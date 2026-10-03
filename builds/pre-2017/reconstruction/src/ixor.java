/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.sajh;

public class ixor
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;
    public int _f;
    public int _g;
    public int _h;
    public int _i;
    public int _j;
    public int _k;

    public ixor() {
    }

    public ixor(Entity entity, int n) {
        this(entity, n, 0);
    }

    public ixor(Entity entity, int n, int n2) {
        this._a = entity.entityId;
        this._b = sajh._c(entity.posX * 32.0);
        this._c = sajh._c(entity.posY * 32.0);
        this._d = sajh._c(entity.posZ * 32.0);
        this._h = sajh._d(entity.rotationPitch * 256.0f / 360.0f);
        this._i = sajh._d(entity.rotationYaw * 256.0f / 360.0f);
        this._j = n;
        this._k = n2;
        if (n2 > 0) {
            double d = entity.motionX;
            double d2 = entity.motionY;
            double d3 = entity.motionZ;
            double d4 = 3.9;
            if (d < -d4) {
                d = -d4;
            }
            if (d2 < -d4) {
                d2 = -d4;
            }
            if (d3 < -d4) {
                d3 = -d4;
            }
            if (d > d4) {
                d = d4;
            }
            if (d2 > d4) {
                d2 = d4;
            }
            if (d3 > d4) {
                d3 = d4;
            }
            this._e = (int)(d * 8000.0);
            this._f = (int)(d2 * 8000.0);
            this._g = (int)(d3 * 8000.0);
        }
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._j = dataInput.readByte();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._h = dataInput.readByte();
        this._i = dataInput.readByte();
        this._k = dataInput.readInt();
        if (this._k > 0) {
            this._e = dataInput.readShort();
            this._f = dataInput.readShort();
            this._g = dataInput.readShort();
        }
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._j);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeByte(this._h);
        dataOutput.writeByte(this._i);
        dataOutput.writeInt(this._k);
        if (this._k > 0) {
            dataOutput.writeShort(this._e);
            dataOutput.writeShort(this._f);
            dataOutput.writeShort(this._g);
        }
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleVehicleSpawn(this);
    }

    @Override
    public int getPacketSize() {
        return 21 + this._k > 0 ? 6 : 0;
    }
}

