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
public class bbq
extends bbo {
    bcu a;
    bcu b;
    bcu c;
    bcu d;
    bcu e;
    bcu f;
    bcu g;
    bcu h;
    int i = 1;

    public bbq() {
        this.a("head.main", 0, 0);
        this.a("head.nose", 0, 24);
        this.a("head.ear1", 0, 10);
        this.a("head.ear2", 6, 10);
        this.g = new bcu(this, "head");
        this.g.a("main", -2.5f, -2.0f, -3.0f, 5, 4, 5);
        this.g.a("nose", -1.5f, 0.0f, -4.0f, 3, 2, 2);
        this.g.a("ear1", -2.0f, -3.0f, 0.0f, 1, 1, 2);
        this.g.a("ear2", 1.0f, -3.0f, 0.0f, 1, 1, 2);
        this.g.a(0.0f, 15.0f, -9.0f);
        this.h = new bcu(this, 20, 0);
        this.h.a(-2.0f, 3.0f, -8.0f, 4, 16, 6, 0.0f);
        this.h.a(0.0f, 12.0f, -10.0f);
        this.e = new bcu(this, 0, 15);
        this.e.a(-0.5f, 0.0f, 0.0f, 1, 8, 1);
        this.e.f = 0.9f;
        this.e.a(0.0f, 15.0f, 8.0f);
        this.f = new bcu(this, 4, 15);
        this.f.a(-0.5f, 0.0f, 0.0f, 1, 8, 1);
        this.f.a(0.0f, 20.0f, 14.0f);
        this.a = new bcu(this, 8, 13);
        this.a.a(-1.0f, 0.0f, 1.0f, 2, 6, 2);
        this.a.a(1.1f, 18.0f, 5.0f);
        this.b = new bcu(this, 8, 13);
        this.b.a(-1.0f, 0.0f, 1.0f, 2, 6, 2);
        this.b.a(-1.1f, 18.0f, 5.0f);
        this.c = new bcu(this, 40, 0);
        this.c.a(-1.0f, 0.0f, 0.0f, 2, 10, 2);
        this.c.a(1.2f, 13.8f, -5.0f);
        this.d = new bcu(this, 40, 0);
        this.d.a(-1.0f, 0.0f, 0.0f, 2, 10, 2);
        this.d.a(-1.2f, 13.8f, -5.0f);
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.a(par2, par3, par4, par5, par6, par7, par1Entity);
        if (this.s) {
            float f6 = 2.0f;
            GL11.glPushMatrix();
            GL11.glScalef((float)(1.5f / f6), (float)(1.5f / f6), (float)(1.5f / f6));
            GL11.glTranslatef((float)0.0f, (float)(10.0f * par7), (float)(4.0f * par7));
            this.g.a(par7);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef((float)(1.0f / f6), (float)(1.0f / f6), (float)(1.0f / f6));
            GL11.glTranslatef((float)0.0f, (float)(24.0f * par7), (float)0.0f);
            this.h.a(par7);
            this.a.a(par7);
            this.b.a(par7);
            this.c.a(par7);
            this.d.a(par7);
            this.e.a(par7);
            this.f.a(par7);
            GL11.glPopMatrix();
        } else {
            this.g.a(par7);
            this.h.a(par7);
            this.e.a(par7);
            this.f.a(par7);
            this.a.a(par7);
            this.b.a(par7);
            this.c.a(par7);
            this.d.a(par7);
        }
    }

    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        this.g.f = par5 / 57.295776f;
        this.g.g = par4 / 57.295776f;
        if (this.i != 3) {
            this.h.f = 1.5707964f;
            if (this.i == 2) {
                this.a.f = ls.b(par1 * 0.6662f) * 1.0f * par2;
                this.b.f = ls.b(par1 * 0.6662f + 0.3f) * 1.0f * par2;
                this.c.f = ls.b(par1 * 0.6662f + (float)Math.PI + 0.3f) * 1.0f * par2;
                this.d.f = ls.b(par1 * 0.6662f + (float)Math.PI) * 1.0f * par2;
                this.f.f = 1.7278761f + 0.31415927f * ls.b(par1) * par2;
            } else {
                this.a.f = ls.b(par1 * 0.6662f) * 1.0f * par2;
                this.b.f = ls.b(par1 * 0.6662f + (float)Math.PI) * 1.0f * par2;
                this.c.f = ls.b(par1 * 0.6662f + (float)Math.PI) * 1.0f * par2;
                this.d.f = ls.b(par1 * 0.6662f) * 1.0f * par2;
                this.f.f = this.i == 1 ? 1.7278761f + 0.7853982f * ls.b(par1) * par2 : 1.7278761f + 0.47123894f * ls.b(par1) * par2;
            }
        }
    }

    public void a(of par1EntityLivingBase, float par2, float par3, float par4) {
        rx entityocelot = (rx)((Object)par1EntityLivingBase);
        this.h.d = 12.0f;
        this.h.e = -10.0f;
        this.g.d = 15.0f;
        this.g.e = -9.0f;
        this.e.d = 15.0f;
        this.e.e = 8.0f;
        this.f.d = 20.0f;
        this.f.e = 14.0f;
        this.d.d = 13.8f;
        this.c.d = 13.8f;
        this.d.e = -5.0f;
        this.c.e = -5.0f;
        this.b.d = 18.0f;
        this.a.d = 18.0f;
        this.b.e = 5.0f;
        this.a.e = 5.0f;
        this.e.f = 0.9f;
        if (entityocelot.ah()) {
            this.h.d += 1.0f;
            this.g.d += 2.0f;
            this.e.d += 1.0f;
            this.f.d += -4.0f;
            this.f.e += 2.0f;
            this.e.f = 1.5707964f;
            this.f.f = 1.5707964f;
            this.i = 0;
        } else if (entityocelot.ai()) {
            this.f.d = this.e.d;
            this.f.e += 2.0f;
            this.e.f = 1.5707964f;
            this.f.f = 1.5707964f;
            this.i = 2;
        } else if (entityocelot.bU()) {
            this.h.f = 0.7853982f;
            this.h.d += -4.0f;
            this.h.e += 5.0f;
            this.g.d += -3.3f;
            this.g.e += 1.0f;
            this.e.d += 8.0f;
            this.e.e += -2.0f;
            this.f.d += 2.0f;
            this.f.e += -0.8f;
            this.e.f = 1.7278761f;
            this.f.f = 2.670354f;
            this.d.f = -0.15707964f;
            this.c.f = -0.15707964f;
            this.d.d = 15.8f;
            this.c.d = 15.8f;
            this.d.e = -7.0f;
            this.c.e = -7.0f;
            this.b.f = -1.5707964f;
            this.a.f = -1.5707964f;
            this.b.d = 21.0f;
            this.a.d = 21.0f;
            this.b.e = 1.0f;
            this.a.e = 1.0f;
            this.i = 3;
        } else {
            this.i = 1;
        }
    }
}

