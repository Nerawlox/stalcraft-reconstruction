/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class eikj
extends zwat {
    private String _a;
    private boolean _b;

    public eikj() {
    }

    public eikj(String string, boolean bl) {
        this._a = string;
        this._b = bl;
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

