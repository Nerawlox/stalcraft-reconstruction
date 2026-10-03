/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath.convexhull;

import com.bulletphysics.util.IntArrayList;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;

class PHullResult {
    public int vcount = 0;
    public int indexCount = 0;
    public int faceCount = 0;
    public ObjectArrayList<Vector3f> vertices = null;
    public IntArrayList indices = new IntArrayList();

    PHullResult() {
    }
}

