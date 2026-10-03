/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.clans.ClansMod;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class gont
extends zwat {
    private int _a;

    public gont(int n) {
        this._a = n;
    }

    @Override
    public void processClient(boolean bl) {
        ClansMod.instance._C._c(this._a);
    }

    public gont() {
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

