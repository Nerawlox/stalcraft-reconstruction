"""Alternate static decompilation of the three CFR-failing library families."""
from pathlib import Path
import hashlib,json,subprocess,time,zipfile,sys
A=Path(__file__).resolve().parent;B=A.parent
JAVA=Path(r'E:\Stalcraft project\stalcraft-decompiled\.cache\runtime\java\bin\java.exe')
tool=A/'decompiler-tools/procyon-decompiler-0.6.0.jar'
expected='821da96012fc69244fa1ea298c90455ee4e021434bc796d3b9546ab24601b779'
if hashlib.sha256(tool.read_bytes()).hexdigest()!=expected:raise ValueError('Procyon checksum mismatch')
targets=['com/google/common/util/concurrent/Futures','org/lwjgl/opengl/LinuxCanvasImplementation','org/lwjgl/opengl/LinuxDisplay']
all_warnings='--all-warnings' in sys.argv
label='library-warnings' if all_warnings else 'library-recheck'
if all_warnings:
    warnings=json.loads((A/'cfr-libs-warnings.json').read_text(encoding='utf-8'))
    targets=sorted({p.removeprefix('decompiled-standard/libs/').removesuffix('.java') for paths in warnings.values() for p in paths})
input_jar=A/'decompiler-tools'/('cfr-'+label+'-input.jar');names=[]
with zipfile.ZipFile(B/'recovered-bytecode/libs-standard.jar') as src,zipfile.ZipFile(input_jar,'w',compression=zipfile.ZIP_DEFLATED) as dst:
    for name in src.namelist():
        if any(name==t+'.class' or name.startswith(t+'$') for t in targets):
            dst.writestr(name,src.read(name));names.append(name)
out=B/'decompiled-alternatives'/('procyon-libs-warnings' if all_warnings else 'procyon-libs');out.mkdir(parents=True,exist_ok=True)
cmd=[str(JAVA),'-Xmx512m','-jar',str(tool),'-jar',str(input_jar),'-o',str(out)]
start=time.monotonic()
with (A/('procyon-'+label+'-stdout.log')).open('w',encoding='utf-8') as stdout,(A/('procyon-'+label+'-stderr.log')).open('w',encoding='utf-8') as stderr:
    result=subprocess.run(cmd,cwd=B,stdout=stdout,stderr=stderr,creationflags=subprocess.CREATE_NO_WINDOW,timeout=180)
sources=[]
for p in out.rglob('*.java'):
    text=p.read_text(encoding='utf-8');sources.append(dict(path=str(p.relative_to(B)),bytes=p.stat().st_size,
        sha256=hashlib.sha256(p.read_bytes()).hexdigest(),decompilation_error_markers=[s for s in ['could not be decompiled','An error occurred','This method could not'] if s.lower() in text.lower()]))
r=dict(scope='alternate decompiler only; input library classes never executed; CFR snapshot unchanged',
    tool_sha256=expected,input_class_count=len(names),input_classes=names,command=cmd,
    exit_code=result.returncode,elapsed_seconds=round(time.monotonic()-start,2),sources=sources)
(A/('procyon-'+label+'.json')).write_text(json.dumps(r,ensure_ascii=False,indent=2),encoding='utf-8')
print(json.dumps({k:v for k,v in r.items() if k not in ('sources','input_classes')},ensure_ascii=False))
print(json.dumps(dict(source_count=len(sources),files_with_error_markers=sum(bool(s['decompilation_error_markers']) for s in sources))))
