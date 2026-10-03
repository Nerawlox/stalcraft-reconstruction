/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class rrld
extends Packet {
    public long _a;
    public long _b;

    public rrld() {
    }

    public rrld(long l, long l2, boolean bl) {
        this._a = l;
        this._b = l2;
        if (!bl) {
            this._b = -this._b;
            if (this._b == 0L) {
                this._b = -1L;
            }
        }
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readLong();
        this._b = dataInput.readLong();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeLong(this._a);
        dataOutput.writeLong(this._b);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleUpdateTime(this);
    }

    @Override
    public int getPacketSize() {
        return 16;
    }

    @Override
    public boolean isRealPacket() {
        return true;
    }

    @Override
    public boolean containsSameEntityIDAs(Packet packet) {
        return true;
    }

    @Override
    public boolean canProcessAsync() {
        return true;
    }
}

