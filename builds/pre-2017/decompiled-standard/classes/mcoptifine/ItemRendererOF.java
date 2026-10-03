/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.lang.reflect.Field;
import mcoptifine.Config;
import mcoptifine.Reflector;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import org.lwjgl.opengl.GL11;

public class ItemRendererOF
extends jizq {
    private xpzm field_78455_a = null;
    private htvc field_78452_e = null;
    private static final ResourceLocation field_110930_b = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    private static Field ItemRenderer_renderBlockInstance = Reflector.getFieldByType(jizq.class, htvc.class);

    public ItemRendererOF(xpzm xpzm2) {
        super(xpzm2);
        this.field_78455_a = xpzm2;
        if (ItemRenderer_renderBlockInstance == null) {
            Config.error("ItemRenderOF not initialized");
        }
        try {
            this.field_78452_e = (htvc)ItemRenderer_renderBlockInstance.get(this);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    @Override
    public void func_78443_a(EntityLivingBase entityLivingBase, cvzo cvzo2, int n) {
        GL11.glPushMatrix();
        apbu apbu2 = this.field_78455_a._R();
        boolean bl = Reflector.MinecraftForgeClient.exists();
        twgu twgu2 = null;
        if (cvzo2._a() instanceof mbpd && cvzo2._d < twgu.field_71973_m.length) {
            twgu2 = twgu.field_71973_m[cvzo2._d];
        }
        Object object = null;
        Object object2 = null;
        if (bl) {
            object = Reflector.getFieldValue(Reflector.ItemRenderType_EQUIPPED);
            object2 = Reflector.call(Reflector.MinecraftForgeClient_getItemRenderer, cvzo2, object);
        }
        if (object2 != null) {
            apbu2._a(apbu2._a(cvzo2._c()));
            Reflector.callVoid(Reflector.ForgeHooksClient_renderEquippedItem, object, object2, this.field_78452_e, entityLivingBase, cvzo2);
        } else if (twgu2 != null && cvzo2._c() == 0 && htvc._a(twgu2.func_71857_b())) {
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
            ItemRendererOF.func_78439_a(htvf2, f2, f3, f, f4, dwan2.func_94211_a(), dwan2.func_94216_b(), 0.0625f);
            boolean bl2 = false;
            if (Reflector.ForgeItemStack_hasEffect.exists()) {
                bl2 = Reflector.callBoolean(Reflector.ForgeItemStack_hasEffect, n);
            } else {
                boolean bl3 = bl2 = cvzo2._v() && n == 0;
            }
            if (bl2) {
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
                ItemRendererOF.func_78439_a(htvf2, 0.0f, 0.0f, 1.0f, 1.0f, 16, 16, 0.0625f);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef(f9, f9, f9);
                f10 = (float)(xpzm._M() % 4873L) / 4873.0f * 8.0f;
                GL11.glTranslatef(-f10, 0.0f, 0.0f);
                GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
                ItemRendererOF.func_78439_a(htvf2, 0.0f, 0.0f, 1.0f, 1.0f, 16, 16, 0.0625f);
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
}

