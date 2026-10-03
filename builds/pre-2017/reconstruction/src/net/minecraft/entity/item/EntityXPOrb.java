/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityXPOrb
extends Entity {
    public int xpColor;
    public int xpOrbAge;
    public int field_70532_c;
    public int xpOrbHealth = 5;
    public int xpValue;
    public EntityPlayer closestPlayer;
    public int xpTargetColor;

    public EntityXPOrb(World world, double d, double d2, double d3, int n) {
        super(world);
        this.setSize(0.5f, 0.5f);
        this.yOffset = this.height / 2.0f;
        this.setPosition(d, d2, d3);
        this.rotationYaw = (float)(Math.random() * 360.0);
        this.motionX = (float)(Math.random() * (double)0.2f - (double)0.1f) * 2.0f;
        this.motionY = (float)(Math.random() * 0.2) * 2.0f;
        this.motionZ = (float)(Math.random() * (double)0.2f - (double)0.1f) * 2.0f;
        this.xpValue = n;
    }

    @Override
    public boolean canTriggerWalking() {
        return false;
    }

    public EntityXPOrb(World world) {
        super(world);
        this.setSize(0.25f, 0.25f);
        this.yOffset = this.height / 2.0f;
    }

    @Override
    public void entityInit() {
    }

    @Override
    public int getBrightnessForRender(float f) {
        float f2 = 0.5f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        int n = super.getBrightnessForRender(f);
        int n2 = n & 0xFF;
        int n3 = n >> 16 & 0xFF;
        if ((n2 += (int)(f2 * 15.0f * 16.0f)) > 240) {
            n2 = 240;
        }
        return n2 | n3 << 16;
    }

    @Override
    public void onUpdate() {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        super.onUpdate();
        if (this.field_70532_c > 0) {
            --this.field_70532_c;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= (double)0.03f;
        if (this.worldObj.getBlockMaterial(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ)) == Material._i) {
            this.motionY = 0.2f;
            this.motionX = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f;
            this.motionZ = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f;
            this.playSound("random.fizz", 0.4f, 2.0f + this.rand.nextFloat() * 0.4f);
        }
        this.pushOutOfBlocks(this.posX, (this.boundingBox._c + this.boundingBox._f) / 2.0, this.posZ);
        double d6 = 8.0;
        if (this.xpTargetColor < this.xpColor - 20 + this.entityId % 100) {
            if (this.closestPlayer == null || this.closestPlayer.getDistanceSqToEntity(this) > d6 * d6) {
                this.closestPlayer = this.worldObj.getClosestPlayerToEntity(this, d6);
            }
            this.xpTargetColor = this.xpColor;
        }
        if (this.closestPlayer != null && (d5 = 1.0 - (d4 = Math.sqrt((d3 = (this.closestPlayer.posX - this.posX) / d6) * d3 + (d2 = (this.closestPlayer.posY + (double)this.closestPlayer.getEyeHeight() - this.posY) / d6) * d2 + (d = (this.closestPlayer.posZ - this.posZ) / d6) * d))) > 0.0) {
            d5 *= d5;
            this.motionX += d3 / d4 * d5 * 0.1;
            this.motionY += d2 / d4 * d5 * 0.1;
            this.motionZ += d / d4 * d5 * 0.1;
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        float f = 0.98f;
        if (this.onGround) {
            f = 0.58800006f;
            int n = this.worldObj.getBlockId(sajh._c(this.posX), sajh._c(this.boundingBox._c) - 1, sajh._c(this.posZ));
            if (n > 0) {
                f = Block.blocksList[n].slipperiness * 0.98f;
            }
        }
        this.motionX *= (double)f;
        this.motionY *= (double)0.98f;
        this.motionZ *= (double)f;
        if (this.onGround) {
            this.motionY *= (double)-0.9f;
        }
        ++this.xpColor;
        ++this.xpOrbAge;
        if (this.xpOrbAge >= 6000) {
            this.setDead();
        }
    }

    @Override
    public boolean handleWaterMovement() {
        return this.worldObj.handleMaterialAcceleration(this.boundingBox, Material._h, this);
    }

    @Override
    public void dealFireDamage(int n) {
        this.attackEntityFrom(DamageSource.inFire, n);
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        this.setBeenAttacked();
        this.xpOrbHealth = (int)((float)this.xpOrbHealth - f);
        if (this.xpOrbHealth <= 0) {
            this.setDead();
        }
        return false;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Health", (short)((byte)this.xpOrbHealth));
        nBTTagCompound._a("Age", (short)this.xpOrbAge);
        nBTTagCompound._a("Value", (short)this.xpValue);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.xpOrbHealth = nBTTagCompound._e("Health") & 0xFF;
        this.xpOrbAge = nBTTagCompound._e("Age");
        this.xpValue = nBTTagCompound._e("Value");
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityPlayer) {
        if (this.worldObj.isRemote) {
            return;
        }
        if (this.field_70532_c == 0 && entityPlayer.xpCooldown == 0) {
            entityPlayer.xpCooldown = 2;
            this.playSound("random.orb", 0.1f, 0.5f * ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7f + 1.8f));
            entityPlayer.onItemPickup(this, 1);
            entityPlayer.addExperience(this.xpValue);
            this.setDead();
        }
    }

    public int getXpValue() {
        return this.xpValue;
    }

    public int getTextureByXP() {
        if (this.xpValue >= 2477) {
            return 10;
        }
        if (this.xpValue >= 1237) {
            return 9;
        }
        if (this.xpValue >= 617) {
            return 8;
        }
        if (this.xpValue >= 307) {
            return 7;
        }
        if (this.xpValue >= 149) {
            return 6;
        }
        if (this.xpValue >= 73) {
            return 5;
        }
        if (this.xpValue >= 37) {
            return 4;
        }
        if (this.xpValue >= 17) {
            return 3;
        }
        if (this.xpValue >= 7) {
            return 2;
        }
        if (this.xpValue >= 3) {
            return 1;
        }
        return 0;
    }

    public static int getXPSplit(int n) {
        if (n >= 2477) {
            return 2477;
        }
        if (n >= 1237) {
            return 1237;
        }
        if (n >= 617) {
            return 617;
        }
        if (n >= 307) {
            return 307;
        }
        if (n >= 149) {
            return 149;
        }
        if (n >= 73) {
            return 73;
        }
        if (n >= 37) {
            return 37;
        }
        if (n >= 17) {
            return 17;
        }
        if (n >= 7) {
            return 7;
        }
        if (n >= 3) {
            return 3;
        }
        return 1;
    }

    @Override
    public boolean canAttackWithItem() {
        return false;
    }
}

