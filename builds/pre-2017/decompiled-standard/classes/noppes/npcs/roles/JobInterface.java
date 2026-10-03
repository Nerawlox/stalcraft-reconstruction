/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;

public abstract class JobInterface {
    public EntityNPCInterface npc;
    public boolean overrideMainHand = false;
    public boolean overrideOffHand = false;
    public cvzo mainhand = null;
    public cvzo offhand = null;

    public JobInterface(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
    }

    public abstract void writeEntityToNBT(qoac var1);

    public abstract void readEntityFromNBT(qoac var1);

    public void killed() {
    }

    public void delete() {
    }

    public boolean aiShouldExecute() {
        return false;
    }

    public boolean aiContinueExecute() {
        return this.aiShouldExecute();
    }

    public void aiStartExecuting() {
    }

    public void aiUpdateTask() {
    }

    public void reset() {
    }

    public void resetTask() {
    }

    public void onDialogInteract(EntityPlayer entityPlayer) {
    }
}

