/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRecordPlayer
extends TileEntity {
    public ItemStack _a;

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        if (nBTTagCompound._c("RecordItem")) {
            this._a(ItemStack._a(nBTTagCompound._m("RecordItem")));
        } else if (nBTTagCompound._f("Record") > 0) {
            this._a(new ItemStack(nBTTagCompound._f("Record"), 1, 0));
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        if (this._a() != null) {
            nBTTagCompound._a("RecordItem", this._a()._b(new NBTTagCompound()));
            nBTTagCompound._a("Record", this._a()._d);
        }
    }

    public ItemStack _a() {
        return this._a;
    }

    public void _a(ItemStack itemStack) {
        this._a = itemStack;
        this.onInventoryChanged();
    }
}

