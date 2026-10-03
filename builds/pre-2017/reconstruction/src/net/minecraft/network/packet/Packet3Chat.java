/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.ChatMessageComponent;

public class Packet3Chat
extends Packet {
    public String _a;
    public boolean _b = true;

    public Packet3Chat() {
    }

    public Packet3Chat(ChatMessageComponent chatMessageComponent) {
        this(chatMessageComponent._i());
    }

    public Packet3Chat(ChatMessageComponent chatMessageComponent, boolean bl) {
        this(chatMessageComponent._i(), bl);
    }

    public Packet3Chat(String string) {
        this(string, true);
    }

    public Packet3Chat(String string, boolean bl) {
        if (string.length() > Short.MAX_VALUE) {
            string = string.substring(0, Short.MAX_VALUE);
        }
        this._a = string;
        this._b = bl;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = Packet3Chat.readString(dataInput, Short.MAX_VALUE);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        Packet3Chat.writeString(this._a, dataOutput);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleChat(this);
    }

    @Override
    public int getPacketSize() {
        return 2 + this._a.length() * 2;
    }

    public boolean _a() {
        return this._b;
    }
}

