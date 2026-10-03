/*
 * Decompiled with CFR 0.152.
 */
public class xbtf
implements lpso {
    public final int _a;
    public final int _b;
    public final cvzo[] _c;
    public cvzo _d;
    public final int _e;
    public boolean _f;

    public xbtf(int n, int n2, cvzo[] cvzoArray, cvzo cvzo2) {
        this._e = cvzo2._d;
        this._a = n;
        this._b = n2;
        this._c = cvzoArray;
        this._d = cvzo2;
    }

    @Override
    public cvzo func_77571_b() {
        return this._d;
    }

    @Override
    public boolean func_77569_a(bsse bsse2, ozlu ozlu2) {
        for (int i = 0; i <= 3 - this._a; ++i) {
            for (int j = 0; j <= 3 - this._b; ++j) {
                if (this._a(bsse2, i, j, true)) {
                    return true;
                }
                if (!this._a(bsse2, i, j, false)) continue;
                return true;
            }
        }
        return false;
    }

    public boolean _a(bsse bsse2, int n, int n2, boolean bl) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                cvzo cvzo2;
                int n3 = i - n;
                int n4 = j - n2;
                cvzo cvzo3 = null;
                if (n3 >= 0 && n4 >= 0 && n3 < this._a && n4 < this._b) {
                    cvzo3 = bl ? this._c[this._a - n3 - 1 + n4 * this._a] : this._c[n3 + n4 * this._a];
                }
                if ((cvzo2 = bsse2.func_70463_b(i, j)) == null && cvzo3 == null) continue;
                if (cvzo2 == null && cvzo3 != null || cvzo2 != null && cvzo3 == null) {
                    return false;
                }
                if (cvzo3._d != cvzo2._d) {
                    return false;
                }
                if (cvzo3._j() == Short.MAX_VALUE || cvzo3._j() == cvzo2._j()) continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public cvzo func_77572_b(bsse bsse2) {
        cvzo cvzo2 = this.func_77571_b()._l();
        if (this._f) {
            for (int i = 0; i < bsse2.func_70302_i_(); ++i) {
                cvzo cvzo3 = bsse2.func_70301_a(i);
                if (cvzo3 == null || !cvzo3._p()) continue;
                cvzo2._d((qoac)cvzo3._e._c());
            }
        }
        return cvzo2;
    }

    @Override
    public int func_77570_a() {
        return this._a * this._b;
    }

    public xbtf _a() {
        this._f = true;
        return this;
    }
}

