/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class xsyc
extends vmsk {
    public xsyc() {
        this._g = true;
    }

    public xsyc(int n, byte by, byte by2, byte by3, byte by4, byte by5) {
        super(n);
        this._b = by;
        this._c = by2;
        this._d = by3;
        this._e = by4;
        this._f = by5;
        this._g = true;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        super.func_73267_a(dataInput);
        this._b = dataInput.readByte();
        this._c = dataInput.readByte();
        this._d = dataInput.readByte();
        this._e = dataInput.readByte();
        this._f = dataInput.readByte();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        super.func_73273_a(dataOutput);
        dataOutput.writeByte(this._b);
        dataOutput.writeByte(this._c);
        dataOutput.writeByte(this._d);
        dataOutput.writeByte(this._e);
        dataOutput.writeByte(this._f);
    }

    @Override
    public int func_73284_a() {
        return 9;
    }
}

