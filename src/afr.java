/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afe
 */
import java.util.Random;

public class afr
extends afe {
    public boolean a(abw par1World, Random par2Random, int par3, int par4, int par5) {
        int l = par2Random.nextInt(5) + 7;
        int i1 = l - par2Random.nextInt(2) - 3;
        int j1 = l - i1;
        int k1 = 1 + par2Random.nextInt(j1 + 1);
        boolean flag = true;
        if (par4 >= 1 && par4 + l + 1 <= 128) {
            int k2;
            int j2;
            int i2;
            int l2;
            int l1;
            for (l1 = par4; l1 <= par4 + 1 + l && flag; ++l1) {
                boolean flag1 = true;
                l2 = l1 - par4 < i1 ? 0 : k1;
                for (i2 = par3 - l2; i2 <= par3 + l2 && flag; ++i2) {
                    for (j2 = par5 - l2; j2 <= par5 + l2 && flag; ++j2) {
                        if (l1 >= 0 && l1 < 128) {
                            k2 = par1World.a(i2, l1, j2);
                            aqz block = aqz.s[k2];
                            if (k2 == 0 || block != null && block.isLeaves(par1World, i2, l1, j2)) continue;
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
            l1 = par1World.a(par3, par4 - 1, par5);
            if ((l1 == aqz.z.cF || l1 == aqz.A.cF) && par4 < 128 - l - 1) {
                this.a(par1World, par3, par4 - 1, par5, aqz.A.cF);
                l2 = 0;
                for (i2 = par4 + l; i2 >= par4 + i1; --i2) {
                    for (j2 = par3 - l2; j2 <= par3 + l2; ++j2) {
                        k2 = j2 - par3;
                        for (int i3 = par5 - l2; i3 <= par5 + l2; ++i3) {
                            int j3 = i3 - par5;
                            aqz block = aqz.s[par1World.a(j2, i2, i3)];
                            if (Math.abs(k2) == l2 && Math.abs(j3) == l2 && l2 > 0 || block != null && !block.canBeReplacedByLeaves(par1World, j2, i2, i3)) continue;
                            this.a(par1World, j2, i2, i3, aqz.P.cF, 1);
                        }
                    }
                    if (l2 >= 1 && i2 == par4 + i1 + 1) {
                        --l2;
                        continue;
                    }
                    if (l2 >= k1) continue;
                    ++l2;
                }
                for (i2 = 0; i2 < l - 1; ++i2) {
                    j2 = par1World.a(par3, par4 + i2, par5);
                    aqz block = aqz.s[j2];
                    if (j2 != 0 && block != null && !block.isLeaves(par1World, par3, par4 + i2, par5)) continue;
                    this.a(par1World, par3, par4 + i2, par5, aqz.O.cF, 1);
                }
                return true;
            }
            return false;
        }
        return false;
    }
}

