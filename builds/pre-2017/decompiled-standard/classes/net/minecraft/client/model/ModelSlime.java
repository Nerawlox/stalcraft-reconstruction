/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSlime
extends ModelBase {
    public ModelRenderer field_78200_a;
    public ModelRenderer field_78198_b;
    public ModelRenderer field_78199_c;
    public ModelRenderer field_78197_d;

    public ModelSlime(int n) {
        this.field_78200_a = new ModelRenderer(this, 0, n);
        this.field_78200_a.func_78789_a(-4.0f, 16.0f, -4.0f, 8, 8, 8);
        if (n > 0) {
            this.field_78200_a = new ModelRenderer(this, 0, n);
            this.field_78200_a.func_78789_a(-3.0f, 17.0f, -3.0f, 6, 6, 6);
            this.field_78198_b = new ModelRenderer(this, 32, 0);
            this.field_78198_b.func_78789_a(-3.25f, 18.0f, -3.5f, 2, 2, 2);
            this.field_78199_c = new ModelRenderer(this, 32, 4);
            this.field_78199_c.func_78789_a(1.25f, 18.0f, -3.5f, 2, 2, 2);
            this.field_78197_d = new ModelRenderer(this, 32, 8);
            this.field_78197_d.func_78789_a(0.0f, 21.0f, -3.5f, 1, 1, 1);
        }
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.field_78200_a.func_78785_a(f6);
        if (this.field_78198_b != null) {
            this.field_78198_b.func_78785_a(f6);
            this.field_78199_c.func_78785_a(f6);
            this.field_78197_d.func_78785_a(f6);
        }
    }
}

