"""Windows debugger for a single diagnostic child. No game/authentication startup.
Default: validate prepared files without execution. --self-test: trusted Python only.
--execute: requires explicit user authorization; launches copied Java -version.
"""
from pathlib import Path
import argparse, ctypes as C, ctypes.wintypes as W, hashlib, json, os, struct
import subprocess, sys, time

HERE=Path(__file__).resolve().parent
RUNTIME=HERE.parent/'runtime-diagnostic'/'java'
EXPECTED_JAVA='9aa9222df7c91946b2e8267c67e852fd2841f6fe1c57b2bf9d843f3ca34ec6b3'
EXPECTED_JVM=None # Checked against the diagnostic-copy manifest below.
PTR=C.c_void_p; U64=C.c_ulonglong; SIZE=C.c_size_t

class STARTUPINFO(C.Structure):
    _fields_=[('cb',W.DWORD),('lpReserved',W.LPWSTR),('lpDesktop',W.LPWSTR),('lpTitle',W.LPWSTR),
        ('dwX',W.DWORD),('dwY',W.DWORD),('dwXSize',W.DWORD),('dwYSize',W.DWORD),
        ('dwXCountChars',W.DWORD),('dwYCountChars',W.DWORD),('dwFillAttribute',W.DWORD),
        ('dwFlags',W.DWORD),('wShowWindow',W.WORD),('cbReserved2',W.WORD),('lpReserved2',PTR),
        ('hStdInput',W.HANDLE),('hStdOutput',W.HANDLE),('hStdError',W.HANDLE)]
class PROCESSINFO(C.Structure):
    _fields_=[('hProcess',W.HANDLE),('hThread',W.HANDLE),('dwProcessId',W.DWORD),('dwThreadId',W.DWORD)]
class EXCEPTION_RECORD(C.Structure):
    _fields_=[('ExceptionCode',W.DWORD),('ExceptionFlags',W.DWORD),('ExceptionRecord',PTR),
        ('ExceptionAddress',PTR),('NumberParameters',W.DWORD),('ExceptionInformation',SIZE*15)]
class EXCEPTION_INFO(C.Structure):
    _fields_=[('ExceptionRecord',EXCEPTION_RECORD),('dwFirstChance',W.DWORD)]
class CREATE_INFO(C.Structure):
    _fields_=[('hFile',W.HANDLE),('hProcess',W.HANDLE),('hThread',W.HANDLE),('lpBaseOfImage',PTR),
        ('dwDebugInfoFileOffset',W.DWORD),('nDebugInfoSize',W.DWORD),('lpThreadLocalBase',PTR),
        ('lpStartAddress',PTR),('lpImageName',PTR),('fUnicode',W.WORD)]
class LOAD_INFO(C.Structure):
    _fields_=[('hFile',W.HANDLE),('lpBaseOfDll',PTR),('dwDebugInfoFileOffset',W.DWORD),
        ('nDebugInfoSize',W.DWORD),('lpImageName',PTR),('fUnicode',W.WORD)]
class EVENT_UNION(C.Union):
    _fields_=[('exception',EXCEPTION_INFO),('create',CREATE_INFO),('load',LOAD_INFO),('raw',C.c_ubyte*160)]
class DEBUG_EVENT(C.Structure):
    _fields_=[('dwDebugEventCode',W.DWORD),('dwProcessId',W.DWORD),('dwThreadId',W.DWORD),('u',EVENT_UNION)]

