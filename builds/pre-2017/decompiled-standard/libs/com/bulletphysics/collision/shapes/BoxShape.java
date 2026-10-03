/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.shapes.PolyhedralConvexShape;
import com.bulletphysics.linearmath.AabbUtil2;
import com.bulletphysics.linearmath.ScalarUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

public class BoxShape
extends PolyhedralConvexShape {
    public BoxShape(Vector3f boxHalfExtents) {
        Vector3f margin = new Vector3f(this.getMargin(), this.getMargin(), this.getMargin());
        VectorUtil.mul(this.implicitShapeDimensions, boxHalfExtents, this.localScaling);
        this.implicitShapeDimensions.sub(margin);
    }

    /*
     * WARNING - void declaration
     */
    public Vector3f getHalfExtentsWithMargin(Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void out;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f halfExtents = this.getHalfExtentsWithoutMargin((Vector3f)out);
            Vector3f margin = $Stack.get$javax$vecmath$Vector3f();
            margin.set(this.getMargin(), this.getMargin(), this.getMargin());
            halfExtents.add(margin);
            $Stack.pop$javax$vecmath$Vector3f();
            return out;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public Vector3f getHalfExtentsWithoutMargin(Vector3f out) {
        out.set(this.implicitShapeDimensions);
        return out;
    }

    @Override
    public BroadphaseNativeType getShapeType() {
        return BroadphaseNativeType.BOX_SHAPE_PROXYTYPE;
    }

    @Override
    public Vector3f localGetSupportingVertex(Vector3f vec, Vector3f out) {
        Vector3f halfExtents = this.getHalfExtentsWithoutMargin(out);
        float margin = this.getMargin();
        halfExtents.x += margin;
        halfExtents.y += margin;
        halfExtents.z += margin;
        out.set(ScalarUtil.fsel(vec.x, halfExtents.x, -halfExtents.x), ScalarUtil.fsel(vec.y, halfExtents.y, -halfExtents.y), ScalarUtil.fsel(vec.z, halfExtents.z, -halfExtents.z));
        return out;
    }

    @Override
    public Vector3f localGetSupportingVertexWithoutMargin(Vector3f vec, Vector3f out) {
        Vector3f halfExtents = this.getHalfExtentsWithoutMargin(out);
        out.set(ScalarUtil.fsel(vec.x, halfExtents.x, -halfExtents.x), ScalarUtil.fsel(vec.y, halfExtents.y, -halfExtents.y), ScalarUtil.fsel(vec.z, halfExtents.z, -halfExtents.z));
        return out;
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
            Vector3f halfExtents = this.getHalfExtentsWithoutMargin($Stack.get$javax$vecmath$Vector3f());
            for (int i = 0; i < numVectors; ++i) {
                void supportVerticesOut;
                void vectors;
                void vec = vectors[i];
                supportVerticesOut[i].set(ScalarUtil.fsel(vec.x, halfExtents.x, -halfExtents.x), ScalarUtil.fsel(vec.y, halfExtents.y, -halfExtents.y), ScalarUtil.fsel(vec.z, halfExtents.z, -halfExtents.z));
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
    public void setMargin(float f) {
        $Stack $Stack = $Stack.get();
        try {
            void margin;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f oldMargin = $Stack.get$javax$vecmath$Vector3f();
            oldMargin.set(this.getMargin(), this.getMargin(), this.getMargin());
            Vector3f implicitShapeDimensionsWithMargin = $Stack.get$javax$vecmath$Vector3f();
            implicitShapeDimensionsWithMargin.add(this.implicitShapeDimensions, oldMargin);
            super.setMargin((float)margin);
            Vector3f newMargin = $Stack.get$javax$vecmath$Vector3f();
            newMargin.set(this.getMargin(), this.getMargin(), this.getMargin());
            this.implicitShapeDimensions.sub(implicitShapeDimensionsWithMargin, newMargin);
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
    public void setLocalScaling(Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void scaling;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f oldMargin = $Stack.get$javax$vecmath$Vector3f();
            oldMargin.set(this.getMargin(), this.getMargin(), this.getMargin());
            Vector3f implicitShapeDimensionsWithMargin = $Stack.get$javax$vecmath$Vector3f();
            implicitShapeDimensionsWithMargin.add(this.implicitShapeDimensions, oldMargin);
            Vector3f unScaledImplicitShapeDimensionsWithMargin = $Stack.get$javax$vecmath$Vector3f();
            VectorUtil.div(unScaledImplicitShapeDimensionsWithMargin, implicitShapeDimensionsWithMargin, this.localScaling);
            super.setLocalScaling((Vector3f)scaling);
            VectorUtil.mul(this.implicitShapeDimensions, unScaledImplicitShapeDimensionsWithMargin, this.localScaling);
            this.implicitShapeDimensions.sub(oldMargin);
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
            void t;
            $Stack.push$javax$vecmath$Vector3f();
            AabbUtil2.transformAabb(this.getHalfExtentsWithoutMargin($Stack.get$javax$vecmath$Vector3f()), this.getMargin(), (Transform)t, (Vector3f)aabbMin, (Vector3f)aabbMax);
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
            void mass;
            void inertia;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f halfExtents = this.getHalfExtentsWithMargin($Stack.get$javax$vecmath$Vector3f());
            float lx = 2.0f * halfExtents.x;
            float ly = 2.0f * halfExtents.y;
            float lz = 2.0f * halfExtents.z;
            inertia.set((float)(mass / 12.0f * (ly * ly + lz * lz)), (float)(mass / 12.0f * (lx * lx + lz * lz)), (float)(mass / 12.0f * (lx * lx + ly * ly)));
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
    public void getPlane(Vector3f vector3f, Vector3f vector3f2, int n) {
        $Stack $Stack = $Stack.get();
        try {
            void planeSupport;
            void planeNormal;
            void i;
            $Stack $Stack2 = $Stack;
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Vector4f();
            Vector4f plane = $Stack.get$javax$vecmath$Vector4f();
            this.getPlaneEquation(plane, (int)i);
            planeNormal.set(plane.x, plane.y, plane.z);
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            tmp.negate((Tuple3f)planeNormal);
            this.localGetSupportingVertex(tmp, (Vector3f)planeSupport);
            $Stack $Stack3 = $Stack;
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Vector4f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Vector4f();
            throw throwable;
        }
    }

    @Override
    public int getNumPlanes() {
        return 6;
    }

    @Override
    public int getNumVertices() {
        return 8;
    }

    @Override
    public int getNumEdges() {
        return 12;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void getVertex(int n, Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void i;
            void vtx;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f halfExtents = this.getHalfExtentsWithoutMargin($Stack.get$javax$vecmath$Vector3f());
            vtx.set(halfExtents.x * (float)(1 - (i & 1)) - halfExtents.x * (float)(i & 1), halfExtents.y * (float)(1 - ((i & 2) >> 1)) - halfExtents.y * (float)((i & 2) >> 1), halfExtents.z * (float)(1 - ((i & 4) >> 2)) - halfExtents.z * (float)((i & 4) >> 2));
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
    public void getPlaneEquation(Vector4f vector4f, int n) {
        $Stack $Stack = $Stack.get();
        try {
            void i;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f halfExtents = this.getHalfExtentsWithoutMargin($Stack.get$javax$vecmath$Vector3f());
            switch (i) {
                case 0: {
                    void plane;
                    plane.set(1.0f, 0.0f, 0.0f, -halfExtents.x);
                    break;
                }
                case 1: {
                    void plane;
                    plane.set(-1.0f, 0.0f, 0.0f, -halfExtents.x);
                    break;
                }
                case 2: {
                    void plane;
                    plane.set(0.0f, 1.0f, 0.0f, -halfExtents.y);
                    break;
                }
                case 3: {
                    void plane;
                    plane.set(0.0f, -1.0f, 0.0f, -halfExtents.y);
                    break;
                }
                case 4: {
                    void plane;
                    plane.set(0.0f, 0.0f, 1.0f, -halfExtents.z);
                    break;
                }
                case 5: {
                    void plane;
                    plane.set(0.0f, 0.0f, -1.0f, -halfExtents.z);
                    break;
                }
                default: {
                    assert (false);
                    break;
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

    @Override
    public void getEdge(int i, Vector3f pa, Vector3f pb) {
        int edgeVert0 = 0;
        int edgeVert1 = 0;
        switch (i) {
            case 0: {
                edgeVert0 = 0;
                edgeVert1 = 1;
                break;
            }
            case 1: {
                edgeVert0 = 0;
                edgeVert1 = 2;
                break;
            }
            case 2: {
                edgeVert0 = 1;
                edgeVert1 = 3;
                break;
            }
            case 3: {
                edgeVert0 = 2;
                edgeVert1 = 3;
                break;
            }
            case 4: {
                edgeVert0 = 0;
                edgeVert1 = 4;
                break;
            }
            case 5: {
                edgeVert0 = 1;
                edgeVert1 = 5;
                break;
            }
            case 6: {
                edgeVert0 = 2;
                edgeVert1 = 6;
                break;
            }
            case 7: {
                edgeVert0 = 3;
                edgeVert1 = 7;
                break;
            }
            case 8: {
                edgeVert0 = 4;
                edgeVert1 = 5;
                break;
            }
            case 9: {
                edgeVert0 = 4;
                edgeVert1 = 6;
                break;
            }
            case 10: {
                edgeVert0 = 5;
                edgeVert1 = 7;
                break;
            }
            case 11: {
                edgeVert0 = 6;
                edgeVert1 = 7;
                break;
            }
            default: {
                assert (false);
                break;
            }
        }
        this.getVertex(edgeVert0, pa);
        this.getVertex(edgeVert1, pb);
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
            Vector3f halfExtents = this.getHalfExtentsWithoutMargin($Stack.get$javax$vecmath$Vector3f());
            boolean result2 = pt.x <= halfExtents.x + tolerance && pt.x >= -halfExtents.x - tolerance && pt.y <= halfExtents.y + tolerance && pt.y >= -halfExtents.y - tolerance && pt.z <= halfExtents.z + tolerance && pt.z >= -halfExtents.z - tolerance;
            $Stack.pop$javax$vecmath$Vector3f();
            return result2;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    @Override
    public String getName() {
        return "Box";
    }

    @Override
    public int getNumPreferredPenetrationDirections() {
        return 6;
    }

    @Override
    public void getPreferredPenetrationDirection(int index, Vector3f penetrationVector) {
        switch (index) {
            case 0: {
                penetrationVector.set(1.0f, 0.0f, 0.0f);
                break;
            }
            case 1: {
                penetrationVector.set(-1.0f, 0.0f, 0.0f);
                break;
            }
            case 2: {
                penetrationVector.set(0.0f, 1.0f, 0.0f);
                break;
            }
            case 3: {
                penetrationVector.set(0.0f, -1.0f, 0.0f);
                break;
            }
            case 4: {
                penetrationVector.set(0.0f, 0.0f, 1.0f);
                break;
            }
            case 5: {
                penetrationVector.set(0.0f, 0.0f, -1.0f);
                break;
            }
            default: {
                assert (false);
                break;
            }
        }
    }
}

