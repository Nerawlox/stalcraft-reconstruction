/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class wptu
extends Packet {
    public int _a;
    public ItemStack[] _b;

    public wptu() {
    }

    public wptu(int n, List list2) {
        this._a = n;
        this._b = new ItemStack[list2.size()];
        for (int i = 0; i < this._b.length; ++i) {
            ItemStack itemStack = (ItemStack)list2.get(i);
            this._b[i] = itemStack == null ? null : itemStack._l();
        }
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readByte();
        int n = dataInput.readShort();
        this._b = new ItemStack[n];
        for (int i = 0; i < n; ++i) {
            this._b[i] = wptu.readItemStack(dataInput);
        }
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
        dataOutput.writeShort(this._b.length);
        for (int i = 0; i < this._b.length; ++i) {
            wptu.writeItemStack(this._b[i], dataOutput);
        }
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleWindowItems(this);
    }

    @Override
    public int getPacketSize() {
        return 3 + this._b.length * 5;
    }
}

