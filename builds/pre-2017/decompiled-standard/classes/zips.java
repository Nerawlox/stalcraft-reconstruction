/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class zips
extends diqv {
    public boolean _a;

    public zips() {
    }

    public zips(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._a = qoac2._o("Mob");
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("Mob", this._a);
    }

    public static zips _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -2, 0, 0, 7, 8, 9, n4);
        if (!zips._a(uken2) || zztd._a(list, uken2) != null) {
            return null;
        }
        return new zips(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        int n;
        int n2;
        this._a(ozlu2, uken2, 0, 2, 0, 6, 7, 7, 0, 0, false);
        this._a(ozlu2, uken2, 1, 0, 0, 5, 1, 7, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 2, 1, 5, 2, 7, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 3, 2, 5, 3, 7, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 4, 3, 5, 4, 7, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 2, 0, 1, 4, 2, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 5, 2, 0, 5, 4, 2, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 5, 2, 1, 5, 3, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 5, 5, 2, 5, 5, 3, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 5, 3, 0, 5, 8, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 6, 5, 3, 6, 5, 8, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 5, 8, 5, 5, 8, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, twgu.field_72098_bB.field_71990_ca, 0, 1, 6, 3, uken2);
        this._a(ozlu2, twgu.field_72098_bB.field_71990_ca, 0, 5, 6, 3, uken2);
        this._a(ozlu2, uken2, 0, 6, 3, 0, 6, 8, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 6, 6, 3, 6, 6, 8, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 6, 8, 5, 7, 8, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 2, 8, 8, 4, 8, 8, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        if (!this._a) {
            int n3;
            n2 = this._b(5);
            n = this._c(3, 5);
            if (uken2._b(n, n2, n3 = this._d(3, 5))) {
                this._a = true;
                ozlu2.func_72832_d(n, n2, n3, twgu.field_72065_as.field_71990_ca, 0, 2);
                xtcq xtcq2 = (xtcq)ozlu2.func_72796_p(n, n2, n3);
                if (xtcq2 != null) {
                    xtcq2._a()._a("Blaze");
                }
            }
        }
        for (n2 = 0; n2 <= 6; ++n2) {
            for (n = 0; n <= 6; ++n) {
                this._b(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, n2, -1, n, uken2);
            }
        }
        return true;
    }
}

