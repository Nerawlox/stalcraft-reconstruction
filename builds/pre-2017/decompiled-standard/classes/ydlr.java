/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.trade.qlgf;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ydlr
extends ytyx {
    private qlgf _a;

    public ydlr(qlgf qlgf2) {
        this._a = qlgf2;
    }

    public ydlr() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = qlgf.values()[dataInput.readInt()];
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.ordinal());
    }
}

