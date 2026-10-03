/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.ugqx;
import net.minecraftforge.common.ForgeDirection;

public class dzqi
extends zzpm {
    public final int _a;
    public final boolean _b;
    public final int _c;
    public final int _d;

    public dzqi(boolean bl) {
        this(bl, 4, 0, 0, false);
    }

    public dzqi(boolean bl, int n, int n2, int n3, boolean bl2) {
        super(bl);
        this._a = n;
        this._c = n2;
        this._d = n3;
        this._b = bl2;
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
                n7 = 1;
                if (n8 == n2) {
                    n7 = 0;
                }
                if (n8 >= n2 + 1 + n4 - 2) {
                    n7 = 2;
                }
                for (int i = n - n7; i <= n + n7 && bl; ++i) {
                    for (n6 = n3 - n7; n6 <= n3 + n7 && bl; ++n6) {
                        if (n8 >= 0 && n8 < 256) {
                            n5 = ozlu2.func_72798_a(i, n8, n6);
                            twgu twgu2 = twgu.field_71973_m[n5];
                            if (ozlu2.func_72799_c(i, n8, n6) || twgu2.isLeaves(ozlu2, i, n8, n6) || n5 == twgu.field_71980_u.field_71990_ca || n5 == twgu.field_71979_v.field_71990_ca || twgu2.isWood(ozlu2, i, n8, n6)) continue;
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
                int n9;
                int n10;
                int n11;
                twgu3.onPlantGrow(ozlu2, n, n2 - 1, n3, n, n2, n3);
                n7 = 3;
                int n12 = 0;
                for (n6 = n2 - n7 + n4; n6 <= n2 + n4; ++n6) {
                    n5 = n6 - (n2 + n4);
                    n11 = n12 + 1 - n5 / 2;
                    for (n10 = n - n11; n10 <= n + n11; ++n10) {
                        n9 = n10 - n;
                        for (int i = n3 - n11; i <= n3 + n11; ++i) {
                            int n13;
                            twgu twgu4;
                            int n14 = i - n3;
                            if (Math.abs(n9) == n11 && Math.abs(n14) == n11 && (random.nextInt(2) == 0 || n5 == 0) || (twgu4 = twgu.field_71973_m[n13 = ozlu2.func_72798_a(n10, n6, i)]) != null && !twgu4.canBeReplacedByLeaves(ozlu2, n10, n6, i)) continue;
                            this._a(ozlu2, n10, n6, i, twgu.field_71952_K.field_71990_ca, this._d);
                        }
                    }
                }
                for (n6 = 0; n6 < n4; ++n6) {
                    n5 = ozlu2.func_72798_a(n, n2 + n6, n3);
                    twgu twgu5 = twgu.field_71973_m[n5];
                    if (twgu5 != null && !twgu5.isAirBlock(ozlu2, n, n2 + n6, n3) && !twgu5.isLeaves(ozlu2, n, n2 + n6, n3)) continue;
                    this._a(ozlu2, n, n2 + n6, n3, twgu.field_71951_J.field_71990_ca, this._c);
                    if (!this._b || n6 <= 0) continue;
                    if (random.nextInt(3) > 0 && ozlu2.func_72799_c(n - 1, n2 + n6, n3)) {
                        this._a(ozlu2, n - 1, n2 + n6, n3, twgu.field_71998_bu.field_71990_ca, 8);
                    }
                    if (random.nextInt(3) > 0 && ozlu2.func_72799_c(n + 1, n2 + n6, n3)) {
                        this._a(ozlu2, n + 1, n2 + n6, n3, twgu.field_71998_bu.field_71990_ca, 2);
                    }
                    if (random.nextInt(3) > 0 && ozlu2.func_72799_c(n, n2 + n6, n3 - 1)) {
                        this._a(ozlu2, n, n2 + n6, n3 - 1, twgu.field_71998_bu.field_71990_ca, 1);
                    }
                    if (random.nextInt(3) <= 0 || !ozlu2.func_72799_c(n, n2 + n6, n3 + 1)) continue;
                    this._a(ozlu2, n, n2 + n6, n3 + 1, twgu.field_71998_bu.field_71990_ca, 4);
                }
                if (this._b) {
                    for (n6 = n2 - 3 + n4; n6 <= n2 + n4; ++n6) {
                        n5 = n6 - (n2 + n4);
                        n11 = 2 - n5 / 2;
                        for (n10 = n - n11; n10 <= n + n11; ++n10) {
                            for (n9 = n3 - n11; n9 <= n3 + n11; ++n9) {
                                twgu twgu6 = twgu.field_71973_m[ozlu2.func_72798_a(n10, n6, n9)];
                                if (twgu6 == null || !twgu6.isLeaves(ozlu2, n10, n6, n9)) continue;
                                if (random.nextInt(4) == 0 && ozlu2.func_72799_c(n10 - 1, n6, n9)) {
                                    this._a(ozlu2, n10 - 1, n6, n9, 8);
                                }
                                if (random.nextInt(4) == 0 && ozlu2.func_72799_c(n10 + 1, n6, n9)) {
                                    this._a(ozlu2, n10 + 1, n6, n9, 2);
                                }
                                if (random.nextInt(4) == 0 && ozlu2.func_72799_c(n10, n6, n9 - 1)) {
                                    this._a(ozlu2, n10, n6, n9 - 1, 1);
                                }
                                if (random.nextInt(4) != 0 || !ozlu2.func_72799_c(n10, n6, n9 + 1)) continue;
                                this._a(ozlu2, n10, n6, n9 + 1, 4);
                            }
                        }
                    }
                    if (random.nextInt(5) == 0 && n4 > 5) {
                        for (n6 = 0; n6 < 2; ++n6) {
                            for (n5 = 0; n5 < 4; ++n5) {
                                if (random.nextInt(4 - n6) != 0) continue;
                                n11 = random.nextInt(3);
                                this._a(ozlu2, n + ugqx._a[ugqx._f[n5]], n2 + n4 - 5 + n6, n3 + ugqx._b[ugqx._f[n5]], twgu.field_72086_bP.field_71990_ca, n11 << 2 | n5);
                            }
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
        while (ozlu2.func_72799_c(n, --n2, n3) && n5 > 0) {
            this._a(ozlu2, n, n2, n3, twgu.field_71998_bu.field_71990_ca, n4);
            --n5;
        }
        return;
    }
}

