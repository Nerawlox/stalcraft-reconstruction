"""Check the name-recovery baseline and generic-signature regression cases."""
from pathlib import Path
import hashlib
import json
from classfile_index import map_signature

ROOT = Path(__file__).resolve().parents[1]
B = ROOT / 'builds/pre-2017/reconstruction'
cases = [
    ('Lold/Outer<TT;>.Inner;', {'old/Outer': 'new/Outer', 'old/Outer$Inner': 'new/Outer$Renamed'},
     'Lnew/Outer<TT;>.Renamed;'),
    ('<T:Ljava/lang/Object;U::Ljava/io/Serializable;>(TT;[Lold/Thing;)TU;^Ljava/lang/Exception;',
     {'old/Thing': 'new/Thing'},
     '<T:Ljava/lang/Object;U::Ljava/io/Serializable;>(TT;[Lnew/Thing;)TU;^Ljava/lang/Exception;'),
    ('Ljava/util/List<+Lold/Thing;>;', {'old/Thing': 'new/Thing'}, 'Ljava/util/List<+Lnew/Thing;>;'),
]
for source, names, expected in cases:
    if map_signature(source, names) != expected:
        raise ValueError('Generic signature regression: ' + source)
mapping = json.loads((B / 'names/minecraft-classes.json').read_text(encoding='utf-8'))
aliases = {row['original']: row['named'] for row in mapping['rows']}
if mapping['consistency_issues'] or len(aliases) != len(set(aliases.values())):
    raise ValueError('Invalid or conflicting class mapping')
for original, target in {'twgu': 'net/minecraft/block/Block', 'tflj': 'net/minecraft/block/material/Material',
                         'tgbl': 'net/minecraft/creativetab/CreativeTabs', 'uioo': 'net/minecraft/block/StepSound',
                         'sdrg': 'net/minecraft/world/IBlockAccess'}.items():
    if aliases.get(original) != target:
        raise ValueError('Core identity regression: ' + original)
proof = json.loads((B / 'names/named-source-snapshot.json').read_text(encoding='utf-8'))
if proof['exit_code']:
    raise ValueError('Incomplete decompilation baseline')
for row in proof['files']:
    path = B / 'src' / row['path']
    if not path.is_file() or hashlib.sha256(path.read_bytes()).hexdigest() != row['sha256']:
        raise ValueError('Named source baseline changed: ' + row['path'])
print('Name recovery checked:', len(aliases), 'class identities;', proof['java_files'],
      'source files;', len(cases), 'generic-signature regressions')
