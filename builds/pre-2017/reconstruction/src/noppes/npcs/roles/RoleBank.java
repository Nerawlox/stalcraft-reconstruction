/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.controllers.Bank;
import noppes.npcs.controllers.BankController;
import noppes.npcs.controllers.BankData;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.roles.RoleInterface;

public class RoleBank
extends RoleInterface {
    public int bankId = -1;

    public RoleBank(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("RoleBankID", this.bankId);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.bankId = nBTTagCompound._f("RoleBankID");
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        BankData bankData = PlayerDataController.instance.getBankData(entityPlayer, this.bankId).getBankOrDefault(this.bankId);
        bankData.openBankGui(entityPlayer, this.npc, this.bankId, 0);
        this.npc.performInteractReplica(entityPlayer);
        return false;
    }

    public Bank getBank() {
        Bank bank = (Bank)BankController.getInstance().banks.get(this.bankId);
        return bank != null ? bank : (Bank)BankController.getInstance().banks.values().iterator().next();
    }
}

