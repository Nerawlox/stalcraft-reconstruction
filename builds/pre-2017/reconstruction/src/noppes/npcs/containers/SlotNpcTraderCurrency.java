/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import noppes.npcs.containers.ContainerNPCTrader;

class SlotNpcTraderCurrency
extends Slot {
    final ContainerNPCTrader inventory;

    public SlotNpcTraderCurrency(ContainerNPCTrader containerNPCTrader, IInventory iInventory, int n, int n2, int n3) {
        super(iInventory, n, n2, n3);
        this.inventory = containerNPCTrader;
    }

    @Override
    public int getSlotStackLimit() {
        return 64;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return true;
    }
}

