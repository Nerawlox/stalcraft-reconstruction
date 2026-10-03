# Статическая проверка имён native/JIMAGE экспорта

Снимок: `E:\Stalcraft project\builds\stalcraft-pre-vk-2017-candidate\analysis\dynamic-capture\jvm-static-view.pe`; SHA-256 `e65dd250be4dab717ba635cb5d6dd4746442abc94da2f4e5360dc6d9d47b3896`.
Строк снимка: 80,456 строк; уникальных строк: 66,066; кандидатных написаний/путей: 590,798.
Проверено native exports: 3,551; JIMAGE hex-имён: 15,646; JLI name/hash пар: 6.

## Результат хеш-проверок

Найдено совпадений: 0; по JLI salted brute force: 6 из 10,551,744 проверок.

- md5 / utf-8: 590,798 входов, 0 совпадений.
- md5 / utf-16le: 590,798 входов, 0 совпадений.
- sha1 / utf-8: 590,798 входов, 0 совпадений.
- sha1 / utf-16le: 590,798 входов, 0 совпадений.
- sha256 / utf-8: 590,798 входов, 0 совпадений.
- sha256 / utf-16le: 590,798 входов, 0 совпадений.

Кандидаты собраны из `watch-all-strings.txt`, включая JNI/JVM имена, Java пути, исходные C++ пути, символы библиотек и прочие строки восстановленного снимка. Для каждого проверены slash/dot, leading slash, `.class`/без суффикса и исходный/lower/upper регистр. Проверки сравнивали MD5 full, SHA-1[:32] и SHA-256[:32].

В salt-переборе для каждой JLI пары использованы 18,319 строк снимка длиной до 96 байт, три регистра имени, 10 разделителей, salt до/после имени, UTF-8 и те же три алгоритма.

## Xref и импорты

Указатели VA в снимке на выбранные строки: 225 ячеек; список адресов сохранён в JSON. Наличие ячейки подтверждает таблицу строк, но не доказывает использование алгоритма хеширования.
Native import table: 23 DLL, 35 symbols. Импортов, похожих на crypto/hash/MD5/SHA/GetProcAddress/LoadLibrary: getprocaddress, loadlibrarya.

## Интерпретация

Unsalted проверки обычных JNI/ClassLoader/Classpath имён и C++ строк по видимым кандидатам не совпали с opaque 32-hex target names; salted пути подтверждены отдельно ниже. `j)Md5o` — единственный совпавший по ASCII-поиску фрагмент с `Md5`; он не NUL-terminated и стоит перед байтами, которые не являются текстом. Это не доказательство MD5-реализации.

Unsalted candidate forms returned no matches; that negative result is separate from the confirmed salted mappings. `.vmp0`/`.vmp1` and `.pdata` remain partly protected. Machine details, code RVAs, exact pairs, digest verification and counters are in `native-name-recovery.json`.


## Подтверждённые salted mappings и code evidence

`MD5(UTF-8(name + 2G5teW9TkteWdMSx))` для JLI имён: 6/6 точных пар. `MD5(UTF-8(classpath + nUHDjbS59e4wF8Pr))` для classpath: `java/lang/Object` → `c14f5b29590d12e945cb0f3a42112a91` в JIMAGE. Литералы находятся по RVA `0x89abc0` и `0x89abd8`; вычислительные пути сходятся на MD5 helper `0x5f0b00`. Вторая дорожка — RVA `0x3ad680` (xref `0x3ac3de`); обработчик RVA `0x3ab230` удаляет `.class` перед формированием пути. У helper стандартные MD5 state constants `67452301 efcdab89 98badcfe 10325476`.
