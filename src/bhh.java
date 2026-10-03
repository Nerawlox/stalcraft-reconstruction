/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  bma
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ol
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bhh
extends bgm {
    private static final bjo a = new bjo("textures/painting/paintings_kristoffer_zetterstrand.png");

    public void a(ol par1EntityPainting, double par2, double par4, double par6, float par8, float par9) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
        GL11.glRotatef((float)par8, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glEnable((int)32826);
        this.b((nn)par1EntityPainting);
        om enumart = par1EntityPainting.e;
        float f2 = 0.0625f;
        GL11.glScalef((float)f2, (float)f2, (float)f2);
        this.a(par1EntityPainting, enumart.C, enumart.D, enumart.E, enumart.F);
        GL11.glDisable((int)32826);
        GL11.glPopMatrix();
    }

    protected bjo a(ol par1EntityPainting) {
        return a;
    }

    private void a(ol par1EntityPainting, int par2, int par3, int par4, int par5) {
        float f2 = (float)(-par2) / 2.0f;
        float f1 = (float)(-par3) / 2.0f;
        float f22 = 0.5f;
        float f3 = 0.75f;
        float f4 = 0.8125f;
        float f5 = 0.0f;
        float f6 = 0.0625f;
        float f7 = 0.75f;
        float f8 = 0.8125f;
        float f9 = 0.001953125f;
        float f10 = 0.001953125f;
        float f11 = 0.7519531f;
        float f12 = 0.7519531f;
        float f13 = 0.0f;
        float f14 = 0.0625f;
        for (int i1 = 0; i1 < par2 / 16; ++i1) {
            for (int j1 = 0; j1 < par3 / 16; ++j1) {
                float f15 = f2 + (float)((i1 + 1) * 16);
                float f16 = f2 + (float)(i1 * 16);
                float f17 = f1 + (float)((j1 + 1) * 16);
                float f18 = f1 + (float)(j1 * 16);
                this.a(par1EntityPainting, (f15 + f16) / 2.0f, (f17 + f18) / 2.0f);
                float f19 = (float)(par4 + par2 - i1 * 16) / 256.0f;
                float f20 = (float)(par4 + par2 - (i1 + 1) * 16) / 256.0f;
                float f21 = (float)(par5 + par3 - j1 * 16) / 256.0f;
                float f222 = (float)(par5 + par3 - (j1 + 1) * 16) / 256.0f;
                bfq tessellator = bfq.a;
                tessellator.b();
                tessellator.b(0.0f, 0.0f, -1.0f);
                tessellator.a(f15, f18, -f22, f20, f21);
                tessellator.a(f16, f18, -f22, f19, f21);
                tessellator.a(f16, f17, -f22, f19, f222);
                tessellator.a(f15, f17, -f22, f20, f222);
                tessellator.b(0.0f, 0.0f, 1.0f);
                tessellator.a(f15, f17, f22, f3, f5);
                tessellator.a(f16, f17, f22, f4, f5);
                tessellator.a(f16, f18, f22, f4, f6);
                tessellator.a(f15, f18, f22, f3, f6);
                tessellator.b(0.0f, 1.0f, 0.0f);
                tessellator.a(f15, f17, -f22, f7, f9);
                tessellator.a(f16, f17, -f22, f8, f9);
                tessellator.a(f16, f17, f22, f8, f10);
                tessellator.a(f15, f17, f22, f7, f10);
                tessellator.b(0.0f, -1.0f, 0.0f);
                tessellator.a(f15, f18, f22, f7, f9);
                tessellator.a(f16, f18, f22, f8, f9);
                tessellator.a(f16, f18, -f22, f8, f10);
                tessellator.a(f15, f18, -f22, f7, f10);
                tessellator.b(-1.0f, 0.0f, 0.0f);
                tessellator.a(f15, f17, f22, f12, f13);
                tessellator.a(f15, f18, f22, f12, f14);
                tessellator.a(f15, f18, -f22, f11, f14);
                tessellator.a(f15, f17, -f22, f11, f13);
                tessellator.b(1.0f, 0.0f, 0.0f);
                tessellator.a(f16, f17, -f22, f12, f13);
                tessellator.a(f16, f18, -f22, f12, f14);
                tessellator.a(f16, f18, f22, f11, f14);
                tessellator.a(f16, f17, f22, f11, f13);
                tessellator.a();
            }
        }
    }

    private void a(ol par1EntityPainting, float par2, float par3) {
        int i2 = ls.c(par1EntityPainting.u);
        int j2 = ls.c(par1EntityPainting.v + (double)(par3 / 16.0f));
        int k = ls.c(par1EntityPainting.w);
        if (par1EntityPainting.a == 2) {
            i2 = ls.c(par1EntityPainting.u + (double)(par2 / 16.0f));
        }
        if (par1EntityPainting.a == 1) {
            k = ls.c(par1EntityPainting.w - (double)(par2 / 16.0f));
        }
        if (par1EntityPainting.a == 0) {
            i2 = ls.c(par1EntityPainting.u - (double)(par2 / 16.0f));
        }
        if (par1EntityPainting.a == 3) {
            k = ls.c(par1EntityPainting.w + (double)(par2 / 16.0f));
        }
        int l2 = this.b.g.h(i2, j2, k, 0);
        int i1 = l2 % 65536;
        int j1 = l2 / 65536;
        bma.a((int)bma.b, (float)i1, (float)j1);
        GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((ol)par1Entity);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((ol)par1Entity, par2, par4, par6, par8, par9);
    }
}

