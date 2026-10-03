/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.main.jgro;
import gloomyfolken.mods.effects.client.main.jxtc;
import gloomyfolken.mods.effects.client.main.kjui;
import gloomyfolken.mods.effects.client.main.vjta;
import gloomyfolken.mods.effects.client.main.zwaw;
import java.util.List;
import kotlin.Unit;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.MinecraftForge;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;

public class hsmn {
    private static xpzm _e = xpzm._E();
    private static float[] _f = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private jxtc _g;
    private jxtc _h;
    public static final int _a = 2;
    private boolean _i = false;
    private boolean _j = false;
    @NotNull
    public jysc _b = this._a();
    public static ResourceLocation _c = new ResourceLocation("effects:textures/fx_noise.dds");
    public static ResourceLocation _d = new ResourceLocation("effects:textures/pnv_offset2.dds");
    private boolean _k = false;
    private kjui.kjui _l = null;
    private static float[] _m = new float[]{0.0f, 0.0f, -90.0f, 1.0f, 0.0f, hsmn._e._o, -90.0f, 1.0f, hsmn._e._n, hsmn._e._o, -90.0f, 1.0f, hsmn._e._n, 0.0f, -90.0f, 1.0f};

    public hsmn() {
        xpzm._E()._h._a(_c);
        xpzm._E()._h._a(_d);
        GL11.glTexParameteri(3553, 10240, 9728);
        GL11.glTexParameteri(3553, 10241, 9728);
        this._b();
    }

    public jysc _a() {
        jysc jysc2 = new jysc();
        MinecraftForge.EVENT_BUS.post(new dxaz(jysc2));
        return jysc2;
    }

    public void _b() {
        this._g = new jxtc("effects", "postprocess");
        this._h = new jxtc("effects", "distortions");
    }

    public void _a(float f, List<ncyh> list2) {
        xpzm._E().__ah._a("distortions");
        if (this._g._f() == 0) {
            return;
        }
        xpzm._E().__ah._a("check");
        boolean bl = this._i();
        boolean bl2 = list2.size() > 0;
        boolean bl3 = this._g();
        this._i = (bl || bl2 || bl3) && zwaw._n();
        xpzm._E().__ah._b();
        if (!this._i) {
            xpzm._E().__ah._b();
            return;
        }
        xpzm._E().__ah._a("start");
        this._a(true);
        if (bl) {
            xpzm._E().__ah._c("entities");
            this._b(f);
        }
        if (bl2) {
            xpzm._E().__ah._c("particles");
            eidj._a._b._a(list2, 2, f);
        }
        if (bl3) {
            xpzm._E().__ah._c("other");
            MinecraftForge.EVENT_BUS.post(new qmds.pidb(f));
        }
        xpzm._E().__ah._c("end");
        this._a(true, true);
        xpzm._E().__ah._b();
        xpzm._E().__ah._b();
    }

    private boolean _g() {
        qmds.kjui kjui2 = new qmds.kjui();
        MinecraftForge.EVENT_BUS.post(kjui2);
        return kjui2._a;
    }

