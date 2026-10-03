/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class kjyw
extends zwat {
    public String _a;
    public String _b;
    public int _c;
    public int _d;
    public int _e;
    public int _f;
    public int _g;
    public int _h;
    public int _i;
    public int _j;
    public int _k;

    @Override
    public void processClient(boolean bl) {
        yuch._a._a(this._a, this._b, this._c, this._d, this._e, this._f, this._g, this._h, this._i, this._j, this._k);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = dataInput.readUTF();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readInt();
        this._f = dataInput.readInt();
        this._g = dataInput.readInt();
        this._h = dataInput.readInt();
        this._i = dataInput.readInt();
        this._j = dataInput.readInt();
        this._k = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeUTF(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeInt(this._e);
        dataOutput.writeInt(this._f);
        dataOutput.writeInt(this._g);
        dataOutput.writeInt(this._h);
        dataOutput.writeInt(this._i);
        dataOutput.writeInt(this._j);
        dataOutput.writeInt(this._k);
    }
}

