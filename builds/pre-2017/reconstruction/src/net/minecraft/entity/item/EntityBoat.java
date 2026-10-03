/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityBoat
extends Entity {
    public boolean field_70279_a = true;
    public double speedMultiplier = 0.07;
    public int boatPosRotationIncrements;
    public double boatX;
    public double boatY;
    public double boatZ;
    public double boatYaw;
    public double boatPitch;
    public double velocityX;
    public double velocityY;
    public double velocityZ;

    public EntityBoat(World world) {
        super(world);
        this.preventEntitySpawning = true;
        this.setSize(1.5f, 0.6f);
        this.yOffset = this.height / 2.0f;
    }

    @Override
    public boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void entityInit() {
        this.dataWatcher._a(17, new Integer(0));
        this.dataWatcher._a(18, new Integer(1));
        this.dataWatcher._a(19, new Float(0.0f));
    }

    @Override
    public AxisAlignedBB getCollisionBox(Entity entity) {
        return entity.boundingBox;
    }

    @Override
    public AxisAlignedBB getBoundingBox() {
        return this.boundingBox;
    }

    @Override
    public boolean canBePushed() {
        return true;
    }

    public EntityBoat(World world, double d, double d2, double d3) {
        this(world);
        this.setPosition(d, d2 + (double)this.yOffset, d3);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = d;
        this.prevPosY = d2;
        this.prevPosZ = d3;
    }

    @Override
    public double getMountedYOffset() {
        return (double)this.height * 0.0 - (double)0.3f;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        boolean bl;
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (this.worldObj.isRemote || this.isDead) {
            return true;
        }
        this.setForwardDirection(-this.getForwardDirection());
        this.setTimeSinceHit(10);
        this.setDamageTaken(this.getDamageTaken() + f * 10.0f);
        this.setBeenAttacked();
        boolean bl2 = bl = damageSource.getEntity() instanceof EntityPlayer && ((EntityPlayer)damageSource.getEntity()).capabilities._d;
        if (bl || this.getDamageTaken() > 40.0f) {
            if (this.riddenByEntity != null) {
                this.riddenByEntity.mountEntity(this);
            }
            if (!bl) {
                this.dropItemWithOffset(Item.boat.itemID, 1, 0.0f);
            }
            this.setDead();
        }
        return true;
    }

    @Override
    public void performHurtAnimation() {
        this.setForwardDirection(-this.getForwardDirection());
        this.setTimeSinceHit(10);
        this.setDamageTaken(this.getDamageTaken() * 11.0f);
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    @Override
    public void setPositionAndRotation2(double d, double d2, double d3, float f, float f2, int n) {
        if (this.field_70279_a) {
            this.boatPosRotationIncrements = n + 5;
        } else {
            double d4 = d - this.posX;
            double d5 = d2 - this.posY;
            double d6 = d3 - this.posZ;
            double d7 = d4 * d4 + d5 * d5 + d6 * d6;
            if (d7 > 1.0) {
                this.boatPosRotationIncrements = 3;
            } else {
                return;
            }
        }
        this.boatX = d;
        this.boatY = d2;
        this.boatZ = d3;
        this.boatYaw = f;
        this.boatPitch = f2;
        this.motionX = this.velocityX;
        this.motionY = this.velocityY;
        this.motionZ = this.velocityZ;
    }

    @Override
    public void setVelocity(double d, double d2, double d3) {
        this.velocityX = this.motionX = d;
        this.velocityY = this.motionY = d2;
        this.velocityZ = this.motionZ = d3;
    }

    @Override
    public void onUpdate() {
        int n;
        double d;
        double d2;
        double d3;
        double d4;
        super.onUpdate();
        if (this.getTimeSinceHit() > 0) {
            this.setTimeSinceHit(this.getTimeSinceHit() - 1);
        }
        if (this.getDamageTaken() > 0.0f) {
            this.setDamageTaken(this.getDamageTaken() - 1.0f);
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        int n2 = 5;
        double d5 = 0.0;
        for (int i = 0; i < n2; ++i) {
            double d6 = this.boundingBox._c + (this.boundingBox._f - this.boundingBox._c) * (double)(i + 0) / (double)n2 - 0.125;
            double d7 = this.boundingBox._c + (this.boundingBox._f - this.boundingBox._c) * (double)(i + 1) / (double)n2 - 0.125;
            AxisAlignedBB axisAlignedBB = AxisAlignedBB._a()._a(this.boundingBox._b, d6, this.boundingBox._d, this.boundingBox._e, d7, this.boundingBox._g);
            if (!this.worldObj.isAABBInMaterial(axisAlignedBB, Material._h)) continue;
            d5 += 1.0 / (double)n2;
        }
        double d8 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        if (d8 > 0.26249999999999996) {
            d4 = Math.cos((double)this.rotationYaw * Math.PI / 180.0);
            d3 = Math.sin((double)this.rotationYaw * Math.PI / 180.0);
            int n3 = 0;
            while ((double)n3 < 1.0 + d8 * 60.0) {
                double d9;
                double d10;
                double d11 = this.rand.nextFloat() * 2.0f - 1.0f;
                double d12 = (double)(this.rand.nextInt(2) * 2 - 1) * 0.7;
                if (this.rand.nextBoolean()) {
                    d10 = this.posX - d4 * d11 * 0.8 + d3 * d12;
                    d9 = this.posZ - d3 * d11 * 0.8 - d4 * d12;
                    this.worldObj.spawnParticle("splash", d10, this.posY - 0.125, d9, this.motionX, this.motionY, this.motionZ);
                } else {
                    d10 = this.posX + d4 + d3 * d11 * 0.7;
                    d9 = this.posZ + d3 - d4 * d11 * 0.7;
                    this.worldObj.spawnParticle("splash", d10, this.posY - 0.125, d9, this.motionX, this.motionY, this.motionZ);
                }
                ++n3;
            }
        }
        if (this.worldObj.isRemote && this.field_70279_a) {
            if (this.boatPosRotationIncrements > 0) {
                d4 = this.posX + (this.boatX - this.posX) / (double)this.boatPosRotationIncrements;
                d3 = this.posY + (this.boatY - this.posY) / (double)this.boatPosRotationIncrements;
                double d13 = this.posZ + (this.boatZ - this.posZ) / (double)this.boatPosRotationIncrements;
                double d14 = sajh._f(this.boatYaw - (double)this.rotationYaw);
                this.rotationYaw = (float)((double)this.rotationYaw + d14 / (double)this.boatPosRotationIncrements);
                this.rotationPitch = (float)((double)this.rotationPitch + (this.boatPitch - (double)this.rotationPitch) / (double)this.boatPosRotationIncrements);
                --this.boatPosRotationIncrements;
                this.setPosition(d4, d3, d13);
                this.setRotation(this.rotationYaw, this.rotationPitch);
            } else {
                d4 = this.posX + this.motionX;
                d3 = this.posY + this.motionY;
                double d15 = this.posZ + this.motionZ;
                this.setPosition(d4, d3, d15);
                if (this.onGround) {
                    this.motionX *= 0.5;
                    this.motionY *= 0.5;
                    this.motionZ *= 0.5;
                }
                this.motionX *= (double)0.99f;
                this.motionY *= (double)0.95f;
                this.motionZ *= (double)0.99f;
            }
            return;
        }
        if (d5 < 1.0) {
            d4 = d5 * 2.0 - 1.0;
            this.motionY += (double)0.04f * d4;
        } else {
            if (this.motionY < 0.0) {
                this.motionY /= 2.0;
            }
            this.motionY += (double)0.007f;
        }
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase && (d4 = (double)((EntityLivingBase)this.riddenByEntity).moveForward) > 0.0) {
            d3 = -Math.sin(this.riddenByEntity.rotationYaw * (float)Math.PI / 180.0f);
            d2 = Math.cos(this.riddenByEntity.rotationYaw * (float)Math.PI / 180.0f);
            this.motionX += d3 * this.speedMultiplier * (double)0.05f;
            this.motionZ += d2 * this.speedMultiplier * (double)0.05f;
        }
        if ((d4 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ)) > 0.35) {
            d3 = 0.35 / d4;
            this.motionX *= d3;
            this.motionZ *= d3;
            d4 = 0.35;
        }
        if (d4 > d8 && this.speedMultiplier < 0.35) {
            this.speedMultiplier += (0.35 - this.speedMultiplier) / 35.0;
            if (this.speedMultiplier > 0.35) {
                this.speedMultiplier = 0.35;
            }
        } else {
            this.speedMultiplier -= (this.speedMultiplier - 0.07) / 35.0;
            if (this.speedMultiplier < 0.07) {
                this.speedMultiplier = 0.07;
            }
        }
        if (this.onGround) {
            this.motionX *= 0.5;
            this.motionY *= 0.5;
            this.motionZ *= 0.5;
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.isCollidedHorizontally && d8 > 0.2) {
            if (!this.worldObj.isRemote && !this.isDead) {
                int n4;
                this.setDead();
                for (n4 = 0; n4 < 3; ++n4) {
                    this.dropItemWithOffset(Block.planks.blockID, 1, 0.0f);
                }
                for (n4 = 0; n4 < 2; ++n4) {
                    this.dropItemWithOffset(Item.stick.itemID, 1, 0.0f);
                }
            }
        } else {
            this.motionX *= (double)0.99f;
            this.motionY *= (double)0.95f;
            this.motionZ *= (double)0.99f;
        }
        this.rotationPitch = 0.0f;
        d3 = this.rotationYaw;
        d2 = this.prevPosX - this.posX;
        double d16 = this.prevPosZ - this.posZ;
        if (d2 * d2 + d16 * d16 > 0.001) {
            d3 = (float)(Math.atan2(d16, d2) * 180.0 / Math.PI);
        }
        if ((d = sajh._f(d3 - (double)this.rotationYaw)) > 20.0) {
            d = 20.0;
        }
        if (d < -20.0) {
            d = -20.0;
        }
        this.rotationYaw = (float)((double)this.rotationYaw + d);
        this.setRotation(this.rotationYaw, this.rotationPitch);
        if (this.worldObj.isRemote) {
            return;
        }
        List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox._b(0.2f, 0.0, 0.2f));
        if (list2 != null && !list2.isEmpty()) {
            for (n = 0; n < list2.size(); ++n) {
                Entity entity = (Entity)list2.get(n);
                if (entity == this.riddenByEntity || !entity.canBePushed() || !(entity instanceof EntityBoat)) continue;
                entity.applyEntityCollision(this);
            }
        }
        for (n = 0; n < 4; ++n) {
            int n5 = sajh._c(this.posX + ((double)(n % 2) - 0.5) * 0.8);
            int n6 = sajh._c(this.posZ + ((double)(n / 2) - 0.5) * 0.8);
            for (int i = 0; i < 2; ++i) {
                int n7 = sajh._c(this.posY) + i;
                int n8 = this.worldObj.getBlockId(n5, n7, n6);
                if (n8 == Block.snow.blockID) {
                    this.worldObj.setBlockToAir(n5, n7, n6);
                    continue;
                }
                if (n8 != Block.waterlily.blockID) continue;
                this.worldObj.destroyBlock(n5, n7, n6, true);
            }
        }
        if (this.riddenByEntity != null && this.riddenByEntity.isDead) {
            this.riddenByEntity = null;
        }
    }

    @Override
    public void updateRiderPosition() {
        if (this.riddenByEntity == null) {
            return;
        }
        double d = Math.cos((double)this.rotationYaw * Math.PI / 180.0) * 0.4;
        double d2 = Math.sin((double)this.rotationYaw * Math.PI / 180.0) * 0.4;
        this.riddenByEntity.setPosition(this.posX + d, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + d2);
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
    public boolean interactFirst(EntityPlayer entityPlayer) {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != entityPlayer) {
            return true;
        }
        if (!this.worldObj.isRemote) {
            entityPlayer.mountEntity(this);
        }
        return true;
    }

    public void setDamageTaken(float f) {
        this.dataWatcher._b(19, Float.valueOf(f));
    }

    public float getDamageTaken() {
        return this.dataWatcher._d(19);
    }

    public void setTimeSinceHit(int n) {
        this.dataWatcher._b(17, n);
    }

    public int getTimeSinceHit() {
        return this.dataWatcher._c(17);
    }

    public void setForwardDirection(int n) {
        this.dataWatcher._b(18, n);
    }

    public int getForwardDirection() {
        return this.dataWatcher._c(18);
    }

    public void func_70270_d(boolean bl) {
        this.field_70279_a = bl;
    }
}

