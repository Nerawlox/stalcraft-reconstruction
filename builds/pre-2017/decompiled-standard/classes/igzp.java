/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class igzp
extends zzpm {
    public int _a;
    public boolean _b;

    public igzp(int n, boolean bl) {
        this._a = n;
        this._b = bl;
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        if (ozlu2.func_72798_a(n, n2 + 1, n3) != twgu.field_72012_bb.field_71990_ca) {
            return false;
        }
        if (ozlu2.func_72798_a(n, n2, n3) != 0 && ozlu2.func_72798_a(n, n2, n3) != twgu.field_72012_bb.field_71990_ca) {
            return false;
        }
        int n4 = 0;
        if (ozlu2.func_72798_a(n - 1, n2, n3) == twgu.field_72012_bb.field_71990_ca) {
            ++n4;
        }
        if (ozlu2.func_72798_a(n + 1, n2, n3) == twgu.field_72012_bb.field_71990_ca) {
            ++n4;
        }
        if (ozlu2.func_72798_a(n, n2, n3 - 1) == twgu.field_72012_bb.field_71990_ca) {
            ++n4;
        }
        if (ozlu2.func_72798_a(n, n2, n3 + 1) == twgu.field_72012_bb.field_71990_ca) {
            ++n4;
        }
        if (ozlu2.func_72798_a(n, n2 - 1, n3) == twgu.field_72012_bb.field_71990_ca) {
            ++n4;
        }
        int n5 = 0;
        if (ozlu2.func_72799_c(n - 1, n2, n3)) {
            ++n5;
        }
        if (ozlu2.func_72799_c(n + 1, n2, n3)) {
            ++n5;
        }
        if (ozlu2.func_72799_c(n, n2, n3 - 1)) {
            ++n5;
        }
        if (ozlu2.func_72799_c(n, n2, n3 + 1)) {
            ++n5;
        }
        if (ozlu2.func_72799_c(n, n2 - 1, n3)) {
            ++n5;
        }
        if (!this._b && n4 == 4 && n5 == 1 || n4 == 5) {
            ozlu2.func_72832_d(n, n2, n3, this._a, 0, 2);
            ozlu2.field_72999_e = true;
            twgu.field_71973_m[this._a].func_71847_b(ozlu2, n, n2, n3, random);
            ozlu2.field_72999_e = false;
        }
        return true;
    }
}

