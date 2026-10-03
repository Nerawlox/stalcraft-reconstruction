"""Compare candidate resources with the original Alex mod without modifying either."""
import collections, hashlib, json, zipfile
from pathlib import Path
project=Path(r'E:\Stalcraft project')
out=project/'builds'/'stalcraft-pre-vk-2017-candidate'/'analysis'
base=project/'Сборка STALKRAFT от Алекса'/'Моды'/'stalker_client212.jar'
candidate=project/'stalcraft_pre'/'stalcraft'/'modassets'
records=[]
def sh(raw): return hashlib.sha256(raw).hexdigest()
with zipfile.ZipFile(base) as jar:
    entries=[e for e in jar.infolist() if e.filename.startswith('assets/') and not e.is_dir()]
    for entry in entries:
        matches=[]
        exact=candidate/entry.filename
        if exact.is_file(): matches.append(exact)
        p=Path(entry.filename)
        if p.suffix.lower() == '.png':
            alternative=candidate/p.with_suffix('.mic')
            if alternative.is_file(): matches.append(alternative)
        if p.suffix.lower() == '.mic':
            alternative=candidate/p.with_suffix('.png')
            if alternative.is_file(): matches.append(alternative)
        if not matches: continue
        original=jar.read(entry)
        for path in matches:
            new=path.read_bytes()
            pnglike=len(original)>16 and len(new)>16 and original[12:16]==b'IHDR' and new[12:16]==b'IHDR'
            records.append({'baseline':entry.filename,'candidate':path.relative_to(candidate).as_posix(),'baseline_size':len(original),'candidate_size':len(new),'exact_bytes':original==new,'png_body_identical':bool(pnglike and original[8:]==new[8:]),'baseline_sha256':sh(original),'candidate_sha256':sh(new)})
    baseline_count=len(entries)
result={'baseline_jar':str(base),'candidate_modassets':str(candidate),'method':'Match exact assets-relative paths, also png/mic extension alternatives. Compare complete bytes and, for PNG-like payloads with IHDR at offset12, bytes after signature. Does not prove common code or date.','baseline_resource_entries':baseline_count,'matched_pairs':len(records),'exact_identical_pairs':sum(r['exact_bytes'] for r in records),'png_body_identical_pairs':sum(r['png_body_identical'] for r in records),'matched_extensions':dict(collections.Counter(Path(r['candidate']).suffix for r in records)),'pairs':records}
(out/'alex-resource-comparison.json').write_text(json.dumps(result,ensure_ascii=False,indent=2),encoding='utf-8')
print(json.dumps({k:v for k,v in result.items() if k!='pairs'},ensure_ascii=False,indent=2))
