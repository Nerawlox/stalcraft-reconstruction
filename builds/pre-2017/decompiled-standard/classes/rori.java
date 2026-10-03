/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class rori
extends zwat {
    private String _a;
    private bqdo _b;

    public rori(String string, bqdo bqdo2) {
        this._a = string;
        this._b = bqdo2;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        this._b.write(dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = new bqdo();
        this._b.read(dataInput);
    }

    public rori() {
    }
}

