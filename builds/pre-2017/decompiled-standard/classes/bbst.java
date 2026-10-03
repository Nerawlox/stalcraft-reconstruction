/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.amww;
import net.minecraft.util.hank;
import net.minecraft.util.ugqx;

public class bbst
extends tgdv {
    public bbst(int n) {
        super(n);
        this.func_77637_a(tgbl.field_78026_f);
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        int n5 = ozlu2.func_72798_a(n, n2, n3);
        int n6 = ozlu2.func_72805_g(n, n2, n3);
        if (entityPlayer.func_82247_a(n, n2, n3, n4, cvzo2) && n5 == twgu.field_72104_bI.field_71990_ca && !uigs._a(n6)) {
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            if (ozlu2.field_72995_K) {
                return true;
            }
            ozlu2.func_72921_c(n, n2, n3, n6 + 4, 2);
            ozlu2.func_96440_m(n, n2, n3, twgu.field_72104_bI.field_71990_ca);
            --cvzo2._b;
            for (n12 = 0; n12 < 16; ++n12) {
                double d = (float)n + (5.0f + field_77697_d.nextFloat() * 6.0f) / 16.0f;
                double d2 = (float)n2 + 0.8125f;
                double d3 = (float)n3 + (5.0f + field_77697_d.nextFloat() * 6.0f) / 16.0f;
                double d4 = 0.0;
                double d5 = 0.0;
                double d6 = 0.0;
                ozlu2.func_72869_a("smoke", d, d2, d3, d4, d5, d6);
            }
            n12 = n6 & 3;
            int n13 = 0;
            int n14 = 0;
            boolean bl = false;
            boolean bl2 = true;
            int n15 = ugqx._g[n12];
            for (n11 = -2; n11 <= 2; ++n11) {
                n10 = n + ugqx._a[n15] * n11;
                n9 = n3 + ugqx._b[n15] * n11;
                n8 = ozlu2.func_72798_a(n10, n2, n9);
                if (n8 != twgu.field_72104_bI.field_71990_ca) continue;
                n7 = ozlu2.func_72805_g(n10, n2, n9);
                if (!uigs._a(n7)) {
                    bl2 = false;
                    break;
                }
                n14 = n11;
                if (bl) continue;
                n13 = n11;
                bl = true;
            }
            if (bl2 && n14 == n13 + 2) {
                for (n11 = n13; n11 <= n14; ++n11) {
                    n10 = n + ugqx._a[n15] * n11;
                    n9 = n3 + ugqx._b[n15] * n11;
                    n8 = ozlu2.func_72798_a(n10 += ugqx._a[n12] * 4, n2, n9 += ugqx._b[n12] * 4);
                    n7 = ozlu2.func_72805_g(n10, n2, n9);
                    if (n8 == twgu.field_72104_bI.field_71990_ca && uigs._a(n7)) continue;
                    bl2 = false;
                    break;
                }
                block3: for (n11 = n13 - 1; n11 <= n14 + 1; n11 += 4) {
                    for (n10 = 1; n10 <= 3; ++n10) {
                        n9 = n + ugqx._a[n15] * n11;
                        n8 = n3 + ugqx._b[n15] * n11;
                        n7 = ozlu2.func_72798_a(n9 += ugqx._a[n12] * n10, n2, n8 += ugqx._b[n12] * n10);
                        int n16 = ozlu2.func_72805_g(n9, n2, n8);
                        if (n7 == twgu.field_72104_bI.field_71990_ca && uigs._a(n16)) continue;
                        bl2 = false;
                        continue block3;
                    }
                }
                if (bl2) {
                    for (n11 = n13; n11 <= n14; ++n11) {
                        for (n10 = 1; n10 <= 3; ++n10) {
                            n9 = n + ugqx._a[n15] * n11;
                            n8 = n3 + ugqx._b[n15] * n11;
                            ozlu2.func_72832_d(n9 += ugqx._a[n12] * n10, n2, n8 += ugqx._b[n12] * n10, twgu.field_72102_bH.field_71990_ca, 0, 2);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        xtcd xtcd2;
        int n;
        hank hank2 = this.func_77621_a(ozlu2, entityPlayer, false);
        if (hank2 != null && hank2._c == amww._a && (n = ozlu2.func_72798_a(hank2._d, hank2._e, hank2._f)) == twgu.field_72104_bI.field_71990_ca) {
            return cvzo2;
        }
        if (!ozlu2.field_72995_K && (xtcd2 = ozlu2.func_72946_b("Stronghold", (int)entityPlayer.field_70165_t, (int)entityPlayer.field_70163_u, (int)entityPlayer.field_70161_v)) != null) {
            EntityEnderEye entityEnderEye = new EntityEnderEye(ozlu2, entityPlayer.field_70165_t, entityPlayer.field_70163_u + 1.62 - (double)entityPlayer.field_70129_M, entityPlayer.field_70161_v);
            entityEnderEye.func_70220_a(xtcd2._d, xtcd2._e, xtcd2._f);
            ozlu2.func_72838_d(entityEnderEye);
            ozlu2.func_72956_a(entityPlayer, "random.bow", 0.5f, 0.4f / (field_77697_d.nextFloat() * 0.4f + 0.8f));
            ozlu2.func_72889_a(null, 1002, (int)entityPlayer.field_70165_t, (int)entityPlayer.field_70163_u, (int)entityPlayer.field_70161_v, 0);
            if (!entityPlayer.field_71075_bZ._d) {
                --cvzo2._b;
            }
        }
        return cvzo2;
    }
}

