/*
 * Decompiled with CFR 0.152.
 */
import org.lwjgl.opengl.GL11;

public class iepm {
    private long _c;
    private int _d;
    private long _e;
    private long _f;
    private long _g;
    public final String _a;
    public long _b;
    private boolean _h;

    public iepm(String string, int n, boolean bl) {
        this._a = string;
        this._g = n;
        this._h = bl;
    }

    public void _a() {
        if (this._h) {
            GL11.glFinish();
        }
        this._c = System.nanoTime();
    }

    public void _b() {
        if (this._h) {
            GL11.glFinish();
        }
        this._e += System.nanoTime() - this._c;
    }

    public void _c() {
        ++this._d;
        if (System.currentTimeMillis() - this._f > this._g && this._d > 0) {
            this._b = (long)((double)this._e / (double)this._d);
            this._d = 0;
            this._e = 0L;
            this._f = System.currentTimeMillis();
        }
    }
}

