"""Compare instruction structure without relying on constant-pool numbering."""
from collections import Counter
import hashlib
import json
import re
from classfile_index import descriptor_parts


def method_fingerprint(info, method, lengths, canonical, known):
    if method.code is None:
        return 'abstract-or-native'
    cp = info.constant_pool
    owner = canonical.get(info.name, info.name)

    def utf(index):
        return cp[index][1].decode('utf-8')

    def name(raw):
        value = canonical.get(raw, raw)
        if value == owner or value in known or not (value.startswith('net/minecraft/') or '/' not in value):
            return value
        return '?'

    def desc(value):
        return re.sub(r'L([^;]+);', lambda match: 'L' + name(match[1]) + ';', value)

    def constant(index):
        row = cp[index]
        tag = row[0]
        if tag in (3, 4, 5, 6):
            return (tag, row[1].hex())
        if tag == 8:
            return (tag, cp[row[1]][1].hex())
        if tag == 7:
            raw = utf(row[1])
            return (tag, desc(raw) if raw.startswith('[') else name(raw))
        if tag in (9, 10, 11):
            raw_owner = utf(cp[row[1]][1])
            nat = cp[row[2]]
            member, descriptor = utf(nat[1]), utf(nat[2])
            ordinal = None
            if raw_owner == info.name:
                members = info.fields if tag == 9 else info.methods
                ordinal = next((i for i, entry in enumerate(members)
                                if (entry.name, entry.descriptor) == (member, descriptor)), None)
            # External library names stay meaningful; Minecraft member names
            # are independently obfuscated. Self member ordinals retain roles.
            member_name = member if not canonical.get(raw_owner, raw_owner).startswith('net/minecraft/') and '/' in raw_owner else ''
            return (tag, name(raw_owner), desc(descriptor), ordinal, member_name)
        if tag == 16:
            return (tag, desc(utf(row[1])))
        if tag == 15:
            return (tag, row[1], constant(row[2]))
        if tag in (17, 18):
            return (tag, desc(utf(cp[row[2]][2])))
        raise ValueError('Unsupported instruction constant tag: ' + str(tag))

    code, p, tokens = method.code, 0, []
    cp_ops = {18: 1, 19: 2, 20: 2, **{op: 2 for op in range(178, 187)},
              187: 2, 189: 2, 192: 2, 193: 2, 197: 2}
    while p < len(code):
        op = code[p]
        size = lengths[op]
        if op == 196:
            size = 6 if code[p + 1] == 132 else 4
        elif op in (170, 171):
            q = (p + 4) & ~3
            if op == 170:
                low = int.from_bytes(code[q + 4:q + 8], 'big', signed=True)
                high = int.from_bytes(code[q + 8:q + 12], 'big', signed=True)
                size = q + 12 + 4 * (high - low + 1) - p
            else:
                count = int.from_bytes(code[q + 4:q + 8], 'big', signed=True)
                size = q + 8 + 8 * count - p
        if size < 1 or p + size > len(code):
            raise ValueError('Invalid instruction span')
        operands = code[p + 1:p + size]
        if op in cp_ops:
            width = cp_ops[op]
            tokens.append((op, constant(int.from_bytes(operands[:width], 'big')), operands[width:].hex()))
        else:
            tokens.append((op, operands.hex()))
        p += size
    return hashlib.sha256(json.dumps(tokens, separators=(',', ':')).encode()).hexdigest()


def class_fingerprint(info, lengths, canonical, known):
    return Counter((member.access & 0x05c8, member.name.startswith('<'),
                    descriptor_parts(member.descriptor)[0],
                    method_fingerprint(info, member, lengths, canonical, known))
                   for member in info.methods)
