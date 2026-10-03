/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.applet;

import java.awt.Rectangle;
import javax.vecmath.Matrix4f;
import javax.vecmath.SingularMatrixException;
import javax.vecmath.Tuple3f;
import javax.vecmath.Tuple4f;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

public class Utils {
    private Utils() {
    }

    public static void setFrustum(Matrix4f mat, float left, float right, float bottom, float top, float near, float far) {
        mat.setZero();
        mat.m00 = 2.0f * near / (right - left);
        mat.m11 = 2.0f * near / (top - bottom);
        mat.m32 = -1.0f;
        mat.m02 = (right + left) / (right - left);
        mat.m12 = (top + bottom) / (top - bottom);
        mat.m22 = -(far + near) / (far - near);
        mat.m23 = -(2.0f * far * near) / (far - near);
    }

    public static void setPerspective(Matrix4f mat, float fovy, float aspect, float zNear, float zFar) {
        float radians = fovy / 2.0f * (float)Math.PI / 180.0f;
        float deltaZ = zFar - zNear;
        float sine = (float)Math.sin(radians);
        if (deltaZ == 0.0f || sine == 0.0f || aspect == 0.0f) {
            return;
        }
        float cotangent = (float)Math.cos(radians) / sine;
        mat.setIdentity();
        mat.m00 = cotangent / aspect;
        mat.m11 = cotangent;
        mat.m22 = -(zFar + zNear) / deltaZ;
        mat.m32 = -1.0f;
        mat.m23 = -2.0f * zNear * zFar / deltaZ;
        mat.m33 = 0.0f;
    }

    public static void mulPerspective(Matrix4f mat, float fovy, float aspect, float zNear, float zFar) {
        Matrix4f tmpMat = new Matrix4f();
        Utils.setPerspective(tmpMat, fovy, aspect, zNear, zFar);
        mat.mul(tmpMat);
    }

    public static void setOrtho(Matrix4f mat, float left, float right, float bottom, float top, float near, float far) {
        mat.setIdentity();
        mat.m00 = 2.0f / (right - left);
        mat.m11 = 2.0f / (top - bottom);
        mat.m22 = -2.0f / (far - near);
        mat.m03 = -(right + left) / (right - left);
        mat.m13 = -(top + bottom) / (top - bottom);
        mat.m23 = -(far + near) / (far - near);
    }

    public static void mulOrtho(Matrix4f mat, float left, float right, float bottom, float top, float near, float far) {
        Matrix4f tmpMat = new Matrix4f();
        Utils.setOrtho(tmpMat, left, right, bottom, top, near, far);
        mat.mul(tmpMat);
    }

    public static void translate(Matrix4f mat, float x, float y, float z) {
        Matrix4f tmpMat = new Matrix4f();
        tmpMat.setIdentity();
        tmpMat.m03 = x;
        tmpMat.m13 = y;
        tmpMat.m23 = z;
        mat.mul(tmpMat);
    }

    public static void scale(Matrix4f mat, float x, float y, float z) {
        Matrix4f tmpMat = new Matrix4f();
        tmpMat.setIdentity();
        tmpMat.m00 = x;
        tmpMat.m11 = y;
        tmpMat.m22 = z;
        mat.mul(tmpMat);
    }

    public static void setLookAt(Matrix4f mat, float eyex, float eyey, float eyez, float centerx, float centery, float centerz, float upx, float upy, float upz) {
        Vector3f forward = new Vector3f();
        Vector3f side = new Vector3f();
        Vector3f up = new Vector3f();
        forward.x = centerx - eyex;
        forward.y = centery - eyey;
        forward.z = centerz - eyez;
        up.x = upx;
        up.y = upy;
        up.z = upz;
        forward.normalize();
        side.cross(forward, up);
        side.normalize();
        up.cross(side, forward);
        mat.setIdentity();
        mat.m00 = side.x;
        mat.m01 = side.y;
        mat.m02 = side.z;
        mat.m10 = up.x;
        mat.m11 = up.y;
        mat.m12 = up.z;
        mat.m20 = -forward.x;
        mat.m21 = -forward.y;
        mat.m22 = -forward.z;
        Utils.translate(mat, -eyex, -eyey, -eyez);
    }

    public static void mulPickMatrix(Matrix4f mat, float x, float y, float deltaX, float deltaY, Rectangle viewport) {
        if (deltaX <= 0.0f || deltaY <= 0.0f) {
            return;
        }
        Utils.translate(mat, ((float)viewport.width - 2.0f * (x - (float)viewport.x)) / deltaX, ((float)viewport.height - 2.0f * (y - (float)viewport.y)) / deltaY, 0.0f);
        Utils.scale(mat, (float)viewport.width / deltaX, (float)viewport.height / deltaY, 1.0f);
    }

    private static void __gluMultMatrixVecf(Matrix4f mat, Tuple4f in, Tuple4f out) {
        out.x = in.x * mat.m00 + in.y * mat.m01 + in.z * mat.m02 + in.w * mat.m03;
        out.y = in.x * mat.m10 + in.y * mat.m11 + in.z * mat.m12 + in.w * mat.m13;
        out.z = in.x * mat.m20 + in.y * mat.m21 + in.z * mat.m22 + in.w * mat.m23;
        out.w = in.x * mat.m30 + in.y * mat.m31 + in.z * mat.m32 + in.w * mat.m33;
    }

    public static boolean project(float objx, float objy, float objz, Matrix4f modelMatrix, Matrix4f projMatrix, Rectangle viewport, Tuple3f win_pos) {
        Vector4f in = new Vector4f();
        Vector4f out = new Vector4f();
        in.x = objx;
        in.y = objy;
        in.z = objz;
        in.w = 1.0f;
        Utils.__gluMultMatrixVecf(modelMatrix, in, out);
        Utils.__gluMultMatrixVecf(projMatrix, out, in);
        if ((double)in.w == 0.0) {
            return false;
        }
        in.w = 1.0f / in.w * 0.5f;
        in.x = in.x * in.w + 0.5f;
        in.y = in.y * in.w + 0.5f;
        in.z = in.z * in.w + 0.5f;
        win_pos.x = in.x * (float)viewport.width + (float)viewport.x;
        win_pos.y = in.y * (float)viewport.height + (float)viewport.y;
        win_pos.z = in.z;
        return true;
    }

    public static boolean unproject(float winx, float winy, float winz, Matrix4f modelMatrix, Matrix4f projMatrix, Rectangle viewport, Tuple3f obj_pos) {
        Vector4f in = new Vector4f();
        Vector4f out = new Vector4f();
        Matrix4f finalMatrix = new Matrix4f();
        finalMatrix.mul(projMatrix, modelMatrix);
        try {
            finalMatrix.invert();
        }
        catch (SingularMatrixException e) {
            return false;
        }
        in.x = winx;
        in.y = winy;
        in.z = winz;
        in.w = 1.0f;
        in.x = (in.x - (float)viewport.x) / (float)viewport.width;
        in.y = (in.y - (float)viewport.y) / (float)viewport.height;
        in.x = in.x * 2.0f - 1.0f;
        in.y = in.y * 2.0f - 1.0f;
        in.z = in.z * 2.0f - 1.0f;
        Utils.__gluMultMatrixVecf(finalMatrix, in, out);
        if ((double)out.w == 0.0) {
            return false;
        }
        out.w = 1.0f / out.w;
        obj_pos.x = out.x * out.w;
        obj_pos.y = out.y * out.w;
        obj_pos.z = out.z * out.w;
        return true;
    }
}

