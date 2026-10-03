"""Extract and verify tables from the captured DLL without executing it."""
from pathlib import Path
import hashlib, json

HERE = Path(__file__).resolve().parent


def multiply(a, b):
    result = 0
    for _ in range(8):
        if b & 1:
            result ^= a
        a = ((a << 1) ^ (0x11b if a & 0x80 else 0)) & 255
        b >>= 1
    return result


def main():
    image = (HERE / 'dynamic-capture/jvm-static-view.pe').read_bytes()
    sbox, inverse, exp, log = [image[r:r + 256] for r in (0x89a6f0, 0x89a7f0, 0x89a8f0, 0x89a9f0)]
    if set(sbox) != set(range(256)) or not all(inverse[sbox[x]] == x for x in range(256)):
        raise ValueError('Substitution tables do not form an inverse permutation pair')
    for a in range(256):
        for b in range(256):
            by_tables = exp[(log[a] + log[b]) % 255] if a and b else 0
            if by_tables != multiply(a, b):
                raise ValueError('Native field tables differ from GF(256) polynomial 0x11b')
    parameters = dict(snapshot_sha256=hashlib.sha256(image).hexdigest(), cipher_rva='0x3ab230',
                      local_key_hex='e7488b845f71f6cccfb8945cc05d1f0d',
                      key_source='Four local immediate DWORDs in the captured code, verified by native emulation',
                      iv='Last 16 bytes of the passed NUL-terminated name after optional .class stripping; left-zero-pad shorter names',
                      rounds=10, gf_polynomial='0x11b', field_table_pair_checks=65536,
                      inverse_mix_log_constants=[253, 134, 238, 124],
                      inverse_mix_coefficients=[exp[x] for x in (253, 134, 238, 124)],
                      rcon_hex=image[0x89aaf0:0x89aafb].hex(),
                      sbox_hex=sbox.hex(), inverse_sbox_hex=inverse.hex(),
                      exp_hex=exp.hex(), log_hex=log.hex(),
                      note='Parameters of the visible captured cipher segment only; protected helper/epilogue are unresolved and payload class validation has failed')
    (HERE / 'native-cipher-parameters.json').write_text(json.dumps(parameters, indent=2), encoding='utf-8')
    print(json.dumps({k: parameters[k] for k in ('field_table_pair_checks', 'gf_polynomial', 'inverse_mix_coefficients', 'local_key_hex')}))


if __name__ == '__main__':
    main()
