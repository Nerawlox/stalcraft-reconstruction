/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.mcsa.ezfa;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import java.nio.FloatBuffer;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix3f;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public abstract class mamj
extends ezfa.pidb {
    protected static Minecraft _e = Minecraft._E();
    protected static Tessellator _f = Tessellator.instance;
    static ResourceLocation _g = new ResourceLocation("weapons", "textures/flash/tracer.dds");
    protected static Random _h = new Random();
    public final int _i;
    public final boolean _j;
    public int _k;
    protected final float _l;
    protected final float _m;
    protected final float _n = _h.nextFloat() * 360.0f;
    protected float _o;
    protected float _p;
    protected float _q;
    protected float _r;
    protected float _s;
    protected float _t;
    protected float _u;
    protected float _v;
    protected static FloatBuffer _w;
    private float _a;
    private float _b;
    protected Vector3f _x;
    protected Vector3f _y;
    protected static Vector3f _z;
    protected static Vector3f _A;
    private static Vector3f _c;
    private static Vector3f _d;

    protected mamj(int n, float f, float f2, boolean bl) {
        this._i = n;
        this._l = f;
        this._m = f2;
        this._j = bl;
    }

    public void _a() {
        this.load();
        ezfa._a._a(this);
    }

    @Override
    protected boolean isSolid() {
        return false;
    }

    @Override
    protected void render(float f) {
        this._c();
        this._d();
        ezfc._a();
        ezfc._a(this.modelView);
        GL11.glPushMatrix();
        ezfc._e();
        GL11.glTranslatef(0.0f, 0.0f, this._l);
        GL11.glScalef(this._m, this._m, this._m);
        iwya._a(iwya._b, 240.0f, 0.0f);
        GL11.glDisable(2896);
        GL11.glDisable(2884);
        GL11.glDisable(3008);
        float f2 = (float)this._k + f;
        if (this._j) {
            this._c(f);
            this._a(f2);
        } else {
            this._b(f2);
        }
        GL11.glEnable(3008);
        GL11.glEnable(2884);
        GL11.glEnable(2896);
        GL11.glPopMatrix();
        ezfc._b();
    }

    private void _c(float f) {
        this._a = mamj._e._t.prevRotationYaw + (mamj._e._u.rotationYaw - mamj._e._u.prevRotationYaw) * f;
        this._b = mamj._e._t.prevRotationPitch + (mamj._e._u.rotationPitch - mamj._e._u.prevRotationPitch) * f;
        if (this._x == null) {
            _w.clear();
            GL11.glGetFloat(2982, _w);
            Matrix4f matrix4f = new Matrix4f();
            matrix4f.load(_w);
            Matrix3f matrix3f = jywc._a(-this._b, 1.0f, 0.0f, 0.0f);
            Matrix3f matrix3f2 = jywc._a(180.0f - this._a, 0.0f, 1.0f, 0.0f);
            Matrix3f matrix3f3 = Matrix3f.mul(matrix3f2, matrix3f, null);
            Vector4f vector4f = Matrix4f.transform(matrix4f, new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), null);
            this._x = Matrix3f.transform(matrix3f3, new Vector3f(vector4f.x, vector4f.y, vector4f.z), null);
            Vector4f vector4f2 = new Vector4f(0.0f, 0.0f, -50.0f, 1.0f);
            this._y = Matrix3f.transform(matrix3f3, new Vector3f(vector4f2.x, vector4f2.y, vector4f2.z), null);
            this._x.translate((float)RenderManager._d, (float)RenderManager._e, (float)RenderManager._f);
            this._y.translate((float)RenderManager._d, (float)RenderManager._e, (float)RenderManager._f);
        }
    }

    protected void _b() {
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, 1.0f);
        GL11.glRotatef(this._b, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(this._a + 180.0f, 0.0f, 1.0f, 0.0f);
    }

    protected abstract void _a(float var1);

    protected abstract void _b(float var1);

    protected void _c() {
        this._p = 0.0f;
        this._o = 0.0f;
        this._r = 1.0f;
        this._q = 1.0f;
    }

    protected void _a(int n, int n2, int n3) {
        this._o = (float)(n % n3) / (float)n3 + 1.0E-4f;
        this._q = (float)(n % n3 + 1) / (float)n3 - 1.0E-4f;
        this._p = (float)(n / n3) / (float)n2 + 1.0E-4f;
        this._r = (float)(n / n3 + 1) / (float)n2 - 1.0E-4f;
    }

    protected void _a(float f, float f2, float f3, float f4) {
        this._s = f;
        this._t = f2;
        this._u = f3;
        this._v = f4;
    }

    protected void _a(float f, float f2) {
        this._a(f, f, f, f2);
    }

    protected void _d() {
        this._a(1.0f, 1.0f, 1.0f, 1.0f);
    }

    protected void _a(float f, float f2, float f3) {
        float f4 = sajh._a(f2 * (float)Math.PI / 180.0f);
        float f5 = sajh._b(f2 * (float)Math.PI / 180.0f);
        _f.startDrawingQuads();
        _f.setColorRGBA_F(this._s, this._t, this._u, this._v);
        _f.addVertexWithUV(-(f /= 2.0f) * f5 + f * f4, -f * f4 - f * f5, f3, this._o, this._r);
        _f.addVertexWithUV(-f * f5 - f * f4, -f * f4 + f * f5, f3, this._o, this._p);
        _f.addVertexWithUV(f * f5 - f * f4, f * f4 + f * f5, f3, this._q, this._p);
        _f.addVertexWithUV(f * f5 + f * f4, f * f4 - f * f5, f3, this._q, this._r);
        _f.draw();
    }

    protected void _b(float f, float f2, float f3) {
        _z.set(0.0f, 0.0f, f);
        _A.set(0.0f, 0.0f, f - f3);
        this._a(_z, _A, f2);
    }

    protected void _a(Vector3f vector3f, Vector3f vector3f2, float f) {
        _w.clear();
        GL11.glGetFloat(2982, _w);
        float f2 = -(_w.get(0) * _w.get(12) + _w.get(1) * _w.get(13) + _w.get(2) * _w.get(14));
        float f3 = -(_w.get(4) * _w.get(12) + _w.get(5) * _w.get(13) + _w.get(6) * _w.get(14));
        float f4 = -(_w.get(8) * _w.get(12) + _w.get(9) * _w.get(13) + _w.get(10) * _w.get(14));
        _c.set(f2, f3, f4);
        Vector3f.cross(_c, vector3f2, _d);
        if (_d.lengthSquared() > 1.0E-6f) {
            _d.normalise();
            _d.scale(f / 2.0f);
            _f.startDrawingQuads();
            _f.setColorRGBA_F(this._s, this._t, this._u, this._v);
            _f.addVertexWithUV(vector3f2.x - mamj._d.x, vector3f2.y - mamj._d.y, vector3f2.z - mamj._d.z, this._q, this._r);
            _f.addVertexWithUV(vector3f.x - mamj._d.x, vector3f.y - mamj._d.y, vector3f.z - mamj._d.z, this._o, this._r);
            _f.addVertexWithUV(vector3f.x + mamj._d.x, vector3f.y + mamj._d.y, vector3f.z + mamj._d.z, this._o, this._p);
            _f.addVertexWithUV(vector3f2.x + mamj._d.x, vector3f2.y + mamj._d.y, vector3f2.z + mamj._d.z, this._q, this._p);
            _f.draw();
        }
    }

    protected int _a(int n, float f, float f2) {
        return sajh._a((int)(f / f2 * (float)n), 0, n - 1);
    }

    static {
        fmib._b(_g);
        _w = BufferUtils.createFloatBuffer(16);
        _z = new Vector3f();
        _A = new Vector3f();
        _c = new Vector3f();
        _d = new Vector3f();
    }
}

