/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fojy {
    public final Map _a = new HashMap();
    public final Map _b = new HashMap();
    public final Map _c = new HashMap();
    public final igri[] _d = new igri[3];
    public final Map _e = new HashMap();
    public final Map _f = new HashMap();

    public igri _a(String string) {
        return (igri)this._a.get(string);
    }

    public igri _a(String string, nwbn nwbn2) {
        igri igri2 = this._a(string);
        if (igri2 != null) {
            throw new IllegalArgumentException("An objective with the name '" + string + "' already exists!");
        }
        igri2 = new igri(this, string, nwbn2);
        ArrayList<igri> arrayList = (ArrayList<igri>)this._b.get(nwbn2);
        if (arrayList == null) {
            arrayList = new ArrayList<igri>();
            this._b.put(nwbn2, arrayList);
        }
        arrayList.add(igri2);
        this._a.put(string, igri2);
        this._c(igri2);
        return igri2;
    }

    public Collection _a(nwbn nwbn2) {
        Collection collection = (Collection)this._b.get(nwbn2);
        return collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public cwdc _a(String string, igri igri2) {
        cwdc cwdc2;
        HashMap<igri, cwdc> hashMap = (HashMap<igri, cwdc>)this._c.get(string);
        if (hashMap == null) {
            hashMap = new HashMap<igri, cwdc>();
            this._c.put(string, hashMap);
        }
        if ((cwdc2 = (cwdc)hashMap.get(igri2)) == null) {
            cwdc2 = new cwdc(this, igri2, string);
            hashMap.put(igri2, cwdc2);
        }
        return cwdc2;
    }

    public Collection _a(igri igri2) {
        ArrayList<cwdc> arrayList = new ArrayList<cwdc>();
        for (Map map : this._c.values()) {
            cwdc cwdc2 = (cwdc)map.get(igri2);
            if (cwdc2 == null) continue;
            arrayList.add(cwdc2);
        }
        Collections.sort(arrayList, cwdc._a);
        return arrayList;
    }

    public Collection _a() {
        return this._a.values();
    }

    public Collection _b() {
        return this._c.keySet();
    }

    public void _b(String string) {
        Map map = (Map)this._c.remove(string);
        if (map != null) {
            this._h(string);
        }
    }

    public Collection _c() {
        Collection collection = this._c.values();
        ArrayList arrayList = new ArrayList();
        for (Map map : collection) {
            arrayList.addAll(map.values());
        }
        return arrayList;
    }

    public Map _c(String string) {
        HashMap hashMap = (HashMap)this._c.get(string);
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        return hashMap;
    }

    public void _b(igri igri2) {
        this._a.remove(igri2._b());
        for (int i = 0; i < 3; ++i) {
            if (this._a(i) != igri2) continue;
            this._a(i, null);
        }
        List list2 = (List)this._b.get(igri2._c());
        if (list2 != null) {
            list2.remove(igri2);
        }
        for (Map map : this._c.values()) {
            map.remove(igri2);
        }
        this._e(igri2);
    }

    public void _a(int n, igri igri2) {
        this._d[n] = igri2;
    }

    public igri _a(int n) {
        return this._d[n];
    }

    public dzew _d(String string) {
        return (dzew)this._e.get(string);
    }

    public dzew _e(String string) {
        dzew dzew2 = this._d(string);
        if (dzew2 != null) {
            throw new IllegalArgumentException("An objective with the name '" + string + "' already exists!");
        }
        dzew2 = new dzew(this, string);
        this._e.put(string, dzew2);
        this._b(dzew2);
        return dzew2;
    }

    public void _a(dzew dzew2) {
        this._e.remove(dzew2._a());
        for (String string : dzew2._c()) {
            this._f.remove(string);
        }
        this._d(dzew2);
    }

    public void _a(String string, dzew dzew2) {
        if (this._g(string) != null) {
            this._f(string);
        }
        this._f.put(string, dzew2);
        dzew2._c().add(string);
    }

    public boolean _f(String string) {
        dzew dzew2 = this._g(string);
        if (dzew2 != null) {
            this._b(string, dzew2);
            return true;
        }
        return false;
    }

    public void _b(String string, dzew dzew2) {
        if (this._g(string) != dzew2) {
            throw new IllegalStateException("Player is either on another team or not on any team. Cannot remove from team '" + dzew2._a() + "'.");
        }
        this._f.remove(string);
        dzew2._c().remove(string);
    }

    public Collection _d() {
        return this._e.keySet();
    }

    public Collection _e() {
        return this._e.values();
    }

    public dzew _g(String string) {
        return (dzew)this._f.get(string);
    }

    public void _c(igri igri2) {
    }

    public void _d(igri igri2) {
    }

    public void _e(igri igri2) {
    }

    public void _a(cwdc cwdc2) {
    }

    public void _h(String string) {
    }

    public void _b(dzew dzew2) {
    }

    public void _c(dzew dzew2) {
    }

    public void _d(dzew dzew2) {
    }

    public static String _b(int n) {
        switch (n) {
            case 0: {
                return "list";
            }
            case 1: {
                return "sidebar";
            }
            case 2: {
                return "belowName";
            }
        }
        return null;
    }

    public static int _i(String string) {
        if (string.equalsIgnoreCase("list")) {
            return 0;
        }
        if (string.equalsIgnoreCase("sidebar")) {
            return 1;
        }
        if (string.equalsIgnoreCase("belowName")) {
            return 2;
        }
        return -1;
    }
}

