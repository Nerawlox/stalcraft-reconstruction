/*
 * Decompiled with CFR 0.152.
 */
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;

public abstract class hsjl {
    private static final int _h = 1000;
    public final String _a;
    public final int _b;
    public int _c;
    public int _d = 1;
    public FloatBuffer _e;
    public int _f;
    private int _i;
    public boolean _g = true;

    public hsjl(String string, int n) {
        this._a = string;
        this._b = n;
    }

    public abstract void _a(ncyh var1, int var2, float var3);

    public void _a(int n) {
        if (this._e == null) {
            this._e = BufferUtils.createFloatBuffer(Math.max(1000, n) * this._b);
        } else if (this._e.capacity() < n * this._b) {
            this._e = BufferUtils.createFloatBuffer(n * this._b);
        } else {
            this._e.clear();
        }
        if (n > this._i) {
            this._g = true;
            this._i = n;
        } else {
            this._g = false;
        }
    }
}

