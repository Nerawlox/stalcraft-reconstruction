/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIDoorInteract;

public class jgro
extends EntityAIDoorInteract {
    public int _a;
    public int _b = -1;

    public jgro(EntityLiving entityLiving) {
        super(entityLiving);
    }

    @Override
    public boolean shouldExecute() {
        if (!super.shouldExecute()) {
            return false;
        }
        if (!this.theEntity.worldObj.getGameRules()._b("mobGriefing")) {
            return false;
        }
        return !this.targetDoor._b(this.theEntity.worldObj, this.entityPosX, this.entityPosY, this.entityPosZ);
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
        this._a = 0;
    }

    @Override
    public boolean continueExecuting() {
        double d = this.theEntity.getDistanceSq(this.entityPosX, this.entityPosY, this.entityPosZ);
        return this._a <= 240 && !this.targetDoor._b(this.theEntity.worldObj, this.entityPosX, this.entityPosY, this.entityPosZ) && d < 4.0;
    }

    @Override
    public void resetTask() {
        super.resetTask();
        this.theEntity.worldObj.destroyBlockInWorldPartially(this.theEntity.entityId, this.entityPosX, this.entityPosY, this.entityPosZ, -1);
    }

    @Override
    public void updateTask() {
        super.updateTask();
        if (this.theEntity.getRNG().nextInt(20) == 0) {
            this.theEntity.worldObj.playAuxSFX(1010, this.entityPosX, this.entityPosY, this.entityPosZ, 0);
        }
        ++this._a;
        int n = (int)((float)this._a / 240.0f * 10.0f);
        if (n != this._b) {
            this.theEntity.worldObj.destroyBlockInWorldPartially(this.theEntity.entityId, this.entityPosX, this.entityPosY, this.entityPosZ, n);
            this._b = n;
        }
        if (this._a == 240 && this.theEntity.worldObj.difficultySetting == 3) {
            this.theEntity.worldObj.setBlockToAir(this.entityPosX, this.entityPosY, this.entityPosZ);
            this.theEntity.worldObj.playAuxSFX(1012, this.entityPosX, this.entityPosY, this.entityPosZ, 0);
            this.theEntity.worldObj.playAuxSFX(2001, this.entityPosX, this.entityPosY, this.entityPosZ, this.targetDoor.blockID);
        }
    }
}

