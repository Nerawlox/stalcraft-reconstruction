/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.world.World;

public class cwan
extends Packet {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;

    public cwan() {
        this.isChunkDataPacket = true;
    }

    public cwan(int n, int n2, int n3, World world) {
        this.isChunkDataPacket = true;
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = world.getBlockId(n, n2, n3);
        this._e = world.getBlockMetadata(n, n2, n3);
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readUnsignedByte();
        this._c = dataInput.readInt();
        this._d = dataInput.readShort();
        this._e = dataInput.readUnsignedByte();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.write(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeShort(this._d);
        dataOutput.write(this._e);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleBlockChange(this);
    }

    @Override
    public int getPacketSize() {
        return 11;
    }
}

