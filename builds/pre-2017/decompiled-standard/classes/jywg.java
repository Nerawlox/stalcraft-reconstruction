/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.money.MoneyMod;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class jywg
extends zwat {
    public int _a;

    public jywg(int n) {
        this._a = n;
    }

    @Override
    public void processClient(boolean bl) {
        MoneyMod._m._c(this._a);
    }

    public jywg() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
    }
}

