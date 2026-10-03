/*
 * Decompiled with CFR 0.152.
 */
public class uken {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;
    public int _f;

    public uken() {
    }

    public uken(int[] nArray) {
        if (nArray.length == 6) {
            this._a = nArray[0];
            this._b = nArray[1];
            this._c = nArray[2];
            this._d = nArray[3];
            this._e = nArray[4];
            this._f = nArray[5];
        }
    }

    public static uken _a() {
        return new uken(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public static uken _a(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        switch (n10) {
            default: {
                return new uken(n + n4, n2 + n5, n3 + n6, n + n7 - 1 + n4, n2 + n8 - 1 + n5, n3 + n9 - 1 + n6);
            }
            case 2: {
                return new uken(n + n4, n2 + n5, n3 - n9 + 1 + n6, n + n7 - 1 + n4, n2 + n8 - 1 + n5, n3 + n6);
            }
            case 0: {
                return new uken(n + n4, n2 + n5, n3 + n6, n + n7 - 1 + n4, n2 + n8 - 1 + n5, n3 + n9 - 1 + n6);
            }
            case 1: {
                return new uken(n - n9 + 1 + n6, n2 + n5, n3 + n4, n + n6, n2 + n8 - 1 + n5, n3 + n7 - 1 + n4);
            }
            case 3: 
        }
        return new uken(n + n6, n2 + n5, n3 + n4, n + n9 - 1 + n6, n2 + n8 - 1 + n5, n3 + n7 - 1 + n4);
    }

    public uken(uken uken2) {
        this._a = uken2._a;
        this._b = uken2._b;
        this._c = uken2._c;
        this._d = uken2._d;
        this._e = uken2._e;
        this._f = uken2._f;
    }

    public uken(int n, int n2, int n3, int n4, int n5, int n6) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
        this._e = n5;
        this._f = n6;
    }

    public uken(int n, int n2, int n3, int n4) {
        this._a = n;
        this._c = n2;
        this._d = n3;
        this._f = n4;
        this._b = 1;
        this._e = 512;
    }

    public boolean _a(uken uken2) {
        return this._d >= uken2._a && this._a <= uken2._d && this._f >= uken2._c && this._c <= uken2._f && this._e >= uken2._b && this._b <= uken2._e;
    }

    public boolean _a(int n, int n2, int n3, int n4) {
        return this._d >= n && this._a <= n3 && this._f >= n2 && this._c <= n4;
    }

    public void _b(uken uken2) {
        this._a = Math.min(this._a, uken2._a);
        this._b = Math.min(this._b, uken2._b);
        this._c = Math.min(this._c, uken2._c);
        this._d = Math.max(this._d, uken2._d);
        this._e = Math.max(this._e, uken2._e);
        this._f = Math.max(this._f, uken2._f);
    }

    public void _a(int n, int n2, int n3) {
        this._a += n;
        this._b += n2;
        this._c += n3;
        this._d += n;
        this._e += n2;
        this._f += n3;
    }

    public boolean _b(int n, int n2, int n3) {
        return n >= this._a && n <= this._d && n3 >= this._c && n3 <= this._f && n2 >= this._b && n2 <= this._e;
    }

    public int _b() {
        return this._d - this._a + 1;
    }

    public int _c() {
        return this._e - this._b + 1;
    }

    public int _d() {
        return this._f - this._c + 1;
    }

    public int _e() {
        return this._a + (this._d - this._a + 1) / 2;
    }

    public int _f() {
        return this._b + (this._e - this._b + 1) / 2;
    }

    public int _g() {
        return this._c + (this._f - this._c + 1) / 2;
    }

    public String toString() {
        return "(" + this._a + ", " + this._b + ", " + this._c + "; " + this._d + ", " + this._e + ", " + this._f + ")";
    }

    public qoak _a(String string) {
        return new qoak(string, new int[]{this._a, this._b, this._c, this._d, this._e, this._f});
    }
}

