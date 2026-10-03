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
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.CompoundShape;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import com.bulletphysics.util.ObjectPool;

public class CompoundCollisionAlgorithm
extends CollisionAlgorithm {
    private final ObjectArrayList<CollisionAlgorithm> childCollisionAlgorithms = new ObjectArrayList();
    private boolean isSwapped;

    public void init(CollisionAlgorithmConstructionInfo ci, CollisionObject body0, CollisionObject body1, boolean isSwapped) {
        CollisionObject otherObj;
        super.init(ci);
        this.isSwapped = isSwapped;
        CollisionObject colObj = isSwapped ? body1 : body0;
        CollisionObject collisionObject = otherObj = isSwapped ? body0 : body1;
        assert (colObj.getCollisionShape().isCompound());
        CompoundShape compoundShape = (CompoundShape)colObj.getCollisionShape();
        int numChildren = compoundShape.getNumChildShapes();
        for (int i = 0; i < numChildren; ++i) {
            CollisionShape tmpShape = colObj.getCollisionShape();
            CollisionShape childShape = compoundShape.getChildShape(i);
            colObj.internalSetTemporaryCollisionShape(childShape);
            this.childCollisionAlgorithms.add(ci.dispatcher1.findAlgorithm(colObj, otherObj));
            colObj.internalSetTemporaryCollisionShape(tmpShape);
        }
    }

    @Override
    public void destroy() {
        int numChildren = this.childCollisionAlgorithms.size();
        for (int i = 0; i < numChildren; ++i) {
            this.dispatcher.freeCollisionAlgorithm(this.childCollisionAlgorithms.getQuick(i));
        }
        this.childCollisionAlgorithms.clear();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void processCollision(CollisionObject collisionObject, CollisionObject collisionObject2, DispatcherInfo dispatcherInfo, ManifoldResult manifoldResult) {
        $Stack $Stack = $Stack.get();
        try {
            void otherObj;
            void body0;
            void body1;
            $Stack.push$com$bulletphysics$linearmath$Transform();
            void colObj = this.isSwapped ? body1 : body0;
            void v0 = otherObj = this.isSwapped ? body0 : body1;
            assert (colObj.getCollisionShape().isCompound());
            CompoundShape compoundShape = (CompoundShape)colObj.getCollisionShape();
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform orgTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform childTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform orgInterpolationTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform newChildWorldTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            int numChildren = this.childCollisionAlgorithms.size();
            for (int i = 0; i < numChildren; ++i) {
                void resultOut;
                void dispatchInfo;
                CollisionShape childShape = compoundShape.getChildShape(i);
                colObj.getWorldTransform(orgTrans);
                colObj.getInterpolationWorldTransform(orgInterpolationTrans);
                compoundShape.getChildTransform(i, childTrans);
                newChildWorldTrans.mul(orgTrans, childTrans);
                colObj.setWorldTransform(newChildWorldTrans);
                colObj.setInterpolationWorldTransform(newChildWorldTrans);
                CollisionShape tmpShape = colObj.getCollisionShape();
                colObj.internalSetTemporaryCollisionShape(childShape);
                this.childCollisionAlgorithms.getQuick(i).processCollision((CollisionObject)colObj, (CollisionObject)otherObj, (DispatcherInfo)dispatchInfo, (ManifoldResult)resultOut);
                colObj.internalSetTemporaryCollisionShape(tmpShape);
                colObj.setWorldTransform(orgTrans);
                colObj.setInterpolationWorldTransform(orgInterpolationTrans);
            }
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public float calculateTimeOfImpact(CollisionObject collisionObject, CollisionObject collisionObject2, DispatcherInfo dispatcherInfo, ManifoldResult manifoldResult) {
        $Stack $Stack = $Stack.get();
        try {
            void otherObj;
            void body0;
            void body1;
            $Stack.push$com$bulletphysics$linearmath$Transform();
            void colObj = this.isSwapped ? body1 : body0;
            void v0 = otherObj = this.isSwapped ? body0 : body1;
            assert (colObj.getCollisionShape().isCompound());
            CompoundShape compoundShape = (CompoundShape)colObj.getCollisionShape();
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform orgTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform childTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            float hitFraction = 1.0f;
            int numChildren = this.childCollisionAlgorithms.size();
            for (int i = 0; i < numChildren; ++i) {
                void resultOut;
                void dispatchInfo;
                CollisionShape childShape = compoundShape.getChildShape(i);
                colObj.getWorldTransform(orgTrans);
                compoundShape.getChildTransform(i, childTrans);
                tmpTrans.set(orgTrans);
                tmpTrans.mul(childTrans);
                colObj.setWorldTransform(tmpTrans);
                CollisionShape tmpShape = colObj.getCollisionShape();
                colObj.internalSetTemporaryCollisionShape(childShape);
                float frac = this.childCollisionAlgorithms.getQuick(i).calculateTimeOfImpact((CollisionObject)colObj, (CollisionObject)otherObj, (DispatcherInfo)dispatchInfo, (ManifoldResult)resultOut);
                if (frac < hitFraction) {
                    hitFraction = frac;
                }
                colObj.internalSetTemporaryCollisionShape(tmpShape);
                colObj.setWorldTransform(orgTrans);
            }
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return hitFraction;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    @Override
    public void getAllContactManifolds(ObjectArrayList<PersistentManifold> manifoldArray) {
        for (int i = 0; i < this.childCollisionAlgorithms.size(); ++i) {
            this.childCollisionAlgorithms.getQuick(i).getAllContactManifolds(manifoldArray);
        }
    }

    public static class SwappedCreateFunc
    extends CollisionAlgorithmCreateFunc {
        private final ObjectPool<CompoundCollisionAlgorithm> pool = ObjectPool.get(CompoundCollisionAlgorithm.class);

        @Override
        public CollisionAlgorithm createCollisionAlgorithm(CollisionAlgorithmConstructionInfo ci, CollisionObject body0, CollisionObject body1) {
            CompoundCollisionAlgorithm algo = this.pool.get();
            algo.init(ci, body0, body1, true);
            return algo;
        }

        @Override
        public void releaseCollisionAlgorithm(CollisionAlgorithm algo) {
            this.pool.release((CompoundCollisionAlgorithm)algo);
        }
    }

    public static class CreateFunc
    extends CollisionAlgorithmCreateFunc {
        private final ObjectPool<CompoundCollisionAlgorithm> pool = ObjectPool.get(CompoundCollisionAlgorithm.class);

        @Override
        public CollisionAlgorithm createCollisionAlgorithm(CollisionAlgorithmConstructionInfo ci, CollisionObject body0, CollisionObject body1) {
            CompoundCollisionAlgorithm algo = this.pool.get();
            algo.init(ci, body0, body1, false);
            return algo;
        }

        @Override
        public void releaseCollisionAlgorithm(CollisionAlgorithm algo) {
            this.pool.release((CompoundCollisionAlgorithm)algo);
        }
    }
}

