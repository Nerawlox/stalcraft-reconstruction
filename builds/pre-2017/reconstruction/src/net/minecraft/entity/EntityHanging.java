/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.util.ugqx;
import net.minecraft.world.World;

public abstract class EntityHanging
extends Entity {
    public int tickCounter1;
    public int hangingDirection;
    public int xPosition;
    public int yPosition;
    public int zPosition;

    public EntityHanging(World world) {
        super(world);
        this.yOffset = 0.0f;
        this.setSize(0.5f, 0.5f);
    }

    public EntityHanging(World world, int n, int n2, int n3, int n4) {
        this(world);
        this.xPosition = n;
        this.yPosition = n2;
        this.zPosition = n3;
    }

    @Override
    public void entityInit() {
    }

    public void setDirection(int n) {
        this.hangingDirection = n;
        this.prevRotationYaw = this.rotationYaw = (float)(n * 90);
        float f = this.getWidthPixels();
        float f2 = this.getHeightPixels();
        float f3 = this.getWidthPixels();
        if (n == 2 || n == 0) {
            f3 = 0.5f;
            this.rotationYaw = this.prevRotationYaw = (float)(ugqx._f[n] * 90);
        } else {
            f = 0.5f;
        }
        f /= 32.0f;
        f2 /= 32.0f;
        f3 /= 32.0f;
        float f4 = (float)this.xPosition + 0.5f;
        float f5 = (float)this.yPosition + 0.5f;
        float f6 = (float)this.zPosition + 0.5f;
        float f7 = 0.5625f;
        if (n == 2) {
            f6 -= f7;
        }
        if (n == 1) {
            f4 -= f7;
        }
        if (n == 0) {
            f6 += f7;
        }
        if (n == 3) {
            f4 += f7;
        }
        if (n == 2) {
            f4 -= this.func_70517_b(this.getWidthPixels());
        }
        if (n == 1) {
            f6 += this.func_70517_b(this.getWidthPixels());
        }
        if (n == 0) {
            f4 += this.func_70517_b(this.getWidthPixels());
        }
        if (n == 3) {
            f6 -= this.func_70517_b(this.getWidthPixels());
        }
        this.setPosition(f4, f5 += this.func_70517_b(this.getHeightPixels()), f6);
        float f8 = -0.03125f;
        this.boundingBox._b(f4 - f - f8, f5 - f2 - f8, f6 - f3 - f8, f4 + f + f8, f5 + f2 + f8, f6 + f3 + f8);
    }

    public float func_70517_b(int n) {
        if (n == 32) {
            return 0.5f;
        }
        if (n == 64) {
            return 0.5f;
        }
        return 0.0f;
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.tickCounter1++ == 100 && !this.worldObj.isRemote) {
            this.tickCounter1 = 0;
            if (!this.isDead && !this.onValidSurface()) {
                this.setDead();
                this.onBroken(null);
            }
        }
    }

    public boolean onValidSurface() {
        if (!this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty()) {
            return false;
        }
        int n = Math.max(1, this.getWidthPixels() / 16);
        int n2 = Math.max(1, this.getHeightPixels() / 16);
        int n3 = this.xPosition;
        int n4 = this.yPosition;
        int n5 = this.zPosition;
        if (this.hangingDirection == 2) {
            n3 = sajh._c(this.posX - (double)((float)this.getWidthPixels() / 32.0f));
        }
        if (this.hangingDirection == 1) {
            n5 = sajh._c(this.posZ - (double)((float)this.getWidthPixels() / 32.0f));
        }
        if (this.hangingDirection == 0) {
            n3 = sajh._c(this.posX - (double)((float)this.getWidthPixels() / 32.0f));
        }
        if (this.hangingDirection == 3) {
            n5 = sajh._c(this.posZ - (double)((float)this.getWidthPixels() / 32.0f));
        }
        n4 = sajh._c(this.posY - (double)((float)this.getHeightPixels() / 32.0f));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                Object object = this.hangingDirection == 2 || this.hangingDirection == 0 ? this.worldObj.getBlockMaterial(n3 + i, n4 + j, this.zPosition) : this.worldObj.getBlockMaterial(this.xPosition, n4 + j, n5 + i);
                if (((Material)object)._a()) continue;
                return false;
            }
        }
        List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox);
        for (Object object : list2) {
            if (!(object instanceof EntityHanging)) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean hitByEntity(Entity entity) {
        if (entity instanceof EntityPlayer) {
            return this.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)entity), 0.0f);
        }
        return false;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (!this.isDead && !this.worldObj.isRemote) {
            this.setDead();
            this.setBeenAttacked();
            this.onBroken(damageSource.getEntity());
        }
        return true;
    }

    @Override
    public void moveEntity(double d, double d2, double d3) {
        if (!this.worldObj.isRemote && !this.isDead && d * d + d2 * d2 + d3 * d3 > 0.0) {
            this.setDead();
            this.onBroken(null);
        }
    }

    @Override
    public void addVelocity(double d, double d2, double d3) {
        if (!this.worldObj.isRemote && !this.isDead && d * d + d2 * d2 + d3 * d3 > 0.0) {
            this.setDead();
            this.onBroken(null);
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Direction", (byte)this.hangingDirection);
        nBTTagCompound._a("TileX", this.xPosition);
        nBTTagCompound._a("TileY", this.yPosition);
        nBTTagCompound._a("TileZ", this.zPosition);
        switch (this.hangingDirection) {
            case 2: {
                nBTTagCompound._a("Dir", (byte)0);
                break;
            }
            case 1: {
                nBTTagCompound._a("Dir", (byte)1);
                break;
            }
            case 0: {
                nBTTagCompound._a("Dir", (byte)2);
                break;
            }
            case 3: {
                nBTTagCompound._a("Dir", (byte)3);
            }
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound._c("Direction")) {
            this.hangingDirection = nBTTagCompound._d("Direction");
        } else {
            switch (nBTTagCompound._d("Dir")) {
                case 0: {
                    this.hangingDirection = 2;
                    break;
                }
                case 1: {
                    this.hangingDirection = 1;
                    break;
                }
                case 2: {
                    this.hangingDirection = 0;
                    break;
                }
                case 3: {
                    this.hangingDirection = 3;
                }
            }
        }
        this.xPosition = nBTTagCompound._f("TileX");
        this.yPosition = nBTTagCompound._f("TileY");
        this.zPosition = nBTTagCompound._f("TileZ");
        this.setDirection(this.hangingDirection);
    }

    public abstract int getWidthPixels();

    public abstract int getHeightPixels();

    public abstract void onBroken(Entity var1);

    @Override
    public boolean shouldSetPosAfterLoading() {
        return false;
    }
}

