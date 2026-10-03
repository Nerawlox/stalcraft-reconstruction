/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet204ClientInfo
extends Packet {
    public String _a;
    public int _b;
    public int _c;
    public boolean _d;
    public int _e;
    public boolean _f;

    public Packet204ClientInfo() {
    }

    public Packet204ClientInfo(String string, int n, int n2, boolean bl, int n3, boolean bl2) {
        this._a = string;
        this._b = n;
        this._c = n2;
        this._d = bl;
        this._e = n3;
        this._f = bl2;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = Packet204ClientInfo.readString(dataInput, 7);
        this._b = dataInput.readByte();
        byte by = dataInput.readByte();
        this._c = by & 7;
        this._d = (by & 8) == 8;
        this._e = dataInput.readByte();
        this._f = dataInput.readBoolean();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        Packet204ClientInfo.writeString(this._a, dataOutput);
        dataOutput.writeByte(this._b);
        dataOutput.writeByte(this._c | (this._d ? 1 : 0) << 3);
        dataOutput.writeByte(this._e);
        dataOutput.writeBoolean(this._f);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleClientInfo(this);
    }

    @Override
    public int getPacketSize() {
        return 7;
    }

    public String _a() {
        return this._a;
    }

    public int _b() {
        return this._b;
    }

    public int _c() {
        return this._c;
    }

    public boolean _d() {
        return this._d;
    }

    public int _e() {
        return this._e;
    }

    public boolean _f() {
        return this._f;
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

