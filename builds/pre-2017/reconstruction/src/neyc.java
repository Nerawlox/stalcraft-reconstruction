/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class neyc
extends Packet {
    public int _a;
    public int _b;
    public int _c;

    public neyc() {
    }

    public neyc(int n, int n2, int n3) {
        this._a = n;
        this._b = n2;
        this._c = n3;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleUpdateProgressbar(this);
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readByte();
        this._b = dataInput.readShort();
        this._c = dataInput.readShort();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
        dataOutput.writeShort(this._b);
        dataOutput.writeShort(this._c);
    }

    @Override
    public int getPacketSize() {
        return 5;
    }
}

