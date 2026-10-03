/*
 * Decompiled with CFR 0.152.
 */
public class zztf {
    public Class _a;
    public final int _b;
    public int _c;
    public int _d;
    public boolean _e;

    public zztf(Class clazz, int n, int n2, boolean bl) {
        this._a = clazz;
        this._b = n;
        this._d = n2;
        this._e = bl;
    }

    public zztf(Class clazz, int n, int n2) {
        this(clazz, n, n2, false);
    }

    public boolean _a(int n) {
        return this._d == 0 || this._c < this._d;
    }

    public boolean _a() {
        return this._d == 0 || this._c < this._d;
    }
}

