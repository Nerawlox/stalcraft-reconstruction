/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIDoorInteract;

public class EntityAIBustDoor
extends EntityAIDoorInteract {
    private int breakingTime;
    private int field_75358_j = -1;

    public EntityAIBustDoor(EntityLiving entityLiving) {
        super(entityLiving);
    }

    @Override
    public boolean shouldExecute() {
        return !super.shouldExecute() ? false : (!this.theEntity.worldObj.getGameRules()._b("mobGriefing") ? false : !this.targetDoor._b(this.theEntity.worldObj, this.entityPosX, this.entityPosY, this.entityPosZ));
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
        this.breakingTime = 0;
    }

    @Override
    public boolean continueExecuting() {
        double d = this.theEntity.getDistanceSq(this.entityPosX, this.entityPosY, this.entityPosZ);
        return this.breakingTime <= 240 && !this.targetDoor._b(this.theEntity.worldObj, this.entityPosX, this.entityPosY, this.entityPosZ) && d < 4.0;
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
            this.theEntity.swingItem();
        }
        ++this.breakingTime;
        int n = (int)((float)this.breakingTime / 240.0f * 10.0f);
        if (n != this.field_75358_j) {
            this.theEntity.worldObj.destroyBlockInWorldPartially(this.theEntity.entityId, this.entityPosX, this.entityPosY, this.entityPosZ, n);
            this.field_75358_j = n;
        }
        if (this.breakingTime == 240) {
            this.theEntity.worldObj.setBlockToAir(this.entityPosX, this.entityPosY, this.entityPosZ);
            this.theEntity.worldObj.playAuxSFX(1012, this.entityPosX, this.entityPosY, this.entityPosZ, 0);
            this.theEntity.worldObj.playAuxSFX(2001, this.entityPosX, this.entityPosY, this.entityPosZ, this.targetDoor.blockID);
        }
    }
}

