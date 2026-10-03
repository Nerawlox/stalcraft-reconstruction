/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.stalker.misc.tupg;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.ForgeHooksClient;
import net.smart.moving.Button;
import net.smart.moving.IEntityPlayerSP;
import net.smart.moving.SmartMoving;
import net.smart.moving.SmartMovingContext;

public class SmartMovingSelf
extends SmartMoving {
    public float exhaustion = 0.0f;
    public float jumpCharge;
    public float headJumpCharge;
    public float maxExhaustionForAction;
    public float maxExhaustionToStartAction;
    public final Button forwardButton = new Button();
    public final Button leftButton = new Button();
    public final Button rightButton = new Button();
    public final Button backButton = new Button();
    public final Button jumpButton = new Button();
    public final Button sneakButton = new Button();
    public final Button grabButton = new Button();
    public final Button sprintButton = new Button();
    public final Button crawlButton = new Button();
    private float landMovementFactor = 0.1f;
    private float staminaBonus = 1.0f;
    private float staminaRegenBonus = 1.0f;
    public tvcu anticheat = new tvcu(this.sp);

    public SmartMovingSelf(EntityPlayer entityPlayer, IEntityPlayerSP iEntityPlayerSP) {
        super(entityPlayer, iEntityPlayerSP);
    }

    public void moveEntityWithHeading(float f, float f2) {
    }

    public void beforeMoveEntity(double d, double d2, double d3) {
    }

    public void afterMoveEntity(double d, double d2, double d3) {
    }

    public void beforeOnUpdate() {
    }

    public void afterOnUpdate() {
    }

    public void beforeOnLivingUpdate() {
    }

    public void afterOnLivingUpdate() {
    }

    public void beforeSetPositionAndRotation() {
    }

    public boolean pushOutOfBlocks(double d, double d2, double d3) {
        return false;
    }

    public float getBrightness(float f) {
        this.sp.posY -= (double)this.anticheat._z;
        float f2 = this.isp.localGetBrightness(f);
        this.sp.posY += (double)this.anticheat._z;
        return f2;
    }

    public int getBrightnessForRender(float f) {
        this.sp.posY -= (double)this.anticheat._z;
        int n = this.isp.localGetBrightnessForRender(f);
        this.sp.posY += (double)this.anticheat._z;
        return n;
    }

    @ezey(_a={eidj.CLIENT})
    public void updateClient() {
        this.isp.localUpdateEntityActionState();
        this.isp.setMoveStrafingField(Math.signum(this.esp.movementInput._a));
        this.isp.setMoveForwardField(Math.signum(this.esp.movementInput._b));
        this.isp.setIsJumpingField(!(!this.esp.movementInput._c || this.anticheat._t || this.anticheat._u || SmartMovingContext.Config.isHeadJumpingEnabled() && this.grabButton.Pressed && this.anticheat.__aU._g() || SmartMovingContext.Config.isJumpChargingEnabled() && this.anticheat._I && this.anticheat.__aU._x && this.anticheat._H || this.anticheat.__aj));
        this.landMovementFactor = ncwh._a((EntityPlayer)this.sp)._k._b().floatValue();
        tupg tupg2 = tupg._a(this.sp);
        this.staminaBonus = tupg2._e._b().floatValue();
        this.staminaRegenBonus = tupg2._f._b().floatValue();
        Minecraft minecraft = Minecraft._E();
        GameSettings gameSettings = minecraft._M;
        this.forwardButton.update(gameSettings.keyBindForward);
        this.leftButton.update(gameSettings.keyBindLeft);
        this.rightButton.update(gameSettings.keyBindRight);
        this.backButton.update(gameSettings.keyBindBack);
        this.jumpButton.update(this.esp.movementInput._c);
        this.sprintButton.update(SmartMovingContext.Options.keyBindSprint);
        this.sneakButton.update(this.esp.movementInput._d);
        this.grabButton.update(SmartMovingContext.Options.keyBindGrab);
        this.crawlButton.update(SmartMovingContext.Options.keyBindCrawl);
        boolean bl = jzcs._d;
        flys flys2 = new flys(this.forwardButton.Pressed, this.leftButton.Pressed, this.rightButton.Pressed, this.backButton.Pressed, this.jumpButton.Pressed, this.sprintButton.Pressed, this.sneakButton.Pressed, this.grabButton.Pressed, Math.signum(this.esp.movementInput._b), Math.signum(this.esp.movementInput._a), bl, this.crawlButton.Pressed);
        boolean bl2 = minecraft._B != null && !minecraft._B.allowUserInput;
        int n = this.sp.getItemInUse() == null ? 0 : this.sp.getItemInUse()._d;
        boolean bl3 = this.sp.isSneaking();
        this.anticheat._a(flys2, bl3, n, bl2, this.getLandMovementFactor(), this.staminaBonus, this.staminaRegenBonus);
        this.anticheat.__aU._c();
        this.anticheat._a(this);
        InvokeSideOnly.client(() -> new ccpx(flys2, bl3, this.getLandMovementFactor(), n, bl2, this.staminaBonus, this.staminaRegenBonus).sendToServer());
    }

    public void updateEntityActionState(boolean bl) {
        InvokeSideOnly.client(() -> this.updateClient());
    }

    public boolean isRunning() {
        return this.sp.isSprinting() && !this.isFast && this.sp.onGround;
    }

    public void beforeGetSleepTimer() {
    }

    public void jump() {
        this.anticheat._A();
    }

    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        this.isp.localWriteEntityToNBT(nBTTagCompound);
        NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("abilities");
        if (nBTTagCompound2 != null && nBTTagCompound2._c("flying")) {
            nBTTagCompound2._a("flying", this.sp.capabilities._b);
        }
    }

    @Override
    public boolean isJumping() {
        return this.isp.getIsJumpingField();
    }

    @Override
    public boolean doFlyingAnimation() {
        return this.anticheat._C();
    }

    @Override
    public boolean doFallingAnimation() {
        return this.anticheat._D();
    }

    @Override
    public double getOverGroundHeight(double d) {
        return this.anticheat._a(d);
    }

    @Override
    public int getOverGroundBlockId(double d) {
        return this.anticheat._b(d);
    }

    public float getFOVMultiplier() {
        return ForgeHooksClient.getOffsetFOV((EntityPlayerSP)this.sp, 1.0f);
    }

    public float getLandMovementFactor() {
        return this.landMovementFactor;
    }
}

