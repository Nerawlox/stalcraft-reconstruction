/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.$Stack;
import com.bulletphysics.extras.gimpact.ClipPolygon;
import com.bulletphysics.extras.gimpact.GeometryOperations;
import com.bulletphysics.extras.gimpact.TriangleContact;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

public class PrimitiveTriangle {
    private final ObjectArrayList<Vector3f> tmpVecList1 = new ObjectArrayList(16);
    private final ObjectArrayList<Vector3f> tmpVecList2 = new ObjectArrayList(16);
    private final ObjectArrayList<Vector3f> tmpVecList3 = new ObjectArrayList(16);
    public final Vector3f[] vertices;
    public final Vector4f plane;
    public float margin;

    public PrimitiveTriangle() {
        int i;
        for (i = 0; i < 16; ++i) {
            this.tmpVecList1.add(new Vector3f());
            this.tmpVecList2.add(new Vector3f());
            this.tmpVecList3.add(new Vector3f());
        }
        this.vertices = new Vector3f[3];
        this.plane = new Vector4f();
        this.margin = 0.01f;
        for (i = 0; i < this.vertices.length; ++i) {
            this.vertices[i] = new Vector3f();
        }
    }

    public void set(PrimitiveTriangle tri) {
        throw new UnsupportedOperationException();
    }

    public void buildTriPlane() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f normal = $Stack.get$javax$vecmath$Vector3f();
            tmp1.sub(this.vertices[1], this.vertices[0]);
            tmp2.sub(this.vertices[2], this.vertices[0]);
            normal.cross(tmp1, tmp2);
            normal.normalize();
            this.plane.set(normal.x, normal.y, normal.z, this.vertices[0].dot(normal));
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public boolean overlap_test_conservative(PrimitiveTriangle other) {
        float total_margin = this.margin + other.margin;
        float dis0 = ClipPolygon.distance_point_plane(this.plane, other.vertices[0]) - total_margin;
        float dis1 = ClipPolygon.distance_point_plane(this.plane, other.vertices[1]) - total_margin;
        float dis2 = ClipPolygon.distance_point_plane(this.plane, other.vertices[2]) - total_margin;
        if (dis0 > 0.0f && dis1 > 0.0f && dis2 > 0.0f) {
            return false;
        }
        dis0 = ClipPolygon.distance_point_plane(other.plane, this.vertices[0]) - total_margin;
        dis1 = ClipPolygon.distance_point_plane(other.plane, this.vertices[1]) - total_margin;
        dis2 = ClipPolygon.distance_point_plane(other.plane, this.vertices[2]) - total_margin;
        return !(dis0 > 0.0f) || !(dis1 > 0.0f) || !(dis2 > 0.0f);
    }

    /*
     * WARNING - void declaration
     */
    public void get_edge_plane(int n, Vector4f vector4f) {
        $Stack $Stack = $Stack.get();
        try {
            void plane;
            void edge_index;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f e0 = this.vertices[edge_index];
            Vector3f e1 = this.vertices[(edge_index + true) % 3];
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            tmp.set(this.plane.x, this.plane.y, this.plane.z);
            GeometryOperations.edge_plane(e0, e1, tmp, (Vector4f)plane);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void applyTransform(Transform t) {
        t.transform(this.vertices[0]);
        t.transform(this.vertices[1]);
        t.transform(this.vertices[2]);
    }

    /*
     * WARNING - void declaration
     */
    public int clip_triangle(PrimitiveTriangle primitiveTriangle, ObjectArrayList<Vector3f> objectArrayList) {
        $Stack $Stack = $Stack.get();
        try {
            void clipped_points;
            void other;
            $Stack.push$javax$vecmath$Vector4f();
            ObjectArrayList<Vector3f> temp_points = this.tmpVecList1;
            Vector4f edgeplane = $Stack.get$javax$vecmath$Vector4f();
            this.get_edge_plane(0, edgeplane);
            int clipped_count = ClipPolygon.plane_clip_triangle(edgeplane, other.vertices[0], other.vertices[1], other.vertices[2], temp_points);
            if (clipped_count == 0) {
                $Stack.pop$javax$vecmath$Vector4f();
                return 0;
            }
            ObjectArrayList<Vector3f> temp_points1 = this.tmpVecList2;
            this.get_edge_plane(1, edgeplane);
            clipped_count = ClipPolygon.plane_clip_polygon(edgeplane, temp_points, clipped_count, temp_points1);
            if (clipped_count == 0) {
                $Stack.pop$javax$vecmath$Vector4f();
                return 0;
            }
            this.get_edge_plane(2, edgeplane);
            clipped_count = ClipPolygon.plane_clip_polygon(edgeplane, temp_points1, clipped_count, (ObjectArrayList<Vector3f>)clipped_points);
            $Stack.pop$javax$vecmath$Vector4f();
            return clipped_count;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector4f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public boolean find_triangle_collision_clip_method(PrimitiveTriangle primitiveTriangle, TriangleContact triangleContact) {
        $Stack $Stack = $Stack.get();
        try {
            void contacts;
            void other;
            $Stack.push$com$bulletphysics$extras$gimpact$TriangleContact();
            float margin = this.margin + other.margin;
            ObjectArrayList<Vector3f> clipped_points = this.tmpVecList3;
            TriangleContact contacts1 = $Stack.get$com$bulletphysics$extras$gimpact$TriangleContact();
            contacts1.separating_normal.set(this.plane);
            int clipped_count = this.clip_triangle((PrimitiveTriangle)other, clipped_points);
            if (clipped_count == 0) {
                $Stack.pop$com$bulletphysics$extras$gimpact$TriangleContact();
                return false;
            }
            contacts1.merge_points(contacts1.separating_normal, margin, clipped_points, clipped_count);
            if (contacts1.point_count == 0) {
                $Stack.pop$com$bulletphysics$extras$gimpact$TriangleContact();
                return false;
            }
            contacts1.separating_normal.x *= -1.0f;
            contacts1.separating_normal.y *= -1.0f;
            contacts1.separating_normal.z *= -1.0f;
            TriangleContact contacts2 = $Stack.get$com$bulletphysics$extras$gimpact$TriangleContact();
            contacts2.separating_normal.set(other.plane);
            clipped_count = other.clip_triangle(this, clipped_points);
            if (clipped_count == 0) {
                $Stack.pop$com$bulletphysics$extras$gimpact$TriangleContact();
                return false;
            }
            contacts2.merge_points(contacts2.separating_normal, margin, clipped_points, clipped_count);
            if (contacts2.point_count == 0) {
                $Stack.pop$com$bulletphysics$extras$gimpact$TriangleContact();
                return false;
            }
            if (contacts2.penetration_depth < contacts1.penetration_depth) {
                contacts.copy_from(contacts2);
            } else {
                contacts.copy_from(contacts1);
            }
            $Stack.pop$com$bulletphysics$extras$gimpact$TriangleContact();
            return true;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$extras$gimpact$TriangleContact();
            throw throwable;
        }
    }
}

