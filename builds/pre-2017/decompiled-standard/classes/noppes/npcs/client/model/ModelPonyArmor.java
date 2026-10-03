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
        this.head.func_78790_a(-4.0f, -4.0f, -6.0f, 8, 8, 8, f);
        this.head.func_78793_a(f3, f4, f5);
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        this.Body = new ModelRenderer(this, 16, 16);
        this.Body.func_78790_a(-4.0f, 4.0f, -2.0f, 8, 8, 4, f);
        this.Body.func_78793_a(f6, f7 + f2, f8);
        this.BodyBack = new ModelRenderer(this, 0, 0);
        this.BodyBack.func_78790_a(-4.0f, 4.0f, 6.0f, 8, 8, 8, f);
        this.BodyBack.func_78793_a(f6, f7 + f2, f8);
        this.rightarm = new ModelRenderer(this, 0, 16);
        this.rightarm.func_78790_a(-2.0f, 4.0f, -2.0f, 4, 12, 4, f);
        this.rightarm.func_78793_a(-3.0f, 8.0f + f2, 0.0f);
        this.LeftArm = new ModelRenderer(this, 0, 16);
        this.LeftArm.field_78809_i = true;
        this.LeftArm.func_78790_a(-2.0f, 4.0f, -2.0f, 4, 12, 4, f);
        this.LeftArm.func_78793_a(3.0f, 8.0f + f2, 0.0f);
        this.RightLeg = new ModelRenderer(this, 0, 16);
        this.RightLeg.func_78790_a(-2.0f, 4.0f, -2.0f, 4, 12, 4, f);
        this.RightLeg.func_78793_a(-3.0f, 0.0f + f2, 0.0f);
        this.LeftLeg = new ModelRenderer(this, 0, 16);
        this.LeftLeg.field_78809_i = true;
        this.LeftLeg.func_78790_a(-2.0f, 4.0f, -2.0f, 4, 12, 4, f);
        this.LeftLeg.func_78793_a(3.0f, 0.0f + f2, 0.0f);
        this.rightarm2 = new ModelRenderer(this, 0, 16);
        this.rightarm2.func_78790_a(-2.0f, 4.0f, -2.0f, 4, 12, 4, f * 0.5f);
        this.rightarm2.func_78793_a(-3.0f, 8.0f + f2, 0.0f);
        this.LeftArm2 = new ModelRenderer(this, 0, 16);
        this.LeftArm2.field_78809_i = true;
        this.LeftArm2.func_78790_a(-2.0f, 4.0f, -2.0f, 4, 12, 4, f * 0.5f);
        this.LeftArm2.func_78793_a(3.0f, 8.0f + f2, 0.0f);
        this.RightLeg2 = new ModelRenderer(this, 0, 16);
        this.RightLeg2.func_78790_a(-2.0f, 4.0f, -2.0f, 4, 12, 4, f * 0.5f);
        this.RightLeg2.func_78793_a(-3.0f, 0.0f + f2, 0.0f);
        this.LeftLeg2 = new ModelRenderer(this, 0, 16);
        this.LeftLeg2.field_78809_i = true;
        this.LeftLeg2.func_78790_a(-2.0f, 4.0f, -2.0f, 4, 12, 4, f * 0.5f);
        this.LeftLeg2.func_78793_a(3.0f, 0.0f + f2, 0.0f);
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
        this.head.field_78796_g = f16;
        this.head.field_78795_f = f15;
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
            this.rightarm.field_78796_g = 0.2f;
            this.LeftArm.field_78796_g = -0.2f;
            this.RightLeg.field_78796_g = -0.2f;
            this.LeftLeg.field_78796_g = 0.2f;
            this.rightarm2.field_78796_g = 0.2f;
            this.LeftArm2.field_78796_g = -0.2f;
            this.RightLeg2.field_78796_g = -0.2f;
            this.LeftLeg2.field_78796_g = 0.2f;
        } else {
            f14 = sajh._b(f * 0.6662f + 3.141593f) * 0.6f * f2;
            f13 = sajh._b(f * 0.6662f) * 0.6f * f2;
            f12 = sajh._b(f * 0.6662f) * 0.3f * f2;
            f11 = sajh._b(f * 0.6662f + 3.141593f) * 0.3f * f2;
            this.rightarm.field_78796_g = 0.0f;
            this.LeftArm.field_78796_g = 0.0f;
            this.RightLeg.field_78796_g = 0.0f;
            this.LeftLeg.field_78796_g = 0.0f;
            this.rightarm2.field_78796_g = 0.0f;
            this.LeftArm2.field_78796_g = 0.0f;
            this.RightLeg2.field_78796_g = 0.0f;
            this.LeftLeg2.field_78796_g = 0.0f;
        }
        if (this.isSleeping) {
            f14 = 4.712f;
            f13 = 4.712f;
            f12 = 1.571f;
            f11 = 1.571f;
        }
        this.rightarm.field_78795_f = f14;
        this.LeftArm.field_78795_f = f13;
        this.RightLeg.field_78795_f = f12;
        this.LeftLeg.field_78795_f = f11;
        this.rightarm.field_78808_h = 0.0f;
        this.LeftArm.field_78808_h = 0.0f;
        this.rightarm2.field_78795_f = f14;
        this.LeftArm2.field_78795_f = f13;
        this.RightLeg2.field_78795_f = f12;
        this.LeftLeg2.field_78795_f = f11;
        this.rightarm2.field_78808_h = 0.0f;
        this.LeftArm2.field_78808_h = 0.0f;
        if (this.heldItemRight != 0 && !this.rainboom && !this.isUnicorn) {
            this.rightarm.field_78795_f = this.rightarm.field_78795_f * 0.5f - 0.3141593f;
            this.rightarm2.field_78795_f = this.rightarm2.field_78795_f * 0.5f - 0.3141593f;
        }
        float f17 = 0.0f;
        if (f6 > -9990.0f && !this.isUnicorn) {
            f17 = sajh._a(sajh._c(f6) * 3.141593f * 2.0f) * 0.2f;
        }
        this.Body.field_78796_g = (float)((double)f17 * 0.2);
        this.BodyBack.field_78796_g = (float)((double)f17 * 0.2);
        float f18 = sajh._a(this.Body.field_78796_g) * 5.0f;
        float f19 = sajh._b(this.Body.field_78796_g) * 5.0f;
        float f20 = 4.0f;
        if (this.isSneak && !this.isFlying) {
            f20 = 0.0f;
        }
        if (this.isSleeping) {
            f20 = 2.6f;
        }
        if (this.rainboom) {
            this.rightarm.field_78798_e = f18 + 2.0f;
            this.rightarm2.field_78798_e = f18 + 2.0f;
            this.LeftArm.field_78798_e = 0.0f - f18 + 2.0f;
            this.LeftArm2.field_78798_e = 0.0f - f18 + 2.0f;
        } else {
            this.rightarm.field_78798_e = f18 + 1.0f;
            this.rightarm2.field_78798_e = f18 + 1.0f;
            this.LeftArm.field_78798_e = 0.0f - f18 + 1.0f;
            this.LeftArm2.field_78798_e = 0.0f - f18 + 1.0f;
        }
        this.rightarm.field_78800_c = 0.0f - f19 - 1.0f + f20;
        this.rightarm2.field_78800_c = 0.0f - f19 - 1.0f + f20;
        this.LeftArm.field_78800_c = f19 + 1.0f - f20;
        this.LeftArm2.field_78800_c = f19 + 1.0f - f20;
        this.RightLeg.field_78800_c = 0.0f - f19 - 1.0f + f20;
        this.RightLeg2.field_78800_c = 0.0f - f19 - 1.0f + f20;
        this.LeftLeg.field_78800_c = f19 + 1.0f - f20;
        this.LeftLeg2.field_78800_c = f19 + 1.0f - f20;
        this.rightarm.field_78796_g += this.Body.field_78796_g;
        this.rightarm2.field_78796_g += this.Body.field_78796_g;
        this.LeftArm.field_78796_g += this.Body.field_78796_g;
        this.LeftArm2.field_78796_g += this.Body.field_78796_g;
        this.LeftArm.field_78795_f += this.Body.field_78796_g;
        this.LeftArm2.field_78795_f += this.Body.field_78796_g;
        this.rightarm.field_78797_d = 8.0f;
        this.LeftArm.field_78797_d = 8.0f;
        this.RightLeg.field_78797_d = 4.0f;
        this.LeftLeg.field_78797_d = 4.0f;
        this.rightarm2.field_78797_d = 8.0f;
        this.LeftArm2.field_78797_d = 8.0f;
        this.RightLeg2.field_78797_d = 4.0f;
        this.LeftLeg2.field_78797_d = 4.0f;
        if (f6 > -9990.0f && !this.isUnicorn) {
            f10 = 1.0f - f6;
            f10 *= f10 * f10;
            f10 = 1.0f - f10;
            f9 = sajh._a(f10 * 3.141593f);
            f8 = sajh._a(f6 * 3.141593f);
            f7 = f8 * -(this.head.field_78795_f - 0.7f) * 0.75f;
        }
        if (this.isSneak && !this.isFlying) {
            float f21;
            float f22;
            f10 = 0.4f;
            f9 = 7.0f;
            f8 = -4.0f;
            this.Body.field_78795_f = f10;
            this.Body.field_78797_d = f9;
            this.Body.field_78798_e = f8;
            this.BodyBack.field_78795_f = f10;
            this.BodyBack.field_78797_d = f9;
            this.BodyBack.field_78798_e = f8;
            this.RightLeg.field_78795_f -= 0.0f;
            this.LeftLeg.field_78795_f -= 0.0f;
            this.rightarm.field_78795_f -= 0.4f;
            this.LeftArm.field_78795_f -= 0.4f;
            this.RightLeg.field_78798_e = 10.0f;
            this.LeftLeg.field_78798_e = 10.0f;
            this.RightLeg.field_78797_d = 7.0f;
            this.LeftLeg.field_78797_d = 7.0f;
            this.RightLeg2.field_78795_f -= 0.0f;
            this.LeftLeg2.field_78795_f -= 0.0f;
            this.rightarm2.field_78795_f -= 0.4f;
            this.LeftArm2.field_78795_f -= 0.4f;
            this.RightLeg2.field_78798_e = 10.0f;
            this.LeftLeg2.field_78798_e = 10.0f;
            this.RightLeg2.field_78797_d = 7.0f;
            this.LeftLeg2.field_78797_d = 7.0f;
            if (this.isSleeping) {
                f7 = 2.0f;
                f22 = -1.0f;
                f21 = 1.0f;
            } else {
                f7 = 6.0f;
                f22 = -2.0f;
                f21 = 0.0f;
            }
            this.head.field_78797_d = f7;
            this.head.field_78798_e = f22;
            this.head.field_78800_c = f21;
        } else {
            f10 = 0.0f;
            f9 = 0.0f;
            f8 = 0.0f;
            this.Body.field_78795_f = f10;
            this.Body.field_78797_d = f9;
            this.Body.field_78798_e = f8;
            this.BodyBack.field_78795_f = f10;
            this.BodyBack.field_78797_d = f9;
            this.BodyBack.field_78798_e = f8;
            this.RightLeg.field_78798_e = 10.0f;
            this.LeftLeg.field_78798_e = 10.0f;
            this.RightLeg.field_78797_d = 8.0f;
            this.LeftLeg.field_78797_d = 8.0f;
            this.RightLeg2.field_78798_e = 10.0f;
            this.LeftLeg2.field_78798_e = 10.0f;
            this.RightLeg2.field_78797_d = 8.0f;
            this.LeftLeg2.field_78797_d = 8.0f;
            f7 = sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
            float f23 = sajh._a(f3 * 0.067f) * 0.05f;
            float f24 = 0.0f;
            float f25 = 0.0f;
            this.head.field_78797_d = f24;
            this.head.field_78798_e = f25;
        }
        if (this.isSleeping) {
            this.rightarm.field_78798_e += 6.0f;
            this.LeftArm.field_78798_e += 6.0f;
            this.RightLeg.field_78798_e -= 8.0f;
            this.LeftLeg.field_78798_e -= 8.0f;
            this.rightarm.field_78797_d += 2.0f;
            this.LeftArm.field_78797_d += 2.0f;
            this.RightLeg.field_78797_d += 2.0f;
            this.LeftLeg.field_78797_d += 2.0f;
            this.rightarm2.field_78798_e += 6.0f;
            this.LeftArm2.field_78798_e += 6.0f;
            this.RightLeg2.field_78798_e -= 8.0f;
            this.LeftLeg2.field_78798_e -= 8.0f;
            this.rightarm2.field_78797_d += 2.0f;
            this.LeftArm2.field_78797_d += 2.0f;
            this.RightLeg2.field_78797_d += 2.0f;
            this.LeftLeg2.field_78797_d += 2.0f;
        }
        if (this.aimedBow && !this.isUnicorn) {
            f10 = 0.0f;
            f9 = 0.0f;
            this.rightarm.field_78808_h = 0.0f;
            this.rightarm.field_78796_g = -(0.1f - f10 * 0.6f) + this.head.field_78796_g;
            this.rightarm.field_78795_f = 4.712f + this.head.field_78795_f;
            this.rightarm.field_78795_f -= f10 * 1.2f - f9 * 0.4f;
            this.rightarm.field_78808_h += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
            this.rightarm.field_78795_f += sajh._a(f3 * 0.067f) * 0.05f;
            this.rightarm2.field_78808_h = 0.0f;
            this.rightarm2.field_78796_g = -(0.1f - f10 * 0.6f) + this.head.field_78796_g;
            this.rightarm2.field_78795_f = 4.712f + this.head.field_78795_f;
            this.rightarm2.field_78795_f -= f10 * 1.2f - f9 * 0.4f;
            this.rightarm2.field_78808_h += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
            this.rightarm2.field_78795_f += sajh._a(f3 * 0.067f) * 0.05f;
            this.rightarm.field_78798_e += 1.0f;
            this.rightarm2.field_78798_e += 1.0f;
        }
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.setRotationAngles(f, f2, f3, f4, f5, f6);
        this.head.func_78785_a(f6);
        this.Body.func_78785_a(f6);
        this.BodyBack.func_78785_a(f6);
        this.LeftArm.func_78785_a(f6);
        this.rightarm.func_78785_a(f6);
        this.LeftLeg.func_78785_a(f6);
        this.RightLeg.func_78785_a(f6);
        this.LeftArm2.func_78785_a(f6);
        this.rightarm2.func_78785_a(f6);
        this.LeftLeg2.func_78785_a(f6);
        this.RightLeg2.func_78785_a(f6);
    }
}

