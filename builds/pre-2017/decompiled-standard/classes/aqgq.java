/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class aqgq
extends diqv {
    public aqgq() {
    }

    public aqgq(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    public aqgq(Random random, int n, int n2) {
        super(0);
        this._n = random.nextInt(4);
        switch (this._n) {
            case 0: 
            case 2: {
                this._m = new uken(n, 64, n2, n + 19 - 1, 73, n2 + 19 - 1);
                break;
            }
            default: {
                this._m = new uken(n, 64, n2, n + 19 - 1, 73, n2 + 19 - 1);
            }
        }
    }

    @Override
    public void _a(zztd zztd2, List list, Random random) {
        this._a((ozrz)zztd2, list, random, 8, 3, false);
        this._b((ozrz)zztd2, list, random, 3, 8, false);
        this._c((ozrz)zztd2, list, random, 3, 8, false);
    }

    public static aqgq _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -8, -3, 0, 19, 10, 19, n4);
        if (!aqgq._a(uken2) || zztd._a(list, uken2) != null) {
            return null;
        }
        return new aqgq(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        int n;
        int n2;
        this._a(ozlu2, uken2, 7, 3, 0, 11, 4, 18, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 3, 7, 18, 4, 11, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 8, 5, 0, 10, 7, 18, 0, 0, false);
        this._a(ozlu2, uken2, 0, 5, 8, 18, 7, 10, 0, 0, false);
        this._a(ozlu2, uken2, 7, 5, 0, 7, 5, 7, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 7, 5, 11, 7, 5, 18, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 11, 5, 0, 11, 5, 7, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 11, 5, 11, 11, 5, 18, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 5, 7, 7, 5, 7, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 11, 5, 7, 18, 5, 7, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 5, 11, 7, 5, 11, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 11, 5, 11, 18, 5, 11, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 7, 2, 0, 11, 2, 5, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 7, 2, 13, 11, 2, 18, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 7, 0, 0, 11, 1, 3, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 7, 0, 15, 11, 1, 18, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        for (n2 = 7; n2 <= 11; ++n2) {
            for (n = 0; n <= 2; ++n) {
                this._b(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, n2, -1, n, uken2);
                this._b(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, n2, -1, 18 - n, uken2);
            }
        }
        this._a(ozlu2, uken2, 0, 2, 7, 5, 2, 11, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 13, 2, 7, 18, 2, 11, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 0, 7, 3, 1, 11, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 15, 0, 7, 18, 1, 11, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        for (n2 = 0; n2 <= 2; ++n2) {
            for (n = 7; n <= 11; ++n) {
                this._b(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, n2, -1, n, uken2);
                this._b(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, 18 - n2, -1, n, uken2);
            }
        }
        return true;
    }
}

