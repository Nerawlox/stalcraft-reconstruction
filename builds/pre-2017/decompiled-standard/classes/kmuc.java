/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class kmuc
extends cezg {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public cvzo _e;
    public float _f;
    public float _g;
    public float _h;

    public kmuc() {
    }

    public kmuc(int n, int n2, int n3, int n4, cvzo cvzo2, float f, float f2, float f3) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
        this._e = cvzo2 != null ? cvzo2._l() : null;
        this._f = f;
        this._g = f2;
        this._h = f3;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readUnsignedByte();
        this._c = dataInput.readInt();
        this._d = dataInput.readUnsignedByte();
        this._e = kmuc.func_73276_c(dataInput);
        this._f = (float)dataInput.readUnsignedByte() / 16.0f;
        this._g = (float)dataInput.readUnsignedByte() / 16.0f;
        this._h = (float)dataInput.readUnsignedByte() / 16.0f;
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.write(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.write(this._d);
        kmuc.func_73270_a(this._e, dataOutput);
        dataOutput.write((int)(this._f * 16.0f));
        dataOutput.write((int)(this._g * 16.0f));
        dataOutput.write((int)(this._h * 16.0f));
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72472_a(this);
    }

    @Override
    public int func_73284_a() {
        return 19;
    }

    public int _a() {
        return this._a;
    }

    public int _b() {
        return this._b;
    }

    public int _c() {
        return this._c;
    }

    public int _d() {
        return this._d;
    }

    public cvzo _e() {
        return this._e;
    }

    public float _f() {
        return this._f;
    }

    public float _g() {
        return this._g;
    }

    public float _h() {
        return this._h;
    }
}

