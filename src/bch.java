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
public class bch
extends bbo {
    public bcu a;
    public bcu b;
    public bcu c;
    public bcu d;
    public bcu e;
    public bcu f;

    public bch(float par1) {
        this(par1, 0.0f, 64, 64);
    }

    public bch(float par1, float par2, int par3, int par4) {
        this.a = new bcu(this).b(par3, par4);
        this.a.a(0.0f, 0.0f + par2, 0.0f);
        this.a.a(0, 0).a(-4.0f, -10.0f, -4.0f, 8, 10, 8, par1);
        this.f = new bcu(this).b(par3, par4);
        this.f.a(0.0f, par2 - 2.0f, 0.0f);
        this.f.a(24, 0).a(-1.0f, -1.0f, -6.0f, 2, 4, 2, par1);
        this.a.a(this.f);
        this.b = new bcu(this).b(par3, par4);
        this.b.a(0.0f, 0.0f + par2, 0.0f);
        this.b.a(16, 20).a(-4.0f, 0.0f, -3.0f, 8, 12, 6, par1);
        this.b.a(0, 38).a(-4.0f, 0.0f, -3.0f, 8, 18, 6, par1 + 0.5f);
        this.c = new bcu(this).b(par3, par4);
        this.c.a(0.0f, 0.0f + par2 + 2.0f, 0.0f);
        this.c.a(44, 22).a(-8.0f, -2.0f, -2.0f, 4, 8, 4, par1);
        this.c.a(44, 22).a(4.0f, -2.0f, -2.0f, 4, 8, 4, par1);
        this.c.a(40, 38).a(-4.0f, 2.0f, -2.0f, 8, 4, 4, par1);
        this.d = new bcu(this, 0, 22).b(par3, par4);
        this.d.a(-2.0f, 12.0f + par2, 0.0f);
        this.d.a(-2.0f, 0.0f, -2.0f, 4, 12, 4, par1);
        this.e = new bcu(this, 0, 22).b(par3, par4);
        this.e.i = true;
        this.e.a(2.0f, 12.0f + par2, 0.0f);
        this.e.a(-2.0f, 0.0f, -2.0f, 4, 12, 4, par1);
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.a(par2, par3, par4, par5, par6, par7, par1Entity);
        this.a.a(par7);
        this.b.a(par7);
        this.d.a(par7);
        this.e.a(par7);
        this.c.a(par7);
    }

    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        this.a.g = par4 / 57.295776f;
        this.a.f = par5 / 57.295776f;
        this.c.d = 3.0f;
        this.c.e = -1.0f;
        this.c.f = -0.75f;
        this.d.f = ls.b(par1 * 0.6662f) * 1.4f * par2 * 0.5f;
        this.e.f = ls.b(par1 * 0.6662f + (float)Math.PI) * 1.4f * par2 * 0.5f;
        this.d.g = 0.0f;
        this.e.g = 0.0f;
    }
}

