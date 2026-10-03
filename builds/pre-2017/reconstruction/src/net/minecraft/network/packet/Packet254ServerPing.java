/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public class Packet254ServerPing
extends Packet {
    public static final int _a = new Packet250CustomPayload().getPacketId();
    public int _b;
    public String _c;
    public int _d;

    public Packet254ServerPing() {
    }

    public Packet254ServerPing(int n, String string, int n2) {
        this._b = n;
        this._c = string;
        this._d = n2;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        try {
            this._b = dataInput.readByte();
            try {
                dataInput.readByte();
                Packet254ServerPing.readString(dataInput, 255);
                dataInput.readShort();
                this._b = dataInput.readByte();
                if (this._b >= 73) {
                    this._c = Packet254ServerPing.readString(dataInput, 255);
                    this._d = dataInput.readInt();
                }
            }
            catch (Throwable throwable) {
                this._c = "";
            }
        }
        catch (Throwable throwable) {
            this._b = 0;
            this._c = "";
        }
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeByte(1);
        dataOutput.writeByte(_a);
        Packet.writeString("MC|PingHost", dataOutput);
        dataOutput.writeShort(3 + 2 * this._c.length() + 4);
        dataOutput.writeByte(this._b);
        Packet.writeString(this._c, dataOutput);
        dataOutput.writeInt(this._d);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleServerPing(this);
    }

    @Override
    public int getPacketSize() {
        return 3 + this._c.length() * 2 + 4;
    }

    public boolean _a() {
        return this._b == 0;
    }
}

