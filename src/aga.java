/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afe
 *  aqi
 *  net.minecraftforge.common.ForgeDirection
 *  net.minecraftforge.common.IPlantable
 *  r
 */
import java.util.Random;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class aga
extends afe {
    private final int a;
    private final boolean b;
    private final int c;
    private final int d;

    public aga(boolean par1) {
        this(par1, 4, 0, 0, false);
    }

    public aga(boolean par1, int par2, int par3, int par4, boolean par5) {
        super(par1);
        this.a = par2;
        this.c = par3;
        this.d = par4;
        this.b = par5;
    }

    public boolean a(abw par1World, Random par2Random, int par3, int par4, int par5) {
        int l = par2Random.nextInt(3) + this.a;
        boolean flag = true;
        if (par4 >= 1 && par4 + l + 1 <= 256) {
            boolean isSoil;
            int k1;
            int j1;
            int b0;
            int i1;
            for (i1 = par4; i1 <= par4 + 1 + l; ++i1) {
                b0 = 1;
                if (i1 == par4) {
                    b0 = 0;
                }
                if (i1 >= par4 + 1 + l - 2) {
                    b0 = 2;
                }
                for (int l1 = par3 - b0; l1 <= par3 + b0 && flag; ++l1) {
                    for (j1 = par5 - b0; j1 <= par5 + b0 && flag; ++j1) {
                        if (i1 >= 0 && i1 < 256) {
                            k1 = par1World.a(l1, i1, j1);
                            aqz block = aqz.s[k1];
                            if (par1World.c(l1, i1, j1) || block.isLeaves(par1World, l1, i1, j1) || k1 == aqz.z.cF || k1 == aqz.A.cF || block.isWood(par1World, l1, i1, j1)) continue;
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
            boolean bl2 = isSoil = soil != null && soil.canSustainPlant(par1World, par3, par4 - 1, par5, ForgeDirection.UP, (IPlantable)((aqi)aqz.D));
            if (isSoil && par4 < 256 - l - 1) {
                int k2;
                int j2;
                int i2;
                soil.onPlantGrow(par1World, par3, par4 - 1, par5, par3, par4, par5);
                b0 = 3;
                int b1 = 0;
                for (j1 = par4 - b0 + l; j1 <= par4 + l; ++j1) {
                    k1 = j1 - (par4 + l);
                    i2 = b1 + 1 - k1 / 2;
                    for (j2 = par3 - i2; j2 <= par3 + i2; ++j2) {
                        k2 = j2 - par3;
                        for (int l2 = par5 - i2; l2 <= par5 + i2; ++l2) {
                            int j3;
                            aqz block;
                            int i3 = l2 - par5;
                            if (Math.abs(k2) == i2 && Math.abs(i3) == i2 && (par2Random.nextInt(2) == 0 || k1 == 0) || (block = aqz.s[j3 = par1World.a(j2, j1, l2)]) != null && !block.canBeReplacedByLeaves(par1World, j2, j1, l2)) continue;
                            this.a(par1World, j2, j1, l2, aqz.P.cF, this.d);
                        }
                    }
                }
                for (j1 = 0; j1 < l; ++j1) {
                    k1 = par1World.a(par3, par4 + j1, par5);
                    aqz block = aqz.s[k1];
                    if (block != null && !block.isAirBlock(par1World, par3, par4 + j1, par5) && !block.isLeaves(par1World, par3, par4 + j1, par5)) continue;
                    this.a(par1World, par3, par4 + j1, par5, aqz.O.cF, this.c);
                    if (!this.b || j1 <= 0) continue;
                    if (par2Random.nextInt(3) > 0 && par1World.c(par3 - 1, par4 + j1, par5)) {
                        this.a(par1World, par3 - 1, par4 + j1, par5, aqz.bz.cF, 8);
                    }
                    if (par2Random.nextInt(3) > 0 && par1World.c(par3 + 1, par4 + j1, par5)) {
                        this.a(par1World, par3 + 1, par4 + j1, par5, aqz.bz.cF, 2);
                    }
                    if (par2Random.nextInt(3) > 0 && par1World.c(par3, par4 + j1, par5 - 1)) {
                        this.a(par1World, par3, par4 + j1, par5 - 1, aqz.bz.cF, 1);
                    }
                    if (par2Random.nextInt(3) <= 0 || !par1World.c(par3, par4 + j1, par5 + 1)) continue;
                    this.a(par1World, par3, par4 + j1, par5 + 1, aqz.bz.cF, 4);
                }
                if (this.b) {
                    for (j1 = par4 - 3 + l; j1 <= par4 + l; ++j1) {
                        k1 = j1 - (par4 + l);
                        i2 = 2 - k1 / 2;
                        for (j2 = par3 - i2; j2 <= par3 + i2; ++j2) {
                            for (k2 = par5 - i2; k2 <= par5 + i2; ++k2) {
                                aqz block = aqz.s[par1World.a(j2, j1, k2)];
                                if (block == null || !block.isLeaves(par1World, j2, j1, k2)) continue;
                                if (par2Random.nextInt(4) == 0 && par1World.c(j2 - 1, j1, k2)) {
                                    this.b(par1World, j2 - 1, j1, k2, 8);
                                }
                                if (par2Random.nextInt(4) == 0 && par1World.c(j2 + 1, j1, k2)) {
                                    this.b(par1World, j2 + 1, j1, k2, 2);
                                }
                                if (par2Random.nextInt(4) == 0 && par1World.c(j2, j1, k2 - 1)) {
                                    this.b(par1World, j2, j1, k2 - 1, 1);
                                }
                                if (par2Random.nextInt(4) != 0 || !par1World.c(j2, j1, k2 + 1)) continue;
                                this.b(par1World, j2, j1, k2 + 1, 4);
                            }
                        }
                    }
                    if (par2Random.nextInt(5) == 0 && l > 5) {
                        for (j1 = 0; j1 < 2; ++j1) {
                            for (k1 = 0; k1 < 4; ++k1) {
                                if (par2Random.nextInt(4 - j1) != 0) continue;
                                i2 = par2Random.nextInt(3);
                                this.a(par1World, par3 + r.a[r.f[k1]], par4 + l - 5 + j1, par5 + r.b[r.f[k1]], aqz.bU.cF, i2 << 2 | k1);
                            }
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
        while (par1World.c(par2, --par3, par4) && i1 > 0) {
            this.a(par1World, par2, par3, par4, aqz.bz.cF, par5);
            --i1;
        }
        return;
    }
}

