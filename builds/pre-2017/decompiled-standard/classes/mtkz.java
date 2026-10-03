/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class mtkz
extends cfof {
    public boolean _b;
    public boolean _c;

    public mtkz() {
    }

    public mtkz(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._a = this._a(random);
        this._m = uken2;
        this._b = random.nextInt(2) == 0;
        this._c = random.nextInt(2) == 0;
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("Left", this._b);
        qoac2._a("Right", this._c);
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._b = qoac2._o("Left");
        this._c = qoac2._o("Right");
    }

    @Override
    public void _a(zztd zztd2, List list, Random random) {
        this._a((xciz)zztd2, list, random, 1, 1);
        if (this._b) {
            this._b((xciz)zztd2, list, random, 1, 2);
        }
        if (this._c) {
            this._c((xciz)zztd2, list, random, 1, 2);
        }
    }

    public static mtkz _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, -1, 0, 5, 5, 7, n4);
        if (!mtkz._a(uken2) || zztd._a(list, uken2) != null) {
            return null;
        }
        return new mtkz(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        if (this._b(ozlu2, uken2)) {
            return false;
        }
        this._a(ozlu2, uken2, 0, 0, 0, 4, 4, 6, true, random, iyda._d());
        this._a(ozlu2, random, uken2, this._a, 1, 1, 0);
        this._a(ozlu2, random, uken2, nwns._a, 1, 1, 6);
        this._a(ozlu2, uken2, random, 0.1f, 1, 2, 1, twgu.field_72069_aq.field_71990_ca, 0);
        this._a(ozlu2, uken2, random, 0.1f, 3, 2, 1, twgu.field_72069_aq.field_71990_ca, 0);
        this._a(ozlu2, uken2, random, 0.1f, 1, 2, 5, twgu.field_72069_aq.field_71990_ca, 0);
        this._a(ozlu2, uken2, random, 0.1f, 3, 2, 5, twgu.field_72069_aq.field_71990_ca, 0);
        if (this._b) {
            this._a(ozlu2, uken2, 0, 1, 2, 0, 3, 4, 0, 0, false);
        }
        if (this._c) {
            this._a(ozlu2, uken2, 4, 1, 2, 4, 3, 4, 0, 0, false);
        }
        return true;
    }
}