    public void _a(boolean bl) {
        if (this._j) {
            throw new IllegalStateException("Already rendering distortions.");
        }
        this._j = true;
        jgro jgro2 = jgro._y();
        if (jgro2 == null) {
            throw new IllegalStateException("Provide a FBO for rendering distortions!");
        }
        if (jgro2._k()) {
            jgro._a(zwaw._h(), zwaw._j(), 256);
        }
        zwaw._j()._a(true);
        if (bl) {
            this._l = zwaw._j()._i()._f();
        }
        zwaw._j()._a(this._l, 0);
        if (bl) {
            GL11.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            GL11.glClear(16384);
            this._k = true;
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        GL11.glDisable(3008);
    }

    public void _a(boolean bl, boolean bl2) {
        if (!this._j) {
            throw new IllegalStateException("Ended drawing distortions without starting rendering distorions!");
        }
        this._j = false;
        jgro._a._g();
        if (bl) {
            this._b(bl2);
        } else {
            if (bl2) {
                this._h();
            }
            zwaw._y();
        }
        GL11.glEnable(2896);
        GL11.glEnable(3008);
    }

    private void _h() {
        this._l._a();
        this._l = null;
        this._k = false;
    }

    public void _b(boolean bl) {
        boolean bl2;
        GL11.glEnable(3553);
        if (this._j) {
            throw new IllegalStateException("You must finish rendering distortions before applying them!");
        }
        if (this._l == null) {
            throw new IllegalStateException("Distortions apply stage was called, though distortion buffer is null! This should never happen.");
        }
        jgro jgro2 = jgro._y();
        jgro jgro3 = zwaw._j();
        if (jgro2 == null) {
            throw new IllegalStateException("Provide a FBO for rendering distortions!");
        }
        kjui.kjui kjui2 = jgro3._j();
        kjui.kjui kjui3 = null;
        boolean bl3 = bl2 = zwaw._t() && jgro2._k();
        if (jgro2._k()) {
            jgro3._a(kjui2, 0);
            jgro._a(jgro2, jgro3, 16384);
        } else {
            kjui3 = jgro2._i()._f();
            jgro2._a(kjui3, 0);
        }
        kjui2._c()._b(0);
        this._l._c()._b(2);
        if (bl2) {
            GL11.glDisable(32925);
        }
        this._h._e();
        GL20.glUniform1i(this._h._a("screenTexture"), 0);
        GL20.glUniform1i(this._h._a("distortion"), 2);
        GL11.glDisable(2929);
        GL11.glDisable(2896);
        GL11.glDisable(3008);
        hsmn._e();
        hsmn._c();
        if (vjta._b) {
            this._l._c()._b(0);
            GL11.glScaled(0.25, 0.25, 1.0);
            hsmn._c();
        }
        hsmn._f();
        GL11.glEnable(2929);
        GL11.glEnable(2896);
        GL11.glEnable(3008);
        if (bl2) {
            GL11.glEnable(32925);
        }
        GL20.glUseProgram(0);
        if (!jgro2._k() && kjui3 != null) {
            kjui3._b();
        }
        if (bl) {
            this._h();
        }
    }

    private void _b(float f) {
        EntityLivingBase entityLivingBase = hsmn._e._u;
        double d = entityLivingBase.field_70142_S + (entityLivingBase.field_70165_t - entityLivingBase.field_70142_S) * (double)f;
        double d2 = entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * (double)f;
        double d3 = entityLivingBase.field_70136_U + (entityLivingBase.field_70161_v - entityLivingBase.field_70136_U) * (double)f;
        bseg bseg2 = new bseg();
        bseg2._a(d, d2, d3);
        qnon._a();
        hsmn._e._D.func_78483_a(f);
        ForgeHooksClient.setRenderPass(2);
        hsmn._e._s._a(entityLivingBase.func_70666_h(f), bseg2, f);
        ForgeHooksClient.setRenderPass(-1);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public static void _c() {
        int n = hsmn._e._n;
        int n2 = hsmn._e._o;
        hsmn._m[8] = hsmn._m[12] = (float)n;
        hsmn._m[5] = hsmn._m[9] = (float)n2;
        GL11.glBegin(7);
        for (int i = 0; i < 4; ++i) {
            GL11.glTexCoord2f(_f[i * 2], _f[i * 2 + 1]);
            GL11.glVertex4f(_m[i * 4], _m[i * 4 + 1], _m[i * 4 + 2], _m[i * 4 + 3]);
        }
        GL11.glEnd();
    }

    public static void _d() {
        if (!fmgg._a._c()) {
            return;
        }
        zwaw._z()._b(0);
        jgro._z();
        for (int i = 0; i < 4; ++i) {
            jgro jgro2 = fmgg._a._a(i);
            jgro2._b(() -> {
                hsmn._c();
                return Unit.INSTANCE;
            });
            jgro2._j()._c()._b(0);
        }
        jgro jgro3 = fmgg._a._a(3);
        ieoo._a(false, 1.0f, jgro3);
        jgro3._a(() -> {
            GL11.glDisable(3042);
            hsmn._c();
            GL11.glEnable(3042);
            GL11.glBlendFunc(1, 1);
            hsmn._c();
            GL11.glDisable(3042);
            return Unit.INSTANCE;
        });
        jgro._A();
    }

    public void _a(float f) {
        int n = hsmn._e._n;
        int n2 = hsmn._e._o;
        GL11.glColor4d(1.0, 1.0, 1.0, 1.0);
        GL11.glEnable(3553);
        GL11.glDisable(2929);
        GL11.glDisable(3008);
        GL11.glDisable(2896);
        hsmn._e();
        if (zwaw._n() && this._b._E()) {
            if (this._b._p() > 0.0) {
                ieoo._a(false, (float)this._b._p(), zwaw._j());
            }
            this._g._e();
            this._g._a("screenTexture", 0);
            this._g._a("noiseTexture", 2);
            this._g._a("nv_OffsetTex", 3);
            GL13.glActiveTexture(33986);
            xpzm._E()._h._a(_c);
            GL13.glActiveTexture(33987);
            xpzm._E()._h._a(_d);
            GL13.glActiveTexture(33984);
            this._b._a(n, n2, this._g, f);
            GL11.glDisable(3042);
            zwaw._b(() -> {
                zwaw._a(hsmn::_c);
                return Unit.INSTANCE;
            });
            GL20.glUseProgram(0);
            GL11.glEnable(3042);
        }
        hsmn._f();
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glEnable(2896);
    }

    private boolean _i() {
        Object object2;
        List list2 = hsmn._e._r.func_72910_y();
        for (Object object2 : list2) {
            if (!((Entity)object2).shouldRenderInPass(2)) continue;
            return true;
        }
        List list3 = hsmn._e._r.field_73009_h;
        object2 = list3.iterator();
        while (object2.hasNext()) {
            hurg hurg2 = (hurg)object2.next();
            if (!hurg2.shouldRenderInPass(2)) continue;
            return true;
        }
        return false;
    }

    public static void _a(double d, double d2, double d3, int n, float f, dwan dwan2) {
        GL11.glAlphaFunc(516, 0.01f);
        GL11.glDepthMask(false);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 1);
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        float f2 = f / 2.0f;
        switch (n) {
            case 5: {
                htvf2.func_78374_a(d, (double)(-f2) + d2, (double)(-f2) + d3, dwan2.func_94209_e(), dwan2.func_94210_h());
                htvf2.func_78374_a(d, (double)f2 + d2, (double)(-f2) + d3, dwan2.func_94212_f(), dwan2.func_94210_h());
                htvf2.func_78374_a(d, (double)f2 + d2, (double)f2 + d3, dwan2.func_94212_f(), dwan2.func_94206_g());
                htvf2.func_78374_a(d, (double)(-f2) + d2, (double)f2 + d3, dwan2.func_94209_e(), dwan2.func_94206_g());
                break;
            }
            case 4: {
                htvf2.func_78374_a(d, (double)(-f2) + d2, (double)(-f2) + d3, dwan2.func_94209_e(), dwan2.func_94210_h());
                htvf2.func_78374_a(d, (double)(-f2) + d2, (double)f2 + d3, dwan2.func_94209_e(), dwan2.func_94206_g());
                htvf2.func_78374_a(d, (double)f2 + d2, (double)f2 + d3, dwan2.func_94212_f(), dwan2.func_94206_g());
                htvf2.func_78374_a(d, (double)f2 + d2, (double)(-f2) + d3, dwan2.func_94212_f(), dwan2.func_94210_h());
                break;
            }
            case 3: {
                htvf2.func_78374_a((double)(-f2) + d, (double)(-f2) + d2, d3, dwan2.func_94209_e(), dwan2.func_94210_h());
                htvf2.func_78374_a((double)f2 + d, (double)(-f2) + d2, d3, dwan2.func_94212_f(), dwan2.func_94210_h());
                htvf2.func_78374_a((double)f2 + d, (double)f2 + d2, d3, dwan2.func_94212_f(), dwan2.func_94206_g());
                htvf2.func_78374_a((double)(-f2) + d, (double)f2 + d2, d3, dwan2.func_94209_e(), dwan2.func_94206_g());
                break;
            }
            case 2: {
                htvf2.func_78374_a((double)(-f2) + d, (double)(-f2) + d2, d3, dwan2.func_94209_e(), dwan2.func_94210_h());
                htvf2.func_78374_a((double)(-f2) + d, (double)f2 + d2, d3, dwan2.func_94209_e(), dwan2.func_94206_g());
                htvf2.func_78374_a((double)f2 + d, (double)f2 + d2, d3, dwan2.func_94212_f(), dwan2.func_94206_g());
                htvf2.func_78374_a((double)f2 + d, (double)(-f2) + d2, d3, dwan2.func_94212_f(), dwan2.func_94210_h());
                break;
            }
            case 1: {
                htvf2.func_78374_a((double)(-f2) + d, d2, (double)(-f2) + d3, dwan2.func_94209_e(), dwan2.func_94210_h());
                htvf2.func_78374_a((double)(-f2) + d, d2, (double)f2 + d3, dwan2.func_94209_e(), dwan2.func_94206_g());
                htvf2.func_78374_a((double)f2 + d, d2, (double)f2 + d3, dwan2.func_94212_f(), dwan2.func_94206_g());
                htvf2.func_78374_a((double)f2 + d, d2, (double)(-f2) + d3, dwan2.func_94212_f(), dwan2.func_94210_h());
                break;
            }
            case 0: {
                htvf2.func_78374_a((double)(-f2) + d, d2, (double)(-f2) + d3, dwan2.func_94209_e(), dwan2.func_94210_h());
                htvf2.func_78374_a((double)f2 + d, d2, (double)(-f2) + d3, dwan2.func_94212_f(), dwan2.func_94210_h());
                htvf2.func_78374_a((double)f2 + d, d2, (double)f2 + d3, dwan2.func_94212_f(), dwan2.func_94206_g());
                htvf2.func_78374_a((double)(-f2) + d, d2, (double)f2 + d3, dwan2.func_94209_e(), dwan2.func_94206_g());
            }
        }
        htvf2.func_78381_a();
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
        GL11.glAlphaFunc(516, 0.1f);
    }

    public static void _a(double d, double d2, double d3, int n, float f) {
        hsmn._a(d, d2, d3, n, f, ejcz._a);
    }

    public static void _e() {
        GL11.glMatrixMode(5889);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, hsmn._e._n, hsmn._e._o, 0.0, 1000.0, 3000.0);
        GL11.glMatrixMode(5888);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -2000.0f);
    }

    public static void _f() {
        GL11.glMatrixMode(5889);
        GL11.glPopMatrix();
        GL11.glMatrixMode(5888);
        GL11.glPopMatrix();
    }
}

