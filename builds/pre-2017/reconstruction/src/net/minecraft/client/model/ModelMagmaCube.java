/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMagmaCube;

public class ModelMagmaCube
extends ModelBase {
    public ModelRenderer[] field_78109_a = new ModelRenderer[8];
    public ModelRenderer field_78108_b;

    public ModelMagmaCube() {
        for (int i = 0; i < this.field_78109_a.length; ++i) {
            int n = 0;
            int n2 = i;
            if (i == 2) {
                n = 24;
                n2 = 10;
            } else if (i == 3) {
                n = 24;
                n2 = 19;
            }
            this.field_78109_a[i] = new ModelRenderer(this, n, n2);
            this.field_78109_a[i].addBox(-4.0f, 16 + i, -4.0f, 8, 1, 8);
        }
        this.field_78108_b = new ModelRenderer(this, 0, 16);
        this.field_78108_b.addBox(-2.0f, 18.0f, -2.0f, 4, 4, 4);
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        EntityMagmaCube entityMagmaCube = (EntityMagmaCube)entityLivingBase;
        float f4 = entityMagmaCube.prevSquishFactor + (entityMagmaCube.squishFactor - entityMagmaCube.prevSquishFactor) * f3;
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        for (int i = 0; i < this.field_78109_a.length; ++i) {
            this.field_78109_a[i].rotationPointY = (float)(-(4 - i)) * f4 * 1.7f;
        }
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        this.field_78108_b.render(f6);
        for (int i = 0; i < this.field_78109_a.length; ++i) {
            this.field_78109_a[i].render(f6);
        }
    }
}

