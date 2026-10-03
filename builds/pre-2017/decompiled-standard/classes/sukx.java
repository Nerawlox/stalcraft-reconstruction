/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class sukx
extends vmsk {
    public sukx() {
    }

    public sukx(int n, byte by, byte by2, byte by3) {
        super(n);
        this._b = by;
        this._c = by2;
        this._d = by3;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        super.func_73267_a(dataInput);
        this._b = dataInput.readByte();
        this._c = dataInput.readByte();
        this._d = dataInput.readByte();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        super.func_73273_a(dataOutput);
        dataOutput.writeByte(this._b);
        dataOutput.writeByte(this._c);
        dataOutput.writeByte(this._d);
    }

    @Override
    public int func_73284_a() {
        return 7;
    }
}

