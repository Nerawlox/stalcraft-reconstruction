/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bbo
 *  bcp
 *  bjo
 *  bma
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraftforge.client.event.RenderLivingEvent$Post
 *  net.minecraftforge.client.event.RenderLivingEvent$Pre
 *  net.minecraftforge.client.event.RenderLivingEvent$Specials$Post
 *  net.minecraftforge.client.event.RenderLivingEvent$Specials$Pre
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public abstract class bhb
extends bgm {
    private static final bjo a = new bjo("textures/misc/enchanted_item_glint.png");
    protected bbo i;
    protected bbo j;
    public static float NAME_TAG_RANGE = 64.0f;
    public static float NAME_TAG_RANGE_SNEAK = 32.0f;

    public bhb(bbo par1ModelBase, float par2) {
        this.i = par1ModelBase;
        this.d = par2;
    }

    public void a(bbo par1ModelBase) {
        this.j = par1ModelBase;
    }

    private float a(float par1, float par2, float par3) {
        float f3;
        for (f3 = par2 - par1; f3 < -180.0f; f3 += 360.0f) {
        }
        while (f3 >= 180.0f) {
            f3 -= 360.0f;
        }
        return par1 + par3 * f3;
    }

    public void a(of par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
        if (MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Pre(par1EntityLivingBase, this))) {
            return;
        }
        GL11.glPushMatrix();
        GL11.glDisable((int)2884);
        this.i.p = this.d(par1EntityLivingBase, par9);
        if (this.j != null) {
            this.j.p = this.i.p;
        }
        this.i.q = par1EntityLivingBase.ag();
        if (this.j != null) {
            this.j.q = this.i.q;
        }
        this.i.s = par1EntityLivingBase.g_();
        if (this.j != null) {
            this.j.s = this.i.s;
        }
        try {
            float f11;
            float f10;
            float f9;
            int i2;
            float f4;
            float f2 = this.a(par1EntityLivingBase.aO, par1EntityLivingBase.aN, par9);
            float f3 = this.a(par1EntityLivingBase.aQ, par1EntityLivingBase.aP, par9);
            if (par1EntityLivingBase.ag() && par1EntityLivingBase.o instanceof of) {
                of entitylivingbase1 = (of)par1EntityLivingBase.o;
                f2 = this.a(entitylivingbase1.aO, entitylivingbase1.aN, par9);
                f4 = ls.g(f3 - f2);
                if (f4 < -85.0f) {
                    f4 = -85.0f;
                }
                if (f4 >= 85.0f) {
                    f4 = 85.0f;
                }
                f2 = f3 - f4;
                if (f4 * f4 > 2500.0f) {
                    f2 += f4 * 0.2f;
                }
            }
            float f5 = par1EntityLivingBase.D + (par1EntityLivingBase.B - par1EntityLivingBase.D) * par9;
            this.a(par1EntityLivingBase, par2, par4, par6);
            f4 = this.b(par1EntityLivingBase, par9);
            this.a(par1EntityLivingBase, f4, f2, par9);
            float f6 = 0.0625f;
            GL11.glEnable((int)32826);
            GL11.glScalef((float)-1.0f, (float)-1.0f, (float)1.0f);
            this.a(par1EntityLivingBase, par9);
            GL11.glTranslatef((float)0.0f, (float)(-24.0f * f6 - 0.0078125f), (float)0.0f);
            float f7 = par1EntityLivingBase.aF + (par1EntityLivingBase.aG - par1EntityLivingBase.aF) * par9;
            float f8 = par1EntityLivingBase.aH - par1EntityLivingBase.aG * (1.0f - par9);
            if (par1EntityLivingBase.g_()) {
                f8 *= 3.0f;
            }
            if (f7 > 1.0f) {
                f7 = 1.0f;
            }
            GL11.glEnable((int)3008);
            this.i.a(par1EntityLivingBase, f8, f7, par9);
            this.a(par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
            for (int j2 = 0; j2 < 4; ++j2) {
                i2 = this.a(par1EntityLivingBase, j2, par9);
                if (i2 <= 0) continue;
                this.j.a(par1EntityLivingBase, f8, f7, par9);
                this.j.a((nn)par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
                if ((i2 & 0xF0) == 16) {
                    this.c(par1EntityLivingBase, j2, par9);
                    this.j.a((nn)par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
                }
                if ((i2 & 0xF) == 15) {
                    f9 = (float)par1EntityLivingBase.ac + par9;
                    this.a(a);
                    GL11.glEnable((int)3042);
                    f10 = 0.5f;
                    GL11.glColor4f((float)f10, (float)f10, (float)f10, (float)1.0f);
                    GL11.glDepthFunc((int)514);
                    GL11.glDepthMask((boolean)false);
                    for (int k = 0; k < 2; ++k) {
                        GL11.glDisable((int)2896);
                        f11 = 0.76f;
                        GL11.glColor4f((float)(0.5f * f11), (float)(0.25f * f11), (float)(0.8f * f11), (float)1.0f);
                        GL11.glBlendFunc((int)768, (int)1);
                        GL11.glMatrixMode((int)5890);
                        GL11.glLoadIdentity();
                        float f12 = f9 * (0.001f + (float)k * 0.003f) * 20.0f;
                        float f13 = 0.33333334f;
                        GL11.glScalef((float)f13, (float)f13, (float)f13);
                        GL11.glRotatef((float)(30.0f - (float)k * 60.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                        GL11.glTranslatef((float)0.0f, (float)f12, (float)0.0f);
                        GL11.glMatrixMode((int)5888);
                        this.j.a((nn)par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
                    }
                    GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                    GL11.glMatrixMode((int)5890);
                    GL11.glDepthMask((boolean)true);
                    GL11.glLoadIdentity();
                    GL11.glMatrixMode((int)5888);
                    GL11.glEnable((int)2896);
                    GL11.glDisable((int)3042);
                    GL11.glDepthFunc((int)515);
                }
                GL11.glDisable((int)3042);
                GL11.glEnable((int)3008);
            }
            GL11.glDepthMask((boolean)true);
            this.c(par1EntityLivingBase, par9);
            float f14 = par1EntityLivingBase.d(par9);
            i2 = this.a(par1EntityLivingBase, f14, par9);
            bma.a((int)bma.b);
            GL11.glDisable((int)3553);
            bma.a((int)bma.a);
            if ((i2 >> 24 & 0xFF) > 0 || par1EntityLivingBase.ay > 0 || par1EntityLivingBase.aB > 0) {
                GL11.glDisable((int)3553);
                GL11.glDisable((int)3008);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
                GL11.glDepthFunc((int)514);
                if (par1EntityLivingBase.ay > 0 || par1EntityLivingBase.aB > 0) {
                    GL11.glColor4f((float)f14, (float)0.0f, (float)0.0f, (float)0.4f);
                    this.i.a((nn)par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
                    for (int l2 = 0; l2 < 4; ++l2) {
                        if (this.b(par1EntityLivingBase, l2, par9) < 0) continue;
                        GL11.glColor4f((float)f14, (float)0.0f, (float)0.0f, (float)0.4f);
                        this.j.a((nn)par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
                    }
                }
                if ((i2 >> 24 & 0xFF) > 0) {
                    f9 = (float)(i2 >> 16 & 0xFF) / 255.0f;
                    f10 = (float)(i2 >> 8 & 0xFF) / 255.0f;
                    float f15 = (float)(i2 & 0xFF) / 255.0f;
                    f11 = (float)(i2 >> 24 & 0xFF) / 255.0f;
                    GL11.glColor4f((float)f9, (float)f10, (float)f15, (float)f11);
                    this.i.a((nn)par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
                    for (int i1 = 0; i1 < 4; ++i1) {
                        if (this.b(par1EntityLivingBase, i1, par9) < 0) continue;
                        GL11.glColor4f((float)f9, (float)f10, (float)f15, (float)f11);
                        this.j.a((nn)par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
                    }
                }
                GL11.glDepthFunc((int)515);
                GL11.glDisable((int)3042);
                GL11.glEnable((int)3008);
                GL11.glEnable((int)3553);
            }
            GL11.glDisable((int)32826);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        bma.a((int)bma.b);
        GL11.glEnable((int)3553);
        bma.a((int)bma.a);
        GL11.glEnable((int)2884);
        GL11.glPopMatrix();
        this.b(par1EntityLivingBase, par2, par4, par6);
        MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Post(par1EntityLivingBase, this));
    }

    protected void a(of par1EntityLivingBase, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.b((nn)par1EntityLivingBase);
        if (!par1EntityLivingBase.aj()) {
            this.i.a((nn)par1EntityLivingBase, par2, par3, par4, par5, par6, par7);
        } else if (!par1EntityLivingBase.d((uf)atv.w().h)) {
            GL11.glPushMatrix();
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)0.15f);
            GL11.glDepthMask((boolean)false);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glAlphaFunc((int)516, (float)0.003921569f);
            this.i.a((nn)par1EntityLivingBase, par2, par3, par4, par5, par6, par7);
            GL11.glDisable((int)3042);
            GL11.glAlphaFunc((int)516, (float)0.1f);
            GL11.glPopMatrix();
            GL11.glDepthMask((boolean)true);
        } else {
            this.i.a(par2, par3, par4, par5, par6, par7, (nn)par1EntityLivingBase);
        }
    }

    protected void a(of par1EntityLivingBase, double par2, double par4, double par6) {
        GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
    }

    protected void a(of par1EntityLivingBase, float par2, float par3, float par4) {
        GL11.glRotatef((float)(180.0f - par3), (float)0.0f, (float)1.0f, (float)0.0f);
        if (par1EntityLivingBase.aB > 0) {
            float f3 = ((float)par1EntityLivingBase.aB + par4 - 1.0f) / 20.0f * 1.6f;
            if ((f3 = ls.c(f3)) > 1.0f) {
                f3 = 1.0f;
            }
            GL11.glRotatef((float)(f3 * this.a(par1EntityLivingBase)), (float)0.0f, (float)0.0f, (float)1.0f);
        } else {
            String s2 = a.a(par1EntityLivingBase.an());
            if (!(!s2.equals("Dinnerbone") && !s2.equals("Grumm") || par1EntityLivingBase instanceof uf && ((uf)par1EntityLivingBase).bL())) {
                GL11.glTranslatef((float)0.0f, (float)(par1EntityLivingBase.P + 0.1f), (float)0.0f);
                GL11.glRotatef((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            }
        }
    }

    protected float d(of par1EntityLivingBase, float par2) {
        return par1EntityLivingBase.k(par2);
    }

    protected float b(of par1EntityLivingBase, float par2) {
        return (float)par1EntityLivingBase.ac + par2;
    }

    protected void c(of par1EntityLivingBase, float par2) {
    }

    protected void e(of par1EntityLivingBase, float par2) {
        int i2 = par1EntityLivingBase.aU();
        if (i2 > 0) {
            uh entityarrow = new uh(par1EntityLivingBase.q, par1EntityLivingBase.u, par1EntityLivingBase.v, par1EntityLivingBase.w);
            Random random = new Random(par1EntityLivingBase.k);
            att.a();
            for (int j2 = 0; j2 < i2; ++j2) {
                GL11.glPushMatrix();
                bcu modelrenderer = this.i.a(random);
                bcp modelbox = (bcp)modelrenderer.l.get(random.nextInt(modelrenderer.l.size()));
                modelrenderer.c(0.0625f);
                float f1 = random.nextFloat();
                float f2 = random.nextFloat();
                float f3 = random.nextFloat();
                float f4 = (modelbox.a + (modelbox.d - modelbox.a) * f1) / 16.0f;
                float f5 = (modelbox.b + (modelbox.e - modelbox.b) * f2) / 16.0f;
                float f6 = (modelbox.c + (modelbox.f - modelbox.c) * f3) / 16.0f;
                GL11.glTranslatef((float)f4, (float)f5, (float)f6);
                f1 = f1 * 2.0f - 1.0f;
                f2 = f2 * 2.0f - 1.0f;
                f3 = f3 * 2.0f - 1.0f;
                float f7 = ls.c((f1 *= -1.0f) * f1 + (f3 *= -1.0f) * f3);
                entityarrow.C = entityarrow.A = (float)(Math.atan2(f1, f3) * 180.0 / Math.PI);
                entityarrow.D = entityarrow.B = (float)(Math.atan2(f2 *= -1.0f, f7) * 180.0 / Math.PI);
                double d0 = 0.0;
                double d1 = 0.0;
                double d2 = 0.0;
                float f8 = 0.0f;
                this.b.a(entityarrow, d0, d1, d2, f8, par2);
                GL11.glPopMatrix();
            }
            att.b();
        }
    }

    protected int b(of par1EntityLivingBase, int par2, float par3) {
        return this.a(par1EntityLivingBase, par2, par3);
    }

    protected int a(of par1EntityLivingBase, int par2, float par3) {
        return -1;
    }

    protected void c(of par1EntityLivingBase, int par2, float par3) {
    }

    protected float a(of par1EntityLivingBase) {
        return 90.0f;
    }

    protected int a(of par1EntityLivingBase, float par2, float par3) {
        return 0;
    }

    protected void a(of par1EntityLivingBase, float par2) {
    }

    protected void b(of par1EntityLivingBase, double par2, double par4, double par6) {
        if (MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Specials.Pre(par1EntityLivingBase, this))) {
            return;
        }
        if (this.b(par1EntityLivingBase)) {
            float f2;
            float f3 = 1.6f;
            float f1 = 0.016666668f * f3;
            double d3 = par1EntityLivingBase.e(this.b.h);
            float f4 = f2 = par1EntityLivingBase.ah() ? NAME_TAG_RANGE_SNEAK : NAME_TAG_RANGE;
            if (d3 < (double)(f2 * f2)) {
                String s2 = par1EntityLivingBase.ay();
                if (par1EntityLivingBase.ah()) {
                    avi fontrenderer = this.a();
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)((float)par2 + 0.0f), (float)((float)par4 + par1EntityLivingBase.P + 0.5f), (float)((float)par6));
                    GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)(-this.b.j), (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)this.b.k, (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glScalef((float)(-f1), (float)(-f1), (float)f1);
                    GL11.glDisable((int)2896);
                    GL11.glTranslatef((float)0.0f, (float)(0.25f / f1), (float)0.0f);
                    GL11.glDepthMask((boolean)false);
                    GL11.glEnable((int)3042);
                    GL11.glBlendFunc((int)770, (int)771);
                    bfq tessellator = bfq.a;
                    GL11.glDisable((int)3553);
                    tessellator.b();
                    int i2 = fontrenderer.a(s2) / 2;
                    tessellator.a(0.0f, 0.0f, 0.0f, 0.25f);
                    tessellator.a((double)(-i2 - 1), -1.0, 0.0);
                    tessellator.a((double)(-i2 - 1), 8.0, 0.0);
                    tessellator.a((double)(i2 + 1), 8.0, 0.0);
                    tessellator.a((double)(i2 + 1), -1.0, 0.0);
                    tessellator.a();
                    GL11.glEnable((int)3553);
                    GL11.glDepthMask((boolean)true);
                    fontrenderer.b(s2, -fontrenderer.a(s2) / 2, 0, 0x20FFFFFF);
                    GL11.glEnable((int)2896);
                    GL11.glDisable((int)3042);
                    GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                    GL11.glPopMatrix();
                } else {
                    this.a(par1EntityLivingBase, par2, par4, par6, s2, f1, d3);
                }
            }
        }
        MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Specials.Post(par1EntityLivingBase, this));
    }

    protected boolean b(of par1EntityLivingBase) {
        return atv.r() && par1EntityLivingBase != this.b.h && !par1EntityLivingBase.d((uf)atv.w().h) && par1EntityLivingBase.n == null;
    }

    protected void a(of par1EntityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10) {
        if (par1EntityLivingBase.bh()) {
            this.a(par1EntityLivingBase, par8Str, par2, par4 - 1.5, par6, 64);
        } else {
            this.a(par1EntityLivingBase, par8Str, par2, par4, par6, 64);
        }
    }

    protected void a(of par1EntityLivingBase, String par2Str, double par3, double par5, double par7, int par9) {
        double d3 = par1EntityLivingBase.e(this.b.h);
        if (d3 <= (double)(par9 * par9)) {
            avi fontrenderer = this.a();
            float f2 = 1.6f;
            float f1 = 0.016666668f * f2;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((float)par3 + 0.0f), (float)((float)par5 + par1EntityLivingBase.P + 0.5f), (float)((float)par7));
            GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)(-this.b.j), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)this.b.k, (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glScalef((float)(-f1), (float)(-f1), (float)f1);
            GL11.glDisable((int)2896);
            GL11.glDepthMask((boolean)false);
            GL11.glDisable((int)2929);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            bfq tessellator = bfq.a;
            int b0 = 0;
            if (par2Str.equals("deadmau5")) {
                b0 = -10;
            }
            GL11.glDisable((int)3553);
            tessellator.b();
            int j2 = fontrenderer.a(par2Str) / 2;
            tessellator.a(0.0f, 0.0f, 0.0f, 0.25f);
            tessellator.a((double)(-j2 - 1), (double)(-1 + b0), 0.0);
            tessellator.a((double)(-j2 - 1), (double)(8 + b0), 0.0);
            tessellator.a((double)(j2 + 1), (double)(8 + b0), 0.0);
            tessellator.a((double)(j2 + 1), (double)(-1 + b0), 0.0);
            tessellator.a();
            GL11.glEnable((int)3553);
            fontrenderer.b(par2Str, -fontrenderer.a(par2Str) / 2, b0, 0x20FFFFFF);
            GL11.glEnable((int)2929);
            GL11.glDepthMask((boolean)true);
            fontrenderer.b(par2Str, -fontrenderer.a(par2Str) / 2, b0, -1);
            GL11.glEnable((int)2896);
            GL11.glDisable((int)3042);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glPopMatrix();
        }
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((of)par1Entity, par2, par4, par6, par8, par9);
    }
}

