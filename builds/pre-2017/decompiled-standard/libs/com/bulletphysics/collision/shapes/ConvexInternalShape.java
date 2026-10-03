/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.shapes.ConvexShape;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Vector3f;

public abstract class ConvexInternalShape
extends ConvexShape {
    protected final Vector3f localScaling = new Vector3f(1.0f, 1.0f, 1.0f);
    protected final Vector3f implicitShapeDimensions = new Vector3f();
    protected float collisionMargin = 0.04f;

    @Override
    public void getAabb(Transform t, Vector3f aabbMin, Vector3f aabbMax) {
        this.getAabbSlow(t, aabbMin, aabbMax);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void getAabbSlow(Transform transform, Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Vector3f();
            float margin = this.getMargin();
            Vector3f vec = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            for (int i = 0; i < 3; ++i) {
                void minAabb;
                void maxAabb;
                void trans;
                vec.set(0.0f, 0.0f, 0.0f);
                VectorUtil.setCoord(vec, i, 1.0f);
                MatrixUtil.transposeTransform(tmp1, vec, trans.basis);
                this.localGetSupportingVertex(tmp1, tmp2);
                trans.transform(tmp2);
                VectorUtil.setCoord((Vector3f)maxAabb, i, VectorUtil.getCoord(tmp2, i) + margin);
                VectorUtil.setCoord(vec, i, -1.0f);
                MatrixUtil.transposeTransform(tmp1, vec, trans.basis);
                this.localGetSupportingVertex(tmp1, tmp2);
                trans.transform(tmp2);
                VectorUtil.setCoord((Vector3f)minAabb, i, VectorUtil.getCoord(tmp2, i) - margin);
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
            void out;
            void vec;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f supVertex = this.localGetSupportingVertexWithoutMargin((Vector3f)vec, (Vector3f)out);
            if (this.getMargin() != 0.0f) {
                Vector3f vecnorm = $Stack.get$javax$vecmath$Vector3f((Vector3f)vec);
                if (vecnorm.lengthSquared() < 1.4210855E-14f) {
                    vecnorm.set(-1.0f, -1.0f, -1.0f);
                }
                vecnorm.normalize();
                supVertex.scaleAdd(this.getMargin(), vecnorm, supVertex);
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
    public void setLocalScaling(Vector3f scaling) {
        this.localScaling.absolute(scaling);
    }

    @Override
    public Vector3f getLocalScaling(Vector3f out) {
        out.set(this.localScaling);
        return out;
    }

    @Override
    public float getMargin() {
        return this.collisionMargin;
    }

    @Override
    public void setMargin(float margin) {
        this.collisionMargin = margin;
    }

    @Override
    public int getNumPreferredPenetrationDirections() {
        return 0;
    }

    @Override
    public void getPreferredPenetrationDirection(int index, Vector3f penetrationVector) {
        throw new InternalError();
    }
}

