/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;

public class ModelIronGolem
extends ModelBase {
    public ModelRenderer field_78178_a;
    public ModelRenderer field_78176_b;
    public ModelRenderer field_78177_c;
    public ModelRenderer field_78174_d;
    public ModelRenderer field_78175_e;
    public ModelRenderer field_78173_f;

    public ModelIronGolem() {
        this(0.0f);
    }

    public ModelIronGolem(float f) {
        this(f, -7.0f);
    }

    public ModelIronGolem(float f, float f2) {
        int n = 128;
        int n2 = 128;
        this.field_78178_a = new ModelRenderer(this).func_78787_b(n, n2);
        this.field_78178_a.func_78793_a(0.0f, 0.0f + f2, -2.0f);
        this.field_78178_a.func_78784_a(0, 0).func_78790_a(-4.0f, -12.0f, -5.5f, 8, 10, 8, f);
        this.field_78178_a.func_78784_a(24, 0).func_78790_a(-1.0f, -5.0f, -7.5f, 2, 4, 2, f);
        this.field_78176_b = new ModelRenderer(this).func_78787_b(n, n2);
        this.field_78176_b.func_78793_a(0.0f, 0.0f + f2, 0.0f);
        this.field_78176_b.func_78784_a(0, 40).func_78790_a(-9.0f, -2.0f, -6.0f, 18, 12, 11, f);
        this.field_78176_b.func_78784_a(0, 70).func_78790_a(-4.5f, 10.0f, -3.0f, 9, 5, 6, f + 0.5f);
        this.field_78177_c = new ModelRenderer(this).func_78787_b(n, n2);
        this.field_78177_c.func_78793_a(0.0f, -7.0f, 0.0f);
        this.field_78177_c.func_78784_a(60, 21).func_78790_a(-13.0f, -2.5f, -3.0f, 4, 30, 6, f);
        this.field_78174_d = new ModelRenderer(this).func_78787_b(n, n2);
        this.field_78174_d.func_78793_a(0.0f, -7.0f, 0.0f);
        this.field_78174_d.func_78784_a(60, 58).func_78790_a(9.0f, -2.5f, -3.0f, 4, 30, 6, f);
        this.field_78175_e = new ModelRenderer(this, 0, 22).func_78787_b(n, n2);
        this.field_78175_e.func_78793_a(-4.0f, 18.0f + f2, 0.0f);
        this.field_78175_e.func_78784_a(37, 0).func_78790_a(-3.5f, -3.0f, -3.0f, 6, 16, 5, f);
        this.field_78173_f = new ModelRenderer(this, 0, 22).func_78787_b(n, n2);
        this.field_78173_f.field_78809_i = true;
        this.field_78173_f.func_78784_a(60, 0).func_78793_a(5.0f, 18.0f + f2, 0.0f);
        this.field_78173_f.func_78790_a(-3.5f, -3.0f, -3.0f, 6, 16, 5, f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.field_78178_a.func_78785_a(f6);
        this.field_78176_b.func_78785_a(f6);
        this.field_78175_e.func_78785_a(f6);
        this.field_78173_f.func_78785_a(f6);
        this.field_78177_c.func_78785_a(f6);
        this.field_78174_d.func_78785_a(f6);
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        this.field_78178_a.field_78796_g = f4 / 57.295776f;
        this.field_78178_a.field_78795_f = f5 / 57.295776f;
        this.field_78175_e.field_78795_f = -1.5f * this.func_78172_a(f, 13.0f) * f2;
        this.field_78173_f.field_78795_f = 1.5f * this.func_78172_a(f, 13.0f) * f2;
        this.field_78175_e.field_78796_g = 0.0f;
        this.field_78173_f.field_78796_g = 0.0f;
    }

    @Override
    public void func_78086_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        EntityIronGolem entityIronGolem = (EntityIronGolem)entityLivingBase;
        int n = entityIronGolem.func_70854_o();
        if (n > 0) {
            this.field_78177_c.field_78795_f = -2.0f + 1.5f * this.func_78172_a((float)n - f3, 10.0f);
            this.field_78174_d.field_78795_f = -2.0f + 1.5f * this.func_78172_a((float)n - f3, 10.0f);
        } else {
            int n2 = entityIronGolem.func_70853_p();
            if (n2 > 0) {
                this.field_78177_c.field_78795_f = -0.8f + 0.025f * this.func_78172_a(n2, 70.0f);
                this.field_78174_d.field_78795_f = 0.0f;
            } else {
                this.field_78177_c.field_78795_f = (-0.2f + 1.5f * this.func_78172_a(f, 13.0f)) * f2;
                this.field_78174_d.field_78795_f = (-0.2f - 1.5f * this.func_78172_a(f, 13.0f)) * f2;
            }
        }
    }

    public float func_78172_a(float f, float f2) {
        return (Math.abs(f % f2 - f2 * 0.5f) - f2 * 0.25f) / (f2 * 0.25f);
    }
}

