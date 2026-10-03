/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.$Stack;
import com.bulletphysics.extras.gimpact.ClipPolygon;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

class GeometryOperations {
    public static final float PLANEDIREPSILON = 1.0E-7f;
    public static final float PARALELENORMALS = 1.0E-6f;

    GeometryOperations() {
    }

    public static final float CLAMP(float number, float minval, float maxval) {
        return number < minval ? minval : (number > maxval ? maxval : number);
    }

    /*
     * WARNING - void declaration
     */
    public static void edge_plane(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector4f vector4f) {
        $Stack $Stack = $Stack.get();
        try {
            void plane;
            void normal;
            Vector3f e1;
            void e2;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f planenormal = $Stack.get$javax$vecmath$Vector3f();
            planenormal.sub((Tuple3f)e2, e1);
            planenormal.cross(planenormal, (Vector3f)normal);
            planenormal.normalize();
            plane.set(planenormal);
            plane.w = e2.dot(planenormal);
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
    public static void closest_point_on_segment(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4) {
        $Stack $Stack = $Stack.get();
        try {
            void v;
            Vector3f cp;
            void e1;
            void e2;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f n = $Stack.get$javax$vecmath$Vector3f();
            n.sub((Tuple3f)e2, (Tuple3f)e1);
            cp.sub((Tuple3f)v, (Tuple3f)e1);
            float _scalar = cp.dot(n) / n.dot(n);
            if (_scalar < 0.0f) {
                cp = e1;
            } else if (_scalar > 1.0f) {
                cp = e2;
            } else {
                cp.scaleAdd(_scalar, n, (Tuple3f)e1);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public static int line_plane_collision(Vector4f plane, Vector3f vDir, Vector3f vPoint, Vector3f pout, float[] tparam, float tmin, float tmax) {
        float _dotdir = VectorUtil.dot3(vDir, plane);
        if (Math.abs(_dotdir) < 1.0E-7f) {
            tparam[0] = tmax;
            return 0;
        }
        float _dis = ClipPolygon.distance_point_plane(plane, vPoint);
        int returnvalue = _dis < 0.0f ? 2 : 1;
        tparam[0] = -_dis / _dotdir;
        if (tparam[0] < tmin) {
            returnvalue = 0;
            tparam[0] = tmin;
        } else if (tparam[0] > tmax) {
            returnvalue = 0;
            tparam[0] = tmax;
        }
        pout.scaleAdd(tparam[0], vDir, vPoint);
        return returnvalue;
    }

    /*
     * WARNING - void declaration
     */
    public static void segment_collision(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4, Vector3f vector3f5, Vector3f vector3f6) {
        $Stack $Stack = $Stack.get();
        try {
            Vector3f vPointA;
            void vPointB;
            void vB1;
            void vB2;
            Vector3f vA1;
            void vA2;
            $Stack $Stack2 = $Stack;
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Vector4f();
            Vector3f AD = $Stack.get$javax$vecmath$Vector3f();
            AD.sub((Tuple3f)vA2, vA1);
            Vector3f BD2 = $Stack.get$javax$vecmath$Vector3f();
            BD2.sub((Tuple3f)vB2, (Tuple3f)vB1);
            Vector3f N = $Stack.get$javax$vecmath$Vector3f();
            N.cross(AD, BD2);
            float[] tp = new float[]{N.lengthSquared()};
            Vector4f _M = $Stack.get$javax$vecmath$Vector4f();
            if (tp[0] < 1.1920929E-7f) {
                boolean invert_b_order = false;
                _M.x = vB1.dot(AD);
                _M.y = vB2.dot(AD);
                if (_M.x > _M.y) {
                    invert_b_order = true;
                    _M.x += _M.y;
                    _M.y = _M.x - _M.y;
                    _M.x -= _M.y;
                }
                _M.z = vA1.dot(AD);
                _M.w = vA2.dot(AD);
                N.x = (_M.x + _M.y) * 0.5f;
                N.y = (_M.z + _M.w) * 0.5f;
                if (N.x < N.y) {
                    if (_M.y < _M.z) {
                        vPointB = invert_b_order ? vB1 : vB2;
                        vPointA = vA1;
                    } else if (_M.y < _M.w) {
                        vPointB = invert_b_order ? vB1 : vB2;
                        GeometryOperations.closest_point_on_segment(vPointA, (Vector3f)vPointB, vA1, (Vector3f)vA2);
                    } else {
                        vPointA = vA2;
                        GeometryOperations.closest_point_on_segment((Vector3f)vPointB, vPointA, (Vector3f)vB1, (Vector3f)vB2);
                    }
                } else if (_M.w < _M.x) {
                    vPointB = invert_b_order ? vB2 : vB1;
                    vPointA = vA2;
                } else if (_M.w < _M.y) {
                    vPointA = vA2;
                    GeometryOperations.closest_point_on_segment((Vector3f)vPointB, vPointA, (Vector3f)vB1, (Vector3f)vB2);
                } else {
                    vPointB = invert_b_order ? vB1 : vB2;
                    GeometryOperations.closest_point_on_segment(vPointA, (Vector3f)vPointB, vA1, (Vector3f)vA2);
                }
                $Stack $Stack3 = $Stack;
                $Stack3.pop$javax$vecmath$Vector3f();
                $Stack3.pop$javax$vecmath$Vector4f();
                return;
            }
            N.cross(N, BD2);
            _M.set(N.x, N.y, N.z, vB1.dot(N));
            GeometryOperations.line_plane_collision(_M, AD, vA1, vPointA, tp, 0.0f, 1.0f);
            vPointB.sub(vPointA, (Tuple3f)vB1);
            tp[0] = vPointB.dot(BD2);
            tp[0] = tp[0] / BD2.dot(BD2);
            tp[0] = GeometryOperations.CLAMP(tp[0], 0.0f, 1.0f);
            vPointB.scaleAdd(tp[0], BD2, (Tuple3f)vB1);
            $Stack $Stack4 = $Stack;
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Vector4f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack5 = $Stack;
            $Stack5.pop$javax$vecmath$Vector3f();
            $Stack5.pop$javax$vecmath$Vector4f();
            throw throwable;
        }
    }
}

