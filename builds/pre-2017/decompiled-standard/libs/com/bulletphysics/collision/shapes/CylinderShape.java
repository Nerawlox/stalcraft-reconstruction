/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.shapes.BoxShape;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class CylinderShape
extends BoxShape {
    protected int upAxis;

    public CylinderShape(Vector3f halfExtents) {
        super(halfExtents);
        this.upAxis = 1;
        this.recalcLocalAabb();
    }

    protected CylinderShape(Vector3f halfExtents, boolean unused) {
        super(halfExtents);
    }

    @Override
    public void getAabb(Transform t, Vector3f aabbMin, Vector3f aabbMax) {
        this._PolyhedralConvexShape_getAabb(t, aabbMin, aabbMax);
    }

    protected Vector3f cylinderLocalSupportX(Vector3f halfExtents, Vector3f v, Vector3f out) {
        return this.cylinderLocalSupport(halfExtents, v, 0, 1, 0, 2, out);
    }

    protected Vector3f cylinderLocalSupportY(Vector3f halfExtents, Vector3f v, Vector3f out) {
        return this.cylinderLocalSupport(halfExtents, v, 1, 0, 1, 2, out);
    }

    protected Vector3f cylinderLocalSupportZ(Vector3f halfExtents, Vector3f v, Vector3f out) {
        return this.cylinderLocalSupport(halfExtents, v, 2, 0, 2, 1, out);
    }

    private Vector3f cylinderLocalSupport(Vector3f halfExtents, Vector3f v, int cylinderUpAxis, int XX, int YY, int ZZ, Vector3f out) {
        float radius = VectorUtil.getCoord(halfExtents, XX);
        float halfHeight = VectorUtil.getCoord(halfExtents, cylinderUpAxis);
        float s = (float)Math.sqrt(VectorUtil.getCoord(v, XX) * VectorUtil.getCoord(v, XX) + VectorUtil.getCoord(v, ZZ) * VectorUtil.getCoord(v, ZZ));
        if (s != 0.0f) {
            float d = radius / s;
            VectorUtil.setCoord(out, XX, VectorUtil.getCoord(v, XX) * d);
            VectorUtil.setCoord(out, YY, VectorUtil.getCoord(v, YY) < 0.0f ? -halfHeight : halfHeight);
            VectorUtil.setCoord(out, ZZ, VectorUtil.getCoord(v, ZZ) * d);
            return out;
        }
        VectorUtil.setCoord(out, XX, radius);
        VectorUtil.setCoord(out, YY, VectorUtil.getCoord(v, YY) < 0.0f ? -halfHeight : halfHeight);
        VectorUtil.setCoord(out, ZZ, 0.0f);
        return out;
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
            Vector3f vector3f3 = this.cylinderLocalSupportY(this.getHalfExtentsWithoutMargin($Stack.get$javax$vecmath$Vector3f()), (Vector3f)vec, (Vector3f)out);
            $Stack.pop$javax$vecmath$Vector3f();
            return vector3f3;
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
    public void batchedUnitVectorGetSupportingVertexWithoutMargin(Vector3f[] vector3fArray, Vector3f[] vector3fArray2, int n) {
        $Stack $Stack = $Stack.get();
        try {
            int numVectors;
            $Stack.push$javax$vecmath$Vector3f();
            for (int i = 0; i < numVectors; ++i) {
                void supportVerticesOut;
                void vectors;
                this.cylinderLocalSupportY(this.getHalfExtentsWithoutMargin($Stack.get$javax$vecmath$Vector3f()), (Vector3f)vectors[i], (Vector3f)supportVerticesOut[i]);
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
    public Vector3f localGetSupportingVertex(Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void vec;
            void out;
            $Stack.push$javax$vecmath$Vector3f();
            void supVertex = out;
            this.localGetSupportingVertexWithoutMargin((Vector3f)vec, (Vector3f)supVertex);
            if (this.getMargin() != 0.0f) {
                Vector3f vecnorm = $Stack.get$javax$vecmath$Vector3f((Vector3f)vec);
                if (vecnorm.lengthSquared() < 1.4210855E-14f) {
                    vecnorm.set(-1.0f, -1.0f, -1.0f);
                }
                vecnorm.normalize();
                supVertex.scaleAdd(this.getMargin(), vecnorm, (Tuple3f)supVertex);
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
    public BroadphaseNativeType getShapeType() {
        return BroadphaseNativeType.CYLINDER_SHAPE_PROXYTYPE;
    }

    public int getUpAxis() {
        return this.upAxis;
    }

    public float getRadius() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Vector3f();
            float f = this.getHalfExtentsWithMargin((Vector3f)$Stack.get$javax$vecmath$Vector3f()).x;
            $Stack.pop$javax$vecmath$Vector3f();
            return f;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    @Override
    public String getName() {
        return "CylinderY";
    }
}

