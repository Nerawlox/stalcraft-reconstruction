/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.anticheat.pidb;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class owtl
extends zwat {
    public int _a;

    public owtl(int n) {
        this._a = n;
    }

    @Override
    public void processClient(boolean bl) {
        pidb._a = this._a;
    }

    public owtl() {
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

