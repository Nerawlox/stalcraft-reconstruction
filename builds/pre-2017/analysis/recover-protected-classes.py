"""Offline class recovery using verified native cipher and ClassFileStream.

Reads original archives only; creates new class-only jars and provenance logs.
No recovered class, protected runtime, or native DLL is executed.
"""
from pathlib import Path, PurePosixPath
import argparse, hashlib, importlib.util, json, re, struct, sys, time, zipfile
import numpy as np

A = Path(__file__).resolve().parent
ORIGINAL = Path(r'E:\Stalcraft project\stalcraft_pre\stalcraft')
OUT = A.parent / 'recovered-bytecode'
spec = importlib.util.spec_from_file_location('custom_cipher', A / 'custom_rijndael.py')
cr = importlib.util.module_from_spec(spec); spec.loader.exec_module(cr)
IMAGE = (A / 'dynamic-capture/jvm-static-view.pe').read_bytes()
SBOX = IMAGE[0x89a6f0:0x89a7f0]
INV = np.frombuffer(IMAGE[0x89a7f0:0x89a8f0], dtype=np.uint8)
STREAM_TABLE = np.frombuffer(IMAGE[0xa2fd40:0xa2fd50], dtype=np.uint8)
KEY = bytes.fromhex('e7488b845f71f6cccfb8945cc05d1f0d')
ROUND_KEYS = np.array(cr.key_expansion(KEY, SBOX), dtype=np.uint8)
COEFFS = (82, 183, 13, 233)
MUL = {c: np.array([cr.gf_mul(x,c) for x in range(256)],dtype=np.uint8) for c in COEFFS}
ISHIFT = [r+4*((c-r)%4) for c in range(4) for r in range(4)]

def decrypt_ecb(cipher):
    blocks = np.frombuffer(cipher, dtype=np.uint8).reshape(-1,16)
    s = blocks ^ ROUND_KEYS[-1]
    for key in ROUND_KEYS[-2:0:-1]:
        s = INV[s[:,ISHIFT]] ^ key
        out = np.empty_like(s)
        for col in range(4):
            p = col*4
            for row in range(4):
                out[:,p+row] = (MUL[COEFFS[(-row)%4]][s[:,p]] ^
                    MUL[COEFFS[(1-row)%4]][s[:,p+1]] ^
                    MUL[COEFFS[(2-row)%4]][s[:,p+2]] ^
                    MUL[COEFFS[(3-row)%4]][s[:,p+3]])
        s = out
    return INV[s[:,ISHIFT]] ^ ROUND_KEYS[0]

def decrypt_group(records):
    combined = b''.join(data for alias,data in records)
    blocks = np.frombuffer(combined,dtype=np.uint8).reshape(-1,16)
    previous = np.empty_like(blocks)
    previous[1:] = blocks[:-1]
    offset = 0
    for alias,data in records:
        previous[offset] = np.frombuffer(alias[-16:].encode('ascii'),dtype=np.uint8)
        offset += len(data)//16
    return (decrypt_ecb(combined) ^ previous).tobytes()

def stream_decode(raw):
    b = np.frombuffer(raw,dtype=np.uint8)
    p = np.arange(2,len(raw),dtype=np.uint32)
    prev2 = b[:-2]
    decoded = b[2:] ^ ((prev2>>3)|(prev2<<5)) ^ STREAM_TABLE[(p+b[1:-1])&15]
    if decoded[:2].tobytes() != bytes.fromhex('e629'):
        raise ValueError('custom class marker mismatch')
    return bytes.fromhex('cafebabe') + decoded[2:].tobytes()

def parse_class(data):
    p=4
    def take(n):
        nonlocal p
        if n<0 or p+n>len(data): raise ValueError('class bounds exceeded')
        v=data[p:p+n];p+=n;return v
    def u1():return take(1)[0]
    def u2():return int.from_bytes(take(2),'big')
    def u4():return int.from_bytes(take(4),'big')
    minor,major,count=u2(),u2(),u2()
    if not 45<=major<=65 or count<2: raise ValueError('class version/constant pool invalid')
    cp=[None]*count;i=1
    while i<count:
        tag=u1()
        if tag==1: cp[i]=(tag,take(u2()))
        elif tag in (3,4):cp[i]=(tag,take(4))
        elif tag in (5,6):cp[i]=(tag,take(8));i+=1
        elif tag in (7,8,16,19,20):cp[i]=(tag,u2())
        elif tag in (9,10,11,12,17,18):cp[i]=(tag,u2(),u2())
        elif tag==15:cp[i]=(tag,u1(),u2())
        else:raise ValueError(f'unknown constant tag {tag}')
        i+=1
    def cp_ref(index,tag):
        if not 0<index<count or not cp[index] or cp[index][0]!=tag:
            raise ValueError(f'invalid constant reference {index} expected tag {tag}')
        return cp[index]
    def attrs():
        n=u2()
        for _ in range(n):cp_ref(u2(),1);take(u4())
        return n
    access,this,super_=u2(),u2(),u2()
    internal=cp_ref(cp_ref(this,7)[1],1)[1].decode('utf-8')
    if super_:cp_ref(super_,7)
    for _ in range(u2()):cp_ref(u2(),7)
    def members():
        n=u2()
        for _ in range(n):u2();cp_ref(u2(),1);cp_ref(u2(),1);attrs()
        return n
    fields,methods=members(),members();attributes=attrs()
    path=PurePosixPath(internal+'.class')
    if path.is_absolute() or '..' in path.parts or '\\' in internal or ':' in internal or '\0' in internal:
        raise ValueError('unsafe class path')
    return dict(name=internal,minor=minor,major=major,constant_pool_count=count,
        fields=fields,methods=methods,attributes=attributes,consumed=p)

