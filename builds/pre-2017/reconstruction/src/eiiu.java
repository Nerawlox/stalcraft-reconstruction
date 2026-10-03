/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class eiiu
extends zwat {
    public String _a;
    public String _b;
    public int _c;
    public double _d;
    public double _e;
    public double _f;
    public float _g;
    public float _h;

    public eiiu(String string, iuyn iuyn2) {
        this._a = string;
        this._b = iuyn2._a._a;
        this._c = iuyn2._a._b;
        this._d = iuyn2._a._c;
        this._e = iuyn2._a._d;
        this._f = iuyn2._a._e;
        this._g = iuyn2._c._b;
        this._h = iuyn2._c._c;
    }

    public eiiu() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = dataInput.readUTF();
        this._c = dataInput.readInt();
        this._d = dataInput.readDouble();
        this._e = dataInput.readDouble();
        this._f = dataInput.readDouble();
        this._g = dataInput.readFloat();
        this._h = dataInput.readFloat();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeUTF(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeDouble(this._d);
        dataOutput.writeDouble(this._e);
        dataOutput.writeDouble(this._f);
        dataOutput.writeFloat(this._g);
        dataOutput.writeFloat(this._h);
    }
}

