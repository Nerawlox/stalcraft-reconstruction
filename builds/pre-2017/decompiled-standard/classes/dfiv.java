/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class dfiv
extends zwat {
    public long _a;
    public int _b;

    private dfiv(long l, int n) {
        this._a = l;
        this._b = (int)TimeUnit.HOURS.toSeconds(3L);
    }

    public static dfiv _b() {
        return new dfiv(System.currentTimeMillis(), rotc._a._b());
    }

    @Override
    public void processClient(boolean bl) {
        long l = this._a - System.currentTimeMillis();
        rotc rotc2 = new rotc(l, this._b);
        if (bl) {
            qlxw._b = rotc2;
        } else {
            qlxw._c = rotc2;
        }
    }

    public dfiv() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readLong();
        this._b = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this._a);
        dataOutput.writeInt(this._b);
    }
}

