/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class rasl
extends zzpm {
    public int _a;
    public int _b;

    public rasl(int n, int n2) {
        this._b = n;
        this._a = n2;
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        twgu twgu2 = null;
        while (((twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(n, n2, n3)]) == null || twgu2.isAirBlock(ozlu2, n, n2, n3) || twgu2.isLeaves(ozlu2, n, n2, n3)) && --n2 > 0) {
        }
        int n4 = ozlu2.func_72798_a(n, n2, n3);
        if (n4 == twgu.field_71979_v.field_71990_ca || n4 == twgu.field_71980_u.field_71990_ca) {
            this._a(ozlu2, n, ++n2, n3, twgu.field_71951_J.field_71990_ca, this._b);
            for (int i = n2; i <= n2 + 2; ++i) {
                int n5 = i - n2;
                int n6 = 2 - n5;
                for (int j = n - n6; j <= n + n6; ++j) {
                    int n7 = j - n;
                    for (int k = n3 - n6; k <= n3 + n6; ++k) {
                        int n8 = k - n3;
                        twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(j, i, k)];
                        if (Math.abs(n7) == n6 && Math.abs(n8) == n6 && random.nextInt(2) == 0 || twgu2 != null && !twgu2.canBeReplacedByLeaves(ozlu2, j, i, k)) continue;
                        this._a(ozlu2, j, i, k, twgu.field_71952_K.field_71990_ca, this._a);
                    }
                }
            }
        }
        return true;
    }
}

