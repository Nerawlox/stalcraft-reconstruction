/*
 * Decompiled with CFR 0.152.
 */
public enum qmig {
    _a(32856, 6408, 5121, false, 1, 1, 4),
    _b(32856, 32993, 5121, false, 1, 1, 4),
    _c(33777, 6408, 5121, true, 4, 4, 8),
    _d(33778, 6408, 5121, true, 4, 4, 16),
    _e(33779, 6408, 5121, true, 4, 4, 16),
    _f(36285, 33319, 5121, true, 4, 4, 16),
    _g(33325, 6403, 5131, false, 1, 1, 2),
    _h(33327, 33319, 5131, false, 1, 1, 4),
    _i(34842, 6408, 5131, false, 1, 1, 8),
    _j(33326, 6403, 5126, false, 1, 1, 4),
    _k(33328, 33319, 5126, false, 1, 1, 8),
    _l(34836, 6408, 5126, false, 1, 1, 16);

    public final int _m;
    public final int _n;
    public final int _o;
    public final boolean _p;
    public final int _q;
    public final int _r;
    public final int _s;

    private qmig(int n2, int n3, int n4, boolean bl, int n5, int n6, int n7) {
        this._m = n2;
        this._n = n3;
        this._o = n4;
        this._p = bl;
        this._q = n5;
        this._r = n6;
        this._s = n7;
    }

    public int _a(int n, int n2, int n3) {
        int n4 = Math.max(n2 >> n, this._q);
        int n5 = Math.max(n3 >> n, this._r);
        int n6 = (n4 + this._q - 1) / this._q;
        int n7 = (n5 + this._r - 1) / this._r;
        return n6 * n7 * this._s;
    }

    public int _a() {
        return this._s * 8 / (this._q * this._r);
    }
}

