/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.util.sajh;
import net.smart.moving.render.IModelPlayer;
import net.smart.moving.render.SmartRenderContext;
import net.smart.render.ModelRotationRenderer;
import net.smart.render.SmartRenderModel;

public class SmartMovingModel
extends SmartRenderContext {
    public IModelPlayer imp;
    public ModelBiped mp;
    public SmartRenderModel md;
    public boolean isStandard;
    public boolean isClimb;
    public boolean isClimbJump;
    public int feetClimbType;
    public int handsClimbType;
    public boolean isHandsVineClimbing;
    public boolean isFeetVineClimbing;
    public boolean isCeilingClimb;
    public boolean isSwim;
    public boolean isDive;
    public boolean isCrawl;
    public boolean isCrawlClimb;
    public boolean isJump;
    public boolean isHeadJump;
    public boolean isFlying;
    public boolean isSlide;
    public boolean isLevitate;
    public boolean isFalling;
    public boolean isGenericSneaking;
    public boolean isAngleJumping;
    public int angleJumpType;
    public boolean isRopeSliding;
    public float currentHorizontalSpeedFlattened;
    public float smallOverGroundHeight;
    public int overGroundBlockId;
    public int scaleArmType;
    public int scaleLegType;

    public SmartMovingModel(float f, net.smart.render.IModelPlayer iModelPlayer, IModelPlayer iModelPlayer2) {
        this.imp = iModelPlayer2;
        this.md = iModelPlayer.getRenderModel();
        this.mp = this.md.mp;
    }

    private void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = 0.6662f;
        this.isStandard = false;
        float f8 = this.md.currentCameraAngle;
        float f9 = this.md.currentHorizontalAngle;
        float f10 = this.md.currentVerticalAngle;
        float f11 = this.md.forwardRotation;
        float f12 = this.md.currentVerticalSpeed;
        float f13 = this.md.totalVerticalDistance;
        float f14 = this.md.totalDistance;
        double d = this.md.horizontalDistance;
        float f15 = this.md.currentSpeed;
        if (!Float.isNaN(this.currentHorizontalSpeedFlattened)) {
            f2 = this.currentHorizontalSpeedFlattened;
        }
        ModelRotationRenderer modelRotationRenderer = this.md.bipedOuter;
        ModelRotationRenderer modelRotationRenderer2 = this.md.bipedTorso;
        ModelRotationRenderer modelRotationRenderer3 = this.md.bipedBody;
        ModelRotationRenderer modelRotationRenderer4 = this.md.bipedBreast;
        ModelRotationRenderer modelRotationRenderer5 = this.md.bipedHead;
        ModelRotationRenderer modelRotationRenderer6 = this.md.bipedRightShoulder;
        ModelRotationRenderer modelRotationRenderer7 = this.md.bipedRightArm;
        ModelRotationRenderer modelRotationRenderer8 = this.md.bipedLeftShoulder;
        ModelRotationRenderer modelRotationRenderer9 = this.md.bipedLeftArm;
        ModelRotationRenderer modelRotationRenderer10 = this.md.bipedPelvic;
        ModelRotationRenderer modelRotationRenderer11 = this.md.bipedRightLeg;
        ModelRotationRenderer modelRotationRenderer12 = this.md.bipedLeftLeg;
        if (this.isRopeSliding) {
            float f16 = f3 * 0.15f;
            modelRotationRenderer5.field_78808_h = SmartMovingModel.Between(-0.3926991f, 0.3926991f, SmartMovingModel.Normalize(f8 - f9));
            modelRotationRenderer5.field_78795_f = 0.7853982f;
            modelRotationRenderer5.field_78797_d = 2.0f;
            modelRotationRenderer.fadeRotateAngleY = false;
            modelRotationRenderer.field_78796_g = f9;
            modelRotationRenderer2.field_78795_f = 0.3926991f + 0.09817477f * sajh._b(f16);
            modelRotationRenderer9.field_78795_f = modelRotationRenderer7.field_78795_f = (float)Math.PI - modelRotationRenderer2.field_78795_f;
            modelRotationRenderer7.field_78808_h = 0.5890486f;
            modelRotationRenderer9.field_78808_h = -0.5890486f;
            modelRotationRenderer9.field_78797_d = -2.0f;
            modelRotationRenderer7.field_78797_d = -2.0f;
            modelRotationRenderer10.field_78795_f = modelRotationRenderer2.field_78795_f;
            modelRotationRenderer12.field_78808_h = -0.19634955f;
            modelRotationRenderer11.field_78808_h = 0.19634955f;
            modelRotationRenderer12.field_78795_f = 0.09817477f * sajh._b(f16 + 1.5707964f);
            modelRotationRenderer11.field_78795_f = 0.09817477f * sajh._b(f16 - 1.5707964f);
        } else if (!this.isClimb && !this.isCrawlClimb) {
            if (this.isClimbJump) {
                modelRotationRenderer7.field_78795_f = 3.5342917f;
                modelRotationRenderer9.field_78795_f = 3.5342917f;
                modelRotationRenderer7.field_78808_h = -0.19634955f;
                modelRotationRenderer9.field_78808_h = 0.19634955f;
            } else if (this.isCeilingClimb) {
                float f17 = f * 0.7f;
                float f18 = SmartMovingModel.Factor(f2, 0.0f, 0.12951545f);
                float f19 = SmartMovingModel.Factor(f2, 0.12951545f, 0.0f);
                float f20 = d < (double)0.015f ? f8 : f9;
                modelRotationRenderer9.field_78795_f = (sajh._b(f17) * 0.52f + (float)Math.PI) * f18 + (float)Math.PI * f19;
                modelRotationRenderer7.field_78795_f = (sajh._b(f17 + (float)Math.PI) * 0.52f - (float)Math.PI) * f18 - (float)Math.PI * f19;
                modelRotationRenderer12.field_78795_f = -sajh._b(f17) * 0.12f * f18;
                modelRotationRenderer11.field_78795_f = -sajh._b(f17 + (float)Math.PI) * 0.32f * f18;
                float f21 = sajh._b(f17) * 0.44f * f18;
                modelRotationRenderer.field_78796_g = f21 + f20;
                modelRotationRenderer7.field_78796_g = modelRotationRenderer9.field_78796_g = -f21;
                modelRotationRenderer11.field_78796_g = modelRotationRenderer12.field_78796_g = -f21;
                modelRotationRenderer5.field_78796_g = -f21;
            } else if (this.isSwim) {
                float f22;
                float f23 = SmartMovingModel.Factor(f2, 0.15679921f, 0.52264464f);
                float f24 = Math.min(SmartMovingModel.Factor(f2, 0.0f, 0.15679921f), SmartMovingModel.Factor(f2, 0.52264464f, 0.15679921f));
                float f25 = SmartMovingModel.Factor(f2, 0.15679921f, 0.0f);
                float f26 = f25 + f24;
                float f27 = d < (this.isGenericSneaking ? 0.005 : (double)0.015f) ? f8 : f9;
                modelRotationRenderer5.rotationOrder = 2;
                modelRotationRenderer5.field_78796_g = sajh._b(f / 2.0f - 1.5707964f) * f23;
                modelRotationRenderer5.field_78795_f = -0.7853982f * f26;
                modelRotationRenderer5.field_78798_e = -2.0f;
                modelRotationRenderer.fadeRotateAngleX = true;
                modelRotationRenderer.field_78795_f = 1.5707964f - 0.3926991f * f26;
                modelRotationRenderer.field_78796_g = f27;
                modelRotationRenderer4.field_78796_g = modelRotationRenderer3.field_78796_g = sajh._b(f / 2.0f - 1.5707964f) * f23;
                modelRotationRenderer7.rotationOrder = 3;
                modelRotationRenderer9.rotationOrder = 3;
                modelRotationRenderer7.field_78808_h = 2.3561945f + sajh._b(f3 * 0.1f) * f26 * 0.8f;
                modelRotationRenderer9.field_78808_h = -2.3561945f - sajh._b(f3 * 0.1f) * f26 * 0.8f;
                modelRotationRenderer7.field_78795_f = (f * 0.5f % ((float)Math.PI * 2) - (float)Math.PI) * f23 + 0.3926991f * f26;
                modelRotationRenderer9.field_78795_f = ((f * 0.5f + (float)Math.PI) % ((float)Math.PI * 2) - (float)Math.PI) * f23 + 0.3926991f * f26;
                modelRotationRenderer11.field_78795_f = sajh._b(f) * 0.52264464f * f23;
                modelRotationRenderer12.field_78795_f = sajh._b(f + (float)Math.PI) * 0.52264464f * f23;
                modelRotationRenderer11.field_78808_h = f22 = 0.3926991f * f26 + sajh._b(f3 * 0.1f) * 0.4f * (f25 - f24);
                modelRotationRenderer12.field_78808_h = -f22;
                if (this.scaleLegType != 1) {
                    this.setLegScales(1.0f + (sajh._b(f3 * 0.1f + 1.5707964f) - 1.0f) * 0.15f * f24, 1.0f + (sajh._b(f3 * 0.1f + 1.5707964f) - 1.0f) * 0.15f * f24);
                }
                if (this.scaleArmType != 1) {
                    this.setArmScales(1.0f + (sajh._b(f3 * 0.1f - 1.5707964f) - 1.0f) * 0.15f * f24, 1.0f + (sajh._b(f3 * 0.1f - 1.5707964f) - 1.0f) * 0.15f * f24);
                }
            } else if (this.isDive) {
                float f28 = f14 * 0.7f;
                float f29 = SmartMovingModel.Factor(f15, 0.0f, 0.15679921f);
                float f30 = SmartMovingModel.Factor(f15, 0.15679921f, 0.0f);
                float f31 = (double)f14 < (this.isGenericSneaking ? 0.005 : (double)0.015f) ? f8 : f9;
                modelRotationRenderer5.field_78795_f = -0.7853982f;
                modelRotationRenderer5.field_78798_e = -2.0f;
                modelRotationRenderer.fadeRotateAngleX = true;
                modelRotationRenderer.field_78795_f = this.isLevitate ? 1.1780972f : (this.isJump ? 0.0f : 1.5707964f - f10);
                modelRotationRenderer.field_78796_g = f31;
                modelRotationRenderer11.field_78808_h = (sajh._b(f28) + 1.0f) * 0.52264464f * f29 + 0.3926991f * f30;
                modelRotationRenderer12.field_78808_h = (sajh._b(f28 + (float)Math.PI) - 1.0f) * 0.52264464f * f29 - 0.3926991f * f30;
                if (this.scaleLegType != 1) {
                    this.setLegScales(1.0f + (sajh._b(f28 - 1.5707964f) - 1.0f) * 0.25f * f29, 1.0f + (sajh._b(f28 - 1.5707964f) - 1.0f) * 0.25f * f29);
                }
                modelRotationRenderer7.field_78808_h = (sajh._b(f28 + (float)Math.PI) * 0.52264464f * 2.5f + 1.5707964f) * f29 + 2.3561945f * f30;
                modelRotationRenderer9.field_78808_h = (sajh._b(f28) * 0.52264464f * 2.5f - 1.5707964f) * f29 - 2.3561945f * f30;
                if (this.scaleArmType != 1) {
                    this.setArmScales(1.0f + (sajh._b(f28 + 1.5707964f) - 1.0f) * 0.15f * f29, 1.0f + (sajh._b(f28 + 1.5707964f) - 1.0f) * 0.15f * f29);
                }
            } else if (this.isCrawl) {
                float f32 = f * 1.3f;
                float f33 = SmartMovingModel.Factor(this.currentHorizontalSpeedFlattened, 0.0f, 0.12951545f);
                float f34 = SmartMovingModel.Factor(this.currentHorizontalSpeedFlattened, 0.12951545f, 0.0f);
                modelRotationRenderer5.field_78808_h = -f4 / 57.295776f;
                modelRotationRenderer5.field_78795_f = -0.7853982f;
                modelRotationRenderer5.field_78798_e = -2.0f;
                modelRotationRenderer2.rotationOrder = 3;
                modelRotationRenderer2.field_78795_f = 1.3744469f;
                modelRotationRenderer2.field_78797_d = 3.0f;
                modelRotationRenderer2.field_78808_h = sajh._b(f32 + 1.5707964f) * 0.09817477f * f33;
                modelRotationRenderer3.field_78796_g = sajh._b(f32 + (float)Math.PI) * 0.09817477f * f33;
                modelRotationRenderer11.field_78795_f = (sajh._b(f32 - 1.5707964f) * 0.09817477f + 0.19634955f) * f33 + 0.19634955f * f34;
                modelRotationRenderer12.field_78795_f = (sajh._b(f32 - (float)Math.PI - 1.5707964f) * 0.09817477f + 0.19634955f) * f33 + 0.19634955f * f34;
                modelRotationRenderer11.field_78808_h = (sajh._b(f32 - 1.5707964f) + 1.0f) * 0.25f * f33 + 0.19634955f * f34;
                modelRotationRenderer12.field_78808_h = (sajh._b(f32 - 1.5707964f) - 1.0f) * 0.25f * f33 - 0.19634955f * f34;
                if (this.scaleLegType != 1) {
                    this.setLegScales(1.0f + (sajh._b(f32 + 1.5707964f - 1.5707964f) - 1.0f) * 0.25f * f33, 1.0f + (sajh._b(f32 - 1.5707964f - 1.5707964f) - 1.0f) * 0.25f * f33);
                }
                modelRotationRenderer7.rotationOrder = 3;
                modelRotationRenderer9.rotationOrder = 3;
                modelRotationRenderer7.field_78795_f = 3.926991f;
                modelRotationRenderer9.field_78795_f = 3.926991f;
                modelRotationRenderer7.field_78808_h = (sajh._b(f32 + (float)Math.PI) * 0.09817477f + 0.19634955f) * f33 + 0.3926991f * f34;
                modelRotationRenderer9.field_78808_h = (sajh._b(f32 + (float)Math.PI) * 0.09817477f - 0.19634955f) * f33 - 0.3926991f * f34;
                modelRotationRenderer7.field_78796_g = -1.5707964f;
                modelRotationRenderer9.field_78796_g = 1.5707964f;
                if (this.scaleArmType != 1) {
                    this.setArmScales(1.0f + (sajh._b(f32 + 1.5707964f) - 1.0f) * 0.15f * f33, 1.0f + (sajh._b(f32 - 1.5707964f) - 1.0f) * 0.15f * f33);
                }
            } else if (this.isSlide) {
                float f35 = f * 0.7f;
                float f36 = SmartMovingModel.Factor(f2, 0.0f, 1.0f) * 0.8f;
                modelRotationRenderer5.field_78808_h = -f4 / 57.295776f;
                modelRotationRenderer5.field_78795_f = -1.1780972f;
                modelRotationRenderer5.field_78798_e = -2.0f;
                modelRotationRenderer.fadeRotateAngleY = false;
                modelRotationRenderer.field_78796_g = f9;
                modelRotationRenderer.field_78797_d = 5.0f;
                modelRotationRenderer.field_78795_f = 1.5707964f;
                modelRotationRenderer3.rotationOrder = 2;
                modelRotationRenderer3.smOffsetY = -0.4f;
                modelRotationRenderer3.field_78797_d = 6.5f;
                modelRotationRenderer3.field_78795_f = sajh._b(f35 - 0.7853982f) * 0.09817477f * f36;
                modelRotationRenderer3.field_78796_g = sajh._b(f35 + 0.7853982f) * 0.09817477f * f36;
                modelRotationRenderer11.field_78795_f = sajh._b(f35 + (float)Math.PI) * 0.09817477f * f36 + 0.09817477f;
                modelRotationRenderer12.field_78795_f = sajh._b(f35 + 1.5707964f) * 0.09817477f * f36 + 0.09817477f;
                modelRotationRenderer11.field_78808_h = 0.19634955f;
                modelRotationRenderer12.field_78808_h = -0.19634955f;
                modelRotationRenderer7.rotationOrder = 3;
                modelRotationRenderer9.rotationOrder = 3;
                modelRotationRenderer7.field_78795_f = sajh._b(f35 + 1.5707964f) * 0.09817477f * f36 + (float)Math.PI - 0.09817477f;
                modelRotationRenderer9.field_78795_f = sajh._b(f35 - (float)Math.PI) * 0.09817477f * f36 + (float)Math.PI - 0.09817477f;
                modelRotationRenderer7.field_78808_h = 0.3926991f;
                modelRotationRenderer9.field_78808_h = -0.3926991f;
                modelRotationRenderer7.field_78796_g = -1.5707964f;
                modelRotationRenderer9.field_78796_g = 1.5707964f;
            } else if (this.isFlying) {
                float f37 = f14 * 0.08f;
                float f38 = SmartMovingModel.Factor(f15, 0.0f, 1.0f);
                float f39 = SmartMovingModel.Factor(f15, 1.0f, 0.0f);
                float f40 = f3 * 0.15f;
                float f41 = this.isJump ? Math.abs(f10) : f10;
                float f42 = d < (double)0.05f ? f8 : f9;
                modelRotationRenderer.fadeRotateAngleX = true;
                modelRotationRenderer.field_78795_f = (1.5707964f - f41) * f38;
                modelRotationRenderer.field_78796_g = f42;
                modelRotationRenderer5.field_78795_f = -modelRotationRenderer.field_78795_f / 2.0f;
                modelRotationRenderer7.rotationOrder = 1;
                modelRotationRenderer9.rotationOrder = 1;
                modelRotationRenderer7.field_78796_g = sajh._b(f40) * 0.3926991f * f39;
                modelRotationRenderer9.field_78796_g = sajh._b(f40) * 0.3926991f * f39;
                modelRotationRenderer7.field_78808_h = (sajh._b(f37 + (float)Math.PI) * 0.09817477f + 2.7488937f) * f38 + 1.5707964f * f39;
                modelRotationRenderer9.field_78808_h = (sajh._b(f37) * 0.09817477f - 2.7488937f) * f38 - 1.5707964f * f39;
                modelRotationRenderer11.field_78795_f = sajh._b(f37) * 0.09817477f * f38 + sajh._b(f40 + (float)Math.PI) * 0.09817477f * f39;
                modelRotationRenderer12.field_78795_f = sajh._b(f37 + (float)Math.PI) * 0.09817477f * f38 + sajh._b(f40) * 0.09817477f * f39;
                modelRotationRenderer11.field_78808_h = 0.09817477f;
                modelRotationRenderer12.field_78808_h = -0.09817477f;
            } else if (this.isHeadJump) {
                modelRotationRenderer.fadeRotateAngleX = true;
                modelRotationRenderer.field_78795_f = 1.5707964f - f10;
                modelRotationRenderer.field_78796_g = f9;
                modelRotationRenderer5.field_78795_f = -modelRotationRenderer.field_78795_f / 2.0f;
                float f43 = Math.min(SmartMovingModel.Factor(f10, 1.5707964f, 0.0f), SmartMovingModel.Factor(f10, -1.5707964f, 0.0f));
                modelRotationRenderer7.field_78795_f = f43 * -0.7853982f;
                modelRotationRenderer9.field_78795_f = f43 * -0.7853982f;
                modelRotationRenderer11.field_78795_f = f43 * -0.7853982f;
                modelRotationRenderer12.field_78795_f = f43 * -0.7853982f;
                float f44 = SmartMovingModel.Factor(f10, 1.5707964f, -1.5707964f);
                if (this.overGroundBlockId > 0 && twgu.field_71973_m[this.overGroundBlockId].field_72018_cp._a()) {
                    f44 = Math.min(f44, this.smallOverGroundHeight / 5.0f);
                }
                modelRotationRenderer7.field_78808_h = 2.7488937f + f44 * 0.7853982f;
                modelRotationRenderer9.field_78808_h = -2.7488937f - f44 * 0.7853982f;
                float f45 = SmartMovingModel.Factor(f10, -1.5707964f, 1.5707964f);
                modelRotationRenderer11.field_78808_h = 0.09817477f * f45;
                modelRotationRenderer12.field_78808_h = -0.09817477f * f45;
            } else if (this.isFalling) {
                float f46 = f14 * 0.1f;
                modelRotationRenderer7.rotationOrder = 1;
                modelRotationRenderer9.rotationOrder = 1;
                modelRotationRenderer7.field_78796_g = sajh._b(f46 + 1.5707964f) * 0.7853982f;
                modelRotationRenderer9.field_78796_g = sajh._b(f46 + 1.5707964f) * 0.7853982f;
                modelRotationRenderer7.field_78808_h = sajh._b(f46) * 0.7853982f + 1.5707964f;
                modelRotationRenderer9.field_78808_h = sajh._b(f46) * 0.7853982f - 1.5707964f;
                modelRotationRenderer11.field_78795_f = sajh._b(f46 + (float)Math.PI + 1.5707964f) * 0.3926991f + 0.19634955f;
                modelRotationRenderer12.field_78795_f = sajh._b(f46 + 1.5707964f) * 0.3926991f + 0.19634955f;
                modelRotationRenderer11.field_78808_h = sajh._b(f46) * 0.3926991f + 0.19634955f;
                modelRotationRenderer12.field_78808_h = sajh._b(f46) * 0.3926991f - 0.19634955f;
            } else {
                this.isStandard = true;
            }
        } else {
            float f47;
            float f48;
            float f49;
            float f50;
            float f51;
            float f52;
            float f53;
            float f54;
            float f55;
            float f56;
            float f57;
            float f58;
            float f59;
            float f60;
            modelRotationRenderer.field_78796_g = f11 / 57.295776f;
            modelRotationRenderer5.field_78796_g = 0.0f;
            modelRotationRenderer5.field_78795_f = f5 / 57.295776f;
            modelRotationRenderer12.rotationOrder = 3;
            modelRotationRenderer11.rotationOrder = 3;
            int n = this.handsClimbType;
            if (this.isHandsVineClimbing && n == 2) {
                n = 1;
            }
            float f61 = Math.min(0.5f, f12);
            float f62 = Math.min(0.5f, f2);
            switch (n) {
                case 1: {
                    f60 = 0.6662f;
                    f59 = 1.0f;
                    f58 = 0.0f;
                    f57 = 0.6662f;
                    f56 = 2.0f;
                    f55 = -2.5f;
                    break;
                }
                case 2: {
                    f60 = 0.6662f;
                    f59 = 1.0f;
                    f58 = 0.0f;
                    f57 = 0.6662f;
                    f56 = 2.0f;
                    f55 = -1.5707964f;
                    break;
                }
                default: {
                    f60 = 0.6662f;
                    f59 = 1.0f;
                    f58 = 0.0f;
                    f57 = 0.6662f;
                    f56 = 0.0f;
                    f55 = -0.5f;
                }
            }
            switch (this.feetClimbType) {
                case 1: {
                    f54 = 0.6662f;
                    f53 = 0.3f / f61;
                    f52 = -0.3f;
                    f51 = 0.6662f;
                    f50 = 0.5f;
                    f49 = 0.0f;
                    break;
                }
                default: {
                    f54 = 0.6662f;
                    f53 = 0.0f;
                    f52 = 0.0f;
                    f51 = 0.6662f;
                    f50 = 0.0f;
                    f49 = 0.0f;
                }
            }
            modelRotationRenderer7.field_78795_f = sajh._b(f13 * f57 + (float)Math.PI) * f61 * f56 + f55;
            modelRotationRenderer9.field_78795_f = sajh._b(f13 * f57) * f61 * f56 + f55;
            modelRotationRenderer7.field_78796_g = sajh._b(f * f60 + 1.5707964f) * f62 * f59 + f58;
            modelRotationRenderer9.field_78796_g = sajh._b(f * f60) * f62 * f59 + f58;
            if (this.isHandsVineClimbing) {
                modelRotationRenderer9.field_78796_g *= 1.0f + f60;
                modelRotationRenderer7.field_78796_g *= 1.0f + f60;
                modelRotationRenderer9.field_78796_g += 0.7853982f;
                modelRotationRenderer7.field_78796_g -= 0.7853982f;
                this.setArmScales(Math.abs(sajh._b(modelRotationRenderer7.field_78795_f)), Math.abs(sajh._b(modelRotationRenderer9.field_78795_f)));
            }
            if (!this.isFeetVineClimbing) {
                modelRotationRenderer11.field_78795_f = sajh._b(f13 * f54) * f53 * f61 + f52;
                modelRotationRenderer12.field_78795_f = sajh._b(f13 * f54 + (float)Math.PI) * f53 * f61 + f52;
            }
            modelRotationRenderer11.field_78808_h = -(sajh._b(f * f51) - 1.0f) * f62 * f50 + f49;
            modelRotationRenderer12.field_78808_h = -(sajh._b(f * f51 + 1.5707964f) + 1.0f) * f62 * f50 + f49;
            if (this.isFeetVineClimbing) {
                f48 = (sajh._b(f14 + (float)Math.PI) + 1.0f) * 0.19634955f + 0.3926991f;
                modelRotationRenderer11.field_78795_f = -f48;
                modelRotationRenderer12.field_78795_f = -f48;
                f47 = Math.max(0.0f, sajh._b(f14 - 1.5707964f)) * 0.09817477f;
                modelRotationRenderer12.field_78808_h += -f47;
                modelRotationRenderer11.field_78808_h += f47;
                this.setLegScales(Math.abs(sajh._b(modelRotationRenderer11.field_78795_f)), Math.abs(sajh._b(modelRotationRenderer12.field_78795_f)));
            }
            if (this.isCrawlClimb) {
                float f63;
                float f64;
                float f65;
                f48 = this.smallOverGroundHeight + 0.25f;
                f47 = 0.7f;
                float f66 = 0.55f;
                if (f48 < f47) {
                    f65 = Math.max(0.0f, (float)Math.acos(f48 / f47));
                    f64 = 1.5707964f - f65;
                    f63 = 0.19634955f;
                } else if (f48 < f47 + f66) {
                    f65 = 0.0f;
                    f64 = Math.max(0.0f, (float)Math.acos((f48 - f47) / f66));
                    f63 = 0.19634955f * (f64 / 1.537f);
                } else {
                    f65 = 0.0f;
                    f64 = 0.0f;
                    f63 = 0.0f;
                }
                modelRotationRenderer2.field_78795_f = f65;
                modelRotationRenderer6.field_78795_f = -f65;
                modelRotationRenderer8.field_78795_f = -f65;
                modelRotationRenderer5.field_78795_f = -f65;
                modelRotationRenderer11.field_78795_f = f64;
                modelRotationRenderer12.field_78795_f = f64;
                modelRotationRenderer11.field_78808_h = f63;
                modelRotationRenderer12.field_78808_h = -f63;
            }
            if (n == 0 && this.feetClimbType != 0) {
                modelRotationRenderer2.field_78795_f = 0.5f;
                modelRotationRenderer5.field_78795_f -= 0.5f;
                modelRotationRenderer10.field_78795_f -= 0.5f;
                modelRotationRenderer2.field_78798_e = -6.0f;
            }
        }
    }

    private boolean isWorking() {
        return this.mp.field_78095_p > 0.0f;
    }

    private void animateAngleJumping() {
        float f = (float)this.angleJumpType * 0.7853982f;
        this.md.bipedPelvic.field_78796_g -= this.md.bipedOuter.field_78796_g;
        this.md.bipedPelvic.field_78796_g += this.md.currentCameraAngle;
        float f2 = 1.0f - Math.abs(f - (float)Math.PI) / 1.5707964f;
        float f3 = -Math.min(f - (float)Math.PI, 0.0f) / 1.5707964f;
        float f4 = Math.max(f - (float)Math.PI, 0.0f) / 1.5707964f;
        this.md.bipedLeftLeg.field_78795_f = 0.19634955f * (1.0f + f4);
        this.md.bipedRightLeg.field_78795_f = 0.19634955f * (1.0f + f3);
        this.md.bipedLeftLeg.field_78796_g = -f;
        this.md.bipedRightLeg.field_78796_g = -f;
        this.md.bipedLeftLeg.field_78808_h = 0.19634955f * f2;
        this.md.bipedRightLeg.field_78808_h = -0.19634955f * f2;
        this.md.bipedLeftLeg.rotationOrder = 4;
        this.md.bipedRightLeg.rotationOrder = 4;
        this.md.bipedLeftArm.field_78808_h = -0.3926991f * f4;
        this.md.bipedRightArm.field_78808_h = 0.3926991f * f3;
        this.md.bipedLeftArm.field_78795_f = -0.7853982f * f2;
        this.md.bipedRightArm.field_78795_f = -0.7853982f * f2;
    }

    private void animateNonStandardWorking(float f) {
        this.md.bipedRightShoulder.ignoreSuperRotation = true;
        this.md.bipedRightShoulder.field_78795_f = f / 57.295776f;
        this.md.bipedRightShoulder.field_78796_g = this.md.workingAngle / 57.295776f;
        this.md.bipedRightShoulder.field_78808_h = (float)Math.PI;
        this.md.bipedRightShoulder.rotationOrder = 5;
        this.md.bipedRightArm.reset();
    }

    private void animateNonStandardBowAiming(float f, float f2, float f3, float f4, float f5, float f6) {
        this.md.bipedRightShoulder.ignoreSuperRotation = true;
        this.md.bipedRightShoulder.field_78796_g = this.md.workingAngle / 57.295776f;
        this.md.bipedRightShoulder.rotationOrder = 5;
        this.md.bipedLeftShoulder.ignoreSuperRotation = true;
        this.md.bipedLeftShoulder.field_78796_g = this.md.workingAngle / 57.295776f;
        this.md.bipedLeftShoulder.rotationOrder = 5;
        this.md.bipedRightArm.reset();
        this.md.bipedLeftArm.reset();
        float f7 = this.md.bipedHead.field_78796_g;
        float f8 = this.md.bipedOuter.field_78796_g;
        float f9 = this.md.bipedHead.field_78795_f;
        this.md.bipedHead.field_78796_g = 0.0f;
        this.md.bipedOuter.field_78796_g = 0.0f;
        this.md.bipedHead.field_78795_f = 0.0f;
        this.md.animateBowAiming(f3);
        this.md.bipedHead.field_78796_g = f7;
        this.md.bipedOuter.field_78796_g = f8;
        this.md.bipedHead.field_78795_f = f9;
    }

    public void animateHeadRotation(float f, float f2, float f3, float f4, float f5, float f6) {
        this.setRotationAngles(f, f2, f3, f4, f5, f6);
        if (this.isStandard) {
            this.md.animateHeadRotation(f4, f5);
        }
    }

    public void animateSleeping(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.isStandard) {
            this.md.animateSleeping();
        }
    }

    public void animateArmSwinging(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.isStandard) {
            if (this.isAngleJumping) {
                this.animateAngleJumping();
            } else {
                this.md.animateArmSwinging(f, f2);
            }
        }
    }

    public void animateRiding(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.isStandard) {
            this.md.animateRiding();
        }
    }

    public void animateLeftArmItemHolding(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.isStandard) {
            this.md.animateLeftArmItemHolding();
        }
    }

    public void animateRightArmItemHolding(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.isStandard) {
            this.md.animateRightArmItemHolding();
        }
    }

    public void animateWorkingBody(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.isStandard) {
            this.md.animateWorkingBody();
        } else if (this.isWorking()) {
            this.animateNonStandardWorking(f5);
        }
    }

    public void animateWorkingArms(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.isStandard || this.isWorking()) {
            this.md.animateWorkingArms();
        }
    }

    public void animateSneaking(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.isStandard && !this.isAngleJumping) {
            this.md.animateSneaking();
        }
    }

    public void animateArms(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.isStandard) {
            this.md.animateArms(f3);
        }
    }

    public void animateBowAiming(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.isStandard) {
            this.md.animateBowAiming(f3);
        } else {
            this.animateNonStandardBowAiming(f, f2, f3, f4, f5, f6);
        }
    }

    private void setArmScales(float f, float f2) {
        if (this.scaleArmType == 0) {
            this.md.bipedRightArm.scaleY = f;
            this.md.bipedLeftArm.scaleY = f2;
        } else if (this.scaleArmType == 2) {
            this.md.bipedRightArm.smOffsetY -= (1.0f - f) * 0.5f;
            this.md.bipedLeftArm.smOffsetY -= (1.0f - f2) * 0.5f;
        }
    }

    private void setLegScales(float f, float f2) {
        if (this.scaleLegType == 0) {
            this.md.bipedRightLeg.scaleY = f;
            this.md.bipedLeftLeg.scaleY = f2;
        } else if (this.scaleLegType == 2) {
            this.md.bipedRightLeg.smOffsetY -= (1.0f - f) * 0.5f;
            this.md.bipedLeftLeg.smOffsetY -= (1.0f - f2) * 0.5f;
        }
    }

    private static float Factor(float f, float f2, float f3) {
        return f2 > f3 ? (f <= f3 ? 1.0f : (f >= f2 ? 0.0f : (f2 - f) / (f2 - f3))) : (f >= f3 ? 1.0f : (f <= f2 ? 0.0f : (f - f2) / (f3 - f2)));
    }

    private static float Between(float f, float f2, float f3) {
        return f3 < f ? f : (f3 > f2 ? f2 : f3);
    }

    private static float Normalize(float f) {
        while (f > (float)Math.PI) {
            f -= (float)Math.PI * 2;
        }
        while (f < (float)(-Math.PI)) {
            f += (float)Math.PI * 2;
        }
        return f;
    }
}

