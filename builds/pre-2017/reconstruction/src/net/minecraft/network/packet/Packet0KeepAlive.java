/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet0KeepAlive
extends Packet {
    public int _a;

    public Packet0KeepAlive() {
    }

    public Packet0KeepAlive(int n) {
        this._a = n;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleKeepAlive(this);
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
    public int getPacketSize() {
        return 4;
    }

    @Override
    public boolean isRealPacket() {
        return true;
    }

    @Override
    public boolean containsSameEntityIDAs(Packet packet) {
        return true;
    }

    @Override
    public boolean canProcessAsync() {
        return true;
    }
}

