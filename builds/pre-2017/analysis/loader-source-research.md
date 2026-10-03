# Исследование открытых источников по загрузчику и JVM STALCRAFT

Дата проверки: 2026-10-03. Задача: найти открытые первичные источники по раннему загрузчику, opaque class payload, GloomyFolken/EXBO и отделить Java runtime от asset/network layers. Исходный пакет не запускался; материалы ниже получены через публичные страницы/документацию. Неизвестные EXE/DLL и готовые unlocker-инструменты не использовались.

## Краткий результат

Самая полезная практическая зацепка — опубликованное сторонним автором описание launcher API с полем `runCommand`: оно указывает Java entry point `exbo.stalcraft.client.Main`, classpath `classes.jar;libs.jar;modassets`, системные свойства и аргументы процесса. Это конкретно связывает имена трёх элементов кандидата с архитектурой запуска STALCRAFT, но пример относится к более позднему клиенту и не раскрывает код раннего loader или шифрование классов. Высокая уверенность в том, что это документированная команда запуска позднего клиента; низкая в переносе точных флагов на пакет 2017 года.

Открытый проект самого GloomyFolken `HookLib` даёт проверяемую историю его обычных Forge coremod-трансформеров: `FMLCorePlugin`, `-Dfml.coreMods.load`, ASM/хуки. Это полезный контрольный пример GloomyFolken-слоя, но проект не содержит GloomyCore и не описывает opaque JAR формат STALCRAFT.

Ни один проверенный публичный первичный исходник не дал алгоритма имени 32-hex файлам, шифрования payload, hash-to-class mapping или специфического bootstrap для сборки 2017. Поэтому 32 hex пока следует считать непрозрачным идентификатором/именем blob: MD5-подобный вид сам по себе не определяет, хешируется ли имя класса, содержимое, путь или иной ключевой материал.

## Наиболее применимые источники

