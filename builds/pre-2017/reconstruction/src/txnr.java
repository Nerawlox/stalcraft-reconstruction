/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.sajh;

public class txnr
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public byte _e;
    public byte _f;

    public txnr() {
    }

    public txnr(Entity entity) {
        this._a = entity.entityId;
        this._b = sajh._c(entity.posX * 32.0);
        this._c = sajh._c(entity.posY * 32.0);
        this._d = sajh._c(entity.posZ * 32.0);
        this._e = (byte)(entity.rotationYaw * 256.0f / 360.0f);
        this._f = (byte)(entity.rotationPitch * 256.0f / 360.0f);
    }

    public txnr(int n, int n2, int n3, int n4, byte by, byte by2) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
        this._e = by;
        this._f = by2;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readByte();
        this._f = dataInput.readByte();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.write(this._e);
        dataOutput.write(this._f);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleEntityTeleport(this);
    }

    @Override
    public int getPacketSize() {
        return 34;
    }

    @Override
    public boolean isRealPacket() {
        return true;
    }

    @Override
    public boolean containsSameEntityIDAs(Packet packet) {
        txnr txnr2 = (txnr)packet;
        return txnr2._a == this._a;
    }
}

