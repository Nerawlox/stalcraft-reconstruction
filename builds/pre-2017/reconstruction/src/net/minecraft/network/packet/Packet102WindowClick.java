/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet102WindowClick
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public short _d;
    public ItemStack _e;
    public int _f;

    public Packet102WindowClick() {
    }

    public Packet102WindowClick(int n, int n2, int n3, int n4, ItemStack itemStack, short s) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._e = itemStack != null ? itemStack._l() : null;
        this._d = s;
        this._f = n4;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleWindowClick(this);
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readByte();
        this._b = dataInput.readShort();
        this._c = dataInput.readByte();
        this._d = dataInput.readShort();
        this._f = dataInput.readByte();
        this._e = Packet102WindowClick.readItemStack(dataInput);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
        dataOutput.writeShort(this._b);
        dataOutput.writeByte(this._c);
        dataOutput.writeShort(this._d);
        dataOutput.writeByte(this._f);
        Packet102WindowClick.writeItemStack(this._e, dataOutput);
    }

    @Override
    public int getPacketSize() {
        return 11;
    }
}

