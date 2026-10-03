/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.$Stack;
import com.bulletphysics.extras.gimpact.PlaneIntersectionType;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Matrix3f;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

class BoxCollision {
    public static final float BOX_PLANE_EPSILON = 1.0E-6f;

    BoxCollision() {
    }

    public static boolean BT_GREATER(float x, float y) {
        return Math.abs(x) > y;
    }

    public static float BT_MAX3(float a, float b, float c) {
        return Math.max(a, Math.max(b, c));
    }

    public static float BT_MIN3(float a, float b, float c) {
        return Math.min(a, Math.min(b, c));
    }

    public static boolean TEST_CROSS_EDGE_BOX_MCR(Vector3f edge, Vector3f absolute_edge, Vector3f pointa, Vector3f pointb, Vector3f _extend, int i_dir_0, int i_dir_1, int i_comp_0, int i_comp_1) {
        float pmax;
        float dir0 = -VectorUtil.getCoord(edge, i_dir_0);
        float dir1 = VectorUtil.getCoord(edge, i_dir_1);
        float pmin = VectorUtil.getCoord(pointa, i_comp_0) * dir0 + VectorUtil.getCoord(pointa, i_comp_1) * dir1;
        if (pmin > (pmax = VectorUtil.getCoord(pointb, i_comp_0) * dir0 + VectorUtil.getCoord(pointb, i_comp_1) * dir1)) {
            pmin += pmax;
            pmax = pmin - pmax;
            pmin -= pmax;
        }
        float abs_dir0 = VectorUtil.getCoord(absolute_edge, i_dir_0);
        float abs_dir1 = VectorUtil.getCoord(absolute_edge, i_dir_1);
        float rad = VectorUtil.getCoord(_extend, i_comp_0) * abs_dir0 + VectorUtil.getCoord(_extend, i_comp_1) * abs_dir1;
        return !(pmin > rad) && !(-rad > pmax);
    }

    public static boolean TEST_CROSS_EDGE_BOX_X_AXIS_MCR(Vector3f edge, Vector3f absolute_edge, Vector3f pointa, Vector3f pointb, Vector3f _extend) {
        return BoxCollision.TEST_CROSS_EDGE_BOX_MCR(edge, absolute_edge, pointa, pointb, _extend, 2, 1, 1, 2);
    }

    public static boolean TEST_CROSS_EDGE_BOX_Y_AXIS_MCR(Vector3f edge, Vector3f absolute_edge, Vector3f pointa, Vector3f pointb, Vector3f _extend) {
        return BoxCollision.TEST_CROSS_EDGE_BOX_MCR(edge, absolute_edge, pointa, pointb, _extend, 0, 2, 2, 0);
    }

    public static boolean TEST_CROSS_EDGE_BOX_Z_AXIS_MCR(Vector3f edge, Vector3f absolute_edge, Vector3f pointa, Vector3f pointb, Vector3f _extend) {
        return BoxCollision.TEST_CROSS_EDGE_BOX_MCR(edge, absolute_edge, pointa, pointb, _extend, 1, 0, 0, 1);
    }

    public static float bt_mat3_dot_col(Matrix3f mat, Vector3f vec3, int colindex) {
        return vec3.x * mat.getElement(0, colindex) + vec3.y * mat.getElement(1, colindex) + vec3.z * mat.getElement(2, colindex);
    }

    public static boolean compareTransformsEqual(Transform t1, Transform t2) {
        return t1.equals(t2);
    }

    public static class AABB {
        public final Vector3f min = new Vector3f();
        public final Vector3f max = new Vector3f();

        public AABB() {
        }

        public AABB(Vector3f V1, Vector3f V2, Vector3f V3) {
            this.calc_from_triangle(V1, V2, V3);
        }

        public AABB(Vector3f V1, Vector3f V2, Vector3f V3, float margin) {
            this.calc_from_triangle_margin(V1, V2, V3, margin);
        }

        public AABB(AABB other) {
            this.set(other);
        }

