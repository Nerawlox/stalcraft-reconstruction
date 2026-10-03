/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.security.PublicKey;
import net.minecraft.util.qlgf;

public class ujpx
extends cezg {
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
    public void func_73267_a(DataInput dataInput) {
        this._a = ujpx.func_73282_a(dataInput, 20);
        this._b = qlgf._a(ujpx.func_73280_b(dataInput));
        this._c = ujpx.func_73280_b(dataInput);
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        ujpx.func_73271_a(this._a, dataOutput);
        ujpx.func_73274_a(dataOutput, this._b.getEncoded());
        ujpx.func_73274_a(dataOutput, this._c);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72470_a(this);
    }

    @Override
    public int func_73284_a() {
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

