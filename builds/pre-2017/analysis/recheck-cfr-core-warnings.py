"""Alternate static decompilation for six game classes with CFR flow warnings."""
from pathlib import Path
import hashlib,json,subprocess,time,zipfile
A=Path(__file__).resolve().parent;B=A.parent
JAVA=Path(r'E:\Stalcraft project\stalcraft-decompiled\.cache\runtime\java\bin\java.exe')
tool=A/'decompiler-tools/procyon-decompiler-0.6.0.jar'
expected='821da96012fc69244fa1ea298c90455ee4e021434bc796d3b9546ab24601b779'
if hashlib.sha256(tool.read_bytes()).hexdigest()!=expected:raise ValueError('Procyon checksum mismatch')
warnings=json.loads((A/'cfr-classes-warnings.json').read_text(encoding='utf-8'))
targets=[x.removeprefix('decompiled-standard/classes/').removesuffix('.java') for x in warnings['Unable to fully structure code']]
input_jar=A/'decompiler-tools/cfr-core-warnings-input.jar';names=[]
with zipfile.ZipFile(B/'recovered-bytecode/classes-standard.jar') as src,zipfile.ZipFile(input_jar,'w',compression=zipfile.ZIP_DEFLATED) as dst:
    for name in src.namelist():
        if any(name==t+'.class' or name.startswith(t+'$') for t in targets):
            dst.writestr(name,src.read(name));names.append(name)
out=B/'decompiled-alternatives/procyon-core';out.mkdir(parents=True,exist_ok=True)
cmd=[str(JAVA),'-Xmx512m','-jar',str(tool),'-jar',str(input_jar),'-o',str(out)]
start=time.monotonic()
with (A/'procyon-core-recheck-stdout.log').open('w',encoding='utf-8') as stdout,(A/'procyon-core-recheck-stderr.log').open('w',encoding='utf-8') as stderr:
    result=subprocess.run(cmd,cwd=B,stdout=stdout,stderr=stderr,creationflags=subprocess.CREATE_NO_WINDOW,timeout=180)
sources=[]
for p in out.rglob('*.java'):
    text=p.read_text(encoding='utf-8');sources.append(dict(path=str(p.relative_to(B)),bytes=p.stat().st_size,
        sha256=hashlib.sha256(p.read_bytes()).hexdigest(),decompilation_error_markers=[s for s in ['could not be decompiled','An error occurred','This method could not'] if s.lower() in text.lower()]))
r=dict(scope='alternate decompiler only; input classes never executed; CFR snapshot unchanged',
    input_class_count=len(names),input_classes=names,command=cmd,exit_code=result.returncode,
    elapsed_seconds=round(time.monotonic()-start,2),sources=sources)
(A/'procyon-core-recheck.json').write_text(json.dumps(r,ensure_ascii=False,indent=2),encoding='utf-8')
print(json.dumps(dict(exit_code=result.returncode,input_class_count=len(names),source_count=len(sources),
    files_with_error_markers=sum(bool(s['decompilation_error_markers']) for s in sources),elapsed_seconds=r['elapsed_seconds'])))
