/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.inventory;

import codechicken.lib.inventory.InventoryUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventorySimple
implements IInventory {
    public ItemStack[] items;
    public int limit;
    public String name;

    public InventorySimple(ItemStack[] itemStackArray, int n, String string) {
        this.items = itemStackArray;
        this.limit = n;
        this.name = string;
    }

    public InventorySimple(ItemStack[] itemStackArray, String string) {
        this(itemStackArray, 64, string);
    }

    public InventorySimple(ItemStack[] itemStackArray, int n) {
        this(itemStackArray, n, "inv");
    }

    public InventorySimple(ItemStack[] itemStackArray) {
        this(itemStackArray, 64, "inv");
    }

    public InventorySimple(int n, int n2, String string) {
        this(new ItemStack[n], n2, string);
    }

    public InventorySimple(int n, int n2) {
        this(n, n2, "inv");
    }

    public InventorySimple(int n, String string) {
        this(n, 64, string);
    }

    public InventorySimple(int n) {
        this(n, 64, "inv");
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
        return this.name;
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
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

    @Override
    public boolean isInvNameLocalized() {
        return true;
    }

    @Override
    public void onInventoryChanged() {
    }
}

