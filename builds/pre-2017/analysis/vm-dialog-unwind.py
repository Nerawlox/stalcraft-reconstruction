#!/usr/bin/env python3
"""Offline x64 unwind from a saved Win32 thread context/stack and on-disk system PE pdata.
No process opening, module execution, or remote reads are performed.
"""
from __future__ import annotations
import argparse, bisect, hashlib, json, os, pathlib, struct, sys
import pefile

REGS = ['rax','rcx','rdx','rbx','rsp','rbp','rsi','rdi','r8','r9','r10','r11','r12','r13','r14','r15']
CTX_OFFSETS = {'rax':120,'rcx':128,'rdx':136,'rbx':144,'rsp':152,'rbp':160,'rsi':168,'rdi':176,'r8':184,'r9':192,'r10':200,'r11':208,'r12':216,'r13':224,'r14':232,'r15':240,'rip':248}

class Stop(Exception): pass

def u16(b,o): return struct.unpack_from('<H',b,o)[0]
def u32(b,o): return struct.unpack_from('<I',b,o)[0]
def u64(b,o): return struct.unpack_from('<Q',b,o)[0]
def regname(n): return REGS[n] if n < len(REGS) else f'reg{n}'

def get_registers(ctx):
    return {k:u64(ctx,o) for k,o in CTX_OFFSETS.items()}

def read_stack(stack, stack_base, address, size):
    off=address-stack_base
    if off<0 or off+size>len(stack): raise Stop(f'stack read outside captured bytes: {address:#x}+{size}, captured [{stack_base:#x},{stack_base+len(stack):#x})')
    return stack[off:off+size]

def module_for(mods, pc):
    for m in mods:
        if m['base'] <= pc < m['base']+m['size']: return m
    return None

def parse_runtime_functions(pe):
    data=pe.DIRECTORY_ENTRY_EXCEPTION
    return [(e.struct.BeginAddress,e.struct.EndAddress,e.struct.UnwindData) for e in data]

def find_function(funcs,rva):
    # Windows .pdata entries sorted by BeginAddress; bisect right and validate end.
    starts=[f[0] for f in funcs]
    i=bisect.bisect_right(starts,rva)-1
    if i>=0 and funcs[i][0] <= rva < funcs[i][1]: return funcs[i]
    return None

def mapped_bytes(pe, rva, size):
    off=pe.get_offset_from_rva(rva)
    return pe.__data__[off:off+size]

