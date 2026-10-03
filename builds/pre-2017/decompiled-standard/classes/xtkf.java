/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.util.vjvn;
import net.minecraftforge.common.ChestGenHooks;

public class xtkf
extends lqhx {
    public static final vjvn[] _e = new vjvn[]{new vjvn(tgdv.field_77702_n.field_77779_bT, 0, 1, 3, 3), new vjvn(tgdv.field_77703_o.field_77779_bT, 0, 1, 5, 10), new vjvn(tgdv.field_77717_p.field_77779_bT, 0, 1, 3, 5), new vjvn(tgdv.field_77684_U.field_77779_bT, 0, 1, 3, 15), new vjvn(tgdv.field_77706_j.field_77779_bT, 0, 1, 3, 15), new vjvn(tgdv.field_77696_g.field_77779_bT, 0, 1, 1, 5), new vjvn(tgdv.field_77716_q.field_77779_bT, 0, 1, 1, 5), new vjvn(tgdv.field_77822_ae.field_77779_bT, 0, 1, 1, 5), new vjvn(tgdv.field_77812_ad.field_77779_bT, 0, 1, 1, 5), new vjvn(tgdv.field_77824_af.field_77779_bT, 0, 1, 1, 5), new vjvn(tgdv.field_77818_ag.field_77779_bT, 0, 1, 1, 5), new vjvn(twgu.field_72089_ap.field_71990_ca, 0, 3, 7, 5), new vjvn(twgu.field_71987_y.field_71990_ca, 0, 3, 7, 5), new vjvn(tgdv.field_77765_aA.field_77779_bT, 0, 1, 1, 3), new vjvn(tgdv.field_111215_ce.field_77779_bT, 0, 1, 1, 1), new vjvn(tgdv.field_111216_cf.field_77779_bT, 0, 1, 1, 1), new vjvn(tgdv.field_111213_cg.field_77779_bT, 0, 1, 1, 1)};
    public boolean _f;

    public xtkf() {
    }

    public xtkf(fovt fovt2, int n, Random random, uken uken2, int n2) {
        super(fovt2, n);
        this._n = n2;
        this._m = uken2;
    }

    public static xtkf _a(fovt fovt2, List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, 0, 0, 0, 10, 6, 7, n4);
        return xtkf._a(uken2) && zztd._a(list2, uken2) == null ? new xtkf(fovt2, n5, random, uken2, n4) : null;
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("Chest", this._f);
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._f = qoac2._o("Chest");
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        int n;
        int n2;
        if (this._a < 0) {
            this._a = this._a(ozlu2, uken2);
            if (this._a < 0) {
                return true;
            }
            this._m._a(0, this._a - this._m._e + 6 - 1, 0);
        }
        this._a(ozlu2, uken2, 0, 1, 0, 9, 4, 6, 0, 0, false);
        this._a(ozlu2, uken2, 0, 0, 0, 9, 0, 6, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 4, 0, 9, 4, 6, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 5, 0, 9, 5, 6, twgu.field_72079_ak.field_71990_ca, twgu.field_72079_ak.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 5, 1, 8, 5, 5, 0, 0, false);
        this._a(ozlu2, uken2, 1, 1, 0, 2, 3, 0, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 1, 0, 0, 4, 0, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        this._a(ozlu2, uken2, 3, 1, 0, 3, 4, 0, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 1, 6, 0, 4, 6, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 3, 3, 1, uken2);
        this._a(ozlu2, uken2, 3, 1, 2, 3, 3, 2, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 4, 1, 3, 5, 3, 3, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 1, 1, 0, 3, 5, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 1, 6, 5, 3, 6, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 5, 1, 0, 5, 3, 0, twgu.field_72031_aZ.field_71990_ca, twgu.field_72031_aZ.field_71990_ca, false);
        this._a(ozlu2, uken2, 9, 1, 0, 9, 3, 0, twgu.field_72031_aZ.field_71990_ca, twgu.field_72031_aZ.field_71990_ca, false);
        this._a(ozlu2, uken2, 6, 1, 4, 9, 4, 6, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, twgu.field_71944_C.field_71990_ca, 0, 7, 1, 5, uken2);
        this._a(ozlu2, twgu.field_71944_C.field_71990_ca, 0, 8, 1, 5, uken2);
        this._a(ozlu2, twgu.field_72002_bp.field_71990_ca, 0, 9, 2, 5, uken2);
        this._a(ozlu2, twgu.field_72002_bp.field_71990_ca, 0, 9, 2, 4, uken2);
        this._a(ozlu2, uken2, 7, 2, 4, 8, 2, 5, 0, 0, false);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 6, 1, 3, uken2);
        this._a(ozlu2, twgu.field_72051_aB.field_71990_ca, 0, 6, 2, 3, uken2);
        this._a(ozlu2, twgu.field_72051_aB.field_71990_ca, 0, 6, 3, 3, uken2);
        this._a(ozlu2, twgu.field_72085_aj.field_71990_ca, 0, 8, 1, 1, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 0, 2, 2, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 0, 2, 4, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 2, 2, 6, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 4, 2, 6, uken2);
        this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 2, 1, 4, uken2);
        this._a(ozlu2, twgu.field_72046_aM.field_71990_ca, 0, 2, 2, 4, uken2);
        this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 1, 1, 5, uken2);
        this._a(ozlu2, twgu.field_72063_at.field_71990_ca, this._e(twgu.field_72063_at.field_71990_ca, 3), 2, 1, 5, uken2);
        this._a(ozlu2, twgu.field_72063_at.field_71990_ca, this._e(twgu.field_72063_at.field_71990_ca, 1), 1, 1, 4, uken2);
        if (!this._f) {
            int n3;
            n2 = this._b(1);
            n = this._c(5, 5);
            if (uken2._b(n, n2, n3 = this._d(5, 5))) {
                this._f = true;
                this._a(ozlu2, uken2, random, 5, 1, 5, ChestGenHooks.getItems("villageBlacksmith", random), ChestGenHooks.getCount("villageBlacksmith", random));
            }
        }
        for (n2 = 6; n2 <= 8; ++n2) {
            if (this._a(ozlu2, n2, 0, -1, uken2) != 0 || this._a(ozlu2, n2, -1, -1, uken2) == 0) continue;
            this._a(ozlu2, twgu.field_72057_aH.field_71990_ca, this._e(twgu.field_72057_aH.field_71990_ca, 3), n2, 0, -1, uken2);
        }
        for (n2 = 0; n2 < 7; ++n2) {
            for (n = 0; n < 10; ++n) {
                this._b(ozlu2, n, 6, n2, uken2);
                this._b(ozlu2, twgu.field_71978_w.field_71990_ca, 0, n, -1, n2, uken2);
            }
        }
        this._a(ozlu2, uken2, 7, 1, 1, 1);
        return true;
    }

    @Override
    public int _a(int n) {
        return 3;
    }
}

