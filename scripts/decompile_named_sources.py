"""Run pinned CFR on validated renamed bytecode without executing game classes."""
from pathlib import Path
import argparse
import hashlib
import json
import subprocess
import time


def sha(path):
    return hashlib.sha256(path.read_bytes()).hexdigest()


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--java', required=True, type=Path)
    parser.add_argument('--cfr', required=True, type=Path)
    parser.add_argument('--validation', required=True, type=Path)
    parser.add_argument('--jimage', required=True, type=Path)
    parser.add_argument('--output', required=True, type=Path)
    parser.add_argument('--logs', required=True, type=Path)
    parser.add_argument('--report', required=True, type=Path)
    parser.add_argument('--heap-mib', type=int, default=1536)
    args = parser.parse_args()
    expected = 'f686e8f3ded377d7bc87d216a90e9e9512df4156e75b06c655a16648ae8765b2'
    if sha(args.cfr) != expected:
        raise ValueError('CFR binary differs from the verified 0.152 tool')
    proof = json.loads(args.validation.read_text(encoding='utf-8'))
    jars = {}
    for archive in proof['archives']:
        path = Path(archive['output'])
        if sha(path) != archive['output_sha256']:
            raise ValueError('Named input SHA-256 mismatch')
        jars[path.name] = path.resolve()
    if args.output.exists() and any(args.output.iterdir()):
        raise ValueError('Refusing to overwrite an existing source directory')
    args.output.mkdir(parents=True, exist_ok=True)
    args.logs.mkdir(parents=True, exist_ok=True)
    if not 128 <= args.heap_mib <= 2048:
        raise ValueError('Heap limit must be between 128 and 2048 MiB')
    command = [str(args.java.resolve()), '-Xmx' + str(args.heap_mib) + 'm', '-jar', str(args.cfr.resolve()),
               str(jars['classes-named.jar']), '--extraclasspath',
               str(jars['libs-named.jar']) + ';' + str(args.jimage.resolve()),
               '--outputdir', str(args.output.resolve()), '--silent', 'true', '--outputencoding', 'UTF-8']
    start = time.monotonic()
    with (args.logs / 'cfr-named.stdout.log').open('w', encoding='utf-8') as stdout, (args.logs / 'cfr-named.stderr.log').open('w', encoding='utf-8') as stderr:
        result = subprocess.run(command, stdout=stdout, stderr=stderr, creationflags=subprocess.CREATE_NO_WINDOW)
    rows = [{'path': path.relative_to(args.output).as_posix(), 'sha256': sha(path)}
            for path in sorted(args.output.rglob('*')) if path.is_file()]
    report = {'command': command, 'cfr_sha256': expected, 'exit_code': result.returncode,
              'elapsed_seconds': round(time.monotonic() - start, 2),
              'java_files': sum(row['path'].endswith('.java') for row in rows),
              'scope': 'Fresh named research source tree; no compilation or game execution', 'files': rows}
    args.report.parent.mkdir(parents=True, exist_ok=True)
    args.report.write_text(json.dumps(report, indent=2) + '\n', encoding='utf-8')
    print(json.dumps({key: value for key, value in report.items() if key != 'files'}), flush=True)
    if result.returncode:
        raise SystemExit(result.returncode)


if __name__ == '__main__':
    main()
