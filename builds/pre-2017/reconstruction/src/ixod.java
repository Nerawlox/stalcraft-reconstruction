/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class ixod
extends Packet {
    public int[] _a;

    public ixod() {
    }

    public ixod(int ... nArray) {
        this._a = nArray;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = new int[dataInput.readByte()];
        for (int i = 0; i < this._a.length; ++i) {
            this._a[i] = dataInput.readInt();
        }
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeByte(this._a.length);
        for (int i = 0; i < this._a.length; ++i) {
            dataOutput.writeInt(this._a[i]);
        }
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleDestroyEntity(this);
    }

    @Override
    public int getPacketSize() {
        return 1 + this._a.length * 4;
    }
}

