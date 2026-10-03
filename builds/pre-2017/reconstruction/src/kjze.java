/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.tupg;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class kjze
extends zwat {
    public String _a;
    public int _b;
    public tupg _c;
    public boolean _d;

    public kjze(String string, int n, tupg tupg2, boolean bl) {
        this._a = string;
        this._b = n;
        this._c = tupg2;
        this._d = bl;
    }

    public kjze() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = dataInput.readInt();
        this._c = tupg.values()[dataInput.readInt()];
        this._d = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c.ordinal());
        dataOutput.writeBoolean(this._d);
    }
}

