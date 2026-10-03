/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class mcgx
extends diqv {
    public mcgx() {
    }

    public mcgx(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    @Override
    public void _a(zztd zztd2, List list, Random random) {
        int n = 1;
        if (this._n == 1 || this._n == 2) {
            n = 5;
        }
        this._b((ozrz)zztd2, list, random, 0, n, random.nextInt(8) > 0);
        this._c((ozrz)zztd2, list, random, 0, n, random.nextInt(8) > 0);
    }

    public static mcgx _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -3, 0, 0, 9, 7, 9, n4);
        if (!mcgx._a(uken2) || zztd._a(list, uken2) != null) {
            return null;
        }
        return new mcgx(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        this._a(ozlu2, uken2, 0, 0, 0, 8, 1, 8, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 2, 0, 8, 5, 8, 0, 0, false);
        this._a(ozlu2, uken2, 0, 6, 0, 8, 6, 5, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 2, 0, 2, 5, 0, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 6, 2, 0, 8, 5, 0, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 3, 0, 1, 4, 0, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 7, 3, 0, 7, 4, 0, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 2, 4, 8, 2, 8, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 1, 4, 2, 2, 4, 0, 0, false);
        this._a(ozlu2, uken2, 6, 1, 4, 7, 2, 4, 0, 0, false);
        this._a(ozlu2, uken2, 0, 3, 8, 8, 3, 8, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 3, 6, 0, 3, 7, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 8, 3, 6, 8, 3, 7, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 3, 4, 0, 5, 5, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 8, 3, 4, 8, 5, 5, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 3, 5, 2, 5, 5, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 6, 3, 5, 7, 5, 5, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 4, 5, 1, 5, 5, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 7, 4, 5, 7, 5, 5, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        for (int i = 0; i <= 5; ++i) {
            for (int j = 0; j <= 8; ++j) {
                this._b(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, j, -1, i, uken2);
            }
        }
        return true;
    }
}

