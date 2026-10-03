/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afl
 *  net.minecraftforge.common.ForgeDirection
 */
import java.util.Random;
import net.minecraftforge.common.ForgeDirection;

public class apj
extends ane {
    protected apj(int par1) {
        super(par1);
        float f = 0.2f;
        this.a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 2.0f, 0.5f + f);
        this.b(true);
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, Random par5Random) {
        if (par5Random.nextInt(25) == 0) {
            int k1;
            int j1;
            int i1;
            int b0 = 4;
            int l = 5;
            for (i1 = par2 - b0; i1 <= par2 + b0; ++i1) {
                for (j1 = par4 - b0; j1 <= par4 + b0; ++j1) {
                    for (k1 = par3 - 1; k1 <= par3 + 1; ++k1) {
                        if (par1World.a(i1, k1, j1) != this.cF || --l > 0) continue;
                        return;
                    }
                }
            }
            i1 = par2 + par5Random.nextInt(3) - 1;
            j1 = par3 + par5Random.nextInt(2) - par5Random.nextInt(2);
            k1 = par4 + par5Random.nextInt(3) - 1;
            for (int l1 = 0; l1 < 4; ++l1) {
                if (par1World.c(i1, j1, k1) && this.f(par1World, i1, j1, k1)) {
                    par2 = i1;
                    par3 = j1;
                    par4 = k1;
                }
                i1 = par2 + par5Random.nextInt(3) - 1;
                j1 = par3 + par5Random.nextInt(2) - par5Random.nextInt(2);
                k1 = par4 + par5Random.nextInt(3) - 1;
            }
            if (par1World.c(i1, j1, k1) && this.f(par1World, i1, j1, k1)) {
                par1World.f(i1, j1, k1, this.cF, 0, 2);
            }
        }
    }

    @Override
    public boolean c(abw par1World, int par2, int par3, int par4) {
        return super.c(par1World, par2, par3, par4) && this.f(par1World, par2, par3, par4);
    }

    @Override
    protected boolean g_(int par1) {
        return aqz.t[par1];
    }

    @Override
    public boolean f(abw par1World, int par2, int par3, int par4) {
        if (par3 >= 0 && par3 < 256) {
            int l = par1World.a(par2, par3 - 1, par4);
            aqz soil = aqz.s[l];
            return (l == aqz.bD.cF || par1World.m(par2, par3, par4) < 13) && soil != null && soil.canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this);
        }
        return false;
    }

    public boolean c(abw par1World, int par2, int par3, int par4, Random par5Random) {
        int l = par1World.h(par2, par3, par4);
        par1World.i(par2, par3, par4);
        afl worldgenbigmushroom = null;
        if (this.cF == aqz.ak.cF) {
            worldgenbigmushroom = new afl(0);
        } else if (this.cF == aqz.al.cF) {
            worldgenbigmushroom = new afl(1);
        }
        if (worldgenbigmushroom != null && worldgenbigmushroom.a(par1World, par5Random, par2, par3, par4)) {
            return true;
        }
        par1World.f(par2, par3, par4, this.cF, l, 3);
        return false;
    }
}

