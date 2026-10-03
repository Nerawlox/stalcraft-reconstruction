/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.ai.EntityAIBase;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumMovingType;
import noppes.npcs.constants.EnumRoleType;

public class EntityAIReturn
extends EntityAIBase {
    private final EntityNPCInterface npc;
    private int stuckTicks = 0;
    private int returnTicks = 0;
    private double posX;
    private double posY;
    private double posZ;
    private boolean wasAttacked = false;
    private double[] preAttackPos;

    public EntityAIReturn(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        if (this.npc.advanced.role == EnumRoleType.Squad) {
            return false;
        }
        if (this.npc.isFollowerWithOwner()) {
            return false;
        }
        if (!this.npc.aiData.returnToStart) {
            return false;
        }
        if (!(this.npc.aiData.findShelter != 0 || this.npc.worldObj.isDaytime() && !this.npc.worldObj.isRaining() || this.npc.worldObj.provider._g || !this.npc.worldObj.canBlockSeeTheSky((int)this.npc.getStartXPos(), (int)this.npc.getStartYPos(), (int)this.npc.getStartZPos()) && this.npc.worldObj.getFullBlockLightValue((int)this.npc.getStartXPos(), (int)this.npc.getStartYPos(), (int)this.npc.getStartZPos()) > 8)) {
            return false;
        }
        if (this.npc.aiData.findShelter == 1 && this.npc.worldObj.isDaytime() && this.npc.worldObj.canBlockSeeTheSky((int)this.npc.getStartXPos(), (int)this.npc.getStartYPos(), (int)this.npc.getStartZPos())) {
            return false;
        }
        if (this.npc.isAttacking()) {
            if (!this.wasAttacked) {
                this.wasAttacked = true;
                this.preAttackPos = new double[]{this.npc.posX, this.npc.posY, this.npc.posZ};
            }
            return false;
        }
        return !this.npc.isAttacking() && this.wasAttacked ? true : (this.npc.aiData.movingType == EnumMovingType.Wandering ? this.npc.getDistance(this.npc.getStartXPos(), this.npc.getStartYPos(), this.npc.getStartZPos()) > (double)this.npc.aiData.walkingRange : (this.npc.aiData.movingType == EnumMovingType.Standing ? !this.npc.isVeryNearAssignedPlace() : false));
    }

    @Override
    public boolean continueExecuting() {
        return this.wasAttacked && this.returnTicks >= 30 && (this.npc.getNavigator()._g() || this.isTooFar()) ? false : !this.npc.isAttacking() && this.stuckTicks > 0 && !this.npc.isVeryNearAssignedPlace();
    }

    @Override
    public void updateTask() {
        if (this.returnTicks < 30) {
            ++this.returnTicks;
        } else if (this.returnTicks == 30) {
            ++this.returnTicks;
            if (this.isTooFar()) {
                this.npc.setPosition(this.posX, this.posY, this.posZ);
            }
        } else if (this.npc.getNavigator()._g()) {
            ++this.stuckTicks;
            if (this.stuckTicks == 30) {
                this.stuckTicks = 0;
                this.npc.setPosition(this.posX, this.posY, this.posZ);
            }
        } else {
            this.stuckTicks = 1;
        }
    }

    private boolean isTooFar() {
        int n = this.npc.stats.aggroRange * 2;
        if (this.npc.aiData.movingType == EnumMovingType.Wandering) {
            n += this.npc.aiData.walkingRange;
        }
        return this.npc.getDistance(this.posX, this.posY, this.posZ) > (double)n;
    }

    @Override
    public void startExecuting() {
        if (this.wasAttacked) {
            this.posX = this.preAttackPos[0];
            this.posY = this.preAttackPos[1];
            this.posZ = this.preAttackPos[2];
        } else {
            this.posX = this.npc.getStartXPos();
            this.posY = this.npc.getStartYPos();
            this.posZ = this.npc.getStartZPos();
        }
        this.npc.getNavigator()._a(this.posX, this.posY, this.posZ, 1.0);
        this.stuckTicks = 1;
        this.returnTicks = 0;
    }

    @Override
    public void resetTask() {
        this.wasAttacked = false;
    }
}

