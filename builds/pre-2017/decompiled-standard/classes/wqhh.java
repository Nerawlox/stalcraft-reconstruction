/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class wqhh
extends lqhx {
    public wqhh() {
    }

    public wqhh(fovt fovt2, int n, Random random, uken uken2, int n2) {
        super(fovt2, n);
        this._n = n2;
        this._m = uken2;
    }

    public static wqhh _a(fovt fovt2, List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, 0, 0, 0, 9, 7, 11, n4);
        if (!wqhh._a(uken2) || zztd._a(list2, uken2) != null) {
            return null;
        }
        return new wqhh(fovt2, n5, random, uken2, n4);
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
            this._m._a(0, this._a - this._m._e + 7 - 1, 0);
        }
        this._a(ozlu2, uken2, 1, 1, 1, 7, 4, 4, 0, 0, false);
        this._a(ozlu2, uken2, 2, 1, 6, 8, 4, 10, 0, 0, false);
        this._a(ozlu2, uken2, 2, 0, 6, 8, 0, 10, twgu.field_71979_v.field_71990_ca, twgu.field_71979_v.field_71990_ca, false);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 6, 0, 6, uken2);
        this._a(ozlu2, uken2, 2, 1, 6, 2, 1, 10, twgu.field_72031_aZ.field_71990_ca, twgu.field_72031_aZ.field_71990_ca, false);
        this._a(ozlu2, uken2, 8, 1, 6, 8, 1, 10, twgu.field_72031_aZ.field_71990_ca, twgu.field_72031_aZ.field_71990_ca, false);
        this._a(ozlu2, uken2, 3, 1, 10, 7, 1, 10, twgu.field_72031_aZ.field_71990_ca, twgu.field_72031_aZ.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 0, 1, 7, 0, 4, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 0, 0, 0, 3, 5, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 8, 0, 0, 8, 3, 5, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 0, 0, 7, 1, 0, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 0, 5, 7, 1, 5, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 2, 0, 7, 3, 0, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 2, 5, 7, 3, 5, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 4, 1, 8, 4, 1, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 4, 4, 8, 4, 4, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 5, 2, 8, 5, 3, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 0, 4, 2, uken2);
        this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 0, 4, 3, uken2);
        this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 8, 4, 2, uken2);
        this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 8, 4, 3, uken2);
        int n3 = this._e(twgu.field_72063_at.field_71990_ca, 3);
        int n4 = this._e(twgu.field_72063_at.field_71990_ca, 2);
        for (n2 = -1; n2 <= 2; ++n2) {
            for (n = 0; n <= 8; ++n) {
                this._a(ozlu2, twgu.field_72063_at.field_71990_ca, n3, n, 4 + n2, n2, uken2);
                this._a(ozlu2, twgu.field_72063_at.field_71990_ca, n4, n, 4 + n2, 5 - n2, uken2);
            }
        }
        this._a(ozlu2, twgu.field_71951_J.field_71990_ca, 0, 0, 2, 1, uken2);
        this._a(ozlu2, twgu.field_71951_J.field_71990_ca, 0, 0, 2, 4, uken2);
        this._a(ozlu2, twgu.field_71951_J.field_71990_ca, 0, 8, 2, 1, uken2);
        this._a(ozlu2, twgu.field_71951_J.field_71990_ca, 0, 8, 2, 4, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 0, 2, 2, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 0, 2, 3, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 8, 2, 2, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 8, 2, 3, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 2, 2, 5, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 3, 2, 5, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 5, 2, 0, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 6, 2, 5, uken2);
        this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 2, 1, 3, uken2);
        this._a(ozlu2, twgu.field_72046_aM.field_71990_ca, 0, 2, 2, 3, uken2);
        this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 1, 1, 4, uken2);
        this._a(ozlu2, twgu.field_72063_at.field_71990_ca, this._e(twgu.field_72063_at.field_71990_ca, 3), 2, 1, 4, uken2);
        this._a(ozlu2, twgu.field_72063_at.field_71990_ca, this._e(twgu.field_72063_at.field_71990_ca, 1), 1, 1, 3, uken2);
        this._a(ozlu2, uken2, 5, 0, 1, 7, 0, 3, twgu.field_72085_aj.field_71990_ca, twgu.field_72085_aj.field_71990_ca, false);
        this._a(ozlu2, twgu.field_72085_aj.field_71990_ca, 0, 6, 1, 1, uken2);
        this._a(ozlu2, twgu.field_72085_aj.field_71990_ca, 0, 6, 1, 2, uken2);
        this._a(ozlu2, 0, 0, 2, 1, 0, uken2);
        this._a(ozlu2, 0, 0, 2, 2, 0, uken2);
        this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 2, 3, 1, uken2);
        this._a(ozlu2, uken2, random, 2, 1, 0, this._e(twgu.field_72054_aE.field_71990_ca, 1));
        if (this._a(ozlu2, 2, 0, -1, uken2) == 0 && this._a(ozlu2, 2, -1, -1, uken2) != 0) {
            this._a(ozlu2, twgu.field_72057_aH.field_71990_ca, this._e(twgu.field_72057_aH.field_71990_ca, 3), 2, 0, -1, uken2);
        }
        this._a(ozlu2, 0, 0, 6, 1, 5, uken2);
        this._a(ozlu2, 0, 0, 6, 2, 5, uken2);
        this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 6, 3, 4, uken2);
        this._a(ozlu2, uken2, random, 6, 1, 5, this._e(twgu.field_72054_aE.field_71990_ca, 1));
        for (n2 = 0; n2 < 5; ++n2) {
            for (n = 0; n < 9; ++n) {
                this._b(ozlu2, n, 7, n2, uken2);
                this._b(ozlu2, twgu.field_71978_w.field_71990_ca, 0, n, -1, n2, uken2);
            }
        }
        this._a(ozlu2, uken2, 4, 1, 2, 2);
        return true;
    }

    @Override
    public int _a(int n) {
        if (n == 0) {
            return 4;
        }
        return 0;
    }
}

