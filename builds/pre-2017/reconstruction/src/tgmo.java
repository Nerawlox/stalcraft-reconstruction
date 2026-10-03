/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.util.List;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.jgro;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.sajh;

public class tgmo
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;
    public int _f;
    public int _g;
    public int _h;
    public byte _i;
    public byte _j;
    public byte _k;
    public DataWatcher _l;
    public List _m;

    public tgmo() {
    }

    public tgmo(EntityLivingBase entityLivingBase) {
        this._a = entityLivingBase.entityId;
        this._b = (byte)jgro._a(entityLivingBase);
        this._c = entityLivingBase.myEntitySize._a(entityLivingBase.posX);
        this._d = sajh._c(entityLivingBase.posY * 32.0);
        this._e = entityLivingBase.myEntitySize._a(entityLivingBase.posZ);
        this._i = (byte)(entityLivingBase.rotationYaw * 256.0f / 360.0f);
        this._j = (byte)(entityLivingBase.rotationPitch * 256.0f / 360.0f);
        this._k = (byte)(entityLivingBase.rotationYawHead * 256.0f / 360.0f);
        double d = 3.9;
        double d2 = entityLivingBase.motionX;
        double d3 = entityLivingBase.motionY;
        double d4 = entityLivingBase.motionZ;
        if (d2 < -d) {
            d2 = -d;
        }
        if (d3 < -d) {
            d3 = -d;
        }
        if (d4 < -d) {
            d4 = -d;
        }
        if (d2 > d) {
            d2 = d;
        }
        if (d3 > d) {
            d3 = d;
        }
        if (d4 > d) {
            d4 = d;
        }
        this._f = (int)(d2 * 8000.0);
        this._g = (int)(d3 * 8000.0);
        this._h = (int)(d4 * 8000.0);
        this._l = entityLivingBase.getDataWatcher();
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readByte() & 0xFF;
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readInt();
        this._i = dataInput.readByte();
        this._j = dataInput.readByte();
        this._k = dataInput.readByte();
        this._f = dataInput.readShort();
        this._g = dataInput.readShort();
        this._h = dataInput.readShort();
        this._m = DataWatcher._a(dataInput);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._b & 0xFF);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeInt(this._e);
        dataOutput.writeByte(this._i);
        dataOutput.writeByte(this._j);
        dataOutput.writeByte(this._k);
        dataOutput.writeShort(this._f);
        dataOutput.writeShort(this._g);
        dataOutput.writeShort(this._h);
        this._l._a(dataOutput);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleMobSpawn(this);
    }

    @Override
    public int getPacketSize() {
        return 26;
    }

    public List _a() {
        if (this._m == null) {
            this._m = this._l._c();
        }
        return this._m;
    }
}

