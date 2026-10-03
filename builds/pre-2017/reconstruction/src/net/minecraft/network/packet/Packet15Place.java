/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet15Place
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public ItemStack _e;
    public float _f;
    public float _g;
    public float _h;

    public Packet15Place() {
    }

    public Packet15Place(int n, int n2, int n3, int n4, ItemStack itemStack, float f, float f2, float f3) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
        this._e = itemStack != null ? itemStack._l() : null;
        this._f = f;
        this._g = f2;
        this._h = f3;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readUnsignedByte();
        this._c = dataInput.readInt();
        this._d = dataInput.readUnsignedByte();
        this._e = Packet15Place.readItemStack(dataInput);
        this._f = (float)dataInput.readUnsignedByte() / 16.0f;
        this._g = (float)dataInput.readUnsignedByte() / 16.0f;
        this._h = (float)dataInput.readUnsignedByte() / 16.0f;
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.write(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.write(this._d);
        Packet15Place.writeItemStack(this._e, dataOutput);
        dataOutput.write((int)(this._f * 16.0f));
        dataOutput.write((int)(this._g * 16.0f));
        dataOutput.write((int)(this._h * 16.0f));
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handlePlace(this);
    }

    @Override
    public int getPacketSize() {
        return 19;
    }

    public int _a() {
        return this._a;
    }

    public int _b() {
        return this._b;
    }

    public int _c() {
        return this._c;
    }

    public int _d() {
        return this._d;
    }

    public ItemStack _e() {
        return this._e;
    }

    public float _f() {
        return this._f;
    }

    public float _g() {
        return this._g;
    }

    public float _h() {
        return this._h;
    }
}

