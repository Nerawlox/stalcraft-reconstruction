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

public class afo
extends afe {
    private final int a;
    private final int b;
    private final int c;

    public afo(boolean par1, int par2, int par3, int par4) {
        super(par1);
        this.a = par2;
        this.b = par3;
        this.c = par4;
    }

    public boolean a(abw par1World, Random par2Random, int par3, int par4, int par5) {
        int l = par2Random.nextInt(3) + this.a;
        boolean flag = true;
        if (par4 >= 1 && par4 + l + 1 <= 256) {
            boolean isValidSoil;
            int l1;
            int k1;
            int j1;
            int i1;
            for (i1 = par4; i1 <= par4 + 1 + l; ++i1) {
                int b0 = 2;
                if (i1 == par4) {
                    b0 = 1;
                }
                if (i1 >= par4 + 1 + l - 2) {
                    b0 = 2;
                }
                for (j1 = par3 - b0; j1 <= par3 + b0 && flag; ++j1) {
                    for (k1 = par5 - b0; k1 <= par5 + b0 && flag; ++k1) {
                        if (i1 >= 0 && i1 < 256) {
                            l1 = par1World.a(j1, i1, k1);
                            aqz block = aqz.s[l1];
                            if (block == null || block.isAirBlock(par1World, j1, i1, k1) || block.isLeaves(par1World, j1, i1, k1) || block.isWood(par1World, j1, i1, k1) || block == aqz.z || block == aqz.A || block == aqz.D) continue;
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
                this.onPlantGrow(par1World, par3, par4 - 1, par5, par3, par4, par5);
                this.onPlantGrow(par1World, par3 + 1, par4 - 1, par5, par3, par4, par5);
                this.onPlantGrow(par1World, par3, par4 - 1, par5 + 1, par3, par4, par5);
                this.onPlantGrow(par1World, par3 + 1, par4 - 1, par5 + 1, par3, par4, par5);
                this.a(par1World, par3, par5, par4 + l, 2, par2Random);
                for (int i2 = par4 + l - 2 - par2Random.nextInt(4); i2 > par4 + l / 2; i2 -= 2 + par2Random.nextInt(4)) {
                    float f = par2Random.nextFloat() * (float)Math.PI * 2.0f;
                    k1 = par3 + (int)(0.5f + ls.b(f) * 4.0f);
                    l1 = par5 + (int)(0.5f + ls.a(f) * 4.0f);
                    this.a(par1World, k1, l1, i2, 0, par2Random);
                    for (int j2 = 0; j2 < 5; ++j2) {
                        k1 = par3 + (int)(1.5f + ls.b(f) * (float)j2);
                        l1 = par5 + (int)(1.5f + ls.a(f) * (float)j2);
                        this.a(par1World, k1, i2 - 3 + j2 / 2, l1, aqz.O.cF, this.b);
                    }
                }
                for (j1 = 0; j1 < l; ++j1) {
                    k1 = par1World.a(par3, par4 + j1, par5);
                    if (this.isReplaceable(par1World, par3, par4 + j1, par5)) {
                        this.a(par1World, par3, par4 + j1, par5, aqz.O.cF, this.b);
                        if (j1 > 0) {
                            if (par2Random.nextInt(3) > 0 && par1World.c(par3 - 1, par4 + j1, par5)) {
                                this.a(par1World, par3 - 1, par4 + j1, par5, aqz.bz.cF, 8);
                            }
                            if (par2Random.nextInt(3) > 0 && par1World.c(par3, par4 + j1, par5 - 1)) {
                                this.a(par1World, par3, par4 + j1, par5 - 1, aqz.bz.cF, 1);
                            }
                        }
                    }
                    if (j1 >= l - 1) continue;
                    k1 = par1World.a(par3 + 1, par4 + j1, par5);
                    if (this.isReplaceable(par1World, par3 + 1, par4 + j1, par5)) {
                        this.a(par1World, par3 + 1, par4 + j1, par5, aqz.O.cF, this.b);
                        if (j1 > 0) {
                            if (par2Random.nextInt(3) > 0 && par1World.c(par3 + 2, par4 + j1, par5)) {
                                this.a(par1World, par3 + 2, par4 + j1, par5, aqz.bz.cF, 2);
                            }
                            if (par2Random.nextInt(3) > 0 && par1World.c(par3 + 1, par4 + j1, par5 - 1)) {
                                this.a(par1World, par3 + 1, par4 + j1, par5 - 1, aqz.bz.cF, 1);
                            }
                        }
                    }
                    k1 = par1World.a(par3 + 1, par4 + j1, par5 + 1);
                    if (this.isReplaceable(par1World, par3 + 1, par4 + j1, par5 + 1)) {
                        this.a(par1World, par3 + 1, par4 + j1, par5 + 1, aqz.O.cF, this.b);
                        if (j1 > 0) {
                            if (par2Random.nextInt(3) > 0 && par1World.c(par3 + 2, par4 + j1, par5 + 1)) {
                                this.a(par1World, par3 + 2, par4 + j1, par5 + 1, aqz.bz.cF, 2);
                            }
                            if (par2Random.nextInt(3) > 0 && par1World.c(par3 + 1, par4 + j1, par5 + 2)) {
                                this.a(par1World, par3 + 1, par4 + j1, par5 + 2, aqz.bz.cF, 4);
                            }
                        }
                    }
                    k1 = par1World.a(par3, par4 + j1, par5 + 1);
                    if (!this.isReplaceable(par1World, par3, par4 + j1, par5 + 1)) continue;
                    this.a(par1World, par3, par4 + j1, par5 + 1, aqz.O.cF, this.b);
                    if (j1 <= 0) continue;
                    if (par2Random.nextInt(3) > 0 && par1World.c(par3 - 1, par4 + j1, par5 + 1)) {
                        this.a(par1World, par3 - 1, par4 + j1, par5 + 1, aqz.bz.cF, 8);
                    }
                    if (par2Random.nextInt(3) <= 0 || !par1World.c(par3, par4 + j1, par5 + 2)) continue;
                    this.a(par1World, par3, par4 + j1, par5 + 2, aqz.bz.cF, 4);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void a(abw par1World, int par2, int par3, int par4, int par5, Random par6Random) {
        int b0 = 2;
        for (int i1 = par4 - b0; i1 <= par4; ++i1) {
            int j1 = i1 - par4;
            int k1 = par5 + 1 - j1;
            for (int l1 = par2 - k1; l1 <= par2 + k1 + 1; ++l1) {
                int i2 = l1 - par2;
                for (int j2 = par3 - k1; j2 <= par3 + k1 + 1; ++j2) {
                    int l2;
                    aqz block;
                    int k2 = j2 - par3;
                    if (i2 < 0 && k2 < 0 && i2 * i2 + k2 * k2 > k1 * k1 || (i2 > 0 || k2 > 0) && i2 * i2 + k2 * k2 > (k1 + 1) * (k1 + 1) || par6Random.nextInt(4) == 0 && i2 * i2 + k2 * k2 > (k1 - 1) * (k1 - 1) || (block = aqz.s[l2 = par1World.a(l1, i1, j2)]) != null && !block.canBeReplacedByLeaves(par1World, l1, i1, j2)) continue;
                    this.a(par1World, l1, i1, j2, aqz.P.cF, this.c);
                }
            }
        }
    }

    private void onPlantGrow(abw world, int x2, int y2, int z2, int sourceX, int sourceY, int sourceZ) {
        aqz block = aqz.s[world.a(x2, y2, z2)];
        if (block != null) {
            block.onPlantGrow(world, x2, y2, z2, sourceX, sourceY, sourceZ);
        }
    }

    private boolean isReplaceable(abw world, int x2, int y2, int z2) {
        aqz block = aqz.s[world.a(x2, y2, z2)];
        return block == null || block.isAirBlock(world, x2, y2, z2) || block.isLeaves(world, x2, y2, z2);
    }
}

