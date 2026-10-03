/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.shapes.ConvexInternalShape;
import com.bulletphysics.collision.shapes.ConvexShape;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class MinkowskiSumShape
extends ConvexInternalShape {
    private final Transform transA = new Transform();
    private final Transform transB = new Transform();
    private ConvexShape shapeA;
    private ConvexShape shapeB;

    public MinkowskiSumShape(ConvexShape shapeA, ConvexShape shapeB) {
        this.shapeA = shapeA;
        this.shapeB = shapeB;
        this.transA.setIdentity();
        this.transB.setIdentity();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Vector3f localGetSupportingVertexWithoutMargin(Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void out;
            void vec;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f supVertexA = $Stack.get$javax$vecmath$Vector3f();
            Vector3f supVertexB = $Stack.get$javax$vecmath$Vector3f();
            tmp.negate((Tuple3f)vec);
            MatrixUtil.transposeTransform(tmp, tmp, this.transA.basis);
            this.shapeA.localGetSupportingVertexWithoutMargin(tmp, supVertexA);
            this.transA.transform(supVertexA);
            MatrixUtil.transposeTransform(tmp, (Vector3f)vec, this.transB.basis);
            this.shapeB.localGetSupportingVertexWithoutMargin(tmp, supVertexB);
            this.transB.transform(supVertexB);
            out.sub(supVertexA, supVertexB);
            $Stack.pop$javax$vecmath$Vector3f();
            return out;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    @Override
    public void batchedUnitVectorGetSupportingVertexWithoutMargin(Vector3f[] vectors, Vector3f[] supportVerticesOut, int numVectors) {
        for (int i = 0; i < numVectors; ++i) {
            this.localGetSupportingVertexWithoutMargin(vectors[i], supportVerticesOut[i]);
        }
    }

    @Override
    public void getAabb(Transform t, Vector3f aabbMin, Vector3f aabbMax) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BroadphaseNativeType getShapeType() {
        return BroadphaseNativeType.MINKOWSKI_SUM_SHAPE_PROXYTYPE;
    }

    @Override
    public void calculateLocalInertia(float mass, Vector3f inertia) {
        assert (false);
        inertia.set(0.0f, 0.0f, 0.0f);
    }

    @Override
    public String getName() {
        return "MinkowskiSum";
    }

    @Override
    public float getMargin() {
        return this.shapeA.getMargin() + this.shapeB.getMargin();
    }

    public void setTransformA(Transform transA) {
        this.transA.set(transA);
    }

    public void setTransformB(Transform transB) {
        this.transB.set(transB);
    }

    public void getTransformA(Transform dest) {
        dest.set(this.transA);
    }

    public void getTransformB(Transform dest) {
        dest.set(this.transB);
    }
}

