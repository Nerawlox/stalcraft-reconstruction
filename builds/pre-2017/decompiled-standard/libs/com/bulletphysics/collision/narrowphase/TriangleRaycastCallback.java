/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.narrowphase;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.shapes.TriangleCallback;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public abstract class TriangleRaycastCallback
extends TriangleCallback {
    public final Vector3f from = new Vector3f();
    public final Vector3f to = new Vector3f();
    public float hitFraction;

    public TriangleRaycastCallback(Vector3f from, Vector3f to) {
        this.from.set(from);
        this.to.set(to);
        this.hitFraction = 1.0f;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void processTriangle(Vector3f[] vector3fArray, int n, int n2) {
        $Stack $Stack = $Stack.get();
        try {
            void triangle;
            $Stack.push$javax$vecmath$Vector3f();
            void vert0 = triangle[0];
            void vert1 = triangle[1];
            void vert2 = triangle[2];
            Vector3f v10 = $Stack.get$javax$vecmath$Vector3f();
            v10.sub((Tuple3f)vert1, (Tuple3f)vert0);
            Vector3f v20 = $Stack.get$javax$vecmath$Vector3f();
            v20.sub((Tuple3f)vert2, (Tuple3f)vert0);
            Vector3f triangleNormal = $Stack.get$javax$vecmath$Vector3f();
            triangleNormal.cross(v10, v20);
            float dist = vert0.dot(triangleNormal);
            float dist_a = triangleNormal.dot(this.from);
            dist_a -= dist;
            float dist_b = triangleNormal.dot(this.to);
            dist_b -= dist;
            if (dist_a * dist_b >= 0.0f) {
                $Stack.pop$javax$vecmath$Vector3f();
                return;
            }
            float proj_length = dist_a - dist_b;
            float distance = dist_a / proj_length;
            if (distance < this.hitFraction) {
                float edge_tolerance = triangleNormal.lengthSquared();
                edge_tolerance *= -1.0E-4f;
                Vector3f point = new Vector3f();
                VectorUtil.setInterpolate3(point, this.from, this.to, distance);
                Vector3f v0p = $Stack.get$javax$vecmath$Vector3f();
                v0p.sub((Tuple3f)vert0, point);
                Vector3f v1p = $Stack.get$javax$vecmath$Vector3f();
                v1p.sub((Tuple3f)vert1, point);
                Vector3f cp0 = $Stack.get$javax$vecmath$Vector3f();
                cp0.cross(v0p, v1p);
                if (cp0.dot(triangleNormal) >= edge_tolerance) {
                    Vector3f v2p = $Stack.get$javax$vecmath$Vector3f();
                    v2p.sub((Tuple3f)vert2, point);
                    Vector3f cp1 = $Stack.get$javax$vecmath$Vector3f();
                    cp1.cross(v1p, v2p);
                    if (cp1.dot(triangleNormal) >= edge_tolerance) {
                        Vector3f cp2 = $Stack.get$javax$vecmath$Vector3f();
                        cp2.cross(v2p, v0p);
                        if (cp2.dot(triangleNormal) >= edge_tolerance) {
                            void triangleIndex;
                            void partId;
                            if (dist_a > 0.0f) {
                                this.hitFraction = this.reportHit(triangleNormal, distance, (int)partId, (int)triangleIndex);
                            } else {
                                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                                tmp.negate(triangleNormal);
                                this.hitFraction = this.reportHit(tmp, distance, (int)partId, (int)triangleIndex);
                            }
                        }
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

    public abstract float reportHit(Vector3f var1, float var2, int var3, int var4);
}

