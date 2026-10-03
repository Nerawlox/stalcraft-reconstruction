/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.extras.gimpact.ClipPolygon;
import com.bulletphysics.util.ArrayPool;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

public class TriangleContact {
    private final ArrayPool<int[]> intArrays = ArrayPool.get(Integer.TYPE);
    public static final int MAX_TRI_CLIPPING = 16;
    public float penetration_depth;
    public int point_count;
    public final Vector4f separating_normal = new Vector4f();
    public Vector3f[] points = new Vector3f[16];

    public TriangleContact() {
        for (int i = 0; i < this.points.length; ++i) {
            this.points[i] = new Vector3f();
        }
    }

    public TriangleContact(TriangleContact other) {
        this.copy_from(other);
    }

    public void set(TriangleContact other) {
        this.copy_from(other);
    }

    public void copy_from(TriangleContact other) {
        this.penetration_depth = other.penetration_depth;
        this.separating_normal.set(other.separating_normal);
        int i = this.point_count = other.point_count;
        while (i-- != 0) {
            this.points[i].set(other.points[i]);
        }
    }

    public void merge_points(Vector4f plane, float margin, ObjectArrayList<Vector3f> points, int point_count) {
        int _k;
        this.point_count = 0;
        this.penetration_depth = -1000.0f;
        int[] point_indices = this.intArrays.getFixed(16);
        for (_k = 0; _k < point_count; ++_k) {
            float _dist = -ClipPolygon.distance_point_plane(plane, points.getQuick(_k)) + margin;
            if (!(_dist >= 0.0f)) continue;
            if (_dist > this.penetration_depth) {
                this.penetration_depth = _dist;
                point_indices[0] = _k;
                this.point_count = 1;
                continue;
            }
            if (!(_dist + 1.1920929E-7f >= this.penetration_depth)) continue;
            point_indices[this.point_count] = _k;
            ++this.point_count;
        }
        for (_k = 0; _k < this.point_count; ++_k) {
            this.points[_k].set(points.getQuick(point_indices[_k]));
        }
        this.intArrays.release(point_indices);
    }
}

