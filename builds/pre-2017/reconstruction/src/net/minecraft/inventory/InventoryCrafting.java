/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryCrafting
implements IInventory {
    public ItemStack[] stackList;
    public int inventoryWidth;
    public Container eventHandler;

    public InventoryCrafting(Container container, int n, int n2) {
        int n3 = n * n2;
        this.stackList = new ItemStack[n3];
        this.eventHandler = container;
        this.inventoryWidth = n;
    }

    @Override
    public int getSizeInventory() {
        return this.stackList.length;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        if (n >= this.getSizeInventory()) {
            return null;
        }
        return this.stackList[n];
    }

    public ItemStack getStackInRowAndColumn(int n, int n2) {
        if (n < 0 || n >= this.inventoryWidth) {
            return null;
        }
        int n3 = n + n2 * this.inventoryWidth;
        return this.getStackInSlot(n3);
    }

    @Override
    public String getInvName() {
        return "container.crafting";
    }

    @Override
    public boolean isInvNameLocalized() {
        return false;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        if (this.stackList[n] != null) {
            ItemStack itemStack = this.stackList[n];
            this.stackList[n] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (this.stackList[n] != null) {
            if (this.stackList[n]._b <= n2) {
                ItemStack itemStack = this.stackList[n];
                this.stackList[n] = null;
                this.eventHandler.onCraftMatrixChanged(this);
                return itemStack;
            }
            ItemStack itemStack = this.stackList[n]._a(n2);
            if (this.stackList[n]._b == 0) {
                this.stackList[n] = null;
            }
            this.eventHandler.onCraftMatrixChanged(this);
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        this.stackList[n] = itemStack;
        this.eventHandler.onCraftMatrixChanged(this);
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

