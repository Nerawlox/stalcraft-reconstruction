"""Prepare a non-executed pre-2017 classpath with original resource companions.

The normalized archives are class-only. Preserve their bytes and old names for
startup research; named archives remain an analysis layer. Never starts Java.
"""
from pathlib import Path, PurePosixPath
import argparse
import hashlib
import json
import re
import shutil
import zipfile

from classfile_index import parse_class


EXPECTED = {
    'classes.jar': 'ced5409138b43c716e9fc20901a0c8dbf5e32218c2ed8448024a3bc612c4a61d',
    'libs.jar': '083923969de251021879359216b358c58a23e75e800d55e2e331b666dd56736a',
    'classes-standard.jar': '2760bda721101cc17b923b60ae185ee69f1d8545bebf579672e77e3a475a87fb',
    'libs-standard.jar': '7caf4aa0afd11f3815e580bcf34382dfacdd85d08b43bf81f463c119ec722284',
}


def sha(path):
    with path.open('rb') as stream:
        digest = hashlib.sha256()
        for chunk in iter(lambda: stream.read(1024 * 1024), b''):
            digest.update(chunk)
        return digest.hexdigest()


def resource_name(name):
    if '\\' in name or ':' in name or name.startswith('/') or '..' in PurePosixPath(name).parts:
        raise ValueError('Unsafe ZIP entry: ' + name)
    if name.endswith('/') or name.endswith('.class'):
        return False
    if re.fullmatch(r'[0-9a-fA-F]{32}', name):
        return False
    if re.fullmatch(r'META-INF/[^/]+\.(SF|RSA|DSA|EC)', name, re.IGNORECASE):
        raise ValueError('Signed resource archive requires separate review: ' + name)
    return True


def resource_companion(source, output):
    rows = []
    with zipfile.ZipFile(source) as original, zipfile.ZipFile(output, 'w', compression=zipfile.ZIP_DEFLATED) as companion:
        names = set()
        for entry in sorted(original.infolist(), key=lambda row: row.filename):
            if not resource_name(entry.filename):
                continue
            if entry.filename in names:
                raise ValueError('Duplicate resource: ' + entry.filename)
            names.add(entry.filename)
            data = original.read(entry)
            info = zipfile.ZipInfo(entry.filename, date_time=(1980, 1, 1, 0, 0, 0))
            info.compress_type = zipfile.ZIP_DEFLATED
            info.external_attr = 0o100644 << 16
            companion.writestr(info, data)
            rows.append({'path': entry.filename, 'bytes': len(data),
                         'sha256': hashlib.sha256(data).hexdigest()})
    with zipfile.ZipFile(output) as restored:
        if sorted(restored.namelist()) != sorted(row['path'] for row in rows):
            raise ValueError('Resource inventory changed')
        for row in rows:
            if hashlib.sha256(restored.read(row['path'])).hexdigest() != row['sha256']:
                raise ValueError('Restored resource differs from original: ' + row['path'])
    return rows


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--original', required=True, type=Path)
    parser.add_argument('--normalized', required=True, type=Path)
    parser.add_argument('--output', required=True, type=Path)
    parser.add_argument('--report', required=True, type=Path)
    args = parser.parse_args()
    sources = {name: (args.original if name in ('classes.jar', 'libs.jar') else args.normalized) / name for name in EXPECTED}
    destination = args.output.resolve()
    if destination.exists() or args.report.exists():
        raise ValueError('Output directory and report must both be new')
    source_directories = [args.original.resolve(), args.normalized.resolve()]
    if any(destination == source or source in destination.parents or destination in source.parents for source in source_directories):
        raise ValueError('Output must be separate from original and normalized directories')
    report_path = args.report.resolve()
    if report_path in {path.resolve() for path in sources.values()} or destination == report_path:
        raise ValueError('Report overlaps an input/output')
    if any(report_path == source or source in report_path.parents for source in source_directories):
        raise ValueError('Report cannot be written inside original/normalized inputs')
    for name, path in sources.items():
        if sha(path) != EXPECTED[name]:
            raise ValueError('Input SHA-256 mismatch: ' + name)
    destination.mkdir(parents=True)
    resources = []
    copied = []
    for stem in ('classes', 'libs'):
        normalized = sources[stem + '-standard.jar']
        target = destination / normalized.name
        shutil.copyfile(normalized, target)
        if sha(target) != EXPECTED[target.name]:
            raise ValueError('Copied class archive changed')
        count = 0
        with zipfile.ZipFile(target) as archive:
            for entry in archive.infolist():
                if not entry.filename.endswith('.class'):
                    raise ValueError('Unexpected entry in normalized archive: ' + entry.filename)
                info = parse_class(archive.read(entry))
                if info.name + '.class' != entry.filename:
                    raise ValueError('Class identity differs from path')
                count += 1
        copied.append({'path': str(target), 'sha256': sha(target), 'classes': count})
        original = sources[stem + '.jar']
        companion = destination / (stem + '-resources.jar')
        entries = resource_companion(original, companion)
        resources.append({'source': str(original), 'source_sha256': sha(original),
                          'output': str(companion), 'output_sha256': sha(companion),
                          'resource_count': len(entries), 'bytes': sum(row['bytes'] for row in entries),
                          'files': entries})
    critical = ['fmlversion.properties', 'mcmod.info', 'forge_at.cfg', 'fml_at.cfg',
                'deobfuscation_data-1.6.4.lzma']
    resource_paths = {row['path'] for group in resources for row in group['files']}
    report = {'scope': 'Non-executed classpath preparation; no complete runtime, launcher, server or game test',
              'inputs': [{'path': str(path), 'sha256': EXPECTED[name]} for name, path in sources.items()],
              'class_archives': copied, 'resource_archives': resources,
              'resource_checks': {name: name in resource_paths for name in critical},
              'classpath_order': [str(destination / name) for name in
                                  ['classes-standard.jar', 'libs-standard.jar', 'classes-resources.jar', 'libs-resources.jar']],
              'not_ready': ['Exported LaunchClassLoader needs adaptation for ordinary Java.',
                            'Native dependencies are untested; DLL resources are preserved but not loaded.',
                            'External modassets/game configuration are not copied into this preparation.',
                            'Reflection and ASM strings retain original names; named bytecode is not used.']}
    (destination / 'classpath.json').write_text(json.dumps({'classpath_order': report['classpath_order'],
                                                          'scope': report['scope']}, indent=2) + '\n', encoding='utf-8')
    args.report.parent.mkdir(parents=True, exist_ok=True)
    args.report.write_text(json.dumps(report, indent=2) + '\n', encoding='utf-8')
    print(json.dumps({'classes': sum(row['classes'] for row in copied),
                      'resources': sum(row['resource_count'] for row in resources),
                      'resource_bytes': sum(row['bytes'] for row in resources),
                      'resource_checks': report['resource_checks'], 'output': str(destination)}))


if __name__ == '__main__':
    main()
