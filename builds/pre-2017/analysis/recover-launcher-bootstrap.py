"""Recover named native imports/launcher functions through static xrefs only."""
from pathlib import Path
import sys, json
HERE=Path(__file__).resolve().parent
sys.path.insert(0,str(HERE/'python-tools'))
import capstone, pefile
ROOT=Path(r'E:\Stalcraft project\stalcraft_pre\stalcraft')
ALIASES={
 'JLI_InitArgProcessing':'137bc867174a904f42a8efa61d836687',
 'JLI_CmdToArgs':'c37c45bdb56ed218e567719525bfad0e',
 'JLI_GetStdArgc':'0e507ffc4f5371b5271f03ac97484fe0',
 'JLI_MemAlloc':'1ee12e87292680737f1c121af6cabfe0',
 'JLI_GetStdArgs':'f5199c4078a19150bc6c85942e593153',
 'JLI_Launch':'9b490ffc0189e74ef6ca6c1079e09043'}

def main():
    results=[]
    for arch in ['win32','win64']:
        p=ROOT/arch/'java/bin/java.exe';raw=p.read_bytes();pe=pefile.PE(data=raw)
        base=pe.OPTIONAL_HEADER.ImageBase
        mode=capstone.CS_MODE_64 if arch=='win64' else capstone.CS_MODE_32
        md=capstone.Cs(capstone.CS_ARCH_X86,mode);md.detail=True
        strings={base+pe.get_rva_from_offset(raw.index(s.encode()+b'\0')):s for s in list(ALIASES.values())+list(ALIASES)+['server\\jvm.dll','9-internal+0-adhoc.Folken.jdk9']}
        iat={i.address:i.name.decode() if i.name else f'ordinal:{i.ordinal}' for lib in pe.DIRECTORY_ENTRY_IMPORT for i in lib.imports}
        refs=[];allins=[]
        for sec in pe.sections:
            if not sec.Characteristics & 0x20000000:continue
            # A linear sweep of launcher text; code was not executed.
            for i in md.disasm(sec.get_data(),base+sec.VirtualAddress):
                target=None
                for op in i.operands:
                    if op.type==capstone.CS_OP_MEM:
                        if op.mem.base==capstone.x86.X86_REG_RIP:target=i.address+i.size+op.mem.disp
                        elif not op.mem.base:target=op.mem.disp
                    elif op.type==capstone.CS_OP_IMM and op.imm in strings:target=op.imm
                    if target in strings:refs.append({'address':i.address,'string_va':target,'string':strings[target]})
                annotation=strings.get(target,iat.get(target,''))
                allins.append((i.address,f'{i.address:016x}: {i.bytes.hex():24} {i.mnemonic:8} {i.op_str}' + (f' ; {annotation}' if annotation else '')))
        ranges=[]
        for entry in getattr(pe,'DIRECTORY_ENTRY_EXCEPTION',[]):
            start,end=base+entry.struct.BeginAddress,base+entry.struct.EndAddress
            if any(start<=r['address']<end for r in refs):ranges.append((start,end))
        if arch=='win64':
            ranges.append((base+0x1000,base+0x1035))
        if arch=='win32' and refs:
            ranges=[(min(r['address'] for r in refs)-128,max(r['address'] for r in refs)+256)]
        lines=[]
        for start,end in sorted(set(ranges)):
            lines.append(f'\n; Function range {start:016x}..{end:016x}')
            lines.extend(s for a,s in allins if start<=a<end)
        (HERE/f'{arch}-launcher-bootstrap.asm').write_text('\n'.join(lines)+'\n',encoding='utf-8')
        jvm=pefile.PE(str(ROOT/arch/'java/bin/server/jvm.dll'))
        exports={s.name.decode():s.address for s in jvm.DIRECTORY_ENTRY_EXPORT.symbols if s.name}
        mapped=[{'original':k,'alias':v,'export_rva':exports.get(v),'referenced_by_launcher':any(r['string']==v for r in refs)} for k,v in ALIASES.items()]
        result=dict(architecture=arch,aliases=mapped,strings=refs,function_ranges=ranges,
                    limitation='symbol aliases/function ranges statically recovered; JVM code at exported RVAs has no raw backing before unpacking')
        results.append(result)
        print(arch,'aliases verified',sum(m['export_rva'] is not None and m['referenced_by_launcher'] for m in mapped),'ranges',ranges)
    (HERE/'launcher-bootstrap.json').write_text(json.dumps(results,ensure_ascii=False,indent=2),encoding='utf-8')

if __name__=='__main__':main()
