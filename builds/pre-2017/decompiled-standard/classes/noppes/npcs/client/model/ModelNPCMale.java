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
        this.field_78089_u = n2;
        this.field_78090_t = n;
        this.init(f, 0.0f);
    }

    @Override
    public void func_78086_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        this.animationTick += f3;
        this.dancingTicks = (float)CustomNpcs.ticks / 3.978873f;
    }

    public void init(float f, float f2) {
        this.heldItemLeft = 0;
        this.heldItemRight = 0;
        this.isSneak = false;
        this.aimedBow = false;
        this.bipedCloak = new ModelRenderer(this, 0, 0);
        this.bipedCloak.field_78799_b = 32.0f;
        this.bipedCloak.func_78790_a(-5.0f, 0.0f, -1.0f, 10, 16, 1, f);
        this.bipedEars = new ModelRenderer(this, 24, 0);
        this.bipedEars.func_78790_a(-3.0f, -6.0f, -1.0f, 6, 6, 1, f);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, f);
        this.bipedHead.func_78793_a(0.0f, 0.0f + f2, 0.0f);
        this.bipedHeadwear = new ModelRenderer(this, 32, 0);
        this.bipedHeadwear.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, f + 0.5f);
        this.bipedHeadwear.func_78793_a(0.0f, 0.0f + f2, 0.0f);
        this.bipedBody = new ModelRenderer(this, 16, 16);
        this.bipedBody.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, f);
        this.bipedBody.func_78793_a(0.0f, 0.0f + f2, 0.0f);
        this.bipedRightArm = new ModelRenderer(this, 40, 16);
        this.bipedRightArm.func_78790_a(-3.0f, -2.0f, -2.0f, 4, 12, 4, f);
        this.bipedRightArm.func_78793_a(-5.0f, 2.0f + f2, 0.0f);
        this.bipedLeftArm = new ModelRenderer(this, 40, 16);
        this.bipedLeftArm.field_78809_i = true;
        this.bipedLeftArm.func_78790_a(-1.0f, -2.0f, -2.0f, 4, 12, 4, f);
        this.bipedLeftArm.func_78793_a(5.0f, 2.0f + f2, 0.0f);
        this.bipedRightLeg = new ModelRenderer(this, 0, 16);
        this.bipedRightLeg.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, f);
        this.bipedRightLeg.func_78793_a(-2.0f, 12.0f + f2, 0.0f);
        this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
        this.bipedLeftLeg.field_78809_i = true;
        this.bipedLeftLeg.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, f);
        this.bipedLeftLeg.func_78793_a(2.0f, 12.0f + f2, 0.0f);
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.setRotationAngles(f, f2, f3, f4, f5, f6);
        if (!this.isDancing) {
            this.bipedBody.func_78785_a(f6);
            this.bipedRightArm.func_78785_a(f6);
            this.bipedLeftArm.func_78785_a(f6);
            this.bipedRightLeg.func_78785_a(f6);
            this.bipedLeftLeg.func_78785_a(f6);
            this.bipedHead.func_78785_a(f6);
            this.bipedHeadwear.func_78785_a(f6);
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
            this.bipedHead.func_78785_a(f);
            this.bipedHeadwear.func_78785_a(f);
            GL11.glPopMatrix();
        } else {
            this.bipedHead.func_78785_a(f);
            this.bipedHeadwear.func_78785_a(f);
        }
    }

    public void renderLeftArm(Entity entity, float f) {
        if (this.isDancing) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)Math.sin(this.dancingTicks) * 0.025f, (float)Math.abs(Math.cos(this.dancingTicks)) * 0.125f - 0.02f, 0.0f);
            this.bipedLeftArm.func_78785_a(f);
            GL11.glPopMatrix();
        } else {
            this.bipedLeftArm.func_78785_a(f);
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
            this.bipedRightArm.func_78785_a(f);
            GL11.glPopMatrix();
        } else {
            this.bipedRightArm.func_78785_a(f);
        }
    }

    public void renderBody(Entity entity, float f) {
        if (this.isDancing) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)Math.sin(this.dancingTicks) * 0.015f, 0.0f, 0.0f);
            this.bipedBody.func_78785_a(f);
            GL11.glPopMatrix();
        } else {
            this.bipedBody.func_78785_a(f);
        }
    }

    public void renderLegs(Entity entity, float f) {
        this.bipedRightLeg.func_78785_a(f);
        this.bipedLeftLeg.func_78785_a(f);
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7;
        float f8;
        this.bipedHead.field_78796_g = f4 / 57.295776f;
        this.bipedHead.field_78795_f = f5 / 57.295776f;
        this.bipedHeadwear.field_78796_g = this.bipedHead.field_78796_g;
        this.bipedHeadwear.field_78795_f = this.bipedHead.field_78795_f;
        this.bipedRightArm.field_78795_f = sajh._b(f * 0.6662f + (float)Math.PI) * 2.0f * f2 * 0.5f;
        this.bipedLeftArm.field_78795_f = sajh._b(f * 0.6662f) * 2.0f * f2 * 0.5f;
        this.bipedRightArm.field_78808_h = 0.0f;
        this.bipedLeftArm.field_78808_h = 0.0f;
        this.bipedRightLeg.field_78795_f = sajh._b(f * 0.6662f) * 1.4f * f2;
        this.bipedLeftLeg.field_78795_f = sajh._b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.bipedRightLeg.field_78796_g = 0.0f;
        this.bipedLeftLeg.field_78796_g = 0.0f;
        if (this.field_78093_q) {
            this.bipedRightArm.field_78795_f += -0.62831855f;
            this.bipedLeftArm.field_78795_f += -0.62831855f;
            this.bipedRightLeg.field_78795_f = -1.2566371f;
            this.bipedLeftLeg.field_78795_f = -1.2566371f;
            this.bipedRightLeg.field_78796_g = 0.31415927f;
            this.bipedLeftLeg.field_78796_g = -0.31415927f;
        }
        if (this.heldItemLeft != 0) {
            this.bipedLeftArm.field_78795_f = this.bipedLeftArm.field_78795_f * 0.5f - 0.31415927f * (float)this.heldItemLeft;
        }
        if (this.heldItemRight != 0) {
            this.bipedRightArm.field_78795_f = this.bipedRightArm.field_78795_f * 0.5f - 0.31415927f * (float)this.heldItemRight;
        }
        this.bipedRightArm.field_78796_g = 0.0f;
        this.bipedLeftArm.field_78796_g = 0.0f;
        if (this.field_78095_p > -9990.0f) {
            f8 = this.field_78095_p;
            this.bipedBody.field_78796_g = sajh._a(sajh._c(f8) * (float)Math.PI * 2.0f) * 0.2f;
            this.bipedRightArm.field_78798_e = sajh._a(this.bipedBody.field_78796_g) * 5.0f;
            this.bipedRightArm.field_78800_c = -sajh._b(this.bipedBody.field_78796_g) * 5.0f;
            this.bipedLeftArm.field_78798_e = -sajh._a(this.bipedBody.field_78796_g) * 5.0f;
            this.bipedLeftArm.field_78800_c = sajh._b(this.bipedBody.field_78796_g) * 5.0f;
            this.bipedRightArm.field_78796_g += this.bipedBody.field_78796_g;
            this.bipedLeftArm.field_78796_g += this.bipedBody.field_78796_g;
            this.bipedLeftArm.field_78795_f += this.bipedBody.field_78796_g;
            f8 = 1.0f - this.field_78095_p;
            f8 *= f8;
            f8 *= f8;
            f8 = 1.0f - f8;
            f7 = sajh._a(f8 * (float)Math.PI);
            float f9 = sajh._a(this.field_78095_p * (float)Math.PI) * -(this.bipedHead.field_78795_f - 0.7f) * 0.75f;
            this.bipedRightArm.field_78795_f = (float)((double)this.bipedRightArm.field_78795_f - ((double)f7 * 1.2 + (double)f9));
            this.bipedRightArm.field_78796_g += this.bipedBody.field_78796_g * 2.0f;
            this.bipedRightArm.field_78808_h = sajh._a(this.field_78095_p * (float)Math.PI) * -0.4f;
        }
        if (this.isSneak) {
            this.bipedBody.field_78795_f = 0.5f;
            this.bipedRightLeg.field_78795_f -= 0.0f;
            this.bipedLeftLeg.field_78795_f -= 0.0f;
            this.bipedRightArm.field_78795_f += 0.4f;
            this.bipedLeftArm.field_78795_f += 0.4f;
            this.bipedRightLeg.field_78798_e = 4.0f;
            this.bipedLeftLeg.field_78798_e = 4.0f;
            this.bipedRightLeg.field_78797_d = 9.0f;
            this.bipedLeftLeg.field_78797_d = 9.0f;
            this.bipedHead.field_78797_d = 1.0f;
        } else {
            this.bipedBody.field_78795_f = 0.0f;
            this.bipedRightLeg.field_78798_e = 0.0f;
            this.bipedLeftLeg.field_78798_e = 0.0f;
            this.bipedRightLeg.field_78797_d = 12.0f;
            this.bipedLeftLeg.field_78797_d = 12.0f;
            this.bipedHead.field_78797_d = 0.0f;
        }
        this.bipedRightArm.field_78808_h += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
        this.bipedLeftArm.field_78808_h -= sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
        this.bipedRightArm.field_78795_f += sajh._a(f3 * 0.067f) * 0.05f;
        this.bipedLeftArm.field_78795_f -= sajh._a(f3 * 0.067f) * 0.05f;
        if (this.aimedBow) {
            f8 = 0.0f;
            f7 = 0.0f;
            this.bipedRightArm.field_78808_h = 0.0f;
            this.bipedLeftArm.field_78808_h = 0.0f;
            this.bipedRightArm.field_78796_g = -(0.1f - f8 * 0.6f) + this.bipedHead.field_78796_g;
            this.bipedLeftArm.field_78796_g = 0.1f - f8 * 0.6f + this.bipedHead.field_78796_g + 0.4f;
            this.bipedRightArm.field_78795_f = -1.5707964f + this.bipedHead.field_78795_f;
            this.bipedLeftArm.field_78795_f = -1.5707964f + this.bipedHead.field_78795_f;
            this.bipedRightArm.field_78795_f -= f8 * 1.2f - f7 * 0.4f;
            this.bipedLeftArm.field_78795_f -= f8 * 1.2f - f7 * 0.4f;
            this.bipedRightArm.field_78808_h += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
            this.bipedLeftArm.field_78808_h -= sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
            this.bipedRightArm.field_78795_f += sajh._a(f3 * 0.067f) * 0.05f;
            this.bipedLeftArm.field_78795_f -= sajh._a(f3 * 0.067f) * 0.05f;
        }
    }

    public void renderEars(float f) {
        this.bipedEars.field_78796_g = this.bipedHead.field_78796_g;
        this.bipedEars.field_78795_f = this.bipedHead.field_78795_f;
        this.bipedEars.field_78800_c = 0.0f;
        this.bipedEars.field_78797_d = 0.0f;
        this.bipedEars.func_78785_a(f);
    }

    public void setRotation(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.field_78795_f = f;
        modelRenderer.field_78796_g = f2;
        modelRenderer.field_78808_h = f3;
    }

    public void renderCloak(float f) {
        this.bipedCloak.func_78785_a(f);
    }
}

