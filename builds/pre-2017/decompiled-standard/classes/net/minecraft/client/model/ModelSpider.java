/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class ModelSpider
extends ModelBase {
    public ModelRenderer field_78209_a;
    public ModelRenderer field_78207_b;
    public ModelRenderer field_78208_c;
    public ModelRenderer field_78205_d;
    public ModelRenderer field_78206_e;
    public ModelRenderer field_78203_f;
    public ModelRenderer field_78204_g;
    public ModelRenderer field_78212_h;
    public ModelRenderer field_78213_i;
    public ModelRenderer field_78210_j;
    public ModelRenderer field_78211_k;

    public ModelSpider() {
        float f = 0.0f;
        int n = 15;
        this.field_78209_a = new ModelRenderer(this, 32, 4);
        this.field_78209_a.func_78790_a(-4.0f, -4.0f, -8.0f, 8, 8, 8, f);
        this.field_78209_a.func_78793_a(0.0f, n, -3.0f);
        this.field_78207_b = new ModelRenderer(this, 0, 0);
        this.field_78207_b.func_78790_a(-3.0f, -3.0f, -3.0f, 6, 6, 6, f);
        this.field_78207_b.func_78793_a(0.0f, n, 0.0f);
        this.field_78208_c = new ModelRenderer(this, 0, 12);
        this.field_78208_c.func_78790_a(-5.0f, -4.0f, -6.0f, 10, 8, 12, f);
        this.field_78208_c.func_78793_a(0.0f, n, 9.0f);
        this.field_78205_d = new ModelRenderer(this, 18, 0);
        this.field_78205_d.func_78790_a(-15.0f, -1.0f, -1.0f, 16, 2, 2, f);
        this.field_78205_d.func_78793_a(-4.0f, n, 2.0f);
        this.field_78206_e = new ModelRenderer(this, 18, 0);
        this.field_78206_e.func_78790_a(-1.0f, -1.0f, -1.0f, 16, 2, 2, f);
        this.field_78206_e.func_78793_a(4.0f, n, 2.0f);
        this.field_78203_f = new ModelRenderer(this, 18, 0);
        this.field_78203_f.func_78790_a(-15.0f, -1.0f, -1.0f, 16, 2, 2, f);
        this.field_78203_f.func_78793_a(-4.0f, n, 1.0f);
        this.field_78204_g = new ModelRenderer(this, 18, 0);
        this.field_78204_g.func_78790_a(-1.0f, -1.0f, -1.0f, 16, 2, 2, f);
        this.field_78204_g.func_78793_a(4.0f, n, 1.0f);
        this.field_78212_h = new ModelRenderer(this, 18, 0);
        this.field_78212_h.func_78790_a(-15.0f, -1.0f, -1.0f, 16, 2, 2, f);
        this.field_78212_h.func_78793_a(-4.0f, n, 0.0f);
        this.field_78213_i = new ModelRenderer(this, 18, 0);
        this.field_78213_i.func_78790_a(-1.0f, -1.0f, -1.0f, 16, 2, 2, f);
        this.field_78213_i.func_78793_a(4.0f, n, 0.0f);
        this.field_78210_j = new ModelRenderer(this, 18, 0);
        this.field_78210_j.func_78790_a(-15.0f, -1.0f, -1.0f, 16, 2, 2, f);
        this.field_78210_j.func_78793_a(-4.0f, n, -1.0f);
        this.field_78211_k = new ModelRenderer(this, 18, 0);
        this.field_78211_k.func_78790_a(-1.0f, -1.0f, -1.0f, 16, 2, 2, f);
        this.field_78211_k.func_78793_a(4.0f, n, -1.0f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.field_78209_a.func_78785_a(f6);
        this.field_78207_b.func_78785_a(f6);
        this.field_78208_c.func_78785_a(f6);
        this.field_78205_d.func_78785_a(f6);
        this.field_78206_e.func_78785_a(f6);
        this.field_78203_f.func_78785_a(f6);
        this.field_78204_g.func_78785_a(f6);
        this.field_78212_h.func_78785_a(f6);
        this.field_78213_i.func_78785_a(f6);
        this.field_78210_j.func_78785_a(f6);
        this.field_78211_k.func_78785_a(f6);
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        this.field_78209_a.field_78796_g = f4 / 57.295776f;
        this.field_78209_a.field_78795_f = f5 / 57.295776f;
        float f7 = 0.7853982f;
        this.field_78205_d.field_78808_h = -f7;
        this.field_78206_e.field_78808_h = f7;
        this.field_78203_f.field_78808_h = -f7 * 0.74f;
        this.field_78204_g.field_78808_h = f7 * 0.74f;
        this.field_78212_h.field_78808_h = -f7 * 0.74f;
        this.field_78213_i.field_78808_h = f7 * 0.74f;
        this.field_78210_j.field_78808_h = -f7;
        this.field_78211_k.field_78808_h = f7;
        float f8 = -0.0f;
        float f9 = 0.3926991f;
        this.field_78205_d.field_78796_g = f9 * 2.0f + f8;
        this.field_78206_e.field_78796_g = -f9 * 2.0f - f8;
        this.field_78203_f.field_78796_g = f9 * 1.0f + f8;
        this.field_78204_g.field_78796_g = -f9 * 1.0f - f8;
        this.field_78212_h.field_78796_g = -f9 * 1.0f + f8;
        this.field_78213_i.field_78796_g = f9 * 1.0f - f8;
        this.field_78210_j.field_78796_g = -f9 * 2.0f + f8;
        this.field_78211_k.field_78796_g = f9 * 2.0f - f8;
        float f10 = -(sajh._b(f * 0.6662f * 2.0f + 0.0f) * 0.4f) * f2;
        float f11 = -(sajh._b(f * 0.6662f * 2.0f + (float)Math.PI) * 0.4f) * f2;
        float f12 = -(sajh._b(f * 0.6662f * 2.0f + 1.5707964f) * 0.4f) * f2;
        float f13 = -(sajh._b(f * 0.6662f * 2.0f + 4.712389f) * 0.4f) * f2;
        float f14 = Math.abs(sajh._a(f * 0.6662f + 0.0f) * 0.4f) * f2;
        float f15 = Math.abs(sajh._a(f * 0.6662f + (float)Math.PI) * 0.4f) * f2;
        float f16 = Math.abs(sajh._a(f * 0.6662f + 1.5707964f) * 0.4f) * f2;
        float f17 = Math.abs(sajh._a(f * 0.6662f + 4.712389f) * 0.4f) * f2;
        this.field_78205_d.field_78796_g += f10;
        this.field_78206_e.field_78796_g += -f10;
        this.field_78203_f.field_78796_g += f11;
        this.field_78204_g.field_78796_g += -f11;
        this.field_78212_h.field_78796_g += f12;
        this.field_78213_i.field_78796_g += -f12;
        this.field_78210_j.field_78796_g += f13;
        this.field_78211_k.field_78796_g += -f13;
        this.field_78205_d.field_78808_h += f14;
        this.field_78206_e.field_78808_h += -f14;
        this.field_78203_f.field_78808_h += f15;
        this.field_78204_g.field_78808_h += -f15;
        this.field_78212_h.field_78808_h += f16;
        this.field_78213_i.field_78808_h += -f16;
        this.field_78210_j.field_78808_h += f17;
        this.field_78211_k.field_78808_h += -f17;
    }
}

