# Repository preparation

The intended GitHub repository is `stalcraft-reconstruction`, containing separate research for `client212` and `pre-2017`. The local checkout remains at its existing path, `E:\Stalcraft project\stalcraft-decompiled`, to preserve launch tools and Git history.

The user reviewed and expanded `README.md`, then authorized publication on 4 October 2026. The public repository is `https://github.com/Nerawlox/stalcraft-reconstruction`; `origin` uses that repository. The user's bilingual project introduction is retained.

## Preserved history

Existing commits record client212 decompilation, resource-pack configuration, intentional Cyrillic region extensions, and gameplay research. Completed pre-2017 work is imported as a text snapshot with a retrospective journal. Historical experiments are not assigned invented backdated commits.

The client212 identifier comes from a filename, not a distributor name. Its client and map dates remain unknown. The preload's source VK post was published on 3 November 2017, confirmed by the contributor; its October file timestamps describe a separate event.

## Snapshot checks

```sh
python scripts/verify_research_snapshots.py
```

This validates both preserved source snapshots and imported research files. It does not execute Java, the game, or diagnostic scripts. Exact imported bytes are protected by `.gitattributes` so recorded hashes remain valid after cloning.

New source fixes should be separate from the preserved decompiler output. Research scripts may require separately acquired originals, tools, libraries, and local path configuration.

## Excluded material

Client archives, executable binaries, runtime environments, full worlds, memory captures, and downloaded tools stay on the research machine. Input hashes, inventories, recovery results, and relevant text logs document those artifacts without uploading them.

Original source ownership is not reassigned by this research, and the repository does not apply a blanket open-source license to recovered third-party code.

## Windows path length

Some generated Forge event class names create very long paths. This checkout uses the repository-local setting `core.longpaths=true`; no Windows system settings were changed. For a future clone with Git for Windows, use `git -c core.longpaths=true clone <repository-url>` and set `git config core.longpaths true` inside the resulting checkout. Other tools may have their own path-length limits.
