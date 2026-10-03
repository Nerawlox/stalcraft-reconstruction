/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.ezfa;

public class ejzs
extends iwgt {
    public static final zhqu _a = new dhrp(new bbmo());
    public Random _b = new Random();
    public dwan _c;
    public dwan _d;
    public dwan _e;

    public ejzs(int n) {
        super(n, tflj._e);
        this.func_71849_a(tgbl.field_78028_d);
    }

    @Override
    public int func_71859_p_(ozlu ozlu2) {
        return 4;
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
        int n3 = n2 & 7;
        if (n == n3) {
            if (n3 == 1 || n3 == 0) {
                return this._e;
            }
            return this._d;
        }
        if (n3 == 1 || n3 == 0) {
            return this._c;
        }
        if (n == 1 || n == 0) {
            return this._c;
        }
        return this.field_94336_cN;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("furnace_side");
        this._c = nege2._b("furnace_top");
        this._d = nege2._b(this.func_111023_E() + "_front_horizontal");
        this._e = nege2._b(this.func_111023_E() + "_front_vertical");
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (ozlu2.field_72995_K) {
            return true;
        }
        jjzo jjzo2 = (jjzo)ozlu2.func_72796_p(n, n2, n3);
        if (jjzo2 != null) {
            entityPlayer.func_71006_a(jjzo2);
        }
        return true;
    }

    public void _b(ozlu ozlu2, int n, int n2, int n3) {
        rqep rqep2 = new rqep(ozlu2, n, n2, n3);
        jjzo jjzo2 = (jjzo)rqep2._i();
        if (jjzo2 == null) {
            return;
        }
        int n4 = jjzo2._a();
        if (n4 < 0) {
            ozlu2.func_72926_e(1001, n, n2, n3, 0);
        } else {
            cvzo cvzo2 = jjzo2.func_70301_a(n4);
            vmgb vmgb2 = this._a(cvzo2);
            if (vmgb2 != vmgb._c) {
                cvzo cvzo3 = vmgb2._a(rqep2, cvzo2);
                jjzo2.func_70299_a(n4, cvzo3._b == 0 ? null : cvzo3);
            }
        }
    }

    public vmgb _a(cvzo cvzo2) {
        return (vmgb)_a._a(cvzo2._a());
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        boolean bl;
        boolean bl2 = ozlu2.func_72864_z(n, n2, n3) || ozlu2.func_72864_z(n, n2 + 1, n3);
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        boolean bl3 = bl = (n5 & 8) != 0;
        if (bl2 && !bl) {
            ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.func_71859_p_(ozlu2));
            ozlu2.func_72921_c(n, n2, n3, n5 | 8, 4);
        } else if (!bl2 && bl) {
            ozlu2.func_72921_c(n, n2, n3, n5 & 0xFFFFFFF7, 4);
        }
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (!ozlu2.field_72995_K) {
            this._b(ozlu2, n, n2, n3);
        }
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new jjzo();
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = cdvp._a(ozlu2, n, n2, n3, entityLivingBase);
        ozlu2.func_72921_c(n, n2, n3, n4, 2);
        if (cvzo2._u()) {
            ((jjzo)ozlu2.func_72796_p(n, n2, n3))._a(cvzo2._s());
        }
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        jjzo jjzo2 = (jjzo)ozlu2.func_72796_p(n, n2, n3);
        if (jjzo2 != null) {
            for (int i = 0; i < jjzo2.func_70302_i_(); ++i) {
                cvzo cvzo2 = jjzo2.func_70301_a(i);
                if (cvzo2 == null) continue;
                float f = this._b.nextFloat() * 0.8f + 0.1f;
                float f2 = this._b.nextFloat() * 0.8f + 0.1f;
                float f3 = this._b.nextFloat() * 0.8f + 0.1f;
                while (cvzo2._b > 0) {
                    int n6 = this._b.nextInt(21) + 10;
                    if (n6 > cvzo2._b) {
                        n6 = cvzo2._b;
                    }
                    cvzo2._b -= n6;
                    EntityItem entityItem = new EntityItem(ozlu2, (float)n + f, (float)n2 + f2, (float)n3 + f3, new cvzo(cvzo2._d, n6, cvzo2._j()));
                    if (cvzo2._p()) {
                        entityItem.func_92059_d()._d((qoac)cvzo2._q()._c());
                    }
                    float f4 = 0.05f;
                    entityItem.field_70159_w = (float)this._b.nextGaussian() * f4;
                    entityItem.field_70181_x = (float)this._b.nextGaussian() * f4 + 0.2f;
                    entityItem.field_70179_y = (float)this._b.nextGaussian() * f4;
                    ozlu2.func_72838_d(entityItem);
                }
            }
            ozlu2.func_96440_m(n, n2, n3, n4);
        }
        super.func_71852_a(ozlu2, n, n2, n3, n4, n5);
    }

    public static yent _a(ekuw ekuw2) {
        ezfa ezfa2 = ejzs._a(ekuw2._h());
        double d = ekuw2._b() + 0.7 * (double)ezfa2._a();
        double d2 = ekuw2._c() + 0.7 * (double)ezfa2._b();
        double d3 = ekuw2._d() + 0.7 * (double)ezfa2._c();
        return new txbx(d, d2, d3);
    }

    public static ezfa _a(int n) {
        return ezfa._a(n & 7);
    }

    @Override
    public boolean func_96468_q_() {
        return true;
    }

    @Override
    public int func_94328_b_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        return jjgc.func_94526_b((mssh)((Object)ozlu2.func_72796_p(n, n2, n3)));
    }
}

