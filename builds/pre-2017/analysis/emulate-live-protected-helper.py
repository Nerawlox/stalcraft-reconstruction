"""Bounded Unicorn interpretation of a protected helper using our own child snapshot.

Only the approved copied Java -version is launched. Target memory is read only.
The helper is interpreted in Unicorn, never invoked as native code on the host.
Windows API calls are recorded and synthesized, not executed from target code.
"""
from pathlib import Path
import argparse, ctypes as C, ctypes.wintypes as W, importlib.util, json, struct, sys, time

HERE = Path(__file__).resolve().parent
sys.path.insert(0, str(HERE / 'python-tools'))
import pefile
from unicorn import Uc, UcError, UC_ARCH_X86, UC_MODE_64, UC_HOOK_CODE, UC_HOOK_MEM_UNMAPPED
from unicorn.x86_const import *
spec = importlib.util.spec_from_file_location('own_stack_capture', HERE / 'diagnostic-stack-walk.py')
capture = importlib.util.module_from_spec(spec)
spec.loader.exec_module(capture)
tool, watch = capture.tool, capture.watch


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--entry', choices=['offset-helper', 'current-thread-thunk', 'hide-thread-thunk'], default='offset-helper')
    args = parser.parse_args()
    entry = {'offset-helper': 0x3ab210, 'current-thread-thunk': 0xf33409, 'hide-thread-thunk': 0xf35d0a}[args.entry]
    k, n = tool.api(), watch.ntdll()
    exe = tool.validate()
    pi = capture.launch_child(k, exe, [str(exe), '-version'], exe.parent)
    process, thread, pid = int(pi.hProcess), int(pi.hThread), int(pi.dwProcessId)
    result = dict(command=[str(exe), '-version'], owned_pid=pid, entry_rva=hex(entry),
                  mode='Unicorn arithmetic and snapshot reads; no target memory writes or native helper invocation', api_calls=[], trace=[], instructions=0)
    try:
        if capture.process_id(k, process) != pid:
            raise RuntimeError('Own-child PID mismatch')
        info, returned = C.create_string_buffer(48), W.ULONG()
        if n.NtQueryInformationProcess(process, 0, info, 48, C.byref(returned)) < 0:
            raise RuntimeError('Cannot query own child PEB')
        peb = struct.unpack_from('<Q', info.raw, 8)[0]
        n.NtResumeProcess(process)
        time.sleep(8)
        if n.NtSuspendProcess(process) < 0:
            raise RuntimeError('Cannot suspend own diagnostic child')
        mods = watch.modules(k, process, peb)
        target = next(m for m in mods if Path(m['path']).resolve() == (tool.RUNTIME / 'bin/server/jvm.dll').resolve())
        base = target['base']
        result['jvm_base'] = base
        uc = Uc(UC_ARCH_X86, UC_MODE_64)
        mapped = set()

        def remote_page(page):
            if page in mapped:
                return
            if len(mapped) >= 16384:
                raise RuntimeError('64 MiB lazy mapping limit')
            if capture.process_id(k, process) != pid:
                raise RuntimeError('Own-child identity changed')
            data, ok = tool.read(k, process, page, 4096)
            if not ok or len(data) != 4096:
                raise RuntimeError(f'Own snapshot page unavailable at {page:#x}')
            uc.mem_map(page, 4096)
            uc.mem_write(page, data)
            mapped.add(page)

        def missing(machine, kind, address, size, value, user):
            for page in range(address & ~4095, ((address + size - 1) & ~4095) + 1, 4096):
                remote_page(page)
            return True

        def read(address, size):
            for page in range(address & ~4095, ((address + size - 1) & ~4095) + 1, 4096):
                remote_page(page)
            return bytes(uc.mem_read(address, size))

        def ascii_string(address):
            chars = bytearray()
            for i in range(256):
                c = read(address + i, 1)[0]
                if not c:
                    return chars.decode('ascii', errors='replace')
                chars.append(c)
            raise RuntimeError('Unterminated API string')

        exports, names, handles = {}, {}, {}
        for mod in mods:
            if Path(mod['path']).name.lower() in ('jvm.dll', 'java.exe'):
                continue
            try:
                pe = pefile.PE(mod['path'], fast_load=True)
                pe.parse_data_directories(directories=[0])
                for sym in getattr(getattr(pe, 'DIRECTORY_ENTRY_EXPORT', None), 'symbols', []):
                    if not sym.name or sym.forwarder:
                        continue
                    name = sym.name.decode('ascii', errors='replace')
                    address = mod['base'] + sym.address
                    exports[address] = name
                    names[(mod['base'], name)] = address
                handles[Path(mod['path']).name.lower()] = mod['base']
            except (OSError, pefile.PEFormatError):
                pass
        # The child's TEB is read, but its stack bounds are replaced only in the emulator.
        n.NtQueryInformationThread.argtypes = [W.HANDLE, W.DWORD, C.c_void_p, W.ULONG, C.POINTER(W.ULONG)]
        n.NtQueryInformationThread.restype = C.c_long
        tinfo = C.create_string_buffer(48)
        if n.NtQueryInformationThread(thread, 0, tinfo, 48, C.byref(returned)) < 0:
            raise RuntimeError('Cannot query own primary thread TEB')
        teb = struct.unpack_from('<Q', tinfo.raw, 8)[0]
        remote_page(teb & ~4095)
        stack, end = 0x30000000, 0x30200000
        uc.mem_map(stack, 0x200000)
        mapped.update(range(stack, end, 4096))
        uc.mem_write(teb + 8, struct.pack('<QQ', end, stack))
        uc.reg_write(UC_X86_REG_GS_BASE, teb)
        sentinel = 0x30300000
        uc.mem_map(sentinel, 4096)
        mapped.add(sentinel)
        rsp = end - 0x10008
        uc.mem_write(rsp, struct.pack('<Q', sentinel))
        uc.reg_write(UC_X86_REG_RSP, rsp)
        if args.entry == 'hide-thread-thunk':
            uc.reg_write(UC_X86_REG_RCX, 0xfffffffffffffffe)
            uc.reg_write(UC_X86_REG_RDX, 17)
            uc.reg_write(UC_X86_REG_R8, 0)
            uc.reg_write(UC_X86_REG_R9, 0)
        error_code = 0

        def return_api(value):
            rsp = uc.reg_read(UC_X86_REG_RSP)
            ret = struct.unpack('<Q', read(rsp, 8))[0]
            uc.reg_write(UC_X86_REG_RAX, value & 0xffffffffffffffff)
            uc.reg_write(UC_X86_REG_RSP, rsp + 8)
            uc.reg_write(UC_X86_REG_RIP, ret)

        def code(machine, address, size, user):
            nonlocal error_code
            result['instructions'] += 1
            if len(result['trace']) < 64:
                result['trace'].append(dict(pc=hex(address), bytes=read(address, size).hex()))
            if address == sentinel:
                result['completed'] = True
                result['return_rax'] = hex(machine.reg_read(UC_X86_REG_RAX))
                machine.emu_stop()
                return
            if address in exports:
                name = exports[address]
                rcx, rdx, r8, r9 = [machine.reg_read(r) for r in (UC_X86_REG_RCX, UC_X86_REG_RDX, UC_X86_REG_R8, UC_X86_REG_R9)]
                result['api_calls'].append(dict(name=name, address=hex(address), args=[hex(x) for x in (rcx, rdx, r8, r9)]))
                if name in ('SetLastError', 'RtlSetLastWin32Error'):
                    error_code = rcx & 0xffffffff
                    return_api(0)
                elif name in ('GetLastError', 'RtlGetLastWin32Error'):
                    return_api(error_code)
                elif name in ('GetCurrentThread', 'NtCurrentThread'):
                    return_api(-2)
                elif name in ('GetCurrentProcess', 'NtCurrentProcess'):
                    return_api(-1)
                elif name == 'IsDebuggerPresent':
                    return_api(0)
                elif name in ('NtClose', 'ZwClose') and rcx == 0x1ee7c0de:
                    # Invalid handle, no native API invocation or SEH exception.
                    return_api(0xc0000008)
                elif name in ('NtSetInformationThread', 'ZwSetInformationThread') and rdx == 17 and not r8 and not r9:
                    return_api(0)
                elif name == 'GetProcAddress':
                    symbol = ascii_string(rdx)
                    result['api_calls'][-1]['symbol'] = symbol
                    resolved = names.get((rcx, symbol))
                    if not resolved:
                        raise RuntimeError(f'Unresolved export {symbol}')
                    return_api(resolved)
                else:
                    raise RuntimeError(f'Unmodeled API: {name}; target OS code will not execute')
                return
            if not base <= address < base + target['size']:
                raise RuntimeError(f'Code outside the captured JVM/API hook set: {address:#x}')

        uc.hook_add(UC_HOOK_MEM_UNMAPPED, missing)
        uc.hook_add(UC_HOOK_CODE, code)
        uc.emu_start(base + entry, sentinel + 1, timeout=20_000_000, count=1_000_000)
        result['mapped_pages'] = len(mapped)
        result['last_pc'] = hex(uc.reg_read(UC_X86_REG_RIP))
        if not result.get('completed'):
            result['error'] = 'Bound reached before protected helper returned'
    except Exception as exc:
        result['error'] = f'{type(exc).__name__}: {exc}'
    finally:
        n.NtResumeProcess(process)
        k.TerminateProcess(process, 0)
        k.WaitForSingleObject(process, 3000)
        k.CloseHandle(thread)
        k.CloseHandle(process)
        out = HERE / ('live-protected-' + args.entry + '.json')
        out.write_text(json.dumps(result, ensure_ascii=False, indent=2), encoding='utf-8')
        print(json.dumps({k: result.get(k) for k in ('entry_rva', 'completed', 'return_rax', 'error', 'instructions', 'api_calls', 'last_pc')}, ensure_ascii=False))


if __name__ == '__main__':
    main()
