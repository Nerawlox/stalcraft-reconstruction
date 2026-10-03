"""Additional static Code/constant-pool checks on selected restored classes."""
from pathlib import Path
import json,struct,zipfile
A=Path(__file__).resolve().parent;B=A.parent/'recovered-bytecode'
STD={r['standard']:r for r in json.loads((A/'opcode-map.json').read_text(encoding='utf-8'))['rows'] if r['standard'] is not None}

def check(data):
    p=8
    def take(n):
        nonlocal p
        if p+n>len(data):raise ValueError('class bounds')
        v=data[p:p+n];p+=n;return v
    def u2():return int.from_bytes(take(2),'big')
    def u4():return int.from_bytes(take(4),'big')
    n=u2();cp=[None]*n;i=1
    while i<n:
        t=take(1)[0]
        if t==1:v=take(u2())
        elif t in(3,4):v=take(4)
        elif t in(5,6):v=take(8)
        elif t in(7,8,16,19,20):v=u2()
        elif t in(9,10,11,12,17,18):v=(u2(),u2())
        elif t==15:v=(take(1)[0],u2())
        else:raise ValueError('CP tag')
        cp[i]=(t,v)
        if t in(5,6):i+=1
        i+=1
    def ref(index,tags):
        if not 0<index<n or not cp[index] or cp[index][0] not in tags:
            raise ValueError(f'invalid CP operand {index} expected {tags}')
    def utf(index):ref(index,(1,));return cp[index][1].decode('utf-8','replace')
    def bytecode(code,maxlocals):
        pc=0;positions=set();count=0;cpchecks=0
        def ci4(at):
            if at+4>len(code):raise ValueError('switch bounds')
            return struct.unpack_from('>i',code,at)[0]
        while pc<len(code):
            positions.add(pc);op=code[pc];row=STD.get(op)
            if not row or op==202:raise ValueError('nonstandard opcode')
            size=row['length'];count+=1
            if op==196:
                inner=STD.get(code[pc+1])
                if not inner or not inner['wide_length']:raise ValueError('wide inner')
                size=inner['wide_length']
                if int.from_bytes(code[pc+2:pc+4],'big')>=maxlocals:raise ValueError('wide local bounds')
            elif op in(170,171):
                q=(pc+4)&~3
                if op==170:
                    low,high=ci4(q+4),ci4(q+8);size=q+12+4*(high-low+1)-pc
                    if high<low:raise ValueError('tableswitch range')
                else:
                    num=ci4(q+4);size=q+8+8*num-pc
                    if num<0:raise ValueError('lookupswitch count')
                    keys=[ci4(q+8+8*j) for j in range(num)]
                    if keys!=sorted(set(keys)):raise ValueError('lookupswitch key order')
            if size<1 or pc+size>len(code):raise ValueError('instruction bounds')
            tags=None;index=None
            if op==18:tags=(3,4,7,8,15,16,17);index=code[pc+1]
            elif op in(19,20):tags=(5,6,17) if op==20 else (3,4,7,8,15,16,17)
            elif 178<=op<=181:tags=(9,)
            elif op==182:tags=(10,)
            elif op in(183,184):tags=(10,11)
            elif op==185:
                tags=(11,)
                if not code[pc+3] or code[pc+4]:raise ValueError('invokeinterface trailing operand')
            elif op==186:
                tags=(18,)
                if code[pc+3:pc+5]!=b'\0\0':raise ValueError('invokedynamic trailing operand')
            elif op in(187,189,192,193,197):tags=(7,)
            if tags:
                if index is None:index=int.from_bytes(code[pc+1:pc+3],'big')
                ref(index,tags);cpchecks+=1
            if op==188 and not 4<=code[pc+1]<=11:raise ValueError('newarray type')
            if op in(21,22,23,24,25,54,55,56,57,58,132,169) and code[pc+1]>=maxlocals:
                raise ValueError('local index bounds')
            pc+=size
        return positions,count,cpchecks
    take(6);take(2*u2());results=[]
    for category in ['field','method']:
        for _ in range(u2()):
            access,name,desc,attrs=u2(),u2(),u2(),u2()
            for _ in range(attrs):
                an,length=u2(),u4();start=p
                if category=='method' and utf(an)=='Code':
                    maxstack,maxlocals,codelen=u2(),u2(),u4();code=take(codelen)
                    positions,count,refs=bytecode(code,maxlocals)
                    handlers=u2()
                    for _ in range(handlers):
                        begin,end,target,catch=u2(),u2(),u2(),u2()
                        if begin not in positions or (end!=codelen and end not in positions) or target not in positions or begin>=end:
                            raise ValueError('exception handler instruction boundary')
                        if catch:ref(catch,(7,))
                    nested=u2()
                    for _ in range(nested):ref(u2(),(1,));take(u4())
                    if p!=start+length:raise ValueError('Code attribute end mismatch')
                    results.append(dict(name=utf(name),descriptor=utf(desc),instructions=count,
                        cp_operand_checks=refs,exception_handlers=handlers,maxstack=maxstack,maxlocals=maxlocals))
                p=start+length
    return results

samples={
    'classes':['com/stalcraft/StalcraftMod.class','com/stalcraft/ClientProxy.class','com/stalcraft/ServerProxy.class',
        'gloomyfolken/mods/core/main/GloomyCore.class','net/minecraft/launchwrapper/Launch.class',
        'net/minecraft/launchwrapper/LaunchClassLoader.class'],
    'libs':['com/google/common/util/concurrent/Futures.class'],
    'jimage':['java/lang/Object.class']}
rows=[]
for source,names in samples.items():
    with zipfile.ZipFile(B/(source+'-standard.jar')) as z:
        for name in names:
            if name not in z.namelist():raise ValueError(f'Missing expected sample {name}')
            methods=check(z.read(name));rows.append(dict(source=source,name=name,methods=methods))
r=dict(scope='static class/Code reads, opcode operands, CP types, locals and exception boundaries; no Java execution or verifier',
    classes_checked=len(rows),methods_checked=sum(len(c['methods']) for c in rows),
    cp_operand_checks=sum(m['cp_operand_checks'] for c in rows for m in c['methods']),failure_count=0,classes=rows)
(A/'restored-code-operand-check.json').write_text(json.dumps(r,ensure_ascii=False,indent=2),encoding='utf-8')
print(json.dumps({k:v for k,v in r.items() if k!='classes'},ensure_ascii=False))
