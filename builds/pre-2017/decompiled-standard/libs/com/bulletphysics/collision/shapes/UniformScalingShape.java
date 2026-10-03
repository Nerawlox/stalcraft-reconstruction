/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.shapes.ConvexShape;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class UniformScalingShape
extends ConvexShape {
    private ConvexShape childConvexShape;
    private float uniformScalingFactor;

    public UniformScalingShape(ConvexShape convexChildShape, float uniformScalingFactor) {
        this.childConvexShape = convexChildShape;
        this.uniformScalingFactor = uniformScalingFactor;
    }

    public float getUniformScalingFactor() {
        return this.uniformScalingFactor;
    }

    public ConvexShape getChildShape() {
        return this.childConvexShape;
    }

    @Override
    public Vector3f localGetSupportingVertex(Vector3f vec, Vector3f out) {
        this.childConvexShape.localGetSupportingVertex(vec, out);
        out.scale(this.uniformScalingFactor);
        return out;
    }

    @Override
    public Vector3f localGetSupportingVertexWithoutMargin(Vector3f vec, Vector3f out) {
        this.childConvexShape.localGetSupportingVertexWithoutMargin(vec, out);
        out.scale(this.uniformScalingFactor);
        return out;
    }

    @Override
    public void batchedUnitVectorGetSupportingVertexWithoutMargin(Vector3f[] vectors, Vector3f[] supportVerticesOut, int numVectors) {
        this.childConvexShape.batchedUnitVectorGetSupportingVertexWithoutMargin(vectors, supportVerticesOut, numVectors);
        for (int i = 0; i < numVectors; ++i) {
            supportVerticesOut[i].scale(this.uniformScalingFactor);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void getAabbSlow(Transform transform, Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void aabbMax;
            void aabbMin;
            void t;
            $Stack.push$javax$vecmath$Vector3f();
            this.childConvexShape.getAabbSlow((Transform)t, (Vector3f)aabbMin, (Vector3f)aabbMax);
            Vector3f aabbCenter = $Stack.get$javax$vecmath$Vector3f();
            aabbCenter.add((Tuple3f)aabbMax, (Tuple3f)aabbMin);
            aabbCenter.scale(0.5f);
            Vector3f scaledAabbHalfExtends = $Stack.get$javax$vecmath$Vector3f();
            scaledAabbHalfExtends.sub((Tuple3f)aabbMax, (Tuple3f)aabbMin);
            scaledAabbHalfExtends.scale(0.5f * this.uniformScalingFactor);
            aabbMin.sub(aabbCenter, scaledAabbHalfExtends);
            aabbMax.add(aabbCenter, scaledAabbHalfExtends);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    @Override
    public void setLocalScaling(Vector3f scaling) {
        this.childConvexShape.setLocalScaling(scaling);
    }

    @Override
    public Vector3f getLocalScaling(Vector3f out) {
        this.childConvexShape.getLocalScaling(out);
        return out;
    }

    @Override
    public void setMargin(float margin) {
        this.childConvexShape.setMargin(margin);
    }

    @Override
    public float getMargin() {
        return this.childConvexShape.getMargin() * this.uniformScalingFactor;
    }

    @Override
    public int getNumPreferredPenetrationDirections() {
        return this.childConvexShape.getNumPreferredPenetrationDirections();
    }

    @Override
    public void getPreferredPenetrationDirection(int index, Vector3f penetrationVector) {
        this.childConvexShape.getPreferredPenetrationDirection(index, penetrationVector);
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
            this.childConvexShape.getAabb((Transform)t, (Vector3f)aabbMin, (Vector3f)aabbMax);
            Vector3f aabbCenter = $Stack.get$javax$vecmath$Vector3f();
            aabbCenter.add((Tuple3f)aabbMax, (Tuple3f)aabbMin);
            aabbCenter.scale(0.5f);
            Vector3f scaledAabbHalfExtends = $Stack.get$javax$vecmath$Vector3f();
            scaledAabbHalfExtends.sub((Tuple3f)aabbMax, (Tuple3f)aabbMin);
            scaledAabbHalfExtends.scale(0.5f * this.uniformScalingFactor);
            aabbMin.sub(aabbCenter, scaledAabbHalfExtends);
            aabbMax.add(aabbCenter, scaledAabbHalfExtends);
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
        return BroadphaseNativeType.UNIFORM_SCALING_SHAPE_PROXYTYPE;
    }

    @Override
    public void calculateLocalInertia(float mass, Vector3f inertia) {
        this.childConvexShape.calculateLocalInertia(mass, inertia);
        inertia.scale(this.uniformScalingFactor);
    }

    @Override
    public String getName() {
        return "UniformScalingShape";
    }
}

