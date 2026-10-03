/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class ixmv
extends Packet {
    public int _a;
    public int _b;
    public ItemStack _c;

    public ixmv() {
    }

    public ixmv(int n, int n2, ItemStack itemStack) {
        this._a = n;
        this._b = n2;
        this._c = itemStack == null ? itemStack : itemStack._l();
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleSetSlot(this);
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readByte();
        this._b = dataInput.readShort();
        this._c = ixmv.readItemStack(dataInput);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
        dataOutput.writeShort(this._b);
        ixmv.writeItemStack(this._c, dataOutput);
    }

    @Override
    public int getPacketSize() {
        return 8;
    }
}

