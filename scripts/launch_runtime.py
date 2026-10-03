"""Launch the isolated local test instance; never use an online account token."""
import argparse, hashlib, json, pathlib, shutil, subprocess, time
parser=argparse.ArgumentParser(description=__doc__)
parser.add_argument('--runtime',type=pathlib.Path,default=pathlib.Path(__file__).resolve().parents[1]/'.cache'/'runtime')
parser.add_argument('--profile',choices=['forge','stalker','pack'],default='pack')
parser.add_argument('--check-seconds',type=int,default=0,help='Observe startup, then stop only the process started by this script')
args=parser.parse_args()
runtime=args.runtime.resolve()
config=json.loads((runtime/'runtime-config.json').read_text(encoding='utf-8'))
# The official 1.6.4 client uses legacy signatures rejected by modern Java 8.
# Pin the original Mojang client before using Forge's narrowly scoped compatibility flag.
client=pathlib.Path(config['client_jar'])
if hashlib.sha1(client.read_bytes()).hexdigest()!='1703704407101cf72bd88e68579e3696ce733ecd':
    raise ValueError('Minecraft client differs from the original Mojang 1.6.4 artifact')
if args.profile=='pack':
    game=pathlib.Path(config['game_dir'])
else:
    game=runtime/'profiles'/args.profile
    game.mkdir(parents=True,exist_ok=True)
    if args.profile=='stalker':
        mods=game/'mods';mods.mkdir(exist_ok=True)
        name='stalker_client212.jar';target=mods/name
        if not target.exists(): shutil.copy2(pathlib.Path(config['game_dir'])/'mods'/name,target)
    options=game/'options.txt'
    if not options.exists(): options.write_text('fullscreen:false\nrenderDistance:0\nsound:0.0\nmusic:0.0\nresourcePacks:[]\n',encoding='utf-8')
if not game.resolve().is_relative_to(runtime): raise ValueError('Game path escapes isolated runtime')
logs=runtime/'logs';logs.mkdir(exist_ok=True)
logpath=logs/(args.profile+'-'+str(int(time.time()))+'.log')
java=pathlib.Path(config['java']).with_name('javaw.exe')
command=[str(java),'-Xms512m','-Xmx4g','-Dfml.ignoreInvalidMinecraftCertificates=true',
         '-Djava.library.path='+config['native_dir'],
         '-cp',';'.join(config['classpath']),config['main_class'],
         '--username','LocalTest','--session','0','--version',config['version'],
         '--gameDir',str(game),'--assetsDir',config['assets_dir'],
         '--width','1024','--height','640','--tweakClass','cpw.mods.fml.common.launcher.FMLTweaker']
with logpath.open('wb') as log:
    process=subprocess.Popen(command,cwd=game,stdout=log,stderr=subprocess.STDOUT,
                             creationflags=getattr(subprocess,'CREATE_NO_WINDOW',0))
    result={'pid':process.pid,'profile':args.profile,'game_dir':str(game),'log':str(logpath)}
    (runtime/'last-launch.json').write_text(json.dumps(result,indent=2),encoding='utf-8')
    print(json.dumps(result,indent=2),flush=True)
    if args.check_seconds:
        try:
            code=process.wait(timeout=args.check_seconds)
            print('Client exited with code',code,flush=True)
        except subprocess.TimeoutExpired:
            print('Client remains running after',args.check_seconds,'seconds; stopping this smoke-test process',flush=True)
            process.terminate()
            try: process.wait(timeout=10)
            except subprocess.TimeoutExpired: process.kill();process.wait()
        text=logpath.read_text(encoding='utf-8',errors='replace')
        print('LOG TAIL\n'+ '\n'.join(text.splitlines()[-45:]),flush=True)
