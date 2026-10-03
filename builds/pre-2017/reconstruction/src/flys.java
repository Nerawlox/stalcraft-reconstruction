/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class flys
extends qlgf {
    public boolean _a;
    public boolean _b;
    public boolean _c;
    public boolean _d;
    public boolean _e;
    public boolean _f;
    public boolean _g;
    public boolean _h;
    public boolean _i;
    public float _j;
    public float _k;
    public boolean _l;

    public flys() {
    }

    public flys(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, float f, float f2, boolean bl9, boolean bl10) {
        this._a = bl;
        this._b = bl2;
        this._c = bl3;
        this._d = bl4;
        this._e = bl5;
        this._f = bl6;
        this._g = bl7;
        this._h = bl8;
        this._j = f;
        this._k = f2;
        this._l = bl9;
        this._i = bl10;
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readBoolean();
        this._b = dataInput.readBoolean();
        this._c = dataInput.readBoolean();
        this._d = dataInput.readBoolean();
        this._e = dataInput.readBoolean();
        this._f = dataInput.readBoolean();
        this._g = dataInput.readBoolean();
        this._h = dataInput.readBoolean();
        this._i = dataInput.readBoolean();
        this._j = dataInput.readFloat();
        this._k = dataInput.readFloat();
        this._l = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeBoolean(this._a);
        dataOutput.writeBoolean(this._b);
        dataOutput.writeBoolean(this._c);
        dataOutput.writeBoolean(this._d);
        dataOutput.writeBoolean(this._e);
        dataOutput.writeBoolean(this._f);
        dataOutput.writeBoolean(this._g);
        dataOutput.writeBoolean(this._h);
        dataOutput.writeBoolean(this._i);
        dataOutput.writeFloat(this._j);
        dataOutput.writeFloat(this._k);
        dataOutput.writeBoolean(this._l);
    }
}

