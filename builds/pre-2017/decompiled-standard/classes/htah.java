/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class htah
extends iwdo {
    static ResourceLocation _a = new ResourceLocation("weapons", "textures/flash/gauss_front.dds");
    static ResourceLocation _b = new ResourceLocation("weapons", "textures/flash/gauss_gradient.dds");
    static ResourceLocation _c = new ResourceLocation("weapons", "textures/flash/gauss_dist.dds");
    static ResourceLocation[] _d = new ResourceLocation[]{_b, _a, _c};
    private float[] _B = new float[4];

    protected htah(float f, float f2, boolean bl) {
        super(5, f, f2, bl);
        for (int i = 0; i < this._B.length; ++i) {
            this._B[i] = mamj._h.nextFloat() * 360.0f;
        }
    }

    @Override
    protected void _a(float f) {
        GL11.glPushMatrix();
        this._b();
        this._a(0.4f, 0.4f, 1.0f, 1.0f);
        for (int i = 0; i < 3; ++i) {
            this._b(f, 5.0f);
        }
        float f2 = f / 3.0f;
        this._c();
        GL11.glBlendFunc(770, 771);
        eidj._a._c._a(true);
        mamj._e._h._a(_c);
        for (int i = 4; i > 0; --i) {
            if (!(f2 >= (float)i * 0.05f)) continue;
            this._a(1.0f, 0.2f - f2 * 0.2f + (float)i * 0.05f);
            Vector3f vector3f = Vector3f.sub(this._y, this._x, null);
            Vector3f vector3f2 = new Vector3f(0.0f, 1.0f, 0.0f);
            Vector3f vector3f3 = new Vector3f((float)((double)this._x.x - gqqu._d), (float)((double)this._x.y - gqqu._e), (float)((double)this._x.z - gqqu._f));
            Vector3f vector3f4 = (Vector3f)vector3f.normalise(null).scale(1.5f + (float)i);
            Vector3f vector3f5 = Vector3f.cross(vector3f2, vector3f, null);
            Vector3f vector3f6 = Vector3f.cross(vector3f, vector3f5, null);
            Vector3f vector3f7 = Vector3f.cross(vector3f, vector3f6, null);
            Vector3f vector3f8 = Vector3f.cross(vector3f, vector3f7, null);
            vector3f5.normalise().scale(0.4f + f2 * 0.05f - (float)i * 0.025f);
            Vector3f.add(vector3f5, vector3f3, vector3f5);
            Vector3f.add(vector3f5, vector3f4, vector3f5);
            vector3f6.normalise().scale(0.4f + f2 * 0.05f - (float)i * 0.025f);
            Vector3f.add(vector3f6, vector3f3, vector3f6);
            Vector3f.add(vector3f6, vector3f4, vector3f6);
            vector3f7.normalise().scale(0.4f + f2 * 0.05f - (float)i * 0.025f);
            Vector3f.add(vector3f7, vector3f3, vector3f7);
            Vector3f.add(vector3f7, vector3f4, vector3f7);
            vector3f8.normalise().scale(0.4f + f2 * 0.05f - (float)i * 0.025f);
            Vector3f.add(vector3f8, vector3f3, vector3f8);
            Vector3f.add(vector3f8, vector3f4, vector3f8);
            mamj._f.func_78382_b();
            mamj._f.func_78369_a(this._s, this._t, this._u, this._v);
            mamj._f.func_78374_a(vector3f5.x, vector3f5.y, vector3f5.z, this._o, this._r);
            mamj._f.func_78374_a(vector3f6.x, vector3f6.y, vector3f6.z, this._o, this._p);
            mamj._f.func_78374_a(vector3f7.x, vector3f7.y, vector3f7.z, this._q, this._p);
            mamj._f.func_78374_a(vector3f8.x, vector3f8.y, vector3f8.z, this._q, this._r);
            mamj._f.func_78381_a();
        }
        eidj._a._c._a(true, true);
        GL11.glDisable(2896);
        GL11.glPopMatrix();
        this._c(f);
    }

    @Override
    protected void _b(float f) {
        GL11.glBlendFunc(770, 1);
        mamj._e._h._a(_a);
        float f2 = f / 3.0f;
        int n = this._a(4, f2, 1.0f);
        int n2 = Math.min(n + 1, 3);
        float f3 = f2 * 4.0f - (float)n;
        for (int i = 0; i < 4; ++i) {
            this._a(1.0f, (1.0f - f3) * (1.0f - f2));
            this._a(n, 2, 2);
            this._a(0.2f - f2 * 0.2f, this._B[i], 0.0f);
            this._a(1.0f, f3 * 0.5f * (1.0f - f2));
            this._a(n2, 2, 2);
            this._a(0.2f - f2 * 0.2f, this._B[i], 0.0f);
        }
    }

    private void _c(float f) {
        float f2 = f / 3.0f;
        this._c();
        if (f2 > 1.0f) {
            return;
        }
        GL11.glBlendFunc(770, 1);
        mamj._e._h._a(_a);
        int n = this._a(4, f2, 1.0f);
        int n2 = Math.min(n + 1, 3);
        float f3 = f2 * 4.0f - (float)n;
        for (int i = 0; i < 4; ++i) {
            this._a(1.0f, (1.0f - f3) * (1.0f - f2));
            this._a(n, 2, 2);
            this._a(0.2f - f2 * 0.2f, this._B[i], -f2 * (0.3f + (float)i * 0.2f));
            this._a(1.0f, f3 * 0.5f * (1.0f - f2));
            this._a(n2, 2, 2);
            this._a(0.2f - f2 * 0.2f, this._B[i], -f2 * (0.3f + (float)i * 0.2f));
        }
        this._a(0.6f, 0.6f, 1.0f, 1.0f - f2);
        mamj._e._h._a(_b);
        this._c();
        this._a(0.8f, 0.0f, 0.0f);
    }

    static {
        fmib._a(_a, _b, _c);
    }
}

