/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.SecretKey;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.qlgf;

public class Packet252SharedKey
extends Packet {
    public byte[] _a = new byte[0];
    public byte[] _b = new byte[0];
    public SecretKey _c;

    public Packet252SharedKey() {
    }

    public Packet252SharedKey(SecretKey secretKey, PublicKey publicKey, byte[] byArray) {
        this._c = secretKey;
        this._a = qlgf._a(publicKey, secretKey.getEncoded());
        this._b = qlgf._a(publicKey, byArray);
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        this._a = Packet252SharedKey.readBytesFromStream(dataInput);
        this._b = Packet252SharedKey.readBytesFromStream(dataInput);
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        Packet252SharedKey.writeByteArray(dataOutput, this._a);
        Packet252SharedKey.writeByteArray(dataOutput, this._b);
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleSharedKey(this);
    }

    @Override
    public int getPacketSize() {
        return 2 + this._a.length + 2 + this._b.length;
    }

    public SecretKey _a(PrivateKey privateKey) {
        if (privateKey == null) {
            return this._c;
        }
        this._c = qlgf._a(privateKey, this._a);
        return this._c;
    }

    public SecretKey _a() {
        return this._a(null);
    }

    public byte[] _b(PrivateKey privateKey) {
        if (privateKey == null) {
            return this._b;
        }
        return qlgf._b(privateKey, this._b);
    }
}

