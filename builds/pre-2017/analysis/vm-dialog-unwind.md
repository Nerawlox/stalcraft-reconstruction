# Offline unwind of the VM warning thread

Capture: `E:\Stalcraft project\builds\stalcraft-pre-vk-2017-candidate\analysis\diagnostic-stack-capture-31860-1791046301`
TID/PID: `2900` / `31860`
Initial RIP/RSP: `0x7ffbf8f31404` / `0x33ef6fdc18`

No process was opened or executed. Windows DLL unwind data comes from local on-disk system DLLs; unwind stops at the first JVM address.

System DLL disk identities and loaded-size matches: `[{"disk_sha256": "87ae7cca2cb9f368f265faa59ed5e421eb9ec8ee07cf60244ed913ce2ba2e0d4", "disk_size_of_image": "0x1c6000", "loaded_base": "0x7ffbfaa40000", "loaded_size": "0x1c6000", "path": "C:\\WINDOWS\\System32\\USER32.dll", "pe_checksum": "0x1d1e86", "pe_timestamp": "0x5d257817", "size_matches": true}, {"disk_sha256": "a8cfcbaf6c3f855f5ba5fb16c91df9ecac65db35a93c8d48da4400466a759388", "disk_size_of_image": "0x27000", "loaded_base": "0x7ffbf8f30000", "loaded_size": "0x27000", "path": "C:\\WINDOWS\\System32\\win32u.dll", "pe_checksum": "0x2b270", "pe_timestamp": "0xaa060f44", "size_matches": true}]`

| # | PC | Module | How unwound | Return slot / next PC | Notes |
|---:|---|---|---|---|---|
| 0 | `0x7ffbf8f31404` | `win32u.dll` | pdata/unwind-info | `0x33ef6fdc18` → `0x7ffbfaa5329a` |  |
| 1 | `0x7ffbfaa5329a` | `USER32.dll` | pdata/unwind-info | `0x33ef6fdcc8` → `0x7ffbfaa70a97` | SAVE_NONVOL rsi @ 0x33ef6fdce8; SAVE_NONVOL rbp @ 0x33ef6fdce0; SAVE_NONVOL rbx @ 0x33ef6fdcd8; ALLOC_SMALL 0x80; PUSH_NONVOL r15; PUSH_NONVOL r14; PUSH_NONVOL r13; PUSH_NONVOL r12; PUSH_NONVOL rdi |
| 2 | `0x7ffbfaa70a97` | `USER32.dll` | pdata/unwind-info | `0x33ef6fdd28` → `0x7ffbfaa72396` | SAVE_NONVOL rdi @ 0x33ef6fdd48; SAVE_NONVOL rsi @ 0x33ef6fdd40; SAVE_NONVOL rbp @ 0x33ef6fdd38; SAVE_NONVOL rbx @ 0x33ef6fdd30; ALLOC_SMALL 0x40; PUSH_NONVOL r15; PUSH_NONVOL r14; PUSH_NONVOL r12 |
| 3 | `0x7ffbfaa72396` | `USER32.dll` | pdata/unwind-info | `0x33ef6fde78` → `0x7ffbfaa9eb12` | SAVE_XMM128 XMM6 (ignored for integer unwind); ALLOC_LARGE 0x108; PUSH_NONVOL r15; PUSH_NONVOL r14; PUSH_NONVOL r13; PUSH_NONVOL r12; PUSH_NONVOL rdi; PUSH_NONVOL rsi; PUSH_NONVOL rbx; PUSH_NONVOL rbp |
| 4 | `0x7ffbfaa9eb12` | `USER32.dll` | pdata/unwind-info | `0x33ef6fe028` → `0x7ffbfaa9e56f` | SAVE_NONVOL rdi @ 0x33ef6fe048; SAVE_NONVOL rsi @ 0x33ef6fe040; SAVE_NONVOL rbx @ 0x33ef6fe038; ALLOC_LARGE 0x180; PUSH_NONVOL r15; PUSH_NONVOL r14; PUSH_NONVOL r13; PUSH_NONVOL r12; PUSH_NONVOL rbp |
| 5 | `0x7ffbfaa9e56f` | `USER32.dll` | pdata/unwind-info | `0x33ef6fe128` → `0x7ffbfaa9e3c5` | ALLOC_LARGE 0xd0; PUSH_NONVOL r14; PUSH_NONVOL rdi; PUSH_NONVOL rsi; PUSH_NONVOL rbp; PUSH_NONVOL rbx |
| 6 | `0x7ffbfaa9e3c5` | `USER32.dll` | pdata/unwind-info | `0x33ef6fe168` → `0x5c59b8bd` | ALLOC_SMALL 0x38 |
| 7 | `0x5c59b8bd` | `jvm.dll` | — | `—` → `—` | first JVM address; stopped before trusting JVM .pdata |

## Caller identification

The final recovered system return PC is USER32 RVA `0x5E3C5`, inside the exported MessageBoxW wrapper (entry RVA `0x5E380`). The on-disk system image shows MessageBoxW calls MessageBoxTimeoutW at `0x5E3C0`; the latter is exported at `0x5E3E0`. The first JVM return PC is RVA `0x1C2B8BD`, and the immediately preceding bytes at `0x1C2B8BB` are FF D0 (call rax) in the synchronized JVM memory image. Thus the OS unwind recovers the actual JVM caller site; no arbitrary stack word was promoted into a frame. The target register value before the call is not in the post-call context, so the direct proof of target comes from the USER32 frames and wrapper path, not from saved pre-call RAX.

**Reconstructed caller nonvolatile state:** {"r12": "0x5c6bae45", "r13": "0x33ef6fe338", "r14": "0x5c", "r15": "0x33ef6fe3a8", "rbp": "0x33ef6fe3a8", "rbx": "0x0", "rdi": "0xfffffffffff4c7f1", "rip": "0x5c59b8bd", "rsi": "0x33ef6fe2f0", "rsp": "0x33ef6fe170"}. Volatile registers are not inferred.

**Stop:** first JVM frame reached; intentionally stopped.

A PC is treated as a caller frame only after a corresponding return address was recovered by a validated system `.pdata`/UNWIND_INFO transition or a documented leaf unwind. Arbitrary stack values are never promoted to frames.
