/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 *  amw
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  mt
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

public class aoc
extends amw {
    @SideOnly(value=Side.CLIENT)
    private ms a;
    @SideOnly(value=Side.CLIENT)
    private ms b;

    protected aoc(int par1) {
        super(par1, akc.e);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
        this.k(0);
        this.a(ww.c);
    }

    public boolean b() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void b(abw par1World, int par2, int par3, int par4, Random par5Random) {
        super.b(par1World, par2, par3, par4, par5Random);
        for (int l = par2 - 2; l <= par2 + 2; ++l) {
            block1: for (int i1 = par4 - 2; i1 <= par4 + 2; ++i1) {
                if (l > par2 - 2 && l < par2 + 2 && i1 == par4 - 1) {
                    i1 = par4 + 2;
                }
                if (par5Random.nextInt(16) != 0) continue;
                for (int j1 = par3; j1 <= par3 + 1; ++j1) {
                    if (par1World.a(l, j1, i1) != aqz.as.cF) continue;
                    if (!par1World.c((l - par2) / 2 + par2, j1, (i1 - par4) / 2 + par4)) continue block1;
                    par1World.a("enchantmenttable", (double)par2 + 0.5, (double)par3 + 2.0, (double)par4 + 0.5, (double)((float)(l - par2) + par5Random.nextFloat()) - 0.5, (double)((float)(j1 - par3) - par5Random.nextFloat() - 1.0f), (double)((float)(i1 - par4) + par5Random.nextFloat()) - 0.5);
                }
            }
        }
    }

    public boolean c() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public ms a(int par1, int par2) {
        return par1 == 0 ? this.b : (par1 == 1 ? this.a : this.cW);
    }

    public asp b(abw par1World) {
        return new ase();
    }

    public boolean a(abw par1World, int par2, int par3, int par4, uf par5EntityPlayer, int par6, float par7, float par8, float par9) {
        if (par1World.I) {
            return true;
        }
        ase tileentityenchantmenttable = (ase)par1World.r(par2, par3, par4);
        par5EntityPlayer.a(par2, par3, par4, tileentityenchantmenttable.b() ? tileentityenchantmenttable.a() : null);
        return true;
    }

    public void a(abw par1World, int par2, int par3, int par4, of par5EntityLivingBase, ye par6ItemStack) {
        super.a(par1World, par2, par3, par4, par5EntityLivingBase, par6ItemStack);
        if (par6ItemStack.u()) {
            ((ase)par1World.r(par2, par3, par4)).a(par6ItemStack.s());
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.cW = par1IconRegister.a(this.E() + "_side");
        this.a = par1IconRegister.a(this.E() + "_top");
        this.b = par1IconRegister.a(this.E() + "_bottom");
    }
}

