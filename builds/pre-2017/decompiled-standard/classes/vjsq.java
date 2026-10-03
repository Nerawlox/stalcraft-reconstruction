/*
 * Decompiled with CFR 0.152.
 */
import java.util.EnumSet;

public enum vjsq {
    _a("\u041d\u043e\u0432\u0438\u0447\u043e\u043a", EnumSet.noneOf(amww.class)),
    _b("\u041f\u0440\u0435\u0434\u0441\u0442\u0430\u0432\u0438\u0442\u0435\u043b\u044c", EnumSet.of(amww._a)),
    _c("\u041e\u0444\u0438\u0446\u0435\u0440", EnumSet.of(amww._a, new amww[]{amww._b, amww._c, amww._d, amww._e, amww._g, amww._m})),
    _d("\u041b\u0438\u0434\u0435\u0440", EnumSet.allOf(amww.class));

    public final String _e;
    public final EnumSet<amww> _f;

    private vjsq(String string2, EnumSet<amww> enumSet) {
        this._e = string2;
        this._f = enumSet;
    }

    public EnumSet<amww> _a() {
        return this._f;
    }
}

