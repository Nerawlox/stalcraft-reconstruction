/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;

public class ModelSheep2
extends ModelQuadruped {
    public float field_78153_i;

    public ModelSheep2() {
        super(12, 0.0f);
        this.field_78150_a = new ModelRenderer(this, 0, 0);
        this.field_78150_a.func_78790_a(-3.0f, -4.0f, -6.0f, 6, 6, 8, 0.0f);
        this.field_78150_a.func_78793_a(0.0f, 6.0f, -8.0f);
        this.field_78148_b = new ModelRenderer(this, 28, 8);
        this.field_78148_b.func_78790_a(-4.0f, -10.0f, -7.0f, 8, 16, 6, 0.0f);
        this.field_78148_b.func_78793_a(0.0f, 5.0f, 2.0f);
    }

    @Override
    public void func_78086_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        super.func_78086_a(entityLivingBase, f, f2, f3);
        this.field_78150_a.field_78797_d = 6.0f + ((EntitySheep)entityLivingBase).func_70894_j(f3) * 9.0f;
        this.field_78153_i = ((EntitySheep)entityLivingBase).func_70890_k(f3);
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.func_78087_a(f, f2, f3, f4, f5, f6, entity);
        this.field_78150_a.field_78795_f = this.field_78153_i;
    }
}

