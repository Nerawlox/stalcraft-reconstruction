/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class kmrj
extends cezg {
    public int _a;
    public int _b;
    public int _c;
    public short _d;
    public cvzo _e;
    public int _f;

    public kmrj() {
    }

    public kmrj(int n, int n2, int n3, int n4, cvzo cvzo2, short s) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._e = cvzo2 != null ? cvzo2._l() : null;
        this._d = s;
        this._f = n4;
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72523_a(this);
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readByte();
        this._b = dataInput.readShort();
        this._c = dataInput.readByte();
        this._d = dataInput.readShort();
        this._f = dataInput.readByte();
        this._e = kmrj.func_73276_c(dataInput);
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
        dataOutput.writeShort(this._b);
        dataOutput.writeByte(this._c);
        dataOutput.writeShort(this._d);
        dataOutput.writeByte(this._f);
        kmrj.func_73270_a(this._e, dataOutput);
    }

    @Override
    public int func_73284_a() {
        return 11;
    }
}

