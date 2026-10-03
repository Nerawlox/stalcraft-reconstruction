/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath.convexhull;

import com.bulletphysics.linearmath.convexhull.HullFlags;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;

public class HullDesc {
    public int flags = HullFlags.DEFAULT;
    public int vcount = 0;
    public ObjectArrayList<Vector3f> vertices;
    int vertexStride = 12;
    public float normalEpsilon = 0.001f;
    public int maxVertices = 4096;
    public int maxFaces = 4096;

    public HullDesc() {
    }

    public HullDesc(int flag, int vcount, ObjectArrayList<Vector3f> vertices) {
        this(flag, vcount, vertices, 12);
    }

    public HullDesc(int flag, int vcount, ObjectArrayList<Vector3f> vertices, int stride) {
        this.flags = flag;
        this.vcount = vcount;
        this.vertices = vertices;
        this.vertexStride = stride;
        this.normalEpsilon = 0.001f;
        this.maxVertices = 4096;
    }

    public boolean hasHullFlag(int flag) {
        return (this.flags & flag) != 0;
    }

    public void setHullFlag(int flag) {
        this.flags |= flag;
    }

    public void clearHullFlag(int flag) {
        this.flags &= ~flag;
    }
}

