/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.main.jgro;
import gloomyfolken.mods.effects.client.main.jxtc;
import gloomyfolken.mods.effects.client.main.zwaw;
import java.awt.Dimension;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.sajh;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL31;
import org.lwjgl.opengl.GL33;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class ejaq {
    private boolean _a = false;
    private Vector4f[] _b = new Vector4f[]{new Vector4f(-0.5f, 0.5f, 0.0f, 0.0f), new Vector4f(-0.5f, -0.5f, 0.0f, 0.0f), new Vector4f(0.5f, -0.5f, 0.0f, 0.0f), new Vector4f(0.5f, 0.5f, 0.0f, 0.0f)};
    private Vector4f[] _c = new Vector4f[]{new Vector4f(), new Vector4f(), new Vector4f(), new Vector4f()};
    private static final float _d = (float)Math.sin(0.7853981633974483);
    private static final String _e = "rotationVec";
    private static final String _f = "billboardRotMatrix";
    private static final String _g = "mvpMatrix";
    private static final String _h = "diffuseMap";
    private static final String _i = "vertexPosition";
    private static uyuh _j = new uyuh("depth_particles_ds", 1, 1, fmfc._c, false, false, jhpr._a)._i();
    private int _k;
    private int _l;
    private kjui _m;
    private List<hsjl> _n = new ArrayList<hsjl>();
    private Matrix4f _o = new Matrix4f();
    private Vector3f _p = new Vector3f();
    private FloatBuffer _q = BufferUtils.createFloatBuffer(16);
    private static Minecraft _r = Minecraft._E();
    private uypf _s = new uypf();
    private boolean _t = true;
    private boolean _u = true;
    private int _v = 0;
    private float _w = 0.00390625f;
    private float _x = 0.00390625f;
    private boolean _y = false;
    private FloatBuffer _z = BufferUtils.createFloatBuffer(16);
    private FloatBuffer _A = BufferUtils.createFloatBuffer(16);

    public ejaq() {
        this._n.add(new fmgp());
        this._n.add(new hblc());
        this._n.add(new uysl());
        this._n.add(new rpja());
        this._n.add(new sbhg());
        this._n.add(new zxba());
        this._n.add(new uyot());
        this._n.add(new fmdl());
        this._o.m33 = 1.0f;
    }

    public void _a() {
        if (this._m != null) {
            this._m._c();
            this._m = null;
        }
        if (eidj._G) {
            this._m = new kjui(this._t);
        }
    }

    public float _b() {
        return this._w;
    }

    public float _c() {
        return this._x;
    }

    private void _a(boolean bl) {
        this._t = bl && eidj._G;
        this._a();
    }

    private void _d() {
        this._w = 0.5f / (float)eidj._a._g._a();
        this._x = 0.5f / (float)eidj._a._g._b();
        boolean bl = ClientProxy.softParticles.enabled;
        if (this._u != bl || !this._y) {
            this._y = true;
            this._u = bl;
            this._a(bl);
        }
        this._v = ClientProxy.particlesQuality.value;
    }

    public void _a(List<ncyh> list2, int n, float f) {
        jgro jgro2;
        boolean bl;
        this._d();
        if (this._t && !zwaw._n()) {
            return;
        }
        Minecraft._E().__ah._a("particles");
        Minecraft._E().__ah._a("start");
        GL11.glDisable(2896);
        GL11.glDisable(3008);
        boolean bl2 = bl = this._v > 0 && fmgg._a._c() && n == 0;
        if (zwaw._n()) {
            if (this._t) {
                zwaw._j()._a(fmfc._c, 0);
                zwaw._f()._b(2);
            }
            if (bl) {
                jgro._z();
                jgro2 = fmgg._a._a(this._v - 1);
                jgro2._a(false);
                jgro2._a(jgro2._j(), 0);
                GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GL11.glClear(16384);
                if (!this._t) {
                    _j._a(jgro2._c());
                    jgro2._a(_j, 0);
                    jgro._a(zwaw._j(), jgro2, 256, zwaw._j()._c(), jgro2._c());
                }
            }
        }
        GL11.glDepthMask(false);
        Minecraft._E()._h._a(wntj._a);
        GL11.glEnable(3042);
        GL11.glBlendFunc(1, 771);
        GL11.glAlphaFunc(516, 0.01f);
        this._o = eidj._a._w;
        this._q.clear();
        this._o.store(this._q);
        this._q.flip();
        Minecraft._E().__ah._c("sort");
        Collections.sort(list2, this._s);
        Minecraft._E().__ah._c("render");
        if (list2.size() > 0) {
            if (this._m != null) {
                if (!this._a) {
                    this._e();
                }
                this._c(list2, n, f);
            } else {
                if (this._a) {
                    this._f();
                }
                this._b(list2, n, f);
            }
        }
        if (zwaw._n()) {
            if (this._t) {
                zwaw._j()._a(zwaw._f(), 0);
            }
            if (bl) {
                jgro2 = fmgg._a._a(this._v - 1);
                jgro2._a(fmfc._c, 0);
                jgro2._j()._c()._b(0);
                jgro._A();
                hsmn._e();
                hsmn._c();
                hsmn._f();
            }
        }
        GL11.glDepthMask(true);
        GL11.glEnable(2896);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        Minecraft._E().__ah._b();
        Minecraft._E().__ah._b();
    }

    private void _e() {
        if (this._a) {
            return;
        }
        this._a = true;
        this._k = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(this._k);
        this._l = GL15.glGenBuffers();
        int n = this._m._b(_i);
        GL15.glBindBuffer(34962, this._l);
        GL20.glVertexAttribPointer(n, 4, 5126, false, 0, 0L);
        for (hsjl hsjl2 : this._n) {
            hsjl2._f = this._m._b(hsjl2._a);
            hsjl2._c = GL15.glGenBuffers();
            GL15.glBindBuffer(34962, hsjl2._c);
            GL20.glVertexAttribPointer(hsjl2._f, hsjl2._b, 5126, false, 0, 0L);
        }
        GL15.glBindBuffer(34962, 0);
        GL30.glBindVertexArray(0);
    }

    private void _f() {
        if (!this._a) {
            return;
        }
        this._a = false;
        for (hsjl hsjl2 : this._n) {
            hsjl2._e = null;
            GL15.glDeleteBuffers(hsjl2._c);
            hsjl2._f = 0;
            hsjl2._c = 0;
        }
        GL15.glDeleteBuffers(this._l);
        GL30.glDeleteVertexArrays(this._k);
    }

    protected void _b(List<ncyh> list2, int n, float f) {
        Tessellator tessellator = Tessellator.instance;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft._E()._D.enableLightmap(f);
        float f2 = tfss._h;
        float f3 = tfss._j;
        float f4 = tfss._k;
        float f5 = tfss._l;
        float f6 = tfss._i;
        tessellator.startDrawingQuads();
        for (ncyh ncyh2 : list2) {
            float f7 = ncyh2.prevAlpha + (ncyh2.alpha - ncyh2.prevAlpha) * f;
            float f8 = f7 * (1.0f - (ncyh2.prevBurn + (ncyh2.burn - ncyh2.prevBurn) * f));
            tessellator.setColorRGBA_F(f7, f7, f7, f8);
            tessellator.setBrightness(ncyh2.getBrightness());
            float f9 = ncyh2.renderTextureSize * _d;
            float f10 = ncyh2.renderTextureSize * _d;
            double d = ncyh2.renderPosX;
            double d2 = ncyh2.renderPosY;
            double d3 = ncyh2.renderPosZ;
            float f11 = (45.0f - ncyh2.prevRotation - (ncyh2.rotation - ncyh2.prevRotation) * f) * (float)Math.PI / 180.0f;
            float f12 = sajh._a(f11);
            float f13 = sajh._b(f11);
            ejcz ejcz2 = ncyh2.getIcon(n);
            tessellator.addVertexWithUV(d + (double)(f2 * f9 * f12) + (double)(f4 * f10 * f13), d2 + (double)(f6 * f10 * f13), d3 + (double)(f3 * f9 * f12) + (double)(f5 * f10 * f13), ejcz2.getMinU(), ejcz2.getMinV());
            tessellator.addVertexWithUV(d + (double)(f2 * f9 * f13) - (double)(f4 * f10 * f12), d2 - (double)(f6 * f10 * f12), d3 + (double)(f3 * f9 * f13) - (double)(f5 * f10 * f12), ejcz2.getMinU(), ejcz2.getMaxV());
            tessellator.addVertexWithUV(d - (double)(f2 * f9 * f12) - (double)(f4 * f10 * f13), d2 - (double)(f6 * f10 * f13), d3 - (double)(f3 * f9 * f12) - (double)(f5 * f10 * f13), ejcz2.getMaxU(), ejcz2.getMaxV());
            tessellator.addVertexWithUV(d - (double)(f2 * f9 * f13) + (double)(f4 * f10 * f12), d2 + (double)(f6 * f10 * f12), d3 - (double)(f3 * f9 * f13) + (double)(f5 * f10 * f12), ejcz2.getMaxU(), ejcz2.getMinV());
        }
        tessellator.draw();
        Minecraft._E()._D.disableLightmap(f);
    }

    protected void _c(List<ncyh> list2, int n, float f) {
        Object object;
        this._m._e();
        int n2 = 0;
        for (hsjl object22 : this._n) {
            object22._a(list2.size());
        }
        for (ncyh ncyh2 : list2) {
            for (hsjl hsjl2 : this._n) {
                hsjl2._a(ncyh2, n, f);
            }
            ++n2;
        }
        for (hsjl hsjl3 : this._n) {
            hsjl3._e.flip();
        }
        GL30.glBindVertexArray(this._k);
        if (this._t) {
            GL20.glUniform1i(this._m._i, 2);
            GL20.glUniform1f(this._m._j, 512.0f);
            object = jgro._y()._c();
            GL20.glUniform2f(this._m._k, ((Dimension)object).width, ((Dimension)object).height);
        }
        GL20.glUniformMatrix4(this._m._f, false, this._q);
        GL20.glUniform1i(this._m._h, 0);
        object = BufferUtils.createFloatBuffer(16);
        this._g().store((FloatBuffer)object);
        ((FloatBuffer)object).flip();
        GL20.glUniformMatrix4(this._m._l, false, (FloatBuffer)object);
        FloatBuffer floatBuffer = BufferUtils.createFloatBuffer(16);
        for (int i = 0; i < this._b.length; ++i) {
            Matrix4f.transform(this._o, this._b[i], this._c[i]).store(floatBuffer);
        }
        floatBuffer.flip();
        this._h();
        GL20.glUniform3f(this._m._e, this._p.x, this._p.y, this._p.z);
        GL15.glBindBuffer(34962, this._l);
        GL15.glBufferData(34962, floatBuffer, 35048);
        GL20.glEnableVertexAttribArray(this._m._d);
        GL33.glVertexAttribDivisor(this._m._d, 0);
        for (hsjl hsjl2 : this._n) {
            GL15.glBindBuffer(34962, hsjl2._c);
            if (hsjl2._g) {
                GL15.glBufferData(34962, hsjl2._e, 35048);
            } else {
                GL15.glBufferSubData(34962, 0L, hsjl2._e);
            }
            GL20.glEnableVertexAttribArray(hsjl2._f);
            GL33.glVertexAttribDivisor(hsjl2._f, hsjl2._d);
        }
        GL31.glDrawArraysInstanced(7, 0, 4, n2);
        GL20.glDisableVertexAttribArray(this._m._d);
        for (hsjl hsjl2 : this._n) {
            GL20.glDisableVertexAttribArray(hsjl2._f);
        }
        GL15.glBindBuffer(34962, 0);
        GL30.glBindVertexArray(0);
        GL20.glUseProgram(0);
    }

    private Matrix4f _g() {
        Matrix4f matrix4f = new Matrix4f();
        this._z.clear();
        this._A.clear();
        GL11.glGetFloat(2982, this._z);
        GL11.glGetFloat(2983, this._A);
        matrix4f.load(this._z);
        Matrix4f.mul((Matrix4f)new Matrix4f().load(this._A), matrix4f, matrix4f);
        return matrix4f;
    }

    public static float _a(float f, float f2, float f3) {
        float f4;
        for (f4 = f2 - f; f4 < -180.0f; f4 += 360.0f) {
        }
        while (f4 >= 180.0f) {
            f4 -= 360.0f;
        }
        return f + f3 * f4;
    }

    private void _h() {
        Vector3f vector3f = new Vector3f(this._c[0]);
        Vector3f vector3f2 = new Vector3f(this._c[1]);
        Vector3f vector3f3 = new Vector3f(this._c[2]);
        Vector3f vector3f4 = Vector3f.sub(vector3f2, vector3f, null);
        Vector3f vector3f5 = Vector3f.sub(vector3f3, vector3f, null);
        this._p = Vector3f.cross(vector3f4, vector3f5, null);
    }

    public int _a(ncyh ncyh2, int n) {
        float f = ncyh2.distanceSq;
        float f2 = ncyh2.renderTextureSize * ncyh2.renderTextureSize;
        float f3 = f2 * eidj._a._B / f;
        return Math.max(0, (int)(0.5 * Math.log((float)n / f3) / Math.log(2.0)));
    }

    private class kjui
    extends jxtc {
        private int _d;
        private int _e;
        private int _f;
        private int _g;
        private int _h;
        private int _i;
        private int _j;
        private int _k;
        private int _l;

        public kjui(boolean bl) {
            super("effects", bl ? "particlesoft" : "particle");
            int n = this._f();
            this._e = GL20.glGetUniformLocation(n, ejaq._e);
            this._f = GL20.glGetUniformLocation(n, ejaq._f);
            this._h = GL20.glGetUniformLocation(n, ejaq._h);
            this._l = GL20.glGetUniformLocation(n, ejaq._g);
            if (bl) {
                this._i = GL20.glGetUniformLocation(n, "depthBuffer");
                this._k = GL20.glGetUniformLocation(n, "resolution");
                this._j = GL20.glGetUniformLocation(n, "far");
            }
            this._d = GL20.glGetAttribLocation(n, ejaq._i);
        }
    }
}

