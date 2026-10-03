/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anticheat.pidb;
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class fofa
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public int _d;

    public fofa() {
    }

    public fofa(Entity entity) {
        this(entity.entityId, entity.motionX, entity.motionY, entity.motionZ);
    }

    public fofa(int n, double d, double d2, double d3) {
        this._a = n;
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
        this._b = (int)(d * 8000.0);
        this._c = (int)(d2 * 8000.0);
        this._d = (int)(d3 * 8000.0);
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readShort();
        this._c = dataInput.readShort();
        this._d = dataInput.readShort();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeShort(this._b);
        dataOutput.writeShort(this._c);
        dataOutput.writeShort(this._d);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleEntityVelocity(this);
    }

    @Override
    public int getPacketSize() {
        return 10;
    }

    @Override
    public boolean isRealPacket() {
        return true;
    }

    @Override
    public boolean containsSameEntityIDAs(Packet packet) {
        pidb._a(this, packet);
        return false;
    }
}

