/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class yezn
extends Packet {
    public int _a;
    public String _b;
    public String _c;
    public int _d;

    public yezn() {
    }

    public yezn(int n, String string, String string2, int n2) {
        this._a = n;
        this._b = string;
        this._c = string2;
        this._d = n2;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readByte();
        this._b = yezn.readString(dataInput, 16);
        this._c = yezn.readString(dataInput, 255);
        this._d = dataInput.readInt();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
        yezn.writeString(this._b, dataOutput);
        yezn.writeString(this._c, dataOutput);
        dataOutput.writeInt(this._d);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleClientProtocol(this);
    }

    @Override
    public int getPacketSize() {
        return 3 + 2 * this._b.length();
    }

    public int _a() {
        return this._a;
    }

    public String _b() {
        return this._b;
    }
}

