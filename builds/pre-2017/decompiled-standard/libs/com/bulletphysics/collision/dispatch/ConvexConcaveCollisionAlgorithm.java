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
import com.bulletphysics.collision.dispatch.ConvexTriangleCallback;
import com.bulletphysics.collision.dispatch.ManifoldResult;
import com.bulletphysics.collision.narrowphase.ConvexCast;
import com.bulletphysics.collision.narrowphase.PersistentManifold;
import com.bulletphysics.collision.narrowphase.SubsimplexConvexCast;
import com.bulletphysics.collision.narrowphase.VoronoiSimplexSolver;
import com.bulletphysics.collision.shapes.ConcaveShape;
import com.bulletphysics.collision.shapes.SphereShape;
import com.bulletphysics.collision.shapes.TriangleCallback;
import com.bulletphysics.collision.shapes.TriangleShape;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import com.bulletphysics.util.ObjectArrayList;
import com.bulletphysics.util.ObjectPool;
import javax.vecmath.Vector3f;

public class ConvexConcaveCollisionAlgorithm
extends CollisionAlgorithm {
    private boolean isSwapped;
    private ConvexTriangleCallback btConvexTriangleCallback;

    public void init(CollisionAlgorithmConstructionInfo ci, CollisionObject body0, CollisionObject body1, boolean isSwapped) {
        super.init(ci);
        this.isSwapped = isSwapped;
        this.btConvexTriangleCallback = new ConvexTriangleCallback(this.dispatcher, body0, body1, isSwapped);
    }

    @Override
    public void destroy() {
        this.btConvexTriangleCallback.destroy();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void processCollision(CollisionObject collisionObject, CollisionObject collisionObject2, DispatcherInfo dispatcherInfo, ManifoldResult manifoldResult) {
        $Stack $Stack = $Stack.get();
        try {
            void triBody;
            void body0;
            void body1;
            $Stack.push$javax$vecmath$Vector3f();
            void convexBody = this.isSwapped ? body1 : body0;
            void v0 = triBody = this.isSwapped ? body0 : body1;
            if (triBody.getCollisionShape().isConcave()) {
                void triOb = triBody;
                ConcaveShape concaveShape = (ConcaveShape)triOb.getCollisionShape();
                if (convexBody.getCollisionShape().isConvex()) {
                    void dispatchInfo;
                    void resultOut;
                    float collisionMarginTriangle = concaveShape.getMargin();
                    resultOut.setPersistentManifold(this.btConvexTriangleCallback.manifoldPtr);
                    this.btConvexTriangleCallback.setTimeStepAndCounters(collisionMarginTriangle, (DispatcherInfo)dispatchInfo, (ManifoldResult)resultOut);
                    this.btConvexTriangleCallback.manifoldPtr.setBodies(convexBody, triBody);
                    concaveShape.processAllTriangles(this.btConvexTriangleCallback, this.btConvexTriangleCallback.getAabbMin($Stack.get$javax$vecmath$Vector3f()), this.btConvexTriangleCallback.getAabbMax($Stack.get$javax$vecmath$Vector3f()));
                    resultOut.refreshContactPoints();
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

    /*
     * WARNING - void declaration
     */
    @Override
    public float calculateTimeOfImpact(CollisionObject collisionObject, CollisionObject collisionObject2, DispatcherInfo dispatcherInfo, ManifoldResult manifoldResult) {
        $Stack $Stack = $Stack.get();
        try {
            void body0;
            void body1;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            void convexbody = this.isSwapped ? body1 : body0;
            void triBody = this.isSwapped ? body0 : body1;
            tmp.sub(convexbody.getInterpolationWorldTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).origin, convexbody.getWorldTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).origin);
            float squareMot0 = tmp.lengthSquared();
            if (squareMot0 < convexbody.getCcdSquareMotionThreshold()) {
                $Stack $Stack3 = $Stack;
                $Stack3.pop$com$bulletphysics$linearmath$Transform();
                $Stack3.pop$javax$vecmath$Vector3f();
                return 1.0f;
            }
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform triInv = triBody.getWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            triInv.inverse();
            Transform convexFromLocal = $Stack.get$com$bulletphysics$linearmath$Transform();
            convexFromLocal.mul(triInv, convexbody.getWorldTransform(tmpTrans));
            Transform convexToLocal = $Stack.get$com$bulletphysics$linearmath$Transform();
            convexToLocal.mul(triInv, convexbody.getInterpolationWorldTransform(tmpTrans));
            if (triBody.getCollisionShape().isConcave()) {
                Vector3f rayAabbMin = $Stack.get$javax$vecmath$Vector3f(convexFromLocal.origin);
                VectorUtil.setMin(rayAabbMin, convexToLocal.origin);
                Vector3f rayAabbMax = $Stack.get$javax$vecmath$Vector3f(convexFromLocal.origin);
                VectorUtil.setMax(rayAabbMax, convexToLocal.origin);
                float ccdRadius0 = convexbody.getCcdSweptSphereRadius();
                tmp.set(ccdRadius0, ccdRadius0, ccdRadius0);
                rayAabbMin.sub(tmp);
                rayAabbMax.add(tmp);
                float curHitFraction = 1.0f;
                LocalTriangleSphereCastCallback raycastCallback = new LocalTriangleSphereCastCallback(convexFromLocal, convexToLocal, convexbody.getCcdSweptSphereRadius(), curHitFraction);
                raycastCallback.hitFraction = convexbody.getHitFraction();
                void concavebody = triBody;
                ConcaveShape triangleMesh = (ConcaveShape)concavebody.getCollisionShape();
                if (triangleMesh != null) {
                    triangleMesh.processAllTriangles(raycastCallback, rayAabbMin, rayAabbMax);
                }
                if (raycastCallback.hitFraction < convexbody.getHitFraction()) {
                    convexbody.setHitFraction(raycastCallback.hitFraction);
                    float f = raycastCallback.hitFraction;
                    $Stack $Stack4 = $Stack;
                    $Stack4.pop$com$bulletphysics$linearmath$Transform();
                    $Stack4.pop$javax$vecmath$Vector3f();
                    return f;
                }
            }
            $Stack $Stack5 = $Stack;
            $Stack5.pop$com$bulletphysics$linearmath$Transform();
            $Stack5.pop$javax$vecmath$Vector3f();
            return 1.0f;
        }
        catch (Throwable throwable) {
            $Stack $Stack6 = $Stack;
            $Stack6.pop$com$bulletphysics$linearmath$Transform();
            $Stack6.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    @Override
    public void getAllContactManifolds(ObjectArrayList<PersistentManifold> manifoldArray) {
        if (this.btConvexTriangleCallback.manifoldPtr != null) {
            manifoldArray.add(this.btConvexTriangleCallback.manifoldPtr);
        }
    }

    public void clearCache() {
        this.btConvexTriangleCallback.clearCache();
    }

    public static class SwappedCreateFunc
    extends CollisionAlgorithmCreateFunc {
        private final ObjectPool<ConvexConcaveCollisionAlgorithm> pool = ObjectPool.get(ConvexConcaveCollisionAlgorithm.class);

        @Override
        public CollisionAlgorithm createCollisionAlgorithm(CollisionAlgorithmConstructionInfo ci, CollisionObject body0, CollisionObject body1) {
            ConvexConcaveCollisionAlgorithm algo = this.pool.get();
            algo.init(ci, body0, body1, true);
            return algo;
        }

        @Override
        public void releaseCollisionAlgorithm(CollisionAlgorithm algo) {
            this.pool.release((ConvexConcaveCollisionAlgorithm)algo);
        }
    }

    public static class CreateFunc
    extends CollisionAlgorithmCreateFunc {
        private final ObjectPool<ConvexConcaveCollisionAlgorithm> pool = ObjectPool.get(ConvexConcaveCollisionAlgorithm.class);

        @Override
        public CollisionAlgorithm createCollisionAlgorithm(CollisionAlgorithmConstructionInfo ci, CollisionObject body0, CollisionObject body1) {
            ConvexConcaveCollisionAlgorithm algo = this.pool.get();
            algo.init(ci, body0, body1, false);
            return algo;
        }

        @Override
        public void releaseCollisionAlgorithm(CollisionAlgorithm algo) {
            this.pool.release((ConvexConcaveCollisionAlgorithm)algo);
        }
    }

    private static class LocalTriangleSphereCastCallback
    extends TriangleCallback {
        public final Transform ccdSphereFromTrans = new Transform();
        public final Transform ccdSphereToTrans = new Transform();
        public final Transform meshTransform = new Transform();
        public float ccdSphereRadius;
        public float hitFraction;
        private final Transform ident = new Transform();

        public LocalTriangleSphereCastCallback(Transform from, Transform to, float ccdSphereRadius, float hitFraction) {
            this.ccdSphereFromTrans.set(from);
            this.ccdSphereToTrans.set(to);
            this.ccdSphereRadius = ccdSphereRadius;
            this.hitFraction = hitFraction;
            this.ident.setIdentity();
        }

        @Override
        public void processTriangle(Vector3f[] triangle, int partId, int triangleIndex) {
            ConvexCast.CastResult castResult = new ConvexCast.CastResult();
            castResult.fraction = this.hitFraction;
            SphereShape pointShape = new SphereShape(this.ccdSphereRadius);
            TriangleShape triShape = new TriangleShape(triangle[0], triangle[1], triangle[2]);
            VoronoiSimplexSolver simplexSolver = new VoronoiSimplexSolver();
            SubsimplexConvexCast convexCaster = new SubsimplexConvexCast(pointShape, triShape, simplexSolver);
            if (convexCaster.calcTimeOfImpact(this.ccdSphereFromTrans, this.ccdSphereToTrans, this.ident, this.ident, castResult) && this.hitFraction > castResult.fraction) {
                this.hitFraction = castResult.fraction;
            }
        }
    }
}

