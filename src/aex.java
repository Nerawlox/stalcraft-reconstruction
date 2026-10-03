/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afe
 *  aqi
 *  net.minecraftforge.common.ForgeDirection
 *  net.minecraftforge.common.IPlantable
 */
import java.util.Random;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class aex
extends afe {
    public aex(boolean par1) {
        super(par1);
    }

    public boolean a(abw par1World, Random par2Random, int par3, int par4, int par5) {
        int l = par2Random.nextInt(3) + 5;
        boolean flag = true;
        if (par4 >= 1 && par4 + l + 1 <= 256) {
            boolean isValidSoil;
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
                    b0 = 2;
                }
                for (j1 = par3 - b0; j1 <= par3 + b0 && flag; ++j1) {
                    for (k1 = par5 - b0; k1 <= par5 + b0 && flag; ++k1) {
                        if (i1 >= 0 && i1 < 256) {
                            l1 = par1World.a(j1, i1, k1);
                            aqz block = aqz.s[l1];
                            if (block == null || block.isAirBlock(par1World, j1, i1, k1) || block.isLeaves(par1World, j1, i1, k1)) continue;
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
            aqz soil = aqz.s[i1];
            boolean bl2 = isValidSoil = soil != null && soil.canSustainPlant(par1World, par3, par4 - 1, par5, ForgeDirection.UP, (IPlantable)((aqi)aqz.D));
            if (isValidSoil && par4 < 256 - l - 1) {
                int i2;
                soil.onPlantGrow(par1World, par3, par4 - 1, par5, par3, par4, par5);
                for (i2 = par4 - 3 + l; i2 <= par4 + l; ++i2) {
                    j1 = i2 - (par4 + l);
                    k1 = 1 - j1 / 2;
                    for (l1 = par3 - k1; l1 <= par3 + k1; ++l1) {
                        int j2 = l1 - par3;
                        for (int k2 = par5 - k1; k2 <= par5 + k1; ++k2) {
                            int i3;
                            aqz block;
                            int l2 = k2 - par5;
                            if (Math.abs(j2) == k1 && Math.abs(l2) == k1 && (par2Random.nextInt(2) == 0 || j1 == 0) || (block = aqz.s[i3 = par1World.a(l1, i2, k2)]) != null && !block.canBeReplacedByLeaves(par1World, l1, i2, k2)) continue;
                            this.a(par1World, l1, i2, k2, aqz.P.cF, 2);
                        }
                    }
                }
                for (i2 = 0; i2 < l; ++i2) {
                    j1 = par1World.a(par3, par4 + i2, par5);
                    aqz block = aqz.s[j1];
                    if (block != null && !block.isAirBlock(par1World, par3, par4 + i2, par5) && !block.isLeaves(par1World, par3, par4 + i2, par5)) continue;
                    this.a(par1World, par3, par4 + i2, par5, aqz.O.cF, 2);
                }
                return true;
            }
            return false;
        }
        return false;
    }
}

