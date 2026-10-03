"""Diagnostic-only CPUID filtering in our copied Java -version child.
Does not alter host CPU configuration, original files, game/authentication code.
--self-test executes our generated filter only; --prepare does static recognition.
"""
from pathlib import Path
import argparse,ctypes as C,ctypes.wintypes as W,json,struct,subprocess,sys,time,importlib.util,re
HERE=Path(__file__).resolve().parent
sys.path.insert(0,str(HERE/'python-tools'))
import capstone
def module(name,file):
    s=importlib.util.spec_from_file_location(name,HERE/file);m=importlib.util.module_from_spec(s);s.loader.exec_module(m);return m
watch=module('watch_tool','watch-jvm-memory.py');tool=watch.tool

# Save input leaf and flags, execute real CPUID, clear hypervisor leaf1 bit only,
# zero only hypervisor vendor leaves 0x40000000..0x400000ff, restore flags/stack.
FILTER=bytes.fromhex('9c50 0fa2 833c2401 7506 81e1ffffff7f 813c2400000040 7211 813c24ff000040 7708 31c031db31c931d2 4883c408 9d')

def prepare():
    state=json.loads((HERE/'watcher-capture-result.json').read_text(encoding='utf-8'))
    capture=state.get('partial_capture') or state['capture'];b=Path(capture['path']).read_bytes()
    md=capstone.Cs(capstone.CS_ARCH_X86,capstone.CS_MODE_64);md.detail=True
    rows=[]
    for lo,hi in [(11755520,11755520+6577297),(18333696,18333696+12879744)]:
        for match in re.finditer(b'\x0f\xa2',b[lo:hi]):
            rva=lo+match.start();after=list(md.disasm(b[rva+2:rva+162],rva+2))
            # Require canonical VM CPUID result stores. This excludes raw-byte coincidences.
            result_stores={}
            for i in after:
                if i.mnemonic=='mov' and len(i.operands)==2:
                    dst,src=i.operands
                    if dst.type==capstone.CS_OP_MEM and src.type==capstone.CS_OP_REG:
                        reg=i.reg_name(src.reg)
                        if reg in ['eax','ebx','ecx','edx']:
                            result_stores[reg]=(dst.mem.base,dst.mem.disp)
                if len(result_stores)==4:break
            if len(result_stores)!=4:continue
            if len({v[0] for v in result_stores.values()})!=1:continue
            if {k:v[1] for k,v in result_stores.items()}!={'eax':12,'ebx':8,'ecx':4,'edx':0}:continue
            overwrite=2;tail=[]
            for i in after:
                if overwrite>=5:break
                if i.group(capstone.CS_GRP_JUMP) or i.group(capstone.CS_GRP_CALL) or i.group(capstone.CS_GRP_RET):break
                if any(o.type==capstone.CS_OP_MEM and o.mem.base==capstone.x86.X86_REG_RIP for o in i.operands):break
                tail.append(i);overwrite+=i.size
            if overwrite<5:continue
            rows.append({'rva':rva,'length':overwrite,'original':b[rva:rva+overwrite].hex(),
                'tail':b[rva+2:rva+overwrite].hex(),'stores':{k:v[1] for k,v in result_stores.items()},
                'copied_instructions':[i.mnemonic+' '+i.op_str for i in tail]})
    result={'source_capture':capture,'recognized_handlers':rows,
        'purpose':'Only suppress hypervisor-identifying CPUID outputs in our diagnostic child; other leaves unchanged'}
    (HERE/'cpuid-filter-plan.json').write_text(json.dumps(result,indent=2),encoding='utf-8')
    print('Recognized CPUID opcode handlers:',len(rows));return rows

def self_test():
    k=tool.api();k.VirtualAlloc.argtypes=[C.c_void_p,C.c_size_t,W.DWORD,W.DWORD];k.VirtualAlloc.restype=C.c_void_p
    k.VirtualFree.argtypes=[C.c_void_p,C.c_size_t,W.DWORD];k.VirtualFree.restype=W.BOOL
    # Windows x64 ABI: ecx=input leaf, rdx=result pointer; rbx is callee-saved.
    code=bytes.fromhex('53 4989d0 89c8 31c9')+FILTER+bytes.fromhex('418900 41895804 41894808 4189500c 5bc3')
    address=k.VirtualAlloc(None,len(code),0x3000,0x40)
    if not address:raise C.WinError(C.get_last_error())
    try:
        C.memmove(address,code,len(code));f=C.WINFUNCTYPE(None,W.DWORD,C.POINTER(W.DWORD))(address)
        results={}
        for leaf in [0,1,7,0x40000000,0x40000001,0x400000ff]:
            out=(W.DWORD*4)();f(leaf,out);results[hex(leaf)]=list(out)
        assert results['0x1'][2]&0x80000000==0
        assert all(results[hex(leaf)]==[0,0,0,0] for leaf in [0x40000000,0x40000001,0x400000ff])
        assert results['0x0'][0]>0 and any(results['0x0'][1:])
        (HERE/'cpuid-filter-self-test.json').write_text(json.dumps({'passed':True,'registers_eax_ebx_ecx_edx':results},indent=2),encoding='utf-8')
        print('Generated CPUID filter self-test passed')
    finally:k.VirtualFree(address,0,0x8000)

