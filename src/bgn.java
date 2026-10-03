/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  bma
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  oa
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bgn
extends bgm {
    private static final bjo a = new bjo("textures/entity/experience_orb.png");

    public bgn() {
        this.d = 0.15f;
        this.e = 0.75f;
    }

    public void a(oa par1EntityXPOrb, double par2, double par4, double par6, float par8, float par9) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
        this.b((nn)par1EntityXPOrb);
        int i2 = par1EntityXPOrb.d();
        float f2 = (float)(i2 % 4 * 16 + 0) / 64.0f;
        float f3 = (float)(i2 % 4 * 16 + 16) / 64.0f;
        float f4 = (float)(i2 / 4 * 16 + 0) / 64.0f;
        float f5 = (float)(i2 / 4 * 16 + 16) / 64.0f;
        float f6 = 1.0f;
        float f7 = 0.5f;
        float f8 = 0.25f;
        int j2 = par1EntityXPOrb.c(par9);
        int k = j2 % 65536;
        int l2 = j2 / 65536;
        bma.a((int)bma.b, (float)((float)k / 1.0f), (float)((float)l2 / 1.0f));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        float f9 = 255.0f;
        float f10 = ((float)par1EntityXPOrb.a + par9) / 2.0f;
        l2 = (int)((ls.a(f10 + 0.0f) + 1.0f) * 0.5f * f9);
        int i1 = (int)f9;
        int j1 = (int)((ls.a(f10 + 4.1887903f) + 1.0f) * 0.1f * f9);
        int k1 = l2 << 16 | i1 << 8 | j1;
        GL11.glRotatef((float)(180.0f - this.b.j), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-this.b.k), (float)1.0f, (float)0.0f, (float)0.0f);
        float f11 = 0.3f;
        GL11.glScalef((float)f11, (float)f11, (float)f11);
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.a(k1, 128);
        tessellator.b(0.0f, 1.0f, 0.0f);
        tessellator.a(0.0f - f7, 0.0f - f8, 0.0, f2, f5);
        tessellator.a(f6 - f7, 0.0f - f8, 0.0, f3, f5);
        tessellator.a(f6 - f7, 1.0f - f8, 0.0, f3, f4);
        tessellator.a(0.0f - f7, 1.0f - f8, 0.0, f2, f4);
        tessellator.a();
        GL11.glDisable((int)3042);
        GL11.glDisable((int)32826);
        GL11.glPopMatrix();
    }

    protected bjo a(oa par1EntityXPOrb) {
        return a;
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((oa)par1Entity);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((oa)par1Entity, par2, par4, par6, par8, par9);
    }
}

