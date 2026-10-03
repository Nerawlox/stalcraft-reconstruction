"""Recover additional classpath names from FML ASMDataTable caches, statically.

The .dump files are Java ObjectOutputStream streams containing TC_BLOCKDATA as
well as TC_STRING values. Length fields and serialization tags make an ASCII-run
scan unsafe: it may absorb a trailing `t`/`w` tag into a class name. This script
uses strict ObjectStream UTF lengths and strict two-byte writeUTF lengths, then
checks only recovered class-like names against opaque archive members.
"""
from __future__ import annotations
import hashlib, json, re, zipfile
from pathlib import Path

ROOT=Path(r'E:\Stalcraft project')
PKG=ROOT/'stalcraft_pre'/'stalcraft'
OUT=ROOT/'builds'/'stalcraft-pre-vk-2017-candidate'/'analysis'
SALT='nUHDjbS59e4wF8Pr'
HEX32=re.compile(r'^[0-9a-fA-F]{32}$')
CLASSISH=re.compile(r'^[A-Za-z_$][A-Za-z0-9_$]*(?:[./$][A-Za-z0-9_$]+)+$')
DESC=re.compile(r'L([A-Za-z_$][A-Za-z0-9_$/]+);')
TOKEN=re.compile(r'(?<![A-Za-z0-9_$])[A-Za-z_$][A-Za-z0-9_$]*(?:[./$][A-Za-z0-9_$]+)+(?:\.class)?')

def valid_text(raw: bytes):
    try: s=raw.decode('utf-8')
    except UnicodeDecodeError: return None
    if not s or not all(c.isprintable() for c in s): return None
    return s

def objectstream_strings(data: bytes):
    """Yield exact TC_STRING/TC_LONGSTRING payloads; validate lengths and UTF."""
    out=[]
    for i,tag in enumerate(data):
        if tag==0x74 and i+3<=len(data):
            n=int.from_bytes(data[i+1:i+3],'big')
            if 0<n<=65535 and i+3+n<=len(data):
                s=valid_text(data[i+3:i+3+n])
                if s is not None: out.append({'offset':i,'kind':'TC_STRING','text':s})
        elif tag==0x7c and i+9<=len(data):
            n=int.from_bytes(data[i+1:i+9],'big')
            if 0<n<=1_000_000 and i+9+n<=len(data):
                s=valid_text(data[i+9:i+9+n])
                if s is not None: out.append({'offset':i,'kind':'TC_LONGSTRING','text':s})
    return out

def writeutf_candidates(data: bytes):
    """Find strict 2-byte big-endian writeUTF fields in custom block records."""
    out=[]
    for i in range(max(0,len(data)-2)):
        n=int.from_bytes(data[i:i+2],'big')
        if 3<=n<=512 and i+2+n<=len(data):
            raw=data[i+2:i+2+n]; s=valid_text(raw)
            if s is not None and ('/' in s or '.' in s or DESC.search(s)):
                out.append({'offset':i,'kind':'u16-length-UTF','text':s})
    return out

def class_names_from_text(text: str):
    names=set()
    for m in DESC.finditer(text): names.add(m.group(1).replace('.','/'))
    for m in TOKEN.finditer(text):
        s=m.group(0)
        if s.endswith('.class'): s=s[:-6]
        if CLASSISH.fullmatch(s): names.add(s.replace('.','/'))
    return names

def candidate_forms(name: str):
    s=name.strip()
    if s.startswith('L') and s.endswith(';'): s=s[1:-1]
    if s.endswith('.class'): s=s[:-6]
    if not CLASSISH.fullmatch(s): return set()
    dotted=s.replace('/','.'); slash=s.replace('.','/')
    vals={s,dotted,slash,'/'+s,'/'+dotted,'/'+slash,s+'.class',slash+'.class',dotted+'.class'}
    return vals

