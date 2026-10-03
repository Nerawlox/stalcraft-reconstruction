/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Color;

public enum ugqi {
    _a("", "", "%1$s%2$s", -1),
    _b("/", "", -1),
    _c("", "\u041e\u0431\u044b\u0447\u043d\u044b\u0439", new Color(175, 175, 175).getRGB(), true, true),
    _d("+", "\u0422\u043e\u0440\u0433\u043e\u0432\u043b\u044f", new Color(192, 116, 82).getRGB(), true, true),
    _e("%", "\u041a\u043b\u0430\u043d", new Color(0, 86, 192).getRGB()),
    _f("*", "\u041e\u0442\u0440\u044f\u0434", new Color(0, 192, 0).getRGB()),
    _g("@", "\u041b\u0421", new Color(202, 0, 226).getRGB(), true, true),
    _h("", "", "->%2$s", new Color(202, 0, 226).getRGB());

    public final String _i;
    public final String _j;
    public final int _k;
    public final String _l;
    public final boolean _m;
    public final boolean _n;

    private ugqi() {
        this("", "", -1);
    }

    private ugqi(String string2, String string3, int n2, boolean bl, boolean bl2) {
        this(string2, string3, "%3$s%1$s:\u00a7r %2$s", n2, bl, bl2);
    }

    private ugqi(String string2, String string3, int n2) {
        this(string2, string3, n2, false, false);
    }

    private ugqi(String string2, String string3, String string4, int n2) {
        this(string2, string3, string4, n2, false, false);
    }

    private ugqi(String string2, String string3, String string4, int n2, boolean bl, boolean bl2) {
        this._i = string2;
        this._j = string3;
        this._k = n2;
        this._l = string4;
        this._m = bl;
        this._n = bl2;
    }
}

