/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afe
 */
import java.util.Random;

public class afq
extends afe {
    private int a;
    private int minableBlockMeta = 0;
    private int b;
    private int c;

    public afq(int par1, int par2) {
        this(par1, par2, aqz.y.cF);
    }

    public afq(int par1, int par2, int par3) {
        this.a = par1;
        this.b = par2;
        this.c = par3;
    }

    public afq(int id, int meta, int number, int target) {
        this(id, number, target);
        this.minableBlockMeta = meta;
    }

    public boolean a(abw par1World, Random par2Random, int par3, int par4, int par5) {
        float f = par2Random.nextFloat() * (float)Math.PI;
        double d0 = (float)(par3 + 8) + ls.a(f) * (float)this.b / 8.0f;
        double d1 = (float)(par3 + 8) - ls.a(f) * (float)this.b / 8.0f;
        double d2 = (float)(par5 + 8) + ls.b(f) * (float)this.b / 8.0f;
        double d3 = (float)(par5 + 8) - ls.b(f) * (float)this.b / 8.0f;
        double d4 = par4 + par2Random.nextInt(3) - 2;
        double d5 = par4 + par2Random.nextInt(3) - 2;
        for (int l = 0; l <= this.b; ++l) {
            double d6 = d0 + (d1 - d0) * (double)l / (double)this.b;
            double d7 = d4 + (d5 - d4) * (double)l / (double)this.b;
            double d8 = d2 + (d3 - d2) * (double)l / (double)this.b;
            double d9 = par2Random.nextDouble() * (double)this.b / 16.0;
            double d10 = (double)(ls.a((float)l * (float)Math.PI / (float)this.b) + 1.0f) * d9 + 1.0;
            double d11 = (double)(ls.a((float)l * (float)Math.PI / (float)this.b) + 1.0f) * d9 + 1.0;
            int i1 = ls.c(d6 - d10 / 2.0);
            int j1 = ls.c(d7 - d11 / 2.0);
            int k1 = ls.c(d8 - d10 / 2.0);
            int l1 = ls.c(d6 + d10 / 2.0);
            int i2 = ls.c(d7 + d11 / 2.0);
            int j2 = ls.c(d8 + d10 / 2.0);
            for (int k2 = i1; k2 <= l1; ++k2) {
                double d12 = ((double)k2 + 0.5 - d6) / (d10 / 2.0);
                if (!(d12 * d12 < 1.0)) continue;
                for (int l2 = j1; l2 <= i2; ++l2) {
                    double d13 = ((double)l2 + 0.5 - d7) / (d11 / 2.0);
                    if (!(d12 * d12 + d13 * d13 < 1.0)) continue;
                    for (int i3 = k1; i3 <= j2; ++i3) {
                        double d14 = ((double)i3 + 0.5 - d8) / (d10 / 2.0);
                        aqz block = aqz.s[par1World.a(k2, l2, i3)];
                        if (!(d12 * d12 + d13 * d13 + d14 * d14 < 1.0) || block == null || !block.isGenMineableReplaceable(par1World, k2, l2, i3, this.c)) continue;
                        par1World.f(k2, l2, i3, this.a, this.minableBlockMeta, 2);
                    }
                }
            }
        }
        return true;
    }
}

