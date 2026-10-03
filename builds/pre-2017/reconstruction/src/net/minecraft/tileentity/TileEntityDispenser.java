/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.tileentity;

import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDispenser
extends TileEntity
implements IInventory {
    public ItemStack[] _a = new ItemStack[9];
    public Random _b = new Random();
    public String _c;

    @Override
    public int getSizeInventory() {
        return 9;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return this._a[n];
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (this._a[n] != null) {
            if (this._a[n]._b <= n2) {
                ItemStack itemStack = this._a[n];
                this._a[n] = null;
                this.onInventoryChanged();
                return itemStack;
            }
            ItemStack itemStack = this._a[n]._a(n2);
            if (this._a[n]._b == 0) {
                this._a[n] = null;
            }
            this.onInventoryChanged();
            return itemStack;
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        if (this._a[n] != null) {
            ItemStack itemStack = this._a[n];
            this._a[n] = null;
            return itemStack;
        }
        return null;
    }

    public int _a() {
        int n = -1;
        int n2 = 1;
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null || this._b.nextInt(n2++) != 0) continue;
            n = i;
        }
        return n;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        this._a[n] = itemStack;
        if (itemStack != null && itemStack._b > this.getInventoryStackLimit()) {
            itemStack._b = this.getInventoryStackLimit();
        }
        this.onInventoryChanged();
    }

    public int _a(ItemStack itemStack) {
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] != null && this._a[i]._d != 0) continue;
            this.setInventorySlotContents(i, itemStack);
            return i;
        }
        return -1;
    }

    @Override
    public String getInvName() {
        return this.isInvNameLocalized() ? this._c : "container.dispenser";
    }

    public void _a(String string) {
        this._c = string;
    }

    @Override
    public boolean isInvNameLocalized() {
        return this._c != null;
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        NBTTagList nBTTagList = nBTTagCompound._n("Items");
        this._a = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            int n = nBTTagCompound2._d("Slot") & 0xFF;
            if (n < 0 || n >= this._a.length) continue;
            this._a[n] = ItemStack._a(nBTTagCompound2);
        }
        if (nBTTagCompound._c("CustomName")) {
            this._c = nBTTagCompound._j("CustomName");
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null) continue;
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("Slot", (byte)i);
            this._a[i]._b(nBTTagCompound2);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("Items", nBTTagList);
        if (this.isInvNameLocalized()) {
            nBTTagCompound._a("CustomName", this._c);
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        if (this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) {
            return false;
        }
        return !(entityPlayer.getDistanceSq((double)this.xCoord + 0.5, (double)this.yCoord + 0.5, (double)this.zCoord + 0.5) > 64.0);
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

