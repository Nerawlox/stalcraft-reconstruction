/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet18Animation
extends Packet {
    public int _a;
    public int _b;

    public Packet18Animation() {
    }

    public Packet18Animation(Entity entity, int n) {
        this._a = entity.entityId;
        this._b = n;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readByte();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._b);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleAnimation(this);
    }

    @Override
    public int getPacketSize() {
        return 5;
    }
}

