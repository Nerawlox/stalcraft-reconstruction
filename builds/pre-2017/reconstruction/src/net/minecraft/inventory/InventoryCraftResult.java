/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryCraftResult
implements IInventory {
    public ItemStack[] _a = new ItemStack[1];

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return this._a[0];
    }

    @Override
    public String getInvName() {
        return "Result";
    }

    @Override
    public boolean isInvNameLocalized() {
        return false;
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (this._a[0] != null) {
            ItemStack itemStack = this._a[0];
            this._a[0] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        if (this._a[0] != null) {
            ItemStack itemStack = this._a[0];
            this._a[0] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        this._a[0] = itemStack;
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public void onInventoryChanged() {
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
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return true;
    }
}

