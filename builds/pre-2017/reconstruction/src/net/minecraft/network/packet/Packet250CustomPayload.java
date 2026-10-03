/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet250CustomPayload
extends Packet {
    public String channel;
    public int length;
    public byte[] data;

    public Packet250CustomPayload() {
    }

    public Packet250CustomPayload(String string, byte[] byArray) {
        this.channel = string;
        this.data = byArray;
        if (byArray != null) {
            this.length = byArray.length;
            if (this.length > Short.MAX_VALUE) {
                throw new IllegalArgumentException("Payload may not be larger than 32k");
            }
        }
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this.channel = Packet250CustomPayload.readString(dataInput, 20);
        this.length = dataInput.readShort();
        if (this.length > 0 && this.length < Short.MAX_VALUE) {
            this.data = new byte[this.length];
            dataInput.readFully(this.data);
        }
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        Packet250CustomPayload.writeString(this.channel, dataOutput);
        dataOutput.writeShort((short)this.length);
        if (this.data != null) {
            dataOutput.write(this.data);
        }
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleCustomPayload(this);
    }

    @Override
    public int getPacketSize() {
        return 2 + this.channel.length() * 2 + 2 + this.length;
    }
}

