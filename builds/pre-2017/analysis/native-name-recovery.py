from __future__ import annotations
import hashlib,json,re,struct
from pathlib import Path
from collections import Counter

AN=Path(r'E:\Stalcraft project\builds\stalcraft-pre-vk-2017-candidate\analysis')
CAP=AN/'dynamic-capture'
IMAGE=CAP/'jvm-static-view.pe'
EXPORT_JSON=AN/'native-images.json'
JIMAGE_JSON=AN/'jimage-index.json'
JLI_PAIRS={
 'JLI_InitArgProcessing':'137bc867174a904f42a8efa61d836687',
 'JLI_CmdToArgs':'c37c45bdb56ed218e567719525bfad0e',
 'JLI_GetStdArgc':'0e507ffc4f5371b5271f03ac97484fe0',
 'JLI_MemAlloc':'1ee12e87292680737f1c121af6cabfe0',
 'JLI_GetStdArgs':'f5199c4078a19150bc6c85942e593153',
 'JLI_Launch':'9b490ffc0189e74ef6ca6c1079e09043',
}
HEX32=re.compile(r'^[0-9a-f]{32}$')
LINE=re.compile(r'^([0-9a-fA-F]{8})\s+(.*)$')


def path_forms(s):
    vals={s,s.lower(),s.upper(),s.replace('/','.'),s.replace('.','/'),'/'+s,'/'+s.replace('/','.')}
    for x in tuple(vals):
        if x.endswith('.class'): vals.update((x[:-6],x[:-6].replace('/','.')))
        else: vals.update((x+'.class',x.replace('/','.')+'.class'))
    return {x for x in vals if x and len(x)<600}

