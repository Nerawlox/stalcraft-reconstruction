/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class ModelZombie
extends ModelBiped {
    public ModelZombie() {
        this(0.0f, false);
    }

    public ModelZombie(float f, float f2, int n, int n2) {
        super(f, f2, n, n2);
    }

    public ModelZombie(float f, boolean bl) {
        super(f, 0.0f, 64, bl ? 32 : 64);
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        float f7 = sajh._a(this.field_78095_p * (float)Math.PI);
        float f8 = sajh._a((1.0f - (1.0f - this.field_78095_p) * (1.0f - this.field_78095_p)) * (float)Math.PI);
        this.field_78112_f.field_78808_h = 0.0f;
        this.field_78113_g.field_78808_h = 0.0f;
        this.field_78112_f.field_78796_g = -(0.1f - f7 * 0.6f);
        this.field_78113_g.field_78796_g = 0.1f - f7 * 0.6f;
        this.field_78112_f.field_78795_f = -1.5707964f;
        this.field_78113_g.field_78795_f = -1.5707964f;
        this.field_78112_f.field_78795_f -= f7 * 1.2f - f8 * 0.4f;
        this.field_78113_g.field_78795_f -= f7 * 1.2f - f8 * 0.4f;
        this.field_78112_f.field_78808_h += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
        this.field_78113_g.field_78808_h -= sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
        this.field_78112_f.field_78795_f += sajh._a(f3 * 0.067f) * 0.05f;
        this.field_78113_g.field_78795_f -= sajh._a(f3 * 0.067f) * 0.05f;
    }
}

