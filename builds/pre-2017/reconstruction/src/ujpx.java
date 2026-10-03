/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.security.PublicKey;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.qlgf;

public class ujpx
extends Packet {
    public String _a;
    public PublicKey _b;
    public byte[] _c = new byte[0];

    public ujpx() {
    }

    public ujpx(String string, PublicKey publicKey, byte[] byArray) {
        this._a = string;
        this._b = publicKey;
        this._c = byArray;
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = ujpx.readString(dataInput, 20);
        this._b = qlgf._a(ujpx.readBytesFromStream(dataInput));
        this._c = ujpx.readBytesFromStream(dataInput);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        ujpx.writeString(this._a, dataOutput);
        ujpx.writeByteArray(dataOutput, this._b.getEncoded());
        ujpx.writeByteArray(dataOutput, this._c);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleServerAuthData(this);
    }

    @Override
    public int getPacketSize() {
        return 2 + this._a.length() * 2 + 2 + this._b.getEncoded().length + 2 + this._c.length;
    }

    public String _a() {
        return this._a;
    }

    public PublicKey _b() {
        return this._b;
    }

    public byte[] _c() {
        return this._c;
    }
}

