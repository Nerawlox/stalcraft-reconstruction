/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.inventory;

import codechicken.lib.inventory.InventoryUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class InventoryNBT
implements IInventory {
    protected ItemStack[] items;
    protected NBTTagCompound tag;

    public InventoryNBT(int n, NBTTagCompound nBTTagCompound) {
        this.tag = nBTTagCompound;
        this.items = new ItemStack[n];
        this.readNBT();
    }

    private void writeNBT() {
        this.tag._a("items", InventoryUtils.writeItemStacksToTag(this.items, this.getInventoryStackLimit()));
    }

    private void readNBT() {
        if (this.tag._c("items")) {
            InventoryUtils.readItemStacksFromTag(this.items, this.tag._n("items"));
        }
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
        return "NBT";
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public void onInventoryChanged() {
        this.writeNBT();
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
}

