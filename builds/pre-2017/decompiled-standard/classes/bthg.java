/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class bthg
extends zzpm {
    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        int n4 = random.nextInt(5) + 7;
        int n5 = n4 - random.nextInt(2) - 3;
        int n6 = n4 - n5;
        int n7 = 1 + random.nextInt(n6 + 1);
        boolean bl = true;
        if (n2 >= 1 && n2 + n4 + 1 <= 128) {
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            for (n13 = n2; n13 <= n2 + 1 + n4 && bl; ++n13) {
                n12 = 1;
                n11 = n13 - n2 < n5 ? 0 : n7;
                for (n10 = n - n11; n10 <= n + n11 && bl; ++n10) {
                    for (n9 = n3 - n11; n9 <= n3 + n11 && bl; ++n9) {
                        if (n13 >= 0 && n13 < 128) {
                            n8 = ozlu2.func_72798_a(n10, n13, n9);
                            twgu twgu2 = twgu.field_71973_m[n8];
                            if (n8 == 0 || twgu2 != null && twgu2.isLeaves(ozlu2, n10, n13, n9)) continue;
                            bl = false;
                            continue;
                        }
                        bl = false;
                    }
                }
            }
            if (!bl) {
                return false;
            }
            n13 = ozlu2.func_72798_a(n, n2 - 1, n3);
            if ((n13 == twgu.field_71980_u.field_71990_ca || n13 == twgu.field_71979_v.field_71990_ca) && n2 < 128 - n4 - 1) {
                this._b(ozlu2, n, n2 - 1, n3, twgu.field_71979_v.field_71990_ca);
                n11 = 0;
                for (n10 = n2 + n4; n10 >= n2 + n5; --n10) {
                    for (n9 = n - n11; n9 <= n + n11; ++n9) {
                        n8 = n9 - n;
                        for (n12 = n3 - n11; n12 <= n3 + n11; ++n12) {
                            int n14 = n12 - n3;
                            twgu twgu3 = twgu.field_71973_m[ozlu2.func_72798_a(n9, n10, n12)];
                            if (Math.abs(n8) == n11 && Math.abs(n14) == n11 && n11 > 0 || twgu3 != null && !twgu3.canBeReplacedByLeaves(ozlu2, n9, n10, n12)) continue;
                            this._a(ozlu2, n9, n10, n12, twgu.field_71952_K.field_71990_ca, 1);
                        }
                    }
                    if (n11 >= 1 && n10 == n2 + n5 + 1) {
                        --n11;
                        continue;
                    }
                    if (n11 >= n7) continue;
                    ++n11;
                }
                for (n10 = 0; n10 < n4 - 1; ++n10) {
                    n9 = ozlu2.func_72798_a(n, n2 + n10, n3);
                    twgu twgu4 = twgu.field_71973_m[n9];
                    if (n9 != 0 && twgu4 != null && !twgu4.isLeaves(ozlu2, n, n2 + n10, n3)) continue;
                    this._a(ozlu2, n, n2 + n10, n3, twgu.field_71951_J.field_71990_ca, 1);
                }
                return true;
            }
            return false;
        }
        return false;
    }
}

