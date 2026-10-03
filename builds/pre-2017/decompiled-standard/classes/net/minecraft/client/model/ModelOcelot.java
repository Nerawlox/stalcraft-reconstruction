/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class ModelOcelot
extends ModelBase {
    public ModelRenderer field_78161_a;
    public ModelRenderer field_78159_b;
    public ModelRenderer field_78160_c;
    public ModelRenderer field_78157_d;
    public ModelRenderer field_78158_e;
    public ModelRenderer field_78155_f;
    public ModelRenderer field_78156_g;
    public ModelRenderer field_78162_h;
    public int field_78163_i = 1;

    public ModelOcelot() {
        this.func_78085_a("head.main", 0, 0);
        this.func_78085_a("head.nose", 0, 24);
        this.func_78085_a("head.ear1", 0, 10);
        this.func_78085_a("head.ear2", 6, 10);
        this.field_78156_g = new ModelRenderer(this, "head");
        this.field_78156_g.func_78786_a("main", -2.5f, -2.0f, -3.0f, 5, 4, 5);
        this.field_78156_g.func_78786_a("nose", -1.5f, 0.0f, -4.0f, 3, 2, 2);
        this.field_78156_g.func_78786_a("ear1", -2.0f, -3.0f, 0.0f, 1, 1, 2);
        this.field_78156_g.func_78786_a("ear2", 1.0f, -3.0f, 0.0f, 1, 1, 2);
        this.field_78156_g.func_78793_a(0.0f, 15.0f, -9.0f);
        this.field_78162_h = new ModelRenderer(this, 20, 0);
        this.field_78162_h.func_78790_a(-2.0f, 3.0f, -8.0f, 4, 16, 6, 0.0f);
        this.field_78162_h.func_78793_a(0.0f, 12.0f, -10.0f);
        this.field_78158_e = new ModelRenderer(this, 0, 15);
        this.field_78158_e.func_78789_a(-0.5f, 0.0f, 0.0f, 1, 8, 1);
        this.field_78158_e.field_78795_f = 0.9f;
        this.field_78158_e.func_78793_a(0.0f, 15.0f, 8.0f);
        this.field_78155_f = new ModelRenderer(this, 4, 15);
        this.field_78155_f.func_78789_a(-0.5f, 0.0f, 0.0f, 1, 8, 1);
        this.field_78155_f.func_78793_a(0.0f, 20.0f, 14.0f);
        this.field_78161_a = new ModelRenderer(this, 8, 13);
        this.field_78161_a.func_78789_a(-1.0f, 0.0f, 1.0f, 2, 6, 2);
        this.field_78161_a.func_78793_a(1.1f, 18.0f, 5.0f);
        this.field_78159_b = new ModelRenderer(this, 8, 13);
        this.field_78159_b.func_78789_a(-1.0f, 0.0f, 1.0f, 2, 6, 2);
        this.field_78159_b.func_78793_a(-1.1f, 18.0f, 5.0f);
        this.field_78160_c = new ModelRenderer(this, 40, 0);
        this.field_78160_c.func_78789_a(-1.0f, 0.0f, 0.0f, 2, 10, 2);
        this.field_78160_c.func_78793_a(1.2f, 13.8f, -5.0f);
        this.field_78157_d = new ModelRenderer(this, 40, 0);
        this.field_78157_d.func_78789_a(-1.0f, 0.0f, 0.0f, 2, 10, 2);
        this.field_78157_d.func_78793_a(-1.2f, 13.8f, -5.0f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        if (this.field_78091_s) {
            float f7 = 2.0f;
            GL11.glPushMatrix();
            GL11.glScalef(1.5f / f7, 1.5f / f7, 1.5f / f7);
            GL11.glTranslatef(0.0f, 10.0f * f6, 4.0f * f6);
            this.field_78156_g.func_78785_a(f6);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0f / f7, 1.0f / f7, 1.0f / f7);
            GL11.glTranslatef(0.0f, 24.0f * f6, 0.0f);
            this.field_78162_h.func_78785_a(f6);
            this.field_78161_a.func_78785_a(f6);
            this.field_78159_b.func_78785_a(f6);
            this.field_78160_c.func_78785_a(f6);
            this.field_78157_d.func_78785_a(f6);
            this.field_78158_e.func_78785_a(f6);
            this.field_78155_f.func_78785_a(f6);
            GL11.glPopMatrix();
        } else {
            this.field_78156_g.func_78785_a(f6);
            this.field_78162_h.func_78785_a(f6);
            this.field_78158_e.func_78785_a(f6);
            this.field_78155_f.func_78785_a(f6);
            this.field_78161_a.func_78785_a(f6);
            this.field_78159_b.func_78785_a(f6);
            this.field_78160_c.func_78785_a(f6);
            this.field_78157_d.func_78785_a(f6);
        }
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        this.field_78156_g.field_78795_f = f5 / 57.295776f;
        this.field_78156_g.field_78796_g = f4 / 57.295776f;
        if (this.field_78163_i != 3) {
            this.field_78162_h.field_78795_f = 1.5707964f;
            if (this.field_78163_i == 2) {
                this.field_78161_a.field_78795_f = sajh._b(f * 0.6662f) * 1.0f * f2;
                this.field_78159_b.field_78795_f = sajh._b(f * 0.6662f + 0.3f) * 1.0f * f2;
                this.field_78160_c.field_78795_f = sajh._b(f * 0.6662f + (float)Math.PI + 0.3f) * 1.0f * f2;
                this.field_78157_d.field_78795_f = sajh._b(f * 0.6662f + (float)Math.PI) * 1.0f * f2;
                this.field_78155_f.field_78795_f = 1.7278761f + 0.31415927f * sajh._b(f) * f2;
            } else {
                this.field_78161_a.field_78795_f = sajh._b(f * 0.6662f) * 1.0f * f2;
                this.field_78159_b.field_78795_f = sajh._b(f * 0.6662f + (float)Math.PI) * 1.0f * f2;
                this.field_78160_c.field_78795_f = sajh._b(f * 0.6662f + (float)Math.PI) * 1.0f * f2;
                this.field_78157_d.field_78795_f = sajh._b(f * 0.6662f) * 1.0f * f2;
                this.field_78155_f.field_78795_f = this.field_78163_i == 1 ? 1.7278761f + 0.7853982f * sajh._b(f) * f2 : 1.7278761f + 0.47123894f * sajh._b(f) * f2;
            }
        }
    }

    @Override
    public void func_78086_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        EntityOcelot entityOcelot = (EntityOcelot)entityLivingBase;
        this.field_78162_h.field_78797_d = 12.0f;
        this.field_78162_h.field_78798_e = -10.0f;
        this.field_78156_g.field_78797_d = 15.0f;
        this.field_78156_g.field_78798_e = -9.0f;
        this.field_78158_e.field_78797_d = 15.0f;
        this.field_78158_e.field_78798_e = 8.0f;
        this.field_78155_f.field_78797_d = 20.0f;
        this.field_78155_f.field_78798_e = 14.0f;
        this.field_78157_d.field_78797_d = 13.8f;
        this.field_78160_c.field_78797_d = 13.8f;
        this.field_78157_d.field_78798_e = -5.0f;
        this.field_78160_c.field_78798_e = -5.0f;
        this.field_78159_b.field_78797_d = 18.0f;
        this.field_78161_a.field_78797_d = 18.0f;
        this.field_78159_b.field_78798_e = 5.0f;
        this.field_78161_a.field_78798_e = 5.0f;
        this.field_78158_e.field_78795_f = 0.9f;
        if (entityOcelot.func_70093_af()) {
            this.field_78162_h.field_78797_d += 1.0f;
            this.field_78156_g.field_78797_d += 2.0f;
            this.field_78158_e.field_78797_d += 1.0f;
            this.field_78155_f.field_78797_d += -4.0f;
            this.field_78155_f.field_78798_e += 2.0f;
            this.field_78158_e.field_78795_f = 1.5707964f;
            this.field_78155_f.field_78795_f = 1.5707964f;
            this.field_78163_i = 0;
        } else if (entityOcelot.func_70051_ag()) {
            this.field_78155_f.field_78797_d = this.field_78158_e.field_78797_d;
            this.field_78155_f.field_78798_e += 2.0f;
            this.field_78158_e.field_78795_f = 1.5707964f;
            this.field_78155_f.field_78795_f = 1.5707964f;
            this.field_78163_i = 2;
        } else if (entityOcelot.func_70906_o()) {
            this.field_78162_h.field_78795_f = 0.7853982f;
            this.field_78162_h.field_78797_d += -4.0f;
            this.field_78162_h.field_78798_e += 5.0f;
            this.field_78156_g.field_78797_d += -3.3f;
            this.field_78156_g.field_78798_e += 1.0f;
            this.field_78158_e.field_78797_d += 8.0f;
            this.field_78158_e.field_78798_e += -2.0f;
            this.field_78155_f.field_78797_d += 2.0f;
            this.field_78155_f.field_78798_e += -0.8f;
            this.field_78158_e.field_78795_f = 1.7278761f;
            this.field_78155_f.field_78795_f = 2.670354f;
            this.field_78157_d.field_78795_f = -0.15707964f;
            this.field_78160_c.field_78795_f = -0.15707964f;
            this.field_78157_d.field_78797_d = 15.8f;
            this.field_78160_c.field_78797_d = 15.8f;
            this.field_78157_d.field_78798_e = -7.0f;
            this.field_78160_c.field_78798_e = -7.0f;
            this.field_78159_b.field_78795_f = -1.5707964f;
            this.field_78161_a.field_78795_f = -1.5707964f;
            this.field_78159_b.field_78797_d = 21.0f;
            this.field_78161_a.field_78797_d = 21.0f;
            this.field_78159_b.field_78798_e = 1.0f;
            this.field_78161_a.field_78798_e = 1.0f;
            this.field_78163_i = 3;
        } else {
            this.field_78163_i = 1;
        }
    }
}

