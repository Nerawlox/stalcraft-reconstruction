/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet106Transaction
extends Packet {
    public int _a;
    public short _b;
    public boolean _c;

    public Packet106Transaction() {
    }

    public Packet106Transaction(int n, short s, boolean bl) {
        this._a = n;
        this._b = s;
        this._c = bl;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleTransaction(this);
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readByte();
        this._b = dataInput.readShort();
        this._c = dataInput.readByte() != 0;
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
        dataOutput.writeShort(this._b);
        dataOutput.writeByte(this._c ? 1 : 0);
    }

    @Override
    public int getPacketSize() {
        return 4;
    }
}

