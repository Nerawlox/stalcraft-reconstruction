/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.shapes.PolyhedralConvexShape;
import com.bulletphysics.linearmath.VectorUtil;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;

public class ConvexHullShape
extends PolyhedralConvexShape {
    private final ObjectArrayList<Vector3f> points = new ObjectArrayList();

    public ConvexHullShape(ObjectArrayList<Vector3f> points) {
        for (int i = 0; i < points.size(); ++i) {
            this.points.add(new Vector3f(points.getQuick(i)));
        }
        this.recalcLocalAabb();
    }

    @Override
    public void setLocalScaling(Vector3f scaling) {
        this.localScaling.set(scaling);
        this.recalcLocalAabb();
    }

    public void addPoint(Vector3f point) {
        this.points.add(new Vector3f(point));
        this.recalcLocalAabb();
    }

    public ObjectArrayList<Vector3f> getPoints() {
        return this.points;
    }

    public int getNumPoints() {
        return this.points.size();
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
            for (int i = 0; i < this.points.size(); ++i) {
                VectorUtil.mul(vtx, this.points.getQuick(i), this.localScaling);
                float newDot = vec.dot(vtx);
                if (!(newDot > maxDot)) continue;
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

    /*
     * WARNING - void declaration
     */
    @Override
    public void batchedUnitVectorGetSupportingVertexWithoutMargin(Vector3f[] vector3fArray, Vector3f[] vector3fArray2, int n) {
        $Stack $Stack = $Stack.get();
        try {
            int numVectors;
            $Stack.push$javax$vecmath$Vector3f();
            float[] wcoords = new float[numVectors];
            for (int i = 0; i < numVectors; ++i) {
                wcoords[i] = -1.0E30f;
            }
            Vector3f vtx = $Stack.get$javax$vecmath$Vector3f();
            for (int i = 0; i < this.points.size(); ++i) {
                VectorUtil.mul(vtx, this.points.getQuick(i), this.localScaling);
                for (int j = 0; j < numVectors; ++j) {
                    void supportVerticesOut;
                    void vectors;
                    void vec = vectors[j];
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
    public int getNumVertices() {
        return this.points.size();
    }

    @Override
    public int getNumEdges() {
        return this.points.size();
    }

    @Override
    public void getEdge(int i, Vector3f pa, Vector3f pb) {
        int index0 = i % this.points.size();
        int index1 = (i + 1) % this.points.size();
        VectorUtil.mul(pa, this.points.getQuick(index0), this.localScaling);
        VectorUtil.mul(pb, this.points.getQuick(index1), this.localScaling);
    }

    @Override
    public void getVertex(int i, Vector3f vtx) {
        VectorUtil.mul(vtx, this.points.getQuick(i), this.localScaling);
    }

    @Override
    public int getNumPlanes() {
        return 0;
    }

    @Override
    public void getPlane(Vector3f planeNormal, Vector3f planeSupport, int i) {
        assert (false);
    }

    @Override
    public boolean isInside(Vector3f pt, float tolerance) {
        assert (false);
        return false;
    }

    @Override
    public BroadphaseNativeType getShapeType() {
        return BroadphaseNativeType.CONVEX_HULL_SHAPE_PROXYTYPE;
    }

    @Override
    public String getName() {
        return "Convex";
    }
}

