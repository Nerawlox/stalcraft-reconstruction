/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.main;

import gloomyfolken.mods.effects.client.main.ezey;
import gloomyfolken.mods.effects.client.main.pidb;
import gloomyfolken.mods.effects.client.main.tupg;
import gloomyfolken.mods.effects.client.main.xpzm;
import gloomyfolken.mods.effects.client.main.zwaw;
import gloomyfolken.mods.effects.client.mcsa.amww;
import gloomyfolken.mods.effects.client.mcsa.ezfa;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.effects.client.mcsa.ugqi;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.ARBDebugOutput;
import org.lwjgl.opengl.ARBDebugOutputCallback;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.vector.Matrix3f;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

@gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
public final class eidj {
    public static eidj _a;
    public ejaq _b;
    public hsmn _c;
    public ytzy _d;
    public List<iekw> _e = new ArrayList<iekw>();
    public List<xqwz> _f = new ArrayList<xqwz>();
    public wntj _g;
    public float _h;
    public float _i;
    public int _j = 4096;
    public boolean _k = false;
    List<rplk> _l = new ArrayList<rplk>();
    boolean _m;
    List<tvlv> _n = new ArrayList<tvlv>();
    int _o = 0;
    static final float _p = (float)Math.PI / 180;
    Random _q = new Random();
    public bseg _r = new bseg();
    public double _s;
    public double _t;
    public double _u;
    public Matrix4f _v = new Matrix4f();
    public Matrix4f _w = new Matrix4f();
    public Matrix3f _x = new Matrix3f();
    public Matrix3f _y = new Matrix3f();
    public float _z;
    public float _A;
    public float _B;
    public static final ezey _C;
    public static final boolean _D;
    public static final boolean _E;
    public static final boolean _F;
    public static final boolean _G;
    public static final boolean _H;
    public static final boolean _I;
    public static final boolean _J;
    public static final boolean _K;
    public static String _L;
    private List<ncyh> _M = new ArrayList<ncyh>();
    private List<ncyh> _N = new ArrayList<ncyh>();
    private FloatBuffer _O = BufferUtils.createFloatBuffer(16);
    private boolean _P = false;
    private static final Vector3f _Q;

    public eidj() {
        _a = this;
        _L = GL11.glGetString(7936);
        gpmu._a("Starting Effects API...", new Object[0]);
        gpmu._a("GL version: %s", GL11.glGetString(7938));
        gpmu._a("GL vendor: %s", _L);
        gpmu._a("GL device: %s", GL11.glGetString(7937));
        qmdg._a();
        uyvo._c = new lnuj();
        AdvancedModelLoader.registerModelHandler(new gloomyfolken.mods.effects.client.mcsa.eidj());
        new xpzm();
        if (_D) {
            this._c = new hsmn();
        }
        this._b = new ejaq();
        this._b._a();
        this._d = new ytzy();
        ugqi.register("pbr", new amww());
        gpmu._a("EffectsMod loaded", new Object[0]);
    }

    public void _a() {
        _C._a();
        qmdg._a._b();
        zwaw._v();
        zwaw._w();
    }

    public void _b() {
        zwaw._x();
        zwaw._u();
    }

    public void _a(float f) {
        ezfa._a._a();
        this._j();
        if (this._d != null) {
            this._d._a(this._f, f);
        }
        zwaw._x();
        this._a(this._M, this._N, f);
        this._a(f, this._M, this._N);
        this._M.clear();
        this._N.clear();
        teei._a._a((ozlu)net.minecraft.client.xpzm._E()._r, net.minecraft.client.xpzm._E()._t);
        MinecraftForge.EVENT_BUS.post(new tvms.pidb(jysc._H()));
    }

    void _a(float f, List<ncyh> list, List<ncyh> list2) {
        if (this._b != null) {
            if (this._c != null) {
                this._c._a(f, list2);
            }
            this._b._a(list, 0, f);
        }
    }

    public void _c() {
        this._O.clear();
        GL11.glGetFloat(2982, this._O);
        this._v.load(this._O);
        this._a(this._v);
    }

    public void _d() {
        ezfc._b(this._v);
        this._a(this._v);
    }

    public void _a(Matrix4f matrix4f) {
        this._v.load(matrix4f);
        Matrix4f.invert(this._v, this._w);
        if (!ezfa._a._b()) {
            gpmu._b("RenderMeshQueue is not empty on view matrix loading! Probably you forgot to call renderMeshes() somewhere.", new Object[0]);
        }
        ezfc._a(this._v);
        jywc._a(this._x, this._v);
        jywc._a(this._y, this._w);
        this._e();
    }

    public void _e() {
        net.minecraft.client.xpzm xpzm2 = net.minecraft.client.xpzm._E();
        float f = xpzm2._p._d;
        this._b(xpzm2._D.func_78481_a(f, true));
    }

    public void _b(float f) {
        this._z = f;
        float f2 = (float)Math.toRadians(f);
        this._A = (float)net.minecraft.client.xpzm._E()._n / ((float)Math.tan(f2 / 2.0f) * 2.0f);
        this._B = this._A * this._A;
    }

    private void _j() {
        this._O.clear();
        GL11.glGetFloat(2982, this._O);
        FloatBuffer floatBuffer = this._O;
        this._s = (double)(-(floatBuffer.get(0) * floatBuffer.get(12) + floatBuffer.get(1) * floatBuffer.get(13) + floatBuffer.get(2) * floatBuffer.get(14))) + gqqu._d;
        this._t = (double)(-(floatBuffer.get(4) * floatBuffer.get(12) + floatBuffer.get(5) * floatBuffer.get(13) + floatBuffer.get(6) * floatBuffer.get(14))) + gqqu._e;
        this._u = (double)(-(floatBuffer.get(8) * floatBuffer.get(12) + floatBuffer.get(9) * floatBuffer.get(13) + floatBuffer.get(10) * floatBuffer.get(14))) + gqqu._f;
    }

