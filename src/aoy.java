/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  akc
 *  asx
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraftforge.common.ForgeDirection
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraftforge.common.ForgeDirection;

public class aoy
extends aqz {
    protected aoy(int par1) {
        super(par1, akc.q);
        this.a(ww.c);
    }

    @Override
    public asx b(abw par1World, int par2, int par3, int par4) {
        this.a((acf)par1World, par2, par3, par4);
        return super.b(par1World, par2, par3, par4);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public asx c_(abw par1World, int par2, int par3, int par4) {
        this.a((acf)par1World, par2, par3, par4);
        return super.c_(par1World, par2, par3, par4);
    }

    @Override
    public void a(acf par1IBlockAccess, int par2, int par3, int par4) {
        this.c(par1IBlockAccess.h(par2, par3, par4));
    }

    public void c(int par1) {
        float f = 0.125f;
        if (par1 == 2) {
            this.a(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
        }
        if (par1 == 3) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
        }
        if (par1 == 4) {
            this.a(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        if (par1 == 5) {
            this.a(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
        }
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
        return 8;
    }

    @Override
    public boolean c(abw par1World, int par2, int par3, int par4) {
        return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST) || par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST) || par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH) || par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH);
    }

    @Override
    public int a(abw par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
        int j1 = par9;
        if ((j1 == 0 || par5 == 2) && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH)) {
            j1 = 2;
        }
        if ((j1 == 0 || par5 == 3) && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH)) {
            j1 = 3;
        }
        if ((j1 == 0 || par5 == 4) && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST)) {
            j1 = 4;
        }
        if ((j1 == 0 || par5 == 5) && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST)) {
            j1 = 5;
        }
        return j1;
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, int par5) {
        int i1 = par1World.h(par2, par3, par4);
        boolean flag = false;
        if (i1 == 2 && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, ForgeDirection.NORTH)) {
            flag = true;
        }
        if (i1 == 3 && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, ForgeDirection.SOUTH)) {
            flag = true;
        }
        if (i1 == 4 && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, ForgeDirection.WEST)) {
            flag = true;
        }
        if (i1 == 5 && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, ForgeDirection.EAST)) {
            flag = true;
        }
        if (!flag) {
            this.c(par1World, par2, par3, par4, i1, 0);
            par1World.i(par2, par3, par4);
        }
        super.a(par1World, par2, par3, par4, par5);
    }

    @Override
    public int a(Random par1Random) {
        return 1;
    }

    @Override
    public boolean isLadder(abw world, int x2, int y2, int z2, of entity) {
        return true;
    }
}

