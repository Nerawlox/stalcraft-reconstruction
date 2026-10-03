/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.collision.shapes.CapsuleShape;

public class CapsuleShapeZ
extends CapsuleShape {
    public CapsuleShapeZ(float radius, float height) {
        this.upAxis = 2;
        this.implicitShapeDimensions.set(radius, radius, 0.5f * height);
    }

    @Override
    public String getName() {
        return "CapsuleZ";
    }
}

