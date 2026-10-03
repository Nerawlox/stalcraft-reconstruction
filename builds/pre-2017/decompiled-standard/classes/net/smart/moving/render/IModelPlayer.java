/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.render;

import net.smart.moving.render.SmartMovingModel;

public interface IModelPlayer {
    public SmartMovingModel getMovingModel();

    public void superAnimateHeadRotation(float var1, float var2, float var3, float var4, float var5, float var6);

    public void superAnimateSleeping(float var1, float var2, float var3, float var4, float var5, float var6);

    public void superAnimateArmSwinging(float var1, float var2, float var3, float var4, float var5, float var6);

    public void superAnimateRiding(float var1, float var2, float var3, float var4, float var5, float var6);

    public void superAnimateLeftArmItemHolding(float var1, float var2, float var3, float var4, float var5, float var6);

    public void superAnimateRightArmItemHolding(float var1, float var2, float var3, float var4, float var5, float var6);

    public void superAnimateWorkingBody(float var1, float var2, float var3, float var4, float var5, float var6);

    public void superAnimateWorkingArms(float var1, float var2, float var3, float var4, float var5, float var6);

    public void superAnimateSneaking(float var1, float var2, float var3, float var4, float var5, float var6);

    public void superApplyAnimationOffsets(float var1, float var2, float var3, float var4, float var5, float var6);

    public void superAnimateBowAiming(float var1, float var2, float var3, float var4, float var5, float var6);
}

