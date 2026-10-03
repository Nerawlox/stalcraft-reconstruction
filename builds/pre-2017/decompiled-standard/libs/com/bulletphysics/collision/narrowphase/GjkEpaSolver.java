/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.narrowphase;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.shapes.ConvexShape;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.QuaternionUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import com.bulletphysics.util.ArrayPool;
import com.bulletphysics.util.ObjectStackList;
import java.util.Arrays;
import javax.vecmath.Matrix3f;
import javax.vecmath.Quat4f;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class GjkEpaSolver {
    protected final ArrayPool<float[]> floatArrays = ArrayPool.get(Float.TYPE);
    protected final ObjectStackList<Mkv> stackMkv = new ObjectStackList<Mkv>(Mkv.class);
    protected final ObjectStackList<He> stackHe = new ObjectStackList<He>(He.class);
    protected final ObjectStackList<Face> stackFace = new ObjectStackList<Face>(Face.class);
    private static final float cstInf = Float.MAX_VALUE;
    private static final float cstPi = (float)Math.PI;
    private static final float cst2Pi = (float)Math.PI * 2;
    private static final int GJK_maxiterations = 128;
    private static final int GJK_hashsize = 64;
    private static final int GJK_hashmask = 63;
    private static final float GJK_insimplex_eps = 1.0E-4f;
    private static final float GJK_sqinsimplex_eps = 9.999999E-9f;
    private static final int EPA_maxiterations = 256;
    private static final float EPA_inface_eps = 0.01f;
    private static final float EPA_accuracy = 0.001f;
    private static int[] mod3 = new int[]{0, 1, 2, 0, 1};
    private static final int[][] tetrahedron_fidx = new int[][]{{2, 1, 0}, {3, 0, 1}, {3, 1, 2}, {3, 2, 0}};
    private static final int[][] tetrahedron_eidx = new int[][]{{0, 0, 2, 1}, {0, 1, 1, 1}, {0, 2, 3, 1}, {1, 0, 3, 2}, {2, 0, 1, 2}, {3, 0, 2, 2}};
    private static final int[][] hexahedron_fidx = new int[][]{{2, 0, 4}, {4, 1, 2}, {1, 4, 0}, {0, 3, 1}, {0, 2, 3}, {1, 3, 2}};
    private static final int[][] hexahedron_eidx = new int[][]{{0, 0, 4, 0}, {0, 1, 2, 1}, {0, 2, 1, 2}, {1, 1, 5, 2}, {1, 0, 2, 0}, {2, 2, 3, 2}, {3, 1, 5, 0}, {3, 0, 4, 2}, {5, 1, 4, 1}};
    private GJK gjk = new GJK();

    protected void pushStack() {
        this.stackMkv.push();
        this.stackHe.push();
        this.stackFace.push();
    }

    protected void popStack() {
        this.stackMkv.pop();
        this.stackHe.pop();
        this.stackFace.pop();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean collide(ConvexShape shape0, Transform wtrs0, ConvexShape shape1, Transform wtrs1, float radialmargin, Results results) {
        results.witnesses[0].set(0.0f, 0.0f, 0.0f);
        results.witnesses[1].set(0.0f, 0.0f, 0.0f);
        results.normal.set(0.0f, 0.0f, 0.0f);
        results.depth = 0.0f;
        results.status = ResultsStatus.Separated;
        results.epa_iterations = 0;
        results.gjk_iterations = 0;
        this.gjk.init(wtrs0.basis, wtrs0.origin, shape0, wtrs1.basis, wtrs1.origin, shape1, radialmargin + 0.001f);
        try {
            boolean collide = this.gjk.SearchOrigin();
            results.gjk_iterations = this.gjk.iterations + 1;
            if (collide) {
                EPA epa = new EPA(this.gjk);
                float pd = epa.EvaluatePD();
                results.epa_iterations = epa.iterations + 1;
                if (pd > 0.0f) {
                    results.status = ResultsStatus.Penetrating;
                    results.normal.set(epa.normal);
                    results.depth = pd;
                    results.witnesses[0].set(epa.nearest[0]);
                    results.witnesses[1].set(epa.nearest[1]);
                    boolean bl = true;
                    return bl;
                }
                if (epa.failed) {
                    results.status = ResultsStatus.EPA_Failed;
                }
            } else if (this.gjk.failed) {
                results.status = ResultsStatus.GJK_Failed;
            }
            boolean bl = false;
            return bl;
        }
        finally {
            this.gjk.destroy();
        }
    }

    protected class EPA {
        public GJK gjk;
        public Face root;
        public int nfaces;
        public int iterations;
        public final Vector3f[][] features = new Vector3f[2][3];
        public final Vector3f[] nearest = new Vector3f[]{new Vector3f(), new Vector3f()};
        public final Vector3f normal = new Vector3f();
        public float depth;
        public boolean failed;

        public EPA(GJK pgjk) {
            for (int i = 0; i < this.features.length; ++i) {
                for (int j = 0; j < this.features[i].length; ++j) {
                    this.features[i][j] = new Vector3f();
                }
            }
            this.gjk = pgjk;
        }

        /*
         * WARNING - void declaration
         */
        public Vector3f GetCoordinates(Face face, Vector3f vector3f) {
            $Stack $Stack = $Stack.get();
            try {
                void out;
                void face2;
                $Stack.push$javax$vecmath$Vector3f();
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
                Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
                Vector3f o = $Stack.get$javax$vecmath$Vector3f();
                o.scale(-face2.d, face2.n);
                float[] a = GjkEpaSolver.this.floatArrays.getFixed(3);
                tmp1.sub(face2.v[0].w, o);
                tmp2.sub(face2.v[1].w, o);
                tmp.cross(tmp1, tmp2);
                a[0] = tmp.length();
                tmp1.sub(face2.v[1].w, o);
                tmp2.sub(face2.v[2].w, o);
                tmp.cross(tmp1, tmp2);
                a[1] = tmp.length();
                tmp1.sub(face2.v[2].w, o);
                tmp2.sub(face2.v[0].w, o);
                tmp.cross(tmp1, tmp2);
                a[2] = tmp.length();
                float sm = a[0] + a[1] + a[2];
                out.set(a[1], a[2], a[0]);
                out.scale(1.0f / (sm > 0.0f ? sm : 1.0f));
                GjkEpaSolver.this.floatArrays.release(a);
                $Stack.pop$javax$vecmath$Vector3f();
                return out;
            }
            catch (Throwable throwable) {
                $Stack.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }

        public Face FindBest() {
            Face bf = null;
            if (this.root != null) {
                Face cf = this.root;
                float bd = Float.MAX_VALUE;
                do {
                    if (!(cf.d < bd)) continue;
                    bd = cf.d;
                    bf = cf;
                } while (null != (cf = cf.next));
            }
            return bf;
        }

        /*
         * WARNING - void declaration
         */
        public boolean Set(Face face, Mkv mkv, Mkv mkv2, Mkv mkv3) {
            $Stack $Stack = $Stack.get();
            try {
                void f;
                void c;
                void a;
                void b;
                $Stack.push$javax$vecmath$Vector3f();
                Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
                Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
                Vector3f tmp3 = $Stack.get$javax$vecmath$Vector3f();
                Vector3f nrm = $Stack.get$javax$vecmath$Vector3f();
                tmp1.sub(b.w, a.w);
                tmp2.sub(c.w, a.w);
                nrm.cross(tmp1, tmp2);
                float len = nrm.length();
                tmp1.cross(a.w, b.w);
                tmp2.cross(b.w, c.w);
                tmp3.cross(c.w, a.w);
                boolean valid = tmp1.dot(nrm) >= -0.01f && tmp2.dot(nrm) >= -0.01f && tmp3.dot(nrm) >= -0.01f;
                f.v[0] = a;
                f.v[1] = b;
                f.v[2] = c;
                f.mark = 0;
                f.n.scale(1.0f / (len > 0.0f ? len : Float.MAX_VALUE), nrm);
                f.d = Math.max(0.0f, -f.n.dot(a.w));
                $Stack.pop$javax$vecmath$Vector3f();
                return valid;
            }
            catch (Throwable throwable) {
                $Stack.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }

        public Face NewFace(Mkv a, Mkv b, Mkv c) {
            Face pf = (Face)GjkEpaSolver.this.stackFace.get();
            if (this.Set(pf, a, b, c)) {
                if (this.root != null) {
                    this.root.prev = pf;
                }
                pf.prev = null;
                pf.next = this.root;
                this.root = pf;
                ++this.nfaces;
            } else {
                pf.next = null;
                pf.prev = null;
            }
            return pf;
        }

        public void Detach(Face face) {
            if (face.prev != null || face.next != null) {
                --this.nfaces;
                if (face == this.root) {
                    this.root = face.next;
                    this.root.prev = null;
                } else if (face.next == null) {
                    face.prev.next = null;
                } else {
                    face.prev.next = face.next;
                    face.next.prev = face.prev;
                }
                face.next = null;
                face.prev = null;
            }
        }

        public void Link(Face f0, int e0, Face f1, int e1) {
            f0.f[e0] = f1;
            f1.e[e1] = e0;
            f1.f[e1] = f0;
            f0.e[e0] = e1;
        }

        public Mkv Support(Vector3f w) {
            Mkv v = (Mkv)GjkEpaSolver.this.stackMkv.get();
            this.gjk.Support(w, v);
            return v;
        }

        public int BuildHorizon(int markid, Mkv w, Face f, int e, Face[] cf, Face[] ff) {
            int ne = 0;
            if (f.mark != markid) {
                int e1 = mod3[e + 1];
                if (f.n.dot(w.w) + f.d > 0.0f) {
                    Face nf = this.NewFace(f.v[e1], f.v[e], w);
                    this.Link(nf, 0, f, e);
                    if (cf[0] != null) {
                        this.Link(cf[0], 1, nf, 2);
                    } else {
                        ff[0] = nf;
                    }
                    cf[0] = nf;
                    ne = 1;
                } else {
                    int e2 = mod3[e + 2];
                    this.Detach(f);
                    f.mark = markid;
                    ne += this.BuildHorizon(markid, w, f.f[e1], f.e[e1], cf, ff);
                    ne += this.BuildHorizon(markid, w, f.f[e2], f.e[e2], cf, ff);
                }
            }
            return ne;
        }

        public float EvaluatePD() {
            return this.EvaluatePD(0.001f);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * WARNING - void declaration
         */
        public float EvaluatePD(float f) {
            $Stack $Stack = $Stack.get();
            try {
                Face bf;
                $Stack.push$javax$vecmath$Vector3f();
                GjkEpaSolver.this.pushStack();
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                Face bestface = null;
                int markid = 1;
                this.depth = -3.4028235E38f;
                this.normal.set(0.0f, 0.0f, 0.0f);
                this.root = null;
                this.nfaces = 0;
                this.iterations = 0;
                this.failed = false;
                if (this.gjk.EncloseOrigin()) {
                    int i;
                    int[][] pfidx_ptr = null;
                    int pfidx_index = 0;
                    int nfidx = 0;
                    int[][] peidx_ptr = null;
                    int peidx_index = 0;
                    int neidx = 0;
                    Mkv[] basemkv = new Mkv[5];
                    Face[] basefaces = new Face[6];
                    switch (this.gjk.order) {
                        case 3: {
                            pfidx_ptr = tetrahedron_fidx;
                            pfidx_index = 0;
                            nfidx = 4;
                            peidx_ptr = tetrahedron_eidx;
                            peidx_index = 0;
                            neidx = 6;
                            break;
                        }
                        case 4: {
                            pfidx_ptr = hexahedron_fidx;
                            pfidx_index = 0;
                            nfidx = 6;
                            peidx_ptr = hexahedron_eidx;
                            peidx_index = 0;
                            neidx = 9;
                        }
                    }
                    for (i = 0; i <= this.gjk.order; ++i) {
                        basemkv[i] = new Mkv();
                        basemkv[i].set(this.gjk.simplex[i]);
                    }
                    i = 0;
                    while (i < nfidx) {
                        basefaces[i] = this.NewFace(basemkv[pfidx_ptr[pfidx_index][0]], basemkv[pfidx_ptr[pfidx_index][1]], basemkv[pfidx_ptr[pfidx_index][2]]);
                        ++i;
                        ++pfidx_index;
                    }
                    i = 0;
                    while (i < neidx) {
                        this.Link(basefaces[peidx_ptr[peidx_index][0]], peidx_ptr[peidx_index][1], basefaces[peidx_ptr[peidx_index][2]], peidx_ptr[peidx_index][3]);
                        ++i;
                        ++peidx_index;
                    }
                }
                if (0 == this.nfaces) {
                    float pfidx_ptr = this.depth;
                    $Stack.pop$javax$vecmath$Vector3f();
                    return pfidx_ptr;
                }
                while (this.iterations < 256 && (bf = this.FindBest()) != null) {
                    void accuracy;
                    tmp.negate(bf.n);
                    Mkv w = this.Support(tmp);
                    float d = bf.n.dot(w.w) + bf.d;
                    bestface = bf;
                    if (!(d < -accuracy)) break;
                    Face[] cf = new Face[]{null};
                    Face[] ff = new Face[]{null};
                    int nf = 0;
                    this.Detach(bf);
                    bf.mark = ++markid;
                    for (int i = 0; i < 3; ++i) {
                        nf += this.BuildHorizon(markid, w, bf.f[i], bf.e[i], cf, ff);
                    }
                    if (nf <= 2) break;
                    this.Link(cf[0], 1, ff[0], 2);
                    ++this.iterations;
                }
                if (bestface != null) {
                    Vector3f b = this.GetCoordinates(bestface, $Stack.get$javax$vecmath$Vector3f());
                    this.normal.set(bestface.n);
                    this.depth = Math.max(0.0f, bestface.d);
                    for (int i = 0; i < 2; ++i) {
                        float s = i != 0 ? -1.0f : 1.0f;
                        for (int j = 0; j < 3; ++j) {
                            tmp.scale(s, bestface.v[j].r);
                            this.gjk.LocalSupport(tmp, i, this.features[i][j]);
                        }
                    }
                    Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
                    Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
                    Vector3f tmp3 = $Stack.get$javax$vecmath$Vector3f();
                    tmp1.scale(b.x, this.features[0][0]);
                    tmp2.scale(b.y, this.features[0][1]);
                    tmp3.scale(b.z, this.features[0][2]);
                    VectorUtil.add(this.nearest[0], tmp1, tmp2, tmp3);
                    tmp1.scale(b.x, this.features[1][0]);
                    tmp2.scale(b.y, this.features[1][1]);
                    tmp3.scale(b.z, this.features[1][2]);
                    VectorUtil.add(this.nearest[1], tmp1, tmp2, tmp3);
                } else {
                    this.failed = true;
                }
                float f2 = this.depth;
                $Stack.pop$javax$vecmath$Vector3f();
                return f2;
                finally {
                    GjkEpaSolver.this.popStack();
                }
            }
            catch (Throwable throwable) {
                $Stack.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }
    }

    public static class Face {
        public final Mkv[] v = new Mkv[3];
        public final Face[] f = new Face[3];
        public final int[] e = new int[3];
        public final Vector3f n = new Vector3f();
        public float d;
        public int mark;
        public Face prev;
        public Face next;
    }

    protected class GJK {
        public final He[] table = new He[64];
        public final Matrix3f[] wrotations = new Matrix3f[]{new Matrix3f(), new Matrix3f()};
        public final Vector3f[] positions = new Vector3f[]{new Vector3f(), new Vector3f()};
        public final ConvexShape[] shapes = new ConvexShape[2];
        public final Mkv[] simplex = new Mkv[5];
        public final Vector3f ray = new Vector3f();
        public int order;
        public int iterations;
        public float margin;
        public boolean failed;

        public GJK() {
            for (int i = 0; i < this.simplex.length; ++i) {
                this.simplex[i] = new Mkv();
            }
        }

        public GJK(Matrix3f wrot0, Vector3f pos0, ConvexShape shape0, Matrix3f wrot1, Vector3f pos1, ConvexShape shape1) {
            this(wrot0, pos0, shape0, wrot1, pos1, shape1, 0.0f);
        }

        public GJK(Matrix3f wrot0, Vector3f pos0, ConvexShape shape0, Matrix3f wrot1, Vector3f pos1, ConvexShape shape1, float pmargin) {
            for (int i = 0; i < this.simplex.length; ++i) {
                this.simplex[i] = new Mkv();
            }
            this.init(wrot0, pos0, shape0, wrot1, pos1, shape1, pmargin);
        }

        public void init(Matrix3f wrot0, Vector3f pos0, ConvexShape shape0, Matrix3f wrot1, Vector3f pos1, ConvexShape shape1, float pmargin) {
            GjkEpaSolver.this.pushStack();
            this.wrotations[0].set(wrot0);
            this.positions[0].set(pos0);
            this.shapes[0] = shape0;
            this.wrotations[1].set(wrot1);
            this.positions[1].set(pos1);
            this.shapes[1] = shape1;
            this.margin = pmargin;
            this.failed = false;
        }

        public void destroy() {
            GjkEpaSolver.this.popStack();
        }

        public int Hash(Vector3f v) {
            int h = (int)(v.x * 15461.0f) ^ (int)(v.y * 83003.0f) ^ (int)(v.z * 15473.0f);
            return h * 169639 & 0x3F;
        }

        /*
         * WARNING - void declaration
         */
        public Vector3f LocalSupport(Vector3f vector3f, int n, Vector3f vector3f2) {
            $Stack $Stack = $Stack.get();
            try {
                void out;
                void i;
                void d;
                $Stack.push$javax$vecmath$Vector3f();
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                MatrixUtil.transposeTransform(tmp, (Vector3f)d, this.wrotations[i]);
                this.shapes[i].localGetSupportingVertex(tmp, (Vector3f)out);
                this.wrotations[i].transform((Tuple3f)out);
                out.add(this.positions[i]);
                $Stack.pop$javax$vecmath$Vector3f();
                return out;
            }
            catch (Throwable throwable) {
                $Stack.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }

        /*
         * WARNING - void declaration
         */
        public void Support(Vector3f vector3f, Mkv mkv) {
            $Stack $Stack = $Stack.get();
            try {
                void d;
                void v;
                $Stack.push$javax$vecmath$Vector3f();
                v.r.set((Tuple3f)d);
                Vector3f tmp1 = this.LocalSupport((Vector3f)d, 0, $Stack.get$javax$vecmath$Vector3f());
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                tmp.set((Tuple3f)d);
                tmp.negate();
                Vector3f tmp2 = this.LocalSupport(tmp, 1, $Stack.get$javax$vecmath$Vector3f());
                v.w.sub(tmp1, tmp2);
                v.w.scaleAdd(this.margin, (Tuple3f)d, v.w);
                $Stack.pop$javax$vecmath$Vector3f();
                return;
            }
            catch (Throwable throwable) {
                $Stack.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }

        public boolean FetchSupport() {
            int h = this.Hash(this.ray);
            He e = this.table[h];
            while (e != null) {
                if (e.v.equals(this.ray)) {
                    --this.order;
                    return false;
                }
                e = e.n;
            }
            e = (He)GjkEpaSolver.this.stackHe.get();
            e.v.set(this.ray);
            e.n = this.table[h];
            this.table[h] = e;
            this.Support(this.ray, this.simplex[++this.order]);
            return this.ray.dot(this.simplex[this.order].w) > 0.0f;
        }

        /*
         * WARNING - void declaration
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public boolean SolveSimplex2(Vector3f vector3f, Vector3f vector3f2) {
            $Stack $Stack = $Stack.get();
            try {
                void ao;
                void ab;
                $Stack.push$javax$vecmath$Vector3f();
                if (ab.dot((Vector3f)ao) >= 0.0f) {
                    Vector3f cabo = $Stack.get$javax$vecmath$Vector3f();
                    cabo.cross((Vector3f)ab, (Vector3f)ao);
                    if (!(cabo.lengthSquared() > 9.999999E-9f)) {
                        $Stack.pop$javax$vecmath$Vector3f();
                        return true;
                    }
                    this.ray.cross(cabo, (Vector3f)ab);
                } else {
                    this.order = 0;
                    this.simplex[0].set(this.simplex[1]);
                    this.ray.set((Tuple3f)ao);
                }
                $Stack.pop$javax$vecmath$Vector3f();
                return false;
            }
            catch (Throwable throwable) {
                $Stack.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }

        /*
         * WARNING - void declaration
         */
        public boolean SolveSimplex3(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
            $Stack $Stack = $Stack.get();
            try {
                void ao;
                void ac;
                void ab;
                $Stack.push$javax$vecmath$Vector3f();
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                tmp.cross((Vector3f)ab, (Vector3f)ac);
                boolean bl = this.SolveSimplex3a((Vector3f)ao, (Vector3f)ab, (Vector3f)ac, tmp);
                $Stack.pop$javax$vecmath$Vector3f();
                return bl;
            }
            catch (Throwable throwable) {
                $Stack.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }

        /*
         * WARNING - void declaration
         */
        public boolean SolveSimplex3a(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4) {
            $Stack $Stack = $Stack.get();
            try {
                void ao;
                void ac;
                void ab;
                void cabc;
                $Stack.push$javax$vecmath$Vector3f();
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                tmp.cross((Vector3f)cabc, (Vector3f)ab);
                Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
                tmp2.cross((Vector3f)cabc, (Vector3f)ac);
                if (tmp.dot((Vector3f)ao) < -1.0E-4f) {
                    this.order = 1;
                    this.simplex[0].set(this.simplex[1]);
                    this.simplex[1].set(this.simplex[2]);
                    boolean bl = this.SolveSimplex2((Vector3f)ao, (Vector3f)ab);
                    $Stack.pop$javax$vecmath$Vector3f();
                    return bl;
                }
                if (tmp2.dot((Vector3f)ao) > 1.0E-4f) {
                    this.order = 1;
                    this.simplex[1].set(this.simplex[2]);
                    boolean bl = this.SolveSimplex2((Vector3f)ao, (Vector3f)ac);
                    $Stack.pop$javax$vecmath$Vector3f();
                    return bl;
                }
                float d = cabc.dot((Vector3f)ao);
                if (Math.abs(d) > 1.0E-4f) {
                    if (d > 0.0f) {
                        this.ray.set((Tuple3f)cabc);
                    } else {
                        this.ray.negate((Tuple3f)cabc);
                        Mkv swapTmp = new Mkv();
                        swapTmp.set(this.simplex[0]);
                        this.simplex[0].set(this.simplex[1]);
                        this.simplex[1].set(swapTmp);
                    }
                    $Stack.pop$javax$vecmath$Vector3f();
                    return false;
                }
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
        public boolean SolveSimplex4(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4) {
            $Stack $Stack = $Stack.get();
            try {
                void ao;
                void ad;
                void ac;
                void ab;
                $Stack.push$javax$vecmath$Vector3f();
                Vector3f crs = $Stack.get$javax$vecmath$Vector3f();
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                tmp.cross((Vector3f)ab, (Vector3f)ac);
                Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
                tmp2.cross((Vector3f)ac, (Vector3f)ad);
                Vector3f tmp3 = $Stack.get$javax$vecmath$Vector3f();
                tmp3.cross((Vector3f)ad, (Vector3f)ab);
                if (tmp.dot((Vector3f)ao) > 1.0E-4f) {
                    crs.set(tmp);
                    this.order = 2;
                    this.simplex[0].set(this.simplex[1]);
                    this.simplex[1].set(this.simplex[2]);
                    this.simplex[2].set(this.simplex[3]);
                    boolean bl = this.SolveSimplex3a((Vector3f)ao, (Vector3f)ab, (Vector3f)ac, crs);
                    $Stack.pop$javax$vecmath$Vector3f();
                    return bl;
                }
                if (tmp2.dot((Vector3f)ao) > 1.0E-4f) {
                    crs.set(tmp2);
                    this.order = 2;
                    this.simplex[2].set(this.simplex[3]);
                    boolean bl = this.SolveSimplex3a((Vector3f)ao, (Vector3f)ac, (Vector3f)ad, crs);
                    $Stack.pop$javax$vecmath$Vector3f();
                    return bl;
                }
                if (tmp3.dot((Vector3f)ao) > 1.0E-4f) {
                    crs.set(tmp3);
                    this.order = 2;
                    this.simplex[1].set(this.simplex[0]);
                    this.simplex[0].set(this.simplex[2]);
                    this.simplex[2].set(this.simplex[3]);
                    boolean bl = this.SolveSimplex3a((Vector3f)ao, (Vector3f)ad, (Vector3f)ab, crs);
                    $Stack.pop$javax$vecmath$Vector3f();
                    return bl;
                }
                $Stack.pop$javax$vecmath$Vector3f();
                return true;
            }
            catch (Throwable throwable) {
                $Stack.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }

        public boolean SearchOrigin() {
            $Stack $Stack = $Stack.get();
            try {
                $Stack.push$javax$vecmath$Vector3f();
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                tmp.set(1.0f, 0.0f, 0.0f);
                boolean bl = this.SearchOrigin(tmp);
                $Stack.pop$javax$vecmath$Vector3f();
                return bl;
            }
            catch (Throwable throwable) {
                $Stack.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }

        /*
         * WARNING - void declaration
         */
        public boolean SearchOrigin(Vector3f vector3f) {
            $Stack $Stack = $Stack.get();
            try {
                void initray;
                $Stack.push$javax$vecmath$Vector3f();
                Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
                Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
                Vector3f tmp3 = $Stack.get$javax$vecmath$Vector3f();
                Vector3f tmp4 = $Stack.get$javax$vecmath$Vector3f();
                this.iterations = 0;
                this.order = -1;
                this.failed = false;
                this.ray.set((Tuple3f)initray);
                this.ray.normalize();
                Arrays.fill(this.table, null);
                this.FetchSupport();
                this.ray.negate(this.simplex[0].w);
                while (this.iterations < 128) {
                    float rl = this.ray.length();
                    this.ray.scale(1.0f / (rl > 0.0f ? rl : 1.0f));
                    if (this.FetchSupport()) {
                        boolean found = false;
                        switch (this.order) {
                            case 1: {
                                tmp1.negate(this.simplex[1].w);
                                tmp2.sub(this.simplex[0].w, this.simplex[1].w);
                                found = this.SolveSimplex2(tmp1, tmp2);
                                break;
                            }
                            case 2: {
                                tmp1.negate(this.simplex[2].w);
                                tmp2.sub(this.simplex[1].w, this.simplex[2].w);
                                tmp3.sub(this.simplex[0].w, this.simplex[2].w);
                                found = this.SolveSimplex3(tmp1, tmp2, tmp3);
                                break;
                            }
                            case 3: {
                                tmp1.negate(this.simplex[3].w);
                                tmp2.sub(this.simplex[2].w, this.simplex[3].w);
                                tmp3.sub(this.simplex[1].w, this.simplex[3].w);
                                tmp4.sub(this.simplex[0].w, this.simplex[3].w);
                                found = this.SolveSimplex4(tmp1, tmp2, tmp3, tmp4);
                            }
                        }
                        if (found) {
                            $Stack.pop$javax$vecmath$Vector3f();
                            return true;
                        }
                    } else {
                        $Stack.pop$javax$vecmath$Vector3f();
                        return false;
                    }
                    ++this.iterations;
                }
                this.failed = true;
                $Stack.pop$javax$vecmath$Vector3f();
                return false;
            }
            catch (Throwable throwable) {
                $Stack.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }

        public boolean EncloseOrigin() {
            $Stack $Stack = $Stack.get();
            try {
                $Stack $Stack2 = $Stack;
                $Stack2.push$javax$vecmath$Vector3f();
                $Stack2.push$javax$vecmath$Quat4f();
                $Stack2.push$javax$vecmath$Matrix3f();
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
                Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
                switch (this.order) {
                    case 0: {
                        break;
                    }
                    case 1: {
                        Vector3f ab = $Stack.get$javax$vecmath$Vector3f();
                        ab.sub(this.simplex[1].w, this.simplex[0].w);
                        Vector3f[] b = new Vector3f[]{$Stack.get$javax$vecmath$Vector3f(), $Stack.get$javax$vecmath$Vector3f(), $Stack.get$javax$vecmath$Vector3f()};
                        b[0].set(1.0f, 0.0f, 0.0f);
                        b[1].set(0.0f, 1.0f, 0.0f);
                        b[2].set(0.0f, 0.0f, 1.0f);
                        b[0].cross(ab, b[0]);
                        b[1].cross(ab, b[1]);
                        b[2].cross(ab, b[2]);
                        float[] m = new float[]{b[0].lengthSquared(), b[1].lengthSquared(), b[2].lengthSquared()};
                        Quat4f tmpQuat = $Stack.get$javax$vecmath$Quat4f();
                        tmp.normalize(ab);
                        QuaternionUtil.setRotation(tmpQuat, tmp, 2.0943952f);
                        Matrix3f r = $Stack.get$javax$vecmath$Matrix3f();
                        MatrixUtil.setRotation(r, tmpQuat);
                        Vector3f w = $Stack.get$javax$vecmath$Vector3f();
                        w.set(b[m[0] > m[1] ? (m[0] > m[2] ? 0 : 2) : (m[1] > m[2] ? 1 : 2)]);
                        tmp.normalize(w);
                        this.Support(tmp, this.simplex[4]);
                        r.transform(w);
                        tmp.normalize(w);
                        this.Support(tmp, this.simplex[2]);
                        r.transform(w);
                        tmp.normalize(w);
                        this.Support(tmp, this.simplex[3]);
                        r.transform(w);
                        this.order = 4;
                        $Stack $Stack3 = $Stack;
                        $Stack3.pop$javax$vecmath$Vector3f();
                        $Stack3.pop$javax$vecmath$Quat4f();
                        $Stack3.pop$javax$vecmath$Matrix3f();
                        return true;
                    }
                    case 2: {
                        tmp1.sub(this.simplex[1].w, this.simplex[0].w);
                        tmp2.sub(this.simplex[2].w, this.simplex[0].w);
                        Vector3f n = $Stack.get$javax$vecmath$Vector3f();
                        n.cross(tmp1, tmp2);
                        n.normalize();
                        this.Support(n, this.simplex[3]);
                        tmp.negate(n);
                        this.Support(tmp, this.simplex[4]);
                        this.order = 4;
                        $Stack $Stack4 = $Stack;
                        $Stack4.pop$javax$vecmath$Vector3f();
                        $Stack4.pop$javax$vecmath$Quat4f();
                        $Stack4.pop$javax$vecmath$Matrix3f();
                        return true;
                    }
                    case 3: {
                        $Stack $Stack5 = $Stack;
                        $Stack5.pop$javax$vecmath$Vector3f();
                        $Stack5.pop$javax$vecmath$Quat4f();
                        $Stack5.pop$javax$vecmath$Matrix3f();
                        return true;
                    }
                    case 4: {
                        $Stack $Stack6 = $Stack;
                        $Stack6.pop$javax$vecmath$Vector3f();
                        $Stack6.pop$javax$vecmath$Quat4f();
                        $Stack6.pop$javax$vecmath$Matrix3f();
                        return true;
                    }
                }
                $Stack $Stack7 = $Stack;
                $Stack7.pop$javax$vecmath$Vector3f();
                $Stack7.pop$javax$vecmath$Quat4f();
                $Stack7.pop$javax$vecmath$Matrix3f();
                return false;
            }
            catch (Throwable throwable) {
                $Stack $Stack8 = $Stack;
                $Stack8.pop$javax$vecmath$Vector3f();
                $Stack8.pop$javax$vecmath$Quat4f();
                $Stack8.pop$javax$vecmath$Matrix3f();
                throw throwable;
            }
        }
    }

    public static class He {
        public final Vector3f v = new Vector3f();
        public He n;
    }

    public static class Mkv {
        public final Vector3f w = new Vector3f();
        public final Vector3f r = new Vector3f();

        public void set(Mkv m) {
            this.w.set(m.w);
            this.r.set(m.r);
        }
    }

    public static class Results {
        public ResultsStatus status;
        public final Vector3f[] witnesses = new Vector3f[]{new Vector3f(), new Vector3f()};
        public final Vector3f normal = new Vector3f();
        public float depth;
        public int epa_iterations;
        public int gjk_iterations;
    }

    public static enum ResultsStatus {
        Separated,
        Penetrating,
        GJK_Failed,
        EPA_Failed;

    }
}

