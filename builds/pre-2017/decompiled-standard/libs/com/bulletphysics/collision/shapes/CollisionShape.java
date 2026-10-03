/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Vector3f;

public abstract class CollisionShape {
    protected Object userPointer;

    public abstract void getAabb(Transform var1, Vector3f var2, Vector3f var3);

    /*
     * WARNING - void declaration
     */
    public void getBoundingSphere(Vector3f vector3f, float[] fArray) {
        $Stack $Stack = $Stack.get();
        try {
            void center;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Transform tr = $Stack.get$com$bulletphysics$linearmath$Transform();
            tr.setIdentity();
            Vector3f aabbMin = $Stack.get$javax$vecmath$Vector3f();
            Vector3f aabbMax = $Stack.get$javax$vecmath$Vector3f();
            this.getAabb(tr, aabbMin, aabbMax);
            tmp.sub(aabbMax, aabbMin);
            radius[0] = tmp.length() * 0.5f;
            tmp.add(aabbMin, aabbMax);
            center.scale(0.5f, tmp);
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$linearmath$Transform();
            $Stack3.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public float getAngularMotionDisc() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f center = $Stack.get$javax$vecmath$Vector3f();
            float[] disc = new float[1];
            this.getBoundingSphere(center, disc);
            disc[0] = disc[0] + center.length();
            float f = disc[0];
            $Stack.pop$javax$vecmath$Vector3f();
            return f;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void calculateTemporalAabb(Transform transform, Vector3f vector3f, Vector3f vector3f2, float f, Vector3f vector3f3, Vector3f vector3f4) {
        $Stack $Stack = $Stack.get();
        try {
            void angvel;
            void timeStep;
            void linvel;
            void temporalAabbMax;
            void temporalAabbMin;
            void curTrans;
            $Stack.push$javax$vecmath$Vector3f();
            this.getAabb((Transform)curTrans, (Vector3f)temporalAabbMin, (Vector3f)temporalAabbMax);
            float temporalAabbMaxx = temporalAabbMax.x;
            float temporalAabbMaxy = temporalAabbMax.y;
            float temporalAabbMaxz = temporalAabbMax.z;
            float temporalAabbMinx = temporalAabbMin.x;
            float temporalAabbMiny = temporalAabbMin.y;
            float temporalAabbMinz = temporalAabbMin.z;
            Vector3f linMotion = $Stack.get$javax$vecmath$Vector3f((Vector3f)linvel);
            linMotion.scale((float)timeStep);
            if (linMotion.x > 0.0f) {
                temporalAabbMaxx += linMotion.x;
            } else {
                temporalAabbMinx += linMotion.x;
            }
            if (linMotion.y > 0.0f) {
                temporalAabbMaxy += linMotion.y;
            } else {
                temporalAabbMiny += linMotion.y;
            }
            if (linMotion.z > 0.0f) {
                temporalAabbMaxz += linMotion.z;
            } else {
                temporalAabbMinz += linMotion.z;
            }
            float angularMotion = angvel.length() * this.getAngularMotionDisc() * timeStep;
            Vector3f angularMotion3d = $Stack.get$javax$vecmath$Vector3f();
            angularMotion3d.set(angularMotion, angularMotion, angularMotion);
            temporalAabbMin.set(temporalAabbMinx, temporalAabbMiny, temporalAabbMinz);
            temporalAabbMax.set(temporalAabbMaxx, temporalAabbMaxy, temporalAabbMaxz);
            temporalAabbMin.sub(angularMotion3d);
            temporalAabbMax.add(angularMotion3d);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public boolean isPolyhedral() {
        return this.getShapeType().isPolyhedral();
    }

    public boolean isConvex() {
        return this.getShapeType().isConvex();
    }

    public boolean isConcave() {
        return this.getShapeType().isConcave();
    }

    public boolean isCompound() {
        return this.getShapeType().isCompound();
    }

    public boolean isInfinite() {
        return this.getShapeType().isInfinite();
    }

    public abstract BroadphaseNativeType getShapeType();

    public abstract void setLocalScaling(Vector3f var1);

    public abstract Vector3f getLocalScaling(Vector3f var1);

    public abstract void calculateLocalInertia(float var1, Vector3f var2);

    public abstract String getName();

    public abstract void setMargin(float var1);

    public abstract float getMargin();

    public void setUserPointer(Object userPtr) {
        this.userPointer = userPtr;
    }

    public Object getUserPointer() {
        return this.userPointer;
    }
}

