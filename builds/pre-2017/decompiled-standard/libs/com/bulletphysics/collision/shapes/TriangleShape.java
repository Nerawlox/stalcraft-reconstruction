/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.shapes.PolyhedralConvexShape;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Vector3f;

public class TriangleShape
extends PolyhedralConvexShape {
    public final Vector3f[] vertices1 = new Vector3f[]{new Vector3f(), new Vector3f(), new Vector3f()};

    public TriangleShape() {
    }

    public TriangleShape(Vector3f p0, Vector3f p1, Vector3f p2) {
        this.vertices1[0].set(p0);
        this.vertices1[1].set(p1);
        this.vertices1[2].set(p2);
    }

    public void init(Vector3f p0, Vector3f p1, Vector3f p2) {
        this.vertices1[0].set(p0);
        this.vertices1[1].set(p1);
        this.vertices1[2].set(p2);
    }

    @Override
    public int getNumVertices() {
        return 3;
    }

    public Vector3f getVertexPtr(int index) {
        return this.vertices1[index];
    }

    @Override
    public void getVertex(int index, Vector3f vert) {
        vert.set(this.vertices1[index]);
    }

    @Override
    public BroadphaseNativeType getShapeType() {
        return BroadphaseNativeType.TRIANGLE_SHAPE_PROXYTYPE;
    }

    @Override
    public int getNumEdges() {
        return 3;
    }

    @Override
    public void getEdge(int i, Vector3f pa, Vector3f pb) {
        this.getVertex(i, pa);
        this.getVertex((i + 1) % 3, pb);
    }

    @Override
    public void getAabb(Transform t, Vector3f aabbMin, Vector3f aabbMax) {
        this.getAabbSlow(t, aabbMin, aabbMax);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Vector3f localGetSupportingVertexWithoutMargin(Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void out;
            void dir;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f dots = $Stack.get$javax$vecmath$Vector3f();
            dots.set(dir.dot(this.vertices1[0]), dir.dot(this.vertices1[1]), dir.dot(this.vertices1[2]));
            out.set(this.vertices1[VectorUtil.maxAxis(dots)]);
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
            Vector3f dots = $Stack.get$javax$vecmath$Vector3f();
            for (int i = 0; i < numVectors; ++i) {
                void supportVerticesOut;
                void vectors;
                void dir = vectors[i];
                dots.set(dir.dot(this.vertices1[0]), dir.dot(this.vertices1[1]), dir.dot(this.vertices1[2]));
                supportVerticesOut[i].set(this.vertices1[VectorUtil.maxAxis(dots)]);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    @Override
    public void getPlane(Vector3f planeNormal, Vector3f planeSupport, int i) {
        this.getPlaneEquation(i, planeNormal, planeSupport);
    }

    @Override
    public int getNumPlanes() {
        return 1;
    }

    /*
     * WARNING - void declaration
     */
    public void calcNormal(Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void normal;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            tmp1.sub(this.vertices1[1], this.vertices1[0]);
            tmp2.sub(this.vertices1[2], this.vertices1[0]);
            normal.cross(tmp1, tmp2);
            normal.normalize();
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void getPlaneEquation(int i, Vector3f planeNormal, Vector3f planeSupport) {
        this.calcNormal(planeNormal);
        planeSupport.set(this.vertices1[0]);
    }

    @Override
    public void calculateLocalInertia(float mass, Vector3f inertia) {
        assert (false);
        inertia.set(0.0f, 0.0f, 0.0f);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean isInside(Vector3f vector3f, float f) {
        $Stack $Stack = $Stack.get();
        try {
            void tolerance;
            void pt;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f normal = $Stack.get$javax$vecmath$Vector3f();
            this.calcNormal(normal);
            float dist = pt.dot(normal);
            float planeconst = this.vertices1[0].dot(normal);
            dist -= planeconst;
            if (dist >= -tolerance && dist <= tolerance) {
                for (int i = 0; i < 3; ++i) {
                    Vector3f pa = $Stack.get$javax$vecmath$Vector3f();
                    Vector3f pb = $Stack.get$javax$vecmath$Vector3f();
                    this.getEdge(i, pa, pb);
                    Vector3f edge = $Stack.get$javax$vecmath$Vector3f();
                    edge.sub(pb, pa);
                    Vector3f edgeNormal = $Stack.get$javax$vecmath$Vector3f();
                    edgeNormal.cross(edge, normal);
                    edgeNormal.normalize();
                    dist = pt.dot(edgeNormal);
                    float edgeConst = pa.dot(edgeNormal);
                    dist -= edgeConst;
                    if (!(dist < -tolerance)) continue;
                    $Stack.pop$javax$vecmath$Vector3f();
                    return false;
                }
                $Stack.pop$javax$vecmath$Vector3f();
                return true;
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return false;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    @Override
    public int getNumPreferredPenetrationDirections() {
        return 2;
    }

    @Override
    public void getPreferredPenetrationDirection(int index, Vector3f penetrationVector) {
        this.calcNormal(penetrationVector);
        if (index != 0) {
            penetrationVector.scale(-1.0f);
        }
    }
}

