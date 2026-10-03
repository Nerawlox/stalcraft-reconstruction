/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet27PlayerInput
extends Packet {
    public float _a;
    public float _b;
    public boolean _c;
    public boolean _d;

    public Packet27PlayerInput() {
    }

    public Packet27PlayerInput(float f, float f2, boolean bl, boolean bl2) {
        this._a = f;
        this._b = f2;
        this._c = bl;
        this._d = bl2;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readFloat();
        this._b = dataInput.readFloat();
        this._c = dataInput.readBoolean();
        this._d = dataInput.readBoolean();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeFloat(this._a);
        dataOutput.writeFloat(this._b);
        dataOutput.writeBoolean(this._c);
        dataOutput.writeBoolean(this._d);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.func_110774_a(this);
    }

    @Override
    public int getPacketSize() {
        return 10;
    }

    public float _a() {
        return this._a;
    }

    public float _b() {
        return this._b;
    }

    public boolean _c() {
        return this._c;
    }

    public boolean _d() {
        return this._d;
    }
}

