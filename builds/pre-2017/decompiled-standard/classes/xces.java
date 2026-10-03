/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class xces
extends zzpm {
    public int _a;

    public xces(int n) {
        this._a = n;
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        for (int i = 0; i < 64; ++i) {
            int n4;
            int n5;
            int n6 = n + random.nextInt(8) - random.nextInt(8);
            if (!ozlu2.func_72799_c(n6, n5 = n2 + random.nextInt(4) - random.nextInt(4), n4 = n3 + random.nextInt(8) - random.nextInt(8)) || ozlu2.field_73011_w._g && n5 >= 127 || !twgu.field_71973_m[this._a].func_71854_d(ozlu2, n6, n5, n4)) continue;
            ozlu2.func_72832_d(n6, n5, n4, this._a, 0, 2);
        }
        return true;
    }
}

