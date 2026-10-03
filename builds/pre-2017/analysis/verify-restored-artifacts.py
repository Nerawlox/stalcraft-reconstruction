"""Read-only original checks and hashes for the recovered source snapshot."""
from pathlib import Path
import ast,hashlib,json,xml.etree.ElementTree as ET
A=Path(__file__).resolve().parent;B=A.parent
def sha(path):
    h=hashlib.sha256()
    with path.open('rb') as f:
        for chunk in iter(lambda:f.read(1024*1024),b''):h.update(chunk)
    return h.hexdigest()
original=Path(r'E:\Stalcraft project\stalcraft_pre\stalcraft')
expected={
    'classes.jar':'ced5409138b43c716e9fc20901a0c8dbf5e32218c2ed8448024a3bc612c4a61d',
    'libs.jar':'083923969de251021879359216b358c58a23e75e800d55e2e331b666dd56736a',
    'win64/java/lib/modules':'b05051c562bec55a2d904d27629aaaff88a7259174e833cd2cf679c57e75809c'}
original_checks={name:sha(original/name)==value for name,value in expected.items()}
if not all(original_checks.values()):raise ValueError('Original input hash changed')
for source in ['classes','libs','jimage']:
    r=json.loads((B/'recovered-bytecode'/(source+'-opcode-normalization.json')).read_text(encoding='utf-8'))
    if r['failure_count'] or sha(Path(r['output']))!=r['output_sha256']:
        raise ValueError('Normalized output check failed')
for source in ['classes','libs']:
    r=json.loads((A/('cfr-standard-'+source+'-result.json')).read_text(encoding='utf-8'))
    if r['exit_code']:raise ValueError('CFR failed')
for p in (B/'ide-project').rglob('*.xml'):ET.parse(p)
ET.parse(B/'ide-project/research.iml')
json.loads((B/'stalcraft-2017.code-workspace').read_text(encoding='utf-8'))
for file in ['recover-protected-classes.py','extract-opcode-map.py','normalize-class-opcodes.py','decompile-restored.py']:
    ast.parse((A/file).read_text(encoding='utf-8'),filename=file)
rows=[]
for p in sorted((B/'decompiled-standard').rglob('*')):
    if p.is_file() and p.suffix in ('.java','.txt'):
        rows.append(dict(path=p.relative_to(B).as_posix(),bytes=p.stat().st_size,sha256=sha(p)))
manifest=dict(scope='immutable raw CFR snapshot; keep future rebuild edits separate',
    original_inputs_unchanged=original_checks,java_file_count=sum(r['path'].endswith('.java') for r in rows),
    ide_configuration_parsed=True,files=rows)
(A/'decompiled-source-sha256.json').write_text(json.dumps(manifest,ensure_ascii=False,indent=2),encoding='utf-8')
print(json.dumps({k:v for k,v in manifest.items() if k!='files'},ensure_ascii=False))
