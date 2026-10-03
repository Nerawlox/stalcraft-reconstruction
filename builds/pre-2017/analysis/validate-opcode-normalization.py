from __future__ import annotations
import json, struct, zipfile
from pathlib import Path
from collections import Counter
A=Path(__file__).resolve().parent
B=A.parent/'recovered-bytecode'
MAP=json.loads((A/'opcode-map.json').read_text(encoding='utf-8'))
KNOWN={r['protected']:r['name'] for r in MAP['rows']}
# Standard JVMS fixed instruction sizes including opcode byte. Dynamic instructions handled below.
L=[1]*256
for op in (0x10,0x12,0x15,0x16,0x17,0x18,0x19,0x36,0x37,0x38,0x39,0x3a,0xa9,0xbc):L[op]=2
for op in (0x11,0x13,0x14,*range(0x99,0xa9),0xb2,0xb3,0xb4,0xb5,0xb6,0xb7,0xb8,0xb9,0xba,0xbb,0xbd,0xc0,0xc1,0xc6,0xc7):L[op]=3
L[0x84]=3;L[0xc5]=4;L[0xc8]=5;L[0xc9]=5
for op in (0xaa,0xab,0xc4):L[op]=0
CP1={0x12};CP2={0x13,0x14,*range(0xb2,0xba),0xba,0xbb,0xbd,0xc0,0xc1,0xc5}

def u(data,p,n):
 if p+n>len(data):raise ValueError(f'truncated at {p:#x}')
 return int.from_bytes(data[p:p+n],'big')
def parse_class(data):
 if data[:4]!=b'\xca\xfe\xba\xbe':raise ValueError('magic')
 pos=8; n=u(data,pos,2);pos+=2;cp=[None]*n;i=1
 while i<n:
  t=u(data,pos,1);pos+=1
  if t==1:
   z=u(data,pos,2);pos+=2;cp[i]=('utf',data[pos:pos+z].decode('utf8','replace'));pos+=z
  elif t in (3,4):cp[i]=(t,u(data,pos,4));pos+=4
  elif t in (5,6):cp[i]=(t,int.from_bytes(data[pos:pos+8],'big'));pos+=8;i+=1
  elif t in (7,8,16,19,20):cp[i]=(t,u(data,pos,2));pos+=2
  elif t in (9,10,11,12,17,18):cp[i]=(t,u(data,pos,2),u(data,pos+2,2));pos+=4
  elif t==15:cp[i]=(t,u(data,pos,1),u(data,pos+1,2));pos+=3
  else:raise ValueError(f'cp tag {t} at {pos-1:#x}')
  i+=1
 def attrs(pos,count):
  out=[]
  for _ in range(count):
   ni=u(data,pos,2);ln=u(data,pos+2,4);start=pos+6;end=start+ln
   if end>len(data):raise ValueError('attribute length')
   name=cp[ni][1] if cp[ni] and cp[ni][0]=='utf' else '?'
   out.append((name,start,end));pos=end
  return out,pos
 access=u(data,pos,2);this=u(data,pos+2,2);sup=u(data,pos+4,2);pos+=6
 ni=cp[this][1]; thisname=cp[ni][1]
 ic=u(data,pos,2);pos+=2+2*ic
 fc=u(data,pos,2);pos+=2
 for _ in range(fc):
  ac=u(data,pos+6,2);pos+=8;_,pos=attrs(pos,ac)
 mc=u(data,pos,2);pos+=2;methods=[]
 for _ in range(mc):
  acc=u(data,pos,2); name=cp[u(data,pos+2,2)][1];desc=cp[u(data,pos+4,2)][1];ac=u(data,pos+6,2);pos+=8
  aa,pos=attrs(pos,ac); code=next((x for x in aa if x[0]=='Code'),None)
  if code:
   _,s,e=code;maxstack=u(data,s,2);maxlocals=u(data,s+2,2);cl=u(data,s+4,4);cs=s+8;ce=cs+cl
   if ce+2>e:raise ValueError(f'Code bounds {name}{desc}')
   exn=u(data,ce,2);ex=[];q=ce+2
   for z in range(exn):
    st=u(data,q,2);en=u(data,q+2,2);h=u(data,q+4,2);ct=u(data,q+6,2);q+=8;ex.append((st,en,h,ct))
   nattr=u(data,q,2);q+=2
   for _x in range(nattr):ln=u(data,q+2,4);q+=6+ln
   if q!=e:raise ValueError(f'Code attr tail {q}/{e}')
   methods.append((name,desc,data[cs:ce],maxstack,maxlocals,ex,cp))
 if pos>len(data):raise ValueError('class overrun')
 return thisname,methods

