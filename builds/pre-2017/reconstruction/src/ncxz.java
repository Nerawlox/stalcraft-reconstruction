/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ncxz
extends ytyx {
    private byte _a;

    public ncxz() {
    }

    public ncxz(byte by) {
        this._a = by;
    }

    public ncxz(int n) {
        this((byte)n);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readByte();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this._a);
    }
}

