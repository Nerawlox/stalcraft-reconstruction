"""Preserve a separate map candidate. Never execute downloaded content."""
import datetime
import hashlib
import json
from pathlib import Path
import urllib.parse
import urllib.request
import zipfile

root = Path(r"E:\Stalcraft project\builds\thezone-ru-minecraft-2017")
original = root / "original"
analysis = root / "analysis"
original.mkdir(parents=True, exist_ok=True)
analysis.mkdir(parents=True, exist_ok=True)
public_url = "https://yadi.sk/d/TPU2Rfe83JkLn7"
api = "https://cloud-api.yandex.net/v1/disk/public/resources?" + urllib.parse.urlencode({"public_key": public_url})
with urllib.request.urlopen(api, timeout=25) as response:
    metadata = json.load(response)
(analysis / "source-metadata.json").write_text(json.dumps(metadata, ensure_ascii=False, indent=2), encoding="utf-8")
target = original / "TheZone.zip"
if not target.exists():
    partial = target.with_suffix(".zip.partial")
    sha = hashlib.sha256()
    size = 0
    next_report = 32 * 1024 * 1024
    with urllib.request.urlopen(metadata["file"], timeout=40) as response, partial.open("wb") as stream:
        print("HTTP", response.status, "expected bytes", metadata["size"], flush=True)
        while chunk := response.read(1024 * 1024):
            stream.write(chunk)
            sha.update(chunk)
            size += len(chunk)
            if size >= next_report:
                print("Downloaded", size, "bytes", flush=True)
                next_report += 32 * 1024 * 1024
    if size != metadata["size"] or sha.hexdigest() != metadata["sha256"]:
        raise RuntimeError("Downloaded size or hash differs from metadata; partial retained")
    partial.replace(target)
else:
    sha = hashlib.sha256(target.read_bytes())
    size = target.stat().st_size
    if sha.hexdigest() != metadata["sha256"]:
        raise RuntimeError("Existing archive hash mismatch")
provenance = {
    "id": "thezone-ru-minecraft-2017", "kind": "map-candidate-not-client",
    "public_url": public_url,
    "source_page": "https://ru-minecraft.ru/karty-dlja-minecraft/48628-the-zone-chernobyl-exclusion-zone-ona-zhe-stalcraft-mega-karta.html",
    "retrieved_at_utc": datetime.datetime.now(datetime.timezone.utc).isoformat(),
    "filename": target.name, "size": size, "sha256": sha.hexdigest(),
    "cloud_created": metadata["created"], "cloud_modified": metadata["modified"],
    "caution": "Cloud timestamps and publication date do not establish map creation or official STALCRAFT provenance. Page specifies Minecraft 1.11.2+.",
    "executed": False,
}
(analysis / "provenance.json").write_text(json.dumps(provenance, ensure_ascii=False, indent=2), encoding="utf-8")
with zipfile.ZipFile(target) as archive:
    entries = [{"name": i.filename, "size": i.file_size, "compressed": i.compress_size, "timestamp": i.date_time, "crc": i.CRC} for i in archive.infolist()]
    (analysis / "zip-inventory.json").write_text(json.dumps(entries, ensure_ascii=False, indent=2), encoding="utf-8")
print(json.dumps(provenance, ensure_ascii=False), flush=True)
print("ZIP entries", len(entries), "regions", sum(e["name"].endswith(".mca") for e in entries), flush=True)
