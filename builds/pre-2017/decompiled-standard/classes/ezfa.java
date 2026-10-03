/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;

public class ezfa {
    public final String _a;
    private vjsq _d;
    private long _e;
    private int _f;
    private int _g;
    private boolean _h;
    public static final int _b = -1000000000;
    public static final int _c = 1000000000;

    @ezey(_a={eidj.CLIENT})
    public ezfa(String string, vjsq vjsq2, long l, int n, int n2, boolean bl) {
        this._a = string;
        this._d = vjsq2;
        this._e = l;
        this._f = n;
        this._g = n2;
        this._h = bl;
    }

    public ezfa(qoac qoac2) {
        this._d = vjsq.values()[qoac2._e("rank")];
        this._a = qoac2._j("username");
        this._e = qoac2._g("last_ingame");
        this._f = qoac2._f("loyalty_points");
        this._g = qoac2._f("resource_points");
        this._h = qoac2._o("battlefield_ban");
    }

    public void _a(qoac qoac2) {
        qoac2._a("username", this._a);
        qoac2._a("rank", (short)this._a().ordinal());
        qoac2._a("last_ingame", this._c());
        qoac2._a("loyalty_points", this._f);
        qoac2._a("resource_points", this._g);
        qoac2._a("battlefield_ban", this._h);
    }

    public vjsq _a() {
        return this._d;
    }

    public boolean _b() {
        return this._e < 0L;
    }

    public long _c() {
        return this._b() ? System.currentTimeMillis() : this._e;
    }

    public long _d() {
        return this._e;
    }

    public int _e() {
        return this._f;
    }

    public int _f() {
        return this._g;
    }

    public boolean _g() {
        return this._h;
    }
}

