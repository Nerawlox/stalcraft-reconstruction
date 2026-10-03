"""Read-only CONTEXT/stack/dialog-page capture from our own Java -version child.

Default mode launches only the prepared diagnostic copy, with the fixed -version
argument. --self-test starts a trusted Python sleeper instead. No external PID,
DLL path, command line or memory address is accepted from the caller.
"""
from pathlib import Path
import argparse, ctypes as C, ctypes.wintypes as W, hashlib, importlib.util
import json, os, struct, subprocess, sys, time

HERE=Path(__file__).resolve().parent
spec=importlib.util.spec_from_file_location('watch_jvm_memory',HERE/'watch-jvm-memory.py')
watch=importlib.util.module_from_spec(spec); spec.loader.exec_module(watch)
tool=watch.tool
CTX_SIZE=1232
CTX_CONTROL_INTEGER=0x100003  # AMD64 | CONTROL | INTEGER (RIP/RSP + nonvolatile GPRs)
STACK_BYTES=16*1024
PAGE_SIZE=4096
VM_MESSAGE='Sorry, this application cannot run under a Virtual Machine.'

def get_context(k,thread):
    raw=C.create_string_buffer(CTX_SIZE+16)
    address=(C.addressof(raw)+15)&~15
    C.c_uint32.from_address(address+48).value=CTX_CONTROL_INTEGER
    if not k.GetThreadContext(thread,C.c_void_p(address)):
        return None, C.get_last_error()
    data=C.string_at(address,CTX_SIZE)
    # x64 CONTEXT offsets used by the existing capture implementation.
    rip=struct.unpack_from('<Q',data,248)[0]
    rsp=struct.unpack_from('<Q',data,152)[0]
    rbp=struct.unpack_from('<Q',data,160)[0]
    return {'raw':data,'rip':rip,'rsp':rsp,'rbp':rbp},0

def process_id(k,handle):
    k.GetProcessId.argtypes=[W.HANDLE]; k.GetProcessId.restype=W.DWORD
    return int(k.GetProcessId(handle))

def set_thread_apis(k):
    k.GetThreadId.argtypes=[W.HANDLE]; k.GetThreadId.restype=W.DWORD
    k.OpenThread.argtypes=[W.DWORD,W.BOOL,W.DWORD]; k.OpenThread.restype=W.HANDLE

def launch_child(k,exe,argv,cwd):
    si=tool.STARTUPINFO(); si.cb=C.sizeof(si)
    pi=tool.PROCESSINFO()
    command=C.create_unicode_buffer(subprocess.list2cmdline(argv))
    flags=0x4|0x08000000  # CREATE_SUSPENDED | CREATE_NO_WINDOW
    if not k.CreateProcessW(str(exe),command,None,None,False,flags,None,str(cwd),C.byref(si),C.byref(pi)):
        raise C.WinError(C.get_last_error())
    return pi

def page_for_address(k,process,address):
    q=watch.MEMORY_INFO()
    k.VirtualQueryEx.argtypes=[W.HANDLE,C.c_void_p,C.POINTER(watch.MEMORY_INFO),C.c_size_t]
    k.VirtualQueryEx.restype=C.c_size_t
    if not k.VirtualQueryEx(process,C.c_void_p(address),C.byref(q),C.sizeof(q)):
        return {'error':'VirtualQueryEx failed','address':address}
    base=int(q.BaseAddress or 0); region_size=int(q.RegionSize)
    page=address&~(PAGE_SIZE-1)
    result={'match_address':address,'page_base':page,'region_base':base,'region_size':region_size,
            'state':int(q.State),'protect':int(q.Protect),'type':int(q.Type)}
    if q.State!=0x1000 or q.Type!=0x20000 or not (base<=page<base+region_size):
        result['error']='string page is not committed MEM_PRIVATE'; return result
    raw,ok=tool.read(k,process,page,PAGE_SIZE)
    result['read_size']=len(raw); result['read_ok']=ok
    if raw:
        result['page_sha256']=hashlib.sha256(raw).hexdigest()
        out=raw
        result['page_bytes']=out
    return result

