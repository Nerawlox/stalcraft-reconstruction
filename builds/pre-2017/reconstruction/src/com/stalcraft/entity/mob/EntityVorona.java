/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.entity.mob;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityVorona
extends EntityFlying
implements ezey {
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private int aggroCooldown;
    public int prevAttackCounter;
    private int explosionStrength = 1;

    public EntityVorona(World world) {
        super(world);
        this.setSize(0.3f, 0.3f);
        this.isImmuneToFire = true;
        this.experienceValue = 5;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_110182_bF() {
        return this.dataWatcher._a(16) != 0;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        return super.attackEntityFrom(damageSource, f);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher._a(16, (Object)0);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(10.0);
    }

    @Override
    protected void updateEntityActionState() {
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == 0) {
            this.setDead();
        }
        this.despawnEntity();
        double d = this.waypointX - this.posX;
        double d2 = this.waypointY - this.posY;
        double d3 = this.waypointZ - this.posZ;
        double d4 = d * d + d2 * d2 + d3 * d3;
        if (d4 < 1.0 || d4 > 3600.0) {
            this.waypointX = this.posX + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.waypointY = this.posY + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.waypointZ = this.posZ + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f);
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.rand.nextInt(5) + 2;
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d4 = (double)sajh._a(d4))) {
                this.motionX += d / d4 * 0.1;
                this.motionY += d2 / d4 * 0.1;
                this.motionZ += d3 / d4 * 0.1;
            } else {
                this.waypointX = this.posX;
                this.waypointY = this.posY;
                this.waypointZ = this.posZ;
            }
        }
        double d5 = 64.0;
    }

    private boolean isCourseTraversable(double d, double d2, double d3, double d4) {
        double d5 = (this.waypointX - this.posX) / d4;
        double d6 = (this.waypointY - this.posY) / d4;
        double d7 = (this.waypointZ - this.posZ) / d4;
        AxisAlignedBB axisAlignedBB = this.boundingBox._c();
        int n = 1;
        while ((double)n < d4) {
            axisAlignedBB._d(d5, d6, d7);
            if (!this.worldObj.getCollidingBoundingBoxes(this, axisAlignedBB).isEmpty()) {
                return false;
            }
            ++n;
        }
        return true;
    }

    @Override
    protected String getLivingSound() {
        return "vorona_idle";
    }

    @Override
    protected String getHurtSound() {
        return "mob.ghast.scream";
    }

    @Override
    protected String getDeathSound() {
        return "mob.ghast.death";
    }

    @Override
    protected int getDropItemId() {
        return Item.gunpowder.itemID;
    }

    @Override
    protected void dropFewItems(boolean bl, int n) {
        int n2;
        int n3 = this.rand.nextInt(2) + this.rand.nextInt(1 + n);
        for (n2 = 0; n2 < n3; ++n2) {
            this.dropItem(Item.ghastTear.itemID, 1);
        }
        n3 = this.rand.nextInt(3) + this.rand.nextInt(1 + n);
        for (n2 = 0; n2 < n3; ++n2) {
            this.dropItem(Item.gunpowder.itemID, 1);
        }
    }

    @Override
    protected float getSoundVolume() {
        return 10.0f;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.rand.nextInt(20) == 0 && super.getCanSpawnHere() && this.worldObj.difficultySetting > 0;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
    }
}

