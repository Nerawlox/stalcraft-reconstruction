/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class bsye
extends cezg {
    public int _a;
    public cvzo _b;

    public bsye() {
    }

    public bsye(int n, cvzo cvzo2) {
        this._a = n;
        this._b = cvzo2 != null ? cvzo2._l() : null;
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72464_a(this);
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readShort();
        this._b = bsye.func_73276_c(dataInput);
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeShort(this._a);
        bsye.func_73270_a(this._b, dataOutput);
    }

    @Override
    public int func_73284_a() {
        return 8;
    }
}

