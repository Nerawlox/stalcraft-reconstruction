/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.roles.RoleInterface;

public class RoleResearcher
extends RoleInterface {
    public RoleResearcher(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        this.npc.performInteractReplica(entityPlayer);
        NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.PlayerResearcher, this.npc);
        return true;
    }
}

