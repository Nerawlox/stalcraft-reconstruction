/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class nwos
extends cfof {
    public boolean _b;

    public nwos() {
    }

    public nwos(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("Mob", this._b);
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._b = qoac2._o("Mob");
    }

    @Override
    public void _a(zztd zztd2, List list, Random random) {
        if (zztd2 != null) {
            ((xciz)zztd2)._d = this;
        }
    }

    public static nwos _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -4, -1, 0, 11, 8, 16, n4);
        if (!nwos._a(uken2) || zztd._a(list, uken2) != null) {
            return null;
        }
        return new nwos(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        int n;
        int n2;
        this._a(ozlu2, uken2, 0, 0, 0, 10, 7, 15, false, random, iyda._d());
        this._a(ozlu2, random, uken2, nwns._c, 4, 1, 0);
        int n3 = 6;
        this._a(ozlu2, uken2, 1, n3, 1, 1, n3, 14, false, random, iyda._d());
        this._a(ozlu2, uken2, 9, n3, 1, 9, n3, 14, false, random, iyda._d());
        this._a(ozlu2, uken2, 2, n3, 1, 8, n3, 2, false, random, iyda._d());
        this._a(ozlu2, uken2, 2, n3, 14, 8, n3, 14, false, random, iyda._d());
        this._a(ozlu2, uken2, 1, 1, 1, 2, 1, 4, false, random, iyda._d());
        this._a(ozlu2, uken2, 8, 1, 1, 9, 1, 4, false, random, iyda._d());
        this._a(ozlu2, uken2, 1, 1, 1, 1, 1, 3, twgu.field_71944_C.field_71990_ca, twgu.field_71944_C.field_71990_ca, false);
        this._a(ozlu2, uken2, 9, 1, 1, 9, 1, 3, twgu.field_71944_C.field_71990_ca, twgu.field_71944_C.field_71990_ca, false);
        this._a(ozlu2, uken2, 3, 1, 8, 7, 1, 12, false, random, iyda._d());
        this._a(ozlu2, uken2, 4, 1, 9, 6, 1, 11, twgu.field_71944_C.field_71990_ca, twgu.field_71944_C.field_71990_ca, false);
        for (n2 = 3; n2 < 14; n2 += 2) {
            this._a(ozlu2, uken2, 0, 3, n2, 0, 4, n2, twgu.field_72002_bp.field_71990_ca, twgu.field_72002_bp.field_71990_ca, false);
            this._a(ozlu2, uken2, 10, 3, n2, 10, 4, n2, twgu.field_72002_bp.field_71990_ca, twgu.field_72002_bp.field_71990_ca, false);
        }
        for (n2 = 2; n2 < 9; n2 += 2) {
            this._a(ozlu2, uken2, n2, 3, 15, n2, 4, 15, twgu.field_72002_bp.field_71990_ca, twgu.field_72002_bp.field_71990_ca, false);
        }
        n2 = this._e(twgu.field_71995_bx.field_71990_ca, 3);
        this._a(ozlu2, uken2, 4, 1, 5, 6, 1, 7, false, random, iyda._d());
        this._a(ozlu2, uken2, 4, 2, 6, 6, 2, 7, false, random, iyda._d());
        this._a(ozlu2, uken2, 4, 3, 7, 6, 3, 7, false, random, iyda._d());
        for (n = 4; n <= 6; ++n) {
            this._a(ozlu2, twgu.field_71995_bx.field_71990_ca, n2, n, 1, 4, uken2);
            this._a(ozlu2, twgu.field_71995_bx.field_71990_ca, n2, n, 2, 5, uken2);
            this._a(ozlu2, twgu.field_71995_bx.field_71990_ca, n2, n, 3, 6, uken2);
        }
        n = 2;
        int n4 = 0;
        int n5 = 3;
        int n6 = 1;
        switch (this._n) {
            case 0: {
                n = 0;
                n4 = 2;
                break;
            }
            case 3: {
                n = 3;
                n4 = 1;
                n5 = 0;
                n6 = 2;
                break;
            }
            case 1: {
                n = 1;
                n4 = 3;
                n5 = 0;
                n6 = 2;
            }
        }
        this._a(ozlu2, twgu.field_72104_bI.field_71990_ca, n + (random.nextFloat() > 0.9f ? 4 : 0), 4, 3, 8, uken2);
        this._a(ozlu2, twgu.field_72104_bI.field_71990_ca, n + (random.nextFloat() > 0.9f ? 4 : 0), 5, 3, 8, uken2);
        this._a(ozlu2, twgu.field_72104_bI.field_71990_ca, n + (random.nextFloat() > 0.9f ? 4 : 0), 6, 3, 8, uken2);
        this._a(ozlu2, twgu.field_72104_bI.field_71990_ca, n4 + (random.nextFloat() > 0.9f ? 4 : 0), 4, 3, 12, uken2);
        this._a(ozlu2, twgu.field_72104_bI.field_71990_ca, n4 + (random.nextFloat() > 0.9f ? 4 : 0), 5, 3, 12, uken2);
        this._a(ozlu2, twgu.field_72104_bI.field_71990_ca, n4 + (random.nextFloat() > 0.9f ? 4 : 0), 6, 3, 12, uken2);
        this._a(ozlu2, twgu.field_72104_bI.field_71990_ca, n5 + (random.nextFloat() > 0.9f ? 4 : 0), 3, 3, 9, uken2);
        this._a(ozlu2, twgu.field_72104_bI.field_71990_ca, n5 + (random.nextFloat() > 0.9f ? 4 : 0), 3, 3, 10, uken2);
        this._a(ozlu2, twgu.field_72104_bI.field_71990_ca, n5 + (random.nextFloat() > 0.9f ? 4 : 0), 3, 3, 11, uken2);
        this._a(ozlu2, twgu.field_72104_bI.field_71990_ca, n6 + (random.nextFloat() > 0.9f ? 4 : 0), 7, 3, 9, uken2);
        this._a(ozlu2, twgu.field_72104_bI.field_71990_ca, n6 + (random.nextFloat() > 0.9f ? 4 : 0), 7, 3, 10, uken2);
        this._a(ozlu2, twgu.field_72104_bI.field_71990_ca, n6 + (random.nextFloat() > 0.9f ? 4 : 0), 7, 3, 11, uken2);
        if (!this._b) {
            int n7;
            n3 = this._b(3);
            int n8 = this._c(5, 6);
            if (uken2._b(n8, n3, n7 = this._d(5, 6))) {
                this._b = true;
                ozlu2.func_72832_d(n8, n3, n7, twgu.field_72065_as.field_71990_ca, 0, 2);
                xtcq xtcq2 = (xtcq)ozlu2.func_72796_p(n8, n3, n7);
                if (xtcq2 != null) {
                    xtcq2._a()._a("Silverfish");
                }
            }
        }
        return true;
    }
}

