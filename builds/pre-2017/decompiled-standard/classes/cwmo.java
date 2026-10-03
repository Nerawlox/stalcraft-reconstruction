/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class cwmo
extends diqv {
    public int _a;

    public cwmo() {
    }

    public cwmo(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
        this._a = random.nextInt();
    }

    public static cwmo _a(List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, -3, 0, 5, 10, 8, n4);
        if (!cwmo._a(uken2) || zztd._a(list2, uken2) != null) {
            return null;
        }
        return new cwmo(n5, random, uken2, n4);
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._a = qoac2._f("Seed");
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("Seed", this._a);
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        int n;
        int n2;
        int n3;
        Random random2 = new Random(this._a);
        for (n3 = 0; n3 <= 4; ++n3) {
            for (n2 = 3; n2 <= 4; ++n2) {
                n = random2.nextInt(8);
                this._a(ozlu2, uken2, n3, n2, 0, n3, n2, n, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
            }
        }
        n3 = random2.nextInt(8);
        this._a(ozlu2, uken2, 0, 5, 0, 0, 5, n3, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        n3 = random2.nextInt(8);
        this._a(ozlu2, uken2, 4, 5, 0, 4, 5, n3, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        for (n3 = 0; n3 <= 4; ++n3) {
            n2 = random2.nextInt(5);
            this._a(ozlu2, uken2, n3, 2, 0, n3, 2, n2, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
        }
        for (n3 = 0; n3 <= 4; ++n3) {
            for (n2 = 0; n2 <= 1; ++n2) {
                n = random2.nextInt(3);
                this._a(ozlu2, uken2, n3, n2, 0, n3, n2, n, twgu.field_72033_bA.field_71990_ca, twgu.field_72033_bA.field_71990_ca, false);
            }
        }
        return true;
    }
}

