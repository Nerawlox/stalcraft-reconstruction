"""Prepare a separate, local Minecraft 1.6.4/Forge instance from official metadata."""
import argparse, concurrent.futures, hashlib, json, os, pathlib, re, shutil, time, urllib.request, zipfile
BASE=pathlib.Path(__file__).resolve().parent
parser=argparse.ArgumentParser(description=__doc__)
parser.add_argument('--repo',type=pathlib.Path,default=BASE.parent)
parser.add_argument('--original',type=pathlib.Path)
parser.add_argument('--java-home',type=pathlib.Path)
args=parser.parse_args()
REPO=args.repo.resolve()
RUNTIME=(REPO/'.cache'/'runtime').resolve()
ORIGINAL=(args.original or REPO.parent/'Сборка STALKRAFT от Алекса').resolve()
DOWNLOADS=REPO/'.cache'/'official-downloads';DOWNLOADS.mkdir(parents=True,exist_ok=True)
if not RUNTIME.is_relative_to(REPO): raise ValueError('Runtime path escapes repository')
RUNTIME.mkdir(parents=True,exist_ok=True)
GAME=RUNTIME/'game';GAME.mkdir(exist_ok=True)
METADATA=RUNTIME/'metadata';METADATA.mkdir(exist_ok=True)
FILES=[]
def digest(path,kind='sha1'):
    h=hashlib.new(kind)
    with path.open('rb') as f:
        while b:=f.read(1024*1024): h.update(b)
    return h.hexdigest()
def fetch(url,path,sha1=None):
    path.parent.mkdir(parents=True,exist_ok=True)
    if path.exists() and (not sha1 or digest(path)==sha1): return path
    last=None
    for attempt in range(3):
        try:
            req=urllib.request.Request(url,headers={'User-Agent':'Stalcraft-local-check/1.0'})
            part=path.with_suffix(path.suffix+'.part')
            with urllib.request.urlopen(req,timeout=35) as r,part.open('wb') as f:
                while b:=r.read(1024*1024): f.write(b)
            if sha1 and digest(part)!=sha1: raise ValueError('Checksum mismatch: '+url)
            part.replace(path)
            return path
        except Exception as e:
            last=e
            if attempt<2: time.sleep(attempt+1)
    raise last
def coordinate(name,classifier=None):
    group,artifact,version=name.split(':')[:3]
    file=artifact+'-'+version+('-'+classifier if classifier else '')+'.jar'
    return '/'.join((group.replace('.','/'),artifact,version,file))
def allowed(lib):
    if 'rules' not in lib: return True
    value=False
    for rule in lib['rules']:
        osrule=rule.get('os',{})
        if osrule.get('name','windows')!='windows': continue
        if osrule.get('arch') and osrule['arch'] not in ('x86','x86_64'): continue
        value=rule['action']=='allow'
    return value

installer=fetch('https://maven.minecraftforge.net/net/minecraftforge/forge/1.6.4-9.11.1.1345/forge-1.6.4-9.11.1.1345-installer.jar',
                DOWNLOADS/'forge-installer.jar','7a57c0febe74260bfdee1a5d4968982d8863a02c')
with zipfile.ZipFile(installer) as z: profile=json.loads(z.read('install_profile.json'))
manifest=json.loads(fetch('https://piston-meta.mojang.com/mc/game/version_manifest_v2.json',DOWNLOADS/'version-manifest.json').read_text())
mc_version=next(v for v in manifest['versions'] if v['id']=='1.6.4')
mc=json.loads(fetch(mc_version['url'],DOWNLOADS/'minecraft-1.6.4.json',mc_version['sha1']).read_text())
if digest(installer)!='7a57c0febe74260bfdee1a5d4968982d8863a02c': raise ValueError('Forge installer checksum mismatch')
for name,data in [('minecraft-1.6.4.json',mc),('forge-profile.json',profile)]:
    (METADATA/name).write_text(json.dumps(data,indent=2),encoding='utf-8')
