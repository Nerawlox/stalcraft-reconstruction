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
public class bbt
extends bbo {
    public bcu a = new bcu(this, 0, 0);
    public bcu b;
    public bcu c;
    public bcu d;
    public bcu e;
    public bcu f;
    protected float g = 8.0f;
    protected float h = 4.0f;

    public bbt(int par1, float par2) {
        this.a.a(-4.0f, -4.0f, -8.0f, 8, 8, 8, par2);
        this.a.a(0.0f, 18 - par1, -6.0f);
        this.b = new bcu(this, 28, 8);
        this.b.a(-5.0f, -10.0f, -7.0f, 10, 16, 8, par2);
        this.b.a(0.0f, 17 - par1, 2.0f);
        this.c = new bcu(this, 0, 16);
        this.c.a(-2.0f, 0.0f, -2.0f, 4, par1, 4, par2);
        this.c.a(-3.0f, 24 - par1, 7.0f);
        this.d = new bcu(this, 0, 16);
        this.d.a(-2.0f, 0.0f, -2.0f, 4, par1, 4, par2);
        this.d.a(3.0f, 24 - par1, 7.0f);
        this.e = new bcu(this, 0, 16);
        this.e.a(-2.0f, 0.0f, -2.0f, 4, par1, 4, par2);
        this.e.a(-3.0f, 24 - par1, -5.0f);
        this.f = new bcu(this, 0, 16);
        this.f.a(-2.0f, 0.0f, -2.0f, 4, par1, 4, par2);
        this.f.a(3.0f, 24 - par1, -5.0f);
    }

    public void a(nn par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.a(par2, par3, par4, par5, par6, par7, par1Entity);
        if (this.s) {
            float f6 = 2.0f;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)0.0f, (float)(this.g * par7), (float)(this.h * par7));
            this.a.a(par7);
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
            this.b.a(par7);
            this.c.a(par7);
            this.d.a(par7);
            this.e.a(par7);
            this.f.a(par7);
        }
    }

    public void a(float par1, float par2, float par3, float par4, float par5, float par6, nn par7Entity) {
        float f6 = 57.295776f;
        this.a.f = par5 / 57.295776f;
        this.a.g = par4 / 57.295776f;
        this.b.f = 1.5707964f;
        this.c.f = ls.b(par1 * 0.6662f) * 1.4f * par2;
        this.d.f = ls.b(par1 * 0.6662f + (float)Math.PI) * 1.4f * par2;
        this.e.f = ls.b(par1 * 0.6662f + (float)Math.PI) * 1.4f * par2;
        this.f.f = ls.b(par1 * 0.6662f) * 1.4f * par2;
    }
}

