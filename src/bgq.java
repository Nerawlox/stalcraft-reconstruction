/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  atc
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bgq
extends bgm {
    private static final bjo a = new bjo("textures/particle/particles.png");

    public void a(ul par1EntityFishHook, double par2, double par4, double par6, float par8, float par9) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
        GL11.glEnable((int)32826);
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        this.b(par1EntityFishHook);
        bfq tessellator = bfq.a;
        int b0 = 1;
        int b1 = 2;
        float f2 = (float)(b0 * 8 + 0) / 128.0f;
        float f3 = (float)(b0 * 8 + 8) / 128.0f;
        float f4 = (float)(b1 * 8 + 0) / 128.0f;
        float f5 = (float)(b1 * 8 + 8) / 128.0f;
        float f6 = 1.0f;
        float f7 = 0.5f;
        float f8 = 0.5f;
        GL11.glRotatef((float)(180.0f - this.b.j), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-this.b.k), (float)1.0f, (float)0.0f, (float)0.0f);
        tessellator.b();
        tessellator.b(0.0f, 1.0f, 0.0f);
        tessellator.a(0.0f - f7, 0.0f - f8, 0.0, f2, f5);
        tessellator.a(f6 - f7, 0.0f - f8, 0.0, f3, f5);
        tessellator.a(f6 - f7, 1.0f - f8, 0.0, f3, f4);
        tessellator.a(0.0f - f7, 1.0f - f8, 0.0, f2, f4);
        tessellator.a();
        GL11.glDisable((int)32826);
        GL11.glPopMatrix();
        if (par1EntityFishHook.b != null) {
            double d6;
            float f9 = par1EntityFishHook.b.k(par9);
            float f10 = ls.a(ls.c(f9) * (float)Math.PI);
            atc vec3 = par1EntityFishHook.q.V().a(-0.5, 0.03, 0.8);
            vec3.a(-(par1EntityFishHook.b.D + (par1EntityFishHook.b.B - par1EntityFishHook.b.D) * par9) * (float)Math.PI / 180.0f);
            vec3.b(-(par1EntityFishHook.b.C + (par1EntityFishHook.b.A - par1EntityFishHook.b.C) * par9) * (float)Math.PI / 180.0f);
            vec3.b(f10 * 0.5f);
            vec3.a(-f10 * 0.7f);
            double d3 = par1EntityFishHook.b.r + (par1EntityFishHook.b.u - par1EntityFishHook.b.r) * (double)par9 + vec3.c;
            double d4 = par1EntityFishHook.b.s + (par1EntityFishHook.b.v - par1EntityFishHook.b.s) * (double)par9 + vec3.d;
            double d5 = par1EntityFishHook.b.t + (par1EntityFishHook.b.w - par1EntityFishHook.b.t) * (double)par9 + vec3.e;
            double d2 = d6 = par1EntityFishHook.b == atv.w().h ? 0.0 : (double)par1EntityFishHook.b.f();
            if (this.b.l.aa > 0 || par1EntityFishHook.b != atv.w().h) {
                float f11 = (par1EntityFishHook.b.aO + (par1EntityFishHook.b.aN - par1EntityFishHook.b.aO) * par9) * (float)Math.PI / 180.0f;
                double d7 = ls.a(f11);
                double d8 = ls.b(f11);
                d3 = par1EntityFishHook.b.r + (par1EntityFishHook.b.u - par1EntityFishHook.b.r) * (double)par9 - d8 * 0.35 - d7 * 0.85;
                d4 = par1EntityFishHook.b.s + d6 + (par1EntityFishHook.b.v - par1EntityFishHook.b.s) * (double)par9 - 0.45;
                d5 = par1EntityFishHook.b.t + (par1EntityFishHook.b.w - par1EntityFishHook.b.t) * (double)par9 - d7 * 0.35 + d8 * 0.85;
            }
            double d9 = par1EntityFishHook.r + (par1EntityFishHook.u - par1EntityFishHook.r) * (double)par9;
            double d10 = par1EntityFishHook.s + (par1EntityFishHook.v - par1EntityFishHook.s) * (double)par9 + 0.25;
            double d11 = par1EntityFishHook.t + (par1EntityFishHook.w - par1EntityFishHook.t) * (double)par9;
            double d12 = (float)(d3 - d9);
            double d13 = (float)(d4 - d10);
            double d14 = (float)(d5 - d11);
            GL11.glDisable((int)3553);
            GL11.glDisable((int)2896);
            tessellator.b(3);
            tessellator.d(0);
            int b2 = 16;
            for (int i2 = 0; i2 <= b2; ++i2) {
                float f12 = (float)i2 / (float)b2;
                tessellator.a(par2 + d12 * (double)f12, par4 + d13 * (double)(f12 * f12 + f12) * 0.5 + 0.25, par6 + d14 * (double)f12);
            }
            tessellator.a();
            GL11.glEnable((int)2896);
            GL11.glEnable((int)3553);
        }
    }

    protected bjo a(ul par1EntityFishHook) {
        return a;
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((ul)par1Entity);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((ul)par1Entity, par2, par4, par6, par8, par9);
    }
}

