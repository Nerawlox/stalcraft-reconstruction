/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityEnderCrystal
extends Entity {
    public int innerRotation;
    public int health;

    public EntityEnderCrystal(World world) {
        super(world);
        this.preventEntitySpawning = true;
        this.setSize(2.0f, 2.0f);
        this.yOffset = this.height / 2.0f;
        this.health = 5;
        this.innerRotation = this.rand.nextInt(100000);
    }

    public EntityEnderCrystal(World world, double d, double d2, double d3) {
        this(world);
        this.setPosition(d, d2, d3);
    }

    @Override
    public boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void entityInit() {
        this.dataWatcher._a(8, (Object)this.health);
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        ++this.innerRotation;
        this.dataWatcher._b(8, this.health);
        int n = sajh._c(this.posX);
        int n2 = sajh._c(this.posY);
        int n3 = sajh._c(this.posZ);
        if (this.worldObj.getBlockId(n, n2, n3) != Block.fire.blockID) {
            this.worldObj.setBlock(n, n2, n3, Block.fire.blockID);
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
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (!this.isDead && !this.worldObj.isRemote) {
            this.health = 0;
            if (this.health <= 0) {
                this.setDead();
                if (!this.worldObj.isRemote) {
                    this.worldObj.createExplosion(null, this.posX, this.posY, this.posZ, 6.0f, true);
                }
            }
        }
        return true;
    }
}

