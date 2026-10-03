/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath;

import com.bulletphysics.$Stack;
import com.bulletphysics.linearmath.MatrixUtil;
import javax.vecmath.Matrix3f;
import javax.vecmath.Matrix4f;
import javax.vecmath.Quat4f;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class Transform {
    public final Matrix3f basis = new Matrix3f();
    public final Vector3f origin = new Vector3f();

    public Transform() {
    }

    public Transform(Matrix3f mat) {
        this.basis.set(mat);
    }

    public Transform(Matrix4f mat) {
        this.set(mat);
    }

    public Transform(Transform tr) {
        this.set(tr);
    }

    public void set(Transform tr) {
        this.basis.set(tr.basis);
        this.origin.set(tr.origin);
    }

    public void set(Matrix3f mat) {
        this.basis.set(mat);
        this.origin.set(0.0f, 0.0f, 0.0f);
    }

    public void set(Matrix4f mat) {
        mat.getRotationScale(this.basis);
        this.origin.set(mat.m03, mat.m13, mat.m23);
    }

    public void transform(Vector3f v) {
        this.basis.transform(v);
        v.add(this.origin);
    }

    public void setIdentity() {
        this.basis.setIdentity();
        this.origin.set(0.0f, 0.0f, 0.0f);
    }

    public void inverse() {
        this.basis.transpose();
        this.origin.scale(-1.0f);
        this.basis.transform(this.origin);
    }

    public void inverse(Transform tr) {
        this.set(tr);
        this.inverse();
    }

    /*
     * WARNING - void declaration
     */
    public void mul(Transform transform) {
        $Stack $Stack = $Stack.get();
        try {
            void tr;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f vec = $Stack.get$javax$vecmath$Vector3f(tr.origin);
            this.transform(vec);
            this.basis.mul(tr.basis);
            this.origin.set(vec);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void mul(Transform transform, Transform transform2) {
        $Stack $Stack = $Stack.get();
        try {
            void tr1;
            void tr2;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f vec = $Stack.get$javax$vecmath$Vector3f(tr2.origin);
            tr1.transform(vec);
            this.basis.mul(tr1.basis, tr2.basis);
            this.origin.set(vec);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void invXform(Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void inVec;
            void out;
            $Stack.push$javax$vecmath$Matrix3f();
            out.sub((Tuple3f)inVec, this.origin);
            Matrix3f mat = $Stack.get$javax$vecmath$Matrix3f(this.basis);
            mat.transpose();
            mat.transform((Tuple3f)out);
            $Stack.pop$javax$vecmath$Matrix3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Matrix3f();
            throw throwable;
        }
    }

    public Quat4f getRotation(Quat4f out) {
        MatrixUtil.getRotation(this.basis, out);
        return out;
    }

    public void setRotation(Quat4f q) {
        MatrixUtil.setRotation(this.basis, q);
    }

    public void setFromOpenGLMatrix(float[] m) {
        MatrixUtil.setFromOpenGLSubMatrix(this.basis, m);
        this.origin.set(m[12], m[13], m[14]);
    }

    public void getOpenGLMatrix(float[] m) {
        MatrixUtil.getOpenGLSubMatrix(this.basis, m);
        m[12] = this.origin.x;
        m[13] = this.origin.y;
        m[14] = this.origin.z;
        m[15] = 1.0f;
    }

    public Matrix4f getMatrix(Matrix4f out) {
        out.set(this.basis);
        out.m03 = this.origin.x;
        out.m13 = this.origin.y;
        out.m23 = this.origin.z;
        return out;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Transform)) {
            return false;
        }
        Transform tr = (Transform)obj;
        return this.basis.equals(tr.basis) && this.origin.equals(tr.origin);
    }

    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.basis.hashCode();
        hash = 41 * hash + this.origin.hashCode();
        return hash;
    }
}

