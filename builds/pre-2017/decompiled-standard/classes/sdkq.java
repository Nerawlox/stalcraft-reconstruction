/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class sdkq
extends cezg {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;

    public sdkq() {
    }

    public sdkq(int n, int n2, int n3, int n4, int n5) {
        this._e = n;
        this._a = n2;
        this._b = n3;
        this._c = n4;
        this._d = n5;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._e = dataInput.readUnsignedByte();
        this._a = dataInput.readInt();
        this._b = dataInput.readUnsignedByte();
        this._c = dataInput.readInt();
        this._d = dataInput.readUnsignedByte();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.write(this._e);
        dataOutput.writeInt(this._a);
        dataOutput.write(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.write(this._d);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72510_a(this);
    }

    @Override
    public int func_73284_a() {
        return 11;
    }
}