forgepath=RUNTIME/'libraries'/coordinate(profile['install']['path'])
forgepath.parent.mkdir(parents=True,exist_ok=True)
with zipfile.ZipFile(installer) as z: forgepath.write_bytes(z.read(profile['install']['filePath']))
if digest(forgepath)!='eb9d954c8d057fa1768acaa40a35b864ad05c58b': raise ValueError('Forge universal checksum mismatch')

downloads=[];classpath=[forgepath];natives=[]
mc_by_name={lib['name']:lib for lib in mc['libraries']}
for lib in profile['versionInfo']['libraries']:
    if not allowed(lib) or lib['name']==profile['install']['path']: continue
    spec=mc_by_name.get(lib['name'],{}).get('downloads',{})
    native=lib.get('natives',{}).get('windows')
    if native:
        spec=spec.get('classifiers',{}).get(native,{})
    else:
        spec=spec.get('artifact',{})
    rel=spec.get('path') or coordinate(lib['name'],native)
    url=spec.get('url') or lib.get('url','https://libraries.minecraft.net/')+rel
    path=RUNTIME/'libraries'/rel
    expected=spec.get('sha1')
    downloads.append((url,path,expected))
    if native: natives.append(path)
    else: classpath.append(path)
client=mc['downloads']['client'];clientpath=RUNTIME/'versions'/'1.6.4'/'1.6.4.jar'
downloads.append((client['url'],clientpath,client['sha1']));classpath.append(clientpath)
print('Downloading/verifying',len(downloads),'client and library files',flush=True)
with concurrent.futures.ThreadPoolExecutor(max_workers=6) as pool:
    futures={pool.submit(fetch,*job):job for job in downloads}
    for f in concurrent.futures.as_completed(futures):
        job=futures[f];path=f.result();FILES.append({'url':job[0],'path':str(path.relative_to(RUNTIME)),'sha1':digest(path)})
print('Client and libraries ready',flush=True)
native_dir=RUNTIME/'natives';native_dir.mkdir(exist_ok=True)
for path in natives:
    with zipfile.ZipFile(path) as z:
        for name in z.namelist():
            if name.endswith('/') or name.startswith('META-INF/'): continue
            target=(native_dir/name).resolve()
            if not target.is_relative_to(native_dir): raise ValueError(name)
            target.parent.mkdir(parents=True,exist_ok=True);target.write_bytes(z.read(name))

java_home=RUNTIME/'java'
if not java_home.exists():
    if args.java_home:
        if not (args.java_home/'bin'/'java.exe').is_file(): raise ValueError('Java home must contain bin/java.exe')
        shutil.copytree(args.java_home,java_home)
    else:
        java_archive=DOWNLOADS/'temurin8-jre.zip'
        fetch('https://github.com/adoptium/temurin8-binaries/releases/download/jdk8u504-b01/OpenJDK8U-jre_x64_windows_hotspot_8u504b01.zip',java_archive)
        if digest(java_archive,'sha256')!='82e2cdc6693737c5998445b31f69668fa0da77c7705121053f6508ac84961123': raise ValueError('Java package checksum mismatch')
        unpack=DOWNLOADS/'java-unpacked';unpack.mkdir(exist_ok=True)
        with zipfile.ZipFile(java_archive) as z:
            if any(not (unpack/n).resolve().is_relative_to(unpack.resolve()) for n in z.namelist()): raise ValueError('Invalid Java package paths')
            z.extractall(unpack)
        executables=list(unpack.rglob('java.exe'))
        if len(executables)!=1: raise ValueError('Unexpected Java package layout')
        shutil.copytree(executables[0].parent.parent,java_home)
java=java_home/'bin'/'java.exe'
mods=GAME/'mods';mods.mkdir(exist_ok=True)
excluded={'Sound.jar':'AuthReplacer changes online authentication; unnecessary for a local test',
          'Smart Moving Universal Standalone.zip':'Alternative standalone installation duplicates the Forge variant',
          'MAtmos_r25_1.6.4.litemod':'LiteLoader is absent; optional ambience mod'}
