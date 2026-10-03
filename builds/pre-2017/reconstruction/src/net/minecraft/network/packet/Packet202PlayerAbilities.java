/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet202PlayerAbilities
extends Packet {
    public boolean _a;
    public boolean _b;
    public boolean _c;
    public boolean _d;
    public float _e;
    public float _f;

    public Packet202PlayerAbilities() {
    }

    public Packet202PlayerAbilities(PlayerCapabilities playerCapabilities) {
        this._a(playerCapabilities._a);
        this._b(playerCapabilities._b);
        this._c(playerCapabilities._c);
        this._d(playerCapabilities._d);
        this._a(playerCapabilities._a());
        this._b(playerCapabilities._b());
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        byte by = dataInput.readByte();
        this._a((by & 1) > 0);
        this._b((by & 2) > 0);
        this._c((by & 4) > 0);
        this._d((by & 8) > 0);
        this._a(dataInput.readFloat());
        this._b(dataInput.readFloat());
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        byte by = 0;
        if (this._a()) {
            by = (byte)(by | 1);
        }
        if (this._b()) {
            by = (byte)(by | 2);
        }
        if (this._c()) {
            by = (byte)(by | 4);
        }
        if (this._d()) {
            by = (byte)(by | 8);
        }
        dataOutput.writeByte(by);
        dataOutput.writeFloat(this._e);
        dataOutput.writeFloat(this._f);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handlePlayerAbilities(this);
    }

    @Override
    public int getPacketSize() {
        return 2;
    }

    public boolean _a() {
        return this._a;
    }

    public void _a(boolean bl) {
        this._a = bl;
    }

    public boolean _b() {
        return this._b;
    }

    public void _b(boolean bl) {
        this._b = bl;
    }

    public boolean _c() {
        return this._c;
    }

    public void _c(boolean bl) {
        this._c = bl;
    }

    public boolean _d() {
        return this._d;
    }

    public void _d(boolean bl) {
        this._d = bl;
    }

    public float _e() {
        return this._e;
    }

    public void _a(float f) {
        this._e = f;
    }

    public float _f() {
        return this._f;
    }

    public void _b(float f) {
        this._f = f;
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

