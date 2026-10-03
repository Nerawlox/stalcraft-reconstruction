/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class ModelCreeper
extends ModelBase {
    public ModelRenderer field_78135_a;
    public ModelRenderer field_78133_b;
    public ModelRenderer field_78134_c;
    public ModelRenderer field_78131_d;
    public ModelRenderer field_78132_e;
    public ModelRenderer field_78129_f;
    public ModelRenderer field_78130_g;

    public ModelCreeper() {
        this(0.0f);
    }

    public ModelCreeper(float f) {
        int n = 4;
        this.field_78135_a = new ModelRenderer(this, 0, 0);
        this.field_78135_a.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, f);
        this.field_78135_a.func_78793_a(0.0f, n, 0.0f);
        this.field_78133_b = new ModelRenderer(this, 32, 0);
        this.field_78133_b.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, f + 0.5f);
        this.field_78133_b.func_78793_a(0.0f, n, 0.0f);
        this.field_78134_c = new ModelRenderer(this, 16, 16);
        this.field_78134_c.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, f);
        this.field_78134_c.func_78793_a(0.0f, n, 0.0f);
        this.field_78131_d = new ModelRenderer(this, 0, 16);
        this.field_78131_d.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, f);
        this.field_78131_d.func_78793_a(-2.0f, 12 + n, 4.0f);
        this.field_78132_e = new ModelRenderer(this, 0, 16);
        this.field_78132_e.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, f);
        this.field_78132_e.func_78793_a(2.0f, 12 + n, 4.0f);
        this.field_78129_f = new ModelRenderer(this, 0, 16);
        this.field_78129_f.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, f);
        this.field_78129_f.func_78793_a(-2.0f, 12 + n, -4.0f);
        this.field_78130_g = new ModelRenderer(this, 0, 16);
        this.field_78130_g.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, f);
        this.field_78130_g.func_78793_a(2.0f, 12 + n, -4.0f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.field_78135_a.func_78785_a(f6);
        this.field_78134_c.func_78785_a(f6);
        this.field_78131_d.func_78785_a(f6);
        this.field_78132_e.func_78785_a(f6);
        this.field_78129_f.func_78785_a(f6);
        this.field_78130_g.func_78785_a(f6);
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        this.field_78135_a.field_78796_g = f4 / 57.295776f;
        this.field_78135_a.field_78795_f = f5 / 57.295776f;
        this.field_78131_d.field_78795_f = sajh._b(f * 0.6662f) * 1.4f * f2;
        this.field_78132_e.field_78795_f = sajh._b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.field_78129_f.field_78795_f = sajh._b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.field_78130_g.field_78795_f = sajh._b(f * 0.6662f) * 1.4f * f2;
    }
}

