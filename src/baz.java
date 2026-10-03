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
public class baz
extends bbo {
    private bcu a;
    private bcu b;
    private bcu c;
    private bcu d;
    private bcu e;
    private bcu f;

    public baz() {
        this.t = 64;
        this.u = 64;
        this.a = new bcu(this, 0, 0);
        this.a.a(-3.0f, -3.0f, -3.0f, 6, 6, 6);
        bcu modelrenderer = new bcu(this, 24, 0);
        modelrenderer.a(-4.0f, -6.0f, -2.0f, 3, 4, 1);
        this.a.a(modelrenderer);
        bcu modelrenderer1 = new bcu(this, 24, 0);
        modelrenderer1.i = true;
        modelrenderer1.a(1.0f, -6.0f, -2.0f, 3, 4, 1);
        this.a.a(modelrenderer1);
        this.b = new bcu(this, 0, 16);
        this.b.a(-3.0f, 4.0f, -3.0f, 6, 12, 6);
        this.b.a(0, 34).a(-5.0f, 16.0f, 0.0f, 10, 6, 1);
        this.c = new bcu(this, 42, 0);
        this.c.a(-12.0f, 1.0f, 1.5f, 10, 16, 1);
        this.e = new bcu(this, 24, 16);
        this.e.a(-12.0f, 1.0f, 1.5f);
        this.e.a(-8.0f, 1.0f, 0.0f, 8, 12, 1);
        this.d = new bcu(this, 42, 0);
        this.d.i = true;
        this.d.a(2.0f, 1.0f, 1.5f, 10, 16, 1);
        this.f = new bcu(this, 24, 16);
        this.f.i = true;
        this.f.a(12.0f, 1.0f, 1.5f);
        this.f.a(0.0f, 1.0f, 0.0f, 8, 12, 1);
        this.b.a(this.c);
        this.b.a(this.d);
        this.c.a(this.e);
        this.d.a(this.f);
    }

    public int a() {
        return 36;
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        ro entitybat = (ro)((Object)par1Entity);
        if (entitybat.bJ()) {
            float f6 = 57.295776f;
            this.a.f = par6 / 57.295776f;
            this.a.g = (float)Math.PI - par5 / 57.295776f;
            this.a.h = (float)Math.PI;
            this.a.a(0.0f, -2.0f, 0.0f);
            this.c.a(-3.0f, 0.0f, 3.0f);
            this.d.a(3.0f, 0.0f, 3.0f);
            this.b.f = (float)Math.PI;
            this.c.f = -0.15707964f;
            this.c.g = -1.2566371f;
            this.e.g = -1.7278761f;
            this.d.f = this.c.f;
            this.d.g = -this.c.g;
            this.f.g = -this.e.g;
        } else {
            float f6 = 57.295776f;
            this.a.f = par6 / 57.295776f;
            this.a.g = par5 / 57.295776f;
            this.a.h = 0.0f;
            this.a.a(0.0f, 0.0f, 0.0f);
            this.c.a(0.0f, 0.0f, 0.0f);
            this.d.a(0.0f, 0.0f, 0.0f);
            this.b.f = 0.7853982f + ls.b(par4 * 0.1f) * 0.15f;
            this.b.g = 0.0f;
            this.c.g = ls.b(par4 * 1.3f) * (float)Math.PI * 0.25f;
            this.d.g = -this.c.g;
            this.e.g = this.c.g * 0.5f;
            this.f.g = -this.c.g * 0.5f;
        }
        this.a.a(par7);
        this.b.a(par7);
    }
}

