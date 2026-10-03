/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.ai.zwat;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.controllers.replica.ReplicaSystem;

public class EntityAIWorldLines
extends zwat {
    private EntityNPCInterface npc;

    public EntityAIWorldLines(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
    }

    @Override
    public boolean func_75250_a() {
        return !this.npc.isAttacking() && !this.npc.isKilled() && this.npc.advanced.hasWorldLines() && this.npc.func_70681_au().nextInt(900) == 1;
    }

    @Override
    public void func_75249_e() {
        this.npc.performReplica(ReplicaSystem.ReplicaType.GENERAL);
    }
}

