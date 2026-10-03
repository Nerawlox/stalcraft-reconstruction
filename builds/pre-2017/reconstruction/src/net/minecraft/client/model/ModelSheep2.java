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
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-3.0f, -4.0f, -6.0f, 6, 6, 8, 0.0f);
        this.head.setRotationPoint(0.0f, 6.0f, -8.0f);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.addBox(-4.0f, -10.0f, -7.0f, 8, 16, 6, 0.0f);
        this.body.setRotationPoint(0.0f, 5.0f, 2.0f);
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        super.setLivingAnimations(entityLivingBase, f, f2, f3);
        this.head.rotationPointY = 6.0f + ((EntitySheep)entityLivingBase).func_70894_j(f3) * 9.0f;
        this.field_78153_i = ((EntitySheep)entityLivingBase).func_70890_k(f3);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        this.head.rotateAngleX = this.field_78153_i;
    }
}

