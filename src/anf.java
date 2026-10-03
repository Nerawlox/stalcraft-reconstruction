/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  akc
 *  asx
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  mt
 *  net.minecraftforge.common.ForgeDirection
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraftforge.common.ForgeDirection;

public abstract class anf
extends aqz {
    protected boolean a;

    protected anf(int par1, boolean par2) {
        super(par1, akc.q);
        this.b(true);
        this.a(ww.d);
        this.a = par2;
    }

    @Override
    public asx b(abw par1World, int par2, int par3, int par4) {
        return null;
    }

    @Override
    public int a(abw par1World) {
        return this.a ? 30 : 20;
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
    public boolean c(abw par1World, int par2, int par3, int par4, int par5) {
        ForgeDirection dir = ForgeDirection.getOrientation((int)par5);
        return dir == ForgeDirection.NORTH && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH) || dir == ForgeDirection.SOUTH && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH) || dir == ForgeDirection.WEST && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST) || dir == ForgeDirection.EAST && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST);
    }

    @Override
    public boolean c(abw par1World, int par2, int par3, int par4) {
        return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST) || par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST) || par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH) || par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH);
    }

    @Override
    public int a(abw par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
        int j1 = par1World.h(par2, par3, par4);
        int k1 = j1 & 8;
        j1 &= 7;
        ForgeDirection dir = ForgeDirection.getOrientation((int)par5);
        j1 = dir == ForgeDirection.NORTH && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH) ? 4 : (dir == ForgeDirection.SOUTH && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH) ? 3 : (dir == ForgeDirection.WEST && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST) ? 2 : (dir == ForgeDirection.EAST && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST) ? 1 : this.k(par1World, par2, par3, par4))));
        return j1 + k1;
    }

    private int k(abw par1World, int par2, int par3, int par4) {
        if (par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST)) {
            return 1;
        }
        if (par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST)) {
            return 2;
        }
        if (par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH)) {
            return 3;
        }
        if (par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH)) {
            return 4;
        }
        return 1;
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, int par5) {
        if (this.m(par1World, par2, par3, par4)) {
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
            if (flag) {
                this.c(par1World, par2, par3, par4, par1World.h(par2, par3, par4), 0);
                par1World.i(par2, par3, par4);
            }
        }
    }

    private boolean m(abw par1World, int par2, int par3, int par4) {
        if (!this.c(par1World, par2, par3, par4)) {
            this.c(par1World, par2, par3, par4, par1World.h(par2, par3, par4), 0);
            par1World.i(par2, par3, par4);
            return false;
        }
        return true;
    }

    @Override
    public void a(acf par1IBlockAccess, int par2, int par3, int par4) {
        int l = par1IBlockAccess.h(par2, par3, par4);
        this.d(l);
    }

    private void d(int par1) {
        int j2 = par1 & 7;
        boolean flag = (par1 & 8) > 0;
        float f = 0.375f;
        float f1 = 0.625f;
        float f2 = 0.1875f;
        float f3 = 0.125f;
        if (flag) {
            f3 = 0.0625f;
        }
        if (j2 == 1) {
            this.a(0.0f, f, 0.5f - f2, f3, f1, 0.5f + f2);
        } else if (j2 == 2) {
            this.a(1.0f - f3, f, 0.5f - f2, 1.0f, f1, 0.5f + f2);
        } else if (j2 == 3) {
            this.a(0.5f - f2, f, 0.0f, 0.5f + f2, f1, f3);
        } else if (j2 == 4) {
            this.a(0.5f - f2, f, 1.0f - f3, 0.5f + f2, f1, 1.0f);
        }
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, uf par5EntityPlayer) {
    }

    @Override
    public boolean a(abw par1World, int par2, int par3, int par4, uf par5EntityPlayer, int par6, float par7, float par8, float par9) {
        int i1 = par1World.h(par2, par3, par4);
        int j1 = i1 & 7;
        int k1 = 8 - (i1 & 8);
        if (k1 == 0) {
            return true;
        }
        par1World.b(par2, par3, par4, j1 + k1, 3);
        par1World.g(par2, par3, par4, par2, par3, par4);
        par1World.a((double)par2 + 0.5, (double)par3 + 0.5, (double)par4 + 0.5, "random.click", 0.3f, 0.6f);
        this.d(par1World, par2, par3, par4, j1);
        par1World.a(par2, par3, par4, this.cF, this.a(par1World));
        return true;
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, int par5, int par6) {
        if ((par6 & 8) > 0) {
            int j1 = par6 & 7;
            this.d(par1World, par2, par3, par4, j1);
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
        return j1 == 5 && par5 == 1 ? 15 : (j1 == 4 && par5 == 2 ? 15 : (j1 == 3 && par5 == 3 ? 15 : (j1 == 2 && par5 == 4 ? 15 : (j1 == 1 && par5 == 5 ? 15 : 0))));
    }

    @Override
    public boolean f() {
        return true;
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, Random par5Random) {
        int l;
        if (!par1World.I && ((l = par1World.h(par2, par3, par4)) & 8) != 0) {
            if (this.a) {
                this.n(par1World, par2, par3, par4);
            } else {
                par1World.b(par2, par3, par4, l & 7, 3);
                int i1 = l & 7;
                this.d(par1World, par2, par3, par4, i1);
                par1World.a((double)par2 + 0.5, (double)par3 + 0.5, (double)par4 + 0.5, "random.click", 0.3f, 0.5f);
                par1World.g(par2, par3, par4, par2, par3, par4);
            }
        }
    }

    @Override
    public void g() {
        float f = 0.1875f;
        float f1 = 0.125f;
        float f2 = 0.125f;
        this.a(0.5f - f, 0.5f - f1, 0.5f - f2, 0.5f + f, 0.5f + f1, 0.5f + f2);
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, nn par5Entity) {
        if (!par1World.I && this.a && (par1World.h(par2, par3, par4) & 8) == 0) {
            this.n(par1World, par2, par3, par4);
        }
    }

    protected void n(abw par1World, int par2, int par3, int par4) {
        boolean flag1;
        int l = par1World.h(par2, par3, par4);
        int i1 = l & 7;
        boolean flag = (l & 8) != 0;
        this.d(l);
        List list = par1World.a(uh.class, asx.a().a((double)par2 + this.cM, (double)par3 + this.cN, (double)par4 + this.cO, (double)par2 + this.cP, (double)par3 + this.cQ, (double)par4 + this.cR));
        boolean bl2 = flag1 = !list.isEmpty();
        if (flag1 && !flag) {
            par1World.b(par2, par3, par4, i1 | 8, 3);
            this.d(par1World, par2, par3, par4, i1);
            par1World.g(par2, par3, par4, par2, par3, par4);
            par1World.a((double)par2 + 0.5, (double)par3 + 0.5, (double)par4 + 0.5, "random.click", 0.3f, 0.6f);
        }
        if (!flag1 && flag) {
            par1World.b(par2, par3, par4, i1, 3);
            this.d(par1World, par2, par3, par4, i1);
            par1World.g(par2, par3, par4, par2, par3, par4);
            par1World.a((double)par2 + 0.5, (double)par3 + 0.5, (double)par4 + 0.5, "random.click", 0.3f, 0.5f);
        }
        if (flag1) {
            par1World.a(par2, par3, par4, this.cF, this.a(par1World));
        }
    }

    private void d(abw par1World, int par2, int par3, int par4, int par5) {
        par1World.f(par2, par3, par4, this.cF);
        if (par5 == 1) {
            par1World.f(par2 - 1, par3, par4, this.cF);
        } else if (par5 == 2) {
            par1World.f(par2 + 1, par3, par4, this.cF);
        } else if (par5 == 3) {
            par1World.f(par2, par3, par4 - 1, this.cF);
        } else if (par5 == 4) {
            par1World.f(par2, par3, par4 + 1, this.cF);
        } else {
            par1World.f(par2, par3 - 1, par4, this.cF);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
    }
}

