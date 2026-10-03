/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.shapes.ConvexInternalShape;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Matrix3f;
import javax.vecmath.Vector3f;

public class CapsuleShape
extends ConvexInternalShape {
    protected int upAxis;

    CapsuleShape() {
    }

    public CapsuleShape(float radius, float height) {
        this.upAxis = 1;
        this.implicitShapeDimensions.set(radius, 0.5f * height, radius);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Vector3f localGetSupportingVertexWithoutMargin(Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void vec0;
            void out;
            $Stack.push$javax$vecmath$Vector3f();
            void supVec = out;
            supVec.set(0.0f, 0.0f, 0.0f);
            float maxDot = -1.0E30f;
            Vector3f vec = $Stack.get$javax$vecmath$Vector3f((Vector3f)vec0);
            float lenSqr = vec.lengthSquared();
            if (lenSqr < 1.0E-4f) {
                vec.set(1.0f, 0.0f, 0.0f);
            } else {
                float rlen = 1.0f / (float)Math.sqrt(lenSqr);
                vec.scale(rlen);
            }
            Vector3f vtx = $Stack.get$javax$vecmath$Vector3f();
            float radius = this.getRadius();
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f pos = $Stack.get$javax$vecmath$Vector3f();
            pos.set(0.0f, 0.0f, 0.0f);
            VectorUtil.setCoord(pos, this.getUpAxis(), this.getHalfHeight());
            VectorUtil.mul(tmp1, vec, this.localScaling);
            tmp1.scale(radius);
            tmp2.scale(this.getMargin(), vec);
            vtx.add(pos, tmp1);
            vtx.sub(tmp2);
            float newDot = vec.dot(vtx);
            if (newDot > maxDot) {
                maxDot = newDot;
                supVec.set(vtx);
            }
            pos.set(0.0f, 0.0f, 0.0f);
            VectorUtil.setCoord(pos, this.getUpAxis(), -this.getHalfHeight());
            VectorUtil.mul(tmp1, vec, this.localScaling);
            tmp1.scale(radius);
            tmp2.scale(this.getMargin(), vec);
            vtx.add(pos, tmp1);
            vtx.sub(tmp2);
            newDot = vec.dot(vtx);
            if (newDot > maxDot) {
                maxDot = newDot;
                supVec.set(vtx);
            }
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void calculateLocalInertia(float f, Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void mass;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Transform ident = $Stack.get$com$bulletphysics$linearmath$Transform();
            ident.setIdentity();
            float radius = this.getRadius();
            Vector3f halfExtents = $Stack.get$javax$vecmath$Vector3f();
            halfExtents.set(radius, radius, radius);
            VectorUtil.setCoord(halfExtents, this.getUpAxis(), radius + this.getHalfHeight());
            float margin = 0.04f;
            float lx = 2.0f * (halfExtents.x + margin);
            float ly = 2.0f * (halfExtents.y + margin);
            float lz = 2.0f * (halfExtents.z + margin);
            float x2 = lx * lx;
            float y2 = ly * ly;
            float z2 = lz * lz;
            void scaledmass = mass * 0.08333333f;
            inertia.x = scaledmass * (y2 + z2);
            inertia.y = scaledmass * (x2 + z2);
            inertia.z = scaledmass * (x2 + y2);
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

    @Override
    public BroadphaseNativeType getShapeType() {
        return BroadphaseNativeType.CAPSULE_SHAPE_PROXYTYPE;
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
            $Stack $Stack2 = $Stack;
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Matrix3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f halfExtents = $Stack.get$javax$vecmath$Vector3f();
            halfExtents.set(this.getRadius(), this.getRadius(), this.getRadius());
            VectorUtil.setCoord(halfExtents, this.upAxis, this.getRadius() + this.getHalfHeight());
            halfExtents.x += this.getMargin();
            halfExtents.y += this.getMargin();
            halfExtents.z += this.getMargin();
            Matrix3f abs_b = $Stack.get$javax$vecmath$Matrix3f();
            abs_b.set(t.basis);
            MatrixUtil.absolute(abs_b);
            Vector3f center = t.origin;
            Vector3f extent = $Stack.get$javax$vecmath$Vector3f();
            abs_b.getRow(0, tmp);
            extent.x = tmp.dot(halfExtents);
            abs_b.getRow(1, tmp);
            extent.y = tmp.dot(halfExtents);
            abs_b.getRow(2, tmp);
            extent.z = tmp.dot(halfExtents);
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
    public String getName() {
        return "CapsuleShape";
    }

    public int getUpAxis() {
        return this.upAxis;
    }

    public float getRadius() {
        int radiusAxis = (this.upAxis + 2) % 3;
        return VectorUtil.getCoord(this.implicitShapeDimensions, radiusAxis);
    }

    public float getHalfHeight() {
        return VectorUtil.getCoord(this.implicitShapeDimensions, this.upAxis);
    }
}

