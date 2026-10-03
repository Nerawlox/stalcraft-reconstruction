/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.shapes.BvhTriangleMeshShape;
import com.bulletphysics.collision.shapes.ConcaveShape;
import com.bulletphysics.collision.shapes.TriangleCallback;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Matrix3f;
import javax.vecmath.Vector3f;

public class ScaledBvhTriangleMeshShape
extends ConcaveShape {
    protected final Vector3f localScaling = new Vector3f();
    protected BvhTriangleMeshShape bvhTriMeshShape;

    public ScaledBvhTriangleMeshShape(BvhTriangleMeshShape childShape, Vector3f localScaling) {
        this.localScaling.set(localScaling);
        this.bvhTriMeshShape = childShape;
    }

    public BvhTriangleMeshShape getChildShape() {
        return this.bvhTriMeshShape;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void processAllTriangles(TriangleCallback triangleCallback, Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void aabbMax;
            void aabbMin;
            void callback;
            $Stack.push$javax$vecmath$Vector3f();
            ScaledTriangleCallback scaledCallback = new ScaledTriangleCallback((TriangleCallback)callback, this.localScaling);
            Vector3f invLocalScaling = $Stack.get$javax$vecmath$Vector3f();
            invLocalScaling.set(1.0f / this.localScaling.x, 1.0f / this.localScaling.y, 1.0f / this.localScaling.z);
            Vector3f scaledAabbMin = $Stack.get$javax$vecmath$Vector3f();
            Vector3f scaledAabbMax = $Stack.get$javax$vecmath$Vector3f();
            scaledAabbMin.x = this.localScaling.x >= 0.0f ? aabbMin.x * invLocalScaling.x : aabbMax.x * invLocalScaling.x;
            scaledAabbMin.y = this.localScaling.y >= 0.0f ? aabbMin.y * invLocalScaling.y : aabbMax.y * invLocalScaling.y;
            scaledAabbMin.z = this.localScaling.z >= 0.0f ? aabbMin.z * invLocalScaling.z : aabbMax.z * invLocalScaling.z;
            scaledAabbMax.x = this.localScaling.x <= 0.0f ? aabbMin.x * invLocalScaling.x : aabbMax.x * invLocalScaling.x;
            scaledAabbMax.y = this.localScaling.y <= 0.0f ? aabbMin.y * invLocalScaling.y : aabbMax.y * invLocalScaling.y;
            scaledAabbMax.z = this.localScaling.z <= 0.0f ? aabbMin.z * invLocalScaling.z : aabbMax.z * invLocalScaling.z;
            this.bvhTriMeshShape.processAllTriangles(scaledCallback, scaledAabbMin, scaledAabbMax);
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
    @Override
    public void getAabb(Transform transform, Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void aabbMax;
            void aabbMin;
            void trans;
            $Stack $Stack2 = $Stack;
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Matrix3f();
            Vector3f localAabbMin = this.bvhTriMeshShape.getLocalAabbMin($Stack.get$javax$vecmath$Vector3f());
            Vector3f localAabbMax = this.bvhTriMeshShape.getLocalAabbMax($Stack.get$javax$vecmath$Vector3f());
            Vector3f tmpLocalAabbMin = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmpLocalAabbMax = $Stack.get$javax$vecmath$Vector3f();
            VectorUtil.mul(tmpLocalAabbMin, localAabbMin, this.localScaling);
            VectorUtil.mul(tmpLocalAabbMax, localAabbMax, this.localScaling);
            localAabbMin.x = this.localScaling.x >= 0.0f ? tmpLocalAabbMin.x : tmpLocalAabbMax.x;
            localAabbMin.y = this.localScaling.y >= 0.0f ? tmpLocalAabbMin.y : tmpLocalAabbMax.y;
            localAabbMin.z = this.localScaling.z >= 0.0f ? tmpLocalAabbMin.z : tmpLocalAabbMax.z;
            localAabbMax.x = this.localScaling.x <= 0.0f ? tmpLocalAabbMin.x : tmpLocalAabbMax.x;
            localAabbMax.y = this.localScaling.y <= 0.0f ? tmpLocalAabbMin.y : tmpLocalAabbMax.y;
            localAabbMax.z = this.localScaling.z <= 0.0f ? tmpLocalAabbMin.z : tmpLocalAabbMax.z;
            Vector3f localHalfExtents = $Stack.get$javax$vecmath$Vector3f();
            localHalfExtents.sub(localAabbMax, localAabbMin);
            localHalfExtents.scale(0.5f);
            float margin = this.bvhTriMeshShape.getMargin();
            localHalfExtents.x += margin;
            localHalfExtents.y += margin;
            localHalfExtents.z += margin;
            Vector3f localCenter = $Stack.get$javax$vecmath$Vector3f();
            localCenter.add(localAabbMax, localAabbMin);
            localCenter.scale(0.5f);
            Matrix3f abs_b = $Stack.get$javax$vecmath$Matrix3f(trans.basis);
            MatrixUtil.absolute(abs_b);
            Vector3f center = $Stack.get$javax$vecmath$Vector3f(localCenter);
            trans.transform(center);
            Vector3f extent = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            abs_b.getRow(0, tmp);
            extent.x = tmp.dot(localHalfExtents);
            abs_b.getRow(1, tmp);
            extent.y = tmp.dot(localHalfExtents);
            abs_b.getRow(2, tmp);
            extent.z = tmp.dot(localHalfExtents);
            aabbMin.sub(center, extent);
            aabbMax.add(center, extent);
            $Stack $Stack3 = $Stack;
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Matrix3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Matrix3f();
            throw throwable;
        }
    }

    @Override
    public BroadphaseNativeType getShapeType() {
        return BroadphaseNativeType.SCALED_TRIANGLE_MESH_SHAPE_PROXYTYPE;
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
    }

    @Override
    public String getName() {
        return "SCALEDBVHTRIANGLEMESH";
    }

    private static class ScaledTriangleCallback
    extends TriangleCallback {
        private TriangleCallback originalCallback;
        private Vector3f localScaling;
        private Vector3f[] newTriangle = new Vector3f[3];

        public ScaledTriangleCallback(TriangleCallback originalCallback, Vector3f localScaling) {
            this.originalCallback = originalCallback;
            this.localScaling = localScaling;
            for (int i = 0; i < this.newTriangle.length; ++i) {
                this.newTriangle[i] = new Vector3f();
            }
        }

        @Override
        public void processTriangle(Vector3f[] triangle, int partId, int triangleIndex) {
            VectorUtil.mul(this.newTriangle[0], triangle[0], this.localScaling);
            VectorUtil.mul(this.newTriangle[1], triangle[1], this.localScaling);
            VectorUtil.mul(this.newTriangle[2], triangle[2], this.localScaling);
            this.originalCallback.processTriangle(this.newTriangle, partId, triangleIndex);
        }
    }
}

