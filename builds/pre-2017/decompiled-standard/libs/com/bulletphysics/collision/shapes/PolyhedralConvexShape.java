/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.shapes.ConvexInternalShape;
import com.bulletphysics.linearmath.AabbUtil2;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Vector3f;

public abstract class PolyhedralConvexShape
extends ConvexInternalShape {
    private static Vector3f[] _directions = new Vector3f[]{new Vector3f(1.0f, 0.0f, 0.0f), new Vector3f(0.0f, 1.0f, 0.0f), new Vector3f(0.0f, 0.0f, 1.0f), new Vector3f(-1.0f, 0.0f, 0.0f), new Vector3f(0.0f, -1.0f, 0.0f), new Vector3f(0.0f, 0.0f, -1.0f)};
    private static Vector3f[] _supporting = new Vector3f[]{new Vector3f(0.0f, 0.0f, 0.0f), new Vector3f(0.0f, 0.0f, 0.0f), new Vector3f(0.0f, 0.0f, 0.0f), new Vector3f(0.0f, 0.0f, 0.0f), new Vector3f(0.0f, 0.0f, 0.0f), new Vector3f(0.0f, 0.0f, 0.0f)};
    protected final Vector3f localAabbMin = new Vector3f(1.0f, 1.0f, 1.0f);
    protected final Vector3f localAabbMax = new Vector3f(-1.0f, -1.0f, -1.0f);
    protected boolean isLocalAabbValid = false;

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
            Vector3f supVec = out;
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
            for (int i = 0; i < this.getNumVertices(); ++i) {
                this.getVertex(i, vtx);
                float newDot = vec.dot(vtx);
                if (!(newDot > maxDot)) continue;
                maxDot = newDot;
                supVec = vtx;
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return out;
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
            int i;
            int numVectors;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f vtx = $Stack.get$javax$vecmath$Vector3f();
            float[] wcoords = new float[numVectors];
            for (i = 0; i < numVectors; ++i) {
                wcoords[i] = -1.0E30f;
            }
            for (int j = 0; j < numVectors; ++j) {
                void vectors;
                void vec = vectors[j];
                for (i = 0; i < this.getNumVertices(); ++i) {
                    void supportVerticesOut;
                    this.getVertex(i, vtx);
                    float newDot = vec.dot(vtx);
                    if (!(newDot > wcoords[j])) continue;
                    supportVerticesOut[j].set(vtx);
                    wcoords[j] = newDot;
                }
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
    public void calculateLocalInertia(float f, Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void inertia;
            void mass;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            float margin = this.getMargin();
            Transform ident = $Stack.get$com$bulletphysics$linearmath$Transform();
            ident.setIdentity();
            Vector3f aabbMin = $Stack.get$javax$vecmath$Vector3f();
            Vector3f aabbMax = $Stack.get$javax$vecmath$Vector3f();
            this.getAabb(ident, aabbMin, aabbMax);
            Vector3f halfExtents = $Stack.get$javax$vecmath$Vector3f();
            halfExtents.sub(aabbMax, aabbMin);
            halfExtents.scale(0.5f);
            float lx = 2.0f * (halfExtents.x + margin);
            float ly = 2.0f * (halfExtents.y + margin);
            float lz = 2.0f * (halfExtents.z + margin);
            float x2 = lx * lx;
            float y2 = ly * ly;
            float z2 = lz * lz;
            void scaledmass = mass * 0.08333333f;
            inertia.set(y2 + z2, x2 + z2, x2 + y2);
            inertia.scale((float)scaledmass);
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

    private void getNonvirtualAabb(Transform trans, Vector3f aabbMin, Vector3f aabbMax, float margin) {
        assert (this.isLocalAabbValid);
        AabbUtil2.transformAabb(this.localAabbMin, this.localAabbMax, margin, trans, aabbMin, aabbMax);
    }

    @Override
    public void getAabb(Transform trans, Vector3f aabbMin, Vector3f aabbMax) {
        this.getNonvirtualAabb(trans, aabbMin, aabbMax, this.getMargin());
    }

    protected final void _PolyhedralConvexShape_getAabb(Transform trans, Vector3f aabbMin, Vector3f aabbMax) {
        this.getNonvirtualAabb(trans, aabbMin, aabbMax, this.getMargin());
    }

    public void recalcLocalAabb() {
        this.isLocalAabbValid = true;
        this.batchedUnitVectorGetSupportingVertexWithoutMargin(_directions, _supporting, 6);
        for (int i = 0; i < 3; ++i) {
            VectorUtil.setCoord(this.localAabbMax, i, VectorUtil.getCoord(_supporting[i], i) + this.collisionMargin);
            VectorUtil.setCoord(this.localAabbMin, i, VectorUtil.getCoord(_supporting[i + 3], i) - this.collisionMargin);
        }
    }

    @Override
    public void setLocalScaling(Vector3f scaling) {
        super.setLocalScaling(scaling);
        this.recalcLocalAabb();
    }

    public abstract int getNumVertices();

    public abstract int getNumEdges();

    public abstract void getEdge(int var1, Vector3f var2, Vector3f var3);

    public abstract void getVertex(int var1, Vector3f var2);

    public abstract int getNumPlanes();

    public abstract void getPlane(Vector3f var1, Vector3f var2, int var3);

    public abstract boolean isInside(Vector3f var1, float var2);
}

