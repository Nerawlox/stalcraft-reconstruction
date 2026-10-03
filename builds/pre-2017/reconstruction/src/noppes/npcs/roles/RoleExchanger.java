/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.NpcMiscInventory;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.roles.RoleInterface;

public class RoleExchanger
extends RoleInterface {
    public NpcMiscInventory invCurrency = new NpcMiscInventory(18);
    public NpcMiscInventory invSold = new NpcMiscInventory(18);
    public boolean checkNbt = true;

    public RoleExchanger(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Currency", (NBTBase)this.invCurrency.getToNBT());
        nBTTagCompound._a("Sold", (NBTBase)this.invSold.getToNBT());
        nBTTagCompound._a("CheckNbt", this.checkNbt);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.invCurrency.setFromNBT(nBTTagCompound._m("Currency"));
        this.invSold.setFromNBT(nBTTagCompound._m("Sold"));
        this.checkNbt = nBTTagCompound._o("CheckNbt");
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        this.npc.performInteractReplica(entityPlayer);
        NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.PlayerExchanger, this.npc);
        return false;
    }
}

