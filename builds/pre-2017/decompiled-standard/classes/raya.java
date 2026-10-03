/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class raya
extends diqv {
    public raya() {
    }

    public raya(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    @Override
    public void _a(zztd zztd2, List list, Random random) {
        this._a((ozrz)zztd2, list, random, 5, 3, true);
        this._a((ozrz)zztd2, list, random, 5, 11, true);
    }

    public static raya _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -5, -3, 0, 13, 14, 13, n4);
        if (!raya._a(uken2) || zztd._a(list, uken2) != null) {
            return null;
        }
        return new raya(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        this._a(ozlu2, uken2, 0, 3, 0, 12, 4, 12, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 5, 0, 12, 13, 12, 0, 0, false);
        this._a(ozlu2, uken2, 0, 5, 0, 1, 12, 12, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 11, 5, 0, 12, 12, 12, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 2, 5, 11, 4, 12, 12, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 8, 5, 11, 10, 12, 12, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 5, 9, 11, 7, 12, 12, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 2, 5, 0, 4, 12, 1, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 8, 5, 0, 10, 12, 1, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 5, 9, 0, 7, 12, 1, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 2, 11, 2, 10, 12, 10, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        for (n5 = 1; n5 <= 11; n5 += 2) {
            this._a(ozlu2, uken2, n5, 10, 0, n5, 11, 0, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
            this._a(ozlu2, uken2, n5, 10, 12, n5, 11, 12, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
            this._a(ozlu2, uken2, 0, 10, n5, 0, 11, n5, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
            this._a(ozlu2, uken2, 12, 10, n5, 12, 11, n5, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
            this._a(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, n5, 13, 0, uken2);
            this._a(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, n5, 13, 12, uken2);
            this._a(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, 0, 13, n5, uken2);
            this._a(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, 12, 13, n5, uken2);
            this._a(ozlu2, twgu.field_72098_bB.field_71990_ca, 0, n5 + 1, 13, 0, uken2);
            this._a(ozlu2, twgu.field_72098_bB.field_71990_ca, 0, n5 + 1, 13, 12, uken2);
            this._a(ozlu2, twgu.field_72098_bB.field_71990_ca, 0, 0, 13, n5 + 1, uken2);
            this._a(ozlu2, twgu.field_72098_bB.field_71990_ca, 0, 12, 13, n5 + 1, uken2);
        }
        this._a(ozlu2, twgu.field_72098_bB.field_71990_ca, 0, 0, 13, 0, uken2);
        this._a(ozlu2, twgu.field_72098_bB.field_71990_ca, 0, 0, 13, 12, uken2);
        this._a(ozlu2, twgu.field_72098_bB.field_71990_ca, 0, 0, 13, 0, uken2);
        this._a(ozlu2, twgu.field_72098_bB.field_71990_ca, 0, 12, 13, 0, uken2);
        for (n5 = 3; n5 <= 9; n5 += 2) {
            this._a(ozlu2, uken2, 1, 7, n5, 1, 8, n5, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
            this._a(ozlu2, uken2, 11, 7, n5, 11, 8, n5, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        }
        n5 = this._e(twgu.field_72100_bC.field_71990_ca, 3);
        for (n4 = 0; n4 <= 6; ++n4) {
            n3 = n4 + 4;
            for (n2 = 5; n2 <= 7; ++n2) {
                this._a(ozlu2, twgu.field_72100_bC.field_71990_ca, n5, n2, 5 + n4, n3, uken2);
            }
            if (n3 >= 5 && n3 <= 8) {
                this._a(ozlu2, uken2, 5, 5, n3, 7, n4 + 4, n3, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
            } else if (n3 >= 9 && n3 <= 10) {
                this._a(ozlu2, uken2, 5, 8, n3, 7, n4 + 4, n3, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
            }
            if (n4 < 1) continue;
            this._a(ozlu2, uken2, 5, 6 + n4, n3, 7, 9 + n4, n3, 0, 0, false);
        }
        for (n4 = 5; n4 <= 7; ++n4) {
            this._a(ozlu2, twgu.field_72100_bC.field_71990_ca, n5, n4, 12, 11, uken2);
        }
        this._a(ozlu2, uken2, 5, 6, 7, 5, 7, 7, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 7, 6, 7, 7, 7, 7, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 5, 13, 12, 7, 13, 12, 0, 0, false);
        this._a(ozlu2, uken2, 2, 5, 2, 3, 5, 3, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 2, 5, 9, 3, 5, 10, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 2, 5, 4, 2, 5, 8, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 9, 5, 2, 10, 5, 3, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 9, 5, 9, 10, 5, 10, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 10, 5, 4, 10, 5, 8, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        n4 = this._e(twgu.field_72100_bC.field_71990_ca, 0);
        n3 = this._e(twgu.field_72100_bC.field_71990_ca, 1);
        this._a(ozlu2, twgu.field_72100_bC.field_71990_ca, n3, 4, 5, 2, uken2);
        this._a(ozlu2, twgu.field_72100_bC.field_71990_ca, n3, 4, 5, 3, uken2);
        this._a(ozlu2, twgu.field_72100_bC.field_71990_ca, n3, 4, 5, 9, uken2);
        this._a(ozlu2, twgu.field_72100_bC.field_71990_ca, n3, 4, 5, 10, uken2);
        this._a(ozlu2, twgu.field_72100_bC.field_71990_ca, n4, 8, 5, 2, uken2);
        this._a(ozlu2, twgu.field_72100_bC.field_71990_ca, n4, 8, 5, 3, uken2);
        this._a(ozlu2, twgu.field_72100_bC.field_71990_ca, n4, 8, 5, 9, uken2);
        this._a(ozlu2, twgu.field_72100_bC.field_71990_ca, n4, 8, 5, 10, uken2);
        this._a(ozlu2, uken2, 3, 4, 4, 4, 4, 8, twgu.field_72013_bc.field_71990_ca, twgu.field_72013_bc.field_71990_ca, false);
        this._a(ozlu2, uken2, 8, 4, 4, 9, 4, 8, twgu.field_72013_bc.field_71990_ca, twgu.field_72013_bc.field_71990_ca, false);
        this._a(ozlu2, uken2, 3, 5, 4, 4, 5, 8, twgu.field_72094_bD.field_71990_ca, twgu.field_72094_bD.field_71990_ca, false);
        this._a(ozlu2, uken2, 8, 5, 4, 9, 5, 8, twgu.field_72094_bD.field_71990_ca, twgu.field_72094_bD.field_71990_ca, false);
        this._a(ozlu2, uken2, 4, 2, 0, 8, 2, 12, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 2, 4, 12, 2, 8, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 4, 0, 0, 8, 1, 3, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 4, 0, 9, 8, 1, 12, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 0, 4, 3, 1, 8, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 9, 0, 4, 12, 1, 8, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        for (n2 = 4; n2 <= 8; ++n2) {
            for (n = 0; n <= 2; ++n) {
                this._b(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, n2, -1, n, uken2);
                this._b(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, n2, -1, 12 - n, uken2);
            }
        }
        for (n2 = 0; n2 <= 2; ++n2) {
            for (n = 4; n <= 8; ++n) {
                this._b(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, n2, -1, n, uken2);
                this._b(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, 12 - n2, -1, n, uken2);
            }
        }
        return true;
    }
}

