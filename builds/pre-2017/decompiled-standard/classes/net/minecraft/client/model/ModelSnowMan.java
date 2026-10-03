/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class ModelSnowMan
extends ModelBase {
    public ModelRenderer field_78196_a;
    public ModelRenderer field_78194_b;
    public ModelRenderer field_78195_c;
    public ModelRenderer field_78192_d;
    public ModelRenderer field_78193_e;

    public ModelSnowMan() {
        float f = 4.0f;
        float f2 = 0.0f;
        this.field_78195_c = new ModelRenderer(this, 0, 0).func_78787_b(64, 64);
        this.field_78195_c.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, f2 - 0.5f);
        this.field_78195_c.func_78793_a(0.0f, 0.0f + f, 0.0f);
        this.field_78192_d = new ModelRenderer(this, 32, 0).func_78787_b(64, 64);
        this.field_78192_d.func_78790_a(-1.0f, 0.0f, -1.0f, 12, 2, 2, f2 - 0.5f);
        this.field_78192_d.func_78793_a(0.0f, 0.0f + f + 9.0f - 7.0f, 0.0f);
        this.field_78193_e = new ModelRenderer(this, 32, 0).func_78787_b(64, 64);
        this.field_78193_e.func_78790_a(-1.0f, 0.0f, -1.0f, 12, 2, 2, f2 - 0.5f);
        this.field_78193_e.func_78793_a(0.0f, 0.0f + f + 9.0f - 7.0f, 0.0f);
        this.field_78196_a = new ModelRenderer(this, 0, 16).func_78787_b(64, 64);
        this.field_78196_a.func_78790_a(-5.0f, -10.0f, -5.0f, 10, 10, 10, f2 - 0.5f);
        this.field_78196_a.func_78793_a(0.0f, 0.0f + f + 9.0f, 0.0f);
        this.field_78194_b = new ModelRenderer(this, 0, 36).func_78787_b(64, 64);
        this.field_78194_b.func_78790_a(-6.0f, -12.0f, -6.0f, 12, 12, 12, f2 - 0.5f);
        this.field_78194_b.func_78793_a(0.0f, 0.0f + f + 20.0f, 0.0f);
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.field_78195_c.field_78796_g = f4 / 57.295776f;
        this.field_78195_c.field_78795_f = f5 / 57.295776f;
        this.field_78196_a.field_78796_g = f4 / 57.295776f * 0.25f;
        float f7 = sajh._a(this.field_78196_a.field_78796_g);
        float f8 = sajh._b(this.field_78196_a.field_78796_g);
        this.field_78192_d.field_78808_h = 1.0f;
        this.field_78193_e.field_78808_h = -1.0f;
        this.field_78192_d.field_78796_g = 0.0f + this.field_78196_a.field_78796_g;
        this.field_78193_e.field_78796_g = (float)Math.PI + this.field_78196_a.field_78796_g;
        this.field_78192_d.field_78800_c = f8 * 5.0f;
        this.field_78192_d.field_78798_e = -f7 * 5.0f;
        this.field_78193_e.field_78800_c = -f8 * 5.0f;
        this.field_78193_e.field_78798_e = f7 * 5.0f;
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.field_78196_a.func_78785_a(f6);
        this.field_78194_b.func_78785_a(f6);
        this.field_78195_c.func_78785_a(f6);
        this.field_78192_d.func_78785_a(f6);
        this.field_78193_e.func_78785_a(f6);
    }
}

