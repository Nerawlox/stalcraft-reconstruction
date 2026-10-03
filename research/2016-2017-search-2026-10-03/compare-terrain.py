"""Read both worlds without modification; compare deterministic distributed chunks."""
import collections, gzip, hashlib, json, struct, zipfile, zlib
from pathlib import Path
ns = {}
exec(Path(__file__).with_name('compare-thezone.py').read_text(encoding='utf-8').split('baseline = Path')[0], ns)
class Reader(ns['NBT']):
    def val(self, t, depth=0):
        if t == 7:
            return self.take(self.unpack('i'))
        return super().val(t, depth)
def chunk(region, slot):
    loc = struct.unpack_from('>I', region, slot*4)[0]
    if not loc: return None
    off = (loc >> 8)*4096
    length = struct.unpack_from('>I', region, off)[0]
    data = region[off+5:off+4+length]
    typ = region[off+4]
    raw = zlib.decompress(data) if typ == 2 else gzip.decompress(data) if typ == 1 else data
    r = Reader(raw)
    t = r.unpack('B'); r.text()
    return r.val(t)['Level']
def terrain(level):
    sections = {s['Y']: s for s in level.get('Sections', [])}
    return b''.join(sections.get(y, {}).get('Blocks', bytes(4096)) for y in range(16))
root = Path(r'E:\Stalcraft project')
baseline = root / 'Сборка STALKRAFT от Алекса' / 'Карта' / 'TheZone-45!' / 'region'
candidate = root / 'builds' / 'thezone-ru-minecraft-2017'
original = {tuple(map(int, p.name.split('.')[1:3])):p for p in baseline.iterdir() if p.name.startswith('r.')}
records = []
with zipfile.ZipFile(candidate/'original'/'TheZone.zip') as archive:
    regions = {tuple(map(int, Path(e.filename).name.split('.')[1:3])):e for e in archive.infolist() if e.filename.startswith('TheZone/region/') and e.filename.endswith('.mca')}
    common = sorted(set(original)&set(regions))
    # Cover every overlapping region. Four evenly separated slots per region.
    for i, coords in enumerate(common):
        a = original[coords].read_bytes(); b = archive.read(regions[coords])
        for slot in [0,341,682,1023]:
            ca, cb = chunk(a, slot), chunk(b, slot)
            if ca is None or cb is None: continue
            ba, bb = terrain(ca), terrain(cb)
            matches = sum(x == y for x,y in zip(ba,bb))
            occupied = sum(x != 0 or y != 0 for x,y in zip(ba,bb))
            occupied_matches = sum(x == y and x != 0 for x,y in zip(ba,bb))
            records.append({'region':list(coords),'slot':slot,'baseline_chunk':[ca['xPos'],ca['zPos']], 'candidate_chunk':[cb['xPos'],cb['zPos']], 'equal_block_id_bytes':matches,'total_block_id_bytes':len(ba),'occupied_union_blocks':occupied,'equal_nonair_blocks':occupied_matches,'exact_block_ids':ba==bb,'baseline_sha256':hashlib.sha256(ba).hexdigest(),'candidate_sha256':hashlib.sha256(bb).hexdigest()})
        if i%50 == 0: print(f'Compared {i+1}/{len(common)} regions', flush=True)
result = {'method':'Four deterministic chunk slots 0,341,682,1023 per common region; compare Sections Blocks arrays padded to 16 sections. Does not compare metadata/nibble arrays, entities, lighting, Add arrays or entire world.', 'regions_examined':len(common),'paired_chunks':len(records),'chunks_identical_block_ids':sum(r['exact_block_ids'] for r in records),'same_internal_chunk_coordinates':sum(r['baseline_chunk']==r['candidate_chunk'] for r in records),'total_matching_bytes':sum(r['equal_block_id_bytes'] for r in records),'total_compared_bytes':sum(r['total_block_id_bytes'] for r in records),'samples':records}
result['occupied_union_blocks'] = sum(r['occupied_union_blocks'] for r in records)
result['equal_nonair_blocks'] = sum(r['equal_nonair_blocks'] for r in records)
(candidate/'analysis'/'terrain-comparison.json').write_text(json.dumps(result,ensure_ascii=False,indent=2),encoding='utf-8')
print(json.dumps({k:v for k,v in result.items() if k!='samples'},ensure_ascii=False,indent=2))
