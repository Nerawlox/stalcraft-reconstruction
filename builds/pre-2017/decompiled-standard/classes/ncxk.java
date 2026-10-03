/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ncxk
extends ntyw {
    public int _f;

    public ncxk(qoac qoac2, int n, int n2, int n3, int n4) {
        this._a = qoac2;
        this._b = n;
        this._c = n2;
        this._d = n3;
        this._f = n4;
    }

    public ncxk() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._f = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeInt(this._f);
    }
}

