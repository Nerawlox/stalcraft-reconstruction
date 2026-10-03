/*
 * Decompiled with CFR 0.152.
 */
public class ixkn
extends xbtf {
    public ixkn() {
        super(3, 3, new cvzo[]{new cvzo(tgdv.field_77759_aK), new cvzo(tgdv.field_77759_aK), new cvzo(tgdv.field_77759_aK), new cvzo(tgdv.field_77759_aK), new cvzo(tgdv.field_77744_bd, 0, Short.MAX_VALUE), new cvzo(tgdv.field_77759_aK), new cvzo(tgdv.field_77759_aK), new cvzo(tgdv.field_77759_aK), new cvzo(tgdv.field_77759_aK)}, new cvzo(tgdv.field_82801_bO, 0, 0));
    }

    @Override
    public boolean func_77569_a(bsse bsse2, ozlu ozlu2) {
        if (!super.func_77569_a(bsse2, ozlu2)) {
            return false;
        }
        cvzo cvzo2 = null;
        for (int i = 0; i < bsse2.func_70302_i_() && cvzo2 == null; ++i) {
            cvzo cvzo3 = bsse2.func_70301_a(i);
            if (cvzo3 == null || cvzo3._d != tgdv.field_77744_bd.field_77779_bT) continue;
            cvzo2 = cvzo3;
        }
        if (cvzo2 == null) {
            return false;
        }
        thdd thdd2 = tgdv.field_77744_bd._a(cvzo2, ozlu2);
        if (thdd2 == null) {
            return false;
        }
        return thdd2._d < 4;
    }

    @Override
    public cvzo func_77572_b(bsse bsse2) {
        cvzo cvzo2 = null;
        for (int i = 0; i < bsse2.func_70302_i_() && cvzo2 == null; ++i) {
            cvzo cvzo3 = bsse2.func_70301_a(i);
            if (cvzo3 == null || cvzo3._d != tgdv.field_77744_bd.field_77779_bT) continue;
            cvzo2 = cvzo3;
        }
        cvzo2 = cvzo2._l();
        cvzo2._b = 1;
        if (cvzo2._q() == null) {
            cvzo2._d(new qoac());
        }
        cvzo2._q()._a("map_is_scaling", true);
        return cvzo2;
    }
}

