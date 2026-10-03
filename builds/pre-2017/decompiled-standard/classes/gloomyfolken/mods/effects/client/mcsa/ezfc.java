/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

public class ezfc {
    private static List<Matrix4f> _b = new ArrayList<Matrix4f>();
    private static List<Matrix4f> _c = new ArrayList<Matrix4f>();
    static Matrix4f _a = new Matrix4f();
    private static Vector3f _d = new Vector3f();
    private static Matrix4f _e = new Matrix4f();
    private static FloatBuffer _f = BufferUtils.createFloatBuffer(16);

    private ezfc() {
    }

    private static Matrix4f _j() {
        if (_b.isEmpty()) {
            return new Matrix4f();
        }
        return _b.remove(_b.size() - 1);
    }

    public static void _a() {
        if (_c.size() > 64) {
            throw new IllegalStateException("Stack overflow");
        }
        Matrix4f matrix4f = ezfc._j();
        matrix4f.load(_a);
        _c.add(_a);
        _a = matrix4f;
    }

    public static void _b() {
        if (_c.size() == 0) {
            throw new IllegalStateException("Stack underflow");
        }
        Matrix4f matrix4f = _c.remove(_c.size() - 1);
        _b.add(_a);
        _a = matrix4f;
    }

    public static void _a(float f, float f2, float f3) {
        _d.set(f, f2, f3);
        _a.translate(_d);
    }

    public static void _a(Vector3f vector3f) {
        _a.translate(vector3f);
    }

    public static void _a(float f, float f2, float f3, float f4) {
        _d.set(f2, f3, f4);
        _a.rotate((float)Math.toRadians(f), _d);
    }

    public static void _a(float f, Vector3f vector3f) {
        _a.rotate((float)Math.toRadians(f), vector3f);
    }

    public static void _b(Vector3f vector3f) {
        ezfc._a(vector3f.z, 0.0f, 0.0f, 1.0f);
        ezfc._a(vector3f.y, 0.0f, 1.0f, 0.0f);
        ezfc._a(vector3f.x, 1.0f, 0.0f, 0.0f);
    }

    public static void _a(Quaternion quaternion) {
        jywc._a(quaternion, _e);
        Matrix4f.mul(_a, _e, _a);
    }

    public static void _b(float f, float f2, float f3) {
        _d.set(f, f2, f3);
        _a.scale(_d);
    }

    public static void _c(Vector3f vector3f) {
        _a.scale(vector3f);
    }

    public static void _a(Matrix4f matrix4f) {
        _a.load(matrix4f);
    }

    public static void _c() {
        _a.setIdentity();
    }

    public static void _b(Matrix4f matrix4f) {
        matrix4f.load(_a);
    }

    public static void _d() {
        _f.clear();
        GL11.glGetFloat(2982, _f);
        _a.load(_f);
    }

    public static void _e() {
        _f.clear();
        _a.store(_f);
        _f.flip();
        GL11.glLoadMatrix(_f);
    }

    public static void _c(Matrix4f matrix4f) {
        Matrix4f.mul(_a, matrix4f, _a);
    }

    public static float _f() {
        return jywc._a(jywc._b(_a, _d));
    }

    public static float _g() {
        return (float)Math.sqrt(ezfc._f());
    }

    public static float _h() {
        return jywc._b(_a);
    }

    public static float _i() {
        return (float)Math.sqrt(ezfc._h());
    }
}

