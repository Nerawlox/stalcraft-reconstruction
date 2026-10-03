/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import net.minecraft.client.xpzm;
import net.minecraft.entity.player.pidb;
import net.smart.moving.SmartMoving;

public interface IEntityPlayerSP {
    public SmartMoving getMoving();

    public boolean getSleepingField();

    public boolean getIsJumpingField();

    public boolean getIsInWebField();

    public void setIsInWebField(boolean var1);

    public xpzm getMcField();

    public void setMoveForwardField(float var1);

    public void setMoveStrafingField(float var1);

    public void setIsJumpingField(boolean var1);

    public void localMoveEntity(double var1, double var3, double var5);

    public pidb localSleepInBedAt(int var1, int var2, int var3);

    public float localGetBrightness(float var1);

    public int localGetBrightnessForRender(float var1);

    public void localUpdateEntityActionState();

    public boolean localIsInsideOfMaterial(tflj var1);

    public void localWriteEntityToNBT(qoac var1);

    public boolean localIsSneaking();

    public float localGetFOVMultiplier();
}

