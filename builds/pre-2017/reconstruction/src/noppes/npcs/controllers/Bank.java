/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import net.minecraft.nbt.NBTTagCompound;
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

    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("BankID", this.id);
        nBTTagCompound._a("BankCurrency", this.currencyInventory.getToNBT());
        nBTTagCompound._a("BankUpgrade", this.upgradeInventory.getToNBT());
        nBTTagCompound._a("Username", this.name);
        nBTTagCompound._a("MaxSlots", this.maxSlots);
        nBTTagCompound._a("StartSlots", this.startSlots);
        nBTTagCompound._a("BankTypes", NBTTags.nbtIntegerIntegerMap(this.slotTypes));
    }

    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.id = nBTTagCompound._f("BankID");
        this.name = nBTTagCompound._j("Username");
        this.startSlots = nBTTagCompound._f("StartSlots");
        this.maxSlots = nBTTagCompound._f("MaxSlots");
        this.slotTypes = NBTTags.getIntegerIntegerMap(nBTTagCompound._n("BankTypes"));
        this.currencyInventory.setFromNBT(nBTTagCompound._m("BankCurrency"));
        this.upgradeInventory.setFromNBT(nBTTagCompound._m("BankUpgrade"));
    }

    public boolean isUpgraded(int n) {
        return this.slotTypes.get(n) != null && (Integer)this.slotTypes.get(n) == 2;
    }

    public boolean canBeUpgraded(int n) {
        return this.upgradeInventory.getStackInSlot(n) == null ? false : this.slotTypes.get(n) == null || (Integer)this.slotTypes.get(n) == 0;
    }

    public int getMaxSlots() {
        for (int i = 0; i < this.maxSlots; ++i) {
            if (this.currencyInventory.getStackInSlot(i) != null || i <= this.startSlots - 1) continue;
            return i;
        }
        return this.maxSlots;
    }
}

