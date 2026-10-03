/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraftforge.common.ForgeDirection;

public class nuxa
extends twgu {
    public int[] _a = new int[256];
    public int[] _b = new int[256];
    @SideOnly(value=Side.CLIENT)
    public dwan[] _c;

    public nuxa(int n) {
        super(n, tflj._o);
        this.func_71907_b(true);
    }

    @Override
    public void func_71928_r_() {
        this._b = twgu.blockFlammability;
        this._a = twgu.blockFireSpreadSpeed;
        this._a(twgu.field_71988_x.field_71990_ca, 5, 20);
        this._a(twgu.field_72090_bN.field_71990_ca, 5, 20);
        this._a(twgu.field_72092_bO.field_71990_ca, 5, 20);
        this._a(twgu.field_72031_aZ.field_71990_ca, 5, 20);
        this._a(twgu.field_72063_at.field_71990_ca, 5, 20);
        this._a(twgu.field_72072_bX.field_71990_ca, 5, 20);
        this._a(twgu.field_72074_bW.field_71990_ca, 5, 20);
        this._a(twgu.field_72070_bY.field_71990_ca, 5, 20);
        this._a(twgu.field_71951_J.field_71990_ca, 5, 5);
        this._a(twgu.field_71952_K.field_71990_ca, 30, 60);
        this._a(twgu.field_72093_an.field_71990_ca, 30, 20);
        this._a(twgu.field_72091_am.field_71990_ca, 15, 100);
        this._a(twgu.field_71962_X.field_71990_ca, 60, 100);
        this._a(twgu.field_72101_ab.field_71990_ca, 30, 60);
        this._a(twgu.field_71998_bu.field_71990_ca, 15, 100);
        this._a(twgu.field_111034_cE.field_71990_ca, 5, 5);
        this._a(twgu.field_111038_cB.field_71990_ca, 60, 20);
    }

    public void _a(int n, int n2, int n3) {
        twgu.setBurnProperties(n, n2, n3);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public int func_71857_b() {
        return 3;
    }

    @Override
    public int func_71925_a(Random random) {
        return 0;
    }

    @Override
    public int func_71859_p_(ozlu ozlu2) {
        return 30;
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (ozlu2.func_82736_K()._b("doFireTick")) {
            boolean bl;
            twgu twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(n, n2 - 1, n3)];
            boolean bl2 = bl = twgu2 != null && twgu2.isFireSource(ozlu2, n, n2 - 1, n3, ozlu2.func_72805_g(n, n2 - 1, n3), ForgeDirection.UP);
            if (!this.func_71930_b(ozlu2, n, n2, n3)) {
                ozlu2.func_94571_i(n, n2, n3);
            }
            if (!bl && ozlu2.func_72896_J() && (ozlu2.func_72951_B(n, n2, n3) || ozlu2.func_72951_B(n - 1, n2, n3) || ozlu2.func_72951_B(n + 1, n2, n3) || ozlu2.func_72951_B(n, n2, n3 - 1) || ozlu2.func_72951_B(n, n2, n3 + 1))) {
                ozlu2.func_94571_i(n, n2, n3);
            } else {
                int n4 = ozlu2.func_72805_g(n, n2, n3);
                if (n4 < 15) {
                    ozlu2.func_72921_c(n, n2, n3, n4 + random.nextInt(3) / 2, 4);
                }
                ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.func_71859_p_(ozlu2) + random.nextInt(10));
                if (!bl && !this._a(ozlu2, n, n2, n3)) {
                    if (!ozlu2.func_72797_t(n, n2 - 1, n3) || n4 > 3) {
                        ozlu2.func_94571_i(n, n2, n3);
                    }
                } else if (!bl && !this._a((sdrg)ozlu2, n, n2 - 1, n3, ForgeDirection.UP) && n4 == 15 && random.nextInt(4) == 0) {
                    ozlu2.func_94571_i(n, n2, n3);
                } else {
                    boolean bl3 = ozlu2.func_72958_C(n, n2, n3);
                    int n5 = 0;
                    if (bl3) {
                        n5 = -50;
                    }
                    this._a(ozlu2, n + 1, n2, n3, 300 + n5, random, n4, ForgeDirection.WEST);
                    this._a(ozlu2, n - 1, n2, n3, 300 + n5, random, n4, ForgeDirection.EAST);
                    this._a(ozlu2, n, n2 - 1, n3, 250 + n5, random, n4, ForgeDirection.UP);
                    this._a(ozlu2, n, n2 + 1, n3, 250 + n5, random, n4, ForgeDirection.DOWN);
                    this._a(ozlu2, n, n2, n3 - 1, 300 + n5, random, n4, ForgeDirection.SOUTH);
                    this._a(ozlu2, n, n2, n3 + 1, 300 + n5, random, n4, ForgeDirection.NORTH);
                    for (int i = n - 1; i <= n + 1; ++i) {
                        for (int j = n3 - 1; j <= n3 + 1; ++j) {
                            for (int k = n2 - 1; k <= n2 + 4; ++k) {
                                int n6;
                                if (i == n && k == n2 && j == n3) continue;
                                int n7 = 100;
                                if (k > n2 + 1) {
                                    n7 += (k - (n2 + 1)) * 100;
                                }
                                if ((n6 = this._b(ozlu2, i, k, j)) <= 0) continue;
                                int n8 = (n6 + 40 + ozlu2.field_73013_u * 7) / (n4 + 30);
                                if (bl3) {
                                    n8 /= 2;
                                }
                                if (n8 <= 0 || random.nextInt(n7) > n8 || ozlu2.func_72896_J() && ozlu2.func_72951_B(i, k, j) || ozlu2.func_72951_B(i - 1, k, n3) || ozlu2.func_72951_B(i + 1, k, j) || ozlu2.func_72951_B(i, k, j - 1) || ozlu2.func_72951_B(i, k, j + 1)) continue;
                                int n9 = n4 + random.nextInt(5) / 4;
                                if (n9 > 15) {
                                    n9 = 15;
                                }
                                ozlu2.func_72832_d(i, k, j, this.field_71990_ca, n9, 3);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean func_82506_l() {
        return false;
    }

    @Deprecated
    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4, Random random, int n5) {
        this._a(ozlu2, n, n2, n3, n4, random, n5, ForgeDirection.UP);
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4, Random random, int n5, ForgeDirection forgeDirection) {
        int n6 = 0;
        twgu twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(n, n2, n3)];
        if (twgu2 != null) {
            n6 = twgu2.getFlammability(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), forgeDirection);
        }
        if (random.nextInt(n4) < n6) {
            boolean bl;
            boolean bl2 = bl = ozlu2.func_72798_a(n, n2, n3) == twgu.field_72091_am.field_71990_ca;
            if (random.nextInt(n5 + 10) < 5 && !ozlu2.func_72951_B(n, n2, n3)) {
                int n7 = n5 + random.nextInt(5) / 4;
                if (n7 > 15) {
                    n7 = 15;
                }
                ozlu2.func_72832_d(n, n2, n3, this.field_71990_ca, n7, 3);
            } else {
                ozlu2.func_94571_i(n, n2, n3);
            }
            if (bl) {
                twgu.field_72091_am.func_71898_d(ozlu2, n, n2, n3, 1);
            }
        }
    }

    public boolean _a(ozlu ozlu2, int n, int n2, int n3) {
        return this._a((sdrg)ozlu2, n + 1, n2, n3, ForgeDirection.WEST) || this._a((sdrg)ozlu2, n - 1, n2, n3, ForgeDirection.EAST) || this._a((sdrg)ozlu2, n, n2 - 1, n3, ForgeDirection.UP) || this._a((sdrg)ozlu2, n, n2 + 1, n3, ForgeDirection.DOWN) || this._a((sdrg)ozlu2, n, n2, n3 - 1, ForgeDirection.SOUTH) || this._a((sdrg)ozlu2, n, n2, n3 + 1, ForgeDirection.NORTH);
    }

    public int _b(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = 0;
        if (!ozlu2.func_72799_c(n, n2, n3)) {
            return 0;
        }
        int n5 = this._a(ozlu2, n + 1, n2, n3, n4, ForgeDirection.WEST);
        n5 = this._a(ozlu2, n - 1, n2, n3, n5, ForgeDirection.EAST);
        n5 = this._a(ozlu2, n, n2 - 1, n3, n5, ForgeDirection.UP);
        n5 = this._a(ozlu2, n, n2 + 1, n3, n5, ForgeDirection.DOWN);
        n5 = this._a(ozlu2, n, n2, n3 - 1, n5, ForgeDirection.SOUTH);
        n5 = this._a(ozlu2, n, n2, n3 + 1, n5, ForgeDirection.NORTH);
        return n5;
    }

    @Override
    public boolean func_71935_l() {
        return false;
    }

    @Deprecated
    public boolean _a(sdrg sdrg2, int n, int n2, int n3) {
        return this._a(sdrg2, n, n2, n3, ForgeDirection.UP);
    }

    @Deprecated
    public int _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        return this._a(ozlu2, n, n2, n3, n4, ForgeDirection.UP);
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.func_72797_t(n, n2 - 1, n3) || this._a(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (!ozlu2.func_72797_t(n, n2 - 1, n3) && !this._a(ozlu2, n, n2, n3)) {
            ozlu2.func_94571_i(n, n2, n3);
        }
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        if (ozlu2.field_73011_w._i > 0 || ozlu2.func_72798_a(n, n2 - 1, n3) != twgu.field_72089_ap.field_71990_ca || !twgu.field_72015_be._a(ozlu2, n, n2, n3)) {
            if (!ozlu2.func_72797_t(n, n2 - 1, n3) && !this._a(ozlu2, n, n2, n3)) {
                ozlu2.func_94571_i(n, n2, n3);
            } else {
                ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.func_71859_p_(ozlu2) + ozlu2.field_73012_v.nextInt(10));
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        block12: {
            block11: {
                float f;
                float f2;
                float f3;
                int n4;
                if (random.nextInt(24) == 0) {
                    ozlu2.func_72980_b((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "fire.fire", 1.0f + random.nextFloat(), random.nextFloat() * 0.7f + 0.3f, false);
                }
                if (ozlu2.func_72797_t(n, n2 - 1, n3) || twgu.field_72067_ar._a((sdrg)ozlu2, n, n2 - 1, n3, ForgeDirection.UP)) break block11;
                if (twgu.field_72067_ar._a((sdrg)ozlu2, n - 1, n2, n3, ForgeDirection.EAST)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)n + random.nextFloat() * 0.1f;
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)n3 + random.nextFloat();
                        ozlu2.func_72869_a("largesmoke", f3, f2, f, 0.0, 0.0, 0.0);
                    }
                }
                if (twgu.field_72067_ar._a((sdrg)ozlu2, n + 1, n2, n3, ForgeDirection.WEST)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)(n + 1) - random.nextFloat() * 0.1f;
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)n3 + random.nextFloat();
                        ozlu2.func_72869_a("largesmoke", f3, f2, f, 0.0, 0.0, 0.0);
                    }
                }
                if (twgu.field_72067_ar._a((sdrg)ozlu2, n, n2, n3 - 1, ForgeDirection.SOUTH)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)n + random.nextFloat();
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)n3 + random.nextFloat() * 0.1f;
                        ozlu2.func_72869_a("largesmoke", f3, f2, f, 0.0, 0.0, 0.0);
                    }
                }
                if (twgu.field_72067_ar._a((sdrg)ozlu2, n, n2, n3 + 1, ForgeDirection.NORTH)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)n + random.nextFloat();
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)(n3 + 1) - random.nextFloat() * 0.1f;
                        ozlu2.func_72869_a("largesmoke", f3, f2, f, 0.0, 0.0, 0.0);
                    }
                }
                if (!twgu.field_72067_ar._a((sdrg)ozlu2, n, n2 + 1, n3, ForgeDirection.DOWN)) break block12;
                for (n4 = 0; n4 < 2; ++n4) {
                    f3 = (float)n + random.nextFloat();
                    f2 = (float)(n2 + 1) - random.nextFloat() * 0.1f;
                    f = (float)n3 + random.nextFloat();
                    ozlu2.func_72869_a("largesmoke", f3, f2, f, 0.0, 0.0, 0.0);
                }
                break block12;
            }
            for (int i = 0; i < 3; ++i) {
                float f = (float)n + random.nextFloat();
                float f4 = (float)n2 + random.nextFloat() * 0.5f + 0.5f;
                float f5 = (float)n3 + random.nextFloat();
                ozlu2.func_72869_a("largesmoke", f, f4, f5, 0.0, 0.0, 0.0);
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this._c = new dwan[]{nege2._b(this.func_111023_E() + "_layer_0"), nege2._b(this.func_111023_E() + "_layer_1")};
    }

    @SideOnly(value=Side.CLIENT)
    public dwan _a(int n) {
        return this._c[n];
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        return this._c[0];
    }

    public boolean _a(sdrg sdrg2, int n, int n2, int n3, ForgeDirection forgeDirection) {
        twgu twgu2 = twgu.field_71973_m[sdrg2.func_72798_a(n, n2, n3)];
        if (twgu2 != null) {
            return twgu2.isFlammable(sdrg2, n, n2, n3, sdrg2.func_72805_g(n, n2, n3), forgeDirection);
        }
        return false;
    }

    public int _a(ozlu ozlu2, int n, int n2, int n3, int n4, ForgeDirection forgeDirection) {
        int n5 = 0;
        twgu twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(n, n2, n3)];
        if (twgu2 != null) {
            n5 = twgu2.getFireSpreadSpeed(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), forgeDirection);
        }
        return n5 > n4 ? n5 : n4;
    }
}

