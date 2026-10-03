import concurrent.futures, datetime, json, urllib.request, urllib.parse, urllib.error
from pathlib import Path
root=Path(__file__).parent
def probe(key):
    url='https://cloud-api.yandex.net/v1/disk/public/resources?'+urllib.parse.urlencode({'public_key':'https://yadi.sk/d/'+key,'limit':100})
    result={'public_key':'https://yadi.sk/d/'+key,'request_url':url,'checked_at_utc':datetime.datetime.now(datetime.timezone.utc).isoformat()}
    try:
        with urllib.request.urlopen(url,timeout=30) as res: result.update(http_status=res.status,body=json.loads(res.read()))
    except urllib.error.HTTPError as e:
        raw=e.read().decode('utf-8','replace')
        try: body=json.loads(raw)
        except ValueError: body=raw[:2000]
        result.update(http_status=e.code,body=body)
    except Exception as e: result['error']=str(e)
    (root/f'yandex-{key}.json').write_text(json.dumps(result,ensure_ascii=False,indent=2),encoding='utf-8')
    return result
with concurrent.futures.ThreadPoolExecutor(max_workers=2) as pool:
    for result in pool.map(probe,['OxPBU7eEUnEzzw','dRJxiYFasz_-tg']): print(json.dumps(result,ensure_ascii=False))
