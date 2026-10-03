/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet130UpdateSign
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public String[] _d;

    public Packet130UpdateSign() {
        this.isChunkDataPacket = true;
    }

    public Packet130UpdateSign(int n, int n2, int n3, String[] stringArray) {
        this.isChunkDataPacket = true;
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = new String[]{stringArray[0], stringArray[1], stringArray[2], stringArray[3]};
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readShort();
        this._c = dataInput.readInt();
        this._d = new String[4];
        for (int i = 0; i < 4; ++i) {
            this._d[i] = Packet130UpdateSign.readString(dataInput, 15);
        }
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeShort(this._b);
        dataOutput.writeInt(this._c);
        for (int i = 0; i < 4; ++i) {
            Packet130UpdateSign.writeString(this._d[i], dataOutput);
        }
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleUpdateSign(this);
    }

    @Override
    public int getPacketSize() {
        int n = 0;
        for (int i = 0; i < 4; ++i) {
            n += this._d[i].length();
        }
        return n;
    }
}

