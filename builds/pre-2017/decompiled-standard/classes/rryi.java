/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class rryi
extends cfof {
    public rryi() {
    }

    public rryi(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._a = this._a(random);
        this._m = uken2;
    }

    @Override
    public void _a(zztd zztd2, List list2, Random random) {
        this._a((xciz)zztd2, list2, random, 1, 1);
    }

    public static rryi _a(List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, -7, 0, 5, 11, 8, n4);
        if (!rryi._a(uken2) || zztd._a(list2, uken2) != null) {
            return null;
        }
        return new rryi(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        if (this._b(ozlu2, uken2)) {
            return false;
        }
        this._a(ozlu2, uken2, 0, 0, 0, 4, 10, 7, true, random, iyda._d());
        this._a(ozlu2, random, uken2, this._a, 1, 7, 0);
        this._a(ozlu2, random, uken2, nwns._a, 1, 1, 7);
        int n = this._e(twgu.field_72057_aH.field_71990_ca, 2);
        for (int i = 0; i < 6; ++i) {
            this._a(ozlu2, twgu.field_72057_aH.field_71990_ca, n, 1, 6 - i, 1 + i, uken2);
            this._a(ozlu2, twgu.field_72057_aH.field_71990_ca, n, 2, 6 - i, 1 + i, uken2);
            this._a(ozlu2, twgu.field_72057_aH.field_71990_ca, n, 3, 6 - i, 1 + i, uken2);
            if (i >= 5) continue;
            this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 1, 5 - i, 1 + i, uken2);
            this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 2, 5 - i, 1 + i, uken2);
            this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 3, 5 - i, 1 + i, uken2);
        }
        return true;
    }
}

