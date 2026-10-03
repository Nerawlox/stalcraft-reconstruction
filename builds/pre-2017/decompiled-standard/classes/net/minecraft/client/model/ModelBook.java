/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class ModelBook
extends ModelBase {
    public ModelRenderer field_78102_a = new ModelRenderer(this).func_78784_a(0, 0).func_78789_a(-6.0f, -5.0f, 0.0f, 6, 10, 0);
    public ModelRenderer field_78100_b = new ModelRenderer(this).func_78784_a(16, 0).func_78789_a(0.0f, -5.0f, 0.0f, 6, 10, 0);
    public ModelRenderer field_78101_c;
    public ModelRenderer field_78098_d;
    public ModelRenderer field_78099_e;
    public ModelRenderer field_78096_f;
    public ModelRenderer field_78097_g = new ModelRenderer(this).func_78784_a(12, 0).func_78789_a(-1.0f, -5.0f, 0.0f, 2, 10, 0);

    public ModelBook() {
        this.field_78101_c = new ModelRenderer(this).func_78784_a(0, 10).func_78789_a(0.0f, -4.0f, -0.99f, 5, 8, 1);
        this.field_78098_d = new ModelRenderer(this).func_78784_a(12, 10).func_78789_a(0.0f, -4.0f, -0.01f, 5, 8, 1);
        this.field_78099_e = new ModelRenderer(this).func_78784_a(24, 10).func_78789_a(0.0f, -4.0f, 0.0f, 5, 8, 0);
        this.field_78096_f = new ModelRenderer(this).func_78784_a(24, 10).func_78789_a(0.0f, -4.0f, 0.0f, 5, 8, 0);
        this.field_78102_a.func_78793_a(0.0f, 0.0f, -1.0f);
        this.field_78100_b.func_78793_a(0.0f, 0.0f, 1.0f);
        this.field_78097_g.field_78796_g = 1.5707964f;
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.field_78102_a.func_78785_a(f6);
        this.field_78100_b.func_78785_a(f6);
        this.field_78097_g.func_78785_a(f6);
        this.field_78101_c.func_78785_a(f6);
        this.field_78098_d.func_78785_a(f6);
        this.field_78099_e.func_78785_a(f6);
        this.field_78096_f.func_78785_a(f6);
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        float f7 = (sajh._a(f * 0.02f) * 0.1f + 1.25f) * f4;
        this.field_78102_a.field_78796_g = (float)Math.PI + f7;
        this.field_78100_b.field_78796_g = -f7;
        this.field_78101_c.field_78796_g = f7;
        this.field_78098_d.field_78796_g = -f7;
        this.field_78099_e.field_78796_g = f7 - f7 * 2.0f * f2;
        this.field_78096_f.field_78796_g = f7 - f7 * 2.0f * f3;
        this.field_78101_c.field_78800_c = sajh._a(f7);
        this.field_78098_d.field_78800_c = sajh._a(f7);
        this.field_78099_e.field_78800_c = sajh._a(f7);
        this.field_78096_f.field_78800_c = sajh._a(f7);
    }
}

