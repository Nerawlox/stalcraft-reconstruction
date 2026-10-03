/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public abstract class VertexData {
    public abstract int getVertexCount();

    public abstract int getIndexCount();

    public abstract <T extends Tuple3f> T getVertex(int var1, T var2);

    public abstract void setVertex(int var1, float var2, float var3, float var4);

    public void setVertex(int idx, Tuple3f t) {
        this.setVertex(idx, t.x, t.y, t.z);
    }

    public abstract int getIndex(int var1);

    public void getTriangle(int firstIndex, Vector3f scale, Vector3f[] triangle) {
        for (int i = 0; i < 3; ++i) {
            this.getVertex(this.getIndex(firstIndex + i), triangle[i]);
            VectorUtil.mul(triangle[i], triangle[i], scale);
        }
    }
}

