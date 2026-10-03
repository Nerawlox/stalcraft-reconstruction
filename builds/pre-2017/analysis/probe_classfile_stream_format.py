"""Static probe for the native ClassFileStream byte transform; no native execution."""
from pathlib import Path
import hashlib, json

A=Path(__file__).resolve().parent
IMAGE=A/'dynamic-capture'/'jvm-static-view.pe'
TABLE_RVA=0xa2fd40
INDEX_NAME='/java.base/c14f5b29590d12e945cb0f3a42112a91'

def ror8(x,n=3): return ((x>>n)|(x<<(8-n)))&0xff

def decode_at(buf,start,count,base_offset=0,table=b''):
    if start<2: raise ValueError('two preceding bytes are required as stream state')
    out=bytearray()
    for i in range(count):
        pos=start+i
        idx=(buf[pos-1]+base_offset+i)&15
        out.append(buf[pos]^ror8(buf[pos-2])^table[idx])
    return bytes(out)

def main():
    pe=IMAGE.read_bytes(); table=pe[TABLE_RVA:TABLE_RVA+16]
    index=json.loads((A/'jimage-index.json').read_text(encoding='utf-8'))
    row=next(e for e in index['entries'] if e['name']==INDEX_NAME)
    with Path(index['source']).open('rb') as f:
        f.seek(row['offset']); cipher=f.read(row['uncompressed_size'])
    native=(A/'emulated-cipher'/f"{INDEX_NAME.rsplit('/',1)[1]}.bin").read_bytes()
    if len(cipher)!=row['uncompressed_size'] or len(native)!=len(cipher):
        raise ValueError('JIMAGE/native sample size mismatch')

    probes=[]
    for label,buf in (('raw_jimage_ciphertext',cipher),('native_cipher_output',native)):
        for skip in range(2,33):
            for base_offset in (0,skip):
                out=decode_at(buf,skip,8,base_offset,table)
                probes.append({'input':label,'stream_start_offset':skip,'base_offset':base_offset,
                    'decoded_first_u2':f'{int.from_bytes(out[:2],"big"):04x}',
                    'decoded_first4':out[:4].hex(),'matches_parser_magic_e629':out[:2]==bytes.fromhex('e629'),
                    'matches_standard_magic_cafebabe':out[:4]==bytes.fromhex('cafebabe')})
    result={'scope':'static mapped-image inspection and pure-Python transform probes only',
        'image_sha256':hashlib.sha256(pe).hexdigest(),'table_rva':hex(TABLE_RVA),'table_hex':table.hex(),
        'table_sha256':hashlib.sha256(table).hexdigest(),
        'jimage_entry':{k:row[k] for k in ('name','offset','compressed_size','uncompressed_size','sha256')},
        'cipher_sha256':hashlib.sha256(cipher).hexdigest(),'native_output_sha256':hashlib.sha256(native).hexdigest(),
        'native_output_prefix':native[:32].hex(),'class_parser_evidence':{
            'constructor_rva':'0x3aa240','bulk_transform_rva':'0x3aa420','get_u1_rva':'0x3aa4c0',
            'get_u2_rva':'0x3aa620','get_u4_rva':'0x3aa680','parse_stream_rva':'0x3a6ed0',
            'direct_parser_get_u1_callsite':'0x3a34ac','direct_parser_get_u2_callsites':['0x3a6f11','0x3a6f60','0x3a6f6f'],
            'parser_skips_two_bytes_before_magic':True,'magic_u2_expected':'0xe629',
            'magic_error_string_rva':'0x89a340','magic_error_xref':'0x3a6f20',
            'standard_cafebabe_check_at_this_path':False},
        'transform_formula':'out[i] = input[pos+i] XOR ROR8(input[pos+i-2],3) XOR table[(input[pos+i-1]+base_offset+i)&15]',
        'bounded_probe_offsets':[2,32],'transform_matches_for_sample':[p for p in probes if p['matches_parser_magic_e629'] or p['matches_standard_magic_cafebabe']],
        'tested_count':len(probes),'probes':probes}
    (A/'classfile-stream-format-probe.json').write_text(json.dumps(result,indent=2),encoding='utf-8')
    print(json.dumps({k:v for k,v in result.items() if k!='probes'},indent=2))

if __name__=='__main__': main()
