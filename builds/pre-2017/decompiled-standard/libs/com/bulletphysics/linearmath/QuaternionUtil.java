/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath;

import com.bulletphysics.$Stack;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

public class QuaternionUtil {
    public static float getAngle(Quat4f q) {
        float s = 2.0f * (float)Math.acos(q.w);
        return s;
    }

    public static void setRotation(Quat4f q, Vector3f axis, float angle) {
        float d = axis.length();
        assert (d != 0.0f);
        float s = (float)Math.sin(angle * 0.5f) / d;
        q.set(axis.x * s, axis.y * s, axis.z * s, (float)Math.cos(angle * 0.5f));
    }

    /*
     * WARNING - void declaration
     */
    public static Quat4f shortestArcQuat(Vector3f vector3f, Vector3f vector3f2, Quat4f quat4f) {
        $Stack $Stack = $Stack.get();
        try {
            void out;
            void v1;
            Vector3f v0;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f c = $Stack.get$javax$vecmath$Vector3f();
            c.cross(v0, (Vector3f)v1);
            float d = v0.dot((Vector3f)v1);
            if ((double)d < -0.9999998807907104) {
                out.set(0.0f, 1.0f, 0.0f, 0.0f);
                $Stack.pop$javax$vecmath$Vector3f();
                return out;
            }
            float s = (float)Math.sqrt((1.0f + d) * 2.0f);
            float rs = 1.0f / s;
            out.set(c.x * rs, c.y * rs, c.z * rs, s * 0.5f);
            $Stack.pop$javax$vecmath$Vector3f();
            return out;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public static void mul(Quat4f q, Vector3f w) {
        float rx = q.w * w.x + q.y * w.z - q.z * w.y;
        float ry = q.w * w.y + q.z * w.x - q.x * w.z;
        float rz = q.w * w.z + q.x * w.y - q.y * w.x;
        float rw = -q.x * w.x - q.y * w.y - q.z * w.z;
        q.set(rx, ry, rz, rw);
    }

    /*
     * WARNING - void declaration
     */
    public static Vector3f quatRotate(Quat4f quat4f, Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void out;
            void v;
            Quat4f rotation;
            $Stack.push$javax$vecmath$Quat4f();
            Quat4f q = $Stack.get$javax$vecmath$Quat4f(rotation);
            QuaternionUtil.mul(q, (Vector3f)v);
            Quat4f tmp = $Stack.get$javax$vecmath$Quat4f();
            QuaternionUtil.inverse(tmp, rotation);
            q.mul(tmp);
            out.set(q.x, q.y, q.z);
            $Stack.pop$javax$vecmath$Quat4f();
            return out;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Quat4f();
            throw throwable;
        }
    }

    public static void inverse(Quat4f q) {
        q.x = -q.x;
        q.y = -q.y;
        q.z = -q.z;
    }

    public static void inverse(Quat4f q, Quat4f src) {
        q.x = -src.x;
        q.y = -src.y;
        q.z = -src.z;
        q.w = src.w;
    }

    public static void setEuler(Quat4f q, float yaw, float pitch, float roll) {
        float halfYaw = yaw * 0.5f;
        float halfPitch = pitch * 0.5f;
        float halfRoll = roll * 0.5f;
        float cosYaw = (float)Math.cos(halfYaw);
        float sinYaw = (float)Math.sin(halfYaw);
        float cosPitch = (float)Math.cos(halfPitch);
        float sinPitch = (float)Math.sin(halfPitch);
        float cosRoll = (float)Math.cos(halfRoll);
        float sinRoll = (float)Math.sin(halfRoll);
        q.x = cosRoll * sinPitch * cosYaw + sinRoll * cosPitch * sinYaw;
        q.y = cosRoll * cosPitch * sinYaw - sinRoll * sinPitch * cosYaw;
        q.z = sinRoll * cosPitch * cosYaw - cosRoll * sinPitch * sinYaw;
        q.w = cosRoll * cosPitch * cosYaw + sinRoll * sinPitch * sinYaw;
    }
}

