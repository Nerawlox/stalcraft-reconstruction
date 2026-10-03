/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class hdya
extends diqv {
    public hdya() {
    }

    public hdya(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    @Override
    public void _a(zztd zztd2, List list2, Random random) {
        this._a((ozrz)zztd2, list2, random, 1, 0, true);
    }

    public static hdya _a(List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, -7, 0, 5, 14, 10, n4);
        if (!hdya._a(uken2) || zztd._a(list2, uken2) != null) {
            return null;
        }
        return new hdya(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        int n = this._e(twgu.field_72100_bC.field_71990_ca, 2);
        for (int i = 0; i <= 9; ++i) {
            int n2 = Math.max(1, 7 - i);
            int n3 = Math.min(Math.max(n2 + 5, 14 - i), 13);
            int n4 = i;
            this._a(ozlu2, uken2, 0, 0, n4, 4, n2, n4, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
            this._a(ozlu2, uken2, 1, n2 + 1, n4, 3, n3 - 1, n4, 0, 0, false);
            if (i <= 6) {
                this._a(ozlu2, twgu.field_72100_bC.field_71990_ca, n, 1, n2 + 1, n4, uken2);
                this._a(ozlu2, twgu.field_72100_bC.field_71990_ca, n, 2, n2 + 1, n4, uken2);
                this._a(ozlu2, twgu.field_72100_bC.field_71990_ca, n, 3, n2 + 1, n4, uken2);
            }
            this._a(ozlu2, uken2, 0, n3, n4, 4, n3, n4, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
            this._a(ozlu2, uken2, 0, n2 + 1, n4, 0, n3 - 1, n4, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
            this._a(ozlu2, uken2, 4, n2 + 1, n4, 4, n3 - 1, n4, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
            if ((i & 1) == 0) {
                this._a(ozlu2, uken2, 0, n2 + 2, n4, 0, n2 + 3, n4, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
                this._a(ozlu2, uken2, 4, n2 + 2, n4, 4, n2 + 3, n4, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
            }
            for (int j = 0; j <= 4; ++j) {
                this._b(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, j, -1, n4, uken2);
            }
        }
        return true;
    }
}

