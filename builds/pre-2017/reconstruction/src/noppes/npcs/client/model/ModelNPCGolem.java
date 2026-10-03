/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;
import noppes.npcs.client.model.ModelNPCMale;

public class ModelNPCGolem
extends ModelNPCMale {
    private ModelRenderer bipedLowerBody;

    public ModelNPCGolem(float f) {
        super(f);
    }

    @Override
    public void init(float f, float f2) {
        super.init(f, f2);
        int n = 128;
        int n2 = 128;
        float f3 = -7.0f;
        this.bipedHead = new ModelRenderer(this).setTextureSize(n, n2);
        this.bipedHead.setRotationPoint(0.0f, f3, -2.0f);
        this.bipedHead.setTextureOffset(0, 0).addBox(-4.0f, -12.0f, -5.5f, 8, 10, 8, f);
        this.bipedHead.setTextureOffset(24, 0).addBox(-1.0f, -5.0f, -7.5f, 2, 4, 2, f);
        this.bipedHeadwear = new ModelRenderer(this).setTextureSize(n, n2);
        this.bipedHeadwear.setRotationPoint(0.0f, f3, -2.0f);
        this.bipedHeadwear.setTextureOffset(0, 85).addBox(-4.0f, -12.0f, -5.5f, 8, 10, 8, f + 0.5f);
        this.bipedBody = new ModelRenderer(this).setTextureSize(n, n2);
        this.bipedBody.setRotationPoint(0.0f, 0.0f + f3, 0.0f);
        this.bipedBody.setTextureOffset(0, 40).addBox(-9.0f, -2.0f, -6.0f, 18, 12, 11, f + 0.2f);
        this.bipedBody.setTextureOffset(0, 21).addBox(-9.0f, -2.0f, -6.0f, 18, 8, 11, f);
        this.bipedLowerBody = new ModelRenderer(this).setTextureSize(n, n2);
        this.bipedLowerBody.setRotationPoint(0.0f, 0.0f + f3, 0.0f);
        this.bipedLowerBody.setTextureOffset(0, 70).addBox(-4.5f, 10.0f, -3.0f, 9, 5, 6, f + 0.5f);
        this.bipedLowerBody.setTextureOffset(30, 70).addBox(-4.5f, 6.0f, -3.0f, 9, 9, 6, f + 0.4f);
        this.bipedRightArm = new ModelRenderer(this).setTextureSize(n, n2);
        this.bipedRightArm.setRotationPoint(0.0f, f3, 0.0f);
        this.bipedRightArm.setTextureOffset(60, 21).addBox(-13.0f, -2.5f, -3.0f, 4, 30, 6, f + 0.2f);
        this.bipedRightArm.setTextureOffset(80, 21).addBox(-13.0f, -2.5f, -3.0f, 4, 20, 6, f);
        this.bipedRightArm.setTextureOffset(100, 21).addBox(-13.0f, -2.5f, -3.0f, 4, 20, 6, f + 1.0f);
        this.bipedLeftArm = new ModelRenderer(this).setTextureSize(n, n2);
        this.bipedLeftArm.setRotationPoint(0.0f, f3, 0.0f);
        this.bipedLeftArm.setTextureOffset(60, 58).addBox(9.0f, -2.5f, -3.0f, 4, 30, 6, f + 0.2f);
        this.bipedLeftArm.setTextureOffset(80, 58).addBox(9.0f, -2.5f, -3.0f, 4, 20, 6, f);
        this.bipedLeftArm.setTextureOffset(100, 58).addBox(9.0f, -2.5f, -3.0f, 4, 20, 6, f + 1.0f);
        this.bipedLeftLeg = new ModelRenderer(this, 0, 22).setTextureSize(n, n2);
        this.bipedLeftLeg.setRotationPoint(-4.0f, 18.0f + f3, 0.0f);
        this.bipedLeftLeg.setTextureOffset(37, 0).addBox(-3.5f, -3.0f, -3.0f, 6, 16, 5, f);
        this.bipedRightLeg = new ModelRenderer(this, 0, 22).setTextureSize(n, n2);
        this.bipedRightLeg.mirror = true;
        this.bipedRightLeg.setTextureOffset(60, 0).setRotationPoint(5.0f, 18.0f + f3, 0.0f);
        this.bipedRightLeg.addBox(-3.5f, -3.0f, -3.0f, 6, 16, 5, f);
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super.render(entity, f, f2, f3, f4, f5, f6);
        this.bipedLowerBody.render(f6);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6) {
        this.bipedHead.rotateAngleY = f4 / 57.295776f;
        this.bipedHead.rotateAngleX = f5 / 57.295776f;
        this.bipedHeadwear.rotateAngleY = this.bipedHead.rotateAngleY;
        this.bipedHeadwear.rotateAngleX = this.bipedHead.rotateAngleX;
        this.bipedLeftLeg.rotateAngleX = -1.5f * this.func_78172_a(f, 13.0f) * f2;
        this.bipedRightLeg.rotateAngleX = 1.5f * this.func_78172_a(f, 13.0f) * f2;
        this.bipedLeftLeg.rotateAngleY = 0.0f;
        this.bipedRightLeg.rotateAngleY = 0.0f;
        float f7 = sajh._a(this.onGround * (float)Math.PI);
        float f8 = sajh._a((16.0f - (1.0f - this.onGround) * (1.0f - this.onGround)) * (float)Math.PI);
        if ((double)this.onGround > 0.0) {
            this.bipedRightArm.rotateAngleZ = 0.0f;
            this.bipedLeftArm.rotateAngleZ = 0.0f;
            this.bipedRightArm.rotateAngleY = -(0.1f - f7 * 0.6f);
            this.bipedLeftArm.rotateAngleY = 0.1f - f7 * 0.6f;
            this.bipedRightArm.rotateAngleX = 0.0f;
            this.bipedLeftArm.rotateAngleX = 0.0f;
            this.bipedRightArm.rotateAngleX = -1.5707964f;
            this.bipedLeftArm.rotateAngleX = -1.5707964f;
            this.bipedRightArm.rotateAngleX -= f7 * 1.2f - f8 * 0.4f;
            this.bipedLeftArm.rotateAngleX -= f7 * 1.2f - f8 * 0.4f;
        } else if (this.aimedBow) {
            float f9 = 0.0f;
            float f10 = 0.0f;
            this.bipedRightArm.rotateAngleZ = 0.0f;
            this.bipedRightArm.rotateAngleX = -1.5707964f + this.bipedHead.rotateAngleX;
            this.bipedRightArm.rotateAngleX -= f9 * 1.2f - f10 * 0.4f;
            this.bipedRightArm.rotateAngleZ += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
            this.bipedRightArm.rotateAngleX += sajh._a(f3 * 0.067f) * 0.05f;
            this.bipedLeftArm.rotateAngleX = (-0.2f - 1.5f * this.func_78172_a(f, 13.0f)) * f2;
            this.bipedBody.rotateAngleY = -(0.1f - f9 * 0.6f) + this.bipedHead.rotateAngleY;
            this.bipedRightArm.rotateAngleY = -(0.1f - f9 * 0.6f) + this.bipedHead.rotateAngleY;
            this.bipedLeftArm.rotateAngleY = 0.1f - f9 * 0.6f + this.bipedHead.rotateAngleY;
        } else {
            this.bipedRightArm.rotateAngleX = (-0.2f + 1.5f * this.func_78172_a(f, 13.0f)) * f2;
            this.bipedLeftArm.rotateAngleX = (-0.2f - 1.5f * this.func_78172_a(f, 13.0f)) * f2;
            this.bipedBody.rotateAngleY = 0.0f;
            this.bipedRightArm.rotateAngleY = 0.0f;
            this.bipedLeftArm.rotateAngleY = 0.0f;
            this.bipedRightArm.rotateAngleZ = 0.0f;
            this.bipedLeftArm.rotateAngleZ = 0.0f;
        }
        if (this.isRiding) {
            this.bipedRightArm.rotateAngleX += -0.62831855f;
            this.bipedLeftArm.rotateAngleX += -0.62831855f;
            this.bipedLeftLeg.rotateAngleX = -1.2566371f;
            this.bipedRightLeg.rotateAngleX = -1.2566371f;
            this.bipedLeftLeg.rotateAngleY = 0.31415927f;
            this.bipedRightLeg.rotateAngleY = -0.31415927f;
        }
    }

    private float func_78172_a(float f, float f2) {
        return (Math.abs(f % f2 - f2 * 0.5f) - f2 * 0.25f) / (f2 * 0.25f);
    }
}

