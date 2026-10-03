/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.util.vjvn;
import net.minecraftforge.common.ChestGenHooks;

public class wqhb
extends cfof {
    public static final vjvn[] _b = new vjvn[]{new vjvn(tgdv.field_77703_o.field_77779_bT, 0, 1, 5, 10), new vjvn(tgdv.field_77717_p.field_77779_bT, 0, 1, 3, 5), new vjvn(tgdv.field_77767_aC.field_77779_bT, 0, 4, 9, 5), new vjvn(tgdv.field_77705_m.field_77779_bT, 0, 3, 8, 10), new vjvn(tgdv.field_77684_U.field_77779_bT, 0, 1, 3, 15), new vjvn(tgdv.field_77706_j.field_77779_bT, 0, 1, 3, 15), new vjvn(tgdv.field_77696_g.field_77779_bT, 0, 1, 1, 1)};
    public int _c;

    public wqhb() {
    }

    public wqhb(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._a = this._a(random);
        this._m = uken2;
        this._c = random.nextInt(5);
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("Type", this._c);
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._c = qoac2._f("Type");
    }

    @Override
    public void _a(zztd zztd2, List list, Random random) {
        this._a((xciz)zztd2, list, random, 4, 1);
        this._b((xciz)zztd2, list, random, 1, 4);
        this._c((xciz)zztd2, list, random, 1, 4);
    }

    public static wqhb _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -4, -1, 0, 11, 7, 11, n4);
        return wqhb._a(uken2) && zztd._a(list, uken2) == null ? new wqhb(n5, random, uken2, n4) : null;
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        if (this._b(ozlu2, uken2)) {
            return false;
        }
        this._a(ozlu2, uken2, 0, 0, 0, 10, 6, 10, true, random, iyda._d());
        this._a(ozlu2, random, uken2, this._a, 4, 1, 0);
        this._a(ozlu2, uken2, 4, 1, 10, 6, 3, 10, 0, 0, false);
        this._a(ozlu2, uken2, 0, 1, 4, 0, 3, 6, 0, 0, false);
        this._a(ozlu2, uken2, 10, 1, 4, 10, 3, 6, 0, 0, false);
        switch (this._c) {
            case 0: {
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 5, 1, 5, uken2);
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 5, 2, 5, uken2);
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 5, 3, 5, uken2);
                this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 4, 3, 5, uken2);
                this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 6, 3, 5, uken2);
                this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 5, 3, 4, uken2);
                this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 5, 3, 6, uken2);
                this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 0, 4, 1, 4, uken2);
                this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 0, 4, 1, 5, uken2);
                this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 0, 4, 1, 6, uken2);
                this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 0, 6, 1, 4, uken2);
                this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 0, 6, 1, 5, uken2);
                this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 0, 6, 1, 6, uken2);
                this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 0, 5, 1, 4, uken2);
                this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 0, 5, 1, 6, uken2);
                break;
            }
            case 1: {
                for (int i = 0; i < 5; ++i) {
                    this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 3, 1, 3 + i, uken2);
                    this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 7, 1, 3 + i, uken2);
                    this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 3 + i, 1, 3, uken2);
                    this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 3 + i, 1, 7, uken2);
                }
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 5, 1, 5, uken2);
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 5, 2, 5, uken2);
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 5, 3, 5, uken2);
                this._a(ozlu2, twgu.field_71942_A.field_71990_ca, 0, 5, 4, 5, uken2);
                break;
            }
            case 2: {
                int n;
                for (n = 1; n <= 9; ++n) {
                    this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 1, 3, n, uken2);
                    this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 9, 3, n, uken2);
                }
                for (n = 1; n <= 9; ++n) {
                    this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, n, 3, 1, uken2);
                    this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, n, 3, 9, uken2);
                }
                this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 5, 1, 4, uken2);
                this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 5, 1, 6, uken2);
                this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 5, 3, 4, uken2);
                this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 5, 3, 6, uken2);
                this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 4, 1, 5, uken2);
                this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 6, 1, 5, uken2);
                this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 4, 3, 5, uken2);
                this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 6, 3, 5, uken2);
                for (n = 1; n <= 3; ++n) {
                    this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 4, n, 4, uken2);
                    this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 6, n, 4, uken2);
                    this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 4, n, 6, uken2);
                    this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 6, n, 6, uken2);
                }
                this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 5, 3, 5, uken2);
                for (n = 2; n <= 8; ++n) {
                    this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 2, 3, n, uken2);
                    this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 3, 3, n, uken2);
                    if (n <= 3 || n >= 7) {
                        this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 4, 3, n, uken2);
                        this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 5, 3, n, uken2);
                        this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 6, 3, n, uken2);
                    }
                    this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 7, 3, n, uken2);
                    this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 8, 3, n, uken2);
                }
                this._a(ozlu2, twgu.field_72055_aF.field_71990_ca, this._e(twgu.field_72055_aF.field_71990_ca, 4), 9, 1, 3, uken2);
                this._a(ozlu2, twgu.field_72055_aF.field_71990_ca, this._e(twgu.field_72055_aF.field_71990_ca, 4), 9, 2, 3, uken2);
                this._a(ozlu2, twgu.field_72055_aF.field_71990_ca, this._e(twgu.field_72055_aF.field_71990_ca, 4), 9, 3, 3, uken2);
                this._a(ozlu2, uken2, random, 3, 4, 8, ChestGenHooks.getItems("strongholdCrossing", random), ChestGenHooks.getCount("strongholdCrossing", random));
            }
        }
        return true;
    }
}

