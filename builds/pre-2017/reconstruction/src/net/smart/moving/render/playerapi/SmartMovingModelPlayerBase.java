/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.render.playerapi;

import api.player.model.ModelPlayerAPI;
import api.player.model.ModelPlayerBase;
import net.minecraft.client.model.ModelRenderer;
import net.smart.moving.render.IModelPlayer;
import net.smart.moving.render.SmartMovingModel;
import net.smart.render.playerapi.SmartRender;

public class SmartMovingModelPlayerBase
extends ModelPlayerBase
implements IModelPlayer {
    private SmartMovingModel model;

    public SmartMovingModelPlayerBase(ModelPlayerAPI modelPlayerAPI) {
        super(modelPlayerAPI);
    }

    @Override
    public void afterLocalConstructing(float f) {
        this.model = new SmartMovingModel(f, SmartRender.getPlayerBase(this.modelPlayer), this);
    }

    @Override
    public SmartMovingModel getMovingModel() {
        return this.model;
    }

    public void dynamicOverrideAnimateHeadRotation(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateHeadRotation(f, f2, f3, f4, f5, f6);
    }

    public void dynamicOverrideAnimateSleeping(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateSleeping(f, f2, f3, f4, f5, f6);
    }

    public void dynamicOverrideAnimateArmSwinging(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateArmSwinging(f, f2, f3, f4, f5, f6);
    }

    public void dynamicOverrideAnimateRiding(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateRiding(f, f2, f3, f4, f5, f6);
    }

    public void dynamicOverrideAnimateLeftArmItemHolding(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateLeftArmItemHolding(f, f2, f3, f4, f5, f6);
    }

    public void dynamicOverrideAnimateRightArmItemHolding(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateRightArmItemHolding(f, f2, f3, f4, f5, f6);
    }

    public void dynamicOverrideAnimateWorkingBody(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateWorkingBody(f, f2, f3, f4, f5, f6);
    }

    public void dynamicOverrideAnimateWorkingArms(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateWorkingArms(f, f2, f3, f4, f5, f6);
    }

    public void dynamicOverrideAnimateSneaking(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateSneaking(f, f2, f3, f4, f5, f6);
    }

    public void dynamicOverrideAnimateArms(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateArms(f, f2, f3, f4, f5, f6);
    }

    public void dynamicOverrideAnimateBowAiming(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateBowAiming(f, f2, f3, f4, f5, f6);
    }

    @Override
    public void superAnimateHeadRotation(float f, float f2, float f3, float f4, float f5, float f6) {
        super.dynamic("animateHeadRotation", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    @Override
    public void superAnimateSleeping(float f, float f2, float f3, float f4, float f5, float f6) {
        super.dynamic("animateSleeping", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    @Override
    public void superAnimateArmSwinging(float f, float f2, float f3, float f4, float f5, float f6) {
        super.dynamic("animateArmSwinging", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    @Override
    public void superAnimateRiding(float f, float f2, float f3, float f4, float f5, float f6) {
        super.dynamic("animateRiding", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    @Override
    public void superAnimateLeftArmItemHolding(float f, float f2, float f3, float f4, float f5, float f6) {
        super.dynamic("animateLeftArmItemHolding", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    @Override
    public void superAnimateRightArmItemHolding(float f, float f2, float f3, float f4, float f5, float f6) {
        super.dynamic("animateRightArmItemHolding", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    @Override
    public void superAnimateWorkingBody(float f, float f2, float f3, float f4, float f5, float f6) {
        super.dynamic("animateWorkingBody", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    @Override
    public void superAnimateWorkingArms(float f, float f2, float f3, float f4, float f5, float f6) {
        super.dynamic("animateWorkingArms", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    @Override
    public void superAnimateSneaking(float f, float f2, float f3, float f4, float f5, float f6) {
        super.dynamic("animateSneaking", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    @Override
    public void superApplyAnimationOffsets(float f, float f2, float f3, float f4, float f5, float f6) {
        super.dynamic("animateArms", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    @Override
    public void superAnimateBowAiming(float f, float f2, float f3, float f4, float f5, float f6) {
        super.dynamic("animateBowAiming", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    @Deprecated
    public ModelRenderer getOuter() {
        return this.model.md.bipedOuter;
    }

    @Deprecated
    public ModelRenderer getTorso() {
        return this.model.md.bipedTorso;
    }

    @Deprecated
    public ModelRenderer getBody() {
        return this.model.md.bipedBody;
    }

    @Deprecated
    public ModelRenderer getBreast() {
        return this.model.md.bipedBreast;
    }

    @Deprecated
    public ModelRenderer getNeck() {
        return this.model.md.bipedNeck;
    }

    @Deprecated
    public ModelRenderer getHead() {
        return this.model.md.bipedHead;
    }

    @Deprecated
    public ModelRenderer getHeadwear() {
        return this.model.md.bipedHeadwear;
    }

    @Deprecated
    public ModelRenderer getRightShoulder() {
        return this.model.md.bipedRightShoulder;
    }

    @Deprecated
    public ModelRenderer getRightArm() {
        return this.model.md.bipedRightArm;
    }

    @Deprecated
    public ModelRenderer getLeftShoulder() {
        return this.model.md.bipedLeftShoulder;
    }

    @Deprecated
    public ModelRenderer getLeftArm() {
        return this.model.md.bipedLeftArm;
    }

    @Deprecated
    public ModelRenderer getPelvic() {
        return this.model.md.bipedPelvic;
    }

    @Deprecated
    public ModelRenderer getRightLeg() {
        return this.model.md.bipedRightLeg;
    }

    @Deprecated
    public ModelRenderer getLeftLeg() {
        return this.model.md.bipedLeftLeg;
    }

    @Deprecated
    public ModelRenderer getEars() {
        return this.model.md.bipedEars;
    }

    @Deprecated
    public ModelRenderer getCloak() {
        return this.model.md.bipedCloak;
    }
}

