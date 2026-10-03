/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityGhast
extends EntityFlying
implements ezey {
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    public Entity targetedEntity;
    public int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
    public int explosionStrength = 1;

    public EntityGhast(World world) {
        super(world);
        this.setSize(4.0f, 4.0f);
        this.isImmuneToFire = true;
        this.experienceValue = 5;
    }

    public boolean func_110182_bF() {
        return this.dataWatcher._a(16) != 0;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if ("fireball".equals(damageSource.getDamageType()) && damageSource.getEntity() instanceof EntityPlayer) {
            super.attackEntityFrom(damageSource, 1000.0f);
            ((EntityPlayer)damageSource.getEntity()).triggerAchievement(AchievementList._y);
            return true;
        }
        return super.attackEntityFrom(damageSource, f);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(16, (Object)0);
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(10.0);
    }

    @Override
    public void updateEntityActionState() {
        byte by;
        byte by2;
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == 0) {
            this.setDead();
        }
        this.despawnEntity();
        this.prevAttackCounter = this.attackCounter;
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
        if (this.targetedEntity != null && this.targetedEntity.isDead) {
            this.targetedEntity = null;
        }
        if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
            this.targetedEntity = this.worldObj.getClosestVulnerablePlayerToEntity(this, 100.0);
            if (this.targetedEntity != null) {
                this.aggroCooldown = 20;
            }
        }
        double d5 = 64.0;
        if (this.targetedEntity != null && this.targetedEntity.getDistanceSqToEntity(this) < d5 * d5) {
            double d6 = this.targetedEntity.posX - this.posX;
            double d7 = this.targetedEntity.boundingBox._c + (double)(this.targetedEntity.height / 2.0f) - (this.posY + (double)(this.height / 2.0f));
            double d8 = this.targetedEntity.posZ - this.posZ;
            this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(d6, d8)) * 180.0f / (float)Math.PI;
            if (this.canEntityBeSeen(this.targetedEntity)) {
                if (this.attackCounter == 10) {
                    this.worldObj.playAuxSFXAtEntity(null, 1007, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                }
                ++this.attackCounter;
                if (this.attackCounter == 20) {
                    this.worldObj.playAuxSFXAtEntity(null, 1008, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                    EntityLargeFireball entityLargeFireball = new EntityLargeFireball(this.worldObj, this, d6, d7, d8);
                    entityLargeFireball.field_92057_e = this.explosionStrength;
                    double d9 = 4.0;
                    Vec3 vec3 = this.getLook(1.0f);
                    entityLargeFireball.posX = this.posX + vec3._c * d9;
                    entityLargeFireball.posY = this.posY + (double)(this.height / 2.0f) + 0.5;
                    entityLargeFireball.posZ = this.posZ + vec3._e * d9;
                    this.worldObj.spawnEntityInWorld(entityLargeFireball);
                    this.attackCounter = -40;
                }
            } else if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        } else {
            this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(this.motionX, this.motionZ)) * 180.0f / (float)Math.PI;
            if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
        if (!this.worldObj.isRemote && (by2 = this.dataWatcher._a(16)) != (by = (byte)(this.attackCounter > 10 ? 1 : 0))) {
            this.dataWatcher._b(16, by);
        }
    }

    public boolean isCourseTraversable(double d, double d2, double d3, double d4) {
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
    public String getLivingSound() {
        return "mob.ghast.moan";
    }

    @Override
    public String getHurtSound() {
        return "mob.ghast.scream";
    }

    @Override
    public String getDeathSound() {
        return "mob.ghast.death";
    }

    @Override
    public int getDropItemId() {
        return Item.gunpowder.itemID;
    }

    @Override
    public void dropFewItems(boolean bl, int n) {
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
    public float getSoundVolume() {
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
        nBTTagCompound._a("ExplosionPower", this.explosionStrength);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        if (nBTTagCompound._c("ExplosionPower")) {
            this.explosionStrength = nBTTagCompound._f("ExplosionPower");
        }
    }
}

