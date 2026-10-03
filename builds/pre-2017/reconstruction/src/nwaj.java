/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class nwaj
extends Packet {
    public int _a;
    public int _b;
    public int _c;

    public nwaj() {
    }

    public nwaj(int n, Entity entity, Entity entity2) {
        this._a = n;
        this._b = entity.entityId;
        this._c = entity2 != null ? entity2.entityId : -1;
    }

    @Override
    public int getPacketSize() {
        return 8;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._a = dataInput.readUnsignedByte();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeByte(this._a);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleAttachEntity(this);
    }

    @Override
    public boolean isRealPacket() {
        return true;
    }

    @Override
    public boolean containsSameEntityIDAs(Packet packet) {
        nwaj nwaj2 = (nwaj)packet;
        return nwaj2._b == this._b;
    }
}

