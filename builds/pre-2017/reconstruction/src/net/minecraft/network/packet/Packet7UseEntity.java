/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet7UseEntity
extends Packet {
    public int _a;
    public int _b;
    public int _c;

    public Packet7UseEntity() {
    }

    public Packet7UseEntity(int n, int n2, int n3) {
        this._a = n;
        this._b = n2;
        this._c = n3;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readByte();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeByte(this._c);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleUseEntity(this);
    }

    @Override
    public int getPacketSize() {
        return 9;
    }
}

