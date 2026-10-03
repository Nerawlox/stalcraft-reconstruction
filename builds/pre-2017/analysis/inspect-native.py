"""PE parsing/disassembly only. Never loads the target images."""
from pathlib import Path
import sys, re, json, hashlib, math
from collections import Counter
HERE=Path(__file__).resolve().parent
sys.path.insert(0,str(HERE/'python-tools'))
import pefile, capstone
ROOT=Path(r'E:\Stalcraft project\stalcraft_pre\stalcraft')

def entropy(b):
    return -sum((v/len(b))*math.log2(v/len(b)) for v in Counter(b).values()) if b else 0

def main():
    rows=[]
    for p in sorted(ROOT.glob('win*/java/bin/**/*.dll'))+sorted(ROOT.glob('win*/java/bin/java.exe')):
        b=p.read_bytes();pe=pefile.PE(data=b,fast_load=False)
        row={'path':str(p.relative_to(ROOT)), 'size':len(b),'sha256':hashlib.sha256(b).hexdigest(),
             'machine':pe.FILE_HEADER.Machine,'timestamp':pe.FILE_HEADER.TimeDateStamp,
             'image_base':pe.OPTIONAL_HEADER.ImageBase,'entry_rva':pe.OPTIONAL_HEADER.AddressOfEntryPoint,
             'sections':[dict(name=s.Name.rstrip(b'\0').decode('ascii',errors='replace'),rva=s.VirtualAddress,
                 virtual_size=s.Misc_VirtualSize,raw_offset=s.PointerToRawData,raw_size=s.SizeOfRawData,
                 entropy=round(entropy(s.get_data()),5)) for s in pe.sections],
             'imports':{},'exports':[]}
        if hasattr(pe,'DIRECTORY_ENTRY_EXPORT'):
            row['declared_exports']={'functions':pe.DIRECTORY_ENTRY_EXPORT.struct.NumberOfFunctions,
                'names':pe.DIRECTORY_ENTRY_EXPORT.struct.NumberOfNames}
        for lib in getattr(pe,'DIRECTORY_ENTRY_IMPORT',[]):
            row['imports'][lib.dll.decode('ascii')]=[i.name.decode('ascii') if i.name else 'ordinal:'+str(i.ordinal) for i in lib.imports]
        for exp in getattr(getattr(pe,'DIRECTORY_ENTRY_EXPORT',None),'symbols',[]):
            row['exports'].append(dict(name=exp.name.decode('ascii') if exp.name else None,rva=exp.address,ordinal=exp.ordinal,
                       forwarder=exp.forwarder.decode('ascii') if exp.forwarder else None))
        strings=[(m.start(),m.group().decode('ascii')) for m in re.finditer(rb'[ -~]{5,}',b)]
        needles=['vmprotect','exbo','stalcraft','classloader','jni_create','jvm','decrypt','encrypt','md5','sha256','read_derived','load_dumped','system_class','EmptyDll','jli_','microsoft','build','version','usage','-xx','-d','class','could','error','main']
        row['selected_strings']=[dict(offset=o,value=s) for o,s in strings if any(n in s.lower() for n in needles) and len(s)<1000]
        if p.name=='java.exe':
            dump=HERE/(p.relative_to(ROOT).parts[0]+'-java-exe-strings.txt')
            dump.write_text('\n'.join(f'{o:08x} {s}' for o,s in strings),encoding='utf-8')
        arch=capstone.CS_MODE_64 if pe.FILE_HEADER.Machine==0x8664 else capstone.CS_MODE_32
        md=capstone.Cs(capstone.CS_ARCH_X86,arch)
        entry=pe.OPTIONAL_HEADER.AddressOfEntryPoint
        row['entry_disassembly']=[f'{i.address:016x} {i.mnemonic} {i.op_str}' for i in md.disasm(pe.get_data(entry,192),pe.OPTIONAL_HEADER.ImageBase+entry)]
        rows.append(row)
        print(row['path'],'exports',len(row['exports']),'sections',[(s['name'],s['raw_size']) for s in row['sections']])
    (HERE/'native-images.json').write_text(json.dumps(rows,ensure_ascii=False,indent=2),encoding='utf-8')

if __name__=='__main__':main()
