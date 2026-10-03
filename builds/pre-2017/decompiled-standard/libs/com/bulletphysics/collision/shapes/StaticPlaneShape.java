/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.shapes.ConcaveShape;
import com.bulletphysics.collision.shapes.TriangleCallback;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.TransformUtil;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class StaticPlaneShape
extends ConcaveShape {
    protected final Vector3f localAabbMin = new Vector3f();
    protected final Vector3f localAabbMax = new Vector3f();
    protected final Vector3f planeNormal = new Vector3f();
    protected float planeConstant;
    protected final Vector3f localScaling = new Vector3f(0.0f, 0.0f, 0.0f);

    public StaticPlaneShape(Vector3f planeNormal, float planeConstant) {
        this.planeNormal.normalize(planeNormal);
        this.planeConstant = planeConstant;
    }

    public Vector3f getPlaneNormal(Vector3f out) {
        out.set(this.planeNormal);
        return out;
    }

    public float getPlaneConstant() {
        return this.planeConstant;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void processAllTriangles(TriangleCallback triangleCallback, Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void callback;
            void aabbMin;
            void aabbMax;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f halfExtents = $Stack.get$javax$vecmath$Vector3f();
            halfExtents.sub((Tuple3f)aabbMax, (Tuple3f)aabbMin);
            halfExtents.scale(0.5f);
            float radius = halfExtents.length();
            Vector3f center = $Stack.get$javax$vecmath$Vector3f();
            center.add((Tuple3f)aabbMax, (Tuple3f)aabbMin);
            center.scale(0.5f);
            Vector3f tangentDir0 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tangentDir1 = $Stack.get$javax$vecmath$Vector3f();
            TransformUtil.planeSpace1(this.planeNormal, tangentDir0, tangentDir1);
            Vector3f supVertex0 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f supVertex1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f projectedCenter = $Stack.get$javax$vecmath$Vector3f();
            tmp.scale(this.planeNormal.dot(center) - this.planeConstant, this.planeNormal);
            projectedCenter.sub(center, tmp);
            Vector3f[] triangle = new Vector3f[]{$Stack.get$javax$vecmath$Vector3f(), $Stack.get$javax$vecmath$Vector3f(), $Stack.get$javax$vecmath$Vector3f()};
            tmp1.scale(radius, tangentDir0);
            tmp2.scale(radius, tangentDir1);
            VectorUtil.add(triangle[0], projectedCenter, tmp1, tmp2);
            tmp1.scale(radius, tangentDir0);
            tmp2.scale(radius, tangentDir1);
            tmp.sub(tmp1, tmp2);
            VectorUtil.add(triangle[1], projectedCenter, tmp);
            tmp1.scale(radius, tangentDir0);
            tmp2.scale(radius, tangentDir1);
            tmp.sub(tmp1, tmp2);
            triangle[2].sub(projectedCenter, tmp);
            callback.processTriangle(triangle, 0, 0);
            tmp1.scale(radius, tangentDir0);
            tmp2.scale(radius, tangentDir1);
            tmp.sub(tmp1, tmp2);
            triangle[0].sub(projectedCenter, tmp);
            tmp1.scale(radius, tangentDir0);
            tmp2.scale(radius, tangentDir1);
            tmp.add(tmp1, tmp2);
            triangle[1].sub(projectedCenter, tmp);
            tmp1.scale(radius, tangentDir0);
            tmp2.scale(radius, tangentDir1);
            VectorUtil.add(triangle[2], projectedCenter, tmp1, tmp2);
            callback.processTriangle(triangle, 0, 1);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    @Override
    public void getAabb(Transform t, Vector3f aabbMin, Vector3f aabbMax) {
        aabbMin.set(-1.0E30f, -1.0E30f, -1.0E30f);
        aabbMax.set(1.0E30f, 1.0E30f, 1.0E30f);
    }

    @Override
    public BroadphaseNativeType getShapeType() {
        return BroadphaseNativeType.STATIC_PLANE_PROXYTYPE;
    }

    @Override
    public void setLocalScaling(Vector3f scaling) {
        this.localScaling.set(scaling);
    }

    @Override
    public Vector3f getLocalScaling(Vector3f out) {
        out.set(this.localScaling);
        return out;
    }

    @Override
    public void calculateLocalInertia(float mass, Vector3f inertia) {
        inertia.set(0.0f, 0.0f, 0.0f);
    }

    @Override
    public String getName() {
        return "STATICPLANE";
    }
}

