"""Bounded offline Unicorn trace of one captured JVM helper.

This emulates only mapped bytes from the synchronized memory snapshot. It maps
synthetic stack/TEB/PEB/heap pages, invokes RVA 0x3ab210 with a sentinel return,
and stops before any non-image instruction, CPUID, syscall, interrupt or fault.
It never loads a DLL/EXE, calls a host API, starts a process, or performs host
memory access. The goal is a feasibility trace, not a VMProtect bypass.
"""
from __future__ import annotations
import hashlib, json, struct, sys
from pathlib import Path

HERE=Path(__file__).resolve().parent
sys.path.insert(0,str(HERE/'python-tools'))
from unicorn import Uc, UC_ARCH_X86, UC_MODE_64, UC_HOOK_CODE, UC_HOOK_MEM_INVALID
from unicorn.x86_const import *
from capstone import Cs, CS_ARCH_X86, CS_MODE_64
import pefile

CAP=HERE/'diagnostic-stack-capture-31860-1791046301'/'capture.json'
IMAGE_META=json.loads(CAP.read_text(encoding='utf-8'))['synchronized_jvm_capture']
IMAGE=Path(IMAGE_META['path'])
BASE=int(IMAGE_META['image_base'])
ENTRY_RVA=0x3ab210
SENTINEL=0x23000000
STACK=0x20000000
HEAP=0x21000000
TEB=0x22000000
LIMIT=20000

