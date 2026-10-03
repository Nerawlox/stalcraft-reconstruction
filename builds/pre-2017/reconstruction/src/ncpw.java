/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ncpw
extends zwat {
    private long _a;
    private int _b;
    private long _c;

    public ncpw(long l, int n) {
        this._a = l;
        this._b = n;
    }

    @Override
    public boolean canProcessWhenDead() {
        return true;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this._a);
        dataOutput.writeInt(this._b);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readLong();
        this._b = dataInput.readInt();
        this._c = System.currentTimeMillis();
    }

    public ncpw() {
    }
}

