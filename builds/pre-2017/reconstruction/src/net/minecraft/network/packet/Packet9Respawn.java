/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.world.EnumGameType;

public class Packet9Respawn
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public EnumGameType _d;
    public nwix _e;

    public Packet9Respawn() {
    }

    public Packet9Respawn(int n, byte by, nwix nwix2, int n2, EnumGameType enumGameType) {
        this._a = n;
        this._b = by;
        this._c = n2;
        this._d = enumGameType;
        this._e = nwix2;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleRespawn(this);
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readByte();
        this._d = EnumGameType._a(dataInput.readByte());
        this._c = dataInput.readShort();
        String string = Packet9Respawn.readString(dataInput, 16);
        this._e = nwix._a(string);
        if (this._e == null) {
            this._e = nwix._d;
        }
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._b);
        dataOutput.writeByte(this._d._a());
        dataOutput.writeShort(this._c);
        Packet9Respawn.writeString(this._e._a(), dataOutput);
    }

    @Override
    public int getPacketSize() {
        return 8 + (this._e == null ? 0 : this._e._a().length());
    }
}

