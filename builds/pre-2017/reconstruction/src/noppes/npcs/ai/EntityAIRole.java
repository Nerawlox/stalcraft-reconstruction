/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.ai.EntityAIBase;
import noppes.npcs.EntityNPCInterface;

public class EntityAIRole
extends EntityAIBase {
    private EntityNPCInterface npc;

    public EntityAIRole(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
    }

    @Override
    public boolean shouldExecute() {
        return !this.npc.isKilled() && this.npc.roleInterface != null ? this.npc.roleInterface.aiShouldExecute() : false;
    }

    @Override
    public void startExecuting() {
        this.npc.roleInterface.aiStartExecuting();
    }

    @Override
    public boolean continueExecuting() {
        return !this.npc.isKilled() && this.npc.roleInterface != null ? this.npc.roleInterface.aiContinueExecute() : false;
    }

    @Override
    public void updateTask() {
        if (this.npc.roleInterface != null) {
            this.npc.roleInterface.aiUpdateTask();
        }
    }
}

