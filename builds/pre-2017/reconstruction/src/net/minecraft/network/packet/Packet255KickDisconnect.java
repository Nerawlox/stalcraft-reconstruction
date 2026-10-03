/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet255KickDisconnect
extends Packet {
    public String _a;

    public Packet255KickDisconnect() {
    }

    public Packet255KickDisconnect(String string) {
        this._a = string;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = Packet255KickDisconnect.readString(dataInput, 256);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        Packet255KickDisconnect.writeString(this._a, dataOutput);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleKickDisconnect(this);
    }

    @Override
    public int getPacketSize() {
        return this._a.length();
    }

    @Override
    public boolean isRealPacket() {
        return true;
    }

    @Override
    public boolean containsSameEntityIDAs(Packet packet) {
        return true;
    }
}

