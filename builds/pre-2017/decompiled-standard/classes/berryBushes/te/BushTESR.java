/*
 * Decompiled with CFR 0.152.
 */
package berryBushes.te;

import berryBushes.te.BushTE;
import berryBushes.te.bush;
import java.lang.reflect.InvocationTargetException;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import org.lwjgl.opengl.GL11;

public class BushTESR
extends htys {
    private static final bush b = new bush();
    private static final ResourceLocation glint = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    private static final ResourceLocation loc = new ResourceLocation("berries:bush.png");

    @Override
    public void func_76894_a(hurg hurg2, double d, double d2, double d3, float f) {
        if (hurg2 != null && hurg2 instanceof BushTE) {
            float f2;
            float f3;
            float f4;
            float f5;
            BushTE bushTE = (BushTE)hurg2;
            this.func_110628_a(loc);
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d + 0.4f, (float)d2 + 1.5f, (float)d3 + 0.5f);
            GL11.glScalef(1.0f, -1.0f, -1.0f);
            if (!bushTE.isCrop) {
                f5 = 0.8f;
                f4 = 1.2f;
                f3 = 1.3f;
                switch (bushTE.Meta) {
                    case 0: {
                        GL11.glTranslatef(0.0f, 0.3f, 0.0f);
                        GL11.glScalef(f5, f5, f5);
                        break;
                    }
                    case 1: {
                        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
                        GL11.glScalef(1.0f, 1.0f, 1.0f);
                        break;
                    }
                    case 2: {
                        GL11.glTranslatef(0.0f, -0.3f, 0.0f);
                        GL11.glScalef(f4, f4, f4);
                        break;
                    }
                    case 3: {
                        GL11.glTranslatef(0.0f, -0.45f, 0.0f);
                        GL11.glScalef(f3, f3, f3);
                        break;
                    }
                }
            } else {
                f5 = 1.35f;
                f4 = -0.9f;
                f3 = -f4 + f5;
                GL11.glTranslatef(0.0f, f5 - bushTE.count / 24000.0f * f3, -0.1f);
                f2 = 0.1f + bushTE.count / 16000.0f;
                GL11.glScalef(f2, f2, f2);
            }
            b.render(0.0625f);
            GL11.glPopMatrix();
            if (bushTE.isCrop) {
                GL11.glPushMatrix();
                GL11.glTranslatef((float)d + 0.5f, (float)d2 + 0.8f, (float)d3 + 0.5f);
                GL11.glEnable(32826);
                GL11.glTranslatef(0.0f, 0.0f, 0.0f);
                if (bushTE.stack != null && tgdv.field_77698_e[bushTE.stack._d] != null) {
                    this.bindTextureMap(bushTE.stack);
                    GL11.glPushMatrix();
                    f5 = 0.5f;
                    try {
                        int n;
                        GL11.glScalef(f5, f5, f5);
                        f4 = -1.5f;
                        f3 = -0.7f;
                        f2 = 0.1f;
                        float f6 = -1.0f;
                        float f7 = -f3 + f4;
                        float f8 = -f6 + f2;
                        GL11.glTranslatef(-0.1f, f4 - bushTE.count / 24000.0f * f7, f2 - bushTE.count / 24000.0f * f8);
                        float f9 = 0.1f + bushTE.count / 30000.0f;
                        GL11.glScalef(f9, f9, f9);
                        if (bushTE.stack._a().func_77623_v()) {
                            for (n = 0; n <= 1; ++n) {
                                this.drawItem(bushTE.stack, n);
                            }
                        } else {
                            this.drawItem(bushTE.stack, 0);
                        }
                        GL11.glTranslatef(0.0f, 0.0f, 2.2f);
                        GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
                        if (bushTE.stack._a().func_77623_v()) {
                            for (n = 0; n <= 1; ++n) {
                                this.drawItem(bushTE.stack, n);
                            }
                        } else {
                            this.drawItem(bushTE.stack, 0);
                        }
                    }
                    catch (Throwable throwable) {
                        throw new RuntimeException(throwable);
                    }
                    GL11.glPopMatrix();
                }
                GL11.glDisable(32826);
                GL11.glPopMatrix();
            }
        }
    }

    private void bindTextureMap(cvzo cvzo2) {
        this.func_110628_a(gqqu._b._g._a(cvzo2._c()));
    }

    private void drawItem(cvzo cvzo2, int n) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        dwan dwan2 = cvzo2._a().func_77618_c(cvzo2._j(), n);
        if (!(dwan2 instanceof dhji)) {
            return;
        }
        dhji dhji2 = (dhji)dwan2;
        GL11.glPushMatrix();
        htvf htvf2 = htvf.field_78398_a;
        float f = dwan2.func_94209_e();
        float f2 = dwan2.func_94212_f();
        float f3 = dwan2.func_94206_g();
        float f4 = dwan2.func_94210_h();
        float f5 = 0.5f;
        float f6 = 0.25f;
        float f7 = 0.0625f;
        float f8 = 0.021875f;
        int n2 = cvzo2._b;
        int n3 = n2 < 2 ? 1 : (n2 < 16 ? 2 : (n2 < 32 ? 3 : 4));
        GL11.glTranslatef(-f5, -f6, -((f7 + f8) * (float)n3 / 2.0f));
        for (int i = 0; i < n3; ++i) {
            GL11.glTranslatef(0.0f, 0.0f, f7 + f8);
            this.bindTextureMap(cvzo2);
            int n4 = tgdv.field_77698_e[cvzo2._d].func_82790_a(cvzo2, n);
            float f9 = (float)(n4 >> 16 & 0xFF) / 255.0f;
            float f10 = (float)(n4 >> 8 & 0xFF) / 255.0f;
            float f11 = (float)(n4 & 0xFF) / 255.0f;
            GL11.glColor4f(f9, f10, f11, 1.0f);
            jizq.func_78439_a(htvf2, f2, f3, f, f4, dhji2.func_94216_b(), dhji2.func_94211_a(), 0.0625f);
            if (cvzo2 == null || !cvzo2._v() || n != 0) continue;
            GL11.glDepthFunc(514);
            GL11.glDisable(2896);
            this.func_110628_a(glint);
            GL11.glEnable(3042);
            GL11.glBlendFunc(768, 1);
            float f12 = 0.76f;
            GL11.glColor4f(0.5f * f12, 0.25f * f12, 0.8f * f12, 1.0f);
            GL11.glMatrixMode(5890);
            GL11.glPushMatrix();
            float f13 = 0.125f;
            GL11.glScalef(f13, f13, f13);
            float f14 = (float)(xpzm._M() % 3000L) / 3000.0f * 8.0f;
            GL11.glTranslatef(f14, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
            jizq.func_78439_a(htvf2, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(f13, f13, f13);
            f14 = (float)(xpzm._M() % 4873L) / 4873.0f * 8.0f;
            GL11.glTranslatef(-f14, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            jizq.func_78439_a(htvf2, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5888);
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glDepthFunc(515);
        }
        GL11.glPopMatrix();
    }
}

