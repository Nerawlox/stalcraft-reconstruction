/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.potion.PotionEffect;

public class cwaw
extends Packet {
    public int _a;
    public byte _b;
    public byte _c;
    public short _d;

    public cwaw() {
    }

    public cwaw(int n, PotionEffect potionEffect) {
        this._a = n;
        this._b = (byte)(potionEffect._a() & 0xFF);
        this._c = (byte)(potionEffect._c() & 0xFF);
        this._d = potionEffect._b() > Short.MAX_VALUE ? (short)Short.MAX_VALUE : (short)potionEffect._b();
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readByte();
        this._c = dataInput.readByte();
        this._d = dataInput.readShort();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._b);
        dataOutput.writeByte(this._c);
        dataOutput.writeShort(this._d);
    }

    public boolean _a() {
        return this._d == Short.MAX_VALUE;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleEntityEffect(this);
    }

    @Override
    public int getPacketSize() {
        return 8;
    }

    @Override
    public boolean isRealPacket() {
        return true;
    }

    @Override
    public boolean containsSameEntityIDAs(Packet packet) {
        cwaw cwaw2 = (cwaw)packet;
        return cwaw2._a == this._a && cwaw2._b == this._b;
    }
}

