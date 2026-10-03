/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class wqci
extends zzpm {
    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        for (int i = 0; i < 20; ++i) {
            int n4;
            int n5;
            int n6 = n + random.nextInt(4) - random.nextInt(4);
            if (!ozlu2.func_72799_c(n6, n5 = n2, n4 = n3 + random.nextInt(4) - random.nextInt(4)) || ozlu2.func_72803_f(n6 - 1, n5 - 1, n4) != tflj._h && ozlu2.func_72803_f(n6 + 1, n5 - 1, n4) != tflj._h && ozlu2.func_72803_f(n6, n5 - 1, n4 - 1) != tflj._h && ozlu2.func_72803_f(n6, n5 - 1, n4 + 1) != tflj._h) continue;
            int n7 = 2 + random.nextInt(random.nextInt(3) + 1);
            for (int j = 0; j < n7; ++j) {
                if (!twgu.field_72040_aX.func_71854_d(ozlu2, n6, n5 + j, n4)) continue;
                ozlu2.func_72832_d(n6, n5 + j, n4, twgu.field_72040_aX.field_71990_ca, 0, 2);
            }
        }
        return true;
    }
}

