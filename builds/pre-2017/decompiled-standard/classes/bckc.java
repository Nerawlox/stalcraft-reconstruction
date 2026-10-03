/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class bckc
extends lqhx {
    public bckc() {
    }

    public bckc(fovt fovt2, int n, Random random, uken uken2, int n2) {
        super(fovt2, n);
        this._n = n2;
        this._m = uken2;
    }

    public static uken _a(fovt fovt2, List list, Random random, int n, int n2, int n3, int n4) {
        uken uken2 = uken._a(n, n2, n3, 0, 0, 0, 3, 4, 2, n4);
        if (zztd._a(list, uken2) != null) {
            return null;
        }
        return uken2;
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        if (this._a < 0) {
            this._a = this._a(ozlu2, uken2);
            if (this._a < 0) {
                return true;
            }
            this._m._a(0, this._a - this._m._e + 4 - 1, 0);
        }
        this._a(ozlu2, uken2, 0, 0, 0, 2, 3, 1, 0, 0, false);
        this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 1, 0, 0, uken2);
        this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 1, 1, 0, uken2);
        this._a(ozlu2, twgu.field_72031_aZ.field_71990_ca, 0, 1, 2, 0, uken2);
        this._a(ozlu2, twgu.field_72101_ab.field_71990_ca, 15, 1, 3, 0, uken2);
        this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 0, 3, 0, uken2);
        this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 1, 3, 1, uken2);
        this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 2, 3, 0, uken2);
        this._a(ozlu2, twgu.field_72069_aq.field_71990_ca, 0, 1, 3, -1, uken2);
        return true;
    }
}

