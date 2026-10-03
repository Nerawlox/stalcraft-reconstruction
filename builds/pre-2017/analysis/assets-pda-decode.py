from pathlib import Path
import argparse, json, re
from collections import Counter
from io import BytesIO
from scfile import formats
from PIL import Image, ImageDraw, ImageFont

def main():
    here = Path(__file__).resolve().parent
    parser = argparse.ArgumentParser(description='Decode the STALCRAFT PDA .ol tile set and create an overview.')
    parser.add_argument('--source', type=Path, default=Path(r'E:\Stalcraft project\stalcraft_pre\stalcraft\modassets\assets\pda\map'))
    parser.add_argument('--output', type=Path, default=here)
    args = parser.parse_args()
    files = sorted(args.source.glob('r.*.*.ol'))
    tiles, failures, formats_seen, mipmaps = {}, [], Counter(), Counter()
    total_bytes = 0
    for path in files:
        match = re.fullmatch(r'r\.(-?\d+)\.(-?\d+)\.ol', path.name)
        if not match:
            continue
        x, z = map(int, match.groups())
        total_bytes += path.stat().st_size
        try:
            with formats.OlDecoder(path) as decoder:
                data = decoder.decode()
            formats_seen[data.format.decode('ascii', errors='replace')] += 1
            mipmaps[data.mipmap_count] += 1
            with formats.DdsEncoder(data) as encoder:
                dds_bytes = encoder.encode().getvalue()
            tile = Image.open(BytesIO(dds_bytes)).convert('RGB')
            tile.thumbnail((96, 96), Image.Resampling.LANCZOS)
            tiles[(x, z)] = tile.copy()
        except Exception as exc:
            failures.append({'file': path.name, 'error': f'{type(exc).__name__}: {exc}'})
    if not tiles:
        raise RuntimeError(f'No tiles decoded from {args.source}')
    min_x, max_x = min(x for x, _ in tiles), max(x for x, _ in tiles)
    min_z, max_z = min(z for _, z in tiles), max(z for _, z in tiles)
    cell, left, top, right, bottom = 100, 48, 26, 12, 38
    canvas = Image.new('RGB', (left + (max_x-min_x+1)*cell + right,
                               top + (max_z-min_z+1)*cell + bottom), (38, 40, 43))
    draw, font = ImageDraw.Draw(canvas), ImageFont.load_default()
    for x in range(min_x, max_x+1):
        for z in range(min_z, max_z+1):
            px, py = left + (x-min_x)*cell, top + (z-min_z)*cell
            tile = tiles.get((x,z))
            if tile:
                canvas.paste(tile, (px+2, py+2))
                draw.rectangle((px+1, py+1, px+98, py+98), outline=(90,94,98))
            else:
                draw.rectangle((px+1, py+1, px+98, py+98), fill=(50,52,55), outline=(90,94,98))
                draw.text((px+48,py+48),'—',anchor='mm',fill=(165,165,165),font=font)
    for x in range(min_x,max_x+1):
        draw.text((left+(x-min_x)*cell+48,6),str(x),anchor='mm',fill='white',font=font)
    for z in range(min_z,max_z+1):
        draw.text((8,top+(z-min_z)*cell+48),str(z),anchor='mm',fill='white',font=font)
    draw.text((left,top+(max_z-min_z+1)*cell+10),
              'PDA tiles: X horizontal; Z increases downward; blank cells are absent',
              fill=(230,230,230),font=font)
    args.output.mkdir(parents=True, exist_ok=True)
    overview = args.output / 'assets-pda-overview.png'
    canvas.save(overview, optimize=True)
    stats = {
        'decoder': 'sc-file 5.2.1 (onejeuu/sc-file)', 'python': '3.12',
        'source': str(args.source), 'files': len(files), 'decoded': len(tiles),
        'failures': failures, 'source_bytes': total_bytes,
        'tile_dimensions': [512, 512], 'x_index_range': [min_x,max_x],
        'z_index_range': [min_z,max_z], 'x_column_counts': dict(sorted(Counter(x for x,_ in tiles).items())),
        'formats': dict(formats_seen), 'mipmap_counts': dict(mipmaps),
        'overview': overview.name, 'overview_dimensions': list(canvas.size),
        'overview_bytes': overview.stat().st_size,
        'limitations': 'only bundled PDA tiles; blank grid cells indicate missing tile files; no world save or terrain height data represented'
    }
    (args.output/'assets-pda-stats.json').write_text(json.dumps(stats,ensure_ascii=False,indent=2)+'\n',encoding='utf-8')
    print(json.dumps(stats,ensure_ascii=False,indent=2))

if __name__ == '__main__':
    main()
