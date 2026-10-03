/*
 * Decompiled with CFR 0.152.
 */
public class ellv {
    public final int _a;
    public final int _b;
    public final int _c;
    public final int _d;
    public final int _e;
    public int _f;
    public boolean _g;
    public int _h;

    public ellv(int n, int n2, int n3, int n4, int n5, int n6) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
        this._e = n5;
        this._f = n6;
    }

    public int _a(int n, int n2, int n3) {
        int n4 = n - this._a;
        int n5 = n2 - this._b;
        int n6 = n3 - this._c;
        return n4 * n4 + n5 * n5 + n6 * n6;
    }

    public int _b(int n, int n2, int n3) {
        int n4 = n - this._a - this._d;
        int n5 = n2 - this._b;
        int n6 = n3 - this._c - this._e;
        return n4 * n4 + n5 * n5 + n6 * n6;
    }

    public int _a() {
        return this._a + this._d;
    }

    public int _b() {
        return this._b;
    }

    public int _c() {
        return this._c + this._e;
    }

    public boolean _a(int n, int n2) {
        int n3 = n - this._a;
        int n4 = n2 - this._c;
        return n3 * this._d + n4 * this._e >= 0;
    }

    public void _d() {
        this._h = 0;
    }

    public void _e() {
        ++this._h;
    }

    public int _f() {
        return this._h;
    }
}

