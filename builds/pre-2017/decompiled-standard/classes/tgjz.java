/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class tgjz
extends yvzj {
    public tgjz() {
        this._h = true;
    }

    public tgjz(double d, double d2, double d3, double d4, boolean bl) {
        this._a = d;
        this._b = d2;
        this._d = d3;
        this._c = d4;
        this._g = bl;
        this._h = true;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readDouble();
        this._b = dataInput.readDouble();
        this._d = dataInput.readDouble();
        this._c = dataInput.readDouble();
        super.func_73267_a(dataInput);
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeDouble(this._a);
        dataOutput.writeDouble(this._b);
        dataOutput.writeDouble(this._d);
        dataOutput.writeDouble(this._c);
        super.func_73273_a(dataOutput);
    }

    @Override
    public int func_73284_a() {
        return 33;
    }
}

