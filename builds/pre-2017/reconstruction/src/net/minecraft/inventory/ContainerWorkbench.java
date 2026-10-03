/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

public class ContainerWorkbench
extends Container {
    public InventoryCrafting _a = new InventoryCrafting(this, 3, 3);
    public IInventory _b = new InventoryCraftResult();
    public World _c;
    public int _d;
    public int _e;
    public int _f;

    public ContainerWorkbench(InventoryPlayer inventoryPlayer, World world, int n, int n2, int n3) {
        int n4;
        int n5;
        this._c = world;
        this._d = n;
        this._e = n2;
        this._f = n3;
        this.addSlotToContainer(new pkzb(inventoryPlayer._e, this._a, this._b, 0, 124, 35));
        for (n5 = 0; n5 < 3; ++n5) {
            for (n4 = 0; n4 < 3; ++n4) {
                this.addSlotToContainer(new Slot(this._a, n4 + n5 * 3, 30 + n4 * 18, 17 + n5 * 18));
            }
        }
        for (n5 = 0; n5 < 3; ++n5) {
            for (n4 = 0; n4 < 9; ++n4) {
                this.addSlotToContainer(new Slot(inventoryPlayer, n4 + n5 * 9 + 9, 8 + n4 * 18, 84 + n5 * 18));
            }
        }
        for (n5 = 0; n5 < 9; ++n5) {
            this.addSlotToContainer(new Slot(inventoryPlayer, n5, 8 + n5 * 18, 142));
        }
        this.onCraftMatrixChanged(this._a);
    }

    @Override
    public void onCraftMatrixChanged(IInventory iInventory) {
        this._b.setInventorySlotContents(0, CraftingManager._a()._a(this._a, this._c));
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);
        if (this._c.isRemote) {
            return;
        }
        for (int i = 0; i < 9; ++i) {
            ItemStack itemStack = this._a.getStackInSlotOnClosing(i);
            if (itemStack == null) continue;
            entityPlayer.dropPlayerItem(itemStack);
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        if (this._c.getBlockId(this._d, this._e, this._f) != Block.workbench.blockID) {
            return false;
        }
        return !(entityPlayer.getDistanceSq((double)this._d + 0.5, (double)this._e + 0.5, (double)this._f + 0.5) > 64.0);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2._l();
            if (n == 0) {
                if (!this.mergeItemStack(itemStack2, 10, 46, true)) {
                    return null;
                }
                slot.onSlotChange(itemStack2, itemStack);
            } else if (n >= 10 && n < 37 ? !this.mergeItemStack(itemStack2, 37, 46, false) : (n >= 37 && n < 46 ? !this.mergeItemStack(itemStack2, 10, 37, false) : !this.mergeItemStack(itemStack2, 10, 46, false))) {
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

