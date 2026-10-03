/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class plqt
extends zztd {
    public int _a;
    public boolean _b;

    public plqt() {
    }

    @Override
    public void _a(qoac qoac2) {
        qoac2._a("tf", this._b);
        qoac2._a("D", this._a);
    }

    @Override
    public void _b(qoac qoac2) {
        this._b = qoac2._o("tf");
        this._a = qoac2._f("D");
    }

    public plqt(int n, Random random, uken uken2, int n2) {
        super(n);
        this._a = n2;
        this._m = uken2;
        this._b = uken2._c() > 3;
    }

    public static uken _a(List list2, Random random, int n, int n2, int n3, int n4) {
        uken uken2 = new uken(n, n2, n3, n, n2 + 2, n3);
        if (random.nextInt(4) == 0) {
            uken2._e += 4;
        }
        switch (n4) {
            case 2: {
                uken2._a = n - 1;
                uken2._d = n + 3;
                uken2._c = n3 - 4;
                break;
            }
            case 0: {
                uken2._a = n - 1;
                uken2._d = n + 3;
                uken2._f = n3 + 4;
                break;
            }
            case 1: {
                uken2._a = n - 4;
                uken2._c = n3 - 1;
                uken2._f = n3 + 3;
                break;
            }
            case 3: {
                uken2._d = n + 4;
                uken2._c = n3 - 1;
                uken2._f = n3 + 3;
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
        switch (this._a) {
            case 2: {
                mtob._b(zztd2, list2, random, this._m._a + 1, this._m._b, this._m._c - 1, 2, n);
                mtob._b(zztd2, list2, random, this._m._a - 1, this._m._b, this._m._c + 1, 1, n);
                mtob._b(zztd2, list2, random, this._m._d + 1, this._m._b, this._m._c + 1, 3, n);
                break;
            }
            case 0: {
                mtob._b(zztd2, list2, random, this._m._a + 1, this._m._b, this._m._f + 1, 0, n);
                mtob._b(zztd2, list2, random, this._m._a - 1, this._m._b, this._m._c + 1, 1, n);
                mtob._b(zztd2, list2, random, this._m._d + 1, this._m._b, this._m._c + 1, 3, n);
                break;
            }
            case 1: {
                mtob._b(zztd2, list2, random, this._m._a + 1, this._m._b, this._m._c - 1, 2, n);
                mtob._b(zztd2, list2, random, this._m._a + 1, this._m._b, this._m._f + 1, 0, n);
                mtob._b(zztd2, list2, random, this._m._a - 1, this._m._b, this._m._c + 1, 1, n);
                break;
            }
            case 3: {
                mtob._b(zztd2, list2, random, this._m._a + 1, this._m._b, this._m._c - 1, 2, n);
                mtob._b(zztd2, list2, random, this._m._a + 1, this._m._b, this._m._f + 1, 0, n);
                mtob._b(zztd2, list2, random, this._m._d + 1, this._m._b, this._m._c + 1, 3, n);
            }
        }
        if (this._b) {
            if (random.nextBoolean()) {
                mtob._b(zztd2, list2, random, this._m._a + 1, this._m._b + 3 + 1, this._m._c - 1, 2, n);
            }
            if (random.nextBoolean()) {
                mtob._b(zztd2, list2, random, this._m._a - 1, this._m._b + 3 + 1, this._m._c + 1, 1, n);
            }
            if (random.nextBoolean()) {
                mtob._b(zztd2, list2, random, this._m._d + 1, this._m._b + 3 + 1, this._m._c + 1, 3, n);
            }
            if (random.nextBoolean()) {
                mtob._b(zztd2, list2, random, this._m._a + 1, this._m._b + 3 + 1, this._m._f + 1, 0, n);
            }
        }
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        if (this._b(ozlu2, uken2)) {
            return false;
        }
        if (this._b) {
            this._a(ozlu2, uken2, this._m._a + 1, this._m._b, this._m._c, this._m._d - 1, this._m._b + 3 - 1, this._m._f, 0, 0, false);
            this._a(ozlu2, uken2, this._m._a, this._m._b, this._m._c + 1, this._m._d, this._m._b + 3 - 1, this._m._f - 1, 0, 0, false);
            this._a(ozlu2, uken2, this._m._a + 1, this._m._e - 2, this._m._c, this._m._d - 1, this._m._e, this._m._f, 0, 0, false);
            this._a(ozlu2, uken2, this._m._a, this._m._e - 2, this._m._c + 1, this._m._d, this._m._e, this._m._f - 1, 0, 0, false);
            this._a(ozlu2, uken2, this._m._a + 1, this._m._b + 3, this._m._c + 1, this._m._d - 1, this._m._b + 3, this._m._f - 1, 0, 0, false);
        } else {
            this._a(ozlu2, uken2, this._m._a + 1, this._m._b, this._m._c, this._m._d - 1, this._m._e, this._m._f, 0, 0, false);
            this._a(ozlu2, uken2, this._m._a, this._m._b, this._m._c + 1, this._m._d, this._m._e, this._m._f - 1, 0, 0, false);
        }
        this._a(ozlu2, uken2, this._m._a + 1, this._m._b, this._m._c + 1, this._m._a + 1, this._m._e, this._m._c + 1, twgu.field_71988_x.field_71990_ca, 0, false);
        this._a(ozlu2, uken2, this._m._a + 1, this._m._b, this._m._f - 1, this._m._a + 1, this._m._e, this._m._f - 1, twgu.field_71988_x.field_71990_ca, 0, false);
        this._a(ozlu2, uken2, this._m._d - 1, this._m._b, this._m._c + 1, this._m._d - 1, this._m._e, this._m._c + 1, twgu.field_71988_x.field_71990_ca, 0, false);
        this._a(ozlu2, uken2, this._m._d - 1, this._m._b, this._m._f - 1, this._m._d - 1, this._m._e, this._m._f - 1, twgu.field_71988_x.field_71990_ca, 0, false);
        for (int i = this._m._a; i <= this._m._d; ++i) {
            for (int j = this._m._c; j <= this._m._f; ++j) {
                int n = this._a(ozlu2, i, this._m._b - 1, j, uken2);
                if (n != 0) continue;
                this._a(ozlu2, twgu.field_71988_x.field_71990_ca, 0, i, this._m._b - 1, j, uken2);
            }
        }
        return true;
    }
}

