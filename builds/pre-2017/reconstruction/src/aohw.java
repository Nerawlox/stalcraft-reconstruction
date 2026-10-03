/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class aohw
extends zwat {
    private String _a;
    private int _b;
    private int _c;

    public aohw(String string, int n, int n2) {
        this._a = string;
        this._b = n;
        this._c = n2;
    }

    public aohw() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
    }
}

