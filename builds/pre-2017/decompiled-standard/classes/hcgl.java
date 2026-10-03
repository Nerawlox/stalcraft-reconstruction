/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;

public class hcgl
extends uims {
    public static final double[] _b = new double[]{-0.0625, 0.0625, 0.1875, 0.3125};
    public static final int[] _c = new int[]{1, 2, 3, 4};

    public hcgl(int n, boolean bl) {
        super(n, bl);
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        int n6 = (n5 & 0xC) >> 2;
        n6 = n6 + 1 << 2 & 0xC;
        ozlu2.func_72921_c(n, n2, n3, n6 | n5 & 3, 3);
        return true;
    }

    @Override
    public int _a(int n) {
        return _c[(n & 0xC) >> 2] * 2;
    }

    @Override
    public uims _a() {
        return twgu.field_72011_bi;
    }

    @Override
    public uims _b() {
        return twgu.field_72010_bh;
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return tgdv.field_77742_bb.field_77779_bT;
    }

    @Override
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return tgdv.field_77742_bb.field_77779_bT;
    }

    @Override
    public int func_71857_b() {
        return 15;
    }

    @Override
    public boolean _b(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return this._c(sdrg2, n, n2, n3, n4) > 0;
    }

    @Override
    public boolean _e(int n) {
        return hcgl._f(n);
    }

    @Override
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (!this._a) {
            return;
        }
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        int n5 = hcgl._d(n4);
        double d = (double)((float)n + 0.5f) + (double)(random.nextFloat() - 0.5f) * 0.2;
        double d2 = (double)((float)n2 + 0.4f) + (double)(random.nextFloat() - 0.5f) * 0.2;
        double d3 = (double)((float)n3 + 0.5f) + (double)(random.nextFloat() - 0.5f) * 0.2;
        double d4 = 0.0;
        double d5 = 0.0;
        if (random.nextInt(2) == 0) {
            switch (n5) {
                case 0: {
                    d5 = -0.3125;
                    break;
                }
                case 2: {
                    d5 = 0.3125;
                    break;
                }
                case 3: {
                    d4 = -0.3125;
                    break;
                }
                case 1: {
                    d4 = 0.3125;
                }
            }
        } else {
            int n6 = (n4 & 0xC) >> 2;
            switch (n5) {
                case 0: {
                    d5 = _b[n6];
                    break;
                }
                case 2: {
                    d5 = -_b[n6];
                    break;
                }
                case 3: {
                    d4 = _b[n6];
                    break;
                }
                case 1: {
                    d4 = -_b[n6];
                }
            }
        }
        ozlu2.func_72869_a("reddust", d + d4, d2, d3 + d5, 0.0, 0.0, 0.0);
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        super.func_71852_a(ozlu2, n, n2, n3, n4, n5);
        this._a(ozlu2, n, n2, n3);
    }
}

