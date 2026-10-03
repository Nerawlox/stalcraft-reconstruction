"""Observe only our Java -version child, without attaching a debugger.
Requires the already granted diagnostic execution authorization.
--self-test uses trusted bundled Python, never the STALCRAFT runtime.
"""
from pathlib import Path
import argparse,ctypes as C,ctypes.wintypes as W,json,struct,subprocess,sys,time,re,importlib.util
HERE=Path(__file__).resolve().parent
spec=importlib.util.spec_from_file_location('capture_tool',HERE/'capture-unpacked-jvm.py')
tool=importlib.util.module_from_spec(spec);spec.loader.exec_module(tool)

class MEMORY_INFO(C.Structure):
    _fields_=[('BaseAddress',C.c_void_p),('AllocationBase',C.c_void_p),('AllocationProtect',W.DWORD),
        ('PartitionId',W.WORD),('RegionSize',C.c_size_t),('State',W.DWORD),('Protect',W.DWORD),('Type',W.DWORD)]
class THREAD_ENTRY(C.Structure):
    _fields_=[('dwSize',W.DWORD),('cntUsage',W.DWORD),('th32ThreadID',W.DWORD),('th32OwnerProcessID',W.DWORD),
        ('tpBasePri',C.c_long),('tpDeltaPri',C.c_long),('dwFlags',W.DWORD)]

def contexts(k,process,pid,target):
    k.CreateToolhelp32Snapshot.argtypes=[W.DWORD,W.DWORD];k.CreateToolhelp32Snapshot.restype=W.HANDLE
    for name in ['Thread32First','Thread32Next']:
        f=getattr(k,name);f.argtypes=[W.HANDLE,C.POINTER(THREAD_ENTRY)];f.restype=W.BOOL
    k.OpenThread.argtypes=[W.DWORD,W.BOOL,W.DWORD];k.OpenThread.restype=W.HANDLE
    snapshot=k.CreateToolhelp32Snapshot(4,0);out=[]
    if snapshot in (None,C.c_void_p(-1).value):return out
    try:
        e=THREAD_ENTRY();e.dwSize=C.sizeof(e);more=k.Thread32First(snapshot,C.byref(e))
        while more:
            if e.th32OwnerProcessID==pid:
                h=k.OpenThread(0x4a,False,e.th32ThreadID)
                if h:
                    try:
                        buf=C.create_string_buffer(1232+16);ptr=(C.addressof(buf)+15)&~15
                        C.c_uint32.from_address(ptr+48).value=0x100001
                        if k.GetThreadContext(h,C.c_void_p(ptr)):
                            rip=C.c_uint64.from_address(ptr+248).value;rsp=C.c_uint64.from_address(ptr+152).value
                            raw,ok=tool.read(k,process,rsp,16384)
                            candidates=[]
                            if target:
                                for offset in range(0,len(raw)-7,8):
                                    va=struct.unpack_from('<Q',raw,offset)[0]
                                    if target['base']<=va<target['base']+target['size']:
                                        candidates.append({'stack_offset':offset,'jvm_rva':va-target['base']})
                            out.append({'tid':e.th32ThreadID,'rip':rip,'rsp':rsp,'jvm_stack_addresses':candidates})
                    finally:k.CloseHandle(h)
            more=k.Thread32Next(snapshot,C.byref(e))
    finally:k.CloseHandle(snapshot)
    return out

def ntdll():
    n=C.WinDLL('ntdll',use_last_error=True)
    for name in ['NtResumeProcess','NtSuspendProcess']:
        f=getattr(n,name);f.argtypes=[W.HANDLE];f.restype=C.c_long
    n.NtQueryInformationProcess.argtypes=[W.HANDLE,W.DWORD,C.c_void_p,W.ULONG,C.POINTER(W.ULONG)]
    n.NtQueryInformationProcess.restype=C.c_long
    return n

def modules(k,process,peb):
    b,ok=tool.read(k,process,peb+0x18,8)
    if not ok:return []
    ldr=int.from_bytes(b,'little')
    b,ok=tool.read(k,process,ldr+0x10,8)
    if not ok:return []
    head=ldr+0x10;entry=int.from_bytes(b,'little');seen=set();found=[]
    for _ in range(400):
        if entry==head or entry in seen or not entry:break
        seen.add(entry);b,ok=tool.read(k,process,entry,112)
        if not ok:break
        flink=struct.unpack_from('<Q',b)[0]
        base=struct.unpack_from('<Q',b,48)[0];size=struct.unpack_from('<I',b,64)[0]
        length=struct.unpack_from('<H',b,72)[0];ptr=struct.unpack_from('<Q',b,80)[0]
        raw,ok=tool.read(k,process,ptr,min(length,32768))
        name=raw.decode('utf-16le',errors='replace') if ok else ''
        found.append({'base':base,'size':size,'path':name});entry=flink
    return found

