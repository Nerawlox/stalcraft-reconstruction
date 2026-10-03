/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import java.util.Iterator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NBTTags;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.NpcMiscInventory;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.containers.ContainerNPCBankInterface;
import noppes.npcs.containers.NpcBankInventory;
import noppes.npcs.controllers.Bank;
import noppes.npcs.controllers.BankController;

public class BankData {
    public HashMap<Integer, NpcBankInventory> itemSlots = new HashMap();
    public HashMap upgradedSlots = new HashMap();
    public int unlockedSlots = 0;
    public int bankId = -1;

    public BankData() {
        for (int i = 0; i < 6; ++i) {
            this.itemSlots.put(i, new NpcBankInventory(54));
            this.upgradedSlots.put(i, false);
        }
    }

    public void readNBT(NBTTagCompound nBTTagCompound) {
        this.bankId = nBTTagCompound._f("DataBankId");
        this.unlockedSlots = nBTTagCompound._f("UnlockedSlots");
        this.itemSlots = this.getItemSlots(nBTTagCompound._n("BankInv"));
        this.upgradedSlots = NBTTags.getBooleanList(nBTTagCompound._n("UpdatedSlots"));
    }

    private HashMap getItemSlots(NBTTagList nBTTagList) {
        HashMap<Integer, NpcBankInventory> hashMap = new HashMap<Integer, NpcBankInventory>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            int n = nBTTagCompound._f("Slot");
            NpcBankInventory npcBankInventory = new NpcBankInventory(54);
            npcBankInventory.setFromNBT(nBTTagCompound._m("BankItems"));
            hashMap.put(n, npcBankInventory);
        }
        return hashMap;
    }

    public void writeNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("DataBankId", this.bankId);
        nBTTagCompound._a("UnlockedSlots", this.unlockedSlots);
        nBTTagCompound._a("UpdatedSlots", NBTTags.nbtBooleanList(this.upgradedSlots));
        nBTTagCompound._a("BankInv", this.nbtItemSlots(this.itemSlots));
    }

    private NBTTagList nbtItemSlots(HashMap hashMap) {
        NBTTagList nBTTagList = new NBTTagList();
        Iterator iterator2 = hashMap.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Slot", n);
            nBTTagCompound._a("BankItems", ((NpcMiscInventory)hashMap.get(n)).getToNBT());
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public boolean isUpgraded(Bank bank, int n) {
        return bank.isUpgraded(n) ? true : bank.canBeUpgraded(n) && (Boolean)this.upgradedSlots.get(n) != false;
    }

    public void openBankGui(EntityPlayer entityPlayer, EntityNPCInterface entityNPCInterface, int n, int n2) {
        Bank bank = (Bank)BankController.getInstance().banks.get(n);
        if (bank == null) {
            bank = (Bank)BankController.getInstance().banks.values().iterator().next();
        }
        if (bank.getMaxSlots() > n2) {
            if (bank.startSlots > this.unlockedSlots) {
                this.unlockedSlots = bank.startSlots;
            }
            ItemStack itemStack = null;
            if (this.unlockedSlots <= n2) {
                itemStack = bank.currencyInventory.getStackInSlot(n2);
                NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.PlayerBankUnlock, entityNPCInterface, n2, bank.id, 0);
            } else if (this.isUpgraded(bank, n2)) {
                NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.PlayerBankLarge, entityNPCInterface, n2, bank.id, 0);
            } else if (bank.canBeUpgraded(n2)) {
                itemStack = bank.upgradeInventory.getStackInSlot(n2);
                NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.PlayerBankUprade, entityNPCInterface, n2, bank.id, 0);
            } else {
                NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.PlayerBankSmall, entityNPCInterface, n2, bank.id, 0);
            }
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("MaxSlots", bank.getMaxSlots());
            nBTTagCompound._a("UnlockedSlots", this.unlockedSlots);
            if (itemStack != null) {
                nBTTagCompound._a("Currency", itemStack._b(new NBTTagCompound()));
                ContainerNPCBankInterface containerNPCBankInterface = this.getContainer(entityPlayer);
                containerNPCBankInterface.currency.item = itemStack;
            }
            NoppesUtilServer.sendData(entityPlayer, EnumPacketType.GuiData, nBTTagCompound);
        }
    }

    private ContainerNPCBankInterface getContainer(EntityPlayer entityPlayer) {
        Container container = entityPlayer.openContainer;
        return container != null && container instanceof ContainerNPCBankInterface ? (ContainerNPCBankInterface)container : null;
    }
}

