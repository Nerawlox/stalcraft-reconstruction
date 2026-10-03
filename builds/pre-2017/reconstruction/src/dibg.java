/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.sajh;

public class dibg
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;

    public dibg() {
    }

    public dibg(Entity entity) {
        this._a = entity.entityId;
        this._b = sajh._c(entity.posX * 32.0);
        this._c = sajh._c(entity.posY * 32.0);
        this._d = sajh._c(entity.posZ * 32.0);
        if (entity instanceof EntityLightningBolt) {
            this._e = 1;
        }
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._e = dataInput.readByte();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._e);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleWeather(this);
    }

    @Override
    public int getPacketSize() {
        return 17;
    }
}

