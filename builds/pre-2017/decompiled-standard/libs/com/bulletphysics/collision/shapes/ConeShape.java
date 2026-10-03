/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.shapes.ConvexInternalShape;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Vector3f;

public class ConeShape
extends ConvexInternalShape {
    private float sinAngle;
    private float radius;
    private float height;
    private int[] coneIndices = new int[3];

    public ConeShape(float radius, float height) {
        this.radius = radius;
        this.height = height;
        this.setConeUpIndex(1);
        this.sinAngle = radius / (float)Math.sqrt(this.radius * this.radius + this.height * this.height);
    }

    public float getRadius() {
        return this.radius;
    }

    public float getHeight() {
        return this.height;
    }

    private Vector3f coneLocalSupport(Vector3f v, Vector3f out) {
        float v2;
        float halfHeight = this.height * 0.5f;
        if (VectorUtil.getCoord(v, this.coneIndices[1]) > v.length() * this.sinAngle) {
            VectorUtil.setCoord(out, this.coneIndices[0], 0.0f);
            VectorUtil.setCoord(out, this.coneIndices[1], halfHeight);
            VectorUtil.setCoord(out, this.coneIndices[2], 0.0f);
            return out;
        }
        float v0 = VectorUtil.getCoord(v, this.coneIndices[0]);
        float s = (float)Math.sqrt(v0 * v0 + (v2 = VectorUtil.getCoord(v, this.coneIndices[2])) * v2);
        if (s > 1.1920929E-7f) {
            float d = this.radius / s;
            VectorUtil.setCoord(out, this.coneIndices[0], VectorUtil.getCoord(v, this.coneIndices[0]) * d);
            VectorUtil.setCoord(out, this.coneIndices[1], -halfHeight);
            VectorUtil.setCoord(out, this.coneIndices[2], VectorUtil.getCoord(v, this.coneIndices[2]) * d);
            return out;
        }
        VectorUtil.setCoord(out, this.coneIndices[0], 0.0f);
        VectorUtil.setCoord(out, this.coneIndices[1], -halfHeight);
        VectorUtil.setCoord(out, this.coneIndices[2], 0.0f);
        return out;
    }

    @Override
    public Vector3f localGetSupportingVertexWithoutMargin(Vector3f vec, Vector3f out) {
        return this.coneLocalSupport(vec, out);
    }

    @Override
    public void batchedUnitVectorGetSupportingVertexWithoutMargin(Vector3f[] vectors, Vector3f[] supportVerticesOut, int numVectors) {
        for (int i = 0; i < numVectors; ++i) {
            Vector3f vec = vectors[i];
            this.coneLocalSupport(vec, supportVerticesOut[i]);
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
            Vector3f supVertex = this.coneLocalSupport((Vector3f)vec, (Vector3f)out);
            if (this.getMargin() != 0.0f) {
                Vector3f vecnorm = $Stack.get$javax$vecmath$Vector3f((Vector3f)vec);
                if (vecnorm.lengthSquared() < 1.4210855E-14f) {
                    vecnorm.set(-1.0f, -1.0f, -1.0f);
                }
                vecnorm.normalize();
                supVertex.scaleAdd(this.getMargin(), vecnorm, supVertex);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return supVertex;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    @Override
    public BroadphaseNativeType getShapeType() {
        return BroadphaseNativeType.CONE_SHAPE_PROXYTYPE;
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
            Transform identity = $Stack.get$com$bulletphysics$linearmath$Transform();
            identity.setIdentity();
            Vector3f aabbMin = $Stack.get$javax$vecmath$Vector3f();
            Vector3f aabbMax = $Stack.get$javax$vecmath$Vector3f();
            this.getAabb(identity, aabbMin, aabbMax);
            Vector3f halfExtents = $Stack.get$javax$vecmath$Vector3f();
            halfExtents.sub(aabbMax, aabbMin);
            halfExtents.scale(0.5f);
            float margin = this.getMargin();
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

    @Override
    public String getName() {
        return "Cone";
    }

    protected void setConeUpIndex(int upIndex) {
        switch (upIndex) {
            case 0: {
                this.coneIndices[0] = 1;
                this.coneIndices[1] = 0;
                this.coneIndices[2] = 2;
                break;
            }
            case 1: {
                this.coneIndices[0] = 0;
                this.coneIndices[1] = 1;
                this.coneIndices[2] = 2;
                break;
            }
            case 2: {
                this.coneIndices[0] = 0;
                this.coneIndices[1] = 2;
                this.coneIndices[2] = 1;
                break;
            }
            default: {
                assert (false);
                break;
            }
        }
    }

    public int getConeUpIndex() {
        return this.coneIndices[1];
    }
}

