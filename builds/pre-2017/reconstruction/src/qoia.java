/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.util.List;
import net.minecraft.entity.DataWatcher;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class qoia
extends Packet {
    public int _a;
    public List _b;

    public qoia() {
    }

    public qoia(int n, DataWatcher dataWatcher, boolean bl) {
        this._a = n;
        this._b = bl ? dataWatcher._c() : dataWatcher._b();
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = DataWatcher._a(dataInput);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        DataWatcher._a(this._b, dataOutput);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleEntityMetadata(this);
    }

    @Override
    public int getPacketSize() {
        return 5;
    }

    public List _a() {
        return this._b;
    }
}

