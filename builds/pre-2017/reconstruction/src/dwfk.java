/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class dwfk
extends zwat {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;
    public int _f;
    public int _g;

    @ezey(_a={eidj.CLIENT})
    public dwfk(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
        this._e = n5;
        this._f = n6;
        this._g = n7;
    }

    public dwfk() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readInt();
        this._f = dataInput.readInt();
        this._g = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeInt(this._e);
        dataOutput.writeInt(this._f);
        dataOutput.writeInt(this._g);
    }
}

