/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.shapes.TriangleShape;
import com.bulletphysics.extras.gimpact.BoxCollision;
import com.bulletphysics.extras.gimpact.ClipPolygon;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

public class TriangleShapeEx
extends TriangleShape {
    public TriangleShapeEx() {
    }

    public TriangleShapeEx(Vector3f p0, Vector3f p1, Vector3f p2) {
        super(p0, p1, p2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void getAabb(Transform transform, Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void aabbMax;
            void aabbMin;
            void t;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            $Stack2.push$javax$vecmath$Vector3f();
            Vector3f tv0 = $Stack.get$javax$vecmath$Vector3f(this.vertices1[0]);
            t.transform(tv0);
            Vector3f tv1 = $Stack.get$javax$vecmath$Vector3f(this.vertices1[1]);
            t.transform(tv1);
            Vector3f tv2 = $Stack.get$javax$vecmath$Vector3f(this.vertices1[2]);
            t.transform(tv2);
            BoxCollision.AABB trianglebox = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            trianglebox.init(tv0, tv1, tv2, this.collisionMargin);
            aabbMin.set(trianglebox.min);
            aabbMax.set(trianglebox.max);
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            $Stack3.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            $Stack4.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void applyTransform(Transform t) {
        t.transform(this.vertices1[0]);
        t.transform(this.vertices1[1]);
        t.transform(this.vertices1[2]);
    }

    /*
     * WARNING - void declaration
     */
    public void buildTriPlane(Vector4f vector4f) {
        $Stack $Stack = $Stack.get();
        try {
            void plane;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f normal = $Stack.get$javax$vecmath$Vector3f();
            tmp1.sub(this.vertices1[1], this.vertices1[0]);
            tmp2.sub(this.vertices1[2], this.vertices1[0]);
            normal.cross(tmp1, tmp2);
            normal.normalize();
            plane.set(normal.x, normal.y, normal.z, this.vertices1[0].dot(normal));
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
    public boolean overlap_test_conservative(TriangleShapeEx triangleShapeEx) {
        $Stack $Stack = $Stack.get();
        try {
            void other;
            $Stack.push$javax$vecmath$Vector4f();
            float total_margin = this.getMargin() + other.getMargin();
            Vector4f plane0 = $Stack.get$javax$vecmath$Vector4f();
            this.buildTriPlane(plane0);
            Vector4f plane1 = $Stack.get$javax$vecmath$Vector4f();
            other.buildTriPlane(plane1);
            float dis0 = ClipPolygon.distance_point_plane(plane0, other.vertices1[0]) - total_margin;
            float dis1 = ClipPolygon.distance_point_plane(plane0, other.vertices1[1]) - total_margin;
            float dis2 = ClipPolygon.distance_point_plane(plane0, other.vertices1[2]) - total_margin;
            if (dis0 > 0.0f && dis1 > 0.0f && dis2 > 0.0f) {
                $Stack.pop$javax$vecmath$Vector4f();
                return false;
            }
            dis0 = ClipPolygon.distance_point_plane(plane1, this.vertices1[0]) - total_margin;
            dis1 = ClipPolygon.distance_point_plane(plane1, this.vertices1[1]) - total_margin;
            dis2 = ClipPolygon.distance_point_plane(plane1, this.vertices1[2]) - total_margin;
            if (dis0 > 0.0f && dis1 > 0.0f && dis2 > 0.0f) {
                $Stack.pop$javax$vecmath$Vector4f();
                return false;
            }
            $Stack.pop$javax$vecmath$Vector4f();
            return true;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector4f();
            throw throwable;
        }
    }
}

