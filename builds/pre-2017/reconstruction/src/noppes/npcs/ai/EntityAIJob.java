/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.ai.EntityAIBase;
import noppes.npcs.EntityNPCInterface;

public class EntityAIJob
extends EntityAIBase {
    private EntityNPCInterface npc;

    public EntityAIJob(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
    }

    @Override
    public boolean shouldExecute() {
        return !this.npc.isKilled() && this.npc.jobInterface != null ? this.npc.jobInterface.aiShouldExecute() : false;
    }

    @Override
    public void startExecuting() {
        this.npc.jobInterface.aiStartExecuting();
    }

    @Override
    public boolean continueExecuting() {
        return !this.npc.isKilled() && this.npc.jobInterface != null ? this.npc.jobInterface.aiContinueExecute() : false;
    }

    @Override
    public void updateTask() {
        this.npc.jobInterface.aiUpdateTask();
    }

    @Override
    public void resetTask() {
        if (this.npc.jobInterface != null) {
            this.npc.jobInterface.resetTask();
        }
    }
}

