/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import java.util.Iterator;
import net.minecraft.entity.player.EntityPlayer;
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

    public void readNBT(qoac qoac2) {
        this.bankId = qoac2._f("DataBankId");
        this.unlockedSlots = qoac2._f("UnlockedSlots");
        this.itemSlots = this.getItemSlots(qoac2._n("BankInv"));
        this.upgradedSlots = NBTTags.getBooleanList(qoac2._n("UpdatedSlots"));
    }

    private HashMap getItemSlots(bsyv bsyv2) {
        HashMap<Integer, NpcBankInventory> hashMap = new HashMap<Integer, NpcBankInventory>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            int n = qoac2._f("Slot");
            NpcBankInventory npcBankInventory = new NpcBankInventory(54);
            npcBankInventory.setFromNBT(qoac2._m("BankItems"));
            hashMap.put(n, npcBankInventory);
        }
        return hashMap;
    }

    public void writeNBT(qoac qoac2) {
        qoac2._a("DataBankId", this.bankId);
        qoac2._a("UnlockedSlots", this.unlockedSlots);
        qoac2._a("UpdatedSlots", NBTTags.nbtBooleanList(this.upgradedSlots));
        qoac2._a("BankInv", this.nbtItemSlots(this.itemSlots));
    }

    private bsyv nbtItemSlots(HashMap hashMap) {
        bsyv bsyv2 = new bsyv();
        Iterator iterator2 = hashMap.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            qoac qoac2 = new qoac();
            qoac2._a("Slot", n);
            qoac2._a("BankItems", ((NpcMiscInventory)hashMap.get(n)).getToNBT());
            bsyv2._a(qoac2);
        }
        return bsyv2;
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
            cvzo cvzo2 = null;
            if (this.unlockedSlots <= n2) {
                cvzo2 = bank.currencyInventory.func_70301_a(n2);
                NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.PlayerBankUnlock, entityNPCInterface, n2, bank.id, 0);
            } else if (this.isUpgraded(bank, n2)) {
                NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.PlayerBankLarge, entityNPCInterface, n2, bank.id, 0);
            } else if (bank.canBeUpgraded(n2)) {
                cvzo2 = bank.upgradeInventory.func_70301_a(n2);
                NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.PlayerBankUprade, entityNPCInterface, n2, bank.id, 0);
            } else {
                NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.PlayerBankSmall, entityNPCInterface, n2, bank.id, 0);
            }
            qoac qoac2 = new qoac();
            qoac2._a("MaxSlots", bank.getMaxSlots());
            qoac2._a("UnlockedSlots", this.unlockedSlots);
            if (cvzo2 != null) {
                qoac2._a("Currency", cvzo2._b(new qoac()));
                ContainerNPCBankInterface containerNPCBankInterface = this.getContainer(entityPlayer);
                containerNPCBankInterface.currency.item = cvzo2;
            }
            NoppesUtilServer.sendData(entityPlayer, EnumPacketType.GuiData, qoac2);
        }
    }

    private ContainerNPCBankInterface getContainer(EntityPlayer entityPlayer) {
        jjgc jjgc2 = entityPlayer.field_71070_bA;
        return jjgc2 != null && jjgc2 instanceof ContainerNPCBankInterface ? (ContainerNPCBankInterface)jjgc2 : null;
    }
}

