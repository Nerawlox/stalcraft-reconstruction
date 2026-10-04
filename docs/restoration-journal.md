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

## Name-recovery milestone — 4 October 2026

An independent working layer now contains 474 recovered custom Minecraft class names and MCP names for 8,553 method declarations and 1,757 field declarations. Another 161 Minecraft classes were already named. Matches use declared SRG identities, vanilla descriptors, type constraints, and unmodified declaration/instruction fingerprints; class kind, superclass, interfaces, and one-to-one targets are checked. Different Python hash seeds reproduced identical evidence.

The historical MCP 8.11 archive identifies Minecraft 1.6.4 in its embedded version file. Text dictionaries are hash-pinned; 123 conflicting client/server identifiers were kept unchanged. Remapping all 15,069 game/dependency classes preserved all Code arrays and literal strings and found no class/member collisions. No game or protected JVM was executed.

The first CFR pass exhausted its 512 MiB heap after 2,326 files; its failure report and incomplete local artifacts were retained. A fresh 1,536 MiB attempt completed and produced 5,519 named main-source files. The same six flow/type warnings remain; no failed-method markers were found. A static review prompted stronger generic-signature and interface checks; comparing all output class payloads after those improvements found no differences.

See [reconstruction/README.md](../builds/pre-2017/reconstruction/README.md). Mod-specific names, unresolved Minecraft classes, reflective/ASM string targets, dependencies, and a full source build still need work.

## Static startup preparation — 4 October 2026

The recovered normalized JARs were confirmed to contain only classes and no resources. An isolated, non-executed classpath now combines byte-identical copies of all 15,069 application/dependency classes with resource-only companion archives: 2,047 entries from the original main JAR and 63 from its libraries. All 2,110 resource hashes match the originals, including required Forge version/configuration files. Original names are retained for this startup layer; readable named bytecode remains separate.

A static audit against 23,931 ordinary Java 8 runtime classes found 81 unresolved type names, many associated with optional/platform/server code. It distinguished 198 absent bootstrap member signatures from references in 70 application classes shadowed by the runtime; only two candidates have unshadowed callers, both in an old cryptography-provider helper. None of these counts is a demonstrated runtime failure. Four static regression tests passed.

Recovered Code arrays confirm that LaunchClassLoader's addURL and registerTransformer bodies are no-ops and its resolving loadClass overload throws. Some startup and mod-list hooks are already integrated, so a stock transforming loader cannot be substituted without checking duplicate transformations. Protection's native tfb initialization remains another conditional blocker: no separately named provider was found in the package. No game/native Java execution, full compilation, or source snapshot modification occurred.

See [startup preparation](../builds/pre-2017/reconstruction/startup/README.md) for scripts, hash manifests, bytecode evidence, and limits.

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
