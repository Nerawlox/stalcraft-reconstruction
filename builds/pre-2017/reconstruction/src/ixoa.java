/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.ugqi;

public class ixoa
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;
    public String _f;

    public ixoa() {
    }

    public ixoa(EntityPainting entityPainting) {
        this._a = entityPainting.entityId;
        this._b = entityPainting.xPosition;
        this._c = entityPainting.yPosition;
        this._d = entityPainting.zPosition;
        this._e = entityPainting.hangingDirection;
        this._f = entityPainting.art.__aK;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._f = ixoa.readString(dataInput, ugqi.__aJ);
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readInt();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        ixoa.writeString(this._f, dataOutput);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeInt(this._e);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleEntityPainting(this);
    }

    @Override
    public int getPacketSize() {
        return 24;
    }
}

