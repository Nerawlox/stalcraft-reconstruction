/*
 * Decompiled with CFR 0.152.
 */
import java.nio.FloatBuffer;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public class qnon {
    public static FloatBuffer _a = pklh._e(16);
    public static final Vec3 _b = Vec3._a(0.2f, 1.0, -0.7f)._a();
    public static final Vec3 _c = Vec3._a(-0.2f, 1.0, 0.7f)._a();

    public static void _a() {
        GL11.glDisable(2896);
        GL11.glDisable(16384);
        GL11.glDisable(16385);
        GL11.glDisable(2903);
    }

    public static void _b() {
        GL11.glEnable(2896);
        GL11.glEnable(16384);
        GL11.glEnable(16385);
        GL11.glEnable(2903);
        GL11.glColorMaterial(1032, 5634);
        float f = 0.4f;
        float f2 = 0.6f;
        float f3 = 0.0f;
        GL11.glLight(16384, 4611, qnon._a(qnon._b._c, qnon._b._d, qnon._b._e, 0.0));
        GL11.glLight(16384, 4609, qnon._a(f2, f2, f2, 1.0f));
        GL11.glLight(16384, 4608, qnon._a(0.0f, 0.0f, 0.0f, 1.0f));
        GL11.glLight(16384, 4610, qnon._a(f3, f3, f3, 1.0f));
        GL11.glLight(16385, 4611, qnon._a(qnon._c._c, qnon._c._d, qnon._c._e, 0.0));
        GL11.glLight(16385, 4609, qnon._a(f2, f2, f2, 1.0f));
        GL11.glLight(16385, 4608, qnon._a(0.0f, 0.0f, 0.0f, 1.0f));
        GL11.glLight(16385, 4610, qnon._a(f3, f3, f3, 1.0f));
        GL11.glShadeModel(7424);
        GL11.glLightModel(2899, qnon._a(f, f, f, 1.0f));
    }

    public static FloatBuffer _a(double d, double d2, double d3, double d4) {
        return qnon._a((float)d, (float)d2, (float)d3, (float)d4);
    }

    public static FloatBuffer _a(float f, float f2, float f3, float f4) {
        _a.clear();
        _a.put(f).put(f2).put(f3).put(f4);
        _a.flip();
        return _a;
    }

    public static void _c() {
        GL11.glPushMatrix();
        GL11.glRotatef(-30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(165.0f, 1.0f, 0.0f, 0.0f);
        qnon._b();
        GL11.glPopMatrix();
    }
}

