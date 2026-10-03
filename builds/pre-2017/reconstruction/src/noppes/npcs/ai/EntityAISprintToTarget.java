/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import noppes.npcs.EntityNPCInterface;

public class EntityAISprintToTarget
extends EntityAIBase {
    EntityNPCInterface runner;
    EntityLivingBase runTarget;

    public EntityAISprintToTarget(EntityNPCInterface entityNPCInterface) {
        this.runner = entityNPCInterface;
        this.setMutexBits(8);
    }

    @Override
    public boolean shouldExecute() {
        this.runTarget = this.runner.getAttackTarget();
        if (this.runTarget == null) {
            return false;
        }
        if (this.runner.getNavigator()._g()) {
            return false;
        }
        switch (this.runner.aiData.onAttack) {
            case 0: {
                return this.runner.getDistanceSqToEntity(this.runTarget) >= 64.0 && this.runner.onGround;
            }
            case 2: {
                return this.runner.getDistanceSqToEntity(this.runTarget) <= 49.0 && this.runner.onGround;
            }
        }
        return false;
    }

    @Override
    public boolean continueExecuting() {
        return this.runner.isEntityAlive() && this.runner.onGround && this.runner.hurtTime <= 0 && this.runner.motionX != 0.0 && this.runner.motionZ != 0.0;
    }

    @Override
    public void startExecuting() {
        this.runner.setSprinting(true);
    }

    @Override
    public void resetTask() {
        this.runner.setSprinting(false);
    }
}

