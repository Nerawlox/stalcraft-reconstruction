/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.clans.ClansMod;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class dxpi
extends zwat {
    public String _a;
    public int _b;
    public int _c;

    public dxpi(String string, int n, int n2) {
        this._a = string;
        this._b = n;
        this._c = n2;
    }

    @Override
    public void processClient(boolean bl) {
        ClansMod.instance._D._a(this._a, this._c, this._b);
    }

    public dxpi() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
    }
}

