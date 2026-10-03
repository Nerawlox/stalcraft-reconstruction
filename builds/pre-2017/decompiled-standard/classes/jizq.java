/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.asm.ItemAtlasHooks;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class jizq {
    public static final ResourceLocation field_110930_b = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    public static final ResourceLocation field_110931_c = new ResourceLocation("textures/map/map_background.png");
    public static final ResourceLocation field_110929_d = new ResourceLocation("textures/misc/underwater.png");
    public xpzm field_78455_a;
    public cvzo field_78453_b;
    public float field_78454_c;
    public float field_78451_d;
    public htvc field_78452_e = new htvc();
    public final rqlb field_78449_f;
    public int field_78450_g = -1;

    public jizq(xpzm xpzm2) {
        this.field_78455_a = xpzm2;
        this.field_78449_f = new rqlb(xpzm2._M, xpzm2._R());
    }

    public void func_78443_a(EntityLivingBase entityLivingBase, cvzo cvzo2, int n) {
        this.renderItem(entityLivingBase, cvzo2, n, IItemRenderer.ItemRenderType.EQUIPPED);
    }

    public void renderItem(EntityLivingBase entityLivingBase, cvzo cvzo2, int n, IItemRenderer.ItemRenderType itemRenderType) {
        IItemRenderer iItemRenderer;
        ItemAtlasHooks.renderItem(this, entityLivingBase, cvzo2, n, itemRenderType);
        GL11.glPushMatrix();
        apbu apbu2 = this.field_78455_a._R();
        twgu twgu2 = null;
        if (cvzo2._a() instanceof mbpd && cvzo2._d < twgu.field_71973_m.length) {
            twgu2 = twgu.field_71973_m[cvzo2._d];
        }
        if ((iItemRenderer = MinecraftForgeClient.getItemRenderer(cvzo2, itemRenderType)) != null) {
            apbu2._a(apbu2._a(cvzo2._c()));
            ForgeHooksClient.renderEquippedItem(itemRenderType, iItemRenderer, this.field_78452_e, entityLivingBase, cvzo2);
        } else if (twgu2 != null && cvzo2._c() == 0 && htvc._a(twgu.field_71973_m[cvzo2._d].func_71857_b())) {
            apbu2._a(apbu2._a(0));
            this.field_78452_e._a(twgu.field_71973_m[cvzo2._d], cvzo2._j(), 1.0f);
        } else {
            dwan dwan2 = entityLivingBase.func_70620_b(cvzo2, n);
            if (dwan2 == null) {
                GL11.glPopMatrix();
                return;
            }
            apbu2._a(apbu2._a(cvzo2._c()));
            htvf htvf2 = htvf.field_78398_a;
            float f = dwan2.func_94209_e();
            float f2 = dwan2.func_94212_f();
            float f3 = dwan2.func_94206_g();
            float f4 = dwan2.func_94210_h();
            float f5 = 0.0f;
            float f6 = 0.3f;
            GL11.glEnable(32826);
            GL11.glTranslatef(-f5, -f6, 0.0f);
            float f7 = 1.5f;
            GL11.glScalef(f7, f7, f7);
            GL11.glRotatef(50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(335.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.9375f, -0.0625f, 0.0f);
            jizq.func_78439_a(htvf2, f2, f3, f, f4, dwan2.func_94211_a(), dwan2.func_94216_b(), 0.0625f);
            if (cvzo2._c(n)) {
                GL11.glDepthFunc(514);
                GL11.glDisable(2896);
                apbu2._a(field_110930_b);
                GL11.glEnable(3042);
                GL11.glBlendFunc(768, 1);
                float f8 = 0.76f;
                GL11.glColor4f(0.5f * f8, 0.25f * f8, 0.8f * f8, 1.0f);
                GL11.glMatrixMode(5890);
                GL11.glPushMatrix();
                float f9 = 0.125f;
                GL11.glScalef(f9, f9, f9);
                float f10 = (float)(xpzm._M() % 3000L) / 3000.0f * 8.0f;
                GL11.glTranslatef(f10, 0.0f, 0.0f);
                GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
                jizq.func_78439_a(htvf2, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef(f9, f9, f9);
                f10 = (float)(xpzm._M() % 4873L) / 4873.0f * 8.0f;
                GL11.glTranslatef(-f10, 0.0f, 0.0f);
                GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
                jizq.func_78439_a(htvf2, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
                GL11.glPopMatrix();
                GL11.glMatrixMode(5888);
                GL11.glDisable(3042);
                GL11.glEnable(2896);
                GL11.glDepthFunc(515);
            }
            GL11.glDisable(32826);
        }
        GL11.glPopMatrix();
    }

    public static void func_78439_a(htvf htvf2, float f, float f2, float f3, float f4, int n, int n2, float f5) {
        float f6;
        float f7;
        float f8;
        int n3;
        htvf2.func_78382_b();
        htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
        htvf2.func_78374_a(0.0, 0.0, 0.0, f, f4);
        htvf2.func_78374_a(1.0, 0.0, 0.0, f3, f4);
        htvf2.func_78374_a(1.0, 1.0, 0.0, f3, f2);
        htvf2.func_78374_a(0.0, 1.0, 0.0, f, f2);
        htvf2.func_78381_a();
        htvf2.func_78382_b();
        htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
        htvf2.func_78374_a(0.0, 1.0, 0.0f - f5, f, f2);
        htvf2.func_78374_a(1.0, 1.0, 0.0f - f5, f3, f2);
        htvf2.func_78374_a(1.0, 0.0, 0.0f - f5, f3, f4);
        htvf2.func_78374_a(0.0, 0.0, 0.0f - f5, f, f4);
        htvf2.func_78381_a();
        float f9 = 0.5f * (f - f3) / (float)n;
        float f10 = 0.5f * (f4 - f2) / (float)n2;
        htvf2.func_78382_b();
        htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
        for (n3 = 0; n3 < n; ++n3) {
            f8 = (float)n3 / (float)n;
            f7 = f + (f3 - f) * f8 - f9;
            htvf2.func_78374_a(f8, 0.0, 0.0f - f5, f7, f4);
            htvf2.func_78374_a(f8, 0.0, 0.0, f7, f4);
            htvf2.func_78374_a(f8, 1.0, 0.0, f7, f2);
            htvf2.func_78374_a(f8, 1.0, 0.0f - f5, f7, f2);
        }
        htvf2.func_78381_a();
        htvf2.func_78382_b();
        htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
        for (n3 = 0; n3 < n; ++n3) {
            f8 = (float)n3 / (float)n;
            f7 = f + (f3 - f) * f8 - f9;
            f6 = f8 + 1.0f / (float)n;
            htvf2.func_78374_a(f6, 1.0, 0.0f - f5, f7, f2);
            htvf2.func_78374_a(f6, 1.0, 0.0, f7, f2);
            htvf2.func_78374_a(f6, 0.0, 0.0, f7, f4);
            htvf2.func_78374_a(f6, 0.0, 0.0f - f5, f7, f4);
        }
        htvf2.func_78381_a();
        htvf2.func_78382_b();
        htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
        for (n3 = 0; n3 < n2; ++n3) {
            f8 = (float)n3 / (float)n2;
            f7 = f4 + (f2 - f4) * f8 - f10;
            f6 = f8 + 1.0f / (float)n2;
            htvf2.func_78374_a(0.0, f6, 0.0, f, f7);
            htvf2.func_78374_a(1.0, f6, 0.0, f3, f7);
            htvf2.func_78374_a(1.0, f6, 0.0f - f5, f3, f7);
            htvf2.func_78374_a(0.0, f6, 0.0f - f5, f, f7);
        }
        htvf2.func_78381_a();
        htvf2.func_78382_b();
        htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
        for (n3 = 0; n3 < n2; ++n3) {
            f8 = (float)n3 / (float)n2;
            f7 = f4 + (f2 - f4) * f8 - f10;
            htvf2.func_78374_a(1.0, f8, 0.0, f3, f7);
            htvf2.func_78374_a(0.0, f8, 0.0, f, f7);
            htvf2.func_78374_a(0.0, f8, 0.0f - f5, f, f7);
            htvf2.func_78374_a(1.0, f8, 0.0f - f5, f3, f7);
        }
        htvf2.func_78381_a();
    }

    public void func_78440_a(float f) {
        float f2;
        float f3;
        float f4;
        float f5 = this.field_78451_d + (this.field_78454_c - this.field_78451_d) * f;
        EntityClientPlayerMP entityClientPlayerMP = this.field_78455_a._t;
        float f6 = entityClientPlayerMP.field_70127_C + (entityClientPlayerMP.field_70125_A - entityClientPlayerMP.field_70127_C) * f;
        GL11.glPushMatrix();
        GL11.glRotatef(f6, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(entityClientPlayerMP.field_70126_B + (entityClientPlayerMP.field_70177_z - entityClientPlayerMP.field_70126_B) * f, 0.0f, 1.0f, 0.0f);
        qnon._b();
        GL11.glPopMatrix();
        EntityClientPlayerMP entityClientPlayerMP2 = entityClientPlayerMP;
        float f7 = entityClientPlayerMP2.field_71164_i + (entityClientPlayerMP2.field_71155_g - entityClientPlayerMP2.field_71164_i) * f;
        float f8 = entityClientPlayerMP2.field_71163_h + (entityClientPlayerMP2.field_71154_f - entityClientPlayerMP2.field_71163_h) * f;
        GL11.glRotatef((entityClientPlayerMP.field_70125_A - f7) * 0.1f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef((entityClientPlayerMP.field_70177_z - f8) * 0.1f, 0.0f, 1.0f, 0.0f);
        cvzo cvzo2 = this.field_78453_b;
        float f9 = this.field_78455_a._r.func_72801_o(sajh._c(entityClientPlayerMP.field_70165_t), sajh._c(entityClientPlayerMP.field_70163_u), sajh._c(entityClientPlayerMP.field_70161_v));
        f9 = 1.0f;
        int n = this.field_78455_a._r.func_72802_i(sajh._c(entityClientPlayerMP.field_70165_t), sajh._c(entityClientPlayerMP.field_70163_u), sajh._c(entityClientPlayerMP.field_70161_v), 0);
        int n2 = n % 65536;
        int n3 = n / 65536;
        iwya._a(iwya._b, (float)n2 / 1.0f, (float)n3 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        if (cvzo2 != null) {
            n = tgdv.field_77698_e[cvzo2._d].func_82790_a(cvzo2, 0);
            f4 = (float)(n >> 16 & 0xFF) / 255.0f;
            f3 = (float)(n >> 8 & 0xFF) / 255.0f;
            f2 = (float)(n & 0xFF) / 255.0f;
            GL11.glColor4f(f9 * f4, f9 * f3, f9 * f2, 1.0f);
        } else {
            GL11.glColor4f(f9, f9, f9, 1.0f);
        }
        if (cvzo2 != null && cvzo2._a() instanceof wppj) {
            float f10;
            GL11.glPushMatrix();
            float f11 = 0.8f;
            f4 = entityClientPlayerMP.func_70678_g(f);
            f3 = sajh._a(f4 * (float)Math.PI);
            f2 = sajh._a(sajh._c(f4) * (float)Math.PI);
            GL11.glTranslatef(-f2 * 0.4f, sajh._a(sajh._c(f4) * (float)Math.PI * 2.0f) * 0.2f, -f3 * 0.2f);
            f4 = 1.0f - f6 / 45.0f + 0.1f;
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            if (f4 > 1.0f) {
                f4 = 1.0f;
            }
            f4 = -sajh._b(f4 * (float)Math.PI) * 0.5f + 0.5f;
            GL11.glTranslatef(0.0f, 0.0f * f11 - (1.0f - f5) * 1.2f - f4 * 0.5f + 0.04f, -0.9f * f11);
            GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(f4 * -85.0f, 0.0f, 0.0f, 1.0f);
            GL11.glEnable(32826);
            this.field_78455_a._R()._a(entityClientPlayerMP.func_110306_p());
            for (n3 = 0; n3 < 2; ++n3) {
                int n4 = n3 * 2 - 1;
                GL11.glPushMatrix();
                GL11.glTranslatef(-0.0f, -0.6f, 1.1f * (float)n4);
                GL11.glRotatef(-45 * n4, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(59.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-65 * n4, 0.0f, 1.0f, 0.0f);
                tfvm tfvm2 = gqqu._b._a(this.field_78455_a._t);
                xbdy xbdy2 = (xbdy)tfvm2;
                f10 = 1.0f;
                GL11.glScalef(f10, f10, f10);
                xbdy2.func_82441_a(this.field_78455_a._t);
                GL11.glPopMatrix();
            }
            f3 = entityClientPlayerMP.func_70678_g(f);
            f2 = sajh._a(f3 * f3 * (float)Math.PI);
            float f12 = sajh._a(sajh._c(f3) * (float)Math.PI);
            GL11.glRotatef(-f2 * 20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-f12 * 20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-f12 * 80.0f, 1.0f, 0.0f, 0.0f);
            float f13 = 0.38f;
            GL11.glScalef(f13, f13, f13);
            GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.0f, -1.0f, 0.0f);
            f10 = 0.015625f;
            GL11.glScalef(f10, f10, f10);
            this.field_78455_a._R()._a(field_110931_c);
            htvf htvf2 = htvf.field_78398_a;
            GL11.glNormal3f(0.0f, 0.0f, -1.0f);
            htvf2.func_78382_b();
            int n5 = 7;
            htvf2.func_78374_a(0 - n5, 128 + n5, 0.0, 0.0, 1.0);
            htvf2.func_78374_a(128 + n5, 128 + n5, 0.0, 1.0, 1.0);
            htvf2.func_78374_a(128 + n5, 0 - n5, 0.0, 1.0, 0.0);
            htvf2.func_78374_a(0 - n5, 0 - n5, 0.0, 0.0, 0.0);
            htvf2.func_78381_a();
            IItemRenderer iItemRenderer = MinecraftForgeClient.getItemRenderer(cvzo2, IItemRenderer.ItemRenderType.FIRST_PERSON_MAP);
            thdd thdd2 = ((wppj)cvzo2._a())._a(cvzo2, this.field_78455_a._r);
            if (iItemRenderer == null) {
                if (thdd2 != null) {
                    this.field_78449_f._a(this.field_78455_a._t, this.field_78455_a._R(), thdd2);
                }
            } else {
                iItemRenderer.renderItem(IItemRenderer.ItemRenderType.FIRST_PERSON_MAP, cvzo2, this.field_78455_a._t, this.field_78455_a._R(), thdd2);
            }
            GL11.glPopMatrix();
        } else if (cvzo2 != null) {
            float f14;
            float f15;
            float f16;
            GL11.glPushMatrix();
            float f17 = 0.8f;
            if (entityClientPlayerMP.func_71052_bv() > 0) {
                bsre bsre2 = cvzo2._o();
                if (bsre2 == bsre._b || bsre2 == bsre._c) {
                    f3 = (float)entityClientPlayerMP.func_71052_bv() - f + 1.0f;
                    f2 = 1.0f - f3 / (float)cvzo2._n();
                    f16 = 1.0f - f2;
                    f16 = f16 * f16 * f16;
                    f16 = f16 * f16 * f16;
                    f16 = f16 * f16 * f16;
                    float f18 = 1.0f - f16;
                    GL11.glTranslatef(0.0f, sajh._e(sajh._b(f3 / 4.0f * (float)Math.PI) * 0.1f) * (float)((double)f2 > 0.2 ? 1 : 0), 0.0f);
                    GL11.glTranslatef(f18 * 0.6f, -f18 * 0.5f, 0.0f);
                    GL11.glRotatef(f18 * 90.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(f18 * 10.0f, 1.0f, 0.0f, 0.0f);
                    GL11.glRotatef(f18 * 30.0f, 0.0f, 0.0f, 1.0f);
                }
            } else {
                f4 = entityClientPlayerMP.func_70678_g(f);
                f3 = sajh._a(f4 * (float)Math.PI);
                f2 = sajh._a(sajh._c(f4) * (float)Math.PI);
                GL11.glTranslatef(-f2 * 0.4f, sajh._a(sajh._c(f4) * (float)Math.PI * 2.0f) * 0.2f, -f3 * 0.2f);
            }
            GL11.glTranslatef(0.7f * f17, -0.65f * f17 - (1.0f - f5) * 0.6f, -0.9f * f17);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glEnable(32826);
            f4 = entityClientPlayerMP.func_70678_g(f);
            f3 = sajh._a(f4 * f4 * (float)Math.PI);
            f2 = sajh._a(sajh._c(f4) * (float)Math.PI);
            GL11.glRotatef(-f3 * 20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-f2 * 20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-f2 * 80.0f, 1.0f, 0.0f, 0.0f);
            f16 = 0.4f;
            GL11.glScalef(f16, f16, f16);
            if (entityClientPlayerMP.func_71052_bv() > 0) {
                bsre bsre3 = cvzo2._o();
                if (bsre3 == bsre._d) {
                    GL11.glTranslatef(-0.5f, 0.2f, 0.0f);
                    GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
                    GL11.glRotatef(60.0f, 0.0f, 1.0f, 0.0f);
                } else if (bsre3 == bsre._e) {
                    GL11.glRotatef(-18.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glRotatef(-12.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(-8.0f, 1.0f, 0.0f, 0.0f);
                    GL11.glTranslatef(-0.9f, 0.2f, 0.0f);
                    f15 = (float)cvzo2._n() - ((float)entityClientPlayerMP.func_71052_bv() - f + 1.0f);
                    float f19 = f15 / 20.0f;
                    f19 = (f19 * f19 + f19 * 2.0f) / 3.0f;
                    if (f19 > 1.0f) {
                        f19 = 1.0f;
                    }
                    if (f19 > 0.1f) {
                        GL11.glTranslatef(0.0f, sajh._a((f15 - 0.1f) * 1.3f) * 0.01f * (f19 - 0.1f), 0.0f);
                    }
                    GL11.glTranslatef(0.0f, 0.0f, f19 * 0.1f);
                    GL11.glRotatef(-335.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glTranslatef(0.0f, 0.5f, 0.0f);
                    f14 = 1.0f + f19 * 0.2f;
                    GL11.glScalef(1.0f, 1.0f, f14);
                    GL11.glTranslatef(0.0f, -0.5f, 0.0f);
                    GL11.glRotatef(50.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(335.0f, 0.0f, 0.0f, 1.0f);
                }
            }
            if (cvzo2._a().func_77629_n_()) {
                GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
            }
            if (cvzo2._a().func_77623_v()) {
                this.renderItem(entityClientPlayerMP, cvzo2, 0, IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
                for (int i = 1; i < cvzo2._a().getRenderPasses(cvzo2._j()); ++i) {
                    int n6 = tgdv.field_77698_e[cvzo2._d].func_82790_a(cvzo2, i);
                    f15 = (float)(n6 >> 16 & 0xFF) / 255.0f;
                    float f20 = (float)(n6 >> 8 & 0xFF) / 255.0f;
                    f14 = (float)(n6 & 0xFF) / 255.0f;
                    GL11.glColor4f(f9 * f15, f9 * f20, f9 * f14, 1.0f);
                    this.renderItem(entityClientPlayerMP, cvzo2, i, IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
                }
            } else {
                this.renderItem(entityClientPlayerMP, cvzo2, 0, IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
            }
            GL11.glPopMatrix();
        } else if (!entityClientPlayerMP.func_82150_aj()) {
            GL11.glPushMatrix();
            float f21 = 0.8f;
            f4 = entityClientPlayerMP.func_70678_g(f);
            f3 = sajh._a(f4 * (float)Math.PI);
            f2 = sajh._a(sajh._c(f4) * (float)Math.PI);
            GL11.glTranslatef(-f2 * 0.3f, sajh._a(sajh._c(f4) * (float)Math.PI * 2.0f) * 0.4f, -f3 * 0.4f);
            GL11.glTranslatef(0.8f * f21, -0.75f * f21 - (1.0f - f5) * 0.6f, -0.9f * f21);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glEnable(32826);
            f4 = entityClientPlayerMP.func_70678_g(f);
            f3 = sajh._a(f4 * f4 * (float)Math.PI);
            f2 = sajh._a(sajh._c(f4) * (float)Math.PI);
            GL11.glRotatef(f2 * 70.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-f3 * 20.0f, 0.0f, 0.0f, 1.0f);
            this.field_78455_a._R()._a(entityClientPlayerMP.func_110306_p());
            GL11.glTranslatef(-1.0f, 3.6f, 3.5f);
            GL11.glRotatef(120.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(200.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-135.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glTranslatef(5.6f, 0.0f, 0.0f);
            tfvm tfvm3 = gqqu._b._a(this.field_78455_a._t);
            xbdy xbdy3 = (xbdy)tfvm3;
            float f22 = 1.0f;
            GL11.glScalef(f22, f22, f22);
            xbdy3.func_82441_a(this.field_78455_a._t);
            GL11.glPopMatrix();
        }
        GL11.glDisable(32826);
        qnon._a();
    }

    public void func_78447_b(float f) {
        GL11.glDisable(3008);
        if (this.field_78455_a._t.func_70027_ad()) {
            this.func_78442_d(f);
        }
        if (this.field_78455_a._t.func_70094_T()) {
            int n = sajh._c(this.field_78455_a._t.field_70165_t);
            int n2 = sajh._c(this.field_78455_a._t.field_70163_u);
            int n3 = sajh._c(this.field_78455_a._t.field_70161_v);
            int n4 = this.field_78455_a._r.func_72798_a(n, n2, n3);
            if (this.field_78455_a._r.func_72809_s(n, n2, n3)) {
                this.func_78446_a(f, twgu.field_71973_m[n4].func_71851_a(2));
            } else {
                for (int i = 0; i < 8; ++i) {
                    int n5;
                    int n6;
                    float f2 = ((float)((i >> 0) % 2) - 0.5f) * this.field_78455_a._t.field_70130_N * 0.9f;
                    float f3 = ((float)((i >> 1) % 2) - 0.5f) * this.field_78455_a._t.field_70131_O * 0.2f;
                    float f4 = ((float)((i >> 2) % 2) - 0.5f) * this.field_78455_a._t.field_70130_N * 0.9f;
                    int n7 = sajh._d((float)n + f2);
                    if (!this.field_78455_a._r.func_72809_s(n7, n6 = sajh._d((float)n2 + f3), n5 = sajh._d((float)n3 + f4))) continue;
                    n4 = this.field_78455_a._r.func_72798_a(n7, n6, n5);
                }
            }
            if (twgu.field_71973_m[n4] != null) {
                this.func_78446_a(f, twgu.field_71973_m[n4].func_71851_a(2));
            }
        }
        if (this.field_78455_a._t.func_70055_a(tflj._h)) {
            this.func_78448_c(f);
        }
        GL11.glEnable(3008);
    }

    public void func_78446_a(float f, dwan dwan2) {
        boolean bl = GloomyHooks.renderInsideOfBlock(this, f, dwan2);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        this.field_78455_a._R()._a(sctd._c);
        htvf htvf2 = htvf.field_78398_a;
        float f2 = 0.1f;
        GL11.glColor4f(f2, f2, f2, 0.5f);
        GL11.glPushMatrix();
        float f3 = -1.0f;
        float f4 = 1.0f;
        float f5 = -1.0f;
        float f6 = 1.0f;
        float f7 = -0.5f;
        float f8 = dwan2.func_94209_e();
        float f9 = dwan2.func_94212_f();
        float f10 = dwan2.func_94206_g();
        float f11 = dwan2.func_94210_h();
        htvf2.func_78382_b();
        htvf2.func_78374_a(f3, f5, f7, f9, f11);
        htvf2.func_78374_a(f4, f5, f7, f8, f11);
        htvf2.func_78374_a(f4, f6, f7, f8, f10);
        htvf2.func_78374_a(f3, f6, f7, f9, f10);
        htvf2.func_78381_a();
        GL11.glPopMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public void func_78448_c(float f) {
        this.field_78455_a._R()._a(field_110929_d);
        htvf htvf2 = htvf.field_78398_a;
        float f2 = this.field_78455_a._t.func_70013_c(f);
        GL11.glColor4f(f2, f2, f2, 0.5f);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glPushMatrix();
        float f3 = 4.0f;
        float f4 = -1.0f;
        float f5 = 1.0f;
        float f6 = -1.0f;
        float f7 = 1.0f;
        float f8 = -0.5f;
        float f9 = -this.field_78455_a._t.field_70177_z / 64.0f;
        float f10 = this.field_78455_a._t.field_70125_A / 64.0f;
        htvf2.func_78382_b();
        htvf2.func_78374_a(f4, f6, f8, f3 + f9, f3 + f10);
        htvf2.func_78374_a(f5, f6, f8, 0.0f + f9, f3 + f10);
        htvf2.func_78374_a(f5, f7, f8, 0.0f + f9, 0.0f + f10);
        htvf2.func_78374_a(f4, f7, f8, f3 + f9, 0.0f + f10);
        htvf2.func_78381_a();
        GL11.glPopMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
    }

    public void func_78442_d(float f) {
        tfsl cfr_ignored_0 = xpzm._E()._D;
        tfsl.enableTerrainShader(-1);
        htvf htvf2 = htvf.field_78398_a;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.9f);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        float f2 = 1.0f;
        for (int i = 0; i < 2; ++i) {
            GL11.glPushMatrix();
            dwan dwan2 = twgu.field_72067_ar._a(1);
            this.field_78455_a._R()._a(sctd._c);
            float f3 = dwan2.func_94209_e();
            float f4 = dwan2.func_94212_f();
            float f5 = dwan2.func_94206_g();
            float f6 = dwan2.func_94210_h();
            float f7 = (0.0f - f2) / 2.0f;
            float f8 = f7 + f2;
            float f9 = 0.0f - f2 / 2.0f;
            float f10 = f9 + f2;
            float f11 = -0.5f;
            GL11.glTranslatef((float)(-(i * 2 - 1)) * 0.24f, -0.3f, 0.0f);
            GL11.glRotatef((float)(i * 2 - 1) * 10.0f, 0.0f, 1.0f, 0.0f);
            htvf2.func_78382_b();
            htvf2.func_78374_a(f7, f9, f11, f4, f6);
            htvf2.func_78374_a(f8, f9, f11, f3, f6);
            htvf2.func_78374_a(f8, f10, f11, f3, f5);
            htvf2.func_78374_a(f7, f10, f11, f4, f5);
            htvf2.func_78381_a();
            GL11.glPopMatrix();
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
        xpzm xpzm2 = xpzm._E();
        xpzm2._D.disableTerrainShader();
    }

    public void func_78441_a() {
        float f;
        float f2;
        float f3;
        boolean bl;
        if (GloomyHooks.onUpdateEquippedItem(this)) {
            return;
        }
        this.field_78451_d = this.field_78454_c;
        EntityClientPlayerMP entityClientPlayerMP = this.field_78455_a._t;
        cvzo cvzo2 = entityClientPlayerMP.field_71071_by._a();
        boolean bl2 = bl = this.field_78450_g == entityClientPlayerMP.field_71071_by._c && cvzo2 == this.field_78453_b;
        if (this.field_78453_b == null && cvzo2 == null) {
            bl = true;
        }
        if (cvzo2 != null && this.field_78453_b != null && cvzo2 != this.field_78453_b && cvzo2._d == this.field_78453_b._d && cvzo2._j() == this.field_78453_b._j()) {
            this.field_78453_b = cvzo2;
            bl = true;
        }
        if ((f3 = (f2 = bl ? 1.0f : 0.0f) - this.field_78454_c) < -(f = 0.4f)) {
            f3 = -f;
        }
        if (f3 > f) {
            f3 = f;
        }
        this.field_78454_c += f3;
        if (this.field_78454_c < 0.1f) {
            this.field_78453_b = cvzo2;
            this.field_78450_g = entityClientPlayerMP.field_71071_by._c;
        }
    }

    public void func_78444_b() {
        this.field_78454_c = 0.0f;
    }

    public void func_78445_c() {
        this.field_78454_c = 0.0f;
    }
}

