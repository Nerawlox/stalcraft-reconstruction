/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class ujsb
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;
    public int _f;

    public ujsb() {
    }

    public ujsb(int n, int n2, int n3, int n4, int n5, int n6) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = n5;
        this._e = n6;
        this._f = n4;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readShort();
        this._c = dataInput.readInt();
        this._d = dataInput.readUnsignedByte();
        this._e = dataInput.readUnsignedByte();
        this._f = dataInput.readShort() & 0xFFF;
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeShort(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.write(this._d);
        dataOutput.write(this._e);
        dataOutput.writeShort(this._f & 0xFFF);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleBlockEvent(this);
    }

    @Override
    public int getPacketSize() {
        return 14;
    }
}

