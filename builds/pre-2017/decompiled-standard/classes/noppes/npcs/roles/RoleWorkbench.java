/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.roles.RoleInterface;

public class RoleWorkbench
extends RoleInterface {
    public String workbenchId = "";

    public RoleWorkbench(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void writeEntityToNBT(qoac qoac2) {
        qoac2._a("WorkbenchId", this.workbenchId);
    }

    @Override
    public void readEntityFromNBT(qoac qoac2) {
        this.workbenchId = qoac2._j("WorkbenchId");
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        if (!entityPlayer.field_70170_p.field_72995_K) {
            InvokeSideOnly.frontend(() -> {});
        }
        return true;
    }
}

