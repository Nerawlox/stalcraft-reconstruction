# Статическое сопоставление hex-имён JAR и exports

Уникальных текстовых вариантов: 5,095,842; базовых проверок (3 алгоритма × 2 кодировки): 30,575,052; дополнительных проверок JLI с salt/separator/NUL: 207,036.
Экспорты jvm.dll: 3,551, из них 32-hex: 3,551.
Прямые совпадения hex-имён JAR payload с exports: 0.
Попадания проверенных хешей в exports/JIMAGE/JLI pairs: 0; salted JLI hits: 0.
Совпадений basename libs.jar↔Java 9 modules: 71 (побайтно идентичных: 0).

## Счётчики по алгоритмам и кодировкам

md5 / utf-8: 5,095,842 проверок, 0 попаданий
md5 / utf-16le: 5,095,842 проверок, 0 попаданий
sha1 / utf-8: 5,095,842 проверок, 0 попаданий
sha1 / utf-16le: 5,095,842 проверок, 0 попаданий
sha256 / utf-8: 5,095,842 проверок, 0 попаданий
sha256 / utf-16le: 5,095,842 проверок, 0 попаданий

## Сводка источников кандидатов

JAR classes/libs записей: 9,383 / 8,447.
ASM dump файлов: 48; извлечено разных строк с точками/слешами: 413.
Обычных проектных библиотечных JAR: 57; class entries: 47,765.
Экспортов portable JVM для словаря JNI/JVM: 2,998.

## Найденные соответствия

Хитов нет для перечисленных алгоритмов, кодировок и путевых форм.

## Прямые пересечения JAR / native exports

Пересечений нет.

## JAR payload и Java 9 modules

Нашлось 71 одинаковых 32-hex basename между libs.jar и JIMAGE (18,022 записей в индексе). Побайтно одинаковых payload: 0; совпадение имени не означает совпадение содержимого. В JSON сохранены размеры и SHA-256 каждой пары. `classes.jar` прямых совпадений не дал.

## Парные имена JLI и opaque идентификаторы

Для 6 строковых имён JLI из java.exe проверены MD5/SHA-1/SHA-256 по UTF-8/UTF-16LE, варианты регистра, common salts, separators и NUL на границах: совпадений 0.

## Проверенный пул стандартных JVM-имён

Обычная portable JVM дала 2,998 именованных exports; из них JNI/JVM/Java-семейств: 222. Помимо них добавлено 6 известных JNI точек входа и стандартные имена классов Java/FML. Оpaque exports не совпали с обычными экспортами напрямую; проверенные hash-хиты перечислены выше.

## Что это показывает

Несолёные проверки широкого пула не дали совпадений, однако salted mapping подтвердил 13,844 Java 9 JIMAGE имён и 6/6 заранее известных JLI пар. Смотри раздел о salted mappings и JSON.

Полная машинная детализация и источники каждой строки: `hash-mapping.json`. Скрипт запускается bundled Python 3 командой:

```powershell
& 'C:\Users\drgoo\.cache\codex-runtimes\codex-primary-runtime\dependencies\python\python.exe' -X utf8 'E:\Stalcraft project\builds\stalcraft-pre-vk-2017-candidate\analysis\hash-mapping.py'
```


## Подтверждённые salted mappings

`MD5(UTF-8(name + 2G5teW9TkteWdMSx))` совпадает для всех 6 пар JLI. Отдельный ключ classpath `nUHDjbS59e4wF8Pr` даёт 13,844 exact JIMAGE matches, 768 `classes.jar` entries и 5,018 `libs.jar` entries из словаря portable Java 8 и проекта. Пример: `java/lang/Object` → `c14f5b29590d12e945cb0f3a42112a91`. Для каждого hit JSON сохраняет исходное имя кандидата, opaque digest, encoding/placement, источники и путь JIMAGE или имя JAR entry.
