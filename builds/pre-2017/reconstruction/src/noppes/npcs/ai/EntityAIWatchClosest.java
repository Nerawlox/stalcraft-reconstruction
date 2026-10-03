/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

public class EntityAIWatchClosest
extends EntityAIBase {
    protected Entity closestEntity;
    private EntityLiving theWatcher;
    private float maxDistanceForPlayer;
    private int lookTime;
    private float field_75331_e;
    private Class watchedClass;

    public EntityAIWatchClosest(EntityLiving entityLiving, Class clazz, float f) {
        this.theWatcher = entityLiving;
        this.watchedClass = clazz;
        this.maxDistanceForPlayer = f;
        this.field_75331_e = 0.02f;
        this.setMutexBits(2);
    }

    public EntityAIWatchClosest(EntityLiving entityLiving, Class clazz, float f, float f2) {
        this.theWatcher = entityLiving;
        this.watchedClass = clazz;
        this.maxDistanceForPlayer = f;
        this.field_75331_e = f2;
        this.setMutexBits(2);
    }

    @Override
    public boolean shouldExecute() {
        if (this.theWatcher.getRNG().nextFloat() >= this.field_75331_e) {
            return false;
        }
        if (this.theWatcher.getAttackTarget() != null) {
            this.closestEntity = this.theWatcher.getAttackTarget();
        }
        if (this.watchedClass == EntityPlayer.class) {
            this.closestEntity = this.theWatcher.worldObj.getClosestPlayerToEntity(this.theWatcher, this.maxDistanceForPlayer);
        } else {
            this.closestEntity = this.theWatcher.worldObj.findNearestEntityWithinAABB(this.watchedClass, this.theWatcher.boundingBox._b(this.maxDistanceForPlayer, 3.0, this.maxDistanceForPlayer), this.theWatcher);
            if (this.closestEntity != null) {
                return this.theWatcher.canEntityBeSeen(this.closestEntity);
            }
        }
        return this.closestEntity != null;
    }

    @Override
    public boolean continueExecuting() {
        return !this.closestEntity.isEntityAlive() ? false : (this.theWatcher.getDistanceSqToEntity(this.closestEntity) > (double)(this.maxDistanceForPlayer * this.maxDistanceForPlayer) ? false : this.lookTime > 0);
    }

    @Override
    public void startExecuting() {
        this.lookTime = 40 + this.theWatcher.getRNG().nextInt(40);
    }

    @Override
    public void resetTask() {
        this.closestEntity = null;
    }

    @Override
    public void updateTask() {
        this.theWatcher.getLookHelper()._a(this.closestEntity.posX, this.closestEntity.posY + (double)this.closestEntity.getEyeHeight(), this.closestEntity.posZ, 10.0f, this.theWatcher.getVerticalFaceSpeed());
        --this.lookTime;
    }
}

