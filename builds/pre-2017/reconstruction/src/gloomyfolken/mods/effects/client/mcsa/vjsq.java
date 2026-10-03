/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import gloomyfolken.mods.effects.client.mcsa.ezfc;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class vjsq {
    private static Vector4f _a = new Vector4f();
    private static Matrix4f _b = new Matrix4f();

    public static ivtm _a(cucv cucv2) {
        return cucv2._a(Minecraft._E()._p._d);
    }

    public static void _a(ivtm ivtm2, int n, float f) {
        Vector3f vector3f = ivtm2._a[n];
        GL11.glTranslatef(vector3f.x * f, vector3f.y * f, vector3f.z * f);
        Vector4f vector4f = jywc._a(ivtm2._b[n], _a);
        GL11.glRotatef((float)Math.toDegrees(vector4f.w * f), vector4f.x, vector4f.y, vector4f.z);
    }

    public static void _a(ivtm ivtm2, int n) {
        jywc._a(ivtm2._b[n], ivtm2._a[n], _b);
        ezfc._c(_b);
    }

    public static void _a(ivtm ivtm2, jywl jywl2) {
        GL11.glDisable(2929);
        GL11.glLineWidth(3.0f);
        GL11.glColor4f(1.0f, 1.0f, 0.0f, 1.0f);
        GL11.glDisable(2896);
        GL11.glDisable(3553);
        float[][] fArrayArray = new float[][]{{1.0f, 0.0f, 0.0f, 1.0f}, {1.0f, 1.0f, 0.0f, 1.0f}, {0.0f, 1.0f, 0.0f, 1.0f}, {1.0f, 0.0f, 1.0f, 1.0f}, {0.0f, 0.0f, 1.0f, 1.0f}, {0.0f, 1.0f, 1.0f, 1.0f}};
        int n = 0;
        for (int i = 0; i < jywl2._a; ++i) {
            jywl.kjui kjui2 = jywl2._a(i);
            Vector3f vector3f = ivtm2._a[i];
            Vector3f vector3f2 = Vector3f.add(jywc._a(ivtm2._b[i], kjui2._f, null), vector3f, null);
            if (kjui2._a != null) {
                Vector3f.sub(ivtm2._a[i], ivtm2._a[kjui2._a._c], vector3f2);
            }
            float[] fArray = fArrayArray[n++ % fArrayArray.length];
            GL11.glColor4f(fArray[0], fArray[1], fArray[2], fArray[3]);
            GL11.glBegin(1);
            GL11.glVertex3f(vector3f.x, vector3f.y, vector3f.z);
            GL11.glVertex3f(vector3f.x - vector3f2.x, vector3f.y - vector3f2.y, vector3f.z - vector3f2.z);
            GL11.glEnd();
        }
        GL11.glEnable(2929);
        GL11.glEnable(3553);
    }
}

