/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class sdlz
extends Packet {
    public float _a;
    public int _b;
    public float _c;

    public sdlz() {
    }

    public sdlz(float f, int n, float f2) {
        this._a = f;
        this._b = n;
        this._c = f2;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readFloat();
        this._b = dataInput.readShort();
        this._c = dataInput.readFloat();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeFloat(this._a);
        dataOutput.writeShort(this._b);
        dataOutput.writeFloat(this._c);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleUpdateHealth(this);
    }

    @Override
    public int getPacketSize() {
        return 8;
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

