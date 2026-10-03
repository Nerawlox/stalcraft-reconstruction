/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afe
 *  akc
 *  asj
 *  net.minecraftforge.common.ChestGenHooks
 *  net.minecraftforge.common.DungeonHooks
 */
import java.util.Random;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;

public class afp
extends afe {
    public static final mk[] a = new mk[]{new mk(yc.aC.cv, 0, 1, 1, 10), new mk(yc.q.cv, 0, 1, 4, 10), new mk(yc.W.cv, 0, 1, 1, 10), new mk(yc.V.cv, 0, 1, 4, 10), new mk(yc.O.cv, 0, 1, 4, 10), new mk(yc.M.cv, 0, 1, 4, 10), new mk(yc.ay.cv, 0, 1, 1, 10), new mk(yc.av.cv, 0, 1, 1, 1), new mk(yc.aE.cv, 0, 1, 4, 10), new mk(yc.cj.cv, 0, 1, 1, 10), new mk(yc.ck.cv, 0, 1, 1, 10), new mk(yc.ci.cv, 0, 1, 1, 10), new mk(yc.cf.cv, 0, 1, 1, 2), new mk(yc.ce.cv, 0, 1, 1, 5), new mk(yc.cg.cv, 0, 1, 1, 1)};

    public boolean a(abw par1World, Random par2Random, int par3, int par4, int par5) {
        int i2;
        int l1;
        int k1;
        int b0 = 3;
        int l = par2Random.nextInt(2) + 2;
        int i1 = par2Random.nextInt(2) + 2;
        int j1 = 0;
        for (k1 = par3 - l - 1; k1 <= par3 + l + 1; ++k1) {
            for (l1 = par4 - 1; l1 <= par4 + b0 + 1; ++l1) {
                for (i2 = par5 - i1 - 1; i2 <= par5 + i1 + 1; ++i2) {
                    akc material = par1World.g(k1, l1, i2);
                    if (l1 == par4 - 1 && !material.a()) {
                        return false;
                    }
                    if (l1 == par4 + b0 + 1 && !material.a()) {
                        return false;
                    }
                    if (k1 != par3 - l - 1 && k1 != par3 + l + 1 && i2 != par5 - i1 - 1 && i2 != par5 + i1 + 1 || l1 != par4 || !par1World.c(k1, l1, i2) || !par1World.c(k1, l1 + 1, i2)) continue;
                    ++j1;
                }
            }
        }
        if (j1 >= 1 && j1 <= 5) {
            for (k1 = par3 - l - 1; k1 <= par3 + l + 1; ++k1) {
                for (l1 = par4 + b0; l1 >= par4 - 1; --l1) {
                    for (i2 = par5 - i1 - 1; i2 <= par5 + i1 + 1; ++i2) {
                        if (k1 != par3 - l - 1 && l1 != par4 - 1 && i2 != par5 - i1 - 1 && k1 != par3 + l + 1 && l1 != par4 + b0 + 1 && i2 != par5 + i1 + 1) {
                            par1World.i(k1, l1, i2);
                            continue;
                        }
                        if (l1 >= 0 && !par1World.g(k1, l1 - 1, i2).a()) {
                            par1World.i(k1, l1, i2);
                            continue;
                        }
                        if (!par1World.g(k1, l1, i2).a()) continue;
                        if (l1 == par4 - 1 && par2Random.nextInt(4) != 0) {
                            par1World.f(k1, l1, i2, aqz.at.cF, 0, 2);
                            continue;
                        }
                        par1World.f(k1, l1, i2, aqz.B.cF, 0, 2);
                    }
                }
            }
            block6: for (k1 = 0; k1 < 2; ++k1) {
                for (l1 = 0; l1 < 3; ++l1) {
                    int j2;
                    i2 = par3 + par2Random.nextInt(l * 2 + 1) - l;
                    if (!par1World.c(i2, par4, j2 = par5 + par2Random.nextInt(i1 * 2 + 1) - i1)) continue;
                    int k2 = 0;
                    if (par1World.g(i2 - 1, par4, j2).a()) {
                        ++k2;
                    }
                    if (par1World.g(i2 + 1, par4, j2).a()) {
                        ++k2;
                    }
                    if (par1World.g(i2, par4, j2 - 1).a()) {
                        ++k2;
                    }
                    if (par1World.g(i2, par4, j2 + 1).a()) {
                        ++k2;
                    }
                    if (k2 != 1) continue;
                    par1World.f(i2, par4, j2, aqz.az.cF, 0, 2);
                    ary tileentitychest = (ary)par1World.r(i2, par4, j2);
                    if (tileentitychest == null) continue block6;
                    ChestGenHooks info = ChestGenHooks.getInfo((String)"dungeonChest");
                    mk.a(par2Random, info.getItems(par2Random), tileentitychest, info.getCount(par2Random));
                    continue block6;
                }
            }
            par1World.f(par3, par4, par5, aqz.ax.cF, 0, 2);
            asj tileentitymobspawner = (asj)par1World.r(par3, par4, par5);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.a().a(this.a(par2Random));
            } else {
                System.err.println("Failed to fetch mob spawner entity at (" + par3 + ", " + par4 + ", " + par5 + ")");
            }
            return true;
        }
        return false;
    }

    private String a(Random par1Random) {
        return DungeonHooks.getRandomDungeonMob((Random)par1Random);
    }
}

