/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath;

import com.bulletphysics.$Stack;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.QuaternionUtil;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Matrix3f;
import javax.vecmath.Quat4f;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class TransformUtil {
    public static final float SIMDSQRT12 = 0.70710677f;
    public static final float ANGULAR_MOTION_THRESHOLD = 0.7853982f;

    public static float recipSqrt(float x) {
        return 1.0f / (float)Math.sqrt(x);
    }

    public static void planeSpace1(Vector3f n, Vector3f p, Vector3f q) {
        if (Math.abs(n.z) > 0.70710677f) {
            float a = n.y * n.y + n.z * n.z;
            float k = TransformUtil.recipSqrt(a);
            p.set(0.0f, -n.z * k, n.y * k);
            q.set(a * k, -n.x * p.z, n.x * p.y);
        } else {
            float a = n.x * n.x + n.y * n.y;
            float k = TransformUtil.recipSqrt(a);
            p.set(-n.y * k, n.x * k, 0.0f);
            q.set(-n.z * p.y, n.z * p.x, a * k);
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void integrateTransform(Transform transform, Vector3f vector3f, Vector3f vector3f2, float f, Transform transform2) {
        $Stack $Stack = $Stack.get();
        try {
            void angvel;
            Transform curTrans;
            void linvel;
            void timeStep;
            void predictedTransform;
            $Stack $Stack2 = $Stack;
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Quat4f();
            predictedTransform.origin.scaleAdd((float)timeStep, (Tuple3f)linvel, curTrans.origin);
            Vector3f axis = $Stack.get$javax$vecmath$Vector3f();
            float fAngle = angvel.length();
            if (fAngle * timeStep > 0.7853982f) {
                fAngle = 0.7853982f / timeStep;
            }
            if (fAngle < 0.001f) {
                axis.scale(0.5f * timeStep - timeStep * timeStep * timeStep * 0.020833334f * fAngle * fAngle, (Tuple3f)angvel);
            } else {
                axis.scale((float)Math.sin(0.5f * fAngle * timeStep) / fAngle, (Tuple3f)angvel);
            }
            Quat4f dorn = $Stack.get$javax$vecmath$Quat4f();
            dorn.set(axis.x, axis.y, axis.z, (float)Math.cos(fAngle * timeStep * 0.5f));
            Quat4f orn0 = curTrans.getRotation($Stack.get$javax$vecmath$Quat4f());
            Quat4f predictedOrn = $Stack.get$javax$vecmath$Quat4f();
            predictedOrn.mul(dorn, orn0);
            predictedOrn.normalize();
            predictedTransform.setRotation(predictedOrn);
            $Stack $Stack3 = $Stack;
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Quat4f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Quat4f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void calculateVelocity(Transform transform, Transform transform2, float f, Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void angVel;
            void timeStep;
            Transform transform0;
            void transform1;
            void linVel;
            $Stack.push$javax$vecmath$Vector3f();
            linVel.sub(transform1.origin, transform0.origin);
            linVel.scale(1.0f / timeStep);
            Vector3f axis = $Stack.get$javax$vecmath$Vector3f();
            float[] angle = new float[1];
            TransformUtil.calculateDiffAxisAngle(transform0, (Transform)transform1, axis, angle);
            angVel.scale(angle[0] / timeStep, axis);
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
    public static void calculateDiffAxisAngle(Transform transform, Transform transform2, Vector3f vector3f, float[] fArray) {
        $Stack $Stack = $Stack.get();
        try {
            void axis;
            void transform1;
            Transform transform0;
            $Stack $Stack2 = $Stack;
            $Stack2.push$javax$vecmath$Quat4f();
            $Stack2.push$javax$vecmath$Matrix3f();
            Matrix3f tmp = $Stack.get$javax$vecmath$Matrix3f();
            tmp.set(transform0.basis);
            MatrixUtil.invert(tmp);
            Matrix3f dmat = $Stack.get$javax$vecmath$Matrix3f();
            dmat.mul(transform1.basis, tmp);
            Quat4f dorn = $Stack.get$javax$vecmath$Quat4f();
            MatrixUtil.getRotation(dmat, dorn);
            dorn.normalize();
            angle[0] = QuaternionUtil.getAngle(dorn);
            axis.set(dorn.x, dorn.y, dorn.z);
            float len = axis.lengthSquared();
            if (len < 1.4210855E-14f) {
                axis.set(1.0f, 0.0f, 0.0f);
            } else {
                axis.scale(1.0f / (float)Math.sqrt(len));
            }
            $Stack $Stack3 = $Stack;
            $Stack3.pop$javax$vecmath$Quat4f();
            $Stack3.pop$javax$vecmath$Matrix3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$javax$vecmath$Quat4f();
            $Stack4.pop$javax$vecmath$Matrix3f();
            throw throwable;
        }
    }
}

