/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.sajh;

public class kmst
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;

    public kmst() {
    }

    public kmst(EntityXPOrb entityXPOrb) {
        this._a = entityXPOrb.entityId;
        this._b = sajh._c(entityXPOrb.posX * 32.0);
        this._c = sajh._c(entityXPOrb.posY * 32.0);
        this._d = sajh._c(entityXPOrb.posZ * 32.0);
        this._e = entityXPOrb.getXpValue();
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readShort();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeShort(this._e);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleEntityExpOrb(this);
    }

    @Override
    public int getPacketSize() {
        return 18;
    }
}

