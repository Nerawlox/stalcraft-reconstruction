/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class kmuh
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;

    public kmuh() {
    }

    public kmuh(Entity entity, int n, int n2, int n3, int n4) {
        this._e = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
        this._a = entity.entityId;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._e = dataInput.readByte();
        this._b = dataInput.readInt();
        this._c = dataInput.readByte();
        this._d = dataInput.readInt();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._e);
        dataOutput.writeInt(this._b);
        dataOutput.writeByte(this._c);
        dataOutput.writeInt(this._d);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleSleep(this);
    }

    @Override
    public int getPacketSize() {
        return 14;
    }
}

