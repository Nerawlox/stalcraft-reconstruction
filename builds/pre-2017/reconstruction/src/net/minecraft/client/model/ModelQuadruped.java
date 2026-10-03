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
    public ModelRenderer head = new ModelRenderer(this, 0, 0);
    public ModelRenderer body;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public float field_78145_g = 8.0f;
    public float field_78151_h = 4.0f;

    public ModelQuadruped(int n, float f) {
        this.head.addBox(-4.0f, -4.0f, -8.0f, 8, 8, 8, f);
        this.head.setRotationPoint(0.0f, 18 - n, -6.0f);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.addBox(-5.0f, -10.0f, -7.0f, 10, 16, 8, f);
        this.body.setRotationPoint(0.0f, 17 - n, 2.0f);
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.addBox(-2.0f, 0.0f, -2.0f, 4, n, 4, f);
        this.leg1.setRotationPoint(-3.0f, 24 - n, 7.0f);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.addBox(-2.0f, 0.0f, -2.0f, 4, n, 4, f);
        this.leg2.setRotationPoint(3.0f, 24 - n, 7.0f);
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.addBox(-2.0f, 0.0f, -2.0f, 4, n, 4, f);
        this.leg3.setRotationPoint(-3.0f, 24 - n, -5.0f);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.addBox(-2.0f, 0.0f, -2.0f, 4, n, 4, f);
        this.leg4.setRotationPoint(3.0f, 24 - n, -5.0f);
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        if (this.isChild) {
            float f7 = 2.0f;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, this.field_78145_g * f6, this.field_78151_h * f6);
            this.head.render(f6);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0f / f7, 1.0f / f7, 1.0f / f7);
            GL11.glTranslatef(0.0f, 24.0f * f6, 0.0f);
            this.body.render(f6);
            this.leg1.render(f6);
            this.leg2.render(f6);
            this.leg3.render(f6);
            this.leg4.render(f6);
            GL11.glPopMatrix();
        } else {
            this.head.render(f6);
            this.body.render(f6);
            this.leg1.render(f6);
            this.leg2.render(f6);
            this.leg3.render(f6);
            this.leg4.render(f6);
        }
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        float f7 = 57.295776f;
        this.head.rotateAngleX = f5 / 57.295776f;
        this.head.rotateAngleY = f4 / 57.295776f;
        this.body.rotateAngleX = 1.5707964f;
        this.leg1.rotateAngleX = sajh._b(f * 0.6662f) * 1.4f * f2;
        this.leg2.rotateAngleX = sajh._b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.leg3.rotateAngleX = sajh._b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.leg4.rotateAngleX = sajh._b(f * 0.6662f) * 1.4f * f2;
    }
}

