/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class plod
extends zzpm {
    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        if (!ozlu2.func_72799_c(n, n2, n3)) {
            return false;
        }
        if (ozlu2.func_72798_a(n, n2 + 1, n3) != twgu.field_72012_bb.field_71990_ca) {
            return false;
        }
        ozlu2.func_72832_d(n, n2, n3, twgu.field_72014_bd.field_71990_ca, 0, 2);
        for (int i = 0; i < 1500; ++i) {
            int n4;
            int n5;
            int n6 = n + random.nextInt(8) - random.nextInt(8);
            if (ozlu2.func_72798_a(n6, n5 = n2 - random.nextInt(12), n4 = n3 + random.nextInt(8) - random.nextInt(8)) != 0) continue;
            int n7 = 0;
            for (int j = 0; j < 6; ++j) {
                int n8 = 0;
                if (j == 0) {
                    n8 = ozlu2.func_72798_a(n6 - 1, n5, n4);
                }
                if (j == 1) {
                    n8 = ozlu2.func_72798_a(n6 + 1, n5, n4);
                }
                if (j == 2) {
                    n8 = ozlu2.func_72798_a(n6, n5 - 1, n4);
                }
                if (j == 3) {
                    n8 = ozlu2.func_72798_a(n6, n5 + 1, n4);
                }
                if (j == 4) {
                    n8 = ozlu2.func_72798_a(n6, n5, n4 - 1);
                }
                if (j == 5) {
                    n8 = ozlu2.func_72798_a(n6, n5, n4 + 1);
                }
                if (n8 != twgu.field_72014_bd.field_71990_ca) continue;
                ++n7;
            }
            if (n7 != true) continue;
            ozlu2.func_72832_d(n6, n5, n4, twgu.field_72014_bd.field_71990_ca, 0, 2);
        }
        return true;
    }
}

