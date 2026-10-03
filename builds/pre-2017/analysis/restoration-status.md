# Восстановление байткода STALCRAFT Pre — 04.10.2026

Все 30 715 защищённых записей восстановлены в class files. Восстановлены также оригинальные внутренние имена из constant pool; для каждого имени проверено соответствие MD5 с солью исходному имени payload. При восстановлении оригинальные файлы только читались.

| Источник | Классов | Методов с Code | Инструкций | Ошибок формата/переходов |
| --- | ---: | ---: | ---: | ---: |
| classes.jar | 6 975 | 53 928 | 1 690 079 | 0 |
| libs.jar | 8 094 | 60 561 | 1 557 614 | 0 |
| Java JIMAGE | 15 646 | 131 836 | 4 064 295 | 0 |

## Что пришлось восстановить

1. Имена ресурсов: MD5 внутреннего пути с солью `nUHDjbS59e4wF8Pr`.
2. Блоковый CBC-шифр с собственными S-box/матрицей смешивания. NumPy-версия побайтно сверена с эмуляцией native-функции на `java/lang/Object`.
3. ClassFileStream: два начальных seed bytes, marker `0xe629` и преобразование с двумя предыдущими байтами/вращением/16-byte таблицей. Правильный адрес таблицы — RVA `0xa2fd40`; прежний `0x9f3d40` был ошибкой арифметики RIP-relative address.
4. Нулевое заполнение длиной 1..16 байт после конца класса. Конец определяется полным разбором структуры, а не удалением всех конечных нулей.
5. Перестановка кодов JVM-инструкций: например, protected `0x3f` означает стандартный `aload_0`. Офлайн-эмуляция native `Bytecodes::initialize` дала 239 имён, включая все 203 стандартных кода. Заменяются только байты opcodes, включая вложенный opcode после `wide`; операнды и все offsets сохраняются.

Полная девиртуализация VMProtect для этого не потребовалась. Защищённые API helper изучены отдельно; восстановление Java-классов не означает получения новой runnable DLL.

## Файлы и воспроизведение

Использовать `../recovered-bytecode/classes-standard.jar`, `libs-standard.jar`, `jimage-standard.jar`. Промежуточные `*-recovered.jar` сохраняют custom opcodes и не предназначены для обычного декомпилятора или Java.

Скрипты в analysis:

- `recover-protected-classes.py --source all` — CBC/stream/structure/hash; пишет class-only JAR и `*-recovery.json`.
- `extract-opcode-map.py` — ограниченная офлайн-эмуляция initialization; пишет `opcode-map.json`. Стандартные номера сопоставлены с [OpenJDK9 bytecodes.hpp](https://github.com/openjdk/jdk9u/blob/master/hotspot/src/share/vm/interpreter/bytecodes.hpp).
- `normalize-class-opcodes.py` — исправление только opcodes и проверка инструкций/ветвей; пишет `*-standard.jar` и `*-opcode-normalization.json`.
- `decompile-restored.py --source classes` / `--source libs` — проверенный CFR0.152 на доверенной Java8. Восстановленные классы не исполняются.

Индивидуальные SHA-256 каждого class и итоговых JAR находятся в JSON-отчётах. Проверка границ/формата не заменяет Java verifier, компиляцию или игровой тест.

## Декомпиляция и дальнейшая работа

Оба архива декомпилированы с exit code0: 5 519 Java-файлов в `../decompiled-standard/classes` и 4 528 в `../decompiled-standard/libs`, всего 10 047. Внутренние классы обычно представлены внутри файла внешнего класса, поэтому число Java-файлов меньше числа class files. Окончательные результаты фиксируются в `cfr-standard-classes-result.json` и `cfr-standard-libs-result.json`.

В summary основного архива CFR отмечает проблемы восстановления структуры/типов у шести классов; полностью недекомпилированных методов основного архива по маркерам не найдено. В библиотечном выводе у трёх файлов есть `Exception decompiling`/`Decompilation failed`, у26 — предупреждения о структуре. Exit code0 не означает отсутствия таких ошибок в отдельных методах. Подробности — `cfr-classes-warnings.json`, `cfr-libs-warnings.json` и summary.txt обоих каталогов.

Для шести проблемных игровых классов и трёх библиотечных файлов получен альтернативный вывод [Procyon0.6.0](https://github.com/mstrobel/procyon/releases/tag/v0.6.0): все девять файлов без маркеров ошибок. Результат — `../decompiled-alternatives/procyon-core` и `procyon-libs`; методы Futures.setOneValue, LinuxCanvasImplementation.findVisualIDFromFormat и LinuxDisplay представлены телами кода. Это дополнительные версии для сопоставления, а не подтверждение пересборки/эквивалентности исходников. CFR-снимок не переписывался.

Расширенная проба всех библиотек с предупреждениями создала31 альтернативный файл в `procyon-libs-warnings`; у11 остаются маркеры ошибок Procyon. Не заменять ими успешный CFR автоматически. Отчёты: `procyon-core-recheck.json`, `procyon-library-recheck.json`, `procyon-library-warnings.json`. Происхождение/контрольная сумма инструмента — `decompiler-tools/procyon-provenance.json`; новые процессы использовали доверенную Java8 и лимит512MB, исходный игровой код не исполнялся.

Многие имена остались обфусцированы; имеются классы в unnamed package, на которые ссылаются именованные пакеты. Это допустимо для JVM bytecode, но мешает обычной компиляции Java-исходников и требует отдельного восстановления имён/пакетов. Все игровые class major versions не выше52 (Java8); Java JIMAGE преимущественно53 (Java9).

Дополнительная статическая проверка выбранных классов — `restored-code-operand-check.json`: типы CP-операндов, indices локальных переменных, switch/wide и границы exception handlers. Проверка не исполняет код и не заменяет Java verifier. Контрольные суммы двух исходных JAR и JIMAGE после восстановления совпали с первоначальными; снимок10 047 Java-файлов зафиксирован в `decompiled-source-sha256.json`. XML/JSON конфигураций IDE разобраны успешно.

Проверка operands охватила8 классов/111 методов и1594 CP-операнда без ошибок, включая StalcraftMod, оба proxy, GloomyCore, Launch/LaunchClassLoader, Futures и Object.

Полная пересборка, compatibility runtime и локальный мир ещё не подготовлены. Оригинальная защищённая Java по-прежнему блокирует диагностический запуск на проверке среды. Игра, лаунчер, учётная запись и восстановленные игровые классы не запускались. ServerProxy этого небольшого мода пуст; наличие серверной логики остальных модулей и возможность offline требуют отдельного анализа.
