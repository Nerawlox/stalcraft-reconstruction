/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import noppes.npcs.controllers.Bank;

public class ContainerManageBanks
extends Container {
    public Bank bank = new Bank();

    public ContainerManageBanks(EntityPlayer entityPlayer) {
        int n;
        int n2;
        int n3;
        int n4;
        for (n4 = 0; n4 < 6; ++n4) {
            n3 = 36;
            n2 = 21;
            n = n2 + n4 * 22;
            this.addSlotToContainer(new Slot(this.bank.currencyInventory, n4, n3, n));
        }
        for (n4 = 0; n4 < 6; ++n4) {
            n3 = 142;
            n2 = 21;
            n = n2 + n4 * 22;
            this.addSlotToContainer(new Slot(this.bank.upgradeInventory, n4, n3, n));
        }
        for (n4 = 0; n4 < 9; ++n4) {
            this.addSlotToContainer(new Slot(entityPlayer.inventory, n4, 8 + n4 * 18, 154));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2._l();
            if (n >= 0 && n < 7 ? !this.mergeItemStack(itemStack2, 7, 43, true) : (n >= 20 && n < 47 ? !this.mergeItemStack(itemStack2, 36, 43, false) : (n >= 47 && n < 56 ? !this.mergeItemStack(itemStack2, 7, 34, false) : !this.mergeItemStack(itemStack2, 7, 43, false)))) {
                return null;
            }
            if (itemStack2._b == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
            if (itemStack2._b == itemStack._b) {
                return null;
            }
            slot.onPickupFromSlot(entityPlayer, itemStack2);
        }
        return itemStack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    public void setBank(Bank bank) {
        for (int i = 0; i < 6; ++i) {
            this.bank.currencyInventory.setInventorySlotContents(i, bank.currencyInventory.getStackInSlot(i));
            this.bank.upgradeInventory.setInventorySlotContents(i, bank.upgradeInventory.getStackInSlot(i));
        }
    }
}

