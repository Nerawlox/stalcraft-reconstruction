/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class ywkp
extends diqv {
    public ywkp() {
    }

    public ywkp(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    @Override
    public void _a(zztd zztd2, List list2, Random random) {
        this._a((ozrz)zztd2, list2, random, 5, 3, true);
    }

    public static ywkp _a(List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -5, -3, 0, 13, 14, 13, n4);
        if (!ywkp._a(uken2) || zztd._a(list2, uken2) != null) {
            return null;
        }
        return new ywkp(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        int n;
        int n2;
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
        this._a(ozlu2, uken2, 5, 8, 0, 7, 8, 0, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        for (n2 = 1; n2 <= 11; n2 += 2) {
            this._a(ozlu2, uken2, n2, 10, 0, n2, 11, 0, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
            this._a(ozlu2, uken2, n2, 10, 12, n2, 11, 12, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
            this._a(ozlu2, uken2, 0, 10, n2, 0, 11, n2, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
            this._a(ozlu2, uken2, 12, 10, n2, 12, 11, n2, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
            this._a(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, n2, 13, 0, uken2);
            this._a(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, n2, 13, 12, uken2);
            this._a(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, 0, 13, n2, uken2);
            this._a(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, 12, 13, n2, uken2);
            this._a(ozlu2, twgu.field_72098_bB.field_71990_ca, 0, n2 + 1, 13, 0, uken2);
            this._a(ozlu2, twgu.field_72098_bB.field_71990_ca, 0, n2 + 1, 13, 12, uken2);
            this._a(ozlu2, twgu.field_72098_bB.field_71990_ca, 0, 0, 13, n2 + 1, uken2);
            this._a(ozlu2, twgu.field_72098_bB.field_71990_ca, 0, 12, 13, n2 + 1, uken2);
        }
        this._a(ozlu2, twgu.field_72098_bB.field_71990_ca, 0, 0, 13, 0, uken2);
        this._a(ozlu2, twgu.field_72098_bB.field_71990_ca, 0, 0, 13, 12, uken2);
        this._a(ozlu2, twgu.field_72098_bB.field_71990_ca, 0, 0, 13, 0, uken2);
        this._a(ozlu2, twgu.field_72098_bB.field_71990_ca, 0, 12, 13, 0, uken2);
        for (n2 = 3; n2 <= 9; n2 += 2) {
            this._a(ozlu2, uken2, 1, 7, n2, 1, 8, n2, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
            this._a(ozlu2, uken2, 11, 7, n2, 11, 8, n2, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        }
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
        this._a(ozlu2, uken2, 5, 5, 5, 7, 5, 7, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 6, 1, 6, 6, 4, 6, 0, 0, false);
        this._a(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, 6, 0, 6, uken2);
        this._a(ozlu2, twgu.field_71944_C.field_71990_ca, 0, 6, 5, 6, uken2);
        n2 = this._c(6, 6);
        n = this._b(5);
        int n3 = this._d(6, 6);
        if (uken2._b(n2, n, n3)) {
            ozlu2.field_72999_e = true;
            twgu.field_71973_m[twgu.field_71944_C.field_71990_ca].func_71847_b(ozlu2, n2, n, n3, random);
            ozlu2.field_72999_e = false;
        }
        return true;
    }
}

