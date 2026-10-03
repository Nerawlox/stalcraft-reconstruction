/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class grzx
extends cfof {
    public int _b;

    public grzx() {
    }

    public grzx(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
        this._b = n2 == 2 || n2 == 0 ? uken2._d() : uken2._b();
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("Steps", this._b);
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._b = qoac2._f("Steps");
    }

    public static uken _a(List list, Random random, int n, int n2, int n3, int n4) {
        int n5 = 3;
        uken uken2 = uken._a(n, n2, n3, -1, -1, 0, 5, 5, 4, n4);
        zztd zztd2 = zztd._a(list, uken2);
        if (zztd2 == null) {
            return null;
        }
        if (zztd2._d()._b == uken2._b) {
            for (int i = 3; i >= 1; --i) {
                uken2 = uken._a(n, n2, n3, -1, -1, 0, 5, 5, i - 1, n4);
                if (zztd2._d()._a(uken2)) continue;
                return uken._a(n, n2, n3, -1, -1, 0, 5, 5, i, n4);
            }
        }
        return null;
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        if (this._b(ozlu2, uken2)) {
            return false;
        }
        for (int i = 0; i < this._b; ++i) {
            this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 0, 0, i, uken2);
            this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 1, 0, i, uken2);
            this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 2, 0, i, uken2);
            this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 3, 0, i, uken2);
            this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 4, 0, i, uken2);
            for (int j = 1; j <= 3; ++j) {
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 0, j, i, uken2);
                this._a(ozlu2, 0, 0, 1, j, i, uken2);
                this._a(ozlu2, 0, 0, 2, j, i, uken2);
                this._a(ozlu2, 0, 0, 3, j, i, uken2);
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 4, j, i, uken2);
            }
            this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 0, 4, i, uken2);
            this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 1, 4, i, uken2);
            this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 2, 4, i, uken2);
            this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 3, 4, i, uken2);
            this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, 4, 4, i, uken2);
        }
        return true;
    }
}

