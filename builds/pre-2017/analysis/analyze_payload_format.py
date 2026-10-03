#!/usr/bin/env python3
"""Read-only statistics and simple-transform checks for opaque STALCRAFT payloads."""
import collections, hashlib, json, math, os, statistics, struct, zipfile

ROOT = r"E:\Stalcraft project\stalcraft_pre\stalcraft"
OUT = r"E:\Stalcraft project\builds\stalcraft-pre-vk-2017-candidate\analysis"
MAGICS = {"class": b"\xca\xfe\xba\xbe", "zip": b"PK\x03\x04", "gzip": b"\x1f\x8b\x08", "zlib": b"\x78\x9c"}

def is_hex(s): return len(s) == 32 and all(c in "0123456789abcdefABCDEF" for c in s)
def ent(b):
    c = collections.Counter(b); n = len(b)
    return -sum((v/n)*math.log2(v/n) for v in c.values()) if n else 0.0
def parse_class(b):
    """Return class identity only after parsing the complete CP and member/attribute framing."""
    try:
        if b[:4] != MAGICS["class"]: return None
        minor, major, count = struct.unpack_from(">HHH", b, 4); p = 10; cp = [None]*count; i = 1
        while i < count:
            tag = b[p]; p += 1
            if tag == 1:
                n = struct.unpack_from(">H", b, p)[0]; p += 2
                s = b[p:p+n].decode("utf-8");
                if len(s.encode("utf-8")) != n: return None
                p += n; cp[i] = (tag, s)
            elif tag in (3,4): p += 4; cp[i] = (tag,)
            elif tag in (5,6): p += 8; cp[i] = (tag,); i += 1
            elif tag in (7,8,16,19,20): x, = struct.unpack_from(">H", b, p); p += 2; cp[i] = (tag,x)
            elif tag in (9,10,11,12,17,18): x,y = struct.unpack_from(">HH", b, p); p += 4; cp[i]=(tag,x,y)
            elif tag == 15: x,y = struct.unpack_from(">BH", b, p); p += 3; cp[i]=(tag,x,y)
            else: return None
            if p > len(b): return None
            i += 1
        for e in cp[1:]:
            if not e: continue
            if e[0] in (7,8,16,19,20):
                if not (0 < e[1] < count and cp[e[1]] and cp[e[1]][0] == 1): return None
            elif e[0] in (9,10,11,12,17,18):
                if not all(0 < x < count and cp[x] for x in e[1:]): return None
            elif e[0] == 15 and not (0 < e[2] < count and cp[e[2]]): return None
        _, this, _ = struct.unpack_from(">HHH", b, p); p += 6
        if not (0 < this < count and cp[this] and cp[this][0] == 7): return None
        name = cp[cp[this][1]][1]
        ni, = struct.unpack_from(">H", b, p); p += 2 + 2*ni
        for _ in range(2):
            n, = struct.unpack_from(">H", b, p); p += 2
            for __ in range(n):
                p += 6; ac, = struct.unpack_from(">H", b, p); p += 2
                for ___ in range(ac):
                    ai, size = struct.unpack_from(">HI", b, p); p += 6
                    if not (0 < ai < count and cp[ai] and cp[ai][0] == 1 and p+size <= len(b)): return None
                    p += size
        ac, = struct.unpack_from(">H", b, p); p += 2
        for _ in range(ac):
            ai, size = struct.unpack_from(">HI", b, p); p += 6
            if not (0 < ai < count and cp[ai] and cp[ai][0] == 1 and p+size <= len(b)): return None
            p += size
        if p != len(b): return None
        return {"internal_name":name,"major":major,"minor":minor,"constant_pool_count":count,"size":len(b)}
    except (IndexError, struct.error, UnicodeDecodeError, ValueError): return None