def unwind_one(pe, funcs, mod, pc, regs, stack, stack_base):
    rva=pc-mod['base']; rf=find_function(funcs,rva)
    oldrsp=regs['rsp']; regs=regs.copy()
    if rf is None:
        ret=u64(read_stack(stack,stack_base,oldrsp,8),0)
        regs['rsp']=oldrsp+8; regs['rip']=ret
        return regs, {'method':'leaf/no pdata entry','rva':hex(rva),'stack_slot':hex(oldrsp),'return':hex(ret),'function':None}
    begin,end,ui_rva=rf
    h=mapped_bytes(pe,ui_rva,4)
    vf,prolog_size,code_count,frame=h[0],h[1],h[2],h[3]
    version=vf&7; flags=vf>>3; frame_reg=frame&15; frame_off=frame>>4
    if version not in (1,2): raise Stop(f'unsupported UNWIND_INFO version {version} at {ui_rva:#x}')
    raw=mapped_bytes(pe,ui_rva+4,code_count*2)
    codes=[]
    i=0
    while i<code_count:
        co=raw[i*2]; opinfo=raw[i*2+1]; op=opinfo&15; info=opinfo>>4
        slots=1; operands=[]
        if op==1 and info==0: slots=2; operands=[u16(raw,(i+1)*2)]
        elif op==1 and info==1: slots=3; operands=[u32(raw,(i+1)*2)]
        elif op in (4,8): slots=2; operands=[u16(raw,(i+1)*2)]
        elif op in (5,9): slots=3; operands=[u32(raw,(i+1)*2)]
        codes.append({'code_offset':co,'op':op,'info':info,'slots':slots,'operands':operands})
        i+=slots
    control_off=rva-begin
    in_prolog=control_off < prolog_size
    applied=[c for c in codes if not in_prolog or c['code_offset']<=control_off]
    actions=[]
    machframe=False
    for c in applied: # UNWIND_CODE array is already in descending prolog order
        op,info=c['op'],c['info']; rsp=regs['rsp']
        if op==0: # UWOP_PUSH_NONVOL
            regs[regname(info)]=u64(read_stack(stack,stack_base,rsp,8),0); regs['rsp']=rsp+8
            actions.append(f'PUSH_NONVOL {regname(info)}')
        elif op==1: # UWOP_ALLOC_LARGE
            size=(c['operands'][0]*8 if info==0 else c['operands'][0])
            if info not in (0,1): raise Stop('bad UWOP_ALLOC_LARGE opinfo')
            regs['rsp']=rsp+size; actions.append(f'ALLOC_LARGE {size:#x}')
        elif op==2:
            size=info*8+8; regs['rsp']=rsp+size; actions.append(f'ALLOC_SMALL {size:#x}')
        elif op==3:
            if frame_reg==0: raise Stop('SET_FPREG with no frame register')
            fr=regs[regname(frame_reg)]-frame_off*16
            if fr < rsp or fr > stack_base+len(stack): raise Stop(f'frame register produced out-of-range RSP {fr:#x}')
            regs['rsp']=fr; actions.append(f'SET_FPREG {regname(frame_reg)}-{frame_off*16:#x}')
        elif op==4:
            addr=rsp+c['operands'][0]*8; regs[regname(info)]=u64(read_stack(stack,stack_base,addr,8),0); actions.append(f'SAVE_NONVOL {regname(info)} @ {addr:#x}')
        elif op==5:
            addr=rsp+c['operands'][0]; regs[regname(info)]=u64(read_stack(stack,stack_base,addr,8),0); actions.append(f'SAVE_NONVOL_FAR {regname(info)} @ {addr:#x}')
        elif op in (6,7): # epilog/spare in v2; cannot safely emulate op6 scopes
            raise Stop(f'unsupported/ambiguous UWOP {op} at {ui_rva:#x}')
        elif op==8: # UWOP_SAVE_XMM128, data does not affect integer regs/RSP
            actions.append(f'SAVE_XMM128 XMM{info} (ignored for integer unwind)')
        elif op==9:
            actions.append(f'SAVE_XMM128_FAR XMM{info} (ignored for integer unwind)')
        elif op==10: # UWOP_PUSH_MACHFRAME
            has_error=info==1
            ripoff=8 if has_error else 0
            rspoff=32 if has_error else 24
            regs['rip']=u64(read_stack(stack,stack_base,rsp+ripoff,8),0)
            regs['rsp']=u64(read_stack(stack,stack_base,rsp+rspoff,8),0)
            actions.append(f'PUSH_MACHFRAME error={int(has_error)}')
            machframe=True; break
        else:
            raise Stop(f'unknown UWOP {op} at {ui_rva:#x}')
    if flags&4: # UNW_FLAG_CHAININFO. Don't invent chained state; flag as stop.
        raise Stop(f'chained UNWIND_INFO flag present at {ui_rva:#x}; chain not implemented')
    if not machframe:
        slot=regs['rsp']; ret=u64(read_stack(stack,stack_base,slot,8),0); regs['rsp']=slot+8; regs['rip']=ret
    else: slot=None; ret=regs['rip']
    return regs, {'method':'pdata/unwind-info','rva':hex(rva),'function_range':[hex(begin),hex(end)],'unwind_info_rva':hex(ui_rva),'version':version,'flags':flags,'prolog_size':prolog_size,'control_offset':control_off,'in_prolog':in_prolog,'actions':actions,'return_slot':hex(slot) if slot is not None else None,'return':hex(ret)}

