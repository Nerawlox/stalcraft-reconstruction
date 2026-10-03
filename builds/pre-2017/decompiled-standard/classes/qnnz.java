/*
 * Decompiled with CFR 0.152.
 */
import java.nio.FloatBuffer;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class qnnz
extends dykk {
    public static qnnz _e = new qnnz();
    public FloatBuffer _f = pklh._e(16);
    public FloatBuffer _g = pklh._e(16);
    public FloatBuffer _h = pklh._e(16);

    public static dykk _a() {
        _e._b();
        return _e;
    }

    public void _a(float[][] fArray, int n) {
        float f = sajh._c(fArray[n][0] * fArray[n][0] + fArray[n][1] * fArray[n][1] + fArray[n][2] * fArray[n][2]);
        float[] fArray2 = fArray[n];
        fArray2[0] = fArray2[0] / f;
        float[] fArray3 = fArray[n];
        fArray3[1] = fArray3[1] / f;
        float[] fArray4 = fArray[n];
        fArray4[2] = fArray4[2] / f;
        float[] fArray5 = fArray[n];
        fArray5[3] = fArray5[3] / f;
    }

    public void _b() {
        this._f.clear();
        this._g.clear();
        this._h.clear();
        GL11.glGetFloat(2983, this._f);
        GL11.glGetFloat(2982, this._g);
        this._f.flip().limit(16);
        this._f.get(this._b);
        this._g.flip().limit(16);
        this._g.get(this._c);
        this._d[0] = this._c[0] * this._b[0] + this._c[1] * this._b[4] + this._c[2] * this._b[8] + this._c[3] * this._b[12];
        this._d[1] = this._c[0] * this._b[1] + this._c[1] * this._b[5] + this._c[2] * this._b[9] + this._c[3] * this._b[13];
        this._d[2] = this._c[0] * this._b[2] + this._c[1] * this._b[6] + this._c[2] * this._b[10] + this._c[3] * this._b[14];
        this._d[3] = this._c[0] * this._b[3] + this._c[1] * this._b[7] + this._c[2] * this._b[11] + this._c[3] * this._b[15];
        this._d[4] = this._c[4] * this._b[0] + this._c[5] * this._b[4] + this._c[6] * this._b[8] + this._c[7] * this._b[12];
        this._d[5] = this._c[4] * this._b[1] + this._c[5] * this._b[5] + this._c[6] * this._b[9] + this._c[7] * this._b[13];
        this._d[6] = this._c[4] * this._b[2] + this._c[5] * this._b[6] + this._c[6] * this._b[10] + this._c[7] * this._b[14];
        this._d[7] = this._c[4] * this._b[3] + this._c[5] * this._b[7] + this._c[6] * this._b[11] + this._c[7] * this._b[15];
        this._d[8] = this._c[8] * this._b[0] + this._c[9] * this._b[4] + this._c[10] * this._b[8] + this._c[11] * this._b[12];
        this._d[9] = this._c[8] * this._b[1] + this._c[9] * this._b[5] + this._c[10] * this._b[9] + this._c[11] * this._b[13];
        this._d[10] = this._c[8] * this._b[2] + this._c[9] * this._b[6] + this._c[10] * this._b[10] + this._c[11] * this._b[14];
        this._d[11] = this._c[8] * this._b[3] + this._c[9] * this._b[7] + this._c[10] * this._b[11] + this._c[11] * this._b[15];
        this._d[12] = this._c[12] * this._b[0] + this._c[13] * this._b[4] + this._c[14] * this._b[8] + this._c[15] * this._b[12];
        this._d[13] = this._c[12] * this._b[1] + this._c[13] * this._b[5] + this._c[14] * this._b[9] + this._c[15] * this._b[13];
        this._d[14] = this._c[12] * this._b[2] + this._c[13] * this._b[6] + this._c[14] * this._b[10] + this._c[15] * this._b[14];
        this._d[15] = this._c[12] * this._b[3] + this._c[13] * this._b[7] + this._c[14] * this._b[11] + this._c[15] * this._b[15];
        this._a[0][0] = this._d[3] - this._d[0];
        this._a[0][1] = this._d[7] - this._d[4];
        this._a[0][2] = this._d[11] - this._d[8];
        this._a[0][3] = this._d[15] - this._d[12];
        this._a(this._a, 0);
        this._a[1][0] = this._d[3] + this._d[0];
        this._a[1][1] = this._d[7] + this._d[4];
        this._a[1][2] = this._d[11] + this._d[8];
        this._a[1][3] = this._d[15] + this._d[12];
        this._a(this._a, 1);
        this._a[2][0] = this._d[3] + this._d[1];
        this._a[2][1] = this._d[7] + this._d[5];
        this._a[2][2] = this._d[11] + this._d[9];
        this._a[2][3] = this._d[15] + this._d[13];
        this._a(this._a, 2);
        this._a[3][0] = this._d[3] - this._d[1];
        this._a[3][1] = this._d[7] - this._d[5];
        this._a[3][2] = this._d[11] - this._d[9];
        this._a[3][3] = this._d[15] - this._d[13];
        this._a(this._a, 3);
        this._a[4][0] = this._d[3] - this._d[2];
        this._a[4][1] = this._d[7] - this._d[6];
        this._a[4][2] = this._d[11] - this._d[10];
        this._a[4][3] = this._d[15] - this._d[14];
        this._a(this._a, 4);
        this._a[5][0] = this._d[3] + this._d[2];
        this._a[5][1] = this._d[7] + this._d[6];
        this._a[5][2] = this._d[11] + this._d[10];
        this._a[5][3] = this._d[15] + this._d[14];
        this._a(this._a, 5);
    }
}

