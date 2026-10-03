/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

public class yfpk {
    public static HashMap<String, mcmy> _a;
    public static mcmy _b;
    public static mcmy _c;
    public static mcmy _d;
    public static mcmy _e;
    public static mcmy _f;
    public static mcmy _g;
    public static mcmy _h;
    public static mcmy _i;

    public static mcmy _a(String string, int n, int n2) {
        String string2 = n2 == 1 ? "bold" : "";
        return _a.get(string + "_" + string2 + "_" + n);
    }

    public static mcmy _b(String string, int n, int n2) {
        String string2 = n2 == 1 ? "bold" : "";
        mcmy mcmy2 = new mcmy(string, n, n2, mcmy._a);
        _a.put(string + "_" + string2 + "_" + n, mcmy2);
        return mcmy2;
    }

    public static void _a() {
        _a = new HashMap();
        _b = yfpk._b("Tahoma", 11, 0);
        _c = yfpk._b("Tahoma", 11, 1);
        _d = yfpk._b("Tahoma", 14, 1);
        _e = yfpk._b("GOST_B", 12, 0);
        _f = yfpk._b("GOST_B", 20, 1);
        _g = yfpk._b("Capture_it", 12, 0);
        _h = yfpk._b("Capture_it", 14, 0);
        _i = yfpk._b("Capture_it", 16, 0);
    }
}

