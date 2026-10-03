/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class bbyg
extends Packet {
    public int _a;
    public int _b;

    public bbyg() {
    }

    public bbyg(int n, int n2) {
        this._a = n;
        this._b = n2;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleCollect(this);
    }

    @Override
    public int getPacketSize() {
        return 8;
    }
}