    public float _a(Entity entity) {
        return (float)entity.func_70011_f(this._s, this._t, this._u);
    }

    public float _b(Entity entity) {
        return (float)entity.func_70092_e(this._s, this._t, this._u);
    }

    private void _a(List<ncyh> list, List<ncyh> list2, float f) {
        net.minecraft.client.xpzm._E().__ah._a("loadparticles");
        int n = 0;
        int n2 = 0;
        this._r._a(this._s, this._t, this._u);
        for (iekw tvlv2 : this._e) {
            tvlv2.updateDistance(this._s, this._t, this._u);
            if (!(tvlv2.lastDistanceSq < tvlv2.renderDistanceSq) || !tvlv2.ignoreFrustrumRenderCheck() && !this._r._a(tvlv2.getBoundingBox())) continue;
            this._n.add(tvlv2);
        }
        for (tvlv tvlv2 : this._n) {
            tvlv2.updateParticlesRenderPos(f);
            for (ncyh ncyh2 : tvlv2.particles) {
                if (ncyh2.shouldRenderInPass(0)) {
                    list.add(ncyh2);
                    ++n;
                }
                if (!ncyh2.shouldRenderInPass(2)) continue;
                list2.add(ncyh2);
                ++n2;
            }
        }
        eidj._C._a = this._n.size();
        eidj._C._b = n;
        eidj._C._c = n2;
        this._n.clear();
        net.minecraft.client.xpzm._E().__ah._b();
    }

    void _f() {
        net.minecraft.client.xpzm._E().__ah._a("effectsapi");
        if (this._P) {
            this._P = false;
            this._m();
        }
        this._k();
        this._l();
        this._c._b._D();
        net.minecraft.client.xpzm._E().__ah._b();
    }

    private void _k() {
        Object object;
        net.minecraft.client.xpzm._E().__ah._a("particles");
        pkix pkix2 = net.minecraft.client.xpzm._E()._r;
        Iterator<iekw> iterator2 = this._e.iterator();
        while (iterator2.hasNext()) {
            object = iterator2.next();
            if (((iekw)object).isValid() && pkix2 == ((tvlv)object).world) continue;
            iterator2.remove();
        }
        for (iekw iekw2 : this._e) {
            iekw2.updateDistance(gqqu._d, gqqu._e, gqqu._f);
            if (!(iekw2.lastDistanceSq < (iekw2.renderDistanceSq + 16.0) * (iekw2.renderDistanceSq + 16.0)) || !iekw2.ignoreFrustrumTickCheck() && !this._r._a(iekw2.getBoundingBox())) continue;
            iekw2.tick();
        }
        if (--this._o <= 0) {
            this._o = 40 + this._q.nextInt(60);
            object = new Vector2f(this._q.nextFloat() - 0.5f, this._q.nextFloat() - 0.5f);
            ((Vector)object).normalise();
            float f = this._q.nextFloat() * 0.01f;
            this._h = ((Vector2f)object).x * f;
            this._i = ((Vector2f)object).y * f;
        }
        net.minecraft.client.xpzm._E().__ah._b();
    }

    private void _l() {
        net.minecraft.client.xpzm._E().__ah._a("customlights");
        pkix pkix2 = net.minecraft.client.xpzm._E()._r;
        Iterator<xqwz> iterator2 = this._f.iterator();
        while (iterator2.hasNext()) {
            xqwz xqwz2 = iterator2.next();
            if (xqwz2._a() && pkix2 == xqwz2._d()) continue;
            iterator2.remove();
        }
        net.minecraft.client.xpzm._E().__ah._b();
    }

    public void _g() {
        this._P = true;
    }

    private void _m() {
        net.minecraft.client.xpzm._E().__ah._a("reload_particles");
        this._g = new wntj(this._l);
        net.minecraft.client.xpzm._E()._h._a(wntj._a, this._g);
        net.minecraft.client.xpzm._E().__ah._b();
    }

    void _h() {
        this._m();
        this._m = true;
        fmib._a(false);
        gpmu._f("EffectsMod post loaded", new Object[0]);
    }

    void _i() {
        this._e.clear();
        this._f.clear();
    }

    public static float _a(float f, float f2) {
        return eidj._a._B / (f * f2);
    }

    public static float _a(Matrix4f matrix4f, float f, float f2) {
        float f3 = jywc._a(jywc._b(matrix4f, _Q));
        float f4 = jywc._a(matrix4f);
        float f5 = Math.max(f4 - f, 0.0f);
        float f6 = f5 * f5;
        return eidj._a._B * f3 / (f6 * f2);
    }

    static {
        _C = new ezey();
        ContextCapabilities contextCapabilities = GLContext.getCapabilities();
        _D = contextCapabilities.OpenGL20;
        _E = contextCapabilities.OpenGL30 && pidb._e();
        _F = contextCapabilities.OpenGL32 && pidb._e();
        _G = contextCapabilities.OpenGL33 && pidb._e();
        _H = contextCapabilities.OpenGL43 && pidb._e();
        tupg._a._a(!_E);
        _I = contextCapabilities.GL_NV_copy_image;
        _J = _F || contextCapabilities.GL_ARB_seamless_cube_map;
        _K = contextCapabilities.GL_NV_framebuffer_multisample_coverage;
        if (System.getProperty("ogl_debug", "false").equals("true")) {
            ARBDebugOutput.glDebugMessageControlARB(4352, 4352, 4352, null, true);
            GL11.glEnable(33346);
            ARBDebugOutput.glDebugMessageCallbackARB(new ARBDebugOutputCallback());
        }
        _Q = new Vector3f();
    }
}

