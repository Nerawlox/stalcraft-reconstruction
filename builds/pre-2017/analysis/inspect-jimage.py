"""Read the bundled JIMAGE without loading its JVM. Reference: OpenJDK9u jimage."""
from pathlib import Path
import struct, json, hashlib, zlib
from collections import Counter

HERE = Path(__file__).resolve().parent
SOURCE = Path(r'E:\Stalcraft project\stalcraft_pre\stalcraft\win64\java\lib\modules')

def inspect():
    b = SOURCE.read_bytes()
    magic, version, flags, count, table, locsize, strsize = struct.unpack_from('<7I', b)
    assert magic == 0xcafedada
    locstart = 28 + table * 8
    strstart = locstart + locsize
    indexsize = strstart + strsize
    def string(offset):
        start = strstart + offset
        return b[start:b.index(b'\0', start)].decode('utf-8', errors='replace')
    entries = []
    for off in struct.unpack_from('<'+'I'*table, b, 28 + table*4):
        if not off: continue
        p = locstart + off
        a = [0]*8
        while b[p] >> 3:
            tag = b[p]; p+=1
            kind, n = tag>>3, (tag&7)+1
            assert kind < 8
            a[kind] = int.from_bytes(b[p:p+n], 'big');p+=n
        name = ('/'+string(a[1])+'/' if a[1] else '')
        name += (string(a[2])+'/' if a[2] else '') + string(a[3])
        name += ('.'+string(a[4]) if a[4] else '')
        pos, size = indexsize+a[5], a[6] or a[7]
        raw = b[pos:pos+size]
        assert len(raw) == size
        row = dict(name=name, offset=pos, compressed_size=a[6], uncompressed_size=a[7],
                   first32=raw[:32].hex(), sha256=hashlib.sha256(raw).hexdigest())
        if a[6] and len(raw)>=29 and struct.unpack_from('<I', raw)[0] == 0xcafefafa:
            _, cs, us, dc, content, terminal = struct.unpack_from('<IQQiiB',raw)
            row.update(compressor=string(dc), compressed_header_size=cs, header_uncompressed_size=us)
            if string(dc)=='zip':
                try:
                    raw=zlib.decompress(raw[29:]);row['decompressed_first32']=raw[:32].hex()
                except zlib.error as e: row['error']=str(e)
        if raw.startswith(b'\xca\xfe\xba\xbe'):
            out=HERE/'jdk-recovered'/name.lstrip('/')
            out.parent.mkdir(parents=True,exist_ok=True);out.write_bytes(raw)
            row['recovered']=str(out.relative_to(HERE))
        entries.append(row)
    assert len(entries)==count
    out=dict(source=str(SOURCE),sha256=hashlib.sha256(b).hexdigest(),
             header=dict(version=version,flags=flags,count=count,table=table,locations_size=locsize,strings_size=strsize,index_size=indexsize),
             compression= dict(Counter(e.get('compressor','none' if not e['compressed_size'] else 'unknown') for e in entries)),
             recovered=sum('recovered' in e for e in entries),entries=sorted(entries,key=lambda e:e['name']))
    (HERE/'jimage-index.json').write_text(json.dumps(out,ensure_ascii=False,indent=2),encoding='utf-8')
    (HERE/'jimage-names.txt').write_text('\n'.join(e['name'] for e in out['entries'])+'\n',encoding='utf-8')
    print(json.dumps({k:v for k,v in out.items() if k!='entries'},ensure_ascii=False,indent=2))
    for row in out['entries']:
        if any(x in row['name'] for x in ['ClassLoader.class','ZipFile.class','java/lang/Class.class','LauncherHelper.class','exbo','stalcraft']):
            print(row)

if __name__ == '__main__': inspect()
