/*
 * Decompiled with CFR 0.152.
 */
public class hbmu {
    public final int _a;
    public final int _b;
    public final int _c;
    public final qmig _d;
    public final boolean _e;

    public hbmu(int n, int n2, int n3, qmig qmig2, boolean bl) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = qmig2;
        this._e = bl;
    }

    public int _a(int n) {
        return this._d._a(n, this._a, this._b);
    }

    public int _b(int n) {
        return this._a(this._a, n);
    }

    public int _c(int n) {
        return this._a(this._b, n);
    }

    private int _a(int n, int n2) {
        return Math.max(1, n >> n2);
    }

    public int _a() {
        return this._e ? 34067 : 3553;
    }

    public int _b() {
        return this._e ? 6 : 1;
    }

    public boolean _c() {
        return this._c > 1;
    }
}

