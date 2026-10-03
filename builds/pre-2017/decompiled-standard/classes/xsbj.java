/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.ItemAtlasHooks;
import gloomyfolken.mods.stalker.misc.qlgf;
import java.util.Random;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class xsbj
extends tfvm {
    public static final ResourceLocation field_110798_h = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    public htvc field_77022_g = new htvc();
    public Random field_77025_h = new Random();
    public boolean field_77024_a = true;
    public float field_77023_b;
    public static boolean field_82407_g;

    public xsbj() {
        this.field_76989_e = 0.15f;
        this.field_76987_f = 0.75f;
    }

    public void func_77014_a(EntityItem entityItem, double d, double d2, double d3, float f, float f2) {
        this.func_110777_b(entityItem);
        this.field_77025_h.setSeed(187L);
        cvzo cvzo2 = entityItem.func_92059_d();
        if (cvzo2._a() != null) {
            GL11.glPushMatrix();
            float f3 = this.shouldBob() ? sajh._a(((float)entityItem.field_70292_b + f2) / 10.0f + entityItem.field_70290_d) * 0.1f + 0.1f : 0.0f;
            float f4 = (((float)entityItem.field_70292_b + f2) / 20.0f + entityItem.field_70290_d) * 57.295776f;
            int n = this.getMiniBlockCount(cvzo2);
            GL11.glTranslatef((float)d, (float)d2 + f3, (float)d3);
            GL11.glEnable(32826);
            twgu twgu2 = null;
            if (cvzo2._d < twgu.field_71973_m.length) {
                twgu2 = twgu.field_71973_m[cvzo2._d];
            }
            if (!ForgeHooksClient.renderEntityItem(entityItem, cvzo2, f3, f4, this.field_77025_h, this.field_76990_c._g, this.field_76988_d)) {
                if (cvzo2._c() == 0 && twgu2 != null && htvc._a(twgu.field_71973_m[cvzo2._d].func_71857_b())) {
                    qlgf._a(f4, 0.0f, 1.0f, 0.0f);
                    if (field_82407_g) {
                        GL11.glScalef(1.25f, 1.25f, 1.25f);
                        GL11.glTranslatef(0.0f, 0.05f, 0.0f);
                        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
                    }
                    float f5 = 0.25f;
                    int n2 = twgu2.func_71857_b();
                    if (n2 == 1 || n2 == 19 || n2 == 12 || n2 == 2) {
                        f5 = 0.5f;
                    }
                    GL11.glScalef(f5, f5, f5);
                    for (int i = 0; i < n; ++i) {
                        float f6;
                        GL11.glPushMatrix();
                        if (i > 0) {
                            f6 = (this.field_77025_h.nextFloat() * 2.0f - 1.0f) * 0.2f / f5;
                            float f7 = (this.field_77025_h.nextFloat() * 2.0f - 1.0f) * 0.2f / f5;
                            float f8 = (this.field_77025_h.nextFloat() * 2.0f - 1.0f) * 0.2f / f5;
                            qlgf._a(f6, f7, f8);
                        }
                        f6 = 1.0f;
                        this.field_77022_g._a(twgu2, cvzo2._j(), f6);
                        GL11.glPopMatrix();
                    }
                } else if (cvzo2._a().func_77623_v()) {
                    if (field_82407_g) {
                        GL11.glScalef(0.5128205f, 0.5128205f, 0.5128205f);
                        GL11.glTranslatef(0.0f, -0.05f, 0.0f);
                    } else {
                        GL11.glScalef(0.5f, 0.5f, 0.5f);
                    }
                    for (int i = 0; i < cvzo2._a().getRenderPasses(cvzo2._j()); ++i) {
                        this.field_77025_h.setSeed(187L);
                        dwan dwan2 = cvzo2._a().getIcon(cvzo2, i);
                        float f9 = 1.0f;
                        if (this.field_77024_a) {
                            int n3 = tgdv.field_77698_e[cvzo2._d].func_82790_a(cvzo2, i);
                            float f10 = (float)(n3 >> 16 & 0xFF) / 255.0f;
                            float f11 = (float)(n3 >> 8 & 0xFF) / 255.0f;
                            float f12 = (float)(n3 & 0xFF) / 255.0f;
                            GL11.glColor4f(f10 * f9, f11 * f9, f12 * f9, 1.0f);
                            this.func_77020_a(entityItem, dwan2, n, f2, f10 * f9, f11 * f9, f12 * f9);
                            continue;
                        }
                        this.func_77020_a(entityItem, dwan2, n, f2, 1.0f, 1.0f, 1.0f);
                    }
                } else {
                    if (field_82407_g) {
                        GL11.glScalef(0.5128205f, 0.5128205f, 0.5128205f);
                        GL11.glTranslatef(0.0f, -0.05f, 0.0f);
                    } else {
                        GL11.glScalef(0.5f, 0.5f, 0.5f);
                    }
                    dwan dwan3 = cvzo2._b();
                    if (this.field_77024_a) {
                        int n4 = tgdv.field_77698_e[cvzo2._d].func_82790_a(cvzo2, 0);
                        float f13 = (float)(n4 >> 16 & 0xFF) / 255.0f;
                        float f14 = (float)(n4 >> 8 & 0xFF) / 255.0f;
                        float f15 = (float)(n4 & 0xFF) / 255.0f;
                        float f16 = 1.0f;
                        this.func_77020_a(entityItem, dwan3, n, f2, f13 * f16, f14 * f16, f15 * f16);
                    } else {
                        this.func_77020_a(entityItem, dwan3, n, f2, 1.0f, 1.0f, 1.0f);
                    }
                }
            }
            GL11.glDisable(32826);
            GL11.glPopMatrix();
        }
    }

    public ResourceLocation func_110796_a(EntityItem entityItem) {
        return this.field_76990_c._g._a(entityItem.func_92059_d()._c());
    }

    public void func_77020_a(EntityItem entityItem, dwan dwan2, int n, float f, float f2, float f3, float f4) {
        this.renderDroppedItem(entityItem, dwan2, n, f, f2, f3, f4, 0);
    }

    public void renderDroppedItem(EntityItem entityItem, dwan dwan2, int n, float f, float f2, float f3, float f4, int n2) {
        ItemAtlasHooks.renderDroppedItem(this, entityItem, dwan2, n, f, f2, f3, f4, n2);
        qlgf._b(entityItem);
        htvf htvf2 = htvf.field_78398_a;
        if (dwan2 == null) {
            apbu apbu2 = xpzm._E()._R();
            ResourceLocation resourceLocation = apbu2._a(entityItem.func_92059_d()._c());
            dwan2 = ((sctd)apbu2._b(resourceLocation))._d("missingno");
        }
        float f5 = dwan2.func_94209_e();
        float f6 = dwan2.func_94212_f();
        float f7 = dwan2.func_94206_g();
        float f8 = dwan2.func_94210_h();
        float f9 = 1.0f;
        float f10 = 0.5f;
        float f11 = 0.25f;
        if (this.field_76990_c._n.field_74347_j) {
            GL11.glPushMatrix();
            if (field_82407_g) {
                GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
            } else {
                qlgf._a((((float)entityItem.field_70292_b + f) / 20.0f + entityItem.field_70290_d) * 57.295776f, 0.0f, 1.0f, 0.0f);
            }
            float f12 = 0.0625f;
            float f13 = 0.021875f;
            cvzo cvzo2 = entityItem.func_92059_d();
            int n3 = cvzo2._b;
            int n4 = this.getMiniItemCount(cvzo2);
            GL11.glTranslatef(-f10, -f11, -((f12 + f13) * (float)n4 / 2.0f));
            for (int i = 0; i < n4; ++i) {
                float f14;
                float f15;
                float f16;
                if (i > 0 && this.shouldSpreadItems()) {
                    f16 = (this.field_77025_h.nextFloat() * 2.0f - 1.0f) * 0.3f / 0.5f;
                    f15 = (this.field_77025_h.nextFloat() * 2.0f - 1.0f) * 0.3f / 0.5f;
                    f14 = (this.field_77025_h.nextFloat() * 2.0f - 1.0f) * 0.3f / 0.5f;
                    GL11.glTranslatef(f16, f15, f12 + f13);
                } else {
                    GL11.glTranslatef(0.0f, 0.0f, f12 + f13);
                }
                if (cvzo2._c() == 0) {
                    this.func_110776_a(sctd._c);
                } else {
                    this.func_110776_a(sctd._e);
                }
                GL11.glColor4f(f2, f3, f4, 1.0f);
                jizq.func_78439_a(htvf2, f6, f7, f5, f8, dwan2.func_94211_a(), dwan2.func_94216_b(), f12);
                if (!cvzo2._c(n2)) continue;
                GL11.glDepthFunc(514);
                GL11.glDisable(2896);
                this.field_76990_c._g._a(field_110798_h);
                GL11.glEnable(3042);
                GL11.glBlendFunc(768, 1);
                f16 = 0.76f;
                GL11.glColor4f(0.5f * f16, 0.25f * f16, 0.8f * f16, 1.0f);
                GL11.glMatrixMode(5890);
                GL11.glPushMatrix();
                f15 = 0.125f;
                GL11.glScalef(f15, f15, f15);
                f14 = (float)(xpzm._M() % 3000L) / 3000.0f * 8.0f;
                GL11.glTranslatef(f14, 0.0f, 0.0f);
                GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
                jizq.func_78439_a(htvf2, 0.0f, 0.0f, 1.0f, 1.0f, 255, 255, f12);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef(f15, f15, f15);
                f14 = (float)(xpzm._M() % 4873L) / 4873.0f * 8.0f;
                GL11.glTranslatef(-f14, 0.0f, 0.0f);
                GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
                jizq.func_78439_a(htvf2, 0.0f, 0.0f, 1.0f, 1.0f, 255, 255, f12);
                GL11.glPopMatrix();
                GL11.glMatrixMode(5888);
                GL11.glDisable(3042);
                GL11.glEnable(2896);
                GL11.glDepthFunc(515);
            }
            GL11.glPopMatrix();
        } else {
            for (int i = 0; i < n; ++i) {
                GL11.glPushMatrix();
                if (i > 0) {
                    float f17 = (this.field_77025_h.nextFloat() * 2.0f - 1.0f) * 0.3f;
                    float f18 = (this.field_77025_h.nextFloat() * 2.0f - 1.0f) * 0.3f;
                    float f19 = (this.field_77025_h.nextFloat() * 2.0f - 1.0f) * 0.3f;
                    GL11.glTranslatef(f17, f18, f19);
                }
                if (!field_82407_g) {
                    GL11.glRotatef(180.0f - this.field_76990_c._l, 0.0f, 1.0f, 0.0f);
                }
                GL11.glColor4f(f2, f3, f4, 1.0f);
                htvf2.func_78382_b();
                htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
                htvf2.func_78374_a(0.0f - f10, 0.0f - f11, 0.0, f5, f8);
                htvf2.func_78374_a(f9 - f10, 0.0f - f11, 0.0, f6, f8);
                htvf2.func_78374_a(f9 - f10, 1.0f - f11, 0.0, f6, f7);
                htvf2.func_78374_a(0.0f - f10, 1.0f - f11, 0.0, f5, f7);
                htvf2.func_78381_a();
                GL11.glPopMatrix();
            }
        }
        qlgf._c(entityItem);
    }

    public void func_77015_a(qncw qncw2, apbu apbu2, cvzo cvzo2, int n, int n2) {
        this.renderItemIntoGUI(qncw2, apbu2, cvzo2, n, n2, false);
    }

    public void renderItemIntoGUI(qncw qncw2, apbu apbu2, cvzo cvzo2, int n, int n2, boolean bl) {
        twgu twgu2;
        qlgf._a(this, qncw2, apbu2, cvzo2, n, n2, bl);
        ItemAtlasHooks.renderItemIntoGUI(this, qncw2, apbu2, cvzo2, n, n2, bl);
        int n3 = cvzo2._d;
        int n4 = cvzo2._j();
        dwan dwan2 = cvzo2._b();
        twgu twgu3 = twgu2 = n3 < twgu.field_71973_m.length ? twgu.field_71973_m[n3] : null;
        if (cvzo2._c() == 0 && twgu2 != null && htvc._a(twgu.field_71973_m[n3].func_71857_b())) {
            apbu2._a(sctd._c);
            GL11.glPushMatrix();
            GL11.glTranslatef(n - 2, n2 + 3, -3.0f + this.field_77023_b);
            GL11.glScalef(10.0f, 10.0f, 10.0f);
            GL11.glTranslatef(1.0f, 0.5f, 1.0f);
            GL11.glScalef(1.0f, 1.0f, -1.0f);
            GL11.glRotatef(210.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            int n5 = tgdv.field_77698_e[n3].func_82790_a(cvzo2, 0);
            float f = (float)(n5 >> 16 & 0xFF) / 255.0f;
            float f2 = (float)(n5 >> 8 & 0xFF) / 255.0f;
            float f3 = (float)(n5 & 0xFF) / 255.0f;
            if (this.field_77024_a) {
                GL11.glColor4f(f, f2, f3, 1.0f);
            }
            GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            this.field_77022_g._g = this.field_77024_a;
            this.field_77022_g._a(twgu2, n4, 1.0f);
            this.field_77022_g._g = true;
            GL11.glPopMatrix();
        } else if (tgdv.field_77698_e[n3].func_77623_v()) {
            GL11.glDisable(2896);
            for (int i = 0; i < tgdv.field_77698_e[n3].getRenderPasses(n4); ++i) {
                apbu2._a(cvzo2._c() == 0 ? sctd._c : sctd._e);
                dwan dwan3 = tgdv.field_77698_e[n3].getIcon(cvzo2, i);
                int n6 = tgdv.field_77698_e[n3].func_82790_a(cvzo2, i);
                float f = (float)(n6 >> 16 & 0xFF) / 255.0f;
                float f4 = (float)(n6 >> 8 & 0xFF) / 255.0f;
                float f5 = (float)(n6 & 0xFF) / 255.0f;
                if (this.field_77024_a) {
                    GL11.glColor4f(f, f4, f5, 1.0f);
                }
                this.func_94149_a(n, n2, dwan3, 16, 16);
                if (!cvzo2._c(i)) continue;
                this.renderEffect(apbu2, n, n2);
            }
            GL11.glEnable(2896);
        } else {
            GL11.glDisable(2896);
            ResourceLocation resourceLocation = apbu2._a(cvzo2._c());
            apbu2._a(resourceLocation);
            if (dwan2 == null) {
                dwan2 = ((sctd)xpzm._E()._R()._b(resourceLocation))._d("missingno");
            }
            int n7 = tgdv.field_77698_e[n3].func_82790_a(cvzo2, 0);
            float f = (float)(n7 >> 16 & 0xFF) / 255.0f;
            float f6 = (float)(n7 >> 8 & 0xFF) / 255.0f;
            float f7 = (float)(n7 & 0xFF) / 255.0f;
            if (this.field_77024_a) {
                GL11.glColor4f(f, f6, f7, 1.0f);
            }
            this.func_94149_a(n, n2, dwan2, 16, 16);
            GL11.glEnable(2896);
            if (cvzo2._c(0)) {
                this.renderEffect(apbu2, n, n2);
            }
        }
        GL11.glEnable(2884);
        qlgf._b(this, qncw2, apbu2, cvzo2, n, n2, bl);
    }

    public void renderEffect(apbu apbu2, int n, int n2) {
        GL11.glDepthFunc(516);
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        apbu2._a(field_110798_h);
        this.field_77023_b -= 50.0f;
        GL11.glEnable(3042);
        GL11.glBlendFunc(774, 774);
        GL11.glColor4f(0.5f, 0.25f, 0.8f, 1.0f);
        this.func_77018_a(n * 431278612 + n2 * 32178161, n - 2, n2 - 2, 20, 20);
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
        this.field_77023_b += 50.0f;
        GL11.glEnable(2896);
        GL11.glDepthFunc(515);
    }

    public void func_82406_b(qncw qncw2, apbu apbu2, cvzo cvzo2, int n, int n2) {
        if (cvzo2 != null && !ForgeHooksClient.renderInventoryItem(this.field_76988_d, apbu2, cvzo2, this.field_77024_a, this.field_77023_b, n, n2)) {
            this.renderItemIntoGUI(qncw2, apbu2, cvzo2, n, n2, true);
        }
    }

    public void func_77018_a(int n, int n2, int n3, int n4, int n5) {
        for (int i = 0; i < 2; ++i) {
            if (i == 0) {
                GL11.glBlendFunc(768, 1);
            }
            if (i == 1) {
                GL11.glBlendFunc(768, 1);
            }
            float f = 0.00390625f;
            float f2 = 0.00390625f;
            float f3 = (float)(xpzm._M() % (long)(3000 + i * 1873)) / (3000.0f + (float)(i * 1873)) * 256.0f;
            float f4 = 0.0f;
            htvf htvf2 = htvf.field_78398_a;
            float f5 = 4.0f;
            if (i == 1) {
                f5 = -1.0f;
            }
            htvf2.func_78382_b();
            htvf2.func_78374_a(n2 + 0, n3 + n5, this.field_77023_b, (f3 + (float)n5 * f5) * f, (f4 + (float)n5) * f2);
            htvf2.func_78374_a(n2 + n4, n3 + n5, this.field_77023_b, (f3 + (float)n4 + (float)n5 * f5) * f, (f4 + (float)n5) * f2);
            htvf2.func_78374_a(n2 + n4, n3 + 0, this.field_77023_b, (f3 + (float)n4) * f, (f4 + 0.0f) * f2);
            htvf2.func_78374_a(n2 + 0, n3 + 0, this.field_77023_b, (f3 + 0.0f) * f, (f4 + 0.0f) * f2);
            htvf2.func_78381_a();
        }
    }

    public void func_77021_b(qncw qncw2, apbu apbu2, cvzo cvzo2, int n, int n2) {
        this.func_94148_a(qncw2, apbu2, cvzo2, n, n2, null);
    }

    public void func_94148_a(qncw qncw2, apbu apbu2, cvzo cvzo2, int n, int n2, String string) {
        if (cvzo2 != null) {
            if (cvzo2._b > 1 || string != null) {
                String string2 = string == null ? String.valueOf(cvzo2._b) : string;
                GL11.glDisable(2896);
                GL11.glDisable(2929);
                qncw2._a(string2, n + 19 - 2 - qncw2._b(string2), n2 + 6 + 3, 0xFFFFFF);
                GL11.glEnable(2896);
                GL11.glEnable(2929);
            }
            if (cvzo2._h()) {
                int n3 = (int)Math.round(13.0 - (double)cvzo2._i() * 13.0 / (double)cvzo2._k());
                int n4 = (int)Math.round(255.0 - (double)cvzo2._i() * 255.0 / (double)cvzo2._k());
                GL11.glDisable(2896);
                GL11.glDisable(2929);
                GL11.glDisable(3553);
                htvf htvf2 = htvf.field_78398_a;
                int n5 = 255 - n4 << 16 | n4 << 8;
                int n6 = (255 - n4) / 4 << 16 | 0x3F00;
                this.func_77017_a(htvf2, n + 2, n2 + 13, 13, 2, 0);
                this.func_77017_a(htvf2, n + 2, n2 + 13, 12, 1, n6);
                this.func_77017_a(htvf2, n + 2, n2 + 13, n3, 1, n5);
                GL11.glEnable(3553);
                GL11.glEnable(2896);
                GL11.glEnable(2929);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            }
        }
    }

    public void func_77017_a(htvf htvf2, int n, int n2, int n3, int n4, int n5) {
        htvf2.func_78382_b();
        htvf2.func_78378_d(n5);
        htvf2.func_78377_a(n + 0, n2 + 0, 0.0);
        htvf2.func_78377_a(n + 0, n2 + n4, 0.0);
        htvf2.func_78377_a(n + n3, n2 + n4, 0.0);
        htvf2.func_78377_a(n + n3, n2 + 0, 0.0);
        htvf2.func_78381_a();
    }

    public void func_94149_a(int n, int n2, dwan dwan2, int n3, int n4) {
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78374_a(n + 0, n2 + n4, this.field_77023_b, dwan2.func_94209_e(), dwan2.func_94210_h());
        htvf2.func_78374_a(n + n3, n2 + n4, this.field_77023_b, dwan2.func_94212_f(), dwan2.func_94210_h());
        htvf2.func_78374_a(n + n3, n2 + 0, this.field_77023_b, dwan2.func_94212_f(), dwan2.func_94206_g());
        htvf2.func_78374_a(n + 0, n2 + 0, this.field_77023_b, dwan2.func_94209_e(), dwan2.func_94206_g());
        htvf2.func_78381_a();
    }

    @Override
    public ResourceLocation func_110775_a(Entity entity) {
        return this.func_110796_a((EntityItem)entity);
    }

    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this.func_77014_a((EntityItem)entity, d, d2, d3, f, f2);
    }

    public boolean shouldSpreadItems() {
        return true;
    }

    public boolean shouldBob() {
        return !qlgf._a();
    }

    public byte getMiniBlockCount(cvzo cvzo2) {
        byte by = 1;
        if (cvzo2._b > 1) {
            by = 2;
        }
        if (cvzo2._b > 5) {
            by = 3;
        }
        if (cvzo2._b > 20) {
            by = 4;
        }
        if (cvzo2._b > 40) {
            by = 5;
        }
        return by;
    }

    public byte getMiniItemCount(cvzo cvzo2) {
        byte by = 1;
        if (cvzo2._b > 1) {
            by = 2;
        }
        if (cvzo2._b > 15) {
            by = 3;
        }
        if (cvzo2._b > 31) {
            by = 4;
        }
        return by;
    }
}

