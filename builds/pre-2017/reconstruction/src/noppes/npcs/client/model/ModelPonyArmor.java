/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class ModelPonyArmor
extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer Body;
    public ModelRenderer BodyBack;
    public ModelRenderer rightarm;
    public ModelRenderer LeftArm;
    public ModelRenderer RightLeg;
    public ModelRenderer LeftLeg;
    public ModelRenderer rightarm2;
    public ModelRenderer LeftArm2;
    public ModelRenderer RightLeg2;
    public ModelRenderer LeftLeg2;
    public boolean isPegasus = false;
    public boolean isUnicorn = false;
    public boolean isSleeping = false;
    public boolean isFlying = false;
    public boolean isGlow = false;
    public boolean isSneak = false;
    public boolean aimedBow;
    public int heldItemRight;
    private boolean rainboom;

    public ModelPonyArmor(float f) {
        this.init(f, 0.0f);
    }

    public void init(float f, float f2) {
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-4.0f, -4.0f, -6.0f, 8, 8, 8, f);
        this.head.setRotationPoint(f3, f4, f5);
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        this.Body = new ModelRenderer(this, 16, 16);
        this.Body.addBox(-4.0f, 4.0f, -2.0f, 8, 8, 4, f);
        this.Body.setRotationPoint(f6, f7 + f2, f8);
        this.BodyBack = new ModelRenderer(this, 0, 0);
        this.BodyBack.addBox(-4.0f, 4.0f, 6.0f, 8, 8, 8, f);
        this.BodyBack.setRotationPoint(f6, f7 + f2, f8);
        this.rightarm = new ModelRenderer(this, 0, 16);
        this.rightarm.addBox(-2.0f, 4.0f, -2.0f, 4, 12, 4, f);
        this.rightarm.setRotationPoint(-3.0f, 8.0f + f2, 0.0f);
        this.LeftArm = new ModelRenderer(this, 0, 16);
        this.LeftArm.mirror = true;
        this.LeftArm.addBox(-2.0f, 4.0f, -2.0f, 4, 12, 4, f);
        this.LeftArm.setRotationPoint(3.0f, 8.0f + f2, 0.0f);
        this.RightLeg = new ModelRenderer(this, 0, 16);
        this.RightLeg.addBox(-2.0f, 4.0f, -2.0f, 4, 12, 4, f);
        this.RightLeg.setRotationPoint(-3.0f, 0.0f + f2, 0.0f);
        this.LeftLeg = new ModelRenderer(this, 0, 16);
        this.LeftLeg.mirror = true;
        this.LeftLeg.addBox(-2.0f, 4.0f, -2.0f, 4, 12, 4, f);
        this.LeftLeg.setRotationPoint(3.0f, 0.0f + f2, 0.0f);
        this.rightarm2 = new ModelRenderer(this, 0, 16);
        this.rightarm2.addBox(-2.0f, 4.0f, -2.0f, 4, 12, 4, f * 0.5f);
        this.rightarm2.setRotationPoint(-3.0f, 8.0f + f2, 0.0f);
        this.LeftArm2 = new ModelRenderer(this, 0, 16);
        this.LeftArm2.mirror = true;
        this.LeftArm2.addBox(-2.0f, 4.0f, -2.0f, 4, 12, 4, f * 0.5f);
        this.LeftArm2.setRotationPoint(3.0f, 8.0f + f2, 0.0f);
        this.RightLeg2 = new ModelRenderer(this, 0, 16);
        this.RightLeg2.addBox(-2.0f, 4.0f, -2.0f, 4, 12, 4, f * 0.5f);
        this.RightLeg2.setRotationPoint(-3.0f, 0.0f + f2, 0.0f);
        this.LeftLeg2 = new ModelRenderer(this, 0, 16);
        this.LeftLeg2.mirror = true;
        this.LeftLeg2.addBox(-2.0f, 4.0f, -2.0f, 4, 12, 4, f * 0.5f);
        this.LeftLeg2.setRotationPoint(3.0f, 0.0f + f2, 0.0f);
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        this.rainboom = false;
        if (this.isSleeping) {
            f16 = 1.4f;
            f15 = 0.1f;
        } else {
            f16 = f4 / 57.29578f;
            f15 = f5 / 57.29578f;
        }
        this.head.rotateAngleY = f16;
        this.head.rotateAngleX = f15;
        if (this.isFlying && this.isPegasus) {
            if (f2 < 0.9999f) {
                this.rainboom = false;
                f14 = sajh._a(0.0f - f2 * 0.5f);
                f13 = sajh._a(0.0f - f2 * 0.5f);
                f12 = sajh._a(f2 * 0.5f);
                f11 = sajh._a(f2 * 0.5f);
            } else {
                this.rainboom = true;
                f14 = 4.712f;
                f13 = 4.712f;
                f12 = 1.571f;
                f11 = 1.571f;
            }
            this.rightarm.rotateAngleY = 0.2f;
            this.LeftArm.rotateAngleY = -0.2f;
            this.RightLeg.rotateAngleY = -0.2f;
            this.LeftLeg.rotateAngleY = 0.2f;
            this.rightarm2.rotateAngleY = 0.2f;
            this.LeftArm2.rotateAngleY = -0.2f;
            this.RightLeg2.rotateAngleY = -0.2f;
            this.LeftLeg2.rotateAngleY = 0.2f;
        } else {
            f14 = sajh._b(f * 0.6662f + 3.141593f) * 0.6f * f2;
            f13 = sajh._b(f * 0.6662f) * 0.6f * f2;
            f12 = sajh._b(f * 0.6662f) * 0.3f * f2;
            f11 = sajh._b(f * 0.6662f + 3.141593f) * 0.3f * f2;
            this.rightarm.rotateAngleY = 0.0f;
            this.LeftArm.rotateAngleY = 0.0f;
            this.RightLeg.rotateAngleY = 0.0f;
            this.LeftLeg.rotateAngleY = 0.0f;
            this.rightarm2.rotateAngleY = 0.0f;
            this.LeftArm2.rotateAngleY = 0.0f;
            this.RightLeg2.rotateAngleY = 0.0f;
            this.LeftLeg2.rotateAngleY = 0.0f;
        }
        if (this.isSleeping) {
            f14 = 4.712f;
            f13 = 4.712f;
            f12 = 1.571f;
            f11 = 1.571f;
        }
        this.rightarm.rotateAngleX = f14;
        this.LeftArm.rotateAngleX = f13;
        this.RightLeg.rotateAngleX = f12;
        this.LeftLeg.rotateAngleX = f11;
        this.rightarm.rotateAngleZ = 0.0f;
        this.LeftArm.rotateAngleZ = 0.0f;
        this.rightarm2.rotateAngleX = f14;
        this.LeftArm2.rotateAngleX = f13;
        this.RightLeg2.rotateAngleX = f12;
        this.LeftLeg2.rotateAngleX = f11;
        this.rightarm2.rotateAngleZ = 0.0f;
        this.LeftArm2.rotateAngleZ = 0.0f;
        if (this.heldItemRight != 0 && !this.rainboom && !this.isUnicorn) {
            this.rightarm.rotateAngleX = this.rightarm.rotateAngleX * 0.5f - 0.3141593f;
            this.rightarm2.rotateAngleX = this.rightarm2.rotateAngleX * 0.5f - 0.3141593f;
        }
        float f17 = 0.0f;
        if (f6 > -9990.0f && !this.isUnicorn) {
            f17 = sajh._a(sajh._c(f6) * 3.141593f * 2.0f) * 0.2f;
        }
        this.Body.rotateAngleY = (float)((double)f17 * 0.2);
        this.BodyBack.rotateAngleY = (float)((double)f17 * 0.2);
        float f18 = sajh._a(this.Body.rotateAngleY) * 5.0f;
        float f19 = sajh._b(this.Body.rotateAngleY) * 5.0f;
        float f20 = 4.0f;
        if (this.isSneak && !this.isFlying) {
            f20 = 0.0f;
        }
        if (this.isSleeping) {
            f20 = 2.6f;
        }
        if (this.rainboom) {
            this.rightarm.rotationPointZ = f18 + 2.0f;
            this.rightarm2.rotationPointZ = f18 + 2.0f;
            this.LeftArm.rotationPointZ = 0.0f - f18 + 2.0f;
            this.LeftArm2.rotationPointZ = 0.0f - f18 + 2.0f;
        } else {
            this.rightarm.rotationPointZ = f18 + 1.0f;
            this.rightarm2.rotationPointZ = f18 + 1.0f;
            this.LeftArm.rotationPointZ = 0.0f - f18 + 1.0f;
            this.LeftArm2.rotationPointZ = 0.0f - f18 + 1.0f;
        }
        this.rightarm.rotationPointX = 0.0f - f19 - 1.0f + f20;
        this.rightarm2.rotationPointX = 0.0f - f19 - 1.0f + f20;
        this.LeftArm.rotationPointX = f19 + 1.0f - f20;
        this.LeftArm2.rotationPointX = f19 + 1.0f - f20;
        this.RightLeg.rotationPointX = 0.0f - f19 - 1.0f + f20;
        this.RightLeg2.rotationPointX = 0.0f - f19 - 1.0f + f20;
        this.LeftLeg.rotationPointX = f19 + 1.0f - f20;
        this.LeftLeg2.rotationPointX = f19 + 1.0f - f20;
        this.rightarm.rotateAngleY += this.Body.rotateAngleY;
        this.rightarm2.rotateAngleY += this.Body.rotateAngleY;
        this.LeftArm.rotateAngleY += this.Body.rotateAngleY;
        this.LeftArm2.rotateAngleY += this.Body.rotateAngleY;
        this.LeftArm.rotateAngleX += this.Body.rotateAngleY;
        this.LeftArm2.rotateAngleX += this.Body.rotateAngleY;
        this.rightarm.rotationPointY = 8.0f;
        this.LeftArm.rotationPointY = 8.0f;
        this.RightLeg.rotationPointY = 4.0f;
        this.LeftLeg.rotationPointY = 4.0f;
        this.rightarm2.rotationPointY = 8.0f;
        this.LeftArm2.rotationPointY = 8.0f;
        this.RightLeg2.rotationPointY = 4.0f;
        this.LeftLeg2.rotationPointY = 4.0f;
        if (f6 > -9990.0f && !this.isUnicorn) {
            f10 = 1.0f - f6;
            f10 *= f10 * f10;
            f10 = 1.0f - f10;
            f9 = sajh._a(f10 * 3.141593f);
            f8 = sajh._a(f6 * 3.141593f);
            f7 = f8 * -(this.head.rotateAngleX - 0.7f) * 0.75f;
        }
        if (this.isSneak && !this.isFlying) {
            float f21;
            float f22;
            f10 = 0.4f;
            f9 = 7.0f;
            f8 = -4.0f;
            this.Body.rotateAngleX = f10;
            this.Body.rotationPointY = f9;
            this.Body.rotationPointZ = f8;
            this.BodyBack.rotateAngleX = f10;
            this.BodyBack.rotationPointY = f9;
            this.BodyBack.rotationPointZ = f8;
            this.RightLeg.rotateAngleX -= 0.0f;
            this.LeftLeg.rotateAngleX -= 0.0f;
            this.rightarm.rotateAngleX -= 0.4f;
            this.LeftArm.rotateAngleX -= 0.4f;
            this.RightLeg.rotationPointZ = 10.0f;
            this.LeftLeg.rotationPointZ = 10.0f;
            this.RightLeg.rotationPointY = 7.0f;
            this.LeftLeg.rotationPointY = 7.0f;
            this.RightLeg2.rotateAngleX -= 0.0f;
            this.LeftLeg2.rotateAngleX -= 0.0f;
            this.rightarm2.rotateAngleX -= 0.4f;
            this.LeftArm2.rotateAngleX -= 0.4f;
            this.RightLeg2.rotationPointZ = 10.0f;
            this.LeftLeg2.rotationPointZ = 10.0f;
            this.RightLeg2.rotationPointY = 7.0f;
            this.LeftLeg2.rotationPointY = 7.0f;
            if (this.isSleeping) {
                f7 = 2.0f;
                f22 = -1.0f;
                f21 = 1.0f;
            } else {
                f7 = 6.0f;
                f22 = -2.0f;
                f21 = 0.0f;
            }
            this.head.rotationPointY = f7;
            this.head.rotationPointZ = f22;
            this.head.rotationPointX = f21;
        } else {
            f10 = 0.0f;
            f9 = 0.0f;
            f8 = 0.0f;
            this.Body.rotateAngleX = f10;
            this.Body.rotationPointY = f9;
            this.Body.rotationPointZ = f8;
            this.BodyBack.rotateAngleX = f10;
            this.BodyBack.rotationPointY = f9;
            this.BodyBack.rotationPointZ = f8;
            this.RightLeg.rotationPointZ = 10.0f;
            this.LeftLeg.rotationPointZ = 10.0f;
            this.RightLeg.rotationPointY = 8.0f;
            this.LeftLeg.rotationPointY = 8.0f;
            this.RightLeg2.rotationPointZ = 10.0f;
            this.LeftLeg2.rotationPointZ = 10.0f;
            this.RightLeg2.rotationPointY = 8.0f;
            this.LeftLeg2.rotationPointY = 8.0f;
            f7 = sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
            float f23 = sajh._a(f3 * 0.067f) * 0.05f;
            float f24 = 0.0f;
            float f25 = 0.0f;
            this.head.rotationPointY = f24;
            this.head.rotationPointZ = f25;
        }
        if (this.isSleeping) {
            this.rightarm.rotationPointZ += 6.0f;
            this.LeftArm.rotationPointZ += 6.0f;
            this.RightLeg.rotationPointZ -= 8.0f;
            this.LeftLeg.rotationPointZ -= 8.0f;
            this.rightarm.rotationPointY += 2.0f;
            this.LeftArm.rotationPointY += 2.0f;
            this.RightLeg.rotationPointY += 2.0f;
            this.LeftLeg.rotationPointY += 2.0f;
            this.rightarm2.rotationPointZ += 6.0f;
            this.LeftArm2.rotationPointZ += 6.0f;
            this.RightLeg2.rotationPointZ -= 8.0f;
            this.LeftLeg2.rotationPointZ -= 8.0f;
            this.rightarm2.rotationPointY += 2.0f;
            this.LeftArm2.rotationPointY += 2.0f;
            this.RightLeg2.rotationPointY += 2.0f;
            this.LeftLeg2.rotationPointY += 2.0f;
        }
        if (this.aimedBow && !this.isUnicorn) {
            f10 = 0.0f;
            f9 = 0.0f;
            this.rightarm.rotateAngleZ = 0.0f;
            this.rightarm.rotateAngleY = -(0.1f - f10 * 0.6f) + this.head.rotateAngleY;
            this.rightarm.rotateAngleX = 4.712f + this.head.rotateAngleX;
            this.rightarm.rotateAngleX -= f10 * 1.2f - f9 * 0.4f;
            this.rightarm.rotateAngleZ += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
            this.rightarm.rotateAngleX += sajh._a(f3 * 0.067f) * 0.05f;
            this.rightarm2.rotateAngleZ = 0.0f;
            this.rightarm2.rotateAngleY = -(0.1f - f10 * 0.6f) + this.head.rotateAngleY;
            this.rightarm2.rotateAngleX = 4.712f + this.head.rotateAngleX;
            this.rightarm2.rotateAngleX -= f10 * 1.2f - f9 * 0.4f;
            this.rightarm2.rotateAngleZ += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
            this.rightarm2.rotateAngleX += sajh._a(f3 * 0.067f) * 0.05f;
            this.rightarm.rotationPointZ += 1.0f;
            this.rightarm2.rotationPointZ += 1.0f;
        }
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.setRotationAngles(f, f2, f3, f4, f5, f6);
        this.head.render(f6);
        this.Body.render(f6);
        this.BodyBack.render(f6);
        this.LeftArm.render(f6);
        this.rightarm.render(f6);
        this.LeftLeg.render(f6);
        this.RightLeg.render(f6);
        this.LeftArm2.render(f6);
        this.rightarm2.render(f6);
        this.LeftLeg2.render(f6);
        this.RightLeg2.render(f6);
    }
}

