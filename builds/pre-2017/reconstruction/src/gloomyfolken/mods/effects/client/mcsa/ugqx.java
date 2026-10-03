/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.mcsa.ezfa;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.effects.client.mcsa.jgro;
import gloomyfolken.mods.effects.client.mcsa.jxsn;
import gloomyfolken.mods.effects.client.mcsa.jxtc;
import gloomyfolken.mods.effects.client.mcsa.qlgf;
import gloomyfolken.mods.effects.client.mcsa.tupg;
import gloomyfolken.mods.effects.client.mcsa.vjsq;
import gloomyfolken.mods.effects.client.mcsa.vjta;
import gloomyfolken.mods.effects.client.mcsa.zwat;
import gloomyfolken.mods.effects.client.mcsa.zwaw;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix3f;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

public class ugqx
extends uytm
implements zwaw {
    private static final zwat _c = new pidb();
    public final jxtc _a;
    public final tupg _b;
    private final kjui[] _d;
    private zwat _e = _c;
    private zwat _f = _c;
    private zwat _g = _c;

    public ugqx(ResourceLocation resourceLocation) {
        this(resourceLocation, jxtc.getDefaultMaterialPath(resourceLocation));
    }

    public ugqx(String string) {
        this(uyvo._a(string));
    }

    public ugqx(ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
        this((jxtc)hsju._a._d(resourceLocation), uyvo._d(resourceLocation2) ? (tupg)hsju._a._d(resourceLocation2) : null);
    }

    public ugqx(String string, String string2) {
        this(uyvo._a(string), uyvo._a(string2));
    }

    public ugqx(jxtc jxtc2, tupg tupg2) {
        super(null);
        this._a = jxtc2;
        this._b = tupg2;
        this._d = new kjui[jxtc2.getMeshes().size()];
    }

    public ugqx _a() {
        this.load(false);
        return this;
    }

    @Override
    protected void load() {
        int n = 0;
        while (n < this._d.length) {
            int n2 = n++;
            this.glTaskDelayed(() -> {
                kjui kjui2;
                qlgf qlgf2 = (qlgf)this._a.getMeshes().get(n2);
                this._d[n] = kjui2 = new kjui(qlgf2, this._b(qlgf2._m));
            });
        }
        this.glTaskDelayed(() -> this.mcFenceTask(() -> {
            this._f = new vjta(false, false, this._d);
            this._g = new vjta(false, true, this._d);
            this._e = new vjta(true, false, this._d);
            this.setLoaded();
        }));
    }

    @Override
    public void release() {
        for (int i = 0; i < this._d.length; ++i) {
            this._d[i]._a();
        }
    }

    public kjui _a(String string) {
        for (int i = 0; i < this._d.length; ++i) {
            if (!string.equals(this._d[i]._c._l)) continue;
            return this._d[i];
        }
        return null;
    }

    public jgro _b(String string) {
        if (this._b == null) {
            return jgro._C;
        }
        return this._b._a(string);
    }

    @Override
    public zwat getWrappedRenderHelper() {
        return this._d();
    }

    @Override
    public String toString() {
        return "McsaRenderer {" + this._a + "/" + this._b + "}";
    }

    public zwat _b() {
        return this._e;
    }

    public zwat _c() {
        return this._f;
    }

    public zwat _d() {
        return this._g;
    }

    public static class kjui {
        public static final int _a = 4;
        public static final int _b = 64;
        private static AtomicInteger _h = new AtomicInteger();
        private static FloatBuffer _i = BufferUtils.createFloatBuffer(16);
        private static FloatBuffer _j = BufferUtils.createFloatBuffer(256);
        private static FloatBuffer _k = BufferUtils.createFloatBuffer(192);
        public final qlgf _c;
        public final jgro _d;
        public jxsn _e;
        int _f;
        final int _g = _h.incrementAndGet();
        private static float[] _l = new float[3];
        private static Matrix4f _m = new Matrix4f();
        private static Matrix3f _n = new Matrix3f();
        private static Matrix4f _o = new Matrix4f();
        private static Matrix4f _p = new Matrix4f();
        private static Vector3f _q = new Vector3f();
        private static Quaternion _r = new Quaternion();
        private static IntBuffer _s = BufferUtils.createIntBuffer(4);

        kjui(qlgf qlgf2, jgro jgro2) {
            this._c = qlgf2;
            this._d = jgro2;
            if (qlgf2._s > 4) {
                throw new IllegalArgumentException("Mesh " + qlgf2 + " in model " + qlgf2._a + " has too many blend links: " + qlgf2._s);
            }
            if (qlgf2._o > 64) {
                throw new IllegalArgumentException("Mesh " + qlgf2 + " in model " + qlgf2._a + " has too many bones: " + qlgf2._o);
            }
            this._e = new jxsn.kjui(jgro2, qlgf2._r ? qlgf2._s : 0)._a();
        }

        void _a(boolean bl, boolean bl2, cucv cucv2) {
            if (bl2) {
                ezfc._a();
                ezfc._d();
            }
            if (bl) {
                this._a(cucv2);
            } else {
                this._a(cucv2 == null ? null : vjsq._a(cucv2));
            }
            if (bl2) {
                ezfc._b();
            }
        }

        void _a(cucv cucv2) {
            ezfa._a._a(this, cucv2);
        }

        void _a() {
            if (this._f != 0) {
                GL30.glDeleteVertexArrays(this._f);
                this._f = 0;
            }
        }

        void _a(ivtm ivtm2) {
            this._e._e();
            this._b(ivtm2);
            GL20.glUseProgram(0);
        }

        void _b(ivtm ivtm2) {
            boolean bl = this._c._r && ivtm2 != null;
            this._d();
            this._c();
            this._b();
            this._f();
            this._j();
            this._a(bl);
            this._e();
            this._a(ezfc._a);
            this._c(ivtm2);
            this._k();
            this._h();
        }

        void _c(ivtm ivtm2) {
            boolean bl;
            boolean bl2 = bl = this._c._r && ivtm2 != null;
            if (bl) {
                this._d(ivtm2);
            }
            GL11.glDrawElements(4, this._c._p * 3, this._c._p * 3 > 65535 ? 5125 : 5123, 0L);
        }

        void _a(Matrix4f matrix4f) {
            this._d._a(matrix4f, this._c._a.getQuantization()._a, this._c._g());
        }

        private void _a(int n) {
            kjui._l[0] = (float)(n >> 16 & 0xFF) / 255.0f;
            kjui._l[1] = (float)(n >> 8 & 0xFF) / 255.0f;
            kjui._l[2] = (float)(n & 0xFF) / 255.0f;
        }

        void _a(boolean bl) {
            int[] nArray = Minecraft._E()._D.lightmapColors;
            int n = nArray[(int)(iwya._d / 16.0f + iwya._e)];
            this._a(n);
            GL20.glUniform3f(this._e._J, _l[0], _l[1], _l[2]);
            if (this._c._r) {
                GL20.glUniform1i(this._e._n, bl ? 1 : 0);
            }
        }

        void _b() {
            jxsn jxsn2 = this._e;
            jgro jgro2 = this._d;
            float[] fArray = jgro2._g._d();
            float[] fArray2 = jgro2._f._d();
            float[] fArray3 = jgro2._h._d();
            GL20.glUniform3f(jxsn2._C, fArray[0], fArray[1], fArray[2]);
            GL20.glUniform3f(jxsn2._D, fArray2[0], fArray2[1], fArray2[2]);
            GL20.glUniform3f(jxsn2._E, fArray3[0], fArray3[1], fArray3[2]);
            GL20.glUniform1f(jxsn2._G, jgro2._i._a());
            if (jgro2._r._a()) {
                GL20.glUniform1f(jxsn2._H, jgro2._j._a());
                GL20.glUniform1f(jxsn2._I, jgro2._k._a());
            }
            if (jgro2._h._e()) {
                GL20.glUniform1f(jxsn2._F, jgro2._l._a());
            }
            if (jgro2._m._a()) {
                GL20.glUniform1i(jxsn2._u, jgro2._m._c());
            }
            if (jgro2._n._a()) {
                GL20.glUniform1i(jxsn2._v, jgro2._n._c());
            }
            if (jgro2._o._a()) {
                GL20.glUniform1i(jxsn2._w, jgro2._o._c());
                GL20.glUniform1i(jxsn2._z, jgro2._o._d().ordinal());
            }
            if (jgro2._p._a()) {
                GL20.glUniform1i(jxsn2._x, jgro2._p._c());
                GL20.glUniform1i(jxsn2._A, jgro2._p._d().ordinal());
            }
            if (jgro2._q._a()) {
                GL20.glUniform1i(jxsn2._y, jgro2._q._c());
                GL20.glUniform1i(jxsn2._B, jgro2._q._d().ordinal());
            }
            if (jgro2._b()) {
                GL20.glUniform1f(jxsn2._K, jgro2._u._a());
                GL20.glUniform1f(jxsn2._L, jgro2._v._a());
                GL20.glUniform1i(jxsn2._t, this._c(jgro2._e.length));
                if (jgro2._c()) {
                    GL20.glUniform1f(jxsn2._M, jgro2._w._a());
                    GL20.glUniform1f(jxsn2._O, jgro2._y._a());
                    GL20.glUniform1f(jxsn2._N, jgro2._x._a());
                }
            }
            if (jgro2._e.length == 0) {
                kjui._a(jxsn2._s, 0);
            } else {
                int[] nArray = new int[jgro2._e.length];
                for (int i = 0; i < nArray.length; ++i) {
                    nArray[i] = this._c(i);
                }
                kjui._a(jxsn2._s, nArray);
            }
            if (jgro2._B._a() != null) {
                jgro2._B._a().loadUniforms(this._e, this._d);
            }
        }

        void _c() {
            GL20.glUniform1f(this._e._q, this._c._a.getQuantization()._a);
            GL20.glUniform1f(this._e._r, this._c._a.getQuantization()._b);
        }

        void _d() {
            this._a(this._e._k, eidj._a._v);
            this._b(2983, _m);
            this._a(this._e._j, _m);
        }

        void _e() {
            this._b(ezfc._a);
        }

        void _b(Matrix4f matrix4f) {
            Matrix4f.mul(eidj._a._w, matrix4f, _m);
            this._a(this._e._l, _m);
            jywc._a(_n, _m);
            _n.invert();
            _n.transpose();
            _i.clear();
            _n.store(_i);
            _i.flip();
            GL20.glUniformMatrix3(this._e._m, false, _i);
        }

        void _a(int n, Matrix4f matrix4f) {
            _i.clear();
            matrix4f.store(_i);
            _i.flip();
            GL20.glUniformMatrix4(n, false, _i);
        }

        private void _b(int n, Matrix4f matrix4f) {
            _i.clear();
            GL11.glGetFloat(n, _i);
            matrix4f.load(_i);
        }

        private void _d(ivtm ivtm2) {
            _j.clear();
            _k.clear();
            for (int i = 0; i < this._c._o; ++i) {
                short s = this._c._t[i];
                Quaternion quaternion = ivtm2._b[s];
                Vector3f vector3f = ivtm2._a[s];
                Vector3f vector3f2 = this._c._a.getSkeleton()._e._a[s];
                _o.setIdentity();
                _o.translate(vector3f);
                Matrix4f.mul(_o, jywc._a(quaternion, _p), _o);
                _o.translate(vector3f2.negate(_q));
                jywc._a(_o, _r);
                _k.put(kjui._o.m30).put(kjui._o.m31).put(kjui._o.m32);
                _r.store(_j);
            }
            _j.flip();
            _k.flip();
            GL20.glUniform4(this._e._o, _j);
            GL20.glUniform3(this._e._p, _k);
        }

        void _f() {
            if (this._d._r._a()) {
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                GL11.glDepthMask(false);
            } else {
                GL11.glDisable(3042);
                GL11.glDepthMask(true);
            }
            GL11.glDisable(3008);
            this._g();
        }

        void _g() {
            for (int i = 0; i < this._d._e.length; ++i) {
                this._a(this._d._e[i], this._c(i));
            }
            if (this._d._b()) {
                ResourceLocation resourceLocation = gloomyfolken.mods.effects.client.main.pidb._a();
                int n = this._c(this._d._e.length);
                if (fmib._a(resourceLocation)) {
                    this._a(resourceLocation, n);
                } else {
                    this._d(n);
                }
            }
            if (this._d._B._a() != null) {
                this._d._B._a().bindTextures(this._e, this._d);
            }
        }

        void _h() {
            GL11.glDisable(3042);
            GL11.glDepthMask(true);
            GL11.glEnable(3008);
            this._i();
        }

        void _i() {
            for (int i = 0; i < this._d._e.length; ++i) {
                this._d(this._c(i));
            }
            if (this._d._b()) {
                this._d(this._c(this._d._e.length));
            }
        }

        void _j() {
            if (eidj._E) {
                if (this._f == 0) {
                    this._f = this._l();
                }
                GL30.glBindVertexArray(this._f);
            } else {
                this._m();
            }
        }

        private int _l() {
            int n = GL30.glGenVertexArrays();
            GL30.glBindVertexArray(n);
            this._m();
            GL30.glBindVertexArray(0);
            GL15.glBindBuffer(34962, 0);
            GL15.glBindBuffer(34963, 0);
            return n;
        }

        private void _m() {
            this._c._b._a();
            this._a(this._e._d, 4, 5122, true, this._c._e);
            this._a(this._e._f, 4, 5120, true, this._c._f);
            this._a(this._e._e, 2, 5122, true, this._c._g);
            if (this._c._a.hasTangents() && this._e._i >= 0) {
                this._a(this._e._i, 4, 5120, true, this._c._h);
            }
            if (this._c._r) {
                this._a(this._e._g, 4, 5121, false, this._c._i);
                if (this._c._s >= 3) {
                    this._a(this._e._h, 4, 5121, true, this._c._j);
                }
            }
            this._c._c._a();
        }

        private void _a(int n, int n2, int n3, boolean bl, long l) {
            if (n >= 0) {
                GL20.glVertexAttribPointer(n, n2, n3, bl, 0, l);
                GL20.glEnableVertexAttribArray(n);
            }
        }

        void _k() {
            if (eidj._E) {
                GL30.glBindVertexArray(0);
            } else {
                this._n();
            }
        }

        private void _n() {
            GL15.glBindBuffer(34962, 0);
            GL15.glBindBuffer(34963, 0);
            this._b(this._e._d);
            this._b(this._e._f);
            this._b(this._e._e);
            if (this._c._r) {
                this._b(this._e._g);
                if (this._c._s >= 3) {
                    this._b(this._e._h);
                }
            }
            if (this._c._a.hasTangents() && this._e._i >= 0) {
                this._b(this._e._i);
            }
        }

        private void _b(int n) {
            if (n >= 0) {
                GL20.glDisableVertexAttribArray(n);
            }
        }

        private int _c(int n) {
            return n == 0 ? 0 : n + 1;
        }

        private void _a(ResourceLocation resourceLocation, int n) {
            iwya._a(n + iwya._a);
            Minecraft._E()._h._a(resourceLocation);
            iwya._a(iwya._a);
        }

        private void _d(int n) {
            iwya._a(n + iwya._a);
            GL11.glBindTexture(3553, 0);
            iwya._a(iwya._a);
        }

        public static void _a(int n, int ... nArray) {
            if (_s.capacity() < nArray.length) {
                _s = BufferUtils.createIntBuffer(nArray.length);
            }
            _s.clear();
            _s.put(nArray);
            _s.flip();
            GL20.glUniform1(n, _s);
        }
    }

    private static class pidb
    implements zwaw {
        private pidb() {
        }

        @Override
        public zwat getWrappedRenderHelper() {
            return null;
        }
    }
}

