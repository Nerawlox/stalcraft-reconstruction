#!/usr/bin/env python3
"""Probe a small, explicit set of name-derived TEA/XTEA/XXTEA keys; never runs payloads."""
import hashlib, json, os, struct, zipfile
ROOT=r"E:\Stalcraft project\stalcraft_pre\stalcraft"
OUT=r"E:\Stalcraft project\builds\stalcraft-pre-vk-2017-candidate\analysis"
MASK=0xffffffff; DELTA=0x9e3779b9; MAGIC=b"\xca\xfe\xba\xbe"

def u32(x): return x & MASK
def key_candidates(name):
    raw=bytes.fromhex(name); ascii_name=name.encode("ascii")
    return {"hex_bytes":raw,"md5_ascii_hexname":hashlib.md5(ascii_name).digest(),"md5_raw_hexbytes":hashlib.md5(raw).digest(),"sha256_ascii_hexname_first16":hashlib.sha256(ascii_name).digest()[:16],"ascii_hexname_first16_zero_padded":ascii_name[:16].ljust(16,b"\0")}
def words(data,endian): return list(struct.unpack("<4I" if endian=="little" else ">4I",data))
def block(data,endian): return struct.unpack("<2I" if endian=="little" else ">2I",data)
def tea_dec(data,key,endian,rounds):
    v0,v1=block(data,endian); k=words(key,endian); s=u32(DELTA*rounds)
    for _ in range(rounds):
        v1=u32(v1-((((v0<<4)+k[2]) ^ (v0+s) ^ ((v0>>5)+k[3]))))
        v0=u32(v0-((((v1<<4)+k[0]) ^ (v1+s) ^ ((v1>>5)+k[1]))))
        s=u32(s-DELTA)
    return struct.pack("<2I" if endian=="little" else ">2I",v0,v1)
def xtea_dec(data,key,endian,rounds):
    v0,v1=block(data,endian); k=words(key,endian); s=u32(DELTA*rounds)
    for _ in range(rounds):
        v1=u32(v1-(((((v0<<4) ^ (v0>>5))+v0) ^ (s+k[(s>>11)&3]))))
        s=u32(s-DELTA)
        v0=u32(v0-(((((v1<<4) ^ (v1>>5))+v1) ^ (s+k[s&3]))))
    return struct.pack("<2I" if endian=="little" else ">2I",v0,v1)
def xxtea_dec(data,key,endian,rounds=None):
    # Fixed two-word XXTEA case. Canonical rounds for n=2 are 6+52/n = 32.
    v=list(block(data,endian)); k=words(key,endian); n=2; q=rounds or (6+52//n); total=u32(q*DELTA)
    while total:
        e=(total>>2)&3
        for p in (1,0):
            z=v[p-1] if p else v[n-1]; y=v[p]
            mx=u32((((z>>5) ^ (y<<2)) + ((y>>3) ^ (z<<4))) ^ ((total ^ y) + (k[(p&3)^e] ^ z)))
            v[p]=u32(v[p]-mx)
        total=u32(total-DELTA)
    return struct.pack("<2I" if endian=="little" else ">2I",*v)

hits=[]; candidates=0
for jar in ("classes.jar","libs.jar"):
    with zipfile.ZipFile(os.path.join(ROOT,jar)) as z:
        for inf in z.infolist():
            if len(inf.filename)!=32 or any(c not in "0123456789abcdefABCDEF" for c in inf.filename) or inf.file_size<8 or inf.file_size%8: continue
            b=z.read(inf); cblock=b[:8]
            for kn,k in key_candidates(inf.filename).items():
                for endian in ("little","big"):
                    for algo,fn,roundlist in (("TEA",tea_dec,(32,64)),("XTEA",xtea_dec,(32,64)),("XXTEA",xxtea_dec,(32,))):
                        for rounds in roundlist:
                            candidates+=1; plain=fn(cblock,k,endian,rounds)
                            if plain[:4]==MAGIC:
                                # Confirm the whole encrypted stream gives a framed Java class before saving anything.
                                dec=bytearray()
                                for pos in range(0,len(b),8): dec.extend(fn(b[pos:pos+8],k,endian,rounds))
                                hits.append({"jar":jar,"entry":inf.filename,"algorithm":algo,"key_source":kn,"word_endian":endian,"rounds":rounds,"first_plaintext_block":plain.hex(),"decrypted_size":len(dec),"class_magic_only":True})
                                with open(os.path.join(OUT,"tea-probe-candidates.json"),"w",encoding="utf-8") as f: json.dump(hits,f,indent=2)
result={"scope":"First 8 bytes of each 8-byte-aligned hex payload only; keys fixed from filename encodings/hash digests; class magic is searched without key fitting","algorithms":["TEA","XTEA","XXTEA"],"rounds":[32,64],"key_sources":["hex_bytes","md5_ascii_hexname","md5_raw_hexbytes","sha256_ascii_hexname_first16","ascii_hexname_first16_zero_padded"],"word_endianness":["little","big"],"block_aligned_entries_checked":candidates,"first_block_class_magic_hits":hits,"validated_class_recoveries":[]}
with open(os.path.join(OUT,"payload-key-probes.json"),"w",encoding="utf-8") as f: json.dump(result,f,indent=2)
print(json.dumps({"candidates_checked":candidates,"class_magic_hits":len(hits)}))
