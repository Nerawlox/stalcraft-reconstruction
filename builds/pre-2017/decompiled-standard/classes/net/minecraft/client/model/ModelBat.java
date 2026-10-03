/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.util.sajh;

public class ModelBat
extends ModelBase {
    public ModelRenderer field_82895_a;
    public ModelRenderer field_82893_b;
    public ModelRenderer field_82894_c;
    public ModelRenderer field_82891_d;
    public ModelRenderer field_82892_e;
    public ModelRenderer field_82890_f;

    public ModelBat() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.field_82895_a = new ModelRenderer(this, 0, 0);
        this.field_82895_a.func_78789_a(-3.0f, -3.0f, -3.0f, 6, 6, 6);
        ModelRenderer modelRenderer = new ModelRenderer(this, 24, 0);
        modelRenderer.func_78789_a(-4.0f, -6.0f, -2.0f, 3, 4, 1);
        this.field_82895_a.func_78792_a(modelRenderer);
        ModelRenderer modelRenderer2 = new ModelRenderer(this, 24, 0);
        modelRenderer2.field_78809_i = true;
        modelRenderer2.func_78789_a(1.0f, -6.0f, -2.0f, 3, 4, 1);
        this.field_82895_a.func_78792_a(modelRenderer2);
        this.field_82893_b = new ModelRenderer(this, 0, 16);
        this.field_82893_b.func_78789_a(-3.0f, 4.0f, -3.0f, 6, 12, 6);
        this.field_82893_b.func_78784_a(0, 34).func_78789_a(-5.0f, 16.0f, 0.0f, 10, 6, 1);
        this.field_82894_c = new ModelRenderer(this, 42, 0);
        this.field_82894_c.func_78789_a(-12.0f, 1.0f, 1.5f, 10, 16, 1);
        this.field_82892_e = new ModelRenderer(this, 24, 16);
        this.field_82892_e.func_78793_a(-12.0f, 1.0f, 1.5f);
        this.field_82892_e.func_78789_a(-8.0f, 1.0f, 0.0f, 8, 12, 1);
        this.field_82891_d = new ModelRenderer(this, 42, 0);
        this.field_82891_d.field_78809_i = true;
        this.field_82891_d.func_78789_a(2.0f, 1.0f, 1.5f, 10, 16, 1);
        this.field_82890_f = new ModelRenderer(this, 24, 16);
        this.field_82890_f.field_78809_i = true;
        this.field_82890_f.func_78793_a(12.0f, 1.0f, 1.5f);
        this.field_82890_f.func_78789_a(0.0f, 1.0f, 0.0f, 8, 12, 1);
        this.field_82893_b.func_78792_a(this.field_82894_c);
        this.field_82893_b.func_78792_a(this.field_82891_d);
        this.field_82894_c.func_78792_a(this.field_82892_e);
        this.field_82891_d.func_78792_a(this.field_82890_f);
    }

    public int func_82889_a() {
        return 36;
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        EntityBat entityBat = (EntityBat)entity;
        if (entityBat.func_82235_h()) {
            float f7 = 57.295776f;
            this.field_82895_a.field_78795_f = f5 / 57.295776f;
            this.field_82895_a.field_78796_g = (float)Math.PI - f4 / 57.295776f;
            this.field_82895_a.field_78808_h = (float)Math.PI;
            this.field_82895_a.func_78793_a(0.0f, -2.0f, 0.0f);
            this.field_82894_c.func_78793_a(-3.0f, 0.0f, 3.0f);
            this.field_82891_d.func_78793_a(3.0f, 0.0f, 3.0f);
            this.field_82893_b.field_78795_f = (float)Math.PI;
            this.field_82894_c.field_78795_f = -0.15707964f;
            this.field_82894_c.field_78796_g = -1.2566371f;
            this.field_82892_e.field_78796_g = -1.7278761f;
            this.field_82891_d.field_78795_f = this.field_82894_c.field_78795_f;
            this.field_82891_d.field_78796_g = -this.field_82894_c.field_78796_g;
            this.field_82890_f.field_78796_g = -this.field_82892_e.field_78796_g;
        } else {
            float f8 = 57.295776f;
            this.field_82895_a.field_78795_f = f5 / 57.295776f;
            this.field_82895_a.field_78796_g = f4 / 57.295776f;
            this.field_82895_a.field_78808_h = 0.0f;
            this.field_82895_a.func_78793_a(0.0f, 0.0f, 0.0f);
            this.field_82894_c.func_78793_a(0.0f, 0.0f, 0.0f);
            this.field_82891_d.func_78793_a(0.0f, 0.0f, 0.0f);
            this.field_82893_b.field_78795_f = 0.7853982f + sajh._b(f3 * 0.1f) * 0.15f;
            this.field_82893_b.field_78796_g = 0.0f;
            this.field_82894_c.field_78796_g = sajh._b(f3 * 1.3f) * (float)Math.PI * 0.25f;
            this.field_82891_d.field_78796_g = -this.field_82894_c.field_78796_g;
            this.field_82892_e.field_78796_g = this.field_82894_c.field_78796_g * 0.5f;
            this.field_82890_f.field_78796_g = -this.field_82894_c.field_78796_g * 0.5f;
        }
        this.field_82895_a.func_78785_a(f6);
        this.field_82893_b.func_78785_a(f6);
    }
}

