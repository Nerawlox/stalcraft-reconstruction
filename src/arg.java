/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 *  asx
 *  ata
 *  atc
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraftforge.common.ForgeDirection
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraftforge.common.ForgeDirection;

public class arg
extends aqz {
    protected arg(int par1) {
        super(par1, akc.q);
        this.b(true);
        this.a(ww.c);
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
        return 2;
    }

    private boolean m(abw par1World, int par2, int par3, int par4) {
        if (par1World.w(par2, par3, par4)) {
            return true;
        }
        int l = par1World.a(par2, par3, par4);
        return aqz.s[l] != null && aqz.s[l].canPlaceTorchOnTop(par1World, par2, par3, par4);
    }

    @Override
    public boolean c(abw par1World, int par2, int par3, int par4) {
        return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST, true) || par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST, true) || par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH, true) || par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH, true) || this.m(par1World, par2, par3 - 1, par4);
    }

    @Override
    public int a(abw par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
        int j1 = par9;
        if (par5 == 1 && this.m(par1World, par2, par3 - 1, par4)) {
            j1 = 5;
        }
        if (par5 == 2 && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH, true)) {
            j1 = 4;
        }
        if (par5 == 3 && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH, true)) {
            j1 = 3;
        }
        if (par5 == 4 && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST, true)) {
            j1 = 2;
        }
        if (par5 == 5 && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST, true)) {
            j1 = 1;
        }
        return j1;
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, Random par5Random) {
        super.a(par1World, par2, par3, par4, par5Random);
        if (par1World.h(par2, par3, par4) == 0) {
            this.a(par1World, par2, par3, par4);
        }
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4) {
        if (par1World.h(par2, par3, par4) == 0) {
            if (par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST, true)) {
                par1World.b(par2, par3, par4, 1, 2);
            } else if (par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST, true)) {
                par1World.b(par2, par3, par4, 2, 2);
            } else if (par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH, true)) {
                par1World.b(par2, par3, par4, 3, 2);
            } else if (par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH, true)) {
                par1World.b(par2, par3, par4, 4, 2);
            } else if (this.m(par1World, par2, par3 - 1, par4)) {
                par1World.b(par2, par3, par4, 5, 2);
            }
        }
        this.k(par1World, par2, par3, par4);
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, int par5) {
        this.d(par1World, par2, par3, par4, par5);
    }

    protected boolean d(abw par1World, int par2, int par3, int par4, int par5) {
        if (this.k(par1World, par2, par3, par4)) {
            int i1 = par1World.h(par2, par3, par4);
            boolean flag = false;
            if (!par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST, true) && i1 == 1) {
                flag = true;
            }
            if (!par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST, true) && i1 == 2) {
                flag = true;
            }
            if (!par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH, true) && i1 == 3) {
                flag = true;
            }
            if (!par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH, true) && i1 == 4) {
                flag = true;
            }
            if (!this.m(par1World, par2, par3 - 1, par4) && i1 == 5) {
                flag = true;
            }
            if (flag) {
                this.c(par1World, par2, par3, par4, par1World.h(par2, par3, par4), 0);
                par1World.i(par2, par3, par4);
                return true;
            }
            return false;
        }
        return true;
    }

    protected boolean k(abw par1World, int par2, int par3, int par4) {
        if (!this.c(par1World, par2, par3, par4)) {
            if (par1World.a(par2, par3, par4) == this.cF) {
                this.c(par1World, par2, par3, par4, par1World.h(par2, par3, par4), 0);
                par1World.i(par2, par3, par4);
            }
            return false;
        }
        return true;
    }

    @Override
    public ata a(abw par1World, int par2, int par3, int par4, atc par5Vec3, atc par6Vec3) {
        int l = par1World.h(par2, par3, par4) & 7;
        float f = 0.15f;
        if (l == 1) {
            this.a(0.0f, 0.2f, 0.5f - f, f * 2.0f, 0.8f, 0.5f + f);
        } else if (l == 2) {
            this.a(1.0f - f * 2.0f, 0.2f, 0.5f - f, 1.0f, 0.8f, 0.5f + f);
        } else if (l == 3) {
            this.a(0.5f - f, 0.2f, 0.0f, 0.5f + f, 0.8f, f * 2.0f);
        } else if (l == 4) {
            this.a(0.5f - f, 0.2f, 1.0f - f * 2.0f, 0.5f + f, 0.8f, 1.0f);
        } else {
            f = 0.1f;
            this.a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.6f, 0.5f + f);
        }
        return super.a(par1World, par2, par3, par4, par5Vec3, par6Vec3);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void b(abw par1World, int par2, int par3, int par4, Random par5Random) {
        int l = par1World.h(par2, par3, par4);
        double d0 = (float)par2 + 0.5f;
        double d1 = (float)par3 + 0.7f;
        double d2 = (float)par4 + 0.5f;
        double d3 = 0.22f;
        double d4 = 0.27f;
        if (l == 1) {
            par1World.a("smoke", d0 - d4, d1 + d3, d2, 0.0, 0.0, 0.0);
            par1World.a("flame", d0 - d4, d1 + d3, d2, 0.0, 0.0, 0.0);
        } else if (l == 2) {
            par1World.a("smoke", d0 + d4, d1 + d3, d2, 0.0, 0.0, 0.0);
            par1World.a("flame", d0 + d4, d1 + d3, d2, 0.0, 0.0, 0.0);
        } else if (l == 3) {
            par1World.a("smoke", d0, d1 + d3, d2 - d4, 0.0, 0.0, 0.0);
            par1World.a("flame", d0, d1 + d3, d2 - d4, 0.0, 0.0, 0.0);
        } else if (l == 4) {
            par1World.a("smoke", d0, d1 + d3, d2 + d4, 0.0, 0.0, 0.0);
            par1World.a("flame", d0, d1 + d3, d2 + d4, 0.0, 0.0, 0.0);
        } else {
            par1World.a("smoke", d0, d1, d2, 0.0, 0.0, 0.0);
            par1World.a("flame", d0, d1, d2, 0.0, 0.0, 0.0);
        }
    }
}

