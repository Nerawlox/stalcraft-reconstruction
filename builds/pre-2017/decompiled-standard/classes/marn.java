/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraftforge.common.IShearable;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.renderer.BetterLeavesRenderer;

public class marn
extends cuwo
implements IShearable {
    public static final String[] _a = new String[]{"oak", "spruce", "birch", "jungle"};
    public static final String[][] _b = new String[][]{{"leaves_oak", "leaves_spruce", "leaves_birch", "leaves_jungle"}, {"leaves_oak_opaque", "leaves_spruce_opaque", "leaves_birch_opaque", "leaves_jungle_opaque"}};
    @SideOnly(value=Side.CLIENT)
    public int _c;
    public dwan[][] _d = new dwan[2][];
    public int[] _e;

    public marn(int n) {
        super(n, tflj._j, false);
        this.func_71907_b(true);
        this.func_71849_a(tgbl.field_78031_c);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71933_m() {
        double d = 0.5;
        double d2 = 1.0;
        return igvq._a(d, d2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71889_f_(int n) {
        return (n & 3) == 1 ? igvq._a() : ((n & 3) == 2 ? igvq._b() : igvq._c());
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71920_b(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        if ((n4 & 3) == 1) {
            return igvq._a();
        }
        if ((n4 & 3) == 2) {
            return igvq._b();
        }
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                int n8 = sdrg2.func_72807_a(n + j, n3 + i)._m();
                n5 += (n8 & 0xFF0000) >> 16;
                n6 += (n8 & 0xFF00) >> 8;
                n7 += n8 & 0xFF;
            }
        }
        return (n5 / 9 & 0xFF) << 16 | (n6 / 9 & 0xFF) << 8 | n7 / 9 & 0xFF;
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        int n6 = 1;
        int n7 = n6 + 1;
        if (ozlu2.func_72904_c(n - n7, n2 - n7, n3 - n7, n + n7, n2 + n7, n3 + n7)) {
            for (int i = -n6; i <= n6; ++i) {
                for (int j = -n6; j <= n6; ++j) {
                    for (int k = -n6; k <= n6; ++k) {
                        int n8 = ozlu2.func_72798_a(n + i, n2 + j, n3 + k);
                        if (twgu.field_71973_m[n8] == null) continue;
                        twgu.field_71973_m[n8].beginLeavesDecay(ozlu2, n + i, n2 + j, n3 + k);
                    }
                }
            }
        }
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        int n4;
        if (!ozlu2.field_72995_K && ((n4 = ozlu2.func_72805_g(n, n2, n3)) & 8) != 0 && (n4 & 4) == 0) {
            int n5;
            int n6 = 4;
            int n7 = n6 + 1;
            int n8 = 32;
            int n9 = n8 * n8;
            int n10 = n8 / 2;
            if (this._e == null) {
                this._e = new int[n8 * n8 * n8];
            }
            if (ozlu2.func_72904_c(n - n7, n2 - n7, n3 - n7, n + n7, n2 + n7, n3 + n7)) {
                int n11;
                int n12;
                int n13;
                for (n5 = -n6; n5 <= n6; ++n5) {
                    for (n13 = -n6; n13 <= n6; ++n13) {
                        for (n12 = -n6; n12 <= n6; ++n12) {
                            n11 = ozlu2.func_72798_a(n + n5, n2 + n13, n3 + n12);
                            twgu twgu2 = twgu.field_71973_m[n11];
                            this._e[(n5 + n10) * n9 + (n13 + n10) * n8 + n12 + n10] = twgu2 != null && twgu2.canSustainLeaves(ozlu2, n + n5, n2 + n13, n3 + n12) ? 0 : (twgu2 != null && twgu2.isLeaves(ozlu2, n + n5, n2 + n13, n3 + n12) ? -2 : -1);
                        }
                    }
                }
                for (n5 = 1; n5 <= 4; ++n5) {
                    for (n13 = -n6; n13 <= n6; ++n13) {
                        for (n12 = -n6; n12 <= n6; ++n12) {
                            for (n11 = -n6; n11 <= n6; ++n11) {
                                if (this._e[(n13 + n10) * n9 + (n12 + n10) * n8 + n11 + n10] != n5 - 1) continue;
                                if (this._e[(n13 + n10 - 1) * n9 + (n12 + n10) * n8 + n11 + n10] == -2) {
                                    this._e[(n13 + n10 - 1) * n9 + (n12 + n10) * n8 + n11 + n10] = n5;
                                }
                                if (this._e[(n13 + n10 + 1) * n9 + (n12 + n10) * n8 + n11 + n10] == -2) {
                                    this._e[(n13 + n10 + 1) * n9 + (n12 + n10) * n8 + n11 + n10] = n5;
                                }
                                if (this._e[(n13 + n10) * n9 + (n12 + n10 - 1) * n8 + n11 + n10] == -2) {
                                    this._e[(n13 + n10) * n9 + (n12 + n10 - 1) * n8 + n11 + n10] = n5;
                                }
                                if (this._e[(n13 + n10) * n9 + (n12 + n10 + 1) * n8 + n11 + n10] == -2) {
                                    this._e[(n13 + n10) * n9 + (n12 + n10 + 1) * n8 + n11 + n10] = n5;
                                }
                                if (this._e[(n13 + n10) * n9 + (n12 + n10) * n8 + (n11 + n10 - 1)] == -2) {
                                    this._e[(n13 + n10) * n9 + (n12 + n10) * n8 + (n11 + n10 - 1)] = n5;
                                }
                                if (this._e[(n13 + n10) * n9 + (n12 + n10) * n8 + n11 + n10 + 1] != -2) continue;
                                this._e[(n13 + n10) * n9 + (n12 + n10) * n8 + n11 + n10 + 1] = n5;
                            }
                        }
                    }
                }
            }
            if ((n5 = this._e[n10 * n9 + n10 * n8 + n10]) >= 0) {
                ozlu2.func_72921_c(n, n2, n3, n4 & 0xFFFFFFF7, 4);
            } else {
                this._a(ozlu2, n, n2, n3);
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (ozlu2.func_72951_B(n, n2 + 1, n3) && !ozlu2.func_72797_t(n, n2 - 1, n3) && random.nextInt(15) == 1) {
            double d = (float)n + random.nextFloat();
            double d2 = (double)n2 - 0.05;
            double d3 = (float)n3 + random.nextFloat();
            ozlu2.func_72869_a("dripWater", d, d2, d3, 0.0, 0.0, 0.0);
        }
        super.func_71862_a(ozlu2, n, n2, n3, random);
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
        ozlu2.func_94571_i(n, n2, n3);
    }

    @Override
    public int func_71925_a(Random random) {
        return random.nextInt(20) == 0 ? 1 : 0;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return twgu.field_71987_y.field_71990_ca;
    }

    @Override
    public void func_71914_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, int n5) {
        if (!ozlu2.field_72995_K) {
            int n6 = 20;
            if ((n4 & 3) == 3) {
                n6 = 40;
            }
            if (n5 > 0 && (n6 -= 2 << n5) < 10) {
                n6 = 10;
            }
            if (ozlu2.field_73012_v.nextInt(n6) == 0) {
                int n7 = this.func_71885_a(n4, ozlu2.field_73012_v, n5);
                this.func_71929_a(ozlu2, n, n2, n3, new cvzo(n7, 1, this.func_71899_b(n4)));
            }
            n6 = 200;
            if (n5 > 0 && (n6 -= 10 << n5) < 40) {
                n6 = 40;
            }
            if ((n4 & 3) == 0 && ozlu2.field_73012_v.nextInt(n6) == 0) {
                this.func_71929_a(ozlu2, n, n2, n3, new cvzo(tgdv.field_77706_j, 1, 0));
            }
        }
    }

    @Override
    public void func_71893_a(ozlu ozlu2, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        super.func_71893_a(ozlu2, entityPlayer, n, n2, n3, n4);
    }

    @Override
    public int func_71899_b(int n) {
        return n & 3;
    }

    @Override
    public boolean func_71926_d() {
        return !this._f;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(boolean bl) {
        this._f = bl;
        this._c = bl ? 0 : 1;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_71879_a(int n, tgbl tgbl2, List list) {
        list.add(new cvzo(n, 1, 0));
        list.add(new cvzo(n, 1, 1));
        list.add(new cvzo(n, 1, 2));
        list.add(new cvzo(n, 1, 3));
    }

    @Override
    public cvzo func_71880_c_(int n) {
        return new cvzo(this.field_71990_ca, 1, n & 3);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        for (int i = 0; i < _b.length; ++i) {
            this._d[i] = new dwan[_b[i].length];
            for (int j = 0; j < _b[i].length; ++j) {
                this._d[i][j] = nege2._b(_b[i][j]);
            }
        }
    }

    @Override
    public boolean isShearable(cvzo cvzo2, ozlu ozlu2, int n, int n2, int n3) {
        return true;
    }

    @Override
    public ArrayList<cvzo> onSheared(cvzo cvzo2, ozlu ozlu2, int n, int n2, int n3, int n4) {
        ArrayList<cvzo> arrayList = new ArrayList<cvzo>();
        arrayList.add(new cvzo(this, 1, ozlu2.func_72805_g(n, n2, n3) & 3));
        return arrayList;
    }

    @Override
    public void beginLeavesDecay(ozlu ozlu2, int n, int n2, int n3) {
        ozlu2.func_72921_c(n, n2, n3, ozlu2.func_72805_g(n, n2, n3) | 8, 4);
    }

    @Override
    public boolean isLeaves(ozlu ozlu2, int n, int n2, int n3) {
        return true;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        if (this._f && BetterGrassAndLeavesMod.modActive && ((Boolean)BetterGrassAndLeavesMod.useRoundedVanillaLeaves.value).booleanValue() && this == twgu.field_71952_K && BetterLeavesRenderer.iconRoundedLeaves[n2 & 3] != null) {
            return BetterLeavesRenderer.iconRoundedLeaves[n2 & 3];
        }
        return this._d[this._c][n2 & 3];
    }

    @Override
    public dwan getIconBetterLeaves(int n, float f) {
        if (BetterLeavesRenderer.iconBetterLeaves == null || this != twgu.field_71952_K) {
            return super.getIconBetterLeaves(n, f);
        }
        int n2 = n & 3;
        return BetterLeavesRenderer.iconBetterLeaves[n2][(int)(f * (float)(BetterLeavesRenderer.iconBetterLeaves[n2].length - 1) + 0.5f)];
    }

    @Override
    public dwan getIconFallingLeaves(int n) {
        if (BetterLeavesRenderer.iconFallingLeaves == null || this != twgu.field_71952_K) {
            return super.getIconFallingLeaves(n);
        }
        return BetterLeavesRenderer.iconFallingLeaves[n & 3];
    }
}

