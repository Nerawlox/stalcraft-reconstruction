/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class wpwt
extends cezg {
    public int _a;
    public int _b;
    public int _c;
    public int _d;

    public wpwt() {
    }

    public wpwt(int n, int n2, int n3, int n4) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_142031_a(this);
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readByte();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
    }

    @Override
    public int func_73284_a() {
        return 13;
    }
}

