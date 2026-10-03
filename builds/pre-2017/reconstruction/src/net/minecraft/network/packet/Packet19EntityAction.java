/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet19EntityAction
extends Packet {
    public int _a;
    public int _b;
    public int _c;

    public Packet19EntityAction() {
    }

    public Packet19EntityAction(Entity entity, int n) {
        this(entity, n, 0);
    }

    public Packet19EntityAction(Entity entity, int n, int n2) {
        this._a = entity.entityId;
        this._b = n;
        this._c = n2;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readByte();
        this._c = dataInput.readInt();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._b);
        dataOutput.writeInt(this._c);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleEntityAction(this);
    }

    @Override
    public int getPacketSize() {
        return 9;
    }
}

