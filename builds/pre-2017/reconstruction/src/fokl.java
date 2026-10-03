/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.bundle.pidb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mcoptifine.Config;

public class fokl {
    public final List _a = new ArrayList();
    public final List _b = new ArrayList();
    public boolean _c;
    public String _d = "";
    public final Map _e = new HashMap();
    public boolean _f;
    public boolean _g = this._f = true;
    public long _h = 0L;
    public long _i = 0L;
    public long _j = 0L;
    public long _k = 0L;

    public void _a() {
        this._e.clear();
        this._d = "";
        this._a.clear();
        this._g = this._f;
    }

    public void _a(String string) {
        pidb._a(this, string);
        if (Config.getGameSettings().showDebugInfo) {
            if (this._h == 0L && string.equals("tick")) {
                this._h = System.nanoTime();
            }
            if (this._h != 0L && string.equals("preRenderErrors")) {
                this._i = System.nanoTime() - this._h;
                this._h = 0L;
            }
            if (this._j == 0L && string.equals("updatechunks")) {
                this._j = System.nanoTime();
            }
            if (this._j != 0L && string.equals("terrain")) {
                this._k = System.nanoTime() - this._j;
                this._j = 0L;
            }
        }
        if (this._g && this._c) {
            if (this._d.length() > 0) {
                this._d = this._d + ".";
            }
            this._d = this._d + string;
            this._a.add(this._d);
            this._b.add(System.nanoTime());
        }
    }

    public void _b() {
        pidb._a(this);
        if (this._g && this._c) {
            long l = System.nanoTime();
            long l2 = (Long)this._b.remove(this._b.size() - 1);
            this._a.remove(this._a.size() - 1);
            long l3 = l - l2;
            if (this._e.containsKey(this._d)) {
                this._e.put(this._d, (Long)this._e.get(this._d) + l3);
            } else {
                this._e.put(this._d, l3);
            }
            if (l3 > 100000000L) {
                System.out.println("Something's taking too long! '" + this._d + "' took aprox " + (double)l3 / 1000000.0 + " ms");
            }
            this._d = !this._a.isEmpty() ? (String)this._a.get(this._a.size() - 1) : "";
        }
    }

    public List _b(String string) {
        this._g = this._f;
        if (!this._g) {
            return new ArrayList<qojt>(Arrays.asList(new qojt("root", 0.0, 0.0)));
        }
        if (!this._c) {
            return null;
        }
        long l = this._e.containsKey("root") ? (Long)this._e.get("root") : 0L;
        long l2 = this._e.containsKey(string) ? (Long)this._e.get(string) : -1L;
        ArrayList<qojt> arrayList = new ArrayList<qojt>();
        if (string.length() > 0) {
            string = string + ".";
        }
        long l3 = 0L;
        for (String string2 : this._e.keySet()) {
            if (string2.length() <= string.length() || !string2.startsWith(string) || string2.indexOf(".", string.length() + 1) >= 0) continue;
            l3 += ((Long)this._e.get(string2)).longValue();
        }
        float f = l3;
        if (l3 < l2) {
            l3 = l2;
        }
        if (l < l3) {
            l = l3;
        }
        for (String string3 : this._e.keySet()) {
            if (string3.length() <= string.length() || !string3.startsWith(string) || string3.indexOf(".", string.length() + 1) >= 0) continue;
            long l4 = (Long)this._e.get(string3);
            double d = (double)l4 * 100.0 / (double)l3;
            double d2 = (double)l4 * 100.0 / (double)l;
            String string4 = string3.substring(string.length());
            arrayList.add(new qojt(string4, d, d2));
        }
        for (String string3 : this._e.keySet()) {
            this._e.put(string3, (Long)this._e.get(string3) * 999L / 1000L);
        }
        if ((float)l3 > f) {
            arrayList.add(new qojt("unspecified", (double)((float)l3 - f) * 100.0 / (double)l3, (double)((float)l3 - f) * 100.0 / (double)l));
        }
        Collections.sort(arrayList);
        arrayList.add(0, new qojt(string, 100.0, (double)l3 * 100.0 / (double)l));
        return arrayList;
    }

    public void _c(String string) {
        pidb._b(this, string);
        znw.mods.stalkerguide.pidb._a(this, string);
        if (this._g) {
            this._b();
            this._a(string);
        }
    }

    public String _c() {
        return this._a.size() == 0 ? "[UNKNOWN]" : (String)this._a.get(this._a.size() - 1);
    }
}

