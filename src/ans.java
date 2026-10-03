/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  akc
 *  amw
 *  asb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  mt
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

public class ans
extends amw {
    private ms[] a = new ms[2];

    public ans(int par1) {
        super(par1, akc.d);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.375f, 1.0f);
        this.a(ww.d);
    }

    public void a(acf par1IBlockAccess, int par2, int par3, int par4) {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.375f, 1.0f);
    }

    public int b(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return par1IBlockAccess.h(par2, par3, par4);
    }

    public void a(abw par1World, int par2, int par3, int par4, Random par5Random) {
    }

    public void a(abw par1World, int par2, int par3, int par4, int par5) {
    }

    public void a(abw par1World, int par2, int par3, int par4) {
    }

    public void i_(abw par1World, int par2, int par3, int par4) {
        if (!par1World.t.g) {
            int l = par1World.h(par2, par3, par4);
            int i1 = par1World.b(ach.a, par2, par3, par4) - par1World.j;
            float f = par1World.d(1.0f);
            f = f < (float)Math.PI ? (f += (0.0f - f) * 0.2f) : (f += ((float)Math.PI * 2 - f) * 0.2f);
            i1 = Math.round((float)i1 * ls.b(f));
            if (i1 < 0) {
                i1 = 0;
            }
            if (i1 > 15) {
                i1 = 15;
            }
            if (l != i1) {
                par1World.b(par2, par3, par4, i1, 3);
            }
        }
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public boolean f() {
        return true;
    }

    public asp b(abw par1World) {
        return new asb();
    }

    @SideOnly(value=Side.CLIENT)
    public ms a(int par1, int par2) {
        return par1 == 1 ? this.a[0] : this.a[1];
    }

    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.a[0] = par1IconRegister.a(this.E() + "_top");
        this.a[1] = par1IconRegister.a(this.E() + "_side");
    }
}

