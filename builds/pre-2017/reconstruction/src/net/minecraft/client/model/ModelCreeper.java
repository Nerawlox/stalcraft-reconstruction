/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class ModelCreeper
extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer field_78133_b;
    public ModelRenderer body;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;

    public ModelCreeper() {
        this(0.0f);
    }

    public ModelCreeper(float f) {
        int n = 4;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, f);
        this.head.setRotationPoint(0.0f, n, 0.0f);
        this.field_78133_b = new ModelRenderer(this, 32, 0);
        this.field_78133_b.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, f + 0.5f);
        this.field_78133_b.setRotationPoint(0.0f, n, 0.0f);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4, f);
        this.body.setRotationPoint(0.0f, n, 0.0f);
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, f);
        this.leg1.setRotationPoint(-2.0f, 12 + n, 4.0f);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, f);
        this.leg2.setRotationPoint(2.0f, 12 + n, 4.0f);
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, f);
        this.leg3.setRotationPoint(-2.0f, 12 + n, -4.0f);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, f);
        this.leg4.setRotationPoint(2.0f, 12 + n, -4.0f);
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        this.head.render(f6);
        this.body.render(f6);
        this.leg1.render(f6);
        this.leg2.render(f6);
        this.leg3.render(f6);
        this.leg4.render(f6);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        this.head.rotateAngleY = f4 / 57.295776f;
        this.head.rotateAngleX = f5 / 57.295776f;
        this.leg1.rotateAngleX = sajh._b(f * 0.6662f) * 1.4f * f2;
        this.leg2.rotateAngleX = sajh._b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.leg3.rotateAngleX = sajh._b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.leg4.rotateAngleX = sajh._b(f * 0.6662f) * 1.4f * f2;
    }
}

