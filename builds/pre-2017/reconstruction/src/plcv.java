/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.scoreboard.Score;

public class plcv
extends Packet {
    public String _a = "";
    public String _b = "";
    public int _c;
    public int _d;

    public plcv() {
    }

    public plcv(Score score, int n) {
        this._a = score._d();
        this._b = score._c()._b();
        this._c = score._b();
        this._d = n;
    }

    public plcv(String string) {
        this._a = string;
        this._b = "";
        this._c = 0;
        this._d = 1;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = plcv.readString(dataInput, 16);
        this._d = dataInput.readByte();
        if (this._d != 1) {
            this._b = plcv.readString(dataInput, 16);
            this._c = dataInput.readInt();
        }
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        plcv.writeString(this._a, dataOutput);
        dataOutput.writeByte(this._d);
        if (this._d != 1) {
            plcv.writeString(this._b, dataOutput);
            dataOutput.writeInt(this._c);
        }
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleSetScore(this);
    }

    @Override
    public int getPacketSize() {
        return 2 + (this._a == null ? 0 : this._a.length()) + 2 + (this._b == null ? 0 : this._b.length()) + 4 + 1;
    }
}

