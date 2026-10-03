/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.sajh;
import net.minecraftforge.common.ForgeDirection;

public class mtgt
extends zzpm {
    public final int _a;
    public final int _b;
    public final int _c;

    public mtgt(boolean bl, int n, int n2, int n3) {
        super(bl);
        this._a = n;
        this._b = n2;
        this._c = n3;
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, int n, int n2, int n3) {
        int n4 = random.nextInt(3) + this._a;
        boolean bl = true;
        if (n2 >= 1 && n2 + n4 + 1 <= 256) {
            boolean bl2;
            int n5;
            int n6;
            int n7;
            int n8;
            for (n8 = n2; n8 <= n2 + 1 + n4; ++n8) {
                int n9 = 2;
                if (n8 == n2) {
                    n9 = 1;
                }
                if (n8 >= n2 + 1 + n4 - 2) {
                    n9 = 2;
                }
                for (n7 = n - n9; n7 <= n + n9 && bl; ++n7) {
                    for (n6 = n3 - n9; n6 <= n3 + n9 && bl; ++n6) {
                        if (n8 >= 0 && n8 < 256) {
                            n5 = ozlu2.func_72798_a(n7, n8, n6);
                            twgu twgu2 = twgu.field_71973_m[n5];
                            if (twgu2 == null || twgu2.isAirBlock(ozlu2, n7, n8, n6) || twgu2.isLeaves(ozlu2, n7, n8, n6) || twgu2.isWood(ozlu2, n7, n8, n6) || twgu2 == twgu.field_71980_u || twgu2 == twgu.field_71979_v || twgu2 == twgu.field_71987_y) continue;
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
            n8 = ozlu2.func_72798_a(n, n2 - 1, n3);
            twgu twgu3 = twgu.field_71973_m[n8];
            boolean bl3 = bl2 = twgu3 != null && twgu3.canSustainPlant(ozlu2, n, n2 - 1, n3, ForgeDirection.UP, (rqeh)twgu.field_71987_y);
            if (bl2 && n2 < 256 - n4 - 1) {
                this._a(ozlu2, n, n2 - 1, n3, n, n2, n3);
                this._a(ozlu2, n + 1, n2 - 1, n3, n, n2, n3);
                this._a(ozlu2, n, n2 - 1, n3 + 1, n, n2, n3);
                this._a(ozlu2, n + 1, n2 - 1, n3 + 1, n, n2, n3);
                this._a(ozlu2, n, n3, n2 + n4, 2, random);
                for (int i = n2 + n4 - 2 - random.nextInt(4); i > n2 + n4 / 2; i -= 2 + random.nextInt(4)) {
                    float f = random.nextFloat() * (float)Math.PI * 2.0f;
                    n6 = n + (int)(0.5f + sajh._b(f) * 4.0f);
                    n5 = n3 + (int)(0.5f + sajh._a(f) * 4.0f);
                    this._a(ozlu2, n6, n5, i, 0, random);
                    for (int j = 0; j < 5; ++j) {
                        n6 = n + (int)(1.5f + sajh._b(f) * (float)j);
                        n5 = n3 + (int)(1.5f + sajh._a(f) * (float)j);
                        this._a(ozlu2, n6, i - 3 + j / 2, n5, twgu.field_71951_J.field_71990_ca, this._b);
                    }
                }
                for (n7 = 0; n7 < n4; ++n7) {
                    n6 = ozlu2.func_72798_a(n, n2 + n7, n3);
                    if (this._a(ozlu2, n, n2 + n7, n3)) {
                        this._a(ozlu2, n, n2 + n7, n3, twgu.field_71951_J.field_71990_ca, this._b);
                        if (n7 > 0) {
                            if (random.nextInt(3) > 0 && ozlu2.func_72799_c(n - 1, n2 + n7, n3)) {
                                this._a(ozlu2, n - 1, n2 + n7, n3, twgu.field_71998_bu.field_71990_ca, 8);
                            }
                            if (random.nextInt(3) > 0 && ozlu2.func_72799_c(n, n2 + n7, n3 - 1)) {
                                this._a(ozlu2, n, n2 + n7, n3 - 1, twgu.field_71998_bu.field_71990_ca, 1);
                            }
                        }
                    }
                    if (n7 >= n4 - 1) continue;
                    n6 = ozlu2.func_72798_a(n + 1, n2 + n7, n3);
                    if (this._a(ozlu2, n + 1, n2 + n7, n3)) {
                        this._a(ozlu2, n + 1, n2 + n7, n3, twgu.field_71951_J.field_71990_ca, this._b);
                        if (n7 > 0) {
                            if (random.nextInt(3) > 0 && ozlu2.func_72799_c(n + 2, n2 + n7, n3)) {
                                this._a(ozlu2, n + 2, n2 + n7, n3, twgu.field_71998_bu.field_71990_ca, 2);
                            }
                            if (random.nextInt(3) > 0 && ozlu2.func_72799_c(n + 1, n2 + n7, n3 - 1)) {
                                this._a(ozlu2, n + 1, n2 + n7, n3 - 1, twgu.field_71998_bu.field_71990_ca, 1);
                            }
                        }
                    }
                    n6 = ozlu2.func_72798_a(n + 1, n2 + n7, n3 + 1);
                    if (this._a(ozlu2, n + 1, n2 + n7, n3 + 1)) {
                        this._a(ozlu2, n + 1, n2 + n7, n3 + 1, twgu.field_71951_J.field_71990_ca, this._b);
                        if (n7 > 0) {
                            if (random.nextInt(3) > 0 && ozlu2.func_72799_c(n + 2, n2 + n7, n3 + 1)) {
                                this._a(ozlu2, n + 2, n2 + n7, n3 + 1, twgu.field_71998_bu.field_71990_ca, 2);
                            }
                            if (random.nextInt(3) > 0 && ozlu2.func_72799_c(n + 1, n2 + n7, n3 + 2)) {
                                this._a(ozlu2, n + 1, n2 + n7, n3 + 2, twgu.field_71998_bu.field_71990_ca, 4);
                            }
                        }
                    }
                    n6 = ozlu2.func_72798_a(n, n2 + n7, n3 + 1);
                    if (!this._a(ozlu2, n, n2 + n7, n3 + 1)) continue;
                    this._a(ozlu2, n, n2 + n7, n3 + 1, twgu.field_71951_J.field_71990_ca, this._b);
                    if (n7 <= 0) continue;
                    if (random.nextInt(3) > 0 && ozlu2.func_72799_c(n - 1, n2 + n7, n3 + 1)) {
                        this._a(ozlu2, n - 1, n2 + n7, n3 + 1, twgu.field_71998_bu.field_71990_ca, 8);
                    }
                    if (random.nextInt(3) <= 0 || !ozlu2.func_72799_c(n, n2 + n7, n3 + 2)) continue;
                    this._a(ozlu2, n, n2 + n7, n3 + 2, twgu.field_71998_bu.field_71990_ca, 4);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4, Random random) {
        int n5 = 2;
        for (int i = n3 - n5; i <= n3; ++i) {
            int n6 = i - n3;
            int n7 = n4 + 1 - n6;
            for (int j = n - n7; j <= n + n7 + 1; ++j) {
                int n8 = j - n;
                for (int k = n2 - n7; k <= n2 + n7 + 1; ++k) {
                    int n9;
                    twgu twgu2;
                    int n10 = k - n2;
                    if (n8 < 0 && n10 < 0 && n8 * n8 + n10 * n10 > n7 * n7 || (n8 > 0 || n10 > 0) && n8 * n8 + n10 * n10 > (n7 + 1) * (n7 + 1) || random.nextInt(4) == 0 && n8 * n8 + n10 * n10 > (n7 - 1) * (n7 - 1) || (twgu2 = twgu.field_71973_m[n9 = ozlu2.func_72798_a(j, i, k)]) != null && !twgu2.canBeReplacedByLeaves(ozlu2, j, i, k)) continue;
                    this._a(ozlu2, j, i, k, twgu.field_71952_K.field_71990_ca, this._c);
                }
            }
        }
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5, int n6) {
        twgu twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(n, n2, n3)];
        if (twgu2 != null) {
            twgu2.onPlantGrow(ozlu2, n, n2, n3, n4, n5, n6);
        }
    }

    public boolean _a(ozlu ozlu2, int n, int n2, int n3) {
        twgu twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(n, n2, n3)];
        return twgu2 == null || twgu2.isAirBlock(ozlu2, n, n2, n3) || twgu2.isLeaves(ozlu2, n, n2, n3);
    }
}

