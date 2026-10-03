/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EnumStatus;
import net.minecraft.nbt.NBTTagCompound;
import net.smart.moving.SmartMoving;

public interface IEntityPlayerSP {
    public SmartMoving getMoving();

    public boolean getSleepingField();

    public boolean getIsJumpingField();

    public boolean getIsInWebField();

    public void setIsInWebField(boolean var1);

    public Minecraft getMcField();

    public void setMoveForwardField(float var1);

    public void setMoveStrafingField(float var1);

    public void setIsJumpingField(boolean var1);

    public void localMoveEntity(double var1, double var3, double var5);

    public EnumStatus localSleepInBedAt(int var1, int var2, int var3);

    public float localGetBrightness(float var1);

    public int localGetBrightnessForRender(float var1);

    public void localUpdateEntityActionState();

    public boolean localIsInsideOfMaterial(Material var1);

    public void localWriteEntityToNBT(NBTTagCompound var1);

    public boolean localIsSneaking();

    public float localGetFOVMultiplier();
}

