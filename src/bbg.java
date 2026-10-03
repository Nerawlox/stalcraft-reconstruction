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
public class bbg
extends bbo {
    public bcu a;
    public bcu b;
    public bcu c;
    public bcu d;
    public bcu e;
    public bcu f;
    public bcu g;

    public bbg() {
        this(0.0f);
    }

    public bbg(float par1) {
        int b0 = 4;
        this.a = new bcu(this, 0, 0);
        this.a.a(-4.0f, -8.0f, -4.0f, 8, 8, 8, par1);
        this.a.a(0.0f, b0, 0.0f);
        this.b = new bcu(this, 32, 0);
        this.b.a(-4.0f, -8.0f, -4.0f, 8, 8, 8, par1 + 0.5f);
        this.b.a(0.0f, b0, 0.0f);
        this.c = new bcu(this, 16, 16);
        this.c.a(-4.0f, 0.0f, -2.0f, 8, 12, 4, par1);
        this.c.a(0.0f, b0, 0.0f);
        this.d = new bcu(this, 0, 16);
        this.d.a(-2.0f, 0.0f, -2.0f, 4, 6, 4, par1);
        this.d.a(-2.0f, 12 + b0, 4.0f);
        this.e = new bcu(this, 0, 16);
        this.e.a(-2.0f, 0.0f, -2.0f, 4, 6, 4, par1);
        this.e.a(2.0f, 12 + b0, 4.0f);
        this.f = new bcu(this, 0, 16);
        this.f.a(-2.0f, 0.0f, -2.0f, 4, 6, 4, par1);
        this.f.a(-2.0f, 12 + b0, -4.0f);
        this.g = new bcu(this, 0, 16);
        this.g.a(-2.0f, 0.0f, -2.0f, 4, 6, 4, par1);
        this.g.a(2.0f, 12 + b0, -4.0f);
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.a(par2, par3, par4, par5, par6, par7, par1Entity);
        this.a.a(par7);
        this.c.a(par7);
        this.d.a(par7);
        this.e.a(par7);
        this.f.a(par7);
        this.g.a(par7);
    }

    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        this.a.g = par4 / 57.295776f;
        this.a.f = par5 / 57.295776f;
        this.d.f = ls.b(par1 * 0.6662f) * 1.4f * par2;
        this.e.f = ls.b(par1 * 0.6662f + (float)Math.PI) * 1.4f * par2;
        this.f.f = ls.b(par1 * 0.6662f + (float)Math.PI) * 1.4f * par2;
        this.g.f = ls.b(par1 * 0.6662f) * 1.4f * par2;
    }
}

