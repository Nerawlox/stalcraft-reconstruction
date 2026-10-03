/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class lpza
extends Packet {
    public String _a;
    public int _b;
    public int _c = Integer.MAX_VALUE;
    public int _d;
    public float _e;
    public int _f;

    public lpza() {
    }

    public lpza(String string, double d, double d2, double d3, float f, float f2) {
        this._a = string;
        this._b = (int)(d * 8.0);
        this._c = (int)(d2 * 8.0);
        this._d = (int)(d3 * 8.0);
        this._e = f;
        this._f = (int)(f2 * 63.0f);
        if (this._f < 0) {
            this._f = 0;
        }
        if (this._f > 255) {
            this._f = 255;
        }
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = lpza.readString(dataInput, 256);
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readFloat();
        this._f = dataInput.readUnsignedByte();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        lpza.writeString(this._a, dataOutput);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeFloat(this._e);
        dataOutput.writeByte(this._f);
    }

    public String _a() {
        return this._a;
    }

    public double _b() {
        return (float)this._b / 8.0f;
    }

    public double _c() {
        return (float)this._c / 8.0f;
    }

    public double _d() {
        return (float)this._d / 8.0f;
    }

    public float _e() {
        return this._e;
    }

    public float _f() {
        return (float)this._f / 63.0f;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleLevelSound(this);
    }

    @Override
    public int getPacketSize() {
        return 24;
    }
}

