/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render.playerapi;

import api.player.model.ModelPlayerAPI;
import api.player.model.ModelPlayerBase;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.util.Random;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.smart.render.IModelPlayer;
import net.smart.render.SmartRenderModel;

public class SmartRenderModelPlayerBase
extends ModelPlayerBase
implements IModelPlayer,
vkmy {
    private SmartRenderModel model;

    public SmartRenderModelPlayerBase(ModelPlayerAPI modelPlayerAPI) {
        super(modelPlayerAPI);
    }

    @Override
    public void afterLocalConstructing(float f) {
        this.model = new SmartRenderModel(f, this.modelPlayer, this);
    }

    @Override
    public SmartRenderModel getRenderModel() {
        return this.model;
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
    public void initialize(ModelRenderer modelRenderer, ModelRenderer modelRenderer2, ModelRenderer modelRenderer3, ModelRenderer modelRenderer4, ModelRenderer modelRenderer5, ModelRenderer modelRenderer6, ModelRenderer modelRenderer7, ModelRenderer modelRenderer8, ModelRenderer modelRenderer9) {
        this.modelPlayer.field_78115_e = modelRenderer;
        this.modelPlayer.field_78122_k = modelRenderer2;
        this.modelPlayer.field_78116_c = modelRenderer3;
        this.modelPlayer.field_78121_j = modelRenderer4;
        this.modelPlayer.field_78114_d = modelRenderer5;
        this.modelPlayer.field_78112_f = modelRenderer6;
        this.modelPlayer.field_78113_g = modelRenderer7;
        this.modelPlayer.field_78123_h = modelRenderer8;
        this.modelPlayer.field_78124_i = modelRenderer9;
    }

    @Override
    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        this.model.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        if (entity instanceof EntityPlayer) {
            InvokeSideOnly.client(() -> {
                ncux ncux2 = ncux._p;
                ncux2._a((EntityPlayer)entity, this.model.mp, f, f2, f3, f4, f5, f6, this.model.bipedBody, this.model.bipedHead, this.model.bipedRightArm, this.model.bipedLeftArm, this.model.bipedRightLeg, this.model.bipedLeftLeg, this);
                MinecraftForge.EVENT_BUS.post(ncux2);
            });
        }
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
        this.modelPlayer.dynamic("animateHeadRotation", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    public void dynamicVirtualAnimateHeadRotation(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateHeadRotation(f4, f5);
    }

    @Override
    public void animateSleeping(float f, float f2, float f3, float f4, float f5, float f6) {
        this.modelPlayer.dynamic("animateSleeping", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    public void dynamicVirtualAnimateSleeping(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateSleeping();
    }

    @Override
    public void animateArmSwinging(float f, float f2, float f3, float f4, float f5, float f6) {
        this.modelPlayer.dynamic("animateArmSwinging", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    public void dynamicVirtualAnimateArmSwinging(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateArmSwinging(f, f2);
    }

    @Override
    public void animateRiding(float f, float f2, float f3, float f4, float f5, float f6) {
        this.modelPlayer.dynamic("animateRiding", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    public void dynamicVirtualAnimateRiding(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateRiding();
    }

    @Override
    public void animateLeftArmItemHolding(float f, float f2, float f3, float f4, float f5, float f6) {
        this.modelPlayer.dynamic("animateLeftArmItemHolding", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    public void dynamicVirtualAnimateLeftArmItemHolding(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateLeftArmItemHolding();
    }

    @Override
    public void animateRightArmItemHolding(float f, float f2, float f3, float f4, float f5, float f6) {
        this.modelPlayer.dynamic("animateRightArmItemHolding", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    public void dynamicVirtualAnimateRightArmItemHolding(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateRightArmItemHolding();
    }

    @Override
    public void animateWorkingBody(float f, float f2, float f3, float f4, float f5, float f6) {
        this.modelPlayer.dynamic("animateWorkingBody", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    public void dynamicVirtualAnimateWorkingBody(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateWorkingBody();
    }

    @Override
    public void animateWorkingArms(float f, float f2, float f3, float f4, float f5, float f6) {
        this.modelPlayer.dynamic("animateWorkingArms", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    public void dynamicVirtualAnimateWorkingArms(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateWorkingArms();
    }

    @Override
    public void animateSneaking(float f, float f2, float f3, float f4, float f5, float f6) {
        this.modelPlayer.dynamic("animateSneaking", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    public void dynamicVirtualAnimateSneaking(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateSneaking();
    }

    @Override
    public void animateArms(float f, float f2, float f3, float f4, float f5, float f6) {
        this.modelPlayer.dynamic("animateArms", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    public void dynamicVirtualAnimateArms(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateArms(f3);
    }

    @Override
    public void animateBowAiming(float f, float f2, float f3, float f4, float f5, float f6) {
        this.modelPlayer.dynamic("animateBowAiming", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)});
    }

    public void dynamicVirtualAnimateBowAiming(float f, float f2, float f3, float f4, float f5, float f6) {
        this.model.animateBowAiming(f3);
    }

    @Override
    public void rotate(float f, float f2, float f3, float f4, float f5, float f6, EntityPlayer entityPlayer) {
        this.setRotationAngles(f, f2, f3, f4, f5, f6, entityPlayer);
    }
}

