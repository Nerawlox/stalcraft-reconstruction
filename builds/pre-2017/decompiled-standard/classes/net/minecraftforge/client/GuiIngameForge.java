/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client;

import cpw.mods.fml.common.FMLCommonHandler;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.crash.jxtc;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.eidj;
import net.minecraft.entity.sajz;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.eifc;
import net.minecraft.util.ezfc;
import net.minecraft.util.sajh;
import net.minecraft.util.tdmn;
import net.minecraft.util.tdpx;
import net.minecraft.util.ugqx;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

public class GuiIngameForge
extends stiq {
    private static final ResourceLocation VIGNETTE = new ResourceLocation("textures/misc/vignette.png");
    private static final ResourceLocation WIDGITS = new ResourceLocation("textures/gui/widgets.png");
    private static final ResourceLocation PUMPKIN_BLUR = new ResourceLocation("textures/misc/pumpkinblur.png");
    private static final int WHITE = 0xFFFFFF;
    public static boolean renderHelmet = true;
    public static boolean renderPortal = true;
    public static boolean renderHotbar = true;
    public static boolean renderCrosshairs = true;
    public static boolean renderBossHealth = true;
    public static boolean renderHealth = true;
    public static boolean renderArmor = true;
    public static boolean renderFood = true;
    public static boolean renderHealthMount = true;
    public static boolean renderAir = true;
    public static boolean renderExperiance = true;
    public static boolean renderJumpBar = true;
    public static boolean renderObjective = true;
    public static int left_height = 39;
    public static int right_height = 39;
    private htou res = null;
    private qncw fontrenderer = null;
    private RenderGameOverlayEvent eventParent;
    private static final String MC_VERSION = new jxtc(null)._a();

    public GuiIngameForge(xpzm xpzm2) {
        super(xpzm2);
    }

    @Override
    public void func_73830_a(float f, boolean bl, int n, int n2) {
        this.res = new htou(this.field_73839_d._M, this.field_73839_d._n, this.field_73839_d._o);
        this.eventParent = new RenderGameOverlayEvent(f, this.res, n, n2);
        int n3 = this.res._a();
        int n4 = this.res._b();
        renderHealthMount = this.field_73839_d._t.field_70154_o instanceof EntityLivingBase;
        renderFood = this.field_73839_d._t.field_70154_o == null;
        renderJumpBar = this.field_73839_d._t.func_110317_t();
        right_height = 39;
        left_height = 39;
        if (this.pre(RenderGameOverlayEvent.ElementType.ALL)) {
            return;
        }
        this.fontrenderer = this.field_73839_d._z;
        this.field_73839_d._D.func_78478_c();
        GL11.glEnable(3042);
        if (xpzm._B()) {
            this.func_73829_a(this.field_73839_d._t.func_70013_c(f), n3, n4);
        } else {
            GL11.glBlendFunc(770, 771);
        }
        if (renderHelmet) {
            this.renderHelmet(this.res, f, bl, n, n2);
        }
        if (renderPortal && !this.field_73839_d._t.func_70644_a(hdpq._k)) {
            this.renderPortal(n3, n4, f);
        }
        if (!this.field_73839_d._j._a()) {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.field_73735_i = -90.0f;
            this.field_73842_c.setSeed(this.field_73837_f * 312871);
            if (renderCrosshairs) {
                this.renderCrosshairs(n3, n4);
            }
            if (renderBossHealth) {
                this.func_73828_d();
            }
            if (this.field_73839_d._j._b()) {
                if (renderHealth) {
                    this.renderHealth(n3, n4);
                }
                if (renderArmor) {
                    this.renderArmor(n3, n4);
                }
                if (renderFood) {
                    this.renderFood(n3, n4);
                }
                if (renderHealthMount) {
                    this.renderHealthMount(n3, n4);
                }
                if (renderAir) {
                    this.renderAir(n3, n4);
                }
            }
            if (renderHotbar) {
                this.renderHotbar(n3, n4, f);
            }
        }
        if (renderJumpBar) {
            this.renderJumpBar(n3, n4);
        } else if (renderExperiance) {
            this.renderExperience(n3, n4);
        }
        this.renderSleepFade(n3, n4);
        this.renderToolHightlight(n3, n4);
        this.renderHUDText(n3, n4);
        this.renderRecordOverlay(n3, n4, f);
        igri igri2 = this.field_73839_d._r.func_96441_U()._a(1);
        if (renderObjective && igri2 != null) {
            this.func_96136_a(igri2, n4, n3, this.fontrenderer);
        }
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        this.renderChat(n3, n4);
        this.renderPlayerList(n3, n4);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        GL11.glEnable(3008);
        this.post(RenderGameOverlayEvent.ElementType.ALL);
    }

    public htou getResolution() {
        return this.res;
    }

    protected void renderHotbar(int n, int n2, float f) {
        if (this.pre(RenderGameOverlayEvent.ElementType.HOTBAR)) {
            return;
        }
        this.field_73839_d.__ah._a("actionBar");
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73839_d._h._a(WIDGITS);
        eidj eidj2 = this.field_73839_d._t.field_71071_by;
        this.func_73729_b(n / 2 - 91, n2 - 22, 0, 0, 182, 22);
        this.func_73729_b(n / 2 - 91 - 1 + eidj2._c * 20, n2 - 22 - 1, 0, 22, 24, 22);
        GL11.glDisable(3042);
        GL11.glEnable(32826);
        qnon._c();
        for (int i = 0; i < 9; ++i) {
            int n3 = n / 2 - 90 + i * 20 + 2;
            int n4 = n2 - 16 - 3;
            this.func_73832_a(i, n3, n4, f);
        }
        qnon._a();
        GL11.glDisable(32826);
        this.field_73839_d.__ah._b();
        this.post(RenderGameOverlayEvent.ElementType.HOTBAR);
    }

    protected void renderCrosshairs(int n, int n2) {
        if (this.pre(RenderGameOverlayEvent.ElementType.CROSSHAIRS)) {
            return;
        }
        this.bind(bawa.field_110324_m);
        GL11.glEnable(3042);
        GL11.glBlendFunc(775, 769);
        this.func_73729_b(n / 2 - 7, n2 / 2 - 7, 0, 0, 16, 16);
        GL11.glDisable(3042);
        this.post(RenderGameOverlayEvent.ElementType.CROSSHAIRS);
    }

    @Override
    protected void func_73828_d() {
        if (this.pre(RenderGameOverlayEvent.ElementType.BOSSHEALTH)) {
            return;
        }
        this.field_73839_d.__ah._a("bossHealth");
        super.func_73828_d();
        this.field_73839_d.__ah._b();
        this.post(RenderGameOverlayEvent.ElementType.BOSSHEALTH);
    }

    private void renderHelmet(htou htou2, float f, boolean bl, int n, int n2) {
        if (this.pre(RenderGameOverlayEvent.ElementType.HELMET)) {
            return;
        }
        cvzo cvzo2 = this.field_73839_d._t.field_71071_by._e(3);
        if (this.field_73839_d._M.field_74320_O == 0 && cvzo2 != null && cvzo2._a() != null) {
            if (cvzo2._d == twgu.field_72061_ba.field_71990_ca) {
                this.func_73836_a(htou2._a(), htou2._b());
            } else {
                cvzo2._a().renderHelmetOverlay(cvzo2, this.field_73839_d._t, htou2, f, bl, n, n2);
            }
        }
        this.post(RenderGameOverlayEvent.ElementType.HELMET);
    }

    protected void renderArmor(int n, int n2) {
        if (this.pre(RenderGameOverlayEvent.ElementType.ARMOR)) {
            return;
        }
        this.field_73839_d.__ah._a("armor");
        int n3 = n / 2 - 91;
        int n4 = n2 - left_height;
        int n5 = ForgeHooks.getTotalArmorValue(this.field_73839_d._t);
        for (int i = 1; n5 > 0 && i < 20; i += 2) {
            if (i < n5) {
                this.func_73729_b(n3, n4, 34, 9, 9, 9);
            } else if (i == n5) {
                this.func_73729_b(n3, n4, 25, 9, 9, 9);
            } else if (i > n5) {
                this.func_73729_b(n3, n4, 16, 9, 9, 9);
            }
            n3 += 8;
        }
        left_height += 10;
        this.field_73839_d.__ah._b();
        this.post(RenderGameOverlayEvent.ElementType.ARMOR);
    }

    protected void renderPortal(int n, int n2, float f) {
        if (this.pre(RenderGameOverlayEvent.ElementType.PORTAL)) {
            return;
        }
        float f2 = this.field_73839_d._t.field_71080_cy + (this.field_73839_d._t.field_71086_bY - this.field_73839_d._t.field_71080_cy) * f;
        if (f2 > 0.0f) {
            this.func_130015_b(f2, n, n2);
        }
        this.post(RenderGameOverlayEvent.ElementType.PORTAL);
    }

    protected void renderAir(int n, int n2) {
        if (this.pre(RenderGameOverlayEvent.ElementType.AIR)) {
            return;
        }
        this.field_73839_d.__ah._a("air");
        int n3 = n / 2 + 91;
        int n4 = n2 - right_height;
        if (this.field_73839_d._t.func_70055_a(tflj._h)) {
            int n5 = this.field_73839_d._t.func_70086_ai();
            int n6 = sajh._e((double)(n5 - 2) * 10.0 / 300.0);
            int n7 = sajh._e((double)n5 * 10.0 / 300.0) - n6;
            for (int i = 0; i < n6 + n7; ++i) {
                this.func_73729_b(n3 - i * 8 - 9, n4, i < n6 ? 16 : 25, 18, 9, 9);
            }
            right_height += 10;
        }
        this.field_73839_d.__ah._b();
        this.post(RenderGameOverlayEvent.ElementType.AIR);
    }

    public void renderHealth(int n, int n2) {
        boolean bl;
        this.bind(field_110324_m);
        if (this.pre(RenderGameOverlayEvent.ElementType.HEALTH)) {
            return;
        }
        this.field_73839_d.__ah._a("health");
        boolean bl2 = bl = this.field_73839_d._t.field_70172_ad / 3 % 2 == 1;
        if (this.field_73839_d._t.field_70172_ad < 10) {
            bl = false;
        }
        hubf hubf2 = this.field_73839_d._t.func_110148_a(sajz._a);
        int n3 = sajh._f(this.field_73839_d._t.func_110143_aJ());
        int n4 = sajh._f(this.field_73839_d._t.field_70735_aL);
        float f = (float)hubf2._e();
        float f2 = this.field_73839_d._t.func_110139_bj();
        int n5 = sajh._f((f + f2) / 2.0f / 10.0f);
        int n6 = Math.max(10 - (n5 - 2), 3);
        this.field_73842_c.setSeed(this.field_73837_f * 312871);
        int n7 = n / 2 - 91;
        int n8 = n2 - left_height;
        left_height += n5 * n6;
        if (n6 != 10) {
            left_height += 10 - n6;
        }
        int n9 = -1;
        if (this.field_73839_d._t.func_70644_a(hdpq._l)) {
            n9 = this.field_73837_f % 25;
        }
        int n10 = 9 * (this.field_73839_d._r.func_72912_H()._t() ? 5 : 0);
        int n11 = bl ? 25 : 16;
        int n12 = 16;
        if (this.field_73839_d._t.func_70644_a(hdpq._u)) {
            n12 += 36;
        } else if (this.field_73839_d._t.func_70644_a(hdpq._v)) {
            n12 += 72;
        }
        float f3 = f2;
        for (int i = sajh._f((f + f2) / 2.0f) - 1; i >= 0; --i) {
            boolean bl3 = bl;
            int n13 = sajh._f((float)(i + 1) / 10.0f) - 1;
            int n14 = n7 + i % 10 * 8;
            int n15 = n8 - n13 * n6;
            if (n3 <= 4) {
                n15 += this.field_73842_c.nextInt(2);
            }
            if (i == n9) {
                n15 -= 2;
            }
            this.func_73729_b(n14, n15, n11, n10, 9, 9);
            if (bl) {
                if (i * 2 + 1 < n4) {
                    this.func_73729_b(n14, n15, n12 + 54, n10, 9, 9);
                } else if (i * 2 + 1 == n4) {
                    this.func_73729_b(n14, n15, n12 + 63, n10, 9, 9);
                }
            }
            if (f3 > 0.0f) {
                if (f3 == f2 && f2 % 2.0f == 1.0f) {
                    this.func_73729_b(n14, n15, n12 + 153, n10, 9, 9);
                } else {
                    this.func_73729_b(n14, n15, n12 + 144, n10, 9, 9);
                }
                f3 -= 2.0f;
                continue;
            }
            if (i * 2 + 1 < n3) {
                this.func_73729_b(n14, n15, n12 + 36, n10, 9, 9);
                continue;
            }
            if (i * 2 + 1 != n3) continue;
            this.func_73729_b(n14, n15, n12 + 45, n10, 9, 9);
        }
        this.field_73839_d.__ah._b();
        this.post(RenderGameOverlayEvent.ElementType.HEALTH);
    }

    public void renderFood(int n, int n2) {
        if (this.pre(RenderGameOverlayEvent.ElementType.FOOD)) {
            return;
        }
        this.field_73839_d.__ah._a("food");
        int n3 = n / 2 + 91;
        int n4 = n2 - right_height;
        right_height += 10;
        boolean bl = false;
        tdmn tdmn2 = this.field_73839_d._t.func_71024_bL();
        int n5 = tdmn2._a();
        int n6 = tdmn2._b();
        for (int i = 0; i < 10; ++i) {
            int n7 = i * 2 + 1;
            int n8 = n3 - i * 8 - 9;
            int n9 = n4;
            int n10 = 16;
            int n11 = 0;
            if (this.field_73839_d._t.func_70644_a(hdpq._s)) {
                n10 += 36;
                n11 = 13;
            }
            if (bl) {
                n11 = 1;
            }
            if (this.field_73839_d._t.func_71024_bL()._d() <= 0.0f && this.field_73837_f % (n5 * 3 + 1) == 0) {
                n9 = n4 + (this.field_73842_c.nextInt(3) - 1);
            }
            this.func_73729_b(n8, n9, 16 + n11 * 9, 27, 9, 9);
            if (bl) {
                if (n7 < n6) {
                    this.func_73729_b(n8, n9, n10 + 54, 27, 9, 9);
                } else if (n7 == n6) {
                    this.func_73729_b(n8, n9, n10 + 63, 27, 9, 9);
                }
            }
            if (n7 < n5) {
                this.func_73729_b(n8, n9, n10 + 36, 27, 9, 9);
                continue;
            }
            if (n7 != n5) continue;
            this.func_73729_b(n8, n9, n10 + 45, 27, 9, 9);
        }
        this.field_73839_d.__ah._b();
        this.post(RenderGameOverlayEvent.ElementType.FOOD);
    }

    protected void renderSleepFade(int n, int n2) {
        if (this.field_73839_d._t.func_71060_bI() > 0) {
            this.field_73839_d.__ah._a("sleep");
            GL11.glDisable(2929);
            GL11.glDisable(3008);
            int n3 = this.field_73839_d._t.func_71060_bI();
            float f = (float)n3 / 100.0f;
            if (f > 1.0f) {
                f = 1.0f - (float)(n3 - 100) / 10.0f;
            }
            int n4 = (int)(220.0f * f) << 24 | 0x101020;
            GuiIngameForge.func_73734_a(0, 0, n, n2, n4);
            GL11.glEnable(3008);
            GL11.glEnable(2929);
            this.field_73839_d.__ah._b();
        }
    }

    protected void renderExperience(int n, int n2) {
        this.bind(field_110324_m);
        if (this.pre(RenderGameOverlayEvent.ElementType.EXPERIENCE)) {
            return;
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        if (this.field_73839_d._j._g()) {
            int n3;
            int n4;
            this.field_73839_d.__ah._a("expBar");
            int n5 = this.field_73839_d._t.func_71050_bK();
            int n6 = n / 2 - 91;
            if (n5 > 0) {
                n4 = 182;
                n3 = (int)(this.field_73839_d._t.field_71106_cc * (float)(n4 + 1));
                int n7 = n2 - 32 + 3;
                this.func_73729_b(n6, n7, 0, 64, n4, 5);
                if (n3 > 0) {
                    this.func_73729_b(n6, n7, 0, 69, n3, 5);
                }
            }
            this.field_73839_d.__ah._b();
            if (this.field_73839_d._j._g() && this.field_73839_d._t.field_71068_ca > 0) {
                this.field_73839_d.__ah._a("expLevel");
                n4 = 0;
                n3 = n4 != 0 ? 0xFFFFFF : 8453920;
                String string = "" + this.field_73839_d._t.field_71068_ca;
                int n8 = (n - this.fontrenderer._b(string)) / 2;
                int n9 = n2 - 31 - 4;
                this.fontrenderer._b(string, n8 + 1, n9, 0);
                this.fontrenderer._b(string, n8 - 1, n9, 0);
                this.fontrenderer._b(string, n8, n9 + 1, 0);
                this.fontrenderer._b(string, n8, n9 - 1, 0);
                this.fontrenderer._b(string, n8, n9, n3);
                this.field_73839_d.__ah._b();
            }
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.post(RenderGameOverlayEvent.ElementType.EXPERIENCE);
    }

    protected void renderJumpBar(int n, int n2) {
        this.bind(field_110324_m);
        if (this.pre(RenderGameOverlayEvent.ElementType.JUMPBAR)) {
            return;
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73839_d.__ah._a("jumpBar");
        float f = this.field_73839_d._t.func_110319_bJ();
        int n3 = 182;
        int n4 = n / 2 - 91;
        int n5 = (int)(f * 183.0f);
        int n6 = n2 - 32 + 3;
        this.func_73729_b(n4, n6, 0, 84, 182, 5);
        if (n5 > 0) {
            this.func_73729_b(n4, n6, 0, 89, n5, 5);
        }
        this.field_73839_d.__ah._b();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.post(RenderGameOverlayEvent.ElementType.JUMPBAR);
    }

    protected void renderToolHightlight(int n, int n2) {
        if (this.field_73839_d._M.field_92117_D) {
            this.field_73839_d.__ah._a("toolHighlight");
            if (this.field_92017_k > 0 && this.field_92016_l != null) {
                String string = this.field_92016_l._s();
                int n3 = (int)((float)this.field_92017_k * 256.0f / 10.0f);
                if (n3 > 255) {
                    n3 = 255;
                }
                if (n3 > 0) {
                    int n4 = n2 - 59;
                    if (!this.field_73839_d._j._b()) {
                        n4 += 14;
                    }
                    GL11.glPushMatrix();
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                    qncw qncw2 = this.field_92016_l._a().getFontRenderer(this.field_92016_l);
                    if (qncw2 != null) {
                        int n5 = (n - qncw2._b(string)) / 2;
                        qncw2._a(string, n5, n4, 0xFFFFFF | n3 << 24);
                    } else {
                        int n6 = (n - this.fontrenderer._b(string)) / 2;
                        this.fontrenderer._a(string, n6, n4, 0xFFFFFF | n3 << 24);
                    }
                    GL11.glDisable(3042);
                    GL11.glPopMatrix();
                }
            }
            this.field_73839_d.__ah._b();
        }
    }

    protected void renderHUDText(int n, int n2) {
        RenderGameOverlayEvent.Text text;
        long l;
        this.field_73839_d.__ah._a("forgeHudText");
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        if (this.field_73839_d._y()) {
            l = this.field_73839_d._r.func_82737_E();
            if (l >= 120500L) {
                arrayList2.add(tdpx._a("demo.demoExpired"));
            } else {
                arrayList2.add(String.format(tdpx._a("demo.remainingTime"), eifc._a((int)(120500L - l))));
            }
        }
        if (this.field_73839_d._M.field_74330_P) {
            this.field_73839_d.__ah._a("debug");
            GL11.glPushMatrix();
            arrayList.add("Minecraft " + MC_VERSION + " (" + this.field_73839_d.__aq + ")");
            arrayList.add(this.field_73839_d._u());
            arrayList.add(this.field_73839_d._v());
            arrayList.add(this.field_73839_d._x());
            arrayList.add(this.field_73839_d._w());
            arrayList.add(null);
            l = Runtime.getRuntime().maxMemory();
            long l2 = Runtime.getRuntime().totalMemory();
            long l3 = Runtime.getRuntime().freeMemory();
            long l4 = l2 - l3;
            arrayList2.add("Used memory: " + l4 * 100L / l + "% (" + l4 / 1024L / 1024L + "MB) of " + l / 1024L / 1024L + "MB");
            arrayList2.add("Allocated memory: " + l2 * 100L / l + "% (" + l2 / 1024L / 1024L + "MB)");
            int n3 = sajh._c(this.field_73839_d._t.field_70165_t);
            int n4 = sajh._c(this.field_73839_d._t.field_70163_u);
            int n5 = sajh._c(this.field_73839_d._t.field_70161_v);
            float f = this.field_73839_d._t.field_70177_z;
            int n6 = sajh._c((double)(this.field_73839_d._t.field_70177_z * 4.0f / 360.0f) + 0.5) & 3;
            arrayList.add(String.format("x: %.5f (%d) // c: %d (%d)", this.field_73839_d._t.field_70165_t, n3, n3 >> 4, n3 & 0xF));
            arrayList.add(String.format("y: %.3f (feet pos, %.3f eyes pos)", this.field_73839_d._t.field_70121_D._c, this.field_73839_d._t.field_70163_u));
            arrayList.add(String.format("z: %.5f (%d) // c: %d (%d)", this.field_73839_d._t.field_70161_v, n5, n5 >> 4, n5 & 0xF));
            arrayList.add(String.format("f: %d (%s) / %f", n6, ugqx._c[n6], Float.valueOf(sajh._g(f))));
            if (this.field_73839_d._r != null && this.field_73839_d._r.func_72899_e(n3, n4, n5)) {
                ixzi ixzi2 = this.field_73839_d._r.func_72938_d(n3, n5);
                arrayList.add(String.format("lc: %d b: %s bl: %d sl: %d rl: %d", ixzi2._a() + 15, ixzi2._a((int)(n3 & 0xF), (int)(n5 & 0xF), (foqg)this.field_73839_d._r.func_72959_q())._y, ixzi2._a(rrqi._b, n3 & 0xF, n4, n5 & 0xF), ixzi2._a(rrqi._a, n3 & 0xF, n4, n5 & 0xF), ixzi2._c(n3 & 0xF, n4, n5 & 0xF, 0)));
            } else {
                arrayList.add(null);
            }
            arrayList.add(String.format("ws: %.3f, fs: %.3f, g: %b, fl: %d", Float.valueOf(this.field_73839_d._t.field_71075_bZ._b()), Float.valueOf(this.field_73839_d._t.field_71075_bZ._a()), this.field_73839_d._t.field_70122_E, this.field_73839_d._r.func_72976_f(n3, n5)));
            arrayList2.add(null);
            for (String string : FMLCommonHandler.instance().getBrandings().subList(1, FMLCommonHandler.instance().getBrandings().size())) {
                arrayList2.add(string);
            }
            GL11.glPopMatrix();
            this.field_73839_d.__ah._b();
        }
        if (!MinecraftForge.EVENT_BUS.post(text = new RenderGameOverlayEvent.Text(this.eventParent, arrayList, arrayList2))) {
            String string;
            int n7;
            for (n7 = 0; n7 < arrayList.size(); ++n7) {
                string = arrayList.get(n7);
                if (string == null) continue;
                this.fontrenderer._a(string, 2, 2 + n7 * 10, 0xFFFFFF);
            }
            for (n7 = 0; n7 < arrayList2.size(); ++n7) {
                string = arrayList2.get(n7);
                if (string == null) continue;
                int n8 = this.fontrenderer._b(string);
                this.fontrenderer._a(string, n - n8 - 10, 2 + n7 * 10, 0xFFFFFF);
            }
        }
        this.field_73839_d.__ah._b();
        this.post(RenderGameOverlayEvent.ElementType.TEXT);
    }

    protected void renderRecordOverlay(int n, int n2, float f) {
        if (this.field_73845_h > 0) {
            this.field_73839_d.__ah._a("overlayMessage");
            float f2 = (float)this.field_73845_h - f;
            int n3 = (int)(f2 * 256.0f / 20.0f);
            if (n3 > 255) {
                n3 = 255;
            }
            if (n3 > 0) {
                GL11.glPushMatrix();
                GL11.glTranslatef(n / 2, n2 - 48, 0.0f);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                int n4 = this.field_73844_j ? Color.HSBtoRGB(f2 / 50.0f, 0.7f, 0.6f) & 0xFFFFFF : 0xFFFFFF;
                this.fontrenderer._b(this.field_73838_g, -this.fontrenderer._b(this.field_73838_g) / 2, -4, n4 | n3 << 24);
                GL11.glDisable(3042);
                GL11.glPopMatrix();
            }
            this.field_73839_d.__ah._b();
        }
    }

    protected void renderChat(int n, int n2) {
        this.field_73839_d.__ah._a("chat");
        RenderGameOverlayEvent.Chat chat = new RenderGameOverlayEvent.Chat(this.eventParent, 0, n2 - 48);
        if (MinecraftForge.EVENT_BUS.post(chat)) {
            return;
        }
        GL11.glPushMatrix();
        GL11.glTranslatef(chat.posX, chat.posY, 0.0f);
        this.field_73840_e._a(this.field_73837_f);
        GL11.glPopMatrix();
        this.post(RenderGameOverlayEvent.ElementType.CHAT);
        this.field_73839_d.__ah._b();
    }

    protected void renderPlayerList(int n, int n2) {
        igri igri2 = this.field_73839_d._r.func_96441_U()._a(0);
        bscn bscn2 = this.field_73839_d._t.field_71174_a;
        if (this.field_73839_d._M.field_74321_H._e && (!this.field_73839_d._H() || bscn2._i.size() > 1 || igri2 != null)) {
            int n3;
            if (this.pre(RenderGameOverlayEvent.ElementType.PLAYER_LIST)) {
                return;
            }
            this.field_73839_d.__ah._a("playerList");
            List list2 = bscn2._i;
            int n4 = n3 = bscn2._j;
            int n5 = 1;
            n5 = 1;
            while (n4 > 20) {
                n4 = (n3 + ++n5 - 1) / n5;
            }
            int n6 = 300 / n5;
            if (n6 > 150) {
                n6 = 150;
            }
            int n7 = (n - n5 * n6) / 2;
            int n8 = 10;
            GuiIngameForge.func_73734_a(n7 - 1, n8 - 1, n7 + n6 * n5, n8 + 9 * n4, Integer.MIN_VALUE);
            for (int i = 0; i < n3; ++i) {
                int n9;
                int n10;
                int n11 = n7 + i % n5 * n6;
                int n12 = n8 + i / n5 * 9;
                GuiIngameForge.func_73734_a(n11, n12, n11 + n6 - 1, n12 + 8, 0x20FFFFFF);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glEnable(3008);
                if (i >= list2.size()) continue;
                maza maza2 = (maza)list2.get(i);
                dzew dzew2 = this.field_73839_d._r.func_96441_U()._g(maza2._a);
                String string = dzew._a(dzew2, maza2._a);
                this.fontrenderer._a(string, n11, n12, 0xFFFFFF);
                if (igri2 != null && (n10 = n11 + n6 - 12 - 5) - (n9 = n11 + this.fontrenderer._b(string) + 5) > 5) {
                    cwdc cwdc2 = igri2._a()._a(maza2._a, igri2);
                    String string2 = (Object)((Object)ezfc._o) + "" + cwdc2._b();
                    this.fontrenderer._a(string2, n10 - this.fontrenderer._b(string2), n12, 0xFFFFFF);
                }
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                this.field_73839_d._R()._a(bawa.field_110324_m);
                n9 = 4;
                n10 = maza2._c;
                if (n10 < 0) {
                    n9 = 5;
                } else if (n10 < 150) {
                    n9 = 0;
                } else if (n10 < 300) {
                    n9 = 1;
                } else if (n10 < 600) {
                    n9 = 2;
                } else if (n10 < 1000) {
                    n9 = 3;
                }
                this.field_73735_i += 100.0f;
                this.func_73729_b(n11 + n6 - 12, n12, 0, 176 + n9 * 8, 10, 8);
                this.field_73735_i -= 100.0f;
            }
            this.post(RenderGameOverlayEvent.ElementType.PLAYER_LIST);
        }
    }

    protected void renderHealthMount(int n, int n2) {
        Entity entity = this.field_73839_d._t.field_70154_o;
        if (!(entity instanceof EntityLivingBase)) {
            return;
        }
        this.bind(field_110324_m);
        if (this.pre(RenderGameOverlayEvent.ElementType.HEALTHMOUNT)) {
            return;
        }
        boolean bl = false;
        int n3 = n / 2 + 91;
        this.field_73839_d.__ah._c("mountHealth");
        EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
        int n4 = (int)Math.ceil(entityLivingBase.func_110143_aJ());
        float f = entityLivingBase.func_110138_aP();
        int n5 = (int)(f + 0.5f) / 2;
        if (n5 > 30) {
            n5 = 30;
        }
        int n6 = 52;
        int n7 = 52 + (bl ? 1 : 0);
        int n8 = 97;
        int n9 = 88;
        int n10 = 0;
        while (n5 > 0) {
            int n11 = n2 - right_height;
            int n12 = Math.min(n5, 10);
            n5 -= n12;
            for (int i = 0; i < n12; ++i) {
                int n13 = n3 - i * 8 - 9;
                this.func_73729_b(n13, n11, n7, 9, 9, 9);
                if (i * 2 + 1 + n10 < n4) {
                    this.func_73729_b(n13, n11, 88, 9, 9, 9);
                    continue;
                }
                if (i * 2 + 1 + n10 != n4) continue;
                this.func_73729_b(n13, n11, 97, 9, 9, 9);
            }
            right_height += 10;
            n10 += 20;
        }
        this.post(RenderGameOverlayEvent.ElementType.HEALTHMOUNT);
    }

    private boolean pre(RenderGameOverlayEvent.ElementType elementType) {
        return MinecraftForge.EVENT_BUS.post(new RenderGameOverlayEvent.Pre(this.eventParent, elementType));
    }

    private void post(RenderGameOverlayEvent.ElementType elementType) {
        MinecraftForge.EVENT_BUS.post(new RenderGameOverlayEvent.Post(this.eventParent, elementType));
    }

    private void bind(ResourceLocation resourceLocation) {
        this.field_73839_d._R()._a(resourceLocation);
    }
}

