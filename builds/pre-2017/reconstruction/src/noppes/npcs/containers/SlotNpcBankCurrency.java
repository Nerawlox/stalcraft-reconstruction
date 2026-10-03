/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import noppes.npcs.containers.ContainerNPCBankInterface;

public class SlotNpcBankCurrency
extends Slot {
    public ItemStack item;

    public SlotNpcBankCurrency(ContainerNPCBankInterface containerNPCBankInterface, IInventory iInventory, int n, int n2, int n3) {
        super(iInventory, n, n2, n3);
    }

    @Override
    public int getSlotStackLimit() {
        return 64;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return this.item == null ? false : this.item._d == itemStack._d && (!this.item._g() || this.item._j() == itemStack._j());
    }
}

