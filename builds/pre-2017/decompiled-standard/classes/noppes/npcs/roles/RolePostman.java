/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.roles.RoleInterface;

public class RolePostman
extends RoleInterface {
    public RolePostman(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void writeEntityToNBT(qoac qoac2) {
    }

    @Override
    public void readEntityFromNBT(qoac qoac2) {
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        InvokeSideOnly.frontend(() -> {});
        return true;
    }
}

