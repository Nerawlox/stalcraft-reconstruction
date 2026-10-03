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
public class bcc
extends bbo {
    public bcu a;
    public bcu b;
    public bcu c;
    public bcu d;
    public bcu e;

    public bcc() {
        float f2 = 4.0f;
        float f1 = 0.0f;
        this.c = new bcu(this, 0, 0).b(64, 64);
        this.c.a(-4.0f, -8.0f, -4.0f, 8, 8, 8, f1 - 0.5f);
        this.c.a(0.0f, 0.0f + f2, 0.0f);
        this.d = new bcu(this, 32, 0).b(64, 64);
        this.d.a(-1.0f, 0.0f, -1.0f, 12, 2, 2, f1 - 0.5f);
        this.d.a(0.0f, 0.0f + f2 + 9.0f - 7.0f, 0.0f);
        this.e = new bcu(this, 32, 0).b(64, 64);
        this.e.a(-1.0f, 0.0f, -1.0f, 12, 2, 2, f1 - 0.5f);
        this.e.a(0.0f, 0.0f + f2 + 9.0f - 7.0f, 0.0f);
        this.a = new bcu(this, 0, 16).b(64, 64);
        this.a.a(-5.0f, -10.0f, -5.0f, 10, 10, 10, f1 - 0.5f);
        this.a.a(0.0f, 0.0f + f2 + 9.0f, 0.0f);
        this.b = new bcu(this, 0, 36).b(64, 64);
        this.b.a(-6.0f, -12.0f, -6.0f, 12, 12, 12, f1 - 0.5f);
        this.b.a(0.0f, 0.0f + f2 + 20.0f, 0.0f);
    }

    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        super.a(par1, par2, par3, par4, par5, par6, par7Entity);
        this.c.g = par4 / 57.295776f;
        this.c.f = par5 / 57.295776f;
        this.a.g = par4 / 57.295776f * 0.25f;
        float f6 = ls.a(this.a.g);
        float f7 = ls.b(this.a.g);
        this.d.h = 1.0f;
        this.e.h = -1.0f;
        this.d.g = 0.0f + this.a.g;
        this.e.g = (float)Math.PI + this.a.g;
        this.d.c = f7 * 5.0f;
        this.d.e = -f6 * 5.0f;
        this.e.c = -f7 * 5.0f;
        this.e.e = f6 * 5.0f;
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.a(par2, par3, par4, par5, par6, par7, par1Entity);
        this.a.a(par7);
        this.b.a(par7);
        this.c.a(par7);
        this.d.a(par7);
        this.e.a(par7);
    }
}

