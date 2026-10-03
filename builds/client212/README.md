# client212 — build date unknown

The identifier `client212` comes from the filename `stalker_client212.jar`. It does not identify an author, an official release number, or a date. The distributor name in the downloaded package is only a source label; the authorship and origin of its contents have not been established.

## Dating evidence

- ZIP entries in the main JAR have timestamps from October 2018.
- The supplied world has a `LastPlayed` value from February 2019.
- Neither value establishes when the map was created, when the code was written, or when the client was released.
- The suggested map date around 2015 remains unconfirmed. Client and map dating, and official provenance, are open questions.

Minecraft 1.6.4, Forge 9.11.1.1345. Main JAR SHA-256: `3f37140d3b75fcd78c4f78481a478239d174adfb3ae5a2643eb16cd2fde31901`.

## Materials and status

Existing paths are retained to preserve the local tools and runtime:

- [src](../../src/) — original CFR snapshot, 748 Java files.
- [resource-configs](../../resource-configs/) — original configuration snapshot.
- [CLIENT212.md](../../CLIENT212.md) — historical decompilation report in Russian; some launch statements have since been superseded.
- [environment-check.md](../../docs/environment-check.md) — observed local launch state and remaining problems.
- [provenance.json](../../provenance.json), [snapshot-sha256.json](../../snapshot-sha256.json) — input evidence and snapshot verification.

Local launch of the original client is confirmed. A complete rebuild from decompiled source is not ready. The map and client may have different origins and dates.
