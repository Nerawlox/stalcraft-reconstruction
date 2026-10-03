/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  mt
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class apz
extends aqz {
    public static final String[] a = new String[]{"default", "chiseled", "lines"};
    private static final String[] b = new String[]{"side", "chiseled", "lines", null, null};
    @SideOnly(value=Side.CLIENT)
    private ms[] c;
    @SideOnly(value=Side.CLIENT)
    private ms d;
    @SideOnly(value=Side.CLIENT)
    private ms e;
    @SideOnly(value=Side.CLIENT)
    private ms cX;
    @SideOnly(value=Side.CLIENT)
    private ms cY;

    public apz(int par1) {
        super(par1, akc.e);
        this.a(ww.b);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public ms a(int par1, int par2) {
        if (par2 != 2 && par2 != 3 && par2 != 4) {
            if (par1 != 1 && (par1 != 0 || par2 != 1)) {
                if (par1 == 0) {
                    return this.cY;
                }
                if (par2 < 0 || par2 >= this.c.length) {
                    par2 = 0;
                }
                return this.c[par2];
            }
            return par2 == 1 ? this.d : this.cX;
        }
        return par2 == 2 && (par1 == 1 || par1 == 0) ? this.e : (par2 == 3 && (par1 == 5 || par1 == 4) ? this.e : (par2 == 4 && (par1 == 2 || par1 == 3) ? this.e : this.c[par2]));
    }

    @Override
    public int a(abw par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
        if (par9 == 2) {
            switch (par5) {
                case 0: 
                case 1: {
                    par9 = 2;
                    break;
                }
                case 2: 
                case 3: {
                    par9 = 4;
                    break;
                }
                case 4: 
                case 5: {
                    par9 = 3;
                }
            }
        }
        return par9;
    }

    @Override
    public int a(int par1) {
        return par1 != 3 && par1 != 4 ? par1 : 2;
    }

    @Override
    protected ye d_(int par1) {
        return par1 != 3 && par1 != 4 ? super.d_(par1) : new ye(this.cF, 1, 2);
    }

    @Override
    public int d() {
        return 39;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(int par1, ww par2CreativeTabs, List par3List) {
        par3List.add(new ye(par1, 1, 0));
        par3List.add(new ye(par1, 1, 1));
        par3List.add(new ye(par1, 1, 2));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.c = new ms[b.length];
        for (int i = 0; i < this.c.length; ++i) {
            this.c[i] = b[i] == null ? this.c[i - 1] : par1IconRegister.a(this.E() + "_" + b[i]);
        }
        this.cX = par1IconRegister.a(this.E() + "_top");
        this.d = par1IconRegister.a(this.E() + "_chiseled_top");
        this.e = par1IconRegister.a(this.E() + "_lines_top");
        this.cY = par1IconRegister.a(this.E() + "_bottom");
    }
}

