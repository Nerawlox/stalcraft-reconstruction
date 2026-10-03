/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.util.vjvn;
import net.minecraftforge.common.ChestGenHooks;

public class oiqc
extends cfof {
    public static final vjvn[] _b = new vjvn[]{new vjvn(tgdv.field_77730_bn.field_77779_bT, 0, 1, 1, 10), new vjvn(tgdv.field_77702_n.field_77779_bT, 0, 1, 3, 3), new vjvn(tgdv.field_77703_o.field_77779_bT, 0, 1, 5, 10), new vjvn(tgdv.field_77717_p.field_77779_bT, 0, 1, 3, 5), new vjvn(tgdv.field_77767_aC.field_77779_bT, 0, 4, 9, 5), new vjvn(tgdv.field_77684_U.field_77779_bT, 0, 1, 3, 15), new vjvn(tgdv.field_77706_j.field_77779_bT, 0, 1, 3, 15), new vjvn(tgdv.field_77696_g.field_77779_bT, 0, 1, 1, 5), new vjvn(tgdv.field_77716_q.field_77779_bT, 0, 1, 1, 5), new vjvn(tgdv.field_77822_ae.field_77779_bT, 0, 1, 1, 5), new vjvn(tgdv.field_77812_ad.field_77779_bT, 0, 1, 1, 5), new vjvn(tgdv.field_77824_af.field_77779_bT, 0, 1, 1, 5), new vjvn(tgdv.field_77818_ag.field_77779_bT, 0, 1, 1, 5), new vjvn(tgdv.field_77778_at.field_77779_bT, 0, 1, 1, 1), new vjvn(tgdv.field_77765_aA.field_77779_bT, 0, 1, 1, 1), new vjvn(tgdv.field_111215_ce.field_77779_bT, 0, 1, 1, 1), new vjvn(tgdv.field_111216_cf.field_77779_bT, 0, 1, 1, 1), new vjvn(tgdv.field_111213_cg.field_77779_bT, 0, 1, 1, 1)};
    public boolean _c;

    public oiqc() {
    }

    public oiqc(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._a = this._a(random);
        this._m = uken2;
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("Chest", this._c);
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._c = qoac2._o("Chest");
    }

    @Override
    public void _a(zztd zztd2, List list2, Random random) {
        this._a((xciz)zztd2, list2, random, 1, 1);
    }

    public static oiqc _a(List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, -1, 0, 5, 5, 7, n4);
        return oiqc._a(uken2) && zztd._a(list2, uken2) == null ? new oiqc(n5, random, uken2, n4) : null;
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        int n;
        if (this._b(ozlu2, uken2)) {
            return false;
        }
        this._a(ozlu2, uken2, 0, 0, 0, 4, 4, 6, true, random, iyda._d());
        this._a(ozlu2, random, uken2, this._a, 1, 1, 0);
        this._a(ozlu2, random, uken2, nwns._a, 1, 1, 6);
        this._a(ozlu2, uken2, 3, 1, 2, 3, 1, 4, twgu.field_72007_bm.field_71990_ca, twgu.field_72007_bm.field_71990_ca, false);
        this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 5, 3, 1, 1, uken2);
        this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 5, 3, 1, 5, uken2);
        this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 5, 3, 2, 2, uken2);
        this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 5, 3, 2, 4, uken2);
        for (n = 2; n <= 4; ++n) {
            this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 5, 2, 1, n, uken2);
        }
        if (!this._c) {
            int n2;
            n = this._b(2);
            int n3 = this._c(3, 3);
            if (uken2._b(n3, n, n2 = this._d(3, 3))) {
                this._c = true;
                this._a(ozlu2, uken2, random, 3, 2, 3, ChestGenHooks.getItems("strongholdCorridor", random), ChestGenHooks.getCount("strongholdCorridor", random));
            }
        }
        return true;
    }
}

