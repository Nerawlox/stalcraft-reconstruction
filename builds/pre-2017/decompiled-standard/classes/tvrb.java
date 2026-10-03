/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;

public class tvrb {
    public final hbmu _a;
    public final ssnu _b;
    public final int _c;
    public final int _d;
    public final int _e;
    public final int _f;
    public final int _g;
    private final int _h;
    private tvlz[] _i;

    public tvrb(hbmu hbmu2, ssnu ssnu2, int n) {
        this._a = hbmu2;
        this._b = ssnu2;
        this._c = n;
        this._d = hbmu2._c - this._c;
        this._e = hbmu2._b(n);
        this._f = hbmu2._c(n);
        this._g = GL11.glGenTextures();
        this._h = hbmu2._e ? 34067 : 3553;
        GL13.glActiveTexture(33999);
        GL11.glBindTexture(this._h, this._g);
        ssnu2._a(this._h, this._d);
        this._i = new tvlz[this._d * (hbmu2._e ? 6 : 1)];
        GL13.glActiveTexture(33984);
    }

    public static tvrb _a(tvrb tvrb2, int n) {
        ogai._y();
        tvrb tvrb3 = new tvrb(tvrb2._a, tvrb2._b, n);
        int n2 = Math.min(tvrb2._a(), tvrb3._a());
        int n3 = tvrb2._a() - n2;
        int n4 = tvrb3._a() - n2;
        tvrb3._a(tvrb2, n2, n3, n4);
        return tvrb3;
    }

    public int _a() {
        return this._a._c - this._c;
    }

    public int _a(int n) {
        return this._a._a(n + this._c);
    }

    public int _b(int n) {
        return this._a._b(n + this._c);
    }

    public int _c(int n) {
        return this._a._c(n + this._c);
    }

    public void _a(temw.kjui[] kjuiArray) {
        GL13.glActiveTexture(33999);
        GL11.glBindTexture(this._h, this._g);
        for (int i = 0; i < kjuiArray.length; ++i) {
            temw.kjui kjui2 = kjuiArray[i];
            int n = this._a._e ? 34069 + kjui2._b : this._h;
            int n2 = kjui2._a - this._c;
            int n3 = this._b(n2);
            int n4 = this._c(n2);
            if (this._a._d._p) {
                GL13.glCompressedTexImage2D(n, n2, this._a._d._m, n3, n4, 0, kjui2._c._a());
                continue;
            }
            GL11.glTexImage2D(n, n2, this._a._d._m, n3, n4, 0, this._a._d._n, this._a._d._o, kjui2._c._a());
        }
        GL13.glActiveTexture(33984);
    }

    public ByteBuffer _a(int n, int n2, boolean bl) {
        boolean bl2 = this._i[this._b(n, n2)] != null;
        tvlz tvlz2 = this._c(n, n2);
        if (tvlz2._c()) {
            throw new IllegalStateException("Level is already locked!");
        }
        ByteBuffer byteBuffer = tvlz2._a(0, tvlz2._c, bl, !bl && bl2);
        tvlz2._b();
        return byteBuffer;
    }

    public void _a(int n, int n2) {
        int n3 = this._b(n, n2);
        tvlz tvlz2 = this._i[n3];
        if (tvlz2 == null) {
            throw new IllegalStateException("Pixel buffer is not created!");
        }
        tvlz2._d();
        GL13.glActiveTexture(33999);
        GL11.glBindTexture(this._h, this._g);
        int n4 = this._a._e ? 34069 + n2 : this._h;
        int n5 = this._a(n);
        int n6 = this._b(n);
        int n7 = this._c(n);
        if (this._a._d._p) {
            GL13.glCompressedTexImage2D(n4, n, this._a._d._m, n6, n7, 0, n5, 0L);
        } else {
            GL11.glTexImage2D(n4, n, this._a._d._m, n6, n7, 0, this._a._d._n, this._a._d._o, 0L);
        }
        GL13.glActiveTexture(33984);
        tvlz2._b();
        tvlz2._e();
        this._i[n3] = null;
    }

    public void _b() {
        GL11.glDeleteTextures(this._g);
    }

    private int _b(int n, int n2) {
        return n * this._a._b() + n2;
    }

    private tvlz _c(int n, int n2) {
        int n3 = this._b(n, n2);
        if (this._i[n3] == null) {
            this._i[n3] = new tvlz(35052, 35040, this._a(n));
        }
        return this._i[n3];
    }

    private void _a(tvrb tvrb2, int n, int n2, int n3) {
        GL13.glActiveTexture(33999);
        for (int i = 0; i < this._a._b(); ++i) {
            for (int j = 0; j < n; ++j) {
                int n4;
                int n5 = j + n2;
                int n6 = j + n3;
                int n7 = Math.max(this._e >> n6, 1);
                int n8 = Math.max(this._f >> n6, 1);
                int n9 = this._a(n6);
                tvlz tvlz2 = new tvlz(35052, 35040, n9);
                GL15.glBindBuffer(35051, tvlz2._e);
                GL11.glBindTexture(tvrb2._h, tvrb2._g);
                int n10 = n4 = this._a._e ? 34069 + i : this._h;
                if (this._a._d._p) {
                    GL13.glGetCompressedTexImage(n4, n5, 0L);
                } else {
                    GL11.glGetTexImage(n4, n5, this._a._d._n, this._a._d._o, 0L);
                }
                GL11.glBindTexture(this._h, this._g);
                if (this._a._d._p) {
                    GL13.glCompressedTexImage2D(n4, n6, this._a._d._m, n7, n8, 0, n9, 0L);
                } else {
                    GL11.glTexImage2D(n4, n6, this._a._d._m, n7, n8, 0, this._a._d._n, this._a._d._o, 0L);
                }
                tvlz2._b();
                GL15.glBindBuffer(35051, 0);
                tvlz2._e();
            }
        }
        GL13.glActiveTexture(33984);
    }
}

