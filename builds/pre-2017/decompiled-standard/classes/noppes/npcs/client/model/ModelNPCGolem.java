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
        this.bipedHead = new ModelRenderer(this).func_78787_b(n, n2);
        this.bipedHead.func_78793_a(0.0f, f3, -2.0f);
        this.bipedHead.func_78784_a(0, 0).func_78790_a(-4.0f, -12.0f, -5.5f, 8, 10, 8, f);
        this.bipedHead.func_78784_a(24, 0).func_78790_a(-1.0f, -5.0f, -7.5f, 2, 4, 2, f);
        this.bipedHeadwear = new ModelRenderer(this).func_78787_b(n, n2);
        this.bipedHeadwear.func_78793_a(0.0f, f3, -2.0f);
        this.bipedHeadwear.func_78784_a(0, 85).func_78790_a(-4.0f, -12.0f, -5.5f, 8, 10, 8, f + 0.5f);
        this.bipedBody = new ModelRenderer(this).func_78787_b(n, n2);
        this.bipedBody.func_78793_a(0.0f, 0.0f + f3, 0.0f);
        this.bipedBody.func_78784_a(0, 40).func_78790_a(-9.0f, -2.0f, -6.0f, 18, 12, 11, f + 0.2f);
        this.bipedBody.func_78784_a(0, 21).func_78790_a(-9.0f, -2.0f, -6.0f, 18, 8, 11, f);
        this.bipedLowerBody = new ModelRenderer(this).func_78787_b(n, n2);
        this.bipedLowerBody.func_78793_a(0.0f, 0.0f + f3, 0.0f);
        this.bipedLowerBody.func_78784_a(0, 70).func_78790_a(-4.5f, 10.0f, -3.0f, 9, 5, 6, f + 0.5f);
        this.bipedLowerBody.func_78784_a(30, 70).func_78790_a(-4.5f, 6.0f, -3.0f, 9, 9, 6, f + 0.4f);
        this.bipedRightArm = new ModelRenderer(this).func_78787_b(n, n2);
        this.bipedRightArm.func_78793_a(0.0f, f3, 0.0f);
        this.bipedRightArm.func_78784_a(60, 21).func_78790_a(-13.0f, -2.5f, -3.0f, 4, 30, 6, f + 0.2f);
        this.bipedRightArm.func_78784_a(80, 21).func_78790_a(-13.0f, -2.5f, -3.0f, 4, 20, 6, f);
        this.bipedRightArm.func_78784_a(100, 21).func_78790_a(-13.0f, -2.5f, -3.0f, 4, 20, 6, f + 1.0f);
        this.bipedLeftArm = new ModelRenderer(this).func_78787_b(n, n2);
        this.bipedLeftArm.func_78793_a(0.0f, f3, 0.0f);
        this.bipedLeftArm.func_78784_a(60, 58).func_78790_a(9.0f, -2.5f, -3.0f, 4, 30, 6, f + 0.2f);
        this.bipedLeftArm.func_78784_a(80, 58).func_78790_a(9.0f, -2.5f, -3.0f, 4, 20, 6, f);
        this.bipedLeftArm.func_78784_a(100, 58).func_78790_a(9.0f, -2.5f, -3.0f, 4, 20, 6, f + 1.0f);
        this.bipedLeftLeg = new ModelRenderer(this, 0, 22).func_78787_b(n, n2);
        this.bipedLeftLeg.func_78793_a(-4.0f, 18.0f + f3, 0.0f);
        this.bipedLeftLeg.func_78784_a(37, 0).func_78790_a(-3.5f, -3.0f, -3.0f, 6, 16, 5, f);
        this.bipedRightLeg = new ModelRenderer(this, 0, 22).func_78787_b(n, n2);
        this.bipedRightLeg.field_78809_i = true;
        this.bipedRightLeg.func_78784_a(60, 0).func_78793_a(5.0f, 18.0f + f3, 0.0f);
        this.bipedRightLeg.func_78790_a(-3.5f, -3.0f, -3.0f, 6, 16, 5, f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super.func_78088_a(entity, f, f2, f3, f4, f5, f6);
        this.bipedLowerBody.func_78785_a(f6);
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6) {
        this.bipedHead.field_78796_g = f4 / 57.295776f;
        this.bipedHead.field_78795_f = f5 / 57.295776f;
        this.bipedHeadwear.field_78796_g = this.bipedHead.field_78796_g;
        this.bipedHeadwear.field_78795_f = this.bipedHead.field_78795_f;
        this.bipedLeftLeg.field_78795_f = -1.5f * this.func_78172_a(f, 13.0f) * f2;
        this.bipedRightLeg.field_78795_f = 1.5f * this.func_78172_a(f, 13.0f) * f2;
        this.bipedLeftLeg.field_78796_g = 0.0f;
        this.bipedRightLeg.field_78796_g = 0.0f;
        float f7 = sajh._a(this.field_78095_p * (float)Math.PI);
        float f8 = sajh._a((16.0f - (1.0f - this.field_78095_p) * (1.0f - this.field_78095_p)) * (float)Math.PI);
        if ((double)this.field_78095_p > 0.0) {
            this.bipedRightArm.field_78808_h = 0.0f;
            this.bipedLeftArm.field_78808_h = 0.0f;
            this.bipedRightArm.field_78796_g = -(0.1f - f7 * 0.6f);
            this.bipedLeftArm.field_78796_g = 0.1f - f7 * 0.6f;
            this.bipedRightArm.field_78795_f = 0.0f;
            this.bipedLeftArm.field_78795_f = 0.0f;
            this.bipedRightArm.field_78795_f = -1.5707964f;
            this.bipedLeftArm.field_78795_f = -1.5707964f;
            this.bipedRightArm.field_78795_f -= f7 * 1.2f - f8 * 0.4f;
            this.bipedLeftArm.field_78795_f -= f7 * 1.2f - f8 * 0.4f;
        } else if (this.aimedBow) {
            float f9 = 0.0f;
            float f10 = 0.0f;
            this.bipedRightArm.field_78808_h = 0.0f;
            this.bipedRightArm.field_78795_f = -1.5707964f + this.bipedHead.field_78795_f;
            this.bipedRightArm.field_78795_f -= f9 * 1.2f - f10 * 0.4f;
            this.bipedRightArm.field_78808_h += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
            this.bipedRightArm.field_78795_f += sajh._a(f3 * 0.067f) * 0.05f;
            this.bipedLeftArm.field_78795_f = (-0.2f - 1.5f * this.func_78172_a(f, 13.0f)) * f2;
            this.bipedBody.field_78796_g = -(0.1f - f9 * 0.6f) + this.bipedHead.field_78796_g;
            this.bipedRightArm.field_78796_g = -(0.1f - f9 * 0.6f) + this.bipedHead.field_78796_g;
            this.bipedLeftArm.field_78796_g = 0.1f - f9 * 0.6f + this.bipedHead.field_78796_g;
        } else {
            this.bipedRightArm.field_78795_f = (-0.2f + 1.5f * this.func_78172_a(f, 13.0f)) * f2;
            this.bipedLeftArm.field_78795_f = (-0.2f - 1.5f * this.func_78172_a(f, 13.0f)) * f2;
            this.bipedBody.field_78796_g = 0.0f;
            this.bipedRightArm.field_78796_g = 0.0f;
            this.bipedLeftArm.field_78796_g = 0.0f;
            this.bipedRightArm.field_78808_h = 0.0f;
            this.bipedLeftArm.field_78808_h = 0.0f;
        }
        if (this.field_78093_q) {
            this.bipedRightArm.field_78795_f += -0.62831855f;
            this.bipedLeftArm.field_78795_f += -0.62831855f;
            this.bipedLeftLeg.field_78795_f = -1.2566371f;
            this.bipedRightLeg.field_78795_f = -1.2566371f;
            this.bipedLeftLeg.field_78796_g = 0.31415927f;
            this.bipedRightLeg.field_78796_g = -0.31415927f;
        }
    }

    private float func_78172_a(float f, float f2) {
        return (Math.abs(f % f2 - f2 * 0.5f) - f2 * 0.25f) / (f2 * 0.25f);
    }
}

