/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class qohl
extends cezg {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;
    public boolean _f;

    public qohl() {
    }

    public qohl(int n, int n2, int n3, int n4, int n5, boolean bl) {
        this._a = n;
        this._c = n2;
        this._d = n3;
        this._e = n4;
        this._b = n5;
        this._f = bl;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readByte() & 0xFF;
        this._e = dataInput.readInt();
        this._b = dataInput.readInt();
        this._f = dataInput.readBoolean();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._c);
        dataOutput.writeByte(this._d & 0xFF);
        dataOutput.writeInt(this._e);
        dataOutput.writeInt(this._b);
        dataOutput.writeBoolean(this._f);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72462_a(this);
    }

    @Override
    public int func_73284_a() {
        return 21;
    }

    public boolean _a() {
        return this._f;
    }
}