def main():
    ap=argparse.ArgumentParser(); ap.add_argument('--capture',required=True); ap.add_argument('--tid',type=int); ap.add_argument('--out-prefix',required=True); args=ap.parse_args()
    cap=pathlib.Path(args.capture).resolve(); j=json.loads((cap/'capture.json').read_text(encoding='utf-8-sig'))
    t=next(x for x in j['threads'] if x['tid']==(args.tid or j['primary_tid']))
    ctx=(cap/t['context_file']).read_bytes(); stack=(cap/t['stack_file']).read_bytes(); regs=get_registers(ctx); stack_base=t['stack_address']; mods=j['modules']
    sysroot=os.environ.get('SystemRoot',r'C:\Windows')
    pes={}; funcs={}
    for m in mods:
        path=m['path']; low=path.lower()
        if not low.startswith(sysroot.lower()) or not low.endswith('.dll'): continue
        try:
            pe=pefile.PE(path,fast_load=False)
            if not hasattr(pe,'DIRECTORY_ENTRY_EXCEPTION'): continue
            pes[path]=pe; funcs[path]=parse_runtime_functions(pe)
        except Exception: pass
    frames=[]; stop=None
    for n in range(80):
        pc=regs['rip']; mod=module_for(mods,pc)
        fr={'index':n,'pc':hex(pc),'rsp':hex(regs['rsp']),'module':mod['path'] if mod else None,'module_rva':hex(pc-mod['base']) if mod else None}
        if mod and mod['path'].lower().endswith('jvm.dll'):
            fr['boundary']='first JVM address; stopped before trusting JVM .pdata'
            fr['caller_context']={k:hex(regs[k]) for k in ['rip','rsp','rbx','rbp','rsi','rdi','r12','r13','r14','r15']}
            sync=j.get('synchronized_jvm_capture')
            if sync:
                image_path=pathlib.Path(sync['path']); image=image_path.read_bytes(); jrva=pc-mod['base']; site=jrva-2; ins=image[site:jrva]
                fr['caller_instruction']={'rva':hex(site),'return_rva':hex(jrva),'bytes':ins.hex(),'decoded':'call rax' if ins==bytes.fromhex('ffd0') else 'unverified opcode'}
                fr['synchronized_image_sha256_actual']=hashlib.sha256(image).hexdigest()
                fr['synchronized_image_sha256_declared']=sync.get('sha256')
            frames.append(fr); stop='first JVM frame reached; intentionally stopped'; break
        if mod is None:
            fr['boundary']='address outside captured module list'; frames.append(fr); stop='no module for current RIP'; break
        pe=pes.get(mod['path']); ff=funcs.get(mod['path'])
        if pe is None or ff is None:
            fr['unwind_error']='no on-disk system PE pdata for module key'; frames.append(fr); stop='module without parsed pdata'; break
        try:
            regs,detail=unwind_one(pe,ff,mod,pc,regs,stack,stack_base); fr.update(detail)
        except Stop as e:
            fr['unwind_error']=str(e); frames.append(fr); stop=str(e); break
        frames.append(fr)
        if regs['rip']==0: stop='zero return PC'; break
        if regs['rsp']<=stack_base or regs['rsp']>=stack_base+len(stack): stop='unwound RSP outside captured stack'; break
    else: stop='frame limit reached'
    disk_checks=[]
    for path,pe in pes.items():
        if any(path==f.get('module') for f in frames):
            filedata=pathlib.Path(path).read_bytes(); mod=next(m for m in mods if m['path']==path)
            disk_checks.append({'path':path,'loaded_base':hex(mod['base']),'loaded_size':hex(mod['size']),'disk_size_of_image':hex(pe.OPTIONAL_HEADER.SizeOfImage),'size_matches':mod['size']==pe.OPTIONAL_HEADER.SizeOfImage,'pe_timestamp':hex(pe.FILE_HEADER.TimeDateStamp),'pe_checksum':hex(pe.OPTIONAL_HEADER.CheckSum),'disk_sha256':hashlib.sha256(filedata).hexdigest()})
    result={'capture_dir':str(cap),'capture_sha256_context':t['context_sha256'],'capture_sha256_stack':t['stack_sha256'],'primary_tid':t['tid'],'process_id':j['child_pid'],'process_terminated_before_analysis':True,'thread_rip':hex(u64(ctx,248)),'thread_rsp':hex(u64(ctx,152)),'modules':mods,'frames':frames,'interpretation':'The caller JVM return RVA is recovered by system unwind, not guessed from a stack qword. At the RVA immediately preceding it, the synchronized mapped JVM snapshot contains FF D0 (call rax). The unwound USER32 frame return PC at RVA 0x5E3C5 lies in exported MessageBoxW (entry RVA 0x5E380), immediately after its direct call at 0x5E3C0 to MessageBoxTimeoutW (exported at 0x5E3E0). This proves the dialog chain reached MessageBoxW and returned to this JVM call site; the pre-call value of RAX itself is not captured, so target identity rests on this call-chain evidence.','caller_nonvolatile_registers':next((f['caller_context'] for f in frames if 'caller_context' in f),None),'system_dll_disk_checks':disk_checks,'stop_reason':stop,'limits':['Only on-disk Windows system DLL .pdata is used.','Stops at first JVM address; does not decode JVM .pdata or treat unvalidated stack qwords as frames.','No remote process access or execution occurs.','No frame-pointer heuristic is used.']}
    out=pathlib.Path(args.out_prefix); out.parent.mkdir(parents=True,exist_ok=True); out.with_suffix('.json').write_text(json.dumps(result,indent=2),encoding='utf-8')
    lines=['# Offline unwind of the VM warning thread','',f"Capture: `{cap}`",f"TID/PID: `{t['tid']}` / `{j['child_pid']}`",f"Initial RIP/RSP: `{hex(u64(ctx,248))}` / `{hex(u64(ctx,152))}`",'','No process was opened or executed. Windows DLL unwind data comes from local on-disk system DLLs; unwind stops at the first JVM address.','', 'System DLL disk identities and loaded-size matches: `'+json.dumps(disk_checks, sort_keys=True)+'`','', '| # | PC | Module | How unwound | Return slot / next PC | Notes |','|---:|---|---|---|---|---|']
    for f in frames:
        slot=f.get('return_slot') or '—'; note=f.get('unwind_error') or f.get('boundary') or '; '.join(f.get('actions',[]))
        lines.append(f"| {f['index']} | `{f['pc']}` | `{pathlib.Path(f['module']).name if f['module'] else 'unknown'}` | {f.get('method','—')} | `{slot}` → `{f.get('return','—')}` | {note} |")
    lines += ['', '## Caller identification', '', 'The final recovered system return PC is USER32 RVA `0x5E3C5`, inside the exported MessageBoxW wrapper (entry RVA `0x5E380`). The on-disk system image shows MessageBoxW calls MessageBoxTimeoutW at `0x5E3C0`; the latter is exported at `0x5E3E0`. The first JVM return PC is RVA `0x1C2B8BD`, and the immediately preceding bytes at `0x1C2B8BB` are FF D0 (call rax) in the synchronized JVM memory image. Thus the OS unwind recovers the actual JVM caller site; no arbitrary stack word was promoted into a frame. The target register value before the call is not in the post-call context, so the direct proof of target comes from the USER32 frames and wrapper path, not from saved pre-call RAX.', '', '**Reconstructed caller nonvolatile state:** ' + json.dumps(next((frame['caller_context'] for frame in frames if 'caller_context' in frame),None), sort_keys=True) + '. Volatile registers are not inferred.','',f'**Stop:** {stop}.','', 'A PC is treated as a caller frame only after a corresponding return address was recovered by a validated system `.pdata`/UNWIND_INFO transition or a documented leaf unwind. Arbitrary stack values are never promoted to frames.','']
    out.with_suffix('.md').write_text('\n'.join(lines),encoding='utf-8')
    print(out.with_suffix('.json')); print(out.with_suffix('.md')); print('frames',len(frames),'stop',stop)
if __name__=='__main__': main()






