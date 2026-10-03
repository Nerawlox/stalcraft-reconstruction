/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.collision.shapes.ScalarType;
import com.bulletphysics.collision.shapes.VertexData;
import java.nio.ByteBuffer;
import javax.vecmath.Tuple3f;

public class ByteBufferVertexData
extends VertexData {
    public ByteBuffer vertexData;
    public int vertexCount;
    public int vertexStride;
    public ScalarType vertexType;
    public ByteBuffer indexData;
    public int indexCount;
    public int indexStride;
    public ScalarType indexType;

    @Override
    public int getVertexCount() {
        return this.vertexCount;
    }

    @Override
    public int getIndexCount() {
        return this.indexCount;
    }

    @Override
    public <T extends Tuple3f> T getVertex(int idx, T out) {
        int off = idx * this.vertexStride;
        out.x = this.vertexData.getFloat(off + 0);
        out.y = this.vertexData.getFloat(off + 4);
        out.z = this.vertexData.getFloat(off + 8);
        return out;
    }

    @Override
    public void setVertex(int idx, float x, float y, float z) {
        int off = idx * this.vertexStride;
        this.vertexData.putFloat(off + 0, x);
        this.vertexData.putFloat(off + 4, y);
        this.vertexData.putFloat(off + 8, z);
    }

    @Override
    public int getIndex(int idx) {
        if (this.indexType == ScalarType.SHORT) {
            return this.indexData.getShort(idx * this.indexStride) & 0xFFFF;
        }
        if (this.indexType == ScalarType.INTEGER) {
            return this.indexData.getInt(idx * this.indexStride);
        }
        throw new IllegalStateException("indicies type must be short or integer");
    }
}

