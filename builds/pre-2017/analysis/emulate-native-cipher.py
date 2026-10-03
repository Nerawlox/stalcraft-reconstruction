"""Emulate only the captured scalar cipher function, without loading a DLL.

No Windows API, external native calls, game entry point or virtualized epilogue
can execute. Unicorn handles arithmetic on an isolated synthetic memory image.
"""
from pathlib import Path
import argparse, hashlib, importlib.util, json, struct, sys

HERE = Path(__file__).resolve().parent
sys.path.insert(0, str(HERE / 'python-tools'))
from unicorn import Uc, UC_ARCH_X86, UC_MODE_64, UC_HOOK_CODE
from unicorn.x86_const import *


def emulate(data, name, inplace=False):
    result = json.loads((HERE / 'watcher-run2-result.json').read_text(encoding='utf-8'))
    captured = result['capture']
    image = Path(captured['path']).read_bytes()
    if hashlib.sha256(image).hexdigest() != captured['sha256']:
        raise ValueError('Snapshot hash mismatch')
    base = captured['image_base']
    uc = Uc(UC_ARCH_X86, UC_MODE_64)
    uc.mem_map(base, (len(image) + 4095) & ~4095)
    uc.mem_write(base, image)
    stack, buffers, peb = 0x20000000, 0x21000000, 0x22000000
    uc.mem_map(stack, 0x200000)
    uc.mem_map(buffers, 0x300000)
    uc.mem_map(peb, 0x10000)
    uc.mem_write(peb + 0x60, struct.pack('<Q', peb + 0x1000))
    uc.reg_write(UC_X86_REG_GS_BASE, peb)
    if len(data) > 0x100000 or not data or len(data) % 16:
        raise ValueError('Expected bounded block-aligned payload')
    uc.mem_write(buffers, data)
    uc.mem_write(buffers + 0x200000, name.encode('ascii') + b'\0')
    uc.reg_write(UC_X86_REG_RSP, stack + 0x100008)
    uc.mem_write(stack + 0x100008, struct.pack('<Q', base + 0x3ac2f6))
    uc.reg_write(UC_X86_REG_RCX, buffers)
    uc.reg_write(UC_X86_REG_RDX, buffers if inplace else buffers + 0x100000)
    uc.reg_write(UC_X86_REG_R8, len(data))
    uc.reg_write(UC_X86_REG_R9, buffers + 0x200000)
    state = dict(instructions=0, helper_return_zero=False, completed=False,
                 inplace=inplace, stop_rva='0x3ac2f6', excluded='Protected epilogue and anti-analysis helper semantics')

    def code_hook(machine, address, size, _):
        state['instructions'] += 1
        if address in (base + 0x3ab210, base + 0x693070):
            # Normal return of this anti-analysis offset helper is exactly zero.
            rsp = machine.reg_read(UC_X86_REG_RSP)
            ret = struct.unpack('<Q', machine.mem_read(rsp, 8))[0]
            machine.reg_write(UC_X86_REG_RAX, buffers + 0x100000 if address == base + 0x693070 else 0)
            machine.reg_write(UC_X86_REG_RSP, rsp + 8)
            machine.reg_write(UC_X86_REG_RIP, ret)
            if address == base + 0x3ab210:
                state['helper_return_zero'] = True
        elif address == base + 0x3ac2f6:
            state['completed'] = True
            machine.emu_stop()
        elif address == base + 0x3ab440 and machine.reg_read(UC_X86_REG_R10) == 4:
            rsp = machine.reg_read(UC_X86_REG_RSP)
            state['actual_initial_key'] = bytes(machine.mem_read(rsp + 0x78, 16)).hex()
        elif not base + 0x3ab230 <= address < base + 0x3ac2f6:
            raise RuntimeError(f'Unexpected code address {address:#x}; refusing external execution')

    uc.hook_add(UC_HOOK_CODE, code_hook)
    uc.emu_start(base + 0x3ab230, base + 0x3ac2f7, timeout=15_000_000, count=2_000_000)
    if not state['completed']:
        raise RuntimeError('Cipher emulation did not finish within its bound')
    return bytes(uc.mem_read(buffers + 0x100000, len(data))), state


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--name', default='java/lang/Object')
    args = parser.parse_args()
    digest = hashlib.md5((args.name + 'nUHDjbS59e4wF8Pr').encode()).hexdigest()
    idx = json.loads((HERE / 'jimage-index.json').read_text(encoding='utf-8'))
    entry = next(e for e in idx['entries'] if e['name'].endswith('/' + digest))
    with Path(idx['source']).open('rb') as source:
        source.seek(entry['offset'])
        data = source.read(entry['uncompressed_size'])
    plain, state = emulate(data, digest)
    output = HERE / 'emulated-cipher' / (digest + '.bin')
    output.parent.mkdir(exist_ok=True)
    output.write_bytes(plain)
    spec = importlib.util.spec_from_file_location('class_check', HERE / 'probe-aes-payload.py')
    check = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(check)
    valid = []
    for trim in range(16):
        candidate = plain if trim == 0 else plain[:-trim]
        parsed = check.valid_class(candidate)
        if parsed:
            valid.append(dict(trim=trim, **parsed))
            target = HERE / 'recovered-java-native-emulated' / (parsed['name'] + '.class')
            target.parent.mkdir(parents=True, exist_ok=True)
            target.write_bytes(candidate)
    report = dict(requested_name=args.name, digest=digest, payload_size=len(data),
                  cipher_name_argument=digest, first32=plain[:32].hex(),
                  output=str(output), **state, valid_classes=valid)
    (output.parent / (digest + '.json')).write_text(json.dumps(report, indent=2), encoding='utf-8')
    print(json.dumps(report, ensure_ascii=False))


if __name__ == '__main__':
    main()
