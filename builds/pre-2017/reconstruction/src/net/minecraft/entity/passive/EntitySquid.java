/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntitySquid
extends EntityWaterMob {
    public float squidPitch;
    public float prevSquidPitch;
    public float squidYaw;
    public float prevSquidYaw;
    public float squidRotation;
    public float prevSquidRotation;
    public float tentacleAngle;
    public float field_70865_by;
    public float randomMotionSpeed;
    public float rotationVelocity;
    public float field_70871_bB;
    public float randomMotionVecX;
    public float randomMotionVecY;
    public float randomMotionVecZ;

    public EntitySquid(World world) {
        super(world);
        this.setSize(0.95f, 0.95f);
        this.rotationVelocity = 1.0f / (this.rand.nextFloat() + 1.0f) * 0.2f;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(10.0);
    }

    @Override
    public String getLivingSound() {
        return null;
    }

    @Override
    public String getHurtSound() {
        return null;
    }

    @Override
    public String getDeathSound() {
        return null;
    }

    @Override
    public float getSoundVolume() {
        return 0.4f;
    }

    @Override
    public int getDropItemId() {
        return 0;
    }

    @Override
    public boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void dropFewItems(boolean bl, int n) {
        int n2 = this.rand.nextInt(3 + n) + 1;
        for (int i = 0; i < n2; ++i) {
            this.entityDropItem(new ItemStack(Item.dyePowder, 1, 0), 0.0f);
        }
    }

    @Override
    public boolean isInWater() {
        return this.worldObj.handleMaterialAcceleration(this.boundingBox._b(0.0, -0.6f, 0.0), Material._h, this);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.prevSquidPitch = this.squidPitch;
        this.prevSquidYaw = this.squidYaw;
        this.prevSquidRotation = this.squidRotation;
        this.field_70865_by = this.tentacleAngle;
        this.squidRotation += this.rotationVelocity;
        if (this.squidRotation > (float)Math.PI * 2) {
            this.squidRotation -= (float)Math.PI * 2;
            if (this.rand.nextInt(10) == 0) {
                this.rotationVelocity = 1.0f / (this.rand.nextFloat() + 1.0f) * 0.2f;
            }
        }
        if (this.isInWater()) {
            float f;
            if (this.squidRotation < (float)Math.PI) {
                f = this.squidRotation / (float)Math.PI;
                this.tentacleAngle = sajh._a(f * f * (float)Math.PI) * (float)Math.PI * 0.25f;
                if ((double)f > 0.75) {
                    this.randomMotionSpeed = 1.0f;
                    this.field_70871_bB = 1.0f;
                } else {
                    this.field_70871_bB *= 0.8f;
                }
            } else {
                this.tentacleAngle = 0.0f;
                this.randomMotionSpeed *= 0.9f;
                this.field_70871_bB *= 0.99f;
            }
            if (!this.worldObj.isRemote) {
                this.motionX = this.randomMotionVecX * this.randomMotionSpeed;
                this.motionY = this.randomMotionVecY * this.randomMotionSpeed;
                this.motionZ = this.randomMotionVecZ * this.randomMotionSpeed;
            }
            f = sajh._a(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.renderYawOffset += (-((float)Math.atan2(this.motionX, this.motionZ)) * 180.0f / (float)Math.PI - this.renderYawOffset) * 0.1f;
            this.rotationYaw = this.renderYawOffset;
            this.squidYaw += (float)Math.PI * this.field_70871_bB * 1.5f;
            this.squidPitch += (-((float)Math.atan2(f, this.motionY)) * 180.0f / (float)Math.PI - this.squidPitch) * 0.1f;
        } else {
            this.tentacleAngle = sajh._e(sajh._a(this.squidRotation)) * (float)Math.PI * 0.25f;
            if (!this.worldObj.isRemote) {
                this.motionX = 0.0;
                this.motionY -= 0.08;
                this.motionY *= (double)0.98f;
                this.motionZ = 0.0;
            }
            this.squidPitch = (float)((double)this.squidPitch + (double)(-90.0f - this.squidPitch) * 0.02);
        }
    }

    @Override
    public void moveEntityWithHeading(float f, float f2) {
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
    }

    @Override
    public void updateEntityActionState() {
        ++this.entityAge;
        if (this.entityAge > 100) {
            this.randomMotionVecZ = 0.0f;
            this.randomMotionVecY = 0.0f;
            this.randomMotionVecX = 0.0f;
        } else if (this.rand.nextInt(50) == 0 || !this.inWater || this.randomMotionVecX == 0.0f && this.randomMotionVecY == 0.0f && this.randomMotionVecZ == 0.0f) {
            float f = this.rand.nextFloat() * (float)Math.PI * 2.0f;
            this.randomMotionVecX = sajh._b(f) * 0.2f;
            this.randomMotionVecY = -0.1f + this.rand.nextFloat() * 0.2f;
            this.randomMotionVecZ = sajh._a(f) * 0.2f;
        }
        this.despawnEntity();
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY > 45.0 && this.posY < 63.0 && super.getCanSpawnHere();
    }
}

