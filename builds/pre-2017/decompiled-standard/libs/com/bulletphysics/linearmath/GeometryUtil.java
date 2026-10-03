/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath;

import com.bulletphysics.$Stack;
import com.bulletphysics.linearmath.VectorUtil;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

public class GeometryUtil {
    public static boolean isPointInsidePlanes(ObjectArrayList<Vector4f> planeEquations, Vector3f point, float margin) {
        int numbrushes = planeEquations.size();
        for (int i = 0; i < numbrushes; ++i) {
            Vector4f N1 = planeEquations.getQuick(i);
            float dist = VectorUtil.dot3(N1, point) + N1.w - margin;
            if (!(dist > 0.0f)) continue;
            return false;
        }
        return true;
    }

    public static boolean areVerticesBehindPlane(Vector4f planeNormal, ObjectArrayList<Vector3f> vertices, float margin) {
        int numvertices = vertices.size();
        for (int i = 0; i < numvertices; ++i) {
            Vector3f N1 = vertices.getQuick(i);
            float dist = VectorUtil.dot3(planeNormal, N1) + planeNormal.w - margin;
            if (!(dist > 0.0f)) continue;
            return false;
        }
        return true;
    }

    private static boolean notExist(Vector4f planeEquation, ObjectArrayList<Vector4f> planeEquations) {
        int numbrushes = planeEquations.size();
        for (int i = 0; i < numbrushes; ++i) {
            Vector4f N1 = planeEquations.getQuick(i);
            if (!(VectorUtil.dot3(planeEquation, N1) > 0.999f)) continue;
            return false;
        }
        return true;
    }

    /*
     * WARNING - void declaration
     */
    public static void getPlaneEquationsFromVertices(ObjectArrayList<Vector3f> objectArrayList, ObjectArrayList<Vector4f> objectArrayList2) {
        $Stack $Stack = $Stack.get();
        try {
            ObjectArrayList<Vector3f> vertices;
            $Stack $Stack2 = $Stack;
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Vector4f();
            Vector4f planeEquation = $Stack.get$javax$vecmath$Vector4f();
            Vector3f edge0 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f edge1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            int numvertices = vertices.size();
            for (int i = 0; i < numvertices; ++i) {
                Vector3f N1 = vertices.getQuick(i);
                for (int j = i + 1; j < numvertices; ++j) {
                    Vector3f N2 = vertices.getQuick(j);
                    for (int k = j + 1; k < numvertices; ++k) {
                        Vector3f N3 = vertices.getQuick(k);
                        edge0.sub(N2, N1);
                        edge1.sub(N3, N1);
                        float normalSign = 1.0f;
                        for (int ww = 0; ww < 2; ++ww) {
                            tmp.cross(edge0, edge1);
                            planeEquation.x = normalSign * tmp.x;
                            planeEquation.y = normalSign * tmp.y;
                            planeEquation.z = normalSign * tmp.z;
                            if (VectorUtil.lengthSquared3(planeEquation) > 1.0E-4f) {
                                void planeEquationsOut;
                                VectorUtil.normalize3(planeEquation);
                                if (GeometryUtil.notExist(planeEquation, (ObjectArrayList<Vector4f>)planeEquationsOut)) {
                                    planeEquation.w = -VectorUtil.dot3(planeEquation, N1);
                                    if (GeometryUtil.areVerticesBehindPlane(planeEquation, vertices, 0.01f)) {
                                        planeEquationsOut.add(new Vector4f(planeEquation));
                                    }
                                }
                            }
                            normalSign = -1.0f;
                        }
                    }
                }
            }
            $Stack $Stack3 = $Stack;
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Vector4f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Vector4f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void getVerticesFromPlaneEquations(ObjectArrayList<Vector4f> objectArrayList, ObjectArrayList<Vector3f> objectArrayList2) {
        $Stack $Stack = $Stack.get();
        try {
            ObjectArrayList<Vector4f> planeEquations;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f n2n3 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f n3n1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f n1n2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f potentialVertex = $Stack.get$javax$vecmath$Vector3f();
            int numbrushes = planeEquations.size();
            for (int i = 0; i < numbrushes; ++i) {
                Vector4f N1 = planeEquations.getQuick(i);
                for (int j = i + 1; j < numbrushes; ++j) {
                    Vector4f N2 = planeEquations.getQuick(j);
                    for (int k = j + 1; k < numbrushes; ++k) {
                        void verticesOut;
                        float quotient;
                        Vector4f N3 = planeEquations.getQuick(k);
                        VectorUtil.cross3(n2n3, N2, N3);
                        VectorUtil.cross3(n3n1, N3, N1);
                        VectorUtil.cross3(n1n2, N1, N2);
                        if (!(n2n3.lengthSquared() > 1.0E-4f) || !(n3n1.lengthSquared() > 1.0E-4f) || !(n1n2.lengthSquared() > 1.0E-4f) || !(Math.abs(quotient = VectorUtil.dot3(N1, n2n3)) > 1.0E-6f)) continue;
                        quotient = -1.0f / quotient;
                        n2n3.scale(N1.w);
                        n3n1.scale(N2.w);
                        n1n2.scale(N3.w);
                        potentialVertex.set(n2n3);
                        potentialVertex.add(n3n1);
                        potentialVertex.add(n1n2);
                        potentialVertex.scale(quotient);
                        if (!GeometryUtil.isPointInsidePlanes(planeEquations, potentialVertex, 0.01f)) continue;
                        verticesOut.add(new Vector3f(potentialVertex));
                    }
                }
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }
}