def summarize_payloads(entries):
    data = [(i,b) for i,b in entries if is_hex(i.filename)]; sizes = [len(b) for _,b in data]
    pooled = {n:collections.Counter() for n in (64,1024,0)}
    for _,b in data:
        pooled[64].update(b[:64]); pooled[1024].update(b[:1024]); pooled[0].update(b)
    def counter_entropy(c):
        n=sum(c.values()); return -sum((v/n)*math.log2(v/n) for v in c.values())
    positions = {}
    for p in range(64):
        vals=[b[p] for _,b in data if len(b)>p]; c=collections.Counter(vals)
        positions[str(p)] = {"unique_values":len(c),"max_count":max(c.values()),"max_fraction":round(max(c.values())/len(data),6),"high_nibble_counts":dict(collections.Counter(str(v>>4) for v in vals)),"low_nibble_counts":dict(collections.Counter(str(v&15) for v in vals))}
    tail_positions = {}
    for p in range(1,65):
        vals=[b[-p] for _,b in data if len(b)>=p]; c=collections.Counter(vals)
        tail_positions[str(-p)] = {"unique_values":len(c),"max_count":max(c.values()),"max_fraction":round(max(c.values())/len(data),6),"high_nibble_counts":dict(collections.Counter(str(v>>4) for v in vals)),"low_nibble_counts":dict(collections.Counter(str(v&15) for v in vals))}
    hs = collections.defaultdict(list)
    for i,b in data: hs[hashlib.sha256(b).hexdigest()].append(i.filename)
    return {"count":len(data),"size_min":min(sizes),"size_median":statistics.median(sizes),"size_max":max(sizes),
        "multiples_of":{"2":sum(x%2==0 for x in sizes),"4":sum(x%4==0 for x in sizes),"8":sum(x%8==0 for x in sizes),"16":sum(x%16==0 for x in sizes),"32":sum(x%32==0 for x in sizes),"64":sum(x%64==0 for x in sizes)},
        "mean_entropy_bits_per_byte":{"first_64":round(statistics.mean(ent(b[:64]) for _,b in data),5),"first_1024":round(statistics.mean(ent(b[:min(1024,len(b))]) for _,b in data),5),"whole":round(statistics.mean(ent(b) for _,b in data),5)},
        "pooled_byte_entropy_bits_per_byte":{"first_64_bytes_per_payload":round(counter_entropy(pooled[64]),5),"first_1024_bytes_per_payload":round(counter_entropy(pooled[1024]),5),"all_payload_bytes":round(counter_entropy(pooled[0]),5)},
        "byte_positions_0_63":positions,"byte_positions_from_end":tail_positions,"prefix_unique_counts":{str(n):len(set(b[:n] for _,b in data if len(b)>=n)) for n in (2,4,8,16,32)},
        "within_jar_duplicate_content_groups":[[i.filename for i in v] for v in hs.values() if len(v)>1],"unique_sha256":len(hs),
        "compression_methods":dict(collections.Counter(i.compress_type for i,b in data)),"extra_fields":dict(collections.Counter(i.extra.hex() for i,b in data)),
        "archive_comments_nonempty":sum(bool(i.comment) for i,b in data),"name_extension_counts":dict(collections.Counter(os.path.splitext(i.filename)[1] for i,b in data))}

archives={}; byjar={}; files=[]
for jar in ("classes.jar","libs.jar"):
    with zipfile.ZipFile(os.path.join(ROOT,jar)) as z:
        infos=z.infolist(); entries=[(i,z.read(i)) for i in infos]
        archives[jar]={"zip_entries":len(infos),"archive_comment_bytes":len(z.comment),"payload":summarize_payloads(entries),"zip_structure":{"compression_methods":dict(collections.Counter(i.compress_type for i in infos)),"extra_fields":dict(collections.Counter(i.extra.hex() for i in infos)),"extra_lengths":dict(collections.Counter(len(i.extra) for i in infos)),"entry_comment_count":sum(bool(i.comment) for i in infos),"file_size_mod16_counts":dict(collections.Counter(i.file_size%16 for i in infos))}}
        nonhex=[i for i in infos if not is_hex(i.filename)]
        archives[jar]["catalog"]={"nonhex_entry_count":len(nonhex),"nonhex_extension_counts":dict(collections.Counter(os.path.splitext(i.filename)[1].lower() for i in nonhex)),"manifest_paths":[i.filename for i in infos if i.filename.lower()=="meta-inf/manifest.mf"],"top_level_nonhex_entries":[{"path":i.filename,"size":i.file_size} for i in nonhex if "/" not in i.filename][:200],"class_entries":sum(i.filename.lower().endswith(".class") for i in infos),"empty_class_entries":sum(i.filename.lower().endswith(".class") and i.file_size==0 for i in infos),"nonempty_class_entries":sum(i.filename.lower().endswith(".class") and i.file_size>0 for i in infos)}
        byjar[jar]={hashlib.sha256(b).hexdigest():{"name":i.filename,"size":len(b)} for i,b in entries if is_hex(i.filename)}
        files += [(jar,i.filename,b) for i,b in entries if is_hex(i.filename)]
common=set(byjar["classes.jar"]) & set(byjar["libs.jar"])
cross=[{"sha256":h,"size":byjar["classes.jar"][h]["size"],"classes_name":byjar["classes.jar"][h]["name"],"libs_name":byjar["libs.jar"][h]["name"]} for h in sorted(common)]

# Known-plaintext tests: each possible one-byte XOR key, all byte bit rotations,
# full/word reversals, and repeating XOR keys of lengths 2-4 implied by CAFEBABE.
# Full class parser is applied to every transformed candidate before recovery.
hits=[]; recovered=[]
def consider(jar, name, transform, transformed, detail):
    parsed=parse_class(transformed)
    if parsed:
        path=os.path.join(OUT,"recovered",jar+"-"+name+".class"); os.makedirs(os.path.dirname(path),exist_ok=True)
        with open(path,"wb") as f:f.write(transformed)
        recovered.append({"jar":jar,"payload":name,"transform":transform,"details":detail,"class":parsed,"recovered_path":os.path.relpath(path,OUT)})
