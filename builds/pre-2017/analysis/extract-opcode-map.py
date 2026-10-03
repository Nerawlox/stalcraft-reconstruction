"""Emulate native opcode-table initialization in an isolated Unicorn image."""
from pathlib import Path
import hashlib,json,re,struct,sys
A=Path(__file__).resolve().parent
sys.path.insert(0,str(A/'python-tools'))
from unicorn import Uc,UC_ARCH_X86,UC_MODE_64,UC_HOOK_CODE
from unicorn.x86_const import *
image=(A/'dynamic-capture/jvm-static-view.pe').read_bytes();base=0x5a970000
uc=Uc(UC_ARCH_X86,UC_MODE_64);uc.mem_map(base,(len(image)+4095)&~4095);uc.mem_write(base,image)
stack,stop=0x20000000,0x21000000
uc.mem_map(stack,0x200000);uc.mem_map(stop,4096)
rsp=stack+0x100008;uc.mem_write(rsp,struct.pack('<Q',stop));uc.reg_write(UC_X86_REG_RSP,rsp)
uc.mem_write(base+0xa732a0,b'\0')
state=dict(instructions=0,completed=False)
def hook(machine,address,size,_):
    state['instructions']+=1
    if address==stop:state['completed']=True;machine.emu_stop();return
    if not base+0x2fd000<=address<base+0x301000:
        raise RuntimeError(f'Unexpected native code address {address:#x}')
uc.hook_add(UC_HOOK_CODE,hook)
uc.emu_start(base+0x2fd500,stop+1,timeout=5_000_000,count=1_000_000)
if not state['completed']:raise ValueError('Opcode initialization bound reached')
reference=(A/'openjdk9-bytecodes.hpp').read_text(encoding='utf-8')
standard={name:int(num) for name,num in re.findall(r'^\s+_(\w+)\s*=\s*(\d+)\s*,',reference,re.M) if int(num)<=202}
rows=[]
for code in range(239):
    p=struct.unpack('<Q',uc.mem_read(base+0xa732b0+8*code,8))[0]
    if not p:continue
    if not base<=p<base+len(image):raise ValueError('Invalid opcode name pointer')
    offset=p-base;name=image[offset:image.find(b'\0',offset)].decode('ascii')
    length=uc.mem_read(base+0xa73ee0+code,1)[0]
    rows.append(dict(protected=code,name=name,standard=standard.get(name),length=length&15,
        wide_length=length>>4,name_rva=hex(offset)))
mapped=[r for r in rows if r['standard'] is not None]
if len(mapped)!=203 or len({r['standard'] for r in mapped})!=203:
    raise ValueError(f'Incomplete standard opcode map: {len(mapped)}')
out=dict(scope='offline isolated Unicorn initialization; no DLL loading or OS calls',
    entry_rva='0x2fd500',name_table_rva='0xa732b0',length_table_rva='0xa73ee0',
    image_sha256=hashlib.sha256(image).hexdigest(),reference_source='https://github.com/openjdk/jdk9u/blob/master/hotspot/src/share/vm/interpreter/bytecodes.hpp',
    **state,standard_count=len(mapped),rows=rows)
(A/'opcode-map.json').write_text(json.dumps(out,indent=2),encoding='utf-8')
print(json.dumps(dict(instructions=state['instructions'],standard_count=len(mapped),total_native_names=len(rows),examples=[r for r in rows if r['name'] in ['aload_0','invokespecial','return','wide','tableswitch']])))
