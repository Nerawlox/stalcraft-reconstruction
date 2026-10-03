/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class cfiv
extends zzpm {
    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        int n4 = random.nextInt(4) + 5;
        while (ozlu2.func_72803_f(n, n2 - 1, n3) == tflj._h) {
            --n2;
        }
        boolean bl = true;
        if (n2 >= 1 && n2 + n4 + 1 <= 128) {
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            for (n9 = n2; n9 <= n2 + 1 + n4; ++n9) {
                n8 = 1;
                if (n9 == n2) {
                    n8 = 0;
                }
                if (n9 >= n2 + 1 + n4 - 2) {
                    n8 = 3;
                }
                for (n7 = n - n8; n7 <= n + n8 && bl; ++n7) {
                    for (n6 = n3 - n8; n6 <= n3 + n8 && bl; ++n6) {
                        if (n9 >= 0 && n9 < 128) {
                            n5 = ozlu2.func_72798_a(n7, n9, n6);
                            if (n5 == 0 || twgu.field_71973_m[n5] == null || twgu.field_71973_m[n5].isLeaves(ozlu2, n7, n9, n6)) continue;
                            if (n5 != twgu.field_71943_B.field_71990_ca && n5 != twgu.field_71942_A.field_71990_ca) {
                                bl = false;
                                continue;
                            }
                            if (n9 <= n2) continue;
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
            n9 = ozlu2.func_72798_a(n, n2 - 1, n3);
            if ((n9 == twgu.field_71980_u.field_71990_ca || n9 == twgu.field_71979_v.field_71990_ca) && n2 < 128 - n4 - 1) {
                int n10;
                this._b(ozlu2, n, n2 - 1, n3, twgu.field_71979_v.field_71990_ca);
                for (n10 = n2 - 3 + n4; n10 <= n2 + n4; ++n10) {
                    n7 = n10 - (n2 + n4);
                    n6 = 2 - n7 / 2;
                    for (n5 = n - n6; n5 <= n + n6; ++n5) {
                        n8 = n5 - n;
                        for (int i = n3 - n6; i <= n3 + n6; ++i) {
                            int n11 = i - n3;
                            twgu twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(n5, n10, i)];
                            if (Math.abs(n8) == n6 && Math.abs(n11) == n6 && (random.nextInt(2) == 0 || n7 == 0) || twgu2 != null && !twgu2.canBeReplacedByLeaves(ozlu2, n5, n10, i)) continue;
                            this._b(ozlu2, n5, n10, i, twgu.field_71952_K.field_71990_ca);
                        }
                    }
                }
                for (n10 = 0; n10 < n4; ++n10) {
                    n7 = ozlu2.func_72798_a(n, n2 + n10, n3);
                    twgu twgu3 = twgu.field_71973_m[n7];
                    if (n7 != 0 && (twgu3 == null || !twgu3.isLeaves(ozlu2, n, n2 + n10, n3)) && n7 != twgu.field_71942_A.field_71990_ca && n7 != twgu.field_71943_B.field_71990_ca) continue;
                    this._b(ozlu2, n, n2 + n10, n3, twgu.field_71951_J.field_71990_ca);
                }
                for (n10 = n2 - 3 + n4; n10 <= n2 + n4; ++n10) {
                    n7 = n10 - (n2 + n4);
                    n6 = 2 - n7 / 2;
                    for (n5 = n - n6; n5 <= n + n6; ++n5) {
                        for (n8 = n3 - n6; n8 <= n3 + n6; ++n8) {
                            twgu twgu4 = twgu.field_71973_m[ozlu2.func_72798_a(n5, n10, n8)];
                            if (twgu4 == null || !twgu4.isLeaves(ozlu2, n5, n10, n8)) continue;
                            if (random.nextInt(4) == 0 && ozlu2.func_72798_a(n5 - 1, n10, n8) == 0) {
                                this._a(ozlu2, n5 - 1, n10, n8, 8);
                            }
                            if (random.nextInt(4) == 0 && ozlu2.func_72798_a(n5 + 1, n10, n8) == 0) {
                                this._a(ozlu2, n5 + 1, n10, n8, 2);
                            }
                            if (random.nextInt(4) == 0 && ozlu2.func_72798_a(n5, n10, n8 - 1) == 0) {
                                this._a(ozlu2, n5, n10, n8 - 1, 1);
                            }
                            if (random.nextInt(4) != 0 || ozlu2.func_72798_a(n5, n10, n8 + 1) != 0) continue;
                            this._a(ozlu2, n5, n10, n8 + 1, 4);
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        this._a(ozlu2, n, n2, n3, twgu.field_71998_bu.field_71990_ca, n4);
        int n5 = 4;
        while (ozlu2.func_72798_a(n, --n2, n3) == 0 && n5 > 0) {
            this._a(ozlu2, n, n2, n3, twgu.field_71998_bu.field_71990_ca, n4);
            --n5;
        }
        return;
    }
}

