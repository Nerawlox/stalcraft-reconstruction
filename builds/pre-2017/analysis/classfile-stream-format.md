# Native class-stream transform: corrected validation

This note supersedes the earlier negative probe in this file. The original probe used the wrong RVA for the 16-byte lookup table (`0x9f3d40`) and did not emulate the reader functions. The correct table address is `0xa2fd40`, derived from the LEA at `0x3aa4e1` (`next RIP 0x3aa4e8 + displacement 0x685858`). Its bytes are `04 bc ca a8 3d 73 7c ad ca ad 56 33 73 5b c7 da`.

## Reconstructed operation

The captured JVM image is `dynamic-capture/jvm-static-view.pe` (RVA-as-file-offset). It contains a stream initializer at `0x3aa240`, bulk reader at `0x3aa420`, and scalar readers `get_u1=0x3aa4c0`, `get_u2=0x3aa620`, `get_u4=0x3aa680`. The current cursor advances as each getter consumes data. With `pos` measured relative to the stream start and `i` relative to the requested read, the byte operation is:

```text
out[i] = input[pos+i]
         XOR ROR8(input[pos+i-2], 3)
         XOR table[(input[pos+i-1] + pos+i) & 15]
```

The parser-like function at `0x3a6ed0` skips two initial bytes, reads a big-endian `u2`, and requires marker `0xe629`; its mismatch path references `Incompatible magic value %u in class file %s` at `0x89a340`. It then reads minor and major versions. This path does not compare `CAFEBABE` directly.

## Validation against JIMAGE `java/lang/Object`

JIMAGE entry `/java.base/c14f5b29590d12e945cb0f3a42112a91` has offset `43,797,169`, no compression, and 1,552 bytes. The native cipher emulator must receive the 32-character MD5 alias as its name argument. Feeding its result to the native stream getters with the parser's two-byte skip and cursor state gives:

- marker `e629`, minor `0`, major `53`;
- constant-pool count `82`, including `registerNatives`, `getClass`, `hashCode`, `equals`, `toString`, `java/lang/StringBuilder`, and other expected `java/lang/Object` constants;
- strict constant-pool/member/attribute parsing identifies `this_class=java/lang/Object`, 0 fields, 14 methods, and consumes exactly 1,545 bytes;
- the remaining 7 bytes are container alignment padding. The recovered standalone class is trimmed to the parser's exact endpoint.

This is validated by [verify_classfile_stream_transform.py](verify_classfile_stream_transform.py), which runs only the selected getter instructions in Unicorn with synthetic memory and checks their outputs against the independent Python formula. It writes `verify-classfile-stream-transform.json` and the recovered sample at `recovered-stream/java/lang/Object.class`. All four getter checks pass. No target executable or DLL is run or loaded.

`probe_classfile_stream_format.py` is retained as a small bounded marker probe and now uses the correct table address. Its corrected result finds `e629` at stream start 2 / base offset 2 in the native cipher output. The previous conclusion that no candidate alignment matched, and that no class could be recovered, is obsolete; that negative result came from the bad table address and incomplete stream-state emulation.

The result validates the cipher output, stream transform, and parser framing for this JIMAGE sample. The independent internal-path digest variant does not decode correctly. This sample alone does not establish that every container or caller uses identical initial-state handling; batch recovery results and their independent hashes are documented by the separate recovery artifacts.
