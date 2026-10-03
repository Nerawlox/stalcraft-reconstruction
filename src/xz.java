/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  oc
 *  od
 *  ol
 *  r
 */
public class xz
extends yc {
    private final Class a;

    public xz(int par1, Class par2Class) {
        super(par1);
        this.a = par2Class;
        this.a(ww.c);
    }

    @Override
    public boolean a(ye par1ItemStack, uf par2EntityPlayer, abw par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        if (par7 == 0) {
            return false;
        }
        if (par7 == 1) {
            return false;
        }
        int i1 = r.e[par7];
        oc entityhanging = this.a(par3World, par4, par5, par6, i1);
        if (!par2EntityPlayer.a(par4, par5, par6, par7, par1ItemStack)) {
            return false;
        }
        if (entityhanging != null && entityhanging.c()) {
            if (!par3World.I) {
                par3World.d((nn)entityhanging);
            }
            --par1ItemStack.b;
        }
        return true;
    }

    private oc a(abw par1World, int par2, int par3, int par4, int par5) {
        return this.a == ol.class ? new ol(par1World, par2, par3, par4, par5) : (this.a == od.class ? new od(par1World, par2, par3, par4, par5) : null);
    }
}

