/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class dgtl
extends iwdo {
    static ResourceLocation _a = new ResourceLocation("weapons", "textures/flash/smoke_front.dds");
    static ResourceLocation _b = new ResourceLocation("weapons", "textures/flash/smoke_side.dds");
    static ResourceLocation[] _c = new ResourceLocation[]{_b, _a};
    private float[] _d = new float[3];

    protected dgtl(float f, float f2, boolean bl) {
        super(5, f, f2, bl);
        for (int i = 0; i < this._d.length; ++i) {
            this._d[i] = mamj._h.nextFloat() * 360.0f;
        }
    }

    @Override
    protected void _a(float f) {
        this._c(f);
        this._b();
        this._a(1.0f, 0.75f, 0.25f, 1.0f);
        this._b(f, 5.0f);
    }

    @Override
    protected void _b(float f) {
        this._c(f);
    }

    private void _c(float f) {
        if (f < 5.0f) {
            GL11.glBlendFunc(770, 771);
            mamj._e._h._a(_b);
            this._a(1.0f, 0.7f - f / 5.0f * 0.7f);
            this._c();
            this._b(0.2f, 0.1f, 0.4f);
            mamj._e._h._a(_a);
            for (int i = 0; i < this._d.length; ++i) {
                float f2 = f / 5.0f + (float)i * 0.05f;
                int n = this._a(9, f2, 1.0f);
                int n2 = Math.min(n + 1, 8);
                float f3 = f2 * 9.0f - (float)n;
                float f4 = (1.0f - f3) * 0.1f;
                this._a(1.0f, f4);
                this._a(n, 3, 3);
                this._a(0.1f + f2 * 0.05f, this._d[i], 0.0f);
                f4 = f3 * 0.1f;
                this._a(1.0f, f4);
                this._a(n2, 3, 3);
                this._a(0.1f + f2 * 0.05f, this._d[i], 0.0f);
            }
        }
    }

    static {
        fmib._a(_a, _b);
    }
}

