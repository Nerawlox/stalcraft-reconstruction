/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath.convexhull;

import com.bulletphysics.util.IntArrayList;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;

public class HullResult {
    public boolean polygons = true;
    public int numOutputVertices = 0;
    public final ObjectArrayList<Vector3f> outputVertices = new ObjectArrayList();
    public int numFaces = 0;
    public int numIndices = 0;
    public final IntArrayList indices = new IntArrayList();
}

