/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  mt
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class zh
extends yc {
    private int a;
    @SideOnly(value=Side.CLIENT)
    private ms b;

    public zh(int par1) {
        super(par1);
        this.a = par1 + 256;
    }

    public int g() {
        return this.a;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int l() {
        return aqz.s[this.a].u_() != null ? 1 : 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public ms b_(int par1) {
        return this.b != null ? this.b : aqz.s[this.a].m(1);
    }

    @Override
    public boolean a(ye par1ItemStack, uf par2EntityPlayer, abw par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        int i1 = par3World.a(par4, par5, par6);
        if (i1 == aqz.aX.cF && (par3World.h(par4, par5, par6) & 7) < 1) {
            par7 = 1;
        } else if (!(i1 == aqz.bz.cF || i1 == aqz.ac.cF || i1 == aqz.ad.cF || aqz.s[i1] != null && aqz.s[i1].isBlockReplaceable(par3World, par4, par5, par6))) {
            if (par7 == 0) {
                --par5;
            }
            if (par7 == 1) {
                ++par5;
            }
            if (par7 == 2) {
                --par6;
            }
            if (par7 == 3) {
                ++par6;
            }
            if (par7 == 4) {
                --par4;
            }
            if (par7 == 5) {
                ++par4;
            }
        }
        if (par1ItemStack.b == 0) {
            return false;
        }
        if (!par2EntityPlayer.a(par4, par5, par6, par7, par1ItemStack)) {
            return false;
        }
        if (par5 == 255 && aqz.s[this.a].cU.a()) {
            return false;
        }
        if (par3World.a(this.a, par4, par5, par6, false, par7, par2EntityPlayer, par1ItemStack)) {
            aqz block = aqz.s[this.a];
            int j1 = this.a(par1ItemStack.k());
            int k1 = aqz.s[this.a].a(par3World, par4, par5, par6, par7, par8, par9, par10, j1);
            if (this.placeBlockAt(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10, k1)) {
                par3World.a((float)par4 + 0.5f, (double)((float)par5 + 0.5f), (double)((float)par6 + 0.5f), block.cS.b(), (block.cS.c() + 1.0f) / 2.0f, block.cS.d() * 0.8f);
                --par1ItemStack.b;
            }
            return true;
        }
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean a(abw par1World, int par2, int par3, int par4, int par5, uf par6EntityPlayer, ye par7ItemStack) {
        int i1 = par1World.a(par2, par3, par4);
        if (i1 == aqz.aX.cF) {
            par5 = 1;
        } else if (!(i1 == aqz.bz.cF || i1 == aqz.ac.cF || i1 == aqz.ad.cF || aqz.s[i1] != null && aqz.s[i1].isBlockReplaceable(par1World, par2, par3, par4))) {
            if (par5 == 0) {
                --par3;
            }
            if (par5 == 1) {
                ++par3;
            }
            if (par5 == 2) {
                --par4;
            }
            if (par5 == 3) {
                ++par4;
            }
            if (par5 == 4) {
                --par2;
            }
            if (par5 == 5) {
                ++par2;
            }
        }
        return par1World.a(this.g(), par2, par3, par4, false, par5, null, par7ItemStack);
    }

    @Override
    public String d(ye par1ItemStack) {
        return aqz.s[this.a].a();
    }

    @Override
    public String a() {
        return aqz.s[this.a].a();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public ww y() {
        return aqz.s[this.a].D();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(int par1, ww par2CreativeTabs, List par3List) {
        aqz.s[this.a].a(par1, par2CreativeTabs, par3List);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        String s2 = aqz.s[this.a].u_();
        if (s2 != null) {
            this.b = par1IconRegister.a(s2);
        }
    }

    public boolean placeBlockAt(ye stack, uf player, abw world, int x2, int y2, int z2, int side, float hitX, float hitY, float hitZ, int metadata) {
        if (!world.f(x2, y2, z2, this.a, metadata, 3)) {
            return false;
        }
        if (world.a(x2, y2, z2) == this.a) {
            aqz.s[this.a].a(world, x2, y2, z2, player, stack);
            aqz.s[this.a].k(world, x2, y2, z2, metadata);
        }
        return true;
    }
}

