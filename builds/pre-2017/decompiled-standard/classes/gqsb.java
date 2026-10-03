/*
 * Decompiled with CFR 0.152.
 */
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;

public class gqsb {
    public int _a;
    public int _b;
    public int _c;
    public double _d;
    public double _e;
    public double _f;
    public IntBuffer _g = pklh._d(65536);
    public boolean _h;
    public boolean _i;

    public void _a(int n, int n2, int n3, double d, double d2, double d3) {
        this._h = true;
        this._g.clear();
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = d;
        this._e = d2;
        this._f = d3;
    }

    public boolean _a(int n, int n2, int n3) {
        if (!this._h) {
            return false;
        }
        return n == this._a && n2 == this._b && n3 == this._c;
    }

    public void _a(int n) {
        this._g.put(n);
        if (this._g.remaining() == 0) {
            this._a();
        }
    }

    public void _a() {
        if (!this._h) {
            return;
        }
        if (!this._i) {
            this._g.flip();
            this._i = true;
        }
        if (this._g.remaining() > 0) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((double)this._a - this._d), (float)((double)this._b - this._e), (float)((double)this._c - this._f));
            GL11.glCallLists(this._g);
            GL11.glPopMatrix();
        }
    }

    public void _b() {
        this._h = false;
        this._i = false;
    }
}

