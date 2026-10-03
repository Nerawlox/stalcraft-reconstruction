/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.scoreboard.ScoreObjective;

public class sulv
extends Packet {
    public String _a;
    public String _b;
    public int _c;

    public sulv() {
    }

    public sulv(ScoreObjective scoreObjective, int n) {
        this._a = scoreObjective._b();
        this._b = scoreObjective._d();
        this._c = n;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = sulv.readString(dataInput, 16);
        this._b = sulv.readString(dataInput, 32);
        this._c = dataInput.readByte();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        sulv.writeString(this._a, dataOutput);
        sulv.writeString(this._b, dataOutput);
        dataOutput.writeByte(this._c);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleSetObjective(this);
    }

    @Override
    public int getPacketSize() {
        return 2 + this._a.length() + 2 + this._b.length() + 1;
    }
}

