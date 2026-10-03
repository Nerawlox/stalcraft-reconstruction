/*
 * Decompiled with CFR 0.152.
 */
public class hbmw {
    public static final int _a = 2048;
    public final temw _b;
    private final temw _c;
    private int _d;

    public hbmw(temw temw2, temw temw3, int n) {
        this._b = temw2;
        this._c = temw3;
        this._d = n;
        if (temw3 != null && qmdg._a._h()) {
            throw new IllegalArgumentException("Texture reallocation is impossible in multi context mode");
        }
    }

    private int _e() {
        int n = this._b._c()._c - 1;
        for (int i = 0; i < n; ++i) {
            if (this._a(i)) continue;
            return i;
        }
        return n;
    }

    public boolean _a() {
        return this._c == null || this._d < this._c._b._d;
    }

    public int _a(hbmu hbmu2) {
        if (this._c == null) {
            return hbmu2._c - this._d;
        }
        return this._c._b._d - this._d;
    }

    public void _b() {
        if (this._d < 0) {
            this._d = this._e();
        }
    }

    public int _c() {
        return this._d;
    }

    public boolean _a(int n) {
        hbmu hbmu2 = this._b._c();
        if (n >= hbmu2._c - 1) {
            return false;
        }
        return hbmu2._b(n) * hbmu2._c(n) > 2048;
    }

    public temw _d() {
        return this._c;
    }
}

