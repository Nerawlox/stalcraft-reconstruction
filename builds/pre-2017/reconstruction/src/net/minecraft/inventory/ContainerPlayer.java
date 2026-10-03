/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotArmor;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class ContainerPlayer
extends Container {
    public InventoryCrafting _a = new InventoryCrafting(this, 2, 2);
    public IInventory _b = new InventoryCraftResult();
    public boolean _c;
    public final EntityPlayer _d;

    public ContainerPlayer(InventoryPlayer inventoryPlayer, boolean bl, EntityPlayer entityPlayer) {
        int n;
        int n2;
        this._c = bl;
        this._d = entityPlayer;
        this.addSlotToContainer(new pkzb(inventoryPlayer._e, this._a, this._b, 0, 144, 36));
        for (n2 = 0; n2 < 2; ++n2) {
            for (n = 0; n < 2; ++n) {
                this.addSlotToContainer(new Slot(this._a, n + n2 * 2, 88 + n * 18, 26 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 4; ++n2) {
            n = n2;
            this.addSlotToContainer(new SlotArmor(this, inventoryPlayer, inventoryPlayer.getSizeInventory() - 1 - n2, 8, 8 + n2 * 18, n));
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlotToContainer(new Slot(inventoryPlayer, n + (n2 + 1) * 9, 8 + n * 18, 84 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.addSlotToContainer(new Slot(inventoryPlayer, n2, 8 + n2 * 18, 142));
        }
        this.onCraftMatrixChanged(this._a);
    }

    @Override
    public void onCraftMatrixChanged(IInventory iInventory) {
        this._b.setInventorySlotContents(0, CraftingManager._a()._a(this._a, this._d.worldObj));
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);
        for (int i = 0; i < 4; ++i) {
            ItemStack itemStack = this._a.getStackInSlotOnClosing(i);
            if (itemStack == null) continue;
            entityPlayer.dropPlayerItem(itemStack);
        }
        this._b.setInventorySlotContents(0, null);
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            int n2;
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2._l();
            if (n == 0) {
                if (!this.mergeItemStack(itemStack2, 9, 45, true)) {
                    return null;
                }
                slot.onSlotChange(itemStack2, itemStack);
            } else if (n >= 1 && n < 5 ? !this.mergeItemStack(itemStack2, 9, 45, false) : (n >= 5 && n < 9 ? !this.mergeItemStack(itemStack2, 9, 45, false) : (itemStack._a() instanceof ItemArmor && !((Slot)this.inventorySlots.get(5 + ((ItemArmor)itemStack._a()).armorType)).getHasStack() ? !this.mergeItemStack(itemStack2, n2 = 5 + ((ItemArmor)itemStack._a()).armorType, n2 + 1, false) : (n >= 9 && n < 36 ? !this.mergeItemStack(itemStack2, 36, 45, false) : (n >= 36 && n < 45 ? !this.mergeItemStack(itemStack2, 9, 36, false) : !this.mergeItemStack(itemStack2, 9, 45, false)))))) {
                return null;
            }
            if (itemStack2._b == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
            if (itemStack2._b == itemStack._b) {
                return null;
            }
            slot.onPickupFromSlot(entityPlayer, itemStack2);
        }
        return itemStack;
    }

    @Override
    public boolean func_94530_a(ItemStack itemStack, Slot slot) {
        return slot.inventory != this._b && super.func_94530_a(itemStack, slot);
    }
}

