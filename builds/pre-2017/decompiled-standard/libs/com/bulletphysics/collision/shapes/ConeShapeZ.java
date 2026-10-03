/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.collision.shapes.ConeShape;

public class ConeShapeZ
extends ConeShape {
    public ConeShapeZ(float radius, float height) {
        super(radius, height);
        this.setConeUpIndex(2);
    }
}

