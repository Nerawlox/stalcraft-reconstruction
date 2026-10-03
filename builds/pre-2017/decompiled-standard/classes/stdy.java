/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class stdy
extends zwat {
    public int _a;
    public int _b;
    public int _c;
    public dxwc.pidb _d;

    public stdy(int n, int n2, int n3, dxwc.pidb pidb2) {
        this._a = n;
        this._c = n3;
        this._b = n2;
        this._d = pidb2;
    }

    public stdy() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dxwc.pidb.values()[dataInput.readInt()];
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d.ordinal());
    }
}