def api():
    if os.name!='nt' or C.sizeof(PTR)!=8:raise RuntimeError('Requires Windows x64 Python')
    assert C.sizeof(DEBUG_EVENT)==176 and DEBUG_EVENT.u.offset==16
    assert C.sizeof(STARTUPINFO)==104 and C.sizeof(PROCESSINFO)==24
    k=C.WinDLL('kernel32',use_last_error=True)
    declarations={
        'CreateProcessW':([W.LPCWSTR,W.LPWSTR,PTR,PTR,W.BOOL,W.DWORD,PTR,W.LPCWSTR,C.POINTER(STARTUPINFO),C.POINTER(PROCESSINFO)],W.BOOL),
        'WaitForDebugEvent':([C.POINTER(DEBUG_EVENT),W.DWORD],W.BOOL),
        'ContinueDebugEvent':([W.DWORD,W.DWORD,W.DWORD],W.BOOL),
        'ReadProcessMemory':([W.HANDLE,PTR,PTR,SIZE,C.POINTER(SIZE)],W.BOOL),
        'WriteProcessMemory':([W.HANDLE,PTR,PTR,SIZE,C.POINTER(SIZE)],W.BOOL),
        'VirtualProtectEx':([W.HANDLE,PTR,SIZE,W.DWORD,C.POINTER(W.DWORD)],W.BOOL),
        'FlushInstructionCache':([W.HANDLE,PTR,SIZE],W.BOOL),
        'TerminateProcess':([W.HANDLE,W.UINT],W.BOOL),
        'WaitForSingleObject':([W.HANDLE,W.DWORD],W.DWORD),
        'CloseHandle':([W.HANDLE],W.BOOL),
        'GetFinalPathNameByHandleW':([W.HANDLE,W.LPWSTR,W.DWORD,W.DWORD],W.DWORD),
        'DebugSetProcessKillOnExit':([W.BOOL],W.BOOL)}
    declarations.update({'SuspendThread':([W.HANDLE],W.DWORD),
        'GetThreadContext':([W.HANDLE,PTR],W.BOOL)})
    for name,(args,result) in declarations.items():
        f=getattr(k,name);f.argtypes=args;f.restype=result
    return k

def validate():
    manifest=json.loads((HERE/'diagnostic-copy.json').read_text(encoding='utf-8'))
    for row in manifest['files']:
        path=RUNTIME/row['path']
        if hashlib.sha256(path.read_bytes()).hexdigest()!=row['sha256']:
            raise RuntimeError(f'Diagnostic file hash mismatch: {path}')
    exe=RUNTIME/'bin/java.exe'
    if hashlib.sha256(exe.read_bytes()).hexdigest()!=EXPECTED_JAVA:
        raise RuntimeError('Unexpected launcher: breakpoint offset is not applicable')
    return exe

def read(k,process,address,size):
    out=C.create_string_buffer(size);n=SIZE()
    success=k.ReadProcessMemory(process,PTR(address),out,size,C.byref(n))
    return out.raw[:n.value],bool(success)

def file_path(k,handle):
    if not handle:return ''
    s=C.create_unicode_buffer(32768)
    n=k.GetFinalPathNameByHandleW(handle,s,len(s),0)
    return s.value.removeprefix('\\\\?\\') if n and n<len(s) else ''

def dump(k,process,base,stage='launcher-stop'):
    header,ok=read(k,process,base,4096)
    if not ok or header[:2]!=b'MZ':raise RuntimeError('JVM memory header is unavailable')
    peoff=struct.unpack_from('<I',header,0x3c)[0]
    if header[peoff:peoff+4]!=b'PE\0\0':raise RuntimeError('Invalid mapped JVM PE header')
    size=struct.unpack_from('<I',header,peoff+24+56)[0]
    if not 1_000_000<size<100_000_000:raise RuntimeError(f'Unexpected image size: {size}')
    image=bytearray(size);holes=[]
    for off in range(0,size,65536):
        want=min(65536,size-off);data,ok=read(k,process,base+off,want)
        if ok and len(data)==want:image[off:off+want]=data;continue
        for p in range(off,off+want,4096):
            n=min(4096,size-p);data,ok=read(k,process,base+p,n)
            image[p:p+len(data)]=data
            if not ok or len(data)!=n:holes.append({'rva':p,'wanted':n,'read':len(data)})
    destination=HERE/'dynamic-capture';destination.mkdir(exist_ok=True)
    target=destination/({'launcher-stop':'jvm-mapped-image.bin','timeout-not-validated':'jvm-timeout-image.bin',
        'watcher-text-populated':'jvm-watch-image.bin','watcher-timeout':'jvm-watcher-timeout-image.bin'}.get(stage,'jvm-'+stage+'.bin'))
    if target.exists():target=target.with_name(target.stem+'-'+str(time.time_ns())+target.suffix)
    target.write_bytes(image)
    return {'image_base':base,'size':size,'memory_holes':holes,'path':str(target),
            'sha256':hashlib.sha256(image).hexdigest(),
            'stage':stage,'layout':'Mapped virtual addresses, not a directly runnable raw PE file'}

