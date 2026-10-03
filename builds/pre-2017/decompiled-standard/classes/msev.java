/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezfc;
import net.minecraft.util.sajh;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public abstract class msev
extends tfvm {
    public static final ResourceLocation field_110814_a = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    public ModelBase field_77045_g;
    public ModelBase field_77046_h;
    public static float NAME_TAG_RANGE = 64.0f;
    public static float NAME_TAG_RANGE_SNEAK = 32.0f;

    public msev(ModelBase modelBase, float f) {
        this.field_77045_g = modelBase;
        this.field_76989_e = f;
    }

    public void func_77042_a(ModelBase modelBase) {
        this.field_77046_h = modelBase;
    }

    public float func_77034_a(float f, float f2, float f3) {
        float f4;
        for (f4 = f2 - f; f4 < -180.0f; f4 += 360.0f) {
        }
        while (f4 >= 180.0f) {
            f4 -= 360.0f;
        }
        return f + f3 * f4;
    }

    public void func_130000_a(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        if (MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Pre(entityLivingBase, this))) {
            return;
        }
        GL11.glPushMatrix();
        GL11.glDisable(2884);
        this.field_77045_g.field_78095_p = this.func_77040_d(entityLivingBase, f2);
        if (this.field_77046_h != null) {
            this.field_77046_h.field_78095_p = this.field_77045_g.field_78095_p;
        }
        this.field_77045_g.field_78093_q = entityLivingBase.func_70115_ae();
        if (this.field_77046_h != null) {
            this.field_77046_h.field_78093_q = this.field_77045_g.field_78093_q;
        }
        this.field_77045_g.field_78091_s = entityLivingBase.func_70631_g_();
        if (this.field_77046_h != null) {
            this.field_77046_h.field_78091_s = this.field_77045_g.field_78091_s;
        }
        try {
            float f3;
            int n;
            float f4;
            float f5;
            int n2;
            float f6;
            float f7 = this.func_77034_a(entityLivingBase.field_70760_ar, entityLivingBase.field_70761_aq, f2);
            float f8 = this.func_77034_a(entityLivingBase.field_70758_at, entityLivingBase.field_70759_as, f2);
            if (entityLivingBase.func_70115_ae() && entityLivingBase.field_70154_o instanceof EntityLivingBase) {
                EntityLivingBase entityLivingBase2 = (EntityLivingBase)entityLivingBase.field_70154_o;
                f7 = this.func_77034_a(entityLivingBase2.field_70760_ar, entityLivingBase2.field_70761_aq, f2);
                f6 = sajh._g(f8 - f7);
                if (f6 < -85.0f) {
                    f6 = -85.0f;
                }
                if (f6 >= 85.0f) {
                    f6 = 85.0f;
                }
                f7 = f8 - f6;
                if (f6 * f6 > 2500.0f) {
                    f7 += f6 * 0.2f;
                }
            }
            float f9 = entityLivingBase.field_70127_C + (entityLivingBase.field_70125_A - entityLivingBase.field_70127_C) * f2;
            this.func_77039_a(entityLivingBase, d, d2, d3);
            f6 = this.func_77044_a(entityLivingBase, f2);
            this.func_77043_a(entityLivingBase, f6, f7, f2);
            float f10 = 0.0625f;
            GL11.glEnable(32826);
            GL11.glScalef(-1.0f, -1.0f, 1.0f);
            this.func_77041_b(entityLivingBase, f2);
            GL11.glTranslatef(0.0f, -24.0f * f10 - 0.0078125f, 0.0f);
            float f11 = entityLivingBase.field_70722_aY + (entityLivingBase.field_70721_aZ - entityLivingBase.field_70722_aY) * f2;
            float f12 = entityLivingBase.field_70754_ba - entityLivingBase.field_70721_aZ * (1.0f - f2);
            if (entityLivingBase.func_70631_g_()) {
                f12 *= 3.0f;
            }
            if (f11 > 1.0f) {
                f11 = 1.0f;
            }
            GL11.glEnable(3008);
            this.field_77045_g.func_78086_a(entityLivingBase, f12, f11, f2);
            this.func_77036_a(entityLivingBase, f12, f11, f6, f8 - f7, f9, f10);
            for (int i = 0; i < 4; ++i) {
                n2 = this.func_77032_a(entityLivingBase, i, f2);
                if (n2 <= 0) continue;
                this.field_77046_h.func_78086_a(entityLivingBase, f12, f11, f2);
                this.field_77046_h.func_78088_a(entityLivingBase, f12, f11, f6, f8 - f7, f9, f10);
                if ((n2 & 0xF0) == 16) {
                    this.func_82408_c(entityLivingBase, i, f2);
                    this.field_77046_h.func_78088_a(entityLivingBase, f12, f11, f6, f8 - f7, f9, f10);
                }
                if ((n2 & 0xF) == 15) {
                    f5 = (float)entityLivingBase.field_70173_aa + f2;
                    this.func_110776_a(field_110814_a);
                    GL11.glEnable(3042);
                    f4 = 0.5f;
                    GL11.glColor4f(f4, f4, f4, 1.0f);
                    GL11.glDepthFunc(514);
                    GL11.glDepthMask(false);
                    for (n = 0; n < 2; ++n) {
                        GL11.glDisable(2896);
                        f3 = 0.76f;
                        GL11.glColor4f(0.5f * f3, 0.25f * f3, 0.8f * f3, 1.0f);
                        GL11.glBlendFunc(768, 1);
                        GL11.glMatrixMode(5890);
                        GL11.glLoadIdentity();
                        float f13 = f5 * (0.001f + (float)n * 0.003f) * 20.0f;
                        float f14 = 0.33333334f;
                        GL11.glScalef(f14, f14, f14);
                        GL11.glRotatef(30.0f - (float)n * 60.0f, 0.0f, 0.0f, 1.0f);
                        GL11.glTranslatef(0.0f, f13, 0.0f);
                        GL11.glMatrixMode(5888);
                        this.field_77046_h.func_78088_a(entityLivingBase, f12, f11, f6, f8 - f7, f9, f10);
                    }
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                    GL11.glMatrixMode(5890);
                    GL11.glDepthMask(true);
                    GL11.glLoadIdentity();
                    GL11.glMatrixMode(5888);
                    GL11.glEnable(2896);
                    GL11.glDisable(3042);
                    GL11.glDepthFunc(515);
                }
                GL11.glDisable(3042);
                GL11.glEnable(3008);
            }
            GL11.glDepthMask(true);
            this.func_77029_c(entityLivingBase, f2);
            float f15 = entityLivingBase.func_70013_c(f2);
            n2 = this.func_77030_a(entityLivingBase, f15, f2);
            iwya._a(iwya._b);
            GL11.glDisable(3553);
            iwya._a(iwya._a);
            if ((n2 >> 24 & 0xFF) > 0 || entityLivingBase.field_70737_aN > 0 || entityLivingBase.field_70725_aQ > 0) {
                GL11.glDisable(3553);
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                GL11.glDepthFunc(514);
                if (entityLivingBase.field_70737_aN > 0 || entityLivingBase.field_70725_aQ > 0) {
                    GL11.glColor4f(f15, 0.0f, 0.0f, 0.4f);
                    this.field_77045_g.func_78088_a(entityLivingBase, f12, f11, f6, f8 - f7, f9, f10);
                    for (n = 0; n < 4; ++n) {
                        if (this.func_77035_b(entityLivingBase, n, f2) < 0) continue;
                        GL11.glColor4f(f15, 0.0f, 0.0f, 0.4f);
                        this.field_77046_h.func_78088_a(entityLivingBase, f12, f11, f6, f8 - f7, f9, f10);
                    }
                }
                if ((n2 >> 24 & 0xFF) > 0) {
                    f5 = (float)(n2 >> 16 & 0xFF) / 255.0f;
                    f4 = (float)(n2 >> 8 & 0xFF) / 255.0f;
                    float f16 = (float)(n2 & 0xFF) / 255.0f;
                    f3 = (float)(n2 >> 24 & 0xFF) / 255.0f;
                    GL11.glColor4f(f5, f4, f16, f3);
                    this.field_77045_g.func_78088_a(entityLivingBase, f12, f11, f6, f8 - f7, f9, f10);
                    for (int i = 0; i < 4; ++i) {
                        if (this.func_77035_b(entityLivingBase, i, f2) < 0) continue;
                        GL11.glColor4f(f5, f4, f16, f3);
                        this.field_77046_h.func_78088_a(entityLivingBase, f12, f11, f6, f8 - f7, f9, f10);
                    }
                }
                GL11.glDepthFunc(515);
                GL11.glDisable(3042);
                GL11.glEnable(3008);
                GL11.glEnable(3553);
            }
            GL11.glDisable(32826);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        iwya._a(iwya._b);
        GL11.glEnable(3553);
        iwya._a(iwya._a);
        GL11.glEnable(2884);
        GL11.glPopMatrix();
        this.func_77033_b(entityLivingBase, d, d2, d3);
        MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Post(entityLivingBase, this));
    }

    public void func_77036_a(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_110777_b(entityLivingBase);
        if (!entityLivingBase.func_82150_aj()) {
            this.field_77045_g.func_78088_a(entityLivingBase, f, f2, f3, f4, f5, f6);
        } else if (!entityLivingBase.func_98034_c(xpzm._E()._t)) {
            GL11.glPushMatrix();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.15f);
            GL11.glDepthMask(false);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glAlphaFunc(516, 0.003921569f);
            this.field_77045_g.func_78088_a(entityLivingBase, f, f2, f3, f4, f5, f6);
            GL11.glDisable(3042);
            GL11.glAlphaFunc(516, 0.1f);
            GL11.glPopMatrix();
            GL11.glDepthMask(true);
        } else {
            this.field_77045_g.func_78087_a(f, f2, f3, f4, f5, f6, entityLivingBase);
        }
    }

    public void func_77039_a(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
    }

    public void func_77043_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        GL11.glRotatef(180.0f - f2, 0.0f, 1.0f, 0.0f);
        if (entityLivingBase.field_70725_aQ > 0) {
            float f4 = ((float)entityLivingBase.field_70725_aQ + f3 - 1.0f) / 20.0f * 1.6f;
            if ((f4 = sajh._c(f4)) > 1.0f) {
                f4 = 1.0f;
            }
            GL11.glRotatef(f4 * this.func_77037_a(entityLivingBase), 0.0f, 0.0f, 1.0f);
        } else {
            String string = ezfc._a(entityLivingBase.func_70023_ak());
            if (!(!string.equals("Dinnerbone") && !string.equals("Grumm") || entityLivingBase instanceof EntityPlayer && ((EntityPlayer)entityLivingBase).func_82238_cc())) {
                GL11.glTranslatef(0.0f, entityLivingBase.field_70131_O + 0.1f, 0.0f);
                GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
            }
        }
    }

    public float func_77040_d(EntityLivingBase entityLivingBase, float f) {
        return entityLivingBase.func_70678_g(f);
    }

    public float func_77044_a(EntityLivingBase entityLivingBase, float f) {
        return (float)entityLivingBase.field_70173_aa + f;
    }

    public void func_77029_c(EntityLivingBase entityLivingBase, float f) {
    }

    public void func_85093_e(EntityLivingBase entityLivingBase, float f) {
        int n = entityLivingBase.func_85035_bI();
        if (n > 0) {
            EntityArrow entityArrow = new EntityArrow(entityLivingBase.field_70170_p, entityLivingBase.field_70165_t, entityLivingBase.field_70163_u, entityLivingBase.field_70161_v);
            Random random = new Random(entityLivingBase.field_70157_k);
            qnon._a();
            for (int i = 0; i < n; ++i) {
                GL11.glPushMatrix();
                ModelRenderer modelRenderer = this.field_77045_g.func_85181_a(random);
                ModelBox modelBox = (ModelBox)modelRenderer.field_78804_l.get(random.nextInt(modelRenderer.field_78804_l.size()));
                modelRenderer.func_78794_c(0.0625f);
                float f2 = random.nextFloat();
                float f3 = random.nextFloat();
                float f4 = random.nextFloat();
                float f5 = (modelBox.field_78252_a + (modelBox.field_78248_d - modelBox.field_78252_a) * f2) / 16.0f;
                float f6 = (modelBox.field_78250_b + (modelBox.field_78249_e - modelBox.field_78250_b) * f3) / 16.0f;
                float f7 = (modelBox.field_78251_c + (modelBox.field_78246_f - modelBox.field_78251_c) * f4) / 16.0f;
                GL11.glTranslatef(f5, f6, f7);
                f2 = f2 * 2.0f - 1.0f;
                f3 = f3 * 2.0f - 1.0f;
                f4 = f4 * 2.0f - 1.0f;
                float f8 = sajh._c((f2 *= -1.0f) * f2 + (f4 *= -1.0f) * f4);
                entityArrow.field_70126_B = entityArrow.field_70177_z = (float)(Math.atan2(f2, f4) * 180.0 / Math.PI);
                entityArrow.field_70127_C = entityArrow.field_70125_A = (float)(Math.atan2(f3 *= -1.0f, f8) * 180.0 / Math.PI);
                double d = 0.0;
                double d2 = 0.0;
                double d3 = 0.0;
                float f9 = 0.0f;
                this.field_76990_c._a(entityArrow, d, d2, d3, f9, f);
                GL11.glPopMatrix();
            }
            qnon._b();
        }
    }

    public int func_77035_b(EntityLivingBase entityLivingBase, int n, float f) {
        return this.func_77032_a(entityLivingBase, n, f);
    }

    public int func_77032_a(EntityLivingBase entityLivingBase, int n, float f) {
        return -1;
    }

    public void func_82408_c(EntityLivingBase entityLivingBase, int n, float f) {
    }

    public float func_77037_a(EntityLivingBase entityLivingBase) {
        return 90.0f;
    }

    public int func_77030_a(EntityLivingBase entityLivingBase, float f, float f2) {
        return 0;
    }

    public void func_77041_b(EntityLivingBase entityLivingBase, float f) {
    }

    public void func_77033_b(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        if (MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Specials.Pre(entityLivingBase, this))) {
            return;
        }
        if (this.func_110813_b(entityLivingBase)) {
            float f;
            float f2 = 1.6f;
            float f3 = 0.016666668f * f2;
            double d4 = entityLivingBase.func_70068_e(this.field_76990_c._j);
            float f4 = f = entityLivingBase.func_70093_af() ? NAME_TAG_RANGE_SNEAK : NAME_TAG_RANGE;
            if (d4 < (double)(f * f)) {
                String string = entityLivingBase.func_96090_ax();
                if (entityLivingBase.func_70093_af()) {
                    qncw qncw2 = this.func_76983_a();
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)d + 0.0f, (float)d2 + entityLivingBase.field_70131_O + 0.5f, (float)d3);
                    GL11.glNormal3f(0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(-this.field_76990_c._l, 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(this.field_76990_c._m, 1.0f, 0.0f, 0.0f);
                    GL11.glScalef(-f3, -f3, f3);
                    GL11.glDisable(2896);
                    GL11.glTranslatef(0.0f, 0.25f / f3, 0.0f);
                    GL11.glDepthMask(false);
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                    htvf htvf2 = htvf.field_78398_a;
                    GL11.glDisable(3553);
                    htvf2.func_78382_b();
                    int n = qncw2._b(string) / 2;
                    htvf2.func_78369_a(0.0f, 0.0f, 0.0f, 0.25f);
                    htvf2.func_78377_a(-n - 1, -1.0, 0.0);
                    htvf2.func_78377_a(-n - 1, 8.0, 0.0);
                    htvf2.func_78377_a(n + 1, 8.0, 0.0);
                    htvf2.func_78377_a(n + 1, -1.0, 0.0);
                    htvf2.func_78381_a();
                    GL11.glEnable(3553);
                    GL11.glDepthMask(true);
                    qncw2._b(string, -qncw2._b(string) / 2, 0, 0x20FFFFFF);
                    GL11.glEnable(2896);
                    GL11.glDisable(3042);
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                    GL11.glPopMatrix();
                } else {
                    this.func_96449_a(entityLivingBase, d, d2, d3, string, f3, d4);
                }
            }
        }
        MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Specials.Post(entityLivingBase, this));
    }

    public boolean func_110813_b(EntityLivingBase entityLivingBase) {
        return xpzm._A() && entityLivingBase != this.field_76990_c._j && !entityLivingBase.func_98034_c(xpzm._E()._t) && entityLivingBase.field_70153_n == null;
    }

    public void func_96449_a(EntityLivingBase entityLivingBase, double d, double d2, double d3, String string, float f, double d4) {
        if (entityLivingBase.func_70608_bn()) {
            this.func_77038_a(entityLivingBase, string, d, d2 - 1.5, d3, 64);
        } else {
            this.func_77038_a(entityLivingBase, string, d, d2, d3, 64);
        }
    }

    public void func_77038_a(EntityLivingBase entityLivingBase, String string, double d, double d2, double d3, int n) {
        double d4 = entityLivingBase.func_70068_e(this.field_76990_c._j);
        if (d4 <= (double)(n * n)) {
            qncw qncw2 = this.func_76983_a();
            float f = 1.6f;
            float f2 = 0.016666668f * f;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d + 0.0f, (float)d2 + entityLivingBase.field_70131_O + 0.5f, (float)d3);
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-this.field_76990_c._l, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(this.field_76990_c._m, 1.0f, 0.0f, 0.0f);
            GL11.glScalef(-f2, -f2, f2);
            GL11.glDisable(2896);
            GL11.glDepthMask(false);
            GL11.glDisable(2929);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            htvf htvf2 = htvf.field_78398_a;
            int n2 = 0;
            if (string.equals("deadmau5")) {
                n2 = -10;
            }
            GL11.glDisable(3553);
            htvf2.func_78382_b();
            int n3 = qncw2._b(string) / 2;
            htvf2.func_78369_a(0.0f, 0.0f, 0.0f, 0.25f);
            htvf2.func_78377_a(-n3 - 1, -1 + n2, 0.0);
            htvf2.func_78377_a(-n3 - 1, 8 + n2, 0.0);
            htvf2.func_78377_a(n3 + 1, 8 + n2, 0.0);
            htvf2.func_78377_a(n3 + 1, -1 + n2, 0.0);
            htvf2.func_78381_a();
            GL11.glEnable(3553);
            qncw2._b(string, -qncw2._b(string) / 2, n2, 0x20FFFFFF);
            GL11.glEnable(2929);
            GL11.glDepthMask(true);
            qncw2._b(string, -qncw2._b(string) / 2, n2, -1);
            GL11.glEnable(2896);
            GL11.glDisable(3042);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPopMatrix();
        }
    }

    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.func_130000_a((EntityLivingBase)entity, d, d2, d3, f, f2);
    }
}

