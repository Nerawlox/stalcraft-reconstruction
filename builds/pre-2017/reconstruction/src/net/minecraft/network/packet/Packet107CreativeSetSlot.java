/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet107CreativeSetSlot
extends Packet {
    public int _a;
    public ItemStack _b;

    public Packet107CreativeSetSlot() {
    }

    public Packet107CreativeSetSlot(int n, ItemStack itemStack) {
        this._a = n;
        this._b = itemStack != null ? itemStack._l() : null;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleCreativeSetSlot(this);
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readShort();
        this._b = Packet107CreativeSetSlot.readItemStack(dataInput);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeShort(this._a);
        Packet107CreativeSetSlot.writeItemStack(this._b, dataOutput);
    }

    @Override
    public int getPacketSize() {
        return 8;
    }
}

