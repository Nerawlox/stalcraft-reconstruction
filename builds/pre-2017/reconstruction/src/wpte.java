/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class wpte
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public NBTTagCompound _e;

    public wpte() {
        this.isChunkDataPacket = true;
    }

    public wpte(int n, int n2, int n3, int n4, NBTTagCompound nBTTagCompound) {
        this.isChunkDataPacket = true;
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
        this._e = nBTTagCompound;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readShort();
        this._c = dataInput.readInt();
        this._d = dataInput.readByte();
        this._e = wpte.readNBTTagCompound(dataInput);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeShort(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeByte((byte)this._d);
        wpte.writeNBTTagCompound(this._e, dataOutput);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleTileEntityData(this);
    }

    @Override
    public int getPacketSize() {
        return 25;
    }
}

