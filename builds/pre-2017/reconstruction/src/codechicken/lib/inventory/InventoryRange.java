/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryRange {
    public IInventory inv;
    public int side;
    public gaaa sidedInv;
    public int[] slots;

    public InventoryRange(IInventory iInventory, int n) {
        this.inv = iInventory;
        this.side = n;
        if (iInventory instanceof gaaa) {
            this.sidedInv = (gaaa)iInventory;
            this.slots = this.sidedInv._a(n);
        } else {
            this.slots = new int[iInventory.getSizeInventory()];
            for (int i = 0; i < this.slots.length; ++i) {
                this.slots[i] = i;
            }
        }
    }

    public InventoryRange(IInventory iInventory) {
        this(iInventory, 0);
    }

    public InventoryRange(IInventory iInventory, int n, int n2) {
        this.inv = iInventory;
        this.slots = new int[n2 - n];
        for (int i = 0; i < this.slots.length; ++i) {
            this.slots[i] = n + i;
        }
    }

    public InventoryRange(IInventory iInventory, InventoryRange inventoryRange) {
        this.inv = iInventory;
        this.slots = inventoryRange.slots;
        this.side = inventoryRange.side;
        if (iInventory instanceof gaaa) {
            this.sidedInv = (gaaa)iInventory;
        }
    }

    public boolean canInsertItem(int n, ItemStack itemStack) {
        return this.sidedInv == null ? this.inv.isItemValidForSlot(n, itemStack) : this.sidedInv._a(n, itemStack, this.side);
    }

    public boolean canExtractItem(int n, ItemStack itemStack) {
        return this.sidedInv == null ? this.inv.isItemValidForSlot(n, itemStack) : this.sidedInv._b(n, itemStack, this.side);
    }

    public int lastSlot() {
        int n = 0;
        for (int n2 : this.slots) {
            if (n2 <= n) continue;
            n = n2;
        }
        return n;
    }
}

