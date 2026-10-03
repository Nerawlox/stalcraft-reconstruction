/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class gryy
extends lqhx {
    public boolean _e;
    public int _f;

    public gryy() {
    }

    public gryy(fovt fovt2, int n, Random random, uken uken2, int n2) {
        super(fovt2, n);
        this._n = n2;
        this._m = uken2;
        this._e = random.nextBoolean();
        this._f = random.nextInt(3);
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("T", this._f);
        qoac2._a("C", this._e);
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._f = qoac2._f("T");
        this._e = qoac2._o("C");
    }

    public static gryy _a(fovt fovt2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, 0, 0, 0, 4, 6, 5, n4);
        if (!gryy._a(uken2) || zztd._a(list, uken2) != null) {
            return null;
        }
        return new gryy(fovt2, n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        if (this._a < 0) {
            this._a = this._a(ozlu2, uken2);
            if (this._a < 0) {
                return true;
            }
            this._m._a(0, this._a - this._m._e + 6 - 1, 0);
        }
        this._a(ozlu2, uken2, 1, 1, 1, 3, 5, 4, 0, 0, false);
        this._a(ozlu2, uken2, 0, 0, 0, 3, 0, 4, twgu.field_71978_w.field_71990_ca, twgu.field_71978_w.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 0, 1, 2, 0, 3, twgu.field_71979_v.field_71990_ca, twgu.field_71979_v.field_71990_ca, false);
        if (this._e) {
            this._a(ozlu2, uken2, 1, 4, 1, 2, 4, 3, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        } else {
            this._a(ozlu2, uken2, 1, 5, 1, 2, 5, 3, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        }
        this._a(ozlu2, twgu.field_71951_J.field_71990_ca, 0, 1, 4, 0, uken2);
        this._a(ozlu2, twgu.field_71951_J.field_71990_ca, 0, 2, 4, 0, uken2);
        this._a(ozlu2, twgu.field_71951_J.field_71990_ca, 0, 1, 4, 4, uken2);
        this._a(ozlu2, twgu.field_71951_J.field_71990_ca, 0, 2, 4, 4, uken2);
        this._a(ozlu2, twgu.field_71951_J.field_71990_ca, 0, 0, 4, 1, uken2);
        this._a(ozlu2, twgu.field_71951_J.field_71990_ca, 0, 0, 4, 2, uken2);
        this._a(ozlu2, twgu.field_71951_J.field_71990_ca, 0, 0, 4, 3, uken2);
        this._a(ozlu2, twgu.field_71951_J.field_71990_ca, 0, 3, 4, 1, uken2);
        this._a(ozlu2, twgu.field_71951_J.field_71990_ca, 0, 3, 4, 2, uken2);
        this._a(ozlu2, twgu.field_71951_J.field_71990_ca, 0, 3, 4, 3, uken2);
        this._a(ozlu2, uken2, 0, 1, 0, 0, 3, 0, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        this._a(ozlu2, uken2, 3, 1, 0, 3, 3, 0, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 1, 4, 0, 3, 4, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        this._a(ozlu2, uken2, 3, 1, 4, 3, 3, 4, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 1, 1, 0, 3, 3, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 3, 1, 1, 3, 3, 3, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 1, 0, 2, 3, 0, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 1, 4, 2, 3, 4, twgu.field_71988_x.field_71990_ca, twgu.field_71988_x.field_71990_ca, false);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 0, 2, 2, uken2);
        this._a(ozlu2, twgu.field_72003_bq.field_71990_ca, 0, 3, 2, 2, uken2);
        if (this._f > 0) {
            this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, this._f, 1, 3, uken2);
            this._a(ozlu2, twgu.field_72046_aM.field_71990_ca, 0, this._f, 2, 3, uken2);
        }
        this._a(ozlu2, 0, 0, 1, 1, 0, uken2);
        this._a(ozlu2, 0, 0, 1, 2, 0, uken2);
        this._a(ozlu2, uken2, random, 1, 1, 0, this._e(twgu.field_72054_aE.field_71990_ca, 1));
        if (this._a(ozlu2, 1, 0, -1, uken2) == 0 && this._a(ozlu2, 1, -1, -1, uken2) != 0) {
            this._a(ozlu2, twgu.field_72057_aH.field_71990_ca, this._e(twgu.field_72057_aH.field_71990_ca, 3), 1, 0, -1, uken2);
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 4; ++j) {
                this._b(ozlu2, j, 6, i, uken2);
                this._b(ozlu2, twgu.field_71978_w.field_71990_ca, 0, j, -1, i, uken2);
            }
        }
        this._a(ozlu2, uken2, 1, 1, 2, 1);
        return true;
    }
}

