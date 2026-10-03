/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class xtgb
extends zzpm {
    public int _a;

    public xtgb(int n) {
        this._a = n;
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        if (ozlu2.func_72798_a(n, n2 + 1, n3) != twgu.field_71981_t.field_71990_ca) {
            return false;
        }
        if (ozlu2.func_72798_a(n, n2 - 1, n3) != twgu.field_71981_t.field_71990_ca) {
            return false;
        }
        if (ozlu2.func_72798_a(n, n2, n3) != 0 && ozlu2.func_72798_a(n, n2, n3) != twgu.field_71981_t.field_71990_ca) {
            return false;
        }
        int n4 = 0;
        if (ozlu2.func_72798_a(n - 1, n2, n3) == twgu.field_71981_t.field_71990_ca) {
            ++n4;
        }
        if (ozlu2.func_72798_a(n + 1, n2, n3) == twgu.field_71981_t.field_71990_ca) {
            ++n4;
        }
        if (ozlu2.func_72798_a(n, n2, n3 - 1) == twgu.field_71981_t.field_71990_ca) {
            ++n4;
        }
        if (ozlu2.func_72798_a(n, n2, n3 + 1) == twgu.field_71981_t.field_71990_ca) {
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
        if (n4 == 3 && n5 == 1) {
            ozlu2.func_72832_d(n, n2, n3, this._a, 0, 2);
            ozlu2.field_72999_e = true;
            twgu.field_71973_m[this._a].func_71847_b(ozlu2, n, n2, n3, random);
            ozlu2.field_72999_e = false;
        }
        return true;
    }
}

