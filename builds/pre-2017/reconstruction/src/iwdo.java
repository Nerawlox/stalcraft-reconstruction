/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.renderer.entity.RenderManager;
import org.lwjgl.opengl.GL11;

public abstract class iwdo
extends mamj {
    protected iwdo(int n, float f, float f2, boolean bl) {
        super(n, f, f2, bl);
    }

    protected void _b(float f, float f2) {
        if (f < f2) {
            GL11.glBlendFunc(770, 1);
            this._v = 1.0f - f / f2;
            mamj._e._h._a(mamj._g);
            int n = 0;
            if (f > f2 / 4.0f) {
                n = 1;
            } else if (f > f2 / 2.0f) {
                n = 2;
            }
            this._a(n, 4, 1);
            mamj._z.set((float)((double)this._x.x - RenderManager._d), (float)((double)this._x.y - RenderManager._e + (double)0.05f), (float)((double)this._x.z - RenderManager._f));
            mamj._A.set((float)((double)this._y.x - RenderManager._d), (float)((double)this._y.y - RenderManager._e), (float)((double)this._y.z - RenderManager._f));
            this._a(mamj._z, mamj._A, 0.1f);
        }
    }
}

