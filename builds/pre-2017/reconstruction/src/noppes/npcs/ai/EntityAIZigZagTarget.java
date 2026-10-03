/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;

public class EntityAIZigZagTarget
extends EntityAIBase {
    private EntityCreature theEntity;
    private EntityLivingBase targetEntity;
    private double movePosX;
    private double movePosY;
    private double movePosZ;
    private int entityPosX;
    private int entityPosY;
    private int entityPosZ;
    private double speed;
    private float maxTargetDistance;

    public EntityAIZigZagTarget(EntityCreature entityCreature, double d, float f) {
        this.theEntity = entityCreature;
        this.speed = d;
        this.maxTargetDistance = f;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        this.targetEntity = this.theEntity.getAttackTarget();
        if (this.targetEntity == null) {
            return false;
        }
        if (this.targetEntity.getDistanceSqToEntity(this.theEntity) < (double)(this.maxTargetDistance * this.maxTargetDistance)) {
            return false;
        }
        PathEntity pathEntity = this.theEntity.getNavigator()._a(this.targetEntity);
        if (pathEntity != null && (float)pathEntity._g() >= this.maxTargetDistance) {
            elhc elhc2 = pathEntity._c(sajh._c((double)this.maxTargetDistance / 2.0));
            this.entityPosX = elhc2._a;
            this.entityPosY = elhc2._b;
            this.entityPosZ = elhc2._c;
            Vec3 vec3 = ofaz._a(this.theEntity, (int)this.maxTargetDistance, 3, this.theEntity.worldObj.getWorldVec3Pool()._a(this.entityPosX, this.entityPosY, this.entityPosZ));
            if (vec3 != null && this.targetEntity.getDistanceSq(vec3._c, vec3._d, vec3._e) < this.targetEntity.getDistanceSq(this.entityPosX, this.entityPosY, this.entityPosZ)) {
                this.movePosX = vec3._c;
                this.movePosY = vec3._d;
                this.movePosZ = vec3._e;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean continueExecuting() {
        return !this.theEntity.getNavigator()._g() && this.targetEntity.isEntityAlive() && this.targetEntity.getDistanceSqToEntity(this.theEntity) > (double)(this.maxTargetDistance * this.maxTargetDistance) && this.theEntity.getEntitySenses()._a(this.targetEntity);
    }

    @Override
    public void resetTask() {
        this.targetEntity = null;
    }

    @Override
    public void startExecuting() {
        this.theEntity.getNavigator()._a(this.movePosX, this.movePosY, this.movePosZ, this.speed);
    }

    @Override
    public void updateTask() {
        this.theEntity.getLookHelper()._a(this.targetEntity, 30.0f, 30.0f);
    }
}

