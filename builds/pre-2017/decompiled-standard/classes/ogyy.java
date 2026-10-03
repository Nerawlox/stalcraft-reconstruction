/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.ofbx;

public abstract class ogyy
extends twgu {
    @SideOnly(value=Side.CLIENT)
    public dwan[] _d;

    public ogyy(int n, tflj tflj2) {
        super(n, tflj2);
        float f = 0.0f;
        float f2 = 0.0f;
        this.func_71905_a(0.0f + f2, 0.0f + f, 0.0f + f2, 1.0f + f2, 1.0f + f, 1.0f + f2);
        this.func_71907_b(true);
    }

    @Override
    public boolean func_71918_c(sdrg sdrg2, int n, int n2, int n3) {
        return this.field_72018_cp != tflj._i;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71933_m() {
        return 0xFFFFFF;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71920_b(sdrg sdrg2, int n, int n2, int n3) {
        if (this.field_72018_cp != tflj._h) {
            return 0xFFFFFF;
        }
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                int n7 = sdrg2.func_72807_a(n + j, n3 + i)._n();
                n4 += (n7 & 0xFF0000) >> 16;
                n5 += (n7 & 0xFF00) >> 8;
                n6 += n7 & 0xFF;
            }
        }
        return (n4 / 9 & 0xFF) << 16 | (n5 / 9 & 0xFF) << 8 | n6 / 9 & 0xFF;
    }

    public static float _a(int n) {
        if (n >= 8) {
            n = 0;
        }
        return (float)(n + 1) / 9.0f;
    }

    @Deprecated
    public float _a(sdrg sdrg2, int n, int n2, int n3) {
        return 1.0f - ogyy._a(sdrg2.func_72805_g(n, n2, n3));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        return n != 0 && n != 1 ? this._d[1] : this._d[0];
    }

    public int _e(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.func_72803_f(n, n2, n3) == this.field_72018_cp ? ozlu2.func_72805_g(n, n2, n3) : -1;
    }

    public int _b(sdrg sdrg2, int n, int n2, int n3) {
        if (sdrg2.func_72803_f(n, n2, n3) != this.field_72018_cp) {
            return -1;
        }
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        if (n4 >= 8) {
            n4 = 0;
        }
        return n4;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71913_a(int n, boolean bl) {
        return bl && n == 0;
    }

    @Override
    public boolean func_71924_d(sdrg sdrg2, int n, int n2, int n3, int n4) {
        tflj tflj2 = sdrg2.func_72803_f(n, n2, n3);
        return tflj2 == this.field_72018_cp ? false : (n4 == 1 ? true : (tflj2 == tflj._w ? false : super.func_71924_d(sdrg2, n, n2, n3, n4)));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        tflj tflj2 = sdrg2.func_72803_f(n, n2, n3);
        return tflj2 == this.field_72018_cp ? false : (n4 == 1 ? true : (tflj2 == tflj._w ? false : super.func_71877_c(sdrg2, n, n2, n3, n4)));
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int func_71857_b() {
        return 4;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return 0;
    }

    @Override
    public int func_71925_a(Random random) {
        return 0;
    }

    public ofbx _c(sdrg sdrg2, int n, int n2, int n3) {
        int n4;
        ofbx ofbx2 = sdrg2.func_82732_R()._a(0.0, 0.0, 0.0);
        int n5 = this._b(sdrg2, n, n2, n3);
        for (n4 = 0; n4 < 4; ++n4) {
            int n6;
            int n7;
            int n8 = n;
            int n9 = n3;
            if (n4 == 0) {
                n8 = n - 1;
            }
            if (n4 == 1) {
                n9 = n3 - 1;
            }
            if (n4 == 2) {
                ++n8;
            }
            if (n4 == 3) {
                ++n9;
            }
            if ((n7 = this._b(sdrg2, n8, n2, n9)) < 0) {
                if (sdrg2.func_72803_f(n8, n2, n9)._c() || (n7 = this._b(sdrg2, n8, n2 - 1, n9)) < 0) continue;
                n6 = n7 - (n5 - 8);
                ofbx2 = ofbx2._c((n8 - n) * n6, (n2 - n2) * n6, (n9 - n3) * n6);
                continue;
            }
            if (n7 < 0) continue;
            n6 = n7 - n5;
            ofbx2 = ofbx2._c((n8 - n) * n6, (n2 - n2) * n6, (n9 - n3) * n6);
        }
        if (sdrg2.func_72805_g(n, n2, n3) >= 8) {
            n4 = 0;
            if (n4 != 0 || this.func_71924_d(sdrg2, n, n2, n3 - 1, 2)) {
                n4 = 1;
            }
            if (n4 != 0 || this.func_71924_d(sdrg2, n, n2, n3 + 1, 3)) {
                n4 = 1;
            }
            if (n4 != 0 || this.func_71924_d(sdrg2, n - 1, n2, n3, 4)) {
                n4 = 1;
            }
            if (n4 != 0 || this.func_71924_d(sdrg2, n + 1, n2, n3, 5)) {
                n4 = 1;
            }
            if (n4 != 0 || this.func_71924_d(sdrg2, n, n2 + 1, n3 - 1, 2)) {
                n4 = 1;
            }
            if (n4 != 0 || this.func_71924_d(sdrg2, n, n2 + 1, n3 + 1, 3)) {
                n4 = 1;
            }
            if (n4 != 0 || this.func_71924_d(sdrg2, n - 1, n2 + 1, n3, 4)) {
                n4 = 1;
            }
            if (n4 != 0 || this.func_71924_d(sdrg2, n + 1, n2 + 1, n3, 5)) {
                n4 = 1;
            }
            if (n4 != 0) {
                ofbx2 = ofbx2._a()._c(0.0, -6.0, 0.0);
            }
        }
        ofbx2 = ofbx2._a();
        return ofbx2;
    }

    @Override
    public void func_71901_a(ozlu ozlu2, int n, int n2, int n3, Entity entity, ofbx ofbx2) {
        ofbx ofbx3 = this._c(ozlu2, n, n2, n3);
        ofbx2._c += ofbx3._c;
        ofbx2._d += ofbx3._d;
        ofbx2._e += ofbx3._e;
    }

    @Override
    public int func_71859_p_(ozlu ozlu2) {
        return this.field_72018_cp == tflj._h ? 5 : (this.field_72018_cp == tflj._i ? (ozlu2.field_73011_w._g ? 10 : 30) : 0);
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        this._f(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        this._f(ozlu2, n, n2, n3);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71874_e(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72802_i(n, n2, n3, 0);
        int n5 = sdrg2.func_72802_i(n, n2 + 1, n3, 0);
        int n6 = n4 & 0xFF;
        int n7 = n5 & 0xFF;
        int n8 = n4 >> 16 & 0xFF;
        int n9 = n5 >> 16 & 0xFF;
        return (n6 > n7 ? n6 : n7) | (n8 > n9 ? n8 : n9) << 16;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float func_71870_f(sdrg sdrg2, int n, int n2, int n3) {
        float f;
        float f2 = sdrg2.func_72801_o(n, n2, n3);
        return f2 > (f = sdrg2.func_72801_o(n, n2 + 1, n3)) ? f2 : f;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71856_s_() {
        return this.field_72018_cp == tflj._h ? 1 : 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        double d;
        double d2;
        double d3;
        int n4;
        if (this.field_72018_cp == tflj._h) {
            if (random.nextInt(10) == 0 && ((n4 = ozlu2.func_72805_g(n, n2, n3)) <= 0 || n4 >= 8)) {
                ozlu2.func_72869_a("suspended", (float)n + random.nextFloat(), (float)n2 + random.nextFloat(), (float)n3 + random.nextFloat(), 0.0, 0.0, 0.0);
            }
            for (n4 = 0; n4 < 0; ++n4) {
                int n5 = random.nextInt(4);
                int n6 = n;
                int n7 = n3;
                if (n5 == 0) {
                    n6 = n - 1;
                }
                if (n5 == 1) {
                    ++n6;
                }
                if (n5 == 2) {
                    n7 = n3 - 1;
                }
                if (n5 == 3) {
                    ++n7;
                }
                if (ozlu2.func_72803_f(n6, n2, n7) != tflj._a || !ozlu2.func_72803_f(n6, n2 - 1, n7)._c() && !ozlu2.func_72803_f(n6, n2 - 1, n7)._d()) continue;
                float f = 0.0625f;
                d3 = (float)n + random.nextFloat();
                double d4 = (float)n2 + random.nextFloat();
                double d5 = (float)n3 + random.nextFloat();
                if (n5 == 0) {
                    d3 = (float)n - f;
                }
                if (n5 == 1) {
                    d3 = (float)(n + 1) + f;
                }
                if (n5 == 2) {
                    d5 = (float)n3 - f;
                }
                if (n5 == 3) {
                    d5 = (float)(n3 + 1) + f;
                }
                double d6 = 0.0;
                double d7 = 0.0;
                if (n5 == 0) {
                    d6 = -f;
                }
                if (n5 == 1) {
                    d6 = f;
                }
                if (n5 == 2) {
                    d7 = -f;
                }
                if (n5 == 3) {
                    d7 = f;
                }
                ozlu2.func_72869_a("splash", d3, d4, d5, d6, 0.0, d7);
            }
        }
        if (this.field_72018_cp == tflj._h && random.nextInt(64) == 0 && (n4 = ozlu2.func_72805_g(n, n2, n3)) > 0 && n4 < 8) {
            ozlu2.func_72980_b((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "liquid.water", random.nextFloat() * 0.25f + 0.75f, random.nextFloat() * 1.0f + 0.5f, false);
        }
        if (this.field_72018_cp == tflj._i && ozlu2.func_72803_f(n, n2 + 1, n3) == tflj._a && !ozlu2.func_72804_r(n, n2 + 1, n3)) {
            if (random.nextInt(100) == 0) {
                d2 = (float)n + random.nextFloat();
                d = (double)n2 + this.field_72022_cl;
                d3 = (float)n3 + random.nextFloat();
                ozlu2.func_72869_a("lava", d2, d, d3, 0.0, 0.0, 0.0);
                ozlu2.func_72980_b(d2, d, d3, "liquid.lavapop", 0.2f + random.nextFloat() * 0.2f, 0.9f + random.nextFloat() * 0.15f, false);
            }
            if (random.nextInt(200) == 0) {
                ozlu2.func_72980_b(n, n2, n3, "liquid.lava", 0.2f + random.nextFloat() * 0.2f, 0.9f + random.nextFloat() * 0.15f, false);
            }
        }
        if (random.nextInt(10) == 0 && ozlu2.func_72797_t(n, n2 - 1, n3) && !ozlu2.func_72803_f(n, n2 - 2, n3)._c()) {
            d2 = (float)n + random.nextFloat();
            d = (double)n2 - 1.05;
            d3 = (float)n3 + random.nextFloat();
            if (this.field_72018_cp == tflj._h) {
                ozlu2.func_72869_a("dripWater", d2, d, d3, 0.0, 0.0, 0.0);
            } else {
                ozlu2.func_72869_a("dripLava", d2, d, d3, 0.0, 0.0, 0.0);
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public static double _a(sdrg sdrg2, int n, int n2, int n3, tflj tflj2) {
        ofbx ofbx2 = null;
        if (tflj2 == tflj._h) {
            ofbx2 = twgu.field_71942_A._c(sdrg2, n, n2, n3);
        }
        if (tflj2 == tflj._i) {
            ofbx2 = twgu.field_71944_C._c(sdrg2, n, n2, n3);
        }
        return ofbx2._c == 0.0 && ofbx2._e == 0.0 ? -1000.0 : Math.atan2(ofbx2._e, ofbx2._c) - 1.5707963267948966;
    }

    public void _f(ozlu ozlu2, int n, int n2, int n3) {
        if (ozlu2.func_72798_a(n, n2, n3) == this.field_71990_ca && this.field_72018_cp == tflj._i) {
            boolean bl = false;
            if (bl || ozlu2.func_72803_f(n, n2, n3 - 1) == tflj._h) {
                bl = true;
            }
            if (bl || ozlu2.func_72803_f(n, n2, n3 + 1) == tflj._h) {
                bl = true;
            }
            if (bl || ozlu2.func_72803_f(n - 1, n2, n3) == tflj._h) {
                bl = true;
            }
            if (bl || ozlu2.func_72803_f(n + 1, n2, n3) == tflj._h) {
                bl = true;
            }
            if (bl || ozlu2.func_72803_f(n, n2 + 1, n3) == tflj._h) {
                bl = true;
            }
            if (bl) {
                int n4 = ozlu2.func_72805_g(n, n2, n3);
                if (n4 == 0) {
                    ozlu2.func_94575_c(n, n2, n3, twgu.field_72089_ap.field_71990_ca);
                } else if (n4 <= 4) {
                    ozlu2.func_94575_c(n, n2, n3, twgu.field_71978_w.field_71990_ca);
                }
                this._g(ozlu2, n, n2, n3);
            }
        }
    }

    public void _g(ozlu ozlu2, int n, int n2, int n3) {
        ozlu2.func_72908_a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.fizz", 0.5f, 2.6f + (ozlu2.field_73012_v.nextFloat() - ozlu2.field_73012_v.nextFloat()) * 0.8f);
        for (int i = 0; i < 8; ++i) {
            ozlu2.func_72869_a("largesmoke", (double)n + Math.random(), (double)n2 + 1.2, (double)n3 + Math.random(), 0.0, 0.0, 0.0);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this._d = this.field_72018_cp == tflj._i ? new dwan[]{nege2._b("lava_still"), nege2._b("lava_flow")} : new dwan[]{nege2._b("water_still"), nege2._b("water_flow")};
    }

    @SideOnly(value=Side.CLIENT)
    public static dwan _a(String string) {
        return string == "water_still" ? twgu.field_71942_A._d[0] : (string == "water_flow" ? twgu.field_71942_A._d[1] : (string == "lava_still" ? twgu.field_71944_C._d[0] : (string == "lava_flow" ? twgu.field_71944_C._d[1] : null)));
    }
}

