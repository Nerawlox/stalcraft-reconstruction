/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class rrvv
extends diqv {
    public rrvv() {
    }

    public rrvv(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    @Override
    public void _a(zztd zztd2, List list2, Random random) {
        this._a((ozrz)zztd2, list2, random, 1, 0, true);
    }

    public static rrvv _a(List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, 0, 0, 5, 7, 5, n4);
        if (!rrvv._a(uken2) || zztd._a(list2, uken2) != null) {
            return null;
        }
        return new rrvv(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        this._a(ozlu2, uken2, 0, 0, 0, 4, 1, 4, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 2, 0, 4, 5, 4, 0, 0, false);
        this._a(ozlu2, uken2, 0, 2, 0, 0, 5, 4, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 4, 2, 0, 4, 5, 4, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 3, 1, 0, 4, 1, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 3, 3, 0, 4, 3, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 4, 3, 1, 4, 4, 1, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 4, 3, 3, 4, 4, 3, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 6, 0, 4, 6, 4, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        for (int i = 0; i <= 4; ++i) {
            for (int j = 0; j <= 4; ++j) {
                this._b(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, i, -1, j, uken2);
            }
        }
        return true;
    }
}

