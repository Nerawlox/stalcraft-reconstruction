/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class vnce
extends zztd {
    public vnce() {
    }

    public vnce(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    @Override
    public void _a(qoac qoac2) {
    }

    @Override
    public void _b(qoac qoac2) {
    }

    public static uken _a(List list2, Random random, int n, int n2, int n3, int n4) {
        uken uken2 = new uken(n, n2 - 5, n3, n, n2 + 2, n3);
        switch (n4) {
            case 2: {
                uken2._d = n + 2;
                uken2._c = n3 - 8;
                break;
            }
            case 0: {
                uken2._d = n + 2;
                uken2._f = n3 + 8;
                break;
            }
            case 1: {
                uken2._a = n - 8;
                uken2._f = n3 + 2;
                break;
            }
            case 3: {
                uken2._d = n + 8;
                uken2._f = n3 + 2;
            }
        }
        if (zztd._a(list2, uken2) != null) {
            return null;
        }
        return uken2;
    }

    @Override
    public void _a(zztd zztd2, List list2, Random random) {
        int n = this._e();
        switch (this._n) {
            case 2: {
                mtob._b(zztd2, list2, random, this._m._a, this._m._b, this._m._c - 1, 2, n);
                break;
            }
            case 0: {
                mtob._b(zztd2, list2, random, this._m._a, this._m._b, this._m._f + 1, 0, n);
                break;
            }
            case 1: {
                mtob._b(zztd2, list2, random, this._m._a - 1, this._m._b, this._m._c, 1, n);
                break;
            }
            case 3: {
                mtob._b(zztd2, list2, random, this._m._d + 1, this._m._b, this._m._c, 3, n);
            }
        }
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        if (this._b(ozlu2, uken2)) {
            return false;
        }
        this._a(ozlu2, uken2, 0, 5, 0, 2, 7, 1, 0, 0, false);
        this._a(ozlu2, uken2, 0, 0, 7, 2, 2, 8, 0, 0, false);
        for (int i = 0; i < 5; ++i) {
            this._a(ozlu2, uken2, 0, 5 - i - (i < 4 ? 1 : 0), 2 + i, 2, 7 - i, 2 + i, 0, 0, false);
        }
        return true;
    }
}

