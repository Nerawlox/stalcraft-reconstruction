/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;

public class nuxm
extends iwgt {
    public final Random _a = new Random();
    public final boolean _b;
    public static boolean _c;
    public dwan _d;
    public dwan _e;

    public nuxm(int n, boolean bl) {
        super(n, tflj._e);
        this._b = bl;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return twgu.field_72051_aB.field_71990_ca;
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        super.func_71861_g(ozlu2, n, n2, n3);
        this._a(ozlu2, n, n2, n3);
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        if (ozlu2.field_72995_K) {
            return;
        }
        int n4 = ozlu2.func_72798_a(n, n2, n3 - 1);
        int n5 = ozlu2.func_72798_a(n, n2, n3 + 1);
        int n6 = ozlu2.func_72798_a(n - 1, n2, n3);
        int n7 = ozlu2.func_72798_a(n + 1, n2, n3);
        int n8 = 3;
        if (twgu.field_71970_n[n4] && !twgu.field_71970_n[n5]) {
            n8 = 3;
        }
        if (twgu.field_71970_n[n5] && !twgu.field_71970_n[n4]) {
            n8 = 2;
        }
        if (twgu.field_71970_n[n6] && !twgu.field_71970_n[n7]) {
            n8 = 5;
        }
        if (twgu.field_71970_n[n7] && !twgu.field_71970_n[n6]) {
            n8 = 4;
        }
        ozlu2.func_72921_c(n, n2, n3, n8, 2);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n == 1) {
            return this._d;
        }
        if (n == 0) {
            return this._d;
        }
        if (n != n2) {
            return this.field_94336_cN;
        }
        return this._e;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("furnace_side");
        this._e = nege2._b(this._b ? "furnace_front_on" : "furnace_front_off");
        this._d = nege2._b("furnace_top");
    }

    @Override
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (!this._b) {
            return;
        }
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        float f = (float)n + 0.5f;
        float f2 = (float)n2 + 0.0f + random.nextFloat() * 6.0f / 16.0f;
        float f3 = (float)n3 + 0.5f;
        float f4 = 0.52f;
        float f5 = random.nextFloat() * 0.6f - 0.3f;
        if (n4 == 4) {
            ozlu2.func_72869_a("smoke", f - f4, f2, f3 + f5, 0.0, 0.0, 0.0);
            ozlu2.func_72869_a("flame", f - f4, f2, f3 + f5, 0.0, 0.0, 0.0);
        } else if (n4 == 5) {
            ozlu2.func_72869_a("smoke", f + f4, f2, f3 + f5, 0.0, 0.0, 0.0);
            ozlu2.func_72869_a("flame", f + f4, f2, f3 + f5, 0.0, 0.0, 0.0);
        } else if (n4 == 2) {
            ozlu2.func_72869_a("smoke", f + f5, f2, f3 - f4, 0.0, 0.0, 0.0);
            ozlu2.func_72869_a("flame", f + f5, f2, f3 - f4, 0.0, 0.0, 0.0);
        } else if (n4 == 3) {
            ozlu2.func_72869_a("smoke", f + f5, f2, f3 + f4, 0.0, 0.0, 0.0);
            ozlu2.func_72869_a("flame", f + f5, f2, f3 + f4, 0.0, 0.0, 0.0);
        }
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (ozlu2.field_72995_K) {
            return true;
        }
        nwgz nwgz2 = (nwgz)ozlu2.func_72796_p(n, n2, n3);
        if (nwgz2 != null) {
            entityPlayer.func_71042_a(nwgz2);
        }
        return true;
    }

    public static void _a(boolean bl, ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
        _c = true;
        if (bl) {
            ozlu2.func_94575_c(n, n2, n3, twgu.field_72052_aC.field_71990_ca);
        } else {
            ozlu2.func_94575_c(n, n2, n3, twgu.field_72051_aB.field_71990_ca);
        }
        _c = false;
        ozlu2.func_72921_c(n, n2, n3, n4, 2);
        if (hurg2 != null) {
            hurg2.func_70312_q();
            ozlu2.func_72837_a(n, n2, n3, hurg2);
        }
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new nwgz();
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 0.5) & 3;
        if (n4 == 0) {
            ozlu2.func_72921_c(n, n2, n3, 2, 2);
        }
        if (n4 == 1) {
            ozlu2.func_72921_c(n, n2, n3, 5, 2);
        }
        if (n4 == 2) {
            ozlu2.func_72921_c(n, n2, n3, 3, 2);
        }
        if (n4 == 3) {
            ozlu2.func_72921_c(n, n2, n3, 4, 2);
        }
        if (cvzo2._u()) {
            ((nwgz)ozlu2.func_72796_p(n, n2, n3))._a(cvzo2._s());
        }
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        nwgz nwgz2;
        if (!_c && (nwgz2 = (nwgz)ozlu2.func_72796_p(n, n2, n3)) != null) {
            for (int i = 0; i < nwgz2.func_70302_i_(); ++i) {
                cvzo cvzo2 = nwgz2.func_70301_a(i);
                if (cvzo2 == null) continue;
                float f = this._a.nextFloat() * 0.8f + 0.1f;
                float f2 = this._a.nextFloat() * 0.8f + 0.1f;
                float f3 = this._a.nextFloat() * 0.8f + 0.1f;
                while (cvzo2._b > 0) {
                    int n6 = this._a.nextInt(21) + 10;
                    if (n6 > cvzo2._b) {
                        n6 = cvzo2._b;
                    }
                    cvzo2._b -= n6;
                    EntityItem entityItem = new EntityItem(ozlu2, (float)n + f, (float)n2 + f2, (float)n3 + f3, new cvzo(cvzo2._d, n6, cvzo2._j()));
                    if (cvzo2._p()) {
                        entityItem.func_92059_d()._d((qoac)cvzo2._q()._c());
                    }
                    float f4 = 0.05f;
                    entityItem.field_70159_w = (float)this._a.nextGaussian() * f4;
                    entityItem.field_70181_x = (float)this._a.nextGaussian() * f4 + 0.2f;
                    entityItem.field_70179_y = (float)this._a.nextGaussian() * f4;
                    ozlu2.func_72838_d(entityItem);
                }
            }
            ozlu2.func_96440_m(n, n2, n3, n4);
        }
        super.func_71852_a(ozlu2, n, n2, n3, n4, n5);
    }

    @Override
    public boolean func_96468_q_() {
        return true;
    }

    @Override
    public int func_94328_b_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        return jjgc.func_94526_b((mssh)((Object)ozlu2.func_72796_p(n, n2, n3)));
    }

    @Override
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return twgu.field_72051_aB.field_71990_ca;
    }
}