        public AABB(AABB other, float margin) {
            this(other);
            this.min.x -= margin;
            this.min.y -= margin;
            this.min.z -= margin;
            this.max.x += margin;
            this.max.y += margin;
            this.max.z += margin;
        }

        public void init(Vector3f V1, Vector3f V2, Vector3f V3, float margin) {
            this.calc_from_triangle_margin(V1, V2, V3, margin);
        }

        public void set(AABB other) {
            this.min.set(other.min);
            this.max.set(other.max);
        }

        public void invalidate() {
            this.min.set(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE);
            this.max.set(-3.4028235E38f, -3.4028235E38f, -3.4028235E38f);
        }

        public void increment_margin(float margin) {
            this.min.x -= margin;
            this.min.y -= margin;
            this.min.z -= margin;
            this.max.x += margin;
            this.max.y += margin;
            this.max.z += margin;
        }

        public void copy_with_margin(AABB other, float margin) {
            this.min.x = other.min.x - margin;
            this.min.y = other.min.y - margin;
            this.min.z = other.min.z - margin;
            this.max.x = other.max.x + margin;
            this.max.y = other.max.y + margin;
            this.max.z = other.max.z + margin;
        }

        public void calc_from_triangle(Vector3f V1, Vector3f V2, Vector3f V3) {
            this.min.x = BoxCollision.BT_MIN3(V1.x, V2.x, V3.x);
            this.min.y = BoxCollision.BT_MIN3(V1.y, V2.y, V3.y);
            this.min.z = BoxCollision.BT_MIN3(V1.z, V2.z, V3.z);
            this.max.x = BoxCollision.BT_MAX3(V1.x, V2.x, V3.x);
            this.max.y = BoxCollision.BT_MAX3(V1.y, V2.y, V3.y);
            this.max.z = BoxCollision.BT_MAX3(V1.z, V2.z, V3.z);
        }

        public void calc_from_triangle_margin(Vector3f V1, Vector3f V2, Vector3f V3, float margin) {
            this.calc_from_triangle(V1, V2, V3);
            this.min.x -= margin;
            this.min.y -= margin;
            this.min.z -= margin;
            this.max.x += margin;
            this.max.y += margin;
            this.max.z += margin;
        }

