/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;

public abstract class RoleInterface {
    public EntityNPCInterface npc;
    public HashMap dataString = new HashMap();

    public RoleInterface(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
    }

    public abstract void writeEntityToNBT(qoac var1);

    public abstract void readEntityFromNBT(qoac var1);

    public abstract boolean interact(EntityPlayer var1);

    public void killed() {
    }

    public void delete() {
    }

    public boolean aiShouldExecute() {
        return false;
    }

    public boolean aiContinueExecute() {
        return false;
    }

    public void aiStartExecuting() {
    }

    public void aiUpdateTask() {
    }

    public boolean syncBetweenClones() {
        return true;
    }
}