def write(k,process,address,data):
    old=W.DWORD();n=C.c_size_t();buffer=C.create_string_buffer(data)
    if not k.VirtualProtectEx(process,C.c_void_p(address),len(data),0x40,C.byref(old)):
        raise C.WinError(C.get_last_error())
    try:
        if not k.WriteProcessMemory(process,C.c_void_p(address),buffer,len(data),C.byref(n)) or n.value!=len(data):raise C.WinError(C.get_last_error())
        k.FlushInstructionCache(process,C.c_void_p(address),len(data))
    finally:
        unused=W.DWORD();k.VirtualProtectEx(process,C.c_void_p(address),len(data),old.value,C.byref(unused))

def execute():
    rows=prepare();k=tool.api();n=watch.ntdll();exe=tool.validate()
    k.VirtualAllocEx.argtypes=[W.HANDLE,C.c_void_p,C.c_size_t,W.DWORD,W.DWORD];k.VirtualAllocEx.restype=C.c_void_p
    child=subprocess.Popen([str(exe),'-version'],cwd=str(exe.parent),stdout=subprocess.PIPE,stderr=subprocess.PIPE,
        creationflags=subprocess.CREATE_NO_WINDOW|0x4)
    h=int(child._handle);state={'child_pid':child.pid,'command':[str(exe),'-version'],'patches':[]}
    target=None;patched=False;arena=None
    try:
        info=C.create_string_buffer(48);ret=W.ULONG()
        if n.NtQueryInformationProcess(h,0,info,48,C.byref(ret))<0:raise RuntimeError('Cannot query diagnostic child')
        peb=struct.unpack_from('<Q',info.raw,8)[0];n.NtResumeProcess(h);started=time.monotonic()
        while time.monotonic()-started<15:
            found=watch.modules(k,h,peb)
            target=next((m for m in found if Path(m['path']).resolve()==(tool.RUNTIME/'bin/server/jvm.dll').resolve()),target)
            if target and not patched:
                n.NtSuspendProcess(h)
                # Allocate a near trampoline arena so relative 5-byte jumps are valid.
                for delta in range(0x04000000,0x70000000,0x10000):
                    candidate=(target['base']+delta)&~0xffff
                    arena=k.VirtualAllocEx(h,C.c_void_p(candidate),65536,0x3000,0x40)
                    if arena:break
                if not arena:raise RuntimeError('Cannot allocate near diagnostic trampoline arena')
                offset=0
                for row in rows:
                    address=target['base']+row['rva'];original=bytes.fromhex(row['original'])
                    observed,ok=tool.read(k,h,address,len(original))
                    if not ok or observed!=original:
                        state['patches'].append({'rva':row['rva'],'status':'byte mismatch; unchanged'});continue
                    tramp=arena+offset;payload=FILTER+bytes.fromhex(row['tail'])
                    back=address+len(original)-(tramp+len(payload)+5)
                    payload+=b'\xe9'+struct.pack('<i',back)
                    write(k,h,tramp,payload)
                    jump=b'\xe9'+struct.pack('<i',tramp-address-5)+b'\x90'*(len(original)-5)
                    write(k,h,address,jump)
                    state['patches'].append({'rva':row['rva'],'status':'patched diagnostic memory only','trampoline':tramp})
                    offset+=(len(payload)+15)&~15
                state['trampoline_base']=arena;patched=True;n.NtResumeProcess(h)
            if target and patched:
                pdata,_=tool.read(k,h,target['base']+11337728,12)
                if len(pdata)==12:
                    begin,end,unwind=struct.unpack('<III',pdata)
                    if 0<begin<end<target['size'] and 0<unwind<target['size']:
                        n.NtSuspendProcess(h);state['capture']=tool.dump(k,h,target['base'],'cpuid-filter-pdata-populated');break
            if child.poll() is not None:state['early_exit_code']=child.returncode;break
            time.sleep(0.001)
        else:
            state['error']='Diagnostic timeout after CPUID filter'
            n.NtSuspendProcess(h)
            if target:state['partial_capture']=tool.dump(k,h,target['base'],'cpuid-filter-timeout')
            state['diagnostic_strings']=watch.error_strings(k,h)
            state['thread_contexts']=watch.contexts(k,h,child.pid,target)
    except Exception as exc:state['error']=f'{type(exc).__name__}: {exc}'
    finally:
        if child.poll() is None:child.terminate()
        try:
            out,err=child.communicate(timeout=3);state['stdout']=out.decode('utf-8',errors='replace');state['stderr']=err.decode('utf-8',errors='replace')
        except subprocess.TimeoutExpired:child.kill();child.wait(timeout=3)
    (HERE/'cpuid-filter-result.json').write_text(json.dumps(state,indent=2),encoding='utf-8')
    print(json.dumps({k:v for k,v in state.items() if k!='thread_contexts'},indent=2))

def main():
    p=argparse.ArgumentParser(description=__doc__);g=p.add_mutually_exclusive_group()
    g.add_argument('--self-test',action='store_true');g.add_argument('--execute',action='store_true');a=p.parse_args()
    if a.self_test:self_test()
    elif a.execute:execute()
    else:prepare()

if __name__=='__main__':main()
