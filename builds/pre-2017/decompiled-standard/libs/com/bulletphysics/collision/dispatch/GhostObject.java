/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.dispatch;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.CollisionObjectType;
import com.bulletphysics.collision.dispatch.CollisionWorld;
import com.bulletphysics.collision.shapes.ConvexShape;
import com.bulletphysics.linearmath.AabbUtil2;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.TransformUtil;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class GhostObject
extends CollisionObject {
    protected ObjectArrayList<CollisionObject> overlappingObjects = new ObjectArrayList();

    public GhostObject() {
        this.internalType = CollisionObjectType.GHOST_OBJECT;
    }

    public void addOverlappingObjectInternal(BroadphaseProxy otherProxy, BroadphaseProxy thisProxy) {
        CollisionObject otherObject = (CollisionObject)otherProxy.clientObject;
        assert (otherObject != null);
        int index = this.overlappingObjects.indexOf(otherObject);
        if (index == -1) {
            this.overlappingObjects.add(otherObject);
        }
    }

    public void removeOverlappingObjectInternal(BroadphaseProxy otherProxy, Dispatcher dispatcher, BroadphaseProxy thisProxy) {
        CollisionObject otherObject = (CollisionObject)otherProxy.clientObject;
        assert (otherObject != null);
        int index = this.overlappingObjects.indexOf(otherObject);
        if (index != -1) {
            this.overlappingObjects.set(index, this.overlappingObjects.getQuick(this.overlappingObjects.size() - 1));
            this.overlappingObjects.removeQuick(this.overlappingObjects.size() - 1);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void convexSweepTest(ConvexShape convexShape, Transform transform, Transform transform2, CollisionWorld.ConvexResultCallback convexResultCallback, float f) {
        $Stack $Stack = $Stack.get();
        try {
            void castShape;
            void convexToWorld;
            void convexFromWorld;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Quat4f();
            Transform convexFromTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform convexToTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            convexFromTrans.set((Transform)convexFromWorld);
            convexToTrans.set((Transform)convexToWorld);
            Vector3f castShapeAabbMin = $Stack.get$javax$vecmath$Vector3f();
            Vector3f castShapeAabbMax = $Stack.get$javax$vecmath$Vector3f();
            Vector3f linVel = $Stack.get$javax$vecmath$Vector3f();
            Vector3f angVel = $Stack.get$javax$vecmath$Vector3f();
            TransformUtil.calculateVelocity(convexFromTrans, convexToTrans, 1.0f, linVel, angVel);
            Transform R = $Stack.get$com$bulletphysics$linearmath$Transform();
            R.setIdentity();
            R.setRotation(convexFromTrans.getRotation($Stack.get$javax$vecmath$Quat4f()));
            castShape.calculateTemporalAabb(R, linVel, angVel, 1.0f, castShapeAabbMin, castShapeAabbMax);
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            for (int i = 0; i < this.overlappingObjects.size(); ++i) {
                void allowedCcdPenetration;
                void resultCallback;
                CollisionObject collisionObject = this.overlappingObjects.getQuick(i);
                if (!resultCallback.needsCollision(collisionObject.getBroadphaseHandle())) continue;
                Vector3f collisionObjectAabbMin = $Stack.get$javax$vecmath$Vector3f();
                Vector3f collisionObjectAabbMax = $Stack.get$javax$vecmath$Vector3f();
                collisionObject.getCollisionShape().getAabb(collisionObject.getWorldTransform(tmpTrans), collisionObjectAabbMin, collisionObjectAabbMax);
                AabbUtil2.aabbExpand(collisionObjectAabbMin, collisionObjectAabbMax, castShapeAabbMin, castShapeAabbMax);
                float[] hitLambda = new float[]{1.0f};
                Vector3f hitNormal = $Stack.get$javax$vecmath$Vector3f();
                if (!AabbUtil2.rayAabb(convexFromWorld.origin, convexToWorld.origin, collisionObjectAabbMin, collisionObjectAabbMax, hitLambda, hitNormal)) continue;
                CollisionWorld.objectQuerySingle((ConvexShape)castShape, convexFromTrans, convexToTrans, collisionObject, collisionObject.getCollisionShape(), collisionObject.getWorldTransform(tmpTrans), (CollisionWorld.ConvexResultCallback)resultCallback, (float)allowedCcdPenetration);
            }
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$linearmath$Transform();
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Quat4f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Quat4f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void rayTest(Vector3f vector3f, Vector3f vector3f2, CollisionWorld.RayResultCallback rayResultCallback) {
        $Stack $Stack = $Stack.get();
        try {
            void rayToWorld;
            void rayFromWorld;
            $Stack.push$com$bulletphysics$linearmath$Transform();
            Transform rayFromTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            rayFromTrans.setIdentity();
            rayFromTrans.origin.set((Tuple3f)rayFromWorld);
            Transform rayToTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            rayToTrans.setIdentity();
            rayToTrans.origin.set((Tuple3f)rayToWorld);
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            for (int i = 0; i < this.overlappingObjects.size(); ++i) {
                void resultCallback;
                CollisionObject collisionObject = this.overlappingObjects.getQuick(i);
                if (!resultCallback.needsCollision(collisionObject.getBroadphaseHandle())) continue;
                CollisionWorld.rayTestSingle(rayFromTrans, rayToTrans, collisionObject, collisionObject.getCollisionShape(), collisionObject.getWorldTransform(tmpTrans), (CollisionWorld.RayResultCallback)resultCallback);
            }
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    public int getNumOverlappingObjects() {
        return this.overlappingObjects.size();
    }

    public CollisionObject getOverlappingObject(int index) {
        return this.overlappingObjects.getQuick(index);
    }

    public ObjectArrayList<CollisionObject> getOverlappingPairs() {
        return this.overlappingObjects;
    }

    public static GhostObject upcast(CollisionObject colObj) {
        if (colObj.getInternalType() == CollisionObjectType.GHOST_OBJECT) {
            return (GhostObject)colObj;
        }
        return null;
    }
}

