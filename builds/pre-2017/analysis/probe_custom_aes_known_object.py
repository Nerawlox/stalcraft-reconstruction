"""Decode one known JIMAGE class using the statically recovered native cipher."""
import importlib.util, json, pathlib, struct, hashlib

ROOT=pathlib.Path(r'E:\Stalcraft project\builds\stalcraft-pre-vk-2017-candidate')
A=ROOT/'analysis'
spec=importlib.util.spec_from_file_location('custom_rijndael',A/'custom_rijndael.py')
cr=importlib.util.module_from_spec(spec); spec.loader.exec_module(cr)

pe=(A/'dynamic-capture'/'jvm-static-view.pe').read_bytes()
sbox=pe[0x89a6f0:0x89a7f0]
inv=pe[0x89a7f0:0x89a8f0]
exp=pe[0x89a8f0:0x89a9f0]
log=pe[0x89a9f0:0x89aaf0]
assert len(sbox)==len(inv)==256 and len(set(sbox))==256
assert all(inv[sbox[i]]==i for i in range(256))
assert len(set(exp[:255]))==255 and exp[255]==0
assert all(log[exp[i]]==i for i in range(255))

index=json.loads((A/'jimage-index.json').read_text(encoding='utf-8'))
record=next(e for e in index['entries'] if e['name']=='/java.base/c14f5b29590d12e945cb0f3a42112a91')
modules=pathlib.Path(index['source'])
with modules.open('rb') as f:
    f.seek(record['offset']); cipher=f.read(record['uncompressed_size'])
assert len(cipher)==record['uncompressed_size'] and len(cipher)%16==0
key=bytes.fromhex('e7488b845f71f6cccfb8945cc05d1f0d')
# The wrapper hashes (name + salt2) to 32 lowercase hex characters and passes
# that string to the cipher. The actual IV is therefore its final 16 ASCII chars.
digest=record['name'].rsplit('/',1)[1]
iv=digest[-16:].encode('ascii')
plain=cr.decrypt_cbc(cipher,key,sbox,inv,iv=iv,inverse_mix=(253,134,238,124))

def parse_class(data):
    p=0
    def u1():
        nonlocal p
        x=data[p]; p+=1; return x
    def u2():
        nonlocal p
        x=struct.unpack_from('>H',data,p)[0]; p+=2; return x
    def u4():
        nonlocal p
        x=struct.unpack_from('>I',data,p)[0]; p+=4; return x
    if data[:4]!=b'\xca\xfe\xba\xbe': raise ValueError('bad magic: '+data[:16].hex())
    p=4; minor=u2(); major=u2(); count=u2(); cp=[None]*count; i=1
    while i<count:
        tag=u1()
        if tag==1:
            n=u2(); raw=data[p:p+n]; p+=n
            cp[i]=('Utf8',raw.decode('utf-8','replace'))
        elif tag in (3,4): p+=4; cp[i]=(tag,None)
        elif tag in (5,6): p+=8; cp[i]=(tag,None); i+=1
        elif tag in (7,8,16,19,20): cp[i]=(tag,u2())
        elif tag in (9,10,11,12,17,18): cp[i]=(tag,u2(),u2())
        elif tag==15: cp[i]=(tag,u1(),u2())
        else: raise ValueError(f'unknown CP tag {tag} at #{i}')
        if p>len(data): raise ValueError('constant pool overrun')
        i+=1
    access=u2(); this=u2(); super_=u2()
    def class_name(idx):
        tag,ref=cp[idx]
        if tag!=7: raise ValueError('this_class not CONSTANT_Class')
        return cp[ref][1]
    this_name=class_name(this)
    interfaces=u2(); p+=2*interfaces
    def members():
        nonlocal p
        n=u2()
        for _ in range(n):
            p+=6; ac=u2()
            for _ in range(ac):
                name=u2(); length=u4(); p+=length
                if p>len(data): raise ValueError('attribute overrun')
        return n
    fields=members(); methods=members(); attrs=u2()
    for _ in range(attrs): p+=2; length=u4(); p+=length
    if p!=len(data): raise ValueError(f'end mismatch {p} != {len(data)}')
    return {'minor':minor,'major':major,'constant_pool_count':count,'this_class':this_name,'fields':fields,'methods':methods,'attributes':attrs,'consumed':p}

identity=None; attempts=[]; native=None; plain=None
spec=importlib.util.spec_from_file_location('emulate_native_cipher',A/'emulate-native-cipher.py')
em=importlib.util.module_from_spec(spec); spec.loader.exec_module(em)
native,native_state=em.emulate(cipher,digest)
for coeff in ((253,134,238,124),(82,183,13,233)):
    # The native inverse coefficients are table-derived byte values; the native
    # routine's MixColumns arithmetic uses the standard 0x11b polynomial.
    candidate=cr.decrypt_cbc(cipher,key,sbox,inv,iv=iv,inverse_mix=coeff)
    byte_equal=(candidate==native)
    try:
        parsed=parse_class(candidate)
        attempts.append({'inverse_mix':coeff,'valid':True,'identity':parsed,'native_byte_equal':byte_equal})
        if parsed['this_class']=='java/lang/Object':
            plain=candidate; identity=parsed; break
    except (ValueError,IndexError,struct.error) as ex:
        attempts.append({'inverse_mix':coeff,'valid':False,'error':str(ex),'first16':candidate[:16].hex(),'native_byte_equal':byte_equal})
        if byte_equal: plain=candidate
if plain is None: plain=native
result={'record':record['name'],'offset':record['offset'],'compressed_size':record['compressed_size'],'cipher_size':len(cipher),'key':key.hex(),'iv':iv.decode(),'attempts':attempts,'native_emulation':native_state,'sbox_sha256':hashlib.sha256(sbox).hexdigest(),'plaintext_sha256':hashlib.sha256(plain).hexdigest(),'valid_class':identity,'output':'none; no valid bytecode recovered'}
(A/'custom-cipher-object-result.json').write_text(json.dumps(result,indent=2),encoding='utf-8')
print(json.dumps(result,indent=2))
