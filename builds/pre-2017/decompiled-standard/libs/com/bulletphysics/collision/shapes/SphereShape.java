/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.shapes.ConvexInternalShape;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Vector3f;

public class SphereShape
extends ConvexInternalShape {
    public SphereShape(float radius) {
        this.implicitShapeDimensions.x = radius;
        this.collisionMargin = radius;
    }

    @Override
    public Vector3f localGetSupportingVertexWithoutMargin(Vector3f vec, Vector3f out) {
        out.set(0.0f, 0.0f, 0.0f);
        return out;
    }

    @Override
    public void batchedUnitVectorGetSupportingVertexWithoutMargin(Vector3f[] vectors, Vector3f[] supportVerticesOut, int numVectors) {
        for (int i = 0; i < numVectors; ++i) {
            supportVerticesOut[i].set(0.0f, 0.0f, 0.0f);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void getAabb(Transform transform, Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void aabbMax;
            void aabbMin;
            void t;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f center = t.origin;
            Vector3f extent = $Stack.get$javax$vecmath$Vector3f();
            extent.set(this.getMargin(), this.getMargin(), this.getMargin());
            aabbMin.sub(center, extent);
            aabbMax.add(center, extent);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    @Override
    public BroadphaseNativeType getShapeType() {
        return BroadphaseNativeType.SPHERE_SHAPE_PROXYTYPE;
    }

    @Override
    public void calculateLocalInertia(float mass, Vector3f inertia) {
        float elem = 0.4f * mass * this.getMargin() * this.getMargin();
        inertia.set(elem, elem, elem);
    }

    @Override
    public String getName() {
        return "SPHERE";
    }

    public float getRadius() {
        return this.implicitShapeDimensions.x * this.localScaling.x;
    }

    @Override
    public void setMargin(float margin) {
        super.setMargin(margin);
    }

    @Override
    public float getMargin() {
        return this.getRadius();
    }
}

