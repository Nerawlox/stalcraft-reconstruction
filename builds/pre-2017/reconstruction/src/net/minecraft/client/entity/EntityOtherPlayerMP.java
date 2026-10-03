/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

@SideOnly(value=Side.CLIENT)
public class EntityOtherPlayerMP
extends AbstractClientPlayer {
    public boolean isItemInUse;
    public int otherPlayerMPPosRotationIncrements;
    public double otherPlayerMPX;
    public double otherPlayerMPY;
    public double otherPlayerMPZ;
    public double otherPlayerMPYaw;
    public double otherPlayerMPPitch;

    public EntityOtherPlayerMP(World world, String string) {
        super(world, string);
        this.yOffset = 0.0f;
        this.stepHeight = 0.0f;
        this.noClip = true;
        this.field_71082_cx = 0.25f;
        this.renderDistanceWeight = 10.0;
    }

    @Override
    public void resetHeight() {
        this.yOffset = 0.0f;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        return true;
    }

    @Override
    public void setPositionAndRotation2(double d, double d2, double d3, float f, float f2, int n) {
        this.otherPlayerMPX = d;
        this.otherPlayerMPY = d2;
        this.otherPlayerMPZ = d3;
        this.otherPlayerMPYaw = f;
        this.otherPlayerMPPitch = f2;
        this.otherPlayerMPPosRotationIncrements = n;
    }

    @Override
    public void onUpdate() {
        this.field_71082_cx = 0.0f;
        super.onUpdate();
        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d = this.posX - this.prevPosX;
        double d2 = this.posZ - this.prevPosZ;
        float f = sajh._a(d * d + d2 * d2) * 4.0f;
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.limbSwingAmount += (f - this.limbSwingAmount) * 0.4f;
        this.limbSwing += this.limbSwingAmount;
        if (!this.isItemInUse && this.isEating() && this.inventory._a[this.inventory._c] != null) {
            ItemStack itemStack = this.inventory._a[this.inventory._c];
            this.setItemInUse(this.inventory._a[this.inventory._c], Item.itemsList[itemStack._d].getMaxItemUseDuration(itemStack));
            this.isItemInUse = true;
        } else if (this.isItemInUse && !this.isEating()) {
            this.clearItemInUse();
            this.isItemInUse = false;
        }
    }

    @Override
    public float getShadowSize() {
        return 0.0f;
    }

    @Override
    public void onLivingUpdate() {
        super.updateEntityActionState();
        if (this.otherPlayerMPPosRotationIncrements > 0) {
            double d;
            double d2 = this.posX + (this.otherPlayerMPX - this.posX) / (double)this.otherPlayerMPPosRotationIncrements;
            double d3 = this.posY + (this.otherPlayerMPY - this.posY) / (double)this.otherPlayerMPPosRotationIncrements;
            double d4 = this.posZ + (this.otherPlayerMPZ - this.posZ) / (double)this.otherPlayerMPPosRotationIncrements;
            for (d = this.otherPlayerMPYaw - (double)this.rotationYaw; d < -180.0; d += 360.0) {
            }
            while (d >= 180.0) {
                d -= 360.0;
            }
            this.rotationYaw = (float)((double)this.rotationYaw + d / (double)this.otherPlayerMPPosRotationIncrements);
            this.rotationPitch = (float)((double)this.rotationPitch + (this.otherPlayerMPPitch - (double)this.rotationPitch) / (double)this.otherPlayerMPPosRotationIncrements);
            --this.otherPlayerMPPosRotationIncrements;
            this.setPosition(d2, d3, d4);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }
        this.prevCameraYaw = this.cameraYaw;
        float f = sajh._a(this.motionX * this.motionX + this.motionZ * this.motionZ);
        float f2 = (float)Math.atan(-this.motionY * (double)0.2f) * 15.0f;
        if (f > 0.1f) {
            f = 0.1f;
        }
        if (!this.onGround || this.getHealth() <= 0.0f) {
            f = 0.0f;
        }
        if (this.onGround || this.getHealth() <= 0.0f) {
            f2 = 0.0f;
        }
        this.cameraYaw += (f - this.cameraYaw) * 0.4f;
        this.cameraPitch += (f2 - this.cameraPitch) * 0.8f;
    }

    @Override
    public void setCurrentItemOrArmor(int n, ItemStack itemStack) {
        if (n == 0) {
            this.inventory._a[this.inventory._c] = itemStack;
        } else {
            this.inventory._b[n - 1] = itemStack;
        }
    }

    @Override
    public float getDefaultEyeHeight() {
        return 1.82f;
    }

    @Override
    public void sendChatToPlayer(ChatMessageComponent chatMessageComponent) {
        Minecraft._E()._J.getChatGUI()._a(chatMessageComponent._a(true));
    }

    @Override
    public boolean canCommandSenderUseCommand(int n, String string) {
        return false;
    }

    @Override
    public ChunkCoordinates func_82114_b() {
        return new ChunkCoordinates(sajh._c(this.posX + 0.5), sajh._c(this.posY + 0.5), sajh._c(this.posZ + 0.5));
    }
}