def capture_threads(k,process,pid,outdir,primary_tid):
    set_thread_apis(k)
    k.CreateToolhelp32Snapshot.argtypes=[W.DWORD,W.DWORD]; k.CreateToolhelp32Snapshot.restype=W.HANDLE
    for fname in ('Thread32First','Thread32Next'):
        f=getattr(k,fname); f.argtypes=[W.HANDLE,C.POINTER(watch.THREAD_ENTRY)]; f.restype=W.BOOL
    snapshot=k.CreateToolhelp32Snapshot(4,0)
    invalid=C.c_void_p(-1).value
    if snapshot in (None,invalid): return [], []
    entries=[]; errors=[]
    try:
        e=watch.THREAD_ENTRY(); e.dwSize=C.sizeof(e)
        more=k.Thread32First(snapshot,C.byref(e))
        while more:
            if e.th32OwnerProcessID==pid:
                h=k.OpenThread(0x48,False,e.th32ThreadID)  # THREAD_GET_CONTEXT | THREAD_QUERY_INFORMATION
                if h:
                    try:
                        ctx,err=get_context(k,h)
                        if ctx is None:
                            errors.append({'tid':int(e.th32ThreadID),'get_context_error':err})
                        else:
                            stack_start=ctx['rsp']
                            raw,ok=tool.read(k,process,stack_start,STACK_BYTES)
                            prefix='thread-%d'%e.th32ThreadID
                            (outdir/(prefix+'-context.bin')).write_bytes(ctx['raw'])
                            (outdir/(prefix+'-stack.bin')).write_bytes(raw)
                            entries.append({'tid':int(e.th32ThreadID),'primary_thread':int(e.th32ThreadID)==primary_tid,'rip':ctx['rip'],'rsp':ctx['rsp'],'rbp':ctx['rbp'],
                                'context_file':prefix+'-context.bin','context_size':len(ctx['raw']),
                                'context_sha256':hashlib.sha256(ctx['raw']).hexdigest(),
                                'stack_file':prefix+'-stack.bin','stack_address':stack_start,
                                'rsp_offset_in_stack':0,
                                'stack_requested':STACK_BYTES,'stack_read':len(raw),'stack_read_ok':ok,
                                'stack_sha256':hashlib.sha256(raw).hexdigest()})
                    finally: k.CloseHandle(h)
            more=k.Thread32Next(snapshot,C.byref(e))
    finally: k.CloseHandle(snapshot)
    return entries,errors

def read_private_message_page(k,process,outdir):
    scan=watch.error_strings(k,process)
    rows=[]
    for row in scan['selected_error_strings']:
        if VM_MESSAGE.lower() not in row['text'].lower(): continue
        page=page_for_address(k,process,int(row['address']))
        data=page.pop('page_bytes',None)
        if data is not None:
            name='vm-message-page-%016x.bin'%page['page_base']
            (outdir/name).write_bytes(data)
            page['file']=name
        page['text']=row['text']; rows.append(page)
    return {'scan_bytes':scan['read_private_bytes'],'matches':rows}

