/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class ModelHorse
extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer mouthTop;
    public ModelRenderer mouthBottom;
    public ModelRenderer horseLeftEar;
    public ModelRenderer horseRightEar;
    public ModelRenderer field_110703_f;
    public ModelRenderer field_110704_g;
    public ModelRenderer neck;
    public ModelRenderer field_110717_i;
    public ModelRenderer mane;
    public ModelRenderer body;
    public ModelRenderer tailBase;
    public ModelRenderer tailMiddle;
    public ModelRenderer tailTip;
    public ModelRenderer backLeftLeg;
    public ModelRenderer backLeftShin;
    public ModelRenderer backLeftHoof;
    public ModelRenderer backRightLeg;
    public ModelRenderer backRightShin;
    public ModelRenderer backRightHoof;
    public ModelRenderer frontRightLeg;
    public ModelRenderer frontLeftShin;
    public ModelRenderer frontLeftHoof;
    public ModelRenderer field_110684_D;
    public ModelRenderer frontRightShin;
    public ModelRenderer frontRightHoof;
    public ModelRenderer field_110687_G;
    public ModelRenderer field_110695_H;
    public ModelRenderer field_110696_I;
    public ModelRenderer field_110697_J;
    public ModelRenderer field_110698_K;
    public ModelRenderer field_110691_L;
    public ModelRenderer field_110692_M;
    public ModelRenderer field_110693_N;
    public ModelRenderer field_110694_O;
    public ModelRenderer field_110700_P;
    public ModelRenderer field_110699_Q;
    public ModelRenderer field_110702_R;
    public ModelRenderer field_110701_S;

    public ModelHorse() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.body = new ModelRenderer(this, 0, 34);
        this.body.addBox(-5.0f, -8.0f, -19.0f, 10, 10, 24);
        this.body.setRotationPoint(0.0f, 11.0f, 9.0f);
        this.tailBase = new ModelRenderer(this, 44, 0);
        this.tailBase.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.tailBase.setRotationPoint(0.0f, 3.0f, 14.0f);
        this.func_110682_a(this.tailBase, -1.134464f, 0.0f, 0.0f);
        this.tailMiddle = new ModelRenderer(this, 38, 7);
        this.tailMiddle.addBox(-1.5f, -2.0f, 3.0f, 3, 4, 7);
        this.tailMiddle.setRotationPoint(0.0f, 3.0f, 14.0f);
        this.func_110682_a(this.tailMiddle, -1.134464f, 0.0f, 0.0f);
        this.tailTip = new ModelRenderer(this, 24, 3);
        this.tailTip.addBox(-1.5f, -4.5f, 9.0f, 3, 4, 7);
        this.tailTip.setRotationPoint(0.0f, 3.0f, 14.0f);
        this.func_110682_a(this.tailTip, -1.40215f, 0.0f, 0.0f);
        this.backLeftLeg = new ModelRenderer(this, 78, 29);
        this.backLeftLeg.addBox(-2.5f, -2.0f, -2.5f, 4, 9, 5);
        this.backLeftLeg.setRotationPoint(4.0f, 9.0f, 11.0f);
        this.backLeftShin = new ModelRenderer(this, 78, 43);
        this.backLeftShin.addBox(-2.0f, 0.0f, -1.5f, 3, 5, 3);
        this.backLeftShin.setRotationPoint(4.0f, 16.0f, 11.0f);
        this.backLeftHoof = new ModelRenderer(this, 78, 51);
        this.backLeftHoof.addBox(-2.5f, 5.1f, -2.0f, 4, 3, 4);
        this.backLeftHoof.setRotationPoint(4.0f, 16.0f, 11.0f);
        this.backRightLeg = new ModelRenderer(this, 96, 29);
        this.backRightLeg.addBox(-1.5f, -2.0f, -2.5f, 4, 9, 5);
        this.backRightLeg.setRotationPoint(-4.0f, 9.0f, 11.0f);
        this.backRightShin = new ModelRenderer(this, 96, 43);
        this.backRightShin.addBox(-1.0f, 0.0f, -1.5f, 3, 5, 3);
        this.backRightShin.setRotationPoint(-4.0f, 16.0f, 11.0f);
        this.backRightHoof = new ModelRenderer(this, 96, 51);
        this.backRightHoof.addBox(-1.5f, 5.1f, -2.0f, 4, 3, 4);
        this.backRightHoof.setRotationPoint(-4.0f, 16.0f, 11.0f);
        this.frontRightLeg = new ModelRenderer(this, 44, 29);
        this.frontRightLeg.addBox(-1.9f, -1.0f, -2.1f, 3, 8, 4);
        this.frontRightLeg.setRotationPoint(4.0f, 9.0f, -8.0f);
        this.frontLeftShin = new ModelRenderer(this, 44, 41);
        this.frontLeftShin.addBox(-1.9f, 0.0f, -1.6f, 3, 5, 3);
        this.frontLeftShin.setRotationPoint(4.0f, 16.0f, -8.0f);
        this.frontLeftHoof = new ModelRenderer(this, 44, 51);
        this.frontLeftHoof.addBox(-2.4f, 5.1f, -2.1f, 4, 3, 4);
        this.frontLeftHoof.setRotationPoint(4.0f, 16.0f, -8.0f);
        this.field_110684_D = new ModelRenderer(this, 60, 29);
        this.field_110684_D.addBox(-1.1f, -1.0f, -2.1f, 3, 8, 4);
        this.field_110684_D.setRotationPoint(-4.0f, 9.0f, -8.0f);
        this.frontRightShin = new ModelRenderer(this, 60, 41);
        this.frontRightShin.addBox(-1.1f, 0.0f, -1.6f, 3, 5, 3);
        this.frontRightShin.setRotationPoint(-4.0f, 16.0f, -8.0f);
        this.frontRightHoof = new ModelRenderer(this, 60, 51);
        this.frontRightHoof.addBox(-1.6f, 5.1f, -2.1f, 4, 3, 4);
        this.frontRightHoof.setRotationPoint(-4.0f, 16.0f, -8.0f);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-2.5f, -10.0f, -1.5f, 5, 5, 7);
        this.head.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.head, 0.5235988f, 0.0f, 0.0f);
        this.mouthTop = new ModelRenderer(this, 24, 18);
        this.mouthTop.addBox(-2.0f, -10.0f, -7.0f, 4, 3, 6);
        this.mouthTop.setRotationPoint(0.0f, 3.95f, -10.0f);
        this.func_110682_a(this.mouthTop, 0.5235988f, 0.0f, 0.0f);
        this.mouthBottom = new ModelRenderer(this, 24, 27);
        this.mouthBottom.addBox(-2.0f, -7.0f, -6.5f, 4, 2, 5);
        this.mouthBottom.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.mouthBottom, 0.5235988f, 0.0f, 0.0f);
        this.head.addChild(this.mouthTop);
        this.head.addChild(this.mouthBottom);
        this.horseLeftEar = new ModelRenderer(this, 0, 0);
        this.horseLeftEar.addBox(0.45f, -12.0f, 4.0f, 2, 3, 1);
        this.horseLeftEar.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.horseLeftEar, 0.5235988f, 0.0f, 0.0f);
        this.horseRightEar = new ModelRenderer(this, 0, 0);
        this.horseRightEar.addBox(-2.45f, -12.0f, 4.0f, 2, 3, 1);
        this.horseRightEar.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.horseRightEar, 0.5235988f, 0.0f, 0.0f);
        this.field_110703_f = new ModelRenderer(this, 0, 12);
        this.field_110703_f.addBox(-2.0f, -16.0f, 4.0f, 2, 7, 1);
        this.field_110703_f.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.field_110703_f, 0.5235988f, 0.0f, 0.2617994f);
        this.field_110704_g = new ModelRenderer(this, 0, 12);
        this.field_110704_g.addBox(0.0f, -16.0f, 4.0f, 2, 7, 1);
        this.field_110704_g.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.field_110704_g, 0.5235988f, 0.0f, -0.2617994f);
        this.neck = new ModelRenderer(this, 0, 12);
        this.neck.addBox(-2.05f, -9.8f, -2.0f, 4, 14, 8);
        this.neck.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.neck, 0.5235988f, 0.0f, 0.0f);
        this.field_110687_G = new ModelRenderer(this, 0, 34);
        this.field_110687_G.addBox(-3.0f, 0.0f, 0.0f, 8, 8, 3);
        this.field_110687_G.setRotationPoint(-7.5f, 3.0f, 10.0f);
        this.func_110682_a(this.field_110687_G, 0.0f, 1.570796f, 0.0f);
        this.field_110695_H = new ModelRenderer(this, 0, 47);
        this.field_110695_H.addBox(-3.0f, 0.0f, 0.0f, 8, 8, 3);
        this.field_110695_H.setRotationPoint(4.5f, 3.0f, 10.0f);
        this.func_110682_a(this.field_110695_H, 0.0f, 1.570796f, 0.0f);
        this.field_110696_I = new ModelRenderer(this, 80, 0);
        this.field_110696_I.addBox(-5.0f, 0.0f, -3.0f, 10, 1, 8);
        this.field_110696_I.setRotationPoint(0.0f, 2.0f, 2.0f);
        this.field_110697_J = new ModelRenderer(this, 106, 9);
        this.field_110697_J.addBox(-1.5f, -1.0f, -3.0f, 3, 1, 2);
        this.field_110697_J.setRotationPoint(0.0f, 2.0f, 2.0f);
        this.field_110698_K = new ModelRenderer(this, 80, 9);
        this.field_110698_K.addBox(-4.0f, -1.0f, 3.0f, 8, 1, 2);
        this.field_110698_K.setRotationPoint(0.0f, 2.0f, 2.0f);
        this.field_110692_M = new ModelRenderer(this, 74, 0);
        this.field_110692_M.addBox(-0.5f, 6.0f, -1.0f, 1, 2, 2);
        this.field_110692_M.setRotationPoint(5.0f, 3.0f, 2.0f);
        this.field_110691_L = new ModelRenderer(this, 70, 0);
        this.field_110691_L.addBox(-0.5f, 0.0f, -0.5f, 1, 6, 1);
        this.field_110691_L.setRotationPoint(5.0f, 3.0f, 2.0f);
        this.field_110694_O = new ModelRenderer(this, 74, 4);
        this.field_110694_O.addBox(-0.5f, 6.0f, -1.0f, 1, 2, 2);
        this.field_110694_O.setRotationPoint(-5.0f, 3.0f, 2.0f);
        this.field_110693_N = new ModelRenderer(this, 80, 0);
        this.field_110693_N.addBox(-0.5f, 0.0f, -0.5f, 1, 6, 1);
        this.field_110693_N.setRotationPoint(-5.0f, 3.0f, 2.0f);
        this.field_110700_P = new ModelRenderer(this, 74, 13);
        this.field_110700_P.addBox(1.5f, -8.0f, -4.0f, 1, 2, 2);
        this.field_110700_P.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.field_110700_P, 0.5235988f, 0.0f, 0.0f);
        this.field_110699_Q = new ModelRenderer(this, 74, 13);
        this.field_110699_Q.addBox(-2.5f, -8.0f, -4.0f, 1, 2, 2);
        this.field_110699_Q.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.field_110699_Q, 0.5235988f, 0.0f, 0.0f);
        this.field_110702_R = new ModelRenderer(this, 44, 10);
        this.field_110702_R.addBox(2.6f, -6.0f, -6.0f, 0, 3, 16);
        this.field_110702_R.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.field_110701_S = new ModelRenderer(this, 44, 5);
        this.field_110701_S.addBox(-2.6f, -6.0f, -6.0f, 0, 3, 16);
        this.field_110701_S.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.mane = new ModelRenderer(this, 58, 0);
        this.mane.addBox(-1.0f, -11.5f, 5.0f, 2, 16, 4);
        this.mane.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.mane, 0.5235988f, 0.0f, 0.0f);
        this.field_110717_i = new ModelRenderer(this, 80, 12);
        this.field_110717_i.addBox(-2.5f, -10.1f, -7.0f, 5, 5, 12, 0.2f);
        this.field_110717_i.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.func_110682_a(this.field_110717_i, 0.5235988f, 0.0f, 0.0f);
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        boolean bl;
        EntityHorse entityHorse = (EntityHorse)entity;
        int n = entityHorse.getHorseType();
        float f7 = entityHorse.getGrassEatingAmount(0.0f);
        boolean bl2 = entityHorse.isAdultHorse();
        boolean bl3 = bl2 && entityHorse.isHorseSaddled();
        boolean bl4 = bl2 && entityHorse.isChested();
        boolean bl5 = n == 1 || n == 2;
        float f8 = entityHorse.getHorseSize();
        boolean bl6 = bl = entityHorse.riddenByEntity != null;
        if (bl3) {
            this.field_110717_i.render(f6);
            this.field_110696_I.render(f6);
            this.field_110697_J.render(f6);
            this.field_110698_K.render(f6);
            this.field_110691_L.render(f6);
            this.field_110692_M.render(f6);
            this.field_110693_N.render(f6);
            this.field_110694_O.render(f6);
            this.field_110700_P.render(f6);
            this.field_110699_Q.render(f6);
            if (bl) {
                this.field_110702_R.render(f6);
                this.field_110701_S.render(f6);
            }
        }
        if (!bl2) {
            GL11.glPushMatrix();
            GL11.glScalef(f8, 0.5f + f8 * 0.5f, f8);
            GL11.glTranslatef(0.0f, 0.95f * (1.0f - f8), 0.0f);
        }
        this.backLeftLeg.render(f6);
        this.backLeftShin.render(f6);
        this.backLeftHoof.render(f6);
        this.backRightLeg.render(f6);
        this.backRightShin.render(f6);
        this.backRightHoof.render(f6);
        this.frontRightLeg.render(f6);
        this.frontLeftShin.render(f6);
        this.frontLeftHoof.render(f6);
        this.field_110684_D.render(f6);
        this.frontRightShin.render(f6);
        this.frontRightHoof.render(f6);
        if (!bl2) {
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(f8, f8, f8);
            GL11.glTranslatef(0.0f, 1.35f * (1.0f - f8), 0.0f);
        }
        this.body.render(f6);
        this.tailBase.render(f6);
        this.tailMiddle.render(f6);
        this.tailTip.render(f6);
        this.neck.render(f6);
        this.mane.render(f6);
        if (!bl2) {
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            float f9 = 0.5f + f8 * f8 * 0.5f;
            GL11.glScalef(f9, f9, f9);
            if (f7 <= 0.0f) {
                GL11.glTranslatef(0.0f, 1.35f * (1.0f - f8), 0.0f);
            } else {
                GL11.glTranslatef(0.0f, 0.9f * (1.0f - f8) * f7 + 1.35f * (1.0f - f8) * (1.0f - f7), 0.15f * (1.0f - f8) * f7);
            }
        }
        if (bl5) {
            this.field_110703_f.render(f6);
            this.field_110704_g.render(f6);
        } else {
            this.horseLeftEar.render(f6);
            this.horseRightEar.render(f6);
        }
        this.head.render(f6);
        if (!bl2) {
            GL11.glPopMatrix();
        }
        if (bl4) {
            this.field_110687_G.render(f6);
            this.field_110695_H.render(f6);
        }
    }

    public void func_110682_a(ModelRenderer modelRenderer, float f, float f2, float f3) {
        modelRenderer.rotateAngleX = f;
        modelRenderer.rotateAngleY = f2;
        modelRenderer.rotateAngleZ = f3;
    }

    public float func_110683_a(float f, float f2, float f3) {
        float f4;
        for (f4 = f2 - f; f4 < -180.0f; f4 += 360.0f) {
        }
        while (f4 >= 180.0f) {
            f4 -= 360.0f;
        }
        return f + f3 * f4;
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        super.setLivingAnimations(entityLivingBase, f, f2, f3);
        float f4 = this.func_110683_a(entityLivingBase.prevRenderYawOffset, entityLivingBase.renderYawOffset, f3);
        float f5 = this.func_110683_a(entityLivingBase.prevRotationYawHead, entityLivingBase.rotationYawHead, f3);
        float f6 = entityLivingBase.prevRotationPitch + (entityLivingBase.rotationPitch - entityLivingBase.prevRotationPitch) * f3;
        float f7 = f5 - f4;
        float f8 = f6 / 57.29578f;
        if (f7 > 20.0f) {
            f7 = 20.0f;
        }
        if (f7 < -20.0f) {
            f7 = -20.0f;
        }
        if (f2 > 0.2f) {
            f8 += sajh._b(f * 0.4f) * 0.15f * f2;
        }
        EntityHorse entityHorse = (EntityHorse)entityLivingBase;
        float f9 = entityHorse.getGrassEatingAmount(f3);
        float f10 = entityHorse.getRearingAmount(f3);
        float f11 = 1.0f - f10;
        float f12 = entityHorse.func_110201_q(f3);
        boolean bl = entityHorse.field_110278_bp != 0;
        boolean bl2 = entityHorse.isHorseSaddled();
        boolean bl3 = entityHorse.riddenByEntity != null;
        float f13 = (float)entityLivingBase.ticksExisted + f3;
        float f14 = sajh._b(f * 0.6662f + 3.141593f);
        float f15 = f14 * 0.8f * f2;
        this.head.rotationPointY = 4.0f;
        this.head.rotationPointZ = -10.0f;
        this.tailBase.rotationPointY = 3.0f;
        this.tailMiddle.rotationPointZ = 14.0f;
        this.field_110695_H.rotationPointY = 3.0f;
        this.field_110695_H.rotationPointZ = 10.0f;
        this.body.rotateAngleX = 0.0f;
        this.head.rotateAngleX = 0.5235988f + f8;
        this.head.rotateAngleY = f7 / 57.29578f;
        this.head.rotateAngleX = f10 * (0.2617994f + f8) + f9 * 2.18166f + (1.0f - Math.max(f10, f9)) * this.head.rotateAngleX;
        this.head.rotateAngleY = f10 * (f7 / 57.29578f) + (1.0f - Math.max(f10, f9)) * this.head.rotateAngleY;
        this.head.rotationPointY = f10 * -6.0f + f9 * 11.0f + (1.0f - Math.max(f10, f9)) * this.head.rotationPointY;
        this.head.rotationPointZ = f10 * -1.0f + f9 * -10.0f + (1.0f - Math.max(f10, f9)) * this.head.rotationPointZ;
        this.tailBase.rotationPointY = f10 * 9.0f + f11 * this.tailBase.rotationPointY;
        this.tailMiddle.rotationPointZ = f10 * 18.0f + f11 * this.tailMiddle.rotationPointZ;
        this.field_110695_H.rotationPointY = f10 * 5.5f + f11 * this.field_110695_H.rotationPointY;
        this.field_110695_H.rotationPointZ = f10 * 15.0f + f11 * this.field_110695_H.rotationPointZ;
        this.body.rotateAngleX = f10 * -0.7853981f + f11 * this.body.rotateAngleX;
        this.horseLeftEar.rotationPointY = this.head.rotationPointY;
        this.horseRightEar.rotationPointY = this.head.rotationPointY;
        this.field_110703_f.rotationPointY = this.head.rotationPointY;
        this.field_110704_g.rotationPointY = this.head.rotationPointY;
        this.neck.rotationPointY = this.head.rotationPointY;
        this.mouthTop.rotationPointY = 0.02f;
        this.mouthBottom.rotationPointY = 0.0f;
        this.mane.rotationPointY = this.head.rotationPointY;
        this.horseLeftEar.rotationPointZ = this.head.rotationPointZ;
        this.horseRightEar.rotationPointZ = this.head.rotationPointZ;
        this.field_110703_f.rotationPointZ = this.head.rotationPointZ;
        this.field_110704_g.rotationPointZ = this.head.rotationPointZ;
        this.neck.rotationPointZ = this.head.rotationPointZ;
        this.mouthTop.rotationPointZ = 0.02f - f12 * 1.0f;
        this.mouthBottom.rotationPointZ = 0.0f + f12 * 1.0f;
        this.mane.rotationPointZ = this.head.rotationPointZ;
        this.horseLeftEar.rotateAngleX = this.head.rotateAngleX;
        this.horseRightEar.rotateAngleX = this.head.rotateAngleX;
        this.field_110703_f.rotateAngleX = this.head.rotateAngleX;
        this.field_110704_g.rotateAngleX = this.head.rotateAngleX;
        this.neck.rotateAngleX = this.head.rotateAngleX;
        this.mouthTop.rotateAngleX = 0.0f - 0.09424778f * f12;
        this.mouthBottom.rotateAngleX = 0.0f + 0.15707964f * f12;
        this.mane.rotateAngleX = this.head.rotateAngleX;
        this.horseLeftEar.rotateAngleY = this.head.rotateAngleY;
        this.horseRightEar.rotateAngleY = this.head.rotateAngleY;
        this.field_110703_f.rotateAngleY = this.head.rotateAngleY;
        this.field_110704_g.rotateAngleY = this.head.rotateAngleY;
        this.neck.rotateAngleY = this.head.rotateAngleY;
        this.mouthTop.rotateAngleY = 0.0f;
        this.mouthBottom.rotateAngleY = 0.0f;
        this.mane.rotateAngleY = this.head.rotateAngleY;
        this.field_110687_G.rotateAngleX = f15 / 5.0f;
        this.field_110695_H.rotateAngleX = -f15 / 5.0f;
        float f16 = 1.5707964f;
        float f17 = 4.712389f;
        float f18 = -1.0471976f;
        float f19 = 0.2617994f * f10;
        float f20 = sajh._b(f13 * 0.6f + 3.141593f);
        this.frontRightLeg.rotationPointY = -2.0f * f10 + 9.0f * f11;
        this.frontRightLeg.rotationPointZ = -2.0f * f10 + -8.0f * f11;
        this.field_110684_D.rotationPointY = this.frontRightLeg.rotationPointY;
        this.field_110684_D.rotationPointZ = this.frontRightLeg.rotationPointZ;
        this.backLeftShin.rotationPointY = this.backLeftLeg.rotationPointY + sajh._a(1.5707964f + f19 + f11 * (-f14 * 0.5f * f2)) * 7.0f;
        this.backLeftShin.rotationPointZ = this.backLeftLeg.rotationPointZ + sajh._b(4.712389f + f19 + f11 * (-f14 * 0.5f * f2)) * 7.0f;
        this.backRightShin.rotationPointY = this.backRightLeg.rotationPointY + sajh._a(1.5707964f + f19 + f11 * (f14 * 0.5f * f2)) * 7.0f;
        this.backRightShin.rotationPointZ = this.backRightLeg.rotationPointZ + sajh._b(4.712389f + f19 + f11 * (f14 * 0.5f * f2)) * 7.0f;
        float f21 = (-1.0471976f + f20) * f10 + f15 * f11;
        float f22 = (-1.0471976f + -f20) * f10 + -f15 * f11;
        this.frontLeftShin.rotationPointY = this.frontRightLeg.rotationPointY + sajh._a(1.5707964f + f21) * 7.0f;
        this.frontLeftShin.rotationPointZ = this.frontRightLeg.rotationPointZ + sajh._b(4.712389f + f21) * 7.0f;
        this.frontRightShin.rotationPointY = this.field_110684_D.rotationPointY + sajh._a(1.5707964f + f22) * 7.0f;
        this.frontRightShin.rotationPointZ = this.field_110684_D.rotationPointZ + sajh._b(4.712389f + f22) * 7.0f;
        this.backLeftLeg.rotateAngleX = f19 + -f14 * 0.5f * f2 * f11;
        this.backLeftHoof.rotateAngleX = this.backLeftShin.rotateAngleX = -0.08726646f * f10 + (-f14 * 0.5f * f2 - Math.max(0.0f, f14 * 0.5f * f2)) * f11;
        this.backRightLeg.rotateAngleX = f19 + f14 * 0.5f * f2 * f11;
        this.backRightHoof.rotateAngleX = this.backRightShin.rotateAngleX = -0.08726646f * f10 + (f14 * 0.5f * f2 - Math.max(0.0f, -f14 * 0.5f * f2)) * f11;
        this.frontRightLeg.rotateAngleX = f21;
        this.frontLeftHoof.rotateAngleX = this.frontLeftShin.rotateAngleX = (this.frontRightLeg.rotateAngleX + (float)Math.PI * Math.max(0.0f, 0.2f + f20 * 0.2f)) * f10 + (f15 + Math.max(0.0f, f14 * 0.5f * f2)) * f11;
        this.field_110684_D.rotateAngleX = f22;
        this.frontRightHoof.rotateAngleX = this.frontRightShin.rotateAngleX = (this.field_110684_D.rotateAngleX + (float)Math.PI * Math.max(0.0f, 0.2f - f20 * 0.2f)) * f10 + (-f15 + Math.max(0.0f, -f14 * 0.5f * f2)) * f11;
        this.backLeftHoof.rotationPointY = this.backLeftShin.rotationPointY;
        this.backLeftHoof.rotationPointZ = this.backLeftShin.rotationPointZ;
        this.backRightHoof.rotationPointY = this.backRightShin.rotationPointY;
        this.backRightHoof.rotationPointZ = this.backRightShin.rotationPointZ;
        this.frontLeftHoof.rotationPointY = this.frontLeftShin.rotationPointY;
        this.frontLeftHoof.rotationPointZ = this.frontLeftShin.rotationPointZ;
        this.frontRightHoof.rotationPointY = this.frontRightShin.rotationPointY;
        this.frontRightHoof.rotationPointZ = this.frontRightShin.rotationPointZ;
        if (bl2) {
            this.field_110696_I.rotationPointY = f10 * 0.5f + f11 * 2.0f;
            this.field_110696_I.rotationPointZ = f10 * 11.0f + f11 * 2.0f;
            this.field_110697_J.rotationPointY = this.field_110696_I.rotationPointY;
            this.field_110698_K.rotationPointY = this.field_110696_I.rotationPointY;
            this.field_110691_L.rotationPointY = this.field_110696_I.rotationPointY;
            this.field_110693_N.rotationPointY = this.field_110696_I.rotationPointY;
            this.field_110692_M.rotationPointY = this.field_110696_I.rotationPointY;
            this.field_110694_O.rotationPointY = this.field_110696_I.rotationPointY;
            this.field_110687_G.rotationPointY = this.field_110695_H.rotationPointY;
            this.field_110697_J.rotationPointZ = this.field_110696_I.rotationPointZ;
            this.field_110698_K.rotationPointZ = this.field_110696_I.rotationPointZ;
            this.field_110691_L.rotationPointZ = this.field_110696_I.rotationPointZ;
            this.field_110693_N.rotationPointZ = this.field_110696_I.rotationPointZ;
            this.field_110692_M.rotationPointZ = this.field_110696_I.rotationPointZ;
            this.field_110694_O.rotationPointZ = this.field_110696_I.rotationPointZ;
            this.field_110687_G.rotationPointZ = this.field_110695_H.rotationPointZ;
            this.field_110696_I.rotateAngleX = this.body.rotateAngleX;
            this.field_110697_J.rotateAngleX = this.body.rotateAngleX;
            this.field_110698_K.rotateAngleX = this.body.rotateAngleX;
            this.field_110702_R.rotationPointY = this.head.rotationPointY;
            this.field_110701_S.rotationPointY = this.head.rotationPointY;
            this.field_110717_i.rotationPointY = this.head.rotationPointY;
            this.field_110700_P.rotationPointY = this.head.rotationPointY;
            this.field_110699_Q.rotationPointY = this.head.rotationPointY;
            this.field_110702_R.rotationPointZ = this.head.rotationPointZ;
            this.field_110701_S.rotationPointZ = this.head.rotationPointZ;
            this.field_110717_i.rotationPointZ = this.head.rotationPointZ;
            this.field_110700_P.rotationPointZ = this.head.rotationPointZ;
            this.field_110699_Q.rotationPointZ = this.head.rotationPointZ;
            this.field_110702_R.rotateAngleX = f8;
            this.field_110701_S.rotateAngleX = f8;
            this.field_110717_i.rotateAngleX = this.head.rotateAngleX;
            this.field_110700_P.rotateAngleX = this.head.rotateAngleX;
            this.field_110699_Q.rotateAngleX = this.head.rotateAngleX;
            this.field_110717_i.rotateAngleY = this.head.rotateAngleY;
            this.field_110700_P.rotateAngleY = this.head.rotateAngleY;
            this.field_110702_R.rotateAngleY = this.head.rotateAngleY;
            this.field_110699_Q.rotateAngleY = this.head.rotateAngleY;
            this.field_110701_S.rotateAngleY = this.head.rotateAngleY;
            if (bl3) {
                this.field_110691_L.rotateAngleX = -1.0471976f;
                this.field_110692_M.rotateAngleX = -1.0471976f;
                this.field_110693_N.rotateAngleX = -1.0471976f;
                this.field_110694_O.rotateAngleX = -1.0471976f;
                this.field_110691_L.rotateAngleZ = 0.0f;
                this.field_110692_M.rotateAngleZ = 0.0f;
                this.field_110693_N.rotateAngleZ = 0.0f;
                this.field_110694_O.rotateAngleZ = 0.0f;
            } else {
                this.field_110691_L.rotateAngleX = f15 / 3.0f;
                this.field_110692_M.rotateAngleX = f15 / 3.0f;
                this.field_110693_N.rotateAngleX = f15 / 3.0f;
                this.field_110694_O.rotateAngleX = f15 / 3.0f;
                this.field_110691_L.rotateAngleZ = f15 / 5.0f;
                this.field_110692_M.rotateAngleZ = f15 / 5.0f;
                this.field_110693_N.rotateAngleZ = -f15 / 5.0f;
                this.field_110694_O.rotateAngleZ = -f15 / 5.0f;
            }
        }
        if ((f16 = -1.3089f + f2 * 1.5f) > 0.0f) {
            f16 = 0.0f;
        }
        if (bl) {
            this.tailBase.rotateAngleY = sajh._b(f13 * 0.7f);
            f16 = 0.0f;
        } else {
            this.tailBase.rotateAngleY = 0.0f;
        }
        this.tailMiddle.rotateAngleY = this.tailBase.rotateAngleY;
        this.tailTip.rotateAngleY = this.tailBase.rotateAngleY;
        this.tailMiddle.rotationPointY = this.tailBase.rotationPointY;
        this.tailTip.rotationPointY = this.tailBase.rotationPointY;
        this.tailMiddle.rotationPointZ = this.tailBase.rotationPointZ;
        this.tailTip.rotationPointZ = this.tailBase.rotationPointZ;
        this.tailBase.rotateAngleX = f16;
        this.tailMiddle.rotateAngleX = f16;
        this.tailTip.rotateAngleX = -0.2618f + f16;
    }
}

