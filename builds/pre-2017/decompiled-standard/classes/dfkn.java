/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class dfkn
extends qlgf {
    public double _a;
    public double _b;
    public double _c;
    public double _d;
    public double _e;
    public double _f;

    public dfkn() {
    }

    public dfkn(dfkn dfkn2) {
        this._a = dfkn2._a;
        this._b = dfkn2._b;
        this._c = dfkn2._c;
        this._d = dfkn2._d;
        this._e = dfkn2._e;
        this._f = dfkn2._f;
    }

    public dfkn(double d, double d2, double d3, double d4, double d5, double d6) {
        this._a = d;
        this._b = d2;
        this._c = d3;
        this._d = d4;
        this._e = d5;
        this._f = d6;
    }

    public dfkn(double[] dArray) {
        if (dArray.length != 6) {
            throw new IllegalArgumentException("Cuboid must consist of 6 coordinates!");
        }
        this._a = dArray[0];
        this._b = dArray[1];
        this._c = dArray[2];
        this._d = dArray[3];
        this._e = dArray[4];
        this._f = dArray[5];
    }

    public dfkn(bsyv bsyv2) {
        this._a = ((qoae)bsyv2._b((int)0))._c;
        this._b = ((qoae)bsyv2._b((int)1))._c;
        this._c = ((qoae)bsyv2._b((int)2))._c;
        this._d = ((qoae)bsyv2._b((int)3))._c;
        this._e = ((qoae)bsyv2._b((int)4))._c;
        this._f = ((qoae)bsyv2._b((int)5))._c;
    }

    public dfkn(einh einh2, einh einh3) {
        this(Math.min(einh2._c, einh3._c), Math.min(einh2._d, einh3._d), Math.min(einh2._e, einh3._e), Math.max(einh2._c, einh3._c), Math.max(einh2._d, einh3._d), Math.max(einh2._e, einh3._e));
    }

    public dfkn _a(double d, double d2, double d3) {
        return new dfkn(this._a - d, this._b - d2, this._c - d3, this._d + d, this._e + d2, this._f + d3);
    }

    public bsyv _a() {
        bsyv bsyv2 = new bsyv();
        bsyv2._a(new qoae(null, this._a));
        bsyv2._a(new qoae(null, this._b));
        bsyv2._a(new qoae(null, this._c));
        bsyv2._a(new qoae(null, this._d));
        bsyv2._a(new qoae(null, this._e));
        bsyv2._a(new qoae(null, this._f));
        return bsyv2;
    }

    public boolean _a(dfkn dfkn2) {
        return !(dfkn2._d < this._a || dfkn2._e < this._b || dfkn2._f < this._c || dfkn2._a > this._d || dfkn2._b > this._e || dfkn2._c > this._f);
    }

    public boolean _a(einh einh2) {
        return this._b(einh2._c, einh2._d, einh2._e);
    }

    public boolean _b(double d, double d2, double d3) {
        return d >= this._a && d <= this._d && d2 >= this._b && d2 <= this._e && d3 >= this._c && d3 <= this._f;
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readDouble();
        this._b = dataInput.readDouble();
        this._c = dataInput.readDouble();
        this._d = dataInput.readDouble();
        this._e = dataInput.readDouble();
        this._f = dataInput.readDouble();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeDouble(this._a);
        dataOutput.writeDouble(this._b);
        dataOutput.writeDouble(this._c);
        dataOutput.writeDouble(this._d);
        dataOutput.writeDouble(this._e);
        dataOutput.writeDouble(this._f);
    }
}

