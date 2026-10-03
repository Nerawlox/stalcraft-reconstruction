/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class ModelVillager
extends ModelBase {
    public ModelRenderer field_78191_a;
    public ModelRenderer field_78189_b;
    public ModelRenderer field_78190_c;
    public ModelRenderer field_78187_d;
    public ModelRenderer field_78188_e;
    public ModelRenderer field_82898_f;

    public ModelVillager(float f) {
        this(f, 0.0f, 64, 64);
    }

    public ModelVillager(float f, float f2, int n, int n2) {
        this.field_78191_a = new ModelRenderer(this).func_78787_b(n, n2);
        this.field_78191_a.func_78793_a(0.0f, 0.0f + f2, 0.0f);
        this.field_78191_a.func_78784_a(0, 0).func_78790_a(-4.0f, -10.0f, -4.0f, 8, 10, 8, f);
        this.field_82898_f = new ModelRenderer(this).func_78787_b(n, n2);
        this.field_82898_f.func_78793_a(0.0f, f2 - 2.0f, 0.0f);
        this.field_82898_f.func_78784_a(24, 0).func_78790_a(-1.0f, -1.0f, -6.0f, 2, 4, 2, f);
        this.field_78191_a.func_78792_a(this.field_82898_f);
        this.field_78189_b = new ModelRenderer(this).func_78787_b(n, n2);
        this.field_78189_b.func_78793_a(0.0f, 0.0f + f2, 0.0f);
        this.field_78189_b.func_78784_a(16, 20).func_78790_a(-4.0f, 0.0f, -3.0f, 8, 12, 6, f);
        this.field_78189_b.func_78784_a(0, 38).func_78790_a(-4.0f, 0.0f, -3.0f, 8, 18, 6, f + 0.5f);
        this.field_78190_c = new ModelRenderer(this).func_78787_b(n, n2);
        this.field_78190_c.func_78793_a(0.0f, 0.0f + f2 + 2.0f, 0.0f);
        this.field_78190_c.func_78784_a(44, 22).func_78790_a(-8.0f, -2.0f, -2.0f, 4, 8, 4, f);
        this.field_78190_c.func_78784_a(44, 22).func_78790_a(4.0f, -2.0f, -2.0f, 4, 8, 4, f);
        this.field_78190_c.func_78784_a(40, 38).func_78790_a(-4.0f, 2.0f, -2.0f, 8, 4, 4, f);
        this.field_78187_d = new ModelRenderer(this, 0, 22).func_78787_b(n, n2);
        this.field_78187_d.func_78793_a(-2.0f, 12.0f + f2, 0.0f);
        this.field_78187_d.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, f);
        this.field_78188_e = new ModelRenderer(this, 0, 22).func_78787_b(n, n2);
        this.field_78188_e.field_78809_i = true;
        this.field_78188_e.func_78793_a(2.0f, 12.0f + f2, 0.0f);
        this.field_78188_e.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.field_78191_a.func_78785_a(f6);
        this.field_78189_b.func_78785_a(f6);
        this.field_78187_d.func_78785_a(f6);
        this.field_78188_e.func_78785_a(f6);
        this.field_78190_c.func_78785_a(f6);
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        this.field_78191_a.field_78796_g = f4 / 57.295776f;
        this.field_78191_a.field_78795_f = f5 / 57.295776f;
        this.field_78190_c.field_78797_d = 3.0f;
        this.field_78190_c.field_78798_e = -1.0f;
        this.field_78190_c.field_78795_f = -0.75f;
        this.field_78187_d.field_78795_f = sajh._b(f * 0.6662f) * 1.4f * f2 * 0.5f;
        this.field_78188_e.field_78795_f = sajh._b(f * 0.6662f + (float)Math.PI) * 1.4f * f2 * 0.5f;
        this.field_78187_d.field_78796_g = 0.0f;
        this.field_78188_e.field_78796_g = 0.0f;
    }
}

