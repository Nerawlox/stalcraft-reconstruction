/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class dzoy
extends diqv {
    public boolean _a;

    public dzoy() {
    }

    public dzoy(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
        this._a = random.nextInt(3) == 0;
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._a = qoac2._o("Chest");
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("Chest", this._a);
    }

    @Override
    public void _a(zztd zztd2, List list2, Random random) {
        this._b((ozrz)zztd2, list2, random, 0, 1, true);
    }

    public static dzoy _a(List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, 0, 0, 5, 7, 5, n4);
        if (!dzoy._a(uken2) || zztd._a(list2, uken2) != null) {
            return null;
        }
        return new dzoy(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        int n;
        int n2;
        this._a(ozlu2, uken2, 0, 0, 0, 4, 1, 4, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 2, 0, 4, 5, 4, 0, 0, false);
        this._a(ozlu2, uken2, 4, 2, 0, 4, 5, 4, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 4, 3, 1, 4, 4, 1, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 4, 3, 3, 4, 4, 3, twgu.field_72098_bB.field_71990_ca, twgu.field_72098_bB.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 2, 0, 0, 5, 0, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 0, 2, 4, 3, 5, 4, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 1, 3, 4, 1, 4, 4, twgu.field_72098_bB.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        this._a(ozlu2, uken2, 3, 3, 4, 3, 4, 4, twgu.field_72098_bB.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        if (this._a) {
            int n3;
            n2 = this._b(2);
            n = this._c(3, 3);
            if (uken2._b(n, n2, n3 = this._d(3, 3))) {
                this._a = false;
                this._a(ozlu2, uken2, random, 3, 2, 3, _b, 2 + random.nextInt(4));
            }
        }
        this._a(ozlu2, uken2, 0, 6, 0, 4, 6, 4, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        for (n2 = 0; n2 <= 4; ++n2) {
            for (n = 0; n <= 4; ++n) {
                this._b(ozlu2, twgu.field_72033_bA.field_71990_ca, 0, n2, -1, n, uken2);
            }
        }
        return true;
    }
}

