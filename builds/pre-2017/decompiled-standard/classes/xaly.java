/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class xaly
extends iwdo {
    static ResourceLocation _a = new ResourceLocation("weapons", "textures/flash/rifle_side.png");
    static ResourceLocation _b = new ResourceLocation("weapons", "textures/flash/rifle_front.png");
    static ResourceLocation[] _c = new ResourceLocation[]{_a, _b};
    private int _d = mamj._h.nextInt(4);
    private int _B = mamj._h.nextInt(4);

    public xaly(float f, float f2, boolean bl) {
        super(5, f, f2, bl);
    }

    @Override
    protected void _a(float f) {
        this._c(f);
        this._b();
        this._a(1.0f, 0.75f, 0.25f, 1.0f);
        this._b(f, 4.0f);
    }

    @Override
    protected void _b(float f) {
        this._c(f);
    }

    private void _c(float f) {
        if (f < 3.0f) {
            float f2 = 1.0f - f / 3.0f;
            float f3 = 0.6f - f * 0.05f;
            float f4 = f2 * (1.0f - f3);
            this._a(f2, f4);
            GL11.glBlendFunc(1, 771);
            mamj._e._h._a(_a);
            this._a(this._d, 2, 2);
            this._b(0.1f, 0.2f, 0.4f);
            mamj._e._h._a(_b);
            this._a(this._B, 2, 2);
            this._a(0.2f + f * 0.04f, this._n, 0.0f);
        }
    }

    static {
        fmib._a(_b, _a);
    }
}

