"""Unicorn-check class-file stream getters against their pure-Python formula.

The emulator executes only selected captured getter instructions in a synthetic
address space. No target process, DLL loader, OS API, or original file is run or
modified.
"""
from pathlib import Path
import hashlib, importlib.util, json, struct, sys

A=Path(__file__).resolve().parent
sys.path.insert(0,str(A/'python-tools'))
from unicorn import Uc,UC_ARCH_X86,UC_MODE_64,UC_HOOK_CODE
from unicorn.x86_const import *

IMAGE=A/'dynamic-capture'/'jvm-static-view.pe'
TABLE_RVA=0xa2fd40
IMAGE_BASE=0x5a970000
STACK=0x20000000
DATA=0x21000000
STRUCT=0x22000000
STOP=0x23000000
FUNCTIONS={'get_u1':0x3aa4c0,'get_u2':0x3aa620,'get_u4':0x3aa680,'get_bytes':0x3aa420}

def ror8(x,n=3):return ((x>>n)|(x<<(8-n)))&255

def python_transform(buf,start,count,base_offset,table):
    return bytes(buf[start+i]^ror8(buf[start+i-2])^table[(buf[start+i-1]+base_offset+i)&15] for i in range(count))

def emulate_reader(image,table,buffer,cur_offset,which,count=0,base_offset=0):
    """Emulate one captured reader over a synthetic object and return result."""
    uc=Uc(UC_ARCH_X86,UC_MODE_64)
    uc.mem_map(IMAGE_BASE,(len(image)+0xfff)&~0xfff)
    uc.mem_write(IMAGE_BASE,image)
    uc.mem_map(STACK,0x20000);uc.mem_map(DATA,0x20000);uc.mem_map(STRUCT,0x1000);uc.mem_map(STOP,0x1000)
    prefix=bytearray(16)+bytearray(buffer)+bytearray(32)
    pointer=DATA+16
    uc.mem_write(DATA,bytes(prefix))
    # `base_offset` is the stream object's start; current-start is the cursor
    # offset. Keep the buffer start fixed at the first byte.
    start=pointer
    current=pointer+cur_offset
    obj=bytearray(0x40)
    struct.pack_into('<Q',obj,8,start)
    struct.pack_into('<Q',obj,16,pointer+len(buffer))
    struct.pack_into('<Q',obj,24,current)
    uc.mem_write(STRUCT,bytes(obj))
    ret_slot=STACK+0x1000
    uc.mem_write(ret_slot,struct.pack('<Q',STOP))
    uc.reg_write(UC_X86_REG_RSP,ret_slot)
    uc.reg_write(UC_X86_REG_RCX,STRUCT)
    uc.reg_write(UC_X86_REG_RIP,IMAGE_BASE+FUNCTIONS[which])
    if which=='get_bytes':
        outptr=DATA+0x10000
        uc.reg_write(UC_X86_REG_RDX,outptr);uc.reg_write(UC_X86_REG_R8,count)
    state={'instructions':0}
    def hook(machine,address,size,_):
        state['instructions']+=1
        if address==STOP:machine.emu_stop();return
        if not IMAGE_BASE<=address<IMAGE_BASE+len(image):
            raise RuntimeError(f'Getter reached unexpected code address {address:#x}')
    uc.hook_add(UC_HOOK_CODE,hook)
    uc.emu_start(IMAGE_BASE+FUNCTIONS[which],STOP+1,timeout=2_000_000,count=100_000)
    if which=='get_bytes':
        output=bytes(uc.mem_read(outptr,count))
    elif which=='get_u1':
        output=bytes([uc.reg_read(UC_X86_REG_RAX)&0xff])
    else:
        n=2 if which=='get_u2' else 4
        value=uc.reg_read(UC_X86_REG_RAX)&((1<<(n*8))-1)
        output=value.to_bytes(n,'big')
    after=struct.unpack('<Q',uc.mem_read(STRUCT+24,8))[0]-pointer
    return output,after,state['instructions']

