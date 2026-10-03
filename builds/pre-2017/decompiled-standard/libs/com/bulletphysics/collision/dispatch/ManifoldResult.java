/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.dispatch;

import com.bulletphysics.$Stack;
import com.bulletphysics.BulletGlobals;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.narrowphase.DiscreteCollisionDetectorInterface;
import com.bulletphysics.collision.narrowphase.ManifoldPoint;
import com.bulletphysics.collision.narrowphase.PersistentManifold;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectPool;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class ManifoldResult
extends DiscreteCollisionDetectorInterface.Result {
    protected final ObjectPool<ManifoldPoint> pointsPool = ObjectPool.get(ManifoldPoint.class);
    private PersistentManifold manifoldPtr;
    private final Transform rootTransA = new Transform();
    private final Transform rootTransB = new Transform();
    private CollisionObject body0;
    private CollisionObject body1;
    private int partId0;
    private int partId1;
    private int index0;
    private int index1;

    public ManifoldResult() {
    }

    public ManifoldResult(CollisionObject body0, CollisionObject body1) {
        this.init(body0, body1);
    }

    public void init(CollisionObject body0, CollisionObject body1) {
        this.body0 = body0;
        this.body1 = body1;
        body0.getWorldTransform(this.rootTransA);
        body1.getWorldTransform(this.rootTransB);
    }

    public PersistentManifold getPersistentManifold() {
        return this.manifoldPtr;
    }

    public void setPersistentManifold(PersistentManifold manifoldPtr) {
        this.manifoldPtr = manifoldPtr;
    }

    @Override
    public void setShapeIdentifiers(int partId0, int index0, int partId1, int index1) {
        this.partId0 = partId0;
        this.partId1 = partId1;
        this.index0 = index0;
        this.index1 = index1;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void addContactPoint(Vector3f vector3f, Vector3f vector3f2, float f) {
        $Stack $Stack = $Stack.get();
        try {
            void pointInWorld;
            void normalOnBInWorld;
            void depth;
            $Stack.push$javax$vecmath$Vector3f();
            assert (this.manifoldPtr != null);
            if (depth > this.manifoldPtr.getContactBreakingThreshold()) {
                $Stack.pop$javax$vecmath$Vector3f();
                return;
            }
            boolean isSwapped = this.manifoldPtr.getBody0() != this.body0;
            Vector3f pointA = $Stack.get$javax$vecmath$Vector3f();
            pointA.scaleAdd((float)depth, (Tuple3f)normalOnBInWorld, (Tuple3f)pointInWorld);
            Vector3f localA = $Stack.get$javax$vecmath$Vector3f();
            Vector3f localB = $Stack.get$javax$vecmath$Vector3f();
            if (isSwapped) {
                this.rootTransB.invXform(pointA, localA);
                this.rootTransA.invXform((Vector3f)pointInWorld, localB);
            } else {
                this.rootTransA.invXform(pointA, localA);
                this.rootTransB.invXform((Vector3f)pointInWorld, localB);
            }
            ManifoldPoint newPt = this.pointsPool.get();
            newPt.init(localA, localB, (Vector3f)normalOnBInWorld, (float)depth);
            newPt.positionWorldOnA.set(pointA);
            newPt.positionWorldOnB.set((Tuple3f)pointInWorld);
            int insertIndex = this.manifoldPtr.getCacheEntry(newPt);
            newPt.combinedFriction = ManifoldResult.calculateCombinedFriction(this.body0, this.body1);
            newPt.combinedRestitution = ManifoldResult.calculateCombinedRestitution(this.body0, this.body1);
            newPt.partId0 = this.partId0;
            newPt.partId1 = this.partId1;
            newPt.index0 = this.index0;
            newPt.index1 = this.index1;
            if (insertIndex >= 0) {
                this.manifoldPtr.replaceContactPoint(newPt, insertIndex);
            } else {
                insertIndex = this.manifoldPtr.addManifoldPoint(newPt);
            }
            if (BulletGlobals.getContactAddedCallback() != null && ((this.body0.getCollisionFlags() & 8) != 0 || (this.body1.getCollisionFlags() & 8) != 0)) {
                CollisionObject obj0 = isSwapped ? this.body1 : this.body0;
                CollisionObject obj1 = isSwapped ? this.body0 : this.body1;
                BulletGlobals.getContactAddedCallback().contactAdded(this.manifoldPtr.getContactPoint(insertIndex), obj0, this.partId0, this.index0, obj1, this.partId1, this.index1);
            }
            this.pointsPool.release(newPt);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    private static float calculateCombinedFriction(CollisionObject body0, CollisionObject body1) {
        float MAX_FRICTION;
        float friction = body0.getFriction() * body1.getFriction();
        if (friction < -(MAX_FRICTION = 10.0f)) {
            friction = -MAX_FRICTION;
        }
        if (friction > MAX_FRICTION) {
            friction = MAX_FRICTION;
        }
        return friction;
    }

    private static float calculateCombinedRestitution(CollisionObject body0, CollisionObject body1) {
        return body0.getRestitution() * body1.getRestitution();
    }

    public void refreshContactPoints() {
        boolean isSwapped;
        assert (this.manifoldPtr != null);
        if (this.manifoldPtr.getNumContacts() == 0) {
            return;
        }
        boolean bl = isSwapped = this.manifoldPtr.getBody0() != this.body0;
        if (isSwapped) {
            this.manifoldPtr.refreshContactPoints(this.rootTransB, this.rootTransA);
        } else {
            this.manifoldPtr.refreshContactPoints(this.rootTransA, this.rootTransB);
        }
    }
}

