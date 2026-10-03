/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bgp
extends bgm {
    private float a;

    public bgp(float par1) {
        this.a = par1;
    }

    public void a(uj par1EntityFireball, double par2, double par4, double par6, float par8, float par9) {
        GL11.glPushMatrix();
        this.b(par1EntityFireball);
        GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
        GL11.glEnable((int)32826);
        float f2 = this.a;
        GL11.glScalef((float)(f2 / 1.0f), (float)(f2 / 1.0f), (float)(f2 / 1.0f));
        ms icon = yc.bG.b_(0);
        bfq tessellator = bfq.a;
        float f3 = icon.c();
        float f4 = icon.d();
        float f5 = icon.e();
        float f6 = icon.f();
        float f7 = 1.0f;
        float f8 = 0.5f;
        float f9 = 0.25f;
        GL11.glRotatef((float)(180.0f - this.b.j), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-this.b.k), (float)1.0f, (float)0.0f, (float)0.0f);
        tessellator.b();
        tessellator.b(0.0f, 1.0f, 0.0f);
        tessellator.a(0.0f - f8, 0.0f - f9, 0.0, f3, f6);
        tessellator.a(f7 - f8, 0.0f - f9, 0.0, f4, f6);
        tessellator.a(f7 - f8, 1.0f - f9, 0.0, f4, f5);
        tessellator.a(0.0f - f8, 1.0f - f9, 0.0, f3, f5);
        tessellator.a();
        GL11.glDisable((int)32826);
        GL11.glPopMatrix();
    }

    protected bjo a(uj par1EntityFireball) {
        return bik.c;
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((uj)par1Entity);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((uj)par1Entity, par2, par4, par6, par8, par9);
    }
}

