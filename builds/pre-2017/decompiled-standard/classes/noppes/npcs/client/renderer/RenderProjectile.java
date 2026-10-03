/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;
import noppes.npcs.client.ClientProxy;
import noppes.npcs.entity.EntityProjectile;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderProjectile
extends tfvm {
    private static final ResourceLocation field_110780_a = new ResourceLocation("textures/entity/arrow.png");
    private static final ResourceLocation field_110798_h = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    public boolean renderWithColor = true;
    private htvc itemRenderBlocks = new htvc();

    public void doRenderProjectile(EntityProjectile entityProjectile, double d, double d2, double d3, float f, float f2) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        GL11.glEnable(32826);
        float f3 = (float)entityProjectile.func_70096_w()._c(23) / 10.0f;
        cvzo cvzo2 = entityProjectile.getItemDisplay();
        GL11.glScalef(f3, f3, f3);
        htvf htvf2 = htvf.field_78398_a;
        if (entityProjectile.isArrow()) {
            this.func_110777_b(entityProjectile);
            GL11.glRotatef(entityProjectile.field_70126_B + (entityProjectile.field_70177_z - entityProjectile.field_70126_B) * f2 - 90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(entityProjectile.field_70127_C + (entityProjectile.field_70125_A - entityProjectile.field_70127_C) * f2, 0.0f, 0.0f, 1.0f);
            int n = 0;
            float f4 = 0.0f;
            float f5 = 0.5f;
            float f6 = (float)(0 + n * 10) / 32.0f;
            float f7 = (float)(5 + n * 10) / 32.0f;
            float f8 = 0.0f;
            float f9 = 0.15625f;
            float f10 = (float)(5 + n * 10) / 32.0f;
            float f11 = (float)(10 + n * 10) / 32.0f;
            float f12 = 0.05625f;
            GL11.glEnable(32826);
            float f13 = (float)entityProjectile.arrowShake - f2;
            if (f13 > 0.0f) {
                float f14 = -sajh._a(f13 * 3.0f) * f13;
                GL11.glRotatef(f14, 0.0f, 0.0f, 1.0f);
            }
            GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScalef(f12, f12, f12);
            GL11.glTranslatef(-4.0f, 0.0f, 0.0f);
            GL11.glNormal3f(f12, 0.0f, 0.0f);
            htvf2.func_78382_b();
            htvf2.func_78374_a(-7.0, -2.0, -2.0, f8, f10);
            htvf2.func_78374_a(-7.0, -2.0, 2.0, f9, f10);
            htvf2.func_78374_a(-7.0, 2.0, 2.0, f9, f11);
            htvf2.func_78374_a(-7.0, 2.0, -2.0, f8, f11);
            htvf2.func_78381_a();
            GL11.glNormal3f(-f12, 0.0f, 0.0f);
            htvf2.func_78382_b();
            htvf2.func_78374_a(-7.0, 2.0, -2.0, f8, f10);
            htvf2.func_78374_a(-7.0, 2.0, 2.0, f9, f10);
            htvf2.func_78374_a(-7.0, -2.0, 2.0, f9, f11);
            htvf2.func_78374_a(-7.0, -2.0, -2.0, f8, f11);
            htvf2.func_78381_a();
            for (int i = 0; i < 4; ++i) {
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glNormal3f(0.0f, 0.0f, f12);
                htvf2.func_78382_b();
                htvf2.func_78374_a(-8.0, -2.0, 0.0, f4, f6);
                htvf2.func_78374_a(8.0, -2.0, 0.0, f5, f6);
                htvf2.func_78374_a(8.0, 2.0, 0.0, f5, f7);
                htvf2.func_78374_a(-8.0, 2.0, 0.0, f4, f7);
                htvf2.func_78381_a();
            }
        } else if (entityProjectile.is3D()) {
            GL11.glRotatef(entityProjectile.field_70126_B + (entityProjectile.field_70177_z - entityProjectile.field_70126_B) * f2 - 90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(entityProjectile.field_70127_C + (entityProjectile.field_70125_A - entityProjectile.field_70127_C) * f2 - 180.0f, 0.0f, 0.0f, 1.0f);
            twgu twgu2 = null;
            if (cvzo2._d < twgu.field_71973_m.length) {
                twgu2 = twgu.field_71973_m[cvzo2._d];
            }
            if (cvzo2._c() == 0 && twgu2 != null && htvc._a(twgu.field_71973_m[cvzo2._d].func_71857_b())) {
                this.func_110776_a(sctd._c);
                float f15 = 0.25f;
                int n = twgu2.func_71857_b();
                if (n == 1 || n == 19 || n == 12 || n == 2) {
                    f15 = 0.5f;
                }
                float f16 = 1.0f;
                this.field_76988_d._a(twgu2, cvzo2._j(), f16);
            } else if (cvzo2._a().func_77623_v()) {
                for (int i = 0; i < cvzo2._a().getRenderPasses(cvzo2._j()); ++i) {
                    cvzo2._a().getIcon(cvzo2, i);
                    float f17 = 1.0f;
                    if (this.renderWithColor) {
                        int n = tgdv.field_77698_e[cvzo2._d].func_82790_a(cvzo2, i);
                        float f18 = (float)(n >> 16 & 0xFF) / 255.0f;
                        float f19 = (float)(n >> 8 & 0xFF) / 255.0f;
                        float f20 = (float)(n & 0xFF) / 255.0f;
                        GL11.glColor4f(f18 * f17, f19 * f17, f20 * f17, 1.0f);
                        this.field_76990_c._h.func_78443_a(xpzm._E()._t, cvzo2, 0);
                        continue;
                    }
                    this.field_76990_c._h.func_78443_a(xpzm._E()._t, cvzo2, 0);
                }
            } else {
                dwan dwan2 = cvzo2._b();
                if (this.renderWithColor) {
                    int n = tgdv.field_77698_e[cvzo2._d].func_82790_a(cvzo2, 0);
                    float f21 = (float)(n >> 16 & 0xFF) / 255.0f;
                    float f22 = (float)(n >> 8 & 0xFF) / 255.0f;
                    float f23 = (float)(n & 0xFF) / 255.0f;
                    float f24 = 1.0f;
                    this.renderDroppedItem(cvzo2, dwan2, f2, f21 * f24, f22 * f24, f23 * f24, f3);
                } else {
                    this.renderDroppedItem(cvzo2, dwan2, f2, 1.0f, 1.0f, 1.0f, f3);
                }
            }
        } else {
            float f25;
            float f26;
            int n;
            dwan dwan3 = cvzo2._b();
            this.func_110776_a(sctd._e);
            if (cvzo2._a().func_77623_v()) {
                for (n = 0; n < cvzo2._a().getRenderPasses(cvzo2._j()); ++n) {
                    int n2 = tgdv.field_77698_e[cvzo2._d].func_82790_a(cvzo2, n);
                    f26 = (float)(n2 >> 16 & 0xFF) / 255.0f;
                    f25 = (float)(n2 >> 8 & 0xFF) / 255.0f;
                    float f27 = (float)(n2 & 0xFF) / 255.0f;
                    GL11.glColor4f(f26, f25, f27, 1.0f);
                }
            }
            if (dwan3 == zyyc._a("potion_splash")) {
                n = hdoy._a(cvzo2._j(), false);
                float f28 = (float)(n >> 16 & 0xFF) / 255.0f;
                f26 = (float)(n >> 8 & 0xFF) / 255.0f;
                f25 = (float)(n & 0xFF) / 255.0f;
                GL11.glColor3f(f28, f26, f25);
                GL11.glPushMatrix();
                this.renderSprite(htvf2, zyyc._a("potion_contents"));
                GL11.glPopMatrix();
                GL11.glColor3f(1.0f, 1.0f, 1.0f);
            }
            this.renderSprite(htvf2, dwan3);
        }
        if (entityProjectile.is3D() && entityProjectile.glows()) {
            GL11.glDisable(2896);
        }
        GL11.glDisable(32826);
        GL11.glPopMatrix();
        GL11.glEnable(2896);
    }

    private void renderSprite(htvf htvf2, dwan dwan2) {
        float f = dwan2.func_94209_e();
        float f2 = dwan2.func_94212_f();
        float f3 = dwan2.func_94206_g();
        float f4 = dwan2.func_94210_h();
        float f5 = 1.0f;
        float f6 = 0.5f;
        float f7 = 0.25f;
        GL11.glRotatef(180.0f - this.field_76990_c._l, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-this.field_76990_c._m, 1.0f, 0.0f, 0.0f);
        htvf2.func_78382_b();
        htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
        htvf2.func_78374_a(0.0f - f6, 0.0f - f7, 0.0, f, f4);
        htvf2.func_78374_a(f5 - f6, 0.0f - f7, 0.0, f2, f4);
        htvf2.func_78374_a(f5 - f6, f5 - f7, 0.0, f2, f3);
        htvf2.func_78374_a(0.0f - f6, f5 - f7, 0.0, f, f3);
        htvf2.func_78381_a();
    }

    private void renderDroppedItem(cvzo cvzo2, dwan dwan2, float f, float f2, float f3, float f4, float f5) {
        htvf htvf2 = htvf.field_78398_a;
        if (dwan2 == null) {
            apbu apbu2 = xpzm._E()._R();
            ResourceLocation resourceLocation = apbu2._a(cvzo2._c());
            dwan2 = ((sctd)apbu2._b(resourceLocation))._b("missingno");
        }
        float f6 = dwan2.func_94209_e();
        float f7 = dwan2.func_94212_f();
        float f8 = dwan2.func_94206_g();
        float f9 = dwan2.func_94210_h();
        float f10 = 1.0f;
        float f11 = 0.5f;
        float f12 = 0.25f;
        float f13 = 0.0625f;
        if (cvzo2._c() == 0) {
            this.func_110776_a(sctd._c);
        } else {
            this.func_110776_a(sctd._e);
        }
        GL11.glColor4f(f2, f3, f4, 1.0f);
        jizq.func_78439_a(htvf2, f7, f8, f6, f9, dwan2.func_94211_a(), dwan2.func_94216_b(), f13);
        if (cvzo2 != null && cvzo2._c(0)) {
            GL11.glDepthFunc(514);
            GL11.glDisable(2896);
            ClientProxy.bindTexture(field_110798_h);
            GL11.glEnable(3042);
            GL11.glBlendFunc(768, 1);
            float f14 = 0.76f;
            GL11.glColor4f(0.5f * f14, 0.25f * f14, 0.8f * f14, 1.0f);
            GL11.glMatrixMode(5890);
            GL11.glPushMatrix();
            GL11.glScalef(f5, f5, f5);
            float f15 = (float)(xpzm._M() % 3000L) / 3000.0f * 8.0f;
            GL11.glTranslatef(f15, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
            jizq.func_78439_a(htvf2, 0.0f, 0.0f, 1.0f, 1.0f, 255, 255, f13);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(f5, f5, f5);
            f15 = (float)(xpzm._M() % 4873L) / 4873.0f * 8.0f;
            GL11.glTranslatef(-f15, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            jizq.func_78439_a(htvf2, 0.0f, 0.0f, 1.0f, 1.0f, 255, 255, f13);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5888);
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glDepthFunc(515);
        }
    }

    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.doRenderProjectile((EntityProjectile)entity, d, d2, d3, f, f2);
    }

    protected ResourceLocation func_110779_a(EntityProjectile entityProjectile) {
        return entityProjectile.isArrow() ? field_110780_a : this.field_76990_c._g._a(entityProjectile.getItemDisplay()._c());
    }

    @Override
    protected ResourceLocation func_110775_a(Entity entity) {
        return this.func_110779_a((EntityProjectile)entity);
    }
}

