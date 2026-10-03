/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import noppes.npcs.containers.ContainerNPCTrader;

public class InventoryNpcTrader
implements IInventory {
    private String inventoryTitle;
    private int slotsCount;
    private ItemStack[] inventoryContents;
    private ContainerNPCTrader con;

    public InventoryNpcTrader(String string, int n, ContainerNPCTrader containerNPCTrader) {
        this.con = containerNPCTrader;
        this.inventoryTitle = string;
        this.slotsCount = n;
        this.inventoryContents = new ItemStack[n];
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        ItemStack itemStack = this.inventoryContents[n];
        return itemStack == null ? null : ItemStack._c(itemStack);
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (this.inventoryContents[n] != null) {
            ItemStack itemStack = this.inventoryContents[n];
            return ItemStack._c(itemStack);
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        if (itemStack != null) {
            this.inventoryContents[n] = itemStack._l();
        }
        this.onInventoryChanged();
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
        return true;
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

