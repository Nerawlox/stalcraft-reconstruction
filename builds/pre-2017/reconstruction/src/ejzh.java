/*
 * Decompiled with CFR 0.152.
 */
public class ejzh {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;
    public int _f;

    public ejzh(int n, int n2, int n3, int n4, int n5, int n6) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._e = n5;
        this._f = n6;
        this._d = n4;
    }

    public int _a() {
        return this._a;
    }

    public int _b() {
        return this._b;
    }

    public int _c() {
        return this._c;
    }

    public int _d() {
        return this._e;
    }

    public int _e() {
        return this._f;
    }

    public int _f() {
        return this._d;
    }

    public boolean equals(Object object) {
        if (object instanceof ejzh) {
            ejzh ejzh2 = (ejzh)object;
            return this._a == ejzh2._a && this._b == ejzh2._b && this._c == ejzh2._c && this._e == ejzh2._e && this._f == ejzh2._f && this._d == ejzh2._d;
        }
        return false;
    }

    public String toString() {
        return "TE(" + this._a + "," + this._b + "," + this._c + ")," + this._e + "," + this._f + "," + this._d;
    }
}

