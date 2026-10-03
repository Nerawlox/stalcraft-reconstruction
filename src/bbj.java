/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bbo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bbj
extends bbo {
    public bcu c;
    public bcu d;
    public bcu e;
    public bcu f;
    public bcu g;
    public bcu h;
    public bcu i;
    public bcu j;
    public bcu k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;

    public bbj() {
        this(0.0f);
    }

    public bbj(float par1) {
        this(par1, 0.0f, 64, 32);
    }

    public bbj(float par1, float par2, int par3, int par4) {
        this.t = par3;
        this.u = par4;
        this.k = new bcu(this, 0, 0);
        this.k.a(-5.0f, 0.0f, -1.0f, 10, 16, 1, par1);
        this.j = new bcu(this, 24, 0);
        this.j.a(-3.0f, -6.0f, -1.0f, 6, 6, 1, par1);
        this.c = new bcu(this, 0, 0);
        this.c.a(-4.0f, -8.0f, -4.0f, 8, 8, 8, par1);
        this.c.a(0.0f, 0.0f + par2, 0.0f);
        this.d = new bcu(this, 32, 0);
        this.d.a(-4.0f, -8.0f, -4.0f, 8, 8, 8, par1 + 0.5f);
        this.d.a(0.0f, 0.0f + par2, 0.0f);
        this.e = new bcu(this, 16, 16);
        this.e.a(-4.0f, 0.0f, -2.0f, 8, 12, 4, par1);
        this.e.a(0.0f, 0.0f + par2, 0.0f);
        this.f = new bcu(this, 40, 16);
        this.f.a(-3.0f, -2.0f, -2.0f, 4, 12, 4, par1);
        this.f.a(-5.0f, 2.0f + par2, 0.0f);
        this.g = new bcu(this, 40, 16);
        this.g.i = true;
        this.g.a(-1.0f, -2.0f, -2.0f, 4, 12, 4, par1);
        this.g.a(5.0f, 2.0f + par2, 0.0f);
        this.h = new bcu(this, 0, 16);
        this.h.a(-2.0f, 0.0f, -2.0f, 4, 12, 4, par1);
        this.h.a(-1.9f, 12.0f + par2, 0.0f);
        this.i = new bcu(this, 0, 16);
        this.i.i = true;
        this.i.a(-2.0f, 0.0f, -2.0f, 4, 12, 4, par1);
        this.i.a(1.9f, 12.0f + par2, 0.0f);
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.a(par2, par3, par4, par5, par6, par7, par1Entity);
        if (this.s) {
            float f6 = 2.0f;
            GL11.glPushMatrix();
            GL11.glScalef((float)(1.5f / f6), (float)(1.5f / f6), (float)(1.5f / f6));
            GL11.glTranslatef((float)0.0f, (float)(16.0f * par7), (float)0.0f);
            this.c.a(par7);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef((float)(1.0f / f6), (float)(1.0f / f6), (float)(1.0f / f6));
            GL11.glTranslatef((float)0.0f, (float)(24.0f * par7), (float)0.0f);
            this.e.a(par7);
            this.f.a(par7);
            this.g.a(par7);
            this.h.a(par7);
            this.i.a(par7);
            this.d.a(par7);
            GL11.glPopMatrix();
        } else {
            this.c.a(par7);
            this.e.a(par7);
            this.f.a(par7);
            this.g.a(par7);
            this.h.a(par7);
            this.i.a(par7);
            this.d.a(par7);
        }
    }

    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        float f7;
        float f6;
        this.c.g = par4 / 57.295776f;
        this.c.f = par5 / 57.295776f;
        this.d.g = this.c.g;
        this.d.f = this.c.f;
        this.f.f = ls.b(par1 * 0.6662f + (float)Math.PI) * 2.0f * par2 * 0.5f;
        this.g.f = ls.b(par1 * 0.6662f) * 2.0f * par2 * 0.5f;
        this.f.h = 0.0f;
        this.g.h = 0.0f;
        this.h.f = ls.b(par1 * 0.6662f) * 1.4f * par2;
        this.i.f = ls.b(par1 * 0.6662f + (float)Math.PI) * 1.4f * par2;
        this.h.g = 0.0f;
        this.i.g = 0.0f;
        if (this.q) {
            this.f.f += -0.62831855f;
            this.g.f += -0.62831855f;
            this.h.f = -1.2566371f;
            this.i.f = -1.2566371f;
            this.h.g = 0.31415927f;
            this.i.g = -0.31415927f;
        }
        if (this.l != 0) {
            this.g.f = this.g.f * 0.5f - 0.31415927f * (float)this.l;
        }
        if (this.m != 0) {
            this.f.f = this.f.f * 0.5f - 0.31415927f * (float)this.m;
        }
        this.f.g = 0.0f;
        this.g.g = 0.0f;
        if (this.p > -9990.0f) {
            f6 = this.p;
            this.e.g = ls.a(ls.c(f6) * (float)Math.PI * 2.0f) * 0.2f;
            this.f.e = ls.a(this.e.g) * 5.0f;
            this.f.c = -ls.b(this.e.g) * 5.0f;
            this.g.e = -ls.a(this.e.g) * 5.0f;
            this.g.c = ls.b(this.e.g) * 5.0f;
            this.f.g += this.e.g;
            this.g.g += this.e.g;
            this.g.f += this.e.g;
            f6 = 1.0f - this.p;
            f6 *= f6;
            f6 *= f6;
            f6 = 1.0f - f6;
            f7 = ls.a(f6 * (float)Math.PI);
            float f8 = ls.a(this.p * (float)Math.PI) * -(this.c.f - 0.7f) * 0.75f;
            this.f.f = (float)((double)this.f.f - ((double)f7 * 1.2 + (double)f8));
            this.f.g += this.e.g * 2.0f;
            this.f.h = ls.a(this.p * (float)Math.PI) * -0.4f;
        }
        if (this.n) {
            this.e.f = 0.5f;
            this.f.f += 0.4f;
            this.g.f += 0.4f;
            this.h.e = 4.0f;
            this.i.e = 4.0f;
            this.h.d = 9.0f;
            this.i.d = 9.0f;
            this.c.d = 1.0f;
            this.d.d = 1.0f;
        } else {
            this.e.f = 0.0f;
            this.h.e = 0.1f;
            this.i.e = 0.1f;
            this.h.d = 12.0f;
            this.i.d = 12.0f;
            this.c.d = 0.0f;
            this.d.d = 0.0f;
        }
        this.f.h += ls.b(par3 * 0.09f) * 0.05f + 0.05f;
        this.g.h -= ls.b(par3 * 0.09f) * 0.05f + 0.05f;
        this.f.f += ls.a(par3 * 0.067f) * 0.05f;
        this.g.f -= ls.a(par3 * 0.067f) * 0.05f;
        if (this.o) {
            f6 = 0.0f;
            f7 = 0.0f;
            this.f.h = 0.0f;
            this.g.h = 0.0f;
            this.f.g = -(0.1f - f6 * 0.6f) + this.c.g;
            this.g.g = 0.1f - f6 * 0.6f + this.c.g + 0.4f;
            this.f.f = -1.5707964f + this.c.f;
            this.g.f = -1.5707964f + this.c.f;
            this.f.f -= f6 * 1.2f - f7 * 0.4f;
            this.g.f -= f6 * 1.2f - f7 * 0.4f;
            this.f.h += ls.b(par3 * 0.09f) * 0.05f + 0.05f;
            this.g.h -= ls.b(par3 * 0.09f) * 0.05f + 0.05f;
            this.f.f += ls.a(par3 * 0.067f) * 0.05f;
            this.g.f -= ls.a(par3 * 0.067f) * 0.05f;
        }
    }

    public void b(float par1) {
        this.j.g = this.c.g;
        this.j.f = this.c.f;
        this.j.c = 0.0f;
        this.j.d = 0.0f;
        this.j.a(par1);
    }

    public void c(float par1) {
        this.k.a(par1);
    }
}

