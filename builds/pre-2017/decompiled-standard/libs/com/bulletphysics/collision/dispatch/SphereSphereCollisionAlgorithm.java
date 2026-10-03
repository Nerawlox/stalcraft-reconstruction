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
import com.bulletphysics.collision.shapes.SphereShape;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import com.bulletphysics.util.ObjectPool;
import javax.vecmath.Vector3f;

public class SphereSphereCollisionAlgorithm
extends CollisionAlgorithm {
    private boolean ownManifold;
    private PersistentManifold manifoldPtr;

    public void init(PersistentManifold mf, CollisionAlgorithmConstructionInfo ci, CollisionObject col0, CollisionObject col1) {
        super.init(ci);
        this.manifoldPtr = mf;
        if (this.manifoldPtr == null) {
            this.manifoldPtr = this.dispatcher.getNewManifold(col0, col1);
            this.ownManifold = true;
        }
    }

    @Override
    public void init(CollisionAlgorithmConstructionInfo ci) {
        super.init(ci);
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
            void col1;
            void col0;
            void resultOut;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            if (this.manifoldPtr == null) {
                $Stack $Stack3 = $Stack;
                $Stack3.pop$com$bulletphysics$linearmath$Transform();
                $Stack3.pop$javax$vecmath$Vector3f();
                return;
            }
            Transform tmpTrans1 = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform tmpTrans2 = $Stack.get$com$bulletphysics$linearmath$Transform();
            resultOut.setPersistentManifold(this.manifoldPtr);
            SphereShape sphere0 = (SphereShape)col0.getCollisionShape();
            SphereShape sphere1 = (SphereShape)col1.getCollisionShape();
            Vector3f diff = $Stack.get$javax$vecmath$Vector3f();
            diff.sub(col0.getWorldTransform((Transform)tmpTrans1).origin, col1.getWorldTransform((Transform)tmpTrans2).origin);
            float len = diff.length();
            float radius0 = sphere0.getRadius();
            float radius1 = sphere1.getRadius();
            if (len > radius0 + radius1) {
                resultOut.refreshContactPoints();
                $Stack $Stack4 = $Stack;
                $Stack4.pop$com$bulletphysics$linearmath$Transform();
                $Stack4.pop$javax$vecmath$Vector3f();
                return;
            }
            float dist = len - (radius0 + radius1);
            Vector3f normalOnSurfaceB = $Stack.get$javax$vecmath$Vector3f();
            normalOnSurfaceB.set(1.0f, 0.0f, 0.0f);
            if (len > 1.1920929E-7f) {
                normalOnSurfaceB.scale(1.0f / len, diff);
            }
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f pos0 = $Stack.get$javax$vecmath$Vector3f();
            tmp.scale(radius0, normalOnSurfaceB);
            pos0.sub(col0.getWorldTransform((Transform)tmpTrans1).origin, tmp);
            Vector3f pos1 = $Stack.get$javax$vecmath$Vector3f();
            tmp.scale(radius1, normalOnSurfaceB);
            pos1.add(col1.getWorldTransform((Transform)tmpTrans2).origin, tmp);
            resultOut.addContactPoint(normalOnSurfaceB, pos1, dist);
            resultOut.refreshContactPoints();
            $Stack $Stack5 = $Stack;
            $Stack5.pop$com$bulletphysics$linearmath$Transform();
            $Stack5.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack6 = $Stack;
            $Stack6.pop$com$bulletphysics$linearmath$Transform();
            $Stack6.pop$javax$vecmath$Vector3f();
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
        private final ObjectPool<SphereSphereCollisionAlgorithm> pool = ObjectPool.get(SphereSphereCollisionAlgorithm.class);

        @Override
        public CollisionAlgorithm createCollisionAlgorithm(CollisionAlgorithmConstructionInfo ci, CollisionObject body0, CollisionObject body1) {
            SphereSphereCollisionAlgorithm algo = this.pool.get();
            algo.init(null, ci, body0, body1);
            return algo;
        }

        @Override
        public void releaseCollisionAlgorithm(CollisionAlgorithm algo) {
            this.pool.release((SphereSphereCollisionAlgorithm)algo);
        }
    }
}

