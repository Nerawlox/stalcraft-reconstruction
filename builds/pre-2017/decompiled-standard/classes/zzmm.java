/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class zzmm
extends zzpm {
    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        int n4;
        int n5;
        while (ozlu2.func_72799_c(n, n2, n3) && n2 > 2) {
            --n2;
        }
        int n6 = ozlu2.func_72798_a(n, n2, n3);
        if (n6 != twgu.field_71939_E.field_71990_ca) {
            return false;
        }
        for (n5 = -2; n5 <= 2; ++n5) {
            for (n4 = -2; n4 <= 2; ++n4) {
                if (!ozlu2.func_72799_c(n + n5, n2 - 1, n3 + n4) || !ozlu2.func_72799_c(n + n5, n2 - 2, n3 + n4)) continue;
                return false;
            }
        }
        for (n5 = -1; n5 <= 0; ++n5) {
            for (n4 = -2; n4 <= 2; ++n4) {
                for (int i = -2; i <= 2; ++i) {
                    ozlu2.func_72832_d(n + n4, n2 + n5, n3 + i, twgu.field_71957_Q.field_71990_ca, 0, 2);
                }
            }
        }
        ozlu2.func_72832_d(n, n2, n3, twgu.field_71942_A.field_71990_ca, 0, 2);
        ozlu2.func_72832_d(n - 1, n2, n3, twgu.field_71942_A.field_71990_ca, 0, 2);
        ozlu2.func_72832_d(n + 1, n2, n3, twgu.field_71942_A.field_71990_ca, 0, 2);
        ozlu2.func_72832_d(n, n2, n3 - 1, twgu.field_71942_A.field_71990_ca, 0, 2);
        ozlu2.func_72832_d(n, n2, n3 + 1, twgu.field_71942_A.field_71990_ca, 0, 2);
        for (n5 = -2; n5 <= 2; ++n5) {
            for (n4 = -2; n4 <= 2; ++n4) {
                if (n5 != -2 && n5 != 2 && n4 != -2 && n4 != 2) continue;
                ozlu2.func_72832_d(n + n5, n2 + 1, n3 + n4, twgu.field_71957_Q.field_71990_ca, 0, 2);
            }
        }
        ozlu2.func_72832_d(n + 2, n2 + 1, n3, twgu.field_72079_ak.field_71990_ca, 1, 2);
        ozlu2.func_72832_d(n - 2, n2 + 1, n3, twgu.field_72079_ak.field_71990_ca, 1, 2);
        ozlu2.func_72832_d(n, n2 + 1, n3 + 2, twgu.field_72079_ak.field_71990_ca, 1, 2);
        ozlu2.func_72832_d(n, n2 + 1, n3 - 2, twgu.field_72079_ak.field_71990_ca, 1, 2);
        for (n5 = -1; n5 <= 1; ++n5) {
            for (n4 = -1; n4 <= 1; ++n4) {
                if (n5 == 0 && n4 == 0) {
                    ozlu2.func_72832_d(n + n5, n2 + 4, n3 + n4, twgu.field_71957_Q.field_71990_ca, 0, 2);
                    continue;
                }
                ozlu2.func_72832_d(n + n5, n2 + 4, n3 + n4, twgu.field_72079_ak.field_71990_ca, 1, 2);
            }
        }
        for (n5 = 1; n5 <= 3; ++n5) {
            ozlu2.func_72832_d(n - 1, n2 + n5, n3 - 1, twgu.field_71957_Q.field_71990_ca, 0, 2);
            ozlu2.func_72832_d(n - 1, n2 + n5, n3 + 1, twgu.field_71957_Q.field_71990_ca, 0, 2);
            ozlu2.func_72832_d(n + 1, n2 + n5, n3 - 1, twgu.field_71957_Q.field_71990_ca, 0, 2);
            ozlu2.func_72832_d(n + 1, n2 + n5, n3 + 1, twgu.field_71957_Q.field_71990_ca, 0, 2);
        }
        return true;
    }
}

