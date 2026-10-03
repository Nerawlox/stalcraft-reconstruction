# Offline emulation of protected helper 0x3AB210

Captured image SHA-256: `e85a5ac5179589cbe0fe9768c338bbc79a19f0a814136c6f58ce780977a6a23c`; capture stage `stack-synchronized`.
Bounded trace: 24 instructions; result `helper_returned_to_synthetic_sentinel`; helper tail returned EAX `0x0`.

## Observed path

Entry loads `ECX=0x1EE7C0DE`, calls RVA `0x76F3B6`, and reaches a protected stub. Static export resolution identifies its external call boundary as `ntdll!NtClose` at RVA `0x160550`; RCX at that boundary is the same `0x1EE7C0DE` value. The offline harness intercepts that exact address and synthesizes `STATUS_INVALID_HANDLE` followed by `ret`, without executing ntdll. Control returns to the mapped helper, which visibly zeroes EAX and returns.

## Limits

The PEB/TEB/heap and stack are synthetic. Only the captured JVM image bytes execute. The `NtClose` result is a selected synthetic response, not a measured Windows response; this demonstrates a path and its return behavior under that model, not the original purpose of the check. No API body, DLL, EXE, process, or host memory API is called. The emulator stops on unhandled external code, CPUID/syscall/interrupt, unmapped memory, or the instruction/time bound.

Reproduce with bundled Python: `python -X utf8 emulate-protected-helper.py`. Full trace and register state: `emulate-protected-helper.json`.
