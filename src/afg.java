/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afe
 */
import java.util.Random;

public class afg
extends afe {
    private int a;
    private int b;

    public afg(int par1, int par2) {
        this.b = par1;
        this.a = par2;
    }

    public boolean a(abw par1World, Random par2Random, int par3, int par4, int par5) {
        aqz block = null;
        while (((block = aqz.s[par1World.a(par3, par4, par5)]) == null || block.isAirBlock(par1World, par3, par4, par5) || block.isLeaves(par1World, par3, par4, par5)) && --par4 > 0) {
        }
        int i1 = par1World.a(par3, par4, par5);
        if (i1 == aqz.A.cF || i1 == aqz.z.cF) {
            this.a(par1World, par3, ++par4, par5, aqz.O.cF, this.b);
            for (int j1 = par4; j1 <= par4 + 2; ++j1) {
                int k1 = j1 - par4;
                int l1 = 2 - k1;
                for (int i2 = par3 - l1; i2 <= par3 + l1; ++i2) {
                    int j2 = i2 - par3;
                    for (int k2 = par5 - l1; k2 <= par5 + l1; ++k2) {
                        int l2 = k2 - par5;
                        block = aqz.s[par1World.a(i2, j1, k2)];
                        if (Math.abs(j2) == l1 && Math.abs(l2) == l1 && par2Random.nextInt(2) == 0 || block != null && !block.canBeReplacedByLeaves(par1World, i2, j1, k2)) continue;
                        this.a(par1World, i2, j1, k2, aqz.P.cF, this.a);
                    }
                }
            }
        }
        return true;
    }
}

