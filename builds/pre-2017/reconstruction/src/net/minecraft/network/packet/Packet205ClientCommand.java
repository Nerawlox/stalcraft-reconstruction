/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet205ClientCommand
extends Packet {
    public int _a;

    public Packet205ClientCommand() {
    }

    public Packet205ClientCommand(int n) {
        this._a = n;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readByte();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeByte(this._a & 0xFF);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleClientCommand(this);
    }

    @Override
    public int getPacketSize() {
        return 1;
    }
}

