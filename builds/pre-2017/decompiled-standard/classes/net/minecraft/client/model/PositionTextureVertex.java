/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.util.ofbx;

public class PositionTextureVertex {
    public ofbx field_78243_a;
    public float field_78241_b;
    public float field_78242_c;

    public PositionTextureVertex(float f, float f2, float f3, float f4, float f5) {
        this(ofbx._a(f, f2, f3), f4, f5);
    }

    public PositionTextureVertex func_78240_a(float f, float f2) {
        return new PositionTextureVertex(this, f, f2);
    }

    public PositionTextureVertex(PositionTextureVertex positionTextureVertex, float f, float f2) {
        this.field_78243_a = positionTextureVertex.field_78243_a;
        this.field_78241_b = f;
        this.field_78242_c = f2;
    }

    public PositionTextureVertex(ofbx ofbx2, float f, float f2) {
        this.field_78243_a = ofbx2;
        this.field_78241_b = f;
        this.field_78242_c = f2;
    }
}

