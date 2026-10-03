/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class ywng
extends lqhx {
    public ywng() {
    }

    public ywng(fovt fovt2, int n, Random random, uken uken2, int n2) {
        super(fovt2, n);
        this._n = n2;
        this._m = uken2;
    }

    public static ywng _a(fovt fovt2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, 0, 0, 0, 9, 9, 6, n4);
        if (!ywng._a(uken2) || zztd._a(list, uken2) != null) {
            return null;
        }
        return new ywng(fovt2, n5, random, uken2, n4);
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
            this._m._a(0, this._a - this._m._e + 9 - 1, 0);
        }
        this._a(ozlu2, uken2, 1, 1, 1, 7, 5, 4, 0, 0, false);
        this._a(ozlu2, uken2, 0, 0, 0, 8, 0, 5, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 5, 0, 8, 5, 5, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 6, 1, 8, 6, 4, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 7, 2, 8, 7, 3, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        int n3 = this._e(twgu.field_72063_at.field_71990_ca, 3);
        int n4 = this._e(twgu.field_72063_at.field_71990_ca, 2);
        for (n2 = -1; n2 <= 2; ++n2) {
            for (n = 0; n <= 8; ++n) {
                this._a(ozlu2, twgu.field_72063_at.field_71990_ca, n3, n, 6 + n2, n2, uken2);
                this._a(ozlu2, twgu.field_72063_at.field_71990_ca, n4, n, 6 + n2, 5 - n2, uken2);
            }
        }
        this._a(ozlu2, uken2, 0, 1, 0, 0, 1, 5, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 1, 5, 8, 1, 5, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 8, 1, 0, 8, 1, 4, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 2, 1, 0, 7, 1, 0, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 2, 0, 0, 4, 0, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 2, 5, 0, 4, 5, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 8, 2, 5, 8, 4, 5, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 8, 2, 0, 8, 4, 0, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 2, 1, 0, 4, 4, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 2, 5, 7, 4, 5, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 8, 2, 1, 8, 4, 4, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 2, 0, 7, 4, 0, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 4, 2, 0, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 5, 2, 0, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 6, 2, 0, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 4, 3, 0, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 5, 3, 0, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 6, 3, 0, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 0, 2, 2, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 0, 2, 3, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 0, 3, 2, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 0, 3, 3, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 8, 2, 2, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 8, 2, 3, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 8, 3, 2, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 8, 3, 3, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 2, 2, 5, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 3, 2, 5, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 5, 2, 5, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 6, 2, 5, uken2);
        this._a(ozlu2, uken2, 1, 4, 1, 7, 4, 1, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 4, 4, 7, 4, 4, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 3, 4, 7, 3, 4, twgu.field_72093_an.field_71990_ca, twgu.field_72093_an.field_71990_ca, false);
        this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 7, 1, 4, uken2);
        this._a(ozlu2, twgu.field_72063_at.field_71990_ca, this._e(twgu.field_72063_at.field_71990_ca, 0), 7, 1, 3, uken2);
        n2 = this._e(twgu.field_72063_at.field_71990_ca, 3);
        this._a(ozlu2, twgu.field_72063_at.field_71990_ca, n2, 6, 1, 4, uken2);
        this._a(ozlu2, twgu.field_72063_at.field_71990_ca, n2, 5, 1, 4, uken2);
        this._a(ozlu2, twgu.field_72063_at.field_71990_ca, n2, 4, 1, 4, uken2);
        this._a(ozlu2, twgu.field_72063_at.field_71990_ca, n2, 3, 1, 4, uken2);
        this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 6, 1, 3, uken2);
        this._a(ozlu2, twgu.field_72046_aM.field_71990_ca, 0, 6, 2, 3, uken2);
        this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 4, 1, 3, uken2);
        this._a(ozlu2, twgu.field_72046_aM.field_71990_ca, 0, 4, 2, 3, uken2);
        this._a(ozlu2, twgu.field_72060_ay.field_71990_ca, 0, 7, 1, 1, uken2);
        this._a(ozlu2, 0, 0, 1, 1, 0, uken2);
        this._a(ozlu2, 0, 0, 1, 2, 0, uken2);
        this._a(ozlu2, uken2, random, 1, 1, 0, this._e(twgu.field_72054_aE.field_71990_ca, 1));
        if (this._a(ozlu2, 1, 0, -1, uken2) == 0 && this._a(ozlu2, 1, -1, -1, uken2) != 0) {
            this._a(ozlu2, twgu.field_72057_aH.field_71990_ca, this._e(twgu.field_72057_aH.field_71990_ca, 3), 1, 0, -1, uken2);
        }
        for (n = 0; n < 6; ++n) {
            for (int i = 0; i < 9; ++i) {
                this._b(ozlu2, i, 9, n, uken2);
                this._b(ozlu2, twgu.field_71978_w.field_71990_ca, 0, i, -1, n, uken2);
            }
        }
        this._a(ozlu2, uken2, 2, 1, 2, 1);
        return true;
    }

    @Override
    public int _a(int n) {
        return 1;
    }
}