| Источник | Что подтверждает | Применимость к кандидату | Уверенность |
|---|---|---|---|
| [Официальный GitHub-аккаунт EXBO-Studio](https://github.com/orgs/EXBO-Studio/repositories) | В открытой организации видны `stalzone-database` и issue tracker `stalzone-api`; исходников клиента/лаунчера в этом списке нет. | Граница поиска: открытого EXBO source tree с loader не обнаружено. Не доказывает, что такого кода никогда не публиковали где-то ещё. | Высокая для текущего списка организации, низкая для общего вывода об отсутствии исходников. |
| [unofficial-stalzone-api README](https://github.com/Art3mLapa/unofficial-stalzone-api) | Документирует endpoints; в примере ответа `/listServers` приведён `runCommand`: `classes.jar;libs.jar;modassets`, main class `exbo.stalcraft.client.Main`, JVM flags и `--username`, `--session`, `--gameDir`, `--assetsDir`, `--dlogin`. README также описывает `launcher?list=true`, `/auth`, `/torrentData`, CDN и данные версий/размеров. | Самая конкретная карта разделения launch metadata, runtime, classpath/assets и backend/session. Это не официальный исходник и это поздняя схема; не считать доказательством наличия каждого флага/параметра в октябре 2017. Репозиторная история, которую удалось просмотреть, начинается в 2025 г. | Высокая для факта, что публичное README содержит эти команды; средняя для точности отражения сервиса; низкая для ретро-переноса на 2017. |
| [SteamDB: STALCRAFT Demo configuration](https://steamdb.info/app/2020940/config/) | Публичный launch config повторяет классический `classes.jar;libs.jar;modassets`, `exbo.stalcraft.client.Main`, `--gameDir`, `--assetsDir` и ряд `-D` свойств. | Независимая практическая сверка поздней схемы запуска; SteamDB не является исходником EXBO и информация поздняя. | Средняя для соответствия конфигурации конкретного Steam приложения; низкая для 2017. |
| [GloomyFolken/HookLib](https://github.com/GloomyFolken/HookLib) | README автора: библиотека упрощает трансформеры; для IDE указан `-Dfml.coreMods.load=...`; для JAR в `mods` описан manifest `FMLCorePlugin`; README объясняет injection static hooks и совместимость с Forge. GitHub профиль автора показывает HookLib среди трёх публичных репозиториев. | Прямой первичный код/описание GloomyFolken по Forge transformer-механике, полезно сопоставить с Forge 1.6.4. Не GloomyCore и не decryptor STALCRAFT. | Высокая по общему механизму HookLib; низкая по связи с opaque payload. |
| [Oracle Java SE 9 `ClassLoader`](https://docs.oracle.com/javase/9/docs/api/java/lang/ClassLoader.html) | Официальная API-документация объясняет custom loader: получить байты класса и `defineClass`; делегирование `loadClass`, `findClass`, `loadClassData`. | Точная runtime-модель, которая позволяет разделить «получение/декодирование байтов» от JVM верификации/определения класса. Не показывает, что именно делает EXBO JVM. | Высокая. |
| [JVMS 9, §5](https://docs.oracle.com/javase/specs/jvms/se9/jvms9.pdf) | Спецификация описывает loading/linking/initialization и `defineClass` contract. | Нормативная основа для проверки, на каком участке должны появиться корректные байты `CAFEBABE` classfile. | Высокая. |
| [Oracle Java launcher JDK 9](https://docs.oracle.com/javase/9/tools/java.htm) | Документирует системный class path и аргументы Java launcher. | Основа для интерпретации classpath и main-class/VM-argument порядка. | Высокая. |
| [EXBO Forum: проблема лаунчера (2022)](https://forum.exbo.net/d/93473-pomogite-problema-s-launcerom) | Пользователь опубликовал команду запуска 2022 с тем же `classes.jar;libs.jar;modassets`, `exbo.stalcraft.client.Main`, session/gameDir/assetsDir и `read_derived`, `load_dumped_event_classes`, `use_system_class_loader` и прочими флагами. | Подтверждает, что параметры из README встречались в живом запуске. Это пользовательский форум-пост, а не разработчик/launcher source; содержит пример session token, поэтому здесь токен намеренно не переписывается. | Средняя для того, что команда была опубликована/использовалась; низкая для назначения каждого свойства и ранней версии. |

## GloomyFolken, GloomyCore и EXBO

- Публичный профиль [GloomyFolken на GitHub](https://github.com/GloomyFolken) показывает три открытых репозитория: `HookLib`, `tcn2obj`, `SnowmanSolver`. В просмотренном каталоге нет `GloomyCore` или loader STALCRAFT.
- `HookLib` относится к стандартной Forge coremod архитектуре. Его readme — прямое первичное описание автора. Это показывает, что GloomyFolken публиковал код, работающий через FML core plugin и transformers, но нельзя приравнивать этот механизм к кастомному защищённому runtime.
- В организации [EXBO-Studio](https://github.com/orgs/EXBO-Studio/repositories) публичны база данных и API issue tracker, а не source клиента. Поэтому прямые исходники EXBO загрузчика в этой проверке не обнаружены.
- Не нашёл открытый репозиторий, содержащий названные свойства `read_derived`, `load_dumped_event_classes`, `use_system_class_loader` или формат 32-hex class payload. Открытые упоминания этих флагов — поздняя launcher command-line документация/пользовательские команды, а не раскрытие реализации.

## Как разделять runtime слои при дальнейшем исследовании

Наблюдаемая схема лучше проверяется по слоям отдельно; это не утверждение, что каждый слой уже доказан для каждого файла кандидата.

1. **Launcher metadata/process creation.** Сначала устанавливать executable, cwd, VM arguments, `-D` properties, `-classpath`, main class и `String[] args`. Поздняя команда указывает `exbo.stalcraft.client.Main`; в candidate нужно искать эти строки в readme/config/cache и проверять, какая версия параметров присутствует. Не переносить поздний `--session`/`--dlogin` автоматически.
2. **Native JVM/runtime integration.** `java.exe`/`java.dll`/`jvm.dll` отвечает за запуск, JNI и VM. VMProtect sections/exports — признак обработки бинарника, но не доказательство того, что native JVM сама расшифровывает классы. Проверять экспортные строки, импорты, манифесты, штатные имена, PE metadata и сопоставлять с Java loader evidence независимо.
3. **JIMAGE/JDK modules.** Исследование `lib/modules`/JIMAGE в кандидате — отдельная ветка от `classes.jar`/`libs.jar`. По переданным результатам анализа, в JIMAGE найдено около 18k encrypted/opaque имён и лишь 20 открытых `module-info.class`; стандартное извлечение JDK 9 модулей не даёт сами закрытые bootstrap-классы. Это свидетельство кастомизации bundled runtime, но связь JIMAGE entries с JAR blobs и точное назначение `-Dread_derived=true` пока не установлены. Нельзя использовать обычный успешный `jimage extract` как доказательство, что opaque payload является стандартным JIMAGE.
4. **Class resolution/decode.** JVM получает класс через обычный classpath или custom/system loader; слой до `ClassLoader.defineClass` обязан предъявить classfile bytes. Разделить идентификатор JAR entry (32-hex), mapping `binary class name -> entry`, header/transform, декомпрессию и дешифрование как отдельные неизвестные. Сигнатура `CAFEBABE` — критерий уже декодированного Java classfile, а не идентификатор алгоритма.
5. **Forge/Gloomy transformer.** Transformers обычно получают/изменяют уже найденный class bytecode; HookLib README показывает эту модель. Это потенциально слой после чтения payload, а не автоматически способ расшифровки JAR.
6. **Assets/modassets.** `modassets` может быть обычным directory classpath element и одновременно деревом ресурсов. Отдельно анализировать `assets`/`modassets`, моды и opaque `.class` blobs. `sc-file` поддерживает OL/MIC и прочие asset formats; его заявленная область не подтверждает поддержку Java bytecode.
7. **Backend/session/network.** `--session`, `--username`, `--dlogin`, backend addresses и CDN/torrent metadata относятся к authentication/service/content delivery. Даже если сервер доставляет идентификатор или ключ, это не докажет локальный формат байт-кода без наблюдаемой связи с loader.

Для статического следующего шага безопаснее строить таблицу классов/entries и проверять офлайн: одинаковы ли 32-hex имена в `classes.jar`/`libs.jar`; пересекаются ли с 32-hex native exports; есть ли стабильные префиксы/размеры/парные entries; встречаются ли в ASM dumps имена loader methods; есть ли дубли по хешу содержимого; согласуется ли имя с candidate `asmdata` и `mcmod.info`. Все совпадения считать эвристикой до установления точного алгоритма/документации.

## Что известно про имя/hash формат

Публичные run commands говорят, где JVM ищет содержимое, но не описывают внутреннее имя payload. Ровно 32 шестнадцатеричных символа дают 128 бит визуального представления, но это может быть MD5, произвольный 128-bit ID или строка, полученная иной функцией. Нельзя выводить алгоритм из длины и алфавита. CDN API в неофициальной документации показывает отдельные 40-hex file hashes для distribution chunks; без совпадения конкретного значения с candidate это другой формат/слой и не доказательство схемы class entries.

## Не найдено / ограничения

- Не найден первичный open source STALCRAFT/EXBO loader, GloomyCore source, decryptor source или документированный class-name/hash format за 2015–2019.
- Не найдено подтверждение, что опубликованная поздняя launcher command совпадает с ранней загрузкой до ОФТ. Candidate readme и локальные PE/JAR находки сохраняют больший вес для его версии.
- Официальный launcher endpoint `launcher.stalcraft.net/listServers` не удалось открыть через используемый web reader; конкретное `runCommand` найдено в публичной неофициальной копии его схемы.
- Репозитории/форум 2022+ помогают понять позднюю архитектуру и терминологию, но не датируют механизм в архиве 2017.

## URL перечень

- https://github.com/orgs/EXBO-Studio/repositories
- https://github.com/Art3mLapa/unofficial-stalzone-api
- https://github.com/GloomyFolken
- https://github.com/GloomyFolken/HookLib
- https://docs.oracle.com/javase/9/docs/api/java/lang/ClassLoader.html
- https://docs.oracle.com/javase/9/tools/java.htm
- https://docs.oracle.com/javase/specs/jvms/se9/jvms9.pdf
- https://steamdb.info/app/2020940/config/
- https://forum.exbo.net/d/93473-pomogite-problema-s-launcerom
- https://github.com/onejeuu/sc-file

## Дополнительный целевой поиск: OpenJDK PDB, exports и исторические аргументы

Проверены точные строки и варианты поиска для признаков, переданных из статического анализа кандидата:

- PDB путь `c:\Projects\OpenJDK\jdk9_\build\windows-x86_64-obfuscated-custom-release\support\native\java.base\java_objs\java.pdb`;
- hex-имена `JLI_Launch` → `9b490ffc0189e74ef6ca6c1079e09043` и `JLI_InitArgProcessing` → `137bc867174a904f42a8efa61d836687`;
- JVM properties `read_derived`, `use_system_class_loader`, `load_dumped_event_classes`;
- возможные старые main-class имена `com.stalcraft.Main`, `com.stalcraft.client.Main`.

Точные PDB path и оба export hash не дали публичных индексируемых совпадений. Поиск `com.stalcraft.Main` / `com.stalcraft.client.Main` и комбинаций с `classes.jar` также не дал результатов. Из этого нельзя выводить, что строки нигде в публичных/архивных данных не встречаются; только что доступный веб-поиск их не обнаружил.

Полезный контрольный первичный источник — [OpenJDK 9 build documentation](https://github.com/openjdk/jdk9/blob/master/common/doc/building.md). В нём OpenJDK объясняет, что каталог сборки зависит от конфигурации, а допустимые HotSpot variants включают `custom`; документированные debug levels — `release`, `fastdebug`, `slowdebug`, `optimized`. В примерах периода 2017 обычная конфигурация именуется `windows-x86_64-normal-server-release` ([build-dev, October 2017](https://mail.openjdk.org/pipermail/build-dev/2017-October/019883.html)). Поэтому observed `windows-x86_64-obfuscated-custom-release` согласуется с OpenJDK 9 custom HotSpot variant и конфигурационным label `obfuscated`, но `obfuscated` не является стандартным документированным debug level/variant. Из имени build directory нельзя установить, какая патч-система или алгоритм использовались. Сам PDB path, сообщённый для локальной сборки, подтверждает происхождение файла из дерева, названного `OpenJDK\jdk9_`, но не открытый публичный repo/commit.

Официальная документация JDK 9 по build variants говорит, что `custom` JVM по умолчанию собирается без набора HotSpot features; feature list выбирается при configure. Это делает `custom` важным термином для дальнейшей проверки build config, но не означает, что сам вариант obfuscates символы или шифрует JIMAGE. `JLI_Launch` и `JLI_InitArgProcessing` — функции launcher layer; переименование именно этих exports показывает обработку native launcher symbols, но без mapping/patch source не раскрывает payload format или Java class entry hash.

### Наиболее ранние найденные публичные даты launch arguments

- [SteamDB STALCRAFT Demo configuration](https://steamdb.info/app/2020940/config/) указывает `First seen on SteamDB: 31 May 2022` и уже содержит `-Dread_derived=true`, `-Dload_dumped_event_classes=true`, `-Duse_system_class_loader=true`, `exbo.stalcraft.client.Main`, `--gameDir`, `--assetsDir`. Это надёжный нижний предел для индексируемого SteamDB снимка этой комбинации; не дата появления самих флагов в разработке.
- [EXBO Forum, 2022 launcher issue](https://forum.exbo.net/d/93473-pomogite-problema-s-launcerom) также показывает `exbo.stalcraft.client.Main` и те же properties вместе с session/backend args.
- Поздняя схема потом меняется: [SteamDB STALZONE](https://steamdb.info/app/1818450/config/) показывает `exbo.stalcraft.engine.clientcore.Main`; значит main class зависит от периода/ветки, и его нельзя экстраполировать назад с современного клиента.
- В доступных indexed sources не найдены старые команды 2015–2019 и ни одного подтверждённого `com.stalcraft.Main`/`com.stalcraft.client.Main`. Для раннего кандидата локальные metadata, ASM dumps, manifests и cached launch config остаются приоритетнее этих поздних примеров.

### Текущий ответ на вопрос о конкретном алгоритме

Пока **нет найденного публичного конкретного алгоритма** для 32-hex class entry names, mapping имени класса в JAR, шифрования/дешифрования JIMAGE modules или защиты OpenJDK native exports. Нет также публично подтверждённой расшифровки `read_derived` либо `use_system_class_loader` в контексте 2017–2019. Доступные источники подтверждают лишь позднее присутствие этих флагов и общую OpenJDK `custom` configuration semantics. Hash-shaped export identifiers и PDB build label — сильные локальные clues о переработанной JDK/launcher сборке, но это не алгоритмический источник.
