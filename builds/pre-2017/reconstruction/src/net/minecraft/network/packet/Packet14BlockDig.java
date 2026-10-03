/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet14BlockDig
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;

    public Packet14BlockDig() {
    }

    public Packet14BlockDig(int n, int n2, int n3, int n4, int n5) {
        this._e = n;
        this._a = n2;
        this._b = n3;
        this._c = n4;
        this._d = n5;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._e = dataInput.readUnsignedByte();
        this._a = dataInput.readInt();
        this._b = dataInput.readUnsignedByte();
        this._c = dataInput.readInt();
        this._d = dataInput.readUnsignedByte();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.write(this._e);
        dataOutput.writeInt(this._a);
        dataOutput.write(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.write(this._d);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleBlockDig(this);
    }

    @Override
    public int getPacketSize() {
        return 11;
    }
}

