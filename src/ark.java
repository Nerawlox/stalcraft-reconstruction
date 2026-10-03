/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  akc
 *  asx
 *  net.minecraftforge.common.ForgeDirection
 *  r
 */
import java.util.Random;
import net.minecraftforge.common.ForgeDirection;

public class ark
extends aqz {
    public ark(int par1) {
        super(par1, akc.q);
        this.a(ww.d);
        this.b(true);
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
        return 29;
    }

    @Override
    public int a(abw par1World) {
        return 10;
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
        int b0 = 0;
        if (par5 == 2 && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH, true)) {
            b0 = 2;
        }
        if (par5 == 3 && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH, true)) {
            b0 = 0;
        }
        if (par5 == 4 && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST, true)) {
            b0 = 1;
        }
        if (par5 == 5 && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST, true)) {
            b0 = 3;
        }
        return b0;
    }

    @Override
    public void k(abw par1World, int par2, int par3, int par4, int par5) {
        this.a(par1World, par2, par3, par4, this.cF, par5, false, -1, 0);
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, int par5) {
        if (par5 != this.cF && this.k(par1World, par2, par3, par4)) {
            int i1 = par1World.h(par2, par3, par4);
            int j1 = i1 & 3;
            boolean flag = false;
            if (!par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST) && j1 == 3) {
                flag = true;
            }
            if (!par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST) && j1 == 1) {
                flag = true;
            }
            if (!par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH) && j1 == 0) {
                flag = true;
            }
            if (!par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH) && j1 == 2) {
                flag = true;
            }
            if (flag) {
                this.c(par1World, par2, par3, par4, i1, 0);
                par1World.i(par2, par3, par4);
            }
        }
    }

    public void a(abw par1World, int par2, int par3, int par4, int par5, int par6, boolean par7, int par8, int par9) {
        int l3;
        int j3;
        int k3;
        int l2;
        int i3;
        int l1 = par6 & 3;
        boolean flag1 = (par6 & 4) == 4;
        boolean flag2 = (par6 & 8) == 8;
        boolean flag3 = par5 == aqz.bY.cF;
        boolean flag4 = false;
        boolean flag5 = !par1World.isBlockSolidOnSide(par2, par3 - 1, par4, ForgeDirection.UP);
        int i2 = r.a[l1];
        int j2 = r.b[l1];
        int k2 = 0;
        int[] aint = new int[42];
        for (i3 = 1; i3 < 42; ++i3) {
            l2 = par2 + i2 * i3;
            k3 = par4 + j2 * i3;
            j3 = par1World.a(l2, par3, k3);
            if (j3 == aqz.bY.cF) {
                l3 = par1World.h(l2, par3, k3);
                if ((l3 & 3) != r.f[l1]) break;
                k2 = i3;
                break;
            }
            if (j3 != aqz.bZ.cF && i3 != par8) {
                aint[i3] = -1;
                flag3 = false;
                continue;
            }
            l3 = i3 == par8 ? par9 : par1World.h(l2, par3, k3);
            boolean flag6 = (l3 & 8) != 8;
            boolean flag7 = (l3 & 1) == 1;
            boolean flag8 = (l3 & 2) == 2;
            flag3 &= flag8 == flag5;
            flag4 |= flag6 && flag7;
            aint[i3] = l3;
            if (i3 != par8) continue;
            par1World.a(par2, par3, par4, par5, this.a(par1World));
            flag3 &= flag6;
        }
        i3 = (flag3 ? 4 : 0) | ((flag4 &= (flag3 &= k2 > 1)) ? 8 : 0);
        par6 = l1 | i3;
        if (k2 > 0) {
            l2 = par2 + i2 * k2;
            k3 = par4 + j2 * k2;
            j3 = r.f[l1];
            par1World.b(l2, par3, k3, j3 | i3, 3);
            this.d(par1World, l2, par3, k3, j3);
            this.a(par1World, l2, par3, k3, flag3, flag4, flag1, flag2);
        }
        this.a(par1World, par2, par3, par4, flag3, flag4, flag1, flag2);
        if (par5 > 0) {
            par1World.b(par2, par3, par4, par6, 3);
            if (par7) {
                this.d(par1World, par2, par3, par4, l1);
            }
        }
        if (flag1 != flag3) {
            for (l2 = 1; l2 < k2; ++l2) {
                k3 = par2 + i2 * l2;
                j3 = par4 + j2 * l2;
                l3 = aint[l2];
                if (l3 < 0) continue;
                l3 = flag3 ? (l3 |= 4) : (l3 &= 0xFFFFFFFB);
                par1World.b(k3, par3, j3, l3, 3);
            }
        }
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, Random par5Random) {
        this.a(par1World, par2, par3, par4, this.cF, par1World.h(par2, par3, par4), true, -1, 0);
    }

    private void a(abw par1World, int par2, int par3, int par4, boolean par5, boolean par6, boolean par7, boolean par8) {
        if (par6 && !par8) {
            par1World.a((double)par2 + 0.5, (double)par3 + 0.1, (double)par4 + 0.5, "random.click", 0.4f, 0.6f);
        } else if (!par6 && par8) {
            par1World.a((double)par2 + 0.5, (double)par3 + 0.1, (double)par4 + 0.5, "random.click", 0.4f, 0.5f);
        } else if (par5 && !par7) {
            par1World.a((double)par2 + 0.5, (double)par3 + 0.1, (double)par4 + 0.5, "random.click", 0.4f, 0.7f);
        } else if (!par5 && par7) {
            par1World.a((double)par2 + 0.5, (double)par3 + 0.1, (double)par4 + 0.5, "random.bowhit", 0.4f, 1.2f / (par1World.s.nextFloat() * 0.2f + 0.9f));
        }
    }

    private void d(abw par1World, int par2, int par3, int par4, int par5) {
        par1World.f(par2, par3, par4, this.cF);
        if (par5 == 3) {
            par1World.f(par2 - 1, par3, par4, this.cF);
        } else if (par5 == 1) {
            par1World.f(par2 + 1, par3, par4, this.cF);
        } else if (par5 == 0) {
            par1World.f(par2, par3, par4 - 1, this.cF);
        } else if (par5 == 2) {
            par1World.f(par2, par3, par4 + 1, this.cF);
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
        int l = par1IBlockAccess.h(par2, par3, par4) & 3;
        float f = 0.1875f;
        if (l == 3) {
            this.a(0.0f, 0.2f, 0.5f - f, f * 2.0f, 0.8f, 0.5f + f);
        } else if (l == 1) {
            this.a(1.0f - f * 2.0f, 0.2f, 0.5f - f, 1.0f, 0.8f, 0.5f + f);
        } else if (l == 0) {
            this.a(0.5f - f, 0.2f, 0.0f, 0.5f + f, 0.8f, f * 2.0f);
        } else if (l == 2) {
            this.a(0.5f - f, 0.2f, 1.0f - f * 2.0f, 0.5f + f, 0.8f, 1.0f);
        }
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, int par5, int par6) {
        boolean flag1;
        boolean flag = (par6 & 4) == 4;
        boolean bl2 = flag1 = (par6 & 8) == 8;
        if (flag || flag1) {
            this.a(par1World, par2, par3, par4, 0, par6, false, -1, 0);
        }
        if (flag1) {
            par1World.f(par2, par3, par4, this.cF);
            int j1 = par6 & 3;
            if (j1 == 3) {
                par1World.f(par2 - 1, par3, par4, this.cF);
            } else if (j1 == 1) {
                par1World.f(par2 + 1, par3, par4, this.cF);
            } else if (j1 == 0) {
                par1World.f(par2, par3, par4 - 1, this.cF);
            } else if (j1 == 2) {
                par1World.f(par2, par3, par4 + 1, this.cF);
            }
        }
        super.a(par1World, par2, par3, par4, par5, par6);
    }

    @Override
    public int b(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return (par1IBlockAccess.h(par2, par3, par4) & 8) == 8 ? 15 : 0;
    }

    @Override
    public int c(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        int i1 = par1IBlockAccess.h(par2, par3, par4);
        if ((i1 & 8) != 8) {
            return 0;
        }
        int j1 = i1 & 3;
        return j1 == 2 && par5 == 2 ? 15 : (j1 == 0 && par5 == 3 ? 15 : (j1 == 1 && par5 == 4 ? 15 : (j1 == 3 && par5 == 5 ? 15 : 0)));
    }

    @Override
    public boolean f() {
        return true;
    }
}

