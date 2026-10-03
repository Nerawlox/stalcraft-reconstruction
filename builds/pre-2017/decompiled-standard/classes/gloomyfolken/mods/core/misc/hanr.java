/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import gloomyfolken.mods.core.misc.sajh;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.util.ezfc;

public enum hanr {
    _a("COMMON", "\u041e\u0431\u044b\u0447\u043d\u044b\u0439", ezfc._p),
    _b("UNCOMMON", "\u041d\u0435\u043e\u0431\u044b\u0447\u043d\u044b\u0439", ezfc._l),
    _c("SPECIAL", "\u041e\u0441\u043e\u0431\u044b\u0439", ezfc._j),
    _d("RARE", "\u0420\u0435\u0434\u043a\u0438\u0439", ezfc._n),
    _e("EXCLUSIVE", "\u0418\u0441\u043a\u043b\u044e\u0447\u0438\u0442\u0435\u043b\u044c\u043d\u044b\u0439", ezfc._f),
    _f("LEGENDARY", "\u041b\u0435\u0433\u0435\u043d\u0434\u0430\u0440\u043d\u044b\u0439", ezfc._m),
    _g("UNIQUE", "\u0423\u043d\u0438\u043a\u0430\u043b\u044c\u043d\u044b\u0439", ezfc._g);

    public static final Map<String, hanr> _h;
    public final String _i;
    public final String _j;
    public final ezfc _k;
    public final int _l;
    public static final String _m = "rar";
    public static final hanr[] _n;

    private hanr(String string2, String string3, ezfc ezfc2) {
        this._i = string2;
        this._j = string3;
        this._k = ezfc2;
        this._l = hanr._a(ezfc2);
    }

    public static boolean _a(cvzo cvzo2) {
        return cvzo2 != null && cvzo2._e != null && cvzo2._e._c(_m);
    }

    public static hanr _b(cvzo cvzo2) {
        if (!hanr._a(cvzo2)) {
            return _a;
        }
        return _n[Math.min(_n.length, cvzo2._e._d(_m))];
    }

    public static int _a(qoac qoac2) {
        return qoac2 != null ? (int)qoac2._d(_m) : 0;
    }

    public static ezfc _c(cvzo cvzo2) {
        return hanr._b((cvzo)cvzo2)._k;
    }

    public static cvzo _a(cvzo cvzo2, hanr hanr2) {
        sajh._c((cvzo)cvzo2)._e._a(_m, (byte)hanr2.ordinal());
        return cvzo2;
    }

    public static qoac _a(qoac qoac2, hanr hanr2) {
        qoac2._a(_m, (byte)hanr2.ordinal());
        return qoac2;
    }

    private static int _a(ezfc ezfc2) {
        int n = ezfc2.ordinal();
        int n2 = (n >> 3 & 1) * 85;
        int n3 = (n >> 2 & 1) * 170 + n2;
        int n4 = (n >> 1 & 1) * 170 + n2;
        int n5 = (n >> 0 & 1) * 170 + n2;
        if (n == 6) {
            n3 += 85;
        }
        return (n3 & 0xFF) << 16 | (n4 & 0xFF) << 8 | n5 & 0xFF;
    }

    static {
        _h = new HashMap<String, hanr>();
        for (hanr hanr2 : hanr.values()) {
            _h.put(hanr2._i, hanr2);
        }
        _n = hanr.values();
    }
}

