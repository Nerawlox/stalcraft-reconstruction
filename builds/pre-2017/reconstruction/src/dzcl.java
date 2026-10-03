/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class dzcl
extends Packet {
    public int _a;
    public int _b;

    public dzcl() {
    }

    public dzcl(int n, int n2) {
        this._a = n;
        this._b = n2;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleStatistic(this);
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
    public int getPacketSize() {
        return 6;
    }

    @Override
    public boolean canProcessAsync() {
        return true;
    }
}

