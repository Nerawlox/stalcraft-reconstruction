/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class btmr
extends cfof {
    public boolean _b;
    public boolean _c;
    public boolean _d;
    public boolean _e;

    public btmr() {
    }

    public btmr(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._a = this._a(random);
        this._m = uken2;
        this._b = random.nextBoolean();
        this._c = random.nextBoolean();
        this._d = random.nextBoolean();
        this._e = random.nextInt(3) > 0;
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("leftLow", this._b);
        qoac2._a("leftHigh", this._c);
        qoac2._a("rightLow", this._d);
        qoac2._a("rightHigh", this._e);
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._b = qoac2._o("leftLow");
        this._c = qoac2._o("leftHigh");
        this._d = qoac2._o("rightLow");
        this._e = qoac2._o("rightHigh");
    }

    @Override
    public void _a(zztd zztd2, List list, Random random) {
        int n = 3;
        int n2 = 5;
        if (this._n == 1 || this._n == 2) {
            n = 8 - n;
            n2 = 8 - n2;
        }
        this._a((xciz)zztd2, list, random, 5, 1);
        if (this._b) {
            this._b((xciz)zztd2, list, random, n, 1);
        }
        if (this._c) {
            this._b((xciz)zztd2, list, random, n2, 7);
        }
        if (this._d) {
            this._c((xciz)zztd2, list, random, n, 1);
        }
        if (this._e) {
            this._c((xciz)zztd2, list, random, n2, 7);
        }
    }

    public static btmr _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -4, -3, 0, 10, 9, 11, n4);
        if (!btmr._a(uken2) || zztd._a(list, uken2) != null) {
            return null;
        }
        return new btmr(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        if (this._b(ozlu2, uken2)) {
            return false;
        }
        this._a(ozlu2, uken2, 0, 0, 0, 9, 8, 10, true, random, iyda._d());
        this._a(ozlu2, random, uken2, this._a, 4, 3, 0);
        if (this._b) {
            this._a(ozlu2, uken2, 0, 3, 1, 0, 5, 3, 0, 0, false);
        }
        if (this._d) {
            this._a(ozlu2, uken2, 9, 3, 1, 9, 5, 3, 0, 0, false);
        }
        if (this._c) {
            this._a(ozlu2, uken2, 0, 5, 7, 0, 7, 9, 0, 0, false);
        }
        if (this._e) {
            this._a(ozlu2, uken2, 9, 5, 7, 9, 7, 9, 0, 0, false);
        }
        this._a(ozlu2, uken2, 5, 1, 10, 7, 3, 10, 0, 0, false);
        this._a(ozlu2, uken2, 1, 2, 1, 8, 2, 6, false, random, iyda._d());
        this._a(ozlu2, uken2, 4, 1, 5, 4, 4, 9, false, random, iyda._d());
        this._a(ozlu2, uken2, 8, 1, 5, 8, 4, 9, false, random, iyda._d());
        this._a(ozlu2, uken2, 1, 4, 7, 3, 4, 9, false, random, iyda._d());
        this._a(ozlu2, uken2, 1, 3, 5, 3, 3, 6, false, random, iyda._d());
        this._a(ozlu2, uken2, 1, 3, 4, 3, 3, 4, twgu.field_72079_ak.field_71990_ca, twgu.field_72079_ak.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 4, 6, 3, 4, 6, twgu.field_72079_ak.field_71990_ca, twgu.field_72079_ak.field_71990_ca, false);
        this._a(ozlu2, uken2, 5, 1, 7, 7, 1, 8, false, random, iyda._d());
        this._a(ozlu2, uken2, 5, 1, 9, 7, 1, 9, twgu.field_72079_ak.field_71990_ca, twgu.field_72079_ak.field_71990_ca, false);
        this._a(ozlu2, uken2, 5, 2, 7, 7, 2, 7, twgu.field_72079_ak.field_71990_ca, twgu.field_72079_ak.field_71990_ca, false);
        this._a(ozlu2, uken2, 4, 5, 7, 4, 5, 9, twgu.field_72079_ak.field_71990_ca, twgu.field_72079_ak.field_71990_ca, false);
        this._a(ozlu2, uken2, 8, 5, 7, 8, 5, 9, twgu.field_72079_ak.field_71990_ca, twgu.field_72079_ak.field_71990_ca, false);
        this._a(ozlu2, uken2, 5, 5, 7, 7, 5, 9, twgu.field_72085_aj.field_71990_ca, twgu.field_72085_aj.field_71990_ca, false);
        this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 6, 5, 6, uken2);
        return true;
    }
}

