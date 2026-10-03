/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class xcpd
extends zwat {
    public static final int _a = 0;
    public static final int _b = 1;
    public static final int _c = 2;
    private String _d;
    private int _e;
    private int _f;

    public xcpd(int n, int n2, String string) {
        this._f = n;
        this._d = string;
        this._e = n2;
    }

    public xcpd() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._d = dataInput.readUTF();
        this._e = dataInput.readInt();
        this._f = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._d);
        dataOutput.writeInt(this._e);
        dataOutput.writeInt(this._f);
    }
}

