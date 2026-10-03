/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;

public class ModelSheep1
extends ModelQuadruped {
    public float field_78152_i;

    public ModelSheep1() {
        super(12, 0.0f);
        this.field_78150_a = new ModelRenderer(this, 0, 0);
        this.field_78150_a.func_78790_a(-3.0f, -4.0f, -4.0f, 6, 6, 6, 0.6f);
        this.field_78150_a.func_78793_a(0.0f, 6.0f, -8.0f);
        this.field_78148_b = new ModelRenderer(this, 28, 8);
        this.field_78148_b.func_78790_a(-4.0f, -10.0f, -7.0f, 8, 16, 6, 1.75f);
        this.field_78148_b.func_78793_a(0.0f, 5.0f, 2.0f);
        float f = 0.5f;
        this.field_78149_c = new ModelRenderer(this, 0, 16);
        this.field_78149_c.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, f);
        this.field_78149_c.func_78793_a(-3.0f, 12.0f, 7.0f);
        this.field_78146_d = new ModelRenderer(this, 0, 16);
        this.field_78146_d.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, f);
        this.field_78146_d.func_78793_a(3.0f, 12.0f, 7.0f);
        this.field_78147_e = new ModelRenderer(this, 0, 16);
        this.field_78147_e.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, f);
        this.field_78147_e.func_78793_a(-3.0f, 12.0f, -5.0f);
        this.field_78144_f = new ModelRenderer(this, 0, 16);
        this.field_78144_f.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, f);
        this.field_78144_f.func_78793_a(3.0f, 12.0f, -5.0f);
    }

    @Override
    public void func_78086_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        super.func_78086_a(entityLivingBase, f, f2, f3);
        this.field_78150_a.field_78797_d = 6.0f + ((EntitySheep)entityLivingBase).func_70894_j(f3) * 9.0f;
        this.field_78152_i = ((EntitySheep)entityLivingBase).func_70890_k(f3);
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.field_78150_a.field_78795_f = this.field_78152_i;
    }
}

