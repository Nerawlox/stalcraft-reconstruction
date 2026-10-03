/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class nuql
extends mamj {
    static ResourceLocation _a = new ResourceLocation("weapons", "textures/flash/shotgun_side.png");
    static ResourceLocation _b = new ResourceLocation("weapons", "textures/flash/shotgun_front.png");
    static ResourceLocation _c = new ResourceLocation("weapons", "textures/flash/sparks.dds");
    static ResourceLocation[] _d = new ResourceLocation[]{_a, _b, _c};
    private int _B = mamj._h.nextInt(4);
    private int _C = mamj._h.nextInt(4);
    private kjui[] _D;
    private pidb[] _E = new pidb[8];

    protected nuql(float f, float f2, boolean bl) {
        super(10, f, f2, bl);
        int n;
        for (n = 0; n < this._E.length; ++n) {
            this._E[n] = new pidb();
        }
        n = 15 + mamj._h.nextInt(10);
        this._D = new kjui[n];
        for (int i = 0; i < n; ++i) {
            this._D[i] = new kjui();
        }
    }

    @Override
    protected void _a(float f) {
        this._d(f);
        this._e(f);
        this._c(f);
    }

    @Override
    protected void _b(float f) {
        this._e(f);
    }

    private void _c(float f) {
        if (f < 10.0f) {
            float f2 = Math.min(1.0f, 2.0f - f / 20.0f) * 0.7f;
            this._a(1.0f, f2);
            GL11.glBlendFunc(1, 1);
            mamj._e._h._a(_c);
            for (int i = 0; i < this._D.length; ++i) {
                this._D[i]._a(f);
            }
        }
    }

    private void _d(float f) {
        if (f < 5.0f) {
            float f2 = Math.min(1.0f, 2.0f - f / 2.5f) * 0.2f;
            int n = 0;
            if (f > 1.5f) {
                n = 1;
            }
            if (f > 3.0f) {
                n = 2;
            }
            GL11.glBlendFunc(770, 771);
            this._a(1.0f, f2);
            this._a(n, 4, 1);
            mamj._e._h._a(mamj._g);
            for (int i = 0; i < this._E.length; ++i) {
                this._E[i]._a(f);
            }
        }
    }

    private void _e(float f) {
        if (f < 3.0f) {
            float f2 = Math.min(1.0f, 2.0f - f / 1.5f);
            float f3 = 0.55f - f * 0.05f;
            float f4 = f2 * (1.0f - f3);
            this._a(f2, f4);
            if (this._j) {
                GL11.glBlendFunc(771, 1);
            } else {
                GL11.glBlendFunc(1, 771);
            }
            mamj._e._h._a(_a);
            this._a(this._B, 2, 2);
            this._b(0.1f, 0.4f, 0.4f);
            GL11.glBlendFunc(1, 771);
            mamj._e._h._a(_b);
            this._a(this._C, 2, 2);
            this._a(0.2f + f * 0.04f, this._n, 0.0f);
        }
    }

    static {
        fmib._a(_b, _a, _c);
    }

    private class pidb {
        private Vector3f _b = new Vector3f((mamj._h.nextFloat() - 0.5f) * 0.15f, (mamj._h.nextFloat() - 0.5f) * 0.15f, -3.0f - mamj._h.nextFloat());

        public void _a(float f) {
            mamj._z.set(0.0f, 0.0f, 0.0f);
            nuql.this._a(mamj._z, this._b, 0.01f);
        }
    }

    private class kjui {
        private Vector3f _c;
        public int _a = mamj._h.nextInt(16);

        public kjui() {
            this._c = new Vector3f((mamj._h.nextFloat() - 0.5f) / 5.0f, (mamj._h.nextFloat() - 0.5f) / 5.0f, mamj._h.nextFloat() / 5.0f - 1.0f);
        }

        public void _a(float f) {
            float f2 = f * f * -0.005f;
            mamj._z.set(this._c).scale(f);
            mamj._z.y += f2;
            mamj._A.set(mamj._z).translate(this._c.x * 0.2f, this._c.y * 0.2f, this._c.z * 0.2f);
            nuql.this._a(this._a, 4, 4);
            nuql.this._a(mamj._z, mamj._A, 0.01f);
        }
    }
}

