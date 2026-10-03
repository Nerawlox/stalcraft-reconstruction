/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;

public class wppj
extends nvwc {
    public wppj(int n) {
        super(n);
        this.func_77627_a(true);
    }

    @SideOnly(value=Side.CLIENT)
    public static thdd _a(short s, ozlu ozlu2) {
        String string = "map_" + s;
        thdd thdd2 = (thdd)ozlu2.func_72943_a(thdd.class, string);
        if (thdd2 == null) {
            thdd2 = new thdd(string);
            ozlu2.func_72823_a(string, thdd2);
        }
        return thdd2;
    }

    public thdd _a(cvzo cvzo2, ozlu ozlu2) {
        String string = "map_" + cvzo2._j();
        thdd thdd2 = (thdd)ozlu2.func_72943_a(thdd.class, string);
        if (thdd2 == null && !ozlu2.field_72995_K) {
            cvzo2._b(ozlu2.func_72841_b("map"));
            string = "map_" + cvzo2._j();
            thdd2 = new thdd(string);
            thdd2._d = (byte)3;
            int n = 128 * (1 << thdd2._d);
            thdd2._a = Math.round((float)ozlu2.func_72912_H()._c() / (float)n) * n;
            thdd2._b = Math.round(ozlu2.func_72912_H()._e() / n) * n;
            thdd2._c = ozlu2.field_73011_w._i;
            thdd2.func_76185_a();
            ozlu2.func_72823_a(string, thdd2);
        }
        return thdd2;
    }

    public void _a(ozlu ozlu2, Entity entity, thdd thdd2) {
        if (ozlu2.field_73011_w._i == thdd2._c && entity instanceof EntityPlayer) {
            int n = 128;
            int n2 = 128;
            int n3 = 1 << thdd2._d;
            int n4 = thdd2._a;
            int n5 = thdd2._b;
            int n6 = sajh._c(entity.field_70165_t - (double)n4) / n3 + n / 2;
            int n7 = sajh._c(entity.field_70161_v - (double)n5) / n3 + n2 / 2;
            int n8 = 128 / n3;
            if (ozlu2.field_73011_w._g) {
                n8 /= 2;
            }
            ihdx ihdx2 = thdd2._a((EntityPlayer)entity);
            ++ihdx2._g;
            for (int i = n6 - n8 + 1; i < n6 + n8; ++i) {
                if ((i & 0xF) != (ihdx2._g & 0xF)) continue;
                int n9 = 255;
                int n10 = 0;
                double d = 0.0;
                for (int j = n7 - n8 - 1; j < n7 + n8; ++j) {
                    byte by;
                    byte by2;
                    int n11;
                    int n12;
                    int n13;
                    int n14;
                    int n15;
                    if (i < 0 || j < -1 || i >= n || j >= n2) continue;
                    int n16 = i - n6;
                    int n17 = j - n7;
                    boolean bl = n16 * n16 + n17 * n17 > (n8 - 2) * (n8 - 2);
                    int n18 = (n4 / n3 + i - n / 2) * n3;
                    int n19 = (n5 / n3 + j - n2 / 2) * n3;
                    int[] nArray = new int[twgu.field_71973_m.length];
                    ixzi ixzi2 = ozlu2.func_72938_d(n18, n19);
                    if (ixzi2._i()) continue;
                    int n20 = n18 & 0xF;
                    int n21 = n19 & 0xF;
                    int n22 = 0;
                    double d2 = 0.0;
                    if (ozlu2.field_73011_w._g) {
                        n15 = n18 + n19 * 231871;
                        if (((n15 = n15 * n15 * 31287121 + n15 * 11) >> 20 & 1) == 0) {
                            int n23 = twgu.field_71979_v.field_71990_ca;
                            nArray[n23] = nArray[n23] + 10;
                        } else {
                            int n24 = twgu.field_71981_t.field_71990_ca;
                            nArray[n24] = nArray[n24] + 10;
                        }
                        d2 = 100.0;
                    } else {
                        for (n15 = 0; n15 < n3; ++n15) {
                            for (n14 = 0; n14 < n3; ++n14) {
                                n13 = ixzi2._b(n15 + n20, n14 + n21) + 1;
                                int n25 = 0;
                                if (n13 > 1) {
                                    boolean bl2;
                                    do {
                                        bl2 = true;
                                        n25 = ixzi2._d(n15 + n20, n13 - 1, n14 + n21);
                                        if (n25 == 0) {
                                            bl2 = false;
                                        } else if (n13 > 0 && n25 > 0 && twgu.field_71973_m[n25].field_72018_cp._K == iwnw._b) {
                                            bl2 = false;
                                        }
                                        if (bl2) continue;
                                        if (--n13 <= 0) break;
                                        n25 = ixzi2._d(n15 + n20, n13 - 1, n14 + n21);
                                    } while (n13 > 0 && !bl2);
                                    if (n13 > 0 && n25 != 0 && twgu.field_71973_m[n25].field_72018_cp._d()) {
                                        int n26;
                                        n12 = n13 - 1;
                                        n11 = 0;
                                        do {
                                            n26 = ixzi2._d(n15 + n20, n12--, n14 + n21);
                                            ++n22;
                                        } while (n12 > 0 && n26 != 0 && twgu.field_71973_m[n26].field_72018_cp._d());
                                    }
                                }
                                d2 += (double)n13 / (double)(n3 * n3);
                                int n27 = n25;
                                nArray[n27] = nArray[n27] + 1;
                            }
                        }
                    }
                    n22 /= n3 * n3;
                    n15 = 0;
                    n14 = 0;
                    for (n13 = 0; n13 < twgu.field_71973_m.length; ++n13) {
                        if (nArray[n13] <= n15) continue;
                        n14 = n13;
                        n15 = nArray[n13];
                    }
                    double d3 = (d2 - d) * 4.0 / (double)(n3 + 4) + ((double)(i + j & 1) - 0.5) * 0.4;
                    n11 = 1;
                    if (d3 > 0.6) {
                        n11 = 2;
                    }
                    if (d3 < -0.6) {
                        n11 = 0;
                    }
                    n12 = 0;
                    if (n14 > 0) {
                        iwnw iwnw2 = twgu.field_71973_m[n14].field_72018_cp._K;
                        if (iwnw2 == iwnw._n) {
                            d3 = (double)n22 * 0.1 + (double)(i + j & 1) * 0.2;
                            n11 = 1;
                            if (d3 < 0.5) {
                                n11 = 2;
                            }
                            if (d3 > 0.9) {
                                n11 = 0;
                            }
                        }
                        n12 = iwnw2._q;
                    }
                    d = d2;
                    if (j < 0 || n16 * n16 + n17 * n17 >= n8 * n8 || bl && (i + j & 1) == 0 || (by2 = thdd2._e[i + j * n]) == (by = (byte)(n12 * 4 + n11))) continue;
                    if (n9 > j) {
                        n9 = j;
                    }
                    if (n10 < j) {
                        n10 = j;
                    }
                    thdd2._e[i + j * n] = by;
                }
                if (n9 > n10) continue;
                thdd2._a(i, n9, n10);
            }
        }
    }

    @Override
    public void func_77663_a(cvzo cvzo2, ozlu ozlu2, Entity entity, int n, boolean bl) {
        if (!ozlu2.field_72995_K) {
            thdd thdd2 = this._a(cvzo2, ozlu2);
            if (entity instanceof EntityPlayer) {
                EntityPlayer entityPlayer = (EntityPlayer)entity;
                thdd2._a(entityPlayer, cvzo2);
            }
            if (bl) {
                this._a(ozlu2, entity, thdd2);
            }
        }
    }

    @Override
    public cezg _a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        byte[] byArray = this._a(cvzo2, ozlu2)._a(cvzo2, ozlu2, entityPlayer);
        return byArray == null ? null : new yexp((short)tgdv.field_77744_bd.field_77779_bT, (short)cvzo2._j(), byArray);
    }

    @Override
    public void func_77622_d(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        if (cvzo2._p() && cvzo2._q()._o("map_is_scaling")) {
            thdd thdd2 = tgdv.field_77744_bd._a(cvzo2, ozlu2);
            cvzo2._b(ozlu2.func_72841_b("map"));
            thdd thdd3 = new thdd("map_" + cvzo2._j());
            thdd3._d = (byte)(thdd2._d + 1);
            if (thdd3._d > 4) {
                thdd3._d = (byte)4;
            }
            thdd3._a = thdd2._a;
            thdd3._b = thdd2._b;
            thdd3._c = thdd2._c;
            thdd3.func_76185_a();
            ozlu2.func_72823_a("map_" + cvzo2._j(), thdd3);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(cvzo cvzo2, EntityPlayer entityPlayer, List list2, boolean bl) {
        thdd thdd2 = this._a(cvzo2, entityPlayer.field_70170_p);
        if (bl) {
            if (thdd2 == null) {
                list2.add("Unknown map");
            } else {
                list2.add("Scaling at 1:" + (1 << thdd2._d));
                list2.add("(Level " + thdd2._d + "/" + 4 + ")");
            }
        }
    }
}

