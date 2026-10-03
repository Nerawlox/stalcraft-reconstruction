/*
 * Decompiled with CFR 0.152.
 */
public class qoaz
implements lpso {
    @Override
    public boolean func_77569_a(bsse bsse2, ozlu ozlu2) {
        int n = 0;
        cvzo cvzo2 = null;
        for (int i = 0; i < bsse2.func_70302_i_(); ++i) {
            cvzo cvzo3 = bsse2.func_70301_a(i);
            if (cvzo3 == null) continue;
            if (cvzo3._d == tgdv.field_77744_bd.field_77779_bT) {
                if (cvzo2 != null) {
                    return false;
                }
                cvzo2 = cvzo3;
                continue;
            }
            if (cvzo3._d == tgdv.field_82801_bO.field_77779_bT) {
                ++n;
                continue;
            }
            return false;
        }
        return cvzo2 != null && n > 0;
    }

    @Override
    public cvzo func_77572_b(bsse bsse2) {
        int n = 0;
        cvzo cvzo2 = null;
        for (int i = 0; i < bsse2.func_70302_i_(); ++i) {
            cvzo cvzo3 = bsse2.func_70301_a(i);
            if (cvzo3 == null) continue;
            if (cvzo3._d == tgdv.field_77744_bd.field_77779_bT) {
                if (cvzo2 != null) {
                    return null;
                }
                cvzo2 = cvzo3;
                continue;
            }
            if (cvzo3._d == tgdv.field_82801_bO.field_77779_bT) {
                ++n;
                continue;
            }
            return null;
        }
        if (cvzo2 == null || n < 1) {
            return null;
        }
        cvzo cvzo4 = new cvzo(tgdv.field_77744_bd, n + 1, cvzo2._j());
        if (cvzo2._u()) {
            cvzo4._a(cvzo2._s());
        }
        return cvzo4;
    }

    @Override
    public int func_77570_a() {
        return 9;
    }

    @Override
    public cvzo func_77571_b() {
        return null;
    }
}

