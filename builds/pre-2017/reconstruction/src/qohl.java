/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class qohl
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;
    public boolean _f;

    public qohl() {
    }

    public qohl(int n, int n2, int n3, int n4, int n5, boolean bl) {
        this._a = n;
        this._c = n2;
        this._d = n3;
        this._e = n4;
        this._b = n5;
        this._f = bl;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readByte() & 0xFF;
        this._e = dataInput.readInt();
        this._b = dataInput.readInt();
        this._f = dataInput.readBoolean();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._c);
        dataOutput.writeByte(this._d & 0xFF);
        dataOutput.writeInt(this._e);
        dataOutput.writeInt(this._b);
        dataOutput.writeBoolean(this._f);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleDoorChange(this);
    }

    @Override
    public int getPacketSize() {
        return 21;
    }

    public boolean _a() {
        return this._f;
    }
}

