/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet130UpdateSign;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySign
extends TileEntity {
    public String[] _a = new String[]{"", "", "", ""};
    public int _b = -1;
    public boolean _c = true;
    public EntityPlayer _d;

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        nBTTagCompound._a("Text1", this._a[0]);
        nBTTagCompound._a("Text2", this._a[1]);
        nBTTagCompound._a("Text3", this._a[2]);
        nBTTagCompound._a("Text4", this._a[3]);
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        this._c = false;
        super.readFromNBT(nBTTagCompound);
        for (int i = 0; i < 4; ++i) {
            this._a[i] = nBTTagCompound._j("Text" + (i + 1));
            if (this._a[i].length() <= 15) continue;
            this._a[i] = this._a[i].substring(0, 15);
        }
    }

    @Override
    public Packet getDescriptionPacket() {
        String[] stringArray = new String[4];
        System.arraycopy(this._a, 0, stringArray, 0, 4);
        return new Packet130UpdateSign(this.xCoord, this.yCoord, this.zCoord, stringArray);
    }

    public boolean _a() {
        return this._c;
    }

    public void _a(boolean bl) {
        this._c = bl;
        if (!bl) {
            this._d = null;
        }
    }

    public void _a(EntityPlayer entityPlayer) {
        this._d = entityPlayer;
    }

    public EntityPlayer _b() {
        return this._d;
    }
}

