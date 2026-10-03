/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class xbzt
extends Packet {
    public int _a;
    public int _b;
    public int _c;

    public xbzt() {
    }

    public xbzt(int n, int n2, int n3) {
        this._a = n;
        this._b = n2;
        this._c = n3;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleSpawnPosition(this);
    }

    @Override
    public int getPacketSize() {
        return 12;
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
        return false;
    }
}

