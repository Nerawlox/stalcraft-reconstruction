/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class jibv
extends ytyx {
    public boolean _a;

    public jibv(boolean bl) {
        this._a = bl;
    }

    public jibv() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeBoolean(this._a);
    }
}

