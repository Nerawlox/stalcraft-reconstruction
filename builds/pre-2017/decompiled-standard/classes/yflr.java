/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.util.sajh;

public class yflr
extends lqhx {
    public int _e;
    public int _f;
    public int _g;
    public int _h;

    public yflr() {
    }

    public yflr(fovt fovt2, int n, Random random, uken uken2, int n2) {
        super(fovt2, n);
        this._n = n2;
        this._m = uken2;
        this._e = this._a(random);
        this._f = this._a(random);
        this._g = this._a(random);
        this._h = this._a(random);
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("CA", this._e);
        qoac2._a("CB", this._f);
        qoac2._a("CC", this._g);
        qoac2._a("CD", this._h);
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._e = qoac2._f("CA");
        this._f = qoac2._f("CB");
        this._g = qoac2._f("CC");
        this._h = qoac2._f("CD");
    }

    public int _a(Random random) {
        switch (random.nextInt(5)) {
            default: {
                return twgu.field_72058_az.field_71990_ca;
            }
            case 0: {
                return twgu.field_82513_cg.field_71990_ca;
            }
            case 1: 
        }
        return twgu.field_82514_ch.field_71990_ca;
    }

    public static yflr _a(fovt fovt2, List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, 0, 0, 0, 13, 4, 9, n4);
        if (!yflr._a(uken2) || zztd._a(list2, uken2) != null) {
            return null;
        }
        return new yflr(fovt2, n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        int n;
        if (this._a < 0) {
            this._a = this._a(ozlu2, uken2);
            if (this._a < 0) {
                return true;
            }
            this._m._a(0, this._a - this._m._e + 4 - 1, 0);
        }
        this._a(ozlu2, uken2, 0, 1, 0, 12, 4, 8, 0, 0, false);
        this._a(ozlu2, uken2, 1, 0, 1, 2, 0, 7, twgu.field_72050_aA.field_71990_ca, twgu.field_72050_aA.field_71990_ca, false);
        this._a(ozlu2, uken2, 4, 0, 1, 5, 0, 7, twgu.field_72050_aA.field_71990_ca, twgu.field_72050_aA.field_71990_ca, false);
        this._a(ozlu2, uken2, 7, 0, 1, 8, 0, 7, twgu.field_72050_aA.field_71990_ca, twgu.field_72050_aA.field_71990_ca, false);
        this._a(ozlu2, uken2, 10, 0, 1, 11, 0, 7, twgu.field_72050_aA.field_71990_ca, twgu.field_72050_aA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 0, 0, 0, 0, 8, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        this._a(ozlu2, uken2, 6, 0, 0, 6, 0, 8, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        this._a(ozlu2, uken2, 12, 0, 0, 12, 0, 8, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 0, 0, 11, 0, 0, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 0, 8, 11, 0, 8, twgu.field_71951_J.field_71990_ca, twgu.field_71951_J.field_71990_ca, false);
        this._a(ozlu2, uken2, 3, 0, 1, 3, 0, 7, twgu.field_71942_A.field_71990_ca, twgu.field_71942_A.field_71990_ca, false);
        this._a(ozlu2, uken2, 9, 0, 1, 9, 0, 7, twgu.field_71942_A.field_71990_ca, twgu.field_71942_A.field_71990_ca, false);
        for (n = 1; n <= 7; ++n) {
            this._a(ozlu2, this._e, sajh._a(random, 2, 7), 1, 1, n, uken2);
            this._a(ozlu2, this._e, sajh._a(random, 2, 7), 2, 1, n, uken2);
            this._a(ozlu2, this._f, sajh._a(random, 2, 7), 4, 1, n, uken2);
            this._a(ozlu2, this._f, sajh._a(random, 2, 7), 5, 1, n, uken2);
            this._a(ozlu2, this._g, sajh._a(random, 2, 7), 7, 1, n, uken2);
            this._a(ozlu2, this._g, sajh._a(random, 2, 7), 8, 1, n, uken2);
            this._a(ozlu2, this._h, sajh._a(random, 2, 7), 10, 1, n, uken2);
            this._a(ozlu2, this._h, sajh._a(random, 2, 7), 11, 1, n, uken2);
        }
        for (n = 0; n < 9; ++n) {
            for (int i = 0; i < 13; ++i) {
                this._b(ozlu2, i, 4, n, uken2);
                this._b(ozlu2, twgu.field_71979_v.field_71990_ca, 0, i, -1, n, uken2);
            }
        }
        return true;
    }
}

