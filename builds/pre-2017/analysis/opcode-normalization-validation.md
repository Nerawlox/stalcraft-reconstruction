# Opcode normalization: independent structural validation

Static parsing only; no recovered class was loaded or executed. `jimage-standard.jar` Object and all 55 `com/stalcraft/` classes in `classes-standard.jar` were checked.

Validated 56 classes, 316 Code methods, 10393 instruction boundaries, 542 branch targets, 3268 constant-pool operands, 0 tableswitch, 0 lookupswitch, and 0 wide instructions.

The parser checked instruction lengths and boundaries, branch destinations, switch/wide encodings, CP index/tag compatibility, exception ranges, and catch types.

Key native map rows from `opcode-map.json`:
- protected 0x3f → aload_0 (standard 0x2a; len=1, wide_len=0)
- protected 0xc2 → invokespecial (standard 0xb7; len=3, wide_len=0)
- protected 0x64 → return (standard 0xb1; len=1, wide_len=0)
- protected 0x57 → wide (standard 0xc4; len=0, wide_len=0)
- protected 0xbd → tableswitch (standard 0xaa; len=0, wide_len=0)
- protected 0xbf → lookupswitch (standard 0xab; len=0, wide_len=0)

Object constructor decoding:
- `<init>()V`: bytes `b1`; first decoded operations: return.

Parser errors: 0. The game-class selection contained no `tableswitch`, `lookupswitch`, or `wide` bytecodes; their protected values were instead cross-checked directly in the native initializer disassembly, recorded in `opcode-native-disassembly-evidence.md`.
