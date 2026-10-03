/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Vec3;

public class ozcz
extends Packet {
    public double _a;
    public double _b;
    public double _c;
    public float _d;
    public List _e;
    public float _f;
    public float _g;
    public float _h;

    public ozcz() {
    }

    public ozcz(double d, double d2, double d3, float f, List list2, Vec3 vec3) {
        this._a = d;
        this._b = d2;
        this._c = d3;
        this._d = f;
        this._e = new ArrayList(list2);
        if (vec3 != null) {
            this._f = (float)vec3._c;
            this._g = (float)vec3._d;
            this._h = (float)vec3._e;
        }
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readDouble();
        this._b = dataInput.readDouble();
        this._c = dataInput.readDouble();
        this._d = dataInput.readFloat();
        int n = dataInput.readInt();
        this._e = new ArrayList(n);
        int n2 = (int)this._a;
        int n3 = (int)this._b;
        int n4 = (int)this._c;
        for (int i = 0; i < n; ++i) {
            int n5 = dataInput.readByte() + n2;
            int n6 = dataInput.readByte() + n3;
            int n7 = dataInput.readByte() + n4;
            this._e.add(new xtcd(n5, n6, n7));
        }
        this._f = dataInput.readFloat();
        this._g = dataInput.readFloat();
        this._h = dataInput.readFloat();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeDouble(this._a);
        dataOutput.writeDouble(this._b);
        dataOutput.writeDouble(this._c);
        dataOutput.writeFloat(this._d);
        dataOutput.writeInt(this._e.size());
        int n = (int)this._a;
        int n2 = (int)this._b;
        int n3 = (int)this._c;
        for (xtcd xtcd2 : this._e) {
            int n4 = xtcd2._d - n;
            int n5 = xtcd2._e - n2;
            int n6 = xtcd2._f - n3;
            dataOutput.writeByte(n4);
            dataOutput.writeByte(n5);
            dataOutput.writeByte(n6);
        }
        dataOutput.writeFloat(this._f);
        dataOutput.writeFloat(this._g);
        dataOutput.writeFloat(this._h);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleExplosion(this);
    }

    @Override
    public int getPacketSize() {
        return 32 + this._e.size() * 3 + 3;
    }

    public float _a() {
        return this._f;
    }

    public float _b() {
        return this._g;
    }

    public float _c() {
        return this._h;
    }
}

