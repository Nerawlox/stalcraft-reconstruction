/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.smart.render.SmartRenderModel;

public interface IModelPlayer {
    public SmartRenderModel getRenderModel();

    public void initialize(ModelRenderer var1, ModelRenderer var2, ModelRenderer var3, ModelRenderer var4, ModelRenderer var5, ModelRenderer var6, ModelRenderer var7, ModelRenderer var8, ModelRenderer var9);

    public void superRender(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7);

    public void superSetRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7);

    public void superRenderCloak(float var1);

    public ModelRenderer getOuter();

    public ModelRenderer getTorso();

    public ModelRenderer getBody();

    public ModelRenderer getBreast();

    public ModelRenderer getNeck();

    public ModelRenderer getHead();

    public ModelRenderer getHeadwear();

    public ModelRenderer getRightShoulder();

    public ModelRenderer getRightArm();

    public ModelRenderer getLeftShoulder();

    public ModelRenderer getLeftArm();

    public ModelRenderer getPelvic();

    public ModelRenderer getRightLeg();

    public ModelRenderer getLeftLeg();

    public ModelRenderer getEars();

    public ModelRenderer getCloak();

    public void animateHeadRotation(float var1, float var2, float var3, float var4, float var5, float var6);

    public void animateSleeping(float var1, float var2, float var3, float var4, float var5, float var6);

    public void animateArmSwinging(float var1, float var2, float var3, float var4, float var5, float var6);

    public void animateRiding(float var1, float var2, float var3, float var4, float var5, float var6);

    public void animateLeftArmItemHolding(float var1, float var2, float var3, float var4, float var5, float var6);

    public void animateRightArmItemHolding(float var1, float var2, float var3, float var4, float var5, float var6);

    public void animateWorkingBody(float var1, float var2, float var3, float var4, float var5, float var6);

    public void animateWorkingArms(float var1, float var2, float var3, float var4, float var5, float var6);

    public void animateSneaking(float var1, float var2, float var3, float var4, float var5, float var6);

    public void animateArms(float var1, float var2, float var3, float var4, float var5, float var6);

    public void animateBowAiming(float var1, float var2, float var3, float var4, float var5, float var6);
}

