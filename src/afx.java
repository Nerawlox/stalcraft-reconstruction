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

public class afx
extends afe {
    public afx(boolean par1) {
        super(par1);
    }

    public boolean a(abw par1World, Random par2Random, int par3, int par4, int par5) {
        int l = par2Random.nextInt(4) + 6;
        int i1 = 1 + par2Random.nextInt(2);
        int j1 = l - i1;
        int k1 = 2 + par2Random.nextInt(2);
        boolean flag = true;
        if (par4 >= 1 && par4 + l + 1 <= 256) {
            boolean isValidSoil;
            int j2;
            int i2;
            int k2;
            int l1;
            for (l1 = par4; l1 <= par4 + 1 + l && flag; ++l1) {
                boolean flag1 = true;
                k2 = l1 - par4 < i1 ? 0 : k1;
                for (i2 = par3 - k2; i2 <= par3 + k2 && flag; ++i2) {
                    for (int l2 = par5 - k2; l2 <= par5 + k2 && flag; ++l2) {
                        if (l1 >= 0 && l1 < 256) {
                            j2 = par1World.a(i2, l1, l2);
                            aqz block = aqz.s[j2];
                            if (j2 == 0 || block == null || block.isLeaves(par1World, i2, l1, l2)) continue;
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
            aqz soil = aqz.s[l1];
            boolean bl2 = isValidSoil = soil != null && soil.canSustainPlant(par1World, par3, par4 - 1, par5, ForgeDirection.UP, (IPlantable)((aqi)aqz.D));
            if (isValidSoil && par4 < 256 - l - 1) {
                int i3;
                int j3;
                soil.onPlantGrow(par1World, par3, par4 - 1, par5, par3, par4, par5);
                k2 = par2Random.nextInt(2);
                i2 = 1;
                int b0 = 0;
                for (j2 = 0; j2 <= j1; ++j2) {
                    j3 = par4 + l - j2;
                    for (i3 = par3 - k2; i3 <= par3 + k2; ++i3) {
                        int k3 = i3 - par3;
                        for (int l3 = par5 - k2; l3 <= par5 + k2; ++l3) {
                            int i4 = l3 - par5;
                            aqz block = aqz.s[par1World.a(i3, j3, l3)];
                            if (Math.abs(k3) == k2 && Math.abs(i4) == k2 && k2 > 0 || block != null && !block.canBeReplacedByLeaves(par1World, i3, j3, l3)) continue;
                            this.a(par1World, i3, j3, l3, aqz.P.cF, 1);
                        }
                    }
                    if (k2 >= i2) {
                        k2 = b0;
                        b0 = 1;
                        if (++i2 <= k1) continue;
                        i2 = k1;
                        continue;
                    }
                    ++k2;
                }
                j2 = par2Random.nextInt(3);
                for (j3 = 0; j3 < l - j2; ++j3) {
                    i3 = par1World.a(par3, par4 + j3, par5);
                    aqz block = aqz.s[i3];
                    if (i3 != 0 && block != null && !block.isLeaves(par1World, par3, par4 + j3, par5)) continue;
                    this.a(par1World, par3, par4 + j3, par5, aqz.O.cF, 1);
                }
                return true;
            }
            return false;
        }
        return false;
    }
}

