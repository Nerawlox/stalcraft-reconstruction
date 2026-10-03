/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.playerapi;

import api.player.client.ClientPlayerAPI;
import api.player.client.ClientPlayerBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumStatus;
import net.minecraft.nbt.NBTTagCompound;
import net.smart.moving.IEntityPlayerSP;
import net.smart.moving.playerapi.SmartMovingSelf;

public class SmartMovingPlayerBase
extends ClientPlayerBase
implements IEntityPlayerSP {
    public SmartMovingSelf moving;

    public static void registerPlayerBase() {
        ClientPlayerAPI.register("Smart Moving", SmartMovingPlayerBase.class);
    }

    public static SmartMovingPlayerBase getPlayerBase(EntityPlayerSP entityPlayerSP) {
        return (SmartMovingPlayerBase)entityPlayerSP.getClientPlayerBase("Smart Moving");
    }

    public SmartMovingPlayerBase(ClientPlayerAPI clientPlayerAPI) {
        super(clientPlayerAPI);
        this.moving = new SmartMovingSelf((EntityPlayer)this.player, this);
    }

    @Override
    public void beforeMoveEntity(double d, double d2, double d3) {
        this.moving.beforeMoveEntity(d, d2, d3);
    }

    @Override
    public void afterMoveEntity(double d, double d2, double d3) {
        this.moving.afterMoveEntity(d, d2, d3);
    }

    @Override
    public void localMoveEntity(double d, double d2, double d3) {
        super.moveEntity(d, d2, d3);
    }

    @Override
    public void beforeSleepInBedAt(int n, int n2, int n3) {
    }

    @Override
    public EnumStatus localSleepInBedAt(int n, int n2, int n3) {
        return super.sleepInBedAt(n, n2, n3);
    }

    @Override
    public float getBrightness(float f) {
        return this.moving.getBrightness(f);
    }

    @Override
    public float localGetBrightness(float f) {
        return super.getBrightness(f);
    }

    @Override
    public int getBrightnessForRender(float f) {
        return this.moving.getBrightnessForRender(f);
    }

    @Override
    public int localGetBrightnessForRender(float f) {
        return super.getBrightnessForRender(f);
    }

    @Override
    public boolean pushOutOfBlocks(double d, double d2, double d3) {
        return this.moving.pushOutOfBlocks(d, d2, d3);
    }

    @Override
    public void beforeOnUpdate() {
        this.moving.beforeOnUpdate();
    }

    @Override
    public void afterOnUpdate() {
        this.moving.afterOnUpdate();
    }

    @Override
    public void beforeOnLivingUpdate() {
        this.moving.beforeOnLivingUpdate();
    }

    @Override
    public void afterOnLivingUpdate() {
        this.moving.afterOnLivingUpdate();
    }

    @Override
    public boolean getSleepingField() {
        return this.player.getSleepingField();
    }

    @Override
    public boolean getIsInWebField() {
        return this.player.getIsInWebField();
    }

    @Override
    public void setIsInWebField(boolean bl) {
        this.player.setIsInWebField(bl);
    }

    @Override
    public boolean getIsJumpingField() {
        return this.player.getIsJumpingField();
    }

    @Override
    public Minecraft getMcField() {
        return this.player.getMcField();
    }

    @Override
    public void moveEntityWithHeading(float f, float f2) {
        this.moving.moveEntityWithHeading(f, f2);
    }

    @Override
    public boolean canTriggerWalking() {
        return this.moving.anticheat._o();
    }

    @Override
    public boolean isOnLadder() {
        return this.moving.anticheat._p();
    }

    @Override
    public SmartMovingSelf getMoving() {
        return this.moving;
    }

    @Override
    public void updateEntityActionState() {
        this.moving.updateEntityActionState(false);
    }

    @Override
    public void localUpdateEntityActionState() {
        super.updateEntityActionState();
    }

    @Override
    public void setIsJumpingField(boolean bl) {
        this.player.setIsJumpingField(bl);
    }

    @Override
    public void setMoveForwardField(float f) {
        this.player.moveForward = f;
    }

    @Override
    public void setMoveStrafingField(float f) {
        this.player.moveStrafing = f;
    }

    @Override
    public boolean isInsideOfMaterial(Material material) {
        return this.moving.isInsideOfMaterial(material);
    }

    @Override
    public boolean localIsInsideOfMaterial(Material material) {
        return super.isInsideOfMaterial(material);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        this.moving.writeEntityToNBT(nBTTagCompound);
    }

    @Override
    public void localWriteEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
    }

    @Override
    public boolean isSneaking() {
        return this.moving.anticheat._x();
    }

    @Override
    public boolean localIsSneaking() {
        return super.isSneaking();
    }

    @Override
    public float getFOVMultiplier() {
        return this.moving.getFOVMultiplier();
    }

    @Override
    public float localGetFOVMultiplier() {
        return this.player.localGetFOVMultiplier();
    }

    @Override
    public void beforeSetPositionAndRotation(double d, double d2, double d3, float f, float f2) {
        this.moving.beforeSetPositionAndRotation();
    }

    @Override
    public void beforeGetSleepTimer() {
        this.moving.beforeGetSleepTimer();
    }

    @Override
    public void jump() {
        this.moving.jump();
    }
}