for jar,name,b in files:
    # brute constant-XOR candidates at every offset in the first 64 bytes, then parse full candidates
    for off in range(min(64,len(b)-3)):
        k=b[off]^0xca
        if all((b[off+j]^k)==MAGICS["class"][j] for j in range(4)):
            x=bytes(v^k for v in b); hits.append({"jar":jar,"payload":name,"transform":"constant_xor","key":k,"offset":off,"magic":"cafebabe"}); consider(jar,name,"constant_xor",x,{"key":k,"offset":off})
    # byte rotations at offset zero (all 1..7 rotations and inverse direction)
    for direction in ("left","right"):
        for k in range(1,8):
            def rot(v): return ((v<<k)|(v>>(8-k)))&255 if direction=="left" else ((v>>k)|(v<<(8-k)))&255
            if bytes(rot(v) for v in b[:4])==MAGICS["class"]:
                x=bytes(rot(v) for v in b);hits.append({"jar":jar,"payload":name,"transform":"rotate_"+direction,"key":k,"offset":0,"magic":"cafebabe"});consider(jar,name,"rotate_"+direction,x,{"key":k})
    variants={"reverse_all":b[::-1]}
    for w in (2,4,8):
        if len(b)%w==0:
            variants["reverse_bytes_in_words_"+str(w)]=b"".join(b[p:p+w][::-1] for p in range(0,len(b),w))
            variants["reverse_word_order_"+str(w)]=b"".join(b[p:p+w] for p in range(0,len(b),w))[::-w] if False else b"".join([b[p:p+w] for p in range(0,len(b),w)][::-1])
    for typ,x in variants.items():
        if x[:4]==MAGICS["class"]:hits.append({"jar":jar,"payload":name,"transform":typ,"offset":0,"magic":"cafebabe"});consider(jar,name,typ,x,{})
# JIMAGE comparison reads only entries indexed by root analysis JSON and the unchanged local module images.
jimage_path=os.path.join(OUT,"jimage-index.json")
jimage={"index_present":os.path.exists(jimage_path)}
if os.path.exists(jimage_path):
    idx=json.load(open(jimage_path,encoding="utf-8")); jhex={}
    for rec in idx.get("entries",[]):
        base=rec.get("name","").rsplit("/",1)[-1]
        if is_hex(base): jhex[base]=rec
    for jar in ("classes.jar","libs.jar"):
        jar_names={name.rsplit("/",1)[-1]: h for h, name in ((h,x["name"]) for h,x in byjar[jar].items())}
        common_names=set(jar_names)&set(jhex)
        exact=[{"name":n,"jar_sha256":jar_names[n],"jimage_sha256":jhex[n].get("sha256"),"equal":jar_names[n]==jhex[n].get("sha256"),"jimage_size":jhex[n].get("uncompressed_size")} for n in sorted(common_names)]
        jimage.setdefault("matching_payloads",{})[jar]={"same_hex_basename_count":len(common_names),"exact_byte_match_count":sum(x["equal"] for x in exact),"examples":exact[:10]}
    for arch in ("win32","win64"):
        path=os.path.join(ROOT,arch,"java","lib","modules")
        counts=collections.Counter(); sizes=[]; entropies=[]; samples=[]
        with open(path,"rb") as f:
            for rec in idx.get("entries",[]):
                off=rec.get("offset"); size=rec.get("uncompressed_size",rec.get("size"))
                if off is None or size is None: continue
                f.seek(off); data=f.read(min(size,4096)); sizes.append(size)
                kind="hex_payload" if is_hex(rec.get("name","" ).rsplit("/",1)[-1]) and "/" in rec.get("name","") else "other"
                counts[kind]+=1
                if kind=="hex_payload" and data: entropies.append(ent(data));
                if kind=="other" and len(samples)<25: samples.append({"name":rec.get("name"),"size":size,"prefix":data[:16].hex()})
        jimage[arch]={"modules_sha256":hashlib.sha256(open(path,"rb").read()).hexdigest(),"indexed_entries":sum(counts.values()),"category_counts":dict(counts),"hex_payload_samples_entropy_mean_first4k":round(statistics.mean(entropies),5) if entropies else None,"other_entry_samples":samples}

result={"scope":"Read-only structural analysis of 32-hex ZIP payloads; simple transforms only; no executables launched","archives":archives,"exact_cross_jar_matches":cross,"simple_transform_magic_hits":hits,"validated_class_recoveries":recovered,"jimage_comparison":jimage}
with open(os.path.join(OUT,"payload-format.json"),"w",encoding="utf-8") as f:json.dump(result,f,indent=2,ensure_ascii=False)
print(json.dumps({"cross_jar_equal_payloads":len(cross),"simple_magic_hits":len(hits),"validated_classes":len(recovered),"jimage":{a:jimage.get(a,{}).get("category_counts") for a in ("win32","win64")}},ensure_ascii=False))
