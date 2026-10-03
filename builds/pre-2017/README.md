# pre-2017 — OFT preload published on 3 November 2017

Research on `stalcraft_pre.rar`, obtained through the official STALCRAFT community [VK post](https://vk.ru/wall-2677092_317761) published on **3 November 2017**. The project contributor supplied and confirmed the post date and source. The included instructions describe an OFT preload package.

Files carry timestamps from **29 October 2017**. Those timestamps describe the packaged files, not the publication date of the post, and do not date every component's creation. See [provenance-update.json](provenance-update.json) for the later source clarification; preserved historical analysis reports have not been rewritten.

## Recovered code and results

- [reconstruction/src](reconstruction/src/) — newer working source with recovered Minecraft/MCP names; see [name-recovery status](reconstruction/README.md).

- [decompiled-standard/classes](decompiled-standard/classes/) — 5,519 Java files from the main archive.
- [decompiled-standard/libs](decompiled-standard/libs/) — 4,528 Java files from dependencies.
- [decompiled-alternatives](decompiled-alternatives/) — separate Procyon results for comparison; these do not replace the CFR snapshot.
- [analysis/restoration-status.md](analysis/restoration-status.md) — current recovery results and limitations.
- [analysis](analysis/) — scripts, experiments, successful and failed results.
- [recovered-bytecode](recovered-bytecode/) — JSON recovery reports; JARs are local artifacts and are not included.

All 30,715 protected class payloads, including the Java runtime image, were recovered. Class encryption and the custom JVM opcode permutation have been decoded. Names remain partly obfuscated, and decompilation does not establish exact source equivalence for every method.

Full source compilation and gameplay launch are not ready. The protected native JVM has not been rebuilt as a runnable unprotected replacement; native dependencies remain. The game and recovered game classes have not been executed.

## Working with these materials

Keep the original CFR snapshot unchanged. Place source corrections in a separate `reconstruction/` directory, recording the original class, reason for the change, and validation method. Commits should describe an actual change and its result.

`analysis` contains exact historical report copies, some in Russian. Earlier hypotheses may have been disproved; use the current status and the [restoration journal](../../docs/restoration-journal.md) to resolve conflicts. Reports retain research-machine paths. Some links refer to local dumps, binaries, or illustrations excluded from Git.

Scripts preserve the process rather than provide a single portable launcher. Some require local originals, Python libraries, Windows tools, and path configuration. Snapshot verification does not run diagnostic scripts. After a reported Windows crash, work continued statically; the crash cause has not been established.

Archives, runtimes, JAR/DLL/EXE files, memory dumps, and downloaded tool binaries are excluded. Text reports retain their relevant SHA-256 values and analysis results.
