/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

public class qozx {
    public static void _a(int n, int n2, int n3, int n4, int n5) {
        qozx._a(n, n3, n2, n5);
        qozx._a(n, n3, n4, n5);
        qozx._b(n, n2, n4, n5);
        qozx._b(n3, n2, n4, n5);
    }

    public static void _a(int n, int n2, int n3, int n4) {
        if (n2 < n) {
            int n5 = n;
            n = n2;
            n2 = n5;
        }
        qozx._b(n, n3, n2 + 1, n3 + 1, n4);
    }

    public static void _b(int n, int n2, int n3, int n4) {
        if (n3 < n2) {
            int n5 = n2;
            n2 = n3;
            n3 = n5;
        }
        qozx._b(n, n2 + 1, n + 1, n3, n4);
    }

    public static void _b(int n, int n2, int n3, int n4, int n5) {
        int n6;
        if (n < n3) {
            n6 = n;
            n = n3;
            n3 = n6;
        }
        if (n2 < n4) {
            n6 = n2;
            n2 = n4;
            n4 = n6;
        }
        float f = (float)(n5 >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n5 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.instance;
        GL11.glDisable(3553);
        GL11.glColor4f(f2, f3, f4, f);
        tessellator.startDrawingQuads();
        tessellator.addVertex(n, n4, 0.0);
        tessellator.addVertex(n3, n4, 0.0);
        tessellator.addVertex(n3, n2, 0.0);
        tessellator.addVertex(n, n2, 0.0);
        tessellator.draw();
        GL11.glEnable(3553);
    }

    public static void _a(int n, int n2, int n3, int n4, int n5, int n6) {
        float f = (float)(n5 >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n5 & 0xFF) / 255.0f;
        float f5 = (float)(n6 >> 24 & 0xFF) / 255.0f;
        float f6 = (float)(n6 >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n6 >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n6 & 0xFF) / 255.0f;
        GL11.glDisable(3553);
        GL11.glShadeModel(7425);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(f2, f3, f4, f);
        tessellator.addVertex(n3, n2, 0.0);
        tessellator.addVertex(n, n2, 0.0);
        tessellator.setColorRGBA_F(f6, f7, f8, f5);
        tessellator.addVertex(n, n4, 0.0);
        tessellator.addVertex(n3, n4, 0.0);
        tessellator.draw();
        GL11.glShadeModel(7424);
        GL11.glEnable(3553);
    }

    public static void _a(int n, int n2, int[] nArray) {
        if (nArray == null || nArray.length < 4) {
            return;
        }
        qozx._a(n, n2, nArray[4], nArray[5], nArray[0], nArray[1], nArray[2], nArray[3], 512.0, 512.0);
    }

    public static void _a(double d, double d2, double d3, double d4, double[] dArray) {
        if (dArray == null || dArray.length < 4) {
            return;
        }
        if (dArray.length > 4) {
            qozx._a(d, d2, d3, d4, dArray[0], dArray[1], dArray[2], dArray[3], dArray[4], dArray[5]);
        } else {
            qozx._a(d, d2, d3, d4, dArray[0], dArray[1], dArray[2], dArray[3]);
        }
    }

    public static void _a(double d, double d2, double d3, double d4, double d5, double d6) {
        qozx._a(d, d2, d5, d6, d3, d4, d3 + d5, d4 + d6, 256.0, 256.0);
    }

    public static void _a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        qozx._a(d, d2, d3, d4, d5, d6, d7, d8, 256.0, 256.0);
    }

    public static void _a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
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

