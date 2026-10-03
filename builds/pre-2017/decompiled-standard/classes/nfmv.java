/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.monster.EntityWitch;

public class nfmv
extends ukcj {
    public boolean _e;

    public nfmv() {
    }

    public nfmv(Random random, int n, int n2) {
        super(random, n, 64, n2, 7, 5, 9);
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("Witch", this._e);
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._e = qoac2._o("Witch");
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        int n;
        int n2;
        int n3;
        if (!this._a(ozlu2, uken2, 0)) {
            return false;
        }
        this._a(ozlu2, uken2, 1, 1, 1, 5, 1, 7, twgu.field_71988_x.field_71990_ca, 1, twgu.field_71988_x.field_71990_ca, 1, false);
        this._a(ozlu2, uken2, 1, 4, 2, 5, 4, 7, twgu.field_71988_x.field_71990_ca, 1, twgu.field_71988_x.field_71990_ca, 1, false);
        this._a(ozlu2, uken2, 2, 1, 0, 4, 1, 0, twgu.field_71988_x.field_71990_ca, 1, twgu.field_71988_x.field_71990_ca, 1, false);
        this._a(ozlu2, uken2, 2, 2, 2, 3, 3, 2, twgu.field_71988_x.field_71990_ca, 1, twgu.field_71988_x.field_71990_ca, 1, false);
        this._a(ozlu2, uken2, 1, 2, 3, 1, 3, 6, twgu.field_71988_x.field_71990_ca, 1, twgu.field_71988_x.field_71990_ca, 1, false);
        this._a(ozlu2, uken2, 5, 2, 3, 5, 3, 6, twgu.field_71988_x.field_71990_ca, 1, twgu.field_71988_x.field_71990_ca, 1, false);
        this._a(ozlu2, uken2, 2, 2, 7, 4, 3, 7, twgu.field_71988_x.field_71990_ca, 1, twgu.field_71988_x.field_71990_ca, 1, false);
        this._a(ozlu2, uken2, 1, 0, 2, 1, 3, 2, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        this._a(ozlu2, uken2, 5, 0, 2, 5, 3, 2, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 0, 7, 1, 3, 7, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        this._a(ozlu2, uken2, 5, 0, 7, 5, 3, 7, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 2, 3, 2, uken2);
        this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 3, 3, 7, uken2);
        this._a(ozlu2, 0, 0, 1, 3, 4, uken2);
        this._a(ozlu2, 0, 0, 5, 3, 4, uken2);
        this._a(ozlu2, 0, 0, 5, 3, 5, uken2);
        this._a(ozlu2, twgu.field_82516_cf.field_71990_ca, 7, 1, 3, 5, uken2);
        this._a(ozlu2, twgu.field_72060_ay.field_71990_ca, 0, 3, 2, 6, uken2);
        this._a(ozlu2, twgu.field_72108_bG.field_71990_ca, 0, 4, 2, 6, uken2);
        this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 1, 2, 1, uken2);
        this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 5, 2, 1, uken2);
        int n4 = this._e(twgu.field_72063_at.field_71990_ca, 3);
        int n5 = this._e(twgu.field_72063_at.field_71990_ca, 1);
        int n6 = this._e(twgu.field_72063_at.field_71990_ca, 0);
        int n7 = this._e(twgu.field_72063_at.field_71990_ca, 2);
        this._a(ozlu2, uken2, 0, 4, 1, 6, 4, 1, twgu.field_72074_bW.field_71990_ca, n4, twgu.field_72074_bW.field_71990_ca, n4, false);
        this._a(ozlu2, uken2, 0, 4, 2, 0, 4, 7, twgu.field_72074_bW.field_71990_ca, n6, twgu.field_72074_bW.field_71990_ca, n6, false);
        this._a(ozlu2, uken2, 6, 4, 2, 6, 4, 7, twgu.field_72074_bW.field_71990_ca, n5, twgu.field_72074_bW.field_71990_ca, n5, false);
        this._a(ozlu2, uken2, 0, 4, 8, 6, 4, 8, twgu.field_72074_bW.field_71990_ca, n7, twgu.field_72074_bW.field_71990_ca, n7, false);
        for (n3 = 2; n3 <= 7; n3 += 5) {
            for (n2 = 1; n2 <= 5; n2 += 4) {
                this._b(ozlu2, twgu.field_71951_J.field_71990_ca, 0, n2, -1, n3, uken2);
            }
        }
        if (!this._e && uken2._b(n3 = this._c(2, 5), n2 = this._b(2), n = this._d(2, 5))) {
            this._e = true;
            EntityWitch entityWitch = new EntityWitch(ozlu2);
            entityWitch.func_70012_b((double)n3 + 0.5, n2, (double)n + 0.5, 0.0f, 0.0f);
            entityWitch.func_110161_a(null);
            ozlu2.func_72838_d(entityWitch);
        }
        return true;
    }
}

