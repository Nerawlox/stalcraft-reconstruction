/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEnderman
extends ModelBiped {
    public boolean field_78126_a;
    public boolean field_78125_b;

    public ModelEnderman() {
        super(0.0f, -14.0f, 64, 32);
        float f = -14.0f;
        float f2 = 0.0f;
        this.field_78114_d = new ModelRenderer(this, 0, 16);
        this.field_78114_d.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, f2 - 0.5f);
        this.field_78114_d.func_78793_a(0.0f, 0.0f + f, 0.0f);
        this.field_78115_e = new ModelRenderer(this, 32, 16);
        this.field_78115_e.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, f2);
        this.field_78115_e.func_78793_a(0.0f, 0.0f + f, 0.0f);
        this.field_78112_f = new ModelRenderer(this, 56, 0);
        this.field_78112_f.func_78790_a(-1.0f, -2.0f, -1.0f, 2, 30, 2, f2);
        this.field_78112_f.func_78793_a(-3.0f, 2.0f + f, 0.0f);
        this.field_78113_g = new ModelRenderer(this, 56, 0);
        this.field_78113_g.field_78809_i = true;
        this.field_78113_g.func_78790_a(-1.0f, -2.0f, -1.0f, 2, 30, 2, f2);
        this.field_78113_g.func_78793_a(5.0f, 2.0f + f, 0.0f);
        this.field_78123_h = new ModelRenderer(this, 56, 0);
        this.field_78123_h.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 30, 2, f2);
        this.field_78123_h.func_78793_a(-2.0f, 12.0f + f, 0.0f);
        this.field_78124_i = new ModelRenderer(this, 56, 0);
        this.field_78124_i.field_78809_i = true;
        this.field_78124_i.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 30, 2, f2);
        this.field_78124_i.func_78793_a(2.0f, 12.0f + f, 0.0f);
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.field_78116_c.field_78806_j = true;
        float f7 = -14.0f;
        this.field_78115_e.field_78795_f = 0.0f;
        this.field_78115_e.field_78797_d = f7;
        this.field_78115_e.field_78798_e = -0.0f;
        this.field_78123_h.field_78795_f -= 0.0f;
        this.field_78124_i.field_78795_f -= 0.0f;
        this.field_78112_f.field_78795_f = (float)((double)this.field_78112_f.field_78795_f * 0.5);
        this.field_78113_g.field_78795_f = (float)((double)this.field_78113_g.field_78795_f * 0.5);
        this.field_78123_h.field_78795_f = (float)((double)this.field_78123_h.field_78795_f * 0.5);
        this.field_78124_i.field_78795_f = (float)((double)this.field_78124_i.field_78795_f * 0.5);
        float f8 = 0.4f;
        if (this.field_78112_f.field_78795_f > f8) {
            this.field_78112_f.field_78795_f = f8;
        }
        if (this.field_78113_g.field_78795_f > f8) {
            this.field_78113_g.field_78795_f = f8;
        }
        if (this.field_78112_f.field_78795_f < -f8) {
            this.field_78112_f.field_78795_f = -f8;
        }
        if (this.field_78113_g.field_78795_f < -f8) {
            this.field_78113_g.field_78795_f = -f8;
        }
        if (this.field_78123_h.field_78795_f > f8) {
            this.field_78123_h.field_78795_f = f8;
        }
        if (this.field_78124_i.field_78795_f > f8) {
            this.field_78124_i.field_78795_f = f8;
        }
        if (this.field_78123_h.field_78795_f < -f8) {
            this.field_78123_h.field_78795_f = -f8;
        }
        if (this.field_78124_i.field_78795_f < -f8) {
            this.field_78124_i.field_78795_f = -f8;
        }
        if (this.field_78126_a) {
            this.field_78112_f.field_78795_f = -0.5f;
            this.field_78113_g.field_78795_f = -0.5f;
            this.field_78112_f.field_78808_h = 0.05f;
            this.field_78113_g.field_78808_h = -0.05f;
        }
        this.field_78112_f.field_78798_e = 0.0f;
        this.field_78113_g.field_78798_e = 0.0f;
        this.field_78123_h.field_78798_e = 0.0f;
        this.field_78124_i.field_78798_e = 0.0f;
        this.field_78123_h.field_78797_d = 9.0f + f7;
        this.field_78124_i.field_78797_d = 9.0f + f7;
        this.field_78116_c.field_78798_e = -0.0f;
        this.field_78116_c.field_78797_d = f7 + 1.0f;
        this.field_78114_d.field_78800_c = this.field_78116_c.field_78800_c;
        this.field_78114_d.field_78797_d = this.field_78116_c.field_78797_d;
        this.field_78114_d.field_78798_e = this.field_78116_c.field_78798_e;
        this.field_78114_d.field_78795_f = this.field_78116_c.field_78795_f;
        this.field_78114_d.field_78796_g = this.field_78116_c.field_78796_g;
        this.field_78114_d.field_78808_h = this.field_78116_c.field_78808_h;
        if (this.field_78125_b) {
            float f9 = 1.0f;
            this.field_78116_c.field_78797_d -= f9 * 5.0f;
        }
    }
}

