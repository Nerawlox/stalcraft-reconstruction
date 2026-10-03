/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.hud;

import cpw.mods.fml.common.FMLCommonHandler;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.effects.client.main.ezey;
import gloomyfolken.mods.effects.client.main.zwaw;
import gloomyfolken.mods.stalker.hud.StalkerGuiMod;
import gloomyfolken.mods.stalker.hud.eidj;
import gloomyfolken.mods.stalker.hud.kjui;
import gloomyfolken.mods.stalker.hud.zwat;
import gloomyfolken.mods.stalker.misc.tupg;
import gloomyfolken.mods.stalker.misc.ugqx;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.xpzm;
import net.minecraft.crash.jxtc;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.amww;
import net.minecraft.util.eifc;
import net.minecraft.util.ezfc;
import net.minecraft.util.hank;
import net.minecraft.util.sajh;
import net.minecraft.util.tdpx;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.smart.moving.SmartMovingContext;
import org.lwjgl.opengl.GL11;

public class pidb
extends GuiIngameForge {
    private static final ResourceLocation _t = new ResourceLocation("textures/misc/vignette.png");
    private static final ResourceLocation _u = new ResourceLocation("textures/gui/widgets.png");
    private static final ResourceLocation _v = new ResourceLocation("textures/misc/pumpkinblur.png");
    private static final ResourceLocation _w = new ResourceLocation("weapons", "textures/gui/hud.png");
    private static final ResourceLocation _x = new ResourceLocation("stalker", "textures/gui/bleeding.png");
    private static final int _y = 0xFFFFFF;
    public static boolean _a = true;
    public static boolean _b = true;
    public static boolean _c = true;
    public static boolean _d = true;
    public static boolean _e = true;
    public static boolean _f = true;
    public static boolean _g = true;
    public static boolean _h = true;
    public static boolean _i = true;
    public static boolean _j = true;
    public static boolean _k = true;
    public static boolean _l = true;
    public static boolean _m = true;
    public static int _n = 39;
    public static int _o = 39;
    public static final ResourceLocation _p = new ResourceLocation("stalker", "textures/gui/crosshair_warning.png");
    private htou _z = null;
    private qncw _A = null;
    private RenderGameOverlayEvent _B;
    private static final String _C = new jxtc(null)._a();
    sctt _q = new sctt(1, 1);
    public long _r = 0L;
    public int _s = 0xFF0000;
    private float _D = 1.0f;
    private float _E = 1.0f;
    private int _F = -1;
    private int _G = -1;
    private cvzo _H = null;
    private String _I = null;
    private String _J = null;
    private static ExternalFont _K = new ExternalFont("capture_it_16");
    private float _L = -1.0f;

    public pidb(xpzm xpzm2) {
        super(xpzm2);
        this._q._a();
    }

    private void _b() {
        if (this.field_73839_d._t == null) {
            return;
        }
        gloomyfolken.mods.weapon.ugqx ugqx2 = gloomyfolken.mods.weapon.ugqx._a(this.field_73839_d._t);
        net.minecraft.entity.player.eidj eidj2 = this.field_73839_d._t.field_71071_by;
        cvzo cvzo2 = eidj2._a();
        this._D = this._E;
        this._E = this.field_73839_d._t.func_110143_aJ() / this.field_73839_d._t.func_110138_aP();
        this._F = -1;
        this._G = -1;
        this._H = null;
        this._I = null;
        this._J = null;
        if (cvzo2 != null && cvzo2._a() instanceof wolf) {
            wolf wolf2 = (wolf)cvzo2._a();
            xrox xrox2 = wolf2._a(cvzo2, dxwc.pidb._b, xrox.class);
            if (ugqx2._f() && xrox2 != null) {
                int n = wolf2._z(cvzo2);
                if (n != 0) {
                    this._H = new cvzo(n, 1, 0);
                }
                this._F = n != 0 ? 1 : 0;
                this._G = 0;
                for (int n2 : xrox2._i) {
                    this._G += ncwh._b((EntityPlayer)this.field_73839_d._t, n2);
                }
            } else {
                cvzo cvzo3 = wolf._H(cvzo2);
                if (cvzo3 != null) {
                    this._H = cvzo3;
                    this._I = String.valueOf(((nusq)cvzo3._a())._b._f.charAt(0));
                }
                this._F = wolf._E(cvzo2);
                this._G = 0;
                for (int n : wolf2._b) {
                    this._G += ncwh._b((EntityPlayer)this.field_73839_d._t, n);
                }
                this._J = ugqx2._g()._e;
            }
        } else if (cvzo2 != null && cvzo2._a() instanceof yurw) {
            yurw yurw2 = (yurw)cvzo2._a();
            this._F = 1;
            this._G = ncwh._b((EntityPlayer)this.field_73839_d._t, yurw2.field_77779_bT) - 1;
            this._H = cvzo2;
        }
    }

    @Override
    public void func_73830_a(float f, boolean bl, int n, int n2) {
        Object object;
        this._z = new htou(this.field_73839_d._M, this.field_73839_d._n, this.field_73839_d._o);
        this._B = new RenderGameOverlayEvent(f, this._z, n, n2);
        int n3 = this._z._a();
        int n4 = this._z._b();
        _i = this.field_73839_d._t.field_70154_o instanceof EntityLivingBase;
        _h = this.field_73839_d._t.field_70154_o == null;
        _l = this.field_73839_d._t.func_110317_t();
        _o = 39;
        _n = 39;
        if (this._a(RenderGameOverlayEvent.ElementType.ALL)) {
            return;
        }
        this._A = this.field_73839_d._z;
        this.field_73839_d._D.func_78478_c();
        GL11.glEnable(3042);
        GL11.glDisable(2896);
        tupg tupg2 = tupg._a(this.field_73839_d._t);
        if (tupg2 != null) {
            float f2;
            tupg2._o -= 1.0f;
            if (f2 > 0.0f) {
                float f3 = (float)Math.sin((double)System.currentTimeMillis() * 0.001);
                f3 *= f3 * tupg2._n;
                this._a(f3 += tupg2._m);
            }
        }
        GL11.glBlendFunc(770, 771);
        if (_a) {
            this._a(this._z, f, bl, n, n2);
        }
        if (_b && !this.field_73839_d._t.func_70644_a(hdpq._k)) {
            this.renderPortal(n3, n4, f);
        }
        ccxr ccxr2 = ncwh._a(this.field_73839_d._t);
        this._a(ccxr2);
        if (!this.field_73839_d._j._a()) {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.field_73735_i = -90.0f;
            this.field_73842_c.setSeed(this.field_73837_f * 312871);
            if (this.field_73839_d._B == null && _d) {
                this.renderCrosshairs(n3, n4);
            }
            if (this.field_73839_d._j._b()) {
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                this.field_73839_d._h._a(_w);
                object = this.field_73839_d._t;
                this._b(ccxr2);
                this._a();
                this._b(f);
                this._c();
                GL11.glDisable(3042);
            }
            if (_c) {
                this.renderHotbar(n3, n4, f);
            }
        }
        this.renderSleepFade(n3, n4);
        this.renderToolHightlight(n3, n4);
        this.renderHUDText(n3, n4);
        this.renderRecordOverlay(n3, n4, f);
        object = this.field_73839_d._r.func_96441_U()._a(1);
        if (_m && object != null) {
            this.func_96136_a((igri)object, n4, n3, this._A);
        }
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        this.renderChat(n3, n4);
        this.renderPlayerList(n3, n4);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        GL11.glEnable(3008);
        this._b(RenderGameOverlayEvent.ElementType.ALL);
    }

    private void _a(float f) {
        int n = this._z._a();
        int n2 = this._z._b();
        GL11.glBindTexture(3553, this._q.func_110552_b());
        GL11.glViewport(0, 0, this.field_73839_d._n, this.field_73839_d._o);
        GL11.glCopyTexImage2D(3553, 0, 6407, 0, 0, this.field_73839_d._n, this.field_73839_d._o, 0);
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        htvf htvf2 = htvf.field_78398_a;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        htvf2.func_78382_b();
        htvf2.func_78374_a((float)(-n) * f, n2, -90.0, 0.0, 0.0);
        htvf2.func_78374_a(n, n2, -90.0, 1.0, 0.0);
        htvf2.func_78374_a(n, 0.0, -90.0, 1.0, 1.0);
        htvf2.func_78374_a((float)(-n) * f, 0.0, -90.0, 0.0, 1.0);
        htvf2.func_78381_a();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);
        htvf2.func_78382_b();
        htvf2.func_78374_a(0.0, n2, -90.0, 0.0, 0.0);
        htvf2.func_78374_a((float)n + (float)n * f, n2, -90.0, 1.0, 0.0);
        htvf2.func_78374_a((float)n + (float)n * f, 0.0, -90.0, 1.0, 1.0);
        htvf2.func_78374_a(0.0, 0.0, -90.0, 0.0, 1.0);
        htvf2.func_78381_a();
        GL11.glEnable(2929);
        GL11.glEnable(3008);
    }

    private void _b(float f) {
        int n = this._z._a();
        int n2 = this._z._b();
        float f2 = 81.0f;
        float f3 = jywc._a(this._D, this._E, f);
        int n3 = n - 117;
        int n4 = n2 - 69;
        this.func_73729_b(n3, n4, 79, 0, 111, 70);
        this.func_73729_b(n3 + 25, n4 + 7, 77, 74, (int)(f3 * f2), 8);
        int n5 = (int)((1.0f - StalkerGuiMod._d._c()) * f2);
        this.func_73729_b(n3 + 25, n4 + 18, 77, 85, n5, 6);
        this._a(f2, n3, n4);
        int n6 = (int)(StalkerGuiMod._d._b() * f2);
        this.func_73729_b(n3 + 25, n2 - 6 - 38, 77, 92, n6, 6);
        if (this._F >= 0 && this._G >= 0) {
            String string = this._F + "/" + this._G;
            _K.drawCenteredString(string, n3 + 35, n4 + 41, this._F > 0 || this._G > 0 ? -1 : -1553616);
        }
        ExternalFont.tahoma9.drawCenteredString((int)(f3 * 100.0f) + "%", n3 + 14, n4 + 7, -1);
        if (this._I != null) {
            _K.drawString(this._I, (double)(n3 + 99), (double)(n4 + 55), -1, false);
        }
        if (this._J != null) {
            _K.drawString(this._J, (double)(n3 + 71), (double)(n4 + 55), -1, false);
        }
        if (this._H != null) {
            stiq.field_73841_b.func_82406_b(this._A, this.field_73839_d._R(), this._H, n3 + 77, n4 + 42);
            GL11.glDisable(2896);
        }
    }

    private void _a(float f, int n, int n2) {
        zwat zwat2 = StalkerGuiMod._d;
        long l = 700L;
        long l2 = System.currentTimeMillis() - zwat2._e();
        if (l2 < l) {
            float f2 = SmartMovingContext.Client.getMaximumExhaustion();
            float f3 = 1.0f - zwat2._d() / f2;
            int n3 = (int)(f3 * f);
            float f4 = (float)l2 / (float)l;
            GL11.glColor4f(1.0f, 0.0f, 0.0f, (float)(Math.abs(Math.sin((double)f4 * Math.PI * 4.0)) * (double)0.6f));
            this.func_73729_b(n + 25, n2 + 18, 77, 85, n3, 6);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    private void _c() {
        Object object;
        eidj.zwat zwat2;
        if (!StalkerGuiMod._c || !StalkerGuiMod.instance._b.enabled) {
            return;
        }
        hank hank2 = this.field_73839_d._L;
        if (hank2 == null) {
            return;
        }
        if (hank2._c == amww._b) {
            zwat2 = eidj._a(hank2._i);
        } else {
            int n = this.field_73839_d._r.func_72798_a(hank2._d, hank2._e, hank2._f);
            object = twgu.field_71973_m[n];
            zwat2 = eidj._a((twgu)object);
        }
        if (zwat2 == null) {
            return;
        }
        String string = zwat2._a;
        object = GameSettings.func_74298_c(ClientProxy.interactBinding._d) + " - " + zwat2._b;
        _K.drawCenteredString(string, this._z._a() / 2, this._z._b() / 2 + 10, -1);
        _K.drawCenteredString((String)object, this._z._a() / 2, this._z._b() / 2 + 20, -1);
    }

    @Override
    public htou getResolution() {
        return this._z;
    }

    protected void _a(ccxr ccxr2) {
        int n = this._z._a();
        int n2 = this._z._b();
        mrja mrja2 = tupg._a((EntityPlayer)this.field_73839_d._t)._b;
        int n3 = mrja2._f()._e();
        if (n3 > 0) {
            this._a(_x, (float)n3 / 3.0f, n, n2);
        }
    }

    protected void _a(ResourceLocation resourceLocation, float f, int n, int n2) {
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, f);
        GL11.glDisable(3008);
        this.field_73839_d._R()._a(resourceLocation);
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78374_a(0.0, n2, -90.0, 0.0, 1.0);
        htvf2.func_78374_a(n, n2, -90.0, 1.0, 1.0);
        htvf2.func_78374_a(n, 0.0, -90.0, 1.0, 0.0);
        htvf2.func_78374_a(0.0, 0.0, -90.0, 0.0, 0.0);
        htvf2.func_78381_a();
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    protected void _a() {
        mrja mrja2 = tupg._a((EntityPlayer)this.field_73839_d._t)._b;
        int n = 0;
        if (this._a(mrja2._b(), 0, n)) {
            ++n;
        }
        if (this._a(mrja2._c(), 1, n)) {
            ++n;
        }
        if (this._a(mrja2._d(), 2, n)) {
            ++n;
        }
        if (this._a(mrja2._e(), 3, n)) {
            ++n;
        }
        if (this._a(mrja2._f(), 5, n)) {
            ++n;
        }
        if (this.field_73839_d._t.func_71024_bL()._a() == 0) {
            this._a(4, 4, n++);
        } else if (this.field_73839_d._t.func_71024_bL()._a() <= 6) {
            this._a(4, 3, n++);
        } else if (this.field_73839_d._t.func_71024_bL()._a() <= 12) {
            this._a(4, 2, n++);
        } else if (this.field_73839_d._t.func_71024_bL()._a() <= 19) {
            this._a(4, 1, n++);
        }
        float f = tupg._a(this.field_73839_d._t)._k();
        if (f <= 0.1f) {
            this._a(6, 4, n++);
        } else if (f <= 0.7f) {
            this._a(6, 3, n++);
        } else if (f <= 0.85f) {
            this._a(6, 2, n++);
        } else if (f <= 0.99f) {
            this._a(6, 1, n++);
        }
        cvzo cvzo2 = this.field_73839_d._t.func_71124_b(3);
        if (cvzo2 != null && cvzo2._a() instanceof dgmz) {
            float f2 = ((dgmz)cvzo2._a())._g(cvzo2);
            if (f2 == 1.0f) {
                this._a(7, 4, n++);
            } else if (f2 >= 0.75f) {
                this._a(7, 3, n++);
            } else if (f2 >= 0.5f) {
                this._a(7, 2, n++);
            } else if (f2 >= 0.25f) {
                this._a(7, 1, n++);
            }
        }
    }

    private boolean _a(ejqm ejqm2, int n, int n2) {
        int n3 = ejqm2._e();
        if (n3 > 0) {
            this._a(n, n3, n2);
            return true;
        }
        return false;
    }

    protected void _b(ccxr ccxr2) {
        xafi xafi2 = new xafi();
        tupg tupg2 = tupg._a(this.field_73839_d._t);
        for (Map.Entry<Integer, ugqx> entry : tupg2._g.entrySet()) {
            entry.getValue()._e._a(xafi2);
        }
        int n = 0;
        if (xafi2._h < 0.0f) {
            this._a(0, n++);
        }
        if (xafi2._i < 0.0f) {
            this._a(1, n++);
        }
        if (xafi2._j < 0.0f) {
            this._a(2, n++);
        }
        if (xafi2._k < 0.0f) {
            this._a(3, n++);
        }
        if (xafi2._l < 0.0f) {
            this._a(4, n++);
        }
        if (xafi2._m > 0.0f) {
            this._a(5, n++);
        }
        if (xafi2._n > 0.0f) {
            this._a(6, n++);
        }
        if (xafi2._o > 0.0f) {
            this._a(7, n++);
        }
        if (xafi2._p > 0.0f) {
            this._a(8, n++);
        }
        if (xafi2._q > 0.0f) {
            this._a(9, n++);
        }
        if (xafi2._r > 0.0f || xafi2._v > 0.0f || xafi2._z > 0.0f) {
            this._a(10, n++);
        }
        if (xafi2._g > 0.0f || xafi2._y > 0.0f || xafi2._x > 0.0f) {
            this._a(11, n++);
        }
    }

    @Override
    protected void renderHotbar(int n, int n2, float f) {
        int n3;
        int n4;
        int n5;
        int n6;
        if (this._a(RenderGameOverlayEvent.ElementType.HOTBAR)) {
            return;
        }
        tupg tupg2 = tupg._a(this.field_73839_d._t);
        this._z = new htou(this.field_73839_d._M, this.field_73839_d._n, this.field_73839_d._o);
        GL11.glDisable(3042);
        this.field_73839_d.__ah._a("actionBar");
        GL11.glEnable(32826);
        qnon._c();
        for (n6 = 0; n6 < 4; ++n6) {
            n5 = 3 + n6 * 20 + 2;
            n4 = n2 - 16 - 3;
            this.func_73832_a(n6 + 44, n5, n4, f);
        }
        n6 = GloomyCore.instance.containerFactory._b();
        for (n5 = 0; n5 < n6; ++n5) {
            n4 = n - 120 - n6 * 20 + n5 * 20;
            n3 = n2 - 19;
            if (this.field_73839_d._t != null && n5 == this.field_73839_d._t.field_71071_by._c) {
                pidb.func_73734_a(n4, n3, n4 + 16, n3 + 16, 1785753712);
            }
            this.func_73832_a(n5, n4, n3, f);
        }
        qnon._a();
        GL11.glDisable(32826);
        GL11.glEnable(3042);
        float f2 = sajh._a((float)(System.currentTimeMillis() - tupg2._i) / (float)tupg2._h, 0.0f, 1.0f);
        n4 = (int)(f2 * 16.0f);
        for (n3 = 0; n3 < 4; ++n3) {
            if (tupg2._c._a[n3 + 8] == null) continue;
            int n7 = 3 + n3 * 20 + 2;
            int n8 = n2 - 16 - 3;
            pidb.func_73734_a(n7, n8 + n4, n7 + 16, n8 + 16, -1435471760);
        }
        GL11.glDisable(3042);
        this.field_73839_d.__ah._b();
        this._b(RenderGameOverlayEvent.ElementType.HOTBAR);
    }

    @Override
    protected void renderCrosshairs(int n, int n2) {
        if (this._a(RenderGameOverlayEvent.ElementType.CROSSHAIRS)) {
            return;
        }
        kjui kjui2 = new kjui(-1);
        MinecraftForge.EVENT_BUS.post(kjui2);
        int n3 = kjui2._a;
        boolean bl = n3 != -1;
        boolean bl2 = System.currentTimeMillis() - this._r < 700L;
        float f = (float)(n3 >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n3 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n3 & 0xFF) / 255.0f;
        float f4 = (float)(n3 >> 24 & 0xFF) / 255.0f;
        cvzo cvzo2 = this.field_73839_d._t.func_71045_bC();
        if (cvzo2 == null || !(cvzo2._a() instanceof wolf)) {
            if (!bl2) {
                this._a(bawa.field_110324_m);
                GL11.glEnable(3042);
                if (!bl) {
                    GL11.glBlendFunc(775, 769);
                }
                GL11.glColor4f(f, f2, f3, f4);
                this.func_73729_b(n / 2 - 7, n2 / 2 - 7, 0, 0, 16, 16);
                GL11.glDisable(3042);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            }
            this._L = -1.0f;
        } else if (gloomyfolken.mods.weapon.ugqx._a(this.field_73839_d._t)._m()) {
            this._L = -1.0f;
        } else {
            wolf wolf2 = (wolf)cvzo2._a();
            float f5 = (float)n / (float)this.field_73839_d._n;
            float f6 = (float)n2 / (float)this.field_73839_d._o;
            htvf htvf2 = htvf.field_78398_a;
            GL11.glEnable(3042);
            GL11.glDisable(3553);
            if (!bl) {
                GL11.glBlendFunc(775, 769);
            }
            GL11.glColor4f(f, f2, f3, f4);
            float f7 = (float)(this.field_73839_d._n / 2) * f5;
            float f8 = (float)(this.field_73839_d._o / 2) * f6;
            float f9 = wolf2._c(this.field_73839_d._t);
            if (this._L < 0.0f) {
                this._L = f9;
            }
            float f10 = jywc._a(this._L, f9, this.field_73839_d._p._d);
            float f11 = this.field_73839_d._D.func_78481_a(this.field_73839_d._p._d, true);
            float f12 = 15.0f * f5;
            float f13 = f10 / f11 * (float)this.field_73839_d._o * f6;
            htvf2.func_78382_b();
            this._a(f7, f8, f5, f6);
            this._a(f7 - f12 - f13 + f5, f8, f12, f6);
            this._a(f7 + f13, f8, f12, f6);
            this._a(f7, f8 - f12 - f13 + f6, f5, f12);
            this._a(f7, f8 + f13, f5, f12);
            htvf2.func_78381_a();
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(f, f2, f3, f4 * 0.5f);
            htvf2.func_78382_b();
            this._a(f7, f8, f5, f6);
            this._a(f7 - f12 - f13 + f5, f8, f12, f6);
            this._a(f7 + f13, f8, f12, f6);
            this._a(f7, f8 - f12 - f13 + f6, f5, f12);
            this._a(f7, f8 + f13, f5, f12);
            htvf2.func_78381_a();
            GL11.glEnable(3553);
            GL11.glDisable(3042);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this._L = f9;
        }
        if (bl2) {
            this._b(n, n2);
        }
        this._b(RenderGameOverlayEvent.ElementType.CROSSHAIRS);
    }

    private void _b(int n, int n2) {
        this._a(_p);
        int n3 = this._s;
        GL11.glColor4f((float)(n3 >> 16 & 0xFF) / 255.0f, (float)(n3 >> 8 & 0xFF) / 255.0f, (float)(n3 & 0xFF) / 255.0f, 1.0f);
        htvf htvf2 = htvf.field_78398_a;
        float f = n / 2 - 4;
        float f2 = n2 / 2 - 4;
        float f3 = 8.0f;
        float f4 = 8.0f;
        GL11.glEnable(3042);
        htvf2.func_78382_b();
        htvf2.func_78374_a(f, f2 + f4, 0.0, 0.0, 1.0);
        htvf2.func_78374_a(f + f3, f2 + f4, 0.0, 1.0, 1.0);
        htvf2.func_78374_a(f + f3, f2, 0.0, 1.0, 0.0);
        htvf2.func_78374_a(f, f2, 0.0, 0.0, 0.0);
        htvf2.func_78381_a();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    private void _a(float f, float f2, float f3, float f4) {
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78377_a(f, f2 + f4, 0.0);
        htvf2.func_78377_a(f + f3, f2 + f4, 0.0);
        htvf2.func_78377_a(f + f3, f2, 0.0);
        htvf2.func_78377_a(f, f2, 0.0);
    }

    private void _a(htou htou2, float f, boolean bl, int n, int n2) {
        if (this._a(RenderGameOverlayEvent.ElementType.HELMET)) {
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
        this._b(RenderGameOverlayEvent.ElementType.HELMET);
    }

    @Override
    protected void renderPortal(int n, int n2, float f) {
        if (this._a(RenderGameOverlayEvent.ElementType.PORTAL)) {
            return;
        }
        float f2 = this.field_73839_d._t.field_71080_cy + (this.field_73839_d._t.field_71086_bY - this.field_73839_d._t.field_71080_cy) * f;
        if (f2 > 0.0f) {
            this.func_130015_b(f2, n, n2);
        }
        this._b(RenderGameOverlayEvent.ElementType.PORTAL);
    }

    @Override
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
            pidb.func_73734_a(0, 0, n, n2, n4);
            GL11.glEnable(3008);
            GL11.glEnable(2929);
            this.field_73839_d.__ah._b();
        }
    }

    public void _a(int n) {
        this._r = System.currentTimeMillis();
        this._s = n;
    }

    @Override
    protected void renderJumpBar(int n, int n2) {
        this._a(bawa.field_110324_m);
        if (this._a(RenderGameOverlayEvent.ElementType.JUMPBAR)) {
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
        this._b(RenderGameOverlayEvent.ElementType.JUMPBAR);
    }

    @Override
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
                        int n6 = (n - this._A._b(string)) / 2;
                        this._A._a(string, n6, n4, 0xFFFFFF | n3 << 24);
                    }
                    GL11.glDisable(3042);
                    GL11.glPopMatrix();
                }
            }
            this.field_73839_d.__ah._b();
        }
    }

    public void _a(List<String> list) {
        Object object;
        list.add("Minecraft " + _C + " (" + this.field_73839_d.__aq + ")");
        list.add(this.field_73839_d._u());
        list.add(this.field_73839_d._v());
        list.add(this.field_73839_d._x());
        list.add(this.field_73839_d._w());
        ezey ezey2 = gloomyfolken.mods.effects.client.main.eidj._C;
        list.add("PE: " + ezey2._a + ", P: " + ezey2._b + ", D: " + ezey2._c);
        list.add("DS: " + ezey2._g + ", DM: " + ezey2._f + ", DR: " + ezey2._e + ", DI: " + ezey2._d);
        list.add("TE: " + ezey2._h + "/" + ezey2._i + " (" + fmea._b + " custom)");
        list.add(null);
        int n = sajh._c(this.field_73839_d._t.field_70165_t);
        int n2 = sajh._c(this.field_73839_d._t.field_70163_u);
        int n3 = sajh._c(this.field_73839_d._t.field_70161_v);
        float f = this.field_73839_d._t.field_70177_z;
        int n4 = sajh._c((double)(this.field_73839_d._t.field_70177_z * 4.0f / 360.0f) + 0.5) & 3;
        list.add(String.format("x: %.5f (%d) // c: %d (%d)", this.field_73839_d._t.field_70165_t, n, n >> 4, n & 0xF));
        list.add(String.format("y: %.3f (feet pos, %.3f eyes pos)", this.field_73839_d._t.field_70121_D._c, this.field_73839_d._t.field_70163_u));
        list.add(String.format("z: %.5f (%d) // c: %d (%d)", this.field_73839_d._t.field_70161_v, n3, n3 >> 4, n3 & 0xF));
        list.add(String.format("f: %d (%s) / %f", n4, net.minecraft.util.ugqx._c[n4], Float.valueOf(sajh._g(f))));
        if (this.field_73839_d._r != null && this.field_73839_d._r.func_72899_e(n, n2, n3)) {
            object = this.field_73839_d._r.func_72938_d(n, n3);
            list.add(String.format("lc: %d b: %s bl: %d sl: %d rl: %d", ((ixzi)object)._a() + 15, ((ixzi)object)._a((int)(n & 0xF), (int)(n3 & 0xF), (foqg)this.field_73839_d._r.func_72959_q())._y, ((ixzi)object)._a(rrqi._b, n & 0xF, n2, n3 & 0xF), ((ixzi)object)._a(rrqi._a, n & 0xF, n2, n3 & 0xF), ((ixzi)object)._c(n & 0xF, n2, n3 & 0xF, 0)));
        } else {
            list.add(null);
        }
        list.add(String.format("ws: %.3f, fs: %.3f, g: %b, fl: %d", Float.valueOf(this.field_73839_d._t.field_71075_bZ._b()), Float.valueOf(this.field_73839_d._t.field_71075_bZ._a()), this.field_73839_d._t.field_70122_E, this.field_73839_d._r.func_72976_f(n, n3)));
        object = new StringBuilder();
        for (ejqm ejqm2 : tupg._a((EntityPlayer)this.field_73839_d._t)._b._a()) {
            if (!(ejqm2._d() > 0.0f) && !(ejqm2._c() > 0.0f)) continue;
            ((StringBuilder)object).append(String.format("%s %.2f/%.2f, ", ejqm2._b(), Float.valueOf(ejqm2._d()), Float.valueOf(ejqm2._c())));
        }
        if (((StringBuilder)object).length() > 0) {
            list.add(((StringBuilder)object).toString());
        }
        boolean bl = false;
        if (jysc._H() != null) {
            bl = jysc._H()._E();
        }
        list.add(String.format("pp: %b, fbo: %b", bl, zwaw._n()));
        list.add(String.format("shader_terrain: %b", tfsl.useShader));
        list.add(String.format("ping: %d", ClientProxy.PING));
    }

    public void _b(List<String> list) {
        long l = Runtime.getRuntime().maxMemory();
        long l2 = Runtime.getRuntime().totalMemory();
        long l3 = Runtime.getRuntime().freeMemory();
        long l4 = l2 - l3;
        list.add("Used memory: " + l4 * 100L / l + "% (" + l4 / 1024L / 1024L + "MB) of " + l / 1024L / 1024L + "MB");
        list.add("Allocated memory: " + l2 * 100L / l + "% (" + l2 / 1024L / 1024L + "MB)");
        list.add(null);
        list.addAll(FMLCommonHandler.instance().getBrandings().subList(1, FMLCommonHandler.instance().getBrandings().size()));
    }

    @Override
    protected void renderHUDText(int n, int n2) {
        RenderGameOverlayEvent.Text text;
        this.field_73839_d.__ah._a("forgeHudText");
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        if (this.field_73839_d._y()) {
            long l = this.field_73839_d._r.func_82737_E();
            if (l >= 120500L) {
                arrayList2.add(tdpx._a("demo.demoExpired"));
            } else {
                arrayList2.add(String.format(tdpx._a("demo.remainingTime"), eifc._a((int)(120500L - l))));
            }
        }
        if (this.field_73839_d._M.field_74330_P) {
            this.field_73839_d.__ah._a("debug");
            GL11.glPushMatrix();
            this._a(arrayList);
            this._b(arrayList2);
            GL11.glPopMatrix();
            this.field_73839_d.__ah._b();
        }
        if (!MinecraftForge.EVENT_BUS.post(text = new RenderGameOverlayEvent.Text(this._B, arrayList, arrayList2))) {
            String string;
            int n3;
            for (n3 = 0; n3 < arrayList.size(); ++n3) {
                string = arrayList.get(n3);
                if (string == null) continue;
                this._A._a(string, 2, 2 + n3 * 10, 0xFFFFFF);
            }
            for (n3 = 0; n3 < arrayList2.size(); ++n3) {
                string = arrayList2.get(n3);
                if (string == null) continue;
                int n4 = this._A._b(string);
                this._A._a(string, n - n4 - 10, 2 + n3 * 10, 0xFFFFFF);
            }
        }
        this.field_73839_d.__ah._b();
        this._b(RenderGameOverlayEvent.ElementType.TEXT);
    }

    @Override
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
                this._A._b(this.field_73838_g, -this._A._b(this.field_73838_g) / 2, -4, n4 | n3 << 24);
                GL11.glDisable(3042);
                GL11.glPopMatrix();
            }
            this.field_73839_d.__ah._b();
        }
    }

    @Override
    protected void renderChat(int n, int n2) {
        this.field_73839_d.__ah._a("chat");
        RenderGameOverlayEvent.Chat chat = new RenderGameOverlayEvent.Chat(this._B, 0, n2 - 48);
        if (MinecraftForge.EVENT_BUS.post(chat)) {
            return;
        }
        GL11.glPushMatrix();
        GL11.glTranslatef(chat.posX, chat.posY, 0.0f);
        this.field_73840_e._a(this.field_73837_f);
        GL11.glPopMatrix();
        this._b(RenderGameOverlayEvent.ElementType.CHAT);
        this.field_73839_d.__ah._b();
    }

    @Override
    protected void renderPlayerList(int n, int n2) {
        boolean bl;
        igri igri2 = this.field_73839_d._r.func_96441_U()._a(0);
        bscn bscn2 = this.field_73839_d._t.field_71174_a;
        boolean bl2 = this.field_73839_d._t.field_71075_bZ._d;
        boolean bl3 = bl = !this.field_73839_d._H() || bscn2._i.size() > 1 || igri2 != null;
        if (bl2 && this.field_73839_d._M.field_74321_H._e && bl) {
            int n3;
            if (this._a(RenderGameOverlayEvent.ElementType.PLAYER_LIST)) {
                return;
            }
            this.field_73839_d.__ah._a("playerList");
            List list = bscn2._i;
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
            pidb.func_73734_a(n7 - 1, n8 - 1, n7 + n6 * n5, n8 + 9 * n4, Integer.MIN_VALUE);
            for (int i = 0; i < n3; ++i) {
                int n9;
                int n10;
                int n11 = n7 + i % n5 * n6;
                int n12 = n8 + i / n5 * 9;
                pidb.func_73734_a(n11, n12, n11 + n6 - 1, n12 + 8, 0x20FFFFFF);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glEnable(3008);
                if (i >= list.size()) continue;
                maza maza2 = (maza)list.get(i);
                dzew dzew2 = this.field_73839_d._r.func_96441_U()._g(maza2._a);
                String string = dzew._a(dzew2, maza2._a);
                this._A._a(string, n11, n12, 0xFFFFFF);
                if (igri2 != null && (n10 = n11 + n6 - 12 - 5) - (n9 = n11 + this._A._b(string) + 5) > 5) {
                    cwdc cwdc2 = igri2._a()._a(maza2._a, igri2);
                    String string2 = (Object)((Object)ezfc._o) + "" + cwdc2._b();
                    this._A._a(string2, n10 - this._A._b(string2), n12, 0xFFFFFF);
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
            this._b(RenderGameOverlayEvent.ElementType.PLAYER_LIST);
        }
    }

    private boolean _a(RenderGameOverlayEvent.ElementType elementType) {
        return MinecraftForge.EVENT_BUS.post(new RenderGameOverlayEvent.Pre(this._B, elementType));
    }

    private void _b(RenderGameOverlayEvent.ElementType elementType) {
        MinecraftForge.EVENT_BUS.post(new RenderGameOverlayEvent.Post(this._B, elementType));
    }

    private void _a(ResourceLocation resourceLocation) {
        this.field_73839_d._R()._a(resourceLocation);
    }

    private void _a(int n, int n2, int n3, int n4, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        GL11.glDisable(3553);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        GL11.glShadeModel(7425);
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78369_a(f, f2, f3, f4);
        htvf2.func_78377_a(n3, n2, this.field_73735_i);
        htvf2.func_78377_a(n, n2, this.field_73735_i);
        htvf2.func_78369_a(f5, f6, f7, f8);
        htvf2.func_78377_a(n, n4, this.field_73735_i);
        htvf2.func_78377_a(n3, n4, this.field_73735_i);
        htvf2.func_78381_a();
        GL11.glShadeModel(7424);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(3553);
    }

    private void _a(htvf htvf2, int n, int n2, int n3, int n4, int n5) {
        htvf2.func_78382_b();
        htvf2.func_78378_d(n5);
        htvf2.func_78377_a(n + 0, n2 + 0, 0.0);
        htvf2.func_78377_a(n + 0, n2 + n4, 0.0);
        htvf2.func_78377_a(n + n3, n2 + n4, 0.0);
        htvf2.func_78377_a(n + n3, n2 + 0, 0.0);
        htvf2.func_78381_a();
    }

    public void _a(int n, int n2) {
        htou htou2 = new htou(this.field_73839_d._M, this.field_73839_d._n, this.field_73839_d._o);
        this.func_73729_b(90 + n2 * 18, htou2._b() - 20, n * 16, 224, 16, 32);
    }

    public void _a(int n, int n2, int n3) {
        htou htou2 = new htou(this.field_73839_d._M, this.field_73839_d._n, this.field_73839_d._o);
        this.func_73729_b(htou2._a() - 6 - 19, htou2._b() - 6 - 63 - 6 - (n3 + 1) * 18, (n2 - 1) * 19, n * 18 + 18, 19, 18);
    }

    @Override
    protected void func_73832_a(int n, int n2, int n3, float f) {
        cvzo cvzo2 = n < 36 ? this.field_73839_d._t.field_71071_by._a[n] : tupg._a((EntityPlayer)this.field_73839_d._t)._c._a[n - 36];
        if (cvzo2 != null) {
            float f2 = (float)cvzo2._c - f;
            if (f2 > 0.0f) {
                GL11.glPushMatrix();
                float f3 = 1.0f + f2 / 5.0f;
                GL11.glTranslatef(n2 + 8, n3 + 12, 0.0f);
                GL11.glScalef(1.0f / f3, (f3 + 1.0f) / 2.0f, 1.0f);
                GL11.glTranslatef(-(n2 + 8), -(n3 + 12), 0.0f);
            }
            stiq.field_73841_b.func_82406_b(this.field_73839_d._z, this.field_73839_d._R(), cvzo2, n2, n3);
            if (f2 > 0.0f) {
                GL11.glPopMatrix();
            }
            stiq.field_73841_b.func_77021_b(this.field_73839_d._z, this.field_73839_d._R(), cvzo2, n2, n3);
        }
    }

    @Override
    public void func_73831_a() {
        this._b();
        if (this.field_73845_h > 0) {
            --this.field_73845_h;
        }
        ++this.field_73837_f;
        if (this.field_73839_d._t != null) {
            cvzo cvzo2 = this.field_73839_d._t.field_71071_by._a();
            if (cvzo2 == null) {
                this.field_92017_k = 0;
            } else if (this.field_92016_l != null && cvzo2._d == this.field_92016_l._d && (cvzo2._f() || cvzo2._j() == this.field_92016_l._j())) {
                if (this.field_92017_k > 0) {
                    --this.field_92017_k;
                }
            } else {
                this.field_92017_k = 40;
            }
            this.field_92016_l = cvzo2;
        }
    }
}

