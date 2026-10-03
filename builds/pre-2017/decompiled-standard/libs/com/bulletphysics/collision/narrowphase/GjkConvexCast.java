/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.narrowphase;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.narrowphase.ConvexCast;
import com.bulletphysics.collision.narrowphase.DiscreteCollisionDetectorInterface;
import com.bulletphysics.collision.narrowphase.GjkPairDetector;
import com.bulletphysics.collision.narrowphase.PointCollector;
import com.bulletphysics.collision.narrowphase.SimplexSolverInterface;
import com.bulletphysics.collision.shapes.ConvexShape;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import com.bulletphysics.util.ObjectPool;
import javax.vecmath.Vector3f;

public class GjkConvexCast
extends ConvexCast {
    protected final ObjectPool<DiscreteCollisionDetectorInterface.ClosestPointInput> pointInputsPool = ObjectPool.get(DiscreteCollisionDetectorInterface.ClosestPointInput.class);
    private static final int MAX_ITERATIONS = 32;
    private SimplexSolverInterface simplexSolver;
    private ConvexShape convexA;
    private ConvexShape convexB;
    private GjkPairDetector gjk = new GjkPairDetector();

    public GjkConvexCast(ConvexShape convexA, ConvexShape convexB, SimplexSolverInterface simplexSolver) {
        this.simplexSolver = simplexSolver;
        this.convexA = convexA;
        this.convexB = convexB;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean calcTimeOfImpact(Transform transform, Transform transform2, Transform transform3, Transform transform4, ConvexCast.CastResult castResult) {
        $Stack $Stack = $Stack.get();
        try {
            void result2;
            float dist;
            DiscreteCollisionDetectorInterface.ClosestPointInput input;
            PointCollector pointCollector;
            int numIter;
            float lastLambda;
            Vector3f r;
            Vector3f c;
            Vector3f n;
            int maxIter;
            float lambda2;
            float radius;
            void fromB;
            void toB;
            void fromA;
            void toA;
            block23: {
                $Stack $Stack2 = $Stack;
                $Stack2.push$com$bulletphysics$linearmath$Transform();
                $Stack2.push$javax$vecmath$Vector3f();
                this.simplexSolver.reset();
                Vector3f linVelA = $Stack.get$javax$vecmath$Vector3f();
                Vector3f linVelB = $Stack.get$javax$vecmath$Vector3f();
                linVelA.sub(toA.origin, fromA.origin);
                linVelB.sub(toB.origin, fromB.origin);
                radius = 0.001f;
                lambda2 = 0.0f;
                Vector3f v = $Stack.get$javax$vecmath$Vector3f();
                v.set(1.0f, 0.0f, 0.0f);
                maxIter = 32;
                n = $Stack.get$javax$vecmath$Vector3f();
                n.set(0.0f, 0.0f, 0.0f);
                boolean hasResult = false;
                c = $Stack.get$javax$vecmath$Vector3f();
                r = $Stack.get$javax$vecmath$Vector3f();
                r.sub(linVelA, linVelB);
                lastLambda = lambda2;
                numIter = 0;
                Transform identityTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
                identityTrans.setIdentity();
                pointCollector = new PointCollector();
                this.gjk.init(this.convexA, this.convexB, this.simplexSolver, null);
                input = this.pointInputsPool.get();
                input.init();
                input.transformA.set((Transform)fromA);
                input.transformB.set((Transform)fromB);
                this.gjk.getClosestPoints(input, pointCollector, null);
                hasResult = pointCollector.hasResult;
                c.set(pointCollector.pointInWorld);
                if (hasResult) {
                    dist = pointCollector.distance;
                    n.set(pointCollector.normalOnBInWorld);
                    break block23;
                } else {
                    boolean bl = false;
                    $Stack $Stack3 = $Stack;
                    $Stack3.pop$com$bulletphysics$linearmath$Transform();
                    $Stack3.pop$javax$vecmath$Vector3f();
                    return bl;
                }
                finally {
                    this.pointInputsPool.release(input);
                }
            }
            while (dist > radius) {
                if (++numIter > maxIter) {
                    boolean bl = false;
                    $Stack $Stack4 = $Stack;
                    $Stack4.pop$com$bulletphysics$linearmath$Transform();
                    $Stack4.pop$javax$vecmath$Vector3f();
                    return bl;
                }
                float dLambda = 0.0f;
                float projectedLinearVelocity = r.dot(n);
                dLambda = dist / projectedLinearVelocity;
                if ((lambda2 -= dLambda) > 1.0f) {
                    boolean bl = false;
                    $Stack $Stack5 = $Stack;
                    $Stack5.pop$com$bulletphysics$linearmath$Transform();
                    $Stack5.pop$javax$vecmath$Vector3f();
                    return bl;
                }
                if (lambda2 < 0.0f) {
                    boolean bl = false;
                    $Stack $Stack6 = $Stack;
                    $Stack6.pop$com$bulletphysics$linearmath$Transform();
                    $Stack6.pop$javax$vecmath$Vector3f();
                    return bl;
                }
                if (lambda2 <= lastLambda) {
                    boolean bl = false;
                    $Stack $Stack7 = $Stack;
                    $Stack7.pop$com$bulletphysics$linearmath$Transform();
                    $Stack7.pop$javax$vecmath$Vector3f();
                    return bl;
                }
                lastLambda = lambda2;
                result2.debugDraw(lambda2);
                VectorUtil.setInterpolate3(input.transformA.origin, fromA.origin, toA.origin, lambda2);
                VectorUtil.setInterpolate3(input.transformB.origin, fromB.origin, toB.origin, lambda2);
                this.gjk.getClosestPoints(input, pointCollector, null);
                if (pointCollector.hasResult) {
                    if (pointCollector.distance < 0.0f) {
                        result2.fraction = lastLambda;
                        n.set(pointCollector.normalOnBInWorld);
                        result2.normal.set(n);
                        result2.hitPoint.set(pointCollector.pointInWorld);
                        boolean bl = true;
                        $Stack $Stack8 = $Stack;
                        $Stack8.pop$com$bulletphysics$linearmath$Transform();
                        $Stack8.pop$javax$vecmath$Vector3f();
                        return bl;
                    }
                    c.set(pointCollector.pointInWorld);
                    n.set(pointCollector.normalOnBInWorld);
                    dist = pointCollector.distance;
                    continue;
                }
                boolean bl = false;
                $Stack $Stack9 = $Stack;
                $Stack9.pop$com$bulletphysics$linearmath$Transform();
                $Stack9.pop$javax$vecmath$Vector3f();
                return bl;
            }
            if (n.dot(r) >= -result2.allowedPenetration) {
                boolean bl = false;
                $Stack $Stack10 = $Stack;
                $Stack10.pop$com$bulletphysics$linearmath$Transform();
                $Stack10.pop$javax$vecmath$Vector3f();
                return bl;
            }
            result2.fraction = lambda2;
            result2.normal.set(n);
            result2.hitPoint.set(c);
            boolean bl = true;
            $Stack $Stack11 = $Stack;
            $Stack11.pop$com$bulletphysics$linearmath$Transform();
            $Stack11.pop$javax$vecmath$Vector3f();
            return bl;
        }
        catch (Throwable throwable) {
            $Stack $Stack12 = $Stack;
            $Stack12.pop$com$bulletphysics$linearmath$Transform();
            $Stack12.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }
}

