/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class lpza
extends cezg {
    public String _a;
    public int _b;
    public int _c = Integer.MAX_VALUE;
    public int _d;
    public float _e;
    public int _f;

    public lpza() {
    }

    public lpza(String string, double d, double d2, double d3, float f, float f2) {
        this._a = string;
        this._b = (int)(d * 8.0);
        this._c = (int)(d2 * 8.0);
        this._d = (int)(d3 * 8.0);
        this._e = f;
        this._f = (int)(f2 * 63.0f);
        if (this._f < 0) {
            this._f = 0;
        }
        if (this._f > 255) {
            this._f = 255;
        }
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = lpza.func_73282_a(dataInput, 256);
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readFloat();
        this._f = dataInput.readUnsignedByte();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        lpza.func_73271_a(this._a, dataOutput);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeFloat(this._e);
        dataOutput.writeByte(this._f);
    }

    public String _a() {
        return this._a;
    }

    public double _b() {
        return (float)this._b / 8.0f;
    }

    public double _c() {
        return (float)this._c / 8.0f;
    }

    public double _d() {
        return (float)this._d / 8.0f;
    }

    public float _e() {
        return this._e;
    }

    public float _f() {
        return (float)this._f / 63.0f;
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72457_a(this);
    }

    @Override
    public int func_73284_a() {
        return 24;
    }
}

