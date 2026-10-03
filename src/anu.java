/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  amy
 *  asx
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  mo
 *  ms
 *  mt
 *  nw
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

public class anu
extends amy {
    @SideOnly(value=Side.CLIENT)
    private ms[] b;

    public anu(int par1) {
        super(par1, true);
        this.b(true);
    }

    public int a(abw par1World) {
        return 20;
    }

    public boolean f() {
        return true;
    }

    public void a(abw par1World, int par2, int par3, int par4, nn par5Entity) {
        int l;
        if (!par1World.I && ((l = par1World.h(par2, par3, par4)) & 8) == 0) {
            this.d(par1World, par2, par3, par4, l);
        }
    }

    public void a(abw par1World, int par2, int par3, int par4, Random par5Random) {
        int l;
        if (!par1World.I && ((l = par1World.h(par2, par3, par4)) & 8) != 0) {
            this.d(par1World, par2, par3, par4, l);
        }
    }

    public int b(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return (par1IBlockAccess.h(par2, par3, par4) & 8) != 0 ? 15 : 0;
    }

    public int c(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return (par1IBlockAccess.h(par2, par3, par4) & 8) == 0 ? 0 : (par5 == 1 ? 15 : 0);
    }

    private void d(abw par1World, int par2, int par3, int par4, int par5) {
        boolean flag = (par5 & 8) != 0;
        boolean flag1 = false;
        float f = 0.125f;
        List list = par1World.a(st.class, asx.a().a((double)((float)par2 + f), (double)par3, (double)((float)par4 + f), (double)((float)(par2 + 1) - f), (double)((float)(par3 + 1) - f), (double)((float)(par4 + 1) - f)));
        if (!list.isEmpty()) {
            flag1 = true;
        }
        if (flag1 && !flag) {
            par1World.b(par2, par3, par4, par5 | 8, 3);
            par1World.f(par2, par3, par4, this.cF);
            par1World.f(par2, par3 - 1, par4, this.cF);
            par1World.g(par2, par3, par4, par2, par3, par4);
        }
        if (!flag1 && flag) {
            par1World.b(par2, par3, par4, par5 & 7, 3);
            par1World.f(par2, par3, par4, this.cF);
            par1World.f(par2, par3 - 1, par4, this.cF);
            par1World.g(par2, par3, par4, par2, par3, par4);
        }
        if (flag1) {
            par1World.a(par2, par3, par4, this.cF, this.a(par1World));
        }
        par1World.m(par2, par3, par4, this.cF);
    }

    public void a(abw par1World, int par2, int par3, int par4) {
        super.a(par1World, par2, par3, par4);
        this.d(par1World, par2, par3, par4, par1World.h(par2, par3, par4));
    }

    public boolean q_() {
        return true;
    }

    public int b_(abw par1World, int par2, int par3, int par4, int par5) {
        if ((par1World.h(par2, par3, par4) & 8) > 0) {
            float f = 0.125f;
            List list = par1World.a(st.class, asx.a().a((double)((float)par2 + f), (double)par3, (double)((float)par4 + f), (double)((float)(par2 + 1) - f), (double)((float)(par3 + 1) - f), (double)((float)(par4 + 1) - f)), nw.b);
            if (list.size() > 0) {
                return uy.b((mo)list.get(0));
            }
        }
        return 0;
    }

    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.b = new ms[2];
        this.b[0] = par1IconRegister.a(this.E());
        this.b[1] = par1IconRegister.a(this.E() + "_powered");
    }

    @SideOnly(value=Side.CLIENT)
    public ms a(int par1, int par2) {
        return (par2 & 8) != 0 ? this.b[1] : this.b[0];
    }
}

