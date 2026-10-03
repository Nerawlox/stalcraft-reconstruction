/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class wqgq
extends lqhx {
    public boolean _e;

    public wqgq() {
    }

    public wqgq(fovt fovt2, int n, Random random, uken uken2, int n2) {
        super(fovt2, n);
        this._n = n2;
        this._m = uken2;
        this._e = random.nextBoolean();
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("Terrace", this._e);
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._e = qoac2._o("Terrace");
    }

    public static wqgq _a(fovt fovt2, List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, 0, 0, 0, 5, 6, 5, n4);
        if (zztd._a(list2, uken2) != null) {
            return null;
        }
        return new wqgq(fovt2, n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        int n;
        if (this._a < 0) {
            this._a = this._a(ozlu2, uken2);
            if (this._a < 0) {
                return true;
            }
            this._m._a(0, this._a - this._m._e + 6 - 1, 0);
        }
        this._a(ozlu2, uken2, 0, 0, 0, 4, 0, 4, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 4, 0, 4, 4, 4, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 4, 1, 3, 4, 3, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 0, 1, 0, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 0, 2, 0, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 0, 3, 0, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 4, 1, 0, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 4, 2, 0, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 4, 3, 0, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 0, 1, 4, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 0, 2, 4, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 0, 3, 4, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 4, 1, 4, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 4, 2, 4, uken2);
        this._a(ozlu2, twgu.field_71978_w.field_71990_ca, 0, 4, 3, 4, uken2);
        this._a(ozlu2, uken2, 0, 1, 1, 0, 3, 3, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 4, 1, 1, 4, 3, 3, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 1, 4, 3, 3, 4, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 0, 2, 2, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 2, 2, 4, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 4, 2, 2, uken2);
        this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 1, 1, 0, uken2);
        this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 1, 2, 0, uken2);
        this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 1, 3, 0, uken2);
        this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 2, 3, 0, uken2);
        this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 3, 3, 0, uken2);
        this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 3, 2, 0, uken2);
        this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, 3, 1, 0, uken2);
        if (this._a(ozlu2, 2, 0, -1, uken2) == 0 && this._a(ozlu2, 2, -1, -1, uken2) != 0) {
            this._a(ozlu2, twgu.field_72057_aH.field_71990_ca, this._e(twgu.field_72057_aH.field_71990_ca, 3), 2, 0, -1, uken2);
        }
        this._a(ozlu2, uken2, 1, 1, 1, 3, 3, 3, 0, 0, false);
        if (this._e) {
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 0, 5, 0, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 1, 5, 0, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 2, 5, 0, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 3, 5, 0, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 4, 5, 0, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 0, 5, 4, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 1, 5, 4, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 2, 5, 4, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 3, 5, 4, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 4, 5, 4, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 4, 5, 1, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 4, 5, 2, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 4, 5, 3, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 0, 5, 1, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 0, 5, 2, uken2);
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 0, 5, 3, uken2);
        }
        if (this._e) {
            n = this._e(twgu.field_72055_aF.field_71990_ca, 3);
            this._a(ozlu2, twgu.field_72055_aF.field_71990_ca, n, 3, 1, 3, uken2);
            this._a(ozlu2, twgu.field_72055_aF.field_71990_ca, n, 3, 2, 3, uken2);
            this._a(ozlu2, twgu.field_72055_aF.field_71990_ca, n, 3, 3, 3, uken2);
            this._a(ozlu2, twgu.field_72055_aF.field_71990_ca, n, 3, 4, 3, uken2);
        }
        this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 2, 3, 1, uken2);
        for (n = 0; n < 5; ++n) {
            for (int i = 0; i < 5; ++i) {
                this._b(ozlu2, i, 6, n, uken2);
                this._b(ozlu2, twgu.field_71978_w.field_71990_ca, 0, i, -1, n, uken2);
            }
        }
        this._a(ozlu2, uken2, 1, 1, 2, 1);
        return true;
    }
}

