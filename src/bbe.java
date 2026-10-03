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
public class bbe
extends bbo {
    public bcu a;
    public bcu b;
    public bcu c;
    public bcu d;
    public bcu e;
    public bcu f;
    public bcu g;
    public bcu h;

    public bbe() {
        int b0 = 16;
        this.a = new bcu(this, 0, 0);
        this.a.a(-2.0f, -6.0f, -2.0f, 4, 6, 3, 0.0f);
        this.a.a(0.0f, -1 + b0, -4.0f);
        this.g = new bcu(this, 14, 0);
        this.g.a(-2.0f, -4.0f, -4.0f, 4, 2, 2, 0.0f);
        this.g.a(0.0f, -1 + b0, -4.0f);
        this.h = new bcu(this, 14, 4);
        this.h.a(-1.0f, -2.0f, -3.0f, 2, 2, 2, 0.0f);
        this.h.a(0.0f, -1 + b0, -4.0f);
        this.b = new bcu(this, 0, 9);
        this.b.a(-3.0f, -4.0f, -3.0f, 6, 8, 6, 0.0f);
        this.b.a(0.0f, b0, 0.0f);
        this.c = new bcu(this, 26, 0);
        this.c.a(-1.0f, 0.0f, -3.0f, 3, 5, 3);
        this.c.a(-2.0f, 3 + b0, 1.0f);
        this.d = new bcu(this, 26, 0);
        this.d.a(-1.0f, 0.0f, -3.0f, 3, 5, 3);
        this.d.a(1.0f, 3 + b0, 1.0f);
        this.e = new bcu(this, 24, 13);
        this.e.a(0.0f, 0.0f, -3.0f, 1, 4, 6);
        this.e.a(-4.0f, -3 + b0, 0.0f);
        this.f = new bcu(this, 24, 13);
        this.f.a(-1.0f, 0.0f, -3.0f, 1, 4, 6);
        this.f.a(4.0f, -3 + b0, 0.0f);
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.a(par2, par3, par4, par5, par6, par7, par1Entity);
        if (this.s) {
            float f6 = 2.0f;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)0.0f, (float)(5.0f * par7), (float)(2.0f * par7));
            this.a.a(par7);
            this.g.a(par7);
            this.h.a(par7);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef((float)(1.0f / f6), (float)(1.0f / f6), (float)(1.0f / f6));
            GL11.glTranslatef((float)0.0f, (float)(24.0f * par7), (float)0.0f);
            this.b.a(par7);
            this.c.a(par7);
            this.d.a(par7);
            this.e.a(par7);
            this.f.a(par7);
            GL11.glPopMatrix();
        } else {
            this.a.a(par7);
            this.g.a(par7);
            this.h.a(par7);
            this.b.a(par7);
            this.c.a(par7);
            this.d.a(par7);
            this.e.a(par7);
            this.f.a(par7);
        }
    }

    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        this.a.f = par5 / 57.295776f;
        this.a.g = par4 / 57.295776f;
        this.g.f = this.a.f;
        this.g.g = this.a.g;
        this.h.f = this.a.f;
        this.h.g = this.a.g;
        this.b.f = 1.5707964f;
        this.c.f = ls.b(par1 * 0.6662f) * 1.4f * par2;
        this.d.f = ls.b(par1 * 0.6662f + (float)Math.PI) * 1.4f * par2;
        this.e.h = par3;
        this.f.h = -par3;
    }
}

