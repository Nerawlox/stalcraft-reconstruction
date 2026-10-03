/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryBasic
implements IInventory {
    public String _b;
    public int _c;
    public ItemStack[] _d;
    public List _e;
    public boolean _f;

    public InventoryBasic(String string, boolean bl, int n) {
        this._b = string;
        this._f = bl;
        this._c = n;
        this._d = new ItemStack[n];
    }

    public void _a(suea suea2) {
        if (this._e == null) {
            this._e = new ArrayList();
        }
        this._e.add(suea2);
    }

    public void _b(suea suea2) {
        this._e.remove(suea2);
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return this._d[n];
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (this._d[n] != null) {
            if (this._d[n]._b <= n2) {
                ItemStack itemStack = this._d[n];
                this._d[n] = null;
                this.onInventoryChanged();
                return itemStack;
            }
            ItemStack itemStack = this._d[n]._a(n2);
            if (this._d[n]._b == 0) {
                this._d[n] = null;
            }
            this.onInventoryChanged();
            return itemStack;
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        if (this._d[n] != null) {
            ItemStack itemStack = this._d[n];
            this._d[n] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        this._d[n] = itemStack;
        if (itemStack != null && itemStack._b > this.getInventoryStackLimit()) {
            itemStack._b = this.getInventoryStackLimit();
        }
        this.onInventoryChanged();
    }

    @Override
    public int getSizeInventory() {
        return this._c;
    }

    @Override
    public String getInvName() {
        return this._b;
    }

    @Override
    public boolean isInvNameLocalized() {
        return this._f;
    }

    public void _a(String string) {
        this._f = true;
        this._b = string;
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public void onInventoryChanged() {
        if (this._e != null) {
            for (int i = 0; i < this._e.size(); ++i) {
                ((suea)this._e.get(i)).onInventoryChanged(this);
            }
        }
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
}

