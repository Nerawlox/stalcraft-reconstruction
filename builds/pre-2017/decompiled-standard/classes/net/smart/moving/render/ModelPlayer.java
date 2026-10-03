/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.render;

import net.smart.moving.render.IModelPlayer;
import net.smart.moving.render.SmartMovingModel;

public class ModelPlayer
extends net.smart.render.ModelPlayer
implements IModelPlayer {
    private final SmartMovingModel model;

    public ModelPlayer(float f) {
        super(f);
        this.model = new SmartMovingModel(f, this, this);
    }

    @Override
    public SmartMovingModel getMovingModel() {
        return this.model;
    }

    @Override
    public void animateHeadRotation(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateHeadRotation(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void animateSleeping(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateSleeping(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void animateArmSwinging(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateArmSwinging(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void animateRiding(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateRiding(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void animateLeftArmItemHolding(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateLeftArmItemHolding(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void animateRightArmItemHolding(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateRightArmItemHolding(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void animateWorkingBody(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateWorkingBody(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void animateWorkingArms(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateWorkingArms(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void animateSneaking(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateSneaking(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void animateArms(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateArms(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void animateBowAiming(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateBowAiming(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void superAnimateHeadRotation(float f, float f2, float f3, float f4, float f5, float f6) {
        super.animateHeadRotation(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void superAnimateSleeping(float f, float f2, float f3, float f4, float f5, float f6) {
        super.animateSleeping(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void superAnimateArmSwinging(float f, float f2, float f3, float f4, float f5, float f6) {
        super.animateArmSwinging(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void superAnimateRiding(float f, float f2, float f3, float f4, float f5, float f6) {
        super.animateRiding(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void superAnimateLeftArmItemHolding(float f, float f2, float f3, float f4, float f5, float f6) {
        super.animateLeftArmItemHolding(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void superAnimateRightArmItemHolding(float f, float f2, float f3, float f4, float f5, float f6) {
        super.animateRightArmItemHolding(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void superAnimateWorkingBody(float f, float f2, float f3, float f4, float f5, float f6) {
        super.animateWorkingBody(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void superAnimateWorkingArms(float f, float f2, float f3, float f4, float f5, float f6) {
        super.animateWorkingArms(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void superAnimateSneaking(float f, float f2, float f3, float f4, float f5, float f6) {
        super.animateSneaking(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void superApplyAnimationOffsets(float f, float f2, float f3, float f4, float f5, float f6) {
        super.animateArms(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void superAnimateBowAiming(float f, float f2, float f3, float f4, float f5, float f6) {
        super.animateBowAiming(f, f2, f3, f4, f5, f6);
    }
}

