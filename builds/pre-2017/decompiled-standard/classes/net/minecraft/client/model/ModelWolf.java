/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class ModelWolf
extends ModelBase {
    public ModelRenderer field_78185_a;
    public ModelRenderer field_78183_b;
    public ModelRenderer field_78184_c;
    public ModelRenderer field_78181_d;
    public ModelRenderer field_78182_e;
    public ModelRenderer field_78179_f;
    public ModelRenderer field_78180_g;
    public ModelRenderer field_78186_h;

    public ModelWolf() {
        float f = 0.0f;
        float f2 = 13.5f;
        this.field_78185_a = new ModelRenderer(this, 0, 0);
        this.field_78185_a.func_78790_a(-3.0f, -3.0f, -2.0f, 6, 6, 4, f);
        this.field_78185_a.func_78793_a(-1.0f, f2, -7.0f);
        this.field_78183_b = new ModelRenderer(this, 18, 14);
        this.field_78183_b.func_78790_a(-4.0f, -2.0f, -3.0f, 6, 9, 6, f);
        this.field_78183_b.func_78793_a(0.0f, 14.0f, 2.0f);
        this.field_78186_h = new ModelRenderer(this, 21, 0);
        this.field_78186_h.func_78790_a(-4.0f, -3.0f, -3.0f, 8, 6, 7, f);
        this.field_78186_h.func_78793_a(-1.0f, 14.0f, 2.0f);
        this.field_78184_c = new ModelRenderer(this, 0, 18);
        this.field_78184_c.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 8, 2, f);
        this.field_78184_c.func_78793_a(-2.5f, 16.0f, 7.0f);
        this.field_78181_d = new ModelRenderer(this, 0, 18);
        this.field_78181_d.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 8, 2, f);
        this.field_78181_d.func_78793_a(0.5f, 16.0f, 7.0f);
        this.field_78182_e = new ModelRenderer(this, 0, 18);
        this.field_78182_e.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 8, 2, f);
        this.field_78182_e.func_78793_a(-2.5f, 16.0f, -4.0f);
        this.field_78179_f = new ModelRenderer(this, 0, 18);
        this.field_78179_f.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 8, 2, f);
        this.field_78179_f.func_78793_a(0.5f, 16.0f, -4.0f);
        this.field_78180_g = new ModelRenderer(this, 9, 18);
        this.field_78180_g.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 8, 2, f);
        this.field_78180_g.func_78793_a(-1.0f, 12.0f, 8.0f);
        this.field_78185_a.func_78784_a(16, 14).func_78790_a(-3.0f, -5.0f, 0.0f, 2, 2, 1, f);
        this.field_78185_a.func_78784_a(16, 14).func_78790_a(1.0f, -5.0f, 0.0f, 2, 2, 1, f);
        this.field_78185_a.func_78784_a(0, 10).func_78790_a(-1.5f, 0.0f, -5.0f, 3, 3, 4, f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super.func_78088_a(entity, f, f2, f3, f4, f5, f6);
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        if (this.field_78091_s) {
            float f7 = 2.0f;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, 5.0f * f6, 2.0f * f6);
            this.field_78185_a.func_78791_b(f6);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0f / f7, 1.0f / f7, 1.0f / f7);
            GL11.glTranslatef(0.0f, 24.0f * f6, 0.0f);
            this.field_78183_b.func_78785_a(f6);
            this.field_78184_c.func_78785_a(f6);
            this.field_78181_d.func_78785_a(f6);
            this.field_78182_e.func_78785_a(f6);
            this.field_78179_f.func_78785_a(f6);
            this.field_78180_g.func_78791_b(f6);
            this.field_78186_h.func_78785_a(f6);
            GL11.glPopMatrix();
        } else {
            this.field_78185_a.func_78791_b(f6);
            this.field_78183_b.func_78785_a(f6);
            this.field_78184_c.func_78785_a(f6);
            this.field_78181_d.func_78785_a(f6);
            this.field_78182_e.func_78785_a(f6);
            this.field_78179_f.func_78785_a(f6);
            this.field_78180_g.func_78791_b(f6);
            this.field_78186_h.func_78785_a(f6);
        }
    }

    @Override
    public void func_78086_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        EntityWolf entityWolf = (EntityWolf)entityLivingBase;
        this.field_78180_g.field_78796_g = entityWolf.func_70919_bu() ? 0.0f : sajh._b(f * 0.6662f) * 1.4f * f2;
        if (entityWolf.func_70906_o()) {
            this.field_78186_h.func_78793_a(-1.0f, 16.0f, -3.0f);
            this.field_78186_h.field_78795_f = 1.2566371f;
            this.field_78186_h.field_78796_g = 0.0f;
            this.field_78183_b.func_78793_a(0.0f, 18.0f, 0.0f);
            this.field_78183_b.field_78795_f = 0.7853982f;
            this.field_78180_g.func_78793_a(-1.0f, 21.0f, 6.0f);
            this.field_78184_c.func_78793_a(-2.5f, 22.0f, 2.0f);
            this.field_78184_c.field_78795_f = 4.712389f;
            this.field_78181_d.func_78793_a(0.5f, 22.0f, 2.0f);
            this.field_78181_d.field_78795_f = 4.712389f;
            this.field_78182_e.field_78795_f = 5.811947f;
            this.field_78182_e.func_78793_a(-2.49f, 17.0f, -4.0f);
            this.field_78179_f.field_78795_f = 5.811947f;
            this.field_78179_f.func_78793_a(0.51f, 17.0f, -4.0f);
        } else {
            this.field_78183_b.func_78793_a(0.0f, 14.0f, 2.0f);
            this.field_78183_b.field_78795_f = 1.5707964f;
            this.field_78186_h.func_78793_a(-1.0f, 14.0f, -3.0f);
            this.field_78186_h.field_78795_f = this.field_78183_b.field_78795_f;
            this.field_78180_g.func_78793_a(-1.0f, 12.0f, 8.0f);
            this.field_78184_c.func_78793_a(-2.5f, 16.0f, 7.0f);
            this.field_78181_d.func_78793_a(0.5f, 16.0f, 7.0f);
            this.field_78182_e.func_78793_a(-2.5f, 16.0f, -4.0f);
            this.field_78179_f.func_78793_a(0.5f, 16.0f, -4.0f);
            this.field_78184_c.field_78795_f = sajh._b(f * 0.6662f) * 1.4f * f2;
            this.field_78181_d.field_78795_f = sajh._b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
            this.field_78182_e.field_78795_f = sajh._b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
            this.field_78179_f.field_78795_f = sajh._b(f * 0.6662f) * 1.4f * f2;
        }
        this.field_78185_a.field_78808_h = entityWolf.func_70917_k(f3) + entityWolf.func_70923_f(f3, 0.0f);
        this.field_78186_h.field_78808_h = entityWolf.func_70923_f(f3, -0.08f);
        this.field_78183_b.field_78808_h = entityWolf.func_70923_f(f3, -0.16f);
        this.field_78180_g.field_78808_h = entityWolf.func_70923_f(f3, -0.2f);
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.field_78185_a.field_78795_f = f5 / 57.295776f;
        this.field_78185_a.field_78796_g = f4 / 57.295776f;
        this.field_78180_g.field_78795_f = f3;
    }
}

