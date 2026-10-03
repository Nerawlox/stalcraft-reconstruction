/*
 * Decompiled with CFR 0.152.
 */
public class suyo {
    public int _a = 1;
    public int _b;
    public int _c;
    public int _d;

    public suyo(int n, int n2) {
        this._a = n;
        this._b = n2;
    }

    public suyo(int n, int n2, int n3) {
        this(n, n2);
        this._c = n3;
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
        return this._d;
    }

    public void _a(int n) {
        this._d = n;
    }

    public String toString() {
        String string = Integer.toString(this._b);
        if (this._a > 1) {
            string = this._a + "x" + string;
        }
        if (this._c > 0) {
            string = string + ":" + this._c;
        }
        return string;
    }
}

