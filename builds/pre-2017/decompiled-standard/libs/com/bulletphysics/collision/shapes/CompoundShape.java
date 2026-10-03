/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.CompoundShapeChild;
import com.bulletphysics.collision.shapes.OptimizedBvh;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Matrix3f;
import javax.vecmath.Vector3f;

public class CompoundShape
extends CollisionShape {
    private final ObjectArrayList<CompoundShapeChild> children = new ObjectArrayList();
    private final Vector3f localAabbMin = new Vector3f(1.0E30f, 1.0E30f, 1.0E30f);
    private final Vector3f localAabbMax = new Vector3f(-1.0E30f, -1.0E30f, -1.0E30f);
    private OptimizedBvh aabbTree = null;
    private float collisionMargin = 0.0f;
    protected final Vector3f localScaling = new Vector3f(1.0f, 1.0f, 1.0f);

    /*
     * WARNING - void declaration
     */
    public void addChildShape(Transform transform, CollisionShape collisionShape) {
        $Stack $Stack = $Stack.get();
        try {
            void shape;
            void localTransform;
            $Stack.push$javax$vecmath$Vector3f();
            CompoundShapeChild child = new CompoundShapeChild();
            child.transform.set((Transform)localTransform);
            child.childShape = shape;
            child.childShapeType = shape.getShapeType();
            child.childMargin = shape.getMargin();
            this.children.add(child);
            Vector3f _localAabbMin = $Stack.get$javax$vecmath$Vector3f();
            Vector3f _localAabbMax = $Stack.get$javax$vecmath$Vector3f();
            shape.getAabb((Transform)localTransform, _localAabbMin, _localAabbMax);
            VectorUtil.setMin(this.localAabbMin, _localAabbMin);
            VectorUtil.setMax(this.localAabbMax, _localAabbMax);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void removeChildShape(CollisionShape shape) {
        boolean done_removing;
        block0: do {
            done_removing = true;
            for (int i = 0; i < this.children.size(); ++i) {
                if (this.children.getQuick((int)i).childShape != shape) continue;
                this.children.removeQuick(i);
                done_removing = false;
                continue block0;
            }
        } while (!done_removing);
        this.recalculateLocalAabb();
    }

    public int getNumChildShapes() {
        return this.children.size();
    }

    public CollisionShape getChildShape(int index) {
        return this.children.getQuick((int)index).childShape;
    }

    public Transform getChildTransform(int index, Transform out) {
        out.set(this.children.getQuick((int)index).transform);
        return out;
    }

    public ObjectArrayList<CompoundShapeChild> getChildList() {
        return this.children;
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
            void trans;
            $Stack $Stack2 = $Stack;
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Matrix3f();
            Vector3f localHalfExtents = $Stack.get$javax$vecmath$Vector3f();
            localHalfExtents.sub(this.localAabbMax, this.localAabbMin);
            localHalfExtents.scale(0.5f);
            localHalfExtents.x += this.getMargin();
            localHalfExtents.y += this.getMargin();
            localHalfExtents.z += this.getMargin();
            Vector3f localCenter = $Stack.get$javax$vecmath$Vector3f();
            localCenter.add(this.localAabbMax, this.localAabbMin);
            localCenter.scale(0.5f);
            Matrix3f abs_b = $Stack.get$javax$vecmath$Matrix3f(trans.basis);
            MatrixUtil.absolute(abs_b);
            Vector3f center = $Stack.get$javax$vecmath$Vector3f(localCenter);
            trans.transform(center);
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f extent = $Stack.get$javax$vecmath$Vector3f();
            abs_b.getRow(0, tmp);
            extent.x = tmp.dot(localHalfExtents);
            abs_b.getRow(1, tmp);
            extent.y = tmp.dot(localHalfExtents);
            abs_b.getRow(2, tmp);
            extent.z = tmp.dot(localHalfExtents);
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

    public void recalculateLocalAabb() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Vector3f();
            this.localAabbMin.set(1.0E30f, 1.0E30f, 1.0E30f);
            this.localAabbMax.set(-1.0E30f, -1.0E30f, -1.0E30f);
            Vector3f tmpLocalAabbMin = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmpLocalAabbMax = $Stack.get$javax$vecmath$Vector3f();
            for (int j = 0; j < this.children.size(); ++j) {
                this.children.getQuick((int)j).childShape.getAabb(this.children.getQuick((int)j).transform, tmpLocalAabbMin, tmpLocalAabbMax);
                for (int i = 0; i < 3; ++i) {
                    if (VectorUtil.getCoord(this.localAabbMin, i) > VectorUtil.getCoord(tmpLocalAabbMin, i)) {
                        VectorUtil.setCoord(this.localAabbMin, i, VectorUtil.getCoord(tmpLocalAabbMin, i));
                    }
                    if (!(VectorUtil.getCoord(this.localAabbMax, i) < VectorUtil.getCoord(tmpLocalAabbMax, i))) continue;
                    VectorUtil.setCoord(this.localAabbMax, i, VectorUtil.getCoord(tmpLocalAabbMax, i));
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
    public void setLocalScaling(Vector3f scaling) {
        this.localScaling.set(scaling);
    }

    @Override
    public Vector3f getLocalScaling(Vector3f out) {
        out.set(this.localScaling);
        return out;
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
            Vector3f aabbMin = $Stack.get$javax$vecmath$Vector3f();
            Vector3f aabbMax = $Stack.get$javax$vecmath$Vector3f();
            this.getAabb(ident, aabbMin, aabbMax);
            Vector3f halfExtents = $Stack.get$javax$vecmath$Vector3f();
            halfExtents.sub(aabbMax, aabbMin);
            halfExtents.scale(0.5f);
            float lx = 2.0f * halfExtents.x;
            float ly = 2.0f * halfExtents.y;
            float lz = 2.0f * halfExtents.z;
            inertia.x = mass / 12.0f * (ly * ly + lz * lz);
            inertia.y = mass / 12.0f * (lx * lx + lz * lz);
            inertia.z = mass / 12.0f * (lx * lx + ly * ly);
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
        return BroadphaseNativeType.COMPOUND_SHAPE_PROXYTYPE;
    }

    @Override
    public void setMargin(float margin) {
        this.collisionMargin = margin;
    }

    @Override
    public float getMargin() {
        return this.collisionMargin;
    }

    @Override
    public String getName() {
        return "Compound";
    }

    public OptimizedBvh getAabbTree() {
        return this.aabbTree;
    }

    /*
     * WARNING - void declaration
     */
    public void calculatePrincipalAxisTransform(float[] fArray, Transform transform, Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void inertia;
            void principal;
            void masses;
            $Stack $Stack2 = $Stack;
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Matrix3f();
            int n = this.children.size();
            float totalMass = 0.0f;
            Vector3f center = $Stack.get$javax$vecmath$Vector3f();
            center.set(0.0f, 0.0f, 0.0f);
            for (int k = 0; k < n; ++k) {
                center.scaleAdd((float)masses[k], this.children.getQuick((int)k).transform.origin, center);
                totalMass += masses[k];
            }
            center.scale(1.0f / totalMass);
            principal.origin.set(center);
            Matrix3f tensor = $Stack.get$javax$vecmath$Matrix3f();
            tensor.setZero();
            for (int k = 0; k < n; ++k) {
                Vector3f i = $Stack.get$javax$vecmath$Vector3f();
                this.children.getQuick((int)k).childShape.calculateLocalInertia((float)masses[k], i);
                Transform t = this.children.getQuick((int)k).transform;
                Vector3f o = $Stack.get$javax$vecmath$Vector3f();
                o.sub(t.origin, center);
                Matrix3f j = $Stack.get$javax$vecmath$Matrix3f();
                j.transpose(t.basis);
                j.m00 *= i.x;
                j.m01 *= i.x;
                j.m02 *= i.x;
                j.m10 *= i.y;
                j.m11 *= i.y;
                j.m12 *= i.y;
                j.m20 *= i.z;
                j.m21 *= i.z;
                j.m22 *= i.z;
                j.mul(t.basis, j);
                tensor.add(j);
                float o2 = o.lengthSquared();
                j.setRow(0, o2, 0.0f, 0.0f);
                j.setRow(1, 0.0f, o2, 0.0f);
                j.setRow(2, 0.0f, 0.0f, o2);
                j.m00 += o.x * -o.x;
                j.m01 += o.y * -o.x;
                j.m02 += o.z * -o.x;
                j.m10 += o.x * -o.y;
                j.m11 += o.y * -o.y;
                j.m12 += o.z * -o.y;
                j.m20 += o.x * -o.z;
                j.m21 += o.y * -o.z;
                j.m22 += o.z * -o.z;
                tensor.m00 += masses[k] * j.m00;
                tensor.m01 += masses[k] * j.m01;
                tensor.m02 += masses[k] * j.m02;
                tensor.m10 += masses[k] * j.m10;
                tensor.m11 += masses[k] * j.m11;
                tensor.m12 += masses[k] * j.m12;
                tensor.m20 += masses[k] * j.m20;
                tensor.m21 += masses[k] * j.m21;
                tensor.m22 += masses[k] * j.m22;
            }
            MatrixUtil.diagonalize(tensor, principal.basis, 1.0E-5f, 20);
            inertia.set(tensor.m00, tensor.m11, tensor.m22);
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
}

