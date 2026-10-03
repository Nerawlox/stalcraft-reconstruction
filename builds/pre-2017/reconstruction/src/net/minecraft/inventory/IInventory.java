/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IInventory {
    public int getSizeInventory();

    public ItemStack getStackInSlot(int var1);

    public ItemStack decrStackSize(int var1, int var2);

    public ItemStack getStackInSlotOnClosing(int var1);

    public void setInventorySlotContents(int var1, ItemStack var2);

    public String getInvName();

    public boolean isInvNameLocalized();

    public int getInventoryStackLimit();

    public void onInventoryChanged();

    public boolean isUseableByPlayer(EntityPlayer var1);

    public void openChest();

    public void closeChest();

    public boolean isItemValidForSlot(int var1, ItemStack var2);
}

