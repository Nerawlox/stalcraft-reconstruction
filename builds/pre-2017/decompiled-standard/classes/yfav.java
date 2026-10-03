/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;

public class yfav
extends hurg
implements mssh {
    public cvzo[] _a = new cvzo[36];
    public boolean _b;
    public yfav _c;
    public yfav _d;
    public yfav _e;
    public yfav _f;
    public float _g;
    public float _h;
    public int _i;
    public int _j;
    public int _k;
    public String _l;

    public yfav() {
        this._k = -1;
    }

    public yfav(int n) {
        this._k = n;
    }

    @Override
    public int func_70302_i_() {
        return 27;
    }

    @Override
    public cvzo func_70301_a(int n) {
        return this._a[n];
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        if (this._a[n] != null) {
            if (this._a[n]._b <= n2) {
                cvzo cvzo2 = this._a[n];
                this._a[n] = null;
                this.func_70296_d();
                return cvzo2;
            }
            cvzo cvzo3 = this._a[n]._a(n2);
            if (this._a[n]._b == 0) {
                this._a[n] = null;
            }
            this.func_70296_d();
            return cvzo3;
        }
        return null;
    }

    @Override
    public cvzo func_70304_b(int n) {
        if (this._a[n] != null) {
            cvzo cvzo2 = this._a[n];
            this._a[n] = null;
            return cvzo2;
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        this._a[n] = cvzo2;
        if (cvzo2 != null && cvzo2._b > this.func_70297_j_()) {
            cvzo2._b = this.func_70297_j_();
        }
        this.func_70296_d();
    }

    @Override
    public String func_70303_b() {
        return this.func_94042_c() ? this._l : "container.chest";
    }

    @Override
    public boolean func_94042_c() {
        return this._l != null && this._l.length() > 0;
    }

    public void _a(String string) {
        this._l = string;
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        bsyv bsyv2 = qoac2._n("Items");
        this._a = new cvzo[this.func_70302_i_()];
        if (qoac2._c("CustomName")) {
            this._l = qoac2._j("CustomName");
        }
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            int n = qoac3._d("Slot") & 0xFF;
            if (n < 0 || n >= this._a.length) continue;
            this._a[n] = cvzo._a(qoac3);
        }
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        bsyv bsyv2 = new bsyv();
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null) continue;
            qoac qoac3 = new qoac();
            qoac3._a("Slot", (byte)i);
            this._a[i]._b(qoac3);
            bsyv2._a(qoac3);
        }
        qoac2._a("Items", bsyv2);
        if (this.func_94042_c()) {
            qoac2._a("CustomName", this._l);
        }
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        if (this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n) != this) {
            return false;
        }
        return !(entityPlayer.func_70092_e((double)this.field_70329_l + 0.5, (double)this.field_70330_m + 0.5, (double)this.field_70327_n + 0.5) > 64.0);
    }

    @Override
    public void func_70321_h() {
        super.func_70321_h();
        this._b = false;
    }

    public void _a(yfav yfav2, int n) {
        if (yfav2.func_70320_p()) {
            this._b = false;
        } else if (this._b) {
            switch (n) {
                case 2: {
                    if (this._c == yfav2) break;
                    this._b = false;
                    break;
                }
                case 0: {
                    if (this._f == yfav2) break;
                    this._b = false;
                    break;
                }
                case 3: {
                    if (this._d == yfav2) break;
                    this._b = false;
                    break;
                }
                case 1: {
                    if (this._e == yfav2) break;
                    this._b = false;
                }
            }
        }
    }

    public void _b() {
        if (this._b) {
            return;
        }
        this._b = true;
        this._c = null;
        this._d = null;
        this._e = null;
        this._f = null;
        if (this._a(this.field_70329_l - 1, this.field_70330_m, this.field_70327_n)) {
            this._e = (yfav)this.field_70331_k.func_72796_p(this.field_70329_l - 1, this.field_70330_m, this.field_70327_n);
        }
        if (this._a(this.field_70329_l + 1, this.field_70330_m, this.field_70327_n)) {
            this._d = (yfav)this.field_70331_k.func_72796_p(this.field_70329_l + 1, this.field_70330_m, this.field_70327_n);
        }
        if (this._a(this.field_70329_l, this.field_70330_m, this.field_70327_n - 1)) {
            this._c = (yfav)this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n - 1);
        }
        if (this._a(this.field_70329_l, this.field_70330_m, this.field_70327_n + 1)) {
            this._f = (yfav)this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n + 1);
        }
        if (this._c != null) {
            this._c._a(this, 0);
        }
        if (this._f != null) {
            this._f._a(this, 2);
        }
        if (this._d != null) {
            this._d._a(this, 1);
        }
        if (this._e != null) {
            this._e._a(this, 3);
        }
    }

    public boolean _a(int n, int n2, int n3) {
        twgu twgu2 = twgu.field_71973_m[this.field_70331_k.func_72798_a(n, n2, n3)];
        if (twgu2 == null || !(twgu2 instanceof ydso)) {
            return false;
        }
        return ((ydso)twgu2)._b == this._c();
    }

    @Override
    public void func_70316_g() {
        double d;
        float f;
        super.func_70316_g();
        this._b();
        ++this._j;
        if (!this.field_70331_k.field_72995_K && this._i != 0 && (this._j + this.field_70329_l + this.field_70330_m + this.field_70327_n) % 200 == 0) {
            this._i = 0;
            f = 5.0f;
            List list = this.field_70331_k.func_72872_a(EntityPlayer.class, eidj._a()._a((float)this.field_70329_l - f, (float)this.field_70330_m - f, (float)this.field_70327_n - f, (float)(this.field_70329_l + 1) + f, (float)(this.field_70330_m + 1) + f, (float)(this.field_70327_n + 1) + f));
            for (EntityPlayer entityPlayer : list) {
                mssh mssh2;
                if (!(entityPlayer.field_71070_bA instanceof wpkx) || (mssh2 = ((wpkx)entityPlayer.field_71070_bA)._a()) != this && (!(mssh2 instanceof huew) || !((huew)mssh2)._a(this))) continue;
                ++this._i;
            }
        }
        this._h = this._g;
        f = 0.1f;
        if (this._i > 0 && this._g == 0.0f && this._c == null && this._e == null) {
            double d2 = (double)this.field_70329_l + 0.5;
            d = (double)this.field_70327_n + 0.5;
            if (this._f != null) {
                d += 0.5;
            }
            if (this._d != null) {
                d2 += 0.5;
            }
            this.field_70331_k.func_72908_a(d2, (double)this.field_70330_m + 0.5, d, "random.chestopen", 0.5f, this.field_70331_k.field_73012_v.nextFloat() * 0.1f + 0.9f);
        }
        if (this._i == 0 && this._g > 0.0f || this._i > 0 && this._g < 1.0f) {
            float f2;
            float f3 = this._g;
            this._g = this._i > 0 ? (this._g += f) : (this._g -= f);
            if (this._g > 1.0f) {
                this._g = 1.0f;
            }
            if (this._g < (f2 = 0.5f) && f3 >= f2 && this._c == null && this._e == null) {
                d = (double)this.field_70329_l + 0.5;
                double d3 = (double)this.field_70327_n + 0.5;
                if (this._f != null) {
                    d3 += 0.5;
                }
                if (this._d != null) {
                    d += 0.5;
                }
                this.field_70331_k.func_72908_a(d, (double)this.field_70330_m + 0.5, d3, "random.chestclosed", 0.5f, this.field_70331_k.field_73012_v.nextFloat() * 0.1f + 0.9f);
            }
            if (this._g < 0.0f) {
                this._g = 0.0f;
            }
        }
    }

    @Override
    public boolean func_70315_b(int n, int n2) {
        if (n == 1) {
            this._i = n2;
            return true;
        }
        return super.func_70315_b(n, n2);
    }

    @Override
    public void func_70295_k_() {
        if (this._i < 0) {
            this._i = 0;
        }
        ++this._i;
        this.field_70331_k.func_72965_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.func_70311_o().field_71990_ca, 1, this._i);
        this.field_70331_k.func_72898_h(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.func_70311_o().field_71990_ca);
        this.field_70331_k.func_72898_h(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n, this.func_70311_o().field_71990_ca);
    }

    @Override
    public void func_70305_f() {
        if (this.func_70311_o() == null || !(this.func_70311_o() instanceof ydso)) {
            return;
        }
        --this._i;
        this.field_70331_k.func_72965_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.func_70311_o().field_71990_ca, 1, this._i);
        this.field_70331_k.func_72898_h(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.func_70311_o().field_71990_ca);
        this.field_70331_k.func_72898_h(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n, this.func_70311_o().field_71990_ca);
    }

    @Override
    public boolean func_94041_b(int n, cvzo cvzo2) {
        return true;
    }

    @Override
    public void func_70313_j() {
        super.func_70313_j();
        this.func_70321_h();
        this._b();
    }

    public int _c() {
        if (this._k == -1) {
            if (this.field_70331_k != null && this.func_70311_o() instanceof ydso) {
                this._k = ((ydso)this.func_70311_o())._b;
            } else {
                return 0;
            }
        }
        return this._k;
    }
}

