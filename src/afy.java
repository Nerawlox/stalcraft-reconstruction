/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afe
 *  akc
 */
import java.util.Random;

public class afy
extends afe {
    public boolean a(abw par1World, Random par2Random, int par3, int par4, int par5) {
        int l = par2Random.nextInt(4) + 5;
        while (par1World.g(par3, par4 - 1, par5) == akc.h) {
            --par4;
        }
        boolean flag = true;
        if (par4 >= 1 && par4 + l + 1 <= 128) {
            int l1;
            int k1;
            int j1;
            int i1;
            for (i1 = par4; i1 <= par4 + 1 + l; ++i1) {
                int b0 = 1;
                if (i1 == par4) {
                    b0 = 0;
                }
                if (i1 >= par4 + 1 + l - 2) {
                    b0 = 3;
                }
                for (j1 = par3 - b0; j1 <= par3 + b0 && flag; ++j1) {
                    for (k1 = par5 - b0; k1 <= par5 + b0 && flag; ++k1) {
                        if (i1 >= 0 && i1 < 128) {
                            l1 = par1World.a(j1, i1, k1);
                            if (l1 == 0 || aqz.s[l1] == null || aqz.s[l1].isLeaves(par1World, j1, i1, k1)) continue;
                            if (l1 != aqz.G.cF && l1 != aqz.F.cF) {
                                flag = false;
                                continue;
                            }
                            if (i1 <= par4) continue;
                            flag = false;
                            continue;
                        }
                        flag = false;
                    }
                }
            }
            if (!flag) {
                return false;
            }
            i1 = par1World.a(par3, par4 - 1, par5);
            if ((i1 == aqz.z.cF || i1 == aqz.A.cF) && par4 < 128 - l - 1) {
                int i2;
                int j2;
                this.a(par1World, par3, par4 - 1, par5, aqz.A.cF);
                for (j2 = par4 - 3 + l; j2 <= par4 + l; ++j2) {
                    j1 = j2 - (par4 + l);
                    k1 = 2 - j1 / 2;
                    for (l1 = par3 - k1; l1 <= par3 + k1; ++l1) {
                        i2 = l1 - par3;
                        for (int k2 = par5 - k1; k2 <= par5 + k1; ++k2) {
                            int l2 = k2 - par5;
                            aqz block = aqz.s[par1World.a(l1, j2, k2)];
                            if (Math.abs(i2) == k1 && Math.abs(l2) == k1 && (par2Random.nextInt(2) == 0 || j1 == 0) || block != null && !block.canBeReplacedByLeaves(par1World, l1, j2, k2)) continue;
                            this.a(par1World, l1, j2, k2, aqz.P.cF);
                        }
                    }
                }
                for (j2 = 0; j2 < l; ++j2) {
                    j1 = par1World.a(par3, par4 + j2, par5);
                    aqz block = aqz.s[j1];
                    if (j1 != 0 && (block == null || !block.isLeaves(par1World, par3, par4 + j2, par5)) && j1 != aqz.F.cF && j1 != aqz.G.cF) continue;
                    this.a(par1World, par3, par4 + j2, par5, aqz.O.cF);
                }
                for (j2 = par4 - 3 + l; j2 <= par4 + l; ++j2) {
                    j1 = j2 - (par4 + l);
                    k1 = 2 - j1 / 2;
                    for (l1 = par3 - k1; l1 <= par3 + k1; ++l1) {
                        for (i2 = par5 - k1; i2 <= par5 + k1; ++i2) {
                            aqz block = aqz.s[par1World.a(l1, j2, i2)];
                            if (block == null || !block.isLeaves(par1World, l1, j2, i2)) continue;
                            if (par2Random.nextInt(4) == 0 && par1World.a(l1 - 1, j2, i2) == 0) {
                                this.b(par1World, l1 - 1, j2, i2, 8);
                            }
                            if (par2Random.nextInt(4) == 0 && par1World.a(l1 + 1, j2, i2) == 0) {
                                this.b(par1World, l1 + 1, j2, i2, 2);
                            }
                            if (par2Random.nextInt(4) == 0 && par1World.a(l1, j2, i2 - 1) == 0) {
                                this.b(par1World, l1, j2, i2 - 1, 1);
                            }
                            if (par2Random.nextInt(4) != 0 || par1World.a(l1, j2, i2 + 1) != 0) continue;
                            this.b(par1World, l1, j2, i2 + 1, 4);
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void b(abw par1World, int par2, int par3, int par4, int par5) {
        this.a(par1World, par2, par3, par4, aqz.bz.cF, par5);
        int i1 = 4;
        while (par1World.a(par2, --par3, par4) == 0 && i1 > 0) {
            this.a(par1World, par2, par3, par4, aqz.bz.cF, par5);
            --i1;
        }
        return;
    }
}

