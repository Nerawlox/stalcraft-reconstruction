/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;

public class gadn
implements lpso {
    public cvzo _a;

    @Override
    public boolean func_77569_a(bsse bsse2, ozlu ozlu2) {
        Object object;
        this._a = null;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        for (int i = 0; i < bsse2.func_70302_i_(); ++i) {
            object = bsse2.func_70301_a(i);
            if (object == null) continue;
            if (((cvzo)object)._d == tgdv.field_77677_M.field_77779_bT) {
                ++n2;
                continue;
            }
            if (((cvzo)object)._d == tgdv.field_92106_bV.field_77779_bT) {
                ++n4;
                continue;
            }
            if (((cvzo)object)._d == tgdv.field_77756_aW.field_77779_bT) {
                ++n3;
                continue;
            }
            if (((cvzo)object)._d == tgdv.field_77759_aK.field_77779_bT) {
                ++n;
                continue;
            }
            if (((cvzo)object)._d == tgdv.field_77751_aT.field_77779_bT) {
                ++n5;
                continue;
            }
            if (((cvzo)object)._d == tgdv.field_77702_n.field_77779_bT) {
                ++n5;
                continue;
            }
            if (((cvzo)object)._d == tgdv.field_77811_bE.field_77779_bT) {
                ++n6;
                continue;
            }
            if (((cvzo)object)._d == tgdv.field_77676_L.field_77779_bT) {
                ++n6;
                continue;
            }
            if (((cvzo)object)._d == tgdv.field_77733_bq.field_77779_bT) {
                ++n6;
                continue;
            }
            if (((cvzo)object)._d != tgdv.field_82799_bQ.field_77779_bT) {
                return false;
            }
            ++n6;
        }
        n5 += n3 + n6;
        if (n2 <= 3 && n <= 1) {
            if (n2 >= 1 && n == 1 && n5 == 0) {
                this._a = new cvzo(tgdv.field_92104_bU);
                qoac qoac2 = new qoac();
                if (n4 > 0) {
                    object = new qoac("Fireworks");
                    bsyv bsyv2 = new bsyv("Explosions");
                    for (int i = 0; i < bsse2.func_70302_i_(); ++i) {
                        cvzo cvzo2 = bsse2.func_70301_a(i);
                        if (cvzo2 == null || cvzo2._d != tgdv.field_92106_bV.field_77779_bT || !cvzo2._p() || !cvzo2._q()._c("Explosion")) continue;
                        bsyv2._a(cvzo2._q()._m("Explosion"));
                    }
                    ((qoac)object)._a("Explosions", bsyv2);
                    ((qoac)object)._a("Flight", (byte)n2);
                    qoac2._a("Fireworks", (huhy)object);
                }
                this._a._d(qoac2);
                return true;
            }
            if (n2 == 1 && n == 0 && n4 == 0 && n3 > 0 && n6 <= 1) {
                this._a = new cvzo(tgdv.field_92106_bV);
                qoac qoac3 = new qoac();
                object = new qoac("Explosion");
                int n7 = 0;
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                for (int i = 0; i < bsse2.func_70302_i_(); ++i) {
                    cvzo cvzo3 = bsse2.func_70301_a(i);
                    if (cvzo3 == null) continue;
                    if (cvzo3._d == tgdv.field_77756_aW.field_77779_bT) {
                        arrayList.add(hugs._c[cvzo3._j()]);
                        continue;
                    }
                    if (cvzo3._d == tgdv.field_77751_aT.field_77779_bT) {
                        ((qoac)object)._a("Flicker", true);
                        continue;
                    }
                    if (cvzo3._d == tgdv.field_77702_n.field_77779_bT) {
                        ((qoac)object)._a("Trail", true);
                        continue;
                    }
                    if (cvzo3._d == tgdv.field_77811_bE.field_77779_bT) {
                        n7 = 1;
                        continue;
                    }
                    if (cvzo3._d == tgdv.field_77676_L.field_77779_bT) {
                        n7 = 4;
                        continue;
                    }
                    if (cvzo3._d == tgdv.field_77733_bq.field_77779_bT) {
                        n7 = 2;
                        continue;
                    }
                    if (cvzo3._d != tgdv.field_82799_bQ.field_77779_bT) continue;
                    n7 = 3;
                }
                int[] nArray = new int[arrayList.size()];
                for (int i = 0; i < nArray.length; ++i) {
                    nArray[i] = (Integer)arrayList.get(i);
                }
                ((qoac)object)._a("Colors", nArray);
                ((qoac)object)._a("Type", (byte)n7);
                qoac3._a("Explosion", (huhy)object);
                this._a._d(qoac3);
                return true;
            }
            if (n2 == 0 && n == 0 && n4 == 1 && n3 > 0 && n3 == n5) {
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                for (int i = 0; i < bsse2.func_70302_i_(); ++i) {
                    cvzo cvzo4 = bsse2.func_70301_a(i);
                    if (cvzo4 == null) continue;
                    if (cvzo4._d == tgdv.field_77756_aW.field_77779_bT) {
                        arrayList.add(hugs._c[cvzo4._j()]);
                        continue;
                    }
                    if (cvzo4._d != tgdv.field_92106_bV.field_77779_bT) continue;
                    this._a = cvzo4._l();
                    this._a._b = 1;
                }
                int[] nArray = new int[arrayList.size()];
                for (int i = 0; i < nArray.length; ++i) {
                    nArray[i] = (Integer)arrayList.get(i);
                }
                if (this._a != null && this._a._p()) {
                    qoac qoac4 = this._a._q()._m("Explosion");
                    if (qoac4 == null) {
                        return false;
                    }
                    qoac4._a("FadeColors", nArray);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override
    public cvzo func_77572_b(bsse bsse2) {
        return this._a._l();
    }

    @Override
    public int func_77570_a() {
        return 10;
    }

    @Override
    public cvzo func_77571_b() {
        return this._a;
    }
}

