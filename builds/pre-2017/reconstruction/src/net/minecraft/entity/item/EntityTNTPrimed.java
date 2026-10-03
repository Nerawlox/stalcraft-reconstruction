/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityTNTPrimed
extends Entity {
    public int fuse;
    public EntityLivingBase tntPlacedBy;

    public EntityTNTPrimed(World world) {
        super(world);
        this.preventEntitySpawning = true;
        this.setSize(0.98f, 0.98f);
        this.yOffset = this.height / 2.0f;
    }

    public EntityTNTPrimed(World world, double d, double d2, double d3, EntityLivingBase entityLivingBase) {
        this(world);
        this.setPosition(d, d2, d3);
        float f = (float)(Math.random() * 3.1415927410125732 * 2.0);
        this.motionX = -((float)Math.sin(f)) * 0.02f;
        this.motionY = 0.2f;
        this.motionZ = -((float)Math.cos(f)) * 0.02f;
        this.fuse = 80;
        this.prevPosX = d;
        this.prevPosY = d2;
        this.prevPosZ = d3;
        this.tntPlacedBy = entityLivingBase;
    }

    @Override
    public void entityInit() {
    }

    @Override
    public boolean canTriggerWalking() {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= (double)0.04f;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= (double)0.98f;
        this.motionY *= (double)0.98f;
        this.motionZ *= (double)0.98f;
        if (this.onGround) {
            this.motionX *= (double)0.7f;
            this.motionZ *= (double)0.7f;
            this.motionY *= -0.5;
        }
        if (this.fuse-- <= 0) {
            this.setDead();
            if (!this.worldObj.isRemote) {
                this.explode();
            }
        } else {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5, this.posZ, 0.0, 0.0, 0.0);
        }
    }

    public void explode() {
        float f = 4.0f;
        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, f, true);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Fuse", (byte)this.fuse);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.fuse = nBTTagCompound._d("Fuse");
    }

    @Override
    public float getShadowSize() {
        return 0.0f;
    }

    public EntityLivingBase getTntPlacedBy() {
        return this.tntPlacedBy;
    }
}

