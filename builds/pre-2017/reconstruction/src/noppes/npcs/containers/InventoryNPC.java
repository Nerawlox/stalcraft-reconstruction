/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryNPC
implements IInventory {
    private String inventoryTitle;
    private int slotsCount;
    private ItemStack[] inventoryContents;
    private Container con;

    public InventoryNPC(String string, int n, Container container) {
        this.con = container;
        this.inventoryTitle = string;
        this.slotsCount = n;
        this.inventoryContents = new ItemStack[n];
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return this.inventoryContents[n];
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (this.inventoryContents[n] != null) {
            if (this.inventoryContents[n]._b <= n2) {
                ItemStack itemStack = this.inventoryContents[n];
                this.inventoryContents[n] = null;
                return itemStack;
            }
            ItemStack itemStack = this.inventoryContents[n]._a(n2);
            if (this.inventoryContents[n]._b == 0) {
                this.inventoryContents[n] = null;
            }
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        this.inventoryContents[n] = itemStack;
        if (itemStack != null && itemStack._b > this.getInventoryStackLimit()) {
            itemStack._b = this.getInventoryStackLimit();
        }
    }

    @Override
    public int getSizeInventory() {
        return this.slotsCount;
    }

    @Override
    public String getInvName() {
        return this.inventoryTitle;
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public void onInventoryChanged() {
        this.con.onCraftMatrixChanged(this);
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return false;
    }

    @Override
    public void openChest() {
    }

    @Override
    public void closeChest() {
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        return null;
    }

    @Override
    public boolean isInvNameLocalized() {
        return true;
    }

    @Override
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return true;
    }
}