def debug(self_test):
    k=api()
    exe=Path(sys.executable) if self_test else validate()
    args=[str(exe),'-c','print("trusted-debugger-self-test")'] if self_test else [str(exe),'-version']
    cwd=HERE if self_test else exe.parent
    si=STARTUPINFO();si.cb=C.sizeof(si);pi=PROCESSINFO()
    # DEBUG_ONLY_THIS_PROCESS | CREATE_NO_WINDOW. No shell or inherited handles.
    cmd=C.create_unicode_buffer(subprocess.list2cmdline(args))
    if not k.CreateProcessW(str(exe),cmd,None,None,False,0x2|0x08000000,None,str(cwd),C.byref(si),C.byref(pi)):
        raise C.WinError(C.get_last_error())
    k.DebugSetProcessKillOnExit(True)
    result={'self_test':self_test,'command':args,'cwd':str(cwd),'child_pid':pi.dwProcessId,'events':[]}
    breakpoint=None;jvm_base=None;created_base=None;ended=False
    thread_handles={pi.dwThreadId:pi.hThread}
    started=time.monotonic()
    try:
        while time.monotonic()-started<15:
            event=DEBUG_EVENT()
            if not k.WaitForDebugEvent(C.byref(event),1000):
                if C.get_last_error()==121:continue
                raise C.WinError(C.get_last_error())
            if event.dwProcessId!=pi.dwProcessId:raise RuntimeError('Unexpected process in single-child debugger')
            code=event.dwDebugEventCode;status=0x00010002 # DBG_CONTINUE
            record={'event':code,'thread':event.dwThreadId}
            if code==3: # CREATE_PROCESS_DEBUG_EVENT
                created_base=event.u.create.lpBaseOfImage
                if event.u.create.hFile:k.CloseHandle(event.u.create.hFile)
                if not self_test:
                    breakpoint=created_base+0x1062
                    original,ok=read(k,pi.hProcess,breakpoint,1)
                    if not ok or original!=b'\x48':raise RuntimeError('Launcher breakpoint byte did not match expected mov instruction')
                    previous=W.DWORD();written=SIZE();patch=C.create_string_buffer(b'\xcc')
                    if not k.VirtualProtectEx(pi.hProcess,PTR(breakpoint),1,0x40,C.byref(previous)):
                        raise C.WinError(C.get_last_error())
                    if not k.WriteProcessMemory(pi.hProcess,PTR(breakpoint),patch,1,C.byref(written)) or written.value!=1:
                        raise C.WinError(C.get_last_error())
                    unused=W.DWORD();k.VirtualProtectEx(pi.hProcess,PTR(breakpoint),1,previous.value,C.byref(unused))
                    k.FlushInstructionCache(pi.hProcess,PTR(breakpoint),1)
                    record['breakpoint']=breakpoint
            elif code==2: # CREATE_THREAD_DEBUG_EVENT
                handle=struct.unpack_from('<Q',bytes(event.u.raw))[0]
                thread_handles[event.dwThreadId]=handle
            elif code==6: # LOAD_DLL_DEBUG_EVENT
                path=file_path(k,event.u.load.hFile);record.update(path=path,base=event.u.load.lpBaseOfDll)
                if event.u.load.hFile:k.CloseHandle(event.u.load.hFile)
                if not self_test and Path(path).resolve()==(RUNTIME/'bin/server/jvm.dll').resolve():
                    jvm_base=event.u.load.lpBaseOfDll
            elif code==1: # EXCEPTION_DEBUG_EVENT
                ex=event.u.exception.ExceptionRecord
                record.update(exception=ex.ExceptionCode,address=ex.ExceptionAddress,first_chance=event.u.exception.dwFirstChance)
                if ex.ExceptionCode==0x80000003:
                    if self_test:
                        data,ok=read(k,pi.hProcess,created_base,64)
                        if not ok or data[:2]!=b'MZ':raise RuntimeError('Trusted child image could not be read')
                        result['self_test_passed']=True;result['image_base']=created_base;result['events'].append(record);break
                    if ex.ExceptionAddress==breakpoint:
                        if jvm_base is None:raise RuntimeError('Breakpoint hit without matching copied JVM load event')
                        result['capture']=dump(k,pi.hProcess,jvm_base);result['events'].append(record);break
                elif ex.ExceptionCode==0x4000001f:pass # WOW64 initial breakpoint (normally unused)
                else:status=0x80010001 # DBG_EXCEPTION_NOT_HANDLED, preserve application behavior
            elif code==5: # EXIT_PROCESS_DEBUG_EVENT
                record['exit_code']=struct.unpack_from('<I',bytes(event.u.raw))[0];ended=True
                result['events'].append(record);k.ContinueDebugEvent(event.dwProcessId,event.dwThreadId,status);break
            result['events'].append(record)
            if not k.ContinueDebugEvent(event.dwProcessId,event.dwThreadId,status):raise C.WinError(C.get_last_error())
        else:
            result['error']='Timed out before diagnostic stop point'
            if not self_test and jvm_base:
                contexts=[]
                for tid,handle in thread_handles.items():
                    previous=k.SuspendThread(handle)
                    if previous==0xffffffff:continue
                    buf=C.create_string_buffer(1232+16)
                    address=(C.addressof(buf)+15)&~15
                    C.c_uint32.from_address(address+48).value=0x100001
                    if k.GetThreadContext(handle,PTR(address)):
                        contexts.append({'tid':tid,'rip':C.c_uint64.from_address(address+248).value})
                result['thread_contexts']=contexts
                result['partial_capture']=dump(k,pi.hProcess,jvm_base,'timeout-not-validated')
    except Exception as exc:
        result['error']=f'{type(exc).__name__}: {exc}'
    finally:
        # Only the process handle returned for our own newly created child is used.
        if not ended:
            k.TerminateProcess(pi.hProcess,0)
            # Drain debug termination events to release a stopped child reliably.
            deadline=time.monotonic()+5
            while time.monotonic()<deadline:
                event=DEBUG_EVENT()
                if not k.WaitForDebugEvent(C.byref(event),100):break
                k.ContinueDebugEvent(event.dwProcessId,event.dwThreadId,0x00010002)
                if event.dwDebugEventCode==5:break
            k.WaitForSingleObject(pi.hProcess,1000)
        k.CloseHandle(pi.hThread);k.CloseHandle(pi.hProcess)
        for handle in set(thread_handles.values())-{pi.hThread}:
            k.CloseHandle(handle)
    filename='debugger-self-test.json' if self_test else 'dynamic-capture-result.json'
    (HERE/filename).write_text(json.dumps(result,ensure_ascii=False,indent=2),encoding='utf-8')
    print(json.dumps({k:v for k,v in result.items() if k!='events'},ensure_ascii=False,indent=2))
    if self_test and not result.get('self_test_passed'):raise RuntimeError('Debugger self-test failed')

def main():
    p=argparse.ArgumentParser(description=__doc__)
    group=p.add_mutually_exclusive_group();group.add_argument('--self-test',action='store_true');group.add_argument('--execute',action='store_true')
    a=p.parse_args()
    if a.self_test:debug(True)
    elif a.execute:debug(False)
    else:print('Validated, no execution:',validate())

if __name__=='__main__':main()
