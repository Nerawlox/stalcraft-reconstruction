/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class numa
extends ytyx {
    public byte _a;
    public boolean _b;

    public numa(byte by, boolean bl) {
        this._a = by;
        this._b = bl;
    }

    public numa() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readByte();
        this._b = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this._a);
        dataOutput.writeBoolean(this._b);
    }
}

