/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ccpx
extends zwat {
    public flys _a;
    public boolean _b;
    public float _c;
    public boolean _d;
    public int _e;
    public float _f;
    public float _g;

    public ccpx(flys flys2, boolean bl, float f, int n, boolean bl2, float f2, float f3) {
        this._a = flys2;
        this._b = bl;
        this._c = f;
        this._e = n;
        this._d = bl2;
        this._f = f2;
        this._g = f3;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        this._a.write(dataOutput);
        dataOutput.writeBoolean(this._b);
        dataOutput.writeFloat(this._c);
        dataOutput.writeInt(this._e);
        dataOutput.writeBoolean(this._d);
        dataOutput.writeFloat(this._f);
        dataOutput.writeFloat(this._g);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = new flys();
        this._a.read(dataInput);
        this._b = dataInput.readBoolean();
        this._c = dataInput.readFloat();
        this._e = dataInput.readInt();
        this._d = dataInput.readBoolean();
        this._f = dataInput.readFloat();
        this._g = dataInput.readFloat();
    }

    public ccpx() {
    }
}

