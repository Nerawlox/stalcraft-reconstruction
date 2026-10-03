/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;
import noppes.npcs.EntityNPCInterface;

public class EntityAIAvoidTarget
extends EntityAIBase {
    private EntityNPCInterface theEntity;
    private Entity closestLivingEntity;
    private float distanceFromEntity;
    private PathEntity entityPathEntity;
    private PathNavigate entityPathNavigate;
    private Class targetEntityClass;

    public EntityAIAvoidTarget(EntityNPCInterface entityNPCInterface) {
        this.theEntity = entityNPCInterface;
        this.distanceFromEntity = this.theEntity.stats.aggroRange;
        this.entityPathNavigate = entityNPCInterface.getNavigator();
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        Object object;
        EntityLivingBase entityLivingBase = this.theEntity.getAttackTarget();
        if (entityLivingBase == null) {
            return false;
        }
        this.targetEntityClass = entityLivingBase.getClass();
        if (this.targetEntityClass == EntityPlayer.class) {
            this.closestLivingEntity = this.theEntity.worldObj.getClosestPlayerToEntity(this.theEntity, this.distanceFromEntity);
            if (this.closestLivingEntity == null) {
                return false;
            }
        } else {
            object = this.theEntity.worldObj.getEntitiesWithinAABB(this.targetEntityClass, this.theEntity.boundingBox._b(this.distanceFromEntity, 3.0, this.distanceFromEntity));
            if (object.isEmpty()) {
                return false;
            }
            this.closestLivingEntity = (Entity)object.get(0);
        }
        if (!this.theEntity.getEntitySenses()._a(this.closestLivingEntity)) {
            return false;
        }
        object = ofaz._b(this.theEntity, 16, 7, this.theEntity.worldObj.getWorldVec3Pool()._a(this.closestLivingEntity.posX, this.closestLivingEntity.posY, this.closestLivingEntity.posZ));
        if (object == null) {
            return false;
        }
        if (this.closestLivingEntity.getDistanceSq(((Vec3)object)._c, ((Vec3)object)._d, ((Vec3)object)._e) < this.closestLivingEntity.getDistanceSqToEntity(this.theEntity)) {
            return false;
        }
        this.entityPathEntity = this.entityPathNavigate._a(((Vec3)object)._c, ((Vec3)object)._d, ((Vec3)object)._e);
        return this.entityPathEntity == null ? false : this.entityPathEntity._a((Vec3)object);
    }

    @Override
    public boolean continueExecuting() {
        return !this.entityPathNavigate._g();
    }

    @Override
    public void startExecuting() {
        this.entityPathNavigate._a(this.entityPathEntity, 1.0);
    }

    @Override
    public void resetTask() {
        this.closestLivingEntity = null;
        this.theEntity.setAttackTarget(null);
    }

    @Override
    public void updateTask() {
        if (this.theEntity.getDistanceSqToEntity(this.closestLivingEntity) < 49.0) {
            this.theEntity.getNavigator()._a(1.2);
        } else {
            this.theEntity.getNavigator()._a(1.0);
        }
    }
}

