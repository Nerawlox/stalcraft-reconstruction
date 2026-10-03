/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet44UpdateAttributes
extends Packet {
    public int _a;
    public final List _b = new ArrayList();

    public Packet44UpdateAttributes() {
    }

    public Packet44UpdateAttributes(int n, Collection collection) {
        this._a = n;
        for (hubf hubf2 : collection) {
            this._b.add(new apzo(this, hubf2._a()._a(), hubf2._b(), hubf2._c()));
        }
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            String string = Packet44UpdateAttributes.readString(dataInput, 64);
            double d = dataInput.readDouble();
            ArrayList<AttributeModifier> arrayList = new ArrayList<AttributeModifier>();
            int n2 = dataInput.readShort();
            for (int j = 0; j < n2; ++j) {
                UUID uUID = new UUID(dataInput.readLong(), dataInput.readLong());
                arrayList.add(new AttributeModifier(uUID, "Unknown synced attribute modifier", dataInput.readDouble(), dataInput.readByte()));
            }
            this._b.add(new apzo(this, string, d, arrayList));
        }
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b.size());
        for (apzo apzo2 : this._b) {
            Packet44UpdateAttributes.writeString(apzo2._a(), dataOutput);
            dataOutput.writeDouble(apzo2._b());
            dataOutput.writeShort(apzo2._c().size());
            for (AttributeModifier attributeModifier : apzo2._c()) {
                dataOutput.writeLong(attributeModifier._a().getMostSignificantBits());
                dataOutput.writeLong(attributeModifier._a().getLeastSignificantBits());
                dataOutput.writeDouble(attributeModifier._d());
                dataOutput.writeByte(attributeModifier._c());
            }
        }
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.func_110773_a(this);
    }

    @Override
    public int getPacketSize() {
        return 8 + this._b.size() * 24;
    }

    public int _a() {
        return this._a;
    }

    public List _b() {
        return this._b;
    }
}

