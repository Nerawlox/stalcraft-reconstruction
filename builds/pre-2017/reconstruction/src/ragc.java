/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class ragc
extends Packet {
    public int _a;
    public byte _b;

    public ragc() {
    }

    public ragc(int n, byte by) {
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
        netHandler.handleEntityHeadRotation(this);
    }

    @Override
    public int getPacketSize() {
        return 5;
    }

    @Override
    public boolean isRealPacket() {
        return true;
    }

    @Override
    public boolean containsSameEntityIDAs(Packet packet) {
        ragc ragc2 = (ragc)packet;
        return ragc2._a == this._a;
    }

    @Override
    public boolean canProcessAsync() {
        return true;
    }
}

