/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.tupg;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class dwed
extends zwat {
    String _a;
    tupg _b;

    public dwed(String string, tupg tupg2) {
        this._a = string;
        this._b = tupg2;
    }

    public dwed() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = tupg.values()[dataInput.readInt()];
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeInt(this._b.ordinal());
    }
}

