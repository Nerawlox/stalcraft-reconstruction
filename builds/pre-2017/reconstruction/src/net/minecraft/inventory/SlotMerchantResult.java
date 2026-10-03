/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryMerchant;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;

public class SlotMerchantResult
extends Slot {
    public final InventoryMerchant _a;
    public EntityPlayer _b;
    public int _c;
    public final IMerchant _d;

    public SlotMerchantResult(EntityPlayer entityPlayer, IMerchant iMerchant, InventoryMerchant inventoryMerchant, int n, int n2, int n3) {
        super(inventoryMerchant, n, n2, n3);
        this._b = entityPlayer;
        this._d = iMerchant;
        this._a = inventoryMerchant;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return false;
    }

    @Override
    public ItemStack decrStackSize(int n) {
        if (this.getHasStack()) {
            this._c += Math.min(n, this.getStack()._b);
        }
        return super.decrStackSize(n);
    }

    @Override
    public void onCrafting(ItemStack itemStack, int n) {
        this._c += n;
        this.onCrafting(itemStack);
    }

    @Override
    public void onCrafting(ItemStack itemStack) {
        itemStack._a(this._b.worldObj, this._b, this._c);
        this._c = 0;
    }

    @Override
    public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack) {
        ItemStack itemStack2;
        ItemStack itemStack3;
        this.onCrafting(itemStack);
        MerchantRecipe merchantRecipe = this._a._b();
        if (merchantRecipe != null && (this._a(merchantRecipe, itemStack3 = this._a.getStackInSlot(0), itemStack2 = this._a.getStackInSlot(1)) || this._a(merchantRecipe, itemStack2, itemStack3))) {
            this._d.useRecipe(merchantRecipe);
            if (itemStack3 != null && itemStack3._b <= 0) {
                itemStack3 = null;
            }
            if (itemStack2 != null && itemStack2._b <= 0) {
                itemStack2 = null;
            }
            this._a.setInventorySlotContents(0, itemStack3);
            this._a.setInventorySlotContents(1, itemStack2);
        }
    }

    public boolean _a(MerchantRecipe merchantRecipe, ItemStack itemStack, ItemStack itemStack2) {
        ItemStack itemStack3 = merchantRecipe._a();
        ItemStack itemStack4 = merchantRecipe._b();
        if (itemStack != null && itemStack._d == itemStack3._d) {
            if (itemStack4 != null && itemStack2 != null && itemStack4._d == itemStack2._d) {
                itemStack._b -= itemStack3._b;
                itemStack2._b -= itemStack4._b;
                return true;
            }
            if (itemStack4 == null && itemStack2 == null) {
                itemStack._b -= itemStack3._b;
                return true;
            }
        }
        return false;
    }
}

