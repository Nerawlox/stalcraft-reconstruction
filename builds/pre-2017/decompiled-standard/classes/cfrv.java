/*
 * Decompiled with CFR 0.152.
 */
public class cfrv
implements Comparable {
    public final String _a;
    public final String _b;
    public final long _c;
    public final long _d;
    public final boolean _e;
    public final xtby _f;
    public final boolean _g;
    public final boolean _h;

    public cfrv(String string, String string2, long l, long l2, xtby xtby2, boolean bl, boolean bl2, boolean bl3) {
        this._a = string;
        this._b = string2;
        this._c = l;
        this._d = l2;
        this._f = xtby2;
        this._e = bl;
        this._g = bl2;
        this._h = bl3;
    }

    public String _a() {
        return this._a;
    }

    public String _b() {
        return this._b;
    }

    public boolean _c() {
        return this._e;
    }

    public long _d() {
        return this._c;
    }

    public int _a(cfrv cfrv2) {
        if (this._c < cfrv2._c) {
            return 1;
        }
        if (this._c > cfrv2._c) {
            return -1;
        }
        return this._a.compareTo(cfrv2._a);
    }

    public xtby _e() {
        return this._f;
    }

    public boolean _f() {
        return this._g;
    }

    public boolean _g() {
        return this._h;
    }

    public /* synthetic */ int compareTo(Object object) {
        return this._a((cfrv)object);
    }
}

