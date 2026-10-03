/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class bbzw
extends Packet {
    public String _a;
    public boolean _b;
    public int _c;

    public bbzw() {
    }

    public bbzw(String string, boolean bl, int n) {
        this._a = string;
        this._b = bl;
        this._c = n;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = bbzw.readString(dataInput, 16);
        this._b = dataInput.readByte() != 0;
        this._c = dataInput.readShort();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        bbzw.writeString(this._a, dataOutput);
        dataOutput.writeByte(this._b ? 1 : 0);
        dataOutput.writeShort(this._c);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handlePlayerInfo(this);
    }

    @Override
    public int getPacketSize() {
        return this._a.length() + 2 + 1 + 2;
    }
}

