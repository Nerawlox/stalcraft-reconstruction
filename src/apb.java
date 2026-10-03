/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  akc
 *  asx
 *  net.minecraftforge.common.ForgeDirection
 */
import net.minecraftforge.common.ForgeDirection;

public class apb
extends aqz {
    protected apb(int par1) {
        super(par1, akc.q);
        this.a(ww.d);
    }

    @Override
    public asx b(abw par1World, int par2, int par3, int par4) {
        return null;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public int d() {
        return 12;
    }

    @Override
    public boolean c(abw par1World, int par2, int par3, int par4, int par5) {
        ForgeDirection dir = ForgeDirection.getOrientation((int)par5);
        return dir == ForgeDirection.DOWN && par1World.isBlockSolidOnSide(par2, par3 + 1, par4, ForgeDirection.DOWN) || dir == ForgeDirection.UP && par1World.isBlockSolidOnSide(par2, par3 - 1, par4, ForgeDirection.UP) || dir == ForgeDirection.NORTH && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH) || dir == ForgeDirection.SOUTH && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH) || dir == ForgeDirection.WEST && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST) || dir == ForgeDirection.EAST && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST);
    }

    @Override
    public boolean c(abw par1World, int par2, int par3, int par4) {
        return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST) || par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST) || par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH) || par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH) || par1World.isBlockSolidOnSide(par2, par3 - 1, par4, ForgeDirection.UP) || par1World.isBlockSolidOnSide(par2, par3 + 1, par4, ForgeDirection.DOWN);
    }

    @Override
    public int a(abw par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
        int j1 = par9 & 8;
        int k1 = par9 & 7;
        int b0 = -1;
        if (par5 == 0 && par1World.isBlockSolidOnSide(par2, par3 + 1, par4, ForgeDirection.DOWN)) {
            b0 = 0;
        }
        if (par5 == 1 && par1World.isBlockSolidOnSide(par2, par3 - 1, par4, ForgeDirection.UP)) {
            b0 = 5;
        }
        if (par5 == 2 && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH)) {
            b0 = 4;
        }
        if (par5 == 3 && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH)) {
            b0 = 3;
        }
        if (par5 == 4 && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST)) {
            b0 = 2;
        }
        if (par5 == 5 && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST)) {
            b0 = 1;
        }
        return b0 + j1;
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, of par5EntityLivingBase, ye par6ItemStack) {
        int l = par1World.h(par2, par3, par4);
        int i1 = l & 7;
        int j1 = l & 8;
        if (i1 == apb.d(1)) {
            if ((ls.c((double)(par5EntityLivingBase.A * 4.0f / 360.0f) + 0.5) & 1) == 0) {
                par1World.b(par2, par3, par4, 5 | j1, 2);
            } else {
                par1World.b(par2, par3, par4, 6 | j1, 2);
            }
        } else if (i1 == apb.d(0)) {
            if ((ls.c((double)(par5EntityLivingBase.A * 4.0f / 360.0f) + 0.5) & 1) == 0) {
                par1World.b(par2, par3, par4, 7 | j1, 2);
            } else {
                par1World.b(par2, par3, par4, 0 | j1, 2);
            }
        }
    }

    public static int d(int par0) {
        switch (par0) {
            case 0: {
                return 0;
            }
            case 1: {
                return 5;
            }
            case 2: {
                return 4;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 1;
            }
        }
        return -1;
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, int par5) {
        if (this.k(par1World, par2, par3, par4)) {
            int i1 = par1World.h(par2, par3, par4) & 7;
            boolean flag = false;
            if (!par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST) && i1 == 1) {
                flag = true;
            }
            if (!par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST) && i1 == 2) {
                flag = true;
            }
            if (!par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH) && i1 == 3) {
                flag = true;
            }
            if (!par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH) && i1 == 4) {
                flag = true;
            }
            if (!par1World.isBlockSolidOnSide(par2, par3 - 1, par4, ForgeDirection.UP) && i1 == 5) {
                flag = true;
            }
            if (!par1World.isBlockSolidOnSide(par2, par3 - 1, par4, ForgeDirection.UP) && i1 == 6) {
                flag = true;
            }
            if (!par1World.isBlockSolidOnSide(par2, par3 + 1, par4, ForgeDirection.DOWN) && i1 == 0) {
                flag = true;
            }
            if (!par1World.isBlockSolidOnSide(par2, par3 + 1, par4, ForgeDirection.DOWN) && i1 == 7) {
                flag = true;
            }
            if (flag) {
                this.c(par1World, par2, par3, par4, par1World.h(par2, par3, par4), 0);
                par1World.i(par2, par3, par4);
            }
        }
    }

    private boolean k(abw par1World, int par2, int par3, int par4) {
        if (!this.c(par1World, par2, par3, par4)) {
            this.c(par1World, par2, par3, par4, par1World.h(par2, par3, par4), 0);
            par1World.i(par2, par3, par4);
            return false;
        }
        return true;
    }

    @Override
    public void a(acf par1IBlockAccess, int par2, int par3, int par4) {
        int l = par1IBlockAccess.h(par2, par3, par4) & 7;
        float f = 0.1875f;
        if (l == 1) {
            this.a(0.0f, 0.2f, 0.5f - f, f * 2.0f, 0.8f, 0.5f + f);
        } else if (l == 2) {
            this.a(1.0f - f * 2.0f, 0.2f, 0.5f - f, 1.0f, 0.8f, 0.5f + f);
        } else if (l == 3) {
            this.a(0.5f - f, 0.2f, 0.0f, 0.5f + f, 0.8f, f * 2.0f);
        } else if (l == 4) {
            this.a(0.5f - f, 0.2f, 1.0f - f * 2.0f, 0.5f + f, 0.8f, 1.0f);
        } else if (l != 5 && l != 6) {
            if (l == 0 || l == 7) {
                f = 0.25f;
                this.a(0.5f - f, 0.4f, 0.5f - f, 0.5f + f, 1.0f, 0.5f + f);
            }
        } else {
            f = 0.25f;
            this.a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.6f, 0.5f + f);
        }
    }

    @Override
    public boolean a(abw par1World, int par2, int par3, int par4, uf par5EntityPlayer, int par6, float par7, float par8, float par9) {
        if (par1World.I) {
            return true;
        }
        int i1 = par1World.h(par2, par3, par4);
        int j1 = i1 & 7;
        int k1 = 8 - (i1 & 8);
        par1World.b(par2, par3, par4, j1 + k1, 3);
        par1World.a((double)par2 + 0.5, (double)par3 + 0.5, (double)par4 + 0.5, "random.click", 0.3f, k1 > 0 ? 0.6f : 0.5f);
        par1World.f(par2, par3, par4, this.cF);
        if (j1 == 1) {
            par1World.f(par2 - 1, par3, par4, this.cF);
        } else if (j1 == 2) {
            par1World.f(par2 + 1, par3, par4, this.cF);
        } else if (j1 == 3) {
            par1World.f(par2, par3, par4 - 1, this.cF);
        } else if (j1 == 4) {
            par1World.f(par2, par3, par4 + 1, this.cF);
        } else if (j1 != 5 && j1 != 6) {
            if (j1 == 0 || j1 == 7) {
                par1World.f(par2, par3 + 1, par4, this.cF);
            }
        } else {
            par1World.f(par2, par3 - 1, par4, this.cF);
        }
        return true;
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, int par5, int par6) {
        if ((par6 & 8) > 0) {
            par1World.f(par2, par3, par4, this.cF);
            int j1 = par6 & 7;
            if (j1 == 1) {
                par1World.f(par2 - 1, par3, par4, this.cF);
            } else if (j1 == 2) {
                par1World.f(par2 + 1, par3, par4, this.cF);
            } else if (j1 == 3) {
                par1World.f(par2, par3, par4 - 1, this.cF);
            } else if (j1 == 4) {
                par1World.f(par2, par3, par4 + 1, this.cF);
            } else if (j1 != 5 && j1 != 6) {
                if (j1 == 0 || j1 == 7) {
                    par1World.f(par2, par3 + 1, par4, this.cF);
                }
            } else {
                par1World.f(par2, par3 - 1, par4, this.cF);
            }
        }
        super.a(par1World, par2, par3, par4, par5, par6);
    }

    @Override
    public int b(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return (par1IBlockAccess.h(par2, par3, par4) & 8) > 0 ? 15 : 0;
    }

    @Override
    public int c(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        int i1 = par1IBlockAccess.h(par2, par3, par4);
        if ((i1 & 8) == 0) {
            return 0;
        }
        int j1 = i1 & 7;
        return j1 == 0 && par5 == 0 ? 15 : (j1 == 7 && par5 == 0 ? 15 : (j1 == 6 && par5 == 1 ? 15 : (j1 == 5 && par5 == 1 ? 15 : (j1 == 4 && par5 == 2 ? 15 : (j1 == 3 && par5 == 3 ? 15 : (j1 == 2 && par5 == 4 ? 15 : (j1 == 1 && par5 == 5 ? 15 : 0)))))));
    }

    @Override
    public boolean f() {
        return true;
    }
}

