/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.shapes.ConcaveShape;
import com.bulletphysics.collision.shapes.InternalTriangleIndexCallback;
import com.bulletphysics.collision.shapes.StridingMeshInterface;
import com.bulletphysics.collision.shapes.TriangleCallback;
import com.bulletphysics.linearmath.AabbUtil2;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Matrix3f;
import javax.vecmath.Vector3f;

public abstract class TriangleMeshShape
extends ConcaveShape {
    protected final Vector3f localAabbMin = new Vector3f();
    protected final Vector3f localAabbMax = new Vector3f();
    protected StridingMeshInterface meshInterface;

    protected TriangleMeshShape(StridingMeshInterface meshInterface) {
        this.meshInterface = meshInterface;
    }

    /*
     * WARNING - void declaration
     */
    public Vector3f localGetSupportingVertex(Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void vec;
            void out;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            void supportVertex = out;
            Transform ident = $Stack.get$com$bulletphysics$linearmath$Transform();
            ident.setIdentity();
            SupportVertexCallback supportCallback = new SupportVertexCallback((Vector3f)vec, ident);
            Vector3f aabbMax = $Stack.get$javax$vecmath$Vector3f();
            aabbMax.set(1.0E30f, 1.0E30f, 1.0E30f);
            tmp.negate(aabbMax);
            this.processAllTriangles(supportCallback, tmp, aabbMax);
            supportCallback.getSupportVertexLocal((Vector3f)supportVertex);
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$linearmath$Transform();
            $Stack3.pop$javax$vecmath$Vector3f();
            return out;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public Vector3f localGetSupportingVertexWithoutMargin(Vector3f vec, Vector3f out) {
        assert (false);
        return this.localGetSupportingVertex(vec, out);
    }

    public void recalcLocalAabb() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Vector3f();
            for (int i = 0; i < 3; ++i) {
                Vector3f vec = $Stack.get$javax$vecmath$Vector3f();
                vec.set(0.0f, 0.0f, 0.0f);
                VectorUtil.setCoord(vec, i, 1.0f);
                Vector3f tmp = this.localGetSupportingVertex(vec, $Stack.get$javax$vecmath$Vector3f());
                VectorUtil.setCoord(this.localAabbMax, i, VectorUtil.getCoord(tmp, i) + this.collisionMargin);
                VectorUtil.setCoord(vec, i, -1.0f);
                this.localGetSupportingVertex(vec, tmp);
                VectorUtil.setCoord(this.localAabbMin, i, VectorUtil.getCoord(tmp, i) - this.collisionMargin);
            }
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
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f localHalfExtents = $Stack.get$javax$vecmath$Vector3f();
            localHalfExtents.sub(this.localAabbMax, this.localAabbMin);
            localHalfExtents.scale(0.5f);
            Vector3f localCenter = $Stack.get$javax$vecmath$Vector3f();
            localCenter.add(this.localAabbMax, this.localAabbMin);
            localCenter.scale(0.5f);
            Matrix3f abs_b = $Stack.get$javax$vecmath$Matrix3f(trans.basis);
            MatrixUtil.absolute(abs_b);
            Vector3f center = $Stack.get$javax$vecmath$Vector3f(localCenter);
            trans.transform(center);
            Vector3f extent = $Stack.get$javax$vecmath$Vector3f();
            abs_b.getRow(0, tmp);
            extent.x = tmp.dot(localHalfExtents);
            abs_b.getRow(1, tmp);
            extent.y = tmp.dot(localHalfExtents);
            abs_b.getRow(2, tmp);
            extent.z = tmp.dot(localHalfExtents);
            Vector3f margin = $Stack.get$javax$vecmath$Vector3f();
            margin.set(this.getMargin(), this.getMargin(), this.getMargin());
            extent.add(margin);
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
    public void processAllTriangles(TriangleCallback callback, Vector3f aabbMin, Vector3f aabbMax) {
        FilteredCallback filterCallback = new FilteredCallback(callback, aabbMin, aabbMax);
        this.meshInterface.internalProcessAllTriangles(filterCallback, aabbMin, aabbMax);
    }

    @Override
    public void calculateLocalInertia(float mass, Vector3f inertia) {
        assert (false);
        inertia.set(0.0f, 0.0f, 0.0f);
    }

    @Override
    public void setLocalScaling(Vector3f scaling) {
        this.meshInterface.setScaling(scaling);
        this.recalcLocalAabb();
    }

    @Override
    public Vector3f getLocalScaling(Vector3f out) {
        return this.meshInterface.getScaling(out);
    }

    public StridingMeshInterface getMeshInterface() {
        return this.meshInterface;
    }

    public Vector3f getLocalAabbMin(Vector3f out) {
        out.set(this.localAabbMin);
        return out;
    }

    public Vector3f getLocalAabbMax(Vector3f out) {
        out.set(this.localAabbMax);
        return out;
    }

    @Override
    public String getName() {
        return "TRIANGLEMESH";
    }

    private static class FilteredCallback
    extends InternalTriangleIndexCallback {
        public TriangleCallback callback;
        public final Vector3f aabbMin = new Vector3f();
        public final Vector3f aabbMax = new Vector3f();

        public FilteredCallback(TriangleCallback callback, Vector3f aabbMin, Vector3f aabbMax) {
            this.callback = callback;
            this.aabbMin.set(aabbMin);
            this.aabbMax.set(aabbMax);
        }

        @Override
        public void internalProcessTriangleIndex(Vector3f[] triangle, int partId, int triangleIndex) {
            if (AabbUtil2.testTriangleAgainstAabb2(triangle, this.aabbMin, this.aabbMax)) {
                this.callback.processTriangle(triangle, partId, triangleIndex);
            }
        }
    }

    private class SupportVertexCallback
    extends TriangleCallback {
        private final Vector3f supportVertexLocal = new Vector3f(0.0f, 0.0f, 0.0f);
        public final Transform worldTrans = new Transform();
        public float maxDot = -1.0E30f;
        public final Vector3f supportVecLocal = new Vector3f();

        public SupportVertexCallback(Vector3f supportVecWorld, Transform trans) {
            this.worldTrans.set(trans);
            MatrixUtil.transposeTransform(this.supportVecLocal, supportVecWorld, this.worldTrans.basis);
        }

        @Override
        public void processTriangle(Vector3f[] triangle, int partId, int triangleIndex) {
            for (int i = 0; i < 3; ++i) {
                float dot = this.supportVecLocal.dot(triangle[i]);
                if (!(dot > this.maxDot)) continue;
                this.maxDot = dot;
                this.supportVertexLocal.set(triangle[i]);
            }
        }

        public Vector3f getSupportVertexWorldSpace(Vector3f out) {
            out.set(this.supportVertexLocal);
            this.worldTrans.transform(out);
            return out;
        }

        public Vector3f getSupportVertexLocal(Vector3f out) {
            out.set(this.supportVertexLocal);
            return out;
        }
    }
}

