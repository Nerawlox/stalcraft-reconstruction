/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

public class InventoryMerchant
implements IInventory {
    public final IMerchant _a;
    public ItemStack[] _b = new ItemStack[3];
    public final EntityPlayer _c;
    public MerchantRecipe _d;
    public int _e;

    public InventoryMerchant(EntityPlayer entityPlayer, IMerchant iMerchant) {
        this._c = entityPlayer;
        this._a = iMerchant;
    }

    @Override
    public int getSizeInventory() {
        return this._b.length;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return this._b[n];
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (this._b[n] != null) {
            if (n == 2) {
                ItemStack itemStack = this._b[n];
                this._b[n] = null;
                return itemStack;
            }
            if (this._b[n]._b <= n2) {
                ItemStack itemStack = this._b[n];
                this._b[n] = null;
                if (this._a(n)) {
                    this._a();
                }
                return itemStack;
            }
            ItemStack itemStack = this._b[n]._a(n2);
            if (this._b[n]._b == 0) {
                this._b[n] = null;
            }
            if (this._a(n)) {
                this._a();
            }
            return itemStack;
        }
        return null;
    }

    public boolean _a(int n) {
        return n == 0 || n == 1;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        if (this._b[n] != null) {
            ItemStack itemStack = this._b[n];
            this._b[n] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        this._b[n] = itemStack;
        if (itemStack != null && itemStack._b > this.getInventoryStackLimit()) {
            itemStack._b = this.getInventoryStackLimit();
        }
        if (this._a(n)) {
            this._a();
        }
    }

    @Override
    public String getInvName() {
        return "mob.villager";
    }

    @Override
    public boolean isInvNameLocalized() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this._a.getCustomer() == entityPlayer;
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
    public void onInventoryChanged() {
        this._a();
    }

    public void _a() {
        this._d = null;
        ItemStack itemStack = this._b[0];
        ItemStack itemStack2 = this._b[1];
        if (itemStack == null) {
            itemStack = itemStack2;
            itemStack2 = null;
        }
        if (itemStack == null) {
            this.setInventorySlotContents(2, null);
        } else {
            MerchantRecipeList merchantRecipeList = this._a.getRecipes(this._c);
            if (merchantRecipeList != null) {
                MerchantRecipe merchantRecipe = merchantRecipeList._a(itemStack, itemStack2, this._e);
                if (merchantRecipe != null && !merchantRecipe._f()) {
                    this._d = merchantRecipe;
                    this.setInventorySlotContents(2, merchantRecipe._d()._l());
                } else if (itemStack2 != null) {
                    merchantRecipe = merchantRecipeList._a(itemStack2, itemStack, this._e);
                    if (merchantRecipe != null && !merchantRecipe._f()) {
                        this._d = merchantRecipe;
                        this.setInventorySlotContents(2, merchantRecipe._d()._l());
                    } else {
                        this.setInventorySlotContents(2, null);
                    }
                } else {
                    this.setInventorySlotContents(2, null);
                }
            }
        }
        this._a.func_110297_a_(this.getStackInSlot(2));
    }

    public MerchantRecipe _b() {
        return this._d;
    }

    public void _b(int n) {
        this._e = n;
        this._a();
    }
}

