# Working on STALCRAFT Reconstruction

This repository contains research on multiple historical clients. Read `README.md`, each build's README, and `docs/restoration-journal.md` before making changes. If the local shared project file `../AGENTS.md` exists, read it as well; it records machine-specific originals, runtime locations, and user instructions. It is not included in the public repository.

## Build identity and dating

- `client212` is identified by `stalker_client212.jar`, not by an author or release year. Its client and map dates are unknown. JAR ZIP timestamps and world `LastPlayed` are metadata, not release or creation dates.
- `pre-2017` is the OFT preload linked in the official STALCRAFT VK post dated 3 November 2017, supplied and confirmed by the user. Its 29 October file timestamps are distinct from the post publication date. Keep this later clarification separate from older preserved analysis records.
- Historical distributor labels and filenames are evidence of where files were obtained, not proof of authorship. Preserve original provenance records without promoting those labels to build identity.

## Paths and preservation

- `src/` and `resource-configs/` are the immutable client212 CFR/config snapshot. Check it with `scripts/verify_snapshot.py`.
- `builds/pre-2017/decompiled-standard/` is the immutable CFR snapshot for the preload client.
- `builds/pre-2017/decompiled-alternatives/` preserves separate Procyon results, including some failed methods. Do not replace successful CFR output automatically.
- `builds/pre-2017/analysis/` and `research/` contain exact historical text imports. Read the current status when older reports conflict.
- Verify both preserved snapshots using `scripts/verify_research_snapshots.py`. Its execution is limited to hashes and inventories.
- New source fixes belong in a separate `reconstruction/` directory for their build. Record evidence and validation; do not silently modify preserved snapshots.
- `builds/pre-2017/reconstruction/src/` is the newer named working source (5,519 files): 474 newly named Minecraft classes and MCP names for 8,553 methods/1,757 fields. Read its README and evidence under `reconstruction/names/`. It is not a complete rebuild. New source edits may intentionally differ from the generated baseline hashes; never confuse them with the immutable historical snapshot.
- `builds/pre-2017/reconstruction/startup/` records a later static classpath preparation: 15,069 original-name classes plus 2,110 byte-identical resource entries in ignored local JARs. Read its README before adapting the loader: exported addURL/registerTransformer are no-ops, existing mod hooks are already embedded, and tfb native initialization remains unresolved. The Java 8 dependency inventory is static and includes optional/shadowed references, not demonstrated runtime failures. Tools: `audit_pre2017_classpath.py`, `prepare_pre2017_classpath.py`, `test_pre2017_classpath.py`. No game or verifier has run.

Run `git status` before editing. Keep builds, assets, worlds, and runtimes separate. Do not move existing local launch paths merely to make the directory tree symmetric. Write new public-facing documentation in English unless the user requests otherwise; historical research may remain in its original language.

## Execution and publication

Original client archives, JARs, DLLs, EXEs, memory dumps, full worlds, and downloaded tools remain outside Git. Never modify the originals. Existing local runtime and game sessions must not be interrupted.

Unknown executables and launchers must not be run automatically. The user's earlier authorization covered a diagnostic Java `-version` run, not gameplay or account login. Following a reported Windows crash, protected-JVM launches and memory experiments remain stopped; the crash cause has not been established. Continue static analysis unless later user instructions authorize more.

Full source compilation has not succeeded for either build. Original client212 gameplay was launched locally; pre-2017 gameplay and recovered game classes have not been executed. Do not equate a structural check or an error-free decompiler exit with a successful rebuild.

The user selected the public GitHub repository name `stalcraft-reconstruction`, reviewed and expanded the README, and explicitly authorized publication on 4 October 2026. The target repository is `https://github.com/Nerawlox/stalcraft-reconstruction`. This authorization covers the prepared code, tools, and research text; excluded original binaries and memory captures remain local.
