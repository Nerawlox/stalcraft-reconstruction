/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.ugqx;

public class losq
extends twgu {
    public boolean _a = true;
    public Set _b = new HashSet();
    @SideOnly(value=Side.CLIENT)
    public dwan _c;
    @SideOnly(value=Side.CLIENT)
    public dwan _d;
    @SideOnly(value=Side.CLIENT)
    public dwan _e;
    @SideOnly(value=Side.CLIENT)
    public dwan _f;

    public losq(int n) {
        super(n, tflj._q);
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.0625f, 1.0f);
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
        return 5;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71920_b(sdrg sdrg2, int n, int n2, int n3) {
        return 0x800000;
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.func_72797_t(n, n2 - 1, n3) || ozlu2.func_72798_a(n, n2 - 1, n3) == twgu.field_72014_bd.field_71990_ca;
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        this._a(ozlu2, n, n2, n3, n, n2, n3);
        ArrayList arrayList = new ArrayList(this._b);
        this._b.clear();
        for (int i = 0; i < arrayList.size(); ++i) {
            xtcd xtcd2 = (xtcd)arrayList.get(i);
            ozlu2.func_72898_h(xtcd2._d, xtcd2._e, xtcd2._f, this.field_71990_ca);
        }
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5, int n6) {
        int n7 = ozlu2.func_72805_g(n, n2, n3);
        int n8 = 0;
        int n9 = this._a(ozlu2, n4, n5, n6, n8);
        this._a = false;
        int n10 = ozlu2.func_94572_D(n, n2, n3);
        this._a = true;
        if (n10 > 0 && n10 > n9 - 1) {
            n9 = n10;
        }
        int n11 = 0;
        for (int i = 0; i < 4; ++i) {
            int n12 = n;
            int n13 = n3;
            if (i == 0) {
                n12 = n - 1;
            }
            if (i == 1) {
                ++n12;
            }
            if (i == 2) {
                n13 = n3 - 1;
            }
            if (i == 3) {
                ++n13;
            }
            if (n12 != n4 || n13 != n6) {
                n11 = this._a(ozlu2, n12, n2, n13, n11);
            }
            if (ozlu2.func_72809_s(n12, n2, n13) && !ozlu2.func_72809_s(n, n2 + 1, n3)) {
                if (n12 == n4 && n13 == n6 || n2 < n5) continue;
                n11 = this._a(ozlu2, n12, n2 + 1, n13, n11);
                continue;
            }
            if (ozlu2.func_72809_s(n12, n2, n13) || n12 == n4 && n13 == n6 || n2 > n5) continue;
            n11 = this._a(ozlu2, n12, n2 - 1, n13, n11);
        }
        n9 = n11 > n9 ? n11 - 1 : (n9 > 0 ? --n9 : 0);
        if (n10 > n9 - 1) {
            n9 = n10;
        }
        if (n7 != n9) {
            ozlu2.func_72921_c(n, n2, n3, n9, 2);
            this._b.add(new xtcd(n, n2, n3));
            this._b.add(new xtcd(n - 1, n2, n3));
            this._b.add(new xtcd(n + 1, n2, n3));
            this._b.add(new xtcd(n, n2 - 1, n3));
            this._b.add(new xtcd(n, n2 + 1, n3));
            this._b.add(new xtcd(n, n2, n3 - 1));
            this._b.add(new xtcd(n, n2, n3 + 1));
        }
    }

    public void _b(ozlu ozlu2, int n, int n2, int n3) {
        if (ozlu2.func_72798_a(n, n2, n3) == this.field_71990_ca) {
            ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n - 1, n2, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n + 1, n2, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2, n3 - 1, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2, n3 + 1, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2 - 1, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2 + 1, n3, this.field_71990_ca);
        }
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        super.func_71861_g(ozlu2, n, n2, n3);
        if (!ozlu2.field_72995_K) {
            this._a(ozlu2, n, n2, n3);
            ozlu2.func_72898_h(n, n2 + 1, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2 - 1, n3, this.field_71990_ca);
            this._b(ozlu2, n - 1, n2, n3);
            this._b(ozlu2, n + 1, n2, n3);
            this._b(ozlu2, n, n2, n3 - 1);
            this._b(ozlu2, n, n2, n3 + 1);
            if (ozlu2.func_72809_s(n - 1, n2, n3)) {
                this._b(ozlu2, n - 1, n2 + 1, n3);
            } else {
                this._b(ozlu2, n - 1, n2 - 1, n3);
            }
            if (ozlu2.func_72809_s(n + 1, n2, n3)) {
                this._b(ozlu2, n + 1, n2 + 1, n3);
            } else {
                this._b(ozlu2, n + 1, n2 - 1, n3);
            }
            if (ozlu2.func_72809_s(n, n2, n3 - 1)) {
                this._b(ozlu2, n, n2 + 1, n3 - 1);
            } else {
                this._b(ozlu2, n, n2 - 1, n3 - 1);
            }
            if (ozlu2.func_72809_s(n, n2, n3 + 1)) {
                this._b(ozlu2, n, n2 + 1, n3 + 1);
            } else {
                this._b(ozlu2, n, n2 - 1, n3 + 1);
            }
        }
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        super.func_71852_a(ozlu2, n, n2, n3, n4, n5);
        if (!ozlu2.field_72995_K) {
            ozlu2.func_72898_h(n, n2 + 1, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2 - 1, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n + 1, n2, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n - 1, n2, n3, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2, n3 + 1, this.field_71990_ca);
            ozlu2.func_72898_h(n, n2, n3 - 1, this.field_71990_ca);
            this._a(ozlu2, n, n2, n3);
            this._b(ozlu2, n - 1, n2, n3);
            this._b(ozlu2, n + 1, n2, n3);
            this._b(ozlu2, n, n2, n3 - 1);
            this._b(ozlu2, n, n2, n3 + 1);
            if (ozlu2.func_72809_s(n - 1, n2, n3)) {
                this._b(ozlu2, n - 1, n2 + 1, n3);
            } else {
                this._b(ozlu2, n - 1, n2 - 1, n3);
            }
            if (ozlu2.func_72809_s(n + 1, n2, n3)) {
                this._b(ozlu2, n + 1, n2 + 1, n3);
            } else {
                this._b(ozlu2, n + 1, n2 - 1, n3);
            }
            if (ozlu2.func_72809_s(n, n2, n3 - 1)) {
                this._b(ozlu2, n, n2 + 1, n3 - 1);
            } else {
                this._b(ozlu2, n, n2 - 1, n3 - 1);
            }
            if (ozlu2.func_72809_s(n, n2, n3 + 1)) {
                this._b(ozlu2, n, n2 + 1, n3 + 1);
            } else {
                this._b(ozlu2, n, n2 - 1, n3 + 1);
            }
        }
    }

    public int _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (ozlu2.func_72798_a(n, n2, n3) != this.field_71990_ca) {
            return n4;
        }
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        return n5 > n4 ? n5 : n4;
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (!ozlu2.field_72995_K) {
            boolean bl = this.func_71930_b(ozlu2, n, n2, n3);
            if (bl) {
                this._a(ozlu2, n, n2, n3);
            } else {
                this.func_71897_c(ozlu2, n, n2, n3, 0, 0);
                ozlu2.func_94571_i(n, n2, n3);
            }
            super.func_71863_a(ozlu2, n, n2, n3, n4);
        }
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return tgdv.field_77767_aC.field_77779_bT;
    }

    @Override
    public int func_71855_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return !this._a ? 0 : this.func_71865_a(sdrg2, n, n2, n3, n4);
    }

    @Override
    public int func_71865_a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        boolean bl;
        if (!this._a) {
            return 0;
        }
        int n5 = sdrg2.func_72805_g(n, n2, n3);
        if (n5 == 0) {
            return 0;
        }
        if (n4 == 1) {
            return n5;
        }
        boolean bl2 = losq._b(sdrg2, n - 1, n2, n3, 1) || !sdrg2.func_72809_s(n - 1, n2, n3) && losq._b(sdrg2, n - 1, n2 - 1, n3, -1);
        boolean bl3 = losq._b(sdrg2, n + 1, n2, n3, 3) || !sdrg2.func_72809_s(n + 1, n2, n3) && losq._b(sdrg2, n + 1, n2 - 1, n3, -1);
        boolean bl4 = losq._b(sdrg2, n, n2, n3 - 1, 2) || !sdrg2.func_72809_s(n, n2, n3 - 1) && losq._b(sdrg2, n, n2 - 1, n3 - 1, -1);
        boolean bl5 = bl = losq._b(sdrg2, n, n2, n3 + 1, 0) || !sdrg2.func_72809_s(n, n2, n3 + 1) && losq._b(sdrg2, n, n2 - 1, n3 + 1, -1);
        if (!sdrg2.func_72809_s(n, n2 + 1, n3)) {
            if (sdrg2.func_72809_s(n - 1, n2, n3) && losq._b(sdrg2, n - 1, n2 + 1, n3, -1)) {
                bl2 = true;
            }
            if (sdrg2.func_72809_s(n + 1, n2, n3) && losq._b(sdrg2, n + 1, n2 + 1, n3, -1)) {
                bl3 = true;
            }
            if (sdrg2.func_72809_s(n, n2, n3 - 1) && losq._b(sdrg2, n, n2 + 1, n3 - 1, -1)) {
                bl4 = true;
            }
            if (sdrg2.func_72809_s(n, n2, n3 + 1) && losq._b(sdrg2, n, n2 + 1, n3 + 1, -1)) {
                bl = true;
            }
        }
        return !bl4 && !bl3 && !bl2 && !bl && n4 >= 2 && n4 <= 5 ? n5 : (n4 == 2 && bl4 && !bl2 && !bl3 ? n5 : (n4 == 3 && bl && !bl2 && !bl3 ? n5 : (n4 == 4 && bl2 && !bl4 && !bl ? n5 : (n4 == 5 && bl3 && !bl4 && !bl ? n5 : 0))));
    }

    @Override
    public boolean func_71853_i() {
        return this._a;
    }

    public static boolean _a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        int n5 = sdrg2.func_72798_a(n, n2, n3);
        if (n5 == twgu.field_72075_av.field_71990_ca) {
            return true;
        }
        if (n5 == 0) {
            return false;
        }
        if (!twgu.field_72010_bh._g(n5)) {
            return twgu.field_71973_m[n5] != null && twgu.field_71973_m[n5].canConnectRedstone(sdrg2, n, n2, n3, n4);
        }
        int n6 = sdrg2.func_72805_g(n, n2, n3);
        return n4 == (n6 & 3) || n4 == ugqx._f[n6 & 3];
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        if (n4 > 0) {
            double d = (double)n + 0.5 + ((double)random.nextFloat() - 0.5) * 0.2;
            double d2 = (float)n2 + 0.0625f;
            double d3 = (double)n3 + 0.5 + ((double)random.nextFloat() - 0.5) * 0.2;
            float f = (float)n4 / 15.0f;
            float f2 = f * 0.6f + 0.4f;
            if (n4 == 0) {
                f2 = 0.0f;
            }
            float f3 = f * f * 0.7f - 0.5f;
            float f4 = f * f * 0.6f - 0.7f;
            if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            ozlu2.func_72869_a("reddust", d, d2, d3, f2, f3, f4);
        }
    }

    public static boolean _b(sdrg sdrg2, int n, int n2, int n3, int n4) {
        if (losq._a(sdrg2, n, n2, n3, n4)) {
            return true;
        }
        int n5 = sdrg2.func_72798_a(n, n2, n3);
        if (n5 == twgu.field_72011_bi.field_71990_ca) {
            int n6 = sdrg2.func_72805_g(n, n2, n3);
            return n4 == (n6 & 3);
        }
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return tgdv.field_77767_aC.field_77779_bT;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this._c = nege2._b(this.func_111023_E() + "_" + "cross");
        this._d = nege2._b(this.func_111023_E() + "_" + "line");
        this._e = nege2._b(this.func_111023_E() + "_" + "cross_overlay");
        this._f = nege2._b(this.func_111023_E() + "_" + "line_overlay");
        this.field_94336_cN = this._c;
    }

    @SideOnly(value=Side.CLIENT)
    public static dwan _a(String string) {
        return string.equals("cross") ? twgu.field_72075_av._c : (string.equals("line") ? twgu.field_72075_av._d : (string.equals("cross_overlay") ? twgu.field_72075_av._e : (string.equals("line_overlay") ? twgu.field_72075_av._f : null)));
    }
}

