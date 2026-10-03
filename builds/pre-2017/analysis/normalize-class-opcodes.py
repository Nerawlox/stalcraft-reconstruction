"""Translate protected opcode enums, preserving operands and bytecode offsets."""
from pathlib import Path
import hashlib,json,struct,zipfile
A=Path(__file__).resolve().parent;B=A.parent/'recovered-bytecode'
mapping=json.loads((A/'opcode-map.json').read_text(encoding='utf-8'))
OP={r['protected']:r for r in mapping['rows']}

def normalize_method(data,start,length):
    end=start+length;p=start;positions=set();targets=[];instructions=0
    def i4(at):
        if at+4>end:raise ValueError('switch operand overrun')
        return struct.unpack_from('>i',data,at)[0]
    while p<end:
        rel=p-start;positions.add(rel);row=OP.get(data[p])
        if not row or row['standard'] is None or row['standard']==202:
            raise ValueError(f'nonstandard opcode {data[p]:02x} at {rel}')
        op=row['standard'];data[p]=op;size=row['length'];instructions+=1
        if op==196:
            if p+1>=end:raise ValueError('wide opcode overrun')
            inner=OP.get(data[p+1])
            if not inner or not inner['wide_length'] or inner['standard'] is None:
                raise ValueError('invalid wide inner opcode')
            size=inner['wide_length'];data[p+1]=inner['standard']
        elif op in (170,171):
            q=start+((rel+4)&~3);targets.append(rel+i4(q))
            if op==170:
                low,high=i4(q+4),i4(q+8);n=high-low+1
                if n<0 or n>(end-q)//4:raise ValueError('invalid tableswitch range')
                for j in range(n):targets.append(rel+i4(q+12+4*j))
                size=q+12+4*n-p
            else:
                n=i4(q+4)
                if n<0 or n>(end-q)//8:raise ValueError('invalid lookupswitch count')
                for j in range(n):targets.append(rel+i4(q+12+8*j))
                size=q+8+8*n-p
        if size<1 or p+size>end:raise ValueError('instruction length overrun')
        if 153<=op<=168 or op in (198,199):targets.append(rel+struct.unpack_from('>h',data,p+1)[0])
        elif op in (200,201):targets.append(rel+i4(p+1))
        p+=size
    if p!=end:raise ValueError('method end mismatch')
    if any(t not in positions for t in targets):raise ValueError('branch target not instruction boundary')
    return instructions

def normalize_class(source):
    b=bytearray(source);p=8
    def take(n):
        nonlocal p
        if p+n>len(b):raise ValueError('class bounds')
        v=bytes(b[p:p+n]);p+=n;return v
    def u2():return int.from_bytes(take(2),'big')
    def u4():return int.from_bytes(take(4),'big')
    count=u2();cp=[None]*count;i=1
    while i<count:
        tag=take(1)[0]
        if tag==1:cp[i]=take(u2())
        elif tag in (3,4):take(4)
        elif tag in (5,6):take(8);i+=1
        elif tag in (7,8,16,19,20):take(2)
        elif tag in (9,10,11,12,17,18):take(4)
        elif tag==15:take(3)
        else:raise ValueError('unknown CP tag')
        i+=1
    take(6);take(u2()*2);methods=0;instructions=0
    for category in ['field','method']:
        for _ in range(u2()):
            take(6)
            for _ in range(u2()):
                name,length=u2(),u4();attrstart=p
                if category=='method' and cp[name]==b'Code':
                    take(4);code_length=u4()
                    instructions+=normalize_method(b,p,code_length);methods+=1
                p=attrstart+length
                if p>len(b):raise ValueError('attribute overrun')
    return bytes(b),methods,instructions

for source in ['classes','libs','jimage']:
    path=B/(source+'-recovered.jar');dest=B/(source+'-standard.jar');ok=[];failed=[]
    with zipfile.ZipFile(path) as src,zipfile.ZipFile(dest,'w',compression=zipfile.ZIP_DEFLATED) as dst:
        for item in src.infolist():
            try:
                converted,methods,instructions=normalize_class(src.read(item))
                dst.writestr(item.filename,converted)
                ok.append(dict(name=item.filename,methods=methods,instructions=instructions,
                    sha256=hashlib.sha256(converted).hexdigest()))
            except (ValueError,IndexError,struct.error) as ex:
                failed.append(dict(name=item.filename,error=str(ex)))
    report=dict(source=str(path),output=str(dest),standard_class_count=len(ok),failure_count=len(failed),
        methods=sum(r['methods'] for r in ok),instructions=sum(r['instructions'] for r in ok),
        validation='complete instruction spans and switch/wide/branch boundary checks; no bytecode execution',
        output_sha256=hashlib.sha256(dest.read_bytes()).hexdigest(),classes=ok,failures=failed)
    (B/(source+'-opcode-normalization.json')).write_text(json.dumps(report,ensure_ascii=False,indent=2),encoding='utf-8')
    print(json.dumps({k:report[k] for k in ['output','standard_class_count','failure_count','methods','instructions']},ensure_ascii=False),flush=True)
