/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class wpwt
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public int _d;

    public wpwt() {
    }

    public wpwt(int n, int n2, int n3, int n4) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.func_142031_a(this);
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readByte();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
    }

    @Override
    public int getPacketSize() {
        return 13;
    }
}

