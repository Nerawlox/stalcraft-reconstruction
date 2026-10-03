#!/usr/bin/env python3
"""Decrypt bounded largest payload samples with salt-derived AES keys, accounting for unknown CBC IV."""
import collections, hashlib, json, math, os, re, statistics, zipfile
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
AN=r"E:\Stalcraft project\builds\stalcraft-pre-vk-2017-candidate\analysis"
ROOT=r"E:\Stalcraft project\stalcraft_pre\stalcraft"
S1=b"2G5teW9TkteWdMSx";S2=b"nUHDjbS59e4wF8Pr"

def entropy(b):
    if not b:return 0
    c=collections.Counter(b);n=len(b)
    return -sum((v/n)*math.log2(v/n) for v in c.values())
keys={"salt1_raw_AES128":S1,"salt1_MD5_AES128":hashlib.md5(S1).digest(),"salt1_SHA256_128":hashlib.sha256(S1).digest()[:16],"salt1_SHA256_256":hashlib.sha256(S1).digest(),
      "salt2_raw_AES128":S2,"salt2_MD5_AES128":hashlib.md5(S2).digest(),"salt2_SHA256_128":hashlib.sha256(S2).digest()[:16],"salt2_SHA256_256":hashlib.sha256(S2).digest(),
      "salts_concat_AES256":S1+S2,"salts_concat_MD5_AES128":hashlib.md5(S1+S2).digest(),"salts_concat_SHA256_AES256":hashlib.sha256(S1+S2).digest()}
samples=[]
for jar in ("classes.jar","libs.jar"):
    with zipfile.ZipFile(os.path.join(ROOT,jar)) as z:
        infos=sorted((i for i in z.infolist() if re.fullmatch(r"[0-9a-f]{32}",i.filename) and i.file_size>=64),key=lambda i:i.file_size,reverse=True)[:80]
        samples.extend((jar,i.filename,z.read(i)) for i in infos)
idx=json.load(open(os.path.join(AN,"jimage-index.json"),encoding="utf-8"));modules=os.path.join(ROOT,"win64","java","lib","modules")
with open(modules,"rb") as f:
    entries=sorted((e for e in idx["entries"] if re.fullmatch(r"[0-9a-f]{32}",e["name"].rsplit("/",1)[-1]) and e["uncompressed_size"]>=64),key=lambda e:e["uncompressed_size"],reverse=True)[:80]
    for e in entries:f.seek(e["offset"]);samples.append(("jimage",e["name"],f.read(e["uncompressed_size"])))
tokens=(b"java/",b"javax/",b"sun/",b"jdk/",b"com/",b"org/",b"net/",b"Ljava/",b"class",b"module-info",b"META-INF",b"CAFEBABE",b"PK\x03\x04")
rows=[];summary=collections.defaultdict(list);count=0
for source,name,cipher in samples:
    for label,key in keys.items():
        if len(cipher)%16:continue
        d=Cipher(algorithms.AES(key),modes.CBC(bytes(16))).decryptor()
        plain=d.update(cipher)+d.finalize();count+=1
        tail=plain[16:]
        found=[t.decode("ascii","replace") for t in tokens if t in tail]
        printable=sum((32<=x<=126) or x in (9,10,13) for x in tail)/len(tail) if tail else 0
        row={"source":source,"name":name,"size":len(cipher),"key":label,"cipher_tail_entropy":round(entropy(cipher[16:]),5),"plain_tail_entropy":round(entropy(tail),5),"tail_printable_fraction":round(printable,5),"common_class_token_hits":found,"cafebabe_at_offset_ge16":tail.find(b"\xca\xfe\xba\xbe"),"zip_magic_at_offset_ge16":tail.find(b"PK\x03\x04"),"decrypted_first16":plain[:16].hex()}
        rows.append(row);summary[(source,label)].append(row)
grouped=[]
for (source,label),vals in summary.items():
    entvals=[r["plain_tail_entropy"] for r in vals]
    token_rows=[r for r in vals if r["common_class_token_hits"]]
    grouped.append({"source":source,"key":label,"samples":len(vals),"mean_cipher_tail_entropy":round(statistics.mean(r["cipher_tail_entropy"] for r in vals),5),"mean_plain_tail_entropy":round(statistics.mean(entvals),5),"min_plain_tail_entropy":round(min(entvals),5),"token_hit_samples":len(token_rows),"token_hit_examples":[{"name":r["name"],"tokens":r["common_class_token_hits"],"plain_entropy":r["plain_tail_entropy"]} for r in token_rows[:10]],"lowest_entropy_examples":[{"name":r["name"],"cipher_tail_entropy":r["cipher_tail_entropy"],"plain_tail_entropy":r["plain_tail_entropy"],"decrypted_first16":r["decrypted_first16"]} for r in sorted(vals,key=lambda r:r["plain_tail_entropy"])[:5]]})
out={"scope":"Largest 80 payloads per source (classes.jar, libs.jar, JIMAGE), full AES-128/256 CBC decryption with zero IV and fixed salt-derived key candidates; unknown-IV CBC decrypts all later blocks independently of IV, so tail strings/entropy remain diagnostic. No guessed-key search.","salt1":"2G5teW9TkteWdMSx","salt2":"nUHDjbS59e4wF8Pr","keys":{k:v.hex() for k,v in keys.items()},"samples_per_source":80,"full_buffer_decryptions":count,"group_summaries":grouped,"per_sample_results":rows,"validated_class_recoveries":[]}
with open(os.path.join(AN,"salt-cbc-full-probe.json"),"w",encoding="utf-8") as f:json.dump(out,f,indent=2,ensure_ascii=False)
print(json.dumps({"full_buffer_decryptions":count,"groups":len(grouped),"total_token_hit_samples":sum(g["token_hit_samples"] for g in grouped),"best_tail_entropy":min((g["min_plain_tail_entropy"],g["source"],g["key"]) for g in grouped)},ensure_ascii=False))
