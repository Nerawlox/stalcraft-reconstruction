/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class zwcc
extends zwat {
    private String _a;
    private long _b;
    private boolean _c;

    public zwcc(String string, long l, boolean bl) {
        this._a = string;
        this._b = l;
        this._c = bl;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeLong(this._b);
        dataOutput.writeBoolean(this._c);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = dataInput.readLong();
        this._c = dataInput.readBoolean();
    }

    public zwcc() {
    }
}

