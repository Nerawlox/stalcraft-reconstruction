#!/usr/bin/env python3
"""Rebuild the read-only JVM code-reference and fixed-key payload probe reports."""
import json, os, runpy
HERE=os.path.dirname(os.path.abspath(__file__))
for script in ("analyze_jvm_reader.py","probe_rdata_aes.py","probe_tea_payload_keys.py"):
    runpy.run_path(os.path.join(HERE,script),run_name="_native_payload_analysis")
x=json.load(open(os.path.join(HERE,"jvm-reader-xrefs.json"),encoding="utf-8"))
a=json.load(open(os.path.join(HERE,"rdata-aes-probe.json"),encoding="utf-8"))
t=json.load(open(os.path.join(HERE,"payload-key-probes.json"),encoding="utf-8"))
relevant=[]
for row in x["relevant_string_xrefs"]:
    if any(s in row["string"].lower() for s in ("classfileparser.cpp","classfilestream.cpp","classloader.cpp","jimage_getresource","jimage_findresource","incompatible magic value","encrypted entry")):
        relevant.append(row)
out={
    "scope":"Static analysis of captured mapped JVM plus fixed, preselected key hypotheses only. No DLL/EXE/payload execution and no unknown-key brute force.",
    "image":x["image"],
    "disassembly_instruction_counts":x["disassembled_instruction_count"],
    "relevant_class_jimage_string_xrefs":relevant,
    "class_magic_immediate_instruction_sites":x["class_magic_immediate_instruction_sites"],
    "class_magic_memory_comparison_count":x["class_magic_comparison_count"],
    "raw_known_crypto_constant_scan":x["crypto_and_class_magic_constant_occurrences"],
    "fixed_rdata_aes_probe":a,
    "fixed_filename_tea_family_probe":t,
    "conclusion":{"cipher_identified":False,"key_identified":False,"method_identified":False,"valid_class_recovered":False,
        "observations":["PE header maps image offsets to RVAs; ImageBase is 0x5a970000.","All recognized direct references to the searched class/JIMAGE strings occur in .text; none were emitted from .vmp0 by this RIP-relative xref scan.","The only CAFEBABE immediates found are two value-passing MOVs and three CMP instructions over memory; their relationship to actual Java class bytes is not established.","Captured .vmp1 remains very high entropy and includes the PE entrypoint, so protected/virtualized code remains an analysis boundary.","The fixed .rdata AES keys and fixed filename-derived TEA/XTEA/XXTEA candidates produced no class magic or valid class."]}
}
with open(os.path.join(HERE,"native-payload-decoder.json"),"w",encoding="utf-8") as f:json.dump(out,f,indent=2,ensure_ascii=False)
print(json.dumps({"output":"native-payload-decoder.json","sections_disassembled":out["disassembly_instruction_counts"],"class_magic_immediate_sites":len(out["class_magic_immediate_instruction_sites"]),"valid_classes":0,"cipher_identified":False},ensure_ascii=False))
