#!/usr/bin/env python3
"""Static x64 disassembly/xref scan of the captured, mapped diagnostic JVM image."""
import collections, hashlib, json, os, re, sys
sys.path.insert(0, os.path.join(os.path.dirname(__file__), "python-tools"))
import pefile
from capstone import Cs, CS_ARCH_X86, CS_MODE_64, CS_OPT_DETAIL, CS_OPT_ON

ROOT=r"E:\Stalcraft project\stalcraft_pre\stalcraft"
AN=r"E:\Stalcraft project\builds\stalcraft-pre-vk-2017-candidate\analysis"
CAP=os.path.join(AN,"dynamic-capture")
IMAGE=os.path.join(CAP,"jvm-static-view.pe")
STRINGS=os.path.join(CAP,"watch-all-strings.txt")
OUT=os.path.join(AN,"jvm-reader-xrefs.json")
data=open(IMAGE,"rb").read(); pe=pefile.PE(data=data,fast_load=False)
imgbase=pe.OPTIONAL_HEADER.ImageBase
sections={s.Name.decode("ascii","replace").rstrip("\0"):s for s in pe.sections}
allstrings=[]
for line in open(STRINGS,encoding="utf-8",errors="replace"):
 m=re.match(r"([0-9a-fA-F]{8})\s+(.*)",line.rstrip("\r\n"))
 if m:
  try: allstrings.append((int(m.group(1),16),m.group(2)))
  except ValueError: pass
needles=re.compile(r"(?i)(class ?file|classfile|CAFEBABE|magic value|JIMAGE|jimage|ZIP_Read|encrypted entry|Corrupted ZIP|Corrupt.*class|cipher|decrypt|encrypt|AES|MD5|SHA|module|\.class|modules%c)")
selected=[(a,s) for a,s in allstrings if needles.search(s)]
interesting={a:s for a,s in selected}
selected_addresses=sorted(interesting)
startsets={name:set() for name in sections}
xrefs=collections.defaultdict(list); instructions=collections.Counter(); call_targets=collections.Counter(); magic_imms=[]
md=Cs(CS_ARCH_X86,CS_MODE_64);md.detail=False;md.skipdata=True
for section_name in (".text",".vmp0"):
 sec=sections[section_name];start=sec.VirtualAddress;end=start+max(sec.Misc_VirtualSize,sec.SizeOfRawData)
 chunk=data[start:end]
 for address,size,mnemonic,opstr in md.disasm_lite(chunk,start):
  instructions[section_name]+=1
  text=mnemonic+" "+opstr
  if mnemonic.startswith("call"):
   direct=re.match(r"0x([0-9a-fA-F]+)$",opstr.strip())
   if direct:call_targets[(section_name,int(direct.group(1),16))]+=1
  imm=re.search(r"0x([0-9a-fA-F]+)",opstr)
  if imm and int(imm.group(1),16)&0xffffffff in (0xcafebabe,0xbebafeca):
   kind="comparison" if mnemonic in ("cmp","test") else "value_passed_or_other_use"
   magic_imms.append({"section":section_name,"rva":hex(address),"instruction":text,"mnemonic":mnemonic,"kind":kind,"immediate":hex(int(imm.group(1),16)&0xffffffff)})
  rel=re.search(r"\[rip\s*([+-])\s*(0x[0-9a-fA-F]+)\]",opstr,re.I)
  if rel:
   disp=int(rel.group(2),16)*(1 if rel.group(1)=="+" else -1);target=address+size+disp
   if target in interesting:
    xrefs[target].append({"section":section_name,"rva":hex(address),"instruction":text})

constant_patterns={
 "java_magic_be":bytes.fromhex("cafebabe"),"java_magic_le":bytes.fromhex("bebafeca"),
 "md5_iv_words_le":bytes.fromhex("0123456789abcdeffedcba9876543210"),
 "md5_k0_le":bytes.fromhex("d76aa478"),"sha256_k0_be":bytes.fromhex("428a2f98"),
 "aes_sbox_start":bytes.fromhex("637c777bf26b6fc53001672bfed7ab76"),
 "blowfish_p0_be":bytes.fromhex("243f6a88"),"des_ip_start":bytes.fromhex("3a321e0a3b331f0b")}
pattern_hits={}
for name,pat in constant_patterns.items():
 pos=[];offset=0
 while len(pos)<20:
  off=data.find(pat,offset)
  if off<0:break
  pos.append({"rva_or_file_offset":hex(off),"section":next((n for n,s in sections.items() if s.VirtualAddress<=off<s.VirtualAddress+max(s.Misc_VirtualSize,s.SizeOfRawData)),"headers")})
  offset=off+1
 pattern_hits[name]=pos

refs=[]
for a,s in selected:
 if xrefs[a]: refs.append({"string_rva":hex(a),"string":s,"xrefs":xrefs[a][:40],"xref_count":len(xrefs[a])})
result={"scope":"read-only scan of captured mapped JVM; PE image address equals RVA in file; no runtime or DLL execution","image":{"path":IMAGE,"size":len(data),"sha256":hashlib.sha256(data).hexdigest(),"image_base":hex(imgbase),"machine":hex(pe.FILE_HEADER.Machine)},"disassembled_instruction_count":dict(instructions),"relevant_string_xrefs":refs,"class_magic_immediate_instruction_sites":magic_imms,"class_magic_comparison_count":sum(x["kind"]=="comparison" for x in magic_imms),"crypto_and_class_magic_constant_occurrences":pattern_hits,"important_string_count":len(selected)}
with open(OUT,"w",encoding="utf-8") as f:json.dump(result,f,indent=2,ensure_ascii=False)
print(json.dumps({"instructions":dict(instructions),"interesting_strings":len(selected),"string_refs_with_xrefs":len(refs),"magic_immediate_count":len(magic_imms),"pattern_hits":{k:len(v) for k,v in pattern_hits.items()}},ensure_ascii=False))
