/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class vnea
extends cfof {
    public boolean _b;

    public vnea() {
    }

    public vnea(int n, Random random, int n2, int n3) {
        super(n);
        this._b = true;
        this._n = random.nextInt(4);
        this._a = nwns._a;
        switch (this._n) {
            case 0: 
            case 2: {
                this._m = new uken(n2, 64, n3, n2 + 5 - 1, 74, n3 + 5 - 1);
                break;
            }
            default: {
                this._m = new uken(n2, 64, n3, n2 + 5 - 1, 74, n3 + 5 - 1);
            }
        }
    }

    public vnea(int n, Random random, uken uken2, int n2) {
        super(n);
        this._b = false;
        this._n = n2;
        this._a = this._a(random);
        this._m = uken2;
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("Source", this._b);
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._b = qoac2._o("Source");
    }

    @Override
    public void _a(zztd zztd2, List list, Random random) {
        if (this._b) {
            iyda._a(btmr.class);
        }
        this._a((xciz)zztd2, list, random, 1, 1);
    }

    public static vnea _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, -7, 0, 5, 11, 5, n4);
        if (!vnea._a(uken2) || zztd._a(list, uken2) != null) {
            return null;
        }
        return new vnea(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        if (this._b(ozlu2, uken2)) {
            return false;
        }
        this._a(ozlu2, uken2, 0, 0, 0, 4, 10, 4, true, random, iyda._d());
        this._a(ozlu2, random, uken2, this._a, 1, 7, 0);
        this._a(ozlu2, random, uken2, nwns._a, 1, 1, 4);
        this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 2, 6, 1, uken2);
        this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 1, 5, 1, uken2);
        this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 0, 1, 6, 1, uken2);
        this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 1, 5, 2, uken2);
        this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 1, 4, 3, uken2);
        this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 0, 1, 5, 3, uken2);
        this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 2, 4, 3, uken2);
        this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 3, 3, 3, uken2);
        this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 0, 3, 4, 3, uken2);
        this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 3, 3, 2, uken2);
        this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 3, 2, 1, uken2);
        this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 0, 3, 3, 1, uken2);
        this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 2, 2, 1, uken2);
        this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 1, 1, 1, uken2);
        this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 0, 1, 2, 1, uken2);
        this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 1, 1, 2, uken2);
        this._a(ozlu2, twgu.field_72079_ak.field_71990_ca, 0, 1, 1, 3, uken2);
        return true;
    }
}

