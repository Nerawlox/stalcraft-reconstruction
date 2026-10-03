# Shared classpath decryption path: directory, ZIP/JAR, and JIMAGE

Update 2026-10-04: the offline decoder is now validated on all 30,715 protected entries, including recovered class identities, custom stream decoding and opcode normalization. See `restoration-status.md`; the static backend callsites below remain useful evidence. Earlier uncertainty about cipher helper/postamble and padding has been resolved as described below.

Read-only static disassembly of `analysis/dynamic-capture/jvm-static-view.pe` (mapped image base `0x5A970000`; addresses in this note are RVAs). No EXE, DLL, or Java process was run. This complements `native-salt-xrefs.md` and `custom-cipher-function.asm`.

## Result

The three visible class-path backends converge on the same native routine at RVA `0x3AB230`. This includes the JIMAGE backend: after its `JIMAGE_GetResource` call, it invokes the same custom block transform. Mass recovery confirms the shared protected class-byte format for the JAR and JIMAGE corpora. Decrypted containers end with 1..16 zero bytes; class structure determines the exact consumed length. Other resource types and the complete runnable native runtime remain outside this validation.

| Backend | Native path and evidence | Confidence |
|---|---|---|
| Directory / loose file | `0x3AE8F0` opens/reads a file; after read/size handling, calls `0x3AB230` at `0x3AEAA5`; returns a stream-like object via `0x3AA240`. | High for same cipher call; medium for exact OpenJDK method label. |
| JIMAGE | `0x3AEB50` calls JIMAGE FindResource slot `0xA78500` at `0x3AEBD6`, has a second definite FindResource call at `0x3AEDD5`, then calls GetResource slot `0xA78508` at `0x3AEE8C`. It passes the resulting buffer through `0x3AB230` at `0x3AEF0C`, then constructs/returns the stream through `0x3AA240` at `0x3AEF38`. | Very high for shared cipher on JIMAGE bytes. |
| ZIP / JAR | `0x3AEF80` calls ZIP stream helper `0x3AE6E0` at `0x3AEFB4`; after entry/length processing it calls `0x3AB230` at `0x3AF026`, then stream construction at `0x3AF06D`. | High for same cipher call; medium for exact method label. |

## JIMAGE call sequence

The JIMAGE function pointer table is initialized by the loader code around `0x3AE2D0`. Slots are consistent with OpenJDK's JIMAGE API:

- `0xA784E8`: `JIMAGE_Open`
- `0xA784F0`: `JIMAGE_Close`
- `0xA784F8`: `JIMAGE_PackageToModule`
- `0xA78500`: `JIMAGE_FindResource`
- `0xA78508`: `JIMAGE_GetResource`
- `0xA78510`: `JIMAGE_ResourceIterator`
- `0xA78518`: `JIMAGE_ResourcePath`

At `0x3AEE6E`–`0x3AEE8C`, the code allocates a buffer from the reported resource size, places the resource handle in `RDX`, buffer in `R8`, size in `R9`, and calls the GetResource slot. After that it prepares the buffer, length/block metadata, and resource-name argument and calls `0x3AB230` at `0x3AEF0C`. That is the decisive JIMAGE/cipher link. The function then uses the same stream factory seen by the other backends (`0x3AA240`).

The indirect call at `0x3AECFB` resolves to slot `0xA78400`, outside the registered JIMAGE API table, and is not counted as a JIMAGE call here. The definite FindResource calls are `0xA78500` at `0x3AEBD6` and `0x3AEDD5`; the definite GetResource call is `0xA78508` at `0x3AEE8C`. Targets are calculated from each decoded RIP-relative call instruction, rather than guessed from nearby code.

## Cipher wrapper and protected tail

The class-name wrapper near `0x3AC3DE` computes MD5 over the supplied name plus the 16-byte salt2, then calls `0x3AB230` with the digest string as the name/IV parameter. The algorithm's readable body ends near `0x3AC324`, but its native epilogue executes protected calls at `0x3AC325` and `0x3AC337` into `.vmp0`:

- `0x3AC325 -> 0xF33409`
- `0x3AC337 -> 0xF35D0A` with `EDX=0x11`, `R8=R9=0`, `RCX=RAX`

Bounded Unicorn traces now resolve the API boundaries: `0xF33409` calls GetCurrentThread, and `0xF35D0A` calls NtSetInformationThread/ZwSetInformationThread with the current-thread pseudo-handle and class0x11 (ThreadHideFromDebugger). Helper0x3AB210 calls NtClose/ZwClose with handle0x1EE7C0DE and returns zero when its API reply is synthesized as STATUS_INVALID_HANDLE. API bodies were never executed from emulation; the entire exceptional path and second thunk return are not established. See `protected-helper-boundaries.md` for the exact limits. The arguments support an anti-analysis role, not another payload transform.

## Practical implication

The resource alias is MD5(UTF-8 internal class name + salt2). Its last16 ASCII characters give the tested CBC IV. After CBC, apply ClassFileStream decoding with the table at RVA0xA2FD40, replace the custom prefix/marker with CAFEBABE, parse the entire class, and verify 1..16 bytes of zero padding in the CBC result. Then normalize protected opcodes. All 6,975 JAR game classes, 8,094 library classes and15,646 JIMAGE classes pass the complete format/name/instruction checks. This validates offline bytecode recovery; a runnable protected runtime and game startup are separate tasks.

All seven JIMAGE APIs also resolve as salted hex exports inside jvm.dll, not a separate bundled jimage.dll (`native-jimage-export-mapping.json`). For example, JIMAGE_GetResource maps to4327cf92ac3c1d62a94b069d13e2e3bb, export RVA0x60DEC. This additional export evidence comes from PE metadata; it does not imply that the runtime function-pointer table was initialized in the early VM-blocked capture.

## Primary-source cross-check

OpenJDK 9u class-loader source for the reference API and backend structure: [openjdk/jdk9u `classLoader.cpp`](https://github.com/openjdk/jdk9u/blob/master/hotspot/src/share/vm/classfile/classLoader.cpp). The corresponding native JIMAGE API declaration is [openjdk/jdk9u `jimage.hpp`](https://github.com/openjdk/jdk9u/blob/master/hotspot/src/share/vm/classfile/jimage.hpp). These sources identify the standard FindResource/GetResource flow and `ClassPathImageEntry` behavior; they do not describe STALCRAFT's added cipher. The exact local addresses and same-cipher conclusion above come from the captured PE disassembly, not from upstream source.


