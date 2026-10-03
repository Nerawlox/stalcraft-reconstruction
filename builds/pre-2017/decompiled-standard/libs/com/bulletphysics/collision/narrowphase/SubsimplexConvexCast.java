/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.narrowphase;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.narrowphase.ConvexCast;
import com.bulletphysics.collision.narrowphase.SimplexSolverInterface;
import com.bulletphysics.collision.shapes.ConvexShape;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Vector3f;

public class SubsimplexConvexCast
extends ConvexCast {
    private static final int MAX_ITERATIONS = 32;
    private SimplexSolverInterface simplexSolver;
    private ConvexShape convexA;
    private ConvexShape convexB;

    public SubsimplexConvexCast(ConvexShape shapeA, ConvexShape shapeB, SimplexSolverInterface simplexSolver) {
        this.convexA = shapeA;
        this.convexB = shapeB;
        this.simplexSolver = simplexSolver;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean calcTimeOfImpact(Transform transform, Transform transform2, Transform transform3, Transform transform4, ConvexCast.CastResult castResult) {
        $Stack $Stack = $Stack.get();
        try {
            void result2;
            void fromB;
            void toB;
            void fromA;
            void toA;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            this.simplexSolver.reset();
            Vector3f linVelA = $Stack.get$javax$vecmath$Vector3f();
            Vector3f linVelB = $Stack.get$javax$vecmath$Vector3f();
            linVelA.sub(toA.origin, fromA.origin);
            linVelB.sub(toB.origin, fromB.origin);
            float lambda2 = 0.0f;
            Transform interpolatedTransA = $Stack.get$com$bulletphysics$linearmath$Transform((Transform)fromA);
            Transform interpolatedTransB = $Stack.get$com$bulletphysics$linearmath$Transform((Transform)fromB);
            Vector3f r = $Stack.get$javax$vecmath$Vector3f();
            r.sub(linVelA, linVelB);
            Vector3f v = $Stack.get$javax$vecmath$Vector3f();
            tmp.negate(r);
            MatrixUtil.transposeTransform(tmp, tmp, fromA.basis);
            Vector3f supVertexA = this.convexA.localGetSupportingVertex(tmp, $Stack.get$javax$vecmath$Vector3f());
            fromA.transform(supVertexA);
            MatrixUtil.transposeTransform(tmp, r, fromB.basis);
            Vector3f supVertexB = this.convexB.localGetSupportingVertex(tmp, $Stack.get$javax$vecmath$Vector3f());
            fromB.transform(supVertexB);
            v.sub(supVertexA, supVertexB);
            int maxIter = 32;
            Vector3f n = $Stack.get$javax$vecmath$Vector3f();
            n.set(0.0f, 0.0f, 0.0f);
            boolean hasResult = false;
            Vector3f c = $Stack.get$javax$vecmath$Vector3f();
            float lastLambda = lambda2;
            float dist2 = v.lengthSquared();
            float epsilon = 1.0E-4f;
            Vector3f w = $Stack.get$javax$vecmath$Vector3f();
            Vector3f p = $Stack.get$javax$vecmath$Vector3f();
            while (dist2 > epsilon && maxIter-- != 0) {
                tmp.negate(v);
                MatrixUtil.transposeTransform(tmp, tmp, interpolatedTransA.basis);
                this.convexA.localGetSupportingVertex(tmp, supVertexA);
                interpolatedTransA.transform(supVertexA);
                MatrixUtil.transposeTransform(tmp, v, interpolatedTransB.basis);
                this.convexB.localGetSupportingVertex(tmp, supVertexB);
                interpolatedTransB.transform(supVertexB);
                w.sub(supVertexA, supVertexB);
                float VdotW = v.dot(w);
                if (lambda2 > 1.0f) {
                    $Stack $Stack3 = $Stack;
                    $Stack3.pop$com$bulletphysics$linearmath$Transform();
                    $Stack3.pop$javax$vecmath$Vector3f();
                    return false;
                }
                if (VdotW > 0.0f) {
                    float VdotR = v.dot(r);
                    if (VdotR >= -1.4210855E-14f) {
                        $Stack $Stack4 = $Stack;
                        $Stack4.pop$com$bulletphysics$linearmath$Transform();
                        $Stack4.pop$javax$vecmath$Vector3f();
                        return false;
                    }
                    VectorUtil.setInterpolate3(interpolatedTransA.origin, fromA.origin, toA.origin, lambda2 -= VdotW / VdotR);
                    VectorUtil.setInterpolate3(interpolatedTransB.origin, fromB.origin, toB.origin, lambda2);
                    w.sub(supVertexA, supVertexB);
                    lastLambda = lambda2;
                    n.set(v);
                    hasResult = true;
                }
                this.simplexSolver.addVertex(w, supVertexA, supVertexB);
                if (this.simplexSolver.closest(v)) {
                    dist2 = v.lengthSquared();
                    hasResult = true;
                    continue;
                }
                dist2 = 0.0f;
            }
            result2.fraction = lambda2;
            if (n.lengthSquared() >= 1.4210855E-14f) {
                result2.normal.normalize(n);
            } else {
                result2.normal.set(0.0f, 0.0f, 0.0f);
            }
            if (result2.normal.dot(r) >= -result2.allowedPenetration) {
                $Stack $Stack5 = $Stack;
                $Stack5.pop$com$bulletphysics$linearmath$Transform();
                $Stack5.pop$javax$vecmath$Vector3f();
                return false;
            }
            Vector3f hitA = $Stack.get$javax$vecmath$Vector3f();
            Vector3f hitB = $Stack.get$javax$vecmath$Vector3f();
            this.simplexSolver.compute_points(hitA, hitB);
            result2.hitPoint.set(hitB);
            $Stack $Stack6 = $Stack;
            $Stack6.pop$com$bulletphysics$linearmath$Transform();
            $Stack6.pop$javax$vecmath$Vector3f();
            return true;
        }
        catch (Throwable throwable) {
            $Stack $Stack7 = $Stack;
            $Stack7.pop$com$bulletphysics$linearmath$Transform();
            $Stack7.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }
}

