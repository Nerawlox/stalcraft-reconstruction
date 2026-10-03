/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import mods.chat.ChatHooks;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import org.apache.commons.lang3.StringUtils;

public class Packet203AutoComplete
extends Packet {
    public String _a;

    public Packet203AutoComplete() {
    }

    public Packet203AutoComplete(String string) {
        this._a = string;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = Packet203AutoComplete.readString(dataInput, Short.MAX_VALUE);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        Packet203AutoComplete.writeString(StringUtils.substring(this._a, 0, Short.MAX_VALUE), dataOutput);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        boolean bl = ChatHooks.processPacket(this, netHandler);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        netHandler.handleAutoComplete(this);
    }

    @Override
    public int getPacketSize() {
        return 2 + this._a.length() * 2;
    }

    public String _a() {
        return this._a;
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