def self_check():
    native=(A/'emulated-cipher/c14f5b29590d12e945cb0f3a42112a91.bin').read_bytes()
    idx=json.loads((A/'jimage-index.json').read_text(encoding='utf-8'))
    row=next(r for r in idx['entries'] if r['name']=='/java.base/c14f5b29590d12e945cb0f3a42112a91')
    with Path(idx['source']).open('rb') as f:f.seek(row['offset']);cipher=f.read(row['uncompressed_size'])
    got=decrypt_group([('c14f5b29590d12e945cb0f3a42112a91',cipher)])
    if got!=native:raise ValueError('vectorized cipher differs from native emulator')
    standard=stream_decode(got);identity=parse_class(standard)
    if identity['name']!='java/lang/Object' or identity['consumed']!=1545:
        raise ValueError('known Object validation failed')
    if any(got[identity['consumed']:]):raise ValueError('expected zero cipher padding')
    return identity

def main():
    parser=argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--source',choices=['classes','libs','jimage','all'],default='classes')
    parser.add_argument('--limit',type=int,default=0)
    args=parser.parse_args()
    proof=self_check();OUT.mkdir(exist_ok=True)
    sources=['classes','libs','jimage'] if args.source=='all' else [args.source]
    for source in sources:
        start=time.monotonic();records=[]
        if source!='jimage':
            input_path=ORIGINAL/(source+'.jar')
            with zipfile.ZipFile(input_path) as jar:
                for item in jar.infolist():
                    if re.fullmatch('[0-9a-f]{32}',item.filename):
                        records.append((item.filename,jar.read(item)))
                        if args.limit and len(records)>=args.limit:break
        else:
            idx=json.loads((A/'jimage-index.json').read_text(encoding='utf-8'));input_path=Path(idx['source'])
            with input_path.open('rb') as f:
                for item in idx['entries']:
                    alias=item['name'].rsplit('/',1)[-1]
                    if re.fullmatch('[0-9a-f]{32}',alias):
                        if item['compressed_size']:raise ValueError('unexpected compressed resource')
                        f.seek(item['offset']);records.append((alias,f.read(item['uncompressed_size'])))
                        if args.limit and len(records)>=args.limit:break
        if not records:raise ValueError('no protected records')
        if any(not data or len(data)%16 for _,data in records):raise ValueError('unaligned payload')
        raw=decrypt_group(records);offset=0;ok=[];failed=[];names=set()
        suffix='-sample' if args.limit else ''
        destination=OUT/(source+suffix+'-recovered.jar')
        with zipfile.ZipFile(destination,'w',compression=zipfile.ZIP_DEFLATED) as jar:
            for alias,cipher in records:
                clear=raw[offset:offset+len(cipher)];offset+=len(cipher)
                try:
                    decoded=stream_decode(clear);meta=parse_class(decoded);end=meta['consumed']
                    padding=len(clear)-end
                    if not 1<=padding<=16 or any(clear[end:]):raise ValueError('invalid end/zero padding')
                    expected=hashlib.md5((meta['name']+'nUHDjbS59e4wF8Pr').encode('utf-8')).hexdigest()
                    if expected!=alias:raise ValueError('recovered class name hash mismatch')
                    if meta['name'] in names:raise ValueError('duplicate recovered class')
                    names.add(meta['name']);payload=decoded[:end]
                    jar.writestr(meta['name']+'.class',payload)
                    ok.append(dict(alias=alias,**meta,padding=padding,sha256=hashlib.sha256(payload).hexdigest()))
                except (ValueError,IndexError,UnicodeDecodeError,struct.error) as ex:
                    failed.append(dict(alias=alias,bytes=len(cipher),error=str(ex)))
        report=dict(source=str(input_path),output=str(destination),scope='offline recovery only; no class execution',
            known_object_native_byte_equal=True,known_object=proof,stream_table_rva='0xa2fd40',
            stream_table=STREAM_TABLE.tobytes().hex(),attempted=len(records),recovered_count=len(ok),
            failure_count=len(failed),elapsed_seconds=round(time.monotonic()-start,3),classes=ok,failures=failed,
            output_sha256=hashlib.sha256(destination.read_bytes()).hexdigest())
        (OUT/(source+suffix+'-recovery.json')).write_text(json.dumps(report,ensure_ascii=False,indent=2),encoding='utf-8')
        print(json.dumps({k:report[k] for k in ['source','output','attempted','recovered_count','failure_count','elapsed_seconds']},ensure_ascii=False),flush=True)

if __name__=='__main__':main()
