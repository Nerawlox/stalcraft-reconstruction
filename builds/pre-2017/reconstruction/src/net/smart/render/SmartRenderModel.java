/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render;

import java.util.List;
import java.util.Random;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.sajh;
import net.smart.moving.render.SmartMovingModel;
import net.smart.render.IModelPlayer;
import net.smart.render.ModelCapeRenderer;
import net.smart.render.ModelEarsRenderer;
import net.smart.render.ModelRotationRenderer;
import net.smart.render.RendererData;
import net.smart.render.SmartRenderContext;

public class SmartRenderModel
extends SmartRenderContext {
    public IModelPlayer imp;
    public ModelBiped mp;
    public boolean isInventory;
    public int scaleArmType;
    public int scaleLegType;
    public float totalVerticalDistance;
    public float currentVerticalSpeed;
    public float totalDistance;
    public float currentSpeed;
    public double distance;
    public double verticalDistance;
    public double horizontalDistance;
    public float currentCameraAngle;
    public float currentVerticalAngle;
    public float currentHorizontalAngle;
    public float actualRotation;
    public float forwardRotation;
    public float workingAngle;
    public ModelRotationRenderer bipedOuter;
    public ModelRotationRenderer bipedTorso;
    public ModelRotationRenderer bipedBody;
    public ModelRotationRenderer bipedBreast;
    public ModelRotationRenderer bipedNeck;
    public ModelRotationRenderer bipedHead;
    public ModelRotationRenderer bipedHeadwear;
    public ModelRotationRenderer bipedRightShoulder;
    public ModelRotationRenderer bipedRightArm;
    public ModelRotationRenderer bipedLeftShoulder;
    public ModelRotationRenderer bipedLeftArm;
    public ModelRotationRenderer bipedPelvic;
    public ModelRotationRenderer bipedRightLeg;
    public ModelRotationRenderer bipedLeftLeg;
    public ModelEarsRenderer bipedEars;
    public ModelCapeRenderer bipedCloak;
    public boolean disabled;
    public boolean attemptToCallRenderCape;
    public RendererData prevOuterRenderData;
    public boolean isSleeping;
    public boolean firstPerson;
    public SmartMovingModel movingModel;

    public SmartRenderModel(float f, ModelBiped modelBiped, IModelPlayer iModelPlayer) {
        this.imp = iModelPlayer;
        this.mp = modelBiped;
        modelBiped.boxList.clear();
        this.bipedOuter = new ModelRotationRenderer(modelBiped, -1, -1, null);
        this.bipedOuter.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedOuter.fadeEnabled = true;
        this.bipedTorso = new ModelRotationRenderer(modelBiped, 16, 16, this.bipedOuter);
        this.bipedTorso.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedBody = new ModelRotationRenderer(modelBiped, 16, 16, this.bipedTorso);
        this.bipedBody.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4, f);
        this.bipedBody.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedBreast = new ModelRotationRenderer(modelBiped, -1, -1, this.bipedTorso);
        this.bipedBreast.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedNeck = new ModelRotationRenderer(modelBiped, -1, -1, this.bipedBreast);
        this.bipedNeck.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedCloak = new ModelCapeRenderer(modelBiped, 0, 0, this.bipedBreast, this.bipedOuter);
        this.bipedCloak.addBox(-5.0f, 0.0f, -1.0f, 10, 16, 1, f);
        this.bipedCloak.setRotationPoint(0.0f, 0.0f, 2.0f);
        this.bipedHead = new ModelRotationRenderer(modelBiped, 0, 0, this.bipedNeck);
        this.bipedHead.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, f);
        this.bipedHead.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedEars = new ModelEarsRenderer(modelBiped, 24, 0, this.bipedHead);
        this.bipedEars.addBox(-3.0f, -6.0f, -1.0f, 6, 6, 1, f);
        this.bipedEars.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedHeadwear = new ModelRotationRenderer(modelBiped, 32, 0, this.bipedHead);
        this.bipedHeadwear.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, f + 0.5f);
        this.bipedHeadwear.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedRightShoulder = new ModelRotationRenderer(modelBiped, 40, 16, this.bipedBreast);
        this.bipedRightShoulder.setRotationPoint(-5.0f, 2.0f, 0.0f);
        this.bipedRightArm = new ModelRotationRenderer(modelBiped, 40, 16, this.bipedRightShoulder);
        this.bipedRightArm.addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4, f);
        this.bipedLeftShoulder = new ModelRotationRenderer(modelBiped, -1, -1, this.bipedBreast);
        this.bipedLeftShoulder.mirror = true;
        this.bipedLeftShoulder.setRotationPoint(5.0f, 2.0f, 0.0f);
        this.bipedLeftArm = new ModelRotationRenderer(modelBiped, 40, 16, this.bipedLeftShoulder);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4, f);
        this.bipedPelvic = new ModelRotationRenderer(modelBiped, -1, -1, this.bipedTorso);
        this.bipedPelvic.setRotationPoint(0.0f, 12.0f, 0.0f);
        this.bipedRightLeg = new ModelRotationRenderer(modelBiped, 0, 16, this.bipedPelvic);
        this.bipedRightLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, f);
        this.bipedRightLeg.setRotationPoint(-2.0f, 0.0f, 0.0f);
        this.bipedLeftLeg = new ModelRotationRenderer(modelBiped, 0, 16, this.bipedPelvic);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, f);
        this.bipedLeftLeg.setRotationPoint(2.0f, 0.0f, 0.0f);
        iModelPlayer.initialize(this.bipedBody, this.bipedCloak, this.bipedHead, this.bipedEars, this.bipedHeadwear, this.bipedRightArm, this.bipedLeftArm, this.bipedRightLeg, this.bipedLeftLeg);
    }

    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.bipedLeftLeg.ignoreRender = true;
        this.bipedRightLeg.ignoreRender = true;
        this.bipedLeftArm.ignoreRender = true;
        this.bipedRightArm.ignoreRender = true;
        this.bipedHeadwear.ignoreRender = true;
        this.bipedHead.ignoreRender = true;
        this.bipedBody.ignoreRender = true;
        this.imp.superRender(entity, f, f2, f3, f4, f5, f6);
        this.bipedLeftLeg.ignoreRender = false;
        this.bipedRightLeg.ignoreRender = false;
        this.bipedLeftArm.ignoreRender = false;
        this.bipedRightArm.ignoreRender = false;
        this.bipedHeadwear.ignoreRender = false;
        this.bipedHead.ignoreRender = false;
        this.bipedBody.ignoreRender = false;
        this.bipedOuter.render(f6);
        this.bipedOuter.renderIgnoreBase(f6);
        this.bipedTorso.renderIgnoreBase(f6);
        this.bipedBody.renderIgnoreBase(f6);
        this.bipedBreast.renderIgnoreBase(f6);
        this.bipedNeck.renderIgnoreBase(f6);
        this.bipedHead.renderIgnoreBase(f6);
        this.bipedHeadwear.renderIgnoreBase(f6);
        this.bipedRightShoulder.renderIgnoreBase(f6);
        this.bipedRightArm.renderIgnoreBase(f6);
        this.bipedLeftShoulder.renderIgnoreBase(f6);
        this.bipedLeftArm.renderIgnoreBase(f6);
        this.bipedPelvic.renderIgnoreBase(f6);
        this.bipedRightLeg.renderIgnoreBase(f6);
        this.bipedLeftLeg.renderIgnoreBase(f6);
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        if (this.movingModel != null) {
            this.setRotationAnglesOptimized(f, f2, f3, f4, f5, f6, entity);
            return;
        }
        this.reset();
        if (!this.firstPerson && !this.isInventory) {
            if (this.isSleeping) {
                this.prevOuterRenderData.rotateAngleX = 0.0f;
                this.prevOuterRenderData.rotateAngleY = 0.0f;
                this.prevOuterRenderData.rotateAngleZ = 0.0f;
            }
            this.bipedOuter.previous = this.prevOuterRenderData;
            this.bipedOuter.rotateAngleY = this.actualRotation / 57.295776f;
            this.bipedOuter.fadeRotateAngleY = !(entity.ridingEntity instanceof EntityPig);
            this.imp.animateHeadRotation(f, f2, f3, f4, f5, f6);
            if (this.isSleeping) {
                this.imp.animateSleeping(f, f2, f3, f4, f5, f6);
            }
            this.imp.animateArmSwinging(f, f2, f3, f4, f5, f6);
            if (this.mp.isRiding) {
                this.imp.animateRiding(f, f2, f3, f4, f5, f6);
            }
            if (this.mp.heldItemLeft != 0) {
                this.imp.animateLeftArmItemHolding(f, f2, f3, f4, f5, f6);
            }
            if (this.mp.heldItemRight != 0) {
                this.imp.animateRightArmItemHolding(f, f2, f3, f4, f5, f6);
            }
            if (this.mp.onGround > -9990.0f) {
                this.imp.animateWorkingBody(f, f2, f3, f4, f5, f6);
                this.imp.animateWorkingArms(f, f2, f3, f4, f5, f6);
            }
            if (this.mp.isSneak) {
                this.imp.animateSneaking(f, f2, f3, f4, f5, f6);
            }
            this.imp.animateArms(f, f2, f3, f4, f5, f6);
            if (this.mp.aimedBow) {
                this.imp.animateBowAiming(f, f2, f3, f4, f5, f6);
            }
            if (this.bipedOuter.previous != null && !this.bipedOuter.fadeRotateAngleX) {
                this.bipedOuter.previous.rotateAngleX = this.bipedOuter.rotateAngleX;
            }
            if (this.bipedOuter.previous != null && !this.bipedOuter.fadeRotateAngleY) {
                this.bipedOuter.previous.rotateAngleY = this.bipedOuter.rotateAngleY;
            }
            this.bipedOuter.fadeIntermediate(f3);
            this.bipedOuter.fadeStore(f3);
            this.bipedCloak.ignoreBase = false;
            this.bipedCloak.rotateAngleX = 0.09817477f;
        } else {
            this.bipedBody.ignoreBase = true;
            this.bipedHead.ignoreBase = true;
            this.bipedHeadwear.ignoreBase = true;
            this.bipedEars.ignoreBase = true;
            this.bipedCloak.ignoreBase = true;
            this.bipedRightArm.ignoreBase = true;
            this.bipedLeftArm.ignoreBase = true;
            this.bipedRightLeg.ignoreBase = true;
            this.bipedLeftLeg.ignoreBase = true;
            this.bipedBody.forceRender = this.firstPerson;
            this.bipedHead.forceRender = this.firstPerson;
            this.bipedHeadwear.forceRender = this.firstPerson;
            this.bipedEars.forceRender = this.firstPerson;
            this.bipedCloak.forceRender = this.firstPerson;
            this.bipedRightArm.forceRender = this.firstPerson;
            this.bipedLeftArm.forceRender = this.firstPerson;
            this.bipedRightLeg.forceRender = this.firstPerson;
            this.bipedLeftLeg.forceRender = this.firstPerson;
            this.bipedRightArm.setRotationPoint(-5.0f, 2.0f, 0.0f);
            this.bipedLeftArm.setRotationPoint(5.0f, 2.0f, 0.0f);
            this.bipedRightLeg.setRotationPoint(-2.0f, 12.0f, 0.0f);
            this.bipedLeftLeg.setRotationPoint(2.0f, 12.0f, 0.0f);
            this.imp.superSetRotationAngles(f, f2, f3, f4, f5, f6, entity);
        }
    }

    private void setRotationAnglesOptimized(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        this.reset();
        if (!this.firstPerson && !this.isInventory) {
            if (this.isSleeping) {
                this.prevOuterRenderData.rotateAngleX = 0.0f;
                this.prevOuterRenderData.rotateAngleY = 0.0f;
                this.prevOuterRenderData.rotateAngleZ = 0.0f;
            }
            this.bipedOuter.previous = this.prevOuterRenderData;
            this.bipedOuter.rotateAngleY = this.actualRotation / 57.295776f;
            this.bipedOuter.fadeRotateAngleY = !(entity.ridingEntity instanceof EntityPig);
            this.movingModel.animateHeadRotation(f, f2, f3, f4, f5, f6);
            if (this.isSleeping) {
                this.movingModel.animateSleeping(f, f2, f3, f4, f5, f6);
            }
            this.movingModel.animateArmSwinging(f, f2, f3, f4, f5, f6);
            if (this.mp.isRiding) {
                this.movingModel.animateRiding(f, f2, f3, f4, f5, f6);
            }
            if (this.mp.heldItemLeft != 0) {
                this.movingModel.animateLeftArmItemHolding(f, f2, f3, f4, f5, f6);
            }
            if (this.mp.heldItemRight != 0) {
                this.movingModel.animateRightArmItemHolding(f, f2, f3, f4, f5, f6);
            }
            if (this.mp.onGround > -9990.0f) {
                this.movingModel.animateWorkingBody(f, f2, f3, f4, f5, f6);
                this.movingModel.animateWorkingArms(f, f2, f3, f4, f5, f6);
            }
            if (this.mp.isSneak) {
                this.movingModel.animateSneaking(f, f2, f3, f4, f5, f6);
            }
            this.movingModel.animateArms(f, f2, f3, f4, f5, f6);
            if (this.mp.aimedBow) {
                this.movingModel.animateBowAiming(f, f2, f3, f4, f5, f6);
            }
            if (this.bipedOuter.previous != null && !this.bipedOuter.fadeRotateAngleX) {
                this.bipedOuter.previous.rotateAngleX = this.bipedOuter.rotateAngleX;
            }
            if (this.bipedOuter.previous != null && !this.bipedOuter.fadeRotateAngleY) {
                this.bipedOuter.previous.rotateAngleY = this.bipedOuter.rotateAngleY;
            }
            this.bipedOuter.fadeIntermediate(f3);
            this.bipedOuter.fadeStore(f3);
            this.bipedCloak.ignoreBase = false;
            this.bipedCloak.rotateAngleX = 0.09817477f;
        } else {
            this.bipedBody.ignoreBase = true;
            this.bipedHead.ignoreBase = true;
            this.bipedHeadwear.ignoreBase = true;
            this.bipedEars.ignoreBase = true;
            this.bipedCloak.ignoreBase = true;
            this.bipedRightArm.ignoreBase = true;
            this.bipedLeftArm.ignoreBase = true;
            this.bipedRightLeg.ignoreBase = true;
            this.bipedLeftLeg.ignoreBase = true;
            this.bipedBody.forceRender = this.firstPerson;
            this.bipedHead.forceRender = this.firstPerson;
            this.bipedHeadwear.forceRender = this.firstPerson;
            this.bipedEars.forceRender = this.firstPerson;
            this.bipedCloak.forceRender = this.firstPerson;
            this.bipedRightArm.forceRender = this.firstPerson;
            this.bipedLeftArm.forceRender = this.firstPerson;
            this.bipedRightLeg.forceRender = this.firstPerson;
            this.bipedLeftLeg.forceRender = this.firstPerson;
            this.bipedRightArm.setRotationPoint(-5.0f, 2.0f, 0.0f);
            this.bipedLeftArm.setRotationPoint(5.0f, 2.0f, 0.0f);
            this.bipedRightLeg.setRotationPoint(-2.0f, 12.0f, 0.0f);
            this.bipedLeftLeg.setRotationPoint(2.0f, 12.0f, 0.0f);
            this.imp.superSetRotationAngles(f, f2, f3, f4, f5, f6, entity);
        }
    }

    public void animateHeadRotation(float f, float f2) {
        this.bipedNeck.ignoreBase = true;
        this.bipedHead.rotateAngleY = (this.actualRotation + f) / 57.295776f;
        this.bipedHead.rotateAngleX = f2 / 57.295776f;
    }

    public void animateSleeping() {
        this.bipedNeck.ignoreBase = false;
        this.bipedHead.rotateAngleY = 0.0f;
        this.bipedHead.rotateAngleX = 0.7853982f;
        this.bipedTorso.rotationPointZ = -17.0f;
    }

    public void animateArmSwinging(float f, float f2) {
        this.bipedRightArm.rotateAngleX = sajh._b(f * 0.6662f + (float)Math.PI) * 2.0f * f2 * 0.5f;
        this.bipedLeftArm.rotateAngleX = sajh._b(f * 0.6662f) * 2.0f * f2 * 0.5f;
        this.bipedRightLeg.rotateAngleX = sajh._b(f * 0.6662f) * 1.4f * f2;
        this.bipedLeftLeg.rotateAngleX = sajh._b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
    }

    public void animateRiding() {
        this.bipedRightArm.rotateAngleX += -0.6283185f;
        this.bipedLeftArm.rotateAngleX += -0.6283185f;
        this.bipedRightLeg.rotateAngleX = -1.256637f;
        this.bipedLeftLeg.rotateAngleX = -1.256637f;
        this.bipedRightLeg.rotateAngleY = 0.3141593f;
        this.bipedLeftLeg.rotateAngleY = -0.3141593f;
    }

    public void animateLeftArmItemHolding() {
        this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5f - 0.3141593f * (float)this.mp.heldItemLeft;
    }

    public void animateRightArmItemHolding() {
        this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5f - 0.3141593f * (float)this.mp.heldItemRight;
    }

    public void animateWorkingBody() {
        float f = sajh._a(sajh._c(this.mp.onGround) * ((float)Math.PI * 2)) * 0.2f;
        this.bipedBreast.rotateAngleY = this.bipedBody.rotateAngleY += f;
        this.bipedBody.rotationOrder = 2;
        this.bipedBreast.rotationOrder = 2;
        this.bipedLeftArm.rotateAngleX += f;
    }

    public void animateWorkingArms() {
        float f = 1.0f - this.mp.onGround;
        f = 1.0f - f * f * f;
        float f2 = sajh._a(f * (float)Math.PI);
        float f3 = sajh._a(this.mp.onGround * (float)Math.PI) * -(this.bipedHead.rotateAngleX - 0.7f) * 0.75f;
        this.bipedRightArm.rotateAngleX = (float)((double)this.bipedRightArm.rotateAngleX - ((double)f2 * 1.2 + (double)f3));
        this.bipedRightArm.rotateAngleY += sajh._a(sajh._c(this.mp.onGround) * ((float)Math.PI * 2)) * 0.4f;
        this.bipedRightArm.rotateAngleZ -= sajh._a(this.mp.onGround * (float)Math.PI) * 0.4f;
    }

    public void animateSneaking() {
        this.bipedTorso.rotateAngleX += 0.5f;
        this.bipedRightLeg.rotateAngleX += -0.5f;
        this.bipedLeftLeg.rotateAngleX += -0.5f;
        this.bipedRightArm.rotateAngleX += -0.1f;
        this.bipedLeftArm.rotateAngleX += -0.1f;
        this.bipedPelvic.smOffsetY = -0.137f;
        this.bipedPelvic.smOffsetZ = -0.051f;
        this.bipedBreast.smOffsetY = -0.014f;
        this.bipedBreast.smOffsetZ = -0.057f;
        this.bipedNeck.smOffsetY = 0.0621f;
    }

    public void animateArms(float f) {
        this.bipedRightArm.rotateAngleZ += sajh._b(f * 0.09f) * 0.05f + 0.05f;
        this.bipedLeftArm.rotateAngleZ -= sajh._b(f * 0.09f) * 0.05f + 0.05f;
        this.bipedRightArm.rotateAngleX += sajh._a(f * 0.067f) * 0.05f;
        this.bipedLeftArm.rotateAngleX -= sajh._a(f * 0.067f) * 0.05f;
    }

    public void animateBowAiming(float f) {
        this.bipedRightArm.rotateAngleZ = 0.0f;
        this.bipedLeftArm.rotateAngleZ = 0.0f;
        this.bipedRightArm.rotateAngleY = -0.1f + this.bipedHead.rotateAngleY - this.bipedOuter.rotateAngleY;
        this.bipedLeftArm.rotateAngleY = 0.1f + this.bipedHead.rotateAngleY + 0.4f - this.bipedOuter.rotateAngleY;
        this.bipedRightArm.rotateAngleX = -1.570796f + this.bipedHead.rotateAngleX;
        this.bipedLeftArm.rotateAngleX = -1.570796f + this.bipedHead.rotateAngleX;
        this.bipedRightArm.rotateAngleZ += sajh._b(f * 0.09f) * 0.05f + 0.05f;
        this.bipedLeftArm.rotateAngleZ -= sajh._b(f * 0.09f) * 0.05f + 0.05f;
        this.bipedRightArm.rotateAngleX += sajh._a(f * 0.067f) * 0.05f;
        this.bipedLeftArm.rotateAngleX -= sajh._a(f * 0.067f) * 0.05f;
    }

    public void reset() {
        this.bipedOuter.reset();
        this.bipedTorso.reset();
        this.bipedBody.reset();
        this.bipedBreast.reset();
        this.bipedNeck.reset();
        this.bipedHead.reset();
        this.bipedHeadwear.reset();
        this.bipedEars.reset();
        this.bipedCloak.reset();
        this.bipedRightShoulder.reset();
        this.bipedRightArm.reset();
        this.bipedLeftShoulder.reset();
        this.bipedLeftArm.reset();
        this.bipedPelvic.reset();
        this.bipedRightLeg.reset();
        this.bipedLeftLeg.reset();
        this.bipedRightShoulder.setRotationPoint(-5.0f, 2.0f, 0.0f);
        this.bipedLeftShoulder.setRotationPoint(5.0f, 2.0f, 0.0f);
        this.bipedPelvic.setRotationPoint(0.0f, 12.0f, 0.0f);
        this.bipedRightLeg.setRotationPoint(-2.0f, 0.0f, 0.0f);
        this.bipedLeftLeg.setRotationPoint(2.0f, 0.0f, 0.0f);
        this.bipedCloak.setRotationPoint(0.0f, 0.0f, 2.0f);
    }

    public void renderCloak(float f) {
        this.attemptToCallRenderCape = true;
        if (!this.disabled) {
            this.imp.superRenderCloak(f);
        }
    }

    public ModelRenderer getRandomBox(Random random) {
        int n;
        List list = this.mp.boxList;
        int n2 = list.size();
        int n3 = 0;
        for (n = 0; n < n2; ++n) {
            ModelRenderer modelRenderer = (ModelRenderer)list.get(n);
            if (!SmartRenderModel.canBeRandomBoxSource(modelRenderer)) continue;
            ++n3;
        }
        if (n3 != 0) {
            n = random.nextInt(n3);
            n3 = -1;
            for (int i = 0; i < n2; ++i) {
                ModelRenderer modelRenderer = (ModelRenderer)list.get(i);
                if (SmartRenderModel.canBeRandomBoxSource(modelRenderer)) {
                    ++n3;
                }
                if (n3 != n) continue;
                return modelRenderer;
            }
        }
        return null;
    }

    private static boolean canBeRandomBoxSource(ModelRenderer modelRenderer) {
        return modelRenderer.cubeList != null && modelRenderer.cubeList.size() > 0 && (!(modelRenderer instanceof ModelRotationRenderer) || ((ModelRotationRenderer)modelRenderer).canBeRandomBoxSource());
    }
}

