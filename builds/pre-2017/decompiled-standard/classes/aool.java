/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.ugqx;

public class aool
extends uims
implements stgn {
    public aool(int n, boolean bl) {
        super(n, bl);
        this.field_72025_cg = true;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return tgdv.field_94585_bY.field_77779_bT;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return tgdv.field_94585_bY.field_77779_bT;
    }

    @Override
    public int _a(int n) {
        return 2;
    }

    @Override
    public uims _a() {
        return twgu.field_94343_co;
    }

    @Override
    public uims _b() {
        return twgu.field_94346_cn;
    }

    @Override
    public int func_71857_b() {
        return 37;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        boolean bl;
        boolean bl2 = bl = this._a || (n2 & 8) != 0;
        return n == 0 ? (bl ? twgu.field_72035_aQ.func_71851_a(n) : twgu.field_72049_aP.func_71851_a(n)) : (n == 1 ? (bl ? twgu.field_94343_co.field_94336_cN : this.field_94336_cN) : twgu.field_72085_aj.func_71851_a(1));
    }

    @Override
    public boolean _b(int n) {
        return this._a || (n & 8) != 0;
    }

    @Override
    public int _a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return this._a(sdrg2, n, n2, n3)._a();
    }

    public int _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        return !this._c(n4) ? this._c(ozlu2, n, n2, n3, n4) : Math.max(this._c(ozlu2, n, n2, n3, n4) - this._c((sdrg)ozlu2, n, n2, n3, n4), 0);
    }

    public boolean _c(int n) {
        return (n & 4) == 4;
    }

    @Override
    public boolean _b(ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5 = this._c(ozlu2, n, n2, n3, n4);
        if (n5 >= 15) {
            return true;
        }
        if (n5 == 0) {
            return false;
        }
        int n6 = this._c((sdrg)ozlu2, n, n2, n3, n4);
        return n6 == 0 ? true : n5 >= n6;
    }

    @Override
    public int _c(ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5;
        int n6 = super._c(ozlu2, n, n2, n3, n4);
        int n7 = aool._d(n4);
        int n8 = n + ugqx._a[n7];
        int n9 = ozlu2.func_72798_a(n8, n2, n5 = n3 + ugqx._b[n7]);
        if (n9 > 0) {
            if (twgu.field_71973_m[n9].func_96468_q_()) {
                n6 = twgu.field_71973_m[n9].func_94328_b_(ozlu2, n8, n2, n5, ugqx._f[n7]);
            } else if (n6 < 15 && twgu.func_71932_i(n9) && (n9 = ozlu2.func_72798_a(n8 += ugqx._a[n7], n2, n5 += ugqx._b[n7])) > 0 && twgu.field_71973_m[n9].func_96468_q_()) {
                n6 = twgu.field_71973_m[n9].func_94328_b_(ozlu2, n8, n2, n5, ugqx._f[n7]);
            }
        }
        return n6;
    }

    public jjzm _a(sdrg sdrg2, int n, int n2, int n3) {
        return (jjzm)sdrg2.func_72796_p(n, n2, n3);
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        boolean bl = this._a | (n5 & 8) != 0;
        boolean bl2 = !this._c(n5);
        int n6 = bl2 ? 4 : 0;
        ozlu2.func_72908_a((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "random.click", 0.3f, bl2 ? 0.55f : 0.5f);
        ozlu2.func_72921_c(n, n2, n3, (n6 |= bl ? 8 : 0) | n5 & 3, 2);
        this._a(ozlu2, n, n2, n3, ozlu2.field_73012_v);
        return true;
    }

    @Override
    public void _d(ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        if (!(ozlu2.func_94573_a(n, n2, n3, this.field_71990_ca) || (n7 = this._a(ozlu2, n, n2, n3, n6 = ozlu2.func_72805_g(n, n2, n3))) == (n5 = this._a((sdrg)ozlu2, n, n2, n3)._a()) && this._b(n6) == this._b(ozlu2, n, n2, n3, n6))) {
            if (this._e(ozlu2, n, n2, n3, n6)) {
                ozlu2.func_82740_a(n, n2, n3, this.field_71990_ca, this._a(0), -1);
            } else {
                ozlu2.func_82740_a(n, n2, n3, this.field_71990_ca, this._a(0), 0);
            }
        }
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        int n5 = this._a(ozlu2, n, n2, n3, n4);
        int n6 = this._a((sdrg)ozlu2, n, n2, n3)._a();
        this._a((sdrg)ozlu2, n, n2, n3)._a(n5);
        if (n6 != n5 || !this._c(n4)) {
            boolean bl;
            boolean bl2 = this._b(ozlu2, n, n2, n3, n4);
            boolean bl3 = bl = this._a || (n4 & 8) != 0;
            if (bl && !bl2) {
                ozlu2.func_72921_c(n, n2, n3, n4 & 0xFFFFFFF7, 2);
            } else if (!bl && bl2) {
                ozlu2.func_72921_c(n, n2, n3, n4 | 8, 2);
            }
            this._a(ozlu2, n, n2, n3);
        }
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (this._a) {
            int n4 = ozlu2.func_72805_g(n, n2, n3);
            ozlu2.func_72832_d(n, n2, n3, this._b().field_71990_ca, n4 | 8, 4);
        }
        this._a(ozlu2, n, n2, n3, random);
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        super.func_71861_g(ozlu2, n, n2, n3);
        ozlu2.func_72837_a(n, n2, n3, this.func_72274_a(ozlu2));
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        super.func_71852_a(ozlu2, n, n2, n3, n4, n5);
        ozlu2.func_72932_q(n, n2, n3);
        this._a(ozlu2, n, n2, n3);
    }

    @Override
    public boolean func_71883_b(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        super.func_71883_b(ozlu2, n, n2, n3, n4, n5);
        hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
        return hurg2 != null ? hurg2.func_70315_b(n4, n5) : false;
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new jjzm();
    }

    @Override
    public void onNeighborTileChange(ozlu ozlu2, int n, int n2, int n3, int n4, int n5, int n6) {
        if (n2 == n5) {
            this.func_71863_a(ozlu2, n, n2, n3, ozlu2.func_72798_a(n4, n5, n6));
        }
    }

    @Override
    public boolean weakTileChanges() {
        return true;
    }
}

