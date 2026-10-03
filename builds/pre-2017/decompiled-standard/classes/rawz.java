/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class rawz
extends lqhx {
    public rawz() {
    }

    public rawz(fovt fovt2, int n, Random random, uken uken2, int n2) {
        super(fovt2, n);
        this._n = n2;
        this._m = uken2;
    }

    public static rawz _a(fovt fovt2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, 0, 0, 0, 5, 12, 9, n4);
        if (!rawz._a(uken2) || zztd._a(list, uken2) != null) {
            return null;
        }
        return new rawz(fovt2, n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        int n;
        if (this._a < 0) {
            this._a = this._a(ozlu2, uken2);
            if (this._a < 0) {
                return true;
            }
            this._m._a(0, this._a - this._m._e + 12 - 1, 0);
        }
        this._a(ozlu2, uken2, 1, 1, 1, 3, 3, 7, 0, 0, false);
        this._a(ozlu2, uken2, 1, 5, 1, 3, 9, 3, 0, 0, false);
        this._a(ozlu2, uken2, 1, 0, 0, 3, 0, 8, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 1, 0, 3, 10, 0, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 1, 1, 0, 10, 3, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 4, 1, 1, 4, 10, 3, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 0, 4, 0, 4, 7, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 4, 0, 4, 4, 4, 7, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 1, 8, 3, 4, 8, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 5, 4, 3, 10, 4, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 5, 5, 3, 5, 7, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 9, 0, 4, 9, 4, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 4, 0, 4, 4, 4, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 0, 11, 2, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 4, 11, 2, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 2, 11, 0, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 2, 11, 4, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 1, 1, 6, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 1, 1, 7, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 2, 1, 7, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 3, 1, 6, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 3, 1, 7, uken2);
        this._a(ozlu2, twgu.field_72057_aH.field_71990_ca, this._e(twgu.field_72057_aH.field_71990_ca, 3), 1, 1, 5, uken2);
        this._a(ozlu2, twgu.field_72057_aH.field_71990_ca, this._e(twgu.field_72057_aH.field_71990_ca, 3), 2, 1, 6, uken2);
        this._a(ozlu2, twgu.field_72057_aH.field_71990_ca, this._e(twgu.field_72057_aH.field_71990_ca, 3), 3, 1, 5, uken2);
        this._a(ozlu2, twgu.field_72057_aH.field_71990_ca, this._e(twgu.field_72057_aH.field_71990_ca, 1), 1, 2, 7, uken2);
        this._a(ozlu2, twgu.field_72057_aH.field_71990_ca, this._e(twgu.field_72057_aH.field_71990_ca, 0), 3, 2, 7, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 0, 2, 2, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 0, 3, 2, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 4, 2, 2, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 4, 3, 2, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 0, 6, 2, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 0, 7, 2, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 4, 6, 2, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 4, 7, 2, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 2, 6, 0, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 2, 7, 0, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 2, 6, 4, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 2, 7, 4, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 0, 3, 6, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 4, 3, 6, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 2, 3, 8, uken2);
        this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 2, 4, 7, uken2);
        this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 1, 4, 6, uken2);
        this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 3, 4, 6, uken2);
        this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 2, 4, 5, uken2);
        int n2 = this._e(twgu.field_72055_aF.field_71990_ca, 4);
        for (n = 1; n <= 9; ++n) {
            this._a(ozlu2, twgu.field_72055_aF.field_71990_ca, n2, 3, n, 3, uken2);
        }
        this._a(ozlu2, 0, 0, 2, 1, 0, uken2);
        this._a(ozlu2, 0, 0, 2, 2, 0, uken2);
        this._a(ozlu2, uken2, random, 2, 1, 0, this._e(twgu.field_72054_aE.field_71990_ca, 1));
        if (this._a(ozlu2, 2, 0, -1, uken2) == 0 && this._a(ozlu2, 2, -1, -1, uken2) != 0) {
            this._a(ozlu2, twgu.field_72057_aH.field_71990_ca, this._e(twgu.field_72057_aH.field_71990_ca, 3), 2, 0, -1, uken2);
        }
        for (n = 0; n < 9; ++n) {
            for (int i = 0; i < 5; ++i) {
                this._b(ozlu2, i, 12, n, uken2);
                this._b(ozlu2, twgu.field_71978_w.field_71990_ca, 0, i, -1, n, uken2);
            }
        }
        this._a(ozlu2, uken2, 2, 1, 2, 1);
        return true;
    }

    @Override
    public int _a(int n) {
        return 2;
    }
}

