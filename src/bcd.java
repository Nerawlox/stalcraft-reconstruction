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
public class bcd
extends bbo {
    public bcu a;
    public bcu b;
    public bcu c;
    public bcu d;
    public bcu e;
    public bcu f;
    public bcu g;
    public bcu h;
    public bcu i;
    public bcu j;
    public bcu k;

    public bcd() {
        float f2 = 0.0f;
        int b0 = 15;
        this.a = new bcu(this, 32, 4);
        this.a.a(-4.0f, -4.0f, -8.0f, 8, 8, 8, f2);
        this.a.a(0.0f, b0, -3.0f);
        this.b = new bcu(this, 0, 0);
        this.b.a(-3.0f, -3.0f, -3.0f, 6, 6, 6, f2);
        this.b.a(0.0f, b0, 0.0f);
        this.c = new bcu(this, 0, 12);
        this.c.a(-5.0f, -4.0f, -6.0f, 10, 8, 12, f2);
        this.c.a(0.0f, b0, 9.0f);
        this.d = new bcu(this, 18, 0);
        this.d.a(-15.0f, -1.0f, -1.0f, 16, 2, 2, f2);
        this.d.a(-4.0f, b0, 2.0f);
        this.e = new bcu(this, 18, 0);
        this.e.a(-1.0f, -1.0f, -1.0f, 16, 2, 2, f2);
        this.e.a(4.0f, b0, 2.0f);
        this.f = new bcu(this, 18, 0);
        this.f.a(-15.0f, -1.0f, -1.0f, 16, 2, 2, f2);
        this.f.a(-4.0f, b0, 1.0f);
        this.g = new bcu(this, 18, 0);
        this.g.a(-1.0f, -1.0f, -1.0f, 16, 2, 2, f2);
        this.g.a(4.0f, b0, 1.0f);
        this.h = new bcu(this, 18, 0);
        this.h.a(-15.0f, -1.0f, -1.0f, 16, 2, 2, f2);
        this.h.a(-4.0f, b0, 0.0f);
        this.i = new bcu(this, 18, 0);
        this.i.a(-1.0f, -1.0f, -1.0f, 16, 2, 2, f2);
        this.i.a(4.0f, b0, 0.0f);
        this.j = new bcu(this, 18, 0);
        this.j.a(-15.0f, -1.0f, -1.0f, 16, 2, 2, f2);
        this.j.a(-4.0f, b0, -1.0f);
        this.k = new bcu(this, 18, 0);
        this.k.a(-1.0f, -1.0f, -1.0f, 16, 2, 2, f2);
        this.k.a(4.0f, b0, -1.0f);
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.a(par2, par3, par4, par5, par6, par7, par1Entity);
        this.a.a(par7);
        this.b.a(par7);
        this.c.a(par7);
        this.d.a(par7);
        this.e.a(par7);
        this.f.a(par7);
        this.g.a(par7);
        this.h.a(par7);
        this.i.a(par7);
        this.j.a(par7);
        this.k.a(par7);
    }

    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        this.a.g = par4 / 57.295776f;
        this.a.f = par5 / 57.295776f;
        float f6 = 0.7853982f;
        this.d.h = -f6;
        this.e.h = f6;
        this.f.h = -f6 * 0.74f;
        this.g.h = f6 * 0.74f;
        this.h.h = -f6 * 0.74f;
        this.i.h = f6 * 0.74f;
        this.j.h = -f6;
        this.k.h = f6;
        float f7 = -0.0f;
        float f8 = 0.3926991f;
        this.d.g = f8 * 2.0f + f7;
        this.e.g = -f8 * 2.0f - f7;
        this.f.g = f8 * 1.0f + f7;
        this.g.g = -f8 * 1.0f - f7;
        this.h.g = -f8 * 1.0f + f7;
        this.i.g = f8 * 1.0f - f7;
        this.j.g = -f8 * 2.0f + f7;
        this.k.g = f8 * 2.0f - f7;
        float f9 = -(ls.b(par1 * 0.6662f * 2.0f + 0.0f) * 0.4f) * par2;
        float f10 = -(ls.b(par1 * 0.6662f * 2.0f + (float)Math.PI) * 0.4f) * par2;
        float f11 = -(ls.b(par1 * 0.6662f * 2.0f + 1.5707964f) * 0.4f) * par2;
        float f12 = -(ls.b(par1 * 0.6662f * 2.0f + 4.712389f) * 0.4f) * par2;
        float f13 = Math.abs(ls.a(par1 * 0.6662f + 0.0f) * 0.4f) * par2;
        float f14 = Math.abs(ls.a(par1 * 0.6662f + (float)Math.PI) * 0.4f) * par2;
        float f15 = Math.abs(ls.a(par1 * 0.6662f + 1.5707964f) * 0.4f) * par2;
        float f16 = Math.abs(ls.a(par1 * 0.6662f + 4.712389f) * 0.4f) * par2;
        this.d.g += f9;
        this.e.g += -f9;
        this.f.g += f10;
        this.g.g += -f10;
        this.h.g += f11;
        this.i.g += -f11;
        this.j.g += f12;
        this.k.g += -f12;
        this.d.h += f13;
        this.e.h += -f13;
        this.f.h += f14;
        this.g.h += -f14;
        this.h.h += f15;
        this.i.h += -f15;
        this.j.h += f16;
        this.k.h += -f16;
    }
}

