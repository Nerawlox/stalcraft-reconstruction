/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

public class owxf {
    private static float _a;
    private static float _b;

    public static void _a() {
        _a = iwya._d;
        _b = iwya._e;
    }

    public static void _b() {
        iwya._d = _a;
        iwya._e = _b;
    }

    public static float _a(float f, float f2, float f3) {
        float f4;
        for (f4 = f2 - f; f4 < -180.0f; f4 += 360.0f) {
        }
        while (f4 >= 180.0f) {
            f4 -= 360.0f;
        }
        return f + f3 * f4;
    }

    public static void _a(double d, double d2, double d3, double d4, double d5, double d6) {
        owxf._a(d, d2, d3, d4, d5, d6, 1.0);
    }

    public static void _a(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        Tessellator tessellator = Tessellator.instance;
        double d8 = d2;
        double d9 = d3;
        if (d4 != 0.0) {
            for (double d10 = d; d10 <= d + d4; d10 += d7) {
                tessellator.addVertex(d10, d2, d3);
                tessellator.addVertex(d10, d2 + d5, d3 + d6);
            }
        }
        if (d5 != 0.0) {
            while (d8 <= d2 + d5) {
                tessellator.addVertex(d, d8, d3);
                tessellator.addVertex(d + d4, d8, d3 + d6);
                d8 += d7;
            }
        }
        if (d6 != 0.0) {
            while (d9 <= d3 + d6) {
                tessellator.addVertex(d, d2, d9);
                tessellator.addVertex(d + d4, d2 + d5, d9);
                d9 += d7;
            }
        }
    }

    public static void _a(AxisAlignedBB axisAlignedBB, float f, float f2, float f3) {
        GL11.glPushAttrib(1048575);
        GL11.glDisable(3553);
        GL11.glDisable(2896);
        GL11.glColor4f(f, f2, f3, 1.0f);
        GL11.glLineWidth(3.0f);
        GL11.glBegin(1);
        GL11.glVertex3d(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._d);
        GL11.glVertex3d(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._d);
        GL11.glVertex3d(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._d);
        GL11.glVertex3d(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._g);
        GL11.glVertex3d(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._g);
        GL11.glVertex3d(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._g);
        GL11.glVertex3d(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._g);
        GL11.glVertex3d(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._d);
        GL11.glVertex3d(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._d);
        GL11.glVertex3d(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._d);
        GL11.glVertex3d(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._d);
        GL11.glVertex3d(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._g);
        GL11.glVertex3d(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._g);
        GL11.glVertex3d(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._g);
        GL11.glVertex3d(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._g);
        GL11.glVertex3d(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._d);
        GL11.glVertex3d(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._d);
        GL11.glVertex3d(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._d);
        GL11.glVertex3d(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._d);
        GL11.glVertex3d(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._d);
        GL11.glVertex3d(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._g);
        GL11.glVertex3d(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._g);
        GL11.glVertex3d(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._g);
        GL11.glVertex3d(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._g);
        GL11.glEnd();
        GL11.glPopAttrib();
    }

    public static void _a(double d, double d2, double d3, double d4, double d5, double d6, int n, float f) {
        GL11.glDisable(3553);
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glLineWidth(f);
        GL11.glTranslated(d - RenderManager._d, d2 - RenderManager._e, d3 - RenderManager._f);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawing(1);
        tessellator.setColorRGBA_I(n & 0xFFFFFF, n >> 24 & 0xFF);
        double d7 = d4 - d + 1.0;
        double d8 = d5 - d2 + 1.0;
        double d9 = d6 - d3 + 1.0;
        owxf._a(0.0, 0.0, 0.0, 0.0, d8, d9);
        owxf._a(d7, 0.0, 0.0, 0.0, d8, d9);
        owxf._a(0.0, 0.0, 0.0, d7, d8, 0.0);
        owxf._a(0.0, 0.0, d9, d7, d8, 0.0);
        owxf._a(0.0, 0.0, 0.0, d7, 0.0, d9);
        owxf._a(0.0, d8, 0.0, d7, 0.0, d9);
        tessellator.draw();
        GL11.glPopMatrix();
        GL11.glDisable(3042);
        GL11.glEnable(2896);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
    }

    public static float _a(float f, float f2) {
        float f3 = (float)Math.tan(0.5f * f * (float)Math.PI / 180.0f) * 2.0f;
        return 1.0f / (f2 * f3 * f3);
    }
}

