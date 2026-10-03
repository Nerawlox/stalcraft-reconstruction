/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.util.pzdf;

public class pibk {
    public transient pzdf[] _a = new pzdf[1024];
    public transient int _b;
    public int _c = (int)(0.75f * (float)this._a.length);
    public final float _d;
    public volatile transient int _e;

    public pibk() {
        this._d = 0.75f;
    }

    public static int _a(long l) {
        return (int)(l ^ l >>> 27);
    }

    public static int _a(int n) {
        n ^= n >>> 20 ^ n >>> 12;
        return n ^ n >>> 7 ^ n >>> 4;
    }

    public static int _a(int n, int n2) {
        return n & n2 - 1;
    }

    public int _a() {
        return this._b;
    }

    public Object _b(long l) {
        int n = pibk._a(l);
        pzdf pzdf2 = this._a[pibk._a(n, this._a.length)];
        while (pzdf2 != null) {
            if (pzdf2._a == l) {
                return pzdf2._b;
            }
            pzdf2 = pzdf2._c;
        }
        return null;
    }

    public boolean _c(long l) {
        return this._d(l) != null;
    }

    public final pzdf _d(long l) {
        int n = pibk._a(l);
        pzdf pzdf2 = this._a[pibk._a(n, this._a.length)];
        while (pzdf2 != null) {
            if (pzdf2._a == l) {
                return pzdf2;
            }
            pzdf2 = pzdf2._c;
        }
        return null;
    }

    public void _a(long l, Object object) {
        int n = pibk._a(l);
        int n2 = pibk._a(n, this._a.length);
        pzdf pzdf2 = this._a[n2];
        while (pzdf2 != null) {
            if (pzdf2._a == l) {
                pzdf2._b = object;
                return;
            }
            pzdf2 = pzdf2._c;
        }
        ++this._e;
        this._a(n, l, object, n2);
    }

    public void _b(int n) {
        pzdf[] pzdfArray = this._a;
        int n2 = pzdfArray.length;
        if (n2 == 0x40000000) {
            this._c = Integer.MAX_VALUE;
        } else {
            pzdf[] pzdfArray2 = new pzdf[n];
            this._a(pzdfArray2);
            this._a = pzdfArray2;
            float f = n;
            this.getClass();
            this._c = (int)(f * 0.75f);
        }
    }

    public void _a(pzdf[] pzdfArray) {
        pzdf[] pzdfArray2 = this._a;
        int n = pzdfArray.length;
        for (int i = 0; i < pzdfArray2.length; ++i) {
            pzdf pzdf2;
            pzdf pzdf3 = pzdfArray2[i];
            if (pzdf3 == null) continue;
            pzdfArray2[i] = null;
            do {
                pzdf2 = pzdf3._c;
                int n2 = pibk._a(pzdf3._d, n);
                pzdf3._c = pzdfArray[n2];
                pzdfArray[n2] = pzdf3;
                pzdf3 = pzdf2;
            } while (pzdf2 != null);
        }
    }

    public Object _e(long l) {
        pzdf pzdf2 = this._f(l);
        return pzdf2 == null ? null : pzdf2._b;
    }

    public final pzdf _f(long l) {
        pzdf pzdf2;
        int n = pibk._a(l);
        int n2 = pibk._a(n, this._a.length);
        pzdf pzdf3 = pzdf2 = this._a[n2];
        while (pzdf3 != null) {
            pzdf pzdf4 = pzdf3._c;
            if (pzdf3._a == l) {
                ++this._e;
                --this._b;
                if (pzdf2 == pzdf3) {
                    this._a[n2] = pzdf4;
                } else {
                    pzdf2._c = pzdf4;
                }
                return pzdf3;
            }
            pzdf2 = pzdf3;
            pzdf3 = pzdf4;
        }
        return pzdf3;
    }

    public void _a(int n, long l, Object object, int n2) {
        pzdf pzdf2 = this._a[n2];
        this._a[n2] = new pzdf(n, l, object, pzdf2);
        if (this._b++ >= this._c) {
            this._b(2 * this._a.length);
        }
    }

    public static int _g(long l) {
        return pibk._a(l);
    }

    public double _b() {
        int n = 0;
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null) continue;
            ++n;
        }
        return 1.0 * (double)n / (double)this._b;
    }
}

