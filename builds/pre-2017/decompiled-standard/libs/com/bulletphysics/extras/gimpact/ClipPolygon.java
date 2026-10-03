/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.linearmath.VectorUtil;
import com.bulletphysics.util.ArrayPool;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

class ClipPolygon {
    ClipPolygon() {
    }

    public static float distance_point_plane(Vector4f plane, Vector3f point) {
        return VectorUtil.dot3(point, plane) - plane.w;
    }

    public static void vec_blend(Vector3f vr, Vector3f va, Vector3f vb, float blend_factor) {
        vr.scale(1.0f - blend_factor, va);
        vr.scaleAdd(blend_factor, vb, vr);
    }

    public static void plane_clip_polygon_collect(Vector3f point0, Vector3f point1, float dist0, float dist1, ObjectArrayList<Vector3f> clipped, int[] clipped_count) {
        boolean _classif;
        boolean _prevclassif = dist0 > 1.1920929E-7f;
        boolean bl = _classif = dist1 > 1.1920929E-7f;
        if (_classif != _prevclassif) {
            float blendfactor = -dist0 / (dist1 - dist0);
            ClipPolygon.vec_blend(clipped.getQuick(clipped_count[0]), point0, point1, blendfactor);
            clipped_count[0] = clipped_count[0] + 1;
        }
        if (!_classif) {
            clipped.getQuick(clipped_count[0]).set(point1);
            clipped_count[0] = clipped_count[0] + 1;
        }
    }

    public static int plane_clip_polygon(Vector4f plane, ObjectArrayList<Vector3f> polygon_points, int polygon_point_count, ObjectArrayList<Vector3f> clipped) {
        ArrayPool<int[]> intArrays = ArrayPool.get(Integer.TYPE);
        int[] clipped_count = (int[])intArrays.getFixed(1);
        clipped_count[0] = 0;
        float firstdist = ClipPolygon.distance_point_plane(plane, polygon_points.getQuick(0));
        if (!(firstdist > 1.1920929E-7f)) {
            clipped.getQuick(clipped_count[0]).set(polygon_points.getQuick(0));
            clipped_count[0] = clipped_count[0] + 1;
        }
        float olddist = firstdist;
        for (int i = 1; i < polygon_point_count; ++i) {
            float dist = ClipPolygon.distance_point_plane(plane, polygon_points.getQuick(i));
            ClipPolygon.plane_clip_polygon_collect(polygon_points.getQuick(i - 1), polygon_points.getQuick(i), olddist, dist, clipped, clipped_count);
            olddist = dist;
        }
        ClipPolygon.plane_clip_polygon_collect(polygon_points.getQuick(polygon_point_count - 1), polygon_points.getQuick(0), olddist, firstdist, clipped, clipped_count);
        int ret = clipped_count[0];
        intArrays.release(clipped_count);
        return ret;
    }

    public static int plane_clip_triangle(Vector4f plane, Vector3f point0, Vector3f point1, Vector3f point2, ObjectArrayList<Vector3f> clipped) {
        ArrayPool<int[]> intArrays = ArrayPool.get(Integer.TYPE);
        int[] clipped_count = (int[])intArrays.getFixed(1);
        clipped_count[0] = 0;
        float firstdist = ClipPolygon.distance_point_plane(plane, point0);
        if (!(firstdist > 1.1920929E-7f)) {
            clipped.getQuick(clipped_count[0]).set(point0);
            clipped_count[0] = clipped_count[0] + 1;
        }
        float olddist = firstdist;
        float dist = ClipPolygon.distance_point_plane(plane, point1);
        ClipPolygon.plane_clip_polygon_collect(point0, point1, olddist, dist, clipped, clipped_count);
        olddist = dist;
        dist = ClipPolygon.distance_point_plane(plane, point2);
        ClipPolygon.plane_clip_polygon_collect(point1, point2, olddist, dist, clipped, clipped_count);
        olddist = dist;
        ClipPolygon.plane_clip_polygon_collect(point2, point0, olddist, firstdist, clipped, clipped_count);
        int ret = clipped_count[0];
        intArrays.release(clipped_count);
        return ret;
    }
}

