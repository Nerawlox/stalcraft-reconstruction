/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.inventory;

import codechicken.lib.inventory.InventoryRange;
import codechicken.lib.inventory.InventoryUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryCopy
implements IInventory {
    public boolean[] accessible;
    public ItemStack[] items;
    public IInventory inv;

    public InventoryCopy(IInventory iInventory) {
        this.items = new ItemStack[iInventory.getSizeInventory()];
        this.accessible = new boolean[iInventory.getSizeInventory()];
        this.inv = iInventory;
        this.update();
    }

    public void update() {
        for (int i = 0; i < this.items.length; ++i) {
            ItemStack itemStack = this.inv.getStackInSlot(i);
            if (itemStack == null) continue;
            this.items[i] = itemStack._l();
        }
    }

    public InventoryCopy open(InventoryRange inventoryRange) {
        int n = inventoryRange.lastSlot();
        if (n > this.accessible.length) {
            boolean[] objectArray = new boolean[n];
            ItemStack[] itemStackArray = new ItemStack[n];
            System.arraycopy(this.accessible, 0, objectArray, 0, this.accessible.length);
            System.arraycopy(this.items, 0, itemStackArray, 0, this.items.length);
            this.accessible = objectArray;
            this.items = itemStackArray;
        }
        for (int n2 : inventoryRange.slots) {
            this.accessible[n2] = true;
        }
        return this;
    }

    @Override
    public int getSizeInventory() {
        return this.items.length;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return this.items[n];
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        return InventoryUtils.decrStackSize(this, n, n2);
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        return InventoryUtils.getStackInSlotOnClosing(this, n);
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        this.items[n] = itemStack;
        this.onInventoryChanged();
    }

    @Override
    public String getInvName() {
        return "copy";
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void openChest() {
    }

    @Override
    public void closeChest() {
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public void onInventoryChanged() {
    }

    @Override
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return this.inv.isItemValidForSlot(n, itemStack);
    }

    @Override
    public boolean isInvNameLocalized() {
        return true;
    }
}

