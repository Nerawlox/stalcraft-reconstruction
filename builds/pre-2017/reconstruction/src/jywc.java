/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.sajh;
import org.lwjgl.util.vector.Matrix3f;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class jywc {
    public static final float _a = (float)Math.PI;
    public static final float _b = (float)Math.PI * 2;
    public static final float _c = (float)Math.PI / 180;
    public static final float _d = 57.295776f;

    public static float _a(float f) {
        if ((f %= (float)Math.PI * 2) > (float)Math.PI) {
            return f - (float)Math.PI * 2;
        }
        if (f < (float)(-Math.PI)) {
            return f + (float)Math.PI * 2;
        }
        return f;
    }

    public static Vector3f _a(Vector3f vector3f, float f, Vector3f vector3f2) {
        if (vector3f2 == null) {
            vector3f2 = new Vector3f();
        }
        vector3f2.set(vector3f.x * f, vector3f.y * f, vector3f.z * f);
        return vector3f2;
    }

    public static Vector3f _a(Quaternion quaternion, Vector3f vector3f, Vector3f vector3f2) {
        if (vector3f2 == null) {
            vector3f2 = new Vector3f();
        }
        float f = quaternion.w * quaternion.w * 2.0f - 1.0f;
        float f2 = vector3f.x * f;
        float f3 = vector3f.y * f;
        float f4 = vector3f.z * f;
        float f5 = 2.0f * (quaternion.x * vector3f.x + quaternion.y * vector3f.y + quaternion.z * vector3f.z);
        float f6 = quaternion.x * f5;
        float f7 = quaternion.y * f5;
        float f8 = quaternion.z * f5;
        float f9 = 2.0f * quaternion.w;
        float f10 = (quaternion.y * vector3f.z - quaternion.z * vector3f.y) * f9;
        float f11 = (vector3f.x * quaternion.z - vector3f.z * quaternion.x) * f9;
        float f12 = (quaternion.x * vector3f.y - quaternion.y * vector3f.x) * f9;
        vector3f2.x = f2 + f6 + f10;
        vector3f2.y = f3 + f7 + f11;
        vector3f2.z = f4 + f8 + f12;
        return vector3f2;
    }

    @Deprecated
    public static Vector3f _a(Quaternion quaternion, Vector3f vector3f) {
        float f;
        if (vector3f == null) {
            vector3f = new Vector3f();
        }
        if ((double)(f = quaternion.x * quaternion.y + quaternion.z * quaternion.w) > 0.499) {
            float f2 = 2.0f * (float)Math.atan2(quaternion.x, quaternion.w);
            float f3 = 1.5707964f;
            float f4 = 0.0f;
            vector3f.set(f4, f2, f3);
            return vector3f;
        }
        if ((double)f < -0.499) {
            float f5 = -2.0f * (float)Math.atan2(quaternion.x, quaternion.w);
            float f6 = -1.5707964f;
            float f7 = 0.0f;
            vector3f.set(f7, f5, f6);
            return vector3f;
        }
        float f8 = quaternion.x * quaternion.x;
        float f9 = quaternion.y * quaternion.y;
        float f10 = quaternion.z * quaternion.z;
        float f11 = (float)Math.atan2(2.0f * quaternion.y * quaternion.w - 2.0f * quaternion.x * quaternion.z, 1.0f - 2.0f * f9 - 2.0f * f10);
        float f12 = (float)Math.asin(2.0f * f);
        float f13 = (float)Math.atan2(2.0f * quaternion.x * quaternion.w - 2.0f * quaternion.y * quaternion.z, 1.0f - 2.0f * f8 - 2.0f * f10);
        vector3f.set(f13, f11, f12);
        return vector3f;
    }

    public static Vector3f _b(Quaternion quaternion, Vector3f vector3f) {
        if (vector3f == null) {
            vector3f = new Vector3f();
        }
        Matrix3f matrix3f = jywc._a(quaternion, null);
        return jywc._a(matrix3f, vector3f);
    }

    public static void _a(Matrix3f matrix3f, Vector3f vector3f, Vector3f vector3f2) {
        float f = (float)Math.sqrt(matrix3f.m00 * matrix3f.m00 + matrix3f.m01 * matrix3f.m01);
        if (f > 1.0E-6f) {
            vector3f.x = (float)Math.atan2(matrix3f.m12, matrix3f.m22);
            vector3f.y = (float)Math.atan2(-matrix3f.m02, f);
            vector3f.z = (float)Math.atan2(matrix3f.m01, matrix3f.m00);
            vector3f2.x = (float)Math.atan2(-matrix3f.m12, -matrix3f.m22);
            vector3f2.y = (float)Math.atan2(-matrix3f.m02, -f);
            vector3f2.z = (float)Math.atan2(-matrix3f.m01, -matrix3f.m00);
        } else {
            vector3f.x = (float)Math.atan2(-matrix3f.m21, matrix3f.m11);
            vector3f.y = (float)Math.atan2(-matrix3f.m02, f);
            vector3f.z = 0.0f;
            vector3f2.set(vector3f);
        }
    }

    public static Vector3f _a(Matrix3f matrix3f, Vector3f vector3f) {
        if (vector3f == null) {
            vector3f = new Vector3f();
        }
        Vector3f vector3f2 = new Vector3f();
        Vector3f vector3f3 = new Vector3f();
        jywc._a(matrix3f, vector3f2, vector3f3);
        if (Math.abs(vector3f2.x) + Math.abs(vector3f2.y) + Math.abs(vector3f2.z) > Math.abs(vector3f3.x) + Math.abs(vector3f3.y) + Math.abs(vector3f3.z)) {
            vector3f.set(vector3f3);
        } else {
            vector3f.set(vector3f2);
        }
        return vector3f;
    }

    public static Vector3f _b(Matrix3f matrix3f, Vector3f vector3f) {
        if (vector3f == null) {
            vector3f = new Vector3f();
        }
        Matrix3f matrix3f2 = jywc._a(matrix3f, null);
        return jywc._a(matrix3f2, vector3f);
    }

    public static Matrix3f _a(Matrix3f matrix3f, Matrix3f matrix3f2) {
        if (matrix3f2 == null) {
            matrix3f2 = new Matrix3f();
        }
        float f = (float)Math.sqrt(matrix3f.m00 * matrix3f.m00 + matrix3f.m01 * matrix3f.m01 + matrix3f.m02 * matrix3f.m02);
        float f2 = (float)Math.sqrt(matrix3f.m10 * matrix3f.m10 + matrix3f.m11 * matrix3f.m11 + matrix3f.m12 * matrix3f.m12);
        float f3 = (float)Math.sqrt(matrix3f.m20 * matrix3f.m20 + matrix3f.m21 * matrix3f.m21 + matrix3f.m22 * matrix3f.m02);
        matrix3f2.m00 = matrix3f.m00 / f;
        matrix3f2.m01 = matrix3f.m01 / f;
        matrix3f2.m02 = matrix3f.m02 / f;
        matrix3f2.m10 = matrix3f.m10 / f2;
        matrix3f2.m11 = matrix3f.m11 / f2;
        matrix3f2.m12 = matrix3f.m12 / f2;
        matrix3f2.m20 = matrix3f.m20 / f3;
        matrix3f2.m21 = matrix3f.m21 / f3;
        matrix3f2.m22 = matrix3f.m22 / f3;
        return matrix3f2;
    }

    public static void _a(Quaternion quaternion, float f, float f2, float f3, float f4) {
        if (f == 0.0f) {
            return;
        }
        float f5 = (float)Math.sin(f / 2.0f);
        float f6 = (float)Math.cos(f / 2.0f);
        float f7 = f2 * f5;
        float f8 = f3 * f5;
        float f9 = f4 * f5;
        quaternion.set(quaternion.x * f6 + quaternion.w * f7 + quaternion.y * f9 - quaternion.z * f8, quaternion.y * f6 + quaternion.w * f8 + quaternion.z * f7 - quaternion.x * f9, quaternion.z * f6 + quaternion.w * f9 + quaternion.x * f8 - quaternion.y * f7, quaternion.w * f6 - quaternion.x * f7 - quaternion.y * f8 - quaternion.z * f9);
    }

    public static void _a(Quaternion quaternion, float f, float f2, float f3) {
        if (Float.isNaN(f)) {
            f = 0.0f;
        }
        if (Float.isNaN(f2)) {
            f2 = 0.0f;
        }
        if (Float.isNaN(f3)) {
            f3 = 0.0f;
        }
        jywc._a(quaternion, f3, 0.0f, 0.0f, 1.0f);
        jywc._a(quaternion, f2, 0.0f, 1.0f, 0.0f);
        jywc._a(quaternion, f, 1.0f, 0.0f, 0.0f);
    }

    public static Quaternion _a(Vector3f vector3f, Quaternion quaternion) {
        if (quaternion == null) {
            quaternion = new Quaternion();
        } else {
            quaternion.setIdentity();
        }
        jywc._a(quaternion, vector3f.x, vector3f.y, vector3f.z);
        return quaternion;
    }

    public static Quaternion _a(Quaternion quaternion, Quaternion quaternion2, Quaternion quaternion3) {
        return Quaternion.mul(quaternion, quaternion2, quaternion3);
    }

    public static Quaternion _a(Quaternion quaternion, Quaternion quaternion2) {
        return new Quaternion(quaternion.x + quaternion2.x, quaternion.y + quaternion2.y, quaternion.z + quaternion2.z, quaternion.w + quaternion2.w);
    }

    public static Vector4f _a(Quaternion quaternion, Vector4f vector4f) {
        if (vector4f == null) {
            vector4f = new Vector4f();
        }
        float f = 2.0f * (float)Math.acos(quaternion.w);
        float f2 = (float)Math.sqrt(1.0f - quaternion.w * quaternion.w);
        if (f2 < 1.0E-7f) {
            vector4f.set(quaternion.x, quaternion.y, quaternion.z, f);
        } else {
            vector4f.set(quaternion.x / f2, quaternion.y / f2, quaternion.z / f2, f);
        }
        return vector4f;
    }

    public static Quaternion _a(Quaternion quaternion, Vector3f vector3f, Quaternion quaternion2) {
        if (quaternion2 == null) {
            quaternion2 = new Quaternion();
        }
        quaternion2.w = -0.5f * (vector3f.x * quaternion.x + vector3f.y * quaternion.y + vector3f.z * quaternion.z);
        quaternion2.x = 0.5f * (vector3f.x * quaternion.w + vector3f.y * quaternion.z - vector3f.z * quaternion.y);
        quaternion2.y = 0.5f * (-vector3f.x * quaternion.z + vector3f.y * quaternion.w + vector3f.z * quaternion.x);
        quaternion2.z = 0.5f * (vector3f.x * quaternion.y - vector3f.y * quaternion.x + vector3f.z * quaternion.w);
        return quaternion2;
    }

    public static Matrix4f _a(Quaternion quaternion, Vector3f vector3f, Matrix4f matrix4f) {
        if (matrix4f == null) {
            matrix4f = new Matrix4f();
        }
        jywc._a(quaternion, matrix4f);
        matrix4f.m30 = vector3f.x;
        matrix4f.m31 = vector3f.y;
        matrix4f.m32 = vector3f.z;
        matrix4f.m23 = 0.0f;
        matrix4f.m13 = 0.0f;
        matrix4f.m03 = 0.0f;
        matrix4f.m33 = 1.0f;
        return matrix4f;
    }

    public static Matrix4f _a(Quaternion quaternion, Matrix4f matrix4f) {
        if (matrix4f == null) {
            matrix4f = new Matrix4f();
        }
        quaternion.normalise();
        float f = quaternion.w * quaternion.w;
        float f2 = quaternion.x * quaternion.x;
        float f3 = quaternion.y * quaternion.y;
        float f4 = quaternion.z * quaternion.z;
        matrix4f.m00 = f2 - f3 - f4 + f;
        matrix4f.m11 = -f2 + f3 - f4 + f;
        matrix4f.m22 = -f2 - f3 + f4 + f;
        float f5 = quaternion.x * quaternion.y;
        float f6 = quaternion.z * quaternion.w;
        matrix4f.m01 = 2.0f * (f5 + f6);
        matrix4f.m10 = 2.0f * (f5 - f6);
        f5 = quaternion.x * quaternion.z;
        f6 = quaternion.y * quaternion.w;
        matrix4f.m02 = 2.0f * (f5 - f6);
        matrix4f.m20 = 2.0f * (f5 + f6);
        f5 = quaternion.y * quaternion.z;
        f6 = quaternion.x * quaternion.w;
        matrix4f.m12 = 2.0f * (f5 + f6);
        matrix4f.m21 = 2.0f * (f5 - f6);
        return matrix4f;
    }

    public static Matrix3f _a(Quaternion quaternion, Matrix3f matrix3f) {
        if (matrix3f == null) {
            matrix3f = new Matrix3f();
        }
        quaternion.normalise();
        float f = quaternion.w * quaternion.w;
        float f2 = quaternion.x * quaternion.x;
        float f3 = quaternion.y * quaternion.y;
        float f4 = quaternion.z * quaternion.z;
        matrix3f.m00 = f2 - f3 - f4 + f;
        matrix3f.m11 = -f2 + f3 - f4 + f;
        matrix3f.m22 = -f2 - f3 + f4 + f;
        float f5 = quaternion.x * quaternion.y;
        float f6 = quaternion.z * quaternion.w;
        matrix3f.m01 = 2.0f * (f5 + f6);
        matrix3f.m10 = 2.0f * (f5 - f6);
        f5 = quaternion.x * quaternion.z;
        f6 = quaternion.y * quaternion.w;
        matrix3f.m02 = 2.0f * (f5 - f6);
        matrix3f.m20 = 2.0f * (f5 + f6);
        f5 = quaternion.y * quaternion.z;
        f6 = quaternion.x * quaternion.w;
        matrix3f.m12 = 2.0f * (f5 + f6);
        matrix3f.m21 = 2.0f * (f5 - f6);
        return matrix3f;
    }

    public static Quaternion _a(Matrix4f matrix4f, Quaternion quaternion) {
        float f;
        if (quaternion == null) {
            quaternion = new Quaternion();
        }
        if ((f = matrix4f.m00 + matrix4f.m11 + matrix4f.m22) > 0.0f) {
            float f2 = (float)Math.sqrt((double)f + 1.0) * 2.0f;
            quaternion.w = 0.25f * f2;
            quaternion.x = (matrix4f.m12 - matrix4f.m21) / f2;
            quaternion.y = (matrix4f.m20 - matrix4f.m02) / f2;
            quaternion.z = (matrix4f.m01 - matrix4f.m10) / f2;
        } else if (matrix4f.m00 > matrix4f.m11 & matrix4f.m00 > matrix4f.m22) {
            float f3 = (float)Math.sqrt(1.0 + (double)matrix4f.m00 - (double)matrix4f.m11 - (double)matrix4f.m22) * 2.0f;
            quaternion.w = (matrix4f.m12 - matrix4f.m21) / f3;
            quaternion.x = 0.25f * f3;
            quaternion.y = (matrix4f.m10 + matrix4f.m01) / f3;
            quaternion.z = (matrix4f.m20 + matrix4f.m02) / f3;
        } else if (matrix4f.m11 > matrix4f.m22) {
            float f4 = (float)Math.sqrt(1.0 + (double)matrix4f.m11 - (double)matrix4f.m00 - (double)matrix4f.m22) * 2.0f;
            quaternion.w = (matrix4f.m20 - matrix4f.m02) / f4;
            quaternion.x = (matrix4f.m10 + matrix4f.m01) / f4;
            quaternion.y = 0.25f * f4;
            quaternion.z = (matrix4f.m21 + matrix4f.m12) / f4;
        } else {
            float f5 = (float)Math.sqrt(1.0 + (double)matrix4f.m22 - (double)matrix4f.m00 - (double)matrix4f.m11) * 2.0f;
            quaternion.w = (matrix4f.m01 - matrix4f.m10) / f5;
            quaternion.x = (matrix4f.m20 + matrix4f.m02) / f5;
            quaternion.y = (matrix4f.m21 + matrix4f.m12) / f5;
            quaternion.z = 0.25f * f5;
        }
        return quaternion;
    }

    public static Vector3f _a(Matrix4f matrix4f, Vector3f vector3f) {
        if (vector3f == null) {
            vector3f = new Vector3f();
        }
        vector3f.x = (float)Math.sqrt(matrix4f.m00 * matrix4f.m00 + matrix4f.m01 * matrix4f.m01 + matrix4f.m02 * matrix4f.m02);
        vector3f.y = (float)Math.sqrt(matrix4f.m10 * matrix4f.m10 + matrix4f.m11 * matrix4f.m11 + matrix4f.m12 * matrix4f.m12);
        vector3f.z = (float)Math.sqrt(matrix4f.m20 * matrix4f.m20 + matrix4f.m21 * matrix4f.m21 + matrix4f.m22 * matrix4f.m22);
        return vector3f;
    }

    public static Vector3f _b(Matrix4f matrix4f, Vector3f vector3f) {
        if (vector3f == null) {
            vector3f = new Vector3f();
        }
        vector3f.x = matrix4f.m00 * matrix4f.m00 + matrix4f.m01 * matrix4f.m01 + matrix4f.m02 * matrix4f.m02;
        vector3f.y = matrix4f.m10 * matrix4f.m10 + matrix4f.m11 * matrix4f.m11 + matrix4f.m12 * matrix4f.m12;
        vector3f.z = matrix4f.m20 * matrix4f.m20 + matrix4f.m21 * matrix4f.m21 + matrix4f.m22 * matrix4f.m22;
        return vector3f;
    }

    public static float _a(Vector3f vector3f) {
        return vector3f.x > vector3f.y ? (vector3f.x > vector3f.z ? vector3f.x : vector3f.z) : (vector3f.y > vector3f.z ? vector3f.y : vector3f.z);
    }

    public static float _a(Matrix4f matrix4f) {
        return (float)Math.sqrt(jywc._b(matrix4f));
    }

    public static float _b(Matrix4f matrix4f) {
        return matrix4f.m30 * matrix4f.m30 + matrix4f.m31 * matrix4f.m31 + matrix4f.m32 * matrix4f.m32;
    }

    public static Quaternion _a(Quaternion quaternion, Quaternion quaternion2, Quaternion quaternion3, float f) {
        boolean bl;
        if (quaternion3 == null) {
            quaternion3 = new Quaternion();
        }
        if (quaternion.x == quaternion2.x && quaternion.y == quaternion2.y && quaternion.z == quaternion2.z && quaternion.w == quaternion2.w) {
            quaternion3.w = quaternion.w;
            quaternion3.x = quaternion.x;
            quaternion3.y = quaternion.y;
            quaternion3.z = quaternion.z;
            return quaternion3;
        }
        boolean bl2 = false;
        float f2 = quaternion.x * quaternion2.x + quaternion.y * quaternion2.y + quaternion.z * quaternion2.z + quaternion.w * quaternion2.w;
        if (f2 < 0.0f) {
            f2 = -f2;
            bl2 = true;
        }
        float f3 = 1.0f - f;
        float f4 = f;
        boolean bl3 = bl = 1.0f - f2 > 0.1f;
        if (bl) {
            float f5 = (float)Math.acos(f2);
            float f6 = sajh._a(f5);
            f3 = sajh._a((1.0f - f) * f5) / f6;
            f4 = sajh._a(f * f5) / f6;
        }
        if (bl2) {
            quaternion3.x = f3 * quaternion.x - f4 * quaternion2.x;
            quaternion3.y = f3 * quaternion.y - f4 * quaternion2.y;
            quaternion3.z = f3 * quaternion.z - f4 * quaternion2.z;
            quaternion3.w = f3 * quaternion.w - f4 * quaternion2.w;
        } else {
            quaternion3.x = f3 * quaternion.x + f4 * quaternion2.x;
            quaternion3.y = f3 * quaternion.y + f4 * quaternion2.y;
            quaternion3.z = f3 * quaternion.z + f4 * quaternion2.z;
            quaternion3.w = f3 * quaternion.w + f4 * quaternion2.w;
        }
        quaternion3.normalise(quaternion3);
        return quaternion3;
    }

    public static Quaternion _b(Quaternion quaternion, Quaternion quaternion2, Quaternion quaternion3, float f) {
        if (quaternion3 == null) {
            quaternion3 = new Quaternion();
        }
        if (quaternion.x == quaternion2.x && quaternion.y == quaternion2.y && quaternion.z == quaternion2.z && quaternion.w == quaternion2.w) {
            quaternion3.w = quaternion.w;
            quaternion3.x = quaternion.x;
            quaternion3.y = quaternion.y;
            quaternion3.z = quaternion.z;
            return quaternion3;
        }
        boolean bl = false;
        float f2 = quaternion.x * quaternion2.x + quaternion.y * quaternion2.y + quaternion.z * quaternion2.z + quaternion.w * quaternion2.w;
        if (f2 < 0.0f) {
            bl = true;
        }
        float f3 = 1.0f - f;
        float f4 = f;
        if (bl) {
            quaternion3.x = f3 * quaternion.x - f4 * quaternion2.x;
            quaternion3.y = f3 * quaternion.y - f4 * quaternion2.y;
            quaternion3.z = f3 * quaternion.z - f4 * quaternion2.z;
            quaternion3.w = f3 * quaternion.w - f4 * quaternion2.w;
        } else {
            quaternion3.x = f3 * quaternion.x + f4 * quaternion2.x;
            quaternion3.y = f3 * quaternion.y + f4 * quaternion2.y;
            quaternion3.z = f3 * quaternion.z + f4 * quaternion2.z;
            quaternion3.w = f3 * quaternion.w + f4 * quaternion2.w;
        }
        quaternion3.normalise(quaternion3);
        return quaternion3;
    }

    public static Vector3f _a(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, float f) {
        if (vector3f3 == null) {
            vector3f3 = new Vector3f();
        }
        vector3f3.x = vector3f.x + (vector3f2.x - vector3f.x) * f;
        vector3f3.y = vector3f.y + (vector3f2.y - vector3f.y) * f;
        vector3f3.z = vector3f.z + (vector3f2.z - vector3f.z) * f;
        return vector3f3;
    }

    public static float _a(float f, float f2, float f3) {
        return f + (f2 - f) * f3;
    }

    public static void _a(Matrix3f matrix3f, Matrix4f matrix4f) {
        matrix3f.m00 = matrix4f.m00;
        matrix3f.m01 = matrix4f.m01;
        matrix3f.m02 = matrix4f.m02;
        matrix3f.m10 = matrix4f.m10;
        matrix3f.m11 = matrix4f.m11;
        matrix3f.m12 = matrix4f.m12;
        matrix3f.m20 = matrix4f.m20;
        matrix3f.m21 = matrix4f.m21;
        matrix3f.m22 = matrix4f.m22;
    }

    public static void _a(AxisAlignedBB axisAlignedBB, float f, float f2, float f3, float f4) {
        int n;
        Matrix3f matrix3f = jywc._a(f, f2, f3, f4, new Matrix3f());
        Vector3f[] vector3fArray = new Vector3f[]{new Vector3f((float)axisAlignedBB._b, (float)axisAlignedBB._c, (float)axisAlignedBB._d), new Vector3f((float)axisAlignedBB._b, (float)axisAlignedBB._c, (float)axisAlignedBB._g), new Vector3f((float)axisAlignedBB._b, (float)axisAlignedBB._f, (float)axisAlignedBB._d), new Vector3f((float)axisAlignedBB._b, (float)axisAlignedBB._f, (float)axisAlignedBB._g), new Vector3f((float)axisAlignedBB._e, (float)axisAlignedBB._c, (float)axisAlignedBB._d), new Vector3f((float)axisAlignedBB._e, (float)axisAlignedBB._c, (float)axisAlignedBB._g), new Vector3f((float)axisAlignedBB._e, (float)axisAlignedBB._f, (float)axisAlignedBB._d), new Vector3f((float)axisAlignedBB._e, (float)axisAlignedBB._f, (float)axisAlignedBB._g)};
        for (n = 0; n < vector3fArray.length; ++n) {
            Matrix3f.transform(matrix3f, vector3fArray[n], vector3fArray[n]);
        }
        axisAlignedBB._b = axisAlignedBB._e = (double)vector3fArray[0].x;
        axisAlignedBB._c = axisAlignedBB._f = (double)vector3fArray[0].y;
        axisAlignedBB._d = axisAlignedBB._g = (double)vector3fArray[0].z;
        for (n = 1; n < vector3fArray.length; ++n) {
            Vector3f vector3f = vector3fArray[n];
            axisAlignedBB._b = Math.min(axisAlignedBB._b, (double)vector3f.x);
            axisAlignedBB._e = Math.max(axisAlignedBB._e, (double)vector3f.x);
            axisAlignedBB._c = Math.min(axisAlignedBB._c, (double)vector3f.y);
            axisAlignedBB._f = Math.max(axisAlignedBB._f, (double)vector3f.y);
            axisAlignedBB._d = Math.min(axisAlignedBB._d, (double)vector3f.z);
            axisAlignedBB._g = Math.max(axisAlignedBB._g, (double)vector3f.z);
        }
    }

    public static Matrix3f _a(float f, float f2, float f3, float f4, Matrix3f matrix3f) {
        if (matrix3f == null) {
            matrix3f = new Matrix3f();
        }
        float f5 = (float)Math.sqrt(f2 * f2 + f3 * f3 + f4 * f4);
        float f6 = sajh._a(f *= (float)Math.PI / 180);
        float f7 = sajh._b(f);
        float f8 = 1.0f - f7;
        float f9 = (f2 /= f5) * (f3 /= f5);
        float f10 = f3 * (f4 /= f5);
        float f11 = f2 * f4;
        float f12 = f2 * f6;
        float f13 = f3 * f6;
        float f14 = f4 * f6;
        matrix3f.m00 = f2 * f2 * f8 + f7;
        matrix3f.m01 = f9 * f8 + f14;
        matrix3f.m02 = f11 * f8 - f13;
        matrix3f.m10 = f9 * f8 - f14;
        matrix3f.m11 = f3 * f3 * f8 + f7;
        matrix3f.m12 = f10 * f8 + f12;
        matrix3f.m20 = f11 * f8 + f13;
        matrix3f.m21 = f10 * f8 - f12;
        matrix3f.m22 = f4 * f4 * f8 + f7;
        return matrix3f;
    }

    public static Matrix3f _a(float f, float f2, float f3, float f4) {
        return jywc._a(f, f2, f3, f4, null);
    }

    public static Matrix3f _a(float f, float f2, float f3, Matrix3f matrix3f) {
        if (matrix3f == null) {
            matrix3f = new Matrix3f();
        }
        matrix3f.m00 = f;
        matrix3f.m11 = f2;
        matrix3f.m22 = f3;
        return matrix3f;
    }

    public static Matrix3f _b(float f, float f2, float f3) {
        return jywc._a(f, f2, f3, null);
    }

    public static boolean _a(int n) {
        return (n & n - 1) == 0;
    }
}