for path in (ORIGINAL/'Моды').iterdir():
    if path.is_file() and path.suffix in ('.jar','.zip') and path.name not in excluded:
        target=mods/path.name
        if not target.exists(): shutil.copy2(path,target)
print('Copied',len(list(mods.iterdir())),'mods; excluded',list(excluded),flush=True)

saves=GAME/'saves';saves.mkdir(exist_ok=True)
world=saves/'TheZone-test'
if not world.exists(): shutil.copytree(ORIGINAL/'Карта'/'TheZone-45!',world)
fixed=[]
for path in world.rglob('*'):
    if path.is_file() and path.suffix=='.mса':
        target=path.with_suffix('.mca').resolve()
        if not target.is_relative_to(world.resolve()): raise ValueError('Region target escapes copied world')
        if target.exists(): raise FileExistsError(target)
        path.rename(target);fixed.append(str(target.relative_to(world)))
print('Copied world; repaired',len(fixed),'Cyrillic region extensions in the copy',flush=True)
packs=GAME/'resourcepacks';packs.mkdir(exist_ok=True)
pack=packs/'STALCRAFT-original'
if not pack.exists(): shutil.copytree(ORIGINAL/'Текстурпак'/'S.T.A.L.C.R.A.F.T',pack)
# Minecraft 1.6.4 selects its single resource pack with "skin", not "resourcePacks".
options=GAME/'options.txt'
if not options.exists(): options.write_text('fullscreen:false\nrenderDistance:0\nsound:0.0\nmusic:0.0\nskin:STALCRAFT-original\nlang:ru_RU\n',encoding='utf-8')

asset_info=mc['assetIndex']
indexpath=RUNTIME/'assets'/'indexes'/(asset_info['id']+'.json')
fetch(asset_info['url'],indexpath,asset_info['sha1'])
index=json.loads(indexpath.read_text())
asset_jobs=[]
for name,info in index['objects'].items():
    sha=info['hash'];path=RUNTIME/'assets'/'objects'/sha[:2]/sha
    asset_jobs.append(('https://resources.download.minecraft.net/'+sha[:2]+'/'+sha,path,sha))
asset_jobs=list({str(j[1]):j for j in asset_jobs}.values())
print('Downloading/verifying',len(asset_jobs),'legacy asset objects',flush=True)
with concurrent.futures.ThreadPoolExecutor(max_workers=10) as pool:
    futures=[pool.submit(fetch,*job) for job in asset_jobs]
    for i,f in enumerate(concurrent.futures.as_completed(futures),1):
        f.result()
        if i%200==0 or i==len(futures): print('Assets',i,'/',len(futures),flush=True)
virtual=RUNTIME/'assets'/'virtual'/'legacy';virtual.mkdir(parents=True,exist_ok=True)
for name,info in index['objects'].items():
    sha=info['hash'];source=RUNTIME/'assets'/'objects'/sha[:2]/sha
    target=(virtual/name).resolve()
    if not target.is_relative_to(virtual): raise ValueError(name)
    target.parent.mkdir(parents=True,exist_ok=True)
    if not target.exists():
        try: os.link(source,target)
        except OSError: shutil.copy2(source,target)
config={'java':str(java),'classpath':[str(p) for p in classpath],'client_jar':str(clientpath),
        'native_dir':str(native_dir),'game_dir':str(GAME),'assets_dir':str(virtual),
        'main_class':profile['versionInfo']['mainClass'],'version':profile['versionInfo']['id'],
        'excluded_mods':excluded,'region_extensions_fixed':fixed,'downloaded_files':FILES,
        'forge_sha1':digest(forgepath),'client_sha1':digest(clientpath),'ready':True}
(RUNTIME/'runtime-config.json').write_text(json.dumps(config,ensure_ascii=False,indent=2),encoding='utf-8')
print('Runtime ready:',RUNTIME,flush=True)
