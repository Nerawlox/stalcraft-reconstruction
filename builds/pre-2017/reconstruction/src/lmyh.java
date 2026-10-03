/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class lmyh
extends zwat {
    private String _a;
    private String _b;
    private String _c;
    private String _d;

    public lmyh(String string, String string2, String string3, String string4) {
        this._a = string;
        this._b = string2;
        this._c = string3;
        this._d = string4;
    }

    public lmyh() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = dataInput.readUTF();
        this._c = dataInput.readUTF();
        this._d = dataInput.readUTF();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeUTF(this._b);
        dataOutput.writeUTF(this._c);
        dataOutput.writeUTF(this._d);
    }
}

