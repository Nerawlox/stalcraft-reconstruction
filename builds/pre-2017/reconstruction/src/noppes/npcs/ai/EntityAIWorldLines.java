/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.ai.EntityAIBase;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.controllers.replica.ReplicaSystem;

public class EntityAIWorldLines
extends EntityAIBase {
    private EntityNPCInterface npc;

    public EntityAIWorldLines(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
    }

    @Override
    public boolean shouldExecute() {
        return !this.npc.isAttacking() && !this.npc.isKilled() && this.npc.advanced.hasWorldLines() && this.npc.getRNG().nextInt(900) == 1;
    }

    @Override
    public void startExecuting() {
        this.npc.performReplica(ReplicaSystem.ReplicaType.GENERAL);
    }
}

