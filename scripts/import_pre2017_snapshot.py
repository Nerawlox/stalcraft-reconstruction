"""Copy research text into Git without modifying the original build or snapshots."""
from pathlib import Path
import argparse
import hashlib
import json
import shutil

ROOT = Path(__file__).resolve().parents[1]
parser = argparse.ArgumentParser(description=__doc__)
parser.add_argument('--source', type=Path, required=True)
parser.add_argument('--research', type=Path, required=True)
args = parser.parse_args()
source = args.source.resolve()
target = ROOT / 'builds' / 'pre-2017'
rows = []

def copy_file(original, destination):
    data = original.read_bytes()
    digest = hashlib.sha256(data).hexdigest()
    if destination.exists() and destination.read_bytes() != data:
        raise ValueError('Refusing to overwrite changed file: ' + str(destination))
    destination.parent.mkdir(parents=True, exist_ok=True)
    if not destination.exists():
        shutil.copyfile(original, destination)
    if hashlib.sha256(destination.read_bytes()).hexdigest() != digest:
        raise ValueError('Copy hash mismatch: ' + str(destination))
    rows.append({'path': destination.relative_to(ROOT).as_posix(),
                 'bytes': len(data), 'sha256': digest})

for directory in ('decompiled-standard', 'decompiled-alternatives'):
    for path in sorted((source / directory).rglob('*')):
        if path.is_file() and path.suffix in ('.java', '.txt'):
            copy_file(path, target / path.relative_to(source))

text_types = {'.md', '.json', '.py', '.txt', '.asm', '.c', '.srg', '.hpp', '.log'}
for path in sorted((source / 'analysis').iterdir()):
    if path.is_file() and path.suffix in text_types:
        copy_file(path, target / 'analysis' / path.name)
for path in sorted((source / 'analysis' / 'decompiler-tools').glob('*.json')):
    copy_file(path, target / 'analysis' / 'decompiler-tools' / path.name)
for path in sorted((source / 'recovered-bytecode').glob('*.json')):
    copy_file(path, target / 'recovered-bytecode' / path.name)
copy_file(source / 'README.md', target / 'analysis' / 'local-workspace-readme.md')
for path in sorted(args.research.resolve().iterdir()):
    if path.is_file() and path.suffix in {'.md', '.py', '.json'}:
        copy_file(path, ROOT / 'research' / '2016-2017-search-2026-10-03' / path.name)

manifest = {'description': 'Exact text snapshot imported on 2026-10-04; historical reports may contain local paths and superseded conclusions.',
            'source_directory': str(source), 'files': rows}
(target / 'import-sha256.json').write_text(
    json.dumps(manifest, ensure_ascii=False, indent=2) + '\n', encoding='utf-8')
print(json.dumps({'files': len(rows), 'bytes': sum(row['bytes'] for row in rows),
                  'java_files': sum(row['path'].endswith('.java') for row in rows)}, ensure_ascii=False))