def main():
    raw=IMAGE.read_bytes()
    sha=hashlib.sha256(raw).hexdigest()
    if sha!=IMAGE_META['sha256']: raise RuntimeError('synchronized image hash mismatch')
    uc=Uc(UC_ARCH_X86,UC_MODE_64)
    uc.mem_map(BASE,(len(raw)+0xfff)&~0xfff); uc.mem_write(BASE,raw)
    uc.mem_map(STACK,0x200000); uc.mem_map(HEAP,0x400000); uc.mem_map(TEB,0x10000); uc.mem_map(SENTINEL,0x1000)
    capture=json.loads(CAP.read_text(encoding='utf-8'))
    ntdll_row=next(m for m in capture['modules'] if Path(m['path']).name.lower()=='ntdll.dll')
    ntdll_path=Path(ntdll_row['path'])
    # Resolve NtClose from the trusted on-disk Windows PE export directory only.
    # The DLL bytes are never mapped; a separate synthetic hook replaces this API.
    ntdll_pe=pefile.PE(str(ntdll_path),fast_load=False)
    ntclose_export=next(s for s in ntdll_pe.DIRECTORY_ENTRY_EXPORT.symbols if s.name==b'NtClose')
    ntclose_va=int(ntdll_row['base'])+int(ntclose_export.address)
    ntclose_page=ntclose_va&~0xfff
    uc.mem_map(ntclose_page,0x1000)
    uc.mem_write(ntclose_page,b'\xcc'*0x1000)
    # Minimal synthetic thread/process environment only; no real OS state.
    PEB=TEB+0x1000; LDR=TEB+0x2000
    uc.mem_write(TEB+0x60,struct.pack('<Q',PEB))
    uc.mem_write(PEB+0x18,struct.pack('<Q',HEAP))
    uc.mem_write(PEB+0x10,struct.pack('<Q',LDR))
    rsp=STACK+0x100008
    uc.mem_write(rsp,struct.pack('<Q',SENTINEL))
    uc.reg_write(UC_X86_REG_GS_BASE,TEB)
    uc.reg_write(UC_X86_REG_RSP,rsp)
    cs=Cs(CS_ARCH_X86,CS_MODE_64); cs.detail=True
    trace=[]; state={'instructions':0,'calls':[],'returns':0,'synthetic_api_calls':[],'reason':None,'fault':None,'fault_pc':None}
    forbidden={'cpuid','syscall','sysenter','rdmsr','wrmsr','rdtsc','rdtscp','hlt','int','int1','int3','ins','outs'}
    def stop(reason,pc):
        if state['reason'] is None: state['reason']=reason; state['fault_pc']=hex(pc)
        uc.emu_stop()
    def on_code(m,pc,size,_):
        if pc==SENTINEL: state['reason']='sentinel_return'; m.emu_stop(); return
        if pc==ntclose_va:
            sp=m.reg_read(UC_X86_REG_RSP)
            ret=struct.unpack('<Q',m.mem_read(sp,8))[0]
            arg=m.reg_read(UC_X86_REG_RCX)
            # Model only the documented NTSTATUS return for a synthetic invalid handle.
            # This is not ntdll code and does not query or close any host handle.
            state['synthetic_api_calls'].append({'api':'ntdll!NtClose','va':hex(pc),'rva':hex(int(ntclose_export.address)),'argument_handle':hex(arg),'synthetic_return_ntstatus':'0xc0000008','return_address':hex(ret),'behavior':'hook sets EAX=STATUS_INVALID_HANDLE and returns; no DLL/API body executed'})
            m.reg_write(UC_X86_REG_RAX,0xc0000008)
            m.reg_write(UC_X86_REG_RSP,sp+8)
            m.reg_write(UC_X86_REG_RIP,ret)
            return
        if not BASE<=pc<BASE+len(raw): stop('control_left_captured_module_before_external_execution',pc); return
        state['instructions']+=1
        if state['instructions']>LIMIT: stop('instruction_limit',pc); return
        ins=next(cs.disasm(bytes(m.mem_read(pc,size)),pc,count=1),None)
        if ins is None: stop('undecodable_instruction',pc); return
        if ins.mnemonic.lower() in forbidden: stop('forbidden_or_host_dependent_instruction_'+ins.mnemonic.lower(),pc); return
        if len(trace)<400: trace.append({'rva':hex(pc-BASE),'mnemonic':ins.mnemonic,'operands':ins.op_str})
        if ins.mnemonic.lower()=='call':
            if len(state['calls'])<200: state['calls'].append({'rva':hex(pc-BASE),'operands':ins.op_str})
        elif ins.mnemonic.lower()=='ret': state['returns']+=1
        # Avoid silently executing an unbounded path into high-entropy VMProtect.
        rva=pc-BASE
        if 0x117c000<=rva<0x1ddc800 and state['instructions']>64:
            stop('entered_opaque_vmp1_after_initial_trace',pc)
    def on_invalid(m,access,address,size,value,_):
        state['fault']={'access':int(access),'address':hex(address),'size':int(size),'value':int(value)}
        stop('unmapped_memory_access',m.reg_read(UC_X86_REG_RIP)); return False
    uc.hook_add(UC_HOOK_CODE,on_code)
    uc.hook_add(UC_HOOK_MEM_INVALID,on_invalid)
    try:
        uc.emu_start(BASE+ENTRY_RVA,SENTINEL,timeout=1_000_000,count=LIMIT)
    except Exception as e:
        state['reason']=state['reason'] or 'unicorn_exception'
        state['exception']=repr(e)
        state['fault_pc']=hex(uc.reg_read(UC_X86_REG_RIP))
    state['final_registers']={name:hex(uc.reg_read(reg)) for name,reg in [('RIP',UC_X86_REG_RIP),('RSP',UC_X86_REG_RSP),('RAX',UC_X86_REG_RAX),('RCX',UC_X86_REG_RCX),('RDX',UC_X86_REG_RDX),('R8',UC_X86_REG_R8),('R9',UC_X86_REG_R9)]}
    if state['reason'] is None and int(state['final_registers']['RIP'],16)==SENTINEL:
        state['reason']='helper_returned_to_synthetic_sentinel'
    report={'scope':'offline bounded Unicorn emulation of captured mapped bytes only','snapshot':str(IMAGE),'snapshot_sha256':sha,'image_base':hex(BASE),'entry_rva':hex(ENTRY_RVA),'entry_static_bytes':raw[ENTRY_RVA:ENTRY_RVA+0x20].hex(),'capture_stage':IMAGE_META.get('stage'),'static_os_export_resolution':{'module_path':str(ntdll_path),'captured_module_base':hex(int(ntdll_row['base'])),'export':'NtClose','export_rva':hex(int(ntclose_export.address)),'export_va':hex(ntclose_va),'method':'pefile read-only parse of on-disk export directory; no module execution'},'synthetic_memory':{'stack':hex(STACK),'heap':hex(HEAP),'teb':hex(TEB),'peb':hex(PEB),'sentinel':hex(SENTINEL),'ntdll_api_page':'synthetic INT3 page with NtClose intercepted at the exact export address'},'limits':{'instructions':LIMIT,'timeout_us':1_000_000,'stop_before_host_api_execution':True,'stop_on_cpuid_syscall_interrupt_and_unmapped_access':True},**state,'trace':trace,'interpretation':'The path reaches ntdll!NtClose with synthetic handle 0x1ee7c0de. The hook returns a chosen STATUS_INVALID_HANDLE and continues; no real API body executes. This supports an invalid-handle/anti-analysis check hypothesis, but does not establish intended semantics or test the real OS response.'}
    out=HERE/'emulate-protected-helper.json'
    out.write_text(json.dumps(report,ensure_ascii=False,indent=2),encoding='utf-8')
    md=['# Offline emulation of protected helper 0x3AB210','',f"Captured image SHA-256: `{sha}`; capture stage `{IMAGE_META.get('stage')}`.",f"Bounded trace: {state['instructions']} instructions; result `{state['reason']}`; helper tail returned EAX `{state['final_registers']['RAX']}`.",'', '## Observed path','', 'Entry loads `ECX=0x1EE7C0DE`, calls RVA `0x76F3B6`, and reaches a protected stub. Static export resolution identifies its external call boundary as `ntdll!NtClose` at RVA `0x160550`; RCX at that boundary is the same `0x1EE7C0DE` value. The offline harness intercepts that exact address and synthesizes `STATUS_INVALID_HANDLE` followed by `ret`, without executing ntdll. Control returns to the mapped helper, which visibly zeroes EAX and returns.','', '## Limits','', 'The PEB/TEB/heap and stack are synthetic. Only the captured JVM image bytes execute. The `NtClose` result is a selected synthetic response, not a measured Windows response; this demonstrates a path and its return behavior under that model, not the original purpose of the check. No API body, DLL, EXE, process, or host memory API is called. The emulator stops on unhandled external code, CPUID/syscall/interrupt, unmapped memory, or the instruction/time bound.', '', 'Reproduce with bundled Python: `python -X utf8 emulate-protected-helper.py`. Full trace and register state: `emulate-protected-helper.json`.','']
    (HERE/'emulate-protected-helper.md').write_text('\n'.join(md),encoding='utf-8')
    print(json.dumps({k:report[k] for k in ('scope','snapshot_sha256','entry_rva','instructions','calls','returns','reason','fault_pc','fault','final_registers')},ensure_ascii=False,indent=2))

if __name__=='__main__': main()
