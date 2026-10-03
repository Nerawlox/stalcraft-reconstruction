/*
 * Decompiled with CFR 0.152.
 */
public class ozfx {
    public elhc[] _a = new elhc[1024];
    public int _b;

    public elhc _a(elhc elhc2) {
        if (elhc2._e >= 0) {
            throw new IllegalStateException("OW KNOWS!");
        }
        if (this._b == this._a.length) {
            elhc[] elhcArray = new elhc[this._b << 1];
            System.arraycopy(this._a, 0, elhcArray, 0, this._b);
            this._a = elhcArray;
        }
        this._a[this._b] = elhc2;
        elhc2._e = this._b;
        this._a(this._b++);
        return elhc2;
    }

    public void _a() {
        this._b = 0;
    }

    public elhc _b() {
        elhc elhc2 = this._a[0];
        this._a[0] = this._a[--this._b];
        this._a[this._b] = null;
        if (this._b > 0) {
            this._b(0);
        }
        elhc2._e = -1;
        return elhc2;
    }

    public void _a(elhc elhc2, float f) {
        float f2 = elhc2._h;
        elhc2._h = f;
        if (f < f2) {
            this._a(elhc2._e);
        } else {
            this._b(elhc2._e);
        }
    }

    public void _a(int n) {
        elhc elhc2 = this._a[n];
        float f = elhc2._h;
        while (n > 0) {
            int n2 = n - 1 >> 1;
            elhc elhc3 = this._a[n2];
            if (!(f < elhc3._h)) break;
            this._a[n] = elhc3;
            elhc3._e = n;
            n = n2;
        }
        this._a[n] = elhc2;
        elhc2._e = n;
    }

    public void _b(int n) {
        elhc elhc2 = this._a[n];
        float f = elhc2._h;
        while (true) {
            float f2;
            elhc elhc3;
            int n2 = 1 + (n << 1);
            int n3 = n2 + 1;
            if (n2 >= this._b) break;
            elhc elhc4 = this._a[n2];
            float f3 = elhc4._h;
            if (n3 >= this._b) {
                elhc3 = null;
                f2 = Float.POSITIVE_INFINITY;
            } else {
                elhc3 = this._a[n3];
                f2 = elhc3._h;
            }
            if (f3 < f2) {
                if (!(f3 < f)) break;
                this._a[n] = elhc4;
                elhc4._e = n;
                n = n2;
                continue;
            }
            if (!(f2 < f)) break;
            this._a[n] = elhc3;
            elhc3._e = n;
            n = n3;
        }
        this._a[n] = elhc2;
        elhc2._e = n;
    }

    public boolean _c() {
        return this._b == 0;
    }
}

