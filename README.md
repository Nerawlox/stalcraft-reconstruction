# STALCRAFT Reconstruction

Research and reconstruction of old STALCRAFT clients. This repository records recovered Java code, analysis tools, experiments, and progress toward rebuilding the clients.

It is an independent research project. The recovered code is decompiler output, not the original developer source tree. Neither build has a complete source rebuild yet.

## What's the point of this project RU/EN

Я играл в эту игру с 10 лет, с ней связано гигантское количество воспоминаний, при этом в интернете нет проектов, возвращающих именно тот игровой опыт, который я помню. Я активно играл в 2016-2019 годах, игра постоянно улучшалась в лучшую сторону технически, но где-то по пути абсолютно растеряла все то, что меня в ней привлекало. Поэтому считаю своим обязательством попытку восстановления, некая дань уважения игре и ее сообществу. Не знаю насколько этот проект имеет смысл, но зато это весело.

I've been playing this game since I was 10 and I have tons of great memories with it, but there's not a single community project that can give me the same experience I have such a clear memory of. I was actively playing in 2016-2019, the game was constantly evolving and getting better but it lost its soul and the very thing making it so valuable to me somewhere along the way. So I consider this restoration attempt my obligation and a tribute to the game and its community. I have no idea if this project makes sense but at least it's pretty fun.

## Builds

| Build | Dating and provenance | Current state |
| --- | --- | --- |
| [client212](builds/client212/) | **Личная оценка / personal assessment:** очень тяжело сказать, какого года эта сборка; по моим воспоминаниям, она выглядит старше версии, в которую я начал играть в 2016. Отсутствуют почти все знакомые мне локации, поэтому это может быть неполный билд. **Build and map dates are unknown.** Identified by `stalker_client212.jar`; the downloaded package name does not establish authorship or official origin. | 748 Java source files recovered. Local launch of the original client confirmed; full source rebuild pending. |
| [pre-2017](builds/pre-2017/) | Предзагрузка файлов ОФТ, опубликованная в официальной ВК группе STALCRAFT **3 ноября 2017 года**. OFT preload package published in the official STALCRAFT VK community on **3 November 2017**: [source post](https://vk.ru/wall-2677092_317761). Files carry timestamps from 29 October 2017; these are separate from the post publication date. | Protected class format and opcode mapping recovered. 10,047 Java source files produced. Full source rebuild and gameplay launch pending. |

### A note on client212 dating

The main JAR has ZIP timestamps from October 2018, and the world has a `LastPlayed` value from February 2019. These are file and save metadata: they do **not** establish when the client was released, when the map was created, or which version was originally distributed.

The name of the downloaded package is retained in historical provenance records as a source label. It is not used as the build identifier or as an attribution of the code or map.

## What has been recovered

For `pre-2017`, all 30,715 protected class payloads were decoded, including the bundled Java runtime image. The recovered class structure, names, padding, and instruction boundaries were checked. CFR produced 5,519 Java files from the main archive and 4,528 from its dependencies.

Encryption recovery does not restore names removed by obfuscation, comments lost during compilation, or the exact original source structure. Some methods still require comparison with bytecode and alternative decompilers. Structural checks are not a substitute for Java verification, compilation, or gameplay testing.

The protected native JVM has not been fully devirtualized into a runnable replacement. Native dependencies and startup behavior still need investigation. See the [restoration journal](docs/restoration-journal.md) and the [current pre-2017 status](builds/pre-2017/analysis/restoration-status.md).

## Repository layout

```text
builds/
  client212/                 Build identity, dating caveats, and links
  pre-2017/
    decompiled-standard/     Preserved CFR output: classes and libraries
    decompiled-alternatives/ Separate Procyon results for comparison
    analysis/                Recovery scripts, reports, and experiments
    recovered-bytecode/      Recovery and normalization reports, without JARs
src/                         Preserved client212 CFR output
resource-configs/            Original client212 configuration snapshot
scripts/                     Snapshot checks and existing local tools
docs/                        Research notes and restoration journal
research/                    Search for other builds and provenance
```

The existing `client212` paths remain in place to preserve its local launch tools and Git history. Each build has its own recovered code and research material; files and environments from different builds are kept separate.

Future source changes belong in a separate `reconstruction/` directory for the relevant build. Preserved decompiler snapshots remain unchanged so that every manual correction can be compared with the original output.

## Reading and verifying the code

Browse [client212 sources](src/) or [pre-2017 game sources](builds/pre-2017/decompiled-standard/classes/). These directories are useful for reading and analysis; opening them in an IDE does not provide a ready-to-build or ready-to-run project.

With Python 3.9 or newer, verify both preserved snapshots:

```sh
python scripts/verify_research_snapshots.py
```

This only checks file hashes and inventories. It does not run Java, the game, or diagnostic experiments.

Research scripts document the methods used. Some depend on original local files, Windows tools, separately installed libraries, or paths from the research machine; there is no single portable reconstruction command yet.

## History and scope

Existing Git commits preserve the earlier client212 work. Previously completed pre-2017 research is imported as a documented snapshot, with successful and failed experiments recorded in the reports. New reconstruction work is recorded through subsequent commits; past experiments are not assigned fabricated commit histories.

Original client archives, executable binaries, runtime environments, memory dumps, downloaded tools, and complete worlds are kept outside Git. Their relevant hashes and analysis results are preserved in text reports. Some historical reports are in Russian and contain local file paths or links to artifacts that are not included here.

This repository does not establish official authorship, a complete server implementation, or a working offline version of the 2017 client. Recovered third-party code retains its original ownership; no blanket license is applied to the recovered code.
