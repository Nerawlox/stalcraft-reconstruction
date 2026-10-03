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
import java.util.Random;

public class aou
extends aqz {
    private static final String[] a = new String[]{"skin_brown", "skin_red"};
    private final int b;
    @SideOnly(value=Side.CLIENT)
    private ms[] c;
    @SideOnly(value=Side.CLIENT)
    private ms d;
    @SideOnly(value=Side.CLIENT)
    private ms e;

    public aou(int par1, akc par2Material, int par3) {
        super(par1, par2Material);
        this.b = par3;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public ms a(int par1, int par2) {
        return par2 == 10 && par1 > 1 ? this.d : (par2 >= 1 && par2 <= 9 && par1 == 1 ? this.c[this.b] : (par2 >= 1 && par2 <= 3 && par1 == 2 ? this.c[this.b] : (par2 >= 7 && par2 <= 9 && par1 == 3 ? this.c[this.b] : ((par2 == 1 || par2 == 4 || par2 == 7) && par1 == 4 ? this.c[this.b] : ((par2 == 3 || par2 == 6 || par2 == 9) && par1 == 5 ? this.c[this.b] : (par2 == 14 ? this.c[this.b] : (par2 == 15 ? this.d : this.e)))))));
    }

    @Override
    public int a(Random par1Random) {
        int i = par1Random.nextInt(10) - 7;
        if (i < 0) {
            i = 0;
        }
        return i;
    }

    @Override
    public int a(int par1, Random par2Random, int par3) {
        return aqz.ak.cF + this.b;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int d(abw par1World, int par2, int par3, int par4) {
        return aqz.ak.cF + this.b;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.c = new ms[a.length];
        for (int i = 0; i < this.c.length; ++i) {
            this.c[i] = par1IconRegister.a(this.E() + "_" + a[i]);
        }
        this.e = par1IconRegister.a(this.E() + "_inside");
        this.d = par1IconRegister.a(this.E() + "_skin_stem");
    }
}

