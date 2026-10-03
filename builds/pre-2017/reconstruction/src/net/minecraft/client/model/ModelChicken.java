/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class ModelChicken
extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer rightLeg;
    public ModelRenderer leftLeg;
    public ModelRenderer rightWing;
    public ModelRenderer leftWing;
    public ModelRenderer bill;
    public ModelRenderer chin;

    public ModelChicken() {
        int n = 16;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-2.0f, -6.0f, -2.0f, 4, 6, 3, 0.0f);
        this.head.setRotationPoint(0.0f, -1 + n, -4.0f);
        this.bill = new ModelRenderer(this, 14, 0);
        this.bill.addBox(-2.0f, -4.0f, -4.0f, 4, 2, 2, 0.0f);
        this.bill.setRotationPoint(0.0f, -1 + n, -4.0f);
        this.chin = new ModelRenderer(this, 14, 4);
        this.chin.addBox(-1.0f, -2.0f, -3.0f, 2, 2, 2, 0.0f);
        this.chin.setRotationPoint(0.0f, -1 + n, -4.0f);
        this.body = new ModelRenderer(this, 0, 9);
        this.body.addBox(-3.0f, -4.0f, -3.0f, 6, 8, 6, 0.0f);
        this.body.setRotationPoint(0.0f, n, 0.0f);
        this.rightLeg = new ModelRenderer(this, 26, 0);
        this.rightLeg.addBox(-1.0f, 0.0f, -3.0f, 3, 5, 3);
        this.rightLeg.setRotationPoint(-2.0f, 3 + n, 1.0f);
        this.leftLeg = new ModelRenderer(this, 26, 0);
        this.leftLeg.addBox(-1.0f, 0.0f, -3.0f, 3, 5, 3);
        this.leftLeg.setRotationPoint(1.0f, 3 + n, 1.0f);
        this.rightWing = new ModelRenderer(this, 24, 13);
        this.rightWing.addBox(0.0f, 0.0f, -3.0f, 1, 4, 6);
        this.rightWing.setRotationPoint(-4.0f, -3 + n, 0.0f);
        this.leftWing = new ModelRenderer(this, 24, 13);
        this.leftWing.addBox(-1.0f, 0.0f, -3.0f, 1, 4, 6);
        this.leftWing.setRotationPoint(4.0f, -3 + n, 0.0f);
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        if (this.isChild) {
            float f7 = 2.0f;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, 5.0f * f6, 2.0f * f6);
            this.head.render(f6);
            this.bill.render(f6);
            this.chin.render(f6);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0f / f7, 1.0f / f7, 1.0f / f7);
            GL11.glTranslatef(0.0f, 24.0f * f6, 0.0f);
            this.body.render(f6);
            this.rightLeg.render(f6);
            this.leftLeg.render(f6);
            this.rightWing.render(f6);
            this.leftWing.render(f6);
            GL11.glPopMatrix();
        } else {
            this.head.render(f6);
            this.bill.render(f6);
            this.chin.render(f6);
            this.body.render(f6);
            this.rightLeg.render(f6);
            this.leftLeg.render(f6);
            this.rightWing.render(f6);
            this.leftWing.render(f6);
        }
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        this.head.rotateAngleX = f5 / 57.295776f;
        this.head.rotateAngleY = f4 / 57.295776f;
        this.bill.rotateAngleX = this.head.rotateAngleX;
        this.bill.rotateAngleY = this.head.rotateAngleY;
        this.chin.rotateAngleX = this.head.rotateAngleX;
        this.chin.rotateAngleY = this.head.rotateAngleY;
        this.body.rotateAngleX = 1.5707964f;
        this.rightLeg.rotateAngleX = sajh._b(f * 0.6662f) * 1.4f * f2;
        this.leftLeg.rotateAngleX = sajh._b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.rightWing.rotateAngleZ = f3;
        this.leftWing.rotateAngleZ = -f3;
    }
}

