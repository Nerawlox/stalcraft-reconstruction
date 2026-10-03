/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class gatb
extends zzpm {
    public int _a;
    public int _b;

    public gatb(int n, int n2) {
        this._a = n2;
        this._b = n;
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        if (ozlu2.func_72803_f(n, n2, n3) != tflj._h) {
            return false;
        }
        int n4 = random.nextInt(this._b - 2) + 2;
        int n5 = 2;
        for (int i = n - n4; i <= n + n4; ++i) {
            for (int j = n3 - n4; j <= n3 + n4; ++j) {
                int n6 = i - n;
                int n7 = j - n3;
                if (n6 * n6 + n7 * n7 > n4 * n4) continue;
                for (int k = n2 - n5; k <= n2 + n5; ++k) {
                    int n8 = ozlu2.func_72798_a(i, k, j);
                    if (n8 != twgu.field_71979_v.field_71990_ca && n8 != twgu.field_71980_u.field_71990_ca) continue;
                    ozlu2.func_72832_d(i, k, j, this._a, 0, 2);
                }
            }
        }
        return true;
    }
}

