/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public abstract class EntityMob
extends EntityCreature
implements ezey {
    public EntityMob(World world) {
        super(world);
        this.experienceValue = 5;
    }

    @Override
    public void onLivingUpdate() {
        this.updateArmSwingProgress();
        float f = this.getBrightness(1.0f);
        if (f > 0.5f) {
            this.entityAge += 2;
        }
        super.onLivingUpdate();
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == 0) {
            this.setDead();
        }
    }

    @Override
    public Entity findPlayerToAttack() {
        EntityPlayer entityPlayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0);
        if (entityPlayer != null && this.canEntityBeSeen(entityPlayer)) {
            return entityPlayer;
        }
        return null;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (super.attackEntityFrom(damageSource, f)) {
            Entity entity = damageSource.getEntity();
            if (this.riddenByEntity == entity || this.ridingEntity == entity) {
                return true;
            }
            if (entity != this) {
                this.entityToAttack = entity;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        boolean bl;
        float f = (float)this.getEntityAttribute(sajz._e)._e();
        int n = 0;
        if (entity instanceof EntityLivingBase) {
            f += zhty._a(this, (EntityLivingBase)entity);
            n += zhty._b(this, (EntityLivingBase)entity);
        }
        if (bl = entity.attackEntityFrom(DamageSource.causeMobDamage(this), f)) {
            int n2;
            if (n > 0) {
                entity.addVelocity(-sajh._a(this.rotationYaw * (float)Math.PI / 180.0f) * (float)n * 0.5f, 0.1, sajh._b(this.rotationYaw * (float)Math.PI / 180.0f) * (float)n * 0.5f);
                this.motionX *= 0.6;
                this.motionZ *= 0.6;
            }
            if ((n2 = zhty._a(this)) > 0) {
                entity.setFire(n2 * 4);
            }
            if (entity instanceof EntityLivingBase) {
                EnchantmentThorns._a(this, (EntityLivingBase)entity, this.rand);
            }
        }
        return bl;
    }

    @Override
    public void attackEntity(Entity entity, float f) {
        if (this.attackTime <= 0 && f < 2.0f && entity.boundingBox._f > this.boundingBox._c && entity.boundingBox._c < this.boundingBox._f) {
            this.attackTime = 20;
            this.attackEntityAsMob(entity);
        }
    }

    @Override
    public float getBlockPathWeight(int n, int n2, int n3) {
        return 0.5f - this.worldObj.getLightBrightness(n, n2, n3);
    }

    public boolean isValidLightLevel() {
        int n;
        int n2;
        int n3 = sajh._c(this.posX);
        if (this.worldObj.getSavedLightValue(EnumSkyBlock._a, n3, n2 = sajh._c(this.boundingBox._c), n = sajh._c(this.posZ)) > this.rand.nextInt(32)) {
            return false;
        }
        int n4 = this.worldObj.getBlockLightValue(n3, n2, n);
        if (this.worldObj.isThundering()) {
            int n5 = this.worldObj.skylightSubtracted;
            this.worldObj.skylightSubtracted = 10;
            n4 = this.worldObj.getBlockLightValue(n3, n2, n);
            this.worldObj.skylightSubtracted = n5;
        }
        return n4 <= this.rand.nextInt(8);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.worldObj.difficultySetting > 0 && this.isValidLightLevel() && super.getCanSpawnHere();
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap()._b(sajz._e);
    }
}

