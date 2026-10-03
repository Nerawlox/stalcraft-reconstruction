/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.ai.zwat;
import noppes.npcs.EntityNPCInterface;

public class EntityAIJob
extends zwat {
    private EntityNPCInterface npc;

    public EntityAIJob(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
    }

    @Override
    public boolean func_75250_a() {
        return !this.npc.isKilled() && this.npc.jobInterface != null ? this.npc.jobInterface.aiShouldExecute() : false;
    }

    @Override
    public void func_75249_e() {
        this.npc.jobInterface.aiStartExecuting();
    }

    @Override
    public boolean func_75253_b() {
        return !this.npc.isKilled() && this.npc.jobInterface != null ? this.npc.jobInterface.aiContinueExecute() : false;
    }

    @Override
    public void func_75246_d() {
        this.npc.jobInterface.aiUpdateTask();
    }

    @Override
    public void func_75251_c() {
        if (this.npc.jobInterface != null) {
            this.npc.jobInterface.resetTask();
        }
    }
}

