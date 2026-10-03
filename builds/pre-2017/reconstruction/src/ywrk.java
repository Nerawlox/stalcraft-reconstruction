/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.renderer.Tessellator;

public class ywrk {
    private int _a;
    private int _b;
    private static ywrk _c;

    public static ywrk _a() {
        if (_c == null) {
            _c = new ywrk();
        }
        return _c;
    }

    public void _a(int n, int n2) {
        this._a = n;
        this._b = n2;
    }

    public void _a(int n, int n2, int[] nArray) {
        if (nArray == null || nArray.length < 4) {
            return;
        }
        this._a(n, n2, nArray[4], nArray[5], nArray[0], nArray[1], nArray[2], nArray[3], 512.0, 512.0);
    }

    public void _a(int n, int n2, int n3, int n4, int[] nArray) {
        if (nArray == null || nArray.length < 4) {
            return;
        }
        if (nArray.length > 4) {
            this._a(n, n2, n3, n4, nArray[0], nArray[1], nArray[2], nArray[3], nArray[4], nArray[5]);
        } else {
            this._a(n, n2, n3, n4, nArray[0], nArray[1], nArray[2], nArray[3]);
        }
    }

    public void _a(int n, int n2, int n3, int n4, int n5, int n6) {
        this._a(n, n2, n5, n6, n3, n4, n3 + n5, n4 + n6, 256.0, 256.0);
    }

    public void _a(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this._a(n, n2, n3, n4, n5, n6, n7, n8, 256.0, 256.0);
    }

    public void _a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = 1.0 / d9;
        double d12 = 1.0 / d10;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(d, d2 + d4, 0.0, (double)((float)d5) * d11, (double)((float)d8) * d12);
        tessellator.addVertexWithUV(d + d3, d2 + d4, 0.0, (double)((float)d7) * d11, (double)((float)d8) * d12);
        tessellator.addVertexWithUV(d + d3, d2, 0.0, (double)((float)d7) * d11, (double)((float)d6) * d12);
        tessellator.addVertexWithUV(d, d2, 0.0, (double)((float)d5) * d11, (double)((float)d6) * d12);
        tessellator.draw();
    }
}

