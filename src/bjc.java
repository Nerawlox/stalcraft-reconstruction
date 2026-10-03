/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aso
 *  atu
 *  bje
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.nio.FloatBuffer;
import java.util.Random;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bjc
extends bje {
    private static final bjo c = new bjo("textures/environment/end_sky.png");
    private static final bjo d = new bjo("textures/entity/end_portal.png");
    private static final Random e = new Random(31100L);
    FloatBuffer a = atu.h((int)16);

    public void a(aso par1TileEntityEndPortal, double par2, double par4, double par6, float par8) {
        float f1 = (float)this.b.j;
        float f2 = (float)this.b.k;
        float f3 = (float)this.b.l;
        GL11.glDisable((int)2896);
        e.setSeed(31100L);
        float f4 = 0.75f;
        for (int i2 = 0; i2 < 16; ++i2) {
            GL11.glPushMatrix();
            float f5 = 16 - i2;
            float f6 = 0.0625f;
            float f7 = 1.0f / (f5 + 1.0f);
            if (i2 == 0) {
                this.a(c);
                f7 = 0.1f;
                f5 = 65.0f;
                f6 = 0.125f;
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
            }
            if (i2 == 1) {
                this.a(d);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)1, (int)1);
                f6 = 0.5f;
            }
            float f8 = (float)(-(par4 + (double)f4));
            float f9 = f8 + atp.b;
            float f10 = f8 + f5 + atp.b;
            float f11 = f9 / f10;
            GL11.glTranslatef((float)f1, (float)(f11 += (float)(par4 + (double)f4)), (float)f3);
            GL11.glTexGeni((int)8192, (int)9472, (int)9217);
            GL11.glTexGeni((int)8193, (int)9472, (int)9217);
            GL11.glTexGeni((int)8194, (int)9472, (int)9217);
            GL11.glTexGeni((int)8195, (int)9472, (int)9216);
            GL11.glTexGen((int)8192, (int)9473, (FloatBuffer)this.a(1.0f, 0.0f, 0.0f, 0.0f));
            GL11.glTexGen((int)8193, (int)9473, (FloatBuffer)this.a(0.0f, 0.0f, 1.0f, 0.0f));
            GL11.glTexGen((int)8194, (int)9473, (FloatBuffer)this.a(0.0f, 0.0f, 0.0f, 1.0f));
            GL11.glTexGen((int)8195, (int)9474, (FloatBuffer)this.a(0.0f, 1.0f, 0.0f, 0.0f));
            GL11.glEnable((int)3168);
            GL11.glEnable((int)3169);
            GL11.glEnable((int)3170);
            GL11.glEnable((int)3171);
            GL11.glPopMatrix();
            GL11.glMatrixMode((int)5890);
            GL11.glPushMatrix();
            GL11.glLoadIdentity();
            GL11.glTranslatef((float)0.0f, (float)((float)(atv.F() % 700000L) / 700000.0f), (float)0.0f);
            GL11.glScalef((float)f6, (float)f6, (float)f6);
            GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.0f);
            GL11.glRotatef((float)((float)(i2 * i2 * 4321 + i2 * 9) * 2.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)0.0f);
            GL11.glTranslatef((float)(-f1), (float)(-f3), (float)(-f2));
            f9 = f8 + atp.b;
            GL11.glTranslatef((float)(atp.a * f5 / f9), (float)(atp.c * f5 / f9), (float)(-f2));
            bfq tessellator = bfq.a;
            tessellator.b();
            f11 = e.nextFloat() * 0.5f + 0.1f;
            float f12 = e.nextFloat() * 0.5f + 0.4f;
            float f13 = e.nextFloat() * 0.5f + 0.5f;
            if (i2 == 0) {
                f13 = 1.0f;
                f12 = 1.0f;
                f11 = 1.0f;
            }
            tessellator.a(f11 * f7, f12 * f7, f13 * f7, 1.0f);
            tessellator.a(par2, par4 + (double)f4, par6);
            tessellator.a(par2, par4 + (double)f4, par6 + 1.0);
            tessellator.a(par2 + 1.0, par4 + (double)f4, par6 + 1.0);
            tessellator.a(par2 + 1.0, par4 + (double)f4, par6);
            tessellator.a();
            GL11.glPopMatrix();
            GL11.glMatrixMode((int)5888);
        }
        GL11.glDisable((int)3042);
        GL11.glDisable((int)3168);
        GL11.glDisable((int)3169);
        GL11.glDisable((int)3170);
        GL11.glDisable((int)3171);
        GL11.glEnable((int)2896);
    }

    private FloatBuffer a(float par1, float par2, float par3, float par4) {
        this.a.clear();
        this.a.put(par1).put(par2).put(par3).put(par4);
        this.a.flip();
        return this.a;
    }

    public void a(asp par1TileEntity, double par2, double par4, double par6, float par8) {
        this.a((aso)par1TileEntity, par2, par4, par6, par8);
    }
}

