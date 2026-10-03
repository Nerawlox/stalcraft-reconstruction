/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class ModelQuadruped
extends ModelBase {
    public ModelRenderer field_78150_a = new ModelRenderer(this, 0, 0);
    public ModelRenderer field_78148_b;
    public ModelRenderer field_78149_c;
    public ModelRenderer field_78146_d;
    public ModelRenderer field_78147_e;
    public ModelRenderer field_78144_f;
    public float field_78145_g = 8.0f;
    public float field_78151_h = 4.0f;

    public ModelQuadruped(int n, float f) {
        this.field_78150_a.func_78790_a(-4.0f, -4.0f, -8.0f, 8, 8, 8, f);
        this.field_78150_a.func_78793_a(0.0f, 18 - n, -6.0f);
        this.field_78148_b = new ModelRenderer(this, 28, 8);
        this.field_78148_b.func_78790_a(-5.0f, -10.0f, -7.0f, 10, 16, 8, f);
        this.field_78148_b.func_78793_a(0.0f, 17 - n, 2.0f);
        this.field_78149_c = new ModelRenderer(this, 0, 16);
        this.field_78149_c.func_78790_a(-2.0f, 0.0f, -2.0f, 4, n, 4, f);
        this.field_78149_c.func_78793_a(-3.0f, 24 - n, 7.0f);
        this.field_78146_d = new ModelRenderer(this, 0, 16);
        this.field_78146_d.func_78790_a(-2.0f, 0.0f, -2.0f, 4, n, 4, f);
        this.field_78146_d.func_78793_a(3.0f, 24 - n, 7.0f);
        this.field_78147_e = new ModelRenderer(this, 0, 16);
        this.field_78147_e.func_78790_a(-2.0f, 0.0f, -2.0f, 4, n, 4, f);
        this.field_78147_e.func_78793_a(-3.0f, 24 - n, -5.0f);
        this.field_78144_f = new ModelRenderer(this, 0, 16);
        this.field_78144_f.func_78790_a(-2.0f, 0.0f, -2.0f, 4, n, 4, f);
        this.field_78144_f.func_78793_a(3.0f, 24 - n, -5.0f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        if (this.field_78091_s) {
            float f7 = 2.0f;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, this.field_78145_g * f6, this.field_78151_h * f6);
            this.field_78150_a.func_78785_a(f6);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0f / f7, 1.0f / f7, 1.0f / f7);
            GL11.glTranslatef(0.0f, 24.0f * f6, 0.0f);
            this.field_78148_b.func_78785_a(f6);
            this.field_78149_c.func_78785_a(f6);
            this.field_78146_d.func_78785_a(f6);
            this.field_78147_e.func_78785_a(f6);
            this.field_78144_f.func_78785_a(f6);
            GL11.glPopMatrix();
        } else {
            this.field_78150_a.func_78785_a(f6);
            this.field_78148_b.func_78785_a(f6);
            this.field_78149_c.func_78785_a(f6);
            this.field_78146_d.func_78785_a(f6);
            this.field_78147_e.func_78785_a(f6);
            this.field_78144_f.func_78785_a(f6);
        }
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        float f7 = 57.295776f;
        this.field_78150_a.field_78795_f = f5 / 57.295776f;
        this.field_78150_a.field_78796_g = f4 / 57.295776f;
        this.field_78148_b.field_78795_f = 1.5707964f;
        this.field_78149_c.field_78795_f = sajh._b(f * 0.6662f) * 1.4f * f2;
        this.field_78146_d.field_78795_f = sajh._b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.field_78147_e.field_78795_f = sajh._b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.field_78144_f.field_78795_f = sajh._b(f * 0.6662f) * 1.4f * f2;
    }
}