def parse_class(data):
    p=0
    def u1():
        nonlocal p;x=data[p];p+=1;return x
    def u2():
        nonlocal p;x=struct.unpack_from('>H',data,p)[0];p+=2;return x
    def u4():
        nonlocal p;x=struct.unpack_from('>I',data,p)[0];p+=4;return x
    if data[:4]!=b'\xca\xfe\xba\xbe':raise ValueError(f'magic {data[:4].hex()}')
    p=4;minor=u2();major=u2();n=u2();cp=[None]*n;i=1
    while i<n:
        t=u1()
        if t==1:
            l=u2();v=data[p:p+l];p+=l;cp[i]=('Utf8',v.decode('utf-8','replace'))
        elif t in (3,4):p+=4;cp[i]=(t,)
        elif t in (5,6):p+=8;cp[i]=(t,);i+=1
        elif t in (7,8,16,19,20):cp[i]=(t,u2())
        elif t in (9,10,11,12,17,18):cp[i]=(t,u2(),u2())
        elif t==15:cp[i]=(t,u1(),u2())
        else:raise ValueError(f'CP tag {t} at #{i}')
        i+=1
        if p>len(data):raise ValueError('CP overrun')
    access=u2();this=u2();super_idx=u2();interfaces=u2();p+=2*interfaces
    def members():
        nonlocal p
        num=u2()
        for _ in range(num):
            p+=6;ac=u2()
            for _ in range(ac):p+=2;l=u4();p+=l
        return num
    fields=members();methods=members();attrs=u2()
    for _ in range(attrs):p+=2;l=u4();p+=l
    if p!=len(data):raise ValueError(f'end {p} of {len(data)}')
    def cname(idx):
        tag,ref=cp[idx]
        if tag!=7:raise ValueError('this_class CP tag')
        return cp[ref][1]
    return {'minor':minor,'major':major,'cp_count':n,'this_class':cname(this),'fields':fields,'methods':methods,'attributes':attrs,'bytes_consumed':p}

