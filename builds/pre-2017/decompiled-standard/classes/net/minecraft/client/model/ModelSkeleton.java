/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;

public class ModelSkeleton
extends ModelZombie {
    public ModelSkeleton() {
        this(0.0f);
    }

    public ModelSkeleton(float f) {
        super(f, 0.0f, 64, 32);
        this.field_78112_f = new ModelRenderer(this, 40, 16);
        this.field_78112_f.func_78790_a(-1.0f, -2.0f, -1.0f, 2, 12, 2, f);
        this.field_78112_f.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.field_78113_g = new ModelRenderer(this, 40, 16);
        this.field_78113_g.field_78809_i = true;
        this.field_78113_g.func_78790_a(-1.0f, -2.0f, -1.0f, 2, 12, 2, f);
        this.field_78113_g.func_78793_a(5.0f, 2.0f, 0.0f);
        this.field_78123_h = new ModelRenderer(this, 0, 16);
        this.field_78123_h.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, f);
        this.field_78123_h.func_78793_a(-2.0f, 12.0f, 0.0f);
        this.field_78124_i = new ModelRenderer(this, 0, 16);
        this.field_78124_i.field_78809_i = true;
        this.field_78124_i.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, f);
        this.field_78124_i.func_78793_a(2.0f, 12.0f, 0.0f);
    }

    @Override
    public void func_78086_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        this.field_78118_o = ((EntitySkeleton)entityLivingBase).func_82202_m() == 1;
        super.func_78086_a(entityLivingBase, f, f2, f3);
    }

    @Override
    public void func_78087_a(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.func_78087_a(f, f2, f3, f4, f5, f6, entity);
    }
}

