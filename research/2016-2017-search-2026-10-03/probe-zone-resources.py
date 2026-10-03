import urllib.request, urllib.error, json, datetime
from pathlib import Path
root=Path(__file__).parent
result=[]
for name,key in [('ZoneResources.zip','497bkh99i7ubpl1'),('ZoneGrass.zip','ady10ivkakbv2yl'),('ZoneSounds.zip','5sm8mk25v90odxk')]:
    url=f'https://www.dropbox.com/s/{key}/{name}?dl=1'
    item={'name':name,'url':url,'checked_at_utc':datetime.datetime.now(datetime.timezone.utc).isoformat()}
    try:
        req=urllib.request.Request(url,headers={'User-Agent':'Mozilla/5.0'})
        with urllib.request.urlopen(req,timeout=20) as res:
            prefix=res.read(4096)
            item.update(http_status=res.status,content_type=res.headers.get('Content-Type'),content_length=res.headers.get('Content-Length'),last_modified=res.headers.get('Last-Modified'),prefix_hex=prefix[:32].hex(),is_zip_prefix=prefix.startswith(b'PK'))
    except urllib.error.HTTPError as e: item.update(http_status=e.code,error=str(e))
    except Exception as e: item['error']=str(e)
    result.append(item); print(json.dumps(item),flush=True)
(root/'zone-resource-probes.json').write_text(json.dumps(result,indent=2),encoding='utf-8')
