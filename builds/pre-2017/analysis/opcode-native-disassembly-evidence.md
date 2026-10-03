# Native opcode initialization: disassembly cross-check

Capstone inspected the native opcode initializer in the captured mapped JVM image. This is separate from the isolated Unicorn table extraction in `extract-opcode-map.py`. The captured image was not executed here. Each string-reference RVA identifies the plaintext mnemonic; the adjacent initializer arguments encode the corresponding protected opcode before the def helper.

| Mnemonic | Protected byte | Standard JVM byte | Native initializer RVAs |
|---|---:|---:|---|
| `aload_0` | `0x3f` | `0x2a` | `0x2fe465`, `0x2fe484`, `0x2fe48e` |
| `return` | `0x64` | `0xb1` | `0x300148`, `0x30015c` |
| `invokespecial` | `0xc2` | `0xb7` | `0x300288`, `0x30029c` |
| `wide` | `0x57` | `0xc4` | `0x300549`, `0x300550` |
| `tableswitch` | `0xbd` | `0xaa` | `0x2fffd9`, `0x2fffe3` |
| `lookupswitch` | `0xbf` | `0xab` | `0x300010`, `0x30001a` |

`aload_0` is an inline record: the name pointer is stored at RVA `0xA734A8`, with code `0x3F` written by the instruction at `0x2FE484`. This directly predicts the recovered Object constructor issue. The other rows call the def helper with the shown opcode and mnemonic pointer.