def error_strings(k,process):
    k.VirtualQueryEx.argtypes=[W.HANDLE,C.c_void_p,C.POINTER(MEMORY_INFO),C.c_size_t]
    k.VirtualQueryEx.restype=C.c_size_t
    assert C.sizeof(MEMORY_INFO)==48
    address=0;selected=[];total=0
    needles=['debugger','virtual machine','virtual environment','file has been','corrupted','vmprotect','отладчик','повреждён','поврежден','виртуальн','cannot be run','operating system','unsupported','compatible','compatibility']
    while address<0x7fffffffffff:
        info=MEMORY_INFO()
        if not k.VirtualQueryEx(process,C.c_void_p(address),C.byref(info),C.sizeof(info)):break
        start=info.BaseAddress or address;size=info.RegionSize
        if not size:break
        address=start+size
        if info.State!=0x1000 or info.Type!=0x20000 or info.Protect&0x101 or size>16_000_000:continue
        b,ok=tool.read(k,process,start,size);total+=len(b)
        candidates=[]
        for m in re.finditer(rb'[ -~]{10,500}',b):candidates.append((m.start(),m.group().decode()))
        # Localized dialog strings: UTF-16 runs of printable Latin/Cyrillic chars.
        for parity in [0,1]:
            text=b[parity:len(b)-((len(b)-parity)%2)].decode('utf-16le',errors='replace')
            for m in re.finditer(r'[\x20-\x7e\u0400-\u04ff]{10,500}',text):candidates.append((parity+m.start()*2,m.group()))
        for off,text in candidates:
            if any(n in text.lower() for n in needles):selected.append({'address':start+off,'text':text})
    return {'read_private_bytes':total,'selected_error_strings':selected}

def main():
    p=argparse.ArgumentParser(description=__doc__);p.add_argument('--self-test',action='store_true');p.add_argument('--late',action='store_true');a=p.parse_args()
    k=tool.api();n=ntdll();exe=Path(sys.executable) if a.self_test else tool.validate()
    args=[str(exe),'-c','import time;time.sleep(5)'] if a.self_test else [str(exe),'-version']
    cwd=HERE if a.self_test else exe.parent
    child=subprocess.Popen(args,cwd=str(cwd),stdout=subprocess.PIPE,stderr=subprocess.PIPE,
        creationflags=subprocess.CREATE_NO_WINDOW|0x4) # CREATE_SUSPENDED
    handle=int(child._handle);info=C.create_string_buffer(48);ret=W.ULONG()
    result={'self_test':a.self_test,'command':args,'child_pid':child.pid,'mode':'memory observation without debugger'}
    try:
        status=n.NtQueryInformationProcess(handle,0,info,48,C.byref(ret))
        if status<0:raise RuntimeError(f'Query process info failed: {status:#x}')
        peb=struct.unpack_from('<Q',info.raw,8)[0]
        status=n.NtResumeProcess(handle)
        if status<0:raise RuntimeError(f'Resume process failed: {status:#x}')
        started=time.monotonic();target=None
        while time.monotonic()-started<15:
            found=modules(k,handle,peb)
            if a.self_test:
                if found:
                    data,ok=tool.read(k,handle,found[0]['base'],64)
                    if not ok or data[:2]!=b'MZ':raise RuntimeError('Cannot read trusted child module')
                    result['self_test_passed']=True;break
            else:
                target=next((m for m in found if Path(m['path']).resolve()==(tool.RUNTIME/'bin/server/jvm.dll').resolve()),target)
                if target:
                    first,_=tool.read(k,handle,target['base']+0x1000,512)
                    tail,_=tool.read(k,handle,target['base']+0x1000+7825006-512,512)
                    rdata,_=tool.read(k,handle,target['base']+7831552,512)
                    unwind,_=tool.read(k,handle,target['base']+11337728,512)
                    unwind_tail,_=tool.read(k,handle,target['base']+11337728+413304-512,512)
                    vmcode,_=tool.read(k,handle,target['base']+11755520,512)
                    vmcode_tail,_=tool.read(k,handle,target['base']+11755520+6577297-512,512)
                    ready=all(any(x) for x in [first,tail,rdata,unwind,unwind_tail,vmcode,vmcode_tail])
                    if a.late and len(unwind)>=12:
                        begin,end,unwind_rva=struct.unpack_from('<III',unwind)
                        ready=ready and 0<begin<end<31301632 and 0<unwind_rva<31301632
                    if ready:
                        n.NtSuspendProcess(handle)
                        result['capture']=tool.dump(k,handle,target['base'],'watcher-text-populated')
                        result['snapshot_note']='Section population detected, not proof of complete unpacking or recovered classes'
                        break
            if child.poll() is not None:
                result['early_exit_code']=child.returncode;break
            time.sleep(0.003)
        else:
            result['error']='Timed out before populated text/rdata sections were observed'
            n.NtSuspendProcess(handle)
            if target:result['partial_capture']=tool.dump(k,handle,target['base'],'watcher-timeout')
            result['diagnostic_strings']=error_strings(k,handle)
            result['thread_contexts']=contexts(k,handle,child.pid,target)
        result['loaded_target']=target
    except Exception as exc:result['error']=f'{type(exc).__name__}: {exc}'
    finally:
        if child.poll() is None:child.terminate()
        try:
            out,err=child.communicate(timeout=3)
            result['stdout']=out.decode('utf-8',errors='replace');result['stderr']=err.decode('utf-8',errors='replace')
        except subprocess.TimeoutExpired:
            child.kill();child.wait(timeout=3)
    filename='watcher-self-test.json' if a.self_test else 'watcher-capture-result.json'
    (HERE/filename).write_text(json.dumps(result,ensure_ascii=False,indent=2),encoding='utf-8')
    print(json.dumps(result,ensure_ascii=False,indent=2))
    if a.self_test and not result.get('self_test_passed'):raise RuntimeError('Watcher self-test failed')

if __name__=='__main__':main()
