/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.sajz;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class ujuz {
    public EntityLiving _a;
    public ozlu _b;
    public suqn _c;
    public double _d;
    public hubf _e;
    public boolean _f;
    public int _g;
    public int _h;
    public ofbx _i = ofbx._a(0.0, 0.0, 0.0);
    public boolean _j = true;
    public boolean _k;
    public boolean _l;
    public boolean _m;

    public ujuz(EntityLiving entityLiving, ozlu ozlu2) {
        this._a = entityLiving;
        this._b = ozlu2;
        this._e = entityLiving.func_110148_a(sajz._b);
    }

    public void _a(boolean bl) {
        this._l = bl;
    }

    public boolean _a() {
        return this._l;
    }

    public void _b(boolean bl) {
        this._k = bl;
    }

    public void _c(boolean bl) {
        this._j = bl;
    }

    public boolean _b() {
        return this._k;
    }

    public void _d(boolean bl) {
        this._f = bl;
    }

    public void _a(double d) {
        this._d = d;
    }

    public void _e(boolean bl) {
        this._m = bl;
    }

    public float _c() {
        return (float)this._e._e();
    }

    public suqn _a(double d, double d2, double d3) {
        if (!this._k()) {
            return null;
        }
        return this._b.func_72844_a(this._a, sajh._c(d), (int)d2, sajh._c(d3), this._c(), this._j, this._k, this._l, this._m);
    }

    public boolean _a(double d, double d2, double d3, double d4) {
        suqn suqn2 = this._a(sajh._c(d), (int)d2, sajh._c(d3));
        return this._a(suqn2, d4);
    }

    public suqn _a(Entity entity) {
        if (!this._k()) {
            return null;
        }
        return this._b.func_72865_a(this._a, entity, this._c(), this._j, this._k, this._l, this._m);
    }

    public boolean _a(Entity entity, double d) {
        suqn suqn2 = this._a(entity);
        if (suqn2 != null) {
            return this._a(suqn2, d);
        }
        return false;
    }

    public boolean _a(suqn suqn2, double d) {
        if (suqn2 == null) {
            this._c = null;
            return false;
        }
        if (!suqn2._a(this._c)) {
            this._c = suqn2;
        }
        if (this._f) {
            this._m();
        }
        if (this._c._g() == 0) {
            return false;
        }
        this._d = d;
        ofbx ofbx2 = this._i();
        this._h = this._g;
        this._i._c = ofbx2._c;
        this._i._d = ofbx2._d;
        this._i._e = ofbx2._e;
        return true;
    }

    public suqn _d() {
        return this._c;
    }

    public void _e() {
        ++this._g;
        if (this._g()) {
            return;
        }
        if (this._k()) {
            this._f();
        }
        if (this._g()) {
            return;
        }
        ofbx ofbx2 = this._c._a(this._a);
        if (ofbx2 == null) {
            return;
        }
        this._a.func_70605_aq()._a(ofbx2._c, ofbx2._d, ofbx2._e, this._d);
    }

    public void _f() {
        int n;
        ofbx ofbx2 = this._i();
        int n2 = this._c._g();
        for (int i = this._c._h(); i < this._c._g(); ++i) {
            if (this._c._c((int)i)._b == (int)ofbx2._d) continue;
            n2 = i;
            break;
        }
        float f = this._a.field_70130_N * this._a.field_70130_N;
        for (n = this._c._h(); n < n2; ++n) {
            if (!(ofbx2._e(this._c._a(this._a, n)) < (double)f)) continue;
            this._c._e(n + 1);
        }
        n = sajh._f(this._a.field_70130_N);
        int n3 = (int)this._a.field_70131_O + 1;
        int n4 = n;
        for (int i = n2 - 1; i >= this._c._h(); --i) {
            if (!this._a(ofbx2, this._c._a(this._a, i), n, n3, n4)) continue;
            this._c._e(i);
            break;
        }
        if (this._g - this._h > 100) {
            if (ofbx2._e(this._i) < 2.25) {
                this._h();
            }
            this._h = this._g;
            this._i._c = ofbx2._c;
            this._i._d = ofbx2._d;
            this._i._e = ofbx2._e;
        }
    }

    public boolean _g() {
        return this._c == null || this._c._e();
    }

    public void _h() {
        this._c = null;
    }

    public ofbx _i() {
        return this._b.func_82732_R()._a(this._a.field_70165_t, this._j(), this._a.field_70161_v);
    }

    public int _j() {
        if (!this._a.func_70090_H() || !this._m) {
            return (int)(this._a.field_70121_D._c + 0.5);
        }
        int n = (int)this._a.field_70121_D._c;
        int n2 = this._b.func_72798_a(sajh._c(this._a.field_70165_t), n, sajh._c(this._a.field_70161_v));
        int n3 = 0;
        while (n2 == twgu.field_71942_A.field_71990_ca || n2 == twgu.field_71943_B.field_71990_ca) {
            n2 = this._b.func_72798_a(sajh._c(this._a.field_70165_t), ++n, sajh._c(this._a.field_70161_v));
            if (++n3 <= 16) continue;
            return (int)this._a.field_70121_D._c;
        }
        return n;
    }

    public boolean _k() {
        return this._a.field_70122_E || this._m && this._l();
    }

    public boolean _l() {
        return this._a.func_70090_H() || this._a.func_70058_J();
    }

    public void _m() {
        if (this._b.func_72937_j(sajh._c(this._a.field_70165_t), (int)(this._a.field_70121_D._c + 0.5), sajh._c(this._a.field_70161_v))) {
            return;
        }
        for (int i = 0; i < this._c._g(); ++i) {
            elhc elhc2 = this._c._c(i);
            if (!this._b.func_72937_j(elhc2._a, elhc2._b, elhc2._c)) continue;
            this._c._d(i - 1);
            return;
        }
    }

    public boolean _a(ofbx ofbx2, ofbx ofbx3, int n, int n2, int n3) {
        int n4 = sajh._c(ofbx2._c);
        int n5 = sajh._c(ofbx2._e);
        double d = ofbx3._c - ofbx2._c;
        double d2 = ofbx3._e - ofbx2._e;
        double d3 = d * d + d2 * d2;
        if (d3 < 1.0E-8) {
            return false;
        }
        double d4 = 1.0 / Math.sqrt(d3);
        if (!this._a(n4, (int)ofbx2._d, n5, n += 2, n2, n3 += 2, ofbx2, d *= d4, d2 *= d4)) {
            return false;
        }
        n -= 2;
        n3 -= 2;
        double d5 = 1.0 / Math.abs(d);
        double d6 = 1.0 / Math.abs(d2);
        double d7 = (double)(n4 * 1) - ofbx2._c;
        double d8 = (double)(n5 * 1) - ofbx2._e;
        if (d >= 0.0) {
            d7 += 1.0;
        }
        if (d2 >= 0.0) {
            d8 += 1.0;
        }
        d7 /= d;
        d8 /= d2;
        int n6 = d < 0.0 ? -1 : 1;
        int n7 = d2 < 0.0 ? -1 : 1;
        int n8 = sajh._c(ofbx3._c);
        int n9 = sajh._c(ofbx3._e);
        int n10 = n8 - n4;
        int n11 = n9 - n5;
        while (n10 * n6 > 0 || n11 * n7 > 0) {
            if (d7 < d8) {
                d7 += d5;
                n10 = n8 - (n4 += n6);
            } else {
                d8 += d6;
                n11 = n9 - (n5 += n7);
            }
            if (this._a(n4, (int)ofbx2._d, n5, n, n2, n3, ofbx2, d, d2)) continue;
            return false;
        }
        return true;
    }

    public boolean _a(int n, int n2, int n3, int n4, int n5, int n6, ofbx ofbx2, double d, double d2) {
        int n7 = n - n4 / 2;
        int n8 = n3 - n6 / 2;
        if (!this._b(n7, n2, n8, n4, n5, n6, ofbx2, d, d2)) {
            return false;
        }
        for (int i = n7; i < n7 + n4; ++i) {
            for (int j = n8; j < n8 + n6; ++j) {
                double d3 = (double)i + 0.5 - ofbx2._c;
                double d4 = (double)j + 0.5 - ofbx2._e;
                if (d3 * d + d4 * d2 < 0.0) continue;
                int n9 = this._b.func_72798_a(i, n2 - 1, j);
                if (n9 <= 0) {
                    return false;
                }
                tflj tflj2 = twgu.field_71973_m[n9].field_72018_cp;
                if (tflj2 == tflj._h && !this._a.func_70090_H()) {
                    return false;
                }
                if (tflj2 != tflj._i) continue;
                return false;
            }
        }
        return true;
    }

    public boolean _b(int n, int n2, int n3, int n4, int n5, int n6, ofbx ofbx2, double d, double d2) {
        for (int i = n; i < n + n4; ++i) {
            for (int j = n2; j < n2 + n5; ++j) {
                for (int k = n3; k < n3 + n6; ++k) {
                    int n7;
                    double d3 = (double)i + 0.5 - ofbx2._c;
                    double d4 = (double)k + 0.5 - ofbx2._e;
                    if (d3 * d + d4 * d2 < 0.0 || (n7 = this._b.func_72798_a(i, j, k)) <= 0 || twgu.field_71973_m[n7].func_71918_c(this._b, i, j, k)) continue;
                    return false;
                }
            }
        }
        return true;
    }
}