        /*
         * WARNING - void declaration
         */
        public void appy_transform(Transform transform) {
            $Stack $Stack = $Stack.get();
            try {
                void trans;
                $Stack.push$javax$vecmath$Vector3f();
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                Vector3f center = $Stack.get$javax$vecmath$Vector3f();
                center.add(this.max, this.min);
                center.scale(0.5f);
                Vector3f extends_ = $Stack.get$javax$vecmath$Vector3f();
                extends_.sub(this.max, center);
                trans.transform(center);
                Vector3f textends = $Stack.get$javax$vecmath$Vector3f();
                trans.basis.getRow(0, tmp);
                tmp.absolute();
                textends.x = extends_.dot(tmp);
                trans.basis.getRow(1, tmp);
                tmp.absolute();
                textends.y = extends_.dot(tmp);
                trans.basis.getRow(2, tmp);
                tmp.absolute();
                textends.z = extends_.dot(tmp);
                this.min.sub(center, textends);
                this.max.add(center, textends);
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
        public void appy_transform_trans_cache(BoxBoxTransformCache boxBoxTransformCache) {
            $Stack $Stack = $Stack.get();
            try {
                void trans;
                $Stack.push$javax$vecmath$Vector3f();
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                Vector3f center = $Stack.get$javax$vecmath$Vector3f();
                center.add(this.max, this.min);
                center.scale(0.5f);
                Vector3f extends_ = $Stack.get$javax$vecmath$Vector3f();
                extends_.sub(this.max, center);
                trans.transform(center, center);
                Vector3f textends = $Stack.get$javax$vecmath$Vector3f();
                trans.R1to0.getRow(0, tmp);
                tmp.absolute();
                textends.x = extends_.dot(tmp);
                trans.R1to0.getRow(1, tmp);
                tmp.absolute();
                textends.y = extends_.dot(tmp);
                trans.R1to0.getRow(2, tmp);
                tmp.absolute();
                textends.z = extends_.dot(tmp);
                this.min.sub(center, textends);
                this.max.add(center, textends);
                $Stack.pop$javax$vecmath$Vector3f();
                return;
            }
            catch (Throwable throwable) {
                $Stack.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }

        public void merge(AABB box) {
            this.min.x = Math.min(this.min.x, box.min.x);
            this.min.y = Math.min(this.min.y, box.min.y);
            this.min.z = Math.min(this.min.z, box.min.z);
            this.max.x = Math.max(this.max.x, box.max.x);
            this.max.y = Math.max(this.max.y, box.max.y);
            this.max.z = Math.max(this.max.z, box.max.z);
        }

        public void merge_point(Vector3f point) {
            this.min.x = Math.min(this.min.x, point.x);
            this.min.y = Math.min(this.min.y, point.y);
            this.min.z = Math.min(this.min.z, point.z);
            this.max.x = Math.max(this.max.x, point.x);
            this.max.y = Math.max(this.max.y, point.y);
            this.max.z = Math.max(this.max.z, point.z);
        }

        public void get_center_extend(Vector3f center, Vector3f extend) {
            center.add(this.max, this.min);
            center.scale(0.5f);
            extend.sub(this.max, center);
        }

        public void find_intersection(AABB other, AABB intersection) {
            intersection.min.x = Math.max(other.min.x, this.min.x);
            intersection.min.y = Math.max(other.min.y, this.min.y);
            intersection.min.z = Math.max(other.min.z, this.min.z);
            intersection.max.x = Math.min(other.max.x, this.max.x);
            intersection.max.y = Math.min(other.max.y, this.max.y);
            intersection.max.z = Math.min(other.max.z, this.max.z);
        }

        public boolean has_collision(AABB other) {
            return !(this.min.x > other.max.x || this.max.x < other.min.x || this.min.y > other.max.y || this.max.y < other.min.y || this.min.z > other.max.z) && !(this.max.z < other.min.z);
        }

        /*
         * WARNING - void declaration
         */
        public boolean collide_ray(Vector3f vector3f, Vector3f vector3f2) {
            $Stack $Stack = $Stack.get();
            try {
                void vdir;
                void vorigin;
                $Stack.push$javax$vecmath$Vector3f();
                Vector3f extents = $Stack.get$javax$vecmath$Vector3f();
                Vector3f center = $Stack.get$javax$vecmath$Vector3f();
                this.get_center_extend(center, extents);
                float Dx = vorigin.x - center.x;
                if (BoxCollision.BT_GREATER(Dx, extents.x) && Dx * vdir.x >= 0.0f) {
                    $Stack.pop$javax$vecmath$Vector3f();
                    return false;
                }
                float Dy = vorigin.y - center.y;
                if (BoxCollision.BT_GREATER(Dy, extents.y) && Dy * vdir.y >= 0.0f) {
                    $Stack.pop$javax$vecmath$Vector3f();
                    return false;
                }
                float Dz = vorigin.z - center.z;
                if (BoxCollision.BT_GREATER(Dz, extents.z) && Dz * vdir.z >= 0.0f) {
                    $Stack.pop$javax$vecmath$Vector3f();
                    return false;
                }
                float f = vdir.y * Dz - vdir.z * Dy;
                if (Math.abs(f) > extents.y * Math.abs(vdir.z) + extents.z * Math.abs(vdir.y)) {
                    $Stack.pop$javax$vecmath$Vector3f();
                    return false;
                }
                f = vdir.z * Dx - vdir.x * Dz;
                if (Math.abs(f) > extents.x * Math.abs(vdir.z) + extents.z * Math.abs(vdir.x)) {
                    $Stack.pop$javax$vecmath$Vector3f();
                    return false;
                }
                f = vdir.x * Dy - vdir.y * Dx;
                if (Math.abs(f) > extents.x * Math.abs(vdir.y) + extents.y * Math.abs(vdir.x)) {
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
        public void projection_interval(Vector3f vector3f, float[] fArray, float[] fArray2) {
            $Stack $Stack = $Stack.get();
            try {
                void direction;
                $Stack.push$javax$vecmath$Vector3f();
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                Vector3f center = $Stack.get$javax$vecmath$Vector3f();
                Vector3f extend = $Stack.get$javax$vecmath$Vector3f();
                this.get_center_extend(center, extend);
                float _fOrigin = direction.dot(center);
                tmp.absolute((Tuple3f)direction);
                float _fMaximumExtent = extend.dot(tmp);
                vmin[0] = _fOrigin - _fMaximumExtent;
                vmax[0] = _fOrigin + _fMaximumExtent;
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
        public PlaneIntersectionType plane_classify(Vector4f vector4f) {
            $Stack $Stack = $Stack.get();
            try {
                void plane;
                $Stack.push$javax$vecmath$Vector3f();
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                float[] _fmin = new float[1];
                float[] _fmax = new float[1];
                tmp.set(plane.x, plane.y, plane.z);
                this.projection_interval(tmp, _fmin, _fmax);
                if (plane.w > _fmax[0] + 1.0E-6f) {
                    $Stack.pop$javax$vecmath$Vector3f();
                    return PlaneIntersectionType.BACK_PLANE;
                }
                if (plane.w + 1.0E-6f >= _fmin[0]) {
                    $Stack.pop$javax$vecmath$Vector3f();
                    return PlaneIntersectionType.COLLIDE_PLANE;
                }
                $Stack.pop$javax$vecmath$Vector3f();
                return PlaneIntersectionType.FRONT_PLANE;
            }
            catch (Throwable throwable) {
                $Stack.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }

        /*
         * WARNING - void declaration
         */
        public boolean overlapping_trans_conservative(AABB aABB, Transform transform) {
            $Stack $Stack = $Stack.get();
            try {
                void trans1_to_0;
                void box;
                $Stack.push$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
                AABB tbox = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB((AABB)box);
                tbox.appy_transform((Transform)trans1_to_0);
                boolean bl = this.has_collision(tbox);
                $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
                return bl;
            }
            catch (Throwable throwable) {
                $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
                throw throwable;
            }
        }

        /*
         * WARNING - void declaration
         */
        public boolean overlapping_trans_conservative2(AABB aABB, BoxBoxTransformCache boxBoxTransformCache) {
            $Stack $Stack = $Stack.get();
            try {
                void trans1_to_0;
                void box;
                $Stack.push$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
                AABB tbox = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB((AABB)box);
                tbox.appy_transform_trans_cache((BoxBoxTransformCache)trans1_to_0);
                boolean bl = this.has_collision(tbox);
                $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
                return bl;
            }
            catch (Throwable throwable) {
                $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
                throw throwable;
            }
        }

        /*
         * WARNING - void declaration
         */
        public boolean overlapping_trans_cache(AABB aABB, BoxBoxTransformCache boxBoxTransformCache, boolean bl) {
            $Stack $Stack = $Stack.get();
            try {
                void fulltest;
                float t2;
                float t;
                void transcache;
                int i;
                void box;
                $Stack.push$javax$vecmath$Vector3f();
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                Vector3f ea = $Stack.get$javax$vecmath$Vector3f();
                Vector3f eb = $Stack.get$javax$vecmath$Vector3f();
                Vector3f ca = $Stack.get$javax$vecmath$Vector3f();
                Vector3f cb = $Stack.get$javax$vecmath$Vector3f();
                this.get_center_extend(ca, ea);
                box.get_center_extend(cb, eb);
                Vector3f T = $Stack.get$javax$vecmath$Vector3f();
                for (i = 0; i < 3; ++i) {
                    transcache.R1to0.getRow(i, tmp);
                    VectorUtil.setCoord(T, i, tmp.dot(cb) + VectorUtil.getCoord(transcache.T1to0, i) - VectorUtil.getCoord(ca, i));
                    transcache.AR.getRow(i, tmp);
                    t = tmp.dot(eb) + VectorUtil.getCoord(ea, i);
                    if (!BoxCollision.BT_GREATER(VectorUtil.getCoord(T, i), t)) continue;
                    $Stack.pop$javax$vecmath$Vector3f();
                    return false;
                }
                for (i = 0; i < 3; ++i) {
                    t = BoxCollision.bt_mat3_dot_col(transcache.R1to0, T, i);
                    if (!BoxCollision.BT_GREATER(t, t2 = BoxCollision.bt_mat3_dot_col(transcache.AR, ea, i) + VectorUtil.getCoord(eb, i))) continue;
                    $Stack.pop$javax$vecmath$Vector3f();
                    return false;
                }
                if (fulltest != false) {
                    for (int i2 = 0; i2 < 3; ++i2) {
                        int m = (i2 + 1) % 3;
                        int n = (i2 + 2) % 3;
                        int o = i2 == 0 ? 1 : 0;
                        int p = i2 == 2 ? 1 : 2;
                        for (int j = 0; j < 3; ++j) {
                            int q = j == 2 ? 1 : 2;
                            int r = j == 0 ? 1 : 0;
                            t = VectorUtil.getCoord(T, n) * transcache.R1to0.getElement(m, j) - VectorUtil.getCoord(T, m) * transcache.R1to0.getElement(n, j);
                            if (!BoxCollision.BT_GREATER(t, t2 = VectorUtil.getCoord(ea, o) * transcache.AR.getElement(p, j) + VectorUtil.getCoord(ea, p) * transcache.AR.getElement(o, j) + VectorUtil.getCoord(eb, r) * transcache.AR.getElement(i2, q) + VectorUtil.getCoord(eb, q) * transcache.AR.getElement(i2, r))) continue;
                            $Stack.pop$javax$vecmath$Vector3f();
                            return false;
                        }
                    }
                }
                $Stack.pop$javax$vecmath$Vector3f();
                return true;
            }
            catch (Throwable throwable) {
                $Stack.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }

        public boolean collide_plane(Vector4f plane) {
            PlaneIntersectionType classify = this.plane_classify(plane);
            return classify == PlaneIntersectionType.COLLIDE_PLANE;
        }

        /*
         * WARNING - void declaration
         */
        public boolean collide_triangle_exact(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector4f vector4f) {
            $Stack $Stack = $Stack.get();
            try {
                void p3;
                void p2;
                void p1;
                void triangle_plane;
                $Stack.push$javax$vecmath$Vector3f();
                if (!this.collide_plane((Vector4f)triangle_plane)) {
                    $Stack.pop$javax$vecmath$Vector3f();
                    return false;
                }
                Vector3f center = $Stack.get$javax$vecmath$Vector3f();
                Vector3f extends_ = $Stack.get$javax$vecmath$Vector3f();
                this.get_center_extend(center, extends_);
                Vector3f v1 = $Stack.get$javax$vecmath$Vector3f();
                v1.sub((Tuple3f)p1, center);
                Vector3f v2 = $Stack.get$javax$vecmath$Vector3f();
                v2.sub((Tuple3f)p2, center);
                Vector3f v3 = $Stack.get$javax$vecmath$Vector3f();
                v3.sub((Tuple3f)p3, center);
                Vector3f diff = $Stack.get$javax$vecmath$Vector3f();
                diff.sub(v2, v1);
                Vector3f abs_diff = $Stack.get$javax$vecmath$Vector3f();
                abs_diff.absolute(diff);
                BoxCollision.TEST_CROSS_EDGE_BOX_X_AXIS_MCR(diff, abs_diff, v1, v3, extends_);
                BoxCollision.TEST_CROSS_EDGE_BOX_Y_AXIS_MCR(diff, abs_diff, v1, v3, extends_);
                BoxCollision.TEST_CROSS_EDGE_BOX_Z_AXIS_MCR(diff, abs_diff, v1, v3, extends_);
                diff.sub(v3, v2);
                abs_diff.absolute(diff);
                BoxCollision.TEST_CROSS_EDGE_BOX_X_AXIS_MCR(diff, abs_diff, v2, v1, extends_);
                BoxCollision.TEST_CROSS_EDGE_BOX_Y_AXIS_MCR(diff, abs_diff, v2, v1, extends_);
                BoxCollision.TEST_CROSS_EDGE_BOX_Z_AXIS_MCR(diff, abs_diff, v2, v1, extends_);
                diff.sub(v1, v3);
                abs_diff.absolute(diff);
                BoxCollision.TEST_CROSS_EDGE_BOX_X_AXIS_MCR(diff, abs_diff, v3, v2, extends_);
                BoxCollision.TEST_CROSS_EDGE_BOX_Y_AXIS_MCR(diff, abs_diff, v3, v2, extends_);
                BoxCollision.TEST_CROSS_EDGE_BOX_Z_AXIS_MCR(diff, abs_diff, v3, v2, extends_);
                $Stack.pop$javax$vecmath$Vector3f();
                return true;
            }
            catch (Throwable throwable) {
                $Stack.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }
    }

    public static class BoxBoxTransformCache {
        public final Vector3f T1to0 = new Vector3f();
        public final Matrix3f R1to0 = new Matrix3f();
        public final Matrix3f AR = new Matrix3f();

        public void set(BoxBoxTransformCache cache) {
            throw new UnsupportedOperationException();
        }

        public void calc_absolute_matrix() {
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    this.AR.setElement(i, j, 1.0E-6f + Math.abs(this.R1to0.getElement(i, j)));
                }
            }
        }

        /*
         * WARNING - void declaration
         */
        public void calc_from_homogenic(Transform transform, Transform transform2) {
            $Stack $Stack = $Stack.get();
            try {
                void trans1;
                void trans0;
                $Stack.push$com$bulletphysics$linearmath$Transform();
                Transform temp_trans = $Stack.get$com$bulletphysics$linearmath$Transform();
                temp_trans.inverse((Transform)trans0);
                temp_trans.mul((Transform)trans1);
                this.T1to0.set(temp_trans.origin);
                this.R1to0.set(temp_trans.basis);
                this.calc_absolute_matrix();
                $Stack.pop$com$bulletphysics$linearmath$Transform();
                return;
            }
            catch (Throwable throwable) {
                $Stack.pop$com$bulletphysics$linearmath$Transform();
                throw throwable;
            }
        }

        /*
         * WARNING - void declaration
         */
        public void calc_from_full_invert(Transform transform, Transform transform2) {
            $Stack $Stack = $Stack.get();
            try {
                void trans1;
                void trans0;
                $Stack.push$javax$vecmath$Vector3f();
                this.R1to0.invert(trans0.basis);
                this.T1to0.negate(trans0.origin);
                this.R1to0.transform(this.T1to0);
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                tmp.set(trans1.origin);
                this.R1to0.transform(tmp);
                this.T1to0.add(tmp);
                this.R1to0.mul(trans1.basis);
                this.calc_absolute_matrix();
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
        public Vector3f transform(Vector3f vector3f, Vector3f vector3f2) {
            $Stack $Stack = $Stack.get();
            try {
                void out;
                Vector3f point;
                $Stack.push$javax$vecmath$Vector3f();
                if (point == out) {
                    point = $Stack.get$javax$vecmath$Vector3f(point);
                }
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                this.R1to0.getRow(0, tmp);
                out.x = tmp.dot(point) + this.T1to0.x;
                this.R1to0.getRow(1, tmp);
                out.y = tmp.dot(point) + this.T1to0.y;
                this.R1to0.getRow(2, tmp);
                out.z = tmp.dot(point) + this.T1to0.z;
                $Stack.pop$javax$vecmath$Vector3f();
                return out;
            }
            catch (Throwable throwable) {
                $Stack.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }
    }
}

