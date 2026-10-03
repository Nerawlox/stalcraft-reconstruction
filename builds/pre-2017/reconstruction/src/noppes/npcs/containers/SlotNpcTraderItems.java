/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

class SlotNpcTraderItems
extends Slot {
    public SlotNpcTraderItems(IInventory iInventory, int n, int n2, int n3) {
        super(iInventory, n, n2, n3);
    }

    public void onPickupFromSlot(ItemStack itemStack) {
        if (itemStack != null && this.getStack() != null && itemStack._d == this.getStack()._d) {
            --itemStack._b;
        }
    }

    @Override
    public int getSlotStackLimit() {
        return 64;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return false;
    }
}

