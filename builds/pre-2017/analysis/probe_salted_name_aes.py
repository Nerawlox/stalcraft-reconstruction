#!/usr/bin/env python3
"""Probe deterministic AES keys derived from the observed native alias salt and payload names."""
import collections, hashlib, importlib.util, json, os, re, sys, zipfile
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
AN=r"E:\Stalcraft project\builds\stalcraft-pre-vk-2017-candidate\analysis"
ROOT=r"E:\Stalcraft project\stalcraft_pre\stalcraft"
SALT=b"2G5teW9TkteWdMSx";SALT2=b"nUHDjbS59e4wF8Pr"
spec=importlib.util.spec_from_file_location("aes_probe_helpers",os.path.join(AN,"probe-aes-payload.py"))
helper=importlib.util.module_from_spec(spec);sys.modules[spec.name]=helper;spec.loader.exec_module(helper)
MAGIC=b"\xca\xfe\xba\xbe";hits=[];attempts=0;class_magic=[];source_counts=collections.Counter()

def name_forms(name):
    # For JIMAGE pass the full module/resource path as well as the 32-hex basename.
    vals={"basename_ascii":name.rsplit("/",1)[-1].encode("ascii"),"full_path_utf8":name.encode("utf-8")}
    try: vals["basename_hex_bytes"]=bytes.fromhex(name.rsplit("/",1)[-1])
    except ValueError: pass
    return vals
def key_forms(name):
    result={};forms=name_forms(name)
    for fn,raw in forms.items():
        for sn,salt in (("JLI_salt",SALT),("adjacent_salt",SALT2)):
            for order,material in (("name_then_salt",raw+salt),("salt_then_name",salt+raw)):
                result.setdefault(hashlib.md5(material).digest(),f"{fn}|{sn}|{order}|MD5_128")
                sha=hashlib.sha256(material).digest()
                result.setdefault(sha[:16],f"{fn}|{sn}|{order}|SHA256_128")
                result.setdefault(sha,f"{fn}|{sn}|{order}|SHA256_256")
    return result
def dec(data,key,iv):
    d=Cipher(algorithms.AES(key),modes.ECB() if iv is None else modes.CBC(iv)).decryptor()
    return d.update(data)+d.finalize()
def inspect(source,name,b):
    global attempts
    if len(b)<16:return
    for start in (0,16,32):
        if len(b)<start+16 or (len(b)-start)%16:continue
        cipher=b[start:]
        ivs=[("ECB",None)]
        for label,iv in (("zero",bytes(16)),("JLI-salt",SALT), ("adjacent-salt",SALT2)):
            ivs.append(("CBC_"+label,iv))
        if start:ivs.append(("CBC_prev_block",b[start-16:start]))
        for key,keylabel in key_forms(name).items():
            for modelabel,iv in ivs:
                attempts+=1
                try:first=dec(cipher[:16],key,iv)
                except Exception:continue
                if first[:4]!=MAGIC:continue
                row={"source":source,"name":name,"key_derivation":keylabel,"mode":modelabel,"start_offset":start,"first_plain_block":first.hex()};class_magic.append(row)
                plain=dec(cipher,key,iv)
                for data in (plain,plain[:-plain[-1]] if plain and 0<plain[-1]<=16 and plain.endswith(bytes([plain[-1]])*plain[-1]) else b""):
                    if not data:continue
                    parsed=helper.valid_class(data)
                    if parsed:
                        dest=os.path.join(AN,"recovered-java-salted-name",source,parsed["name"]+".class")
                        os.makedirs(os.path.dirname(dest),exist_ok=True);open(dest,"wb").write(data)
                        hits.append({**row,**parsed,"recovered_path":os.path.relpath(dest,AN)});break

for jar in ("classes.jar","libs.jar"):
    with zipfile.ZipFile(os.path.join(ROOT,jar)) as z:
        for inf in z.infolist():
            if re.fullmatch(r"[0-9a-f]{32}",inf.filename):source_counts[jar]+=1;inspect(jar,inf.filename,z.read(inf))
idx=json.load(open(os.path.join(AN,"jimage-index.json"),encoding="utf-8"));modules=os.path.join(ROOT,"win64","java","lib","modules")
with open(modules,"rb") as f:
    for rec in idx["entries"]:
        name=rec["name"]
        if re.fullmatch(r"[0-9a-f]{32}",name.rsplit("/",1)[-1]):
            f.seek(rec["offset"]);b=f.read(rec["uncompressed_size"]);source_counts["jimage"]+=1;inspect("jimage",name,b)
result={"scope":"Every 32-hex payload in classes.jar, libs.jar, and indexed JIMAGE; AES ECB/CBC first-block probes with fixed name+observed-salt key derivations; no unknown-key search","salt":"2G5teW9TkteWdMSx","adjacent_string":"nUHDjbS59e4wF8Pr","source_counts":dict(source_counts),"unique_key_derivations_per_name_example":len(key_forms("0123456789abcdef0123456789abcdef")),"attempted_first_block_decryptions":attempts,"first_block_class_magic_hits":class_magic,"validated_classes":hits}
with open(os.path.join(AN,"salted-name-aes-probe.json"),"w",encoding="utf-8") as f:json.dump(result,f,indent=2,ensure_ascii=False)
print(json.dumps({"sources":dict(source_counts),"attempts":attempts,"magic_hits":len(class_magic),"valid_classes":len(hits)},ensure_ascii=False))
