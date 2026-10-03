/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSquid
extends ModelBase {
    public ModelRenderer field_78202_a;
    public ModelRenderer[] field_78201_b = new ModelRenderer[8];

    public ModelSquid() {
        int n = -16;
        this.field_78202_a = new ModelRenderer(this, 0, 0);
        this.field_78202_a.func_78789_a(-6.0f, -8.0f, -6.0f, 12, 16, 12);
        this.field_78202_a.field_78797_d += (float)(24 + n);
        for (int i = 0; i < this.field_78201_b.length; ++i) {
            this.field_78201_b[i] = new ModelRenderer(this, 48, 0);
            double d = (double)i * Math.PI * 2.0 / (double)this.field_78201_b.length;
            float f = (float)Math.cos(d) * 5.0f;
            float f2 = (float)Math.sin(d) * 5.0f;
            this.field_78201_b[i].func_78789_a(-1.0f, 0.0f, -1.0f, 2, 18, 2);
            this.field_78201_b[i].field_78800_c = f;
            this.field_78201_b[i].field_78798_e = f2;
            this.field_78201_b[i].field_78797_d = 31 + n;
            d = (double)i * Math.PI * -2.0 / (double)this.field_78201_b.length + 1.5707963267948966;
            this.field_78201_b[i].field_78796_g = (float)d;
        }
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        for (ModelRenderer modelRenderer : this.field_78201_b) {
            modelRenderer.field_78795_f = f3;
        }
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.field_78202_a.func_78785_a(f6);
        for (int i = 0; i < this.field_78201_b.length; ++i) {
            this.field_78201_b[i].func_78785_a(f6);
        }
    }
}

