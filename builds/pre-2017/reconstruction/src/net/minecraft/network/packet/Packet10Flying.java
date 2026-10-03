/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import gloomyfolken.mods.anticheat.pidb;
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet10Flying
extends Packet {
    public double _a;
    public double _b;
    public double _c;
    public double _d;
    public float _e;
    public float _f;
    public boolean _g;
    public boolean _h;
    public boolean _i;

    public Packet10Flying() {
    }

    public Packet10Flying(boolean bl) {
        this._g = bl;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleFlying(this);
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._g = dataInput.readUnsignedByte() != 0;
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.write(this._g ? 1 : 0);
    }

    @Override
    public int getPacketSize() {
        return 1;
    }

    @Override
    public boolean isRealPacket() {
        return true;
    }

    @Override
    public boolean containsSameEntityIDAs(Packet packet) {
        pidb._a(this, packet);
        return false;
    }
}

