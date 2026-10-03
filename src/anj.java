/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 *  asx
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  mt
 *  wh
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

public class anj
extends aqz {
    @SideOnly(value=Side.CLIENT)
    private ms a;
    @SideOnly(value=Side.CLIENT)
    private ms b;
    @SideOnly(value=Side.CLIENT)
    private ms c;

    public anj(int par1) {
        super(par1, akc.f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public ms a(int par1, int par2) {
        return par1 == 1 ? this.b : (par1 == 0 ? this.c : this.cW);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.a = par1IconRegister.a(this.E() + "_inner");
        this.b = par1IconRegister.a(this.E() + "_top");
        this.c = par1IconRegister.a(this.E() + "_bottom");
        this.cW = par1IconRegister.a(this.E() + "_side");
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, asx par5AxisAlignedBB, List par6List, nn par7Entity) {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.3125f, 1.0f);
        super.a(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        float f = 0.125f;
        this.a(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
        super.a(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
        super.a(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        this.a(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        super.a(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        this.a(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
        super.a(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        this.g();
    }

    @SideOnly(value=Side.CLIENT)
    public static ms b(String par0Str) {
        return par0Str.equals("inner") ? aqz.bL.a : (par0Str.equals("bottom") ? aqz.bL.c : null);
    }

    @Override
    public void g() {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public int d() {
        return 24;
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public boolean a(abw par1World, int par2, int par3, int par4, uf par5EntityPlayer, int par6, float par7, float par8, float par9) {
        if (par1World.I) {
            return true;
        }
        ye itemstack = par5EntityPlayer.bn.h();
        if (itemstack == null) {
            return true;
        }
        int i1 = par1World.h(par2, par3, par4);
        int j1 = anj.h_(i1);
        if (itemstack.d == yc.az.cv) {
            if (j1 < 3) {
                if (!par5EntityPlayer.bG.d) {
                    par5EntityPlayer.bn.a(par5EntityPlayer.bn.c, new ye(yc.ay));
                }
                par1World.b(par2, par3, par4, 3, 2);
                par1World.m(par2, par3, par4, this.cF);
            }
            return true;
        }
        if (itemstack.d == yc.bv.cv) {
            if (j1 > 0) {
                ye itemstack1 = new ye(yc.bu, 1, 0);
                if (!par5EntityPlayer.bn.a(itemstack1)) {
                    par1World.d(new ss(par1World, (double)par2 + 0.5, (double)par3 + 1.5, (double)par4 + 0.5, itemstack1));
                } else if (par5EntityPlayer instanceof jv) {
                    ((jv)par5EntityPlayer).a(par5EntityPlayer.bo);
                }
                --itemstack.b;
                if (itemstack.b <= 0) {
                    par5EntityPlayer.bn.a(par5EntityPlayer.bn.c, (ye)null);
                }
                par1World.b(par2, par3, par4, j1 - 1, 2);
                par1World.m(par2, par3, par4, this.cF);
            }
        } else if (j1 > 0 && itemstack.b() instanceof wh && ((wh)itemstack.b()).d() == wj.a) {
            wh itemarmor = (wh)itemstack.b();
            itemarmor.c(itemstack);
            par1World.b(par2, par3, par4, j1 - 1, 2);
            par1World.m(par2, par3, par4, this.cF);
            return true;
        }
        return true;
    }

    @Override
    public void g(abw par1World, int par2, int par3, int par4) {
        int l;
        if (par1World.s.nextInt(20) == 1 && (l = par1World.h(par2, par3, par4)) < 3) {
            par1World.b(par2, par3, par4, l + 1, 2);
        }
    }

    @Override
    public int a(int par1, Random par2Random, int par3) {
        return yc.bB.cv;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int d(abw par1World, int par2, int par3, int par4) {
        return yc.bB.cv;
    }

    @Override
    public boolean q_() {
        return true;
    }

    @Override
    public int b_(abw par1World, int par2, int par3, int par4, int par5) {
        int i1 = par1World.h(par2, par3, par4);
        return anj.h_(i1);
    }

    public static int h_(int par0) {
        return par0;
    }
}

