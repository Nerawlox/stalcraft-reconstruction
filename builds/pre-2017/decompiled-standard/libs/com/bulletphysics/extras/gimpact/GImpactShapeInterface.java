/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.dispatch.CollisionWorld;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.ConcaveShape;
import com.bulletphysics.collision.shapes.TriangleCallback;
import com.bulletphysics.extras.gimpact.BoxCollision;
import com.bulletphysics.extras.gimpact.GImpactBvh;
import com.bulletphysics.extras.gimpact.PrimitiveManagerBase;
import com.bulletphysics.extras.gimpact.PrimitiveTriangle;
import com.bulletphysics.extras.gimpact.ShapeType;
import com.bulletphysics.extras.gimpact.TetrahedronShapeEx;
import com.bulletphysics.extras.gimpact.TriangleShapeEx;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Vector3f;

public abstract class GImpactShapeInterface
extends ConcaveShape {
    protected BoxCollision.AABB localAABB = new BoxCollision.AABB();
    protected boolean needs_update;
    protected final Vector3f localScaling = new Vector3f();
    GImpactBvh box_set = new GImpactBvh();

    public GImpactShapeInterface() {
        this.localAABB.invalidate();
        this.needs_update = true;
        this.localScaling.set(1.0f, 1.0f, 1.0f);
    }

    public void updateBound() {
        if (!this.needs_update) {
            return;
        }
        this.calcLocalAABB();
        this.needs_update = false;
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
            $Stack.push$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            BoxCollision.AABB transformedbox = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB(this.localAABB);
            transformedbox.appy_transform((Transform)t);
            aabbMin.set(transformedbox.min);
            aabbMax.set(transformedbox.max);
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            throw throwable;
        }
    }

    public void postUpdate() {
        this.needs_update = true;
    }

    public BoxCollision.AABB getLocalBox(BoxCollision.AABB out) {
        out.set(this.localAABB);
        return out;
    }

    @Override
    public BroadphaseNativeType getShapeType() {
        return BroadphaseNativeType.GIMPACT_SHAPE_PROXYTYPE;
    }

    @Override
    public void setLocalScaling(Vector3f scaling) {
        this.localScaling.set(scaling);
        this.postUpdate();
    }

    @Override
    public Vector3f getLocalScaling(Vector3f out) {
        out.set(this.localScaling);
        return out;
    }

    @Override
    public void setMargin(float margin) {
        this.collisionMargin = margin;
        int i = this.getNumChildShapes();
        while (i-- != 0) {
            CollisionShape child = this.getChildShape(i);
            child.setMargin(margin);
        }
        this.needs_update = true;
    }

    abstract ShapeType getGImpactShapeType();

    GImpactBvh getBoxSet() {
        return this.box_set;
    }

    public boolean hasBoxSet() {
        return this.box_set.getNodeCount() != 0;
    }

    abstract PrimitiveManagerBase getPrimitiveManager();

    public abstract int getNumChildShapes();

    public abstract boolean childrenHasTransform();

    public abstract boolean needsRetrieveTriangles();

    public abstract boolean needsRetrieveTetrahedrons();

    public abstract void getBulletTriangle(int var1, TriangleShapeEx var2);

    abstract void getBulletTetrahedron(int var1, TetrahedronShapeEx var2);

    public void lockChildShapes() {
    }

    public void unlockChildShapes() {
    }

    void getPrimitiveTriangle(int index, PrimitiveTriangle triangle) {
        this.getPrimitiveManager().get_primitive_triangle(index, triangle);
    }

    protected void calcLocalAABB() {
        this.lockChildShapes();
        if (this.box_set.getNodeCount() == 0) {
            this.box_set.buildSet();
        } else {
            this.box_set.update();
        }
        this.unlockChildShapes();
        this.box_set.getGlobalBox(this.localAABB);
    }

    /*
     * WARNING - void declaration
     */
    public void getChildAabb(int n, Transform transform, Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void aabbMax;
            void aabbMin;
            void t;
            void child_index;
            $Stack.push$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            BoxCollision.AABB child_aabb = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            this.getPrimitiveManager().get_primitive_box((int)child_index, child_aabb);
            child_aabb.appy_transform((Transform)t);
            aabbMin.set(child_aabb.min);
            aabbMax.set(child_aabb.max);
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            throw throwable;
        }
    }

    public abstract CollisionShape getChildShape(int var1);

    public abstract Transform getChildTransform(int var1);

    public abstract void setChildTransform(int var1, Transform var2);

    public void rayTest(Vector3f rayFrom, Vector3f rayTo, CollisionWorld.RayResultCallback resultCallback) {
    }

    @Override
    public void processAllTriangles(TriangleCallback callback, Vector3f aabbMin, Vector3f aabbMax) {
    }
}