def decode(code,cp):
 starts=set(); branches=[]; uses=[]; op_counts=Counter(); p=0
 while p<len(code):
  start=p;starts.add(p);op=code[p];op_counts[op]+=1;p+=1
  if op in (0xaa,0xab):
   while p%4:p+=1
   if p+8>len(code):raise ValueError(f'switch header at {start}')
   default=int.from_bytes(code[p:p+4],'big',signed=True);p+=4;branches.append((start,start+default))
   if op==0xaa:
    low=int.from_bytes(code[p:p+4],'big',signed=True);high=int.from_bytes(code[p+4:p+8],'big',signed=True);p+=8
    if high<low or high-low>100000:raise ValueError(f'tableswitch bounds at {start}: {low}..{high}')
    count=high-low+1
    if p+count*4>len(code):raise ValueError(f'tableswitch truncated at {start}')
    for _ in range(count):off=int.from_bytes(code[p:p+4],'big',signed=True);p+=4;branches.append((start,start+off))
   else:
    count=int.from_bytes(code[p:p+4],'big',signed=True);p+=4
    if count<0 or count>100000 or p+count*8>len(code):raise ValueError(f'lookupswitch bounds at {start}')
    prev=None
    for _ in range(count):
     key=int.from_bytes(code[p:p+4],'big',signed=True);off=int.from_bytes(code[p+4:p+8],'big',signed=True);p+=8
     if prev is not None and key<=prev:raise ValueError(f'unsorted lookupswitch at {start}')
     prev=key;branches.append((start,start+off))
  elif op==0xc4:
   if p>=len(code):raise ValueError(f'wide truncated at {start}')
   sub=code[p];p+=1
   if sub==0x84:p+=4
   elif sub in (*range(0x15,0x1a),*range(0x36,0x3b),0xa9):p+=2
   else:raise ValueError(f'invalid wide {sub:#x} at {start}')
  else:
   length=L[op]
   if length==0:raise ValueError(f'unknown dynamic opcode {op:#x} at {start}')
   p=start+length
   if p>len(code):raise ValueError(f'opcode truncated {op:#x} at {start}')
   if op in CP1:
    idx=code[start+1];uses.append((start,op,idx))
   elif op in CP2:
    idx=int.from_bytes(code[start+1:start+3],'big');uses.append((start,op,idx))
   if op in (*range(0x99,0xa9),0xc6,0xc7):
    off=int.from_bytes(code[start+1:start+3],'big',signed=True);branches.append((start,start+off))
   elif op in (0xc8,0xc9):
    off=int.from_bytes(code[start+1:start+5],'big',signed=True);branches.append((start,start+off))
  if p<=start:raise ValueError('no progress')
 if p!=len(code):raise ValueError(f'end {p} != {len(code)}')
 for src,tgt in branches:
  if tgt not in starts:raise ValueError(f'branch target {tgt} from {src} not instruction boundary')
 for off,op,idx in uses:
  if idx<=0 or idx>=len(cp) or cp[idx] is None:raise ValueError(f'bad CP index {idx} op {op:#x} at {off} cpLen={len(cp)} entry={cp[idx] if idx < len(cp) else None}')
  tag=cp[idx][0]
  allow={0x12:{3,4,7,8,15,16,17},0x13:{3,4,7,8,15,16,17},0x14:{5,6,17},0xb2:{9},0xb3:{9},0xb4:{9},0xb5:{9},0xb6:{10},0xb7:{10,11},0xb8:{10,11},0xb9:{11},0xba:{18},0xbb:{7},0xbd:{7},0xc0:{7},0xc1:{7},0xc5:{7}}
  if tag not in allow[op]:raise ValueError(f'CP tag mismatch idx={idx} tag={tag} op={op:#x} off={off}')
 return starts,branches,uses,op_counts

