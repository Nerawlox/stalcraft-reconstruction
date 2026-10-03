/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryMerchant;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotMerchantResult;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerMerchant
extends Container {
    public IMerchant _a;
    public InventoryMerchant _b;
    public final World _c;

    public ContainerMerchant(InventoryPlayer inventoryPlayer, IMerchant iMerchant, World world) {
        int n;
        this._a = iMerchant;
        this._c = world;
        this._b = new InventoryMerchant(inventoryPlayer._e, iMerchant);
        this.addSlotToContainer(new Slot(this._b, 0, 36, 53));
        this.addSlotToContainer(new Slot(this._b, 1, 62, 53));
        this.addSlotToContainer(new SlotMerchantResult(inventoryPlayer._e, iMerchant, this._b, 2, 120, 53));
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(inventoryPlayer, i + n * 9 + 9, 8 + i * 18, 84 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.addSlotToContainer(new Slot(inventoryPlayer, n, 8 + n * 18, 142));
        }
    }

    public InventoryMerchant _a() {
        return this._b;
    }

    @Override
    public void func_75132_a(ICrafting iCrafting) {
        super.func_75132_a(iCrafting);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
    }

    @Override
    public void onCraftMatrixChanged(IInventory iInventory) {
        this._b._a();
        super.onCraftMatrixChanged(iInventory);
    }

    public void _a(int n) {
        this._b._b(n);
    }

    @Override
    public void updateProgressBar(int n, int n2) {
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this._a.getCustomer() == entityPlayer;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2._l();
            if (n == 2) {
                if (!this.mergeItemStack(itemStack2, 3, 39, true)) {
                    return null;
                }
                slot.onSlotChange(itemStack2, itemStack);
            } else if (n == 0 || n == 1 ? !this.mergeItemStack(itemStack2, 3, 39, false) : (n >= 3 && n < 30 ? !this.mergeItemStack(itemStack2, 30, 39, false) : n >= 30 && n < 39 && !this.mergeItemStack(itemStack2, 3, 30, false))) {
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
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);
        this._a.setCustomer(null);
        super.onContainerClosed(entityPlayer);
        if (this._c.isRemote) {
            return;
        }
        ItemStack itemStack = this._b.getStackInSlotOnClosing(0);
        if (itemStack != null) {
            entityPlayer.dropPlayerItem(itemStack);
        }
        if ((itemStack = this._b.getStackInSlotOnClosing(1)) != null) {
            entityPlayer.dropPlayerItem(itemStack);
        }
    }
}

