#!/usr/bin/env python3
"""Test only the fixed initial .rdata bytes as AES keys against opaque payloads."""
import collections, hashlib, importlib.util, json, os, re, struct, sys, zipfile
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
AN=r"E:\Stalcraft project\builds\stalcraft-pre-vk-2017-candidate\analysis"
ROOT=r"E:\Stalcraft project\stalcraft_pre\stalcraft"
CAP=os.path.join(AN,"dynamic-capture")
image=open(os.path.join(CAP,"jvm-static-view.pe"),"rb").read()
RDATA_RVA=0x778000
key16=image[RDATA_RVA:RDATA_RVA+16];key32=image[RDATA_RVA:RDATA_RVA+32]
salts={"JLI_shared_salt":b"2G5teW9TkteWdMSx","adjacent_16char_rdata_string":b"nUHDjbS59e4wF8Pr"}
keys={"rdata_first16_AES128":key16,"rdata_first32_AES256":key32}
for label,salt in salts.items():
    keys[label+"_raw_AES128"]=salt
    keys[label+"_MD5_AES128"]=hashlib.md5(salt).digest()
    keys[label+"_SHA256_first16_AES128"]=hashlib.sha256(salt).digest()[:16]
    keys[label+"_SHA256_AES256"]=hashlib.sha256(salt).digest()
keys["two_adjacent_strings_concat_AES256"]=salts["JLI_shared_salt"]+salts["adjacent_16char_rdata_string"]
keys["two_adjacent_strings_reverse_concat_AES256"]=salts["adjacent_16char_rdata_string"]+salts["JLI_shared_salt"]

# Reuse the existing bounded parser; importing it is safe and does not run its main().
spec=importlib.util.spec_from_file_location("aes_probe_helpers",os.path.join(AN,"probe-aes-payload.py"))
helper=importlib.util.module_from_spec(spec);sys.modules[spec.name]=helper;spec.loader.exec_module(helper)
MAGIC=b"\xca\xfe\xba\xbe"
hits=[]; attempted=0; magic_hits=[]
summary={"scope":"Fixed key bytes from first 16/32 bytes of captured JVM .rdata and explicitly observed 16-character rdata salt strings; no key search; AES ECB/CBC hypotheses against every JAR and JIMAGE 32-hex payload","rdata_rva":hex(RDATA_RVA),"salt_rvas":{"JLI_shared_salt":"0x89abc0","adjacent_16char_rdata_string":"0x89abd8"},"image_base":hex(0x5a970000),"candidate_keys":{k:v.hex() for k,v in keys.items()},"source_counts":collections.Counter()}

def aes_dec(cipher,key,mode):
    d=Cipher(algorithms.AES(key),mode).decryptor();return d.update(cipher)+d.finalize()

def inspect(source,name,b):
    global attempted
    if len(b)<16:return
    for start in (0,16,32):
        if len(b)<start+16 or (len(b)-start)%16:continue
        c=b[start:]
        ivs=[("zero",bytes(16))]
        if re.fullmatch(r"[0-9a-fA-F]{32}",name):ivs.append(("hex-name",bytes.fromhex(name)))
        if start:ivs.append(("previous-cipher-block",b[start-16:start]))
        for keyname,key in keys.items():
            candidates=[("ECB",None)] + [("CBC_"+label,iv) for label,iv in ivs]
            for mode_name,iv in candidates:
                attempted+=1
                try: first=aes_dec(c[:16],key,modes.ECB() if iv is None else modes.CBC(iv))
                except Exception:continue
                if first[:4]!=MAGIC:continue
                record={"source":source,"name":name,"key":keyname,"mode":mode_name,"start_offset":start,"first_plain_block":first.hex()}
                magic_hits.append(record)
                try: plain=aes_dec(c,key,modes.ECB() if iv is None else modes.CBC(iv))
                except Exception:continue
                parsed=None
                for data in (plain,plain[:-plain[-1]] if plain and 0<plain[-1]<=16 and plain.endswith(bytes([plain[-1]])*plain[-1]) else b""):
                    if not data:continue
                    parsed=helper.valid_class(data)
                    if parsed:
                        path=os.path.join(AN,"recovered-java-rdata",source,parsed["name"]+".class")
                        os.makedirs(os.path.dirname(path),exist_ok=True);open(path,"wb").write(data)
                        hits.append({**record,**parsed,"recovered_path":os.path.relpath(path,AN)})
                        break

for jar in ("classes.jar","libs.jar"):
    with zipfile.ZipFile(os.path.join(ROOT,jar)) as z:
        for info in z.infolist():
            if re.fullmatch(r"[0-9a-f]{32}",info.filename):
                summary["source_counts"][jar]+=1;inspect(jar,info.filename,z.read(info))
idx_path=os.path.join(AN,"jimage-index.json")
if os.path.exists(idx_path):
    index=json.load(open(idx_path,encoding="utf-8"));modules=os.path.join(ROOT,"win64","java","lib","modules")
    with open(modules,"rb") as f:
        for item in index["entries"]:
            name=item["name"].rsplit("/",1)[-1]
            if re.fullmatch(r"[0-9a-f]{32}",name):
                size=item["uncompressed_size"];f.seek(item["offset"]);b=f.read(size)
                summary["source_counts"]["jimage"]+=1;inspect("jimage",name,b)
summary["source_counts"]=dict(summary["source_counts"])
summary["attempted_first_block_decryptions"]=attempted
summary["class_magic_hits"]=magic_hits
summary["validated_classes"]=hits
with open(os.path.join(AN,"rdata-aes-probe.json"),"w",encoding="utf-8") as f:json.dump(summary,f,indent=2,ensure_ascii=False)
print(json.dumps({"key128":key16.hex(),"key256":key32.hex(),"sources":summary["source_counts"],"attempts":attempted,"magic_hits":len(magic_hits),"valid_classes":len(hits)},ensure_ascii=False))
