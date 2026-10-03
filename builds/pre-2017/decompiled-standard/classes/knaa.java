/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class knaa
extends zzpm {
    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        for (int i = 0; i < 64; ++i) {
            int n4;
            int n5;
            int n6 = n + random.nextInt(8) - random.nextInt(8);
            if (!ozlu2.func_72799_c(n6, n5 = n2 + random.nextInt(4) - random.nextInt(4), n4 = n3 + random.nextInt(8) - random.nextInt(8)) || ozlu2.func_72798_a(n6, n5 - 1, n4) != twgu.field_71980_u.field_71990_ca || !twgu.field_72061_ba.func_71930_b(ozlu2, n6, n5, n4)) continue;
            ozlu2.func_72832_d(n6, n5, n4, twgu.field_72061_ba.field_71990_ca, random.nextInt(4), 2);
        }
        return true;
    }
}

