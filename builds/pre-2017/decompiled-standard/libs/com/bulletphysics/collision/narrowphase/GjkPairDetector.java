/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.narrowphase;

import com.bulletphysics.$Stack;
import com.bulletphysics.BulletStats;
import com.bulletphysics.collision.narrowphase.ConvexPenetrationDepthSolver;
import com.bulletphysics.collision.narrowphase.DiscreteCollisionDetectorInterface;
import com.bulletphysics.collision.narrowphase.SimplexSolverInterface;
import com.bulletphysics.collision.shapes.ConvexShape;
import com.bulletphysics.linearmath.IDebugDraw;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Vector3f;

public class GjkPairDetector
extends DiscreteCollisionDetectorInterface {
    private static final float REL_ERROR2 = 1.0E-6f;
    private final Vector3f cachedSeparatingAxis = new Vector3f();
    private ConvexPenetrationDepthSolver penetrationDepthSolver;
    private SimplexSolverInterface simplexSolver;
    private ConvexShape minkowskiA;
    private ConvexShape minkowskiB;
    private boolean ignoreMargin;
    public int lastUsedMethod;
    public int curIter;
    public int degenerateSimplex;
    public int catchDegeneracies;

    public void init(ConvexShape objectA, ConvexShape objectB, SimplexSolverInterface simplexSolver, ConvexPenetrationDepthSolver penetrationDepthSolver) {
        this.cachedSeparatingAxis.set(0.0f, 0.0f, 1.0f);
        this.ignoreMargin = false;
        this.lastUsedMethod = -1;
        this.catchDegeneracies = 1;
        this.penetrationDepthSolver = penetrationDepthSolver;
        this.simplexSolver = simplexSolver;
        this.minkowskiA = objectA;
        this.minkowskiB = objectB;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void getClosestPoints(DiscreteCollisionDetectorInterface.ClosestPointInput closestPointInput, DiscreteCollisionDetectorInterface.Result result2, IDebugDraw iDebugDraw, boolean bl) {
        $Stack $Stack = $Stack.get();
        try {
            boolean catchDegeneratePenetrationCase;
            Vector3f tmpNormalInB;
            Vector3f tmpPointOnB;
            Vector3f tmpPointOnA;
            float margin;
            float squaredDistance;
            boolean checkPenetration;
            boolean checkSimplex;
            boolean isValid;
            float marginB;
            float marginA;
            Vector3f positionOffset;
            Transform localTransB;
            Transform localTransA;
            Vector3f pointOnB;
            Vector3f pointOnA;
            Vector3f normalInB;
            float distance;
            Vector3f tmp;
            block23: {
                boolean check;
                void input;
                $Stack $Stack2 = $Stack;
                $Stack2.push$com$bulletphysics$linearmath$Transform();
                $Stack2.push$javax$vecmath$Vector3f();
                tmp = $Stack.get$javax$vecmath$Vector3f();
                distance = 0.0f;
                normalInB = $Stack.get$javax$vecmath$Vector3f();
                normalInB.set(0.0f, 0.0f, 0.0f);
                pointOnA = $Stack.get$javax$vecmath$Vector3f();
                pointOnB = $Stack.get$javax$vecmath$Vector3f();
                localTransA = $Stack.get$com$bulletphysics$linearmath$Transform(input.transformA);
                localTransB = $Stack.get$com$bulletphysics$linearmath$Transform(input.transformB);
                positionOffset = $Stack.get$javax$vecmath$Vector3f();
                positionOffset.add(localTransA.origin, localTransB.origin);
                positionOffset.scale(0.5f);
                localTransA.origin.sub(positionOffset);
                localTransB.origin.sub(positionOffset);
                marginA = this.minkowskiA.getMargin();
                marginB = this.minkowskiB.getMargin();
                ++BulletStats.gNumGjkChecks;
                if (this.ignoreMargin) {
                    marginA = 0.0f;
                    marginB = 0.0f;
                }
                this.curIter = 0;
                int gGjkMaxIter = 1000;
                this.cachedSeparatingAxis.set(0.0f, 1.0f, 0.0f);
                isValid = false;
                checkSimplex = false;
                checkPenetration = true;
                this.degenerateSimplex = 0;
                this.lastUsedMethod = -1;
                squaredDistance = Float.MAX_VALUE;
                float delta = 0.0f;
                margin = marginA + marginB;
                this.simplexSolver.reset();
                Vector3f seperatingAxisInA = $Stack.get$javax$vecmath$Vector3f();
                Vector3f seperatingAxisInB = $Stack.get$javax$vecmath$Vector3f();
                Vector3f pInA = $Stack.get$javax$vecmath$Vector3f();
                Vector3f qInB = $Stack.get$javax$vecmath$Vector3f();
                Vector3f pWorld = $Stack.get$javax$vecmath$Vector3f();
                Vector3f qWorld = $Stack.get$javax$vecmath$Vector3f();
                Vector3f w = $Stack.get$javax$vecmath$Vector3f();
                tmpPointOnA = $Stack.get$javax$vecmath$Vector3f();
                tmpPointOnB = $Stack.get$javax$vecmath$Vector3f();
                tmpNormalInB = $Stack.get$javax$vecmath$Vector3f();
                do {
                    seperatingAxisInA.negate(this.cachedSeparatingAxis);
                    MatrixUtil.transposeTransform(seperatingAxisInA, seperatingAxisInA, input.transformA.basis);
                    seperatingAxisInB.set(this.cachedSeparatingAxis);
                    MatrixUtil.transposeTransform(seperatingAxisInB, seperatingAxisInB, input.transformB.basis);
                    this.minkowskiA.localGetSupportingVertexWithoutMargin(seperatingAxisInA, pInA);
                    this.minkowskiB.localGetSupportingVertexWithoutMargin(seperatingAxisInB, qInB);
                    pWorld.set(pInA);
                    localTransA.transform(pWorld);
                    qWorld.set(qInB);
                    localTransB.transform(qWorld);
                    w.sub(pWorld, qWorld);
                    delta = this.cachedSeparatingAxis.dot(w);
                    if (delta > 0.0f && delta * delta > squaredDistance * input.maximumDistanceSquared) {
                        checkPenetration = false;
                        break block23;
                    }
                    if (this.simplexSolver.inSimplex(w)) {
                        this.degenerateSimplex = 1;
                        checkSimplex = true;
                        break block23;
                    }
                    float f0 = squaredDistance - delta;
                    float f1 = squaredDistance * 1.0E-6f;
                    if (f0 <= f1) {
                        if (f0 <= 0.0f) {
                            this.degenerateSimplex = 2;
                        }
                        checkSimplex = true;
                        break block23;
                    }
                    this.simplexSolver.addVertex(w, pWorld, qWorld);
                    if (!this.simplexSolver.closest(this.cachedSeparatingAxis)) {
                        this.degenerateSimplex = 3;
                        checkSimplex = true;
                        break block23;
                    }
                    if (this.cachedSeparatingAxis.lengthSquared() < 1.0E-6f) {
                        this.degenerateSimplex = 6;
                        checkSimplex = true;
                        break block23;
                    }
                    float previousSquaredDistance = squaredDistance;
                    if (previousSquaredDistance - (squaredDistance = this.cachedSeparatingAxis.lengthSquared()) <= 1.1920929E-7f * previousSquaredDistance) {
                        this.simplexSolver.backup_closest(this.cachedSeparatingAxis);
                        checkSimplex = true;
                        break block23;
                    }
                    if (this.curIter++ > gGjkMaxIter) break block23;
                } while (check = !this.simplexSolver.fullSimplex());
                this.simplexSolver.backup_closest(this.cachedSeparatingAxis);
            }
            if (checkSimplex) {
                this.simplexSolver.compute_points(pointOnA, pointOnB);
                normalInB.sub(pointOnA, pointOnB);
                float lenSqr = this.cachedSeparatingAxis.lengthSquared();
                if (lenSqr < 1.0E-4f) {
                    this.degenerateSimplex = 5;
                }
                if (lenSqr > 1.4210855E-14f) {
                    float rlen = 1.0f / (float)Math.sqrt(lenSqr);
                    normalInB.scale(rlen);
                    float s = (float)Math.sqrt(squaredDistance);
                    assert (s > 0.0f);
                    tmp.scale(marginA / s, this.cachedSeparatingAxis);
                    pointOnA.sub(tmp);
                    tmp.scale(marginB / s, this.cachedSeparatingAxis);
                    pointOnB.add(tmp);
                    distance = 1.0f / rlen - margin;
                    isValid = true;
                    this.lastUsedMethod = 1;
                } else {
                    this.lastUsedMethod = 2;
                }
            }
            boolean bl2 = catchDegeneratePenetrationCase = this.catchDegeneracies != 0 && this.penetrationDepthSolver != null && this.degenerateSimplex != 0 && distance + margin < 0.01f;
            if (checkPenetration && (!isValid || catchDegeneratePenetrationCase) && this.penetrationDepthSolver != null) {
                void debugDraw;
                ++BulletStats.gNumDeepPenetrationChecks;
                boolean isValid2 = this.penetrationDepthSolver.calcPenDepth(this.simplexSolver, this.minkowskiA, this.minkowskiB, localTransA, localTransB, this.cachedSeparatingAxis, tmpPointOnA, tmpPointOnB, (IDebugDraw)debugDraw);
                if (isValid2) {
                    tmpNormalInB.sub(tmpPointOnB, tmpPointOnA);
                    float lenSqr = tmpNormalInB.lengthSquared();
                    if (lenSqr > 1.4210855E-14f) {
                        tmpNormalInB.scale(1.0f / (float)Math.sqrt(lenSqr));
                        tmp.sub(tmpPointOnA, tmpPointOnB);
                        float distance2 = -tmp.length();
                        if (!isValid || distance2 < distance) {
                            distance = distance2;
                            pointOnA.set(tmpPointOnA);
                            pointOnB.set(tmpPointOnB);
                            normalInB.set(tmpNormalInB);
                            isValid = true;
                            this.lastUsedMethod = 3;
                        }
                    } else {
                        this.lastUsedMethod = 4;
                    }
                } else {
                    this.lastUsedMethod = 5;
                }
            }
            if (isValid) {
                void output;
                tmp.add(pointOnB, positionOffset);
                output.addContactPoint(normalInB, tmp, distance);
            }
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

    public void setMinkowskiA(ConvexShape minkA) {
        this.minkowskiA = minkA;
    }

    public void setMinkowskiB(ConvexShape minkB) {
        this.minkowskiB = minkB;
    }

    public void setCachedSeperatingAxis(Vector3f seperatingAxis) {
        this.cachedSeparatingAxis.set(seperatingAxis);
    }

    public void setPenetrationDepthSolver(ConvexPenetrationDepthSolver penetrationDepthSolver) {
        this.penetrationDepthSolver = penetrationDepthSolver;
    }

    public void setIgnoreMargin(boolean ignoreMargin) {
        this.ignoreMargin = ignoreMargin;
    }
}

