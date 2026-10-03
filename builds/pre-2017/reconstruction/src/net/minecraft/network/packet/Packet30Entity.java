/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet30Entity
extends Packet {
    public int _a;
    public byte _b;
    public byte _c;
    public byte _d;
    public byte _e;
    public byte _f;
    public boolean _g;

    public Packet30Entity() {
    }

    public Packet30Entity(int n) {
        this._a = n;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleEntity(this);
    }

    @Override
    public int getPacketSize() {
        return 4;
    }

    @Override
    public String toString() {
        return "Entity_" + super.toString();
    }

    @Override
    public boolean isRealPacket() {
        return true;
    }

    @Override
    public boolean containsSameEntityIDAs(Packet packet) {
        Packet30Entity packet30Entity = (Packet30Entity)packet;
        return packet30Entity._a == this._a;
    }
}