def main():
 results=[]; errors=[]; totals=Counter(); cfr_sample=[]
 for jar_name in ('jimage-standard.jar','classes-standard.jar','libs-standard.jar'):
  jar=B/jar_name
  # Object plus every class named com/stalcraft.* in classes jar, deterministic spread up to 200.
  with zipfile.ZipFile(jar) as z:
   names=z.namelist()
   if jar_name=='jimage-standard.jar': selected=[n for n in names if n=='java/lang/Object.class']
   elif jar_name=='classes-standard.jar':
    game=[n for n in names if n.startswith('com/stalcraft/') and n.endswith('.class')]
    selected=sorted(game)
   else:selected=[]
   for path in selected:
    try:
     cname,methods=parse_class(z.read(path));totals['classes']+=1
     for name,desc,code,ms,ml,ex,cp in methods:
      totals['code_methods']+=1
      starts,branches,uses,op_counts=decode(code,cp);totals['instructions']+=len(starts);totals['branches']+=len(branches);totals['cprefs']+=len(uses);totals['tableswitch']+=op_counts[0xaa];totals['lookupswitch']+=op_counts[0xab];totals['wide']+=op_counts[0xc4]
      for st,en,h,ct in ex:
       if not(st<en<=len(code) and h in starts):raise ValueError(f'exception range {st}..{en}, handler {h}, code={len(code)}')
       if ct and (ct>=len(cp) or cp[ct] is None or cp[ct][0]!=7):raise ValueError(f'exception catch CP {ct}')
      if cname=='java/lang/Object' and name=='<init>':
       cfr_sample.append({'class':cname,'method':name+desc,'code_hex':code.hex(),'first_ops':[code[i] for i in sorted(starts)[:4]],'decoded_names':[next((r['name'] for r in MAP['rows'] if r['standard']==code[i]),hex(code[i])) for i in sorted(starts)[:4]]})
    except Exception as e:errors.append({'jar':jar_name,'path':path,'error':str(e)})
 report={'scope':'static parser validation only; no class/JVM execution','jars_checked':{'jimage-standard.jar':1,'classes-standard.jar':'sampled com/stalcraft classes','libs-standard.jar':0},'sampled_classes':totals['classes'],'code_methods':totals['code_methods'],'instruction_starts':totals['instructions'],'branch_targets':totals['branches'],'constant_pool_operands':totals['cprefs'],'tableswitch':totals['tableswitch'],'lookupswitch':totals['lookupswitch'],'wide':totals['wide'],'object_constructor':cfr_sample,'errors':errors}
 out=A/'opcode-normalization-validation.json';out.write_text(json.dumps(report,indent=2),encoding='utf-8')
 md=['# Opcode normalization: independent structural validation','', 'Static parsing only; no recovered class was loaded or executed. `jimage-standard.jar` Object and a deterministic sample of `com/stalcraft/` classes in `classes-standard.jar` were checked.','',f"Validated {totals['classes']} classes, {totals['code_methods']} Code methods, {totals['instructions']} instruction boundaries, {totals['branches']} branch targets, {totals['cprefs']} constant-pool operands, {totals['tableswitch']} tableswitch, {totals['lookupswitch']} lookupswitch, and {totals['wide']} wide instructions.",'', 'The parser checked instruction lengths and boundaries, branch destinations, switch/wide encodings, CP index/tag compatibility, exception ranges, and catch types.','', 'Key native map rows from `opcode-map.json`:']
 for n in ('aload_0','invokespecial','return','wide','tableswitch','lookupswitch'):
  md.append('- '+', '.join(f"protected 0x{r['protected']:02x} → {n} (standard 0x{r['standard']:02x}; len={r['length']}, wide_len={r['wide_length']})" for r in MAP['rows'] if r['name']==n))
 md+=['','Object constructor decoding:']+[f"- `{x['method']}`: bytes `{x['code_hex']}`; first decoded operations: {', '.join(x['decoded_names'])}." for x in cfr_sample]
 md+=['',f"Parser errors: {len(errors)}."]
 (A/'opcode-normalization-validation.md').write_text('\n'.join(md)+'\n',encoding='utf-8')
 print(json.dumps({'classes':totals['classes'],'methods':totals['code_methods'],'instructions':totals['instructions'],'branches':totals['branches'],'cprefs':totals['cprefs'],'tableswitch':totals['tableswitch'],'lookupswitch':totals['lookupswitch'],'wide':totals['wide'],'object':cfr_sample,'errors':len(errors),'report':str(out)},indent=2))
if __name__=='__main__':main()
