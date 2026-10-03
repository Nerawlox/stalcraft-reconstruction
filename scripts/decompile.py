"""Statically decompile a mod JAR; never execute the input mod."""
import argparse
import hashlib
import pathlib
import subprocess
import zipfile

ROOT = pathlib.Path(__file__).resolve().parents[1]
parser = argparse.ArgumentParser(description=__doc__)
parser.add_argument('--input', required=True, type=pathlib.Path)
parser.add_argument('--java', required=True, type=pathlib.Path)
parser.add_argument('--cfr', required=True, type=pathlib.Path)
parser.add_argument('--output', type=pathlib.Path, default=ROOT / '.cache' / 'redecompiled')
args = parser.parse_args()
for path in (args.input, args.java, args.cfr):
    if not path.is_file():
        parser.error('File not found: ' + str(path))
expected_cfr_sha256 = 'f686e8f3ded377d7bc87d216a90e9e9512df4156e75b06c655a16648ae8765b2'
if hashlib.sha256(args.cfr.read_bytes()).hexdigest() != expected_cfr_sha256:
    parser.error('Expected the verified CFR 0.152 binary; checksum differs')
cache = ROOT / '.cache'
cache.mkdir(exist_ok=True)
thin = cache / 'decompiler-input.jar'
count = 0
with zipfile.ZipFile(args.input) as source, zipfile.ZipFile(thin, 'w', compression=zipfile.ZIP_DEFLATED) as target:
    for item in source.infolist():
        if not item.filename.endswith('.class'):
            continue
        name = pathlib.PurePosixPath(item.filename)
        if name.is_absolute() or '..' in name.parts or '\\' in item.filename:
            parser.error('Unexpected archive path: ' + item.filename)
        target.writestr(item.filename, source.read(item))
        count += 1
print('Input classes:', count, flush=True)
args.output.mkdir(parents=True, exist_ok=True)
command = [str(args.java.resolve()), '-Xmx2g', '-jar', str(args.cfr.resolve()),
           str(thin), '--outputdir', str(args.output.resolve()),
           '--silent', 'true', '--outputencoding', 'UTF-8']
subprocess.run(command, cwd=ROOT, check=True)
print('Decompiled sources:', args.output.resolve())
