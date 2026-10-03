/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ycab
extends zwat {
    public String _a;

    public ycab(String string) {
        this._a = string;
    }

    @Override
    public void processClient(boolean bl) {
        yuch._a._a(this._a);
    }

    public ycab() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
    }
}

