/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class bszz
extends Packet {
    public int _a;
    public byte _b;

    public bszz() {
    }

    public bszz(int n, byte by) {
        this._a = n;
        this._b = by;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readByte();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._b);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleEntityStatus(this);
    }

    @Override
    public int getPacketSize() {
        return 5;
    }
}

