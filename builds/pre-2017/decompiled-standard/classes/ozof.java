/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class ozof
extends diqv {
    public ozof() {
    }

    public ozof(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    @Override
    public void _a(zztd zztd2, List list, Random random) {
        this._a((ozrz)zztd2, list, random, 2, 0, false);
        this._b((ozrz)zztd2, list, random, 0, 2, false);
        this._c((ozrz)zztd2, list, random, 0, 2, false);
    }

    public static ozof _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -2, 0, 0, 7, 9, 7, n4);
        if (!ozof._a(uken2) || zztd._a(list, uken2) != null) {
            return null;
        }
        return new ozof(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        this._a(ozlu2, uken2, 0, 0, 0, 6, 1, 6, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 2, 0, 6, 7, 6, 0, 0, false);
        this._a(ozlu2, uken2, 0, 2, 0, 1, 6, 0, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 2, 6, 1, 6, 6, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 5, 2, 0, 6, 6, 0, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 5, 2, 6, 6, 6, 6, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 2, 0, 0, 6, 1, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 2, 5, 0, 6, 6, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 6, 2, 0, 6, 6, 1, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 6, 2, 5, 6, 6, 6, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 2, 6, 0, 4, 6, 0, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 2, 5, 0, 4, 5, 0, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 2, 6, 6, 4, 6, 6, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 2, 5, 6, 4, 5, 6, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 6, 2, 0, 6, 4, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 5, 2, 0, 5, 4, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 6, 6, 2, 6, 6, 4, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 6, 5, 2, 6, 5, 4, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        for (int i = 0; i <= 6; ++i) {
            for (int j = 0; j <= 6; ++j) {
                this._b(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, i, -1, j, uken2);
            }
        }
        return true;
    }
}

