# Recovered STALCRAFT entrypoints: static findings

Scope: the standard-bytecode restoration and CFR output under `decompiled-standard/classes/com/stalcraft/`. This is a static review of `StalcraftMod`, `ClientProxy`, and `ServerProxy`; no Java, EXE, DLL, game, or authentication flow was run. Decompiler output can misstate source-level details, but recovered class identity and constant-pool checks support that these are the intended classes.

## What the entrypoints do

`StalcraftMod` is an FML mod entrypoint. Its annotation declares mod id/name `STALCRAFT`, version `1.1`, and `required-after:GloomyCore`; `@NetworkMod` declares `clientSideRequired=true` and `serverSideRequired=true`, with version bounds `1.1.0` (`decompiled-standard/classes/com/stalcraft/StalcraftMod.java:45-46`). FML injects a sided proxy selecting `ClientProxy` or `ServerProxy` (`:53-54`).

`preLoad` is empty (`:81-83`). During initialization, `load` calls `proxy.preload()`, registers three entities, blocks, tile entities, and display names, then calls `proxy.load(event)` (`:85-130`). Post-initialization only calls `proxy.postload(event)` (`:133-136`). These operations register mod content; the class does not construct a world, start an integrated/dedicated server, choose a save, or connect to a remote server.

`ServerProxy` is a no-op base proxy: all three lifecycle methods have empty bodies (`decompiled-standard/classes/com/stalcraft/ServerProxy.java:9-18`). `ClientProxy` extends it and in `preload()` registers client event handling and entity/block/tile renderers, with model paths under `/assets/stalcraft/models/` (`decompiled-standard/classes/com/stalcraft/ClientProxy.java:43-82`). Its `load` and `postload` only delegate to the empty superclass methods (`:84-92`). No singleplayer/offline condition or world-start action appears in these proxy bodies.

## Offline, singleplayer, and network interpretation

There is no `SINGLEPLAYER` or offline gate in these three entrypoint classes, and no world-creation or remote-connect call. They do not themselves force online play or prevent singleplayer. This does **not** prove that the complete client works offline: other code, native bootstrap, authentication, or external services may impose requirements outside these entrypoints.

The `@NetworkMod` declaration is a multiplayer/server compatibility requirement for the STALCRAFT mod: Forge expects the mod on both client and server and version compatibility at `1.1.0` (`StalcraftMod.java:46`). This is not evidence of an internet login or central account server. The inspected classes declare no packet channel/handler, endpoint, URL, authentication call, or explicit send/connect operation. Other bundled mods and obfuscated client classes contain network code, so conclusions about the entire client must not be projected from this entrypoint subset.

No evidence in these three classes establishes whether the original distribution included a runnable official server, an account service, or a standalone singleplayer UI path. They are Forge lifecycle/proxy glue around registered content and client rendering.

## Evidence files

- `decompiled-standard/classes/com/stalcraft/StalcraftMod.java`
- `decompiled-standard/classes/com/stalcraft/ClientProxy.java`
- `decompiled-standard/classes/com/stalcraft/ServerProxy.java`
- Corrected class-stream validation: `classfile-stream-format.md`, `verify_classfile_stream_transform.py`, and `verify-classfile-stream-transform.json`.
