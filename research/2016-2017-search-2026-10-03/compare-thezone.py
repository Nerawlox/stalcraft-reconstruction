"""Read-only NBT and region-header comparison of two independently kept maps."""
import collections
import datetime
import gzip
import json
from pathlib import Path
import struct
import zipfile

class NBT:
    def __init__(self, data):
        self.data, self.pos = data, 0
    def take(self, n):
        if n < 0 or self.pos + n > len(self.data):
            raise ValueError("NBT length exceeds remaining bytes")
        result = self.data[self.pos:self.pos + n]
        self.pos += n
        return result
    def unpack(self, fmt):
        return struct.unpack(">" + fmt, self.take(struct.calcsize(">" + fmt)))[0]
    def text(self):
        return self.take(self.unpack("H")).decode("utf-8", "replace")
    def val(self, t, depth=0):
        if depth > 64:
            raise ValueError("NBT nesting exceeds 64")
        if 1 <= t <= 6:
            return self.unpack({1:"b", 2:"h", 3:"i", 4:"q", 5:"f", 6:"d"}[t])
        if t == 7:
            return {"byte_array_length": len(self.take(self.unpack("i")))}
        if t == 8:
            return self.text()
        if t == 9:
            typ, count = self.unpack("B"), self.unpack("i")
            if not 0 <= count <= 1000000:
                raise ValueError("Excessive NBT list")
            return [self.val(typ, depth+1) for _ in range(count)]
        if t == 10:
            result = {}
            while typ := self.unpack("B"):
                name = self.text()
                result[name] = self.val(typ, depth+1)
            return result
        if t in (11,12):
            count = self.unpack("i")
            if not 0 <= count <= 1000000:
                raise ValueError("Excessive NBT array")
            return [self.unpack("i" if t == 11 else "q") for _ in range(count)]
        raise ValueError(f"Unknown tag {t}")

def parse(data):
    reader = NBT(gzip.decompress(data))
    typ = reader.unpack("B")
    reader.text()
    return reader.val(typ)

baseline = Path(r"E:\Stalcraft project\Сборка STALKRAFT от Алекса\Карта\TheZone-45!")
candidate = Path(r"E:\Stalcraft project\builds\thezone-ru-minecraft-2017")
output = candidate / "analysis"
with zipfile.ZipFile(candidate / "original" / "TheZone.zip") as archive:
    metadata = parse(archive.read("TheZone/level.dat"))
    (output / "level-metadata.json").write_text(json.dumps(metadata, ensure_ascii=False, indent=2), encoding="utf-8")
    regions = {}
    chunks = 0
    for entry in archive.infolist():
        if entry.filename.startswith("TheZone/region/") and entry.filename.endswith(".mca"):
            name = Path(entry.filename).name
            _, x, z, _ = name.split(".")
            with archive.open(entry) as stream:
                header = stream.read(4096)
            coords = (int(x), int(z))
            count = sum(bool(struct.unpack_from(">I", header, i*4)[0]) for i in range(1024))
            regions[coords] = count
            chunks += count

original_metadata = parse((baseline / "level.dat").read_bytes())
original_regions = set()
original_chunks = 0
for path in (baseline / "region").iterdir():
    if not path.is_file() or not path.name.startswith("r."):
        continue
    parts = path.name.split(".")
    if len(parts) != 4:
        continue
    original_regions.add((int(parts[1]), int(parts[2])))
    with path.open("rb") as stream:
        header = stream.read(4096)
    original_chunks += sum(bool(struct.unpack_from(">I", header, i*4)[0]) for i in range(1024))

def selected(root):
    data = root["Data"]
    fields = ["LevelName", "version", "DataVersion", "Version", "LastPlayed", "RandomSeed", "SpawnX", "SpawnY", "SpawnZ", "generatorName", "generatorVersion"]
    result = {key: data[key] for key in fields if key in data}
    if "LastPlayed" in result:
        result["LastPlayed_utc"] = datetime.datetime.fromtimestamp(result["LastPlayed"]/1000, datetime.timezone.utc).isoformat()
    return result

report = {
    "candidate": selected(metadata), "baseline": selected(original_metadata),
    "candidate_regions": len(regions), "candidate_chunks": chunks,
    "baseline_regions": len(original_regions), "baseline_chunks": original_chunks,
    "same_region_coordinates": len(set(regions) & original_regions),
    "candidate_region_extent": {"x":[min(x for x,z in regions), max(x for x,z in regions)], "z":[min(z for x,z in regions), max(z for x,z in regions)]},
    "limitations": "Matching region coordinates do not prove matching terrain. No file modifications, extraction into runtime, or game execution. Region header count includes allocated chunk slots, not validation of every chunk.",
}
(output / "baseline-comparison.json").write_text(json.dumps(report, ensure_ascii=False, indent=2), encoding="utf-8")
print(json.dumps(report, ensure_ascii=False, indent=2))
