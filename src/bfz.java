/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bfz
extends bgm {
    private static final bjo a = new bjo("textures/entity/arrow.png");

    public void a(uh par1EntityArrow, double par2, double par4, double par6, float par8, float par9) {
        this.b(par1EntityArrow);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
        GL11.glRotatef((float)(par1EntityArrow.C + (par1EntityArrow.A - par1EntityArrow.C) * par9 - 90.0f), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(par1EntityArrow.D + (par1EntityArrow.B - par1EntityArrow.D) * par9), (float)0.0f, (float)0.0f, (float)1.0f);
        bfq tessellator = bfq.a;
        int b0 = 0;
        float f2 = 0.0f;
        float f3 = 0.5f;
        float f4 = (float)(0 + b0 * 10) / 32.0f;
        float f5 = (float)(5 + b0 * 10) / 32.0f;
        float f6 = 0.0f;
        float f7 = 0.15625f;
        float f8 = (float)(5 + b0 * 10) / 32.0f;
        float f9 = (float)(10 + b0 * 10) / 32.0f;
        float f10 = 0.05625f;
        GL11.glEnable((int)32826);
        float f11 = (float)par1EntityArrow.b - par9;
        if (f11 > 0.0f) {
            float f12 = -ls.a(f11 * 3.0f) * f11;
            GL11.glRotatef((float)f12, (float)0.0f, (float)0.0f, (float)1.0f);
        }
        GL11.glRotatef((float)45.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glScalef((float)f10, (float)f10, (float)f10);
        GL11.glTranslatef((float)-4.0f, (float)0.0f, (float)0.0f);
        GL11.glNormal3f((float)f10, (float)0.0f, (float)0.0f);
        tessellator.b();
        tessellator.a(-7.0, -2.0, -2.0, f6, f8);
        tessellator.a(-7.0, -2.0, 2.0, f7, f8);
        tessellator.a(-7.0, 2.0, 2.0, f7, f9);
        tessellator.a(-7.0, 2.0, -2.0, f6, f9);
        tessellator.a();
        GL11.glNormal3f((float)(-f10), (float)0.0f, (float)0.0f);
        tessellator.b();
        tessellator.a(-7.0, 2.0, -2.0, f6, f8);
        tessellator.a(-7.0, 2.0, 2.0, f7, f8);
        tessellator.a(-7.0, -2.0, 2.0, f7, f9);
        tessellator.a(-7.0, -2.0, -2.0, f6, f9);
        tessellator.a();
        for (int i2 = 0; i2 < 4; ++i2) {
            GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glNormal3f((float)0.0f, (float)0.0f, (float)f10);
            tessellator.b();
            tessellator.a(-8.0, -2.0, 0.0, f2, f4);
            tessellator.a(8.0, -2.0, 0.0, f3, f4);
            tessellator.a(8.0, 2.0, 0.0, f3, f5);
            tessellator.a(-8.0, 2.0, 0.0, f2, f5);
            tessellator.a();
        }
        GL11.glDisable((int)32826);
        GL11.glPopMatrix();
    }

    protected bjo a(uh par1EntityArrow) {
        return a;
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((uh)par1Entity);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((uh)par1Entity, par2, par4, par6, par8, par9);
    }
}

