/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render;

import java.util.Random;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.smart.render.IModelPlayer;
import net.smart.render.SmartRenderModel;

public class ModelPlayer
extends ModelBiped
implements IModelPlayer {
    private final SmartRenderModel model;

    public ModelPlayer(float f) {
        super(f);
        this.model = new SmartRenderModel(f, this, this);
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.render(entity, f, f2, f3, f4, f5, f6);
    }

    @Override
    public void superRender(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        super.render(entity, f, f2, f3, f4, f5, f6);
    }

    @Override
    public SmartRenderModel getRenderModel() {
        return this.model;
    }

    @Override
    public void initialize(ModelRenderer modelRenderer, ModelRenderer modelRenderer2, ModelRenderer modelRenderer3, ModelRenderer modelRenderer4, ModelRenderer modelRenderer5, ModelRenderer modelRenderer6, ModelRenderer modelRenderer7, ModelRenderer modelRenderer8, ModelRenderer modelRenderer9) {
        this.bipedBody = modelRenderer;
        this.bipedCloak = modelRenderer2;
        this.bipedHead = modelRenderer3;
        this.bipedEars = modelRenderer4;
        this.bipedHeadwear = modelRenderer5;
        this.bipedRightArm = modelRenderer6;
        this.bipedLeftArm = modelRenderer7;
        this.bipedRightLeg = modelRenderer8;
        this.bipedLeftLeg = modelRenderer9;
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        this.model.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
    }

    @Override
    public void superSetRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        super.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
    }

    @Override
    public void renderCloak(float f) {
        this.model.renderCloak(f);
    }

    @Override
    public void superRenderCloak(float f) {
        super.renderCloak(f);
    }

    @Override
    public ModelRenderer getRandomModelBox(Random random) {
        return this.model.getRandomBox(random);
    }

    @Override
    public ModelRenderer getOuter() {
        return this.model.bipedOuter;
    }

    @Override
    public ModelRenderer getTorso() {
        return this.model.bipedTorso;
    }

    @Override
    public ModelRenderer getBody() {
        return this.model.bipedBody;
    }

    @Override
    public ModelRenderer getBreast() {
        return this.model.bipedBreast;
    }

    @Override
    public ModelRenderer getNeck() {
        return this.model.bipedNeck;
    }

    @Override
    public ModelRenderer getHead() {
        return this.model.bipedHead;
    }

    @Override
    public ModelRenderer getHeadwear() {
        return this.model.bipedHeadwear;
    }

    @Override
    public ModelRenderer getRightShoulder() {
        return this.model.bipedRightShoulder;
    }

    @Override
    public ModelRenderer getRightArm() {
        return this.model.bipedRightArm;
    }

    @Override
    public ModelRenderer getLeftShoulder() {
        return this.model.bipedLeftShoulder;
    }

    @Override
    public ModelRenderer getLeftArm() {
        return this.model.bipedLeftArm;
    }

    @Override
    public ModelRenderer getPelvic() {
        return this.model.bipedPelvic;
    }

    @Override
    public ModelRenderer getRightLeg() {
        return this.model.bipedRightLeg;
    }

    @Override
    public ModelRenderer getLeftLeg() {
        return this.model.bipedLeftLeg;
    }

    @Override
    public ModelRenderer getEars() {
        return this.model.bipedEars;
    }

    @Override
    public ModelRenderer getCloak() {
        return this.model.bipedCloak;
    }

    @Override
    public void animateHeadRotation(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateHeadRotation(f4, f5);
    }

    @Override
    public void animateSleeping(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateSleeping();
    }

    @Override
    public void animateArmSwinging(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateArmSwinging(f, f2);
    }

    @Override
    public void animateRiding(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateRiding();
    }

    @Override
    public void animateLeftArmItemHolding(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateLeftArmItemHolding();
    }

    @Override
    public void animateRightArmItemHolding(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateRightArmItemHolding();
    }

    @Override
    public void animateWorkingBody(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateWorkingBody();
    }

    @Override
    public void animateWorkingArms(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateWorkingArms();
    }

    @Override
    public void animateSneaking(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateSneaking();
    }

    @Override
    public void animateArms(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateArms(f3);
    }

    @Override
    public void animateBowAiming(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateBowAiming(f3);
    }
}

