/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.potion.PotionEffect;

public class zibp
extends Packet {
    public int _a;
    public byte _b;

    public zibp() {
    }

    public zibp(int n, PotionEffect potionEffect) {
        this._a = n;
        this._b = (byte)(potionEffect._a() & 0xFF);
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readByte();
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._b);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleRemoveEntityEffect(this);
    }

    @Override
    public int getPacketSize() {
        return 5;
    }
}

