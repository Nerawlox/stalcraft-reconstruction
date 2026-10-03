/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class ixmv
extends cezg {
    public int _a;
    public int _b;
    public cvzo _c;

    public ixmv() {
    }

    public ixmv(int n, int n2, cvzo cvzo2) {
        this._a = n;
        this._b = n2;
        this._c = cvzo2 == null ? cvzo2 : cvzo2._l();
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72490_a(this);
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readByte();
        this._b = dataInput.readShort();
        this._c = ixmv.func_73276_c(dataInput);
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
        dataOutput.writeShort(this._b);
        ixmv.func_73270_a(this._c, dataOutput);
    }

    @Override
    public int func_73284_a() {
        return 8;
    }
}

