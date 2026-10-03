/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.ai.zwat;
import noppes.npcs.EntityNPCInterface;

public class EntityAIRole
extends zwat {
    private EntityNPCInterface npc;

    public EntityAIRole(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
    }

    @Override
    public boolean func_75250_a() {
        return !this.npc.isKilled() && this.npc.roleInterface != null ? this.npc.roleInterface.aiShouldExecute() : false;
    }

    @Override
    public void func_75249_e() {
        this.npc.roleInterface.aiStartExecuting();
    }

    @Override
    public boolean func_75253_b() {
        return !this.npc.isKilled() && this.npc.roleInterface != null ? this.npc.roleInterface.aiContinueExecute() : false;
    }

    @Override
    public void func_75246_d() {
        if (this.npc.roleInterface != null) {
            this.npc.roleInterface.aiUpdateTask();
        }
    }
}

