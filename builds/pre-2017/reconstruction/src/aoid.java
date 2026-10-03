/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class aoid
extends ytyx {
    private long _a;

    public aoid(long l) {
        this._a = l;
    }

    public aoid() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readLong();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this._a);
    }
}

