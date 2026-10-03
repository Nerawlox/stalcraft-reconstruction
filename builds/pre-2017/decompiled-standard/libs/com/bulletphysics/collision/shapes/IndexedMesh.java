/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.collision.shapes.ScalarType;
import java.nio.ByteBuffer;

public class IndexedMesh {
    public int numTriangles;
    public ByteBuffer triangleIndexBase;
    public int triangleIndexStride;
    public int numVertices;
    public ByteBuffer vertexBase;
    public int vertexStride;
    public ScalarType indexType;
}

