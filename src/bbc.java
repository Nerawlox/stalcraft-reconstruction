/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bbo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class bbc
extends bbo {
    public bcu a = new bcu(this).a(0, 0).a(-6.0f, -5.0f, 0.0f, 6, 10, 0);
    public bcu b = new bcu(this).a(16, 0).a(0.0f, -5.0f, 0.0f, 6, 10, 0);
    public bcu c = new bcu(this).a(0, 10).a(0.0f, -4.0f, -0.99f, 5, 8, 1);
    public bcu d = new bcu(this).a(12, 10).a(0.0f, -4.0f, -0.01f, 5, 8, 1);
    public bcu e = new bcu(this).a(24, 10).a(0.0f, -4.0f, 0.0f, 5, 8, 0);
    public bcu f = new bcu(this).a(24, 10).a(0.0f, -4.0f, 0.0f, 5, 8, 0);
    public bcu g = new bcu(this).a(12, 0).a(-1.0f, -5.0f, 0.0f, 2, 10, 0);

    public bbc() {
        this.a.a(0.0f, 0.0f, -1.0f);
        this.b.a(0.0f, 0.0f, 1.0f);
        this.g.g = 1.5707964f;
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.a(par2, par3, par4, par5, par6, par7, par1Entity);
        this.a.a(par7);
        this.b.a(par7);
        this.g.a(par7);
        this.c.a(par7);
        this.d.a(par7);
        this.e.a(par7);
        this.f.a(par7);
    }

    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        float f6 = (ls.a(par1 * 0.02f) * 0.1f + 1.25f) * par4;
        this.a.g = (float)Math.PI + f6;
        this.b.g = -f6;
        this.c.g = f6;
        this.d.g = -f6;
        this.e.g = f6 - f6 * 2.0f * par2;
        this.f.g = f6 - f6 * 2.0f * par3;
        this.c.c = ls.a(f6);
        this.d.c = ls.a(f6);
        this.e.c = ls.a(f6);
        this.f.c = ls.a(f6);
    }
}

