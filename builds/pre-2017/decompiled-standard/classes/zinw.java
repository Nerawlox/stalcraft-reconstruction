/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class zinw
extends zzpm {
    public int _a;
    public int _b;

    public zinw(int n, int n2) {
        this._a = n;
        this._b = n2;
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        twgu twgu2 = null;
        while (((twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(n, n2, n3)]) == null || twgu2.isLeaves(ozlu2, n, n2, n3)) && --n2 > 0) {
        }
        for (int i = 0; i < 128; ++i) {
            int n4;
            int n5;
            int n6 = n + random.nextInt(8) - random.nextInt(8);
            if (!ozlu2.func_72799_c(n6, n5 = n2 + random.nextInt(4) - random.nextInt(4), n4 = n3 + random.nextInt(8) - random.nextInt(8)) || !twgu.field_71973_m[this._a].func_71854_d(ozlu2, n6, n5, n4)) continue;
            ozlu2.func_72832_d(n6, n5, n4, this._a, this._b, 2);
        }
        return true;
    }
}

