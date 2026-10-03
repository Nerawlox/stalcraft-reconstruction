/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class klfx
extends vlfg {
    public oxot _e;
    public oxot _f;
    public double _g;
    public double _h;
    public int[] _i;

    public klfx() {
    }

    public klfx(double d, double d2, int[] nArray, rpzz rpzz2, int n, oxot oxot2, oxot oxot3) {
        super(ndni._a, rpzz2, n);
        this._g = d;
        this._h = d2;
        this._i = nArray;
        this._e = oxot2;
        this._f = oxot3;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeDouble(this._g);
        dataOutput.writeDouble(this._h);
        dataOutput.writeInt(this._i.length);
        for (int i = 0; i < this._i.length; ++i) {
            dataOutput.writeInt(this._i[i]);
        }
        this._a(this._e, dataOutput);
        if (this._f != null) {
            dataOutput.writeBoolean(true);
            this._a(this._f, dataOutput);
        } else {
            dataOutput.writeBoolean(false);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._g = dataInput.readDouble();
        this._h = dataInput.readDouble();
        this._i = new int[dataInput.readInt()];
        for (int i = 0; i < this._i.length; ++i) {
            this._i[i] = dataInput.readInt();
        }
        this._e = this._a(dataInput);
        if (dataInput.readBoolean()) {
            this._f = this._a(dataInput);
        }
    }
}

