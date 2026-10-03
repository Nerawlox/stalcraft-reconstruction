/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.stalker.misc.qlgf;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.ugqx;
import net.minecraft.util.zwaw;

public class gqbt
extends gqau {
    public static final int[][] _a = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    public dwan[] _b;
    public dwan[] _c;
    public dwan[] _d;

    public gqbt(int n) {
        super(n, tflj._n);
        this._a();
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        qlgf._a(this, ozlu2, n, n2, n3, entityPlayer, n4, f, f2, f3);
        return false;
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        int n3;
        if (n == 0) {
            return twgu.field_71988_x.func_71851_a(n);
        }
        int n4 = gqbt._d(n2);
        int n5 = ugqx._i[n4][n];
        int n6 = n3 = gqbt._a(n2) ? 1 : 0;
        if (n3 == 1 && n5 == 2 || n3 == 0 && n5 == 3) {
            return this._b[n3];
        }
        if (n5 == 5 || n5 == 4) {
            return this._c[n3];
        }
        return this._d[n3];
    }

    @Override
    public void func_94332_a(nege nege2) {
        this._d = new dwan[]{nege2._b(this.func_111023_E() + "_feet_top"), nege2._b(this.func_111023_E() + "_head_top")};
        this._b = new dwan[]{nege2._b(this.func_111023_E() + "_feet_end"), nege2._b(this.func_111023_E() + "_head_end")};
        this._c = new dwan[]{nege2._b(this.func_111023_E() + "_feet_side"), nege2._b(this.func_111023_E() + "_head_side")};
    }

    @Override
    public int func_71857_b() {
        return 14;
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
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        this._a();
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        int n6 = gqbt._d(n5);
        if (gqbt._a(n5)) {
            if (ozlu2.func_72798_a(n - _a[n6][0], n2, n3 - _a[n6][1]) != this.field_71990_ca) {
                ozlu2.func_94571_i(n, n2, n3);
            }
        } else if (ozlu2.func_72798_a(n + _a[n6][0], n2, n3 + _a[n6][1]) != this.field_71990_ca) {
            ozlu2.func_94571_i(n, n2, n3);
            if (!ozlu2.field_72995_K) {
                this.func_71897_c(ozlu2, n, n2, n3, n5, 0);
            }
        }
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        if (gqbt._a(n)) {
            return 0;
        }
        return tgdv.field_77776_ba.field_77779_bT;
    }

    public void _a() {
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.5625f, 1.0f);
    }

    public static boolean _a(int n) {
        return (n & 8) != 0;
    }

    public static boolean _b(int n) {
        return (n & 4) != 0;
    }

    public static void _a(ozlu ozlu2, int n, int n2, int n3, boolean bl) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        n4 = bl ? (n4 |= 4) : (n4 &= 0xFFFFFFFB);
        ozlu2.func_72921_c(n, n2, n3, n4, 4);
    }

    public static zwaw _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        int n6 = gqau._d(n5);
        for (int i = 0; i <= 1; ++i) {
            int n7 = n - _a[n6][0] * i - 1;
            int n8 = n3 - _a[n6][1] * i - 1;
            int n9 = n7 + 2;
            int n10 = n8 + 2;
            for (int j = n7; j <= n9; ++j) {
                for (int k = n8; k <= n10; ++k) {
                    if (!ozlu2.func_72797_t(j, n2 - 1, k) || ozlu2.func_72803_f(j, n2, k)._k() || ozlu2.func_72803_f(j, n2 + 1, k)._k()) continue;
                    if (n4 > 0) {
                        --n4;
                        continue;
                    }
                    return new zwaw(j, n2, k);
                }
            }
        }
        return null;
    }

    @Override
    public void func_71914_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, int n5) {
        if (!gqbt._a(n4)) {
            super.func_71914_a(ozlu2, n, n2, n3, n4, f, 0);
        }
    }

    @Override
    public int func_71915_e() {
        return 1;
    }

    @Override
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return tgdv.field_77776_ba.field_77779_bT;
    }

    @Override
    public void func_71846_a(ozlu ozlu2, int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
        int n5;
        if (entityPlayer.field_71075_bZ._d && gqbt._a(n4) && ozlu2.func_72798_a(n -= _a[n5 = gqbt._d(n4)][0], n2, n3 -= _a[n5][1]) == this.field_71990_ca) {
            ozlu2.func_94571_i(n, n2, n3);
        }
    }
}

