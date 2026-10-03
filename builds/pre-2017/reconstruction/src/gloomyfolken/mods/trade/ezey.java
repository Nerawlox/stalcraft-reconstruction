/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.trade;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class ezey
implements IInventory {
    private ItemStack[] _b;
    public EntityPlayer _a;
    private int _c;

    public ezey(int n, EntityPlayer entityPlayer) {
        this._b = new ItemStack[n];
        this._a = entityPlayer;
        this._c = n;
    }

    @Override
    public int getSizeInventory() {
        return this._c;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return this._b[n];
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (this._b[n] != null) {
            if (this._b[n]._b <= n2) {
                ItemStack itemStack = this._b[n];
                this._b[n] = null;
                this.onInventoryChanged();
                return itemStack;
            }
            ItemStack itemStack = this._b[n]._a(n2);
            if (this._b[n]._b == 0) {
                this._b[n] = null;
            }
            this.onInventoryChanged();
            return itemStack;
        }
        return null;
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
        this.onInventoryChanged();
    }

    @Override
    public String getInvName() {
        return "Trade";
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
    public void onInventoryChanged() {
        InvokeSideOnly.frontend(!this._a.worldObj.isRemote, () -> {});
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return entityPlayer == this._a;
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

