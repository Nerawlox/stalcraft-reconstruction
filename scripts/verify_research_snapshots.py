"""Verify preserved decompiler and research snapshots without running client code."""
from pathlib import Path
import hashlib
import json
import subprocess
import sys

ROOT = Path(__file__).resolve().parents[1]
subprocess.run([sys.executable, str(ROOT / 'scripts' / 'verify_snapshot.py')], check=True)
build = ROOT / 'builds' / 'pre-2017'
manifest = json.loads((build / 'import-sha256.json').read_text(encoding='utf-8'))
errors = []
for row in manifest['files']:
    path = (ROOT / row['path']).resolve()
    if not path.is_relative_to(ROOT.resolve()):
        errors.append('Invalid path: ' + row['path'])
    elif not path.is_file():
        errors.append('Missing: ' + row['path'])
    elif hashlib.sha256(path.read_bytes()).hexdigest() != row['sha256']:
        errors.append('Changed: ' + row['path'])
source_manifest = json.loads((build / 'analysis' / 'decompiled-source-sha256.json').read_text(encoding='utf-8'))
for row in source_manifest['files']:
    path = build / row['path']
    if not path.is_file() or hashlib.sha256(path.read_bytes()).hexdigest() != row['sha256']:
        errors.append('CFR snapshot mismatch: ' + row['path'])
expected = {row['path'] for row in source_manifest['files'] if row['path'].endswith('.java')}
actual = {path.relative_to(build).as_posix() for path in (build / 'decompiled-standard').rglob('*.java')}
if actual != expected:
    errors.append('CFR Java file inventory mismatch')
if errors:
    print('\n'.join(errors))
    raise SystemExit(1)
print('Pre-2017 snapshot verified:', len(manifest['files']), 'imported text files;', len(actual), 'CFR Java sources')
