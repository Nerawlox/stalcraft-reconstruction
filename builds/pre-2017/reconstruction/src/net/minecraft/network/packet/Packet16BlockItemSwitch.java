/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet16BlockItemSwitch
extends Packet {
    public int _a;

    public Packet16BlockItemSwitch() {
    }

    public Packet16BlockItemSwitch(int n) {
        this._a = n;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readShort();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeShort(this._a);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleBlockItemSwitch(this);
    }

    @Override
    public int getPacketSize() {
        return 2;
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

