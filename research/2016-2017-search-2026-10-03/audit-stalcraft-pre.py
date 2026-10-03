"""Static read-only inventory of the user-provided STALCRAFT package."""
import collections, datetime, hashlib, json, struct, zipfile
from pathlib import Path

project = Path(r'E:\Stalcraft project')
source = project / 'stalcraft_pre'
archive = project / 'stalcraft_pre.rar'
out = project / 'builds' / 'stalcraft-pre-vk-2017-candidate' / 'analysis'
out.mkdir(parents=True, exist_ok=True)

def digest(path):
    h = hashlib.sha256()
    with path.open('rb') as stream:
        for block in iter(lambda: stream.read(4*1024*1024), b''):
            h.update(block)
    return h.hexdigest()

note = (source/'ПРОЧИТАЙ.txt').read_bytes()
decoded = note.decode('cp1251')
(out/'provided-readme.txt').write_text(decoded, encoding='utf-8')
inventory = []
for i,path in enumerate(sorted(source.rglob('*'))):
    if not path.is_file(): continue
    st = path.stat()
    inventory.append({'path':path.relative_to(source).as_posix(), 'size':st.st_size, 'mtime_utc':datetime.datetime.fromtimestamp(st.st_mtime, datetime.timezone.utc).isoformat(), 'sha256':digest(path)})
    if len(inventory)%3000 == 0: print(f'Hashed {len(inventory)} files',flush=True)
(out/'file-inventory.json').write_text(json.dumps(inventory, ensure_ascii=False, indent=2), encoding='utf-8')
print(f'Inventory complete: {len(inventory)} files',flush=True)

jars = {}
for filename in ['classes.jar','libs.jar']:
    path = source/'stalcraft'/filename
    with zipfile.ZipFile(path) as jar:
        entries = jar.infolist()
        classes = [e for e in entries if e.filename.endswith('.class')]
        packages = collections.Counter('/'.join(e.filename.split('/')[:2]) for e in classes)
        dates = collections.Counter('-'.join(map(lambda n:f'{n:02}', e.date_time[:2])) for e in classes)
        versions = collections.Counter()
        bad_magic = []
        names = []
        for entry in classes:
            with jar.open(entry) as stream: header=stream.read(8)
            if header[:4] == bytes.fromhex('cafebabe'):
                versions[str(struct.unpack('>H',header[6:8])[0])] += 1
            else: bad_magic.append({'path':entry.filename,'header':header.hex()})
            names.append(entry.filename)
        metadata = {}
        for entry in entries:
            lower = entry.filename.lower()
            if entry.file_size<65536 and (lower in ['meta-inf/manifest.mf','mcmod.info','version.json','pack.mcmeta'] or lower.endswith('/pom.properties')):
                metadata[entry.filename] = jar.read(entry).decode('utf-8','replace')
        jars[filename]={'size':path.stat().st_size,'sha256':digest(path),'zip_entries':len(entries),'class_count':len(classes),'class_major_versions':dict(versions),'bad_class_magic':bad_magic,'top_package_prefixes':packages.most_common(40),'class_zip_months':dates.most_common(30),'metadata':metadata}
        (out/(filename+'.entries.json')).write_text(json.dumps([{'path':e.filename,'size':e.file_size,'compressed_size':e.compress_size,'zip_datetime':list(e.date_time),'crc32':f'{e.CRC:08x}'} for e in entries],ensure_ascii=False,indent=2),encoding='utf-8')
        (out/(filename+'.class-names.txt')).write_text('\n'.join(names),encoding='utf-8')
        print(filename,json.dumps({k:v for k,v in jars[filename].items() if k not in ['metadata','top_package_prefixes','bad_class_magic']},ensure_ascii=False),flush=True)
(out/'jar-summary.json').write_text(json.dumps(jars,ensure_ascii=False,indent=2),encoding='utf-8')
provenance={'id':'stalcraft-pre-vk-2017-candidate','provided_by':'user','source_post':'https://vk.com/wall-2677092_317761','source_claim':'User reports downloading from an official VK group; official origin and exact downloadable attachment URL not independently verified.','input_directory':str(source),'archive_path':str(archive),'received_at_utc':datetime.datetime.now(datetime.timezone.utc).isoformat(),'executed':False,'input_modified':False,'provided_readme_encoding':'cp1251','provided_readme_text':decoded,'directory_file_count':len(inventory),'directory_total_size':sum(e['size'] for e in inventory)}
if archive.is_file():
    print('Hashing original RAR',flush=True)
    provenance['archive_size']=archive.stat().st_size
    provenance['archive_sha256']=digest(archive)
(out/'provenance.json').write_text(json.dumps(provenance,ensure_ascii=False,indent=2),encoding='utf-8')
extensions=collections.Counter(Path(e['path']).suffix.lower() or '(none)' for e in inventory)
summary={'file_count':len(inventory),'total_size':sum(e['size'] for e in inventory),'extensions':extensions.most_common(40),'readme':decoded,'jar_summaries':jars,'archive_sha256':provenance.get('archive_sha256')}
(out/'summary.json').write_text(json.dumps(summary,ensure_ascii=False,indent=2),encoding='utf-8')
print(json.dumps({k:v for k,v in summary.items() if k!='jar_summaries'},ensure_ascii=False,indent=2),flush=True)
