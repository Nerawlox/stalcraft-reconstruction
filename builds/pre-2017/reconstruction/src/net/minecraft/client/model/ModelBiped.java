/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import gloomyfolken.mods.asm.GloomyHooks;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class ModelBiped
extends ModelBase {
    public ModelRenderer bipedHead;
    public ModelRenderer bipedHeadwear;
    public ModelRenderer bipedBody;
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedRightLeg;
    public ModelRenderer bipedLeftLeg;
    public ModelRenderer bipedEars;
    public ModelRenderer bipedCloak;
    public int heldItemLeft;
    public int heldItemRight;
    public boolean isSneak;
    public boolean aimedBow;

    public ModelBiped() {
        this(0.0f);
    }

    public ModelBiped(float f) {
        this(f, 0.0f, 64, 32);
    }

    public ModelBiped(float f, float f2, int n, int n2) {
        this.textureWidth = n;
        this.textureHeight = n2;
        this.bipedCloak = new ModelRenderer(this, 0, 0);
        this.bipedCloak.addBox(-5.0f, 0.0f, -1.0f, 10, 16, 1, f);
        this.bipedEars = new ModelRenderer(this, 24, 0);
        this.bipedEars.addBox(-3.0f, -6.0f, -1.0f, 6, 6, 1, f);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, f);
        this.bipedHead.setRotationPoint(0.0f, 0.0f + f2, 0.0f);
        this.bipedHeadwear = new ModelRenderer(this, 32, 0);
        this.bipedHeadwear.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, f + 0.5f);
        this.bipedHeadwear.setRotationPoint(0.0f, 0.0f + f2, 0.0f);
        this.bipedBody = new ModelRenderer(this, 16, 16);
        this.bipedBody.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4, f);
        this.bipedBody.setRotationPoint(0.0f, 0.0f + f2, 0.0f);
        this.bipedRightArm = new ModelRenderer(this, 40, 16);
        this.bipedRightArm.addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4, f);
        this.bipedRightArm.setRotationPoint(-5.0f, 2.0f + f2, 0.0f);
        this.bipedLeftArm = new ModelRenderer(this, 40, 16);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4, f);
        this.bipedLeftArm.setRotationPoint(5.0f, 2.0f + f2, 0.0f);
        this.bipedRightLeg = new ModelRenderer(this, 0, 16);
        this.bipedRightLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, f);
        this.bipedRightLeg.setRotationPoint(-1.9f, 12.0f + f2, 0.0f);
        this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, f);
        this.bipedLeftLeg.setRotationPoint(1.9f, 12.0f + f2, 0.0f);
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        if (this.isChild) {
            float f7 = 2.0f;
            GL11.glPushMatrix();
            GL11.glScalef(1.5f / f7, 1.5f / f7, 1.5f / f7);
            GL11.glTranslatef(0.0f, 16.0f * f6, 0.0f);
            this.bipedHead.render(f6);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0f / f7, 1.0f / f7, 1.0f / f7);
            GL11.glTranslatef(0.0f, 24.0f * f6, 0.0f);
            this.bipedBody.render(f6);
            this.bipedRightArm.render(f6);
            this.bipedLeftArm.render(f6);
            this.bipedRightLeg.render(f6);
            this.bipedLeftLeg.render(f6);
            this.bipedHeadwear.render(f6);
            GL11.glPopMatrix();
        } else {
            this.bipedHead.render(f6);
            this.bipedBody.render(f6);
            this.bipedRightArm.render(f6);
            this.bipedLeftArm.render(f6);
            this.bipedRightLeg.render(f6);
            this.bipedLeftLeg.render(f6);
            this.bipedHeadwear.render(f6);
        }
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        float f7;
        float f8;
        this.bipedHead.rotateAngleY = f4 / 57.295776f;
        this.bipedHead.rotateAngleX = f5 / 57.295776f;
        this.bipedHeadwear.rotateAngleY = this.bipedHead.rotateAngleY;
        this.bipedHeadwear.rotateAngleX = this.bipedHead.rotateAngleX;
        this.bipedRightArm.rotateAngleX = sajh._b(f * 0.6662f + (float)Math.PI) * 2.0f * f2 * 0.5f;
        this.bipedLeftArm.rotateAngleX = sajh._b(f * 0.6662f) * 2.0f * f2 * 0.5f;
        this.bipedRightArm.rotateAngleZ = 0.0f;
        this.bipedLeftArm.rotateAngleZ = 0.0f;
        this.bipedRightLeg.rotateAngleX = sajh._b(f * 0.6662f) * 1.4f * f2;
        this.bipedLeftLeg.rotateAngleX = sajh._b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.bipedRightLeg.rotateAngleY = 0.0f;
        this.bipedLeftLeg.rotateAngleY = 0.0f;
        if (this.isRiding) {
            this.bipedRightArm.rotateAngleX += -0.62831855f;
            this.bipedLeftArm.rotateAngleX += -0.62831855f;
            this.bipedRightLeg.rotateAngleX = -1.2566371f;
            this.bipedLeftLeg.rotateAngleX = -1.2566371f;
            this.bipedRightLeg.rotateAngleY = 0.31415927f;
            this.bipedLeftLeg.rotateAngleY = -0.31415927f;
        }
        if (this.heldItemLeft != 0) {
            this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5f - 0.31415927f * (float)this.heldItemLeft;
        }
        if (this.heldItemRight != 0) {
            this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5f - 0.31415927f * (float)this.heldItemRight;
        }
        this.bipedRightArm.rotateAngleY = 0.0f;
        this.bipedLeftArm.rotateAngleY = 0.0f;
        if (this.onGround > -9990.0f) {
            f8 = this.onGround;
            this.bipedBody.rotateAngleY = sajh._a(sajh._c(f8) * (float)Math.PI * 2.0f) * 0.2f;
            this.bipedRightArm.rotationPointZ = sajh._a(this.bipedBody.rotateAngleY) * 5.0f;
            this.bipedRightArm.rotationPointX = -sajh._b(this.bipedBody.rotateAngleY) * 5.0f;
            this.bipedLeftArm.rotationPointZ = -sajh._a(this.bipedBody.rotateAngleY) * 5.0f;
            this.bipedLeftArm.rotationPointX = sajh._b(this.bipedBody.rotateAngleY) * 5.0f;
            this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY;
            this.bipedLeftArm.rotateAngleY += this.bipedBody.rotateAngleY;
            this.bipedLeftArm.rotateAngleX += this.bipedBody.rotateAngleY;
            f8 = 1.0f - this.onGround;
            f8 *= f8;
            f8 *= f8;
            f8 = 1.0f - f8;
            f7 = sajh._a(f8 * (float)Math.PI);
            float f9 = sajh._a(this.onGround * (float)Math.PI) * -(this.bipedHead.rotateAngleX - 0.7f) * 0.75f;
            this.bipedRightArm.rotateAngleX = (float)((double)this.bipedRightArm.rotateAngleX - ((double)f7 * 1.2 + (double)f9));
            this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY * 2.0f;
            this.bipedRightArm.rotateAngleZ = sajh._a(this.onGround * (float)Math.PI) * -0.4f;
        }
        if (this.isSneak) {
            this.bipedBody.rotateAngleX = 0.5f;
            this.bipedRightArm.rotateAngleX += 0.4f;
            this.bipedLeftArm.rotateAngleX += 0.4f;
            this.bipedRightLeg.rotationPointZ = 4.0f;
            this.bipedLeftLeg.rotationPointZ = 4.0f;
            this.bipedRightLeg.rotationPointY = 9.0f;
            this.bipedLeftLeg.rotationPointY = 9.0f;
            this.bipedHead.rotationPointY = 1.0f;
            this.bipedHeadwear.rotationPointY = 1.0f;
        } else {
            this.bipedBody.rotateAngleX = 0.0f;
            this.bipedRightLeg.rotationPointZ = 0.1f;
            this.bipedLeftLeg.rotationPointZ = 0.1f;
            this.bipedRightLeg.rotationPointY = 12.0f;
            this.bipedLeftLeg.rotationPointY = 12.0f;
            this.bipedHead.rotationPointY = 0.0f;
            this.bipedHeadwear.rotationPointY = 0.0f;
        }
        this.bipedRightArm.rotateAngleZ += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
        this.bipedLeftArm.rotateAngleZ -= sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
        this.bipedRightArm.rotateAngleX += sajh._a(f3 * 0.067f) * 0.05f;
        this.bipedLeftArm.rotateAngleX -= sajh._a(f3 * 0.067f) * 0.05f;
        if (this.aimedBow) {
            f8 = 0.0f;
            f7 = 0.0f;
            this.bipedRightArm.rotateAngleZ = 0.0f;
            this.bipedLeftArm.rotateAngleZ = 0.0f;
            this.bipedRightArm.rotateAngleY = -(0.1f - f8 * 0.6f) + this.bipedHead.rotateAngleY;
            this.bipedLeftArm.rotateAngleY = 0.1f - f8 * 0.6f + this.bipedHead.rotateAngleY + 0.4f;
            this.bipedRightArm.rotateAngleX = -1.5707964f + this.bipedHead.rotateAngleX;
            this.bipedLeftArm.rotateAngleX = -1.5707964f + this.bipedHead.rotateAngleX;
            this.bipedRightArm.rotateAngleX -= f8 * 1.2f - f7 * 0.4f;
            this.bipedLeftArm.rotateAngleX -= f8 * 1.2f - f7 * 0.4f;
            this.bipedRightArm.rotateAngleZ += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
            this.bipedLeftArm.rotateAngleZ -= sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
            this.bipedRightArm.rotateAngleX += sajh._a(f3 * 0.067f) * 0.05f;
            this.bipedLeftArm.rotateAngleX -= sajh._a(f3 * 0.067f) * 0.05f;
        }
        GloomyHooks.onSetRotationAnglesVanilla(this, f, f2, f3, f4, f5, f6, entity);
    }

    public void renderEars(float f) {
        this.bipedEars.rotateAngleY = this.bipedHead.rotateAngleY;
        this.bipedEars.rotateAngleX = this.bipedHead.rotateAngleX;
        this.bipedEars.rotationPointX = 0.0f;
        this.bipedEars.rotationPointY = 0.0f;
        this.bipedEars.render(f);
    }

    public void renderCloak(float f) {
        this.bipedCloak.render(f);
    }
}

