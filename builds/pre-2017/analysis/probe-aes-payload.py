"""Bounded AES hypotheses; ciphertext is never executed. No guessed key is a fact."""
from pathlib import Path
import hashlib, json, zipfile, re, struct, zlib
from collections import Counter
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
HERE=Path(__file__).resolve().parent
ROOT=Path(r'E:\Stalcraft project\stalcraft_pre\stalcraft')

def valid_class(b):
    if not b.startswith(bytes.fromhex('cafebabe')):return None
    try:
        minor,major,n=struct.unpack_from('>HHH',b,4)
        if not (45<=major<=65 and n>1):return None
        cp=[None]*n;p=10;i=1
        while i<n:
            tag=b[p];p+=1
            if tag==1:
                k=struct.unpack_from('>H',b,p)[0];p+=2
                cp[i]=b[p:p+k].decode('utf-8',errors='replace');p+=k
            elif tag in (3,4):p+=4
            elif tag in (5,6):p+=8;i+=1
            elif tag in (7,8,16,19,20):cp[i]=struct.unpack_from('>H',b,p)[0];p+=2
            elif tag in (9,10,11,12,17,18):p+=4
            elif tag==15:p+=3
            else:return None
            if p>len(b):return None
            i+=1
        _,this,_=struct.unpack_from('>HHH',b,p);p+=6
        name=cp[cp[this]]
        if not isinstance(name,str):return None
        ni=struct.unpack_from('>H',b,p)[0];p+=2+2*ni
        def attrs(p):
            count=struct.unpack_from('>H',b,p)[0];p+=2
            for _ in range(count):
                _,size=struct.unpack_from('>HI',b,p);p+=6+size
                if p>len(b):raise ValueError('truncated attribute')
            return p
        for kind in ['fields','methods']:
            count=struct.unpack_from('>H',b,p)[0];p+=2
            for _ in range(count):p=attrs(p+6)
        p=attrs(p)
        if p!=len(b):return None
        return dict(name=name,major=major,constant_pool=n)
    except (IndexError,struct.error,TypeError,ValueError):return None

def keys(name):
    raw=bytes.fromhex(name);a=name.encode()
    result={'hex':raw,'hex-reversed':raw[::-1],'hex-u32-reversed':b''.join(raw[i:i+4][::-1] for i in range(0,16,4)),
        'name-md5':hashlib.md5(a).digest(),'name-sha256':hashlib.sha256(a).digest(),
        'name-sha256-first16':hashlib.sha256(a).digest()[:16],'name-first16':a[:16],
        'name-last16':a[-16:],'name-ascii32':a,'name-utf16-md5':hashlib.md5(name.encode('utf-16le')).digest()}
    for word in ['stalcraft','STALCRAFT','stalkraft','STALKRAFT','exbo','EXBO','Folken','GloomyFolken','gloomyfolken','GloomyCore','gloomycore','classes.jar','libs.jar','jdk9','OpenJDK','0123456789abcdef','1234567890123456']:
        t=word.encode();result['word-md5:'+word]=hashlib.md5(t).digest()
        result['word-sha256:'+word]=hashlib.sha256(t).digest()
        if len(t) in (16,24,32):result['word-raw:'+word]=t
    return result

def main():
    samples=[]
    for jar in ['classes.jar','libs.jar']:
        with zipfile.ZipFile(ROOT/jar) as z:
            infos=sorted((i for i in z.infolist() if re.fullmatch('[0-9a-f]{32}',i.filename)),key=lambda i:i.file_size)
            chosen={i.filename:i for i in infos[:80]+infos[-40:]+infos[::max(1,len(infos)//80)]}
            samples.extend((jar,i.filename,z.read(i)) for i in chosen.values())
    image=(ROOT/'win64/java/lib/modules').read_bytes()
    idx=json.loads((HERE/'jimage-index.json').read_text(encoding='utf-8'))
    entries=sorted((e for e in idx['entries'] if re.fullmatch('[0-9a-f]{32}',e['name'].rsplit('/',1)[-1])),key=lambda e:e['uncompressed_size'])
    chosen={e['name']:e for e in entries[:40]+entries[-20:]+entries[::max(1,len(entries)//40)]}
    samples.extend(('jimage',e['name'].rsplit('/',1)[-1],image[e['offset']:e['offset']+e['uncompressed_size']]) for e in chosen.values())
    tests=0;hits=[]
    for source,name,b in samples:
        for label,key in keys(name).items():
            for start in [0,16,32]:
                if len(b)<start+16:continue
                for mode_name,iv in [('ECB',None),('CBC-zero',bytes(16)),('CBC-name',bytes.fromhex(name)),('CBC-prefix',b[start-16:start] if start else b[:16])]:
                    dec=Cipher(algorithms.AES(key),modes.ECB() if iv is None else modes.CBC(iv)).decryptor()
                    first=dec.update(b[start:start+16]);tests+=1
                    if first[:4]!=bytes.fromhex('cafebabe') and first[:2] not in (b'\x78\x01',b'\x78\x9c',b'\x78\xda'):
                        continue
                    full=first+dec.update(b[start+16:])+dec.finalize()
                    # Validate actual structure, never retain magic-only candidates.
                    for padding,data in [('none',full),('pkcs7',full[:-full[-1]] if full[-1] and full[-1]<=16 and full.endswith(bytes([full[-1]])*full[-1]) else b'')]:
                        if not data:continue
                        if data[:2] in (b'\x78\x01',b'\x78\x9c',b'\x78\xda'):
                            try:data=zlib.decompress(data)
                            except zlib.error:continue
                        valid=valid_class(data)
                        if valid:
                            record=dict(source=source,payload=name,key_derivation=label,mode=mode_name,start=start,padding=padding,**valid)
                            target=HERE/'recovered-java'/source/(valid['name']+'.class')
                            target.parent.mkdir(parents=True,exist_ok=True);target.write_bytes(data);hits.append(record)
    summary=dict(sample_count=len(samples),samples_by_source=dict(Counter(s for s,_,_ in samples)),first_block_attempts=tests,valid_classes=hits,
                 scope='AES-128/256 ECB/CBC, offsets0/16/32, named filename-derived and small common-word key hypotheses; no unknown-key brute force; negative result does not disprove AES')
    (HERE/'aes-probe.json').write_text(json.dumps(summary,ensure_ascii=False,indent=2),encoding='utf-8')
    print(json.dumps(summary,ensure_ascii=False,indent=2))

if __name__=='__main__':main()