def main():
    image=IMAGE.read_bytes();table=image[TABLE_RVA:TABLE_RVA+16]
    index=json.loads((A/'jimage-index.json').read_text(encoding='utf-8'))
    record=next(e for e in index['entries'] if e['name']=='/java.base/c14f5b29590d12e945cb0f3a42112a91')
    with Path(index['source']).open('rb') as f:f.seek(record['offset']);cipher=f.read(record['uncompressed_size'])
    spec=importlib.util.spec_from_file_location('emu',A/'emulate-native-cipher.py');emu=importlib.util.module_from_spec(spec);spec.loader.exec_module(emu)
    decoded={}
    for variant,name in (('alias_md5','c14f5b29590d12e945cb0f3a42112a91'),('internal_path','java/lang/Object')):
        data,state=emu.emulate(cipher,name)
        decoded[variant]={'data':data,'instructions':state['instructions'],'sha256':hashlib.sha256(data).hexdigest()}

    tests=[]
    # Confirm independently that all getters, including the vector reader,
    # match the stated byte operation on synthetic byte patterns.
    pattern=bytes((i*29+101)&255 for i in range(64))
    for name,off,n in (('get_u1',2,1),('get_u2',2,2),('get_u4',2,4),('get_bytes',2,24)):
        want=python_transform(pattern,off,n,off,table)
        got,newpos,ins=emulate_reader(image,table,pattern,off,name,n,off)
        tests.append({'kind':'synthetic_formula_check','reader':name,'match':got==want,
            'expected':want.hex(),'actual':got.hex(),'new_cursor_offset':newpos,'instructions':ins})

    class_results=[];candidates={}
    for variant,item in decoded.items():
        data=item['data'];
        # Class parser skips two prefix bytes before checking the transformed
        # u2 marker. Then it reads minor, major and the remaining transformed body.
        u2,u2pos,u2ins=emulate_reader(image,table,data,2,'get_u2',base_offset=2)
        versions,verpos,verins=emulate_reader(image,table,data,4,'get_bytes',4,4)
        tail,tailpos,tailins=emulate_reader(image,table,data,8,'get_bytes',len(data)-8,8)
        stream=u2+versions+tail
        # A hypothetical standard-class candidate replaces the 2-byte custom
        # marker by the 4-byte Java magic, preserving versions/body alignment.
        candidate=b'\xca\xfe\xba\xbe'+stream[2:]
        candidates[variant]=candidate
        identity=None;error=None;padding=None;trimmed=None
        # Require strict whole-file parsing after removing at most one
        # 16-byte container-padding tail. Padding is zero in the pre-stream
        # cipher output, but the positional stream transform need not preserve
        # zero bytes at the tail.
        for pad in range(1,17):
            if pad>len(candidate):continue
            try:
                parsed=parse_class(candidate[:-pad])
                if parsed['bytes_consumed']==len(candidate)-pad:
                    identity=parsed;padding=pad;trimmed=candidate[:-pad];error=None;break
            except (ValueError,IndexError,struct.error) as ex:error=str(ex)
        if identity is None:
            try:identity=parse_class(candidate);error=None;trimmed=candidate
            except (ValueError,IndexError,struct.error) as ex:error=str(ex)
        utf8=[]
        if len(candidate)>=10:
            cpcount=int.from_bytes(candidate[8:10],'big');pos=10;i=1
            try:
                while i<cpcount and pos<len(candidate):
                    tag=candidate[pos];pos+=1
                    if tag==1:
                        n=int.from_bytes(candidate[pos:pos+2],'big');pos+=2
                        val=candidate[pos:pos+n];pos+=n;utf8.append(val.decode('utf-8','replace'))
                    elif tag in (3,4):pos+=4
                    elif tag in (5,6):pos+=8;i+=1
                    elif tag in (7,8,16,19,20):pos+=2
                    elif tag in (9,10,11,12,17,18):pos+=4
                    elif tag==15:pos+=3
                    else:break
                    i+=1
            except (IndexError,struct.error):pass
        class_results.append({'variant':variant,'native_cipher_sha256':item['sha256'],
            'native_cipher_tail_7_hex':item['data'][-7:].hex(),
            'parser_marker_u2':u2.hex(),'parser_marker_value':hex(int.from_bytes(u2,'big')),
            'minor_major_raw':versions.hex(),'tail_preview':tail[:32].hex(),
            'candidate_sha256':hashlib.sha256(candidate).hexdigest(),'candidate_prefix':candidate[:32].hex(),
            'strict_class_identity':identity,'strict_parse_error':error,'zero_padding_bytes_removed':padding,
            'early_utf8_candidates':utf8[:40],
            'getter_cursor_offsets':[u2pos,verpos,tailpos],'getter_instruction_counts':[u2ins,verins,tailins]})

    if not all(t['match'] for t in tests):raise RuntimeError('Python formula disagrees with Unicorn getter')
    valid=[r for r in class_results if r['strict_class_identity'] and r['strict_class_identity']['this_class']=='java/lang/Object']
    if valid:
        out=A/'recovered-stream'/'java'/'lang'/'Object.class';out.parent.mkdir(parents=True,exist_ok=True)
        chosen=next(r for r in class_results if r['strict_class_identity'] and r['strict_class_identity']['this_class']=='java/lang/Object')
        # Recreate complete bytes; JSON preview is intentionally only 32 bytes.
        chosen_result=next(r for r in class_results if r['variant']==chosen['variant'])
        out.write_bytes(candidates[chosen['variant']][:-chosen_result['zero_padding_bytes_removed']])
    report={'scope':'bounded Unicorn instruction emulation over captured mapped code and synthetic memory; no target process/DLL/OS loading',
        'image_sha256':hashlib.sha256(image).hexdigest(),'table_rva':hex(TABLE_RVA),'table_hex':table.hex(),
        'jimage_record':{k:record[k] for k in ('name','offset','compressed_size','uncompressed_size','sha256')},
        'native_cipher_and_stream_variants':class_results,'synthetic_formula_checks':tests,
        'valid_java_lang_Object_recovered':bool(valid),'recovered_path':str(out) if valid else None}
    (A/'verify-classfile-stream-transform.json').write_text(json.dumps(report,indent=2),encoding='utf-8')
    print(json.dumps(report,indent=2))

if __name__=='__main__':main()
