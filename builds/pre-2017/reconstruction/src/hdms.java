/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class hdms
extends Packet {
    public int _a;
    public int _b;
    public ItemStack _c;

    public hdms() {
    }

    public hdms(int n, int n2, ItemStack itemStack) {
        this._a = n;
        this._b = n2;
        this._c = itemStack == null ? null : itemStack._l();
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readShort();
        this._c = hdms.readItemStack(dataInput);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeShort(this._b);
        hdms.writeItemStack(this._c, dataOutput);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handlePlayerInventory(this);
    }

    @Override
    public int getPacketSize() {
        return 8;
    }

    public ItemStack _a() {
        return this._c;
    }

    @Override
    public boolean isRealPacket() {
        return true;
    }

    @Override
    public boolean containsSameEntityIDAs(Packet packet) {
        hdms hdms2 = (hdms)packet;
        return hdms2._a == this._a && hdms2._b == this._b;
    }
}

