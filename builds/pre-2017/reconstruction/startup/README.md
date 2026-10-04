# Static startup preparation — 4 October 2026

A separate, non-executed classpath now contains all 15,069 recovered application/dependency classes and 2,110 original resource entries. This is preparation for an ordinary-Java adaptation, not a launcher or a successful game test. Original binaries and both source snapshots remain unchanged.

## Resources restored to the preparation

The normalized `classes-standard.jar` and `libs-standard.jar` contain only classes: both have zero resource entries. Using those two archives alone omits Forge version/configuration files, bundled textures, and library resources. The original archives still contain those bytes.

`scripts/prepare_pre2017_classpath.py` creates an isolated directory containing byte-identical copies of the two normalized archives and separate `classes-resources.jar`/`libs-resources.jar` companions. It excludes encrypted 32-hex class payloads and empty `.class` placeholders. All copied class identities and all resource hashes are checked. The resource companions contain 2,047 and 63 entries respectively, totaling 10,828,632 uncompressed bytes. The native DLL resources remain ZIP entries; nothing is extracted as a runnable native library or loaded.

The preparation restores `fmlversion.properties`, `mcmod.info`, `forge_at.cfg`, `fml_at.cfg`, and `deobfuscation_data-1.6.4.lzma`. It does not copy the external `modassets` tree or configure a game directory. [classpath-preparation.json](classpath-preparation.json) records every copied resource and the local output paths.

The preparation uses original recovered class/member names. Readable named JARs remain an analysis layer because reflection, hook annotations, and generated ASM strings need an owner/descriptor audit before their runtime use. No library from `client212` is added to the 2017 application classpath. Its separately installed, ordinary Java 8 runtime is used only as a read-only reference for the following audit.

## Loader findings

The declared profile uses LaunchWrapper/FMLTweaker. The recovered source describes `Launch` → `FMLTweaker` → `net.minecraft.client.main.Main`.

The recovered `LaunchClassLoader` is a bridge to another loader rather than a complete ordinary LaunchWrapper implementation:

- `addURL(URL)` and `registerTransformer(String)` each have the one-byte Code body `b1` (`return`).
- `loadClass(String, boolean)` has a ten-byte body throwing `RuntimeException`.
- `loadClass(String)` delegates to `mainClassLoader`.
- `getClassBytes(String)` has a 23-byte body reading `mainClassLoader.getResourceAsStream(name)` without converting a binary class name to a `.class` resource path.
- Its reflective `ClassLoader.class.getMethod("findClass", String.class)` lookup requests a public method; the ordinary Java 8 declaration is protected. The constructor catches this lookup failure. It is not, by itself, an uncaught startup failure.

These Code bodies are recorded in [classpath-java8.json](classpath-java8.json), not inferred solely from CFR text. The constructor's generic/varargs expression still needs careful reconstruction; no constructor null-pointer failure is asserted.

Some transformations are already embedded in the recovered classes: [Main.java](../src/net/minecraft/client/main/Main.java) calls `GloomyStartHooks.main`; [ModClassLoader.java](../src/cpw/mods/fml/common/ModClassLoader.java) calls `ModListHooks`; `ASMEventHandler` also contains mod-list hooks. Replacing the bridge with a stock transforming loader could apply some changes twice. A compatible loader must preserve this distinction; a stock LaunchWrapper replacement is not yet validated.

## Dependency and native findings

The static audit parsed 15,069 application classes against 23,931 classes from an ordinary Java 8 runtime. Application class-file major versions range from 45 to 52. That is a format observation, not Java verification or proof of runtime compatibility.

The audit found 81 unresolved type names in constant pools/declarations. Some belong to optional UI-design, test, OpenGL ES, or server integrations. Two names are movement-anticheat classes referenced by SmartMoving's server-side classes. The inventory also contains `java/util/list` referenced by `ozlu`; this unusual lowercase name needs investigation. Every unresolved reference must be assessed by its actual execution path: the count does not mean 81 missing libraries or 81 startup failures.

It also found 198 bootstrap member signatures absent from the supplied Java 8 declarations. Most are references from old bundled cryptography classes whose names are shadowed by ordinary bootstrap classes: 70 application class names overlap the reference runtime. After excluding callers shadowed by bootstrap classes, only two candidates remain, both from `com/sun/crypto/provider/SunJCE_af`. The audit records those callers separately. These are declaration-existence candidates, not demonstrated `NoSuchMethodError` failures; access rules and Java verification are not checked.

[Protection.java](../src/ru/hoshimin/Protection.java) unconditionally loads `tfb64`/`tfb` during static initialization and declares three native methods. [AnticheatMod.java](../src/gloomyfolken/mods/anticheat/AnticheatMod.java) calls `startAntiMacros` on the client and later `closeHandles`. No separately named `tfb`/`tfb64` library was found in the unpacked package or the original JAR resource inventory. This is a conditional blocker on an ordinary JVM if initialization reaches that path without a native provider. It does not establish whether the protected original JVM supplied that functionality internally, and no replacement/stub has been installed. The mod also requires `GloomyCore` and `mod_SmartMoving`.

The corpus has 2,617 native method declarations, including many platform/library variants. This does not mean 2,617 separate native dependencies. DLL resources exist for LWJGL/JInput and other libraries, but architecture, extraction, exports, and actual loading remain untested.

## Reproduction and next boundary

Run from the repository root, supplying local originals and a **new** destination/report:

```sh
python scripts/prepare_pre2017_classpath.py --original ORIGINAL_DIRECTORY --normalized NORMALIZED_DIRECTORY --output NEW_LOCAL_DIRECTORY --report NEW_REPORT.json
python scripts/audit_pre2017_classpath.py --application classes-standard.jar --application libs-standard.jar --bootstrap JAVA8_RT.jar --bootstrap JAVA8_JCE.jar --report NEW_AUDIT.json
python scripts/test_pre2017_classpath.py
```

Repeat `--bootstrap` for each runtime archive recorded in the audit to reproduce its full scope. The scripts only read ZIP/class bytes and write preparation files/reports; they do not start Java or initialize game classes. Resource archives use fixed ZIP timestamps, and source inputs are SHA-256 pinned. Four static regressions cover array/descriptor references, inherited members versus constructors, bootstrap shadowing, and resource/path boundaries.

The next implementation boundary is a compatible ordinary-Java loader for already transformed recovered classes, followed by controlled verification. Native anti-cheat handling, exact optional dependencies, external asset paths, and full source compilation remain unresolved. No protected JVM, game, account login, or server connection was executed in this stage.
