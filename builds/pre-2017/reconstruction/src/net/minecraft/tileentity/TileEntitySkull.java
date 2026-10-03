/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySkull
extends TileEntity {
    public int _a;
    public int _b;
    public String _c = "";

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        nBTTagCompound._a("SkullType", (byte)(this._a & 0xFF));
        nBTTagCompound._a("Rot", (byte)(this._b & 0xFF));
        nBTTagCompound._a("ExtraType", this._c);
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        this._a = nBTTagCompound._d("SkullType");
        this._b = nBTTagCompound._d("Rot");
        if (nBTTagCompound._c("ExtraType")) {
            this._c = nBTTagCompound._j("ExtraType");
        }
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        this.writeToNBT(nBTTagCompound);
        return new wpte(this.xCoord, this.yCoord, this.zCoord, 4, nBTTagCompound);
    }

    public void _a(int n, String string) {
        this._a = n;
        this._c = string;
    }

    public int _a() {
        return this._a;
    }

    public int _b() {
        return this._b;
    }

    public void _a(int n) {
        this._b = n;
    }

    public String _c() {
        return this._c;
    }
}

