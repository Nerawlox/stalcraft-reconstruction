/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.SecretKey;
import net.minecraft.util.qlgf;

public class hulv
extends cezg {
    public byte[] _a = new byte[0];
    public byte[] _b = new byte[0];
    public SecretKey _c;

    public hulv() {
    }

    public hulv(SecretKey secretKey, PublicKey publicKey, byte[] byArray) {
        this._c = secretKey;
        this._a = qlgf._a(publicKey, secretKey.getEncoded());
        this._b = qlgf._a(publicKey, byArray);
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = hulv.func_73280_b(dataInput);
        this._b = hulv.func_73280_b(dataInput);
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        hulv.func_73274_a(dataOutput, this._a);
        hulv.func_73274_a(dataOutput, this._b);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72513_a(this);
    }

    @Override
    public int func_73284_a() {
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

