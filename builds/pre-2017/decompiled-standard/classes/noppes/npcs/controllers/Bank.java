/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import noppes.npcs.NBTTags;
import noppes.npcs.NpcMiscInventory;

public class Bank {
    public int id = -1;
    public String name = "";
    public HashMap slotTypes = new HashMap();
    public int startSlots = 1;
    public int maxSlots = 6;
    public NpcMiscInventory currencyInventory = new NpcMiscInventory(6);
    public NpcMiscInventory upgradeInventory = new NpcMiscInventory(6);

    public Bank() {
        for (int i = 0; i < 6; ++i) {
            this.slotTypes.put(i, 0);
        }
    }

    public void writeEntityToNBT(qoac qoac2) {
        qoac2._a("BankID", this.id);
        qoac2._a("BankCurrency", this.currencyInventory.getToNBT());
        qoac2._a("BankUpgrade", this.upgradeInventory.getToNBT());
        qoac2._a("Username", this.name);
        qoac2._a("MaxSlots", this.maxSlots);
        qoac2._a("StartSlots", this.startSlots);
        qoac2._a("BankTypes", NBTTags.nbtIntegerIntegerMap(this.slotTypes));
    }

    public void readEntityFromNBT(qoac qoac2) {
        this.id = qoac2._f("BankID");
        this.name = qoac2._j("Username");
        this.startSlots = qoac2._f("StartSlots");
        this.maxSlots = qoac2._f("MaxSlots");
        this.slotTypes = NBTTags.getIntegerIntegerMap(qoac2._n("BankTypes"));
        this.currencyInventory.setFromNBT(qoac2._m("BankCurrency"));
        this.upgradeInventory.setFromNBT(qoac2._m("BankUpgrade"));
    }

    public boolean isUpgraded(int n) {
        return this.slotTypes.get(n) != null && (Integer)this.slotTypes.get(n) == 2;
    }

    public boolean canBeUpgraded(int n) {
        return this.upgradeInventory.func_70301_a(n) == null ? false : this.slotTypes.get(n) == null || (Integer)this.slotTypes.get(n) == 0;
    }

    public int getMaxSlots() {
        for (int i = 0; i < this.maxSlots; ++i) {
            if (this.currencyInventory.func_70301_a(i) != null || i <= this.startSlots - 1) continue;
            return i;
        }
        return this.maxSlots;
    }
}

