/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class igpu
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;

    public igpu() {
    }

    public igpu(int n, int n2, int n3, int n4, int n5) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
        this._e = n5;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readUnsignedByte();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.write(this._e);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleBlockDestroy(this);
    }

    @Override
    public int getPacketSize() {
        return 13;
    }

    public int _a() {
        return this._a;
    }

    public int _b() {
        return this._b;
    }

    public int _c() {
        return this._c;
    }

    public int _d() {
        return this._d;
    }

    public int _e() {
        return this._e;
    }

    @Override
    public boolean isRealPacket() {
        return true;
    }

    @Override
    public boolean containsSameEntityIDAs(Packet packet) {
        igpu igpu2 = (igpu)packet;
        return igpu2._a == this._a;
    }
}

