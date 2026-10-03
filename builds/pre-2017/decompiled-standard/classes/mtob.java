/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.util.vjvn;

public class mtob {
    public static final vjvn[] _a = new vjvn[]{new vjvn(tgdv.field_77703_o.field_77779_bT, 0, 1, 5, 10), new vjvn(tgdv.field_77717_p.field_77779_bT, 0, 1, 3, 5), new vjvn(tgdv.field_77767_aC.field_77779_bT, 0, 4, 9, 5), new vjvn(tgdv.field_77756_aW.field_77779_bT, 4, 4, 9, 5), new vjvn(tgdv.field_77702_n.field_77779_bT, 0, 1, 2, 3), new vjvn(tgdv.field_77705_m.field_77779_bT, 0, 3, 8, 10), new vjvn(tgdv.field_77684_U.field_77779_bT, 0, 1, 3, 15), new vjvn(tgdv.field_77696_g.field_77779_bT, 0, 1, 1, 1), new vjvn(twgu.field_72056_aG.field_71990_ca, 0, 4, 8, 1), new vjvn(tgdv.field_77740_bh.field_77779_bT, 0, 2, 4, 10), new vjvn(tgdv.field_77739_bg.field_77779_bT, 0, 2, 4, 10), new vjvn(tgdv.field_77765_aA.field_77779_bT, 0, 1, 1, 3), new vjvn(tgdv.field_111215_ce.field_77779_bT, 0, 1, 1, 1)};

    public static void _a() {
        cfps._b(mchl.class, "MSCorridor");
        cfps._b(plqt.class, "MSCrossing");
        cfps._b(nwmc.class, "MSRoom");
        cfps._b(vnce.class, "MSStairs");
    }

    public static zztd _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        int n6 = random.nextInt(100);
        if (n6 >= 80) {
            uken uken2 = plqt._a(list, random, n, n2, n3, n4);
            if (uken2 != null) {
                return new plqt(n5, random, uken2, n4);
            }
        } else if (n6 >= 70) {
            uken uken3 = vnce._a(list, random, n, n2, n3, n4);
            if (uken3 != null) {
                return new vnce(n5, random, uken3, n4);
            }
        } else {
            uken uken4 = mchl._a(list, random, n, n2, n3, n4);
            if (uken4 != null) {
                return new mchl(n5, random, uken4, n4);
            }
        }
        return null;
    }

    public static zztd _a(zztd zztd2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        if (n5 > 8) {
            return null;
        }
        if (Math.abs(n - zztd2._d()._a) > 80 || Math.abs(n3 - zztd2._d()._c) > 80) {
            return null;
        }
        zztd zztd3 = mtob._a(list, random, n, n2, n3, n4, n5 + 1);
        if (zztd3 != null) {
            list.add(zztd3);
            zztd3._a(zztd2, list, random);
        }
        return zztd3;
    }

    public static /* synthetic */ zztd _b(zztd zztd2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        return mtob._a(zztd2, list, random, n, n2, n3, n4, n5);
    }

    public static /* synthetic */ vjvn[] _b() {
        return _a;
    }
}