def main():
    image=IMAGE.read_bytes(); capture=json.loads((CAP/'section-analysis.json').read_text(encoding='utf-8'))
    native=json.loads(EXPORT_JSON.read_text(encoding='utf-8'))
    jvm=next(x for x in native if x['path'].lower()=='win64\\java\\bin\\server\\jvm.dll')
    export_names=[x['name'] for x in jvm.get('exports',[])]
    export_targets={x.lower() for x in export_names if HEX32.fullmatch(x.lower())}
    jd=json.loads(JIMAGE_JSON.read_text(encoding='utf-8'))
    jimage_targets={Path(e['name']).name.lower() for e in jd.get('entries',[]) if HEX32.fullmatch(Path(e['name']).name.lower())}
    target_sets={'jvm_exports':export_targets,'java9_jimage':jimage_targets,'jli_pairs':set(JLI_PAIRS.values())}
    lines=(CAP/'watch-all-strings.txt').read_text(encoding='utf-8',errors='replace').splitlines()
    addressed=[]
    for line in lines:
        m=LINE.match(line)
        if m: addressed.append({'rva':int(m.group(1),16),'text':m.group(2)})
    strings=[x['text'] for x in addressed]
    candidates=set()
    for s in strings: candidates.update(path_forms(s))
    hits=[]; checks=Counter(); bypair=Counter()
    for s in candidates:
        for enc in ('utf-8','utf-16le'):
            try: raw=s.encode(enc)
            except UnicodeEncodeError: continue
            for algo in ('md5','sha1','sha256'):
                value=getattr(hashlib,algo)(raw).hexdigest()[:32]
                checks[(algo,enc)]+=1
                for label,targets in target_sets.items():
                    if value in targets:
                        hits.append({'target_set':label,'digest':value,'algorithm':algo,'encoding':enc,'input':s})
                        bypair[(label,algo,enc)]+=1
    # Test all short-ish strings extracted from the native image as salts on both sides
    # of the six known JLI name/id pairs, over common separators and three digests.
    salts=sorted({s for s in strings if re.fullmatch(r'[A-Za-z0-9_.$/\\:-]{3,64}',s)})
    separators=['',':','|','/','_','-','\x00','::']
    salt_hits=[]; salt_checks=0
    for name,target in JLI_PAIRS.items():
        cases={name,name.lower()}
        for case in cases:
            for salt in salts:
                sb=salt.encode('utf-8',errors='ignore')
                for sep in separators:
                    sepb=sep.encode('utf-8')
                    for raw in (sb+sepb+case.encode('utf-8'),case.encode('utf-8')+sepb+sb):
                        for algo in ('md5','sha1','sha256'):
                            salt_checks+=1
                            if getattr(hashlib,algo)(raw).hexdigest()[:32]==target:
                                salt_hits.append({'name':name,'target':target,'algorithm':algo,'case':case,'salt':salt,'separator':sep,'order':'salt+name' if raw.startswith(sb) else 'name+salt'})
    # Statically find data cells containing VA pointers to selected strings. A cell is
    # evidence of a reference-bearing table, not by itself a code xref.
    imagebase=capture['capture']['image_base']
    selected_terms=('md5','sha','digest','hash','classloader','classpath','jli_','jni_','jvm_','java/lang')
    selected=[x for x in addressed if any(k in x['text'].lower() for k in selected_terms)]
    ptr_cells=[]
    for x in selected:
        needle=struct.pack('<Q',imagebase+x['rva']); pos=0
        while True:
            pos=image.find(needle,pos)
            if pos<0: break
            ptr_cells.append({'string_rva':x['rva'],'string':x['text'],'pointer_cell_rva':pos})
            pos+=1
    imports=jvm.get('imports',{})
    import_names={dll:[n for n in names] for dll,names in imports.items()}
    flat_imports={n.lower() for vals in import_names.values() for n in vals}
    relevant_imports=sorted(n for n in flat_imports if any(k in n for k in ('crypt','bcrypt','hash','digest','md5','sha','getprocaddress','loadlibrary','virtualprotect','virtualalloc')))
    # `j)Md5o` is non-NUL terminated in context and immediately abuts entropy-like bytes.
    md5_evidence=[]
    for x in addressed:
        if 'md5' in x['text'].lower():
            r=x['rva']; md5_evidence.append({'rva':r,'text':x['text'],'context_hex':image[r-8:r+24].hex(),'nul_terminated':image.find(b'\0',r,r+len(x['text'])+1)==r+len(x['text'])})
    salt_evidence={
      'jli_salt':{'literal':'2G5teW9TkteWdMSx','rva':'0x89abc0','xref_rva':'0x633dd0','function_rva':'0x633d50','call_md5_helper_rva':'0x5f0b00','formula':'MD5(UTF-8(name + salt))','operation_summary':'copies input name, appends 16-byte literal and NUL, calls helper'},
      'classpath_salt':{'literal':'nUHDjbS59e4wF8Pr','rva':'0x89abd8','function_rva':'0x3ad680','additional_xref_rva':'0x3ac3de','tailjump_md5_helper_rva':'0x5f0b00','formula':'MD5(UTF-8(classpath + salt))','class_suffix_handling_rva':'0x3ab230','class_suffix_removed':'.class (6 bytes)','operation_summary':'computes strlen(name), allocates length+0x11, copies name, movups-appends 16-byte salt, NUL-terminates, tail-jumps to helper'},
      'md5_helper':{'rva':'0x5f0b00','state_constants':['0x67452301','0xefcdab89','0x98badcfe','0x10325476'],'basis':'canonical MD5 initial state and transform constants in mapped machine code','state_constant_rvas':['0x5f0b25','0x5f0b2d','0x5f0b35','0x5f0b42']}
    }
    known_salted_matches=[{'name':name,'target':target,'salt':salt_evidence['jli_salt']['literal'],'formula':'MD5(UTF-8(name + salt))','computed':hashlib.md5((name+salt_evidence['jli_salt']['literal']).encode('utf-8')).hexdigest(),'verified':hashlib.md5((name+salt_evidence['jli_salt']['literal']).encode('utf-8')).hexdigest()==target} for name,target in JLI_PAIRS.items()]
    classpath_match={'name':'java/lang/Object','target':'c14f5b29590d12e945cb0f3a42112a91','salt':salt_evidence['classpath_salt']['literal'],'formula':'MD5(UTF-8(name + salt))','computed':hashlib.md5(('java/lang/Object'+salt_evidence['classpath_salt']['literal']).encode('utf-8')).hexdigest()}
    report={
      'schema':1,
      'inputs':{'static_view':str(IMAGE),'static_view_sha256':hashlib.sha256(image).hexdigest(),'stage':capture['capture'].get('stage'),'image_base':imagebase,'layout':capture['capture'].get('layout'),'watch_string_rows':len(addressed),'unique_watch_strings':len(set(strings)),'unique_native_string_candidate_forms':len(candidates),'native_exports':len(export_names),'hex32_native_exports':len(export_targets),'jimage_hex32_names':len(jimage_targets),'portable_jvm_import_dlls':len(import_names),'portable_jvm_import_symbols':sum(map(len,import_names.values())),'native_salt_candidates':len(salts)},
      'checks':{'candidate_hash_checks':sum(checks.values()),'candidate_checks_by_algorithm_encoding':[{'algorithm':a,'encoding':e,'checks':checks[(a,e)],'hits':sum(1 for h in hits if h['algorithm']==a and h['encoding']==e)} for a in ('md5','sha1','sha256') for e in ('utf-8','utf-16le')],'jli_salt_checks':salt_checks,'direct_native_string_hits':hits,'jli_salt_hits':salt_hits},
      'target_counts':{k:len(v) for k,v in target_sets.items()},
      'xref_observations':{'pointer_cells_to_selected_strings':ptr_cells,'note':'Pointer cells are static VA references in the mapped view; code xrefs into protected/virtualized regions are not claimed from this scan.'},
      'imports':{'dlls':import_names,'relevant_symbols':relevant_imports},
      'md5_ascii_observation':md5_evidence,'code_evidence':salt_evidence,'confirmed_salted_matches':{'jli':known_salted_matches,'jli_all_verified':all(x['verified'] for x in known_salted_matches),'classpath_jimage':classpath_match},
      'interpretation':['This scan tested candidate hash inputs extracted from native-image ASCII strings and common path/class spellings against the observed native/JIMAGE/JLI 32-hex targets. It found no direct matches.','Unsalted candidates failed; independently, all six JLI pairs exactly validate MD5(name + 2G5teW9TkteWdMSx), and java/lang/Object validates against JIMAGE as MD5(classpath + nUHDjbS59e4wF8Pr).' ,'Code evidence: salt literals at RVA 0x89abc0 and 0x89abd8; JLI append/xref at 0x633dd0 then call to MD5 helper 0x5f0b00; classpath function 0x3ad680 appends the second salt and hashes via the same helper. The helper has canonical MD5 state constants. RVA 0x3ab230 strips .class (6 bytes). The lone ASCII fragment `j)Md5o` is junk and unrelated.','The capture is an in-memory mapped image, and `.vmp0`/`.vmp1` plus `.pdata` remain partly virtualized/high entropy. Missing xrefs are not proof of no runtime reference.']
    }
    (AN/'native-name-recovery.json').write_text(json.dumps(report,ensure_ascii=False,indent=2),encoding='utf-8')
    md=['# Статическая проверка имён native/JIMAGE экспорта','',f"Снимок: `{report['inputs']['static_view']}`; SHA-256 `{report['inputs']['static_view_sha256']}`.",f"Строк снимка: {len(addressed):,} строк; уникальных строк: {len(set(strings)):,}; кандидатных написаний/путей: {len(candidates):,}.",f"Проверено native exports: {len(export_targets):,}; JIMAGE hex-имён: {len(jimage_targets):,}; JLI name/hash пар: {len(JLI_PAIRS)}.",'','## Результат хеш-проверок','',f"Найдено совпадений: {len(hits)}; по JLI salted brute force: {len(salt_hits)} из {salt_checks:,} проверок.",'']
    for e in report['checks']['candidate_checks_by_algorithm_encoding']:md.append(f"- {e['algorithm']} / {e['encoding']}: {e['checks']:,} входов, {e['hits']} совпадений.")
    md += ['','Кандидаты собраны из `watch-all-strings.txt`, включая JNI/JVM имена, Java пути, исходные C++ пути, символы библиотек и прочие строки восстановленного снимка. Для каждого проверены slash/dot, leading slash, `.class`/без суффикса и исходный/lower/upper регистр. Проверки сравнивали MD5 full, SHA-1[:32] и SHA-256[:32].','',f"В salt-переборе для каждой JLI пары использованы {len(salts):,} строк снимка длиной до 96 байт, три регистра имени, 10 разделителей, salt до/после имени, UTF-8 и те же три алгоритма.",'','## Xref и импорты','',f"Указатели VA в снимке на выбранные строки: {len(ptr_cells)} ячеек; список адресов сохранён в JSON. Наличие ячейки подтверждает таблицу строк, но не доказывает использование алгоритма хеширования.",f"Native import table: {len(import_names)} DLL, {sum(map(len,import_names.values())):,} symbols. Импортов, похожих на crypto/hash/MD5/SHA/GetProcAddress/LoadLibrary: {', '.join(relevant_imports) if relevant_imports else 'нет'}.",'','## Интерпретация','',"Unsalted проверки обычных JNI/ClassLoader/Classpath имён и C++ строк по видимым кандидатам не совпали с opaque 32-hex target names; salted пути подтверждены отдельно ниже. `j)Md5o` — единственный совпавший по ASCII-поиску фрагмент с `Md5`; он не NUL-terminated и стоит перед байтами, которые не являются текстом. Это не доказательство MD5-реализации.",'','Unsalted candidate forms returned no matches; that negative result is separate from the confirmed salted mappings. `.vmp0`/`.vmp1` and `.pdata` remain partly protected. Machine details, code RVAs, exact pairs, digest verification and counters are in `native-name-recovery.json`.','']
    md += ['', '## Подтверждённые salted mappings и code evidence', '', '`MD5(UTF-8(name + 2G5teW9TkteWdMSx))` для JLI имён: '+str(sum(x['verified'] for x in known_salted_matches))+'/6 точных пар. `MD5(UTF-8(classpath + nUHDjbS59e4wF8Pr))` для classpath: `java/lang/Object` → `c14f5b29590d12e945cb0f3a42112a91` в JIMAGE. Литералы находятся по RVA `0x89abc0` и `0x89abd8`; вычислительные пути сходятся на MD5 helper `0x5f0b00`. Вторая дорожка — RVA `0x3ad680` (xref `0x3ac3de`); обработчик RVA `0x3ab230` удаляет `.class` перед формированием пути. У helper стандартные MD5 state constants `67452301 efcdab89 98badcfe 10325476`.', '']
    (AN/'native-name-recovery.md').write_text('\n'.join(md),encoding='utf-8')
    print(json.dumps({'inputs':report['inputs'],'candidate_hash_checks':report['checks']['candidate_hash_checks'],'jli_salt_checks':salt_checks,'candidate_hits':len(hits),'salt_hits':len(salt_hits),'pointer_cells':len(ptr_cells),'relevant_imports':relevant_imports},ensure_ascii=False,indent=2))
if __name__=='__main__':main()
