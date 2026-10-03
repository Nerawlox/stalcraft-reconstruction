/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class lpub
extends Packet {
    public int _a;
    public int _b;
    public String _c;
    public int _d;
    public boolean _e;
    public int _f;

    public lpub() {
    }

    public lpub(int n, int n2, String string, int n3, boolean bl) {
        this._a = n;
        this._b = n2;
        this._c = string;
        this._d = n3;
        this._e = bl;
    }

    public lpub(int n, int n2, String string, int n3, boolean bl, int n4) {
        this(n, n2, string, n3, bl);
        this._f = n4;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleOpenWindow(this);
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readByte() & 0xFF;
        this._b = dataInput.readByte() & 0xFF;
        this._c = lpub.readString(dataInput, 32);
        this._d = dataInput.readByte() & 0xFF;
        this._e = dataInput.readBoolean();
        if (this._b == 11) {
            this._f = dataInput.readInt();
        }
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeByte(this._a & 0xFF);
        dataOutput.writeByte(this._b & 0xFF);
        lpub.writeString(this._c, dataOutput);
        dataOutput.writeByte(this._d & 0xFF);
        dataOutput.writeBoolean(this._e);
        if (this._b == 11) {
            dataOutput.writeInt(this._f);
        }
    }

    @Override
    public int getPacketSize() {
        if (this._b == 11) {
            return 8 + this._c.length();
        }
        return 4 + this._c.length();
    }
}

