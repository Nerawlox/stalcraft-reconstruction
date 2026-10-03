"""Verify discovered hashes and summarize names without claiming decoded bytecode."""
from pathlib import Path
from collections import Counter
import hashlib, json, re, zipfile

HERE = Path(__file__).resolve().parent
ROOT = Path(r'E:\Stalcraft project\stalcraft_pre\stalcraft')


def main():
    mapping = json.loads((HERE / 'hash-mapping.json').read_text(encoding='utf-8'))
    groups = {}
    for row in mapping['results']['discovered_salt_hits']:
        if row['target'] not in ('classes.jar', 'libs.jar', 'java9-jimage-path'):
            continue
        if (row['algorithm'], row['encoding'], row['placement'], row['salt']) != ('md5', 'utf-8', 'name+salt', 'nUHDjbS59e4wF8Pr'):
            continue
        calculated = hashlib.md5((row['candidate'] + row['salt']).encode('utf-8')).hexdigest()
        if calculated != row['hex']:
            raise ValueError('Mapping contains an invalid hash')
        key = (row['target'], row['hex'])
        previous = groups.get(key)
        if previous and previous['name'] != row['candidate']:
            raise ValueError('Different names map to one payload; inspect the collision')
        groups[key] = dict(source=row['target'], name=row['candidate'], payload=row['hex'])
    extra_path = HERE / 'classname-extra-mapping.json'
    if extra_path.exists():
        extra = json.loads(extra_path.read_text(encoding='utf-8'))
        for row in extra['results']['matches']:
            name, digest, source = row['hashed_input'], row['digest'], row['target_archive']
            if hashlib.md5((name + 'nUHDjbS59e4wF8Pr').encode('utf-8')).hexdigest() != digest:
                raise ValueError('Invalid extra mapping hash')
            key = (source, digest)
            previous = groups.get(key)
            if previous and previous['name'] != name:
                raise ValueError('Extra mapping disagrees with the broad dictionary')
            if previous:
                previous['extra_sources'] = row['sources']
            else:
                groups[key] = dict(source=source, name=name, payload=digest, extra_sources=row['sources'])
    jars = {}
    for jar in ('classes.jar', 'libs.jar'):
        with zipfile.ZipFile(ROOT / jar) as z:
            jars[jar] = {i.filename: i.file_size for i in z.infolist() if re.fullmatch('[0-9a-f]{32}', i.filename)}
    rows = sorted(groups.values(), key=lambda r: (r['source'], r['name']))
    for row in rows:
        if row['source'] in jars:
            row['ciphertext_size'] = jars[row['source']][row['payload']]
    counts = Counter(r['source'] for r in rows)
    report = dict(formula='MD5(UTF-8(internal path + nUHDjbS59e4wF8Pr))', counts=dict(counts),
                  note='Restored name identities only; payload bytecode has not been decrypted or parsed', records=rows)
    (HERE / 'classname-inventory.json').write_text(json.dumps(report, ensure_ascii=False, indent=2), encoding='utf-8')
    lines = ['# Восстановленные имена классов и записей', '',
             'Имена сопоставлены точным MD5 с солью, затем повторно проверены. Это идентификация скрытых записей; байткод из этих записей ещё не восстановлен.', '',
             '| Источник | Сопоставлено | Всего hex-payload |', '|---|---:|---:|']
    for source in ('classes.jar', 'libs.jar', 'java9-jimage-path'):
        lines.append(f'| {source} | {counts[source]} | {len(jars[source]) if source in jars else 15646} |')
    lines.extend(['', '## Группы в игровом classes.jar', '', '| Начало пути | Записей |', '|---|---:|'])
    namespaces = Counter('/'.join(r['name'].split('/')[:2]) for r in rows if r['source'] == 'classes.jar')
    for namespace, count in namespaces.most_common(20):
        lines.append(f'| {namespace} | {count} |')
    lines.extend(['', '## STALCRAFT', '', 'Сопоставленные имена из пространства STALCRAFT (словарь ограничен доступными метаданными/материалами проекта):', ''])
    for row in rows:
        if row['source'] == 'classes.jar' and 'stalcraft' in row['name'].lower():
            lines.append(f"- `{row['name']}` → `{row['payload']}` ({row['ciphertext_size']} байт ciphertext)")
    (HERE / 'classname-inventory.md').write_text('\n'.join(lines) + '\n', encoding='utf-8')
    print(json.dumps(dict(counts=report['counts'], records=len(rows), game_namespaces=namespaces.most_common(10)), ensure_ascii=False))


if __name__ == '__main__':
    main()
