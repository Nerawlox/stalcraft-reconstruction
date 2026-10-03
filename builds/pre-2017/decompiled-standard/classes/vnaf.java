/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class vnaf
extends zzpm {
    public int _a;

    public vnaf(int n) {
        this._a = n;
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        n -= 8;
        n3 -= 8;
        while (n2 > 5 && ozlu2.func_72799_c(n, n2, n3)) {
            --n2;
        }
        if (n2 <= 4) {
            return false;
        }
        n2 -= 4;
        boolean[] blArray = new boolean[2048];
        int n7 = random.nextInt(4) + 4;
        for (n6 = 0; n6 < n7; ++n6) {
            double d = random.nextDouble() * 6.0 + 3.0;
            double d2 = random.nextDouble() * 4.0 + 2.0;
            double d3 = random.nextDouble() * 6.0 + 3.0;
            double d4 = random.nextDouble() * (16.0 - d - 2.0) + 1.0 + d / 2.0;
            double d5 = random.nextDouble() * (8.0 - d2 - 4.0) + 2.0 + d2 / 2.0;
            double d6 = random.nextDouble() * (16.0 - d3 - 2.0) + 1.0 + d3 / 2.0;
            for (int i = 1; i < 15; ++i) {
                for (int j = 1; j < 15; ++j) {
                    for (int k = 1; k < 7; ++k) {
                        double d7 = ((double)i - d4) / (d / 2.0);
                        double d8 = ((double)k - d5) / (d2 / 2.0);
                        double d9 = ((double)j - d6) / (d3 / 2.0);
                        double d10 = d7 * d7 + d8 * d8 + d9 * d9;
                        if (!(d10 < 1.0)) continue;
                        blArray[(i * 16 + j) * 8 + k] = true;
                    }
                }
            }
        }
        for (n6 = 0; n6 < 16; ++n6) {
            for (n5 = 0; n5 < 16; ++n5) {
                for (n4 = 0; n4 < 8; ++n4) {
                    boolean bl;
                    boolean bl2 = bl = !blArray[(n6 * 16 + n5) * 8 + n4] && (n6 < 15 && blArray[((n6 + 1) * 16 + n5) * 8 + n4] || n6 > 0 && blArray[((n6 - 1) * 16 + n5) * 8 + n4] || n5 < 15 && blArray[(n6 * 16 + (n5 + 1)) * 8 + n4] || n5 > 0 && blArray[(n6 * 16 + (n5 - 1)) * 8 + n4] || n4 < 7 && blArray[(n6 * 16 + n5) * 8 + (n4 + 1)] || n4 > 0 && blArray[(n6 * 16 + n5) * 8 + (n4 - 1)]);
                    if (!bl) continue;
                    tflj tflj2 = ozlu2.func_72803_f(n + n6, n2 + n4, n3 + n5);
                    if (n4 >= 4 && tflj2._d()) {
                        return false;
                    }
                    if (n4 >= 4 || tflj2._a() || ozlu2.func_72798_a(n + n6, n2 + n4, n3 + n5) == this._a) continue;
                    return false;
                }
            }
        }
        for (n6 = 0; n6 < 16; ++n6) {
            for (n5 = 0; n5 < 16; ++n5) {
                for (n4 = 0; n4 < 8; ++n4) {
                    if (!blArray[(n6 * 16 + n5) * 8 + n4]) continue;
                    ozlu2.func_72832_d(n + n6, n2 + n4, n3 + n5, n4 >= 4 ? 0 : this._a, 0, 2);
                }
            }
        }
        for (n6 = 0; n6 < 16; ++n6) {
            for (n5 = 0; n5 < 16; ++n5) {
                for (n4 = 4; n4 < 8; ++n4) {
                    if (!blArray[(n6 * 16 + n5) * 8 + n4] || ozlu2.func_72798_a(n + n6, n2 + n4 - 1, n3 + n5) != twgu.field_71979_v.field_71990_ca || ozlu2.func_72972_b(rrqi._a, n + n6, n2 + n4, n3 + n5) <= 0) continue;
                    foqh foqh2 = ozlu2.func_72807_a(n + n6, n3 + n5);
                    if (foqh2._A == twgu.field_71994_by.field_71990_ca) {
                        ozlu2.func_72832_d(n + n6, n2 + n4 - 1, n3 + n5, twgu.field_71994_by.field_71990_ca, 0, 2);
                        continue;
                    }
                    ozlu2.func_72832_d(n + n6, n2 + n4 - 1, n3 + n5, twgu.field_71980_u.field_71990_ca, 0, 2);
                }
            }
        }
        if (twgu.field_71973_m[this._a].field_72018_cp == tflj._i) {
            for (n6 = 0; n6 < 16; ++n6) {
                for (n5 = 0; n5 < 16; ++n5) {
                    for (n4 = 0; n4 < 8; ++n4) {
                        boolean bl;
                        boolean bl3 = bl = !blArray[(n6 * 16 + n5) * 8 + n4] && (n6 < 15 && blArray[((n6 + 1) * 16 + n5) * 8 + n4] || n6 > 0 && blArray[((n6 - 1) * 16 + n5) * 8 + n4] || n5 < 15 && blArray[(n6 * 16 + (n5 + 1)) * 8 + n4] || n5 > 0 && blArray[(n6 * 16 + (n5 - 1)) * 8 + n4] || n4 < 7 && blArray[(n6 * 16 + n5) * 8 + (n4 + 1)] || n4 > 0 && blArray[(n6 * 16 + n5) * 8 + (n4 - 1)]);
                        if (!bl || n4 >= 4 && random.nextInt(2) == 0 || !ozlu2.func_72803_f(n + n6, n2 + n4, n3 + n5)._a()) continue;
                        ozlu2.func_72832_d(n + n6, n2 + n4, n3 + n5, twgu.field_71981_t.field_71990_ca, 0, 2);
                    }
                }
            }
        }
        if (twgu.field_71973_m[this._a].field_72018_cp == tflj._h) {
            for (n6 = 0; n6 < 16; ++n6) {
                for (n5 = 0; n5 < 16; ++n5) {
                    n4 = 4;
                    if (!ozlu2.func_72884_u(n + n6, n2 + n4, n3 + n5)) continue;
                    ozlu2.func_72832_d(n + n6, n2 + n4, n3 + n5, twgu.field_72036_aT.field_71990_ca, 0, 2);
                }
            }
        }
        return true;
    }
}

