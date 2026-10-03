/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ncdr
extends zwat {
    private String _a;
    private boolean _b;

    public ncdr(String string, boolean bl) {
        this._b = true;
        this._a = string;
        this._b = bl;
    }

    public ncdr() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeBoolean(this._b);
    }
}

