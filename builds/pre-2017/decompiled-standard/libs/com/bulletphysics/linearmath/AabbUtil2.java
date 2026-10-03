/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath;

import com.bulletphysics.$Stack;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Matrix3f;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class AabbUtil2 {
    public static void aabbExpand(Vector3f aabbMin, Vector3f aabbMax, Vector3f expansionMin, Vector3f expansionMax) {
        aabbMin.add(expansionMin);
        aabbMax.add(expansionMax);
    }

    public static int outcode(Vector3f p, Vector3f halfExtent) {
        return (p.x < -halfExtent.x ? 1 : 0) | (p.x > halfExtent.x ? 8 : 0) | (p.y < -halfExtent.y ? 2 : 0) | (p.y > halfExtent.y ? 16 : 0) | (p.z < -halfExtent.z ? 4 : 0) | (p.z > halfExtent.z ? 32 : 0);
    }

    /*
     * WARNING - void declaration
     */
    public static boolean rayAabb(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4, float[] fArray, Vector3f vector3f5) {
        $Stack $Stack = $Stack.get();
        try {
            void rayTo;
            Vector3f rayFrom;
            void aabbMin;
            void aabbMax;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f aabbHalfExtent = $Stack.get$javax$vecmath$Vector3f();
            Vector3f aabbCenter = $Stack.get$javax$vecmath$Vector3f();
            Vector3f source = $Stack.get$javax$vecmath$Vector3f();
            Vector3f target = $Stack.get$javax$vecmath$Vector3f();
            Vector3f r = $Stack.get$javax$vecmath$Vector3f();
            Vector3f hitNormal = $Stack.get$javax$vecmath$Vector3f();
            aabbHalfExtent.sub((Tuple3f)aabbMax, (Tuple3f)aabbMin);
            aabbHalfExtent.scale(0.5f);
            aabbCenter.add((Tuple3f)aabbMax, (Tuple3f)aabbMin);
            aabbCenter.scale(0.5f);
            source.sub(rayFrom, aabbCenter);
            target.sub((Tuple3f)rayTo, aabbCenter);
            int sourceOutcode = AabbUtil2.outcode(source, aabbHalfExtent);
            int targetOutcode = AabbUtil2.outcode(target, aabbHalfExtent);
            if ((sourceOutcode & targetOutcode) == 0) {
                void param;
                float lambda_enter = 0.0f;
                float lambda_exit = param[0];
                r.sub(target, source);
                float normSign = 1.0f;
                hitNormal.set(0.0f, 0.0f, 0.0f);
                int bit = 1;
                for (int j = 0; j < 2; ++j) {
                    for (int i = 0; i != 3; ++i) {
                        float lambda2;
                        if ((sourceOutcode & bit) != 0) {
                            lambda2 = (-VectorUtil.getCoord(source, i) - VectorUtil.getCoord(aabbHalfExtent, i) * normSign) / VectorUtil.getCoord(r, i);
                            if (lambda_enter <= lambda2) {
                                lambda_enter = lambda2;
                                hitNormal.set(0.0f, 0.0f, 0.0f);
                                VectorUtil.setCoord(hitNormal, i, normSign);
                            }
                        } else if ((targetOutcode & bit) != 0) {
                            lambda2 = (-VectorUtil.getCoord(source, i) - VectorUtil.getCoord(aabbHalfExtent, i) * normSign) / VectorUtil.getCoord(r, i);
                            lambda_exit = Math.min(lambda_exit, lambda2);
                        }
                        bit <<= 1;
                    }
                    normSign = -1.0f;
                }
                if (lambda_enter <= lambda_exit) {
                    void normal;
                    param[0] = lambda_enter;
                    normal.set(hitNormal);
                    $Stack.pop$javax$vecmath$Vector3f();
                    return true;
                }
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return false;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public static boolean testAabbAgainstAabb2(Vector3f aabbMin1, Vector3f aabbMax1, Vector3f aabbMin2, Vector3f aabbMax2) {
        boolean overlap = true;
        overlap = aabbMin1.x > aabbMax2.x || aabbMax1.x < aabbMin2.x ? false : overlap;
        overlap = aabbMin1.z > aabbMax2.z || aabbMax1.z < aabbMin2.z ? false : overlap;
        overlap = aabbMin1.y > aabbMax2.y || aabbMax1.y < aabbMin2.y ? false : overlap;
        return overlap;
    }

    public static boolean testTriangleAgainstAabb2(Vector3f[] vertices, Vector3f aabbMin, Vector3f aabbMax) {
        Vector3f p1 = vertices[0];
        Vector3f p2 = vertices[1];
        Vector3f p3 = vertices[2];
        if (Math.min(Math.min(p1.x, p2.x), p3.x) > aabbMax.x) {
            return false;
        }
        if (Math.max(Math.max(p1.x, p2.x), p3.x) < aabbMin.x) {
            return false;
        }
        if (Math.min(Math.min(p1.z, p2.z), p3.z) > aabbMax.z) {
            return false;
        }
        if (Math.max(Math.max(p1.z, p2.z), p3.z) < aabbMin.z) {
            return false;
        }
        if (Math.min(Math.min(p1.y, p2.y), p3.y) > aabbMax.y) {
            return false;
        }
        return !(Math.max(Math.max(p1.y, p2.y), p3.y) < aabbMin.y);
    }

    /*
     * WARNING - void declaration
     */
    public static void transformAabb(Vector3f vector3f, float f, Transform transform, Vector3f vector3f2, Vector3f vector3f3) {
        $Stack $Stack = $Stack.get();
        try {
            void aabbMaxOut;
            void aabbMinOut;
            void t;
            void margin;
            Vector3f halfExtents;
            $Stack $Stack2 = $Stack;
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Matrix3f();
            Vector3f halfExtentsWithMargin = $Stack.get$javax$vecmath$Vector3f();
            halfExtentsWithMargin.x = halfExtents.x + margin;
            halfExtentsWithMargin.y = halfExtents.y + margin;
            halfExtentsWithMargin.z = halfExtents.z + margin;
            Matrix3f abs_b = $Stack.get$javax$vecmath$Matrix3f(t.basis);
            MatrixUtil.absolute(abs_b);
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f center = $Stack.get$javax$vecmath$Vector3f(t.origin);
            Vector3f extent = $Stack.get$javax$vecmath$Vector3f();
            abs_b.getRow(0, tmp);
            extent.x = tmp.dot(halfExtentsWithMargin);
            abs_b.getRow(1, tmp);
            extent.y = tmp.dot(halfExtentsWithMargin);
            abs_b.getRow(2, tmp);
            extent.z = tmp.dot(halfExtentsWithMargin);
            aabbMinOut.sub(center, extent);
            aabbMaxOut.add(center, extent);
            $Stack $Stack3 = $Stack;
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Matrix3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Matrix3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void transformAabb(Vector3f vector3f, Vector3f vector3f2, float f, Transform transform, Vector3f vector3f3, Vector3f vector3f4) {
        $Stack $Stack = $Stack.get();
        try {
            void aabbMaxOut;
            void aabbMinOut;
            void trans;
            void margin;
            void localAabbMax;
            Vector3f localAabbMin;
            $Stack $Stack2 = $Stack;
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Matrix3f();
            assert (localAabbMin.x <= localAabbMax.x);
            assert (localAabbMin.y <= localAabbMax.y);
            assert (localAabbMin.z <= localAabbMax.z);
            Vector3f localHalfExtents = $Stack.get$javax$vecmath$Vector3f();
            localHalfExtents.sub((Tuple3f)localAabbMax, localAabbMin);
            localHalfExtents.scale(0.5f);
            localHalfExtents.x += margin;
            localHalfExtents.y += margin;
            localHalfExtents.z += margin;
            Vector3f localCenter = $Stack.get$javax$vecmath$Vector3f();
            localCenter.add((Tuple3f)localAabbMax, localAabbMin);
            localCenter.scale(0.5f);
            Matrix3f abs_b = $Stack.get$javax$vecmath$Matrix3f(trans.basis);
            MatrixUtil.absolute(abs_b);
            Vector3f center = $Stack.get$javax$vecmath$Vector3f(localCenter);
            trans.transform(center);
            Vector3f extent = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            abs_b.getRow(0, tmp);
            extent.x = tmp.dot(localHalfExtents);
            abs_b.getRow(1, tmp);
            extent.y = tmp.dot(localHalfExtents);
            abs_b.getRow(2, tmp);
            extent.z = tmp.dot(localHalfExtents);
            aabbMinOut.sub(center, extent);
            aabbMaxOut.add(center, extent);
            $Stack $Stack3 = $Stack;
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Matrix3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Matrix3f();
            throw throwable;
        }
    }
}

