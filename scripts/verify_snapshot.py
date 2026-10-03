"""Check the original decompiler snapshot without running Java or game code."""
import hashlib
import json
import pathlib
import sys

ROOT = pathlib.Path(__file__).resolve().parents[1]
manifest = json.loads((ROOT / 'snapshot-sha256.json').read_text(encoding='utf-8'))
errors = []
for name, expected in manifest['files'].items():
    path = ROOT / name
    if not path.is_file():
        errors.append('Missing: ' + name)
    elif hashlib.sha256(path.read_bytes()).hexdigest() != expected:
        errors.append('Changed: ' + name)
expected_sources = {name for name in manifest['files'] if name.startswith('src/')}
actual_sources = {p.relative_to(ROOT).as_posix() for p in (ROOT / 'src').rglob('*.java')}
errors.extend('Additional source: ' + name for name in sorted(actual_sources - expected_sources))
if errors:
    print('\n'.join(errors))
    sys.exit(1)
print('Original snapshot verified:', len(manifest['files']), 'files;', len(expected_sources), 'Java sources')
