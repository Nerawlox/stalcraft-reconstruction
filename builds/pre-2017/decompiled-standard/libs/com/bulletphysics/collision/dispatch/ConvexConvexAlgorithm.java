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
import com.bulletphysics.collision.narrowphase.ConvexCast;
import com.bulletphysics.collision.narrowphase.ConvexPenetrationDepthSolver;
import com.bulletphysics.collision.narrowphase.DiscreteCollisionDetectorInterface;
import com.bulletphysics.collision.narrowphase.GjkConvexCast;
import com.bulletphysics.collision.narrowphase.GjkPairDetector;
import com.bulletphysics.collision.narrowphase.PersistentManifold;
import com.bulletphysics.collision.narrowphase.SimplexSolverInterface;
import com.bulletphysics.collision.narrowphase.VoronoiSimplexSolver;
import com.bulletphysics.collision.shapes.ConvexShape;
import com.bulletphysics.collision.shapes.SphereShape;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import com.bulletphysics.util.ObjectPool;
import javax.vecmath.Vector3f;

public class ConvexConvexAlgorithm
extends CollisionAlgorithm {
    protected final ObjectPool<DiscreteCollisionDetectorInterface.ClosestPointInput> pointInputsPool = ObjectPool.get(DiscreteCollisionDetectorInterface.ClosestPointInput.class);
    private GjkPairDetector gjkPairDetector = new GjkPairDetector();
    public boolean ownManifold;
    public PersistentManifold manifoldPtr;
    public boolean lowLevelOfDetail;
    private static boolean disableCcd = false;

    public void init(PersistentManifold mf, CollisionAlgorithmConstructionInfo ci, CollisionObject body0, CollisionObject body1, SimplexSolverInterface simplexSolver, ConvexPenetrationDepthSolver pdSolver) {
        super.init(ci);
        this.gjkPairDetector.init(null, null, simplexSolver, pdSolver);
        this.manifoldPtr = mf;
        this.ownManifold = false;
        this.lowLevelOfDetail = false;
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

    public void setLowLevelOfDetail(boolean useLowLevel) {
        this.lowLevelOfDetail = useLowLevel;
    }

    @Override
    public void processCollision(CollisionObject body0, CollisionObject body1, DispatcherInfo dispatchInfo, ManifoldResult resultOut) {
        if (this.manifoldPtr == null) {
            this.manifoldPtr = this.dispatcher.getNewManifold(body0, body1);
            this.ownManifold = true;
        }
        resultOut.setPersistentManifold(this.manifoldPtr);
        ConvexShape min0 = (ConvexShape)body0.getCollisionShape();
        ConvexShape min1 = (ConvexShape)body1.getCollisionShape();
        DiscreteCollisionDetectorInterface.ClosestPointInput input = this.pointInputsPool.get();
        input.init();
        this.gjkPairDetector.setMinkowskiA(min0);
        this.gjkPairDetector.setMinkowskiB(min1);
        input.maximumDistanceSquared = min0.getMargin() + min1.getMargin() + this.manifoldPtr.getContactBreakingThreshold();
        input.maximumDistanceSquared *= input.maximumDistanceSquared;
        body0.getWorldTransform(input.transformA);
        body1.getWorldTransform(input.transformB);
        this.gjkPairDetector.getClosestPoints(input, resultOut, dispatchInfo.debugDraw);
        this.pointInputsPool.release(input);
        if (this.ownManifold) {
            resultOut.refreshContactPoints();
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public float calculateTimeOfImpact(CollisionObject collisionObject, CollisionObject collisionObject2, DispatcherInfo dispatcherInfo, ManifoldResult manifoldResult) {
        $Stack $Stack = $Stack.get();
        try {
            void col1;
            void col0;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Transform tmpTrans1 = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform tmpTrans2 = $Stack.get$com$bulletphysics$linearmath$Transform();
            float resultFraction = 1.0f;
            tmp.sub(col0.getInterpolationWorldTransform((Transform)tmpTrans1).origin, col0.getWorldTransform((Transform)tmpTrans2).origin);
            float squareMot0 = tmp.lengthSquared();
            tmp.sub(col1.getInterpolationWorldTransform((Transform)tmpTrans1).origin, col1.getWorldTransform((Transform)tmpTrans2).origin);
            float squareMot1 = tmp.lengthSquared();
            if (squareMot0 < col0.getCcdSquareMotionThreshold() && squareMot1 < col1.getCcdSquareMotionThreshold()) {
                $Stack $Stack3 = $Stack;
                $Stack3.pop$com$bulletphysics$linearmath$Transform();
                $Stack3.pop$javax$vecmath$Vector3f();
                return resultFraction;
            }
            if (disableCcd) {
                $Stack $Stack4 = $Stack;
                $Stack4.pop$com$bulletphysics$linearmath$Transform();
                $Stack4.pop$javax$vecmath$Vector3f();
                return 1.0f;
            }
            Transform tmpTrans3 = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform tmpTrans4 = $Stack.get$com$bulletphysics$linearmath$Transform();
            ConvexShape convex0 = (ConvexShape)col0.getCollisionShape();
            SphereShape sphere1 = new SphereShape(col1.getCcdSweptSphereRadius());
            ConvexCast.CastResult result2 = new ConvexCast.CastResult();
            VoronoiSimplexSolver voronoiSimplex = new VoronoiSimplexSolver();
            GjkConvexCast ccd1 = new GjkConvexCast(convex0, sphere1, voronoiSimplex);
            if (ccd1.calcTimeOfImpact(col0.getWorldTransform(tmpTrans1), col0.getInterpolationWorldTransform(tmpTrans2), col1.getWorldTransform(tmpTrans3), col1.getInterpolationWorldTransform(tmpTrans4), result2)) {
                if (col0.getHitFraction() > result2.fraction) {
                    col0.setHitFraction(result2.fraction);
                }
                if (col1.getHitFraction() > result2.fraction) {
                    col1.setHitFraction(result2.fraction);
                }
                if (resultFraction > result2.fraction) {
                    resultFraction = result2.fraction;
                }
            }
            ConvexShape convex1 = (ConvexShape)col1.getCollisionShape();
            SphereShape sphere0 = new SphereShape(col0.getCcdSweptSphereRadius());
            result2 = new ConvexCast.CastResult();
            voronoiSimplex = new VoronoiSimplexSolver();
            ccd1 = new GjkConvexCast(sphere0, convex1, voronoiSimplex);
            if (ccd1.calcTimeOfImpact(col0.getWorldTransform(tmpTrans1), col0.getInterpolationWorldTransform(tmpTrans2), col1.getWorldTransform(tmpTrans3), col1.getInterpolationWorldTransform(tmpTrans4), result2)) {
                if (col0.getHitFraction() > result2.fraction) {
                    col0.setHitFraction(result2.fraction);
                }
                if (col1.getHitFraction() > result2.fraction) {
                    col1.setHitFraction(result2.fraction);
                }
                if (resultFraction > result2.fraction) {
                    resultFraction = result2.fraction;
                }
            }
            $Stack $Stack5 = $Stack;
            $Stack5.pop$com$bulletphysics$linearmath$Transform();
            $Stack5.pop$javax$vecmath$Vector3f();
            return resultFraction;
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
        if (this.manifoldPtr != null && this.ownManifold) {
            manifoldArray.add(this.manifoldPtr);
        }
    }

    public PersistentManifold getManifold() {
        return this.manifoldPtr;
    }

    public static class CreateFunc
    extends CollisionAlgorithmCreateFunc {
        private final ObjectPool<ConvexConvexAlgorithm> pool = ObjectPool.get(ConvexConvexAlgorithm.class);
        public ConvexPenetrationDepthSolver pdSolver;
        public SimplexSolverInterface simplexSolver;

        public CreateFunc(SimplexSolverInterface simplexSolver, ConvexPenetrationDepthSolver pdSolver) {
            this.simplexSolver = simplexSolver;
            this.pdSolver = pdSolver;
        }

        @Override
        public CollisionAlgorithm createCollisionAlgorithm(CollisionAlgorithmConstructionInfo ci, CollisionObject body0, CollisionObject body1) {
            ConvexConvexAlgorithm algo = this.pool.get();
            algo.init(ci.manifold, ci, body0, body1, this.simplexSolver, this.pdSolver);
            return algo;
        }

        @Override
        public void releaseCollisionAlgorithm(CollisionAlgorithm algo) {
            this.pool.release((ConvexConvexAlgorithm)algo);
        }
    }
}