def main():
    archives={}
    for jar in ('classes.jar','libs.jar'):
        path=PKG/jar
        with zipfile.ZipFile(path) as z:
            archives[jar]={n.lower() for n in z.namelist() if HEX32.fullmatch(n)}
    sources=[]; dump_stats={}; all_names={}
    dump_dir=PKG/'mods'/'asmdata'
    for p in sorted(dump_dir.glob('*.dump')):
        data=p.read_bytes(); ts=objectstream_strings(data); us=writeutf_candidates(data)
        dump_stats[p.name]={'bytes':len(data),'tc_string_records':len(ts),'u16_utf_fields':len(us)}
        for rec in ts+us:
            for name in class_names_from_text(rec['text']):
                key=name
                all_names.setdefault(key,[]).append({'source_type':rec['kind'],'source':str(p.relative_to(PKG)),'offset':rec['offset'],'raw_text':rec['text']})
    # Search small textual metadata/resource files for class pointers and descriptors.
    allowed={'.cfg','.properties','.json','.xml','.info','.txt','.mf','.lang','.yaml','.yml','.toml'}
    text_files=[]; text_errors=[]
    for base in (PKG/'mods',PKG/'modassets',PKG/'config',PKG/'META-INF'):
        if not base.exists(): continue
        for p in base.rglob('*'):
            if not p.is_file() or p.suffix.lower() not in allowed: continue
            try:
                if p.stat().st_size>2_000_000: continue
                text=p.read_text(encoding='utf-8',errors='replace')
            except OSError as e:
                text_errors.append({'path':str(p),'error':str(e)}); continue
            text_files.append(str(p.relative_to(PKG)))
            for name in class_names_from_text(text):
                all_names.setdefault(name,[]).append({'source_type':'text-token','source':str(p.relative_to(PKG)),'offset':None,'raw_text':name})
    checked=set(); matches=[]; tested=0
    for name,sources in sorted(all_names.items()):
        for form in sorted(candidate_forms(name)):
            if (name,form) in checked: continue
            checked.add((name,form)); tested+=1
            digest=hashlib.md5((form+SALT).encode('utf-8')).hexdigest()
            for jar,targets in archives.items():
                if digest in targets:
                    matches.append({'class_name':name,'hashed_input':form,'salt':SALT,'formula':'MD5(UTF-8(name + salt))','digest':digest,'target_archive':jar,'opaque_entry':digest,'sources':sources})
    # Surface the requested mod proxies and core mod entrypoint explicitly.
    focus=[]
    for m in matches:
        if any(k in m['class_name'].lower() for k in ('proxy','stalcraftmod','gloomycore','mod')):
            focus.append(m)
    report={'schema':1,'algorithm':{'name':'MD5','encoding':'UTF-8','formula':'MD5(classpath + nUHDjbS59e4wF8Pr)','salt':SALT},
      'input_counts':{'asm_dump_files':len(dump_stats),'asm_dump_stats':dump_stats,'distinct_classname_candidates':len(all_names),'candidate_forms_tested':tested,'archive_opaque_targets':{k:len(v) for k,v in archives.items()},'text_metadata_files_scanned':len(text_files),'text_metadata_paths':text_files,'text_read_errors':text_errors},
      'results':{'match_count':len(matches),'matches':matches,'proxy_and_mod_focus_matches':focus},
      'method_notes':['FML dump parsing recognizes Java ObjectStream TC_STRING (0x74) and TC_LONGSTRING (0x7c) length records and independently scans strict u16-length printable fields used within block data.','Class descriptors Lpkg/name; are reduced to the internal class path. Slash/dot, leading slash, and .class/no-extension forms are hashed.','Only MD5 UTF-8 with the independently recovered classpath salt is tested against opaque classes.jar/libs.jar member names. No executable was loaded or run.']}
    (OUT/'classname-extra-mapping.json').write_text(json.dumps(report,ensure_ascii=False,indent=2),encoding='utf-8')
    lines=['# Дополнительное восстановление имен классов из FML ASM cache','',f"Соль: `{SALT}`; формула: `MD5(UTF-8(classpath + salt))`.",f"Разобрано `.dump`: {len(dump_stats)}; exact ObjectStream strings + custom UTF-поля; уникальных class-like names: {len(all_names):,}; проверено форм: {tested:,}.",f"Проверено opaque entries: classes.jar {len(archives['classes.jar']):,}, libs.jar {len(archives['libs.jar']):,}; текстовых metadata/resource файлов: {len(text_files):,}.",f"Точные salted попадания: {len(matches)}.",'','## Восстановленные имена, вошедшие в classes.jar/libs.jar','']
    for m in matches:
        src=', '.join(sorted({x['source'] for x in m['sources']}))
        lines.append(f"- `{m['class_name']}` → `{m['opaque_entry']}` ({m['target_archive']}; input `{m['hashed_input']}`; источник: {src})")
    lines += ['','## Обработка proxy и дескрипторов','',"Длина-ограниченный разбор сохраняет конец строки до соседнего ObjectStream-тега. Это важно для полей `com.stalcraft.ServerProxy`/`com.stalcraft.ClientProxy`: прежний greedy ASCII-run захватывал следующий `w`/`t` serialization tag и не давал корректный hash input.",'','Все счётчики, смещения сериализованных строк и источники каждого совпадения: `classname-extra-mapping.json`.','']
    (OUT/'classname-extra-mapping.md').write_text('\n'.join(lines),encoding='utf-8')
    print(json.dumps({'dump_files':len(dump_stats),'class_candidates':len(all_names),'forms_tested':tested,'target_counts':{k:len(v) for k,v in archives.items()},'matches':len(matches),'proxy_and_mod_focus_count':len(focus),'focus_examples':[{'class_name':m['class_name'],'digest':m['digest'],'archive':m['target_archive']} for m in focus if 'proxy' in m['class_name'].lower() or 'stalcraftmod' in m['class_name'].lower()]},ensure_ascii=False,indent=2))

if __name__=='__main__': main()
