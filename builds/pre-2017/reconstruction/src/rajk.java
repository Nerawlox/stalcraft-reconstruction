/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class rajk
extends Packet {
    public float _a;
    public int _b;
    public int _c;

    public rajk() {
    }

    public rajk(float f, int n, int n2) {
        this._a = f;
        this._b = n;
        this._c = n2;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readFloat();
        this._c = dataInput.readShort();
        this._b = dataInput.readShort();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeFloat(this._a);
        dataOutput.writeShort(this._c);
        dataOutput.writeShort(this._b);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleExperience(this);
    }

    @Override
    public int getPacketSize() {
        return 4;
    }

    @Override
    public boolean isRealPacket() {
        return true;
    }

    @Override
    public boolean containsSameEntityIDAs(Packet packet) {
        return true;
    }
}

