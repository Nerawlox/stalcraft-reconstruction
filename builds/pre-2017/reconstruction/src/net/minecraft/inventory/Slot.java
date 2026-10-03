/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;

public class Slot {
    public final int slotIndex;
    public final IInventory inventory;
    public int slotNumber;
    public int xDisplayPosition;
    public int yDisplayPosition;
    public Icon backgroundIcon = null;
    @SideOnly(value=Side.CLIENT)
    public ResourceLocation texture;

    public Slot(IInventory iInventory, int n, int n2, int n3) {
        this.inventory = iInventory;
        this.slotIndex = n;
        this.xDisplayPosition = n2;
        this.yDisplayPosition = n3;
    }

    public void onSlotChange(ItemStack itemStack, ItemStack itemStack2) {
        int n;
        if (itemStack != null && itemStack2 != null && itemStack._d == itemStack2._d && (n = itemStack2._b - itemStack._b) > 0) {
            this.onCrafting(itemStack, n);
        }
    }

    public void onCrafting(ItemStack itemStack, int n) {
    }

    public void onCrafting(ItemStack itemStack) {
    }

    public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack) {
        this.onSlotChanged();
    }

    public boolean isItemValid(ItemStack itemStack) {
        return true;
    }

    public ItemStack getStack() {
        return this.inventory.getStackInSlot(this.slotIndex);
    }

    public boolean getHasStack() {
        return this.getStack() != null;
    }

    public void putStack(ItemStack itemStack) {
        this.inventory.setInventorySlotContents(this.slotIndex, itemStack);
        this.onSlotChanged();
    }

    public void onSlotChanged() {
        GloomyHooks.onSlotChanged(this);
        this.inventory.onInventoryChanged();
    }

    public int getSlotStackLimit() {
        return this.inventory.getInventoryStackLimit();
    }

    public ItemStack decrStackSize(int n) {
        return this.inventory.decrStackSize(this.slotIndex, n);
    }

    public boolean func_75217_a(IInventory iInventory, int n) {
        return iInventory == this.inventory && n == this.slotIndex;
    }

    public boolean canTakeStack(EntityPlayer entityPlayer) {
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public Icon getBackgroundIconIndex() {
        return this.backgroundIcon;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_111238_b() {
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public ResourceLocation getBackgroundIconTexture() {
        return this.texture == null ? sctd._e : this.texture;
    }

    public void setBackgroundIcon(Icon icon) {
        this.backgroundIcon = icon;
    }

    @SideOnly(value=Side.CLIENT)
    public void setBackgroundIconTexture(ResourceLocation resourceLocation) {
        this.texture = resourceLocation;
    }

    public int getSlotIndex() {
        return this.slotIndex;
    }
}

