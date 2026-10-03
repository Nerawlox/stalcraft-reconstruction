/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class mqvh
extends zwat {
    private int _a;
    private int _b;
    private int _c;
    private int _d;
    private float _e;
    private float _f;
    private float _g;

    public mqvh(int n, int n2, int n3, int n4, float f, float f2, float f3) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
        this._e = f;
        this._f = f2;
        this._g = f3;
    }

    public mqvh() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readFloat();
        this._f = dataInput.readFloat();
        this._g = dataInput.readFloat();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeFloat(this._e);
        dataOutput.writeFloat(this._f);
        dataOutput.writeFloat(this._g);
    }
}

