import urllib.request, re, json
from pathlib import Path
root = Path(__file__).parent
urls = ['https://www.planetminecraft.com/project/pripyat-city/', 'https://www.planetminecraft.com/project/pripyat-city/download/mirror/306573/', 'https://www.reddit.com/r/TheZone/about.json']
for i,url in enumerate(urls):
    try:
        req = urllib.request.Request(url,headers={'User-Agent':'Mozilla/5.0'})
        with urllib.request.urlopen(req,timeout=30) as res:
            raw=res.read(); final=res.url
        text=raw.decode('utf-8','replace')
        (root/f'map-source-{i}.txt').write_text(text,encoding='utf-8')
        links = sorted(set(re.findall(r'https?[^\s<>"\x27]+',text)))
        print(json.dumps({'url':url,'final':final,'bytes':len(raw),'candidate_links':[u for u in links if any(k in u.lower() for k in ['dropbox','mediafire','drive.google','tsar','thezone','download','yadi','reddit.com/r/thezone'])]},ensure_ascii=False))
    except Exception as e: print(url,type(e).__name__,str(e))
