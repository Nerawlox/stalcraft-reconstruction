/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 */
import java.util.List;

public class yg
extends yc {
    public yg(int par1) {
        super(par1);
        this.a(ww.i);
    }

    @Override
    public boolean a(ye par1ItemStack, uf par2EntityPlayer, abw par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        int i1 = par3World.a(par4, par5, par6);
        if (aqz.s[i1] != null && aqz.s[i1].d() == 11) {
            if (par3World.I) {
                return true;
            }
            yg.a(par2EntityPlayer, par3World, par4, par5, par6);
            return true;
        }
        return false;
    }

    public static boolean a(uf par0EntityPlayer, abw par1World, int par2, int par3, int par4) {
        oe entityleashknot = oe.b(par1World, par2, par3, par4);
        boolean flag = false;
        double d0 = 7.0;
        List list = par1World.a(og.class, asx.a().a((double)par2 - d0, (double)par3 - d0, (double)par4 - d0, (double)par2 + d0, (double)par3 + d0, (double)par4 + d0));
        if (list != null) {
            for (og entityliving : list) {
                if (!entityliving.bH() || entityliving.bI() != par0EntityPlayer) continue;
                if (entityleashknot == null) {
                    entityleashknot = oe.a(par1World, par2, par3, par4);
                }
                entityliving.b((nn)((Object)entityleashknot), true);
                flag = true;
            }
        }
        return flag;
    }
}

