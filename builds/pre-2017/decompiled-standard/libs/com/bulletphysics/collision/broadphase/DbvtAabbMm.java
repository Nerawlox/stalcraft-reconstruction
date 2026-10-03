/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

import com.bulletphysics.$Stack;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Vector3f;

public class DbvtAabbMm {
    private final Vector3f mi = new Vector3f();
    private final Vector3f mx = new Vector3f();

    public DbvtAabbMm() {
    }

    public DbvtAabbMm(DbvtAabbMm o) {
        this.set(o);
    }

    public void set(DbvtAabbMm o) {
        this.mi.set(o.mi);
        this.mx.set(o.mx);
    }

    /*
     * WARNING - void declaration
     */
    public static void swap(DbvtAabbMm dbvtAabbMm, DbvtAabbMm dbvtAabbMm2) {
        $Stack $Stack = $Stack.get();
        try {
            void p2;
            DbvtAabbMm p1;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            tmp.set(p1.mi);
            p1.mi.set(p2.mi);
            p2.mi.set(tmp);
            tmp.set(p1.mx);
            p1.mx.set(p2.mx);
            p2.mx.set(tmp);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public Vector3f Center(Vector3f out) {
        out.add(this.mi, this.mx);
        out.scale(0.5f);
        return out;
    }

    public Vector3f Lengths(Vector3f out) {
        out.sub(this.mx, this.mi);
        return out;
    }

    public Vector3f Extents(Vector3f out) {
        out.sub(this.mx, this.mi);
        out.scale(0.5f);
        return out;
    }

    public Vector3f Mins() {
        return this.mi;
    }

    public Vector3f Maxs() {
        return this.mx;
    }

    public static DbvtAabbMm FromCE(Vector3f c, Vector3f e, DbvtAabbMm out) {
        DbvtAabbMm box = out;
        box.mi.sub(c, e);
        box.mx.add(c, e);
        return box;
    }

    /*
     * WARNING - void declaration
     */
    public static DbvtAabbMm FromCR(Vector3f vector3f, float f, DbvtAabbMm dbvtAabbMm) {
        $Stack $Stack = $Stack.get();
        try {
            void out;
            Vector3f c;
            void r;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            tmp.set((float)r, (float)r, (float)r);
            DbvtAabbMm dbvtAabbMm2 = DbvtAabbMm.FromCE(c, tmp, (DbvtAabbMm)out);
            $Stack.pop$javax$vecmath$Vector3f();
            return dbvtAabbMm2;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public static DbvtAabbMm FromMM(Vector3f mi, Vector3f mx, DbvtAabbMm out) {
        DbvtAabbMm box = out;
        box.mi.set(mi);
        box.mx.set(mx);
        return box;
    }

    public void Expand(Vector3f e) {
        this.mi.sub(e);
        this.mx.add(e);
    }

    public void SignedExpand(Vector3f e) {
        if (e.x > 0.0f) {
            this.mx.x += e.x;
        } else {
            this.mi.x += e.x;
        }
        if (e.y > 0.0f) {
            this.mx.y += e.y;
        } else {
            this.mi.y += e.y;
        }
        if (e.z > 0.0f) {
            this.mx.z += e.z;
        } else {
            this.mi.z += e.z;
        }
    }

    public boolean Contain(DbvtAabbMm a) {
        return this.mi.x <= a.mi.x && this.mi.y <= a.mi.y && this.mi.z <= a.mi.z && this.mx.x >= a.mx.x && this.mx.y >= a.mx.y && this.mx.z >= a.mx.z;
    }

    /*
     * WARNING - void declaration
     */
    public int Classify(Vector3f vector3f, float f, int n) {
        $Stack $Stack = $Stack.get();
        try {
            void o;
            void n2;
            void s;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f pi = $Stack.get$javax$vecmath$Vector3f();
            Vector3f px = $Stack.get$javax$vecmath$Vector3f();
            switch (s) {
                case 0: {
                    px.set(this.mi.x, this.mi.y, this.mi.z);
                    pi.set(this.mx.x, this.mx.y, this.mx.z);
                    break;
                }
                case 1: {
                    px.set(this.mx.x, this.mi.y, this.mi.z);
                    pi.set(this.mi.x, this.mx.y, this.mx.z);
                    break;
                }
                case 2: {
                    px.set(this.mi.x, this.mx.y, this.mi.z);
                    pi.set(this.mx.x, this.mi.y, this.mx.z);
                    break;
                }
                case 3: {
                    px.set(this.mx.x, this.mx.y, this.mi.z);
                    pi.set(this.mi.x, this.mi.y, this.mx.z);
                    break;
                }
                case 4: {
                    px.set(this.mi.x, this.mi.y, this.mx.z);
                    pi.set(this.mx.x, this.mx.y, this.mi.z);
                    break;
                }
                case 5: {
                    px.set(this.mx.x, this.mi.y, this.mx.z);
                    pi.set(this.mi.x, this.mx.y, this.mi.z);
                    break;
                }
                case 6: {
                    px.set(this.mi.x, this.mx.y, this.mx.z);
                    pi.set(this.mx.x, this.mi.y, this.mi.z);
                    break;
                }
                case 7: {
                    px.set(this.mx.x, this.mx.y, this.mx.z);
                    pi.set(this.mi.x, this.mi.y, this.mi.z);
                }
            }
            if (n2.dot(px) + o < 0.0f) {
                $Stack.pop$javax$vecmath$Vector3f();
                return -1;
            }
            if (n2.dot(pi) + o >= 0.0f) {
                $Stack.pop$javax$vecmath$Vector3f();
                return 1;
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return 0;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public float ProjectMinimum(Vector3f vector3f, int n) {
        $Stack $Stack = $Stack.get();
        try {
            void v;
            void signs;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f[] b = new Vector3f[]{this.mx, this.mi};
            Vector3f p = $Stack.get$javax$vecmath$Vector3f();
            p.set(b[signs >> 0 & 1].x, b[signs >> 1 & 1].y, b[signs >> 2 & 1].z);
            float f = p.dot((Vector3f)v);
            $Stack.pop$javax$vecmath$Vector3f();
            return f;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public static boolean Intersect(DbvtAabbMm a, DbvtAabbMm b) {
        return a.mi.x <= b.mx.x && a.mx.x >= b.mi.x && a.mi.y <= b.mx.y && a.mx.y >= b.mi.y && a.mi.z <= b.mx.z && a.mx.z >= b.mi.z;
    }

    /*
     * WARNING - void declaration
     */
    public static boolean Intersect(DbvtAabbMm dbvtAabbMm, DbvtAabbMm dbvtAabbMm2, Transform transform) {
        $Stack $Stack = $Stack.get();
        try {
            float[] s1;
            DbvtAabbMm a;
            void xform;
            void b;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f d0 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f d1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            b.Center(d0);
            xform.transform(d0);
            d0.sub(a.Center(tmp));
            MatrixUtil.transposeTransform(d1, d0, xform.basis);
            float[] s0 = new float[]{0.0f, 0.0f};
            s1 = new float[]{xform.origin.dot(d0), s1[0]};
            a.AddSpan(d0, s0, 0, s0, 1);
            super.AddSpan(d1, s1, 0, s1, 1);
            if (s0[0] > s1[1]) {
                $Stack.pop$javax$vecmath$Vector3f();
                return false;
            }
            if (s0[1] < s1[0]) {
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

    public static boolean Intersect(DbvtAabbMm a, Vector3f b) {
        return b.x >= a.mi.x && b.y >= a.mi.y && b.z >= a.mi.z && b.x <= a.mx.x && b.y <= a.mx.y && b.z <= a.mx.z;
    }

    public static boolean Intersect(DbvtAabbMm a, Vector3f org, Vector3f invdir, int[] signs) {
        Vector3f[] bounds = new Vector3f[]{a.mi, a.mx};
        float txmin = (bounds[signs[0]].x - org.x) * invdir.x;
        float txmax = (bounds[1 - signs[0]].x - org.x) * invdir.x;
        float tymin = (bounds[signs[1]].y - org.y) * invdir.y;
        float tymax = (bounds[1 - signs[1]].y - org.y) * invdir.y;
        if (txmin > tymax || tymin > txmax) {
            return false;
        }
        if (tymin > txmin) {
            txmin = tymin;
        }
        if (tymax < txmax) {
            txmax = tymax;
        }
        float tzmin = (bounds[signs[2]].z - org.z) * invdir.z;
        float tzmax = (bounds[1 - signs[2]].z - org.z) * invdir.z;
        if (txmin > tzmax || tzmin > txmax) {
            return false;
        }
        if (tzmin > txmin) {
            txmin = tzmin;
        }
        if (tzmax < txmax) {
            txmax = tzmax;
        }
        return txmax > 0.0f;
    }

    /*
     * WARNING - void declaration
     */
    public static float Proximity(DbvtAabbMm dbvtAabbMm, DbvtAabbMm dbvtAabbMm2) {
        $Stack $Stack = $Stack.get();
        try {
            void b;
            DbvtAabbMm a;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f d = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            d.add(a.mi, a.mx);
            tmp.add(b.mi, b.mx);
            d.sub(tmp);
            float f = Math.abs(d.x) + Math.abs(d.y) + Math.abs(d.z);
            $Stack.pop$javax$vecmath$Vector3f();
            return f;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public static void Merge(DbvtAabbMm a, DbvtAabbMm b, DbvtAabbMm r) {
        for (int i = 0; i < 3; ++i) {
            if (VectorUtil.getCoord(a.mi, i) < VectorUtil.getCoord(b.mi, i)) {
                VectorUtil.setCoord(r.mi, i, VectorUtil.getCoord(a.mi, i));
            } else {
                VectorUtil.setCoord(r.mi, i, VectorUtil.getCoord(b.mi, i));
            }
            if (VectorUtil.getCoord(a.mx, i) > VectorUtil.getCoord(b.mx, i)) {
                VectorUtil.setCoord(r.mx, i, VectorUtil.getCoord(a.mx, i));
                continue;
            }
            VectorUtil.setCoord(r.mx, i, VectorUtil.getCoord(b.mx, i));
        }
    }

    public static boolean NotEqual(DbvtAabbMm a, DbvtAabbMm b) {
        return a.mi.x != b.mi.x || a.mi.y != b.mi.y || a.mi.z != b.mi.z || a.mx.x != b.mx.x || a.mx.y != b.mx.y || a.mx.z != b.mx.z;
    }

    private void AddSpan(Vector3f d, float[] smi, int smi_idx, float[] smx, int smx_idx) {
        for (int i = 0; i < 3; ++i) {
            if (VectorUtil.getCoord(d, i) < 0.0f) {
                int n = smi_idx;
                smi[n] = smi[n] + VectorUtil.getCoord(this.mx, i) * VectorUtil.getCoord(d, i);
                int n2 = smx_idx;
                smx[n2] = smx[n2] + VectorUtil.getCoord(this.mi, i) * VectorUtil.getCoord(d, i);
                continue;
            }
            int n = smi_idx;
            smi[n] = smi[n] + VectorUtil.getCoord(this.mi, i) * VectorUtil.getCoord(d, i);
            int n3 = smx_idx;
            smx[n3] = smx[n3] + VectorUtil.getCoord(this.mx, i) * VectorUtil.getCoord(d, i);
        }
    }
}

