/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import gloomyfolken.mods.asm.GloomyHooks;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class ModelBiped
extends ModelBase {
    public ModelRenderer field_78116_c;
    public ModelRenderer field_78114_d;
    public ModelRenderer field_78115_e;
    public ModelRenderer field_78112_f;
    public ModelRenderer field_78113_g;
    public ModelRenderer field_78123_h;
    public ModelRenderer field_78124_i;
    public ModelRenderer field_78121_j;
    public ModelRenderer field_78122_k;
    public int field_78119_l;
    public int field_78120_m;
    public boolean field_78117_n;
    public boolean field_78118_o;

    public ModelBiped() {
        this(0.0f);
    }

    public ModelBiped(float f) {
        this(f, 0.0f, 64, 32);
    }

    public ModelBiped(float f, float f2, int n, int n2) {
        this.field_78090_t = n;
        this.field_78089_u = n2;
        this.field_78122_k = new ModelRenderer(this, 0, 0);
        this.field_78122_k.func_78790_a(-5.0f, 0.0f, -1.0f, 10, 16, 1, f);
        this.field_78121_j = new ModelRenderer(this, 24, 0);
        this.field_78121_j.func_78790_a(-3.0f, -6.0f, -1.0f, 6, 6, 1, f);
        this.field_78116_c = new ModelRenderer(this, 0, 0);
        this.field_78116_c.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, f);
        this.field_78116_c.func_78793_a(0.0f, 0.0f + f2, 0.0f);
        this.field_78114_d = new ModelRenderer(this, 32, 0);
        this.field_78114_d.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, f + 0.5f);
        this.field_78114_d.func_78793_a(0.0f, 0.0f + f2, 0.0f);
        this.field_78115_e = new ModelRenderer(this, 16, 16);
        this.field_78115_e.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, f);
        this.field_78115_e.func_78793_a(0.0f, 0.0f + f2, 0.0f);
        this.field_78112_f = new ModelRenderer(this, 40, 16);
        this.field_78112_f.func_78790_a(-3.0f, -2.0f, -2.0f, 4, 12, 4, f);
        this.field_78112_f.func_78793_a(-5.0f, 2.0f + f2, 0.0f);
        this.field_78113_g = new ModelRenderer(this, 40, 16);
        this.field_78113_g.field_78809_i = true;
        this.field_78113_g.func_78790_a(-1.0f, -2.0f, -2.0f, 4, 12, 4, f);
        this.field_78113_g.func_78793_a(5.0f, 2.0f + f2, 0.0f);
        this.field_78123_h = new ModelRenderer(this, 0, 16);
        this.field_78123_h.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, f);
        this.field_78123_h.func_78793_a(-1.9f, 12.0f + f2, 0.0f);
        this.field_78124_i = new ModelRenderer(this, 0, 16);
        this.field_78124_i.field_78809_i = true;
        this.field_78124_i.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, f);
        this.field_78124_i.func_78793_a(1.9f, 12.0f + f2, 0.0f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        if (this.field_78091_s) {
            float f7 = 2.0f;
            GL11.glPushMatrix();
            GL11.glScalef(1.5f / f7, 1.5f / f7, 1.5f / f7);
            GL11.glTranslatef(0.0f, 16.0f * f6, 0.0f);
            this.field_78116_c.func_78785_a(f6);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0f / f7, 1.0f / f7, 1.0f / f7);
            GL11.glTranslatef(0.0f, 24.0f * f6, 0.0f);
            this.field_78115_e.func_78785_a(f6);
            this.field_78112_f.func_78785_a(f6);
            this.field_78113_g.func_78785_a(f6);
            this.field_78123_h.func_78785_a(f6);
            this.field_78124_i.func_78785_a(f6);
            this.field_78114_d.func_78785_a(f6);
            GL11.glPopMatrix();
        } else {
            this.field_78116_c.func_78785_a(f6);
            this.field_78115_e.func_78785_a(f6);
            this.field_78112_f.func_78785_a(f6);
            this.field_78113_g.func_78785_a(f6);
            this.field_78123_h.func_78785_a(f6);
            this.field_78124_i.func_78785_a(f6);
            this.field_78114_d.func_78785_a(f6);
        }
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        float f7;
        float f8;
        this.field_78116_c.field_78796_g = f4 / 57.295776f;
        this.field_78116_c.field_78795_f = f5 / 57.295776f;
        this.field_78114_d.field_78796_g = this.field_78116_c.field_78796_g;
        this.field_78114_d.field_78795_f = this.field_78116_c.field_78795_f;
        this.field_78112_f.field_78795_f = sajh._b(f * 0.6662f + (float)Math.PI) * 2.0f * f2 * 0.5f;
        this.field_78113_g.field_78795_f = sajh._b(f * 0.6662f) * 2.0f * f2 * 0.5f;
        this.field_78112_f.field_78808_h = 0.0f;
        this.field_78113_g.field_78808_h = 0.0f;
        this.field_78123_h.field_78795_f = sajh._b(f * 0.6662f) * 1.4f * f2;
        this.field_78124_i.field_78795_f = sajh._b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.field_78123_h.field_78796_g = 0.0f;
        this.field_78124_i.field_78796_g = 0.0f;
        if (this.field_78093_q) {
            this.field_78112_f.field_78795_f += -0.62831855f;
            this.field_78113_g.field_78795_f += -0.62831855f;
            this.field_78123_h.field_78795_f = -1.2566371f;
            this.field_78124_i.field_78795_f = -1.2566371f;
            this.field_78123_h.field_78796_g = 0.31415927f;
            this.field_78124_i.field_78796_g = -0.31415927f;
        }
        if (this.field_78119_l != 0) {
            this.field_78113_g.field_78795_f = this.field_78113_g.field_78795_f * 0.5f - 0.31415927f * (float)this.field_78119_l;
        }
        if (this.field_78120_m != 0) {
            this.field_78112_f.field_78795_f = this.field_78112_f.field_78795_f * 0.5f - 0.31415927f * (float)this.field_78120_m;
        }
        this.field_78112_f.field_78796_g = 0.0f;
        this.field_78113_g.field_78796_g = 0.0f;
        if (this.field_78095_p > -9990.0f) {
            f8 = this.field_78095_p;
            this.field_78115_e.field_78796_g = sajh._a(sajh._c(f8) * (float)Math.PI * 2.0f) * 0.2f;
            this.field_78112_f.field_78798_e = sajh._a(this.field_78115_e.field_78796_g) * 5.0f;
            this.field_78112_f.field_78800_c = -sajh._b(this.field_78115_e.field_78796_g) * 5.0f;
            this.field_78113_g.field_78798_e = -sajh._a(this.field_78115_e.field_78796_g) * 5.0f;
            this.field_78113_g.field_78800_c = sajh._b(this.field_78115_e.field_78796_g) * 5.0f;
            this.field_78112_f.field_78796_g += this.field_78115_e.field_78796_g;
            this.field_78113_g.field_78796_g += this.field_78115_e.field_78796_g;
            this.field_78113_g.field_78795_f += this.field_78115_e.field_78796_g;
            f8 = 1.0f - this.field_78095_p;
            f8 *= f8;
            f8 *= f8;
            f8 = 1.0f - f8;
            f7 = sajh._a(f8 * (float)Math.PI);
            float f9 = sajh._a(this.field_78095_p * (float)Math.PI) * -(this.field_78116_c.field_78795_f - 0.7f) * 0.75f;
            this.field_78112_f.field_78795_f = (float)((double)this.field_78112_f.field_78795_f - ((double)f7 * 1.2 + (double)f9));
            this.field_78112_f.field_78796_g += this.field_78115_e.field_78796_g * 2.0f;
            this.field_78112_f.field_78808_h = sajh._a(this.field_78095_p * (float)Math.PI) * -0.4f;
        }
        if (this.field_78117_n) {
            this.field_78115_e.field_78795_f = 0.5f;
            this.field_78112_f.field_78795_f += 0.4f;
            this.field_78113_g.field_78795_f += 0.4f;
            this.field_78123_h.field_78798_e = 4.0f;
            this.field_78124_i.field_78798_e = 4.0f;
            this.field_78123_h.field_78797_d = 9.0f;
            this.field_78124_i.field_78797_d = 9.0f;
            this.field_78116_c.field_78797_d = 1.0f;
            this.field_78114_d.field_78797_d = 1.0f;
        } else {
            this.field_78115_e.field_78795_f = 0.0f;
            this.field_78123_h.field_78798_e = 0.1f;
            this.field_78124_i.field_78798_e = 0.1f;
            this.field_78123_h.field_78797_d = 12.0f;
            this.field_78124_i.field_78797_d = 12.0f;
            this.field_78116_c.field_78797_d = 0.0f;
            this.field_78114_d.field_78797_d = 0.0f;
        }
        this.field_78112_f.field_78808_h += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
        this.field_78113_g.field_78808_h -= sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
        this.field_78112_f.field_78795_f += sajh._a(f3 * 0.067f) * 0.05f;
        this.field_78113_g.field_78795_f -= sajh._a(f3 * 0.067f) * 0.05f;
        if (this.field_78118_o) {
            f8 = 0.0f;
            f7 = 0.0f;
            this.field_78112_f.field_78808_h = 0.0f;
            this.field_78113_g.field_78808_h = 0.0f;
            this.field_78112_f.field_78796_g = -(0.1f - f8 * 0.6f) + this.field_78116_c.field_78796_g;
            this.field_78113_g.field_78796_g = 0.1f - f8 * 0.6f + this.field_78116_c.field_78796_g + 0.4f;
            this.field_78112_f.field_78795_f = -1.5707964f + this.field_78116_c.field_78795_f;
            this.field_78113_g.field_78795_f = -1.5707964f + this.field_78116_c.field_78795_f;
            this.field_78112_f.field_78795_f -= f8 * 1.2f - f7 * 0.4f;
            this.field_78113_g.field_78795_f -= f8 * 1.2f - f7 * 0.4f;
            this.field_78112_f.field_78808_h += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
            this.field_78113_g.field_78808_h -= sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
            this.field_78112_f.field_78795_f += sajh._a(f3 * 0.067f) * 0.05f;
            this.field_78113_g.field_78795_f -= sajh._a(f3 * 0.067f) * 0.05f;
        }
        GloomyHooks.onSetRotationAnglesVanilla(this, f, f2, f3, f4, f5, f6, entity);
    }

    public void func_78110_b(float f) {
        this.field_78121_j.field_78796_g = this.field_78116_c.field_78796_g;
        this.field_78121_j.field_78795_f = this.field_78116_c.field_78795_f;
        this.field_78121_j.field_78800_c = 0.0f;
        this.field_78121_j.field_78797_d = 0.0f;
        this.field_78121_j.func_78785_a(f);
    }

    public void func_78111_c(float f) {
        this.field_78122_k.func_78785_a(f);
    }
}

