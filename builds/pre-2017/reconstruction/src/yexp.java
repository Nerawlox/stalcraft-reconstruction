/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class yexp
extends Packet {
    public short _a;
    public short _b;
    public byte[] _c;

    public yexp() {
        this.isChunkDataPacket = true;
    }

    public yexp(short s, short s2, byte[] byArray) {
        this.isChunkDataPacket = true;
        this._a = s;
        this._b = s2;
        this._c = byArray;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readShort();
        this._b = dataInput.readShort();
        this._c = new byte[dataInput.readUnsignedShort()];
        dataInput.readFully(this._c);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeShort(this._a);
        dataOutput.writeShort(this._b);
        dataOutput.writeShort(this._c.length);
        dataOutput.write(this._c);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleMapData(this);
    }

    @Override
    public int getPacketSize() {
        return 4 + this._c.length;
    }
}

