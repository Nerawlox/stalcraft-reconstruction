"""Run verified CFR on normalized bytecode without executing recovered code."""
from pathlib import Path
import argparse,hashlib,json,subprocess,time
A=Path(__file__).resolve().parent;B=A.parent
CFR=Path(r'C:\Users\drgoo\Documents\Codex\2026-10-03\new-chat\work\tools\cfr-0.152.jar')
JAVA=Path(r'E:\Stalcraft project\stalcraft-decompiled\.cache\runtime\java\bin\java.exe')
EXPECTED='f686e8f3ded377d7bc87d216a90e9e9512df4156e75b06c655a16648ae8765b2'
parser=argparse.ArgumentParser(description=__doc__)
parser.add_argument('--source',choices=['classes','libs'],default='classes')
args=parser.parse_args();source=args.source
if hashlib.sha256(CFR.read_bytes()).hexdigest()!=EXPECTED:raise ValueError('Unverified CFR binary')
jar=B/'recovered-bytecode'/(source+'-standard.jar')
proof=json.loads((B/'recovered-bytecode'/(source+'-opcode-normalization.json')).read_text(encoding='utf-8'))
if proof['failure_count'] or hashlib.sha256(jar.read_bytes()).hexdigest()!=proof['output_sha256']:
    raise ValueError('Normalized bytecode validation/hash mismatch')
out=B/'decompiled-standard'/source;out.mkdir(parents=True,exist_ok=True)
others=['libs','jimage'] if source=='classes' else ['classes','jimage']
extra=';'.join(str(B/'recovered-bytecode'/(x+'-standard.jar')) for x in others)
cmd=[str(JAVA),'-Xmx2g','-jar',str(CFR),str(jar),'--extraclasspath',extra,
    '--outputdir',str(out),'--silent','true','--outputencoding','UTF-8']
start=time.monotonic()
with (A/('cfr-standard-'+source+'-stdout.log')).open('w',encoding='utf-8') as stdout, (A/('cfr-standard-'+source+'-stderr.log')).open('w',encoding='utf-8') as stderr:
    result=subprocess.run(cmd,cwd=B,stdout=stdout,stderr=stderr,creationflags=subprocess.CREATE_NO_WINDOW)
r=dict(command=cmd,cfr_sha256=EXPECTED,input_sha256=proof['output_sha256'],
    input_class_count=proof['standard_class_count'],exit_code=result.returncode,
    elapsed_seconds=round(time.monotonic()-start,2),java_source_count=sum(1 for p in out.rglob('*.java')),
    scope='trusted CFR static decompilation; recovered classes not executed',output=str(out))
(A/('cfr-standard-'+source+'-result.json')).write_text(json.dumps(r,ensure_ascii=False,indent=2),encoding='utf-8')
print(json.dumps(r,ensure_ascii=False),flush=True)
if result.returncode:raise SystemExit(result.returncode)
