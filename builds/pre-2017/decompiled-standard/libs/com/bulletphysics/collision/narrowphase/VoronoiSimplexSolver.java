/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.narrowphase;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.narrowphase.SimplexSolverInterface;
import com.bulletphysics.linearmath.VectorUtil;
import com.bulletphysics.util.ObjectPool;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class VoronoiSimplexSolver
extends SimplexSolverInterface {
    protected final ObjectPool<SubSimplexClosestResult> subsimplexResultsPool = ObjectPool.get(SubSimplexClosestResult.class);
    private static final int VORONOI_SIMPLEX_MAX_VERTS = 5;
    private static final int VERTA = 0;
    private static final int VERTB = 1;
    private static final int VERTC = 2;
    private static final int VERTD = 3;
    public int numVertices;
    public final Vector3f[] simplexVectorW = new Vector3f[5];
    public final Vector3f[] simplexPointsP = new Vector3f[5];
    public final Vector3f[] simplexPointsQ = new Vector3f[5];
    public final Vector3f cachedP1 = new Vector3f();
    public final Vector3f cachedP2 = new Vector3f();
    public final Vector3f cachedV = new Vector3f();
    public final Vector3f lastW = new Vector3f();
    public boolean cachedValidClosest;
    public final SubSimplexClosestResult cachedBC = new SubSimplexClosestResult();
    public boolean needsUpdate;

    public VoronoiSimplexSolver() {
        for (int i = 0; i < 5; ++i) {
            this.simplexVectorW[i] = new Vector3f();
            this.simplexPointsP[i] = new Vector3f();
            this.simplexPointsQ[i] = new Vector3f();
        }
    }

    public void removeVertex(int index) {
        assert (this.numVertices > 0);
        --this.numVertices;
        this.simplexVectorW[index].set(this.simplexVectorW[this.numVertices]);
        this.simplexPointsP[index].set(this.simplexPointsP[this.numVertices]);
        this.simplexPointsQ[index].set(this.simplexPointsQ[this.numVertices]);
    }

    public void reduceVertices(UsageBitfield usedVerts) {
        if (this.numVertices() >= 4 && !usedVerts.usedVertexD) {
            this.removeVertex(3);
        }
        if (this.numVertices() >= 3 && !usedVerts.usedVertexC) {
            this.removeVertex(2);
        }
        if (this.numVertices() >= 2 && !usedVerts.usedVertexB) {
            this.removeVertex(1);
        }
        if (this.numVertices() >= 1 && !usedVerts.usedVertexA) {
            this.removeVertex(0);
        }
    }

    public boolean updateClosestVectorAndPoints() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Vector3f();
            if (this.needsUpdate) {
                this.cachedBC.reset();
                this.needsUpdate = false;
                switch (this.numVertices()) {
                    case 0: {
                        this.cachedValidClosest = false;
                        break;
                    }
                    case 1: {
                        this.cachedP1.set(this.simplexPointsP[0]);
                        this.cachedP2.set(this.simplexPointsQ[0]);
                        this.cachedV.sub(this.cachedP1, this.cachedP2);
                        this.cachedBC.reset();
                        this.cachedBC.setBarycentricCoordinates(1.0f, 0.0f, 0.0f, 0.0f);
                        this.cachedValidClosest = this.cachedBC.isValid();
                        break;
                    }
                    case 2: {
                        Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                        Vector3f from = this.simplexVectorW[0];
                        Vector3f to = this.simplexVectorW[1];
                        Vector3f nearest = $Stack.get$javax$vecmath$Vector3f();
                        Vector3f p = $Stack.get$javax$vecmath$Vector3f();
                        p.set(0.0f, 0.0f, 0.0f);
                        Vector3f diff = $Stack.get$javax$vecmath$Vector3f();
                        diff.sub(p, from);
                        Vector3f v = $Stack.get$javax$vecmath$Vector3f();
                        v.sub(to, from);
                        float t = v.dot(diff);
                        if (t > 0.0f) {
                            float dotVV = v.dot(v);
                            if (t < dotVV) {
                                tmp.scale(t /= dotVV, v);
                                diff.sub(tmp);
                                this.cachedBC.usedVertices.usedVertexA = true;
                                this.cachedBC.usedVertices.usedVertexB = true;
                            } else {
                                t = 1.0f;
                                diff.sub(v);
                                this.cachedBC.usedVertices.usedVertexB = true;
                            }
                        } else {
                            t = 0.0f;
                            this.cachedBC.usedVertices.usedVertexA = true;
                        }
                        this.cachedBC.setBarycentricCoordinates(1.0f - t, t, 0.0f, 0.0f);
                        tmp.scale(t, v);
                        nearest.add(from, tmp);
                        tmp.sub(this.simplexPointsP[1], this.simplexPointsP[0]);
                        tmp.scale(t);
                        this.cachedP1.add(this.simplexPointsP[0], tmp);
                        tmp.sub(this.simplexPointsQ[1], this.simplexPointsQ[0]);
                        tmp.scale(t);
                        this.cachedP2.add(this.simplexPointsQ[0], tmp);
                        this.cachedV.sub(this.cachedP1, this.cachedP2);
                        this.reduceVertices(this.cachedBC.usedVertices);
                        this.cachedValidClosest = this.cachedBC.isValid();
                        break;
                    }
                    case 3: {
                        Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
                        Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
                        Vector3f tmp3 = $Stack.get$javax$vecmath$Vector3f();
                        Vector3f p = $Stack.get$javax$vecmath$Vector3f();
                        p.set(0.0f, 0.0f, 0.0f);
                        Vector3f a = this.simplexVectorW[0];
                        Vector3f b = this.simplexVectorW[1];
                        Vector3f c = this.simplexVectorW[2];
                        this.closestPtPointTriangle(p, a, b, c, this.cachedBC);
                        tmp1.scale(this.cachedBC.barycentricCoords[0], this.simplexPointsP[0]);
                        tmp2.scale(this.cachedBC.barycentricCoords[1], this.simplexPointsP[1]);
                        tmp3.scale(this.cachedBC.barycentricCoords[2], this.simplexPointsP[2]);
                        VectorUtil.add(this.cachedP1, tmp1, tmp2, tmp3);
                        tmp1.scale(this.cachedBC.barycentricCoords[0], this.simplexPointsQ[0]);
                        tmp2.scale(this.cachedBC.barycentricCoords[1], this.simplexPointsQ[1]);
                        tmp3.scale(this.cachedBC.barycentricCoords[2], this.simplexPointsQ[2]);
                        VectorUtil.add(this.cachedP2, tmp1, tmp2, tmp3);
                        this.cachedV.sub(this.cachedP1, this.cachedP2);
                        this.reduceVertices(this.cachedBC.usedVertices);
                        this.cachedValidClosest = this.cachedBC.isValid();
                        break;
                    }
                    case 4: {
                        Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
                        Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
                        Vector3f tmp3 = $Stack.get$javax$vecmath$Vector3f();
                        Vector3f tmp4 = $Stack.get$javax$vecmath$Vector3f();
                        Vector3f p = $Stack.get$javax$vecmath$Vector3f();
                        p.set(0.0f, 0.0f, 0.0f);
                        Vector3f a = this.simplexVectorW[0];
                        Vector3f b = this.simplexVectorW[1];
                        Vector3f c = this.simplexVectorW[2];
                        Vector3f d = this.simplexVectorW[3];
                        boolean hasSeperation = this.closestPtPointTetrahedron(p, a, b, c, d, this.cachedBC);
                        if (!hasSeperation) {
                            if (this.cachedBC.degenerate) {
                                this.cachedValidClosest = false;
                                break;
                            }
                            this.cachedValidClosest = true;
                            this.cachedV.set(0.0f, 0.0f, 0.0f);
                            break;
                        }
                        tmp1.scale(this.cachedBC.barycentricCoords[0], this.simplexPointsP[0]);
                        tmp2.scale(this.cachedBC.barycentricCoords[1], this.simplexPointsP[1]);
                        tmp3.scale(this.cachedBC.barycentricCoords[2], this.simplexPointsP[2]);
                        tmp4.scale(this.cachedBC.barycentricCoords[3], this.simplexPointsP[3]);
                        VectorUtil.add(this.cachedP1, tmp1, tmp2, tmp3, tmp4);
                        tmp1.scale(this.cachedBC.barycentricCoords[0], this.simplexPointsQ[0]);
                        tmp2.scale(this.cachedBC.barycentricCoords[1], this.simplexPointsQ[1]);
                        tmp3.scale(this.cachedBC.barycentricCoords[2], this.simplexPointsQ[2]);
                        tmp4.scale(this.cachedBC.barycentricCoords[3], this.simplexPointsQ[3]);
                        VectorUtil.add(this.cachedP2, tmp1, tmp2, tmp3, tmp4);
                        this.cachedV.sub(this.cachedP1, this.cachedP2);
                        this.reduceVertices(this.cachedBC.usedVertices);
                        this.cachedValidClosest = this.cachedBC.isValid();
                        break;
                    }
                    default: {
                        this.cachedValidClosest = false;
                    }
                }
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return this.cachedValidClosest;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public boolean closestPtPointTriangle(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4, SubSimplexClosestResult subSimplexClosestResult) {
        $Stack $Stack = $Stack.get();
        try {
            void p;
            void c;
            void a;
            void b;
            void result2;
            $Stack.push$javax$vecmath$Vector3f();
            result2.usedVertices.reset();
            Vector3f ab = $Stack.get$javax$vecmath$Vector3f();
            ab.sub((Tuple3f)b, (Tuple3f)a);
            Vector3f ac = $Stack.get$javax$vecmath$Vector3f();
            ac.sub((Tuple3f)c, (Tuple3f)a);
            Vector3f ap = $Stack.get$javax$vecmath$Vector3f();
            ap.sub((Tuple3f)p, (Tuple3f)a);
            float d1 = ab.dot(ap);
            float d2 = ac.dot(ap);
            if (d1 <= 0.0f && d2 <= 0.0f) {
                result2.closestPointOnSimplex.set((Tuple3f)a);
                result2.usedVertices.usedVertexA = true;
                result2.setBarycentricCoordinates(1.0f, 0.0f, 0.0f, 0.0f);
                $Stack.pop$javax$vecmath$Vector3f();
                return true;
            }
            Vector3f bp = $Stack.get$javax$vecmath$Vector3f();
            bp.sub((Tuple3f)p, (Tuple3f)b);
            float d3 = ab.dot(bp);
            float d4 = ac.dot(bp);
            if (d3 >= 0.0f && d4 <= d3) {
                result2.closestPointOnSimplex.set((Tuple3f)b);
                result2.usedVertices.usedVertexB = true;
                result2.setBarycentricCoordinates(0.0f, 1.0f, 0.0f, 0.0f);
                $Stack.pop$javax$vecmath$Vector3f();
                return true;
            }
            float vc = d1 * d4 - d3 * d2;
            if (vc <= 0.0f && d1 >= 0.0f && d3 <= 0.0f) {
                float v = d1 / (d1 - d3);
                result2.closestPointOnSimplex.scaleAdd(v, ab, (Tuple3f)a);
                result2.usedVertices.usedVertexA = true;
                result2.usedVertices.usedVertexB = true;
                result2.setBarycentricCoordinates(1.0f - v, v, 0.0f, 0.0f);
                $Stack.pop$javax$vecmath$Vector3f();
                return true;
            }
            Vector3f cp = $Stack.get$javax$vecmath$Vector3f();
            cp.sub((Tuple3f)p, (Tuple3f)c);
            float d5 = ab.dot(cp);
            float d6 = ac.dot(cp);
            if (d6 >= 0.0f && d5 <= d6) {
                result2.closestPointOnSimplex.set((Tuple3f)c);
                result2.usedVertices.usedVertexC = true;
                result2.setBarycentricCoordinates(0.0f, 0.0f, 1.0f, 0.0f);
                $Stack.pop$javax$vecmath$Vector3f();
                return true;
            }
            float vb = d5 * d2 - d1 * d6;
            if (vb <= 0.0f && d2 >= 0.0f && d6 <= 0.0f) {
                float w = d2 / (d2 - d6);
                result2.closestPointOnSimplex.scaleAdd(w, ac, (Tuple3f)a);
                result2.usedVertices.usedVertexA = true;
                result2.usedVertices.usedVertexC = true;
                result2.setBarycentricCoordinates(1.0f - w, 0.0f, w, 0.0f);
                $Stack.pop$javax$vecmath$Vector3f();
                return true;
            }
            float va = d3 * d6 - d5 * d4;
            if (va <= 0.0f && d4 - d3 >= 0.0f && d5 - d6 >= 0.0f) {
                float w = (d4 - d3) / (d4 - d3 + (d5 - d6));
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                tmp.sub((Tuple3f)c, (Tuple3f)b);
                result2.closestPointOnSimplex.scaleAdd(w, tmp, (Tuple3f)b);
                result2.usedVertices.usedVertexB = true;
                result2.usedVertices.usedVertexC = true;
                result2.setBarycentricCoordinates(0.0f, 1.0f - w, w, 0.0f);
                $Stack.pop$javax$vecmath$Vector3f();
                return true;
            }
            float denom = 1.0f / (va + vb + vc);
            float v = vb * denom;
            float w = vc * denom;
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            tmp1.scale(v, ab);
            tmp2.scale(w, ac);
            VectorUtil.add(result2.closestPointOnSimplex, (Vector3f)a, tmp1, tmp2);
            result2.usedVertices.usedVertexA = true;
            result2.usedVertices.usedVertexB = true;
            result2.usedVertices.usedVertexC = true;
            result2.setBarycentricCoordinates(1.0f - v - w, v, w, 0.0f);
            $Stack.pop$javax$vecmath$Vector3f();
            return true;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public static int pointOutsideOfPlane(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4, Vector3f vector3f5) {
        $Stack $Stack = $Stack.get();
        try {
            void d;
            Vector3f p;
            void c;
            void a;
            void b;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f normal = $Stack.get$javax$vecmath$Vector3f();
            normal.sub((Tuple3f)b, (Tuple3f)a);
            tmp.sub((Tuple3f)c, (Tuple3f)a);
            normal.cross(normal, tmp);
            tmp.sub(p, (Tuple3f)a);
            float signp = tmp.dot(normal);
            tmp.sub((Tuple3f)d, (Tuple3f)a);
            float signd = tmp.dot(normal);
            if (signd * signd < 9.999999E-9f) {
                $Stack.pop$javax$vecmath$Vector3f();
                return -1;
            }
            int n = signp * signd < 0.0f ? 1 : 0;
            $Stack.pop$javax$vecmath$Vector3f();
            return n;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean closestPtPointTetrahedron(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4, Vector3f vector3f5, SubSimplexClosestResult subSimplexClosestResult) {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Vector3f();
            SubSimplexClosestResult tempResult = this.subsimplexResultsPool.get();
            tempResult.reset();
            try {
                float sqDist;
                void d;
                void c;
                void b;
                void a;
                void p;
                void finalResult;
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                Vector3f q = $Stack.get$javax$vecmath$Vector3f();
                finalResult.closestPointOnSimplex.set((Tuple3f)p);
                finalResult.usedVertices.reset();
                finalResult.usedVertices.usedVertexA = true;
                finalResult.usedVertices.usedVertexB = true;
                finalResult.usedVertices.usedVertexC = true;
                finalResult.usedVertices.usedVertexD = true;
                int pointOutsideABC = VoronoiSimplexSolver.pointOutsideOfPlane((Vector3f)p, (Vector3f)a, (Vector3f)b, (Vector3f)c, (Vector3f)d);
                int pointOutsideACD = VoronoiSimplexSolver.pointOutsideOfPlane((Vector3f)p, (Vector3f)a, (Vector3f)c, (Vector3f)d, (Vector3f)b);
                int pointOutsideADB = VoronoiSimplexSolver.pointOutsideOfPlane((Vector3f)p, (Vector3f)a, (Vector3f)d, (Vector3f)b, (Vector3f)c);
                int pointOutsideBDC = VoronoiSimplexSolver.pointOutsideOfPlane((Vector3f)p, (Vector3f)b, (Vector3f)d, (Vector3f)c, (Vector3f)a);
                if (pointOutsideABC < 0 || pointOutsideACD < 0 || pointOutsideADB < 0 || pointOutsideBDC < 0) {
                    finalResult.degenerate = true;
                    boolean bl = false;
                    $Stack.pop$javax$vecmath$Vector3f();
                    return bl;
                }
                if (pointOutsideABC == 0 && pointOutsideACD == 0 && pointOutsideADB == 0 && pointOutsideBDC == 0) {
                    boolean bl = false;
                    $Stack.pop$javax$vecmath$Vector3f();
                    return bl;
                }
                float bestSqDist = Float.MAX_VALUE;
                if (pointOutsideABC != 0) {
                    this.closestPtPointTriangle((Vector3f)p, (Vector3f)a, (Vector3f)b, (Vector3f)c, tempResult);
                    q.set(tempResult.closestPointOnSimplex);
                    tmp.sub(q, (Tuple3f)p);
                    sqDist = tmp.dot(tmp);
                    if (sqDist < bestSqDist) {
                        bestSqDist = sqDist;
                        finalResult.closestPointOnSimplex.set(q);
                        finalResult.usedVertices.reset();
                        finalResult.usedVertices.usedVertexA = tempResult.usedVertices.usedVertexA;
                        finalResult.usedVertices.usedVertexB = tempResult.usedVertices.usedVertexB;
                        finalResult.usedVertices.usedVertexC = tempResult.usedVertices.usedVertexC;
                        finalResult.setBarycentricCoordinates(tempResult.barycentricCoords[0], tempResult.barycentricCoords[1], tempResult.barycentricCoords[2], 0.0f);
                    }
                }
                if (pointOutsideACD != 0) {
                    this.closestPtPointTriangle((Vector3f)p, (Vector3f)a, (Vector3f)c, (Vector3f)d, tempResult);
                    q.set(tempResult.closestPointOnSimplex);
                    tmp.sub(q, (Tuple3f)p);
                    sqDist = tmp.dot(tmp);
                    if (sqDist < bestSqDist) {
                        bestSqDist = sqDist;
                        finalResult.closestPointOnSimplex.set(q);
                        finalResult.usedVertices.reset();
                        finalResult.usedVertices.usedVertexA = tempResult.usedVertices.usedVertexA;
                        finalResult.usedVertices.usedVertexC = tempResult.usedVertices.usedVertexB;
                        finalResult.usedVertices.usedVertexD = tempResult.usedVertices.usedVertexC;
                        finalResult.setBarycentricCoordinates(tempResult.barycentricCoords[0], 0.0f, tempResult.barycentricCoords[1], tempResult.barycentricCoords[2]);
                    }
                }
                if (pointOutsideADB != 0) {
                    this.closestPtPointTriangle((Vector3f)p, (Vector3f)a, (Vector3f)d, (Vector3f)b, tempResult);
                    q.set(tempResult.closestPointOnSimplex);
                    tmp.sub(q, (Tuple3f)p);
                    sqDist = tmp.dot(tmp);
                    if (sqDist < bestSqDist) {
                        bestSqDist = sqDist;
                        finalResult.closestPointOnSimplex.set(q);
                        finalResult.usedVertices.reset();
                        finalResult.usedVertices.usedVertexA = tempResult.usedVertices.usedVertexA;
                        finalResult.usedVertices.usedVertexB = tempResult.usedVertices.usedVertexC;
                        finalResult.usedVertices.usedVertexD = tempResult.usedVertices.usedVertexB;
                        finalResult.setBarycentricCoordinates(tempResult.barycentricCoords[0], tempResult.barycentricCoords[2], 0.0f, tempResult.barycentricCoords[1]);
                    }
                }
                if (pointOutsideBDC != 0) {
                    this.closestPtPointTriangle((Vector3f)p, (Vector3f)b, (Vector3f)d, (Vector3f)c, tempResult);
                    q.set(tempResult.closestPointOnSimplex);
                    tmp.sub(q, (Tuple3f)p);
                    sqDist = tmp.dot(tmp);
                    if (sqDist < bestSqDist) {
                        bestSqDist = sqDist;
                        finalResult.closestPointOnSimplex.set(q);
                        finalResult.usedVertices.reset();
                        finalResult.usedVertices.usedVertexB = tempResult.usedVertices.usedVertexA;
                        finalResult.usedVertices.usedVertexC = tempResult.usedVertices.usedVertexC;
                        finalResult.usedVertices.usedVertexD = tempResult.usedVertices.usedVertexB;
                        finalResult.setBarycentricCoordinates(0.0f, tempResult.barycentricCoords[0], tempResult.barycentricCoords[2], tempResult.barycentricCoords[1]);
                    }
                }
                if (finalResult.usedVertices.usedVertexA && finalResult.usedVertices.usedVertexB && finalResult.usedVertices.usedVertexC && finalResult.usedVertices.usedVertexD) {
                    boolean bl = true;
                    $Stack.pop$javax$vecmath$Vector3f();
                    return bl;
                }
                boolean bl = true;
                $Stack.pop$javax$vecmath$Vector3f();
                return bl;
            }
            finally {
                this.subsimplexResultsPool.release(tempResult);
            }
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    @Override
    public void reset() {
        this.cachedValidClosest = false;
        this.numVertices = 0;
        this.needsUpdate = true;
        this.lastW.set(1.0E30f, 1.0E30f, 1.0E30f);
        this.cachedBC.reset();
    }

    @Override
    public void addVertex(Vector3f w, Vector3f p, Vector3f q) {
        this.lastW.set(w);
        this.needsUpdate = true;
        this.simplexVectorW[this.numVertices].set(w);
        this.simplexPointsP[this.numVertices].set(p);
        this.simplexPointsQ[this.numVertices].set(q);
        ++this.numVertices;
    }

    @Override
    public boolean closest(Vector3f v) {
        boolean succes = this.updateClosestVectorAndPoints();
        v.set(this.cachedV);
        return succes;
    }

    @Override
    public float maxVertex() {
        int numverts = this.numVertices();
        float maxV = 0.0f;
        for (int i = 0; i < numverts; ++i) {
            float curLen2 = this.simplexVectorW[i].lengthSquared();
            if (!(maxV < curLen2)) continue;
            maxV = curLen2;
        }
        return maxV;
    }

    @Override
    public boolean fullSimplex() {
        return this.numVertices == 4;
    }

    @Override
    public int getSimplex(Vector3f[] pBuf, Vector3f[] qBuf, Vector3f[] yBuf) {
        for (int i = 0; i < this.numVertices(); ++i) {
            yBuf[i].set(this.simplexVectorW[i]);
            pBuf[i].set(this.simplexPointsP[i]);
            qBuf[i].set(this.simplexPointsQ[i]);
        }
        return this.numVertices();
    }

    @Override
    public boolean inSimplex(Vector3f w) {
        boolean found = false;
        int numverts = this.numVertices();
        for (int i = 0; i < numverts; ++i) {
            if (!this.simplexVectorW[i].equals(w)) continue;
            found = true;
        }
        if (w.equals(this.lastW)) {
            return true;
        }
        return found;
    }

    @Override
    public void backup_closest(Vector3f v) {
        v.set(this.cachedV);
    }

    @Override
    public boolean emptySimplex() {
        return this.numVertices() == 0;
    }

    @Override
    public void compute_points(Vector3f p1, Vector3f p2) {
        this.updateClosestVectorAndPoints();
        p1.set(this.cachedP1);
        p2.set(this.cachedP2);
    }

    @Override
    public int numVertices() {
        return this.numVertices;
    }

    public static class SubSimplexClosestResult {
        public final Vector3f closestPointOnSimplex = new Vector3f();
        public final UsageBitfield usedVertices = new UsageBitfield();
        public final float[] barycentricCoords = new float[4];
        public boolean degenerate;

        public void reset() {
            this.degenerate = false;
            this.setBarycentricCoordinates(0.0f, 0.0f, 0.0f, 0.0f);
            this.usedVertices.reset();
        }

        public boolean isValid() {
            boolean valid = this.barycentricCoords[0] >= 0.0f && this.barycentricCoords[1] >= 0.0f && this.barycentricCoords[2] >= 0.0f && this.barycentricCoords[3] >= 0.0f;
            return valid;
        }

        public void setBarycentricCoordinates(float a, float b, float c, float d) {
            this.barycentricCoords[0] = a;
            this.barycentricCoords[1] = b;
            this.barycentricCoords[2] = c;
            this.barycentricCoords[3] = d;
        }
    }

    public static class UsageBitfield {
        public boolean usedVertexA;
        public boolean usedVertexB;
        public boolean usedVertexC;
        public boolean usedVertexD;

        public void reset() {
            this.usedVertexA = false;
            this.usedVertexB = false;
            this.usedVertexC = false;
            this.usedVertexD = false;
        }
    }
}

