/*
 * Decompiled with CFR 0.152.
 */
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.util.hanr;

public class rqmi {
    public final String _a;
    public final String _b;
    public static String _c = "https://mcoapi.minecraft.net/";

    public rqmi(hanr hanr2) {
        this._a = hanr2._b();
        this._b = hanr2._a();
    }

    public oyhq _a() {
        String string = this._a(klxf._a(_c + "worlds"));
        return oyhq._a(string);
    }

    public rqmh _a(long l) {
        String string = this._a(klxf._a(_c + "worlds" + "/$ID".replace("$ID", String.valueOf(l))));
        return rqmh._c(string);
    }

    public vlwy _b(long l) {
        String string = _c + "worlds" + "/$ID/join".replace("$ID", "" + l);
        String string2 = this._a(klxf._a(string));
        return vlwy._a(string2);
    }

    public void _a(String string, String string2, String string3, String string4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(_c).append("worlds").append("/$NAME/$LOCATION_ID".replace("$NAME", this._c(string)));
        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (string2 != null && !string2.trim().equals("")) {
            hashMap.put("motd", string2);
        }
        if (string3 != null && !string3.equals("")) {
            hashMap.put("seed", string3);
        }
        hashMap.put("template", string4);
        if (!hashMap.isEmpty()) {
            boolean bl = true;
            for (Map.Entry entry : hashMap.entrySet()) {
                if (bl) {
                    stringBuilder.append("?");
                    bl = false;
                } else {
                    stringBuilder.append("&");
                }
                stringBuilder.append((String)entry.getKey()).append("=").append(this._c((String)entry.getValue()));
            }
        }
        this._a(klxf._a(stringBuilder.toString(), "", 5000, 30000));
    }

    public Boolean _b() {
        String string = _c + "mco" + "/available";
        String string2 = this._a(klxf._a(string));
        return Boolean.valueOf(string2);
    }

    public Boolean _c() {
        String string = _c + "mco" + "/client/outdated";
        String string2 = this._a(klxf._a(string));
        return Boolean.valueOf(string2);
    }

    public int _d() {
        String string = _c + "payments" + "/unused";
        String string2 = this._a(klxf._a(string));
        return Integer.valueOf(string2);
    }

    public void _a(long l, String string) {
        String string2 = _c + "invites" + "/$WORLD_ID/invite/$USER_NAME".replace("$WORLD_ID", String.valueOf(l)).replace("$USER_NAME", string);
        this._a(klxf._b(string2));
    }

    public void _c(long l) {
        String string = _c + "invites" + "/$WORLD_ID".replace("$WORLD_ID", String.valueOf(l));
        this._a(klxf._b(string));
    }

    public rqmh _b(long l, String string) {
        String string2 = _c + "invites" + "/$WORLD_ID/invite/$USER_NAME".replace("$WORLD_ID", String.valueOf(l)).replace("$USER_NAME", string);
        String string3 = this._a(klxf._b(string2, ""));
        return rqmh._c(string3);
    }

    public uitq _d(long l) {
        String string = _c + "worlds" + "/$WORLD_ID/backups".replace("$WORLD_ID", String.valueOf(l));
        String string2 = this._a(klxf._a(string));
        return uitq._a(string2);
    }

    public void _a(long l, String string, String string2, int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(_c).append("worlds").append("/$WORLD_ID/$NAME".replace("$WORLD_ID", String.valueOf(l)).replace("$NAME", this._c(string)));
        if (string2 != null && !string2.trim().equals("")) {
            stringBuilder.append("?motd=").append(this._c(string2));
        } else {
            stringBuilder.append("?motd=");
        }
        stringBuilder.append("&difficulty=").append(n).append("&gameMode=").append(n2);
        this._a(klxf._c(stringBuilder.toString(), ""));
    }

    public void _c(long l, String string) {
        String string2 = _c + "worlds" + "/$WORLD_ID/backups".replace("$WORLD_ID", String.valueOf(l)) + "?backupId=" + string;
        this._a(klxf._c(string2, ""));
    }

    public xsax _e() {
        String string = _c + "worlds" + "/templates";
        String string2 = this._a(klxf._a(string));
        return xsax._a(string2);
    }

    public Boolean _e(long l) {
        String string = _c + "worlds" + "/$WORLD_ID/open".replace("$WORLD_ID", String.valueOf(l));
        String string2 = this._a(klxf._c(string, ""));
        return Boolean.valueOf(string2);
    }

    public Boolean _f(long l) {
        String string = _c + "worlds" + "/$WORLD_ID/close".replace("$WORLD_ID", String.valueOf(l));
        String string2 = this._a(klxf._c(string, ""));
        return Boolean.valueOf(string2);
    }

    public Boolean _d(long l, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(_c).append("worlds").append("/$WORLD_ID/reset".replace("$WORLD_ID", String.valueOf(l)));
        if (string != null && string.length() > 0) {
            stringBuilder.append("?seed=").append(this._c(string));
        }
        String string2 = this._a(klxf._b(stringBuilder.toString(), "", 30000, 80000));
        return Boolean.valueOf(string2);
    }

    public Boolean _e(long l, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(_c).append("worlds").append("/$WORLD_ID/reset".replace("$WORLD_ID", String.valueOf(l)));
        if (string != null) {
            stringBuilder.append("?template=").append(string);
        }
        String string2 = this._a(klxf._b(stringBuilder.toString(), "", 30000, 80000));
        return Boolean.valueOf(string2);
    }

    public nedg _g(long l) {
        String string = this._a(klxf._a(_c + "subscriptions" + "/$WORLD_ID".replace("$WORLD_ID", String.valueOf(l))));
        return nedg._a(string);
    }

    public int _f() {
        String string = this._a(klxf._a(_c + "invites" + "/count/pending"));
        return Integer.parseInt(string);
    }

    public ohcl _g() {
        String string = this._a(klxf._a(_c + "invites" + "/pending"));
        return ohcl._a(string);
    }

    public void _a(String string) {
        this._a(klxf._c(_c + "invites" + "/accept/$INVITATION_ID".replace("$INVITATION_ID", string), ""));
    }

    public void _b(String string) {
        this._a(klxf._c(_c + "invites" + "/reject/$INVITATION_ID".replace("$INVITATION_ID", string), ""));
    }

    public String _c(String string) {
        return URLEncoder.encode(string, "UTF-8");
    }

    public String _a(klxf klxf2) {
        klxf2._a("sid", this._a);
        klxf2._a("user", this._b);
        klxf2._a("version", "1.6.4");
        try {
            int n = klxf2._a();
            if (n == 503) {
                int n2 = klxf2._b();
                throw new dhdd(n2);
            }
            if (n < 200 || n >= 300) {
                throw new twsl(klxf2._a(), klxf2._c(), klxf2._g());
            }
            return klxf2._c();
        }
        catch (htpz htpz2) {
            throw new twsl(500, "Server not available!", -1);
        }
    }
}

