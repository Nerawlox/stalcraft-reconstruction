/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;

public class EntityAIAttackTarget
extends EntityAIBase {
    World worldObj;
    EntityNPCInterface attacker;
    int attackTick = 0;
    boolean longMemory;
    PathEntity entityPathEntity;
    private int field_75445_i;

    public EntityAIAttackTarget(EntityNPCInterface entityNPCInterface, boolean bl) {
        this.attacker = entityNPCInterface;
        this.worldObj = entityNPCInterface.worldObj;
        this.longMemory = bl;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        EntityLivingBase entityLivingBase = this.attacker.getAttackTarget();
        if (entityLivingBase == null) {
            return false;
        }
        if (!entityLivingBase.isEntityAlive()) {
            return false;
        }
        if (this.attacker.inventory.getFirearm() != null && this.attacker.aiData.useRangeMelee == 0) {
            return false;
        }
        double d = this.attacker.getDistanceSq(entityLivingBase.posX, entityLivingBase.boundingBox._c, entityLivingBase.posZ);
        double d2 = this.attacker.aiData.distanceToMelee * this.attacker.aiData.distanceToMelee;
        if (this.attacker.aiData.useRangeMelee == 1 && d > d2) {
            return false;
        }
        this.entityPathEntity = this.attacker.getNavigator()._a(entityLivingBase);
        return this.entityPathEntity != null;
    }

    @Override
    public boolean continueExecuting() {
        EntityLivingBase entityLivingBase = this.attacker.getAttackTarget();
        if (entityLivingBase != null && this.attacker.getDistanceSqToEntity(entityLivingBase) <= this.attacker.getDistanceSqToEntity(entityLivingBase)) {
            if (this.attacker.aiData.useRangeMelee == 1 && this.attacker.getDistanceSqToEntity(entityLivingBase) > (double)(this.attacker.aiData.distanceToMelee * this.attacker.aiData.distanceToMelee)) {
                return false;
            }
            if (!entityLivingBase.isEntityAlive()) {
                return false;
            }
            if (!this.longMemory) {
                return !this.attacker.getNavigator()._g();
            }
            return this.attacker.func_110176_b(sajh._c(entityLivingBase.posX), sajh._c(entityLivingBase.posY), sajh._c(entityLivingBase.posZ));
        }
        return false;
    }

    @Override
    public void startExecuting() {
        this.attacker.getNavigator()._a(this.entityPathEntity, 1.0);
        this.field_75445_i = 0;
    }

    @Override
    public void resetTask() {
        this.entityPathEntity = null;
        this.attacker.setAttackTarget(null);
        this.attacker.getNavigator()._h();
    }

    @Override
    public void updateTask() {
        EntityLivingBase entityLivingBase = this.attacker.getAttackTarget();
        if (entityLivingBase == null) {
            return;
        }
        this.attacker.getLookHelper()._a(entityLivingBase, 30.0f, 30.0f);
        if ((this.longMemory || this.attacker.getEntitySenses()._a(entityLivingBase)) && --this.field_75445_i <= 0) {
            this.field_75445_i = 4 + this.attacker.getRNG().nextInt(7);
            this.attacker.getNavigator()._a(entityLivingBase, 1.0);
        }
        this.attackTick = Math.max(this.attackTick - 1, 0);
        if (this.attacker.getDistance(entityLivingBase.posX, entityLivingBase.boundingBox._c, entityLivingBase.posZ) <= (double)this.attacker.stats.attackRange && this.attacker.canEntityBeSeen(entityLivingBase) && this.attackTick <= 0) {
            this.attackTick = this.attacker.stats.attackSpeed;
            this.attacker.swingItem();
            this.attacker.attackEntityAsMob(entityLivingBase);
        }
    }
}

