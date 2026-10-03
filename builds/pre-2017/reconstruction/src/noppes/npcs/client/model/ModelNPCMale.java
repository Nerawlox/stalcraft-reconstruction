/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.sajh;
import noppes.npcs.CustomNpcs;
import org.lwjgl.opengl.GL11;

public class ModelNPCMale
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
    public boolean isDancing;
    public boolean isSleeping;
    public float animationTick;
    public float dancingTicks;

    public ModelNPCMale(float f) {
        this.init(f, 0.0f);
    }

    public ModelNPCMale(int n, int n2, float f) {
        this.textureHeight = n2;
        this.textureWidth = n;
        this.init(f, 0.0f);
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        this.animationTick += f3;
        this.dancingTicks = (float)CustomNpcs.ticks / 3.978873f;
    }

    public void init(float f, float f2) {
        this.heldItemLeft = 0;
        this.heldItemRight = 0;
        this.isSneak = false;
        this.aimedBow = false;
        this.bipedCloak = new ModelRenderer(this, 0, 0);
        this.bipedCloak.textureHeight = 32.0f;
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
        this.bipedRightLeg.setRotationPoint(-2.0f, 12.0f + f2, 0.0f);
        this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, f);
        this.bipedLeftLeg.setRotationPoint(2.0f, 12.0f + f2, 0.0f);
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.setRotationAngles(f, f2, f3, f4, f5, f6);
        if (!this.isDancing) {
            this.bipedBody.render(f6);
            this.bipedRightArm.render(f6);
            this.bipedLeftArm.render(f6);
            this.bipedRightLeg.render(f6);
            this.bipedLeftLeg.render(f6);
            this.bipedHead.render(f6);
            this.bipedHeadwear.render(f6);
        } else {
            this.renderHead(entity, f6);
            this.renderBody(entity, f6);
            this.renderArms(entity, f6);
            this.renderLegs(entity, f6);
        }
    }

    public void renderHead(Entity entity, float f) {
        if (this.isDancing) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)Math.sin(this.dancingTicks) * 0.075f, (float)Math.abs(Math.cos(this.dancingTicks)) * 0.125f - 0.02f, (float)(-Math.abs(Math.cos(this.dancingTicks))) * 0.075f);
            this.bipedHead.render(f);
            this.bipedHeadwear.render(f);
            GL11.glPopMatrix();
        } else {
            this.bipedHead.render(f);
            this.bipedHeadwear.render(f);
        }
    }

    public void renderLeftArm(Entity entity, float f) {
        if (this.isDancing) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)Math.sin(this.dancingTicks) * 0.025f, (float)Math.abs(Math.cos(this.dancingTicks)) * 0.125f - 0.02f, 0.0f);
            this.bipedLeftArm.render(f);
            GL11.glPopMatrix();
        } else {
            this.bipedLeftArm.render(f);
        }
    }

    public void renderArms(Entity entity, float f) {
        this.renderLeftArm(entity, f);
        this.renderRightArm(entity, f);
    }

    public void renderRightArm(Entity entity, float f) {
        if (this.isDancing) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)Math.sin(this.dancingTicks) * 0.025f, (float)Math.abs(Math.cos(this.dancingTicks)) * 0.125f - 0.02f, 0.0f);
            this.bipedRightArm.render(f);
            GL11.glPopMatrix();
        } else {
            this.bipedRightArm.render(f);
        }
    }

    public void renderBody(Entity entity, float f) {
        if (this.isDancing) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)Math.sin(this.dancingTicks) * 0.015f, 0.0f, 0.0f);
            this.bipedBody.render(f);
            GL11.glPopMatrix();
        } else {
            this.bipedBody.render(f);
        }
    }

    public void renderLegs(Entity entity, float f) {
        this.bipedRightLeg.render(f);
        this.bipedLeftLeg.render(f);
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6) {
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
            this.bipedRightLeg.rotateAngleX -= 0.0f;
            this.bipedLeftLeg.rotateAngleX -= 0.0f;
            this.bipedRightArm.rotateAngleX += 0.4f;
            this.bipedLeftArm.rotateAngleX += 0.4f;
            this.bipedRightLeg.rotationPointZ = 4.0f;
            this.bipedLeftLeg.rotationPointZ = 4.0f;
            this.bipedRightLeg.rotationPointY = 9.0f;
            this.bipedLeftLeg.rotationPointY = 9.0f;
            this.bipedHead.rotationPointY = 1.0f;
        } else {
            this.bipedBody.rotateAngleX = 0.0f;
            this.bipedRightLeg.rotationPointZ = 0.0f;
            this.bipedLeftLeg.rotationPointZ = 0.0f;
            this.bipedRightLeg.rotationPointY = 12.0f;
            this.bipedLeftLeg.rotationPointY = 12.0f;
            this.bipedHead.rotationPointY = 0.0f;
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
    }

    public void renderEars(float f) {
        this.bipedEars.rotateAngleY = this.bipedHead.rotateAngleY;
        this.bipedEars.rotateAngleX = this.bipedHead.rotateAngleX;
        this.bipedEars.rotationPointX = 0.0f;
        this.bipedEars.rotationPointY = 0.0f;
        this.bipedEars.render(f);
    }

    public void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.rotateAngleX = f;
        modelRenderer.rotateAngleY = f2;
        modelRenderer.rotateAngleZ = f3;
    }

    public void renderCloak(float f) {
        this.bipedCloak.render(f);
    }
}

