/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet70GameEvent
extends Packet {
    public static final String[] _a = new String[]{"tile.bed.notValid", null, null, "gameMode.changed"};
    public int _b;
    public int _c;

    public Packet70GameEvent() {
    }

    public Packet70GameEvent(int n, int n2) {
        this._b = n;
        this._c = n2;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._b = dataInput.readByte();
        this._c = dataInput.readByte();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeByte(this._b);
        dataOutput.writeByte(this._c);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleGameEvent(this);
    }

    @Override
    public int getPacketSize() {
        return 2;
    }
}

