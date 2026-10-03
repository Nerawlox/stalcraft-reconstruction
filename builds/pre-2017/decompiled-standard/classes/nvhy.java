/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class nvhy {
    public final int _a;
    public final int _b;
    public final int _c;
    public final int _d;
    public List _e;
    public cegl _f;

    public nvhy(int n, int n2, int n3, int n4) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
    }

    public cegl _a() {
        return this._f;
    }

    public int _b() {
        return this._a;
    }

    public int _c() {
        return this._b;
    }

    public boolean _a(cegl cegl2) {
        if (this._f != null) {
            return false;
        }
        int n = cegl2._b();
        int n2 = cegl2._c();
        if (n > this._c || n2 > this._d) {
            return false;
        }
        if (n == this._c && n2 == this._d) {
            this._f = cegl2;
            return true;
        }
        if (this._e == null) {
            this._e = new ArrayList(1);
            this._e.add(new nvhy(this._a, this._b, n, n2));
            int n3 = this._c - n;
            int n4 = this._d - n2;
            if (n4 > 0 && n3 > 0) {
                int n5;
                int n6 = Math.max(this._d, n3);
                if (n6 >= (n5 = Math.max(this._c, n4))) {
                    this._e.add(new nvhy(this._a, this._b + n2, n, n4));
                    this._e.add(new nvhy(this._a + n, this._b, n3, this._d));
                } else {
                    this._e.add(new nvhy(this._a + n, this._b, n3, n2));
                    this._e.add(new nvhy(this._a, this._b + n2, this._c, n4));
                }
            } else if (n3 == 0) {
                this._e.add(new nvhy(this._a, this._b + n2, n, n4));
            } else if (n4 == 0) {
                this._e.add(new nvhy(this._a + n, this._b, n3, n2));
            }
        }
        for (nvhy nvhy2 : this._e) {
            if (!nvhy2._a(cegl2)) continue;
            return true;
        }
        return false;
    }

    public void _a(List list2) {
        if (this._f != null) {
            list2.add(this);
        } else if (this._e != null) {
            for (nvhy nvhy2 : this._e) {
                nvhy2._a(list2);
            }
        }
    }

    public String toString() {
        return "Slot{originX=" + this._a + ", originY=" + this._b + ", width=" + this._c + ", height=" + this._d + ", texture=" + this._f + ", subSlots=" + this._e + '}';
    }
}

