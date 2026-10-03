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
public class bcl
extends bbo {
    public bcu a;
    public bcu b;
    public bcu c;
    public bcu d;
    public bcu e;
    public bcu f;
    bcu g;
    bcu h;

    public bcl() {
        float f2 = 0.0f;
        float f1 = 13.5f;
        this.a = new bcu(this, 0, 0);
        this.a.a(-3.0f, -3.0f, -2.0f, 6, 6, 4, f2);
        this.a.a(-1.0f, f1, -7.0f);
        this.b = new bcu(this, 18, 14);
        this.b.a(-4.0f, -2.0f, -3.0f, 6, 9, 6, f2);
        this.b.a(0.0f, 14.0f, 2.0f);
        this.h = new bcu(this, 21, 0);
        this.h.a(-4.0f, -3.0f, -3.0f, 8, 6, 7, f2);
        this.h.a(-1.0f, 14.0f, 2.0f);
        this.c = new bcu(this, 0, 18);
        this.c.a(-1.0f, 0.0f, -1.0f, 2, 8, 2, f2);
        this.c.a(-2.5f, 16.0f, 7.0f);
        this.d = new bcu(this, 0, 18);
        this.d.a(-1.0f, 0.0f, -1.0f, 2, 8, 2, f2);
        this.d.a(0.5f, 16.0f, 7.0f);
        this.e = new bcu(this, 0, 18);
        this.e.a(-1.0f, 0.0f, -1.0f, 2, 8, 2, f2);
        this.e.a(-2.5f, 16.0f, -4.0f);
        this.f = new bcu(this, 0, 18);
        this.f.a(-1.0f, 0.0f, -1.0f, 2, 8, 2, f2);
        this.f.a(0.5f, 16.0f, -4.0f);
        this.g = new bcu(this, 9, 18);
        this.g.a(-1.0f, 0.0f, -1.0f, 2, 8, 2, f2);
        this.g.a(-1.0f, 12.0f, 8.0f);
        this.a.a(16, 14).a(-3.0f, -5.0f, 0.0f, 2, 2, 1, f2);
        this.a.a(16, 14).a(1.0f, -5.0f, 0.0f, 2, 2, 1, f2);
        this.a.a(0, 10).a(-1.5f, 0.0f, -5.0f, 3, 3, 4, f2);
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        super.a(par1Entity, par2, par3, par4, par5, par6, par7);
        this.a(par2, par3, par4, par5, par6, par7, par1Entity);
        if (this.s) {
            float f6 = 2.0f;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)0.0f, (float)(5.0f * par7), (float)(2.0f * par7));
            this.a.b(par7);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef((float)(1.0f / f6), (float)(1.0f / f6), (float)(1.0f / f6));
            GL11.glTranslatef((float)0.0f, (float)(24.0f * par7), (float)0.0f);
            this.b.a(par7);
            this.c.a(par7);
            this.d.a(par7);
            this.e.a(par7);
            this.f.a(par7);
            this.g.b(par7);
            this.h.a(par7);
            GL11.glPopMatrix();
        } else {
            this.a.b(par7);
            this.b.a(par7);
            this.c.a(par7);
            this.d.a(par7);
            this.e.a(par7);
            this.f.a(par7);
            this.g.b(par7);
            this.h.a(par7);
        }
    }

    public void a(of par1EntityLivingBase, float par2, float par3, float par4) {
        sf entitywolf = (sf)((Object)par1EntityLivingBase);
        this.g.g = entitywolf.cc() ? 0.0f : ls.b(par2 * 0.6662f) * 1.4f * par3;
        if (entitywolf.bU()) {
            this.h.a(-1.0f, 16.0f, -3.0f);
            this.h.f = 1.2566371f;
            this.h.g = 0.0f;
            this.b.a(0.0f, 18.0f, 0.0f);
            this.b.f = 0.7853982f;
            this.g.a(-1.0f, 21.0f, 6.0f);
            this.c.a(-2.5f, 22.0f, 2.0f);
            this.c.f = 4.712389f;
            this.d.a(0.5f, 22.0f, 2.0f);
            this.d.f = 4.712389f;
            this.e.f = 5.811947f;
            this.e.a(-2.49f, 17.0f, -4.0f);
            this.f.f = 5.811947f;
            this.f.a(0.51f, 17.0f, -4.0f);
        } else {
            this.b.a(0.0f, 14.0f, 2.0f);
            this.b.f = 1.5707964f;
            this.h.a(-1.0f, 14.0f, -3.0f);
            this.h.f = this.b.f;
            this.g.a(-1.0f, 12.0f, 8.0f);
            this.c.a(-2.5f, 16.0f, 7.0f);
            this.d.a(0.5f, 16.0f, 7.0f);
            this.e.a(-2.5f, 16.0f, -4.0f);
            this.f.a(0.5f, 16.0f, -4.0f);
            this.c.f = ls.b(par2 * 0.6662f) * 1.4f * par3;
            this.d.f = ls.b(par2 * 0.6662f + (float)Math.PI) * 1.4f * par3;
            this.e.f = ls.b(par2 * 0.6662f + (float)Math.PI) * 1.4f * par3;
            this.f.f = ls.b(par2 * 0.6662f) * 1.4f * par3;
        }
        this.a.h = entitywolf.q(par4) + entitywolf.g(par4, 0.0f);
        this.h.h = entitywolf.g(par4, -0.08f);
        this.b.h = entitywolf.g(par4, -0.16f);
        this.g.h = entitywolf.g(par4, -0.2f);
    }

    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        super.a(par1, par2, par3, par4, par5, par6, par7Entity);
        this.a.f = par5 / 57.295776f;
        this.a.g = par4 / 57.295776f;
        this.g.f = par3;
    }
}

