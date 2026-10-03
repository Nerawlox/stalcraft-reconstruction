/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.dispatch;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.CollisionAlgorithm;
import com.bulletphysics.collision.broadphase.CollisionAlgorithmConstructionInfo;
import com.bulletphysics.collision.broadphase.DispatcherInfo;
import com.bulletphysics.collision.dispatch.CollisionAlgorithmCreateFunc;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.ManifoldResult;
import com.bulletphysics.collision.narrowphase.PersistentManifold;
import com.bulletphysics.collision.shapes.ConvexShape;
import com.bulletphysics.collision.shapes.StaticPlaneShape;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import com.bulletphysics.util.ObjectPool;
import javax.vecmath.Vector3f;

public class ConvexPlaneCollisionAlgorithm
extends CollisionAlgorithm {
    private boolean ownManifold;
    private PersistentManifold manifoldPtr;
    private boolean isSwapped;

    public void init(PersistentManifold mf, CollisionAlgorithmConstructionInfo ci, CollisionObject col0, CollisionObject col1, boolean isSwapped) {
        CollisionObject planeObj;
        super.init(ci);
        this.ownManifold = false;
        this.manifoldPtr = mf;
        this.isSwapped = isSwapped;
        CollisionObject convexObj = isSwapped ? col1 : col0;
        CollisionObject collisionObject = planeObj = isSwapped ? col0 : col1;
        if (this.manifoldPtr == null && this.dispatcher.needsCollision(convexObj, planeObj)) {
            this.manifoldPtr = this.dispatcher.getNewManifold(convexObj, planeObj);
            this.ownManifold = true;
        }
    }

    @Override
    public void destroy() {
        if (this.ownManifold) {
            if (this.manifoldPtr != null) {
                this.dispatcher.releaseManifold(this.manifoldPtr);
            }
            this.manifoldPtr = null;
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void processCollision(CollisionObject collisionObject, CollisionObject collisionObject2, DispatcherInfo dispatcherInfo, ManifoldResult manifoldResult) {
        $Stack $Stack = $Stack.get();
        try {
            void resultOut;
            void body0;
            void body1;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            if (this.manifoldPtr == null) {
                $Stack $Stack3 = $Stack;
                $Stack3.pop$com$bulletphysics$linearmath$Transform();
                $Stack3.pop$javax$vecmath$Vector3f();
                return;
            }
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            void convexObj = this.isSwapped ? body1 : body0;
            void planeObj = this.isSwapped ? body0 : body1;
            ConvexShape convexShape = (ConvexShape)convexObj.getCollisionShape();
            StaticPlaneShape planeShape = (StaticPlaneShape)planeObj.getCollisionShape();
            boolean hasCollision = false;
            Vector3f planeNormal = planeShape.getPlaneNormal($Stack.get$javax$vecmath$Vector3f());
            float planeConstant = planeShape.getPlaneConstant();
            Transform planeInConvex = $Stack.get$com$bulletphysics$linearmath$Transform();
            convexObj.getWorldTransform(planeInConvex);
            planeInConvex.inverse();
            planeInConvex.mul(planeObj.getWorldTransform(tmpTrans));
            Transform convexInPlaneTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            convexInPlaneTrans.inverse(planeObj.getWorldTransform(tmpTrans));
            convexInPlaneTrans.mul(convexObj.getWorldTransform(tmpTrans));
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            tmp.negate(planeNormal);
            planeInConvex.basis.transform(tmp);
            Vector3f vtx = convexShape.localGetSupportingVertex(tmp, $Stack.get$javax$vecmath$Vector3f());
            Vector3f vtxInPlane = $Stack.get$javax$vecmath$Vector3f(vtx);
            convexInPlaneTrans.transform(vtxInPlane);
            float distance = planeNormal.dot(vtxInPlane) - planeConstant;
            Vector3f vtxInPlaneProjected = $Stack.get$javax$vecmath$Vector3f();
            tmp.scale(distance, planeNormal);
            vtxInPlaneProjected.sub(vtxInPlane, tmp);
            Vector3f vtxInPlaneWorld = $Stack.get$javax$vecmath$Vector3f(vtxInPlaneProjected);
            planeObj.getWorldTransform(tmpTrans).transform(vtxInPlaneWorld);
            hasCollision = distance < this.manifoldPtr.getContactBreakingThreshold();
            resultOut.setPersistentManifold(this.manifoldPtr);
            if (hasCollision) {
                Vector3f normalOnSurfaceB = $Stack.get$javax$vecmath$Vector3f(planeNormal);
                planeObj.getWorldTransform((Transform)tmpTrans).basis.transform(normalOnSurfaceB);
                Vector3f pOnB = $Stack.get$javax$vecmath$Vector3f(vtxInPlaneWorld);
                resultOut.addContactPoint(normalOnSurfaceB, pOnB, distance);
            }
            if (this.ownManifold && this.manifoldPtr.getNumContacts() != 0) {
                resultOut.refreshContactPoints();
            }
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack5 = $Stack;
            $Stack5.pop$com$bulletphysics$linearmath$Transform();
            $Stack5.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    @Override
    public float calculateTimeOfImpact(CollisionObject body0, CollisionObject body1, DispatcherInfo dispatchInfo, ManifoldResult resultOut) {
        return 1.0f;
    }

    @Override
    public void getAllContactManifolds(ObjectArrayList<PersistentManifold> manifoldArray) {
        if (this.manifoldPtr != null && this.ownManifold) {
            manifoldArray.add(this.manifoldPtr);
        }
    }

    public static class CreateFunc
    extends CollisionAlgorithmCreateFunc {
        private final ObjectPool<ConvexPlaneCollisionAlgorithm> pool = ObjectPool.get(ConvexPlaneCollisionAlgorithm.class);

        @Override
        public CollisionAlgorithm createCollisionAlgorithm(CollisionAlgorithmConstructionInfo ci, CollisionObject body0, CollisionObject body1) {
            ConvexPlaneCollisionAlgorithm algo = this.pool.get();
            if (!this.swapped) {
                algo.init(null, ci, body0, body1, false);
            } else {
                algo.init(null, ci, body0, body1, true);
            }
            return algo;
        }

        @Override
        public void releaseCollisionAlgorithm(CollisionAlgorithm algo) {
            this.pool.release((ConvexPlaneCollisionAlgorithm)algo);
        }
    }
}

