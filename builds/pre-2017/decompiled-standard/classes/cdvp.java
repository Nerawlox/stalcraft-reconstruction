/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.owak;
import net.minecraft.util.sajh;

public class cdvp
extends twgu {
    public final boolean _a;
    @SideOnly(value=Side.CLIENT)
    public dwan _b;
    @SideOnly(value=Side.CLIENT)
    public dwan _c;
    @SideOnly(value=Side.CLIENT)
    public dwan _d;

    public cdvp(int n, boolean bl) {
        super(n, tflj._G);
        this._a = bl;
        this.func_71884_a(field_71976_h);
        this.func_71848_c(0.5f);
        this.func_71849_a(tgbl.field_78028_d);
    }

    @SideOnly(value=Side.CLIENT)
    public dwan _a() {
        return this._d;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_71905_a(f, f2, f3, f4, f5, f6);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        int n3 = cdvp._a(n2);
        return n3 > 5 ? this._d : (n == n3 ? (!cdvp._b(n2) && this.field_72026_ch <= 0.0 && this.field_72023_ci <= 0.0 && this.field_72024_cj <= 0.0 && this.field_72021_ck >= 1.0 && this.field_72022_cl >= 1.0 && this.field_72019_cm >= 1.0 ? this._d : this._b) : (n == owak._a[n3] ? this._c : this.field_94336_cN));
    }

    @SideOnly(value=Side.CLIENT)
    public static dwan _a(String string) {
        return string == "piston_side" ? twgu.field_71963_Z.field_94336_cN : (string == "piston_top_normal" ? twgu.field_71963_Z._d : (string == "piston_top_sticky" ? twgu.field_71956_V._d : (string == "piston_inner" ? twgu.field_71963_Z._b : null)));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("piston_side");
        this._d = nege2._b(this._a ? "piston_top_sticky" : "piston_top_normal");
        this._b = nege2._b("piston_inner");
        this._c = nege2._b("piston_bottom");
    }

    @Override
    public int func_71857_b() {
        return 16;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        return false;
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = cdvp._a(ozlu2, n, n2, n3, entityLivingBase);
        ozlu2.func_72921_c(n, n2, n3, n4, 2);
        if (!ozlu2.field_72995_K) {
            this._a(ozlu2, n, n2, n3);
        }
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (!ozlu2.field_72995_K) {
            this._a(ozlu2, n, n2, n3);
        }
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        if (!ozlu2.field_72995_K && ozlu2.func_72796_p(n, n2, n3) == null) {
            this._a(ozlu2, n, n2, n3);
        }
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        int n5 = cdvp._a(n4);
        if (n5 != 7) {
            boolean bl = this._a(ozlu2, n, n2, n3, n5);
            if (bl && !cdvp._b(n4)) {
                if (cdvp._b(ozlu2, n, n2, n3, n5)) {
                    ozlu2.func_72965_b(n, n2, n3, this.field_71990_ca, 0, n5);
                }
            } else if (!bl && cdvp._b(n4)) {
                ozlu2.func_72921_c(n, n2, n3, n5, 2);
                ozlu2.func_72965_b(n, n2, n3, this.field_71990_ca, 1, n5);
            }
        }
    }

    public boolean _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        return n4 != 0 && ozlu2.func_94574_k(n, n2 - 1, n3, 0) ? true : (n4 != 1 && ozlu2.func_94574_k(n, n2 + 1, n3, 1) ? true : (n4 != 2 && ozlu2.func_94574_k(n, n2, n3 - 1, 2) ? true : (n4 != 3 && ozlu2.func_94574_k(n, n2, n3 + 1, 3) ? true : (n4 != 5 && ozlu2.func_94574_k(n + 1, n2, n3, 5) ? true : (n4 != 4 && ozlu2.func_94574_k(n - 1, n2, n3, 4) ? true : (ozlu2.func_94574_k(n, n2, n3, 0) ? true : (ozlu2.func_94574_k(n, n2 + 2, n3, 1) ? true : (ozlu2.func_94574_k(n, n2 + 1, n3 - 1, 2) ? true : (ozlu2.func_94574_k(n, n2 + 1, n3 + 1, 3) ? true : (ozlu2.func_94574_k(n - 1, n2 + 1, n3, 4) ? true : ozlu2.func_94574_k(n + 1, n2 + 1, n3, 5)))))))))));
    }

    @Override
    public boolean func_71883_b(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        if (!ozlu2.field_72995_K) {
            boolean bl = this._a(ozlu2, n, n2, n3, n5);
            if (bl && n4 == 1) {
                ozlu2.func_72921_c(n, n2, n3, n5 | 8, 2);
                return false;
            }
            if (!bl && n4 == 0) {
                return false;
            }
        }
        if (n4 == 0) {
            if (!this._c(ozlu2, n, n2, n3, n5)) {
                return false;
            }
            ozlu2.func_72921_c(n, n2, n3, n5 | 8, 2);
            ozlu2.func_72908_a((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "tile.piston.out", 0.5f, ozlu2.field_73012_v.nextFloat() * 0.25f + 0.6f);
        } else if (n4 == 1) {
            hurg hurg2 = ozlu2.func_72796_p(n + owak._b[n5], n2 + owak._c[n5], n3 + owak._d[n5]);
            if (hurg2 instanceof mcbr) {
                ((mcbr)hurg2)._e();
            }
            ozlu2.func_72832_d(n, n2, n3, twgu.field_72095_ac.field_71990_ca, n5, 3);
            ozlu2.func_72837_a(n, n2, n3, uzku._a(this.field_71990_ca, n5, n5, false, true));
            if (this._a) {
                mcbr mcbr2;
                hurg hurg3;
                int n6 = n + owak._b[n5] * 2;
                int n7 = n2 + owak._c[n5] * 2;
                int n8 = n3 + owak._d[n5] * 2;
                int n9 = ozlu2.func_72798_a(n6, n7, n8);
                int n10 = ozlu2.func_72805_g(n6, n7, n8);
                boolean bl = false;
                if (n9 == twgu.field_72095_ac.field_71990_ca && (hurg3 = ozlu2.func_72796_p(n6, n7, n8)) instanceof mcbr && (mcbr2 = (mcbr)hurg3)._c() == n5 && mcbr2._b()) {
                    mcbr2._e();
                    n9 = mcbr2._a();
                    n10 = mcbr2.func_70322_n();
                    bl = true;
                }
                if (!bl && n9 > 0 && cdvp._a(n9, ozlu2, n6, n7, n8, false) && (twgu.field_71973_m[n9].func_71915_e() == 0 || n9 == twgu.field_71963_Z.field_71990_ca || n9 == twgu.field_71956_V.field_71990_ca)) {
                    ozlu2.func_72832_d(n += owak._b[n5], n2 += owak._c[n5], n3 += owak._d[n5], twgu.field_72095_ac.field_71990_ca, n10, 3);
                    ozlu2.func_72837_a(n, n2, n3, uzku._a(n9, n10, n5, false, false));
                    ozlu2.func_94571_i(n6, n7, n8);
                } else if (!bl) {
                    ozlu2.func_94571_i(n + owak._b[n5], n2 + owak._c[n5], n3 + owak._d[n5]);
                }
            } else {
                ozlu2.func_94571_i(n + owak._b[n5], n2 + owak._c[n5], n3 + owak._d[n5]);
            }
            ozlu2.func_72908_a((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "tile.piston.in", 0.5f, ozlu2.field_73012_v.nextFloat() * 0.15f + 0.6f);
        }
        return true;
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        if (cdvp._b(n4)) {
            float f = 0.25f;
            switch (cdvp._a(n4)) {
                case 0: {
                    this.func_71905_a(0.0f, 0.25f, 0.0f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 1: {
                    this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
                    break;
                }
                case 2: {
                    this.func_71905_a(0.0f, 0.0f, 0.25f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 3: {
                    this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.75f);
                    break;
                }
                case 4: {
                    this.func_71905_a(0.25f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 5: {
                    this.func_71905_a(0.0f, 0.0f, 0.0f, 0.75f, 1.0f, 1.0f);
                }
            }
        } else {
            this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    @Override
    public void func_71919_f() {
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list2, Entity entity) {
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        this.func_71902_a(ozlu2, n, n2, n3);
        return super.func_71872_e(ozlu2, n, n2, n3);
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    public static int _a(int n) {
        return n & 7;
    }

    public static boolean _b(int n) {
        return (n & 8) != 0;
    }

    public static int _a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase) {
        int n4;
        if (sajh._e((float)entityLivingBase.field_70165_t - (float)n) < 2.0f && sajh._e((float)entityLivingBase.field_70161_v - (float)n3) < 2.0f) {
            double d = entityLivingBase.field_70163_u + 1.82 - (double)entityLivingBase.field_70129_M;
            if (d - (double)n2 > 2.0) {
                return 1;
            }
            if ((double)n2 - d > 0.0) {
                return 0;
            }
        }
        return (n4 = sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 0.5) & 3) == 0 ? 2 : (n4 == 1 ? 5 : (n4 == 2 ? 3 : (n4 == 3 ? 4 : 0)));
    }

    public static boolean _a(int n, ozlu ozlu2, int n2, int n3, int n4, boolean bl) {
        if (n == twgu.field_72089_ap.field_71990_ca) {
            return false;
        }
        if (n != twgu.field_71963_Z.field_71990_ca && n != twgu.field_71956_V.field_71990_ca) {
            if (twgu.field_71973_m[n].func_71934_m(ozlu2, n2, n3, n4) == -1.0f) {
                return false;
            }
            if (twgu.field_71973_m[n].func_71915_e() == 2) {
                return false;
            }
            if (twgu.field_71973_m[n].func_71915_e() == 1) {
                return bl;
            }
        } else if (cdvp._b(ozlu2.func_72805_g(n2, n3, n4))) {
            return false;
        }
        return !ozlu2.func_72927_d(n2, n3, n4);
    }

    public static boolean _b(ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5 = n + owak._b[n4];
        int n6 = n2 + owak._c[n4];
        int n7 = n3 + owak._d[n4];
        for (int i = 0; i < 13; ++i) {
            if (n6 <= 0 || n6 >= ozlu2.func_72800_K() - 1) {
                return false;
            }
            int n8 = ozlu2.func_72798_a(n5, n6, n7);
            if (ozlu2.func_72799_c(n5, n6, n7)) break;
            if (!cdvp._a(n8, ozlu2, n5, n6, n7, true)) {
                return false;
            }
            if (twgu.field_71973_m[n8].func_71915_e() == 1) break;
            if (i == 12) {
                return false;
            }
            n5 += owak._b[n4];
            n6 += owak._c[n4];
            n7 += owak._d[n4];
        }
        return true;
    }

    public boolean _c(ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10 = n + owak._b[n4];
        int n11 = n2 + owak._c[n4];
        int n12 = n3 + owak._d[n4];
        for (n9 = 0; n9 < 13; ++n9) {
            if (n11 <= 0 || n11 >= ozlu2.func_72800_K() - 1) {
                return false;
            }
            n8 = ozlu2.func_72798_a(n10, n11, n12);
            if (ozlu2.func_72799_c(n10, n11, n12)) break;
            if (!cdvp._a(n8, ozlu2, n10, n11, n12, true)) {
                return false;
            }
            if (twgu.field_71973_m[n8].func_71915_e() != 1) {
                if (n9 == 12) {
                    return false;
                }
                n10 += owak._b[n4];
                n11 += owak._c[n4];
                n12 += owak._d[n4];
                continue;
            }
            float f = twgu.field_71973_m[n8] instanceof zgzq ? -1.0f : 1.0f;
            twgu.field_71973_m[n8].func_71914_a(ozlu2, n10, n11, n12, ozlu2.func_72805_g(n10, n11, n12), f, 0);
            ozlu2.func_94571_i(n10, n11, n12);
            break;
        }
        n9 = n10;
        n8 = n11;
        int n13 = n12;
        int n14 = 0;
        int[] nArray = new int[13];
        while (n10 != n || n11 != n2 || n12 != n3) {
            n7 = n10 - owak._b[n4];
            n6 = n11 - owak._c[n4];
            n5 = n12 - owak._d[n4];
            int n15 = ozlu2.func_72798_a(n7, n6, n5);
            int n16 = ozlu2.func_72805_g(n7, n6, n5);
            if (n15 == this.field_71990_ca && n7 == n && n6 == n2 && n5 == n3) {
                ozlu2.func_72832_d(n10, n11, n12, twgu.field_72095_ac.field_71990_ca, n4 | (this._a ? 8 : 0), 4);
                ozlu2.func_72837_a(n10, n11, n12, uzku._a(twgu.field_72099_aa.field_71990_ca, n4 | (this._a ? 8 : 0), n4, true, false));
            } else {
                ozlu2.func_72832_d(n10, n11, n12, twgu.field_72095_ac.field_71990_ca, n16, 4);
                ozlu2.func_72837_a(n10, n11, n12, uzku._a(n15, n16, n4, true, false));
            }
            nArray[n14++] = n15;
            n10 = n7;
            n11 = n6;
            n12 = n5;
        }
        n10 = n9;
        n11 = n8;
        n12 = n13;
        n14 = 0;
        while (n10 != n || n11 != n2 || n12 != n3) {
            n7 = n10 - owak._b[n4];
            n6 = n11 - owak._c[n4];
            n5 = n12 - owak._d[n4];
            ozlu2.func_72898_h(n7, n6, n5, nArray[n14++]);
            n10 = n7;
            n11 = n6;
            n12 = n5;
        }
        return true;
    }
}

