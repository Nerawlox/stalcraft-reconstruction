/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityEnderEye
extends Entity {
    public double targetX;
    public double targetY;
    public double targetZ;
    public int despawnTimer;
    public boolean shatterOrDrop;

    public EntityEnderEye(World world) {
        super(world);
        this.setSize(0.25f, 0.25f);
    }

    @Override
    public void entityInit() {
    }

    @Override
    public boolean isInRangeToRenderDist(double d) {
        double d2 = this.boundingBox._b() * 4.0;
        return d < (d2 *= 64.0) * d2;
    }

    public EntityEnderEye(World world, double d, double d2, double d3) {
        super(world);
        this.despawnTimer = 0;
        this.setSize(0.25f, 0.25f);
        this.setPosition(d, d2, d3);
        this.yOffset = 0.0f;
    }

    public void moveTowards(double d, int n, double d2) {
        double d3 = d - this.posX;
        double d4 = d2 - this.posZ;
        float f = sajh._a(d3 * d3 + d4 * d4);
        if (f > 12.0f) {
            this.targetX = this.posX + d3 / (double)f * 12.0;
            this.targetZ = this.posZ + d4 / (double)f * 12.0;
            this.targetY = this.posY + 8.0;
        } else {
            this.targetX = d;
            this.targetY = n;
            this.targetZ = d2;
        }
        this.despawnTimer = 0;
        this.shatterOrDrop = this.rand.nextInt(5) > 0;
    }

    @Override
    public void setVelocity(double d, double d2, double d3) {
        this.motionX = d;
        this.motionY = d2;
        this.motionZ = d3;
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            float f = sajh._a(d * d + d3 * d3);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(d, d3) * 180.0 / 3.1415927410125732);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(d2, f) * 180.0 / 3.1415927410125732);
        }
    }

    @Override
    public void onUpdate() {
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        super.onUpdate();
        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        float f = sajh._a(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.1415927410125732);
        this.rotationPitch = (float)(Math.atan2(this.motionY, f) * 180.0 / 3.1415927410125732);
        while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
            this.prevRotationPitch -= 360.0f;
        }
        while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
            this.prevRotationPitch += 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
            this.prevRotationYaw -= 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
            this.prevRotationYaw += 360.0f;
        }
        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2f;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2f;
        if (!this.worldObj.isRemote) {
            double d = this.targetX - this.posX;
            double d2 = this.targetZ - this.posZ;
            float f2 = (float)Math.sqrt(d * d + d2 * d2);
            float f3 = (float)Math.atan2(d2, d);
            double d3 = (double)f + (double)(f2 - f) * 0.0025;
            if (f2 < 1.0f) {
                d3 *= 0.8;
                this.motionY *= 0.8;
            }
            this.motionX = Math.cos(f3) * d3;
            this.motionZ = Math.sin(f3) * d3;
            this.motionY = this.posY < this.targetY ? (this.motionY += (1.0 - this.motionY) * (double)0.015f) : (this.motionY += (-1.0 - this.motionY) * (double)0.015f);
        }
        float f4 = 0.25f;
        if (this.isInWater()) {
            for (int i = 0; i < 4; ++i) {
                this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f4, this.posY - this.motionY * (double)f4, this.posZ - this.motionZ * (double)f4, this.motionX, this.motionY, this.motionZ);
            }
        } else {
            this.worldObj.spawnParticle("portal", this.posX - this.motionX * (double)f4 + this.rand.nextDouble() * 0.6 - 0.3, this.posY - this.motionY * (double)f4 - 0.5, this.posZ - this.motionZ * (double)f4 + this.rand.nextDouble() * 0.6 - 0.3, this.motionX, this.motionY, this.motionZ);
        }
        if (!this.worldObj.isRemote) {
            this.setPosition(this.posX, this.posY, this.posZ);
            ++this.despawnTimer;
            if (this.despawnTimer > 80 && !this.worldObj.isRemote) {
                this.setDead();
                if (this.shatterOrDrop) {
                    this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(Item.eyeOfEnder)));
                } else {
                    this.worldObj.playAuxSFX(2003, (int)Math.round(this.posX), (int)Math.round(this.posY), (int)Math.round(this.posZ), 0);
                }
            }
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public float getShadowSize() {
        return 0.0f;
    }

    @Override
    public float getBrightness(float f) {
        return 1.0f;
    }

    @Override
    public int getBrightnessForRender(float f) {
        return 0xF000F0;
    }

    @Override
    public boolean canAttackWithItem() {
        return false;
    }
}

