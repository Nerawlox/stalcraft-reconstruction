/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class grll
extends cezg {
    public String _a;
    public float _b;
    public float _c;
    public float _d;
    public float _e;
    public float _f;
    public float _g;
    public float _h;
    public int _i;

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = grll.func_73282_a(dataInput, 64);
        this._b = dataInput.readFloat();
        this._c = dataInput.readFloat();
        this._d = dataInput.readFloat();
        this._e = dataInput.readFloat();
        this._f = dataInput.readFloat();
        this._g = dataInput.readFloat();
        this._h = dataInput.readFloat();
        this._i = dataInput.readInt();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        grll.func_73271_a(this._a, dataOutput);
        dataOutput.writeFloat(this._b);
        dataOutput.writeFloat(this._c);
        dataOutput.writeFloat(this._d);
        dataOutput.writeFloat(this._e);
        dataOutput.writeFloat(this._f);
        dataOutput.writeFloat(this._g);
        dataOutput.writeFloat(this._h);
        dataOutput.writeInt(this._i);
    }

    public String _a() {
        return this._a;
    }

    public double _b() {
        return this._b;
    }

    public double _c() {
        return this._c;
    }

    public double _d() {
        return this._d;
    }

    public float _e() {
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

    public int _i() {
        return this._i;
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_98182_a(this);
    }

    @Override
    public int func_73284_a() {
        return 64;
    }
}

