/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class elyz
extends zwat {
    private int _a;
    private int _b;
    private int _c;
    private int _d;

    public elyz(cvzo cvzo2, int n) {
        if (cvzo2 != null) {
            this._a = cvzo2._d;
            this._b = cvzo2._f;
            this._c = cvzo2._b;
            this._d = n;
        }
    }

    public elyz() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
    }
}

