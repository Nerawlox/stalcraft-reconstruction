/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import net.minecraft.entity.player.EntityPlayer;
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
    public void writeEntityToNBT(qoac qoac2) {
        qoac2._a("Currency", (huhy)this.invCurrency.getToNBT());
        qoac2._a("Sold", (huhy)this.invSold.getToNBT());
        qoac2._a("CheckNbt", this.checkNbt);
    }

    @Override
    public void readEntityFromNBT(qoac qoac2) {
        this.invCurrency.setFromNBT(qoac2._m("Currency"));
        this.invSold.setFromNBT(qoac2._m("Sold"));
        this.checkNbt = qoac2._o("CheckNbt");
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        this.npc.performInteractReplica(entityPlayer);
        NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.PlayerExchanger, this.npc);
        return false;
    }
}

