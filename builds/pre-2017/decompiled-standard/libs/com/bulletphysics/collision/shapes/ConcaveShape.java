/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.TriangleCallback;
import javax.vecmath.Vector3f;

public abstract class ConcaveShape
extends CollisionShape {
    protected float collisionMargin = 0.0f;

    public abstract void processAllTriangles(TriangleCallback var1, Vector3f var2, Vector3f var3);

    @Override
    public float getMargin() {
        return this.collisionMargin;
    }

    @Override
    public void setMargin(float margin) {
        this.collisionMargin = margin;
    }
}

