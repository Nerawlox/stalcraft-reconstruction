/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.scoreboard.ScoreObjective;

public class txou
extends Packet {
    public int _a;
    public String _b;

    public txou() {
    }

    public txou(int n, ScoreObjective scoreObjective) {
        this._a = n;
        this._b = scoreObjective == null ? "" : scoreObjective._b();
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readByte();
        this._b = txou.readString(dataInput, 16);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
        txou.writeString(this._b, dataOutput);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleSetDisplayObjective(this);
    }

    @Override
    public int getPacketSize() {
        return 3 + this._b.length();
    }
}

