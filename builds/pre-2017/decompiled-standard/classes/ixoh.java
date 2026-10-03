/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class ixoh
extends vmsk {
    public ixoh() {
        this._g = true;
    }

    public ixoh(int n, byte by, byte by2) {
        super(n);
        this._e = by;
        this._f = by2;
        this._g = true;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        super.func_73267_a(dataInput);
        this._e = dataInput.readByte();
        this._f = dataInput.readByte();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        super.func_73273_a(dataOutput);
        dataOutput.writeByte(this._e);
        dataOutput.writeByte(this._f);
    }

    @Override
    public int func_73284_a() {
        return 6;
    }
}

