/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet108EnchantItem
extends Packet {
    public int _a;
    public int _b;

    public Packet108EnchantItem() {
    }

    public Packet108EnchantItem(int n, int n2) {
        this._a = n;
        this._b = n2;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleEnchantItem(this);
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readByte();
        this._b = dataInput.readByte();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
        dataOutput.writeByte(this._b);
    }

    @Override
    public int getPacketSize() {
        return 2;
    }
}

