# Restoration journal

Compiled on 4 October 2026 from preserved reports. This is a record of completed work, not a reconstruction of the precise time of each action or a fabricated sequence of backdated commits. New work is recorded through ordinary Git commits.

## client212: build date unknown

On 3 October 2026, `stalker_client212.jar` was decompiled: 919 classes yielded 748 Java files. The snapshot was preserved with SHA-256 hashes. A separate Minecraft 1.6.4/Forge environment was prepared and local launch confirmed. Resource-pack selection was corrected. Cyrillic region-file extensions were found to be intentional and supported by the code. Inventory, weapons, and dialogue support were examined; NPC data, quests, and full source compilation remain unfinished.

JAR ZIP timestamps and world `LastPlayed` metadata do not establish the release date or map creation date. A downloaded package name does not establish authorship of its contents.

## Search and pre-2017 recovery

On 3 October 2026, searches for older builds, the VK lead, and mirrors were recorded in `research/2016-2017-search-2026-10-03`. The user supplied `stalcraft_pre.rar`; file inventories and hashes were collected without modifying originals.

Initial inspection found empty conventional `.class` entries and payloads under hexadecimal names. The bundled JVM has VMProtect sections. Direct decompilation required recovery of the protected class format.

After explicit diagnostic authorization, a copy of the bundled Java was started with `-version`. Mapped JVM sections were captured, but the environment check prevented a successful Java startup. No complete VMProtect devirtualization or runnable unpacked DLL was obtained. A CPUID-filter experiment ended with an error in the diagnostic process; a bypass was not established.

The salted name hashes, CBC cipher, and additional ClassFileStream transform were recovered. The first stream-table address hypothesis was incorrect; the corrected address passed checks. All 30,715 class payloads were then decoded with structure, name, and padding validation.

On 4 October 2026, the JVM opcode permutation was recovered. 246,325 methods and 7,311,988 instructions were normalized with boundary checks; this is not execution of the Java verifier. CFR produced 10,047 Java files. Problematic methods were compared with Procyon; a broader Procyon attempt also produced failures, retained separately.

The user reported a Windows crash. The Windows log confirmed bugcheck 0x1E/C0000005; its relationship to the research has not been established. Work continued statically, without new protected-JVM launches.

## Remaining work

### Source-date clarification

On 4 October 2026, the project contributor confirmed that the source VK post was published on **3 November 2017** and supplied `https://vk.ru/wall-2677092_317761`. This is the publication date, separate from the archive's 29 October 2017 file timestamps. Public build descriptions now use the exact post date; historical analysis reports remain unchanged.

### Reconstruction tasks

- Identify obfuscated types and restore readable names in working copies.
- Compare problematic methods against bytecode and alternative decompilers.
- Prepare dependencies and source compilation separately for each build.
- Investigate native dependencies and the pre-2017 loader; gameplay launch remains unconfirmed.
- Seek independent evidence for the origin and dating of the client212 code and map.

Check the preserved snapshots using `python scripts/verify_research_snapshots.py` with Python 3.9 or newer. This checks files without running Java, the game, or diagnostic experiments.
