/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ndpk
extends iwdo {
    static ResourceLocation _a = new ResourceLocation("weapons", "textures/flash/heavy_front.png");
    private float[] _c = new float[5];
    static ResourceLocation[] _b = new ResourceLocation[]{_a};

    protected ndpk(float f, float f2, boolean bl) {
        super(10, f, f2, bl);
        for (int i = 0; i < this._c.length; ++i) {
            this._c[i] = mamj._h.nextFloat() * 360.0f;
        }
    }

    @Override
    protected void _a(float f) {
        this._c(f);
        this._b();
        this._a(1.0f, 1.0f, 0.5f, 1.0f);
        this._b(f, 4.0f);
    }

    @Override
    protected void _b(float f) {
        this._c(f);
    }

    private void _c(float f) {
        if (f < 10.0f) {
            GL11.glBlendFunc(1, 771);
            mamj._e._h._a(_a);
            float f2 = f / 10.0f;
            float f3 = 0.9f - f2 * 0.9f;
            int n = this._a(9, f2, 1.0f);
            int n2 = Math.min(n + 1, 8);
            float f4 = f2 * 9.0f - (float)n;
            for (int i = 0; i < 5; ++i) {
                float f5 = (1.0f - f4) * 0.5f;
                float f6 = f5 * (1.0f - f3);
                this._a(f5, f5 * 0.9f, f5, f6);
                this._a(n, 3, 3);
                this._a(0.1f + f2 * 0.05f, this._c[i], 0.0f);
                f5 = f4 * 0.5f;
                f6 = f5 * (1.0f - f3);
                this._a(f5, f5 * 0.9f, f5, f6);
                this._a(n2, 3, 3);
                this._a(0.1f + f2 * 0.05f, this._c[i], 0.0f);
            }
        }
    }

    static {
        fmib._b(_a);
    }
}

