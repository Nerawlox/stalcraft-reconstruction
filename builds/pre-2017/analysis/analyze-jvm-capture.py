"""Convert an existing own-child RVA-layout snapshot for static analysis only.

Does not load or execute the captured DLL. Output is not a repaired runnable PE.
"""
from pathlib import Path
import argparse, hashlib, json, math, re, struct, sys
from collections import Counter

HERE = Path(__file__).resolve().parent
sys.path.insert(0, str(HERE / 'python-tools'))
import pefile


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--result', type=Path, default=HERE / 'watcher-run2-result.json')
    parser.add_argument('--output', type=Path, default=HERE / 'dynamic-capture' / 'regenerated')
    args = parser.parse_args()
    result = json.loads(args.result.read_text(encoding='utf-8'))
    capture = result['capture']
    data = Path(capture['path']).read_bytes()
    if len(data) != capture['size'] or hashlib.sha256(data).hexdigest() != capture['sha256']:
        raise ValueError('Snapshot length or SHA-256 differs from its capture record')
    if capture.get('memory_holes'):
        raise ValueError('Incomplete snapshot; inspect memory holes before using this converter')
    pe = pefile.PE(data=data, fast_load=True)
    if pe.OPTIONAL_HEADER.Magic != 0x20b or pe.OPTIONAL_HEADER.SizeOfImage != len(data):
        raise ValueError('Expected complete x64 mapped image')
    view = bytearray(data)
    image_base_offset = pe.OPTIONAL_HEADER.get_field_absolute_offset('ImageBase')
    struct.pack_into('<Q', view, image_base_offset, capture['image_base'])
    sections = []
    for sec in pe.sections:
        rva, size = sec.VirtualAddress, sec.Misc_VirtualSize
        if rva + size > len(data):
            raise ValueError('Section extends outside the capture')
        part = data[rva:rva + size]
        counts = Counter(part)
        entropy = -sum((n / len(part)) * math.log2(n / len(part)) for n in counts.values()) if part else 0
        sections.append(dict(name=sec.Name.rstrip(b'\0').decode('ascii'), rva=rva,
                             size=size, entropy=round(entropy, 4),
                             nonzero=len(part) - counts[0], start=part[:16].hex()))
        struct.pack_into('<I', view, sec.get_field_absolute_offset('PointerToRawData'), rva)
        struct.pack_into('<I', view, sec.get_field_absolute_offset('SizeOfRawData'), size)
    args.output.mkdir(parents=True, exist_ok=True)
    target = args.output / 'jvm-static-view.pe'
    target.write_bytes(view)
    strings = [(m.start(), m.group().decode('ascii')) for m in re.finditer(rb'[ -~]{6,}', data)]
    (args.output / 'all-strings.txt').write_text(''.join(f'0x{rva:08x} {s}\n' for rva, s in strings), encoding='utf-8')
    report = dict(capture=capture, sections=sections, ascii_strings=len(strings),
                  static_view=str(target), static_view_sha256=hashlib.sha256(view).hexdigest(),
                  note='Static RVA-layout view only; imports, relocations, VM bytecode and unwind metadata are not repaired')
    (args.output / 'analysis.json').write_text(json.dumps(report, ensure_ascii=False, indent=2), encoding='utf-8')
    print(json.dumps(dict(sections=len(sections), ascii_strings=len(strings), static_view=str(target),
                          static_view_sha256=report['static_view_sha256']), ensure_ascii=False))


if __name__ == '__main__':
    main()
