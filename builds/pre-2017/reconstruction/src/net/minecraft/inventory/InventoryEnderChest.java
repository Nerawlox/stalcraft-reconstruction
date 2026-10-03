/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryEnderChest
extends InventoryBasic {
    public gaqr _a;

    public InventoryEnderChest() {
        super("container.enderchest", false, 27);
    }

    public void _a(gaqr gaqr2) {
        this._a = gaqr2;
    }

    public void _a(NBTTagList nBTTagList) {
        int n;
        for (n = 0; n < this.getSizeInventory(); ++n) {
            this.setInventorySlotContents(n, null);
        }
        for (n = 0; n < nBTTagList._d(); ++n) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(n);
            int n2 = nBTTagCompound._d("Slot") & 0xFF;
            if (n2 < 0 || n2 >= this.getSizeInventory()) continue;
            this.setInventorySlotContents(n2, ItemStack._a(nBTTagCompound));
        }
    }

    public NBTTagList _a() {
        NBTTagList nBTTagList = new NBTTagList("EnderItems");
        for (int i = 0; i < this.getSizeInventory(); ++i) {
            ItemStack itemStack = this.getStackInSlot(i);
            if (itemStack == null) continue;
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Slot", (byte)i);
            itemStack._b(nBTTagCompound);
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        if (this._a != null && !this._a._a(entityPlayer)) {
            return false;
        }
        return super.isUseableByPlayer(entityPlayer);
    }

    @Override
    public void openChest() {
        if (this._a != null) {
            this._a._a();
        }
        super.openChest();
    }

    @Override
    public void closeChest() {
        if (this._a != null) {
            this._a._b();
        }
        super.closeChest();
        this._a = null;
    }

    @Override
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return true;
    }
}

