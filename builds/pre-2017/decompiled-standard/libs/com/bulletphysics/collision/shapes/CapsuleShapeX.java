/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.collision.shapes.CapsuleShape;

public class CapsuleShapeX
extends CapsuleShape {
    public CapsuleShapeX(float radius, float height) {
        this.upAxis = 0;
        this.implicitShapeDimensions.set(0.5f * height, radius, radius);
    }

    @Override
    public String getName() {
        return "CapsuleX";
    }
}

