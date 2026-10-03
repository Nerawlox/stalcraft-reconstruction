"""Small read-only software Rijndael implementation with caller-supplied S-box.

Supports 128/192/256-bit keys; uses the standard AES polynomial 0x11b,
Rcon sequence, ShiftRows and MixColumns. It never loads native code.
"""

def gf_mul(a,b,field=None):
    if field is not None:
        exp,log=field
        if a==0 or b==0:return 0
        return exp[(log[a]+log[b])%255]
    out=0
    for _ in range(8):
        if b&1:out^=a
        a=((a<<1)^0x11b) if a&0x80 else (a<<1)
        b>>=1
    return out&255

def key_expansion(key,sbox,field=None):
    if len(key) not in (16,24,32):raise ValueError("AES key must be 16, 24, or 32 bytes")
    nk=len(key)//4;nr=nk+6;words=[list(key[i:i+4]) for i in range(0,len(key),4)]
    rcon=1; rci=0
    while len(words)<4*(nr+1):
        i=len(words);t=words[-1][:]
        if i%nk==0:
            t=t[1:]+t[:1];t=[sbox[x] for x in t];t[0]^=rcon
            rci+=1; rcon=field[0][rci] if field is not None else gf_mul(rcon,2)
        elif nk>6 and i%nk==4:t=[sbox[x] for x in t]
        words.append([words[i-nk][j]^t[j] for j in range(4)])
    return [sum((words[4*r+c] for c in range(4)),[]) for r in range(nr+1)]

def _add(s,k):return [x^y for x,y in zip(s,k)]
def _sub(s,box):return [box[x] for x in s]
def _shift(s):return [s[r+4*((c+r)%4)] for c in range(4) for r in range(4)]
def _ishift(s):return [s[r+4*((c-r)%4)] for c in range(4) for r in range(4)]
def _mix(s):
    out=s[:]
    for c in range(4):
        p=4*c;a,b,d,e=s[p:p+4]
        out[p]=gf_mul(a,2)^gf_mul(b,3)^d^e
        out[p+1]=a^gf_mul(b,2)^gf_mul(d,3)^e
        out[p+2]=a^b^gf_mul(d,2)^gf_mul(e,3)
        out[p+3]=gf_mul(a,3)^b^d^gf_mul(e,2)
    return out
def _imix(s,coefficients=(14,11,13,9),field=None):
    out=s[:]
    c0,c1,c2,c3=coefficients
    for c in range(4):
        p=4*c;a,b,d,e=s[p:p+4]
        out[p]=gf_mul(a,c0,field)^gf_mul(b,c1,field)^gf_mul(d,c2,field)^gf_mul(e,c3,field)
        out[p+1]=gf_mul(a,c3,field)^gf_mul(b,c0,field)^gf_mul(d,c1,field)^gf_mul(e,c2,field)
        out[p+2]=gf_mul(a,c2,field)^gf_mul(b,c3,field)^gf_mul(d,c0,field)^gf_mul(e,c1,field)
        out[p+3]=gf_mul(a,c1,field)^gf_mul(b,c2,field)^gf_mul(d,c3,field)^gf_mul(e,c0,field)
    return out

def encrypt_block(block,key,sbox):
    if len(block)!=16:raise ValueError("block must be 16 bytes")
    keys=key_expansion(key,sbox);s=_add(list(block),keys[0])
    for k in keys[1:-1]:s=_add(_mix(_shift(_sub(s,sbox))),k)
    return bytes(_add(_shift(_sub(s,sbox)),keys[-1]))

def decrypt_block(block,key,sbox,inverse_sbox,inverse_mix=(14,11,13,9),field=None):
    if len(block)!=16:raise ValueError("block must be 16 bytes")
    keys=key_expansion(key,sbox,field);s=_add(list(block),keys[-1])
    for k in reversed(keys[1:-1]):s=_imix(_add(_sub(_ishift(s),inverse_sbox),k),inverse_mix,field)
    return bytes(_add(_sub(_ishift(s),inverse_sbox),keys[0]))

def decrypt_cbc(data,key,sbox,inverse_sbox,iv=bytes(16),inverse_mix=(14,11,13,9),field=None):
    if len(data)%16 or len(iv)!=16:raise ValueError("CBC data and IV must be block aligned")
    out=bytearray()
    for p in range(0,len(data),16):
        c=data[p:p+16];d=decrypt_block(c,key,sbox,inverse_sbox,inverse_mix,field)
        out.extend(x^y for x,y in zip(d,iv));iv=c
    return bytes(out)
