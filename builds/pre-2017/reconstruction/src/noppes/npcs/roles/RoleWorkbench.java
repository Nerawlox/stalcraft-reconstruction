/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.roles.RoleInterface;

public class RoleWorkbench
extends RoleInterface {
    public String workbenchId = "";

    public RoleWorkbench(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("WorkbenchId", this.workbenchId);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.workbenchId = nBTTagCompound._j("WorkbenchId");
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        if (!entityPlayer.worldObj.isRemote) {
            InvokeSideOnly.frontend(() -> {});
        }
        return true;
    }
}

