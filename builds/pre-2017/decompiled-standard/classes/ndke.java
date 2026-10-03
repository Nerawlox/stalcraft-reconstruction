/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.clans.ClansMod;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ndke
extends zwat {
    public String _a;
    public int _b;

    public ndke(String string, int n) {
        this._a = string;
        this._b = n;
    }

    @Override
    public void processClient(boolean bl) {
        ClansMod.instance._D._a(this._a, this._b);
    }

    public ndke() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeInt(this._b);
    }
}

