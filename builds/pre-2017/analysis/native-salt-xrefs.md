# Native salt, class path, and cipher xrefs

Read-only analysis of `analysis/dynamic-capture/jvm-static-view.pe` (SHA-256 `e65dd250be4dab717ba635cb5d6dd4746442abc94da2f4e5360dc6d9d47b3896`). Mapped image base `0x5A970000`; addresses below are RVAs. No EXE/DLL was run and no capture or original was changed.

## Main findings

- The visible salt1 literal is at RVA `0x89ABC0`. A locally aligned decode finds its RIP-relative use at `0x633DD0`; the function appends this text to an input string, calls the MD5 helper at RVA `0x5F0B00`, then passes the result onward through indirect calls. This independently matches the parent report that MD5 of JLI names plus salt1 yields export aliases.
- The second salt literal starts at RVA `0x89ABD8`. Both visible `movups` references target **RVA `0x89ABD8`** and copy the full 16-byte ASCII string `nUHDjbS59e4wF8Pr`. A following byte-load targets `0x89ABE8`, the terminator. Target arithmetic uses the decoded 7-byte instruction lengths.
- Salt2 is used in two visible MD5 paths. `0x3AD680` appends the 16 bytes to its input and tail-jumps to MD5 at `0x5F0B00`. The wrapper around `0x3AC3DE` performs the same append, calls MD5 at `0x3AC3FC`, then calls the custom cipher at `0x3AC40F` (`0x3AB230`) with the hexdigest buffer in `R9`. The cipher copies the final 16 ASCII bytes of this string into local IV state; its key schedule instead starts from local fixed key constants. The digest is therefore an IV/name-derived parameter, not the AES key.
- RVA `0x3AB230` is a custom AES/Rijndael-like byte-oriented block-cipher path associated with `.class` names: it references the literal `.class` from `0x3AB306`, detects/strips that suffix, expands a 16-byte key, and processes data in 16-byte blocks. Its S-box at `0x89A6F0` and inverse at `0x89A7F0` are exact inverse permutations, but the first bytes (`D3 CD B8 22 ...` / `0E E9 2C 88 ...`) are not the standard AES S-box pair. Do not substitute standard AES tables.
- The GF exp/log tables at `0x89A8F0`/`0x89A9F0` are mutual lookup tables. Code around `0x3AB650` uses the GF log table, adds constants in observed order `FD`, `86`, `EE`, `7C`, reduces modulo 255, looks up exp values, and XOR-combines them. This confirms a custom field-mixing transform; the four constants in that loop are not the standard AES inverse-mix coefficients. Mode/IV/padding conclusions are outside this xref note; the full local cipher dump is `custom-cipher-function.asm`.
- Before this cipher work, the function calls helper `0x3AB210` at `0x3AB268`. Its readable stub sets `ECX=0x1EE7C0DE`, calls `0x76F3B6`, then explicitly zeroes EAX and returns. The called RVA starts `push rbp; call VA 0x5B904949 (RVA 0xF94949); call VA 0x5B941AF3 (RVA 0xFD1AF3)`, both inside `.vmp0`; the snapshot does not provide a safely attributable ordinary function body for those targets. The visible return value is zero, but the VMP calls could have side effects; their purpose is unresolved. Do not treat this stub as a no-op or assert it initializes the cipher tables.

## Exact local instruction evidence

| RVA | Instruction / target | Interpretation |
|---:|---|---|
| `0x633DD0` | `lea rdx, [rip + 0x266DE9]` → `0x89ABC0` | salt1 appended to an input before MD5 |
| `0x633E59` | `call 0x5F0B00` | MD5 helper in salt1 path |
| `0x3AD6DD` | `movups xmm0, [rip + 0x4ED4F4]` → `0x89ABD8` | copy all 16 bytes of salt2 |
| `0x3AD6EA` | `movzx eax, byte ptr [rip + 0x4ED4F7]` → `0x89ABE8` | append terminator after the copied 16 bytes |
| `0x3AD701` | `jmp 0x5F0B00` | salt2 hash wrapper tail-calls MD5 |
| `0x3AC3DE` | `movups xmm0, [rip + 0x4EE7F3]` → `0x89ABD8` | inline salt2 append in class/cipher wrapper |
| `0x3AC3F1` | `movzx eax, byte ptr [rip + 0x4EE7F0]` → `0x89ABE8` | same appended-string terminator |
| `0x3AC3FC` | `call 0x5F0B00` | MD5 digest produced for next cipher call |
| `0x3AC40F` | `call 0x3AB230`, with `R9 = [rsp+0x20]` | MD5 hexdigest is passed as IV/name parameter; cipher takes its final 16 ASCII bytes |
| `0x3AB306` | `lea r9, [rip + 0x4EF8DF]` → `0x89ABEC` (`.class`) | suffix check/strip in cipher path |
| `0x3AB46B–0x3AB4A4` | image-base-relative loads from `+0x89A6F0` and `+0x89AAF0` | custom S-box and Rcon during key schedule; Rcon sequence starts at `0x89AAF1` |
| `0x3AB5E7` and `0x3ABB7B/0x3ABD1B/0x3AC2AC` | image-base-relative `+0x89A7F0` | inverse substitution table |
| `0x3AB650+` | image-base-relative `+0x89A8F0`, `+0x89A9F0` | GF exponent/log lookups in inverse/mix path |
| `0x3AB268` | `call 0x3AB210` | cipher preamble calls magic helper before processing |
| `0x3AB210–0x3AB22B` | `mov ecx,0x1EE7C0DE; call 0x76F3B6; xor eax,eax; ret` | explicit zero return plus unresolved protected side-effect path |

The salt2 references were recovered by decoding locally aligned blocks; a single linear sweep from the beginning of `.text` can lose instruction alignment in this image. I have not established a code reference to `jimage file is null` at `0x89ABF8`; because the broad linear sweep is unreliable here, absence cannot be concluded. That literal's adjacency alone does not bind it to the class cipher.

## What this establishes

The salt literals are not merely inert nearby strings: both are consumed in input-concatenation-and-MD5 code, and one resulting hexdigest supplies the custom cipher's IV/name parameter. The other salt path appears in native lookup plumbing and is consistent with the observed MD5(JLI-name + salt1) export mapping. The exact caller-level semantic meaning of the salt1 digest beyond that mapping remains open. This report does not identify the cipher mode or authenticate/encrypt/decrypt direction by salt references alone.
