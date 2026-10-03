/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;
import net.minecraft.util.ugqx;

public abstract class uims
extends gqau {
    public final boolean _a;

    public uims(int n, boolean bl) {
        super(n, tflj._q);
        this._a = bl;
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        if (!ozlu2.func_72797_t(n, n2 - 1, n3)) {
            return false;
        }
        return super.func_71930_b(ozlu2, n, n2, n3);
    }

    @Override
    public boolean func_71854_d(ozlu ozlu2, int n, int n2, int n3) {
        if (!ozlu2.func_72797_t(n, n2 - 1, n3)) {
            return false;
        }
        return super.func_71854_d(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        if (!this._b((sdrg)ozlu2, n, n2, n3, n4)) {
            boolean bl = this._b(ozlu2, n, n2, n3, n4);
            if (this._a && !bl) {
                ozlu2.func_72832_d(n, n2, n3, this._b().field_71990_ca, n4, 2);
            } else if (!this._a) {
                ozlu2.func_72832_d(n, n2, n3, this._a().field_71990_ca, n4, 2);
                if (!bl) {
                    ozlu2.func_82740_a(n, n2, n3, this._a().field_71990_ca, this._h(n4), -1);
                }
            }
        }
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n == 0) {
            if (this._a) {
                return twgu.field_72035_aQ.func_71851_a(n);
            }
            return twgu.field_72049_aP.func_71851_a(n);
        }
        if (n == 1) {
            return this.field_94336_cN;
        }
        return twgu.field_72085_aj.func_71851_a(1);
    }

    @Override
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return n4 != 0 && n4 != 1;
    }

    @Override
    public int func_71857_b() {
        return 36;
    }

    public boolean _b(int n) {
        return this._a;
    }

    @Override
    public int func_71855_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return this.func_71865_a(sdrg2, n, n2, n3, n4);
    }

    @Override
    public int func_71865_a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        int n5 = sdrg2.func_72805_g(n, n2, n3);
        if (!this._b(n5)) {
            return 0;
        }
        int n6 = uims._d(n5);
        if (n6 == 0 && n4 == 3) {
            return this._a(sdrg2, n, n2, n3, n5);
        }
        if (n6 == 1 && n4 == 4) {
            return this._a(sdrg2, n, n2, n3, n5);
        }
        if (n6 == 2 && n4 == 2) {
            return this._a(sdrg2, n, n2, n3, n5);
        }
        if (n6 == 3 && n4 == 5) {
            return this._a(sdrg2, n, n2, n3, n5);
        }
        return 0;
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (!this.func_71854_d(ozlu2, n, n2, n3)) {
            this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
            ozlu2.func_94571_i(n, n2, n3);
            ozlu2.func_72898_h(n + 1, n2, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n - 1, n2, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2, n3 + 1, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2, n3 - 1, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2 - 1, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2 + 1, n3, this.field_71990_ca);
            return;
        }
        this._d(ozlu2, n, n2, n3, n4);
    }

    public void _d(ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        if (!this._b((sdrg)ozlu2, n, n2, n3, n5)) {
            boolean bl = this._b(ozlu2, n, n2, n3, n5);
            if ((this._a && !bl || !this._a && bl) && !ozlu2.func_94573_a(n, n2, n3, this.field_71990_ca)) {
                int n6 = -1;
                if (this._e(ozlu2, n, n2, n3, n5)) {
                    n6 = -3;
                } else if (this._a) {
                    n6 = -2;
                }
                ozlu2.func_82740_a(n, n2, n3, this.field_71990_ca, this._a(n5), n6);
            }
        }
    }

    public boolean _b(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return false;
    }

    public boolean _b(ozlu ozlu2, int n, int n2, int n3, int n4) {
        return this._c(ozlu2, n, n2, n3, n4) > 0;
    }

    public int _c(ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5;
        int n6 = uims._d(n4);
        int n7 = n + ugqx._a[n6];
        int n8 = ozlu2.func_72878_l(n7, n2, n5 = n3 + ugqx._b[n6], ugqx._d[n6]);
        if (n8 >= 15) {
            return n8;
        }
        return Math.max(n8, ozlu2.func_72798_a(n7, n2, n5) == twgu.field_72075_av.field_71990_ca ? ozlu2.func_72805_g(n7, n2, n5) : 0);
    }

    public int _c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        int n5 = uims._d(n4);
        switch (n5) {
            case 0: 
            case 2: {
                return Math.max(this._d(sdrg2, n - 1, n2, n3, 4), this._d(sdrg2, n + 1, n2, n3, 5));
            }
            case 1: 
            case 3: {
                return Math.max(this._d(sdrg2, n, n2, n3 + 1, 3), this._d(sdrg2, n, n2, n3 - 1, 2));
            }
        }
        return 0;
    }

    public int _d(sdrg sdrg2, int n, int n2, int n3, int n4) {
        int n5 = sdrg2.func_72798_a(n, n2, n3);
        if (this._e(n5)) {
            if (n5 == twgu.field_72075_av.field_71990_ca) {
                return sdrg2.func_72805_g(n, n2, n3);
            }
            return sdrg2.func_72879_k(n, n2, n3, n4);
        }
        return 0;
    }

    @Override
    public boolean func_71853_i() {
        return true;
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = ((sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 0.5) & 3) + 2) % 4;
        ozlu2.func_72921_c(n, n2, n3, n4, 3);
        boolean bl = this._b(ozlu2, n, n2, n3, n4);
        if (bl) {
            ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, 1);
        }
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        this._a(ozlu2, n, n2, n3);
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = uims._d(ozlu2.func_72805_g(n, n2, n3));
        if (n4 == 1) {
            ozlu2.func_72821_m(n + 1, n2, n3, this.field_71990_ca);
            ozlu2.func_96439_d(n + 1, n2, n3, this.field_71990_ca, 4);
        }
        if (n4 == 3) {
            ozlu2.func_72821_m(n - 1, n2, n3, this.field_71990_ca);
            ozlu2.func_96439_d(n - 1, n2, n3, this.field_71990_ca, 5);
        }
        if (n4 == 2) {
            ozlu2.func_72821_m(n, n2, n3 + 1, this.field_71990_ca);
            ozlu2.func_96439_d(n, n2, n3 + 1, this.field_71990_ca, 2);
        }
        if (n4 == 0) {
            ozlu2.func_72821_m(n, n2, n3 - 1, this.field_71990_ca);
            ozlu2.func_96439_d(n, n2, n3 - 1, this.field_71990_ca, 3);
        }
    }

    @Override
    public void func_71898_d(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (this._a) {
            ozlu2.func_72898_h(n + 1, n2, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n - 1, n2, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2, n3 + 1, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2, n3 - 1, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2 - 1, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2 + 1, n3, this.field_71990_ca);
        }
        super.func_71898_d(ozlu2, n, n2, n3, n4);
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    public boolean _e(int n) {
        twgu twgu2 = twgu.field_71973_m[n];
        return twgu2 != null && twgu2.func_71853_i();
    }

    public int _a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return 15;
    }

    public static boolean _f(int n) {
        return twgu.field_72010_bh._g(n) || twgu.field_94346_cn._g(n);
    }

    public boolean _g(int n) {
        return n == this._a().field_71990_ca || n == this._b().field_71990_ca;
    }

    public boolean _e(ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5 = uims._d(n4);
        if (uims._f(ozlu2.func_72798_a(n - ugqx._a[n5], n2, n3 - ugqx._b[n5]))) {
            int n6 = ozlu2.func_72805_g(n - ugqx._a[n5], n2, n3 - ugqx._b[n5]);
            int n7 = uims._d(n6);
            return n7 != n5;
        }
        return false;
    }

    public int _h(int n) {
        return this._a(n);
    }

    public abstract int _a(int var1);

    public abstract uims _a();

    public abstract uims _b();

    @Override
    public boolean func_94334_h(int n) {
        return this._g(n);
    }
}