def main():
    ap=argparse.ArgumentParser(description=__doc__)
    ap.add_argument('--self-test',action='store_true',help='use trusted bundled Python only')
    ap.add_argument('--timeout',type=float,default=15.0)
    ap.add_argument('--settle',type=float,default=8.0,help='wait after JVM module appears before suspending')
    ap.add_argument('--capture-jvm',action='store_true',help='capture the same stopped child JVM image alongside its contexts/stacks')
    args=ap.parse_args()
    if os.name!='nt' or C.sizeof(C.c_void_p)!=8: raise RuntimeError('Requires Windows x64')
    k=tool.api(); n=watch.ntdll();
    exe=Path(sys.executable).resolve() if args.self_test else tool.validate()
    argv=[str(exe),'-c','import time; time.sleep(30)'] if args.self_test else [str(exe),'-version']
    pi=launch_child(k,exe,argv,HERE if args.self_test else exe.parent)
    handle=int(pi.hProcess); primary_handle=int(pi.hThread); pid=int(pi.dwProcessId); primary_tid=int(pi.dwThreadId)
    if process_id(k,handle)!=pid:
        k.TerminateProcess(handle,1); raise RuntimeError('Process handle PID mismatch; refusing memory reads')
    outdir=HERE/('diagnostic-stack-capture-%d-%d'%(pid,int(time.time())))
    outdir.mkdir()
    result={'self_test':args.self_test,'command':argv,'child_pid':pid,'primary_tid':primary_tid,'owned_handle_pid':process_id(k,handle),
            'read_only_memory_capture':True,'output_directory':str(outdir),'loaded_target':None}
    try:
        info=C.create_string_buffer(48); ret=W.ULONG()
        status=n.NtQueryInformationProcess(handle,0,info,48,C.byref(ret))
        if status<0: raise RuntimeError(f'NtQueryInformationProcess failed {status:#x}')
        peb=struct.unpack_from('<Q',info.raw,8)[0]
        status=n.NtResumeProcess(handle)
        if status<0: raise RuntimeError(f'NtResumeProcess failed {status:#x}')
        start=time.monotonic(); target=None; target_seen=None
        while time.monotonic()-start<args.timeout:
            exit_code=W.DWORD()
            k.GetExitCodeProcess.argtypes=[W.HANDLE,C.POINTER(W.DWORD)]; k.GetExitCodeProcess.restype=W.BOOL
            if k.GetExitCodeProcess(handle,C.byref(exit_code)) and exit_code.value!=259:
                result['early_exit_code']=int(exit_code.value); break
            found=watch.modules(k,handle,peb)
            if args.self_test:
                if found:
                    target=found[0]; target_seen=time.monotonic(); break
            else:
                target=next((m for m in found if Path(m['path']).resolve()==(tool.RUNTIME/'bin/server/jvm.dll').resolve()),target)
                if target:
                    target_seen=time.monotonic(); break
            time.sleep(0.05)
        result['loaded_target']=target
        if target_seen is not None and not args.self_test:
            time.sleep(max(0.0,args.settle))
        status=n.NtSuspendProcess(handle)
        result['suspend_status']=status
        if status<0: raise RuntimeError(f'NtSuspendProcess failed {status:#x}')
        result['suspended']=True
        if args.capture_jvm and not args.self_test and target:
            result['synchronized_jvm_capture']=tool.dump(k,handle,target['base'],'stack-synchronized')
        # All reads below are tied to this exact CreateProcess-owned handle and PID.
        assert process_id(k,handle)==pid
        result['modules']=watch.modules(k,handle,peb)
        set_thread_apis(k)
        result['threads'],result['thread_errors']=capture_threads(k,handle,pid,outdir,primary_tid)
        if not args.self_test:
            result['dialog_page_capture']=read_private_message_page(k,handle,outdir)
        if not result['threads']:
            result['capture_error']='No readable thread contexts/stacks'
        if args.self_test:
            result['self_test_passed']=bool(result['threads']) and all(t['context_size']==CTX_SIZE for t in result['threads'])
    finally:
        # Resume before termination; no process remains suspended by the tool.
        try:
            n.NtResumeProcess(handle)
        except Exception: pass
        exit_code=W.DWORD()
        if k.GetExitCodeProcess(handle,C.byref(exit_code)) and exit_code.value==259:
            k.TerminateProcess(handle,1)
            k.WaitForSingleObject(handle,3000)
        k.CloseHandle(primary_handle); k.CloseHandle(handle)
        (outdir/'capture.json').write_text(json.dumps(result,ensure_ascii=False,indent=2),encoding='utf-8')
    print(json.dumps(result,ensure_ascii=False,indent=2))
    if args.self_test and not result.get('self_test_passed'):
        raise RuntimeError('Trusted-Python self-test failed')

if __name__=='__main__': main()
