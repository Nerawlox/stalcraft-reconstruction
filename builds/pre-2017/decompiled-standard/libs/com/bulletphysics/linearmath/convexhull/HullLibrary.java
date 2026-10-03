/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath.convexhull;

import com.bulletphysics.$Stack;
import com.bulletphysics.linearmath.MiscUtil;
import com.bulletphysics.linearmath.VectorUtil;
import com.bulletphysics.linearmath.convexhull.HullDesc;
import com.bulletphysics.linearmath.convexhull.HullFlags;
import com.bulletphysics.linearmath.convexhull.HullResult;
import com.bulletphysics.linearmath.convexhull.Int3;
import com.bulletphysics.linearmath.convexhull.Int4;
import com.bulletphysics.linearmath.convexhull.PHullResult;
import com.bulletphysics.linearmath.convexhull.Tri;
import com.bulletphysics.util.IntArrayList;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class HullLibrary {
    public final IntArrayList vertexIndexMapping = new IntArrayList();
    private ObjectArrayList<Tri> tris = new ObjectArrayList();
    private static final float EPSILON = 1.0E-6f;

    /*
     * WARNING - void declaration
     */
    public boolean createConvexHull(HullDesc hullDesc, HullResult hullResult) {
        $Stack $Stack = $Stack.get();
        try {
            void desc;
            $Stack.push$javax$vecmath$Vector3f();
            boolean ret = false;
            PHullResult hr = new PHullResult();
            int vcount = desc.vcount;
            if (vcount < 8) {
                vcount = 8;
            }
            ObjectArrayList<Vector3f> vertexSource = new ObjectArrayList<Vector3f>();
            MiscUtil.resize(vertexSource, vcount, Vector3f.class);
            Vector3f scale = $Stack.get$javax$vecmath$Vector3f();
            int[] ovcount = new int[1];
            boolean ok = this.cleanupVertices(desc.vcount, desc.vertices, desc.vertexStride, ovcount, vertexSource, desc.normalEpsilon, scale);
            if (ok) {
                for (int i = 0; i < ovcount[0]; ++i) {
                    Vector3f v = vertexSource.getQuick(i);
                    VectorUtil.mul(v, v, scale);
                }
                ok = this.computeHull(ovcount[0], vertexSource, hr, desc.maxVertices);
                if (ok) {
                    void result2;
                    ObjectArrayList<Vector3f> vertexScratch = new ObjectArrayList<Vector3f>();
                    MiscUtil.resize(vertexScratch, hr.vcount, Vector3f.class);
                    this.bringOutYourDead(hr.vertices, hr.vcount, vertexScratch, ovcount, hr.indices, hr.indexCount);
                    ret = true;
                    if (desc.hasHullFlag(HullFlags.TRIANGLES)) {
                        int i;
                        result2.polygons = false;
                        result2.numOutputVertices = ovcount[0];
                        MiscUtil.resize(result2.outputVertices, ovcount[0], Vector3f.class);
                        result2.numFaces = hr.faceCount;
                        result2.numIndices = hr.indexCount;
                        MiscUtil.resize(result2.indices, hr.indexCount, 0);
                        for (i = 0; i < ovcount[0]; ++i) {
                            result2.outputVertices.getQuick(i).set(vertexScratch.getQuick(i));
                        }
                        if (desc.hasHullFlag(HullFlags.REVERSE_ORDER)) {
                            IntArrayList source_ptr = hr.indices;
                            int source_idx = 0;
                            IntArrayList dest_ptr = result2.indices;
                            int dest_idx = 0;
                            for (int i2 = 0; i2 < hr.faceCount; ++i2) {
                                dest_ptr.set(dest_idx + 0, source_ptr.get(source_idx + 2));
                                dest_ptr.set(dest_idx + 1, source_ptr.get(source_idx + 1));
                                dest_ptr.set(dest_idx + 2, source_ptr.get(source_idx + 0));
                                dest_idx += 3;
                                source_idx += 3;
                            }
                        } else {
                            for (i = 0; i < hr.indexCount; ++i) {
                                result2.indices.set(i, hr.indices.get(i));
                            }
                        }
                    } else {
                        result2.polygons = true;
                        result2.numOutputVertices = ovcount[0];
                        MiscUtil.resize(result2.outputVertices, ovcount[0], Vector3f.class);
                        result2.numFaces = hr.faceCount;
                        result2.numIndices = hr.indexCount + hr.faceCount;
                        MiscUtil.resize(result2.indices, result2.numIndices, 0);
                        for (int i = 0; i < ovcount[0]; ++i) {
                            result2.outputVertices.getQuick(i).set(vertexScratch.getQuick(i));
                        }
                        IntArrayList source_ptr = hr.indices;
                        int source_idx = 0;
                        IntArrayList dest_ptr = result2.indices;
                        int dest_idx = 0;
                        for (int i = 0; i < hr.faceCount; ++i) {
                            dest_ptr.set(dest_idx + 0, 3);
                            if (desc.hasHullFlag(HullFlags.REVERSE_ORDER)) {
                                dest_ptr.set(dest_idx + 1, source_ptr.get(source_idx + 2));
                                dest_ptr.set(dest_idx + 2, source_ptr.get(source_idx + 1));
                                dest_ptr.set(dest_idx + 3, source_ptr.get(source_idx + 0));
                            } else {
                                dest_ptr.set(dest_idx + 1, source_ptr.get(source_idx + 0));
                                dest_ptr.set(dest_idx + 2, source_ptr.get(source_idx + 1));
                                dest_ptr.set(dest_idx + 3, source_ptr.get(source_idx + 2));
                            }
                            dest_idx += 4;
                            source_idx += 3;
                        }
                    }
                    HullLibrary.releaseHull(hr);
                }
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return ret;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public boolean releaseResult(HullResult result2) {
        if (result2.outputVertices.size() != 0) {
            result2.numOutputVertices = 0;
            result2.outputVertices.clear();
        }
        if (result2.indices.size() != 0) {
            result2.numIndices = 0;
            result2.indices.clear();
        }
        return true;
    }

    private boolean computeHull(int vcount, ObjectArrayList<Vector3f> vertices, PHullResult result2, int vlimit) {
        int[] tris_count = new int[1];
        int ret = this.calchull(vertices, vcount, result2.indices, tris_count, vlimit);
        if (ret == 0) {
            return false;
        }
        result2.indexCount = tris_count[0] * 3;
        result2.faceCount = tris_count[0];
        result2.vertices = vertices;
        result2.vcount = vcount;
        return true;
    }

    private Tri allocateTriangle(int a, int b, int c) {
        Tri tr = new Tri(a, b, c);
        tr.id = this.tris.size();
        this.tris.add(tr);
        return tr;
    }

    private void deAllocateTriangle(Tri tri) {
        assert (this.tris.getQuick(tri.id) == tri);
        this.tris.setQuick(tri.id, null);
    }

    private void b2bfix(Tri s, Tri t) {
        for (int i = 0; i < 3; ++i) {
            int i1 = (i + 1) % 3;
            int i2 = (i + 2) % 3;
            int a = s.getCoord(i1);
            int b = s.getCoord(i2);
            assert (this.tris.getQuick(s.neib(a, b).get()).neib(b, a).get() == s.id);
            assert (this.tris.getQuick(t.neib(a, b).get()).neib(b, a).get() == t.id);
            this.tris.getQuick(s.neib(a, b).get()).neib(b, a).set(t.neib(b, a).get());
            this.tris.getQuick(t.neib(b, a).get()).neib(a, b).set(s.neib(a, b).get());
        }
    }

    private void removeb2b(Tri s, Tri t) {
        this.b2bfix(s, t);
        this.deAllocateTriangle(s);
        this.deAllocateTriangle(t);
    }

    private void checkit(Tri t) {
        assert (this.tris.getQuick(t.id) == t);
        for (int i = 0; i < 3; ++i) {
            int i1 = (i + 1) % 3;
            int i2 = (i + 2) % 3;
            int a = t.getCoord(i1);
            int b = t.getCoord(i2);
            assert (a != b);
            assert (this.tris.getQuick(t.n.getCoord(i)).neib(b, a).get() == t.id);
        }
    }

    private Tri extrudable(float epsilon) {
        Tri t = null;
        for (int i = 0; i < this.tris.size(); ++i) {
            if (t != null && (this.tris.getQuick(i) == null || !(t.rise < this.tris.getQuick((int)i).rise))) continue;
            t = this.tris.getQuick(i);
        }
        return t.rise > epsilon ? t : null;
    }

    private int calchull(ObjectArrayList<Vector3f> verts, int verts_count, IntArrayList tris_out, int[] tris_count, int vlimit) {
        int i;
        int rc = this.calchullgen(verts, verts_count, vlimit);
        if (rc == 0) {
            return 0;
        }
        IntArrayList ts = new IntArrayList();
        for (i = 0; i < this.tris.size(); ++i) {
            if (this.tris.getQuick(i) == null) continue;
            for (int j = 0; j < 3; ++j) {
                ts.add(this.tris.getQuick(i).getCoord(j));
            }
            this.deAllocateTriangle(this.tris.getQuick(i));
        }
        tris_count[0] = ts.size() / 3;
        MiscUtil.resize(tris_out, ts.size(), 0);
        for (i = 0; i < ts.size(); ++i) {
            tris_out.set(i, ts.get(i));
        }
        MiscUtil.resize(this.tris, 0, Tri.class);
        return 1;
    }

    /*
     * WARNING - void declaration
     */
    private int calchullgen(ObjectArrayList<Vector3f> objectArrayList, int n, int n2) {
        $Stack $Stack = $Stack.get();
        try {
            Tri te;
            void verts;
            int vlimit;
            int verts_count;
            $Stack.push$javax$vecmath$Vector3f();
            if (verts_count < 4) {
                $Stack.pop$javax$vecmath$Vector3f();
                return 0;
            }
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            if (vlimit == 0) {
                vlimit = 1000000000;
            }
            Vector3f bmin = $Stack.get$javax$vecmath$Vector3f((Vector3f)verts.getQuick(0));
            Vector3f bmax = $Stack.get$javax$vecmath$Vector3f((Vector3f)verts.getQuick(0));
            IntArrayList isextreme = new IntArrayList();
            IntArrayList allow = new IntArrayList();
            for (int j = 0; j < verts_count; ++j) {
                allow.add(1);
                isextreme.add(0);
                VectorUtil.setMin(bmin, (Vector3f)verts.getQuick(j));
                VectorUtil.setMax(bmax, (Vector3f)verts.getQuick(j));
            }
            tmp.sub(bmax, bmin);
            float epsilon = tmp.length() * 0.001f;
            assert (epsilon != 0.0f);
            Int4 p = this.findSimplex((ObjectArrayList<Vector3f>)verts, verts_count, allow, new Int4());
            if (p.x == -1) {
                $Stack.pop$javax$vecmath$Vector3f();
                return 0;
            }
            Vector3f center = $Stack.get$javax$vecmath$Vector3f();
            VectorUtil.add(center, (Vector3f)verts.getQuick(p.getCoord(0)), (Vector3f)verts.getQuick(p.getCoord(1)), (Vector3f)verts.getQuick(p.getCoord(2)), (Vector3f)verts.getQuick(p.getCoord(3)));
            center.scale(0.25f);
            Tri t0 = this.allocateTriangle(p.getCoord(2), p.getCoord(3), p.getCoord(1));
            t0.n.set(2, 3, 1);
            Tri t1 = this.allocateTriangle(p.getCoord(3), p.getCoord(2), p.getCoord(0));
            t1.n.set(3, 2, 0);
            Tri t2 = this.allocateTriangle(p.getCoord(0), p.getCoord(1), p.getCoord(3));
            t2.n.set(0, 1, 3);
            Tri t3 = this.allocateTriangle(p.getCoord(1), p.getCoord(0), p.getCoord(2));
            t3.n.set(1, 0, 2);
            isextreme.set(p.getCoord(0), 1);
            isextreme.set(p.getCoord(1), 1);
            isextreme.set(p.getCoord(2), 1);
            isextreme.set(p.getCoord(3), 1);
            this.checkit(t0);
            this.checkit(t1);
            this.checkit(t2);
            this.checkit(t3);
            Vector3f n3 = $Stack.get$javax$vecmath$Vector3f();
            for (int j = 0; j < this.tris.size(); ++j) {
                Tri t = this.tris.getQuick(j);
                assert (t != null);
                assert (t.vmax < 0);
                HullLibrary.triNormal((Vector3f)verts.getQuick(t.getCoord(0)), (Vector3f)verts.getQuick(t.getCoord(1)), (Vector3f)verts.getQuick(t.getCoord(2)), n3);
                t.vmax = HullLibrary.maxdirsterid((ObjectArrayList<Vector3f>)verts, verts_count, n3, allow);
                tmp.sub((Tuple3f)verts.getQuick(t.vmax), (Tuple3f)verts.getQuick(t.getCoord(0)));
                t.rise = n3.dot(tmp);
            }
            vlimit -= 4;
            while (vlimit > 0 && (te = this.extrudable(epsilon)) != null) {
                Int3 t;
                Tri ti = te;
                int v = te.vmax;
                assert (v != -1);
                assert (isextreme.get(v) == 0);
                isextreme.set(v, 1);
                int j = this.tris.size();
                while (j-- != 0) {
                    if (this.tris.getQuick(j) == null || !HullLibrary.above((ObjectArrayList<Vector3f>)verts, t = (Int3)this.tris.getQuick(j), (Vector3f)verts.getQuick(v), 0.01f * epsilon)) continue;
                    this.extrude(this.tris.getQuick(j), v);
                }
                j = this.tris.size();
                while (j-- != 0) {
                    if (this.tris.getQuick(j) == null) continue;
                    if (!HullLibrary.hasvert(this.tris.getQuick(j), v)) break;
                    Int3 nt = this.tris.getQuick(j);
                    tmp1.sub((Tuple3f)verts.getQuick(nt.getCoord(1)), (Tuple3f)verts.getQuick(nt.getCoord(0)));
                    tmp2.sub((Tuple3f)verts.getQuick(nt.getCoord(2)), (Tuple3f)verts.getQuick(nt.getCoord(1)));
                    tmp.cross(tmp1, tmp2);
                    if (!HullLibrary.above((ObjectArrayList<Vector3f>)verts, nt, center, 0.01f * epsilon) && !(tmp.length() < epsilon * epsilon * 0.1f)) continue;
                    Tri nb = this.tris.getQuick(this.tris.getQuick((int)j).n.getCoord(0));
                    assert (nb != null);
                    assert (!HullLibrary.hasvert(nb, v));
                    assert (nb.id < j);
                    this.extrude(nb, v);
                    j = this.tris.size();
                }
                j = this.tris.size();
                while (j-- != 0) {
                    t = this.tris.getQuick(j);
                    if (t == null) continue;
                    if (((Tri)t).vmax >= 0) break;
                    HullLibrary.triNormal((Vector3f)verts.getQuick(t.getCoord(0)), (Vector3f)verts.getQuick(t.getCoord(1)), (Vector3f)verts.getQuick(t.getCoord(2)), n3);
                    ((Tri)t).vmax = HullLibrary.maxdirsterid((ObjectArrayList<Vector3f>)verts, verts_count, n3, allow);
                    if (isextreme.get(((Tri)t).vmax) != 0) {
                        ((Tri)t).vmax = -1;
                        continue;
                    }
                    tmp.sub((Tuple3f)verts.getQuick(((Tri)t).vmax), (Tuple3f)verts.getQuick(t.getCoord(0)));
                    ((Tri)t).rise = n3.dot(tmp);
                }
                --vlimit;
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return 1;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    private Int4 findSimplex(ObjectArrayList<Vector3f> objectArrayList, int n, IntArrayList intArrayList, Int4 int4) {
        $Stack $Stack = $Stack.get();
        try {
            void out;
            void allow;
            void verts_count;
            void verts;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f[] basis = new Vector3f[]{$Stack.get$javax$vecmath$Vector3f(), $Stack.get$javax$vecmath$Vector3f(), $Stack.get$javax$vecmath$Vector3f()};
            basis[0].set(0.01f, 0.02f, 1.0f);
            int p0 = HullLibrary.maxdirsterid((ObjectArrayList<Vector3f>)verts, (int)verts_count, basis[0], (IntArrayList)allow);
            tmp.negate(basis[0]);
            int p1 = HullLibrary.maxdirsterid((ObjectArrayList<Vector3f>)verts, (int)verts_count, tmp, (IntArrayList)allow);
            basis[0].sub((Tuple3f)verts.getQuick(p0), (Tuple3f)verts.getQuick(p1));
            if (p0 == p1 || basis[0].x == 0.0f && basis[0].y == 0.0f && basis[0].z == 0.0f) {
                out.set(-1, -1, -1, -1);
                $Stack.pop$javax$vecmath$Vector3f();
                return out;
            }
            tmp.set(1.0f, 0.02f, 0.0f);
            basis[1].cross(tmp, basis[0]);
            tmp.set(-0.02f, 1.0f, 0.0f);
            basis[2].cross(tmp, basis[0]);
            if (basis[1].length() > basis[2].length()) {
                basis[1].normalize();
            } else {
                basis[1].set(basis[2]);
                basis[1].normalize();
            }
            int p2 = HullLibrary.maxdirsterid((ObjectArrayList<Vector3f>)verts, (int)verts_count, basis[1], (IntArrayList)allow);
            if (p2 == p0 || p2 == p1) {
                tmp.negate(basis[1]);
                p2 = HullLibrary.maxdirsterid((ObjectArrayList<Vector3f>)verts, (int)verts_count, tmp, (IntArrayList)allow);
            }
            if (p2 == p0 || p2 == p1) {
                out.set(-1, -1, -1, -1);
                $Stack.pop$javax$vecmath$Vector3f();
                return out;
            }
            basis[1].sub((Tuple3f)verts.getQuick(p2), (Tuple3f)verts.getQuick(p0));
            basis[2].cross(basis[1], basis[0]);
            basis[2].normalize();
            int p3 = HullLibrary.maxdirsterid((ObjectArrayList<Vector3f>)verts, (int)verts_count, basis[2], (IntArrayList)allow);
            if (p3 == p0 || p3 == p1 || p3 == p2) {
                tmp.negate(basis[2]);
                p3 = HullLibrary.maxdirsterid((ObjectArrayList<Vector3f>)verts, (int)verts_count, tmp, (IntArrayList)allow);
            }
            if (p3 == p0 || p3 == p1 || p3 == p2) {
                out.set(-1, -1, -1, -1);
                $Stack.pop$javax$vecmath$Vector3f();
                return out;
            }
            assert (p0 != p1 && p0 != p2 && p0 != p3 && p1 != p2 && p1 != p3 && p2 != p3);
            tmp1.sub((Tuple3f)verts.getQuick(p1), (Tuple3f)verts.getQuick(p0));
            tmp2.sub((Tuple3f)verts.getQuick(p2), (Tuple3f)verts.getQuick(p0));
            tmp2.cross(tmp1, tmp2);
            tmp1.sub((Tuple3f)verts.getQuick(p3), (Tuple3f)verts.getQuick(p0));
            if (tmp1.dot(tmp2) < 0.0f) {
                int swap_tmp = p2;
                p2 = p3;
                p3 = swap_tmp;
            }
            out.set(p0, p1, p2, p3);
            $Stack.pop$javax$vecmath$Vector3f();
            return out;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    private void extrude(Tri t0, int v) {
        Int3 t = new Int3(t0);
        int n = this.tris.size();
        Tri ta = this.allocateTriangle(v, t.getCoord(1), t.getCoord(2));
        ta.n.set(t0.n.getCoord(0), n + 1, n + 2);
        this.tris.getQuick(t0.n.getCoord(0)).neib(t.getCoord(1), t.getCoord(2)).set(n + 0);
        Tri tb = this.allocateTriangle(v, t.getCoord(2), t.getCoord(0));
        tb.n.set(t0.n.getCoord(1), n + 2, n + 0);
        this.tris.getQuick(t0.n.getCoord(1)).neib(t.getCoord(2), t.getCoord(0)).set(n + 1);
        Tri tc = this.allocateTriangle(v, t.getCoord(0), t.getCoord(1));
        tc.n.set(t0.n.getCoord(2), n + 0, n + 1);
        this.tris.getQuick(t0.n.getCoord(2)).neib(t.getCoord(0), t.getCoord(1)).set(n + 2);
        this.checkit(ta);
        this.checkit(tb);
        this.checkit(tc);
        if (HullLibrary.hasvert(this.tris.getQuick(ta.n.getCoord(0)), v)) {
            this.removeb2b(ta, this.tris.getQuick(ta.n.getCoord(0)));
        }
        if (HullLibrary.hasvert(this.tris.getQuick(tb.n.getCoord(0)), v)) {
            this.removeb2b(tb, this.tris.getQuick(tb.n.getCoord(0)));
        }
        if (HullLibrary.hasvert(this.tris.getQuick(tc.n.getCoord(0)), v)) {
            this.removeb2b(tc, this.tris.getQuick(tc.n.getCoord(0)));
        }
        this.deAllocateTriangle(t0);
    }

    private void bringOutYourDead(ObjectArrayList<Vector3f> verts, int vcount, ObjectArrayList<Vector3f> overts, int[] ocount, IntArrayList indices, int indexcount) {
        IntArrayList tmpIndices = new IntArrayList();
        for (int i = 0; i < this.vertexIndexMapping.size(); ++i) {
            tmpIndices.add(this.vertexIndexMapping.size());
        }
        IntArrayList usedIndices = new IntArrayList();
        MiscUtil.resize(usedIndices, vcount, 0);
        ocount[0] = 0;
        for (int i = 0; i < indexcount; ++i) {
            int v = indices.get(i);
            assert (v >= 0 && v < vcount);
            if (usedIndices.get(v) != 0) {
                indices.set(i, usedIndices.get(v) - 1);
                continue;
            }
            indices.set(i, ocount[0]);
            overts.getQuick(ocount[0]).set(verts.getQuick(v));
            for (int k = 0; k < this.vertexIndexMapping.size(); ++k) {
                if (tmpIndices.get(k) != v) continue;
                this.vertexIndexMapping.set(k, ocount[0]);
            }
            ocount[0] = ocount[0] + 1;
            assert (ocount[0] >= 0 && ocount[0] <= vcount);
            usedIndices.set(v, ocount[0]);
        }
    }

    /*
     * WARNING - void declaration
     */
    private boolean cleanupVertices(int n, ObjectArrayList<Vector3f> objectArrayList, int n2, int[] nArray, ObjectArrayList<Vector3f> objectArrayList2, float f, Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            Vector3f p;
            int i;
            void vertices;
            void vcount;
            void svertices;
            void scale;
            int svcount;
            $Stack.push$javax$vecmath$Vector3f();
            if (svcount == 0) {
                $Stack.pop$javax$vecmath$Vector3f();
                return false;
            }
            this.vertexIndexMapping.clear();
            vcount[0] = false;
            float[] recip = new float[3];
            if (scale != null) {
                scale.set(1.0f, 1.0f, 1.0f);
            }
            float[] bmin = new float[]{Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE};
            float[] bmax = new float[]{-3.4028235E38f, -3.4028235E38f, -3.4028235E38f};
            void vtx_ptr = svertices;
            int vtx_idx = 0;
            for (int i2 = 0; i2 < svcount; ++i2) {
                Vector3f p2 = (Vector3f)vtx_ptr.getQuick(vtx_idx);
                ++vtx_idx;
                for (int j = 0; j < 3; ++j) {
                    if (VectorUtil.getCoord(p2, j) < bmin[j]) {
                        bmin[j] = VectorUtil.getCoord(p2, j);
                    }
                    if (!(VectorUtil.getCoord(p2, j) > bmax[j])) continue;
                    bmax[j] = VectorUtil.getCoord(p2, j);
                }
            }
            float dx = bmax[0] - bmin[0];
            float dy = bmax[1] - bmin[1];
            float dz = bmax[2] - bmin[2];
            Vector3f center = $Stack.get$javax$vecmath$Vector3f();
            center.x = dx * 0.5f + bmin[0];
            center.y = dy * 0.5f + bmin[1];
            center.z = dz * 0.5f + bmin[2];
            if (dx < 1.0E-6f || dy < 1.0E-6f || dz < 1.0E-6f || svcount < 3) {
                float len = Float.MAX_VALUE;
                if (dx > 1.0E-6f && dx < len) {
                    len = dx;
                }
                if (dy > 1.0E-6f && dy < len) {
                    len = dy;
                }
                if (dz > 1.0E-6f && dz < len) {
                    len = dz;
                }
                if (len == Float.MAX_VALUE) {
                    dz = 0.01f;
                    dy = 0.01f;
                    dx = 0.01f;
                } else {
                    if (dx < 1.0E-6f) {
                        dx = len * 0.05f;
                    }
                    if (dy < 1.0E-6f) {
                        dy = len * 0.05f;
                    }
                    if (dz < 1.0E-6f) {
                        dz = len * 0.05f;
                    }
                }
                float x1 = center.x - dx;
                float x2 = center.x + dx;
                float y1 = center.y - dy;
                float y2 = center.y + dy;
                float z1 = center.z - dz;
                float z2 = center.z + dz;
                HullLibrary.addPoint((int[])vcount, (ObjectArrayList<Vector3f>)vertices, x1, y1, z1);
                HullLibrary.addPoint((int[])vcount, (ObjectArrayList<Vector3f>)vertices, x2, y1, z1);
                HullLibrary.addPoint((int[])vcount, (ObjectArrayList<Vector3f>)vertices, x2, y2, z1);
                HullLibrary.addPoint((int[])vcount, (ObjectArrayList<Vector3f>)vertices, x1, y2, z1);
                HullLibrary.addPoint((int[])vcount, (ObjectArrayList<Vector3f>)vertices, x1, y1, z2);
                HullLibrary.addPoint((int[])vcount, (ObjectArrayList<Vector3f>)vertices, x2, y1, z2);
                HullLibrary.addPoint((int[])vcount, (ObjectArrayList<Vector3f>)vertices, x2, y2, z2);
                HullLibrary.addPoint((int[])vcount, (ObjectArrayList<Vector3f>)vertices, x1, y2, z2);
                $Stack.pop$javax$vecmath$Vector3f();
                return true;
            }
            if (scale != null) {
                scale.x = dx;
                scale.y = dy;
                scale.z = dz;
                recip[0] = 1.0f / dx;
                recip[1] = 1.0f / dy;
                recip[2] = 1.0f / dz;
                center.x *= recip[0];
                center.y *= recip[1];
                center.z *= recip[2];
            }
            vtx_ptr = svertices;
            vtx_idx = 0;
            for (i = 0; i < svcount; ++i) {
                int j;
                p = (Vector3f)vtx_ptr.getQuick(vtx_idx);
                ++vtx_idx;
                float px = p.x;
                float py = p.y;
                float pz = p.z;
                if (scale != null) {
                    px *= recip[0];
                    py *= recip[1];
                    pz *= recip[2];
                }
                for (j = 0; j < vcount[0]; ++j) {
                    float dist2;
                    void normalepsilon;
                    Vector3f v = (Vector3f)vertices.getQuick(j);
                    float x = v.x;
                    float y = v.y;
                    float z = v.z;
                    dx = Math.abs(x - px);
                    dy = Math.abs(y - py);
                    dz = Math.abs(z - pz);
                    if (!(dx < normalepsilon) || !(dy < normalepsilon) || !(dz < normalepsilon)) continue;
                    float dist1 = HullLibrary.getDist(px, py, pz, center);
                    if (!(dist1 > (dist2 = HullLibrary.getDist(v.x, v.y, v.z, center)))) break;
                    v.x = px;
                    v.y = py;
                    v.z = pz;
                    break;
                }
                if (j == vcount[0]) {
                    Vector3f dest = (Vector3f)vertices.getQuick((int)vcount[0]);
                    dest.x = px;
                    dest.y = py;
                    dest.z = pz;
                    void v0 = vcount;
                    v0[0] = v0[0] + true;
                }
                this.vertexIndexMapping.add(j);
            }
            bmin = new float[]{Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE};
            bmax = new float[]{-3.4028235E38f, -3.4028235E38f, -3.4028235E38f};
            for (i = 0; i < vcount[0]; ++i) {
                p = (Vector3f)vertices.getQuick(i);
                for (int j = 0; j < 3; ++j) {
                    if (VectorUtil.getCoord(p, j) < bmin[j]) {
                        bmin[j] = VectorUtil.getCoord(p, j);
                    }
                    if (!(VectorUtil.getCoord(p, j) > bmax[j])) continue;
                    bmax[j] = VectorUtil.getCoord(p, j);
                }
            }
            dx = bmax[0] - bmin[0];
            dy = bmax[1] - bmin[1];
            dz = bmax[2] - bmin[2];
            if (dx < 1.0E-6f || dy < 1.0E-6f || dz < 1.0E-6f || vcount[0] < 3) {
                float cx = dx * 0.5f + bmin[0];
                float cy = dy * 0.5f + bmin[1];
                float cz = dz * 0.5f + bmin[2];
                float len = Float.MAX_VALUE;
                if (dx >= 1.0E-6f && dx < len) {
                    len = dx;
                }
                if (dy >= 1.0E-6f && dy < len) {
                    len = dy;
                }
                if (dz >= 1.0E-6f && dz < len) {
                    len = dz;
                }
                if (len == Float.MAX_VALUE) {
                    dz = 0.01f;
                    dy = 0.01f;
                    dx = 0.01f;
                } else {
                    if (dx < 1.0E-6f) {
                        dx = len * 0.05f;
                    }
                    if (dy < 1.0E-6f) {
                        dy = len * 0.05f;
                    }
                    if (dz < 1.0E-6f) {
                        dz = len * 0.05f;
                    }
                }
                float x1 = cx - dx;
                float x2 = cx + dx;
                float y1 = cy - dy;
                float y2 = cy + dy;
                float z1 = cz - dz;
                float z2 = cz + dz;
                vcount[0] = false;
                HullLibrary.addPoint((int[])vcount, (ObjectArrayList<Vector3f>)vertices, x1, y1, z1);
                HullLibrary.addPoint((int[])vcount, (ObjectArrayList<Vector3f>)vertices, x2, y1, z1);
                HullLibrary.addPoint((int[])vcount, (ObjectArrayList<Vector3f>)vertices, x2, y2, z1);
                HullLibrary.addPoint((int[])vcount, (ObjectArrayList<Vector3f>)vertices, x1, y2, z1);
                HullLibrary.addPoint((int[])vcount, (ObjectArrayList<Vector3f>)vertices, x1, y1, z2);
                HullLibrary.addPoint((int[])vcount, (ObjectArrayList<Vector3f>)vertices, x2, y1, z2);
                HullLibrary.addPoint((int[])vcount, (ObjectArrayList<Vector3f>)vertices, x2, y2, z2);
                HullLibrary.addPoint((int[])vcount, (ObjectArrayList<Vector3f>)vertices, x1, y2, z2);
                $Stack.pop$javax$vecmath$Vector3f();
                return true;
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return true;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    private static boolean hasvert(Int3 t, int v) {
        return t.getCoord(0) == v || t.getCoord(1) == v || t.getCoord(2) == v;
    }

    /*
     * WARNING - void declaration
     */
    private static Vector3f orth(Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void out;
            Vector3f v;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f a = $Stack.get$javax$vecmath$Vector3f();
            a.set(0.0f, 0.0f, 1.0f);
            a.cross(v, a);
            Vector3f b = $Stack.get$javax$vecmath$Vector3f();
            b.set(0.0f, 1.0f, 0.0f);
            b.cross(v, b);
            if (a.length() > b.length()) {
                out.normalize(a);
                $Stack.pop$javax$vecmath$Vector3f();
                return out;
            }
            out.normalize(b);
            $Stack.pop$javax$vecmath$Vector3f();
            return out;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    private static int maxdirfiltered(ObjectArrayList<Vector3f> p, int count, Vector3f dir, IntArrayList allow) {
        assert (count != 0);
        int m = -1;
        for (int i = 0; i < count; ++i) {
            if (allow.get(i) == 0 || m != -1 && !(p.getQuick(i).dot(dir) > p.getQuick(m).dot(dir))) continue;
            m = i;
        }
        assert (m != -1);
        return m;
    }

    /*
     * WARNING - void declaration
     */
    private static int maxdirsterid(ObjectArrayList<Vector3f> objectArrayList, int n, Vector3f vector3f, IntArrayList intArrayList) {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f u = $Stack.get$javax$vecmath$Vector3f();
            Vector3f v = $Stack.get$javax$vecmath$Vector3f();
            int m = -1;
            while (m == -1) {
                void allow;
                void dir;
                void count;
                ObjectArrayList<Vector3f> p;
                m = HullLibrary.maxdirfiltered(p, (int)count, (Vector3f)dir, (IntArrayList)allow);
                if (allow.get(m) == 3) {
                    $Stack.pop$javax$vecmath$Vector3f();
                    return m;
                }
                HullLibrary.orth((Vector3f)dir, u);
                v.cross(u, (Vector3f)dir);
                int ma = -1;
                for (float x = 0.0f; x <= 360.0f; x += 45.0f) {
                    float s = (float)Math.sin((float)Math.PI / 180 * x);
                    float c = (float)Math.cos((float)Math.PI / 180 * x);
                    tmp1.scale(s, u);
                    tmp2.scale(c, v);
                    tmp.add(tmp1, tmp2);
                    tmp.scale(0.025f);
                    tmp.add((Tuple3f)dir);
                    int mb = HullLibrary.maxdirfiltered(p, (int)count, tmp, (IntArrayList)allow);
                    if (ma == m && mb == m) {
                        allow.set(m, 3);
                        $Stack.pop$javax$vecmath$Vector3f();
                        return m;
                    }
                    if (ma != -1 && ma != mb) {
                        int mc = ma;
                        for (float xx = x - 40.0f; xx <= x; xx += 5.0f) {
                            s = (float)Math.sin((float)Math.PI / 180 * xx);
                            c = (float)Math.cos((float)Math.PI / 180 * xx);
                            tmp1.scale(s, u);
                            tmp2.scale(c, v);
                            tmp.add(tmp1, tmp2);
                            tmp.scale(0.025f);
                            tmp.add((Tuple3f)dir);
                            int md = HullLibrary.maxdirfiltered(p, (int)count, tmp, (IntArrayList)allow);
                            if (mc == m && md == m) {
                                allow.set(m, 3);
                                $Stack.pop$javax$vecmath$Vector3f();
                                return m;
                            }
                            mc = md;
                        }
                    }
                    ma = mb;
                }
                allow.set(m, 0);
                m = -1;
            }
            assert (false);
            $Stack.pop$javax$vecmath$Vector3f();
            return m;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    private static Vector3f triNormal(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4) {
        $Stack $Stack = $Stack.get();
        try {
            void out;
            void v2;
            Vector3f v0;
            void v1;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            tmp1.sub((Tuple3f)v1, v0);
            tmp2.sub((Tuple3f)v2, (Tuple3f)v1);
            Vector3f cp = $Stack.get$javax$vecmath$Vector3f();
            cp.cross(tmp1, tmp2);
            float m = cp.length();
            if (m == 0.0f) {
                out.set(1.0f, 0.0f, 0.0f);
                $Stack.pop$javax$vecmath$Vector3f();
                return out;
            }
            out.scale(1.0f / m, cp);
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
    private static boolean above(ObjectArrayList<Vector3f> objectArrayList, Int3 int3, Vector3f vector3f, float f) {
        $Stack $Stack = $Stack.get();
        try {
            void epsilon;
            void p;
            void t;
            ObjectArrayList<Vector3f> vertices;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f n = HullLibrary.triNormal(vertices.getQuick(t.getCoord(0)), vertices.getQuick(t.getCoord(1)), vertices.getQuick(t.getCoord(2)), $Stack.get$javax$vecmath$Vector3f());
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            tmp.sub((Tuple3f)p, vertices.getQuick(t.getCoord(0)));
            boolean bl = n.dot(tmp) > epsilon;
            $Stack.pop$javax$vecmath$Vector3f();
            return bl;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    private static void releaseHull(PHullResult result2) {
        if (result2.indices.size() != 0) {
            result2.indices.clear();
        }
        result2.vcount = 0;
        result2.indexCount = 0;
        result2.vertices = null;
    }

    private static void addPoint(int[] vcount, ObjectArrayList<Vector3f> p, float x, float y, float z) {
        Vector3f dest = p.getQuick(vcount[0]);
        dest.x = x;
        dest.y = y;
        dest.z = z;
        vcount[0] = vcount[0] + 1;
    }

    private static float getDist(float px, float py, float pz, Vector3f p2) {
        float dx = px - p2.x;
        float dy = py - p2.y;
        float dz = pz - p2.z;
        return dx * dx + dy * dy + dz * dz;
    }
}

