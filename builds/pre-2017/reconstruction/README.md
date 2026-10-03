# Name recovery and reconstruction

This is a separate working layer. The original CFR snapshot in `../decompiled-standard` remains unchanged. The named source tree is an analysis baseline, not a complete rebuild or a runnable client.

## Current name recovery

- 474 custom class names mapped to Minecraft SRG identities, plus 161 classes already carrying their SRG names.
- 8,553 method declarations and 1,757 field declarations renamed using unambiguous MCP 8.11 identifiers.
- All 6,975 main-archive and 8,094 dependency classes reparsed after remapping.
- All 114,489 method Code arrays and literal strings preserved; no class-path or member-signature collisions found.
- Conflicting client/server MCP names are retained as SRG identifiers instead of selecting a name arbitrarily.
- 123 conflicting MCP identifiers remain unchanged. The six CFR flow/type warning files are the same as in the original snapshot; no failed-method markers were found in the new main source tree.

These are evidence-based class identity inferences, not a claim that every original developer name has been recovered. Mod-specific `_a` names and many obfuscated classes remain.

MCP member names are dictionary aliases selected by unambiguous SRG token across declarations and references, including mod overrides. A separate owner/signature audit of those overrides remains part of preparation for a full build; this stage does not establish original private mod-member names.

## Read the improved source

The generated source tree is [src](src/). Start with [StalcraftMod.java](src/com/stalcraft/StalcraftMod.java), where `twgu` becomes `Block`, `tgbl` becomes `CreativeTabs`, and SRG setters become readable names such as `setCreativeTab` and `setUnlocalizedName`.

The 1,536 MiB CFR attempt completed successfully and produced all 5,519 main-archive Java files. This does not establish that every decompiled method is correct or that the source compiles.

Source files remain decompiler output. Class names, packages, descriptors, generic signatures, and annotation type references are updated through bytecode metadata rather than a text-wide replacement. String literals, including reflection and ASM-transformer targets, are deliberately preserved and require a separate audit before using remapped bytecode at runtime. No game code was executed.

## Evidence

- [minecraft-classes.json](names/minecraft-classes.json) records each class correspondence, supporting declarations/type constraints/string anchors, and validation results.
- [named-bytecode-validation.json](names/named-bytecode-validation.json) records input/output hashes and corpus-wide remapping checks. Bytecode JARs are excluded from Git.
- [mcp811](names/mcp811/) contains hash-pinned text dictionaries and provenance. The archive identifies its client/server version as 1.6.4 and MCP version as 8.11. The archive itself remains local.
- [named-source-snapshot.json](names/named-source-snapshot.json) records CFR execution and the generated source baseline hashes.
- [cfr-512m-failed.json](names/cfr-512m-failed.json) retains the initial incomplete attempt: CFR exhausted its 512 MiB heap after 2,326 Java files. The incomplete sources remain in local cache, separate from the successful output.
- [review-validation.json](names/review-validation.json) records interface checks, nested-generic regression checks, and identical payloads for all 15,069 classes after strengthening the remapper. Mapping reproduction with different Python hash seeds also produced identical evidence.

Class matching uses declared SRG fields/methods and their descriptors, then propagates constrained type identities. Unmodified declaration fingerprints require known type agreement and unique string anchors; candidates without string anchors additionally require matching instruction fingerprints. Overloaded descriptors, hierarchy, class kind, and one-to-one destinations are checked. Ambiguous matches remain unmapped.

The readable MCP archive came from an archival mirror, with its historical MD5 corroborated by a [Forge setup record](https://forums.minecraftforge.net/topic/62152-164-valid-hash-for-compiling/). SHA-256 pins the retrieved archive and CSV files. The remapper follows the [Java 8 class-file format](https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html) for descriptor and annotation references.

## Reproduction

The scripts live in the repository's `scripts/` directory:

1. `recover_minecraft_names.py`: supply the normalized main JAR, official vanilla 1.6.4 JAR, bundled SRG, and an output class map. Reads class declarations only.
2. `remap_named_bytecode.py`: supply normalized JARs, the class map, and `names/mcp811` dictionaries. Produces separate named JARs and a validation report.
3. `decompile_named_sources.py`: supply a trusted Java, pinned CFR 0.152, validated named JARs, and a fresh output directory. Existing source trees are never overwritten. The successful attempt uses a 1,536 MiB heap limit.

All original binaries and runtime images are local prerequisites. Paths recorded in reports refer to the research machine; configuring a portable full build remains future work. Editing this working source is allowed, while the historical decompiler snapshot remains preserved.

Run `python scripts/check_name_recovery.py` from the repository root to check the generated baseline and generic regression cases. After intentional working-source edits, baseline differences are expected; retain the recorded baseline hashes as evidence rather than silently resetting them.
